package com.bytedance.android.livesdk.revenue.room;

import com.bytedance.android.livesdk.chatroom.model.PadOrientation;

/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f157286a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f157287b = null;

    static {
        int[] r100 = new int[PadOrientation.values().length];
        f157286a = r100;
        r100[PadOrientation.PORTRAIT.ordinal()] = 1;
        r100[PadOrientation.LANDSCAPE.ordinal()] = 2;
        int[] r101 = new int[RevPadOrientation.values().length];
        f157287b = r101;
        r101[RevPadOrientation.PORTRAIT.ordinal()] = 1;
        r101[RevPadOrientation.LANDSCAPE.ordinal()] = 2;
    }
}
