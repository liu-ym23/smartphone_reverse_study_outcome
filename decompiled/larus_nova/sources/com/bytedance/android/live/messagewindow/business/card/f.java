package com.bytedance.android.live.messagewindow.business.card;

import com.bytedance.android.live.messagewindow.business.presenter.JsEventType;

/* JADX INFO: loaded from: classes46.dex */
public final /* synthetic */ class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f82946a = null;

    static {
        int[] r100 = new int[JsEventType.values().length];
        f82946a = r100;
        r100[JsEventType.CLOSE_CARD.ordinal()] = 1;
        r100[JsEventType.HIDE_CARD.ordinal()] = 2;
        r100[JsEventType.SHOW_CARD.ordinal()] = 3;
    }
}
