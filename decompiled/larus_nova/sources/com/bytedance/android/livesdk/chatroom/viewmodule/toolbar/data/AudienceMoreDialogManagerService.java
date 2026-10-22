package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatCallback;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.AudienceLandTopToolbarMoreDialog;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.AudiencePortToolbarMoreDialog;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.MorePanelDynamicControllerViewModel;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.d2;
import com.bytedance.android.livesdk.config.setting.t;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public class AudienceMoreDialogManagerService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f115893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f115894b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CommonStandardBottomDialog f115895c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f115896d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AudienceMoreDialogDataManagerImpl f115897e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DataCenter f115898f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f115899g;

    public boolean g() {
        return false;
    }

    public CommonStandardBottomDialog d() {
        if (this.f115894b == false) goto L6;
        return new AudiencePortToolbarMoreDialog(this.f115899g);
    L6:
        return new AudienceLandTopToolbarMoreDialog(this.f115899g);
    }

    public final void h() {
        if (g() == false) goto L5;
    L7:
        this.f115894b = ((Boolean) this.f115898f.get("data_is_portrait", Boolean.TRUE)).booleanValue();
        e().c(new AudienceMoreDialogManagerService$onCreate$1(this));
        return;
    L5:
        if (t.a() == false) goto L7;
        MorePanelDynamicControllerViewModel.Companion r100 = MorePanelDynamicControllerViewModel.Companion;
        DataCenter r101 = this.f115898f;
        r100.getClass();
        MorePanelDynamicControllerViewModel.Companion.b(r101);
        goto L7
    }

    public f e() {
        return this.f115897e;
    }

    public String f() {
        return this.f115893a;
    }

    public final Context getContext() {
        return this.f115899g;
    }

    public static void a(CommonStandardBottomDialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L17;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static final void c(AudienceMoreDialogManagerService r100) {
        r100.update("control");
    }

    private final void update(String r100) {
        Context r101 = this.f115899g;
        if ((r101 instanceof Activity) == true) goto L5;
    L7:
        CommonStandardBottomDialog r102 = this.f115895c;
        if (r102 != null) goto L10;
        return;
    L10:
        if (r102.isShowing() != true) goto L21;
        ALogger.i(f(), "Updating started by " + r100);
        AppCompatCallback r103 = this.f115895c;
        if ((r103 instanceof d2) == true) goto L14;
        return;
    L14:
        if ((r103 instanceof d2) == true) goto L16;
        r103 = null;
    L16:
        d2 r104 = (d2) r103;
        if (r104 == null) goto L23;
        r104.l0(e().getData(), true);
        return;
    L23:
        return;
    L21:
        return;
    L5:
        if (((Activity) r101).isFinishing() == false) goto L7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i(String r100) {
        CommonStandardBottomDialog r101 = d();
        if ((r101.getContext() instanceof Activity) == false) goto L13;
        Context r102 = r101.getContext();
        if ((r102 instanceof Activity) == true) goto L7;
        r102 = null;
    L7:
        Activity r103 = (Activity) r102;
        if (r103 == null) goto L13;
        if (r103.isFinishing() != true) goto L13;
        return;
    L13:
        if ((r101 instanceof d2) == false) goto L16;
        d2 r104 = (d2) r101;
        r104.setEnterFrom(r100);
        r104.setDataCenter(this.f115898f);
        e().a();
        ALogger.i(f(), "on dialog show");
        r104.l0(e().getData(), false);
    L16:
        if (DialogLancet.shouldBlockDialogShow(r101) == false) goto L23;
        DialogLancet.handleBlockedDialogShow(r101);
    L20:
        Unit r105 = Unit.INSTANCE;
        this.f115895c = r101;
        return;
    L23:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L22
    L19:
        DialogLancet.beforeDialogShow(r101);
        r101.show();
        DialogLancet.afterDialogShow(r101);
        goto L20
    }

    public AudienceMoreDialogManagerService(DataCenter r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f115898f = r100;
        this.f115899g = r101;
        this.f115893a = "AudienceMoreDialogManagerService";
        this.f115896d = new CompositeDisposable();
        this.f115897e = new AudienceMoreDialogDataManagerImpl(r100, r101);
    }

    public static final /* synthetic */ void b(AudienceMoreDialogManagerService r100, String r101) {
        r100.update(r101);
    }
}
