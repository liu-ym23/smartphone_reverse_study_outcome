package com.android.server.credentials.metrics.shared;

import com.android.server.audio.AudioService$$ExternalSyntheticLambda2;
import com.android.server.credentials.metrics.EntryEnum;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ResponseCollective {
    private static final String TAG = "ResponseCollective";
    private final Map<EntryEnum, Integer> mEntryCounts;
    private final Map<String, Integer> mResponseCounts;

    public ResponseCollective(Map<String, Integer> responseCounts, Map<EntryEnum, Integer> entryCounts) {
        if (responseCounts != null) goto L5;
        LinkedHashMap r0 = new LinkedHashMap();
    L6:
        this.mResponseCounts = r0;
        if (entryCounts != null) goto L9;
        LinkedHashMap r1 = new LinkedHashMap();
    L10:
        this.mEntryCounts = r1;
        return;
    L9:
        r1 = new LinkedHashMap(entryCounts);
        goto L10
    L5:
        r0 = new LinkedHashMap(responseCounts);
        goto L6
    }

    public String[] getUniqueResponseStrings() {
        String[] result = new String[this.mResponseCounts.keySet().size()];
        this.mResponseCounts.keySet().toArray(result);
        return result;
    }

    public Map<EntryEnum, Integer> getEntryCountsMap() {
        return Collections.unmodifiableMap(this.mEntryCounts);
    }

    public Map<String, Integer> getResponseCountsMap() {
        return Collections.unmodifiableMap(this.mResponseCounts);
    }

    public int[] getUniqueResponseCounts() {
        return this.mResponseCounts.values().stream().mapToInt(new AudioService$$ExternalSyntheticLambda2()).toArray();
    }

    public int[] getUniqueEntries() {
        return this.mEntryCounts.keySet().stream().mapToInt(new ResponseCollective$$ExternalSyntheticLambda0()).toArray();
    }

    public int[] getUniqueEntryCounts() {
        return this.mEntryCounts.values().stream().mapToInt(new AudioService$$ExternalSyntheticLambda2()).toArray();
    }

    public int getCountForEntry(EntryEnum e) {
        return this.mEntryCounts.getOrDefault(e, 0).intValue();
    }

    public int getNumEntriesTotal() {
        return this.mEntryCounts.values().stream().mapToInt(new AudioService$$ExternalSyntheticLambda2()).sum();
    }

    public ResponseCollective combineCollectives(ResponseCollective other) {
        if (this != other) goto L4;
        return this;
    L4:
        Map<String, Integer> responseCounts = new LinkedHashMap(other.mResponseCounts);
        Iterator<String> r1 = this.mResponseCounts.keySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        String response = r1.next();
        responseCounts.merge(response, this.mResponseCounts.get(response), new ResponseCollective$$ExternalSyntheticLambda1());
        goto L6
    L8:
        Map<EntryEnum, Integer> entryCounts = new LinkedHashMap(other.mEntryCounts);
        Iterator<EntryEnum> r2 = this.mEntryCounts.keySet().iterator();
    L10:
        if (r2.hasNext() == false) goto L13;
        EntryEnum entry = r2.next();
        entryCounts.merge(entry, this.mEntryCounts.get(entry), new ResponseCollective$$ExternalSyntheticLambda1());
        goto L10
    L13:
        return new ResponseCollective(responseCounts, entryCounts);
    }

    public static <T> Map<T, Integer> combineTypeCountMaps(Map<T, Integer> first, Map<T, Integer> second) {
        Iterator<T> r0 = second.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        T response = r0.next();
        first.put(response, Integer.valueOf(first.getOrDefault(response, 0).intValue() + second.get(response).intValue()));
        goto L4
    L6:
        return first;
    }
}
