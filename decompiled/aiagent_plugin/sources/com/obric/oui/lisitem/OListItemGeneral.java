package com.obric.oui.lisitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.OneShotPreDrawListener;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.obric.oui.common.util.k;
import com.obric.oui.d.c;
import com.obric.oui.indicator.d;
import com.obric.oui.layout.OUIFrameLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: OListItemGeneral.kt */
/* JADX INFO: loaded from: classes4.dex */
public class OListItemGeneral extends OUIFrameLayout {
    private Drawable contentImage;
    public ConstraintLayout mClContent;
    public FrameLayout mContentElement;
    private float mContentElementWidth;
    public ImageView mIvContent;
    public FrameLayout mLeadingElement;
    public FrameLayout mTrailingElement;
    public TextView mTvSubtitle;
    public TextView mTvTitle;
    private boolean showBackground;
    private boolean showDivider;
    private boolean showPreDefineBackground;
    private CharSequence subTitleString;
    private CharSequence titleString;
    private Drawable trailingImage;

    /* JADX INFO: compiled from: View.kt */
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f35409a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f35410b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OListItemGeneral f35411c;

        public a(View r1, boolean r2, OListItemGeneral r3) {
            this.f35409a = r1;
            this.f35410b = r2;
            this.f35411c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f35410b == false) goto L5;
            OListItemGeneral r0 = this.f35411c;
            r0.updateBottomDivider(r0.getMClContent().getLeft(), 0, g.a((View) ZeusTransformUtils.preCheckCast(this.f35411c, View.class, "com.obric.aiagent.plugin"), 0.6d), ZeusTransformUtils.getResources(this.f35411c, "com.obric.aiagent.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_line_2, "color", "oui_line_2")));
            return;
        L5:
            OListItemGeneral r10 = this.f35411c;
            r10.updateBottomDivider(r10.getMClContent().getLeft(), 0, 0, ZeusTransformUtils.mapRes(R.color.oui_line_2, "color", "oui_line_2"));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OListItemGeneral(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, com.obric.oui.common.style.b
    public boolean shouldUpdateDividerColorOnPress() {
        return true;
    }

    public /* synthetic */ OListItemGeneral(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public OListItemGeneral(Context r10, AttributeSet r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r13 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r12, "context");
        super(r12, r13, 0, null, 12, null);
        init(r12, r13);
    }

    public final FrameLayout getMLeadingElement() {
        FrameLayout r0 = this.mLeadingElement;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("mLeadingElement");
        return null;
    }

    public final void setMLeadingElement(FrameLayout r2) {
        o.e(r2, "<set-?>");
        this.mLeadingElement = r2;
    }

    public final FrameLayout getMTrailingElement() {
        FrameLayout r0 = this.mTrailingElement;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("mTrailingElement");
        return null;
    }

    public final void setMTrailingElement(FrameLayout r2) {
        o.e(r2, "<set-?>");
        this.mTrailingElement = r2;
    }

    public final FrameLayout getMContentElement() {
        FrameLayout r0 = this.mContentElement;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("mContentElement");
        return null;
    }

    public final void setMContentElement(FrameLayout r2) {
        o.e(r2, "<set-?>");
        this.mContentElement = r2;
    }

    public final ImageView getMIvContent() {
        ImageView r0 = this.mIvContent;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("mIvContent");
        return null;
    }

    public final void setMIvContent(ImageView r2) {
        o.e(r2, "<set-?>");
        this.mIvContent = r2;
    }

    public final TextView getMTvTitle() {
        TextView r0 = this.mTvTitle;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("mTvTitle");
        return null;
    }

    public final void setMTvTitle(TextView r2) {
        o.e(r2, "<set-?>");
        this.mTvTitle = r2;
    }

    public final TextView getMTvSubtitle() {
        TextView r0 = this.mTvSubtitle;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("mTvSubtitle");
        return null;
    }

    public final void setMTvSubtitle(TextView r2) {
        o.e(r2, "<set-?>");
        this.mTvSubtitle = r2;
    }

    public final ConstraintLayout getMClContent() {
        ConstraintLayout r0 = this.mClContent;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("mClContent");
        return null;
    }

    public final void setMClContent(ConstraintLayout r2) {
        o.e(r2, "<set-?>");
        this.mClContent = r2;
    }

    public final CharSequence getTitleString() {
        return this.titleString;
    }

    public final void setTitleString(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.titleString = r4;
        getMTvTitle().setText(r4);
    }

    public final CharSequence getSubTitleString() {
        return this.subTitleString;
    }

    public final void setSubTitleString(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.subTitleString = r4;
        if (TextUtils.isEmpty(r4) == false) goto L5;
        k.b((View) ZeusTransformUtils.preCheckCast(getMTvSubtitle(), View.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        k.a((View) ZeusTransformUtils.preCheckCast(getMTvSubtitle(), View.class, "com.obric.aiagent.plugin"));
        getMTvSubtitle().setText(this.subTitleString);
    }

    public final Drawable getContentImage() {
        return this.contentImage;
    }

    public final void setContentImage(Drawable r2) {
        this.contentImage = r2;
        if (r2 == null) goto L5;
        getMIvContent().setImageDrawable(this.contentImage);
        getMIvContent().setVisibility(0);
        getMContentElement().setVisibility(0);
    L6:
        updateState();
        return;
    L5:
        getMIvContent().setVisibility(8);
        goto L6
    }

    public final Drawable getTrailingImage() {
        return this.trailingImage;
    }

    public final void setTrailingImage(Drawable r1) {
        this.trailingImage = r1;
        setTrailingImageView(r1);
    }

    public final void setShowBackground(boolean r1) {
        this.showBackground = r1;
        setShowPreDefineBackground(r1);
    }

    public final boolean getShowBackground() {
        return this.showPreDefineBackground;
    }

    public final boolean getShowPreDefineBackground() {
        return this.showPreDefineBackground;
    }

    public final void setShowPreDefineBackground(boolean r7) {
        this.showPreDefineBackground = r7;
        if (getBackground() == null) goto L5;
        return;
    L5:
        if (r7 == false) goto L7;
        Drawable r8 = (Drawable) ZeusTransformUtils.preCheckCast(new ColorDrawable(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_fill_list_item_card, "color", "oui_fill_list_item_card"), null)), Drawable.class, "com.obric.aiagent.plugin");
    L8:
        setBackground(r8);
        return;
    L7:
        r8 = (Drawable) ZeusTransformUtils.preCheckCast(null, Drawable.class, "com.obric.aiagent.plugin");
        goto L8
    }

    public final boolean getShowDivider() {
        return this.showDivider;
    }

    public final void setShowDivider(boolean r4) {
        this.showDivider = r4;
        View r0 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin");
        o.c(OneShotPreDrawListener.add(r0, (Runnable) ZeusTransformUtils.preCheckCast(new a(r0, r4, this), Runnable.class, "com.obric.aiagent.plugin")), "OneShotPreDrawListener.add(this) { action(this) }");
    }

    public final float getMContentElementWidth() {
        return this.mContentElementWidth;
    }

    public final void setMContentElementWidth(float r3) {
        this.mContentElementWidth = r3;
        if (r3 != 0.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        d.a((View) ZeusTransformUtils.preCheckCast(getMContentElement(), View.class, "com.obric.aiagent.plugin"), (int) r3);
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setAlpha(boolean r1) {
        if (r1 == true) goto L4;
        float r2 = 0.3f;
    L5:
        setAlpha(r2);
        return;
    L4:
        r2 = 1.0f;
        goto L5
    }

    public void inflateContent() {
        ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), ZeusTransformUtils.mapRes(R.layout.o_listitem_general, "layout", "o_listitem_general"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
    }

    private final void init(Context r6, AttributeSet r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.aiagent.plugin");
        inflateContent();
        ViewGroup r0 = (ViewGroup) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.ll_root, DbHelper.COL_ID, "ll_root")), ViewGroup.class, "com.obric.aiagent.plugin");
        c r3 = c.f35012a;
        if (r0 != null) goto L6;
    L4:
        r0 = null;
    L7:
        com.obric.oui.common.style.a r1 = (com.obric.oui.common.style.a) ZeusTransformUtils.preCheckCast(r0, com.obric.oui.common.style.a.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L11;
        r1.setChangeAlphaWhenPress(false);
    L11:
        View r2 = findViewById(ZeusTransformUtils.mapRes(R.id.fl_leading_element, DbHelper.COL_ID, "fl_leading_element"));
        o.c(r2, "findViewById(R.id.fl_leading_element)");
        setMLeadingElement((FrameLayout) ZeusTransformUtils.preCheckCast(r2, FrameLayout.class, "com.obric.aiagent.plugin"));
        View r4 = findViewById(ZeusTransformUtils.mapRes(R.id.fl_trailing_element, DbHelper.COL_ID, "fl_trailing_element"));
        o.c(r4, "findViewById(R.id.fl_trailing_element)");
        setMTrailingElement((FrameLayout) ZeusTransformUtils.preCheckCast(r4, FrameLayout.class, "com.obric.aiagent.plugin"));
        View r5 = findViewById(ZeusTransformUtils.mapRes(R.id.fl_content_element, DbHelper.COL_ID, "fl_content_element"));
        o.c(r5, "findViewById(R.id.fl_content_element)");
        setMContentElement((FrameLayout) ZeusTransformUtils.preCheckCast(r5, FrameLayout.class, "com.obric.aiagent.plugin"));
        View r10 = findViewById(ZeusTransformUtils.mapRes(R.id.iv_content_img, DbHelper.COL_ID, "iv_content_img"));
        o.c(r10, "findViewById(R.id.iv_content_img)");
        setMIvContent((ImageView) ZeusTransformUtils.preCheckCast(r10, ImageView.class, "com.obric.aiagent.plugin"));
        View r11 = findViewById(ZeusTransformUtils.mapRes(R.id.cl_content_container, DbHelper.COL_ID, "cl_content_container"));
        o.c(r11, "findViewById(R.id.cl_content_container)");
        setMClContent((ConstraintLayout) ZeusTransformUtils.preCheckCast(r11, ConstraintLayout.class, "com.obric.aiagent.plugin"));
        View r12 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_content_title, DbHelper.COL_ID, "tv_content_title"));
        o.c(r12, "findViewById(R.id.tv_content_title)");
        setMTvTitle((TextView) ZeusTransformUtils.preCheckCast(r12, TextView.class, "com.obric.aiagent.plugin"));
        View r13 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_content_subtitle, DbHelper.COL_ID, "tv_content_subtitle"));
        o.c(r13, "findViewById(R.id.tv_content_subtitle)");
        setMTvSubtitle((TextView) ZeusTransformUtils.preCheckCast(r13, TextView.class, "com.obric.aiagent.plugin"));
        TypedArray r14 = r8.obtainStyledAttributes(r9, R.styleable.OListItemGeneral);
        setTitleString((CharSequence) ZeusTransformUtils.preCheckCast(r14.getString(ZeusTransformUtils.mapRes(R.styleable.OListItemGeneral_oui_list_item_title, "styleable", "OListItemGeneral_oui_list_item_title")), CharSequence.class, "com.obric.aiagent.plugin"));
        setSubTitleString((CharSequence) ZeusTransformUtils.preCheckCast(r14.getString(ZeusTransformUtils.mapRes(R.styleable.OListItemGeneral_oui_list_item_subtitle, "styleable", "OListItemGeneral_oui_list_item_subtitle")), CharSequence.class, "com.obric.aiagent.plugin"));
        setTrailingImage(r14.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OListItemGeneral_oui_list_item_trailing_image, "styleable", "OListItemGeneral_oui_list_item_trailing_image")));
        setContentImage(r14.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OListItemGeneral_oui_list_item_content_image, "styleable", "OListItemGeneral_oui_list_item_content_image")));
        setShowPreDefineBackground(r14.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OListItemGeneral_oui_list_item_show_background, "styleable", "OListItemGeneral_oui_list_item_show_background"), true));
        setShowDivider(r14.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OListItemGeneral_oui_list_item_show_divider, "styleable", "OListItemGeneral_oui_list_item_show_divider"), false));
        setMContentElementWidth(r14.getDimension(ZeusTransformUtils.mapRes(R.styleable.OListItemGeneral_oui_list_item_content_width, "styleable", "OListItemGeneral_oui_list_item_content_width"), 0.0f));
        r14.recycle();
        setRadius((int) ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimension(ZeusTransformUtils.mapRes(R.dimen.oui_r_l3_rect, "dimen", "oui_r_l3_rect")));
        setChangeAlphaWhenDisable(false);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r0, com.obric.oui.common.style.a.class) == false) goto L4;
        goto L4
    }

    public final void setLeadingView(View r8) {
        if (r8 == null) goto L5;
        setChildToParent$default(this, (ViewGroup) ZeusTransformUtils.preCheckCast(getMLeadingElement(), ViewGroup.class, "com.obric.aiagent.plugin"), r8, null, 4, null);
        return;
    }

    public final void setTrailingView(View r5) {
        if (r5 == null) goto L5;
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-2, -2);
        r0.gravity = 8388629;
        setChildToParent((ViewGroup) ZeusTransformUtils.preCheckCast(getMTrailingElement(), ViewGroup.class, "com.obric.aiagent.plugin"), r5, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return;
    }

    public final void setTrailingView(View r4, ViewGroup.LayoutParams r5) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r5 != null) goto L6;
        FrameLayout.LayoutParams r6 = new FrameLayout.LayoutParams(-2, -2);
        r6.gravity = 8388629;
        r5 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r6, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
    L6:
        setChildToParent((ViewGroup) ZeusTransformUtils.preCheckCast(getMTrailingElement(), ViewGroup.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    public static /* synthetic */ void setChildToParent$default(OListItemGeneral r0, ViewGroup r1, View r2, ViewGroup.LayoutParams r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 4) == 0) goto L6;
        r3 = null;
    L6:
        r0.setChildToParent(r1, r2, r3);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setChildToParent");
    }

    public final void setChildToParent(ViewGroup r2, View r3, ViewGroup.LayoutParams r4) {
        if (r3 == null) goto L17;
        if (r2 == null) goto L7;
        k.a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"));
    L7:
        if (r2 == null) goto L10;
        r2.removeAllViews();
    L10:
        if (r4 != null) goto L14;
        if (r2 == null) goto L23;
        r2.addView(r3);
        return;
    L23:
        return;
    L14:
        if (r2 == null) goto L24;
        r2.addView(r3, r4);
        return;
    L24:
        return;
    L17:
        if (r2 == null) goto L25;
        k.b((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"));
        return;
    }

    public final void addChildToParent(ViewGroup r2, View r3) {
        if (r3 == null) goto L10;
        if (r2 == null) goto L7;
        k.a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"));
    L7:
        if (r2 == null) goto L15;
        r2.addView(r3);
        return;
    L15:
        return;
    L10:
        if (r2 == null) goto L16;
        k.b((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"));
        return;
    }

    public final void setTrailingImageView(Drawable r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        ImageView r0 = new ImageView((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        r0.setImageDrawable(r5);
        setTrailingView((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"));
    }

    public final boolean hasChildVisible(ViewGroup r4) {
        o.e(r4, "parent");
        int r3 = r4.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r3) goto L9;
        int r2 = r1 + 1;
        if (r4.getChildAt(r1).getVisibility() == 0) goto L6;
        r1 = r2;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public final void updateState() {
        if (hasChildVisible((ViewGroup) ZeusTransformUtils.preCheckCast(getMContentElement(), ViewGroup.class, "com.obric.aiagent.plugin")) == false) goto L5;
        d.a((View) ZeusTransformUtils.preCheckCast(getMContentElement(), View.class, "com.obric.aiagent.plugin"), getContentDefaultOneChildWidth());
    L7:
        if (this.mContentElementWidth != 0.0f) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == true) goto L13;
        d.a((View) ZeusTransformUtils.preCheckCast(getMContentElement(), View.class, "com.obric.aiagent.plugin"), (int) this.mContentElementWidth);
        return;
    L13:
        return;
    L9:
        r0 = false;
        goto L10
    L5:
        d.a((View) ZeusTransformUtils.preCheckCast(getMContentElement(), View.class, "com.obric.aiagent.plugin"), d.i.a.a(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimension(ZeusTransformUtils.mapRes(R.dimen.oui_listitem_content_width_empty, "dimen", "oui_listitem_content_width_empty"))));
        goto L7
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
    }

    public int getContentDefaultOneChildWidth() {
        return d.i.a.a(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimension(ZeusTransformUtils.mapRes(R.dimen.oui_listitem_content_width_middle, "dimen", "oui_listitem_content_width_middle")));
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r2) {
        o.e(r2, "event");
        if (isEnabled() == true) goto L7;
        return false;
    L7:
        return super.dispatchTouchEvent(r2);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setSelected(boolean r4) {
        super.setSelected(r4);
        getAlphaHelper().onSelectedChanged((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r4);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        if (r2 == false) goto L5;
        getMLeadingElement().setAlpha(1.0f);
        getMClContent().setAlpha(1.0f);
        getMContentElement().setAlpha(1.0f);
        return;
    L5:
        getMLeadingElement().setAlpha(0.3f);
        getMClContent().setAlpha(0.3f);
        getMContentElement().setAlpha(0.3f);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        setShowDivider(this.showDivider);
    }
}
