package com.android.server.people.data;

import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public interface EventHistory {
    EventIndex getEventIndex(int r1);

    EventIndex getEventIndex(Set<Integer> r1);

    List<Event> queryEvents(Set<Integer> r1, long r2, long r4);
}
