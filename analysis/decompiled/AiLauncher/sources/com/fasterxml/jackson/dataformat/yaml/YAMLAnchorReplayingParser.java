package com.fasterxml.jackson.dataformat.yaml;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.IOContext;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.events.AliasEvent;
import org.yaml.snakeyaml.events.CollectionEndEvent;
import org.yaml.snakeyaml.events.CollectionStartEvent;
import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.events.MappingEndEvent;
import org.yaml.snakeyaml.events.MappingStartEvent;
import org.yaml.snakeyaml.events.NodeEvent;
import org.yaml.snakeyaml.events.ScalarEvent;

/* loaded from: classes2.dex */
public class YAMLAnchorReplayingParser extends YAMLParser {
    public static final int MAX_ANCHORS = 9999;
    public static final int MAX_EVENTS = 9999;
    public static final int MAX_MERGES = 9999;
    public static final int MAX_REFS = 9999;
    private int globalDepth;
    private final ArrayDeque<Integer> mergeStack;
    private final ArrayDeque<Event> refEvents;
    private final Map<String, List<Event>> referencedObjects;
    private final ArrayDeque<AnchorContext> tokenStack;

    public static class AnchorContext {
        public final String anchor;
        public final List<Event> events = new ArrayList();
        public int depth = 1;

        public AnchorContext(String str) {
            this.anchor = str;
        }
    }

    public YAMLAnchorReplayingParser(IOContext iOContext, int i10, int i11, LoaderOptions loaderOptions, ObjectCodec objectCodec, Reader reader) {
        super(iOContext, i10, i11, loaderOptions, objectCodec, reader);
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
        List<Event> list = this.tokenStack.peek().events;
        if (list.size() + anchorContext.events.size() > 9999) {
            throw new StreamConstraintsException("too many events to replay");
        }
        list.addAll(anchorContext.events);
    }

    public Event filterEvent(Event event) {
        if (!(event instanceof MappingEndEvent) || this.mergeStack.isEmpty() || this.mergeStack.peek().intValue() <= this.globalDepth) {
            return event;
        }
        this.mergeStack.pop();
        return null;
    }

    @Override // com.fasterxml.jackson.dataformat.yaml.YAMLParser
    public Event getEvent() throws IOException {
        String anchor;
        while (!this.refEvents.isEmpty()) {
            Event eventFilterEvent = filterEvent(trackDepth(this.refEvents.removeFirst()));
            if (eventFilterEvent != null) {
                return eventFilterEvent;
            }
        }
        Event eventFilterEvent2 = null;
        while (eventFilterEvent2 == null) {
            Event eventTrackDepth = trackDepth(super.getEvent());
            if (eventTrackDepth == null) {
                return null;
            }
            eventFilterEvent2 = filterEvent(eventTrackDepth);
        }
        if (eventFilterEvent2 instanceof AliasEvent) {
            AliasEvent aliasEvent = (AliasEvent) eventFilterEvent2;
            List<Event> list = this.referencedObjects.get(aliasEvent.getAnchor());
            if (list != null) {
                if (this.refEvents.size() + list.size() > 9999) {
                    throw new StreamConstraintsException("too many events to replay");
                }
                this.refEvents.addAll(list);
                return this.refEvents.removeFirst();
            }
            throw new JsonParseException("invalid alias " + aliasEvent.getAnchor());
        }
        if ((eventFilterEvent2 instanceof NodeEvent) && (anchor = ((NodeEvent) eventFilterEvent2).getAnchor()) != null) {
            AnchorContext anchorContext = new AnchorContext(anchor);
            anchorContext.events.add(eventFilterEvent2);
            if (!(eventFilterEvent2 instanceof CollectionStartEvent)) {
                finishContext(anchorContext);
                return eventFilterEvent2;
            }
            if (this.tokenStack.size() + 1 > 9999) {
                throw new StreamConstraintsException("too many anchors in the document");
            }
            this.tokenStack.push(anchorContext);
            return eventFilterEvent2;
        }
        if ((eventFilterEvent2 instanceof ScalarEvent) && ((ScalarEvent) eventFilterEvent2).getValue().equals("<<")) {
            if (!(getEvent() instanceof MappingStartEvent)) {
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
            anchorContextPeek.events.add(eventFilterEvent2);
            if (eventFilterEvent2 instanceof CollectionStartEvent) {
                anchorContextPeek.depth++;
                return eventFilterEvent2;
            }
            if (eventFilterEvent2 instanceof CollectionEndEvent) {
                int i10 = anchorContextPeek.depth - 1;
                anchorContextPeek.depth = i10;
                if (i10 == 0) {
                    this.tokenStack.pop();
                    finishContext(anchorContextPeek);
                    return eventFilterEvent2;
                }
            }
        }
        return eventFilterEvent2;
    }

    public Event trackDepth(Event event) {
        if (event instanceof CollectionStartEvent) {
            this.globalDepth++;
            return event;
        }
        if (event instanceof CollectionEndEvent) {
            this.globalDepth--;
        }
        return event;
    }
}
