package com.android.ttcjpaysdk.facelive.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.ktextension.CJPayKotlinExtensionsKt;
import com.android.ttcjpaysdk.base.ktextension.CJPayViewExtensionsKt;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.ui.dialog.CJPayFadeAnimationDialog;
import com.android.ttcjpaysdk.base.utils.CJPayFakeBoldUtils;
import com.android.ttcjpaysdk.facelive.utils.CJPayFaceDialogAdapter;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0002J\u0012\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\u0010\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/android/ttcjpaysdk/facelive/view/CJPayFaceProcessCallbackDialog;", "Lcom/android/ttcjpaysdk/base/ui/dialog/CJPayFadeAnimationDialog;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "action", "Lcom/android/ttcjpaysdk/facelive/utils/CJPayFaceDialogAdapter$FaceDialogCallbackAction;", "themeResId", "", "(Landroid/content/Context;Lcom/android/ttcjpaysdk/facelive/utils/CJPayFaceDialogAdapter$FaceDialogCallbackAction;I)V", "leftBtnView", "Landroid/widget/TextView;", "middleBtnView", "rightBtnView", "subTitleView", "titleView", "bindViews", "", "initAction", "initViews", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "safelyShow", "", "ctx", "Landroid/app/Activity;", "bdpay-facecheck_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayFaceProcessCallbackDialog extends CJPayFadeAnimationDialog {
    private final CJPayFaceDialogAdapter.FaceDialogCallbackAction action;
    private TextView leftBtnView;
    private TextView middleBtnView;
    private TextView rightBtnView;
    private TextView subTitleView;
    private TextView titleView;

    private final void initAction() {
        TextView r100 = this.leftBtnView;
        if (r100 == null) goto L5;
        r100.setOnClickListener(new AnonymousClass1(this));
    L5:
        TextView r101 = this.rightBtnView;
        if (r101 == null) goto L8;
        r101.setOnClickListener(new AnonymousClass2(this));
    L8:
        TextView r102 = this.middleBtnView;
        if (r102 == null) goto L11;
        r102.setOnClickListener(new AnonymousClass3(this));
    L11:
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    private final void initViews() {
        CJPayFakeBoldUtils.fakeBold(this.titleView);
        CJPayFakeBoldUtils.fakeBold(this.rightBtnView);
        CJPayFakeBoldUtils.fakeBold(this.leftBtnView);
        CJPayFakeBoldUtils.fakeBold(this.middleBtnView);
        String r100 = this.action.getSubTitleStr();
        if (r100 == null) goto L17;
        Unit r101 = null;
        if ((!StringsKt.isBlank(r100)) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L17;
        TextView r102 = this.subTitleView;
        if (r102 == null) goto L13;
        r102.setText(r100);
    L13:
        TextView r103 = this.subTitleView;
        if (r103 == null) goto L16;
        CJPayViewExtensionsKt.viewVisible(r103);
        r101 = Unit.INSTANCE;
    L16:
        if (r101 == null) goto L17;
    L20:
        TextView r104 = this.titleView;
        if (r104 == null) goto L24;
        r104.setText(this.action.getTitleStr());
    L24:
        KtSafeMethodExtensionKt.tf(this.action.isSingleBtn(), new AnonymousClass4(this), new AnonymousClass5(this));
        return;
    L17:
        TextView r105 = this.subTitleView;
        if (r105 == null) goto L20;
        CJPayViewExtensionsKt.viewGone(r105);
        Unit r106 = Unit.INSTANCE;
        goto L20
    }

    private final void bindViews() {
        setContentView(LayoutInflater.from(getContext()).inflate(R.layout.cj_pay_view_face_process_callback_dialog, null));
        this.titleView = (TextView) findViewById(R.id.cj_pay_face_dialog_process_title);
        this.subTitleView = (TextView) findViewById(R.id.cj_pay_face_dialog_process_sub_title);
        this.leftBtnView = (TextView) findViewById(R.id.cj_pay_face_dialog_process_stop);
        this.rightBtnView = (TextView) findViewById(R.id.cj_pay_face_dialog_process_retry);
        this.middleBtnView = (TextView) findViewById(R.id.cj_pay_face_dialog_process_known);
    }

    public static final /* synthetic */ CJPayFaceDialogAdapter.FaceDialogCallbackAction access$getAction$p(CJPayFaceProcessCallbackDialog r100) {
        return r100.action;
    }

    public static final /* synthetic */ TextView access$getLeftBtnView$p(CJPayFaceProcessCallbackDialog r100) {
        return r100.leftBtnView;
    }

    public static final /* synthetic */ TextView access$getMiddleBtnView$p(CJPayFaceProcessCallbackDialog r100) {
        return r100.middleBtnView;
    }

    public static final /* synthetic */ TextView access$getRightBtnView$p(CJPayFaceProcessCallbackDialog r100) {
        return r100.rightBtnView;
    }

    @Override // com.android.ttcjpaysdk.base.ui.dialog.CJPayFadeAnimationDialog, android.app.Dialog
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        bindViews();
        initViews();
        initAction();
    }

    public final boolean safelyShow(Activity r100) {
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L10;
        CJPayKotlinExtensionsKt.showSafely(this, r100);
        return true;
    L10:
        return false;
    L5:
        if (CJPayKotlinExtensionsKt.isAlive(r100) != true) goto L7;
        r101 = true;
        goto L8
    }

    public CJPayFaceProcessCallbackDialog(Context r100, CJPayFaceDialogAdapter.FaceDialogCallbackAction r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "action");
        super(r100, r110, false, 4, null);
        this.action = r101;
    }

    public /* synthetic */ CJPayFaceProcessCallbackDialog(Context r100, CJPayFaceDialogAdapter.FaceDialogCallbackAction r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = R.style.CJ_Pay_Dialog_With_Layer;
    L5:
        this(r100, r101, r102);
    }
}
