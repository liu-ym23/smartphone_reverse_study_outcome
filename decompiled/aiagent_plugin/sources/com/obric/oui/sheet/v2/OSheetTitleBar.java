package com.obric.oui.sheet.v2;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.blur.BlurToken;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OIconButtonFloating;
import com.obric.oui.material.g;
import com.obric.oui.material.l;
import com.obric.oui.text.OTextView;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.h.b.p;
import d.k;
import d.l.n;
import d.m;
import d.s;
import java.util.Objects;

/* JADX INFO: compiled from: OSheetTitleBar.kt */
/* JADX INFO: loaded from: classes4.dex */
public class OSheetTitleBar extends FrameLayout implements com.obric.oui.material.b, g {
    private static final int CENTER_TITLE_GAP = 12;
    private static final int CENTER_TITLE_GAP_IN_LARGE_FONT = 4;
    private static final int CENTER_TITLE_HORIZONTAL_PADDING = 8;
    public static final a Companion = null;
    public static final int STYLE_AREA_ONLY_ICON = 7;
    public static final int STYLE_BACK = 1;
    public static final int STYLE_CUSTOM_BACKGROUND = 9;
    public static final int STYLE_DELETE = 3;
    public static final int STYLE_HIGHLIGHT_BLUE = 4;
    public static final int STYLE_HIGHLIGHT_RED = 5;
    public static final int STYLE_MIX = 10;
    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_NORMAL_WITH_ICON = 6;
    public static final int STYLE_SEARCH = 8;
    public static final int STYLE_SETTING = 2;
    public static final int STYLE_TNT_3_BLUE = 11;
    private View backdropTarget;
    private int centerTitleGapLargeFontPx;
    private int centerTitleGapPx;
    private int centerTitleHorizontalPaddingPx;
    private com.obric.oui.material.c currentMaskMaterialConfig;
    private int currentTheme;
    private String desText;
    private int fixedCenterSubTitleDefaultMaxWidth;
    private int fixedCenterTitleDefaultMaxWidth;
    private boolean isBackdropView;
    private boolean isFixedCenterOverflow;
    public FrameLayout mCenterContainer;
    private TextView mCenterTitleView;
    private FrameLayout mDesContainerView;
    private OTextView mDesTextView;
    public FrameLayout mFixedCenterContainer;
    private TextView mFixedCenterSubTitleView;
    private TextView mFixedCenterTitleView;
    private ImageView mHandleView;
    private boolean mIsLargeFont;
    public OIconButtonFloating mLeftActionBack;
    public LinearLayout mLeftContainer;
    private TextView mLeftTitleView;
    public LinearLayout mRightContainer;
    private ViewGroup mTitleBarRoot;
    private b mTitlePosition;
    private d.h.a.b<? super Boolean, com.obric.oui.material.c> maskMaterial;
    private int materialSrcType;
    private boolean showLeftBack;
    private String subTitleText;
    private String titleText;
    private float touchStartX;
    private float touchStartY;
    private VelocityTracker velocityTracker;

    /* JADX INFO: compiled from: OSheetTitleBar.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OSheetTitleBar.kt */
    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f36219a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f36220b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f36221c = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ b[] f36222e = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f36223d;

        private static final /* synthetic */ b[] b() {
            return new b[]{f36219a, f36220b, f36221c};
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(f36222e.clone(), b[].class, "com.obric.aiagent.plugin");
        }

        private b(String r1, int r2, int r3) {
            super(r1, r2);
            this.f36223d = r3;
        }

        public final int a() {
            return this.f36223d;
        }

