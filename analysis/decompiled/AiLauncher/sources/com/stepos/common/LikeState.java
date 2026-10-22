package com.stepos.common;

import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/common/LikeState;", "", "<init>", "(Ljava/lang/String;I)V", "Like", "UnLike", "Normal", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LikeState {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ LikeState[] $VALUES;
    public static final LikeState Like = new LikeState("Like", 0);
    public static final LikeState UnLike = new LikeState("UnLike", 1);
    public static final LikeState Normal = new LikeState("Normal", 2);

    private static final /* synthetic */ LikeState[] $values() {
        return new LikeState[]{Like, UnLike, Normal};
    }

    static {
        LikeState[] likeStateArr$values = $values();
        $VALUES = likeStateArr$values;
        $ENTRIES = a.a(likeStateArr$values);
    }

    private LikeState(String str, int i10) {
    }

    public static InterfaceC4149a<LikeState> getEntries() {
        return $ENTRIES;
    }

    public static LikeState valueOf(String str) {
        return (LikeState) Enum.valueOf(LikeState.class, str);
    }

    public static LikeState[] values() {
        return (LikeState[]) $VALUES.clone();
    }
}
