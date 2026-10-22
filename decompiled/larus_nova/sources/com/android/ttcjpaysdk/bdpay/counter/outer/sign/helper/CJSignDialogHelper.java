package com.android.ttcjpaysdk.bdpay.counter.outer.sign.helper;

import android.app.Activity;
import android.view.View;
import com.android.ttcjpaysdk.base.ktextension.CJPayKotlinExtensionsKt;
import com.android.ttcjpaysdk.base.ui.data.CJPayButtonInfo;
import com.android.ttcjpaysdk.base.ui.dialog.CJPayCommonDialog;
import com.android.ttcjpaysdk.base.ui.dialog.CJPayDialogUtils;
import com.android.ttcjpaysdk.bdpay.counter.outer.sign.logger.CJPaySignOnlyLogger;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J0\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\fH\u0002J\"\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u0011\u001a\u00020\u00122\b\u0010\t\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/helper/CJSignDialogHelper;", "", "activity", "Landroid/app/Activity;", "logger", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/logger/CJPaySignOnlyLogger;", "(Landroid/app/Activity;Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/logger/CJPaySignOnlyLogger;)V", "buildButtonInfoDialog", "Lcom/android/ttcjpaysdk/base/ui/dialog/CJPayCommonDialog;", "buttonInfo", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayButtonInfo;", "leftListener", "Landroid/view/View$OnClickListener;", "rightListener", "singleListener", "handleButtonInfo", "", "handleNonBlockingPopup", "", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJSignDialogHelper {
    private final Activity activity;
    private final CJPaySignOnlyLogger logger;

    public static final /* synthetic */ CJPaySignOnlyLogger access$getLogger$p(CJSignDialogHelper r100) {
        return r100.logger;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [T, android.app.Dialog, com.android.ttcjpaysdk.base.ui.dialog.CJPayCommonDialog] */
    public final void handleNonBlockingPopup(CJPayButtonInfo r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (Intrinsics.areEqual(r100.button_status, "1") == true) goto L7;
        return;
    L7:
        if (r100.button_desc.length() != 0) goto L9;
        boolean r101 = true;
    L10:
        if (r101 == false) goto L12;
        r100.button_desc = this.activity.getString(R.string.cj_pay_i_got_it_btn);
    L12:
        final Ref.ObjectRef r102 = new Ref.ObjectRef();
        ?? r103 = buildButtonInfoDialog(r100, null, null, new ViewOnClickListenerC89991(r102));
        r102.element = r103;
        CJPayCommonDialog r104 = (CJPayCommonDialog) r103;
        if (r103 == 0) goto L17;
        CJPayKotlinExtensionsKt.showSafely(r103, this.activity);
        this.logger.uploadHomePageDialogShow(r100.main_title);
        return;
    L17:
        return;
    L9:
        r101 = false;
        goto L10
    }

    public CJSignDialogHelper(Activity r100, CJPaySignOnlyLogger r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "logger");
        this.activity = r100;
        this.logger = r101;
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [T, android.app.Dialog, com.android.ttcjpaysdk.base.ui.dialog.CJPayCommonDialog] */
    public final boolean handleButtonInfo(final CJPayButtonInfo r100, final View.OnClickListener r101, final View.OnClickListener r102) {
        Intrinsics.checkNotNullParameter(r100, "buttonInfo");
        if (Intrinsics.areEqual(r100.button_status, "1") == true) goto L5;
        return false;
    L5:
        final Ref.ObjectRef r103 = new Ref.ObjectRef();
        ?? r104 = buildButtonInfoDialog(r100, new AnonymousClass1(r103, r101, this, r100), new AnonymousClass2(r102, r103, this, r100), new AnonymousClass3(r103, this, r100));
        r103.element = r104;
        CJPayCommonDialog r105 = (CJPayCommonDialog) r104;
        if (r104 == 0) goto L9;
        CJPayKotlinExtensionsKt.showSafely(r104, this.activity);
        this.logger.uploadTipDialogShow(r100.main_title);
        return true;
    L9:
        return false;
    }

    private final CJPayCommonDialog buildButtonInfoDialog(CJPayButtonInfo r100, View.OnClickListener r101, View.OnClickListener r102, View.OnClickListener r103) {
        return CJPayDialogUtils.initDialog(CJPayDialogUtils.getDyStandardBuilder(this.activity).setTitle(r100.main_title).setContent(r100.page_desc).setRightText(r100.right_button_desc).setLeftText(r100.left_button_desc).setSingleText(r100.button_desc).setLeftListener(r101).setRightListener(r102).setSingleListener(r103));
    }
}
