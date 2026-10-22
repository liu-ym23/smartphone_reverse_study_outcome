package com.bytedance.android.live.messagewindow.business.widget;

import com.bytedance.android.live.room.api.messagewindow.state.CardAction;

/* JADX INFO: loaded from: classes46.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f83016a = null;

    static {
        int[] r100 = new int[CardAction.values().length];
        f83016a = r100;
        r100[CardAction.REFRESH.ordinal()] = 1;
        r100[CardAction.HIDE.ordinal()] = 2;
        r100[CardAction.DESTROY.ordinal()] = 3;
        r100[CardAction.DESTROY_WITHOUT_DESTROY.ordinal()] = 4;
    }
}
