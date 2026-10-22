package com.fasterxml.jackson.dataformat.yaml;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.IOContext;
import java.io.Reader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import vd.e;
import zd.a;
import zd.b;
import zd.c;
import zd.g;
import zd.i;
import zd.j;
import zd.k;
import zd.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class YAMLAnchorReplayingParser extends YAMLParser {
    public static final int MAX_ANCHORS = 9999;
    public static final int MAX_EVENTS = 9999;
    public static final int MAX_MERGES = 9999;
    public static final int MAX_REFS = 9999;
    private int globalDepth;
    private final ArrayDeque<Integer> mergeStack;
    private final ArrayDeque<g> refEvents;
    private final Map<String, List<g>> referencedObjects;
    private final ArrayDeque<AnchorContext> tokenStack;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class AnchorContext {
        public final String anchor;
        public final List<g> events = new ArrayList();
        public int depth = 1;

        public AnchorContext(String str) {
            this.anchor = str;
        }
    }

    public YAMLAnchorReplayingParser(IOContext iOContext, int i, int i3, e eVar, ObjectCodec objectCodec, Reader reader) {
        super(iOContext, i, i3, eVar, objectCodec, reader);
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
        List<g> list = this.tokenStack.peek().events;
        if (anchorContext.events.size() + list.size() > 9999) {
            throw new StreamConstraintsException("too many events to replay");
        }
        list.addAll(anchorContext.events);
    }

    public g filterEvent(g gVar) {
        if (!(gVar instanceof i) || this.mergeStack.isEmpty() || this.mergeStack.peek().intValue() <= this.globalDepth) {
            return gVar;
        }
        this.mergeStack.pop();
        return null;
    }

    @Override // com.fasterxml.jackson.dataformat.yaml.YAMLParser
    public g getEvent() throws JsonParseException, StreamConstraintsException {
        String str;
        while (!this.refEvents.isEmpty()) {
            g gVarFilterEvent = filterEvent(trackDepth(this.refEvents.removeFirst()));
            if (gVarFilterEvent != null) {
                return gVarFilterEvent;
            }
        }
        g gVarFilterEvent2 = null;
        while (gVarFilterEvent2 == null) {
            g gVarTrackDepth = trackDepth(super.getEvent());
            if (gVarTrackDepth == null) {
                return null;
            }
            gVarFilterEvent2 = filterEvent(gVarTrackDepth);
        }
        if (gVarFilterEvent2 instanceof a) {
            String str2 = ((a) gVarFilterEvent2).f16591c;
            List<g> list = this.referencedObjects.get(str2);
            if (list == null) {
                throw new JsonParseException("invalid alias " + str2);
            }
            if (list.size() + this.refEvents.size() > 9999) {
                throw new StreamConstraintsException("too many events to replay");
            }
            this.refEvents.addAll(list);
            return this.refEvents.removeFirst();
        }
        if ((gVarFilterEvent2 instanceof k) && (str = ((k) gVarFilterEvent2).f16591c) != null) {
            AnchorContext anchorContext = new AnchorContext(str);
            anchorContext.events.add(gVarFilterEvent2);
            if (!(gVarFilterEvent2 instanceof c)) {
                finishContext(anchorContext);
                return gVarFilterEvent2;
            }
            if (this.tokenStack.size() + 1 > 9999) {
                throw new StreamConstraintsException("too many anchors in the document");
            }
            this.tokenStack.push(anchorContext);
            return gVarFilterEvent2;
        }
        if ((gVarFilterEvent2 instanceof l) && ((l) gVarFilterEvent2).f16594f.equals("<<")) {
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
            anchorContextPeek.events.add(gVarFilterEvent2);
            if (gVarFilterEvent2 instanceof c) {
                anchorContextPeek.depth++;
                return gVarFilterEvent2;
            }
            if (gVarFilterEvent2 instanceof b) {
                int i = anchorContextPeek.depth - 1;
                anchorContextPeek.depth = i;
                if (i == 0) {
                    this.tokenStack.pop();
                    finishContext(anchorContextPeek);
                    return gVarFilterEvent2;
                }
            }
        }
        return gVarFilterEvent2;
    }

    public g trackDepth(g gVar) {
        if (gVar instanceof c) {
            this.globalDepth++;
            return gVar;
        }
        if (gVar instanceof b) {
            this.globalDepth--;
        }
        return gVar;
    }
}
