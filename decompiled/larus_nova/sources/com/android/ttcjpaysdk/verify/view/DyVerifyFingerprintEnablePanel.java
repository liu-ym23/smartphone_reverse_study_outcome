package com.android.ttcjpaysdk.verify.view;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.ktextension.CJPayViewExtensionsKt;
import com.android.ttcjpaysdk.base.ui.component.CJSwitchView;
import com.android.ttcjpaysdk.verify.utils.DyVerifyStringHelper;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/android/ttcjpaysdk/verify/view/DyVerifyFingerprintEnablePanel;", "", "ctx", "Landroid/app/Activity;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "tipMsg", "", "(Landroid/app/Activity;Landroid/view/ViewGroup;Ljava/lang/String;)V", "switchBtn", "Lcom/android/ttcjpaysdk/base/ui/component/CJSwitchView;", "switchLayout", "Landroid/widget/RelativeLayout;", "tipTv", "Landroid/widget/TextView;", "getSwitchChecked", "", "init", "", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DyVerifyFingerprintEnablePanel {
    private final ViewGroup container;
    private final Activity ctx;
    private CJSwitchView switchBtn;
    private RelativeLayout switchLayout;
    private final String tipMsg;
    private TextView tipTv;

    public final boolean getSwitchChecked() {
        CJSwitchView r100 = this.switchBtn;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.isChecked() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final void init() {
        this.switchLayout = (RelativeLayout) this.container.findViewById(R.id.switch_fingerprint_enable_layout);
        this.switchBtn = (CJSwitchView) this.container.findViewById(R.id.switch_fingerprint_enable);
        this.tipTv = (TextView) this.container.findViewById(R.id.switch_fingerprint_enable_tip);
        CJSwitchView r100 = this.switchBtn;
        if (r100 == null) goto L5;
        r100.setIsChecked(true);
    L5:
        TextView r101 = this.tipTv;
        if (r101 == null) goto L9;
        r101.setText(DyVerifyStringHelper.getStringSafely(this.ctx, R.string.dy_verify_fingerprint_enable_tip, new Object[0]));
    L9:
        RelativeLayout r102 = this.switchLayout;
        if (r102 == null) goto L12;
        CJPayViewExtensionsKt.viewVisible(r102);
    L12:
        CJSwitchView r103 = this.switchBtn;
        if (r103 == null) goto L16;
        r103.setOnCheckedChangeListener(new AnonymousClass1(this));
        return;
    }

    public static final /* synthetic */ Activity access$getCtx$p(DyVerifyFingerprintEnablePanel r100) {
        return r100.ctx;
    }

    public static final /* synthetic */ CJSwitchView access$getSwitchBtn$p(DyVerifyFingerprintEnablePanel r100) {
        return r100.switchBtn;
    }

    public DyVerifyFingerprintEnablePanel(Activity r100, ViewGroup r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        this.ctx = r100;
        this.container = r101;
        this.tipMsg = r102;
        r101.addView(LayoutInflater.from(r100).inflate(R.layout.dy_verify_fingerprint_enable_in_degrade_pwd_layout, null), new ViewGroup.LayoutParams(-1, -2));
        CJPayViewExtensionsKt.viewVisible(r101);
    }

    public /* synthetic */ DyVerifyFingerprintEnablePanel(Activity r100, ViewGroup r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102);
    }
}
