package org.yaml.snakeyaml.emitter;

import O6.l;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.JsonFactory;
import io.ktor.sse.ServerSentEventKt;
import io.ktor.util.date.GMTDateParser;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.comments.CommentEventsCollector;
import org.yaml.snakeyaml.comments.CommentLine;
import org.yaml.snakeyaml.comments.CommentType;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.events.AliasEvent;
import org.yaml.snakeyaml.events.CollectionEndEvent;
import org.yaml.snakeyaml.events.CollectionStartEvent;
import org.yaml.snakeyaml.events.CommentEvent;
import org.yaml.snakeyaml.events.DocumentEndEvent;
import org.yaml.snakeyaml.events.DocumentStartEvent;
import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.events.MappingEndEvent;
import org.yaml.snakeyaml.events.MappingStartEvent;
import org.yaml.snakeyaml.events.NodeEvent;
import org.yaml.snakeyaml.events.ScalarEvent;
import org.yaml.snakeyaml.events.SequenceEndEvent;
import org.yaml.snakeyaml.events.SequenceStartEvent;
import org.yaml.snakeyaml.events.StreamEndEvent;
import org.yaml.snakeyaml.events.StreamStartEvent;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.reader.StreamReader;
import org.yaml.snakeyaml.scanner.Constant;
import org.yaml.snakeyaml.util.ArrayStack;

/* loaded from: classes5.dex */
public final class Emitter implements Emitable {
    private static final Map<String, String> DEFAULT_TAG_PREFIXES;
    private static final Map<Character, String> ESCAPE_REPLACEMENTS;
    private static final Pattern HANDLE_FORMAT;
    private static final Set<Character> INVALID_ANCHOR;
    public static final int MAX_INDENT = 10;
    public static final int MIN_INDENT = 1;
    private static final char[] SPACE = {' '};
    private static final Pattern SPACES_PATTERN = Pattern.compile("\\s");
    private final boolean allowUnicode;
    private ScalarAnalysis analysis;
    private int bestIndent;
    private final char[] bestLineBreak;
    private int bestWidth;
    private final CommentEventsCollector blockCommentsCollector;
    private final Boolean canonical;
    private int column;
    private final boolean emitComments;
    private Event event;
    private final Queue<Event> events;
    private int flowLevel;
    private Integer indent;
    private final boolean indentWithIndicator;
    private boolean indention;
    private final ArrayStack<Integer> indents;
    private final int indicatorIndent;
    private final CommentEventsCollector inlineCommentsCollector;
    private boolean mappingContext;
    private final int maxSimpleKeyLength;
    private boolean openEnded;
    private String preparedAnchor;
    private String preparedTag;
    private final Boolean prettyFlow;
    private boolean rootContext;
    private boolean simpleKeyContext;
    private final boolean splitLines;
    private EmitterState state;
    private final ArrayStack<EmitterState> states;
    private final Writer stream;
    private DumperOptions.ScalarStyle style;
    private Map<String, String> tagPrefixes;
    private boolean whitespace;

