package com.bytedance.android.livesdk.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.livesdk.utils.k4;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes11.dex */
public final class g1 extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveStandardSheetDialog f161704a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g1 f161705a;

        public a(g1 r100) {
            this.f161705a = r100;
        }

        public final void a() {
            LiveStandardSheetDialog r100 = this.f161705a.f161704a;
            Handler r101 = DialogLancet.resolveDialogHandler(r100);
            if (r101 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r100);
            r100.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r100);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r100);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r102 == null) goto L16;
            com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r101.getLooper()) goto L7;
            r101.post(DialogLancet.createDismissRunnable(r100));
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

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        boolean r101 = k4.e(getContext());
        LiveStandardSheetDialog r102 = this.f161704a;
        if (r102.f161091w == r101) goto L5;
        r102.f161091w = r101;
        post(new a(this));
    L8:
        if (this.f161704a.f161093y == false) goto L31;
        Rect r103 = k4.c(getContext());
        int r104 = -1;
        if (r103 == null) goto L12;
        int r105 = r103.width();
    L13:
        if (r103 == null) goto L15;
        r104 = r103.height();
    L15:
        Window r106 = this.f161704a.getWindow();
        if (r106 == null) goto L19;
        r106.setLayout(r105, r104);
    L19:
        if (FoldScreenUtils.a() != 1) goto L25;
        Window r107 = this.f161704a.getWindow();
        if (r107 == null) goto L23;
        r107.setWindowAnimations(R.style.ttlive_standard_dialog_bottom_anim);
    L23:
        this.f161704a.T0();
        return;
    L25:
        if (FoldScreenUtils.a() != 0) goto L33;
        Window r108 = this.f161704a.getWindow();
        if (r108 == null) goto L29;
        r108.setWindowAnimations(R.style.ttlive_standard_dialog_right_anim);
    L29:
        this.f161704a.U0();
        return;
    L33:
        return;
    L12:
        r105 = -1;
        goto L13
    L31:
        return;
    L5:
        if (r101 == false) goto L8;
        r102.O0();
        goto L8
    }

    public g1(LiveStandardSheetDialog r100, Context r101) {
        this.f161704a = r100;
        super(r101);
    }
}
