package com.android.ttcjpaysdk.facelive.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.ui.dialog.CJPayFadeAnimationDialog;
import com.android.ttcjpaysdk.base.utils.CJPayFakeBoldUtils;
import com.android.ttcjpaysdk.facelive.utils.CJPayFaceDialogAdapter;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0002J\u0012\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/android/ttcjpaysdk/facelive/view/CJPayFaceRetainOrFailDialog;", "Lcom/android/ttcjpaysdk/base/ui/dialog/CJPayFadeAnimationDialog;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "action", "Lcom/android/ttcjpaysdk/facelive/utils/CJPayFaceDialogAdapter$FaceDialogCallbackAction;", "themeResId", "", "(Landroid/content/Context;Lcom/android/ttcjpaysdk/facelive/utils/CJPayFaceDialogAdapter$FaceDialogCallbackAction;I)V", "leftBtnView", "Landroid/widget/TextView;", "rightBtnView", "subTitleView", "titleView", "bindViews", "", "initAction", "initViews", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "bdpay-facecheck_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayFaceRetainOrFailDialog extends CJPayFadeAnimationDialog {
    private final CJPayFaceDialogAdapter.FaceDialogCallbackAction action;
    private TextView leftBtnView;
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
        setCanceledOnTouchOutside(false);
    }

    private final void initViews() {
        CJPayFakeBoldUtils.fakeBold(this.titleView);
        CJPayFakeBoldUtils.fakeBold(this.rightBtnView);
        TextView r100 = this.titleView;
        if (r100 == null) goto L6;
        r100.setText(this.action.getTitleStr());
    L6:
        TextView r101 = this.subTitleView;
        if (r101 == null) goto L10;
        r101.setText(this.action.getSubTitleStr());
    L10:
        TextView r102 = this.leftBtnView;
        if (r102 == null) goto L14;
        r102.setText(this.action.getLeftStr());
    L14:
        TextView r103 = this.rightBtnView;
        if (r103 == null) goto L19;
        r103.setText(this.action.getRightStr());
        return;
    }

    private final void bindViews() {
        setContentView(LayoutInflater.from(getContext()).inflate(R.layout.cj_pay_view_face_retain_or_fail_dialog, null));
        this.titleView = (TextView) findViewById(R.id.cj_pay_face_retain_or_fail_dialog_title_view);
        this.subTitleView = (TextView) findViewById(R.id.cj_pay_face_retain_or_fail_dialog_sub_title_view);
        this.leftBtnView = (TextView) findViewById(R.id.cj_pay_face_retain_or_fail_dialog_left_btn_view);
        this.rightBtnView = (TextView) findViewById(R.id.cj_pay_face_retain_or_fail_dialog_right_btn_view);
    }

    public static final /* synthetic */ CJPayFaceDialogAdapter.FaceDialogCallbackAction access$getAction$p(CJPayFaceRetainOrFailDialog r100) {
        return r100.action;
    }

    @Override // com.android.ttcjpaysdk.base.ui.dialog.CJPayFadeAnimationDialog, android.app.Dialog
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        bindViews();
        initViews();
        initAction();
    }

    public CJPayFaceRetainOrFailDialog(Context r100, CJPayFaceDialogAdapter.FaceDialogCallbackAction r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "action");
        super(r100, r110, false, 4, null);
        this.action = r101;
    }

    public /* synthetic */ CJPayFaceRetainOrFailDialog(Context r100, CJPayFaceDialogAdapter.FaceDialogCallbackAction r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = R.style.CJ_Pay_Dialog_With_Layer;
    L5:
        this(r100, r101, r102);
    }
}
