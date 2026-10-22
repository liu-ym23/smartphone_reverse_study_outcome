package com.stepos.stepclaw.memory.search;

import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/stepclaw/memory/search/RetrievalSource;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Ljava/lang/String;I)V", "BM25", "VECTOR", "UNKNOWN", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RetrievalSource {
    private static final /* synthetic */ i5.a $ENTRIES;
    private static final /* synthetic */ RetrievalSource[] $VALUES;
    public static final RetrievalSource BM25 = new RetrievalSource("BM25", 0);
    public static final RetrievalSource VECTOR = new RetrievalSource("VECTOR", 1);
    public static final RetrievalSource UNKNOWN = new RetrievalSource("UNKNOWN", 2);

    private static final /* synthetic */ RetrievalSource[] $values() {
        return new RetrievalSource[]{BM25, VECTOR, UNKNOWN};
    }

    static {
        RetrievalSource[] retrievalSourceArr$values = $values();
        $VALUES = retrievalSourceArr$values;
        $ENTRIES = a.a.F(retrievalSourceArr$values);
    }

    private RetrievalSource(String str, int i8) {
    }

    public static i5.a getEntries() {
        return $ENTRIES;
    }

    public static RetrievalSource valueOf(String str) {
        return (RetrievalSource) Enum.valueOf(RetrievalSource.class, str);
    }

    public static RetrievalSource[] values() {
        return (RetrievalSource[]) $VALUES.clone();
    }
}
