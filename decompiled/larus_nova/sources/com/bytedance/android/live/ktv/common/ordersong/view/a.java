package com.bytedance.android.live.ktv.common.ordersong.view;

import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SongTextSwitcher f70244a;

    public a(SongTextSwitcher r100) {
        this.f70244a = r100;
    }

    public final void a() {
        SongTextSwitcher r100 = this.f70244a;
        if (r100.f70240g == true) goto L5;
        return;
    L5:
        if (r100.f70241h == true) goto L17;
        c90.a r101 = r100.f70237d;
        if (r101 == null) goto L9;
        PopupWindowLancet.handleDismissBeforeOrigin(r101);
        r101.dismiss();
    L9:
        c90.a r102 = this.f70244a.f70237d;
        if (r102 == null) goto L12;
        r102.g();
    L12:
        SongTextSwitcher r103 = this.f70244a;
        r103.f70240g = false;
        r103.f70241h = false;
        Function1<Boolean, Unit> r104 = r103.getOnWindowStateListener();
        if (r104 == null) goto L18;
        Unit r105 = r104.invoke(Boolean.TRUE);
        return;
    L18:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
