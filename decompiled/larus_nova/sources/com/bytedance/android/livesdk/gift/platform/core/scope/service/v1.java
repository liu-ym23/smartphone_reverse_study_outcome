package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.model.CardType;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;

/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class v1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f131814a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f131815b = null;

    static {
        int[] r100 = new int[ReceiverType.values().length];
        f131814a = r100;
        r100[ReceiverType.Anchor.ordinal()] = 1;
        r100[ReceiverType.Guest.ordinal()] = 2;
        r100[ReceiverType.Audience.ordinal()] = 3;
        r100[ReceiverType.OtherAnchor.ordinal()] = 4;
        int[] r101 = new int[CardType.values().length];
        f131815b = r101;
        r101[CardType.DIY.ordinal()] = 1;
        r101[CardType.Buff.ordinal()] = 2;
    }
}