        static {
            f36219a = new b("FIXED_CENTER", 0, 0);
            f36220b = new b("FLOW_WITH_ACTION", 1, 1);
            f36221c = new b("LEFT_IN_ACTION", 2, 2);
            f36222e = b();
        }
    }

    /* JADX INFO: compiled from: OSheetTitleBar.kt */
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f36224a = null;

        static {
            int[] r0 = new int[b.values().length];
            r0[b.f36219a.ordinal()] = 1;
            r0[b.f36220b.ordinal()] = 2;
            r0[b.f36221c.ordinal()] = 3;
            f36224a = r0;
        }
    }

    /* JADX INFO: compiled from: OSheetTitleBar.kt */
    static final class d extends p implements d.h.a.b<Boolean, com.obric.oui.material.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OSheetTitleBar f36225a;

        d(OSheetTitleBar r1) {
            this.f36225a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.material.c invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.material.c a(boolean r33) {
            if (r33 == false) goto L6;
            return new com.obric.oui.material.c(null, null, l.a(ZeusTransformUtils.getResources(this.f36225a, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.array.oui_no_gradient_blur_colors, "array", "oui_no_gradient_blur_colors"), ZeusTransformUtils.mapRes(R.array.oui_no_gradient_blur_blend_modes, "array", "oui_no_gradient_blur_blend_modes")), null, null, null, new com.obric.oui.blur.a(BlurToken.Blur_Progress_Thin, 1, 0.0f, 6, 0.0f, 20, null), null, null, null, 955, null);
        L6:
            return new com.obric.oui.material.c(null, null, l.a(ZeusTransformUtils.getResources(this.f36225a, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.array.oui_no_gradient_blur_colors, "array", "oui_no_gradient_blur_colors"), ZeusTransformUtils.mapRes(R.array.oui_no_gradient_blur_blend_modes, "array", "oui_no_gradient_blur_blend_modes")), null, null, null, new com.obric.oui.blur.a(BlurToken.Blur_Progress_Thin, 1, 0.0f, 6, 0.0f, 20, null), null, null, null, 955, null);
        }
    }

    static {
        Companion = new a(null);
    }

    public OSheetTitleBar(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OSheetTitleBar(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public static /* synthetic */ boolean lambda$OFZjLYYoddrMj0AYp5IR8l5rSq8(OSheetTitleBar r0, e r1, View r2, MotionEvent r3) {
        return m1180createHandleView$lambda8(r0, r1, r2, r3);
    }

    public /* synthetic */ OSheetTitleBar(Context r2, AttributeSet r3, int r4, int r5, h r6) {
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

    public OSheetTitleBar(Context r4, AttributeSet r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        super(r7, r8, r6);
        this.fixedCenterTitleDefaultMaxWidth = Integer.MAX_VALUE;
        this.fixedCenterSubTitleDefaultMaxWidth = Integer.MAX_VALUE;
        this.mIsLargeFont = com.obric.oui.d.h.a(ZeusTransformUtils.getResources(r7, "com.obric.aiagent.plugin").getConfiguration().fontScale);
        this.isBackdropView = true;
        this.materialSrcType = 2;
        this.maskMaterial = (d.h.a.b) ZeusTransformUtils.preCheckCast(new d(this), d.h.a.b.class, "com.obric.aiagent.plugin");
        this.showLeftBack = true;
        this.mTitlePosition = b.f36219a;
        refreshDimensionCache();
        init(r7);
        if (r8 == null) goto L5;
        initAttrs(r8);
    L5:
        updateMaterial();
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

    public final int getCurrentTheme() {
        return this.currentTheme;
    }

    public final void setCurrentTheme(int r1) {
        this.currentTheme = r1;
    }

    public final OIconButtonFloating getMLeftActionBack() {
        OIconButtonFloating r0 = this.mLeftActionBack;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("mLeftActionBack");
        return null;
    }

    public final void setMLeftActionBack(OIconButtonFloating r2) {
        o.e(r2, "<set-?>");
        this.mLeftActionBack = r2;
    }

    public final boolean getShowLeftBack() {
        return this.showLeftBack;
    }

    public final void setShowLeftBack(boolean r3) {
        this.showLeftBack = r3;
        OIconButtonFloating r0 = getMLeftActionBack();
        if (r3 == false) goto L5;
        int r4 = 0;
    L6:
        r0.setVisibility(r4);
        if (this.mTitlePosition != b.f36221c) goto L10;
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

    public final void setSubTitleText(String r5) {
        this.subTitleText = r5;
        TextView r0 = null;
        if (r5 != null) goto L9;
        TextView r4 = this.mFixedCenterSubTitleView;
        if (r4 != null) goto L7;
        o.c("mFixedCenterSubTitleView");
    L8:
        r0.setVisibility(8);
        return;
    L7:
        r0 = r4;
        goto L8
    L9:
        TextView r2 = this.mFixedCenterSubTitleView;
        if (r2 != null) goto L12;
        o.c("mFixedCenterSubTitleView");
        r2 = null;
    L12:
        r2.setVisibility(0);
        TextView r6 = this.mFixedCenterSubTitleView;
        if (r6 != null) goto L15;
        o.c("mFixedCenterSubTitleView");
    L16:
        r0.setText((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"));
        return;
    L15:
        r0 = r6;
        goto L16
    }

    public final String getTitleText() {
        return this.titleText;
    }

    public final void setTitleText(String r3) {
        this.titleText = r3;
        if (r3 != null) goto L5;
        getMTitleView().setVisibility(4);
        return;
    L5:
        getMTitleView().setVisibility(0);
        getMTitleView().setText((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"));
    }

    public final String getDesText() {
        return this.desText;
    }

    public final void setDesText(String r6) {
        this.desText = r6;
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        OTextView r4 = null;
        FrameLayout r5 = null;
        if (r1 == false) goto L16;
        FrameLayout r7 = this.mDesContainerView;
        if (r7 != null) goto L14;
        o.c("mDesContainerView");
    L15:
        r5.setVisibility(8);
        return;
    L14:
        r5 = r7;
        goto L15
    L16:
        FrameLayout r2 = this.mDesContainerView;
        if (r2 != null) goto L19;
        o.c("mDesContainerView");
        r2 = null;
    L19:
        r2.setVisibility(0);
        OTextView r8 = this.mDesTextView;
        if (r8 != null) goto L22;
        o.c("mDesTextView");
    L23:
        r4.setText((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"));
        return;
    L22:
        r4 = r8;
        goto L23
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final TextView getMTitleView() {
        b r0 = this.mTitlePosition;
        int r1 = c.f36224a[r0.ordinal()];
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
        int r9 = c.f36224a[r8.ordinal()];
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
        FrameLayout.inflate((Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.layout.o_sheet_title_bar_container_v2, "layout", "o_sheet_title_bar_container_v2"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"));
        View r6 = findViewById(ZeusTransformUtils.mapRes(R.id.sheet_title_bar_main, DbHelper.COL_ID, "sheet_title_bar_main"));
        o.c(r6, "findViewById(R.id.sheet_title_bar_main)");
        this.mTitleBarRoot = (ViewGroup) ZeusTransformUtils.preCheckCast(r6, ViewGroup.class, "com.obric.aiagent.plugin");
        View r7 = findViewById(ZeusTransformUtils.mapRes(R.id.center_title, DbHelper.COL_ID, "center_title"));
        o.c(r7, "findViewById(R.id.center_title)");
        this.mCenterTitleView = (TextView) ZeusTransformUtils.preCheckCast(r7, TextView.class, "com.obric.aiagent.plugin");
        View r8 = findViewById(ZeusTransformUtils.mapRes(R.id.left_title, DbHelper.COL_ID, "left_title"));
        o.c(r8, "findViewById(R.id.left_title)");
        this.mLeftTitleView = (TextView) ZeusTransformUtils.preCheckCast(r8, TextView.class, "com.obric.aiagent.plugin");
        View r9 = findViewById(ZeusTransformUtils.mapRes(R.id.ll_left_action_container, DbHelper.COL_ID, "ll_left_action_container"));
        o.c(r9, "findViewById(R.id.ll_left_action_container)");
        setMLeftContainer((LinearLayout) ZeusTransformUtils.preCheckCast(r9, LinearLayout.class, "com.obric.aiagent.plugin"));
        View r10 = findViewById(ZeusTransformUtils.mapRes(R.id.ll_right_action_container, DbHelper.COL_ID, "ll_right_action_container"));
        o.c(r10, "findViewById(R.id.ll_right_action_container)");
        setMRightContainer((LinearLayout) ZeusTransformUtils.preCheckCast(r10, LinearLayout.class, "com.obric.aiagent.plugin"));
        View r11 = findViewById(ZeusTransformUtils.mapRes(R.id.fl_center_action_container, DbHelper.COL_ID, "fl_center_action_container"));
        o.c(r11, "findViewById(R.id.fl_center_action_container)");
        setMCenterContainer((FrameLayout) ZeusTransformUtils.preCheckCast(r11, FrameLayout.class, "com.obric.aiagent.plugin"));
        View r12 = findViewById(ZeusTransformUtils.mapRes(R.id.fl_fixed_center_action_container, DbHelper.COL_ID, "fl_fixed_center_action_container"));
        o.c(r12, "findViewById(R.id.fl_fix…_center_action_container)");
        setMFixedCenterContainer((FrameLayout) ZeusTransformUtils.preCheckCast(r12, FrameLayout.class, "com.obric.aiagent.plugin"));
        View r13 = findViewById(ZeusTransformUtils.mapRes(R.id.fixed_center_title, DbHelper.COL_ID, "fixed_center_title"));
        o.c(r13, "findViewById(R.id.fixed_center_title)");
        this.mFixedCenterTitleView = (TextView) ZeusTransformUtils.preCheckCast(r13, TextView.class, "com.obric.aiagent.plugin");
        View r14 = findViewById(ZeusTransformUtils.mapRes(R.id.left_action_back, DbHelper.COL_ID, "left_action_back"));
        o.c(r14, "findViewById(R.id.left_action_back)");
        setMLeftActionBack((OIconButtonFloating) ZeusTransformUtils.preCheckCast(r14, OIconButtonFloating.class, "com.obric.aiagent.plugin"));
        View r15 = findViewById(ZeusTransformUtils.mapRes(R.id.fixed_center_sub_title, DbHelper.COL_ID, "fixed_center_sub_title"));
        o.c(r15, "findViewById(R.id.fixed_center_sub_title)");
        this.mFixedCenterSubTitleView = (TextView) ZeusTransformUtils.preCheckCast(r15, TextView.class, "com.obric.aiagent.plugin");
        View r16 = findViewById(ZeusTransformUtils.mapRes(R.id.sheet_title_bar_des, DbHelper.COL_ID, "sheet_title_bar_des"));
        o.c(r16, "findViewById(R.id.sheet_title_bar_des)");
        this.mDesContainerView = (FrameLayout) ZeusTransformUtils.preCheckCast(r16, FrameLayout.class, "com.obric.aiagent.plugin");
        View r17 = findViewById(ZeusTransformUtils.mapRes(R.id.sheet_title_bar_des_text, DbHelper.COL_ID, "sheet_title_bar_des_text"));
        o.c(r17, "findViewById(R.id.sheet_title_bar_des_text)");
        OTextView r18 = (OTextView) ZeusTransformUtils.preCheckCast(r17, OTextView.class, "com.obric.aiagent.plugin");
        this.mDesTextView = r18;
        TextView r0 = null;
        if (r18 != null) goto L5;
        o.c("mDesTextView");
        r18 = null;
    L5:
        r18.setEnableAutoAlignLeft(true);
        TextView r19 = this.mFixedCenterTitleView;
        if (r19 != null) goto L8;
        o.c("mFixedCenterTitleView");
        r19 = null;
    L8:
        this.fixedCenterTitleDefaultMaxWidth = r19.getMaxWidth();
        TextView r20 = this.mFixedCenterSubTitleView;
        if (r20 != null) goto L11;
        o.c("mFixedCenterSubTitleView");
    L12:
        this.fixedCenterSubTitleDefaultMaxWidth = r0.getMaxWidth();
        return;
    L11:
        r0 = r20;
        goto L12
    }

    public void applyDynamicTheme(int r2) {
        if (this.currentTheme == r2) goto L6;
        this.currentTheme = r2;
        updateMaterial();
        return;
    }

    public boolean isDarkTheme() {
        int r0 = this.currentTheme;
        boolean r1 = false;
        if (r0 != 0) goto L5;
        TextView r2 = this.mLeftTitleView;
        TextView r4 = null;
        if (r2 != null) goto L12;
        o.c("mLeftTitleView");
        r2 = null;
    L12:
        if (((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin")).getVisibility() != 0) goto L14;
        boolean r3 = true;
    L15:
        if (r3 == false) goto L21;
        TextView r7 = this.mLeftTitleView;
        if (r7 != null) goto L19;
        o.c("mLeftTitleView");
    L20:
        int r8 = r4.getTextColors().getDefaultColor();
    L35:
        return !com.obric.oui.color.d.a(r8);
    L19:
        r4 = r7;
        goto L20
    L21:
        TextView r5 = this.mFixedCenterTitleView;
        if (r5 != null) goto L25;
        o.c("mFixedCenterTitleView");
        r5 = null;
    L25:
        if (((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.aiagent.plugin")).getVisibility() != 0) goto L27;
        r1 = true;
    L27:
        if (r1 == false) goto L33;
        TextView r9 = this.mFixedCenterTitleView;
        if (r9 != null) goto L31;
        o.c("mFixedCenterTitleView");
    L32:
        r8 = r4.getTextColors().getDefaultColor();
        goto L35
    L31:
        r4 = r9;
        goto L32
    L33:
        r8 = -16777216;
        goto L35
    L14:
        r3 = false;
        goto L15
    L5:
        if (r0 == 2) goto L7;
        return false;
    L7:
        return true;
    }

    private final void initAttrs(AttributeSet r5) {
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        TypedArray r7 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getTheme().obtainStyledAttributes(r6, R.styleable.OCTitleBar, 0, 0);
        int r1 = r7.getInt(ZeusTransformUtils.mapRes(R.styleable.OCTitleBar_oui_title_pos, "styleable", "OCTitleBar_oui_title_pos"), b.f36219a.a());     // Catch: Throwable -> L6
        setMTitlePosition(b.values()[r1]);     // Catch: Throwable -> L6
        setTitleText(r7.getString(ZeusTransformUtils.mapRes(R.styleable.OCTitleBar_oui_title_text, "styleable", "OCTitleBar_oui_title_text")));     // Catch: Throwable -> L6
        setDesText(r7.getString(ZeusTransformUtils.mapRes(R.styleable.OCTitleBar_oui_title_des_text, "styleable", "OCTitleBar_oui_title_des_text")));     // Catch: Throwable -> L6
        setShowLeftBack(r7.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OCTitleBar_oui_useBackIcon, "styleable", "OCTitleBar_oui_useBackIcon"), true));     // Catch: Throwable -> L6
        setSubTitleText(r7.getString(ZeusTransformUtils.mapRes(R.styleable.OCTitleBar_oui_sub_title_text, "styleable", "OCTitleBar_oui_sub_title_text")));     // Catch: Throwable -> L6
        r7.recycle();
        return;
    L6:
        th = move-exception;
        r7.recycle();
        throw th;
    }

    private final void updateMaterial() {
        this.currentMaskMaterialConfig = (com.obric.oui.material.c) ZeusTransformUtils.preCheckCast(this.maskMaterial.invoke(Boolean.valueOf(!isDarkTheme())), com.obric.oui.material.c.class, "com.obric.aiagent.plugin");
        View r0 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin");
        com.obric.oui.material.c r1 = this.currentMaskMaterialConfig;
        if (r1 != null) goto L5;
        o.c("currentMaskMaterialConfig");
        r1 = null;
    L5:
        l.a(r0, r1, this.materialSrcType);
        View r2 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin");
        View r3 = this.backdropTarget;
        if (r3 != null) goto L9;
        r3 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin");
    L9:
        com.obric.oui.material.k.a(r2, r3);
    }

    public final OButton createNeutralButton(Context r2, ViewGroup r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        o.e(r3, "root");
        return OButton.Companion.a(r1, r3);
    }

    public final OButton createPrimaryButton(Context r2, ViewGroup r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        o.e(r3, "root");
        return OButton.Companion.b(r1, r3);
    }

    public final OIconButtonFloating createNeutralIconButton(Context r5, ViewGroup r6, int r7, ColorStateList r8, Integer r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        o.e(r10, "context");
        o.e(r6, "root");
        OIconButtonFloating r11 = createIconButton(r10, r6, ZeusTransformUtils.mapRes(R.layout.o_widget_titlebar_neutral_icon_button, "layout", "o_widget_titlebar_neutral_icon_button"));
        com.obric.oui.material.k.a((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.aiagent.plugin"), getDefaultTargetView());
        r11.setIcon(r7);
        if (r8 == null) goto L6;
        r11.setIconTintColor(r8);
    L6:
        if (r9 == null) goto L9;
        ((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.aiagent.plugin")).intValue();
        r11.setContentDescription((CharSequence) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(r9.intValue()), CharSequence.class, "com.obric.aiagent.plugin"));
    L9:
        return r11;
    }

    public final OIconButtonFloating createPrimaryIconButton(Context r5, ViewGroup r6, int r7, ColorStateList r8, Integer r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        o.e(r10, "context");
        o.e(r6, "root");
        OIconButtonFloating r11 = createIconButton(r10, r6, ZeusTransformUtils.mapRes(R.layout.o_widget_titlebar_primary_icon_button, "layout", "o_widget_titlebar_primary_icon_button"));
        com.obric.oui.material.k.a((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.aiagent.plugin"), getDefaultTargetView());
        r11.setIcon(r7);
        if (r8 == null) goto L6;
        r11.setIconTintColor(r8);
    L6:
        if (r9 == null) goto L9;
        ((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.aiagent.plugin")).intValue();
        r11.setContentDescription((CharSequence) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(r9.intValue()), CharSequence.class, "com.obric.aiagent.plugin"));
    L9:
        return r11;
    }

    public final OButton createPrimaryLightButton(Context r3, ViewGroup r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        o.e(r4, "root");
        OButton r6 = OButton.Companion.c(r5, r4);
        com.obric.oui.material.k.a((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.aiagent.plugin"), getDefaultTargetView());
        return r6;
    }

    public final OButton createTransButton(Context r2, ViewGroup r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        o.e(r3, "root");
        return OButton.Companion.d(r1, r3);
    }

    public final OButton createUnderstatedButton(Context r2, ViewGroup r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        o.e(r3, "root");
        return OButton.Companion.e(r1, r3);
    }

    public final OButton createButton(Context r2, ViewGroup r3, int r4) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        o.e(r3, "root");
        return OButton.Companion.a(r1, r3, r4);
    }

    public final OIconButtonFloating createIconButton(Context r2, ViewGroup r3, int r4) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        o.e(r3, "root");
        View r5 = FrameLayout.inflate(r1, r4, r3);
        Objects.requireNonNull(r5, "null cannot be cast to non-null type android.view.ViewGroup");
        View r6 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.aiagent.plugin")).getChildAt(r3.getChildCount() - 1);
        Objects.requireNonNull(r6, "null cannot be cast to non-null type com.obric.oui.button.OIconButtonFloating");
        return (OIconButtonFloating) ZeusTransformUtils.preCheckCast(r6, OIconButtonFloating.class, "com.obric.aiagent.plugin");
    }

    public final float getTouchStartX() {
        return this.touchStartX;
    }

    public final void setTouchStartX(float r1) {
        this.touchStartX = r1;
    }

    public final float getTouchStartY() {
        return this.touchStartY;
    }

    public final void setTouchStartY(float r1) {
        this.touchStartY = r1;
    }

    public final VelocityTracker getVelocityTracker() {
        return this.velocityTracker;
    }

    public final void setVelocityTracker(VelocityTracker r1) {
        this.velocityTracker = r1;
    }

    public final ImageView createHandleView(Context r5, e r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        final e r8 = (e) ZeusTransformUtils.wrapperContextForParams(r6, e.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        o.e(r8, "sheet");
        View r9 = FrameLayout.inflate(r7, ZeusTransformUtils.mapRes(R.layout.o_widget_titlebar_handler, "layout", "o_widget_titlebar_handler"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin")).findViewById(ZeusTransformUtils.mapRes(R.id.title_handler, DbHelper.COL_ID, "title_handler"));
        o.c(r9, "inflate(context, R.layou…wById(R.id.title_handler)");
        ImageView r10 = (ImageView) ZeusTransformUtils.preCheckCast(r9, ImageView.class, "com.obric.aiagent.plugin");
        this.mHandleView = r10;
        if (r10 != null) goto L5;
        o.c("mHandleView");
        r10 = null;
    L5:
        r10.setOnTouchListener(new $$Lambda$OSheetTitleBar$OFZjLYYoddrMj0AYp5IR8l5rSq8(this, r8));
        ImageView r4 = this.mHandleView;
        if (r4 != null) goto L9;
        o.c("mHandleView");
        return null;
    L9:
        return r4;
    }

    /* JADX INFO: renamed from: createHandleView$lambda-8, reason: not valid java name */
    private static final boolean m1180createHandleView$lambda8(OSheetTitleBar r6, e r7, View r8, MotionEvent r9) {
        e r0 = (e) ZeusTransformUtils.wrapperContextForParams(r7, e.class, "com.obric.aiagent.plugin");
        o.e(r6, "this$0");
        o.e(r0, "$sheet");
        if (r6.velocityTracker != null) goto L5;
        r6.velocityTracker = VelocityTracker.obtain();
    L5:
        VelocityTracker r10 = r6.velocityTracker;
        if (r10 == null) goto L9;
        r10.addMovement(r9);
    L9:
        int r11 = r9.getAction();
        if (r11 != 0) goto L12;
        r6.touchStartX = r9.getRawX();
        r6.touchStartY = r9.getRawY();
        r6.requestFocus();
        e.a.a(r0, 0.0f, 0.0f, true, 3, null);
    L35:
        return true;
    L12:
        if (r11 != 1) goto L14;
    L19:
        VelocityTracker r12 = r6.velocityTracker;
        if (r12 == null) goto L23;
        r12.computeCurrentVelocity(1000);
    L23:
        VelocityTracker r13 = r6.velocityTracker;
        if (r13 != null) goto L26;
        float r14 = 0.0f;
    L27:
        VelocityTracker r2 = r6.velocityTracker;
        if (r2 == null) goto L31;
        r2.recycle();
    L31:
        r6.velocityTracker = null;
        if ((r9.getRawY() - r6.touchStartY) < 0.0f) goto L35;
        r0.fling(0.0f, r14);
        goto L35
    L26:
        r14 = r13.getYVelocity();
        goto L27
    L14:
        if (r11 != 2) goto L16;
        e.a.a(r0, 0.0f, n.a(r9.getRawY() - r6.touchStartY, 0.0f), false, 4, null);
        goto L35
    L16:
        if (r11 == 3) goto L19;
        goto L19
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
    L9:
        r3.setText(r5);
        return r3;
    L5:
        if (r4 == 4) goto L7;
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r7, "context");
        r3 = createPrimaryLightButton(r7, (ViewGroup) ZeusTransformUtils.preCheckCast(getMRightContainer(), ViewGroup.class, "com.obric.aiagent.plugin"));
        goto L9
    L7:
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r8, "context");
        r3 = createPrimaryLightButton(r8, (ViewGroup) ZeusTransformUtils.preCheckCast(getMRightContainer(), ViewGroup.class, "com.obric.aiagent.plugin"));
        goto L9
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

    public final void addRightView(View r2) {
        o.e(r2, "view");
        getMRightContainer().addView(r2);
    }

    public final void removeAllRightViews() {
        getMRightContainer().removeAllViews();
    }

    public final void sheetTitleBarStyle() {
        getMTitleView().setTextSize(16.0f);
    }

    @Override // com.obric.oui.material.b
    public void applyMaskMaterial(boolean r4) {
        if (this.materialSrcType == (-1)) goto L6;
        com.obric.oui.material.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r4, this.materialSrcType);
        return;
    L6:
        com.obric.oui.material.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r4, this.isBackdropView);
    }

    @Override // com.obric.oui.material.g
    public void applyContentMaterial(boolean r4) {
        if (this.materialSrcType == (-1)) goto L6;
        com.obric.oui.material.h.a((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.a(getMLeftActionBack()), Iterable.class, "com.obric.aiagent.plugin"), r4);
        com.obric.oui.material.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r4, this.materialSrcType);
        return;
    L6:
        com.obric.oui.material.h.a((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.a(getMLeftActionBack()), Iterable.class, "com.obric.aiagent.plugin"), r4);
    }

    @Override // com.obric.oui.material.g
    public void setBackdropTarget(View r3) {
        this.backdropTarget = r3;
        if (r3 != null) goto L6;
        com.obric.oui.material.k.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"));
        setDefaultBackdropTargetForChild();
        return;
    L6:
        com.obric.oui.material.k.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r3);
        com.obric.oui.material.h.a((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.a(getMLeftActionBack()), Iterable.class, "com.obric.aiagent.plugin"), r3);
    }

    @Override // com.obric.oui.material.g
    public void updateBackdropTargetType(boolean r3) {
        if (this.isBackdropView == r3) goto L9;
        this.isBackdropView = r3;
        if (this.materialSrcType == (-1)) goto L7;
        return;
    L7:
        com.obric.oui.material.k.c((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r3);
        com.obric.oui.material.h.b((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.a(getMLeftActionBack()), Iterable.class, "com.obric.aiagent.plugin"), r3);
        return;
    }

    @Override // com.obric.oui.material.g
    public void updateBackdropSrcType(int r4) {
        this.materialSrcType = r4;
        com.obric.oui.material.h.a((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.a(getMLeftActionBack()), Iterable.class, "com.obric.aiagent.plugin"), r4);
        com.obric.oui.material.k.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r4);
    }

    private final void setDefaultBackdropTargetForChild() {
        View r0 = getDefaultTargetView();
        getMLeftActionBack().setBackdropTarget(r0);
    }

    private final View getDefaultTargetView() {
        if (l.c() <= 1) goto L10;
        ViewGroup r3 = this.mTitleBarRoot;
        if (r3 != null) goto L8;
        o.c("mTitleBarRoot");
        r3 = null;
    L8:
        return (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin");
    L10:
        return (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin");
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        boolean r0 = false;
        this.isFixedCenterOverflow = false;
        TextView r1 = this.mFixedCenterTitleView;
        TextView r3 = null;
        if (r1 != null) goto L5;
        o.c("mFixedCenterTitleView");
        r1 = null;
    L5:
        r1.setMaxWidth(this.fixedCenterTitleDefaultMaxWidth);
        TextView r2 = this.mFixedCenterSubTitleView;
        if (r2 != null) goto L8;
        o.c("mFixedCenterSubTitleView");
        r2 = null;
    L8:
        r2.setMaxWidth(this.fixedCenterSubTitleDefaultMaxWidth);
        super.onMeasure(r10, r11);
        if (isFixedCenterTitleVisible() == true) goto L11;
        return;
    L11:
        int r4 = getTitleBarContentWidth();
        if (r4 > 0) goto L14;
        return;
    L14:
        m<Integer, Integer> r5 = getFixedCenterSafeBounds(r4);
        int r6 = ((Number) ZeusTransformUtils.preCheckCast(r5.c(), Number.class, "com.obric.aiagent.plugin")).intValue();
        int r7 = ((Number) ZeusTransformUtils.preCheckCast(r5.d(), Number.class, "com.obric.aiagent.plugin")).intValue();
        int r8 = r4 / 2;
        int r9 = Math.max(0, Math.min((r8 - r6) * 2, (r7 - r8) * 2));
        int r12 = Math.max(0, r7 - r6);
        if (getMFixedCenterContainer().getMeasuredWidth() <= r9) goto L39;
        boolean r13 = true;
        this.isFixedCenterOverflow = true;
        int r14 = Math.min(this.fixedCenterTitleDefaultMaxWidth, r12);
        int r15 = Math.min(this.fixedCenterSubTitleDefaultMaxWidth, r12);
        TextView r16 = this.mFixedCenterTitleView;
        if (r16 != null) goto L20;
        o.c("mFixedCenterTitleView");
        r16 = null;
    L20:
        if (r16.getMaxWidth() == r14) goto L25;
        TextView r17 = this.mFixedCenterTitleView;
        if (r17 != null) goto L24;
        o.c("mFixedCenterTitleView");
        r17 = null;
    L24:
        r17.setMaxWidth(r14);
        r0 = true;
    L25:
        TextView r18 = this.mFixedCenterSubTitleView;
        if (r18 != null) goto L29;
        o.c("mFixedCenterSubTitleView");
        r18 = null;
    L29:
        if (r18.getMaxWidth() == r15) goto L35;
        TextView r19 = this.mFixedCenterSubTitleView;
        if (r19 != null) goto L33;
        o.c("mFixedCenterSubTitleView");
    L34:
        r3.setMaxWidth(r15);
    L36:
        if (r13 == false) goto L40;
        super.onMeasure(r10, r11);
        return;
    L40:
        return;
    L33:
        r3 = r19;
        goto L34
    L35:
        r13 = r0;
        goto L36
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
        super.onLayout(r2, r3, r4, r5, r6);
        if (isFixedCenterTitleVisible() == true) goto L5;
        return;
    L5:
        int r7 = getTitleBarContentWidth();
        if (r7 > 0) goto L8;
        return;
    L8:
        m<Integer, Integer> r8 = getFixedCenterSafeBounds(r7);
        int r9 = ((Number) ZeusTransformUtils.preCheckCast(r8.c(), Number.class, "com.obric.aiagent.plugin")).intValue();
        int r10 = ((Number) ZeusTransformUtils.preCheckCast(r8.d(), Number.class, "com.obric.aiagent.plugin")).intValue();
        int r11 = Math.max(0, r10 - r9);
        int r12 = getMFixedCenterContainer().getMeasuredWidth();
        int r13 = (r7 - r12) / 2;
        int r0 = r13 + r12;
        if (r12 <= r11) goto L11;
    L10:
        r13 = r9;
    L17:
        if (this.isFixedCenterOverflow == false) goto L20;
        if (r12 > r11) goto L20;
        r13 = r9 + ((r11 - r12) / 2);
        r10 = r13 + r12;
    L20:
        getMFixedCenterContainer().layout(r13, getMFixedCenterContainer().getTop(), r10, getMFixedCenterContainer().getBottom());
        return;
    L11:
        if (r13 >= r9) goto L13;
        r10 = r9 + r12;
        goto L10
    L13:
        if (r0 <= r10) goto L15;
        r13 = r10 - r12;
        goto L17
    L15:
        r10 = r0;
        goto L17
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        if (r1 == null) goto L6;
        this.mIsLargeFont = com.obric.oui.d.h.a(r1.fontScale);
    L6:
        refreshDimensionCache();
    }

    private final int getCenterTitleGap() {
        if (this.mIsLargeFont == false) goto L6;
        return this.centerTitleGapLargeFontPx;
    L6:
        return this.centerTitleGapPx;
    }

    private final int getTitleBarContentWidth() {
        ViewGroup r0 = this.mTitleBarRoot;
        ViewGroup r1 = null;
        if (r0 != null) goto L6;
        o.c("mTitleBarRoot");
        r0 = null;
    L6:
        if (r0.getMeasuredWidth() <= 0) goto L13;
        ViewGroup r3 = this.mTitleBarRoot;
        if (r3 != null) goto L10;
        o.c("mTitleBarRoot");
    L14:
        return r1.getMeasuredWidth();
    L10:
        r1 = r3;
        goto L14
    L13:
        return getMeasuredWidth();
    }

    private final m<Integer, Integer> getFixedCenterSafeBounds(int r8) {
        ViewGroup r0 = this.mTitleBarRoot;
        ViewGroup r1 = null;
        if (r0 != null) goto L5;
        o.c("mTitleBarRoot");
        r0 = null;
    L5:
        int r2 = r0.getPaddingLeft();
        ViewGroup r3 = this.mTitleBarRoot;
        if (r3 != null) goto L8;
        o.c("mTitleBarRoot");
    L9:
        int r4 = r1.getPaddingRight();
        int r5 = getCenterTitleGap();
        int r6 = getOccupiedWidth((View) ZeusTransformUtils.preCheckCast(getMLeftContainer(), View.class, "com.obric.aiagent.plugin"));
        int r7 = getOccupiedWidth((View) ZeusTransformUtils.preCheckCast(getMRightContainer(), View.class, "com.obric.aiagent.plugin"));
        if (r6 <= 0) goto L12;
        int r9 = (r2 + r6) + r5;
    L13:
        if (r7 <= 0) goto L15;
        int r10 = ((r8 - r4) - r7) - r5;
    L17:
        return s.a(Integer.valueOf(r9), Integer.valueOf(r10));
    L15:
        r10 = (r8 - r4) - this.centerTitleHorizontalPaddingPx;
        goto L17
    L12:
        r9 = r2 + this.centerTitleHorizontalPaddingPx;
        goto L13
    L8:
        r1 = r3;
        goto L9
    }

    private final void refreshDimensionCache() {
        this.centerTitleGapPx = com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12);
        this.centerTitleGapLargeFontPx = com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 4);
        this.centerTitleHorizontalPaddingPx = com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 8);
    }

    private final boolean isFixedCenterTitleVisible() {
        if (this.mTitlePosition != b.f36219a) goto L28;
        if (((View) ZeusTransformUtils.preCheckCast(getMFixedCenterContainer(), View.class, "com.obric.aiagent.plugin")).getVisibility() != 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L28;
        TextView r1 = this.mFixedCenterTitleView;
        TextView r2 = null;
        if (r1 != null) goto L13;
        o.c("mFixedCenterTitleView");
        r1 = null;
    L13:
        if (((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin")).getVisibility() != 0) goto L15;
        boolean r3 = true;
    L16:
        if (r3 == true) goto L29;
        TextView r6 = this.mFixedCenterSubTitleView;
        if (r6 != null) goto L20;
        o.c("mFixedCenterSubTitleView");
    L22:
        if (((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin")).getVisibility() != 0) goto L24;
        boolean r7 = true;
    L25:
        if (r7 == false) goto L28;
        return true;
    L24:
        r7 = false;
        goto L25
    L20:
        r2 = r6;
        goto L22
    L29:
        return true;
    L15:
        r3 = false;
        goto L16
    L7:
        r0 = false;
    L28:
        return false;
    }

    private final int getOccupiedWidth(View r4) {
        int r0 = 0;
        if (r4.getVisibility() != 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == true) goto L8;
    L15:
        return 0;
    L8:
        if (r4.getMeasuredWidth() <= 0) goto L15;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r5, ViewGroup.MarginLayoutParams.class) == false) goto L14;
        r0 = ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r5, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin")).getMarginStart() + ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r5, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin")).getMarginEnd();
    L14:
        return r4.getMeasuredWidth() + r0;
    L5:
        r3 = false;
        goto L6
    }
}
