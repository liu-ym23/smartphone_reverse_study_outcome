package com.obric.oui.infopanel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.obric.oui.common.util.k;
import com.obric.oui.text.OTextView;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.b;
import d.h.b.h;
import d.h.b.o;
import d.i.a;
import d.x;
import java.util.Objects;

/* JADX INFO: compiled from: OInfoPanelView.kt */
/* JADX INFO: loaded from: classes4.dex */
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
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    private final void showDevelopTips() {
    }

    public /* synthetic */ OInfoPanelView(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
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

    /* JADX WARN: Type inference failed for: r8v47, types: [com.obric.oui.infopanel.OInfoPanelView$fixDescHeightListener$1] */
    public OInfoPanelView(Context r7, AttributeSet r8) {
        final Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r8, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r9, "context");
        super(r9, r10);
        setMinimumHeight(g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 290));
        ConstraintLayout.inflate(r9, ZeusTransformUtils.mapRes(R.layout.o_info_panel_frame, "layout", "o_info_panel_frame"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"));
        ConstraintLayout.LayoutParams r11 = new ConstraintLayout.LayoutParams(-1, -2);
        setMinHeight(g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 290));
        setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r11, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        View r12 = findViewById(ZeusTransformUtils.mapRes(R.id.header_container, DbHelper.COL_ID, "header_container"));
        o.c(r12, "findViewById(R.id.header_container)");
        this.headerContainer = (ViewGroup) ZeusTransformUtils.preCheckCast(r12, ViewGroup.class, "com.obric.aiagent.plugin");
        View r13 = findViewById(ZeusTransformUtils.mapRes(R.id.content_container, DbHelper.COL_ID, "content_container"));
        o.c(r13, "findViewById(R.id.content_container)");
        this.contentContainer = (ViewGroup) ZeusTransformUtils.preCheckCast(r13, ViewGroup.class, "com.obric.aiagent.plugin");
        View r14 = findViewById(ZeusTransformUtils.mapRes(R.id.desc_container, DbHelper.COL_ID, "desc_container"));
        o.c(r14, "findViewById(R.id.desc_container)");
        this.descContainer = (NestedScrollView) ZeusTransformUtils.preCheckCast(r14, NestedScrollView.class, "com.obric.aiagent.plugin");
        View r15 = findViewById(ZeusTransformUtils.mapRes(R.id.custom_container, DbHelper.COL_ID, "custom_container"));
        o.c(r15, "findViewById(R.id.custom_container)");
        this.customContainer = (ViewGroup) ZeusTransformUtils.preCheckCast(r15, ViewGroup.class, "com.obric.aiagent.plugin");
        View r16 = findViewById(ZeusTransformUtils.mapRes(R.id.iv_illustration, DbHelper.COL_ID, "iv_illustration"));
        o.c(r16, "findViewById(R.id.iv_illustration)");
        this.ivImg = (ImageView) ZeusTransformUtils.preCheckCast(r16, ImageView.class, "com.obric.aiagent.plugin");
        View r17 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_title, DbHelper.COL_ID, "tv_title"));
        o.c(r17, "findViewById(R.id.tv_title)");
        this.tvTitle = (OTextView) ZeusTransformUtils.preCheckCast(r17, OTextView.class, "com.obric.aiagent.plugin");
        View r18 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_desc, DbHelper.COL_ID, "tv_desc"));
        OTextView r0 = (OTextView) ZeusTransformUtils.preCheckCast(r18, OTextView.class, "com.obric.aiagent.plugin");
        r0.setLineHeight(a.a(((double) r0.getTextSize()) * 1.4d));
        o.c(r18, "findViewById<OTextView>(…4).roundToInt()\n        }");
        this.tvDesc = (OTextView) ZeusTransformUtils.preCheckCast(r18, OTextView.class, "com.obric.aiagent.plugin");
        this.fixDescHeightListener = new OInfoPanelView$fixDescHeightListener$1(this, r9);
    }

    private final void insetTopImg() {
        this.headerContainer.setPadding(0, g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 32), 0, 0);
        if (this.contentContainer.getLayoutParams() == null) goto L6;
        ViewGroup r0 = this.contentContainer;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        Objects.requireNonNull(r1, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        r2.setMargins(r2.leftMargin, g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 16), r2.rightMargin, r2.bottomMargin);
        r0.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return;
    }

    private final void unInsetTopImg() {
        this.headerContainer.setPadding(0, 0, 0, 0);
        if (this.contentContainer.getLayoutParams() == null) goto L6;
        ViewGroup r0 = this.contentContainer;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        Objects.requireNonNull(r1, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        r2.setMargins(r2.leftMargin, g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 24), r2.rightMargin, r2.bottomMargin);
        r0.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return;
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

    public final void setImgSize(int r3, int r4) {
        View r2 = (View) ZeusTransformUtils.preCheckCast(this.ivImg, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        Objects.requireNonNull(r0, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        r0.width = r3;
        r0.height = r4;
        r2.setLayoutParams(r0);
    }

    public final void exImgOperation(b<? super ImageView, x> r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        o.e(r4, "operation");
        r4.invoke(this.ivImg);
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
        o.e(r2, "view");
        if (r3 == null) goto L5;
        this.customContainer.addView(r2, r3);
        return;
    L5:
        this.customContainer.addView(r2);
    }

    public final void setTitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r4, DBDefinition.TITLE);
        this.tvTitle.setText(r4);
    }

    public final void setDesc(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        k.b((View) ZeusTransformUtils.preCheckCast(this.tvDesc, View.class, "com.obric.aiagent.plugin"));
        ViewGroup.LayoutParams r2 = this.tvDesc.getLayoutParams();
        Objects.requireNonNull(r2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin")).topMargin = 0;
        return;
    L5:
        this.tvDesc.setText(r4);
        k.a((View) ZeusTransformUtils.preCheckCast(this.tvDesc, View.class, "com.obric.aiagent.plugin"));
    }

    public final void setScrollableDesc(CharSequence r3) {
        setDesc((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"));
        getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener) ZeusTransformUtils.preCheckCast(this.fixDescHeightListener, ViewTreeObserver.OnGlobalLayoutListener.class, "com.obric.aiagent.plugin"));
    }

    public static /* synthetic */ void setBottomActionView$default(OInfoPanelView r1, com.obric.oui.infopanel.action.a r2, boolean r3, int r4, Object r5) {
        com.obric.oui.infopanel.action.a r6 = (com.obric.oui.infopanel.action.a) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.oui.infopanel.action.a.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = true;
    L5:
        r1.setBottomActionView(r6, r3);
    }

    public final void setBottomActionView(com.obric.oui.infopanel.action.a r5, boolean r6) {
        com.obric.oui.infopanel.action.a r7 = (com.obric.oui.infopanel.action.a) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.oui.infopanel.action.a.class, "com.obric.aiagent.plugin");
        o.e(r7, "view");
        View r8 = r7.getView();
        this.bottomView = r8;
        ConstraintLayout.LayoutParams r0 = new ConstraintLayout.LayoutParams(-1, -2);
        r0.startToStart = 0;
        r0.endToEnd = 0;
        r0.bottomToBottom = 0;
        r0.topToBottom = this.contentContainer.getId();
        r0.verticalBias = 1.0f;
        if (r6 == false) goto L5;
        r0.setMargins(0, g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12), 0, 0);
    L5:
        x r9 = x.f38692a;
        addView(r8, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
    }

    public final void setBottomActionView(com.obric.oui.infopanel.action.a r3, ConstraintLayout.LayoutParams r4) {
        com.obric.oui.infopanel.action.a r5 = (com.obric.oui.infopanel.action.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.infopanel.action.a.class, "com.obric.aiagent.plugin");
        o.e(r5, "view");
        o.e(r4, "params");
        View r6 = r5.getView();
        this.bottomView = r6;
        addView(r6, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r4, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
    }
}
