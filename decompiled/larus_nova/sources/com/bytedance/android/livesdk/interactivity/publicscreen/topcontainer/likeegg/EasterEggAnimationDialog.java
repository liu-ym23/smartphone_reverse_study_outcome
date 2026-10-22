package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.facebook.drawee.interfaces.DraweeController;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class EasterEggAnimationDialog extends Dialog {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile AtomicInteger f139895h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f139896i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<Unit> f139897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HSImageView f139898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f139899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f139900d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f139901e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f139902f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f139903g;

    public static final class a {
        public a() {
        }

        public static void a(Context r100, Function0 r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "confirmAction");
            if (EasterEggAnimationDialog.f139895h.get() <= 0) goto L6;
            ALogger.d("EasterEggAnimationDialog", "showing not allowed, skip launch.");
            return;
        L6:
            ALogger.d("EasterEggAnimationDialog", "start launch");
            EasterEggAnimationDialog r102 = new EasterEggAnimationDialog(r100);
            r102.f139897a = r101;
            if (DialogLancet.shouldBlockDialogShow(r102) == false) goto L13;
            DialogLancet.handleBlockedDialogShow(r102);
            return;
        L13:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
        L10:
            DialogLancet.beforeDialogShow(r102);
            r102.show();
            DialogLancet.afterDialogShow(r102);
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EasterEggAnimationDialog f139904a;

        public b(EasterEggAnimationDialog r100) {
            this.f139904a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            int r101 = com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.b.f140046a;
            Intrinsics.checkNotNullParameter("open", "clickType");
            LinkedHashMap r102 = new LinkedHashMap();
            r102.put("operate_type", "open");
            r102.put("interactive_name", "like_scene");
            com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.b.b("livesdk_sjb_interactive_page_click", r102);
            Function0<Unit> r103 = this.f139904a.f139897a;
            if (r103 == null) goto L5;
            Unit r104 = r103.invoke();
        L5:
            EasterEggAnimationDialog r105 = this.f139904a;
            Handler r106 = DialogLancet.resolveDialogHandler(r105);
            if (r106 != null) goto L8;
        L10:
            DialogLancet.beforeDialogDismiss(r105);
            r105.dismiss();     // Catch: Throwable -> L13 Exception -> L15
        L19:
            DialogLancet.afterDialogDismiss(r105);
            return;
        L15:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
            Throwable r107 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
            if (r107 == null) goto L19;
            com.bytedance.crash.d.d(r107, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r105);
            throw th;
        L8:
            if (Looper.myLooper() == r106.getLooper()) goto L10;
            r106.post(DialogLancet.createDismissRunnable(r105));
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EasterEggAnimationDialog f139905a;

        public c(EasterEggAnimationDialog r100) {
            this.f139905a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            int r101 = com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.b.f140046a;
            Intrinsics.checkNotNullParameter("close", "clickType");
            LinkedHashMap r102 = new LinkedHashMap();
            r102.put("operate_type", "close");
            r102.put("interactive_name", "like_scene");
            com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.b.b("livesdk_sjb_interactive_page_click", r102);
            EasterEggAnimationDialog r103 = this.f139905a;
            Handler r104 = DialogLancet.resolveDialogHandler(r103);
            if (r104 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r103);
            r103.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r103);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r103);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r105 == null) goto L16;
            com.bytedance.crash.d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r104.getLooper()) goto L7;
            r104.post(DialogLancet.createDismissRunnable(r103));
        }
    }

    static {
        f139896i = new a();
        f139895h = new AtomicInteger(0);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        ALogger.d("EasterEggAnimationDialog", "dismiss");
        com.bytedance.android.livesdk.f.d().f();
        if (this.f139903g == true) goto L5;
        this.f139903g = true;
        ALogger.d("EasterEggAnimationDialog", "likeEggDialogCount decrement: " + f139895h.decrementAndGet());
    L5:
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(this);
        return;
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r101 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r101 == null) goto L19;
        com.bytedance.crash.d.d(r101, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L8:
        if (Looper.myLooper() == r100.getLooper()) goto L10;
        r100.post(DialogLancet.createDismissRunnable(this));
    }

    @Override // android.app.Dialog
    public final void show() {
        ALogger.d("EasterEggAnimationDialog", "start show");
        com.bytedance.android.livesdk.f.d().a();
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(this);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        if (this.f139898b != null) goto L13;
        this.f139898b = (HSImageView) findViewById(R.id.animation_player);
        this.f139899c = findViewById(R.id.btn_cancel);
        this.f139900d = findViewById(R.id.btn_confirm);
        HSImageView r100 = this.f139898b;
        if (r100 == null) goto L7;
        r100.setController((DraweeController) this.f139901e.getValue());
    L7:
        View r101 = this.f139900d;
        if (r101 == null) goto L10;
        r101.setOnClickListener(new b(this));
    L10:
        View r102 = this.f139899c;
        if (r102 == null) goto L13;
        r102.setOnClickListener(new c(this));
    L13:
        int r103 = com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.b.f140046a;
        LinkedHashMap r104 = new LinkedHashMap();
        r104.put("interactive_name", "like_scene");
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.b.b("livesdk_sjb_interactive_page_show", r104);
    }

    public EasterEggAnimationDialog(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, R.style.ttlive_like_egg_float_dialog);
        this.f139901e = LazyKt.lazy(EasterEggAnimationDialog$easterEggWebpController$2.INSTANCE);
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Window r101 = getWindow();
        if (r101 == null) goto L6;
        r101.requestFeature(1);
    L6:
        if (PadConfigUtils.c() == false) goto L8;
        int r102 = R.layout.ttlive_like_egg_animation_dialog_pad;
    L9:
        setContentView(r102);
        Window r103 = getWindow();
        if (r103 == null) goto L12;
        r103.setLayout(-1, -1);
    L12:
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        if (this.f139902f == true) goto L16;
        this.f139902f = true;
        ALogger.d("EasterEggAnimationDialog", "likeEggDialogCount increment: " + f139895h.incrementAndGet());
        return;
    L16:
        return;
    L8:
        r102 = R.layout.ttlive_like_egg_animation_dialog;
        goto L9
    }
}
