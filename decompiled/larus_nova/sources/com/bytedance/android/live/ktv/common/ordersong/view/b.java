package com.bytedance.android.live.ktv.common.ordersong.view;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements c90.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SongTextSwitcher f70245a;

    @Override // c90.a.c
    public final void bubbleDismiss() {
        Function1<Boolean, Unit> r100 = this.f70245a.getOnWindowStateListener();
        if (r100 == null) goto L5;
        Unit r101 = r100.invoke(Boolean.TRUE);
    L5:
        SongTextSwitcher r102 = this.f70245a;
        r102.f70240g = false;
        r102.f70241h = false;
    }

    public b(SongTextSwitcher r100) {
        this.f70245a = r100;
    }
}
