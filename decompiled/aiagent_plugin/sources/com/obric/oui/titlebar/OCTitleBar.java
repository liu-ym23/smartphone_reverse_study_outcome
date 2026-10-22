package com.obric.oui.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.g;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.k;
import java.util.Objects;

/* JADX INFO: compiled from: OCTitleBar.kt */
/* JADX INFO: loaded from: classes4.dex */
public class OCTitleBar extends FrameLayout {
    public static final a Companion = null;
    public static final int STYLE_HIGHLIGHT_BLUE = 1;
    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_PRIMARY_BLUE = 2;
    private static final String TAG = "OCTitleBarLegacy";
    public ViewGroup fixedCenterTitleContainer;
    public FrameLayout mCenterContainer;
    private TextView mCenterTitleView;
    public FrameLayout mFixedCenterContainer;
    private TextView mFixedCenterSubTitleView;
    private TextView mFixedCenterTitleView;
    public OButton mLeftActionBack;
    public LinearLayout mLeftContainer;
    private TextView mLeftTitleView;
    public LinearLayout mRightContainer;
    private b mTitlePosition;
    private int minCenterTitleWidth;
    private boolean showLeftBack;
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

    /* JADX INFO: compiled from: OCTitleBar.kt */
    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f36494a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f36495b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f36496c = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ b[] f36497e = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f36498d;

        private static final /* synthetic */ b[] b() {
            return new b[]{f36494a, f36495b, f36496c};
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(f36497e.clone(), b[].class, "com.obric.aiagent.plugin");
        }

        private b(String r1, int r2, int r3) {
            super(r1, r2);
            this.f36498d = r3;
        }

        public final int a() {
            return this.f36498d;
        }