    /* renamed from: org.yaml.snakeyaml.emitter.Emitter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$yaml$snakeyaml$DumperOptions$ScalarStyle;

        static {
            int[] iArr = new int[DumperOptions.ScalarStyle.values().length];
            $SwitchMap$org$yaml$snakeyaml$DumperOptions$ScalarStyle = iArr;
            try {
                iArr[DumperOptions.ScalarStyle.PLAIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$yaml$snakeyaml$DumperOptions$ScalarStyle[DumperOptions.ScalarStyle.DOUBLE_QUOTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$yaml$snakeyaml$DumperOptions$ScalarStyle[DumperOptions.ScalarStyle.SINGLE_QUOTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$yaml$snakeyaml$DumperOptions$ScalarStyle[DumperOptions.ScalarStyle.FOLDED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$yaml$snakeyaml$DumperOptions$ScalarStyle[DumperOptions.ScalarStyle.LITERAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public class ExpectBlockMappingKey implements EmitterState {
        private final boolean first;

        public ExpectBlockMappingKey(boolean z10) {
            this.first = z10;
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            Emitter emitter = Emitter.this;
            emitter.event = emitter.blockCommentsCollector.collectEventsAndPoll(Emitter.this.event);
            Emitter.this.writeBlockComment();
            if (!this.first && (Emitter.this.event instanceof MappingEndEvent)) {
                Emitter emitter2 = Emitter.this;
                emitter2.indent = (Integer) emitter2.indents.pop();
                Emitter emitter3 = Emitter.this;
                emitter3.state = (EmitterState) emitter3.states.pop();
                return;
            }
            Emitter.this.writeIndent();
            AnonymousClass1 anonymousClass1 = null;
            if (Emitter.this.checkSimpleKey()) {
                Emitter.this.states.push(new ExpectBlockMappingSimpleValue(Emitter.this, anonymousClass1));
                Emitter.this.expectNode(false, true, true);
            } else {
                Emitter.this.writeIndicator("?", true, false, true);
                Emitter.this.states.push(new ExpectBlockMappingValue(Emitter.this, anonymousClass1));
                Emitter.this.expectNode(false, true, false);
            }
        }
    }

    public class ExpectBlockMappingSimpleValue implements EmitterState {
        private ExpectBlockMappingSimpleValue() {
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            Emitter.this.writeIndicator(ServerSentEventKt.COLON, false, false, false);
            Emitter emitter = Emitter.this;
            emitter.event = emitter.inlineCommentsCollector.collectEventsAndPoll(Emitter.this.event);
            Emitter emitter2 = Emitter.this;
            if (!emitter2.isFoldedOrLiteral(emitter2.event) && Emitter.this.writeInlineComments()) {
                Emitter.this.increaseIndent(true, false);
                Emitter.this.writeIndent();
                Emitter emitter3 = Emitter.this;
                emitter3.indent = (Integer) emitter3.indents.pop();
            }
            Emitter emitter4 = Emitter.this;
            emitter4.event = emitter4.blockCommentsCollector.collectEventsAndPoll(Emitter.this.event);
            if (!Emitter.this.blockCommentsCollector.isEmpty()) {
                Emitter.this.increaseIndent(true, false);
                Emitter.this.writeBlockComment();
                Emitter.this.writeIndent();
                Emitter emitter5 = Emitter.this;
                emitter5.indent = (Integer) emitter5.indents.pop();
            }
            Emitter.this.states.push(Emitter.this.new ExpectBlockMappingKey(false));
            Emitter.this.expectNode(false, true, false);
            Emitter.this.inlineCommentsCollector.collectEvents();
            Emitter.this.writeInlineComments();
        }

        public /* synthetic */ ExpectBlockMappingSimpleValue(Emitter emitter, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public class ExpectBlockMappingValue implements EmitterState {
        private ExpectBlockMappingValue() {
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            Emitter.this.writeIndent();
            Emitter.this.writeIndicator(ServerSentEventKt.COLON, true, false, true);
            Emitter emitter = Emitter.this;
            emitter.event = emitter.inlineCommentsCollector.collectEventsAndPoll(Emitter.this.event);
            Emitter.this.writeInlineComments();
            Emitter emitter2 = Emitter.this;
            emitter2.event = emitter2.blockCommentsCollector.collectEventsAndPoll(Emitter.this.event);
            Emitter.this.writeBlockComment();
            Emitter.this.states.push(Emitter.this.new ExpectBlockMappingKey(false));
            Emitter.this.expectNode(false, true, false);
            Emitter.this.inlineCommentsCollector.collectEvents(Emitter.this.event);
            Emitter.this.writeInlineComments();
        }

        public /* synthetic */ ExpectBlockMappingValue(Emitter emitter, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public class ExpectBlockSequenceItem implements EmitterState {
        private final boolean first;

        public ExpectBlockSequenceItem(boolean z10) {
            this.first = z10;
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            if (!this.first && (Emitter.this.event instanceof SequenceEndEvent)) {
                Emitter emitter = Emitter.this;
                emitter.indent = (Integer) emitter.indents.pop();
                Emitter emitter2 = Emitter.this;
                emitter2.state = (EmitterState) emitter2.states.pop();
                return;
            }
            if (Emitter.this.event instanceof CommentEvent) {
                Emitter.this.blockCommentsCollector.collectEvents(Emitter.this.event);
                return;
            }
            Emitter.this.writeIndent();
            if (!Emitter.this.indentWithIndicator || this.first) {
                Emitter emitter3 = Emitter.this;
                emitter3.writeWhitespace(emitter3.indicatorIndent);
            }
            Emitter.this.writeIndicator(l.DATE_SEPARATOR, true, false, true);
            if (Emitter.this.indentWithIndicator && this.first) {
                Emitter emitter4 = Emitter.this;
                emitter4.indent = Integer.valueOf(emitter4.indent.intValue() + Emitter.this.indicatorIndent);
            }
            if (!Emitter.this.blockCommentsCollector.isEmpty()) {
                Emitter.this.increaseIndent(false, false);
                Emitter.this.writeBlockComment();
                if (Emitter.this.event instanceof ScalarEvent) {
                    Emitter emitter5 = Emitter.this;
                    emitter5.analysis = emitter5.analyzeScalar(((ScalarEvent) emitter5.event).getValue());
                    if (!Emitter.this.analysis.isEmpty()) {
                        Emitter.this.writeIndent();
                    }
                }
                Emitter emitter6 = Emitter.this;
                emitter6.indent = (Integer) emitter6.indents.pop();
            }
            Emitter.this.states.push(Emitter.this.new ExpectBlockSequenceItem(false));
            Emitter.this.expectNode(false, false, false);
            Emitter.this.inlineCommentsCollector.collectEvents();
            Emitter.this.writeInlineComments();
        }
    }

    public class ExpectDocumentEnd implements EmitterState {
        private ExpectDocumentEnd() {
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            Emitter emitter = Emitter.this;
            emitter.event = emitter.blockCommentsCollector.collectEventsAndPoll(Emitter.this.event);
            Emitter.this.writeBlockComment();
            if (!(Emitter.this.event instanceof DocumentEndEvent)) {
                throw new EmitterException("expected DocumentEndEvent, but got " + Emitter.this.event);
            }
            Emitter.this.writeIndent();
            if (((DocumentEndEvent) Emitter.this.event).getExplicit()) {
                Emitter.this.writeIndicator("...", true, false, false);
                Emitter.this.writeIndent();
            }
            Emitter.this.flushStream();
            Emitter emitter2 = Emitter.this;
            emitter2.state = emitter2.new ExpectDocumentStart(false);
        }

        public /* synthetic */ ExpectDocumentEnd(Emitter emitter, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public class ExpectDocumentRoot implements EmitterState {
        private ExpectDocumentRoot() {
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            Emitter emitter = Emitter.this;
            emitter.event = emitter.blockCommentsCollector.collectEventsAndPoll(Emitter.this.event);
            AnonymousClass1 anonymousClass1 = null;
            if (!Emitter.this.blockCommentsCollector.isEmpty()) {
                Emitter.this.writeBlockComment();
                if (Emitter.this.event instanceof DocumentEndEvent) {
                    new ExpectDocumentEnd(Emitter.this, anonymousClass1).expect();
                    return;
                }
            }
            Emitter.this.states.push(new ExpectDocumentEnd(Emitter.this, anonymousClass1));
            Emitter.this.expectNode(true, false, false);
        }

        public /* synthetic */ ExpectDocumentRoot(Emitter emitter, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public class ExpectDocumentStart implements EmitterState {
        private final boolean first;

        public ExpectDocumentStart(boolean z10) {
            this.first = z10;
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            AnonymousClass1 anonymousClass1 = null;
            if (!(Emitter.this.event instanceof DocumentStartEvent)) {
                if (Emitter.this.event instanceof StreamEndEvent) {
                    Emitter.this.writeStreamEnd();
                    Emitter emitter = Emitter.this;
                    emitter.state = new ExpectNothing(emitter, anonymousClass1);
                    return;
                } else {
                    if (!(Emitter.this.event instanceof CommentEvent)) {
                        throw new EmitterException("expected DocumentStartEvent, but got " + Emitter.this.event);
                    }
                    Emitter.this.blockCommentsCollector.collectEvents(Emitter.this.event);
                    Emitter.this.writeBlockComment();
                    return;
                }
            }
            DocumentStartEvent documentStartEvent = (DocumentStartEvent) Emitter.this.event;
            if ((documentStartEvent.getVersion() != null || documentStartEvent.getTags() != null) && Emitter.this.openEnded) {
                Emitter.this.writeIndicator("...", true, false, false);
                Emitter.this.writeIndent();
            }
            if (documentStartEvent.getVersion() != null) {
                Emitter.this.writeVersionDirective(Emitter.this.prepareVersion(documentStartEvent.getVersion()));
            }
            Emitter.this.tagPrefixes = new LinkedHashMap(Emitter.DEFAULT_TAG_PREFIXES);
            if (documentStartEvent.getTags() != null) {
                for (String str : new TreeSet(documentStartEvent.getTags().keySet())) {
                    String str2 = documentStartEvent.getTags().get(str);
                    Emitter.this.tagPrefixes.put(str2, str);
                    Emitter.this.writeTagDirective(Emitter.this.prepareTagHandle(str), Emitter.this.prepareTagPrefix(str2));
                }
            }
            if (!this.first || documentStartEvent.getExplicit() || Emitter.this.canonical.booleanValue() || documentStartEvent.getVersion() != null || ((documentStartEvent.getTags() != null && !documentStartEvent.getTags().isEmpty()) || Emitter.this.checkEmptyDocument())) {
                Emitter.this.writeIndent();
                Emitter.this.writeIndicator("---", true, false, false);
                if (Emitter.this.canonical.booleanValue()) {
                    Emitter.this.writeIndent();
                }
            }
            Emitter emitter2 = Emitter.this;
            emitter2.state = new ExpectDocumentRoot(emitter2, anonymousClass1);
        }
    }

    public class ExpectFirstBlockMappingKey implements EmitterState {
        private ExpectFirstBlockMappingKey() {
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            Emitter.this.new ExpectBlockMappingKey(true).expect();
        }

        public /* synthetic */ ExpectFirstBlockMappingKey(Emitter emitter, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public class ExpectFirstBlockSequenceItem implements EmitterState {
        private ExpectFirstBlockSequenceItem() {
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            Emitter.this.new ExpectBlockSequenceItem(true).expect();
        }

        public /* synthetic */ ExpectFirstBlockSequenceItem(Emitter emitter, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public class ExpectFirstDocumentStart implements EmitterState {
        private ExpectFirstDocumentStart() {
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            Emitter.this.new ExpectDocumentStart(true).expect();
        }

        public /* synthetic */ ExpectFirstDocumentStart(Emitter emitter, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public class ExpectFirstFlowMappingKey implements EmitterState {
        private ExpectFirstFlowMappingKey() {
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            Emitter emitter = Emitter.this;
            emitter.event = emitter.blockCommentsCollector.collectEventsAndPoll(Emitter.this.event);
            Emitter.this.writeBlockComment();
            if (Emitter.this.event instanceof MappingEndEvent) {
                Emitter emitter2 = Emitter.this;
                emitter2.indent = (Integer) emitter2.indents.pop();
                Emitter.access$2210(Emitter.this);
                Emitter.this.writeIndicator("}", false, false, false);
                Emitter.this.inlineCommentsCollector.collectEvents();
                Emitter.this.writeInlineComments();
                Emitter emitter3 = Emitter.this;
                emitter3.state = (EmitterState) emitter3.states.pop();
                return;
            }
            if (Emitter.this.canonical.booleanValue() || ((Emitter.this.column > Emitter.this.bestWidth && Emitter.this.splitLines) || Emitter.this.prettyFlow.booleanValue())) {
                Emitter.this.writeIndent();
            }
            AnonymousClass1 anonymousClass1 = null;
            if (!Emitter.this.canonical.booleanValue() && Emitter.this.checkSimpleKey()) {
                Emitter.this.states.push(new ExpectFlowMappingSimpleValue(Emitter.this, anonymousClass1));
                Emitter.this.expectNode(false, true, true);
            } else {
                Emitter.this.writeIndicator("?", true, false, false);
                Emitter.this.states.push(new ExpectFlowMappingValue(Emitter.this, anonymousClass1));
                Emitter.this.expectNode(false, true, false);
            }
        }

        public /* synthetic */ ExpectFirstFlowMappingKey(Emitter emitter, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public class ExpectFirstFlowSequenceItem implements EmitterState {
        private ExpectFirstFlowSequenceItem() {
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            if (Emitter.this.event instanceof SequenceEndEvent) {
                Emitter emitter = Emitter.this;
                emitter.indent = (Integer) emitter.indents.pop();
                Emitter.access$2210(Emitter.this);
                Emitter.this.writeIndicator("]", false, false, false);
                Emitter.this.inlineCommentsCollector.collectEvents();
                Emitter.this.writeInlineComments();
                Emitter emitter2 = Emitter.this;
                emitter2.state = (EmitterState) emitter2.states.pop();
                return;
            }
            if (Emitter.this.event instanceof CommentEvent) {
                Emitter.this.blockCommentsCollector.collectEvents(Emitter.this.event);
                Emitter.this.writeBlockComment();
                return;
            }
            if (Emitter.this.canonical.booleanValue() || ((Emitter.this.column > Emitter.this.bestWidth && Emitter.this.splitLines) || Emitter.this.prettyFlow.booleanValue())) {
                Emitter.this.writeIndent();
            }
            Emitter.this.states.push(new ExpectFlowSequenceItem(Emitter.this, null));
            Emitter.this.expectNode(false, false, false);
            Emitter emitter3 = Emitter.this;
            emitter3.event = emitter3.inlineCommentsCollector.collectEvents(Emitter.this.event);
            Emitter.this.writeInlineComments();
        }

        public /* synthetic */ ExpectFirstFlowSequenceItem(Emitter emitter, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public class ExpectFlowMappingKey implements EmitterState {
        private ExpectFlowMappingKey() {
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            if (Emitter.this.event instanceof MappingEndEvent) {
                Emitter emitter = Emitter.this;
                emitter.indent = (Integer) emitter.indents.pop();
                Emitter.access$2210(Emitter.this);
                if (Emitter.this.canonical.booleanValue()) {
                    Emitter.this.writeIndicator(Const.STR_MART_COMMA, false, false, false);
                    Emitter.this.writeIndent();
                }
                if (Emitter.this.prettyFlow.booleanValue()) {
                    Emitter.this.writeIndent();
                }
                Emitter.this.writeIndicator("}", false, false, false);
                Emitter.this.inlineCommentsCollector.collectEvents();
                Emitter.this.writeInlineComments();
                Emitter emitter2 = Emitter.this;
                emitter2.state = (EmitterState) emitter2.states.pop();
                return;
            }
            Emitter.this.writeIndicator(Const.STR_MART_COMMA, false, false, false);
            Emitter emitter3 = Emitter.this;
            emitter3.event = emitter3.blockCommentsCollector.collectEventsAndPoll(Emitter.this.event);
            Emitter.this.writeBlockComment();
            if (Emitter.this.canonical.booleanValue() || ((Emitter.this.column > Emitter.this.bestWidth && Emitter.this.splitLines) || Emitter.this.prettyFlow.booleanValue())) {
                Emitter.this.writeIndent();
            }
            AnonymousClass1 anonymousClass1 = null;
            if (!Emitter.this.canonical.booleanValue() && Emitter.this.checkSimpleKey()) {
                Emitter.this.states.push(new ExpectFlowMappingSimpleValue(Emitter.this, anonymousClass1));
                Emitter.this.expectNode(false, true, true);
            } else {
                Emitter.this.writeIndicator("?", true, false, false);
                Emitter.this.states.push(new ExpectFlowMappingValue(Emitter.this, anonymousClass1));
                Emitter.this.expectNode(false, true, false);
            }
        }

        public /* synthetic */ ExpectFlowMappingKey(Emitter emitter, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public class ExpectFlowMappingSimpleValue implements EmitterState {
        private ExpectFlowMappingSimpleValue() {
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            Emitter.this.writeIndicator(ServerSentEventKt.COLON, false, false, false);
            Emitter emitter = Emitter.this;
            emitter.event = emitter.inlineCommentsCollector.collectEventsAndPoll(Emitter.this.event);
            Emitter.this.writeInlineComments();
            Emitter.this.states.push(new ExpectFlowMappingKey(Emitter.this, null));
            Emitter.this.expectNode(false, true, false);
            Emitter.this.inlineCommentsCollector.collectEvents(Emitter.this.event);
            Emitter.this.writeInlineComments();
        }

        public /* synthetic */ ExpectFlowMappingSimpleValue(Emitter emitter, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public class ExpectFlowMappingValue implements EmitterState {
        private ExpectFlowMappingValue() {
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            if (Emitter.this.canonical.booleanValue() || Emitter.this.column > Emitter.this.bestWidth || Emitter.this.prettyFlow.booleanValue()) {
                Emitter.this.writeIndent();
            }
            Emitter.this.writeIndicator(ServerSentEventKt.COLON, true, false, false);
            Emitter emitter = Emitter.this;
            emitter.event = emitter.inlineCommentsCollector.collectEventsAndPoll(Emitter.this.event);
            Emitter.this.writeInlineComments();
            Emitter.this.states.push(new ExpectFlowMappingKey(Emitter.this, null));
            Emitter.this.expectNode(false, true, false);
            Emitter.this.inlineCommentsCollector.collectEvents(Emitter.this.event);
            Emitter.this.writeInlineComments();
        }

        public /* synthetic */ ExpectFlowMappingValue(Emitter emitter, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public class ExpectFlowSequenceItem implements EmitterState {
        private ExpectFlowSequenceItem() {
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            if (Emitter.this.event instanceof SequenceEndEvent) {
                Emitter emitter = Emitter.this;
                emitter.indent = (Integer) emitter.indents.pop();
                Emitter.access$2210(Emitter.this);
                if (Emitter.this.canonical.booleanValue()) {
                    Emitter.this.writeIndicator(Const.STR_MART_COMMA, false, false, false);
                    Emitter.this.writeIndent();
                } else if (Emitter.this.prettyFlow.booleanValue()) {
                    Emitter.this.writeIndent();
                }
                Emitter.this.writeIndicator("]", false, false, false);
                Emitter.this.inlineCommentsCollector.collectEvents();
                Emitter.this.writeInlineComments();
                if (Emitter.this.prettyFlow.booleanValue()) {
                    Emitter.this.writeIndent();
                }
                Emitter emitter2 = Emitter.this;
                emitter2.state = (EmitterState) emitter2.states.pop();
                return;
            }
            if (Emitter.this.event instanceof CommentEvent) {
                Emitter emitter3 = Emitter.this;
                emitter3.event = emitter3.blockCommentsCollector.collectEvents(Emitter.this.event);
                return;
            }
            Emitter.this.writeIndicator(Const.STR_MART_COMMA, false, false, false);
            Emitter.this.writeBlockComment();
            if (Emitter.this.canonical.booleanValue() || ((Emitter.this.column > Emitter.this.bestWidth && Emitter.this.splitLines) || Emitter.this.prettyFlow.booleanValue())) {
                Emitter.this.writeIndent();
            }
            Emitter.this.states.push(Emitter.this.new ExpectFlowSequenceItem());
            Emitter.this.expectNode(false, false, false);
            Emitter emitter4 = Emitter.this;
            emitter4.event = emitter4.inlineCommentsCollector.collectEvents(Emitter.this.event);
            Emitter.this.writeInlineComments();
        }

        public /* synthetic */ ExpectFlowSequenceItem(Emitter emitter, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public class ExpectNothing implements EmitterState {
        private ExpectNothing() {
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            throw new EmitterException("expecting nothing, but got " + Emitter.this.event);
        }

        public /* synthetic */ ExpectNothing(Emitter emitter, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public class ExpectStreamStart implements EmitterState {
        private ExpectStreamStart() {
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            if (Emitter.this.event instanceof StreamStartEvent) {
                Emitter.this.writeStreamStart();
                Emitter emitter = Emitter.this;
                emitter.state = new ExpectFirstDocumentStart(emitter, null);
            } else {
                throw new EmitterException("expected StreamStartEvent, but got " + Emitter.this.event);
            }
        }

        public /* synthetic */ ExpectStreamStart(Emitter emitter, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    static {
        HashSet hashSet = new HashSet();
        INVALID_ANCHOR = hashSet;
        hashSet.add('[');
        hashSet.add(']');
        hashSet.add('{');
        hashSet.add('}');
        hashSet.add(',');
        hashSet.add(Character.valueOf(GMTDateParser.ANY));
        hashSet.add('&');
        HashMap map = new HashMap();
        ESCAPE_REPLACEMENTS = map;
        map.put((char) 0, "0");
        map.put((char) 7, Const.INTENT_KEY_APIKEY);
        map.put('\b', Const.INTENT_KEY_PKGNAME);
        map.put('\t', "t");
        map.put('\n', "n");
        map.put((char) 11, "v");
        map.put('\f', "f");
        map.put('\r', "r");
        map.put((char) 27, "e");
        map.put(Character.valueOf(JsonFactory.DEFAULT_QUOTE_CHAR), "\"");
        map.put('\\', "\\");
        map.put((char) 133, "N");
        map.put((char) 160, "_");
        map.put((char) 8232, "L");
        map.put((char) 8233, "P");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        DEFAULT_TAG_PREFIXES = linkedHashMap;
        linkedHashMap.put("!", "!");
        linkedHashMap.put(Tag.PREFIX, "!!");
        HANDLE_FORMAT = Pattern.compile("^![-_\\w]*!$");
    }

    public Emitter(Writer writer, DumperOptions dumperOptions) {
        if (writer == null) {
            throw new NullPointerException("Writer must be provided.");
        }
        if (dumperOptions == null) {
            throw new NullPointerException("DumperOptions must be provided.");
        }
        this.stream = writer;
        this.states = new ArrayStack<>(100);
        this.state = new ExpectStreamStart(this, null);
        ArrayDeque arrayDeque = new ArrayDeque(100);
        this.events = arrayDeque;
        this.event = null;
        this.indents = new ArrayStack<>(10);
        this.indent = null;
        this.flowLevel = 0;
        this.mappingContext = false;
        this.simpleKeyContext = false;
        this.column = 0;
        this.whitespace = true;
        this.indention = true;
        this.openEnded = false;
        this.canonical = Boolean.valueOf(dumperOptions.isCanonical());
        this.prettyFlow = Boolean.valueOf(dumperOptions.isPrettyFlow());
        this.allowUnicode = dumperOptions.isAllowUnicode();
        this.bestIndent = 2;
        if (dumperOptions.getIndent() > 1 && dumperOptions.getIndent() < 10) {
            this.bestIndent = dumperOptions.getIndent();
        }
        this.indicatorIndent = dumperOptions.getIndicatorIndent();
        this.indentWithIndicator = dumperOptions.getIndentWithIndicator();
        this.bestWidth = 80;
        if (dumperOptions.getWidth() > this.bestIndent * 2) {
            this.bestWidth = dumperOptions.getWidth();
        }
        this.bestLineBreak = dumperOptions.getLineBreak().getString().toCharArray();
        this.splitLines = dumperOptions.getSplitLines();
        this.maxSimpleKeyLength = dumperOptions.getMaxSimpleKeyLength();
        this.emitComments = dumperOptions.isProcessComments();
        this.tagPrefixes = new LinkedHashMap();
        this.preparedAnchor = null;
        this.preparedTag = null;
        this.analysis = null;
        this.style = null;
        this.blockCommentsCollector = new CommentEventsCollector(arrayDeque, CommentType.BLANK_LINE, CommentType.BLOCK);
        this.inlineCommentsCollector = new CommentEventsCollector(arrayDeque, CommentType.IN_LINE);
    }

    public static /* synthetic */ int access$2210(Emitter emitter) {
        int i10 = emitter.flowLevel;
        emitter.flowLevel = i10 - 1;
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ab A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.yaml.snakeyaml.emitter.ScalarAnalysis analyzeScalar(java.lang.String r24) {
        /*
            Method dump skipped, instructions count: 444
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.yaml.snakeyaml.emitter.Emitter.analyzeScalar(java.lang.String):org.yaml.snakeyaml.emitter.ScalarAnalysis");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkEmptyDocument() {
        if ((this.event instanceof DocumentStartEvent) && !this.events.isEmpty()) {
            Event eventPeek = this.events.peek();
            if (eventPeek instanceof ScalarEvent) {
                ScalarEvent scalarEvent = (ScalarEvent) eventPeek;
                if (scalarEvent.getAnchor() == null && scalarEvent.getTag() == null && scalarEvent.getImplicit() != null && scalarEvent.getValue().isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkEmptyMapping() {
        return (this.event instanceof MappingStartEvent) && !this.events.isEmpty() && (this.events.peek() instanceof MappingEndEvent);
    }

    private boolean checkEmptySequence() {
        return (this.event instanceof SequenceStartEvent) && !this.events.isEmpty() && (this.events.peek() instanceof SequenceEndEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkSimpleKey() {
        int length;
        Event event = this.event;
        if (!(event instanceof NodeEvent) || ((NodeEvent) event).getAnchor() == null) {
            length = 0;
        } else {
            if (this.preparedAnchor == null) {
                this.preparedAnchor = prepareAnchor(((NodeEvent) this.event).getAnchor());
            }
            length = this.preparedAnchor.length();
        }
        Event event2 = this.event;
        String tag = event2 instanceof ScalarEvent ? ((ScalarEvent) event2).getTag() : event2 instanceof CollectionStartEvent ? ((CollectionStartEvent) event2).getTag() : null;
        if (tag != null) {
            if (this.preparedTag == null) {
                this.preparedTag = prepareTag(tag);
            }
            length += this.preparedTag.length();
        }
        Event event3 = this.event;
        if (event3 instanceof ScalarEvent) {
            if (this.analysis == null) {
                this.analysis = analyzeScalar(((ScalarEvent) event3).getValue());
            }
            length += this.analysis.getScalar().length();
        }
        if (length < this.maxSimpleKeyLength) {
            Event event4 = this.event;
            if (event4 instanceof AliasEvent) {
                return true;
            }
            if (((event4 instanceof ScalarEvent) && !this.analysis.isEmpty() && !this.analysis.isMultiline()) || checkEmptySequence() || checkEmptyMapping()) {
                return true;
            }
        }
        return false;
    }

    private DumperOptions.ScalarStyle chooseScalarStyle() {
        ScalarEvent scalarEvent = (ScalarEvent) this.event;
        if (this.analysis == null) {
            this.analysis = analyzeScalar(scalarEvent.getValue());
        }
        return ((scalarEvent.isPlain() || !scalarEvent.isDQuoted()) && !this.canonical.booleanValue()) ? (scalarEvent.isJson() && Tag.STR.getValue().equals(scalarEvent.getTag())) ? DumperOptions.ScalarStyle.DOUBLE_QUOTED : ((scalarEvent.isPlain() || scalarEvent.isJson()) && scalarEvent.getImplicit().canOmitTagInPlainScalar() && !(this.simpleKeyContext && (this.analysis.isEmpty() || this.analysis.isMultiline())) && ((this.flowLevel != 0 && this.analysis.isAllowFlowPlain()) || (this.flowLevel == 0 && this.analysis.isAllowBlockPlain()))) ? DumperOptions.ScalarStyle.PLAIN : ((scalarEvent.isLiteral() || scalarEvent.isFolded()) && this.flowLevel == 0 && !this.simpleKeyContext && this.analysis.isAllowBlock()) ? scalarEvent.getScalarStyle() : ((scalarEvent.isPlain() || scalarEvent.isSQuoted()) && this.analysis.isAllowSingleQuoted() && !(this.simpleKeyContext && this.analysis.isMultiline())) ? DumperOptions.ScalarStyle.SINGLE_QUOTED : DumperOptions.ScalarStyle.DOUBLE_QUOTED : DumperOptions.ScalarStyle.DOUBLE_QUOTED;
    }

    private String determineBlockHints(String str) {
        StringBuilder sb2 = new StringBuilder();
        Constant constant = Constant.LINEBR;
        if (constant.has(str.charAt(0), " ")) {
            sb2.append(this.bestIndent);
        }
        if (constant.hasNo(str.charAt(str.length() - 1))) {
            sb2.append(l.DATE_SEPARATOR);
        } else if (str.length() == 1 || constant.has(str.charAt(str.length() - 2))) {
            sb2.append("+");
        }
        return sb2.toString();
    }

    private void expectAlias() throws IOException {
        if (!(this.event instanceof AliasEvent)) {
            throw new EmitterException("Alias must be provided");
        }
        processAnchor("*");
        this.state = this.states.pop();
    }

    private void expectBlockMapping() throws IOException {
        increaseIndent(false, false);
        this.state = new ExpectFirstBlockMappingKey(this, null);
    }

    private void expectBlockSequence() throws IOException {
        increaseIndent(false, this.mappingContext && !this.indention);
        this.state = new ExpectFirstBlockSequenceItem(this, null);
    }

    private void expectFlowMapping() throws IOException {
        writeIndicator(Const.STR_MART_JSON_BEGIN, true, true, false);
        this.flowLevel++;
        increaseIndent(true, false);
        if (this.prettyFlow.booleanValue()) {
            writeIndent();
        }
        this.state = new ExpectFirstFlowMappingKey(this, null);
    }

    private void expectFlowSequence() throws IOException {
        writeIndicator("[", true, true, false);
        this.flowLevel++;
        increaseIndent(true, false);
        if (this.prettyFlow.booleanValue()) {
            writeIndent();
        }
        this.state = new ExpectFirstFlowSequenceItem(this, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void expectNode(boolean z10, boolean z11, boolean z12) throws IOException {
        this.rootContext = z10;
        this.mappingContext = z11;
        this.simpleKeyContext = z12;
        Event event = this.event;
        if (event instanceof AliasEvent) {
            expectAlias();
            return;
        }
        if (!(event instanceof ScalarEvent) && !(event instanceof CollectionStartEvent)) {
            throw new EmitterException("expected NodeEvent, but got " + this.event);
        }
        processAnchor(Const.STR_MART_ADD);
        processTag();
        Event event2 = this.event;
        if (event2 instanceof ScalarEvent) {
            expectScalar();
            return;
        }
        if (event2 instanceof SequenceStartEvent) {
            if (this.flowLevel != 0 || this.canonical.booleanValue() || ((SequenceStartEvent) this.event).isFlow() || checkEmptySequence()) {
                expectFlowSequence();
                return;
            } else {
                expectBlockSequence();
                return;
            }
        }
        if (this.flowLevel != 0 || this.canonical.booleanValue() || ((MappingStartEvent) this.event).isFlow() || checkEmptyMapping()) {
            expectFlowMapping();
        } else {
            expectBlockMapping();
        }
    }

    private void expectScalar() throws IOException {
        increaseIndent(true, false);
        processScalar();
        this.indent = this.indents.pop();
        this.state = this.states.pop();
    }

    private static boolean hasLeadingZero(String str) {
        if (str.length() <= 1 || str.charAt(0) != '0') {
            return false;
        }
        for (int i10 = 1; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if ((cCharAt < '0' || cCharAt > '9') && cCharAt != '_') {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void increaseIndent(boolean z10, boolean z11) {
        this.indents.push(this.indent);
        Integer num = this.indent;
        if (num != null) {
            if (z11) {
                return;
            }
            this.indent = Integer.valueOf(num.intValue() + this.bestIndent);
        } else if (z10) {
            this.indent = Integer.valueOf(this.bestIndent);
        } else {
            this.indent = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFoldedOrLiteral(Event event) {
        if (!event.is(Event.ID.Scalar)) {
            return false;
        }
        DumperOptions.ScalarStyle scalarStyle = ((ScalarEvent) event).getScalarStyle();
        return scalarStyle == DumperOptions.ScalarStyle.FOLDED || scalarStyle == DumperOptions.ScalarStyle.LITERAL;
    }

    private boolean needEvents(Iterator<Event> it, int i10) {
        int i11 = 0;
        int i12 = 0;
        while (it.hasNext()) {
            Event next = it.next();
            if (!(next instanceof CommentEvent)) {
                i11++;
                if ((next instanceof DocumentStartEvent) || (next instanceof CollectionStartEvent)) {
                    i12++;
                } else if ((next instanceof DocumentEndEvent) || (next instanceof CollectionEndEvent)) {
                    i12--;
                } else if (next instanceof StreamEndEvent) {
                    i12 = -1;
                }
                if (i12 < 0) {
                    return false;
                }
            }
        }
        return i11 < i10;
    }

    private boolean needMoreEvents() {
        if (this.events.isEmpty()) {
            return true;
        }
        Iterator<Event> it = this.events.iterator();
        Event next = it.next();
        while (true) {
            Event event = next;
            if (!(event instanceof CommentEvent)) {
                if (event instanceof DocumentStartEvent) {
                    return needEvents(it, 1);
                }
                if (event instanceof SequenceStartEvent) {
                    return needEvents(it, 2);
                }
                if (event instanceof MappingStartEvent) {
                    return needEvents(it, 3);
                }
                if (event instanceof StreamStartEvent) {
                    return needEvents(it, 2);
                }
                if (!(event instanceof StreamEndEvent) && this.emitComments) {
                    return needEvents(it, 1);
                }
                return false;
            }
            if (!it.hasNext()) {
                return true;
            }
            next = it.next();
        }
    }

    public static String prepareAnchor(String str) {
        if (str.isEmpty()) {
            throw new EmitterException("anchor must not be empty");
        }
        for (Character ch : INVALID_ANCHOR) {
            if (str.indexOf(ch.charValue()) > -1) {
                throw new EmitterException("Invalid character '" + ch + "' in the anchor: " + str);
            }
        }
        if (!SPACES_PATTERN.matcher(str).find()) {
            return str;
        }
        throw new EmitterException("Anchor may not contain spaces: " + str);
    }

    private String prepareTag(String str) {
        if (str.isEmpty()) {
            throw new EmitterException("tag must not be empty");
        }
        if ("!".equals(str)) {
            return str;
        }
        String str2 = null;
        for (String str3 : this.tagPrefixes.keySet()) {
            if (str.startsWith(str3) && ("!".equals(str3) || str3.length() < str.length())) {
                str2 = str3;
            }
        }
        if (str2 != null) {
            str = str.substring(str2.length());
            str2 = this.tagPrefixes.get(str2);
        }
        if (str2 != null) {
            return str2 + str;
        }
        return "!<" + str + ">";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String prepareTagHandle(String str) {
        if (str.isEmpty()) {
            throw new EmitterException("tag handle must not be empty");
        }
        if (str.charAt(0) != '!' || str.charAt(str.length() - 1) != '!') {
            throw new EmitterException("tag handle must start and end with '!': " + str);
        }
        if ("!".equals(str) || HANDLE_FORMAT.matcher(str).matches()) {
            return str;
        }
        throw new EmitterException("invalid character in the tag handle: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String prepareTagPrefix(String str) {
        if (str.isEmpty()) {
            throw new EmitterException("tag prefix must not be empty");
        }
        StringBuilder sb2 = new StringBuilder();
        int i10 = str.charAt(0) == '!' ? 1 : 0;
        while (i10 < str.length()) {
            i10++;
        }
        sb2.append((CharSequence) str, 0, i10);
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String prepareVersion(DumperOptions.Version version) {
        if (version.major() == 1) {
            return version.getRepresentation();
        }
        throw new EmitterException("unsupported YAML version: " + version);
    }

    private void processAnchor(String str) throws IOException {
        NodeEvent nodeEvent = (NodeEvent) this.event;
        if (nodeEvent.getAnchor() == null) {
            this.preparedAnchor = null;
            return;
        }
        if (this.preparedAnchor == null) {
            this.preparedAnchor = prepareAnchor(nodeEvent.getAnchor());
        }
        writeIndicator(str + this.preparedAnchor, true, false, false);
        this.preparedAnchor = null;
    }

    private void processScalar() throws IOException {
        ScalarEvent scalarEvent = (ScalarEvent) this.event;
        if (this.analysis == null) {
            this.analysis = analyzeScalar(scalarEvent.getValue());
        }
        boolean z10 = !this.simpleKeyContext && this.splitLines;
        int i10 = AnonymousClass1.$SwitchMap$org$yaml$snakeyaml$DumperOptions$ScalarStyle[this.style.ordinal()];
        if (i10 == 1) {
            writePlain(this.analysis.getScalar(), z10);
        } else if (i10 == 2) {
            writeDoubleQuoted(this.analysis.getScalar(), z10);
        } else if (i10 == 3) {
            writeSingleQuoted(this.analysis.getScalar(), z10);
        } else if (i10 == 4) {
            writeFolded(this.analysis.getScalar(), z10);
        } else {
            if (i10 != 5) {
                throw new YAMLException("Unexpected style: " + this.style);
            }
            writeLiteral(this.analysis.getScalar());
        }
        this.analysis = null;
        this.style = null;
    }

    private void processTag() throws IOException {
        String tag;
        Event event = this.event;
        if (event instanceof ScalarEvent) {
            ScalarEvent scalarEvent = (ScalarEvent) event;
            tag = scalarEvent.getTag();
            if (this.style == null) {
                this.style = chooseScalarStyle();
            }
            if (!this.canonical.booleanValue() || tag == null) {
                DumperOptions.ScalarStyle scalarStyle = this.style;
                DumperOptions.ScalarStyle scalarStyle2 = DumperOptions.ScalarStyle.PLAIN;
                if ((scalarStyle == scalarStyle2 && scalarEvent.getImplicit().canOmitTagInPlainScalar()) || (this.style != scalarStyle2 && scalarEvent.getImplicit().canOmitTagInNonPlainScalar())) {
                    this.preparedTag = null;
                    return;
                }
            }
            if (scalarEvent.getImplicit().canOmitTagInPlainScalar() && tag == null) {
                this.preparedTag = null;
                tag = "!";
            }
        } else {
            CollectionStartEvent collectionStartEvent = (CollectionStartEvent) event;
            tag = collectionStartEvent.getTag();
            if ((!this.canonical.booleanValue() || tag == null) && collectionStartEvent.getImplicit()) {
                this.preparedTag = null;
                return;
            }
        }
        if (tag == null) {
            throw new EmitterException("tag is not specified");
        }
        if (this.preparedTag == null) {
            this.preparedTag = prepareTag(tag);
        }
        writeIndicator(this.preparedTag, true, false, false);
        this.preparedTag = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeBlockComment() throws IOException {
        if (this.blockCommentsCollector.isEmpty()) {
            return;
        }
        writeIndent();
        writeCommentLines(this.blockCommentsCollector.consume());
    }

    private boolean writeCommentLines(List<CommentLine> list) throws IOException {
        if (!this.emitComments) {
            return false;
        }
        boolean z10 = true;
        boolean z11 = false;
        int i10 = 0;
        for (CommentLine commentLine : list) {
            if (commentLine.getCommentType() != CommentType.BLANK_LINE) {
                if (z10) {
                    writeIndicator(Const.STR_MART_WELL, commentLine.getCommentType() == CommentType.IN_LINE, false, false);
                    int i11 = this.column;
                    i10 = i11 > 0 ? i11 - 1 : 0;
                    z10 = false;
                } else {
                    writeWhitespace(i10);
                    writeIndicator(Const.STR_MART_WELL, false, false, false);
                }
                this.stream.write(commentLine.getValue());
                writeLineBreak(null);
            } else {
                writeLineBreak(null);
                writeIndent();
            }
            z11 = true;
        }
        return z11;
    }

    private void writeDoubleQuoted(String str, boolean z10) throws IOException {
        String str2;
        int i10;
        String str3;
        writeIndicator("\"", true, false, false);
        int i11 = 0;
        int i12 = 0;
        while (i11 <= str.length()) {
            Character chValueOf = i11 < str.length() ? Character.valueOf(str.charAt(i11)) : null;
            if (chValueOf == null || "\"\\\u0085\u2028\u2029\ufeff".indexOf(chValueOf.charValue()) != -1 || ' ' > chValueOf.charValue() || chValueOf.charValue() > '~') {
                if (i12 < i11) {
                    int i13 = i11 - i12;
                    this.column += i13;
                    this.stream.write(str, i12, i13);
                    i12 = i11;
                }
                if (chValueOf != null) {
                    Map<Character, String> map = ESCAPE_REPLACEMENTS;
                    if (map.containsKey(chValueOf)) {
                        str2 = "\\" + map.get(chValueOf);
                    } else {
                        int iCharValue = (!Character.isHighSurrogate(chValueOf.charValue()) || (i10 = i11 + 1) >= str.length()) ? chValueOf.charValue() : Character.toCodePoint(chValueOf.charValue(), str.charAt(i10));
                        if (this.allowUnicode && StreamReader.isPrintable(iCharValue)) {
                            String strValueOf = String.valueOf(Character.toChars(iCharValue));
                            if (Character.charCount(iCharValue) == 2) {
                                i11++;
                            }
                            str2 = strValueOf;
                        } else if (chValueOf.charValue() <= 255) {
                            String str4 = "0" + Integer.toString(chValueOf.charValue(), 16);
                            str2 = "\\x" + str4.substring(str4.length() - 2);
                        } else if (Character.charCount(iCharValue) == 2) {
                            i11++;
                            str2 = "\\U" + ("000" + Long.toHexString(iCharValue)).substring(r4.length() - 8);
                        } else {
                            str2 = "\\u" + ("000" + Integer.toString(chValueOf.charValue(), 16)).substring(r4.length() - 4);
                        }
                    }
                    this.column += str2.length();
                    this.stream.write(str2);
                    i12 = i11 + 1;
                }
            }
            if (i11 > 0 && i11 < str.length() - 1 && ((chValueOf.charValue() == ' ' || i12 >= i11) && this.column + (i11 - i12) > this.bestWidth && z10)) {
                if (i12 >= i11) {
                    str3 = "\\";
                } else {
                    str3 = str.substring(i12, i11) + "\\";
                }
                if (i12 < i11) {
                    i12 = i11;
                }
                this.column += str3.length();
                this.stream.write(str3);
                writeIndent();
                this.whitespace = false;
                this.indention = false;
                if (str.charAt(i12) == ' ') {
                    this.column++;
                    this.stream.write("\\");
                }
            }
            i11++;
        }
        writeIndicator("\"", false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean writeInlineComments() throws IOException {
        return writeCommentLines(this.inlineCommentsCollector.consume());
    }

    private void writeLineBreak(String str) throws IOException {
        this.whitespace = true;
        this.indention = true;
        this.column = 0;
        if (str == null) {
            this.stream.write(this.bestLineBreak);
        } else {
            this.stream.write(str);
        }
    }

    private void writeSingleQuoted(String str, boolean z10) throws IOException {
        writeIndicator("'", true, false, false);
        int i10 = 0;
        boolean z11 = false;
        boolean zHas = false;
        int i11 = 0;
        while (i10 <= str.length()) {
            char cCharAt = i10 < str.length() ? str.charAt(i10) : (char) 0;
            if (z11) {
                if (cCharAt == 0 || cCharAt != ' ') {
                    if (i11 + 1 != i10 || this.column <= this.bestWidth || !z10 || i11 == 0 || i10 == str.length()) {
                        int i12 = i10 - i11;
                        this.column += i12;
                        this.stream.write(str, i11, i12);
                    } else {
                        writeIndent();
                    }
                    i11 = i10;
                }
            } else if (zHas) {
                if (cCharAt == 0 || Constant.LINEBR.hasNo(cCharAt)) {
                    if (str.charAt(i11) == '\n') {
                        writeLineBreak(null);
                    }
                    for (char c10 : str.substring(i11, i10).toCharArray()) {
                        if (c10 == '\n') {
                            writeLineBreak(null);
                        } else {
                            writeLineBreak(String.valueOf(c10));
                        }
                    }
                    writeIndent();
                    i11 = i10;
                }
            } else if (Constant.LINEBR.has(cCharAt, "\u0000 '") && i11 < i10) {
                int i13 = i10 - i11;
                this.column += i13;
                this.stream.write(str, i11, i13);
                i11 = i10;
            }
            if (cCharAt == '\'') {
                this.column += 2;
                this.stream.write("''");
                i11 = i10 + 1;
            }
            if (cCharAt != 0) {
                z11 = cCharAt == ' ';
                zHas = Constant.LINEBR.has(cCharAt);
            }
            i10++;
        }
        writeIndicator("'", false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeWhitespace(int i10) throws IOException {
        if (i10 <= 0) {
            return;
        }
        this.whitespace = true;
        char[] cArr = new char[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            cArr[i11] = ' ';
        }
        this.column += i10;
        this.stream.write(cArr);
    }

    @Override // org.yaml.snakeyaml.emitter.Emitable
    public void emit(Event event) throws IOException {
        this.events.add(event);
        while (!needMoreEvents()) {
            this.event = this.events.poll();
            this.state.expect();
            this.event = null;
        }
    }

    public void flushStream() throws IOException {
        this.stream.flush();
    }

    public void writeFolded(String str, boolean z10) throws IOException {
        String strDetermineBlockHints = determineBlockHints(str);
        writeIndicator(">" + strDetermineBlockHints, true, false, false);
        if (strDetermineBlockHints.length() > 0 && strDetermineBlockHints.charAt(strDetermineBlockHints.length() - 1) == '+') {
            this.openEnded = true;
        }
        if (!writeInlineComments()) {
            writeLineBreak(null);
        }
        boolean zHas = true;
        boolean z11 = true;
        int i10 = 0;
        boolean z12 = false;
        int i11 = 0;
        while (i10 <= str.length()) {
            char cCharAt = i10 < str.length() ? str.charAt(i10) : (char) 0;
            if (zHas) {
                if (cCharAt == 0 || Constant.LINEBR.hasNo(cCharAt)) {
                    if (!z11 && cCharAt != 0 && cCharAt != ' ' && str.charAt(i11) == '\n') {
                        writeLineBreak(null);
                    }
                    z11 = cCharAt == ' ';
                    for (char c10 : str.substring(i11, i10).toCharArray()) {
                        if (c10 == '\n') {
                            writeLineBreak(null);
                        } else {
                            writeLineBreak(String.valueOf(c10));
                        }
                    }
                    if (cCharAt != 0) {
                        writeIndent();
                    }
                    i11 = i10;
                }
            } else if (z12) {
                if (cCharAt != ' ') {
                    if (i11 + 1 == i10 && this.column > this.bestWidth && z10) {
                        writeIndent();
                    } else {
                        int i12 = i10 - i11;
                        this.column += i12;
                        this.stream.write(str, i11, i12);
                    }
                    i11 = i10;
                }
            } else if (Constant.LINEBR.has(cCharAt, "\u0000 ")) {
                int i13 = i10 - i11;
                this.column += i13;
                this.stream.write(str, i11, i13);
                if (cCharAt == 0) {
                    writeLineBreak(null);
                }
                i11 = i10;
            }
            if (cCharAt != 0) {
                zHas = Constant.LINEBR.has(cCharAt);
                z12 = cCharAt == ' ';
            }
            i10++;
        }
    }

    public void writeIndent() throws IOException {
        int i10;
        Integer num = this.indent;
        int iIntValue = num != null ? num.intValue() : 0;
        if (!this.indention || (i10 = this.column) > iIntValue || (i10 == iIntValue && !this.whitespace)) {
            writeLineBreak(null);
        }
        writeWhitespace(iIntValue - this.column);
    }

    public void writeIndicator(String str, boolean z10, boolean z11, boolean z12) throws IOException {
        if (!this.whitespace && z10) {
            this.column++;
            this.stream.write(SPACE);
        }
        this.whitespace = z11;
        this.indention = this.indention && z12;
        this.column += str.length();
        this.openEnded = false;
        this.stream.write(str);
    }

    public void writeLiteral(String str) throws IOException {
        String strDetermineBlockHints = determineBlockHints(str);
        boolean zHas = true;
        writeIndicator("|" + strDetermineBlockHints, true, false, false);
        if (strDetermineBlockHints.length() > 0 && strDetermineBlockHints.charAt(strDetermineBlockHints.length() - 1) == '+') {
            this.openEnded = true;
        }
        if (!writeInlineComments()) {
            writeLineBreak(null);
        }
        int i10 = 0;
        int i11 = 0;
        while (i10 <= str.length()) {
            char cCharAt = i10 < str.length() ? str.charAt(i10) : (char) 0;
            if (zHas) {
                if (cCharAt == 0 || Constant.LINEBR.hasNo(cCharAt)) {
                    for (char c10 : str.substring(i11, i10).toCharArray()) {
                        if (c10 == '\n') {
                            writeLineBreak(null);
                        } else {
                            writeLineBreak(String.valueOf(c10));
                        }
                    }
                    if (cCharAt != 0) {
                        writeIndent();
                    }
                    i11 = i10;
                }
            } else if (cCharAt == 0 || Constant.LINEBR.has(cCharAt)) {
                this.stream.write(str, i11, i10 - i11);
                if (cCharAt == 0) {
                    writeLineBreak(null);
                }
                i11 = i10;
            }
            if (cCharAt != 0) {
                zHas = Constant.LINEBR.has(cCharAt);
            }
            i10++;
        }
    }

    public void writePlain(String str, boolean z10) throws IOException {
        if (this.rootContext) {
            this.openEnded = true;
        }
        if (str.isEmpty()) {
            return;
        }
        if (!this.whitespace) {
            this.column++;
            this.stream.write(SPACE);
        }
        this.whitespace = false;
        this.indention = false;
        int i10 = 0;
        boolean z11 = false;
        boolean zHas = false;
        int i11 = 0;
        while (i10 <= str.length()) {
            char cCharAt = i10 < str.length() ? str.charAt(i10) : (char) 0;
            if (z11) {
                if (cCharAt != ' ') {
                    if (i11 + 1 == i10 && this.column > this.bestWidth && z10) {
                        writeIndent();
                        this.whitespace = false;
                        this.indention = false;
                    } else {
                        int i12 = i10 - i11;
                        this.column += i12;
                        this.stream.write(str, i11, i12);
                    }
                    i11 = i10;
                }
            } else if (zHas) {
                if (Constant.LINEBR.hasNo(cCharAt)) {
                    if (str.charAt(i11) == '\n') {
                        writeLineBreak(null);
                    }
                    for (char c10 : str.substring(i11, i10).toCharArray()) {
                        if (c10 == '\n') {
                            writeLineBreak(null);
                        } else {
                            writeLineBreak(String.valueOf(c10));
                        }
                    }
                    writeIndent();
                    this.whitespace = false;
                    this.indention = false;
                    i11 = i10;
                }
            } else if (Constant.LINEBR.has(cCharAt, "\u0000 ")) {
                int i13 = i10 - i11;
                this.column += i13;
                this.stream.write(str, i11, i13);
                i11 = i10;
            }
            if (cCharAt != 0) {
                z11 = cCharAt == ' ';
                zHas = Constant.LINEBR.has(cCharAt);
            }
            i10++;
        }
    }

    public void writeStreamEnd() throws IOException {
        flushStream();
    }

    public void writeStreamStart() {
    }

    public void writeTagDirective(String str, String str2) throws IOException {
        this.stream.write("%TAG ");
        this.stream.write(str);
        this.stream.write(SPACE);
        this.stream.write(str2);
        writeLineBreak(null);
    }

    public void writeVersionDirective(String str) throws IOException {
        this.stream.write("%YAML ");
        this.stream.write(str);
        writeLineBreak(null);
    }
}
