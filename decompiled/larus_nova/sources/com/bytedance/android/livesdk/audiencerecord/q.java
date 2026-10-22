package com.bytedance.android.livesdk.audiencerecord;

import com.bytedance.android.livesdk.audiencerecord.api.BacktrackState;

/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f104068a = null;

    static {
        int[] r100 = new int[BacktrackState.values().length];
        f104068a = r100;
        r100[BacktrackState.TIMEOUT.ordinal()] = 1;
        r100[BacktrackState.ERROR.ordinal()] = 2;
        r100[BacktrackState.DONE.ordinal()] = 3;
    }
}
