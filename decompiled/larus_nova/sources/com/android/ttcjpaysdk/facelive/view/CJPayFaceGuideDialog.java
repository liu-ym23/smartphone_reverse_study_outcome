package com.android.ttcjpaysdk.facelive.view;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.ktextension.CJPayViewExtensionsKt;
import com.android.ttcjpaysdk.base.ui.dialog.CJPayFadeAnimationDialog;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayDebouncingClickableSpan;
import com.android.ttcjpaysdk.base.utils.CJPayFakeBoldUtils;
import com.android.ttcjpaysdk.facelive.data.CJPayFacePanelPageConfigParams;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001#B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0013H\u0002J&\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\u0015H\u0002J\u0012\u0010\u001d\u001a\u00020\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\b\u0010 \u001a\u00020\u0013H\u0002J\u000e\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/android/ttcjpaysdk/facelive/view/CJPayFaceGuideDialog;", "Lcom/android/ttcjpaysdk/base/ui/dialog/CJPayFadeAnimationDialog;", "ctx", "Landroid/content/Context;", "action", "Lcom/android/ttcjpaysdk/facelive/view/CJPayFaceGuideDialog$FaceGuideDialogAction;", "themeResId", "", "(Landroid/content/Context;Lcom/android/ttcjpaysdk/facelive/view/CJPayFaceGuideDialog$FaceGuideDialogAction;I)V", "backView", "Landroid/widget/ImageView;", "confirmBtn", "Landroid/widget/TextView;", "confirmLoading", "Landroid/widget/ProgressBar;", "protocolView", "subTitleView", "titleView", "bindViews", "", "getBtnName", "", "initAction", "initViews", "isValidProtocol", "", "protocolDesc", "agreementDesc", "agreementUrl", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "setProtocol", "showBtnLoading", "isShow", "FaceGuideDialogAction", "bdpay-facecheck_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayFaceGuideDialog extends CJPayFadeAnimationDialog {
    private final FaceGuideDialogAction action;
    private ImageView backView;
    private TextView confirmBtn;
    private ProgressBar confirmLoading;
    private final Context ctx;
    private TextView protocolView;
    private TextView subTitleView;
    private TextView titleView;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u001c\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\bH&¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/facelive/view/CJPayFaceGuideDialog$FaceGuideDialogAction;", "", "getConfig", "Lcom/android/ttcjpaysdk/facelive/data/CJPayFacePanelPageConfigParams;", "onCancel", "", "onGotoCert", "buttonName", "", "onProtocolClick", "protocolDesc", "protocolUrl", "bdpay-facecheck_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface FaceGuideDialogAction {
        CJPayFacePanelPageConfigParams getConfig();

        void onCancel();

        void onGotoCert(String r100);

        void onProtocolClick(String r100, String r101);
    }

    private final String getBtnName() {
        return this.ctx.getResources().getString(R.string.cj_pay_face_guide_button_text_face_verify);
    }

    private final void initAction() {
        ImageView r100 = this.backView;
        if (r100 == null) goto L5;
        CJPayViewExtensionsKt.setDebouncingOnClickListener(r100, new AnonymousClass1(this));
    L5:
        TextView r101 = this.confirmBtn;
        if (r101 == null) goto L9;
        CJPayViewExtensionsKt.setDebouncingOnClickListener(r101, new AnonymousClass2(this));
        return;
    }

    private final void initViews() {
        CJPayFakeBoldUtils.fakeBold(this.titleView);
        CJPayFakeBoldUtils.fakeBold(this.confirmBtn);
        TextView r100 = this.titleView;
        String r101 = null;
        if (r100 == null) goto L17;
        CJPayFacePanelPageConfigParams r102 = this.action.getConfig();
        if (r102 == null) goto L15;
        String r103 = r102.main_title_desc;
        if (r103 == null) goto L15;
        if ((!StringsKt.isBlank(r103)) == true) goto L13;
        r103 = null;
    L13:
        if (r103 == null) goto L15;
    L16:
        r100.setText(r103);
    L15:
        r103 = this.ctx.getResources().getString(R.string.cj_pay_face_guide_title);
    L17:
        TextView r104 = this.subTitleView;
        if (r104 == null) goto L31;
        CJPayFacePanelPageConfigParams r105 = this.action.getConfig();
        if (r105 == null) goto L29;
        String r106 = r105.subhead_desc;
        if (r106 == null) goto L29;
        if ((!StringsKt.isBlank(r106)) == false) goto L27;
        r101 = r106;
    L27:
        if (r101 == null) goto L29;
    L30:
        r104.setText(r101);
    L29:
        r101 = this.ctx.getResources().getString(R.string.cj_pay_face_guide_sub_title);
    L31:
        TextView r107 = this.confirmBtn;
        if (r107 == null) goto L35;
        r107.setText(getBtnName());
    L35:
        setProtocol();
    }

    private final void setProtocol() {
        CJPayFacePanelPageConfigParams r100 = this.action.getConfig();     // Catch: Throwable -> L50
        Unit r101 = null;
        if (r100 == null) goto L6;
        String r102 = r100.signed_protocol_desc;     // Catch: Throwable -> L50
    L7:
        CJPayFacePanelPageConfigParams r103 = this.action.getConfig();     // Catch: Throwable -> L50
        if (r103 == null) goto L10;
        final String r104 = r103.agreement_desc;     // Catch: Throwable -> L50
    L11:
        CJPayFacePanelPageConfigParams r105 = this.action.getConfig();     // Catch: Throwable -> L50
        if (r105 == null) goto L14;
        final String r106 = r105.agreement_url;     // Catch: Throwable -> L50
    L15:
        int r107 = 0;
        String r108 = this.ctx.getResources().getString(R.string.cj_pay_face_guide_protocol_checkbox_with_sign, new Object[]{r104});     // Catch: Throwable -> L50
        if (r102 != null) goto L18;
    L24:
        TextView r109 = this.protocolView;     // Catch: Throwable -> L50
        if (r109 != null) goto L27;
    L44:
        if (r101 != null) goto L58;
        TextView r110 = this.protocolView;     // Catch: Throwable -> L50
        if (r110 == null) goto L59;
        r110.setVisibility(8);     // Catch: Throwable -> L50
        return;
    L59:
        return;
    L58:
        return;
    L27:
        if (isValidProtocol(r108, r104, r106) == true) goto L30;
        r109 = null;
    L30:
        if (r109 == null) goto L44;
        r109.setVisibility(0);     // Catch: Throwable -> L50
        CJPayDebouncingClickableSpan r111 = new CJPayFaceGuideDialog$setProtocol$2$clickProtocolSpan$1(this, r104, r106);     // Catch: Throwable -> L50
        String[] r112 = new String[1];     // Catch: Throwable -> L50
        if (r104 != null) goto L34;
        String r113 = "";
    L35:
        r112[0] = r113;     // Catch: Throwable -> L50
        List r114 = StringsKt.split$default(r108, r112, false, 0, 6, null);     // Catch: Throwable -> L50
        if (r114 == null) goto L40;
        String r115 = (String) CollectionsKt.getOrNull(r114, 0);     // Catch: Throwable -> L50
        if (r115 == null) goto L40;
        int r116 = r115.length();     // Catch: Throwable -> L50
    L41:
        if (r104 == null) goto L43;
        r107 = r104.length();     // Catch: Throwable -> L50
    L43:
        SpannableString r117 = new SpannableString(r108);     // Catch: Throwable -> L50
        r117.setSpan(r111, r116, r107 + r116, 33);     // Catch: Throwable -> L50
        r109.setMovementMethod(LinkMovementMethod.getInstance());     // Catch: Throwable -> L50
        r109.setHighlightColor(this.ctx.getResources().getColor(R.color.cj_pay_color_trans));     // Catch: Throwable -> L50
        r109.setText(r117);     // Catch: Throwable -> L50
        r101 = Unit.INSTANCE;     // Catch: Throwable -> L50
    L40:
        r116 = 0;
        goto L41
    L34:
        r113 = r104;
        goto L35
    L18:
        if ((!StringsKt.isBlank(r102)) == true) goto L21;
        r102 = null;
    L21:
        if (r102 == null) goto L24;
        r108 = r102;
        goto L24
    L14:
        r106 = null;
        goto L15
    L10:
        r104 = null;
        goto L11
    L6:
        r102 = null;
    L50:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayFaceGuideDialog#updateDrawState", th);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayFaceGuideDialog#updateDrawState", th);
        TextView r118 = this.protocolView;
        if (r118 == null) goto L61;
        r118.setVisibility(8);
        return;
    }

    private final void bindViews() {
        setContentView(LayoutInflater.from(getContext()).inflate(R.layout.cj_pay_view_face_guide_dialog, null));
        this.backView = (ImageView) findViewById(R.id.cj_pay_back_view);
        this.titleView = (TextView) findViewById(R.id.cj_pay_face_guide_title_view);
        this.subTitleView = (TextView) findViewById(R.id.cj_pay_face_guide_sub_title_view);
        this.protocolView = (TextView) findViewById(R.id.cj_pay_face_guide_protocol_text);
        this.confirmLoading = (ProgressBar) findViewById(R.id.cj_pay_face_dialog_agree_and_continue_loading);
        this.confirmBtn = (TextView) findViewById(R.id.cj_pay_face_guide_confirm_btn);
        this.confirmLoading = (ProgressBar) findViewById(R.id.cj_pay_face_guide_confirm_loading);
    }

    public static final /* synthetic */ FaceGuideDialogAction access$getAction$p(CJPayFaceGuideDialog r100) {
        return r100.action;
    }

    public static final /* synthetic */ String access$getBtnName(CJPayFaceGuideDialog r100) {
        return r100.getBtnName();
    }

    @Override // com.android.ttcjpaysdk.base.ui.dialog.CJPayFadeAnimationDialog, android.app.Dialog
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        bindViews();
        initViews();
        initAction();
    }

    public final void showBtnLoading(boolean r100) {
        if (r100 == false) goto L11;
        ProgressBar r101 = this.confirmLoading;
        if (r101 == null) goto L7;
        r101.setVisibility(0);
    L7:
        TextView r102 = this.confirmBtn;
        if (r102 == null) goto L21;
        r102.setText("");
        return;
    L21:
        return;
    L11:
        ProgressBar r103 = this.confirmLoading;
        if (r103 == null) goto L15;
        r103.setVisibility(8);
    L15:
        TextView r104 = this.confirmBtn;
        if (r104 == null) goto L22;
        r104.setText(getBtnName());
        return;
    }

    public CJPayFaceGuideDialog(Context r100, FaceGuideDialogAction r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        Intrinsics.checkNotNullParameter(r101, "action");
        super(r100, r110, false, 4, null);
        this.ctx = r100;
        this.action = r101;
    }

    private final boolean isValidProtocol(String r100, String r101, String r102) {
        if (r100 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L26;
        if (r101 != null) goto L12;
    L15:
        boolean r104 = true;
    L16:
        if (r104 == true) goto L27;
        if (r102 != null) goto L19;
    L22:
        boolean r105 = true;
    L23:
        if (r105 == true) goto L28;
        return true;
    L28:
        return false;
    L19:
        if (StringsKt.isBlank(r102) == true) goto L22;
        r105 = false;
        goto L23
    L27:
        return false;
    L12:
        if (StringsKt.isBlank(r101) == true) goto L15;
        r104 = false;
        goto L16
    L26:
        return false;
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r103 = false;
        goto L9
    }

    public /* synthetic */ CJPayFaceGuideDialog(Context r100, FaceGuideDialogAction r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = R.style.CJ_Pay_Dialog_With_Layer;
    L5:
        this(r100, r101, r102);
    }
}
