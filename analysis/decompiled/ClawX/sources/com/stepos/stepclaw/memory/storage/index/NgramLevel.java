package com.stepos.stepclaw.memory.storage.index;

import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/stepclaw/memory/storage/index/NgramLevel;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Ljava/lang/String;I)V", "UNIGRAM", "BIGRAM", "TRIGRAM", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NgramLevel {
    private static final /* synthetic */ i5.a $ENTRIES;
    private static final /* synthetic */ NgramLevel[] $VALUES;
    public static final NgramLevel UNIGRAM = new NgramLevel("UNIGRAM", 0);
    public static final NgramLevel BIGRAM = new NgramLevel("BIGRAM", 1);
    public static final NgramLevel TRIGRAM = new NgramLevel("TRIGRAM", 2);

    private static final /* synthetic */ NgramLevel[] $values() {
        return new NgramLevel[]{UNIGRAM, BIGRAM, TRIGRAM};
    }

    static {
        NgramLevel[] ngramLevelArr$values = $values();
        $VALUES = ngramLevelArr$values;
        $ENTRIES = a.a.F(ngramLevelArr$values);
    }

    private NgramLevel(String str, int i8) {
    }

    public static i5.a getEntries() {
        return $ENTRIES;
    }

    public static NgramLevel valueOf(String str) {
        return (NgramLevel) Enum.valueOf(NgramLevel.class, str);
    }

    public static NgramLevel[] values() {
        return (NgramLevel[]) $VALUES.clone();
    }
}