        static {
            f36494a = new b("FIXED_CENTER", 0, 0);
            f36495b = new b("FLOW_WITH_ACTION", 1, 1);
            f36496c = new b("LEFT_IN_ACTION", 2, 2);
            f36497e = b();
        }
    }

    /* JADX INFO: compiled from: OCTitleBar.kt */
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f36499a = null;

        static {
            int[] r0 = new int[b.values().length];
            r0[b.f36494a.ordinal()] = 1;
            r0[b.f36495b.ordinal()] = 2;
            r0[b.f36496c.ordinal()] = 3;
            f36499a = r0;
        }
    }

    static {
        Companion = new a(null);
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

    /* JADX INFO: renamed from: lambda$-Pk24BIuKqRC_mXJCv2Ml0bgcfM, reason: not valid java name */
    public static /* synthetic */ void m1205lambda$Pk24BIuKqRC_mXJCv2Ml0bgcfM(OCTitleBar r0) {
        m1208setMinCenterTitleWidth$lambda1(r0);
    }

    /* JADX INFO: renamed from: lambda$AsmVlZ-ppY0J1GApugPaAc-zCX4, reason: not valid java name */
    public static /* synthetic */ void m1206lambda$AsmVlZppY0J1GApugPaAczCX4(OCTitleBar r0) {
        m1207refreshTitleView$lambda2(r0);
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

    public OCTitleBar(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7, r5);
        this.minCenterTitleWidth = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 70);
        this.showLeftBack = true;
        this.mTitlePosition = b.f36494a;
        init(r6);
        if (r7 == null) goto L6;
        initAttrs(r7);
        return;
    }

    public final LinearLayout getMLeftContainer() {
        LinearLayout r0 = this.mLeftContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("mLeftContainer");
        return null;
    }

    public final void setMLeftContainer(LinearLayout r2) {
        o.e(r2, "<set-?>");
        this.mLeftContainer = r2;
    }

    public final LinearLayout getMRightContainer() {
        LinearLayout r0 = this.mRightContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("mRightContainer");
        return null;
    }

    public final void setMRightContainer(LinearLayout r2) {
        o.e(r2, "<set-?>");
        this.mRightContainer = r2;
    }

    public final FrameLayout getMCenterContainer() {
        FrameLayout r0 = this.mCenterContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("mCenterContainer");
        return null;
    }

    public final void setMCenterContainer(FrameLayout r2) {
        o.e(r2, "<set-?>");
        this.mCenterContainer = r2;
    }

    public final FrameLayout getMFixedCenterContainer() {
        FrameLayout r0 = this.mFixedCenterContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("mFixedCenterContainer");
        return null;
    }

    public final void setMFixedCenterContainer(FrameLayout r2) {
        o.e(r2, "<set-?>");
        this.mFixedCenterContainer = r2;
    }

    public final ViewGroup getFixedCenterTitleContainer() {
        ViewGroup r0 = this.fixedCenterTitleContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("fixedCenterTitleContainer");
        return null;
    }

    public final void setFixedCenterTitleContainer(ViewGroup r2) {
        o.e(r2, "<set-?>");
        this.fixedCenterTitleContainer = r2;
    }

    public final OButton getMLeftActionBack() {
        OButton r0 = this.mLeftActionBack;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("mLeftActionBack");
        return null;
    }

    public final void setMLeftActionBack(OButton r2) {
        o.e(r2, "<set-?>");
        this.mLeftActionBack = r2;
    }

    public final boolean getShowLeftBack() {
        return this.showLeftBack;
    }

    public final void setShowLeftBack(boolean r3) {
        this.showLeftBack = r3;
        OButton r0 = getMLeftActionBack();
        if (r3 == false) goto L5;
        int r4 = 0;
    L6:
        r0.setVisibility(r4);
        if (this.mTitlePosition != b.f36496c) goto L10;
        getMLeftActionBack().setVisibility(8);
        return;
    L10:
        return;
    L5:
        r4 = 8;
        goto L6
    }

    public final String getSubTitleText() {
        return this.subTitleText;
    }

    public final void setSubTitleText(String r6) {
        this.subTitleText = r6;
        TextView r1 = null;
        if (r6 != null) goto L9;
        TextView r5 = this.mFixedCenterSubTitleView;
        if (r5 != null) goto L7;
        o.c("mFixedCenterSubTitleView");
    L8:
        r1.setVisibility(8);
        return;
    L7:
        r1 = r5;
        goto L8
    L9:
        TextView r2 = this.mFixedCenterSubTitleView;
        if (r2 != null) goto L12;
        o.c("mFixedCenterSubTitleView");
        r2 = null;
    L12:
        r2.setVisibility(0);
        TextView r3 = this.mFixedCenterSubTitleView;
        if (r3 != null) goto L15;
        o.c("mFixedCenterSubTitleView");
        r3 = null;
    L15:
        r3.setText((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"));
        if (ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getConfiguration().fontScale <= 1.0f) goto L25;
        TextView r7 = this.mFixedCenterTitleView;
        if (r7 != null) goto L20;
        o.c("mFixedCenterTitleView");
        r7 = null;
    L20:
        r7.setTextSize(1, 16.0f);
        TextView r8 = this.mFixedCenterSubTitleView;
        if (r8 != null) goto L23;
        o.c("mFixedCenterSubTitleView");
    L24:
        r1.setTextSize(1, 12.0f);
        goto L25
    L23:
        r1 = r8;
    L25:
        refreshTitleViewIfNeeded();
    }

    public final String getTitleText() {
        return this.titleText;
    }

    public final void setTitleText(String r4) {
        this.titleText = r4;
        if (r4 != null) goto L5;
        getMTitleView().setVisibility(4);
        return;
    L5:
        getMTitleView().setVisibility(0);
        getMTitleView().setText((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"));
        refreshTitleViewIfNeeded();
    }

    public final TextView getMTitleView() {
        b r0 = this.mTitlePosition;
        int r1 = c.f36499a[r0.ordinal()];
        if (r1 != 1) goto L5;
        TextView r3 = this.mFixedCenterTitleView;
        if (r3 != null) goto L20;
        o.c("mFixedCenterTitleView");
        return null;
    L20:
        return r3;
    L5:
        if (r1 != 2) goto L7;
        r3 = this.mCenterTitleView;
        if (r3 != null) goto L20;
        o.c("mCenterTitleView");
        return null;
    L7:
        if (r1 != 3) goto L12;
        r3 = this.mLeftTitleView;
        if (r3 != null) goto L20;
        o.c("mLeftTitleView");
        return null;
    L12:
        throw new k();
    }

    public final b getMTitlePosition() {
        return this.mTitlePosition;
    }

    public final void setMTitlePosition(b r8) {
        o.e(r8, "value");
        this.mTitlePosition = r8;
        int r9 = c.f36499a[r8.ordinal()];
        TextView r6 = null;
        if (r9 != 1) goto L5;
        TextView r10 = this.mFixedCenterTitleView;
        if (r10 != null) goto L34;
        o.c("mFixedCenterTitleView");
        r10 = null;
    L34:
        r10.setVisibility(0);
        TextView r11 = this.mCenterTitleView;
        if (r11 != null) goto L37;
        o.c("mCenterTitleView");
        r11 = null;
    L37:
        r11.setVisibility(8);
        TextView r12 = this.mLeftTitleView;
        if (r12 != null) goto L40;
        o.c("mLeftTitleView");
    L41:
        r6.setVisibility(8);
    L42:
        getMTitleView().setText((CharSequence) ZeusTransformUtils.preCheckCast(this.titleText, CharSequence.class, "com.obric.aiagent.plugin"));
        return;
    L40:
        r6 = r12;
        goto L41
    L5:
        if (r9 != 2) goto L7;
        TextView r13 = this.mFixedCenterTitleView;
        if (r13 != null) goto L23;
        o.c("mFixedCenterTitleView");
        r13 = null;
    L23:
        r13.setVisibility(8);
        TextView r14 = this.mCenterTitleView;
        if (r14 != null) goto L26;
        o.c("mCenterTitleView");
        r14 = null;
    L26:
        r14.setVisibility(0);
        TextView r15 = this.mLeftTitleView;
        if (r15 != null) goto L29;
        o.c("mLeftTitleView");
    L30:
        r6.setVisibility(8);
        goto L42
    L29:
        r6 = r15;
        goto L30
    L7:
        if (r9 != 3) goto L42;
        TextView r16 = this.mFixedCenterTitleView;
        if (r16 != null) goto L12;
        o.c("mFixedCenterTitleView");
        r16 = null;
    L12:
        r16.setVisibility(8);
        TextView r17 = this.mCenterTitleView;
        if (r17 != null) goto L15;
        o.c("mCenterTitleView");
        r17 = null;
    L15:
        r17.setVisibility(8);
        TextView r18 = this.mLeftTitleView;
        if (r18 != null) goto L18;
        o.c("mLeftTitleView");
    L19:
        r6.setVisibility(0);
        setShowLeftBack(false);
        goto L42
    L18:
        r6 = r18;
        goto L19
    }

    private final void init(Context r5) {
        FrameLayout.inflate((Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.layout.o_title_bar_container, "layout", "o_title_bar_container"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"));
        View r6 = findViewById(ZeusTransformUtils.mapRes(R.id.center_title, DbHelper.COL_ID, "center_title"));
        o.c(r6, "findViewById(R.id.center_title)");
        this.mCenterTitleView = (TextView) ZeusTransformUtils.preCheckCast(r6, TextView.class, "com.obric.aiagent.plugin");
        View r7 = findViewById(ZeusTransformUtils.mapRes(R.id.left_title, DbHelper.COL_ID, "left_title"));
        o.c(r7, "findViewById(R.id.left_title)");
        this.mLeftTitleView = (TextView) ZeusTransformUtils.preCheckCast(r7, TextView.class, "com.obric.aiagent.plugin");
        View r8 = findViewById(ZeusTransformUtils.mapRes(R.id.ll_left_action_container, DbHelper.COL_ID, "ll_left_action_container"));
        o.c(r8, "findViewById(R.id.ll_left_action_container)");
        setMLeftContainer((LinearLayout) ZeusTransformUtils.preCheckCast(r8, LinearLayout.class, "com.obric.aiagent.plugin"));
        View r9 = findViewById(ZeusTransformUtils.mapRes(R.id.ll_right_action_container, DbHelper.COL_ID, "ll_right_action_container"));
        o.c(r9, "findViewById(R.id.ll_right_action_container)");
        setMRightContainer((LinearLayout) ZeusTransformUtils.preCheckCast(r9, LinearLayout.class, "com.obric.aiagent.plugin"));
        View r10 = findViewById(ZeusTransformUtils.mapRes(R.id.fl_center_action_container, DbHelper.COL_ID, "fl_center_action_container"));
        o.c(r10, "findViewById(R.id.fl_center_action_container)");
        setMCenterContainer((FrameLayout) ZeusTransformUtils.preCheckCast(r10, FrameLayout.class, "com.obric.aiagent.plugin"));
        View r11 = findViewById(ZeusTransformUtils.mapRes(R.id.fl_fixed_center_action_container, DbHelper.COL_ID, "fl_fixed_center_action_container"));
        o.c(r11, "findViewById(R.id.fl_fix…_center_action_container)");
        setMFixedCenterContainer((FrameLayout) ZeusTransformUtils.preCheckCast(r11, FrameLayout.class, "com.obric.aiagent.plugin"));
        View r12 = findViewById(ZeusTransformUtils.mapRes(R.id.fixed_center_title, DbHelper.COL_ID, "fixed_center_title"));
        o.c(r12, "findViewById(R.id.fixed_center_title)");
        this.mFixedCenterTitleView = (TextView) ZeusTransformUtils.preCheckCast(r12, TextView.class, "com.obric.aiagent.plugin");
        View r13 = findViewById(ZeusTransformUtils.mapRes(R.id.left_action_back, DbHelper.COL_ID, "left_action_back"));
        o.c(r13, "findViewById(R.id.left_action_back)");
        setMLeftActionBack((OButton) ZeusTransformUtils.preCheckCast(r13, OButton.class, "com.obric.aiagent.plugin"));
        View r14 = findViewById(ZeusTransformUtils.mapRes(R.id.fixed_center_sub_title, DbHelper.COL_ID, "fixed_center_sub_title"));
        o.c(r14, "findViewById(R.id.fixed_center_sub_title)");
        this.mFixedCenterSubTitleView = (TextView) ZeusTransformUtils.preCheckCast(r14, TextView.class, "com.obric.aiagent.plugin");
        View r15 = findViewById(ZeusTransformUtils.mapRes(R.id.fixed_center_title_container, DbHelper.COL_ID, "fixed_center_title_container"));
        o.c(r15, "findViewById(R.id.fixed_center_title_container)");
        setFixedCenterTitleContainer((ViewGroup) ZeusTransformUtils.preCheckCast(r15, ViewGroup.class, "com.obric.aiagent.plugin"));
    }

    private final void initAttrs(AttributeSet r5) {
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        TypedArray r7 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getTheme().obtainStyledAttributes(r6, R.styleable.OCTitleBar, 0, 0);
        int r1 = r7.getInt(ZeusTransformUtils.mapRes(R.styleable.OCTitleBar_oui_title_pos, "styleable", "OCTitleBar_oui_title_pos"), b.f36494a.a());     // Catch: Throwable -> L6
        setMTitlePosition(b.values()[r1]);     // Catch: Throwable -> L6
        setTitleText(r7.getString(ZeusTransformUtils.mapRes(R.styleable.OCTitleBar_oui_title_text, "styleable", "OCTitleBar_oui_title_text")));     // Catch: Throwable -> L6
        setShowLeftBack(r7.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OCTitleBar_oui_useBackIcon, "styleable", "OCTitleBar_oui_useBackIcon"), true));     // Catch: Throwable -> L6
        setSubTitleText(r7.getString(ZeusTransformUtils.mapRes(R.styleable.OCTitleBar_oui_sub_title_text, "styleable", "OCTitleBar_oui_sub_title_text")));     // Catch: Throwable -> L6
        r7.recycle();
        return;
    L6:
        th = move-exception;
        r7.recycle();
        throw th;
    }

    public final OButton createNeutralButton(Context r4, ViewGroup r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        o.e(r5, "root");
        return createButton(r6, r5, ZeusTransformUtils.mapRes(R.layout.o_widget_titlebar_button_neutral, "layout", "o_widget_titlebar_button_neutral"));
    }

    public final OButton createPrimaryLightButton(Context r4, ViewGroup r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        o.e(r5, "root");
        return createButton(r6, r5, ZeusTransformUtils.mapRes(R.layout.o_widget_titlebar_primarylight_button, "layout", "o_widget_titlebar_primarylight_button"));
    }

    public final OButton createTransButton(Context r4, ViewGroup r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        o.e(r5, "root");
        return createButton(r6, r5, ZeusTransformUtils.mapRes(R.layout.o_widget_titlebar_trans_button, "layout", "o_widget_titlebar_trans_button"));
    }

    public final OButton createTransIconButton(Context r4, ViewGroup r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        o.e(r5, "root");
        return createButton(r6, r5, ZeusTransformUtils.mapRes(R.layout.o_widget_titlebar_trans_icon_button, "layout", "o_widget_titlebar_trans_icon_button"));
    }

    public final OButton createPrimaryButton(Context r4, ViewGroup r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        o.e(r5, "root");
        return createButton(r6, r5, ZeusTransformUtils.mapRes(R.layout.o_widget_titlebar_primary_button, "layout", "o_widget_titlebar_primary_button"));
    }

    public final OButton createButton(Context r5, ViewGroup r6, int r7) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        o.e(r6, "root");
        if (((OButton) ZeusTransformUtils.preCheckCast(r6.findViewById(ZeusTransformUtils.mapRes(R.id.btn_titlebar, DbHelper.COL_ID, "btn_titlebar")), OButton.class, "com.obric.aiagent.plugin")) != null) goto L5;
        View r8 = FrameLayout.inflate(r4, r7, r6).findViewById(ZeusTransformUtils.mapRes(R.id.btn_titlebar, DbHelper.COL_ID, "btn_titlebar"));
        o.a(r8);
        return (OButton) ZeusTransformUtils.preCheckCast(r8, OButton.class, "com.obric.aiagent.plugin");
    L5:
        View r9 = ZeusTransformUtils.inflate(LayoutInflater.from(r4), r7, r6, false, "com.obric.aiagent.plugin");
        Objects.requireNonNull(r9, "null cannot be cast to non-null type com.obric.oui.button.OButton");
        OButton r10 = (OButton) ZeusTransformUtils.preCheckCast(r9, OButton.class, "com.obric.aiagent.plugin");
        r10.setId(-1);
        r6.addView((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.aiagent.plugin"));
        return r10;
    }

    public final ImageView addLeftImageView(int r5) {
        ImageView r0 = new ImageView((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        r0.setImageResource(r5);
        getMLeftContainer().addView((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"));
        return r0;
    }

    public final ImageView addRightImageView(int r5) {
        ImageView r0 = new ImageView((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        r0.setImageResource(r5);
        getMRightContainer().addView((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"));
        return r0;
    }

    public final OButton addRightButton(int r4, int r5) {
        if (r4 != 0) goto L5;
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r6, "context");
        OButton r3 = createNeutralButton(r6, (ViewGroup) ZeusTransformUtils.preCheckCast(getMRightContainer(), ViewGroup.class, "com.obric.aiagent.plugin"));
    L12:
        r3.setText(r5);
        return r3;
    L5:
        if (r4 != 1) goto L7;
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r7, "context");
        r3 = createPrimaryLightButton(r7, (ViewGroup) ZeusTransformUtils.preCheckCast(getMRightContainer(), ViewGroup.class, "com.obric.aiagent.plugin"));
        goto L12
    L7:
        if (r4 == 2) goto L9;
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r8, "context");
        r3 = createPrimaryLightButton(r8, (ViewGroup) ZeusTransformUtils.preCheckCast(getMRightContainer(), ViewGroup.class, "com.obric.aiagent.plugin"));
        goto L12
    L9:
        Context r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r9, "context");
        r3 = createPrimaryButton(r9, (ViewGroup) ZeusTransformUtils.preCheckCast(getMRightContainer(), ViewGroup.class, "com.obric.aiagent.plugin"));
        goto L12
    }

    public final OButton addRightTransButton(int r5) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r0, "context");
        OButton r4 = createTransButton(r0, (ViewGroup) ZeusTransformUtils.preCheckCast(getMRightContainer(), ViewGroup.class, "com.obric.aiagent.plugin"));
        r4.setButtonSourceBitmap(r5);
        return r4;
    }

    public final void setCenterText(int r2) {
        String r3 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getString(r2);
        o.c(r3, "resources.getString(resId)");
        setTitleText(r3);
    }

    public final void setCenterText(String r2) {
        o.e(r2, DBDefinition.TITLE);
        setTitleText(r2);
    }

    public final TextView getTitleView() {
        return getMTitleView();
    }

    public final void removeAllLeftViews() {
        getMLeftContainer().removeAllViews();
    }

    public final void addLeftView(View r2) {
        o.e(r2, "view");
        getMLeftContainer().addView(r2);
    }

    public final void addRightView(View r2) {
        o.e(r2, "view");
        getMRightContainer().addView(r2);
    }

    public final void removeAllRightViews() {
        getMRightContainer().removeAllViews();
    }

    public final void startTitleMarquee() {
        com.obric.oui.d.h r0 = com.obric.oui.d.h.f35017a;
        TextView r1 = this.mFixedCenterTitleView;
        if (r1 != null) goto L5;
        o.c("mFixedCenterTitleView");
        r1 = null;
    L5:
        r0.a(r1);
    }

    public final void stopTitleMarquee() {
        com.obric.oui.d.h r0 = com.obric.oui.d.h.f35017a;
        TextView r1 = this.mFixedCenterTitleView;
        if (r1 != null) goto L5;
        o.c("mFixedCenterTitleView");
        r1 = null;
    L5:
        r0.b(r1);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r7, int r8) {
        super.onMeasure(r7, r8);
        int r0 = 0;
        TextView r2 = null;
        if (this.mTitlePosition != b.f36496c) goto L35;
        TextView r9 = this.mLeftTitleView;
        if (r9 != null) goto L7;
        o.c("mLeftTitleView");
        r9 = null;
    L7:
        int r3 = ((getMeasuredWidth() - getMRightContainer().getMeasuredWidth()) - getMLeftContainer().getPaddingLeft()) - getMLeftContainer().getPaddingRight();
        TextView r4 = this.mLeftTitleView;
        if (r4 != null) goto L10;
        o.c("mLeftTitleView");
        r4 = null;
    L10:
        ViewGroup.LayoutParams r5 = ((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin")).getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r5, ViewGroup.MarginLayoutParams.class) == true) goto L13;
        r5 = null;
    L13:
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r5, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L16;
        int r10 = r6.rightMargin;
    L17:
        int r11 = r3 - r10;
        TextView r12 = this.mLeftTitleView;
        if (r12 != null) goto L20;
        o.c("mLeftTitleView");
        r12 = null;
    L20:
        ViewGroup.LayoutParams r13 = ((View) ZeusTransformUtils.preCheckCast(r12, View.class, "com.obric.aiagent.plugin")).getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r13, ViewGroup.MarginLayoutParams.class) == true) goto L23;
        r13 = null;
    L23:
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r13, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L26;
        r0 = r1.rightMargin;
    L26:
        int r14 = r11 - r0;
        TextView r15 = this.mLeftTitleView;
        if (r15 != null) goto L29;
        o.c("mLeftTitleView");
        r15 = null;
    L29:
        int r16 = r14 - r15.getPaddingLeft();
        TextView r17 = this.mLeftTitleView;
        if (r17 != null) goto L32;
        o.c("mLeftTitleView");
    L33:
        r9.setMaxWidth(r16 - r2.getPaddingRight());
        return;
    L32:
        r2 = r17;
        goto L33
    L16:
        r10 = 0;
        goto L17
    L35:
        if (this.mTitlePosition == b.f36494a) goto L37;
        return;
    L37:
        if (getMLeftContainer().getVisibility() != 0) goto L46;
        int r18 = getMLeftContainer().getMeasuredWidth();
        ViewGroup.LayoutParams r19 = ((View) ZeusTransformUtils.preCheckCast(getMLeftContainer(), View.class, "com.obric.aiagent.plugin")).getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r19, ViewGroup.MarginLayoutParams.class) == true) goto L41;
        r19 = null;
    L41:
        ViewGroup.MarginLayoutParams r20 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r19, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        if (r20 == null) goto L44;
        int r21 = r20.leftMargin;
    L45:
        int r22 = r18 + r21;
    L48:
        if (getMRightContainer().getVisibility() != 0) goto L57;
        int r23 = getMRightContainer().getMeasuredWidth();
        ViewGroup.LayoutParams r24 = ((View) ZeusTransformUtils.preCheckCast(getMRightContainer(), View.class, "com.obric.aiagent.plugin")).getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r24, ViewGroup.MarginLayoutParams.class) == true) goto L52;
        r24 = null;
    L52:
        ViewGroup.MarginLayoutParams r25 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r24, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        if (r25 == null) goto L55;
        int r26 = r25.rightMargin;
    L56:
        int r27 = r23 + r26;
    L58:
        int r28 = Math.max(r22, r27);
        if (getMFixedCenterContainer().getVisibility() != 0) goto L96;
        ViewGroup.LayoutParams r29 = ((View) ZeusTransformUtils.preCheckCast(getMFixedCenterContainer(), View.class, "com.obric.aiagent.plugin")).getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r29, ViewGroup.MarginLayoutParams.class) == true) goto L63;
        r29 = null;
    L63:
        ViewGroup.MarginLayoutParams r30 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r29, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        if (r30 == null) goto L66;
        int r31 = r30.leftMargin;
    L67:
        ViewGroup.LayoutParams r32 = ((View) ZeusTransformUtils.preCheckCast(getMFixedCenterContainer(), View.class, "com.obric.aiagent.plugin")).getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r32, ViewGroup.MarginLayoutParams.class) == true) goto L70;
        r32 = null;
    L70:
        ViewGroup.MarginLayoutParams r33 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r32, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        if (r33 == null) goto L73;
        r0 = r33.rightMargin;
    L73:
        int r34 = Math.max((getMeasuredWidth() - (r28 * 2)) - (r31 + r0), this.minCenterTitleWidth);
        TextView r35 = this.mFixedCenterTitleView;
        if (r35 != null) goto L76;
        o.c("mFixedCenterTitleView");
        r35 = null;
    L76:
        TextView r36 = this.mFixedCenterTitleView;
        if (r36 != null) goto L79;
        o.c("mFixedCenterTitleView");
        r36 = null;
    L79:
        int r37 = r36.getPaddingLeft() + r34;
        TextView r38 = this.mFixedCenterTitleView;
        if (r38 != null) goto L82;
        o.c("mFixedCenterTitleView");
        r38 = null;
    L82:
        r35.setMaxWidth(r37 + r38.getPaddingRight());
        TextView r39 = this.mFixedCenterSubTitleView;
        if (r39 != null) goto L85;
        o.c("mFixedCenterSubTitleView");
        r39 = null;
    L85:
        TextView r40 = this.mFixedCenterSubTitleView;
        if (r40 != null) goto L88;
        o.c("mFixedCenterSubTitleView");
        r40 = null;
    L88:
        int r41 = r34 + r40.getPaddingLeft();
        TextView r42 = this.mFixedCenterSubTitleView;
        if (r42 != null) goto L91;
        o.c("mFixedCenterSubTitleView");
    L92:
        r39.setMaxWidth(r41 + r2.getPaddingRight());
        return;
    L91:
        r2 = r42;
        goto L92
    L66:
        r31 = 0;
        goto L67
    L96:
        return;
    L55:
        r26 = 0;
        goto L56
    L57:
        r27 = 0;
        goto L58
    L44:
        r21 = 0;
        goto L45
    L46:
        r22 = 0;
        goto L48
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    private final void refreshTitleViewIfNeeded() {
        TextView r2 = null;
        if (this.mTitlePosition != b.f36496c) goto L10;
        TextView r3 = this.mLeftTitleView;
        if (r3 != null) goto L7;
        o.c("mLeftTitleView");
    L8:
        r2.requestLayout();
        return;
    L7:
        r2 = r3;
        goto L8
    L10:
        if (this.mTitlePosition != b.f36494a) goto L21;
        TextView r0 = this.mFixedCenterTitleView;
        if (r0 != null) goto L14;
        o.c("mFixedCenterTitleView");
        r0 = null;
    L14:
        r0.requestLayout();
        TextView r1 = this.mFixedCenterSubTitleView;
        if (r1 != null) goto L17;
        o.c("mFixedCenterSubTitleView");
    L18:
        r2.requestLayout();
        getMFixedCenterContainer().requestLayout();
        return;
    L17:
        r2 = r1;
        goto L18
    }

    public final void setMinCenterTitleWidth(int r3) {
        this.minCenterTitleWidth = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r3);
        post(new $$Lambda$OCTitleBar$Pk24BIuKqRC_mXJCv2Ml0bgcfM(this));
    }

    /* JADX INFO: renamed from: setMinCenterTitleWidth$lambda-1, reason: not valid java name */
    private static final void m1208setMinCenterTitleWidth$lambda1(OCTitleBar r1) {
        o.e(r1, "this$0");
        r1.refreshTitleViewIfNeeded();
    }

    public final void refreshTitleView() {
        post(new $$Lambda$OCTitleBar$AsmVlZppY0J1GApugPaAczCX4(this));
    }

    /* JADX INFO: renamed from: refreshTitleView$lambda-2, reason: not valid java name */
    private static final void m1207refreshTitleView$lambda2(OCTitleBar r1) {
        o.e(r1, "this$0");
        r1.refreshTitleViewIfNeeded();
    }
}
