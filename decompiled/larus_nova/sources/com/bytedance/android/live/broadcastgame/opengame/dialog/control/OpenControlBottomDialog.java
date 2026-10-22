package com.bytedance.android.live.broadcastgame.opengame.dialog.control;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.open.SocialConstants;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/dialog/control/OpenControlBottomDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "Lcom/bytedance/android/live/broadcastgame/opengame/dialog/control/a;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenControlBottomDialog extends CommonBottomDialog implements com.bytedance.android.live.broadcastgame.opengame.dialog.control.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f60086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f60087b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinearLayout f60088c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Button f60089d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Long f60090e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<Unit> f60091f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f60092g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Disposable f60093h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f60094i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f60095j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f60096k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Function0<Unit> f60097l;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f60098a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OpenControlBottomDialog f60099b;

        public a(String r100, OpenControlBottomDialog r101) {
            this.f60098a = r100;
            this.f60099b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ((IBrowserService) k.n(IBrowserService.class)).buildFullScreenWebPage(this.f60099b.getContext(), this.f60098a).b();
            Button r101 = this.f60099b.f60089d;
            if (r101 == null) goto L6;
            r101.performClick();
            return;
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OpenControlBottomDialog f60100a;

        public b(OpenControlBottomDialog r100) {
            this.f60100a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Function0<Unit> r101 = this.f60100a.f60097l;
            if (r101 == null) goto L6;
            Unit r102 = r101.invoke();
            return;
        }
    }

    public static final class c implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OpenControlBottomDialog f60101a;

        public c(OpenControlBottomDialog r100) {
            this.f60101a = r100;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r100) {
            Function0<Unit> r101 = this.f60101a.f60097l;
            if (r101 == null) goto L6;
            Unit r102 = r101.invoke();
            return;
        }
    }

    public static final class d implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OpenControlBottomDialog f60102a;

        public d(OpenControlBottomDialog r100) {
            this.f60102a = r100;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            Function0<Unit> r100 = this.f60102a.f60091f;
            if (r100 == null) goto L6;
            Unit r101 = r100.invoke();
            return;
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f60103a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OpenControlBottomDialog f60104b;

        public e(long r100, OpenControlBottomDialog r101) {
            this.f60103a = r100;
            this.f60104b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            OpenControlBottomDialog r102 = this.f60104b;
            Button r103 = r102.f60089d;
            if (r103 == null) goto L10;
            String r104 = r102.f60092g;
            if (r104 == null) goto L7;
            String r105 = r104 + ' ' + ((this.f60103a - r101.longValue()) - 1) + 's';
        L8:
            r103.setText(r105);
            return;
        L7:
            r105 = null;
            goto L8
        }
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog
    public final int getLayoutId() {
        return R.layout.ttlive_dialog_control_weak;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.dialog.control.a
    public final void setIcon(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "icon");
    }

    public final void M0() {
        TextView r100 = this.f60086a;
        if (r100 == null) goto L5;
        r100.setText(this.f60094i);
    L5:
        TextView r101 = this.f60087b;
        if (r101 == null) goto L8;
        r101.setText(this.f60095j);
    L8:
        String r102 = this.f60096k;
        if (r102 == null) goto L16;
        LinearLayout r103 = this.f60088c;
        if (r103 == null) goto L13;
        r103.setVisibility(0);
    L13:
        LinearLayout r104 = this.f60088c;
        if (r104 == null) goto L16;
        r104.setOnClickListener(new a(r102, this));
    L16:
        Button r105 = this.f60089d;
        if (r105 == null) goto L19;
        r105.setOnClickListener(new b(this));
    L19:
        Button r106 = this.f60089d;
        if (r106 == null) goto L31;
        String r107 = this.f60092g;
        if (r107 == null) goto L29;
        Long r108 = this.f60090e;
        if (r108 == null) goto L27;
        String r109 = " " + r108.longValue() + 's';
        if (r109 == null) goto L27;
    L28:
        String r110 = r107.concat(r109);
    L30:
        r106.setText(r110);
    L27:
        r109 = "";
        goto L28
    L29:
        r110 = null;
    L31:
        setOnCancelListener(new c(this));
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Disposable r100 = this.f60093h;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        Handler r101 = DialogLancet.resolveDialogHandler(this);
        if (r101 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(this);
        return;
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r102 == null) goto L19;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
        goto L19
    L8:
        if (Looper.myLooper() == r101.getLooper()) goto L10;
        r101.post(DialogLancet.createDismissRunnable(this));
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, android.app.Dialog
    public final void show() {
        Disposable r100 = this.f60093h;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        M0();
        Long r101 = this.f60090e;
        if (r101 == null) goto L9;
        long r110 = r101.longValue();
        this.f60093h = du2.a.e(0, r110, 1, 1, TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).doOnComplete(new d(this)).subscribe(new e(r110, this));
    L9:
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L15;
        DialogLancet.handleBlockedDialogShow(this);
        return;
    L15:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L14
    L12:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
    }

    public OpenControlBottomDialog(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f60092g = r100.getString(R.string.ttlive_open_platform_control_confirm);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.dialog.control.a
    public final void F0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f60096k = r100;
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.f60086a = (TextView) findViewById(R.id.ttlive_control_weak_alert_title);
        this.f60087b = (TextView) findViewById(R.id.ttlive_control_weak_alert_content);
        this.f60088c = (LinearLayout) findViewById(R.id.ttlive_control_weak_alert_jump);
        this.f60089d = (Button) findViewById(R.id.ttlive_control_weak_alert_btn);
        M0();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.dialog.control.a
    public final void setContent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        this.f60095j = r100;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.dialog.control.a
    public final void setTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "title");
        this.f60094i = r100;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.dialog.control.a
    public final void v(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f60097l = r100;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.dialog.control.a
    public final void y(String r100) {
        Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_APP_DESC);
        this.f60092g = r100;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.dialog.control.a
    public final void n0(long r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f60090e = Long.valueOf(r100);
        this.f60091f = r101;
    }
}
