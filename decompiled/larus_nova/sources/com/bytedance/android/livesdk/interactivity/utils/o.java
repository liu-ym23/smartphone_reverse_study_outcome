package com.bytedance.android.livesdk.interactivity.utils;

import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageAction;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessagePriority;

/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f141403a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f141404b = null;

    static {
        int[] r100 = new int[PSMessageAction.values().length];
        f141403a = r100;
        r100[PSMessageAction.BASIC.ordinal()] = 1;
        r100[PSMessageAction.CHAT.ordinal()] = 2;
        r100[PSMessageAction.BUSINESS.ordinal()] = 3;
        int[] r101 = new int[PSMessagePriority.values().length];
        f141404b = r101;
        r101[PSMessagePriority.HIGH.ordinal()] = 1;
        r101[PSMessagePriority.LOW.ordinal()] = 2;
        r101[PSMessagePriority.NORMAL.ordinal()] = 3;
    }
}
