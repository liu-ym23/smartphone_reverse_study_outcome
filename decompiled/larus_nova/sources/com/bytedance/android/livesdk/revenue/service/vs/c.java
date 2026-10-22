package com.bytedance.android.livesdk.revenue.service.vs;

import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.revenue.vs.RevPlayViewControl$Key;
import com.bytedance.android.livesdk.revenue.vs.RevPlayViewControl$Style;
import com.bytedance.android.livesdk.revenue.vs.RevPlayViewControl$Type;

/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f157509a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f157510b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f157511c = null;

    static {
        int[] r100 = new int[RevPlayViewControl$Key.values().length];
        f157509a = r100;
        r100[RevPlayViewControl$Key.GiftTray.ordinal()] = 1;
        new int[PlayerViewControl.KEY.values().length][PlayerViewControl.KEY.GiftTray.ordinal()] = 1;
        int[] r101 = new int[RevPlayViewControl$Type.values().length];
        f157510b = r101;
        r101[RevPlayViewControl$Type.TOP.ordinal()] = 1;
        r101[RevPlayViewControl$Type.BOTTOM.ordinal()] = 2;
        r101[RevPlayViewControl$Type.LEFT.ordinal()] = 3;
        r101[RevPlayViewControl$Type.RIGHT.ordinal()] = 4;
        r101[RevPlayViewControl$Type.NONE.ordinal()] = 5;
        r101[RevPlayViewControl$Type.ALPHA.ordinal()] = 6;
        int[] r102 = new int[RevPlayViewControl$Style.values().length];
        f157511c = r102;
        r102[RevPlayViewControl$Style.ATTACH.ordinal()] = 1;
        r102[RevPlayViewControl$Style.HIDE.ordinal()] = 2;
    }
}
