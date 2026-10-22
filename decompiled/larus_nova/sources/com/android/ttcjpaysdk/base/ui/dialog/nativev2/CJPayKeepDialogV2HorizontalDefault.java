package com.android.ttcjpaysdk.base.ui.dialog.nativev2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.ktextension.CJPayViewExtensionsKt;
import com.android.ttcjpaysdk.base.ui.Utils.keepdialog.RetainInfoV2Config;
import com.android.ttcjpaysdk.base.ui.data.DefaultRetainInfo;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\u0012\u0010\u001c\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0013\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0014\u0010\u0010R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0017\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/dialog/nativev2/CJPayKeepDialogV2HorizontalDefault;", "Lcom/android/ttcjpaysdk/base/ui/dialog/nativev2/CJPayKeepDialogNativeV2Base;", "activity", "Landroid/app/Activity;", "themeResId", "", "defaultRetainInfo", "Lcom/android/ttcjpaysdk/base/ui/data/DefaultRetainInfo;", "retainInfoV2Config", "Lcom/android/ttcjpaysdk/base/ui/Utils/keepdialog/RetainInfoV2Config;", "hasVoucher", "", "(Landroid/app/Activity;ILcom/android/ttcjpaysdk/base/ui/data/DefaultRetainInfo;Lcom/android/ttcjpaysdk/base/ui/Utils/keepdialog/RetainInfoV2Config;Z)V", "cancelBtn", "Landroid/widget/TextView;", "getCancelBtn", "()Landroid/widget/TextView;", "cancelBtn$delegate", "Lkotlin/Lazy;", "confirmBtn", "getConfirmBtn", "confirmBtn$delegate", "titleText", "getTitleText", "titleText$delegate", "initAction", "", "initView", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayKeepDialogV2HorizontalDefault extends CJPayKeepDialogNativeV2Base {
    private final Lazy cancelBtn$delegate;
    private final Lazy confirmBtn$delegate;
    private final DefaultRetainInfo defaultRetainInfo;
    private final boolean hasVoucher;
    private final RetainInfoV2Config retainInfoV2Config;
    private final Lazy titleText$delegate;

    private final TextView getCancelBtn() {
        return (TextView) this.cancelBtn$delegate.getValue();
    }

    private final TextView getConfirmBtn() {
        return (TextView) this.confirmBtn$delegate.getValue();
    }

    private final TextView getTitleText() {
        return (TextView) this.titleText$delegate.getValue();
    }

    private final void initAction() {
        CJPayViewExtensionsKt.setDebouncingOnClickListener(getConfirmBtn(), new AnonymousClass1(this));
        CJPayViewExtensionsKt.setDebouncingOnClickListener(getCancelBtn(), new AnonymousClass2(this));
    }

    private final void initView() {
        TextView r100 = getTitleText();
        DefaultRetainInfo r101 = this.defaultRetainInfo;
        if (r101 == null) goto L8;
        String r102 = r101.title;
        if (r102 == null) goto L8;
    L12:
        r100.setText(r102);
        TextView r103 = getConfirmBtn();
        DefaultRetainInfo r104 = this.defaultRetainInfo;
        if (r104 == null) goto L17;
        String r105 = r104.top_retain_button_text;
        if (r105 == null) goto L17;
    L18:
        r103.setText(r105);
        TextView r106 = getCancelBtn();
        DefaultRetainInfo r107 = this.defaultRetainInfo;
        if (r107 == null) goto L23;
        String r108 = r107.bottom_retain_button_text;
        if (r108 == null) goto L23;
    L24:
        r106.setText(r108);
        return;
    L23:
        r108 = getContext().getString(R.string.cj_pay_keep_window_cancel);
    L17:
        r105 = getContext().getString(R.string.cj_pay_keep_window_keep);
    L8:
        if (this.hasVoucher == false) goto L10;
        Context r109 = getContext();
        int r110 = R.string.cj_pay_keep_window_title_discount;
    L11:
        r102 = r109.getString(r110);
        goto L12
    L10:
        r109 = getContext();
        r110 = R.string.cj_pay_keep_window_title_no_discount;
        goto L11
    }

    public static final /* synthetic */ RetainInfoV2Config access$getRetainInfoV2Config$p(CJPayKeepDialogV2HorizontalDefault r100) {
        return r100.retainInfoV2Config;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        setContentView(R.layout.cj_pay_keep_dialog_native_v2_default_v1_layout);
        setCancelable(false);
        initView();
        initAction();
    }

    public CJPayKeepDialogV2HorizontalDefault(Activity r100, int r101, DefaultRetainInfo r102, RetainInfoV2Config r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        super(r100, r101);
        this.defaultRetainInfo = r102;
        this.retainInfoV2Config = r103;
        this.hasVoucher = r104;
        this.titleText$delegate = id(R.id.keep_dialog_v2_title);
        this.confirmBtn$delegate = id(R.id.keep_dialog_v2_confirm_button);
        this.cancelBtn$delegate = id(R.id.keep_dialog_v2_cancel_button);
    }

    public /* synthetic */ CJPayKeepDialogV2HorizontalDefault(Activity r100, int r101, DefaultRetainInfo r102, RetainInfoV2Config r110, boolean r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 2) == 0) goto L5;
        int r103 = R.style.CJ_Pay_Full_Dialog_Fragment_Style;
    L7:
        if ((r112 & 16) == 0) goto L9;
        boolean r104 = false;
    L10:
        this(r100, r103, r102, r110, r104);
        return;
    L9:
        r104 = r111;
        goto L10
    L5:
        r103 = r101;
        goto L7
    }
}
