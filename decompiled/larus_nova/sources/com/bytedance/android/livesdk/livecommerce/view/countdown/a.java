package com.bytedance.android.livesdk.livecommerce.view.countdown;

import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.widget.TextView;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScreenshotCountDownDialog f153212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Animation f153213b;

    public a(ScreenshotCountDownDialog r100, Animation r101) {
        this.f153212a = r100;
        this.f153213b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        TextView r102 = this.f153212a.f153207a;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("countdownTextView");
    L5:
        r102.setText(String.valueOf(this.f153212a.f153209c));
        this.f153213b.reset();
        TextView r103 = this.f153212a.f153207a;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("countdownTextView");
    L8:
        r103.startAnimation(this.f153213b);
        ScreenshotCountDownDialog r104 = this.f153212a;
        if (r104.f153209c > 0) goto L30;
        Disposable r105 = r104.f153208b;
        if (r105 == null) goto L13;
        r105.dispose();
    L13:
        this.f153212a.f153210d.invoke();
        ScreenshotCountDownDialog r106 = this.f153212a;
        Handler r107 = DialogLancet.resolveDialogHandler(r106);
        if (r107 != null) goto L16;
    L18:
        DialogLancet.beforeDialogDismiss(r106);
        r106.dismiss();     // Catch: Throwable -> L21 Exception -> L23
    L27:
        DialogLancet.afterDialogDismiss(r106);
        goto L30
    L21:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r106);
        throw th;
    L23:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L21
        Throwable r108 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L21
        if (r108 == null) goto L27;
        com.bytedance.crash.d.d(r108, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L21
        goto L27
    L16:
        if (Looper.myLooper() == r107.getLooper()) goto L18;
        r107.post(DialogLancet.createDismissRunnable(r106));
    L30:
        this.f153212a.f153209c--;
    }
}
