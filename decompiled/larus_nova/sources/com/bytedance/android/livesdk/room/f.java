package com.bytedance.android.livesdk.room;

import com.bytedance.android.livesdk.room.state.LiveSessionState;

/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f157647a = null;

    static {
        int[] r100 = new int[LiveSessionState.values().length];
        f157647a = r100;
        r100[LiveSessionState.SESSION_PRE_START_CREATE.ordinal()] = 1;
        r100[LiveSessionState.SESSION_PRE_SESSION_INIT.ordinal()] = 2;
        r100[LiveSessionState.SESSION_CREATE_FINISHING.ordinal()] = 3;
        r100[LiveSessionState.SESSION_CONTAINER_STATE_CHANGED.ordinal()] = 4;
        r100[LiveSessionState.SESSION_CONTAINER_SCROLL_CHANGED.ordinal()] = 5;
        r100[LiveSessionState.SESSION_EXIT_CONTAINER.ordinal()] = 6;
    }
}
