package com.stepos.stepclaw.memory.storage.index;

import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/stepclaw/memory/storage/index/IndexTier;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Ljava/lang/String;I)V", "PERMANENT", "DYNAMIC", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class IndexTier {
    private static final /* synthetic */ i5.a $ENTRIES;
    private static final /* synthetic */ IndexTier[] $VALUES;
    public static final IndexTier PERMANENT = new IndexTier("PERMANENT", 0);
    public static final IndexTier DYNAMIC = new IndexTier("DYNAMIC", 1);

    private static final /* synthetic */ IndexTier[] $values() {
        return new IndexTier[]{PERMANENT, DYNAMIC};
    }

    static {
        IndexTier[] indexTierArr$values = $values();
        $VALUES = indexTierArr$values;
        $ENTRIES = a.a.F(indexTierArr$values);
    }

    private IndexTier(String str, int i8) {
    }

    public static i5.a getEntries() {
        return $ENTRIES;
    }

    public static IndexTier valueOf(String str) {
        return (IndexTier) Enum.valueOf(IndexTier.class, str);
    }

    public static IndexTier[] values() {
        return (IndexTier[]) $VALUES.clone();
    }
}
