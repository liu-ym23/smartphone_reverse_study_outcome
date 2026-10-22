package com.bytedance.android.live.recharge.exchange.saas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/recharge/exchange/saas/CashExchangeDialog;", "Landroidx/appcompat/app/AppCompatDialog;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CashExchangeDialog extends AppCompatDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f89876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HSImageView f89877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f89878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f89879d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f89880e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f89881f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ToggleButton f89882g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f89883h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Button f89884i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Button f89885j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f89886k;

    public static final class a {
    }

    static {
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L12;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        Window r100 = getWindow();
        if (r100 == null) goto L14;
        WindowManager.LayoutParams r101 = new WindowManager.LayoutParams();
        r101.copyFrom(r100.getAttributes());
        r101.width = s1.f(280.0f);
        r101.height = -2;
        r100.setAttributes(r101);
        return;
    L14:
        return;
    L12:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public CashExchangeDialog(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, 0);
        init(r100);
    }

    public final void init(Context r100) {
        View r101 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_dialog_cash_exchange_gift_saas, null);
        this.f89876a = r101;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L5:
        setContentView(r101);
        View r102 = this.f89876a;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L8:
        this.f89877b = (HSImageView) r102.findViewById(R.id.gift_icon);
        View r103 = this.f89876a;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L11:
        this.f89878c = r103.findViewById(R.id.icon_bg_view);
        View r104 = this.f89876a;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L14:
        this.f89879d = (TextView) r104.findViewById(R.id.title);
        View r105 = this.f89876a;
        if (r105 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L17:
        this.f89880e = r105.findViewById(R.id.content_view);
        View r106 = this.f89876a;
        if (r106 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L20:
        this.f89881f = (TextView) r106.findViewById(R.id.content);
        View r107 = this.f89876a;
        if (r107 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L23:
        this.f89882g = (ToggleButton) r107.findViewById(R.id.toggle_btn);
        View r108 = this.f89876a;
        if (r108 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L26:
        this.f89883h = r108.findViewById(R.id.toggle_btn_container);
        View r109 = this.f89876a;
        if (r109 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L29:
        this.f89884i = (Button) r109.findViewById(R.id.button_left);
        View r110 = this.f89876a;
        if (r110 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L32:
        this.f89885j = (Button) r110.findViewById(R.id.button_right);
    }

    public CashExchangeDialog(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, R.style.ttlive_live_dialog);
        init(r100);
    }
}
