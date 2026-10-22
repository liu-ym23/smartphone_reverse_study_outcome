package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import com.bytedance.android.livesdk.audiencerecord.api.BacktrackState;

/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class k2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f117261a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f117262b = null;

    static {
        int[] r100 = new int[BacktrackState.values().length];
        f117261a = r100;
        BacktrackState r101 = BacktrackState.IDLE;
        r100[r101.ordinal()] = 1;
        BacktrackState r102 = BacktrackState.TIMEOUT;
        r100[r102.ordinal()] = 2;
        BacktrackState r103 = BacktrackState.ERROR;
        r100[r103.ordinal()] = 3;
        BacktrackState r104 = BacktrackState.BACKTRACK_DOING;
        r100[r104.ordinal()] = 4;
        BacktrackState r105 = BacktrackState.PREVIEWING;
        r100[r105.ordinal()] = 5;
        BacktrackState r110 = BacktrackState.DONE;
        r100[r110.ordinal()] = 6;
        int[] r106 = new int[BacktrackState.values().length];
        f117262b = r106;
        r106[r101.ordinal()] = 1;
        r106[r102.ordinal()] = 2;
        r106[r103.ordinal()] = 3;
        r106[r104.ordinal()] = 4;
        r106[r105.ordinal()] = 5;
        r106[r110.ordinal()] = 6;
    }
}
