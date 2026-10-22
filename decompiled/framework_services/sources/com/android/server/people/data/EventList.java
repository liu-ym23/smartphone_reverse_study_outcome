package com.android.server.people.data;

import com.android.internal.util.CollectionUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
class EventList {
    private final List<Event> mEvents;

    EventList() {
        this.mEvents = new ArrayList();
    }

    void add(Event event) {
        int index = firstIndexOnOrAfter(event.getTimestamp());
        if (index < this.mEvents.size()) goto L5;
    L9:
        this.mEvents.add(index, event);
        return;
    L5:
        if (this.mEvents.get(index).getTimestamp() != event.getTimestamp()) goto L9;
        if (isDuplicate(event, index) == false) goto L9;
    }

    void addAll(List<Event> events) {
        Iterator<Event> r0 = events.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Event event = r0.next();
        add(event);
        goto L4
    }

    List<Event> queryEvents(Set<Integer> eventTypes, long fromTimestamp, long toTimestamp) {
        int fromIndex = firstIndexOnOrAfter(fromTimestamp);
        if (fromIndex == this.mEvents.size()) goto L5;
        int toIndex = firstIndexOnOrAfter(toTimestamp);
        if (toIndex < fromIndex) goto L9;
        List<Event> result = new ArrayList();
        int i = fromIndex;
    L11:
        if (i >= toIndex) goto L17;
        Event e = this.mEvents.get(i);
        if (eventTypes.contains(Integer.valueOf(e.getType())) == false) goto L15;
        result.add(e);
    L15:
        i = i + 1;
        goto L11
    L17:
        return result;
    L9:
        return new ArrayList();
    L5:
        return new ArrayList();
    }

    void clear() {
        this.mEvents.clear();
    }

    List<Event> getAllEvents() {
        return CollectionUtils.copyOf(this.mEvents);
    }

    void removeOldEvents(long cutOffThreshold) {
        int cutOffIndex = firstIndexOnOrAfter(cutOffThreshold);
        if (cutOffIndex != 0) goto L5;
        return;
    L5:
        int eventsSize = this.mEvents.size();
        if (cutOffIndex != eventsSize) goto L9;
        this.mEvents.clear();
        return;
    L9:
        int i = 0;
    L10:
        if (cutOffIndex >= eventsSize) goto L12;
        this.mEvents.set(i, this.mEvents.get(cutOffIndex));
        i = i + 1;
        cutOffIndex = cutOffIndex + 1;
        goto L10
    L12:
        if (eventsSize <= i) goto L16;
        this.mEvents.subList(i, eventsSize).clear();
        return;
    }

    private int firstIndexOnOrAfter(long timestamp) {
        int result = this.mEvents.size();
        int low = 0;
        int high = this.mEvents.size() - 1;
    L3:
        if (low > high) goto L9;
        int mid = (low + high) >>> 1;
        if (this.mEvents.get(mid).getTimestamp() >= timestamp) goto L6;
        low = mid + 1;
        goto L3
    L6:
        high = mid - 1;
        result = mid;
        goto L3
    L9:
        return result;
    }

    private boolean isDuplicate(Event event, int startIndex) {
        int size = this.mEvents.size();
        int index = startIndex;
    L3:
        if (index >= size) goto L11;
        if (this.mEvents.get(index).getTimestamp() > event.getTimestamp()) goto L16;
        int index2 = index + 1;
        if (this.mEvents.get(index).getType() == event.getType()) goto L8;
        index = index2;
        goto L3
    L8:
        return true;
    L16:
        return false;
    L11:
        return false;
    }
}
