package com.bytedance.android.livesdk.chatroom.viewmodule.backtrack;

import com.bytedance.android.livesdk.audiencerecord.api.BacktrackState;
import com.bytedance.android.livesdkapi.depend.live.IAnchorBacktrackService;

/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f115221a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f115222b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f115223c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int[] f115224d = null;

    static {
        int[] r100 = new int[IAnchorBacktrackService.State.values().length];
        f115221a = r100;
        IAnchorBacktrackService.State r101 = IAnchorBacktrackService.State.BACKTRACK_DOING;
        r100[r101.ordinal()] = 1;
        int[] r102 = new int[BacktrackState.values().length];
        f115222b = r102;
        BacktrackState r103 = BacktrackState.STARTED;
        r102[r103.ordinal()] = 1;
        BacktrackState r104 = BacktrackState.BACKTRACK_DOING;
        r102[r104.ordinal()] = 2;
        BacktrackState r105 = BacktrackState.PREVIEWING;
        r102[r105.ordinal()] = 3;
        int[] r106 = new int[BacktrackState.values().length];
        f115223c = r106;
        r106[BacktrackState.IDLE.ordinal()] = 1;
        r106[r103.ordinal()] = 2;
        r106[r104.ordinal()] = 3;
        r106[r105.ordinal()] = 4;
        r106[BacktrackState.TIMEOUT.ordinal()] = 5;
        r106[BacktrackState.DONE.ordinal()] = 6;
        r106[BacktrackState.ERROR.ordinal()] = 7;
        int[] r107 = new int[IAnchorBacktrackService.State.values().length];
        f115224d = r107;
        r107[IAnchorBacktrackService.State.IDLE.ordinal()] = 1;
        r107[r101.ordinal()] = 2;
        r107[IAnchorBacktrackService.State.BACKTRACK_DONE.ordinal()] = 3;
        r107[IAnchorBacktrackService.State.DOWNLOAD.ordinal()] = 4;
        r107[IAnchorBacktrackService.State.SAVE_DRAFT.ordinal()] = 5;
        r107[IAnchorBacktrackService.State.DONE.ordinal()] = 6;
    }
}
