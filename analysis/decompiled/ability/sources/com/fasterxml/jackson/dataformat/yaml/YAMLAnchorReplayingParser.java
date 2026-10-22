package com.fasterxml.jackson.dataformat.yaml;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.IOContext;
import ea.C1429b;
import ha.AbstractC1546b;
import ha.AbstractC1547c;
import ha.AbstractC1551g;
import ha.C1545a;
import ha.i;
import ha.j;
import ha.k;
import ha.l;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class YAMLAnchorReplayingParser extends YAMLParser {
    public static final int MAX_ANCHORS = 9999;
    public static final int MAX_EVENTS = 9999;
    public static final int MAX_MERGES = 9999;
    public static final int MAX_REFS = 9999;
    private int globalDepth;
    private final ArrayDeque<Integer> mergeStack;
    private final ArrayDeque<AbstractC1551g> refEvents;
    private final Map<String, List<AbstractC1551g>> referencedObjects;
    private final ArrayDeque<AnchorContext> tokenStack;

    public static class AnchorContext {
        public final String anchor;
        public final List<AbstractC1551g> events = new ArrayList();
        public int depth = 1;

        public AnchorContext(String str) {
            this.anchor = str;
        }
    }

    public YAMLAnchorReplayingParser(IOContext iOContext, int i, int i6, C1429b c1429b, ObjectCodec objectCodec, Reader reader) {
        super(iOContext, i, i6, c1429b, objectCodec, reader);
        this.mergeStack = new ArrayDeque<>();
        this.tokenStack = new ArrayDeque<>();
        this.referencedObjects = new HashMap();
        this.refEvents = new ArrayDeque<>();
        this.globalDepth = 0;
    }

    private void finishContext(AnchorContext anchorContext) throws StreamConstraintsException {
        if (this.referencedObjects.size() + 1 > 9999) {
            throw new StreamConstraintsException("too many references in the document");
        }
        this.referencedObjects.put(anchorContext.anchor, anchorContext.events);
        if (this.tokenStack.isEmpty()) {
            return;
        }
        List<AbstractC1551g> list = this.tokenStack.peek().events;
        if (anchorContext.events.size() + list.size() > 9999) {
            throw new StreamConstraintsException("too many events to replay");
        }
        list.addAll(anchorContext.events);
    }

    public AbstractC1551g filterEvent(AbstractC1551g abstractC1551g) {
        if (!(abstractC1551g instanceof i) || this.mergeStack.isEmpty() || this.mergeStack.peek().intValue() <= this.globalDepth) {
            return abstractC1551g;
        }
        this.mergeStack.pop();
        return null;
    }

    @Override // com.fasterxml.jackson.dataformat.yaml.YAMLParser
    public AbstractC1551g getEvent() throws IOException {
        String str;
        while (!this.refEvents.isEmpty()) {
            AbstractC1551g abstractC1551gFilterEvent = filterEvent(trackDepth(this.refEvents.removeFirst()));
            if (abstractC1551gFilterEvent != null) {
                return abstractC1551gFilterEvent;
            }
        }
        AbstractC1551g abstractC1551gFilterEvent2 = null;
        while (abstractC1551gFilterEvent2 == null) {
            AbstractC1551g abstractC1551gTrackDepth = trackDepth(super.getEvent());
            if (abstractC1551gTrackDepth == null) {
                return null;
            }
            abstractC1551gFilterEvent2 = filterEvent(abstractC1551gTrackDepth);
        }
        if (abstractC1551gFilterEvent2 instanceof C1545a) {
            String str2 = ((C1545a) abstractC1551gFilterEvent2).c;
            List<AbstractC1551g> list = this.referencedObjects.get(str2);
            if (list == null) {
                throw new JsonParseException("invalid alias " + str2);
            }
            if (list.size() + this.refEvents.size() > 9999) {
                throw new StreamConstraintsException("too many events to replay");
            }
            this.refEvents.addAll(list);
            return this.refEvents.removeFirst();
        }
        if ((abstractC1551gFilterEvent2 instanceof k) && (str = ((k) abstractC1551gFilterEvent2).c) != null) {
            AnchorContext anchorContext = new AnchorContext(str);
            anchorContext.events.add(abstractC1551gFilterEvent2);
            if (!(abstractC1551gFilterEvent2 instanceof AbstractC1547c)) {
                finishContext(anchorContext);
                return abstractC1551gFilterEvent2;
            }
            if (this.tokenStack.size() + 1 > 9999) {
                throw new StreamConstraintsException("too many anchors in the document");
            }
            this.tokenStack.push(anchorContext);
            return abstractC1551gFilterEvent2;
        }
        if ((abstractC1551gFilterEvent2 instanceof l) && ((l) abstractC1551gFilterEvent2).f.equals("<<")) {
            if (!(getEvent() instanceof j)) {
                throw new JsonParseException("found field '<<' but value isn't a map");
            }
            if (this.mergeStack.size() + 1 > 9999) {
                throw new StreamConstraintsException("too many merges in the document");
            }
            this.mergeStack.push(Integer.valueOf(this.globalDepth));
            return getEvent();
        }
        if (!this.tokenStack.isEmpty()) {
            AnchorContext anchorContextPeek = this.tokenStack.peek();
            if (anchorContextPeek.events.size() + 1 > 9999) {
                throw new StreamConstraintsException("too many events to replay");
            }
            anchorContextPeek.events.add(abstractC1551gFilterEvent2);
            if (abstractC1551gFilterEvent2 instanceof AbstractC1547c) {
                anchorContextPeek.depth++;
                return abstractC1551gFilterEvent2;
            }
            if (abstractC1551gFilterEvent2 instanceof AbstractC1546b) {
                int i = anchorContextPeek.depth - 1;
                anchorContextPeek.depth = i;
                if (i == 0) {
                    this.tokenStack.pop();
                    finishContext(anchorContextPeek);
                    return abstractC1551gFilterEvent2;
                }
            }
        }
        return abstractC1551gFilterEvent2;
    }

    public AbstractC1551g trackDepth(AbstractC1551g abstractC1551g) {
        if (abstractC1551g instanceof AbstractC1547c) {
            this.globalDepth++;
            return abstractC1551g;
        }
        if (abstractC1551g instanceof AbstractC1546b) {
            this.globalDepth--;
        }
        return abstractC1551g;
    }
}
