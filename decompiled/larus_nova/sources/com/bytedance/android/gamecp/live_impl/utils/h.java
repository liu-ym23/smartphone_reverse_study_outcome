package com.bytedance.android.gamecp.live_impl.utils;

/* JADX INFO: loaded from: classes44.dex */
public final /* synthetic */ class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f58087a = null;

    static {
        int[] r100 = new int[GamePromoteCardMonitor.Status.values().length];
        f58087a = r100;
        r100[GamePromoteCardMonitor.Status.START.ordinal()] = 1;
        r100[GamePromoteCardMonitor.Status.WILL_SHOW.ordinal()] = 2;
        r100[GamePromoteCardMonitor.Status.CANCEL.ordinal()] = 3;
        r100[GamePromoteCardMonitor.Status.END.ordinal()] = 4;
        r100[GamePromoteCardMonitor.Status.WILL_NOT_SHOW.ordinal()] = 5;
    }
}
