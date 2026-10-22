package com.android.server.people.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
class AggregateEventHistoryImpl implements EventHistory {
    private final List<EventHistory> mEventHistoryList;

    AggregateEventHistoryImpl() {
        this.mEventHistoryList = new ArrayList();
    }

    @Override // com.android.server.people.data.EventHistory
    public EventIndex getEventIndex(int eventType) {
        Iterator<EventHistory> r0 = this.mEventHistoryList.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        EventHistory eventHistory = r0.next();
        EventIndex eventIndex = eventHistory.getEventIndex(eventType);
        if (eventIndex.isEmpty() == true) goto L4;
        return eventIndex;
    L10:
        return EventIndex.EMPTY;
    }

    @Override // com.android.server.people.data.EventHistory
    public EventIndex getEventIndex(Set<Integer> eventTypes) {
        EventIndex merged = null;
        Iterator<EventHistory> r1 = this.mEventHistoryList.iterator();
    L4:
        if (r1.hasNext() == false) goto L12;
        EventHistory eventHistory = r1.next();
        EventIndex eventIndex = eventHistory.getEventIndex(eventTypes);
        if (merged == null) goto L7;
        if (eventIndex.isEmpty() == true) goto L4;
        merged = EventIndex.combine(merged, eventIndex);
        goto L4
    L7:
        merged = eventIndex;
        goto L4
    L12:
        if (merged == null) goto L15;
        return merged;
    L15:
        return EventIndex.EMPTY;
    }

    @Override // com.android.server.people.data.EventHistory
    public List<Event> queryEvents(Set<Integer> eventTypes, long startTime, long endTime) {
        List<Event> results = new ArrayList();
        Iterator<EventHistory> r1 = this.mEventHistoryList.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        EventHistory eventHistory = r1.next();
        EventIndex eventIndex = eventHistory.getEventIndex(eventTypes);
        if (eventIndex.isEmpty() == true) goto L4;
        Set<Integer> eventTypes2 = eventTypes;
        List<Event> queryResults = eventHistory.queryEvents(eventTypes2, startTime, endTime);
        results = combineEventLists(results, queryResults);
        eventTypes = eventTypes2;
        goto L4
    L9:
        return results;
    }

    void addEventHistory(EventHistory eventHistory) {
        this.mEventHistoryList.add(eventHistory);
    }

    private List<Event> combineEventLists(List<Event> lhs, List<Event> rhs) {
        List<Event> results = new ArrayList();
        int i = 0;
        int j = 0;
    L4:
        if (i >= lhs.size()) goto L11;
        if (j >= rhs.size()) goto L11;
        if (lhs.get(i).getTimestamp() < rhs.get(j).getTimestamp()) goto L9;
        int i2 = j + 1;
        results.add(rhs.get(j));
        j = i2;
        goto L4
    L9:
        int i3 = i + 1;
        results.add(lhs.get(i));
        i = i3;
    L11:
        int j2 = lhs.size();
        if (i >= j2) goto L15;
        results.addAll(lhs.subList(i, lhs.size()));
    L17:
        return results;
    L15:
        if (j >= rhs.size()) goto L17;
        results.addAll(rhs.subList(j, rhs.size()));
        goto L17
    }
}
