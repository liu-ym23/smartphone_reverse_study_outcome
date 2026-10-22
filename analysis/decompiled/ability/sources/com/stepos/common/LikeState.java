package com.stepos.common;

import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/stepos/common/LikeState;", "", "common_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LikeState {

    /* renamed from: a, reason: collision with root package name */
    public static final LikeState f3542a;
    public static final /* synthetic */ LikeState[] b;

    static {
        LikeState likeState = new LikeState("Like", 0);
        LikeState likeState2 = new LikeState("UnLike", 1);
        LikeState likeState3 = new LikeState("Normal", 2);
        f3542a = likeState3;
        LikeState[] likeStateArr = {likeState, likeState2, likeState3};
        b = likeStateArr;
        a.a(likeStateArr);
    }

    public static LikeState valueOf(String str) {
        return (LikeState) Enum.valueOf(LikeState.class, str);
    }

    public static LikeState[] values() {
        return (LikeState[]) b.clone();
    }
}
