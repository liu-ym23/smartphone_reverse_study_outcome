package com.bytedance.android.livesdk;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.view.View;
import android.view.Window;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes7.dex */
public final class x8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f162541a = 0;

    public static final class a implements DialogInterface.OnShowListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Dialog f162542a;

        public a(Dialog r100) {
            this.f162542a = r100;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public final void onShow(DialogInterface r100) {
            Dialog r101 = this.f162542a;
            if (r101 == null) goto L8;
            Window r102 = r101.getWindow();
            if (r102 == null) goto L9;
            r102.clearFlags(8);
            x8.a(r102);
            return;
        L9:
            return;
        }
    }

    static {
    }

    public static void a(Window r100) {
        com.bytedance.android.live.core.utils.statusbar.a.C1098a r101 = com.bytedance.android.live.core.utils.statusbar.a.f66401b;
        r101.a();
        r101.a();
        View r102 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r103 = ThreadMethodProxy.currentThread();
        if (r103 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r103, "getDecorView");
    L7:
        r102.setSystemUiVisibility(5894);
    }

    @JvmStatic
    public static final void b(Dialog r100) {
        if (r100 == null) goto L8;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L6;
        r101.addFlags(8);
        a(r101);
        r101.setType(1000);
    L6:
        r100.setOnShowListener(new a(r100));
        return;
    }

    public static Activity c(Context r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof Activity) == false) goto L9;
        return (Activity) r100;
    L9:
        if ((r100 instanceof ContextWrapper) == true) goto L11;
        return null;
    L11:
        return c(((ContextWrapper) r100).getBaseContext());
    }
}
