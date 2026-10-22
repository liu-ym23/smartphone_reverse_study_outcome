package com.bytedance.android.live.broadcastgame.opengame.dialog.control;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.chatroom.ui.c9;
import com.bytedance.crash.d;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.open.SocialConstants;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements com.bytedance.android.live.broadcastgame.opengame.dialog.control.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c9 f60108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Long f60109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f60110c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f60111d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Disposable f60112e;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f60113a;

        public a(Function0 r100) {
            this.f60113a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f60113a.invoke();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.opengame.dialog.control.b$b, reason: collision with other inner class name */
    public static final class C0986b implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f60114a;

        public C0986b(b r100) {
            this.f60114a = r100;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            Function0<Unit> r100 = this.f60114a.f60110c;
            if (r100 == null) goto L6;
            Unit r101 = r100.invoke();
            return;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f60115a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f60116b;

        public c(long r100, b r101) {
            this.f60115a = r100;
            this.f60116b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            b r102 = this.f60116b;
            c9 r103 = r102.f60108a;
            String r104 = r102.f60111d;
            if (r104 == null) goto L5;
            String r105 = r104 + ' ' + ((this.f60115a - r101.longValue()) - 1) + 's';
        L6:
            r103.f112673h.setText(r105);
            return;
        L5:
            r105 = null;
            goto L6
        }
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.dialog.control.a
    public final void F0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.dialog.control.a
    public final void dismiss() {
        Disposable r100 = this.f60112e;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        c9 r101 = this.f60108a;
        Handler r102 = DialogLancet.resolveDialogHandler(r101);
        if (r102 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(r101);
        r101.dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(r101);
        return;
    L15:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r103 == null) goto L19;
        d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r101);
        throw th;
    L8:
        if (Looper.myLooper() == r102.getLooper()) goto L10;
        r102.post(DialogLancet.createDismissRunnable(r101));
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.dialog.control.a
    public final boolean isShowing() {
        return this.f60108a.isShowing();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.dialog.control.a
    public final void show() {
        Disposable r100 = this.f60112e;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        c9 r101 = this.f60108a;
        String r102 = this.f60111d;
        if (r102 == null) goto L13;
        Long r103 = this.f60109b;
        if (r103 == null) goto L11;
        String r104 = " " + r103.longValue() + 's';
        if (r104 == null) goto L11;
    L12:
        String r105 = r102.concat(r104);
    L14:
        r101.f112673h.setText(r105);
        Long r106 = this.f60109b;
        if (r106 == null) goto L17;
        long r110 = r106.longValue();
        this.f60112e = du2.a.e(0, r110, 1, 1, TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).doOnComplete(new C0986b(this)).subscribe(new c(r110, this));
    L17:
        c9 r107 = this.f60108a;
        if (DialogLancet.shouldBlockDialogShow(r107) == false) goto L24;
        DialogLancet.handleBlockedDialogShow(r107);
        return;
    L24:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L23
    L21:
        DialogLancet.beforeDialogShow(r107);
        r107.show();
        DialogLancet.afterDialogShow(r107);
        return;
    L11:
        r104 = "";
        goto L12
    L13:
        r105 = null;
        goto L14
    }

    public b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        c9.b r101 = new c9.b();
        r101.f112681a = r100;
        r101.f112682b = 1;
        r101.f112683c = R.layout.ttlive_dialog_room_center_notice_layout;
        r101.f112696p = false;
        r101.f112687g = 17;
        r101.f112697q = false;
        this.f60108a = new c9(r101.f112681a, r101);
        this.f60111d = r100.getString(R.string.ttlive_open_platform_control_confirm);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.dialog.control.a
    public final void setContent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        this.f60108a.c(r100);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.dialog.control.a
    public final void setIcon(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "icon");
        c9 r101 = this.f60108a;
        r101.f112667b.setVisibility(0);
        r101.f112668c.setImageDrawable(r100);
        c9 r102 = this.f60108a;
        r102.f112667b.setVisibility(0);
        r102.f112668c.setVisibility(0);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.dialog.control.a
    public final void setTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "title");
        this.f60108a.d(r100);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.dialog.control.a
    public final void v(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        c9 r101 = this.f60108a;
        a r102 = new a(r100);
        r101.f112673h.setOnClickListener(r102);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.dialog.control.a
    public final void y(String r100) {
        Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_APP_DESC);
        this.f60111d = r100;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.dialog.control.a
    public final void n0(long r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f60109b = Long.valueOf(r100);
        this.f60110c = r101;
    }
}
