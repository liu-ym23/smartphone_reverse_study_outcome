package com.bytedance.android.live.broadcastgame.effectgame.base;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.android.live.broadcastgame.api.model.u;
import com.bytedance.android.livesdk.widget.CircleProgressView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class ResourceLoadingController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LoadingDialog f59597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public u f59598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, ? extends Object> f59599c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f59600d;

    public static final class LoadingDialog extends Dialog {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Lazy f59601a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Lazy f59602b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Lazy f59603c;

        public static final class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ LoadingDialog f59604a;

            public a(LoadingDialog r100) {
                this.f59604a = r100;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r100) {
                LoadingDialog r101 = this.f59604a;
                Handler r102 = DialogLancet.resolveDialogHandler(r101);
                if (r102 != null) goto L5;
            L7:
                DialogLancet.beforeDialogDismiss(r101);
                r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
            L16:
                DialogLancet.afterDialogDismiss(r101);
                return;
            L10:
                th = move-exception;
                DialogLancet.afterDialogDismiss(r101);
                throw th;
            L12:
                e = move-exception;
                com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
                Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
                if (r103 == null) goto L16;
                com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
                goto L16
            L5:
                if (Looper.myLooper() == r102.getLooper()) goto L7;
                r102.post(DialogLancet.createDismissRunnable(r101));
            }
        }

        public LoadingDialog(Context r100) {
            Intrinsics.checkNotNullParameter(r100, "ctx");
            super(r100, R.style.ttlivebase_game_countdown_dialog);
            this.f59601a = LazyKt.lazy(new ResourceLoadingController$LoadingDialog$textView$2(this));
            this.f59602b = LazyKt.lazy(new ResourceLoadingController$LoadingDialog$progressView$2(this));
            this.f59603c = LazyKt.lazy(new ResourceLoadingController$LoadingDialog$closeBtn$2(this));
        }

        public final void a(int r100) {
            TextView r101 = (TextView) this.f59601a.getValue();
            StringBuilder r102 = new StringBuilder();
            r102.append(r100);
            r102.append('%');
            r101.setText(r102.toString());
            ((CircleProgressView) this.f59602b.getValue()).setProgress(r100 * 3.6f);
        }

        @Override // android.app.Dialog
        public final void onCreate(Bundle r100) {
            super.onCreate(r100);
            setContentView(R.layout.ttlive_dialog_game_loading_resource);
            setCancelable(false);
            ((View) this.f59603c.getValue()).setOnClickListener(new a(this));
        }
    }

    public ResourceLoadingController(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        this.f59600d = r100;
    }

    public final void a(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "success");
        LoadingDialog r101 = this.f59597a;
        if (r101 != null) goto L6;
        r100.invoke();
    L31:
        this.f59597a = null;
        this.f59598b = null;
        return;
    L6:
        if (r101.isShowing() != true) goto L27;
        LoadingDialog r102 = this.f59597a;
        if (r102 == null) goto L26;
        Handler r103 = DialogLancet.resolveDialogHandler(r102);
        if (r103 != null) goto L12;
    L14:
        DialogLancet.beforeDialogDismiss(r102);
        r102.dismiss();     // Catch: Throwable -> L17 Exception -> L19
    L23:
        DialogLancet.afterDialogDismiss(r102);
        goto L26
    L19:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r104 == null) goto L23;
        com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r102);
        throw th;
    L12:
        if (Looper.myLooper() == r103.getLooper()) goto L14;
        r103.post(DialogLancet.createDismissRunnable(r102));
    L26:
        r100.invoke();
        goto L31
    L27:
        int r105 = b.f59608a;
        JSONObject r106 = new JSONObject().put("status_code", IInteractGameMonitorService.FAILURE_CODE_EFFECT_GAME_START_RESOURCE_CANCEL);
        if (r106 != null) goto L30;
        r106 = new JSONObject();
    L30:
        ((IInteractGameMonitorService) k.n(IInteractGameMonitorService.class)).logGameStartupResult(1, this.f59598b, r106);
        goto L31
    }
}
