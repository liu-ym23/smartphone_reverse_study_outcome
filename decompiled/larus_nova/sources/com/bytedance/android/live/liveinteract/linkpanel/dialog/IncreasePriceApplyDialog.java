package com.bytedance.android.live.liveinteract.linkpanel.dialog;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.linkpanel.util.o;
import com.bytedance.android.live.liveinteract.linkpanel.vm.GuestApplyViewModel;
import com.bytedance.android.live.liveinteract.plantform.model.GetInfoBeforeAddPriceResponse;
import com.bytedance.android.livesdk.utils.r3;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/dialog/IncreasePriceApplyDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IncreasePriceApplyDialog extends CommonBottomDialog {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f74387g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f74388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IRoom f74389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f74390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f74391d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f74392e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final GuestApplyViewModel f74393f;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog
    public final int getLayoutId() {
        return R.layout.ttlive_dialog_increase_price_apply;
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L18:
        if (getWindow() == null) goto L25;
        Window r101 = getWindow();
        if (r101 == null) goto L22;
        r101.addFlags(2);
    L22:
        Window r102 = getWindow();
        if (r102 == null) goto L25;
        r102.setDimAmount(1.0f);
    L25:
        GuestApplyViewModel r103 = this.f74393f;
        if (r103 == null) goto L28;
        r103.clearAddPriceData();
    L28:
        this.f74391d = false;
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r104 == null) goto L16;
        com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r100.getLooper()) goto L7;
        r100.post(DialogLancet.createDismissRunnable(this));
        goto L18
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f74388a.dispose();
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L17;
        DialogLancet.handleBlockedDialogShow(this);
    L8:
        if (getWindow() == null) goto L19;
        Window r100 = getWindow();
        if (r100 == null) goto L12;
        r100.addFlags(2);
    L12:
        Window r101 = getWindow();
        if (r101 == null) goto L20;
        r101.setDimAmount(0.6f);
        return;
    L20:
        return;
    L19:
        return;
    L17:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L8
    }

    public static final int M0(IncreasePriceApplyDialog r100) {
        GuestApplyViewModel r101 = r100.f74393f;
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.getPaidCount();
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        if (Intrinsics.areEqual(m.i().isPortraitInteraction(), Boolean.FALSE) == false) goto L10;
        Window r101 = getWindow();
        if (r101 == null) goto L7;
        r101.setGravity(5);
    L7:
        Window r102 = getWindow();
        if (r102 == null) goto L10;
        r102.setLayout(s1.f(375.0f), -1);
    L10:
        com.bytedance.live.datacontext.m<IRoom> r103 = m.i().getRoom();
        if (r103 == null) goto L13;
        IRoom r104 = r103.getValue();
    L14:
        this.f74389b = r104;
        GuestApplyViewModel r105 = this.f74393f;
        if (r105 == null) goto L17;
        r105.getInfoBeforeAddPrice(this.f74392e, 0, new AnonymousClass1(this));
    L17:
        b r106 = new b(this);
        GuestApplyViewModel r107 = this.f74393f;
        if (r107 == null) goto L22;
        LiveData<GetInfoBeforeAddPriceResponse> r108 = r107.getAfterIncreasePriceData();
        if (r108 == null) goto L22;
        r108.observeForever(r106);
    L22:
        c r109 = new c(this);
        GuestApplyViewModel r110 = this.f74393f;
        if (r110 == null) goto L27;
        MutableLiveData<Boolean> r111 = r110.getAddPriceState();
        if (r111 == null) goto L27;
        r111.observeForever(r109);
    L27:
        setOnDismissListener(new com.bytedance.android.live.liveinteract.linkpanel.dialog.a(this, r106, r109));
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        ((Button) findViewById(R.id.btn_increase_price)).setOnClickListener(x0.a(new AnonymousClass2(this)));
        o.z();
        o.z();
        ((ImageView) findViewById(R.id.minus_btn)).setVisibility(8);
        ((ImageView) findViewById(R.id.plus_btn)).setVisibility(8);
        int r112 = r3.f159145a;
        ImageLoader.load(j40.m.f497260a.getValue().getIcCoin()).a((HSImageView) findViewById(R.id.iv_icon));
        ((TextView) findViewById(R.id.tv_paid_count)).setText(r3.b());
        return;
    L13:
        r104 = null;
        goto L14
    }

    public IncreasePriceApplyDialog(Context r100, int r101, GuestApplyViewModel r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f74392e = r101;
        this.f74393f = r102;
        this.f74388a = new CompositeDisposable();
        this.f74390c = 1;
    }
}
