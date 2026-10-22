package com.android.ttcjpaysdk.bindcard.base.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.android.ttcjpaysdk.base.framework.mvp.nothing.PresentorNothing;
import com.android.ttcjpaysdk.base.ktextension.CJPayViewExtensionsKt;
import com.android.ttcjpaysdk.base.mvp.base.MvpBaseLoggerDialogFragment;
import com.android.ttcjpaysdk.base.mvp.mvp.MvpModel;
import com.android.ttcjpaysdk.base.theme.widget.CJPayCircleCheckBox;
import com.android.ttcjpaysdk.base.theme.widget.CJPayCustomButton;
import com.android.ttcjpaysdk.base.utils.CJPayAnimationUtils;
import com.android.ttcjpaysdk.bindcard.base.applog.CJPayAgreementDialogLogger;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 22\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003234B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\"\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020%H\u0016J\n\u0010&\u001a\u0004\u0018\u00010'H\u0014J\b\u0010(\u001a\u00020\u001eH\u0016J\b\u0010)\u001a\u00020\u001eH\u0016J\b\u0010*\u001a\u00020\u001eH\u0002J\u0010\u0010+\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020#H\u0016J\b\u0010,\u001a\u00020\u001eH\u0016J\u0012\u0010-\u001a\u00020\u001e2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00100\u001a\u00020\u001eH\u0016J\u001a\u00101\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020#2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\b\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\b\u0015R[\u0010\u0016\u001aO\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012.\u0012,\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e0\u001b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/ui/CJPayAgreementDialog;", "Lcom/android/ttcjpaysdk/base/mvp/base/MvpBaseLoggerDialogFragment;", "Lcom/android/ttcjpaysdk/base/framework/mvp/nothing/PresentorNothing;", "Lcom/android/ttcjpaysdk/bindcard/base/applog/CJPayAgreementDialogLogger;", "()V", "agreeBtn", "Lcom/android/ttcjpaysdk/base/theme/widget/CJPayCustomButton;", "agreementSource", "Lcom/android/ttcjpaysdk/bindcard/base/applog/CJPayAgreementDialogLogger$AgreementSource;", "agreementSource$1", "agreementTextView", "Landroid/widget/TextView;", "btnAction", "Lcom/android/ttcjpaysdk/bindcard/base/ui/CJPayAgreementDialog$IBtnAction;", "checkbox", "Lcom/android/ttcjpaysdk/base/theme/widget/CJPayCircleCheckBox;", "disagreeBtn", "llAgreementView", "Landroid/widget/LinearLayout;", "scene", "Lcom/android/ttcjpaysdk/bindcard/base/ui/CJPayAgreementDialog$Scenes;", "scene$1", "setAgreement", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "view", "Lkotlin/Function1;", "", "agreementName", "", "action", "tvAgreement", "tvTitle", "bindViews", "Landroid/view/View;", "getLayoutId", "", "getModel", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpModel;", "initAction", "initData", "initViewText", "initViews", TeaEventTrack.ACTION_DRAMA_NEXT, WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onViewCreated", "Builder", "IBtnAction", "Scenes", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayAgreementDialog extends MvpBaseLoggerDialogFragment<PresentorNothing, CJPayAgreementDialogLogger> {
    public static final Builder Builder = null;
    private static CJPayAgreementDialogLogger.AgreementSource agreementSource;
    private static Scenes scene;
    private CJPayCustomButton agreeBtn;
    private CJPayAgreementDialogLogger.AgreementSource agreementSource$1;
    private TextView agreementTextView;
    private IBtnAction btnAction;
    private CJPayCircleCheckBox checkbox;
    private TextView disagreeBtn;
    private LinearLayout llAgreementView;
    private Scenes scene$1;
    private Function2<? super TextView, ? super Function1<? super String, Unit>, Unit> setAgreement;
    private TextView tvAgreement;
    private TextView tvTitle;

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Ja\u0010\u0007\u001a\u00020\b2Q\u0010\t\u001aM\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012.\u0012,\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00120\n2\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/ui/CJPayAgreementDialog$Builder;", "", "()V", "agreementSource", "Lcom/android/ttcjpaysdk/bindcard/base/applog/CJPayAgreementDialogLogger$AgreementSource;", "scene", "Lcom/android/ttcjpaysdk/bindcard/base/ui/CJPayAgreementDialog$Scenes;", "build", "Lcom/android/ttcjpaysdk/bindcard/base/ui/CJPayAgreementDialog;", "setAgreementView", "Lkotlin/Function2;", "Landroid/widget/TextView;", "Lkotlin/ParameterName;", "name", "view", "Lkotlin/Function1;", "", "agreementName", "", "action", "Lcom/android/ttcjpaysdk/bindcard/base/ui/CJPayAgreementDialog$IBtnAction;", "setAgreementSource", "setScene", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder {
        private Builder() {
        }

        public /* synthetic */ Builder(DefaultConstructorMarker r100) {
            this();
        }

        public final Builder setAgreementSource(CJPayAgreementDialogLogger.AgreementSource r100) {
            Intrinsics.checkNotNullParameter(r100, "agreementSource");
            CJPayAgreementDialog.access$setAgreementSource$cp(r100);
            return this;
        }

        public final Builder setScene(Scenes r100) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            CJPayAgreementDialog.access$setScene$cp(r100);
            return this;
        }

        public final CJPayAgreementDialog build(Function2<? super TextView, ? super Function1<? super String, Unit>, Unit> r100, IBtnAction r101) {
            Intrinsics.checkNotNullParameter(r100, "setAgreementView");
            Intrinsics.checkNotNullParameter(r101, "action");
            CJPayAgreementDialog r102 = new CJPayAgreementDialog();
            CJPayAgreementDialog.access$setScene$p(r102, CJPayAgreementDialog.access$getScene$cp());
            CJPayAgreementDialog.access$setAgreementSource$p(r102, CJPayAgreementDialog.access$getAgreementSource$cp());
            CJPayAgreementDialog.access$setSetAgreement$p(r102, r100);
            CJPayAgreementDialog.access$setBtnAction$p(r102, r101);
            return r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/ui/CJPayAgreementDialog$IBtnAction;", "", "agreeAction", "", "dialog", "Lcom/android/ttcjpaysdk/bindcard/base/ui/CJPayAgreementDialog;", "disagreeAction", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface IBtnAction {
        void agreeAction(CJPayAgreementDialog r100);

        void disagreeAction(CJPayAgreementDialog r100);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/ui/CJPayAgreementDialog$Scenes;", "", SocialConstants.PARAM_APP_DESC, "", "(Ljava/lang/String;ILjava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", "AN_AGREEMENT", "TWO_AGREEMENTS_CONTINUE", "TWO_AGREEMENTS_AUTH", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum Scenes extends Enum<Scenes> {
        private static final /* synthetic */ Scenes[] $VALUES = null;
        public static final Scenes AN_AGREEMENT = null;
        public static final Scenes TWO_AGREEMENTS_AUTH = null;
        public static final Scenes TWO_AGREEMENTS_CONTINUE = null;
        private String desc;

        private static final /* synthetic */ Scenes[] $values() {
            return new Scenes[]{AN_AGREEMENT, TWO_AGREEMENTS_CONTINUE, TWO_AGREEMENTS_AUTH};
        }

        public static Scenes valueOf(String r100) {
            return (Scenes) r27.a.a(Scenes.class, r100);
        }

        public static Scenes[] values() {
            return (Scenes[]) $VALUES.clone();
        }

        static {
            AN_AGREEMENT = new Scenes("AN_AGREEMENT", 0, "一个协议");
            TWO_AGREEMENTS_CONTINUE = new Scenes("TWO_AGREEMENTS_CONTINUE", 1, "两个协议（同意协议并继续）");
            TWO_AGREEMENTS_AUTH = new Scenes("TWO_AGREEMENTS_AUTH", 2, "两个协议（同意协议并授权）");
            $VALUES = $values();
        }

        public final String getDesc() {
            return this.desc;
        }

        public final void setDesc(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.desc = r100;
        }

        private Scenes(String r100, int r101, String r102) {
            super(r100, r101);
            this.desc = r102;
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[Scenes.values().length];
            r100[Scenes.TWO_AGREEMENTS_CONTINUE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[Scenes.TWO_AGREEMENTS_AUTH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r100;
        }
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseDialogFragment
    public int getLayoutId() {
        return R.layout.cj_pay_agreement_dialog_for_fragment;
    }

    @Override // com.android.ttcjpaysdk.base.mvp.base.MvpBaseLoggerDialogFragment
    public MvpModel getModel() {
        return null;
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseDialogFragment
    public void initData() {
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseDialogFragment
    public void next() {
    }

    static {
        Builder = new Builder(null);
        scene = Scenes.AN_AGREEMENT;
    }

    private final void initViewText() {
        Scenes r100 = this.scene$1;
        if (r100 != null) goto L5;
        int r101 = -1;
    L6:
        String r102 = "";
        if (r101 != 1) goto L9;
        FragmentActivity r103 = getActivity();
        if (r103 == null) goto L62;
        Resources r104 = r103.getResources();
        if (r104 == null) goto L62;
        String r105 = r104.getString(R.string.cj_pay_agreement_dialog_title2);
        if (r105 == null) goto L62;
    L63:
        FragmentActivity r106 = getActivity();
        if (r106 == null) goto L69;
        Resources r107 = r106.getResources();
        if (r107 == null) goto L69;
        String r108 = r107.getString(R.string.cj_pay_agreement_dialog_agree1);
        if (r108 == null) goto L69;
    L70:
        FragmentActivity r109 = getActivity();
        if (r109 == null) goto L78;
        Resources r110 = r109.getResources();
        if (r110 == null) goto L78;
        String r111 = r110.getString(R.string.cj_pay_agreement_dialog_disagree);
        if (r111 == null) goto L78;
        r102 = r111;
    L78:
        Triple r112 = new Triple(r105, r108, r102);
    L79:
        TextView r113 = this.tvTitle;
        if (r113 == null) goto L83;
        r113.setText((CharSequence) r112.getFirst());
    L83:
        CJPayCustomButton r114 = this.agreeBtn;
        if (r114 == null) goto L87;
        r114.setText((CharSequence) r112.getSecond());
    L87:
        TextView r115 = this.disagreeBtn;
        if (r115 == null) goto L92;
        r115.setText((CharSequence) r112.getThird());
        return;
    L92:
        return;
    L69:
        r108 = "";
    L62:
        r105 = "";
        goto L63
    L9:
        if (r101 == 2) goto L33;
        FragmentActivity r116 = getActivity();
        if (r116 == null) goto L16;
        Resources r117 = r116.getResources();
        if (r117 == null) goto L16;
        String r118 = r117.getString(R.string.cj_pay_agreement_dialog_title1);
        if (r118 == null) goto L16;
    L17:
        FragmentActivity r119 = getActivity();
        if (r119 == null) goto L23;
        Resources r120 = r119.getResources();
        if (r120 == null) goto L23;
        String r121 = r120.getString(R.string.cj_pay_agreement_dialog_agree1);
        if (r121 == null) goto L23;
    L24:
        FragmentActivity r122 = getActivity();
        if (r122 == null) goto L32;
        Resources r123 = r122.getResources();
        if (r123 == null) goto L32;
        String r124 = r123.getString(R.string.cj_pay_agreement_dialog_disagree);
        if (r124 == null) goto L32;
        r102 = r124;
    L32:
        r112 = new Triple(r118, r121, r102);
    L23:
        r121 = "";
    L16:
        r118 = "";
        goto L17
    L33:
        FragmentActivity r125 = getActivity();
        if (r125 == null) goto L39;
        Resources r126 = r125.getResources();
        if (r126 == null) goto L39;
        String r127 = r126.getString(R.string.cj_pay_agreement_dialog_title2);
        if (r127 == null) goto L39;
    L40:
        FragmentActivity r128 = getActivity();
        if (r128 == null) goto L46;
        Resources r129 = r128.getResources();
        if (r129 == null) goto L46;
        String r130 = r129.getString(R.string.cj_pay_agreement_dialog_agree2);
        if (r130 == null) goto L46;
    L47:
        FragmentActivity r131 = getActivity();
        if (r131 == null) goto L55;
        Resources r132 = r131.getResources();
        if (r132 == null) goto L55;
        String r133 = r132.getString(R.string.cj_pay_agreement_dialog_disagree);
        if (r133 == null) goto L55;
        r102 = r133;
    L55:
        r112 = new Triple(r127, r130, r102);
    L46:
        r130 = "";
    L39:
        r127 = "";
        goto L40
    L5:
        r101 = WhenMappings.$EnumSwitchMapping$0[r100.ordinal()];
        goto L6
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseDialogFragment
    public void initAction() {
        CJPayCustomButton r100 = this.agreeBtn;
        if (r100 == null) goto L5;
        CJPayViewExtensionsKt.setDebouncingOnClickListener(r100, new AnonymousClass1(this));
    L5:
        TextView r101 = this.disagreeBtn;
        if (r101 == null) goto L9;
        CJPayViewExtensionsKt.setDebouncingOnClickListener(r101, new AnonymousClass2(this));
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        CJPayAgreementDialogLogger.AgreementSource r100 = this.agreementSource$1;
        if (r100 == null) goto L7;
        CJPayAgreementDialogLogger r101 = getLogger();
        if (r101 == null) goto L7;
        r101.initParams(r100);
    L7:
        CJPayAgreementDialogLogger r102 = getLogger();
        if (r102 == null) goto L11;
        r102.show();
        return;
    }

    public CJPayAgreementDialog() {
    }

    public static final /* synthetic */ CJPayAgreementDialogLogger.AgreementSource access$getAgreementSource$cp() {
        return agreementSource;
    }

    public static final /* synthetic */ Scenes access$getScene$cp() {
        return scene;
    }

    public static final /* synthetic */ IBtnAction access$getBtnAction$p(CJPayAgreementDialog r100) {
        return r100.btnAction;
    }

    public static final /* synthetic */ CJPayAgreementDialogLogger access$getLogger(CJPayAgreementDialog r100) {
        return r100.getLogger();
    }

    public static final /* synthetic */ void access$setAgreementSource$cp(CJPayAgreementDialogLogger.AgreementSource r100) {
        agreementSource = r100;
    }

    public static final /* synthetic */ void access$setScene$cp(Scenes r100) {
        scene = r100;
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseDialogFragment
    public void bindViews(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.tvTitle = (TextView) r100.findViewById(R.id.title);
        this.llAgreementView = (LinearLayout) r100.findViewById(R.id.ll_agreement_container);
        this.tvAgreement = (TextView) r100.findViewById(R.id.cj_pay_agreement_content);
        this.checkbox = (CJPayCircleCheckBox) r100.findViewById(R.id.cj_pay_agreement_checkbox);
        this.agreementTextView = (TextView) r100.findViewById(R.id.cj_pay_agreement_content);
        this.agreeBtn = (CJPayCustomButton) r100.findViewById(R.id.agree_and_continue);
        this.disagreeBtn = (TextView) r100.findViewById(R.id.disagree);
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseDialogFragment
    public void initViews(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        setStatusBar();
        initViewText();
        Function2<? super TextView, ? super Function1<? super String, Unit>, Unit> r101 = this.setAgreement;
        if (r101 == null) goto L13;
        TextView r102 = this.tvAgreement;
        if (r102 == null) goto L14;
        r101.invoke(r102, new CJPayAgreementDialog$initViews$1$1$1(this));
        SpannableStringBuilder r103 = new SpannableStringBuilder(r102.getText());
        Context r104 = getContext();
        if (r104 == null) goto L10;
        String r105 = r104.getString(R.string.cj_pay_dy_protect_you);
        if (r105 == null) goto L10;
    L11:
        r102.setText(r103.append(r105));
        return;
    L10:
        r105 = "";
        goto L11
    L14:
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(1, R.style.CJ_Pay_Full_Dialog_Fragment_Style);
    }

    public static final /* synthetic */ void access$setAgreementSource$p(CJPayAgreementDialog r100, CJPayAgreementDialogLogger.AgreementSource r101) {
        r100.agreementSource$1 = r101;
    }

    public static final /* synthetic */ void access$setBtnAction$p(CJPayAgreementDialog r100, IBtnAction r101) {
        r100.btnAction = r101;
    }

    public static final /* synthetic */ void access$setScene$p(CJPayAgreementDialog r100, Scenes r101) {
        r100.scene$1 = r101;
    }

    public static final /* synthetic */ void access$setSetAgreement$p(CJPayAgreementDialog r100, Function2 r101) {
        r100.setAgreement = r101;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        CJPayAnimationUtils.fadeInOrOutAnimation(getRootView(), true, getActivity(), null, 200);
    }
}
