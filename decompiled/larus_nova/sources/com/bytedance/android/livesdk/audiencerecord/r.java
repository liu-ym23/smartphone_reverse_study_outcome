package com.bytedance.android.livesdk.audiencerecord;

import com.bytedance.android.livesdk.audiencerecord.api.BacktrackState;

/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f104069a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f104070b = null;

    static {
        int[] r100 = new int[BacktrackState.values().length];
        f104069a = r100;
        BacktrackState r101 = BacktrackState.TIMEOUT;
        r100[r101.ordinal()] = 1;
        BacktrackState r102 = BacktrackState.ERROR;
        r100[r102.ordinal()] = 2;
        BacktrackState r103 = BacktrackState.DONE;
        r100[r103.ordinal()] = 3;
        int[] r104 = new int[BacktrackState.values().length];
        f104070b = r104;
        r104[r103.ordinal()] = 1;
        r104[BacktrackState.BACKTRACK_DOING.ordinal()] = 2;
        r104[r101.ordinal()] = 3;
        r104[r102.ordinal()] = 4;
        r104[BacktrackState.PREVIEWING.ordinal()] = 5;
    }
}
