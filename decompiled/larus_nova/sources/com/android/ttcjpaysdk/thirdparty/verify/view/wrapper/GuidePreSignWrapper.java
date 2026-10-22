package com.android.ttcjpaysdk.thirdparty.verify.view.wrapper;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.framework.BaseWrapper;
import com.android.ttcjpaysdk.base.ui.component.CJSwitchView;
import com.android.ttcjpaysdk.base.ui.data.CJCommonRecommendInfo;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\u0010\nJ\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\bJ\b\u0010\u0013\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/verify/view/wrapper/GuidePreSignWrapper;", "Lcom/android/ttcjpaysdk/base/framework/BaseWrapper;", "contentView", "Landroid/view/View;", "commonRecommendInfo", "Lcom/android/ttcjpaysdk/base/ui/data/CJCommonRecommendInfo;", "onCheckedChanged", "Lkotlin/Function1;", "", "", "(Landroid/view/View;Lcom/android/ttcjpaysdk/base/ui/data/CJCommonRecommendInfo;Lkotlin/jvm/functions/Function1;)V", "switchLayout", "Landroid/widget/RelativeLayout;", "switchText", "Landroid/widget/TextView;", "switchView", "Lcom/android/ttcjpaysdk/base/ui/component/CJSwitchView;", "setChecked", "checked", "setListeners", "bdpay-verify_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GuidePreSignWrapper extends BaseWrapper {
    private final CJCommonRecommendInfo commonRecommendInfo;
    private final Function1<Boolean, Unit> onCheckedChanged;
    private final RelativeLayout switchLayout;
    private final TextView switchText;
    private final CJSwitchView switchView;

    private final void setListeners() {
        CJSwitchView r100 = this.switchView;
        if (r100 == null) goto L6;
        r100.setOnCheckedChangeListener(new AnonymousClass1(this));
        return;
    }

    public static final /* synthetic */ Function1 access$getOnCheckedChanged$p(GuidePreSignWrapper r100) {
        return r100.onCheckedChanged;
    }

    public final void setChecked(boolean r100) {
        CJSwitchView r101 = this.switchView;
        if (r101 == null) goto L6;
        r101.setIsChecked(r100);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GuidePreSignWrapper(View r100, CJCommonRecommendInfo r101, Function1<? super Boolean, Unit> r102) {
        Intrinsics.checkNotNullParameter(r101, "commonRecommendInfo");
        super(r100);
        this.commonRecommendInfo = r101;
        this.onCheckedChanged = r102;
        View r103 = null;
        if (r100 == null) goto L5;
        RelativeLayout r104 = (RelativeLayout) r100.findViewById(R.id.no_pwd_agreement_guide_layout_switch);
    L6:
        this.switchLayout = r104;
        if (r100 == null) goto L9;
        TextView r105 = (TextView) r100.findViewById(R.id.no_pwd_guide_text_agreement_switch);
    L10:
        this.switchText = r105;
        if (r100 == null) goto L13;
        CJSwitchView r106 = (CJSwitchView) r100.findViewById(R.id.no_pwd_guide_switch);
    L14:
        this.switchView = r106;
        if (r104 == null) goto L18;
        r104.setVisibility(0);
    L18:
        if (r100 == null) goto L20;
        View r107 = r100.findViewById(R.id.no_pwd_agreement_guide_layout_checkbox);
    L22:
        if (r107 == null) goto L25;
        r107.setVisibility(8);
    L25:
        if (r100 == null) goto L27;
        r103 = r100.findViewById(R.id.tv_next_open_and_pay);
    L27:
        if (r103 == null) goto L30;
        r103.setVisibility(8);
    L30:
        if (r105 == null) goto L33;
        r105.setText(r101.getRecommendDesc());
    L33:
        setChecked(r101.isRecommendChecked());
        setListeners();
        return;
    L20:
        r107 = null;
        goto L22
    L13:
        r106 = null;
        goto L14
    L9:
        r105 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }

    public /* synthetic */ GuidePreSignWrapper(View r100, CJCommonRecommendInfo r101, Function1 r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102);
    }
}
