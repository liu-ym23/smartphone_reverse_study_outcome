package com.obric.oui.titlebar.optimize;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.obric.aiagent.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.g;
import com.obric.oui.d.a.b;
import com.obric.oui.d.c;
import com.obric.oui.text.OBaseTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.l.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: OCTitleBar.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OCTitleBar extends RelativeLayout {
    private static final int BACK_ICON_RES = 0;
    public static final a Companion = null;
    private static final int SUB_TITLE_TEXT_COLOR = 0;
    public static final float SUB_TITLE_TEXT_SIZE = 12.5f;
    private static final String TAG = "OCTitleBar";
    private static final int TITLE_TEXT_COLOR = 0;
    public static final float TITLE_TEXT_SIZE = 16.0f;
    private boolean autoAdjustTitleSpace;
    private View mCenterView;
    private OButton mLeftActionBack;
    private View mLeftLastView;
    private List<View> mLeftViewList;
    private View mRightLastView;
    private List<View> mRightViewList;
    private TextView mSubTitleView;
    private TextView mTitleView;
    private final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
    private String subTitleText;
    private String titleText;

    /* JADX INFO: compiled from: OCTitleBar.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    public OCTitleBar(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OCTitleBar(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    /* JADX INFO: renamed from: lambda$oNtyMbcjyTrgLFSJN-wlYJawg1M, reason: not valid java name */
    public static /* synthetic */ void m1237lambda$oNtyMbcjyTrgLFSJNwlYJawg1M(OCTitleBar r0) {
        m1238onGlobalLayoutListener$lambda0(r0);
    }

    public /* synthetic */ OCTitleBar(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public static final /* synthetic */ int access$getBACK_ICON_RES$cp() {
        return BACK_ICON_RES;
    }

    public static final /* synthetic */ int access$getSUB_TITLE_TEXT_COLOR$cp() {
        return SUB_TITLE_TEXT_COLOR;
    }

    public static final /* synthetic */ int access$getTITLE_TEXT_COLOR$cp() {
        return TITLE_TEXT_COLOR;
    }

    public OCTitleBar(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7, r5);
        this.onGlobalLayoutListener = new $$Lambda$OCTitleBar$oNtyMbcjyTrgLFSJNwlYJawg1M(this);
        if (r7 == null) goto L6;
        initAttrs(r7);
    L6:
        if (isNeedListenGlobalLayout() == false) goto L9;
        addGlobalLayoutListener();
        return;
    }

    static {
        Companion = new a(null);
        BACK_ICON_RES = ZeusTransformUtils.mapRes(R.drawable.o_ic_titlebar_back, "drawable", "o_ic_titlebar_back");
        TITLE_TEXT_COLOR = ZeusTransformUtils.mapRes(R.color.oui_text_1, "color", "oui_text_1");
        SUB_TITLE_TEXT_COLOR = ZeusTransformUtils.mapRes(R.color.oui_text_3b, "color", "oui_text_3b");
    }

    public final View getMCenterView() {
        return this.mCenterView;
    }

    public final void setMCenterView(View r1) {
        this.mCenterView = r1;
    }

    public final View getMLeftLastView() {
        return this.mLeftLastView;
    }

    public final void setMLeftLastView(View r1) {
        this.mLeftLastView = r1;
    }

    public final View getMRightLastView() {
        return this.mRightLastView;
    }

    public final void setMRightLastView(View r1) {
        this.mRightLastView = r1;
    }

    public final List<View> getMLeftViewList() {
        return this.mLeftViewList;
    }

    public final void setMLeftViewList(List<View> r3) {
        this.mLeftViewList = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public final List<View> getMRightViewList() {
        return this.mRightViewList;
    }

    public final void setMRightViewList(List<View> r3) {
        this.mRightViewList = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public final OButton getMLeftActionBack() {
        return this.mLeftActionBack;
    }

    public final void setMLeftActionBack(OButton r1) {
        this.mLeftActionBack = r1;
    }

    public final TextView getMTitleView() {
        return this.mTitleView;
    }

    public final void setMTitleView(TextView r1) {
        this.mTitleView = r1;
    }

    public final String getTitleText() {
        return this.titleText;
    }

    public final void setTitleText(String r1) {
        this.titleText = r1;
        setCenterText(r1);
    }

    public final TextView getMSubTitleView() {
        return this.mSubTitleView;
    }

    public final void setMSubTitleView(TextView r1) {
        this.mSubTitleView = r1;
    }

    public final String getSubTitleText() {
        return this.subTitleText;
    }

    public final void setSubTitleText(String r1) {
        this.subTitleText = r1;
        setCenterSubText(r1);
    }

    private final TextView getSubtitleViewOrCreate() {
        TextView r0 = this.mSubTitleView;
        if (r0 == null) goto L6;
        o.a(r0);
        return r0;
    L6:
        this.mSubTitleView = generateSubTitleView();
        ViewGroup.LayoutParams r1 = generateDefaultLayoutParams();
        Objects.requireNonNull(r1, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams r2 = (RelativeLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r1, RelativeLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r2.addRule(14);
        r2.topMargin = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 30);
        addView((View) ZeusTransformUtils.preCheckCast(this.mSubTitleView, View.class, "com.obric.aiagent.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        TextView r4 = this.mSubTitleView;
        o.a(r4);
        return r4;
    }

    private final TextView getTitleViewOrCreate() {
        View r0 = this.mCenterView;
        if (r0 == null) goto L8;
        TextView r1 = this.mTitleView;
        if (r0 != r1) goto L8;
        o.a(r1);
        return r1;
    L8:
        if (this.mTitleView != null) goto L11;
        this.mTitleView = generateTitleView();
    L11:
        if (this.mCenterView == null) goto L13;
        removeCenterView();
    L13:
        addView((View) ZeusTransformUtils.preCheckCast(this.mTitleView, View.class, "com.obric.aiagent.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(generateCenterViewLayoutParams(), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        this.mCenterView = (View) ZeusTransformUtils.preCheckCast(this.mTitleView, View.class, "com.obric.aiagent.plugin");
        TextView r2 = this.mTitleView;
        o.a(r2);
        return r2;
    }

    private final List<View> getRightViewListOrCreate() {
        if (this.mRightViewList != null) goto L5;
        this.mRightViewList = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    L5:
        List<View> r3 = this.mRightViewList;
        o.a(r3);
        return r3;
    }

    private final List<View> getLeftViewListOrCreate() {
        if (this.mLeftViewList != null) goto L5;
        this.mLeftViewList = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    L5:
        List<View> r3 = this.mLeftViewList;
        o.a(r3);
        return r3;
    }

    /* JADX INFO: renamed from: onGlobalLayoutListener$lambda-0, reason: not valid java name */
    private static final void m1238onGlobalLayoutListener$lambda0(OCTitleBar r1) {
        o.e(r1, "this$0");
        r1.removeGlobalLayoutListener();
        if (r1.isNeedListenGlobalLayout() == true) goto L5;
        return;
    L5:
        r1.adjustTitleViewSpace("OnGlobalLayoutListener");
    }

    private final void addGlobalLayoutListener() {
        getViewTreeObserver().addOnGlobalLayoutListener(this.onGlobalLayoutListener);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        b.b(TAG, "addGlobalLayoutListener: ", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    private final void removeGlobalLayoutListener() {
        getViewTreeObserver().removeOnGlobalLayoutListener(this.onGlobalLayoutListener);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        b.b(TAG, "removeGlobalLayoutListener: ", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    private final void initAttrs(AttributeSet r7) {
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.aiagent.plugin");
        TypedArray r9 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getTheme().obtainStyledAttributes(r8, R.styleable.OCTitleBar, 0, 0);
        int r0 = r9.getInt(ZeusTransformUtils.mapRes(R.styleable.OCTitleBar_oui_title_pos, "styleable", "OCTitleBar_oui_title_pos"), com.obric.oui.titlebar.OCTitleBar.b.f36494a.a());
        com.obric.oui.titlebar.OCTitleBar.b r1 = com.obric.oui.titlebar.OCTitleBar.b.values()[r0];
        String r2 = r9.getString(ZeusTransformUtils.mapRes(R.styleable.OCTitleBar_oui_title_text, "styleable", "OCTitleBar_oui_title_text"));
        if (r2 == null) goto L6;
        setCenterText(r2);
    L6:
        if (r9.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OCTitleBar_oui_useBackIcon, "styleable", "OCTitleBar_oui_useBackIcon"), true) == false) goto L8;
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r3, "context");
        OButton r4 = com.obric.oui.titlebar.optimize.a.a(this, r3);
        r4.setButtonSourceBitmap(BACK_ICON_RES);
        setMLeftActionBack(r4);
        addLeftView((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin"));
    L8:
        String r5 = r9.getString(ZeusTransformUtils.mapRes(R.styleable.OCTitleBar_oui_sub_title_text, "styleable", "OCTitleBar_oui_sub_title_text"));
        if (r5 == null) goto L11;
        setCenterSubText(r5);
    L11:
        this.autoAdjustTitleSpace = r9.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OCTitleBar_oui_autoAdjustTitleSpace, "styleable", "OCTitleBar_oui_autoAdjustTitleSpace"), true);
        int r10 = (int) ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDimension(ZeusTransformUtils.mapRes(R.dimen.oui_p_title_bar_default, "dimen", "oui_p_title_bar_default"));
        setPadding(r10, 0, r10, 0);
    }

    private final boolean isNeedListenGlobalLayout() {
        return this.autoAdjustTitleSpace;
    }

    public final void setCenterView(View r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        setCenterView(r2, findLayoutParams(r2, true));
    }

    private final void setCenterView(View r3, RelativeLayout.LayoutParams r4) {
        if (o.a(this.mCenterView, r3) == false) goto L5;
        return;
    L5:
        removeCenterView();
        this.mCenterView = r3;
        addView(r3, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r4, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
    }

    public final void setCenterText(int r4) {
        setCenterText(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(r4));
    }

    private final void setCenterText(String r3) {
        getTitleViewOrCreate().setText((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"));
    }

    private final void setCenterSubText(String r4) {
        getSubtitleViewOrCreate().setText((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"));
        adjustTitlePosition();
    }

    private final void adjustTitlePosition() {
        TextView r0 = this.mTitleView;
        if (r0 != null) goto L6;
        return;
    L6:
        if (getMSubTitleView() == null) goto L14;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        Objects.requireNonNull(r1, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams r2 = (RelativeLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r1, RelativeLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r2.removeRule(13);
        r2.addRule(14);
        r2.topMargin = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 9);
        if (ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getConfiguration().fontScale <= 1.0f) goto L15;
        r2.topMargin = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 6);
        TextView r3 = getMSubTitleView();
        if (r3 == null) goto L17;
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        Objects.requireNonNull(r4, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams r5 = (RelativeLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r4, RelativeLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r5.topMargin = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 31);
        return;
    L17:
        return;
    L15:
        return;
    }

    private final void removeCenterView() {
        View r0 = this.mCenterView;
        if (r0 == null) goto L6;
        removeView(r0);
        this.mCenterView = null;
        return;
    }

    private final TextView generateTitleView() {
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r1, "context");
        OBaseTextView r6 = new OBaseTextView(r1, null, 0, 6, null);
        r6.setMaxLines(1);
        r6.setEllipsize(TextUtils.TruncateAt.END);
        r6.setTextAppearance(ZeusTransformUtils.mapRes(R.style.Title_Title_M_Thick, "style", "Title_Title_M_Thick"));
        r6.setTextColor(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getColor(TITLE_TEXT_COLOR));
        return (TextView) ZeusTransformUtils.preCheckCast(r6, TextView.class, "com.obric.aiagent.plugin");
    }

    private final TextView generateSubTitleView() {
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r1, "context");
        OBaseTextView r6 = new OBaseTextView(r1, null, 0, 6, null);
        r6.setMaxLines(1);
        r6.setEllipsize(TextUtils.TruncateAt.END);
        r6.setTextAppearance(ZeusTransformUtils.mapRes(R.style.Label_M, "style", "Label_M"));
        r6.setTextColor(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getColor(SUB_TITLE_TEXT_COLOR));
        return (TextView) ZeusTransformUtils.preCheckCast(r6, TextView.class, "com.obric.aiagent.plugin");
    }

    private final RelativeLayout.LayoutParams generateCenterViewLayoutParams() {
        ViewGroup.LayoutParams r2 = generateDefaultLayoutParams();
        Objects.requireNonNull(r2, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams r3 = (RelativeLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r2, RelativeLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r3.addRule(13);
        return r3;
    }

    public final void addLeftView(View r4) {
        o.e(r4, "view");
        addLeftView(r4, findLayoutParams(r4, false), getLeftViewCount(), 0);
    }

    public final void addLeftView(View r9, int r10) {
        o.e(r9, "view");
        addLeftView$default(this, r9, findLayoutParams(r9, false), r10, 0, 8, null);
    }

    public final void addLeftView(View r2, int r3, int r4) {
        o.e(r2, "view");
        addLeftView(r2, findLayoutParams(r2, false), r3, r4);
    }

    public static /* synthetic */ void addLeftView$default(OCTitleBar r0, View r1, RelativeLayout.LayoutParams r2, int r3, int r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = g.a((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"), 8);
    L5:
        r0.addLeftView(r1, r2, r3, r4);
    }

    public final void addLeftView(View r6, RelativeLayout.LayoutParams r7, int r8, int r9) {
        o.e(r6, "view");
        o.e(r7, "layoutParams");
        r7.alignWithParent = true;
        r7.leftMargin = r9;
        r6.setId(View.generateViewId());
        if (this.mLeftLastView != null) goto L5;
        r8 = 0;
        r7.addRule(9);
    L14:
        r7.addRule(15);
        List<View> r10 = this.mLeftViewList;
        if (r10 == null) goto L18;
        o.a(r10);
        if (r8 == r10.size()) goto L18;
    L19:
        getLeftViewListOrCreate().add(r8, r6);
        addView(r6, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r7, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return;
    L18:
        this.mLeftLastView = r6;
        goto L19
    L5:
        if (r8 < 0) goto L13;
        List<View> r11 = this.mLeftViewList;
        o.a(r11);
        if (r8 >= r11.size()) goto L13;
        if (r8 != 0) goto L12;
        r7.addRule(9);
        List<View> r3 = this.mLeftViewList;
        o.a(r3);
        ViewGroup.LayoutParams r4 = ((View) ZeusTransformUtils.preCheckCast(r3.get(r8), View.class, "com.obric.aiagent.plugin")).getLayoutParams();
        Objects.requireNonNull(r4, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams r12 = (RelativeLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r4, RelativeLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r12.removeRule(9);
        r12.addRule(1, r6.getId());
        goto L14
    L12:
        List<View> r1 = this.mLeftViewList;
        o.a(r1);
        View r2 = (View) ZeusTransformUtils.preCheckCast(r1.get(r8 - 1), View.class, "com.obric.aiagent.plugin");
        List<View> r5 = this.mLeftViewList;
        o.a(r5);
        View r13 = (View) ZeusTransformUtils.preCheckCast(r5.get(r8), View.class, "com.obric.aiagent.plugin");
        r7.addRule(1, r2.getId());
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        Objects.requireNonNull(r14, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        ((RelativeLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r14, RelativeLayout.LayoutParams.class, "com.obric.aiagent.plugin")).addRule(1, r6.getId());
    L13:
        List<View> r15 = this.mLeftViewList;
        o.a(r15);
        r8 = r15.size();
        View r16 = this.mLeftLastView;
        o.a(r16);
        r7.addRule(1, r16.getId());
        goto L14
    }

    public final void hideAllLeftView() {
        List<View> r3 = this.mLeftViewList;
        if (r3 == null) goto L9;
        Iterator<View> r4 = r3.iterator();
    L7:
        if (r4.hasNext() == false) goto L11;
        ((View) ZeusTransformUtils.preCheckCast(r4.next(), View.class, "com.obric.aiagent.plugin")).setVisibility(4);
        goto L7
    L11:
        return;
    }

    public final void removeAllLeftViews() {
        List<View> r0 = this.mLeftViewList;
        if (r0 == null) goto L12;
        Iterator<View> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        removeViewInLayout((View) ZeusTransformUtils.preCheckCast(r1.next(), View.class, "com.obric.aiagent.plugin"));
        goto L7
    L9:
        setMLeftLastView(null);
        List<View> r2 = getMLeftViewList();
        o.a(r2);
        r2.clear();
        requestLayout();
        return;
    }

    public final void removeLeftView(int r7) {
        if (r7 < 0) goto L18;
        List<View> r0 = this.mLeftViewList;
        o.a(r0);
        if (r7 < r0.size()) goto L7;
        return;
    L7:
        if (r7 != 0) goto L12;
        int r3 = r7 + 1;
        List<View> r4 = this.mLeftViewList;
        o.a(r4);
        if (r3 >= r4.size()) goto L11;
        List<View> r5 = this.mLeftViewList;
        o.a(r5);
        ViewGroup.LayoutParams r6 = ((View) ZeusTransformUtils.preCheckCast(r5.get(r3), View.class, "com.obric.aiagent.plugin")).getLayoutParams();
        Objects.requireNonNull(r6, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams r1 = (RelativeLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r6, RelativeLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r1.removeRule(1);
        r1.addRule(9);
    L16:
        List<View> r2 = this.mLeftViewList;
        o.a(r2);
        removeView((View) ZeusTransformUtils.preCheckCast(r2.get(r7), View.class, "com.obric.aiagent.plugin"));
        List<View> r8 = this.mLeftViewList;
        o.a(r8);
        r8.remove(r7);
        return;
    L11:
        this.mLeftLastView = null;
        goto L16
    L12:
        List<View> r9 = this.mLeftViewList;
        o.a(r9);
        if (r7 != (r9.size() - 1)) goto L15;
        List<View> r10 = this.mLeftViewList;
        o.a(r10);
        this.mLeftLastView = (View) ZeusTransformUtils.preCheckCast(r10.get(r7 - 1), View.class, "com.obric.aiagent.plugin");
        goto L16
    L15:
        List<View> r11 = this.mLeftViewList;
        o.a(r11);
        View r12 = (View) ZeusTransformUtils.preCheckCast(r11.get(r7 - 1), View.class, "com.obric.aiagent.plugin");
        List<View> r13 = this.mLeftViewList;
        o.a(r13);
        ViewGroup.LayoutParams r14 = ((View) ZeusTransformUtils.preCheckCast(r13.get(r7 + 1), View.class, "com.obric.aiagent.plugin")).getLayoutParams();
        Objects.requireNonNull(r14, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        ((RelativeLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r14, RelativeLayout.LayoutParams.class, "com.obric.aiagent.plugin")).addRule(1, r12.getId());
        goto L16
    }

    public final void hideAllRightView() {
        List<View> r3 = this.mRightViewList;
        if (r3 == null) goto L9;
        Iterator<View> r4 = r3.iterator();
    L7:
        if (r4.hasNext() == false) goto L11;
        ((View) ZeusTransformUtils.preCheckCast(r4.next(), View.class, "com.obric.aiagent.plugin")).setVisibility(4);
        goto L7
    L11:
        return;
    }

    public final void addRightView(View r9) {
        o.e(r9, "view");
        addRightView$default(this, r9, findLayoutParams(r9, false), 0, 0, 8, null);
    }

    public static /* synthetic */ void addRightView$default(OCTitleBar r0, View r1, RelativeLayout.LayoutParams r2, int r3, int r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = g.a((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"), 0);
    L5:
        r0.addRightView(r1, r2, r3, r4);
    }

    public final void addRightView(View r7, RelativeLayout.LayoutParams r8, int r9, int r10) {
        o.e(r7, "view");
        o.e(r8, "layoutParams");
        r8.alignWithParent = true;
        r7.setId(View.generateViewId());
        if (this.mRightLastView != null) goto L5;
        r8.rightMargin = r10;
        r8.addRule(11);
        r9 = 0;
    L14:
        r8.addRule(15);
        List<View> r11 = this.mRightViewList;
        if (r11 == null) goto L18;
        o.a(r11);
        if (r9 == r11.size()) goto L18;
    L19:
        getRightViewListOrCreate().add(r9, r7);
        addView(r7, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r8, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return;
    L18:
        this.mRightLastView = r7;
        goto L19
    L5:
        if (r9 < 0) goto L13;
        List<View> r0 = this.mRightViewList;
        o.a(r0);
        if (r9 >= r0.size()) goto L13;
        if (r9 != 0) goto L12;
        r8.rightMargin = r10;
        r8.addRule(11);
        List<View> r12 = this.mRightViewList;
        o.a(r12);
        ViewGroup.LayoutParams r13 = ((View) ZeusTransformUtils.preCheckCast(r12.get(r9), View.class, "com.obric.aiagent.plugin")).getLayoutParams();
        Objects.requireNonNull(r13, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams r14 = (RelativeLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r13, RelativeLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r14.removeRule(11);
        r14.addRule(0, r7.getId());
        goto L14
    L12:
        List<View> r1 = this.mRightViewList;
        o.a(r1);
        View r2 = (View) ZeusTransformUtils.preCheckCast(r1.get(r9 - 1), View.class, "com.obric.aiagent.plugin");
        List<View> r4 = this.mRightViewList;
        o.a(r4);
        View r5 = (View) ZeusTransformUtils.preCheckCast(r4.get(r9), View.class, "com.obric.aiagent.plugin");
        r8.addRule(0, r2.getId());
        r8.rightMargin = r10;
        ViewGroup.LayoutParams r15 = r5.getLayoutParams();
        Objects.requireNonNull(r15, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        ((RelativeLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r15, RelativeLayout.LayoutParams.class, "com.obric.aiagent.plugin")).addRule(0, r7.getId());
    L13:
        List<View> r16 = this.mRightViewList;
        o.a(r16);
        r9 = r16.size();
        View r3 = this.mRightLastView;
        o.a(r3);
        r8.addRule(0, r3.getId());
        r8.rightMargin = r10;
        goto L14
    }

    public final void removeAllRightViews() {
        List<View> r0 = this.mRightViewList;
        if (r0 == null) goto L12;
        Iterator<View> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        removeViewInLayout((View) ZeusTransformUtils.preCheckCast(r1.next(), View.class, "com.obric.aiagent.plugin"));
        goto L7
    L9:
        setMRightLastView(null);
        List<View> r2 = getMRightViewList();
        o.a(r2);
        r2.clear();
        requestLayout();
        invalidate();
        return;
    }

    public final void removeRightView(int r7) {
        if (r7 < 0) goto L18;
        List<View> r0 = this.mRightViewList;
        o.a(r0);
        if (r7 < r0.size()) goto L7;
        return;
    L7:
        if (r7 != 0) goto L12;
        int r3 = r7 + 1;
        List<View> r4 = this.mRightViewList;
        o.a(r4);
        if (r3 >= r4.size()) goto L11;
        List<View> r5 = this.mRightViewList;
        o.a(r5);
        ViewGroup.LayoutParams r6 = ((View) ZeusTransformUtils.preCheckCast(r5.get(r3), View.class, "com.obric.aiagent.plugin")).getLayoutParams();
        Objects.requireNonNull(r6, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams r1 = (RelativeLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r6, RelativeLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r1.removeRule(0);
        r1.addRule(11);
    L16:
        List<View> r2 = this.mRightViewList;
        o.a(r2);
        removeView((View) ZeusTransformUtils.preCheckCast(r2.get(r7), View.class, "com.obric.aiagent.plugin"));
        List<View> r8 = this.mRightViewList;
        o.a(r8);
        r8.remove(r7);
        return;
    L11:
        this.mRightLastView = null;
        goto L16
    L12:
        List<View> r9 = this.mRightViewList;
        o.a(r9);
        if (r7 != (r9.size() - 1)) goto L15;
        List<View> r10 = this.mRightViewList;
        o.a(r10);
        this.mRightLastView = (View) ZeusTransformUtils.preCheckCast(r10.get(r7 - 1), View.class, "com.obric.aiagent.plugin");
        goto L16
    L15:
        List<View> r11 = this.mRightViewList;
        o.a(r11);
        View r12 = (View) ZeusTransformUtils.preCheckCast(r11.get(r7 - 1), View.class, "com.obric.aiagent.plugin");
        List<View> r13 = this.mRightViewList;
        o.a(r13);
        ViewGroup.LayoutParams r14 = ((View) ZeusTransformUtils.preCheckCast(r13.get(r7 + 1), View.class, "com.obric.aiagent.plugin")).getLayoutParams();
        Objects.requireNonNull(r14, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        ((RelativeLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r14, RelativeLayout.LayoutParams.class, "com.obric.aiagent.plugin")).addRule(0, r12.getId());
        goto L16
    }

    public final boolean hasLeftView() {
        return hasView(this.mLeftViewList);
    }

    public final int getLeftViewCount() {
        return getViewCount(this.mLeftViewList);
    }

    public final View getLeftViewByIndex(int r2) {
        return getViewByIndex(r2, this.mLeftViewList);
    }

    public final boolean hasRightView() {
        return hasView(this.mRightViewList);
    }

    public final int getRightViewCount() {
        return getViewCount(this.mRightViewList);
    }

    public final View getRightViewByIndex(int r2) {
        return getViewByIndex(r2, this.mRightViewList);
    }

    private final void adjustTitleViewSpace(String r9) {
        Rect r0 = new Rect();
        Rect r1 = new Rect();
        List<View> r2 = this.mLeftViewList;
        if (r2 == null) goto L9;
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        View r4 = (View) ZeusTransformUtils.preCheckCast(r3.next(), View.class, "com.obric.aiagent.plugin");
        Rect r5 = new Rect();
        r4.getGlobalVisibleRect(r5);
        r0.union(r5.left, r5.top, r5.right, r5.bottom);
    L9:
        List<View> r6 = this.mRightViewList;
        if (r6 == null) goto L17;
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L14:
        if (r7.hasNext() == false) goto L17;
        View r8 = (View) ZeusTransformUtils.preCheckCast(r7.next(), View.class, "com.obric.aiagent.plugin");
        Rect r10 = new Rect();
        r8.getGlobalVisibleRect(r10);
        r1.union(r10.left, r10.top, r10.right, r10.bottom);
    L17:
        if (r0.isEmpty() == false) goto L19;
        int r11 = 0;
    L20:
        int r12 = n.c(r11, 0);
        if (r1.isEmpty() == false) goto L23;
        int r13 = 0;
    L24:
        int r14 = n.c(r13, 0);
        int r15 = Math.max(r12, r14);
        b.b(TAG, "adjustTitleViewSpace, scene: " + r9 + ", leftSpace: " + r12 + ", rightSpace: " + r14 + ", leftViewRectF: " + r0 + ", rightViewRectF: " + r1 + ", width: " + getWidth() + ", height: " + getHeight());
        if (r15 <= 0) goto L55;
        c r16 = c.f35012a;
        TextView r17 = this.mTitleView;
        ViewGroup.LayoutParams r18 = null;
        if (r17 != null) goto L29;
        ViewGroup.LayoutParams r19 = null;
    L30:
        if (r19 != null) goto L33;
    L31:
        r19 = null;
    L34:
        RelativeLayout.LayoutParams r20 = (RelativeLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r19, RelativeLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        if (r20 == null) goto L38;
        r20.leftMargin = r15;
        r20.rightMargin = r15;
    L38:
        c r21 = c.f35012a;
        TextView r22 = this.mSubTitleView;
        if (r22 != null) goto L41;
        ViewGroup.LayoutParams r23 = null;
    L42:
        if (r23 != null) goto L45;
    L47:
        RelativeLayout.LayoutParams r24 = (RelativeLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r18, RelativeLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        if (r24 == null) goto L51;
        r24.leftMargin = r15;
        r24.rightMargin = r15;
    L51:
        requestLayout();
        return;
    L45:
        if (ZeusTransformUtils.instanceOf(r23, RelativeLayout.LayoutParams.class) == false) goto L47;
        r18 = r23;
        goto L47
    L41:
        r23 = r22.getLayoutParams();
        goto L42
    L33:
        if (ZeusTransformUtils.instanceOf(r19, RelativeLayout.LayoutParams.class) == false) goto L31;
    L29:
        r19 = r17.getLayoutParams();
        goto L30
    L55:
        return;
    L23:
        r13 = getWidth() - r1.left;
        goto L24
    L19:
        r11 = r0.right;
        goto L20
    }

    private final boolean hasView(List<? extends View> r6) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
    L13:
        return false;
    L5:
        if (r5.size() <= 0) goto L13;
        int r1 = r5.size();
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L13;
        int r3 = r2 + 1;
        if (((View) ZeusTransformUtils.preCheckCast(r5.get(r2), View.class, "com.obric.aiagent.plugin")).getVisibility() != 8) goto L10;
        r2 = r3;
        goto L7
    L10:
        return true;
    }

    private final View getViewByIndex(int r7, List<? extends View> r8) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L16;
        if (r7 >= 0) goto L6;
        return null;
    L6:
        if (r7 >= r6.size()) goto L26;
        int r9 = r6.size();
        int r1 = 0;
        int r2 = 0;
    L8:
        if (r1 >= r9) goto L27;
        r1 = r1 + 1;
        View r3 = (View) ZeusTransformUtils.preCheckCast(r6.get(r1), View.class, "com.obric.aiagent.plugin");
        if (r3.getVisibility() == 8) goto L8;
        int r4 = r2 + 1;
        if (r7 == r2) goto L13;
        r2 = r4;
        goto L8
    L13:
        return r3;
    L27:
        return null;
    L26:
        return null;
    L16:
        return null;
    }

    private final int getViewCount(List<? extends View> r6) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        int r7 = 0;
        if (r5 != null) goto L5;
        return 0;
    L5:
        if (r5.size() <= 0) goto L18;
        int r1 = r5.size();
        int r2 = 0;
    L7:
        if (r7 >= r1) goto L13;
        int r3 = r7 + 1;
        if (((View) ZeusTransformUtils.preCheckCast(r5.get(r7), View.class, "com.obric.aiagent.plugin")).getVisibility() == 8) goto L11;
        r2 = r2 + 1;
    L11:
        r7 = r3;
        goto L7
    L13:
        return r2;
    L18:
        return 0;
    }

    private final RelativeLayout.LayoutParams findLayoutParams(View r3, boolean r4) {
        ViewGroup.LayoutParams r5 = r3.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r5, RelativeLayout.LayoutParams.class) == true) goto L10;
        if (r4 == false) goto L7;
        ViewGroup.LayoutParams r2 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(generateCenterViewLayoutParams(), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
    L8:
        Objects.requireNonNull(r2, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        return (RelativeLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r2, RelativeLayout.LayoutParams.class, "com.obric.aiagent.plugin");
    L7:
        r2 = generateDefaultLayoutParams();
        goto L8
    L10:
        return (RelativeLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r5, RelativeLayout.LayoutParams.class, "com.obric.aiagent.plugin");
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int r4, int r5) {
        super.onMeasure(r4, View.MeasureSpec.makeMeasureSpec((int) ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDimension(ZeusTransformUtils.mapRes(R.dimen.oui_h_title_bar_window, "dimen", "oui_h_title_bar_window")), 1073741824));
    }
}
