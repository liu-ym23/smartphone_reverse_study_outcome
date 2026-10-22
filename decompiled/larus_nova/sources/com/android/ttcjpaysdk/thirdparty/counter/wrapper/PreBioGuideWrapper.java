package com.android.ttcjpaysdk.thirdparty.counter.wrapper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.framework.BaseWrapper;
import com.android.ttcjpaysdk.base.service.ICJPaySecurityLoadingService;
import com.android.ttcjpaysdk.base.ui.CJPayNewLoadingWrapper;
import com.android.ttcjpaysdk.base.ui.Utils.CJPaySecurityLoadingHelper;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0013R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/counter/wrapper/PreBioGuideWrapper;", "Lcom/android/ttcjpaysdk/base/framework/BaseWrapper;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "backView", "Landroid/widget/ImageView;", "dividerLine", "loadingLayout", "loadingView", "panelRootView", "Landroid/widget/RelativeLayout;", "securityLoadingHelper", "Lcom/android/ttcjpaysdk/base/ui/Utils/CJPaySecurityLoadingHelper;", "tvTitle", "Landroid/widget/TextView;", "init", "", "height", "", "setHeightInPx", "showSecurityLoading", "isShow", "", "containerHeightDip", "bdpay-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PreBioGuideWrapper extends BaseWrapper {
    private final ImageView backView;
    private View dividerLine;
    private final View loadingLayout;
    private final View loadingView;
    private final RelativeLayout panelRootView;
    private CJPaySecurityLoadingHelper securityLoadingHelper;
    private final TextView tvTitle;

    public PreBioGuideWrapper(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
        this.panelRootView = (RelativeLayout) r100.findViewById(R.id.cj_pay_pre_bio_guide_root_view);
        this.tvTitle = (TextView) r100.findViewById(R.id.cj_pay_middle_title);
        this.backView = (ImageView) r100.findViewById(R.id.cj_pay_back_view);
        this.loadingLayout = r100.findViewById(R.id.cj_pay_loading_layout);
        this.loadingView = r100.findViewById(R.id.cj_pay_loading_view);
        this.dividerLine = r100.findViewById(R.id.cj_pay_bottom_divider_line);
    }

    public static final /* synthetic */ View access$getLoadingLayout$p(PreBioGuideWrapper r100) {
        return r100.loadingLayout;
    }

    public static final /* synthetic */ View access$getLoadingView$p(PreBioGuideWrapper r100) {
        return r100.loadingView;
    }

    public final void init(int r100) {
        setHeightInPx(r100);
        new CJPayNewLoadingWrapper(this.loadingLayout);
        this.backView.setVisibility(8);
        this.tvTitle.setText(getContext().getResources().getString(R.string.cj_pay_dy_pay));
        this.dividerLine.setVisibility(8);
        Context r101 = getContext();
        RelativeLayout r102 = this.panelRootView;
        this.securityLoadingHelper = new CJPaySecurityLoadingHelper(r101, r102, r102, 0.26f, null);
    }

    public final void setHeightInPx(int r100) {
        View r101 = getRootView();
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 == 516) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L11;
        r101 = null;
    L11:
        if (r101 == null) goto L18;
        ViewGroup.LayoutParams r103 = r101.getLayoutParams();
        if (r103 == null) goto L19;
        r103.height = CJPayBasicUtils.dipToPX(getContext(), r100);
        return;
    L19:
        return;
    L18:
        return;
    L7:
        r102 = false;
        goto L8
    }

    public final void showSecurityLoading(boolean r210, int r211) {
        Function2<Boolean, Boolean, Unit> r110 = new PreBioGuideWrapper$showSecurityLoading$defaultLoadingTask$1(this);
        CJPaySecurityLoadingHelper r100 = this.securityLoadingHelper;
        if (r100 == null) goto L5;
        CJPaySecurityLoadingHelper.showSecurityLoading$default(r100, r210, false, r110, ICJPaySecurityLoadingService.SecurityLoadingScene.SECURITY_LOADING_SCENE_NORMAL, null, null, null, false, r211, false, false, false, null, 7920, null);
        Unit r101 = Unit.INSTANCE;
    L6:
        if (r101 != null) goto L9;
        r110.invoke(Boolean.valueOf(r210), Boolean.FALSE);
        return;
    L9:
        return;
    L5:
        r101 = null;
        goto L6
    }
}
