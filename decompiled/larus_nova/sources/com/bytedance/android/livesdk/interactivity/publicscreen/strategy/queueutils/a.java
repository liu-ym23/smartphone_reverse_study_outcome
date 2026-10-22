package com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils;

import com.bytedance.android.livesdk.interactivity.api.entity.PSMessagePriority;

/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f139558a = null;

    static {
        int[] r100 = new int[PSMessagePriority.values().length];
        f139558a = r100;
        r100[PSMessagePriority.HIGH.ordinal()] = 1;
        r100[PSMessagePriority.LOW.ordinal()] = 2;
        r100[PSMessagePriority.NORMAL.ordinal()] = 3;
    }
}
