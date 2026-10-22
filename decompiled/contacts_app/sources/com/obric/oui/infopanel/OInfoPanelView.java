package com.obric.oui.infopanel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.infopanel.action.IOInfoPanelActionView;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: OInfoPanelView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n*\u0001\u000f\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u0017\u001a\u00020\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00180\u001aJ\u0006\u0010\u001b\u001a\u00020\nJ\u0006\u0010\u001c\u001a\u00020\u0013J\u0006\u0010\u001d\u001a\u00020\u0013J\b\u0010\u001e\u001a\u00020\u0018H\u0002J\u0016\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\u0018\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010$\u001a\u00020%J\u001a\u0010&\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\b2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010'J\u0010\u0010(\u001a\u00020\u00182\b\u0010)\u001a\u0004\u0018\u00010*J\u0016\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-J\u000e\u0010/\u001a\u00020\u00182\u0006\u00100\u001a\u00020-J\u0010\u00101\u001a\u00020\u00182\b\u0010)\u001a\u0004\u0018\u00010*J\u000e\u00102\u001a\u00020\u00182\u0006\u00103\u001a\u00020*J\u000e\u00104\u001a\u00020\u00182\u0006\u00100\u001a\u00020-J\b\u00105\u001a\u00020\u0018H\u0002J\b\u00106\u001a\u00020\u0018H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/obric/oui/infopanel/OInfoPanelView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "bottomView", "Landroid/view/View;", "contentContainer", "Landroid/view/ViewGroup;", "customContainer", "descContainer", "Landroidx/core/widget/NestedScrollView;", "fixDescHeightListener", "com/obric/oui/infopanel/OInfoPanelView$fixDescHeightListener$1", "Lcom/obric/oui/infopanel/OInfoPanelView$fixDescHeightListener$1;", "headerContainer", "ivImg", "Landroid/widget/ImageView;", "tvDesc", "Lcom/obric/oui/text/OTextView;", "tvTitle", "exImgOperation", "", "operation", "Lkotlin/Function1;", "getCustomContainer", "getTopBannerView", "getTopImgView", "insetTopImg", "setBottomActionView", "view", "Lcom/obric/oui/infopanel/action/IOInfoPanelActionView;", "params", "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "withTopMargin", "", "setCustomContent", "Landroid/view/ViewGroup$LayoutParams;", "setDesc", "desc", "", "setImgSize", MaterialConfigFormatNames.WIDTH, "", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "setInsetTopImg", "resId", "setScrollableDesc", "setTitle", "title", "setUnInsetImg", "showDevelopTips", "unInsetTopImg", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OInfoPanelView extends ConstraintLayout {
    private View bottomView;
    private final ViewGroup contentContainer;
    private final ViewGroup customContainer;
    private NestedScrollView descContainer;
    private final OInfoPanelView$fixDescHeightListener$1 fixDescHeightListener;
    private final ViewGroup headerContainer;
    private final ImageView ivImg;
    private final OTextView tvDesc;
    private final OTextView tvTitle;

    /* JADX WARN: Multi-variable type inference failed */
    public OInfoPanelView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, 2, 0 == true ? 1 : 0);
    }

    private final void showDevelopTips() {
    }

    public /* synthetic */ OInfoPanelView(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public static final /* synthetic */ View access$getBottomView$p(OInfoPanelView r0) {
        return r0.bottomView;
    }

    public static final /* synthetic */ NestedScrollView access$getDescContainer$p(OInfoPanelView r0) {
        return r0.descContainer;
    }

    public static final /* synthetic */ OTextView access$getTvDesc$p(OInfoPanelView r0) {
        return r0.tvDesc;
    }

    public static final /* synthetic */ void access$showDevelopTips(OInfoPanelView r0) {
        r0.showDevelopTips();
    }

    /* JADX WARN: Type inference failed for: r7v24, types: [com.obric.oui.infopanel.OInfoPanelView$fixDescHeightListener$1] */
    public OInfoPanelView(final Context r6, AttributeSet r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7);
        OInfoPanelView r8 = this;
        setMinimumHeight(OUnitExtensionKt.vdp(r8, 290));
        ConstraintLayout.inflate(r6, R.layout.o_info_panel_frame, this);
        ConstraintLayout.LayoutParams r1 = new ConstraintLayout.LayoutParams(-1, -2);
        setMinHeight(OUnitExtensionKt.vdp(r8, 290));
        setLayoutParams(r1);
        View r9 = findViewById(R.id.header_container);
        Intrinsics.checkNotNullExpressionValue(r9, "findViewById(R.id.header_container)");
        this.headerContainer = (ViewGroup) r9;
        View r10 = findViewById(R.id.content_container);
        Intrinsics.checkNotNullExpressionValue(r10, "findViewById(R.id.content_container)");
        this.contentContainer = (ViewGroup) r10;
        View r11 = findViewById(R.id.desc_container);
        Intrinsics.checkNotNullExpressionValue(r11, "findViewById(R.id.desc_container)");
        this.descContainer = (NestedScrollView) r11;
        View r12 = findViewById(R.id.custom_container);
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.custom_container)");
        this.customContainer = (ViewGroup) r12;
        View r13 = findViewById(R.id.iv_illustration);
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.iv_illustration)");
        this.ivImg = (ImageView) r13;
        View r14 = findViewById(R.id.tv_title);
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.tv_title)");
        this.tvTitle = (OTextView) r14;
        View r15 = findViewById(R.id.tv_desc);
        OTextView r0 = (OTextView) r15;
        r0.setLineHeight(MathKt.roundToInt(((double) r0.getTextSize()) * 1.4d));
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById<OTextView>(…4).roundToInt()\n        }");
        this.tvDesc = r0;
        this.fixDescHeightListener = new OInfoPanelView$fixDescHeightListener$1(this, r6);
    }

    private final void insetTopImg() {
        OInfoPanelView r1 = this;
        this.headerContainer.setPadding(0, OUnitExtensionKt.vdp(r1, 32), 0, 0);
        if (this.contentContainer.getLayoutParams() == null) goto L9;
        ViewGroup r5 = this.contentContainer;
        ViewGroup.LayoutParams r0 = r5.getLayoutParams();
        if (r0 == null) goto L8;
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r0;
        r2.setMargins(r2.leftMargin, OUnitExtensionKt.vdp(r1, 16), r2.rightMargin, r2.bottomMargin);
        r5.setLayoutParams(r2);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    private final void unInsetTopImg() {
        this.headerContainer.setPadding(0, 0, 0, 0);
        if (this.contentContainer.getLayoutParams() == null) goto L9;
        ViewGroup r0 = this.contentContainer;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L8;
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
        r2.setMargins(r2.leftMargin, OUnitExtensionKt.vdp(this, 24), r2.rightMargin, r2.bottomMargin);
        r0.setLayoutParams(r2);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final ImageView getTopBannerView() {
        unInsetTopImg();
        return this.ivImg;
    }

    public final ImageView getTopImgView() {
        insetTopImg();
        return this.ivImg;
    }

    public final void setInsetTopImg(int r1) {
        getTopBannerView().setImageResource(r1);
    }

    public final void setUnInsetImg(int r1) {
        getTopImgView().setImageResource(r1);
    }

    public final void setImgSize(int r2, int r3) {
        ImageView r1 = this.ivImg;
        ViewGroup.LayoutParams r0 = r1.getLayoutParams();
        if (r0 == null) goto L7;
        r0.width = r2;
        r0.height = r3;
        r1.setLayoutParams(r0);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final void exImgOperation(Function1<? super ImageView, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "operation");
        r2.invoke(this.ivImg);
    }

    public final ViewGroup getCustomContainer() {
        return this.customContainer;
    }

    public static /* synthetic */ void setCustomContent$default(OInfoPanelView r0, View r1, ViewGroup.LayoutParams r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.setCustomContent(r1, r2);
    }

    public final void setCustomContent(View r2, ViewGroup.LayoutParams r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        if (r3 == null) goto L5;
        this.customContainer.addView(r2, r3);
        return;
    L5:
        this.customContainer.addView(r2);
    }

    public final void setTitle(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "title");
        this.tvTitle.setText(r2);
    }

    public final void setDesc(CharSequence r2) {
        if (r2 != null) goto L8;
        ViewExtensionsKt.makeGone(this.tvDesc);
        ViewGroup.LayoutParams r1 = this.tvDesc.getLayoutParams();
        if (r1 == null) goto L7;
        ((ViewGroup.MarginLayoutParams) r1).topMargin = 0;
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L8:
        this.tvDesc.setText(r2);
        ViewExtensionsKt.makeVisible(this.tvDesc);
    }

    public final void setScrollableDesc(CharSequence r1) {
        setDesc(r1);
        getViewTreeObserver().addOnGlobalLayoutListener(this.fixDescHeightListener);
    }

    public static /* synthetic */ void setBottomActionView$default(OInfoPanelView r0, IOInfoPanelActionView r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        r0.setBottomActionView(r1, r2);
    }

    public final void setBottomActionView(IOInfoPanelActionView r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        View r6 = r4.getView();
        this.bottomView = r6;
        ConstraintLayout.LayoutParams r0 = new ConstraintLayout.LayoutParams(-1, -2);
        r0.startToStart = 0;
        r0.endToEnd = 0;
        r0.bottomToBottom = 0;
        r0.topToBottom = this.contentContainer.getId();
        r0.verticalBias = 1.0f;
        if (r5 == false) goto L5;
        r0.setMargins(0, OUnitExtensionKt.vdp(this, 12), 0, 0);
    L5:
        Unit r7 = Unit.INSTANCE;
        addView(r6, r0);
    }

    public final void setBottomActionView(IOInfoPanelActionView r2, ConstraintLayout.LayoutParams r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "params");
        View r4 = r2.getView();
        this.bottomView = r4;
        addView(r4, r3);
    }
}
