package com.obric.oui.searchbar.v2;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.oui.color.d;
import com.obric.oui.common.style.f;
import com.obric.oui.common.style.j;
import com.obric.oui.d.i;
import com.obric.oui.forms.OEditText;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.c;
import com.obric.oui.material.g;
import com.obric.oui.material.k;
import com.obric.oui.material.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.r;
import d.h.b.h;
import d.h.b.o;
import d.h.b.p;
import d.x;
import java.util.List;

/* JADX INFO: compiled from: OSearchBar.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OSearchBar extends OUIFrameLayout implements g {
    public static final a Companion = null;
    private static final String TAG = "OSearchBar";
    private int bgColor;
    private int bgColorResting;
    private boolean canShowClear;
    private final ImageView clearAction;
    private final ViewGroup clearActionContainer;
    private c[] currentMaterials;
    private int currentTheme;
    private boolean enabledMaterial;
    private final OEditText inputView;
    private boolean isBackdropView;
    private final FrameLayout leftContainer;
    private int materialSrcType;
    private String materialToken;
    private String materialTokenResting;
    private c[] materialsActive;
    private c[] materialsResting;
    private final FrameLayout rightContainer;
    private OUILinearLayout searchBarContainer;
    private List<j> shadowsNormal;
    private List<j> shadowsResting;

    /* JADX INFO: renamed from: com.obric.oui.searchbar.v2.OSearchBar$1, reason: invalid class name */
    /* JADX INFO: compiled from: OSearchBar.kt */
    static final class AnonymousClass1 extends p implements d.h.a.b<MotionEvent, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OSearchBar f36133a;

        AnonymousClass1(OSearchBar r1) {
            this.f36133a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(MotionEvent r3) {
            a((MotionEvent) ZeusTransformUtils.preCheckCast(r3, MotionEvent.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(MotionEvent r7) {
            OUILinearLayout r0 = null;
            if (r7 != null) goto L5;
            Integer r8 = null;
        L6:
            boolean r2 = true;
            if (r8 == null) goto L17;
            if (r8.intValue() != 0) goto L17;
            OUILinearLayout r6 = OSearchBar.access$getSearchBarContainer$p(this.f36133a);
            if (r6 != null) goto L14;
            o.c("searchBarContainer");
        L15:
            r0.setFakePressed(true);
            return;
        L14:
            r0 = r6;
        L17:
            if (r8 != null) goto L20;
        L22:
            if (r8 != null) goto L25;
        L27:
            r2 = false;
        L28:
            if (r2 == false) goto L36;
            OUILinearLayout r9 = OSearchBar.access$getSearchBarContainer$p(this.f36133a);
            if (r9 != null) goto L32;
            o.c("searchBarContainer");
        L33:
            r0.setFakePressed(false);
            return;
        L32:
            r0 = r9;
            goto L33
        L36:
            return;
        L25:
            if (r8.intValue() != 1) goto L27;
        L20:
            if (r8.intValue() != 3) goto L22;
        L5:
            r8 = Integer.valueOf(r7.getActionMasked());
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.searchbar.v2.OSearchBar$2, reason: invalid class name */
    /* JADX INFO: compiled from: OSearchBar.kt */
    static final class AnonymousClass2 extends p implements r<CharSequence, Integer, Integer, Integer, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OSearchBar f36134a;

        AnonymousClass2(OSearchBar r1) {
            this.f36134a = r1;
            super(4);
        }

        @Override // d.h.a.r
        public /* synthetic */ x a(CharSequence r3, Integer r4, Integer r5, Integer r6) {
            a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.aiagent.plugin")).intValue());
            return x.f38692a;
        }

        public final void a(CharSequence r1, int r2, int r3, int r4) {
            CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.aiagent.plugin");
            OSearchBar.access$updateClear(this.f36134a);
            OSearchBar.access$updateStateInternal(this.f36134a);
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.searchbar.v2.OSearchBar$3, reason: invalid class name */
    /* JADX INFO: compiled from: OSearchBar.kt */
    static final class AnonymousClass3 extends p implements d.h.a.b<Boolean, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OSearchBar f36135a;

        AnonymousClass3(OSearchBar r1) {
            this.f36135a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(Boolean r3) {
            a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
            return x.f38692a;
        }

        public final void a(boolean r1) {
            OSearchBar.access$updateStateInternal(this.f36135a);
        }
    }

    /* JADX INFO: compiled from: OSearchBar.kt */
    public static final class a {

        /* JADX INFO: renamed from: com.obric.oui.searchbar.v2.OSearchBar$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: OSearchBar.kt */
        public static final enum EnumC0986a extends Enum<EnumC0986a> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final EnumC0986a f36136a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final EnumC0986a f36137b = null;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final EnumC0986a f36138c = null;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private static final /* synthetic */ EnumC0986a[] f36139d = null;

            private static final /* synthetic */ EnumC0986a[] a() {
                return new EnumC0986a[]{f36136a, f36137b, f36138c};
            }

            public static EnumC0986a valueOf(String r2) {
                return (EnumC0986a) ZeusTransformUtils.preCheckCast(Enum.valueOf(EnumC0986a.class, r2), EnumC0986a.class, "com.obric.aiagent.plugin");
            }

            public static EnumC0986a[] values() {
                return (EnumC0986a[]) ZeusTransformUtils.preCheckCast(f36139d.clone(), EnumC0986a[].class, "com.obric.aiagent.plugin");
            }

            private EnumC0986a(String r1, int r2) {
                super(r1, r2);
            }

            static {
                f36136a = new EnumC0986a("RESTING", 0);
                f36137b = new EnumC0986a("ACTIVE", 1);
                f36138c = new EnumC0986a("VALUE", 2);
                f36139d = a();
            }
        }

        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OSearchBar.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f36140a = null;

        static {
            int[] r0 = new int[a.EnumC0986a.values().length];
            r0[a.EnumC0986a.f36136a.ordinal()] = 1;
            r0[a.EnumC0986a.f36137b.ordinal()] = 2;
            r0[a.EnumC0986a.f36138c.ordinal()] = 3;
            f36140a = r0;
        }
    }

    static {
        Companion = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OSearchBar(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "originContext");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void lambda$jhWeaav6reO0PmnK8mg7muNgDp8(OSearchBar r0, View r1) {
        m1151lambda4$lambda0(r0, r1);
    }

    public /* synthetic */ OSearchBar(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public static final /* synthetic */ OUILinearLayout access$getSearchBarContainer$p(OSearchBar r0) {
        return r0.searchBarContainer;
    }

    public static final /* synthetic */ void access$updateClear(OSearchBar r0) {
        r0.updateClear();
    }

    public static final /* synthetic */ void access$updateStateInternal(OSearchBar r0) {
        r0.updateStateInternal();
    }

    public OSearchBar(Context r25, AttributeSet r26) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r25, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r26, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r1, "originContext");
        super(r1, r9, 0, null, 12, null);
        this.isBackdropView = true;
        this.canShowClear = true;
        this.materialSrcType = -1;
        FrameLayout.inflate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.layout.o_widget_search_bar_v2, "layout", "o_widget_search_bar_v2"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"));
        setChangeAlphaWhenPress(false);
        if (k.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin")) == true) goto L5;
    L7:
        boolean r3 = false;
    L8:
        this.enabledMaterial = r3;
        View r4 = findViewById(ZeusTransformUtils.mapRes(R.id.searchbar_container, DbHelper.COL_ID, "searchbar_container"));
        o.c(r4, "findViewById(R.id.searchbar_container)");
        this.searchBarContainer = (OUILinearLayout) ZeusTransformUtils.preCheckCast(r4, OUILinearLayout.class, "com.obric.aiagent.plugin");
        View r5 = findViewById(ZeusTransformUtils.mapRes(R.id.input_view, DbHelper.COL_ID, "input_view"));
        o.c(r5, "findViewById(R.id.input_view)");
        OEditText r6 = (OEditText) ZeusTransformUtils.preCheckCast(r5, OEditText.class, "com.obric.aiagent.plugin");
        this.inputView = r6;
        r6.onOnTouchEvent$OUI_standardRelease((d.h.a.b) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), d.h.a.b.class, "com.obric.aiagent.plugin"));
        View r7 = findViewById(ZeusTransformUtils.mapRes(R.id.left_container, DbHelper.COL_ID, "left_container"));
        o.c(r7, "findViewById(R.id.left_container)");
        FrameLayout r8 = (FrameLayout) ZeusTransformUtils.preCheckCast(r7, FrameLayout.class, "com.obric.aiagent.plugin");
        this.leftContainer = r8;
        View r10 = findViewById(ZeusTransformUtils.mapRes(R.id.right_container, DbHelper.COL_ID, "right_container"));
        o.c(r10, "findViewById(R.id.right_container)");
        FrameLayout r11 = (FrameLayout) ZeusTransformUtils.preCheckCast(r10, FrameLayout.class, "com.obric.aiagent.plugin");
        this.rightContainer = r11;
        View r12 = findViewById(ZeusTransformUtils.mapRes(R.id.clear_action_container, DbHelper.COL_ID, "clear_action_container"));
        o.c(r12, "findViewById(R.id.clear_action_container)");
        ViewGroup r13 = (ViewGroup) ZeusTransformUtils.preCheckCast(r12, ViewGroup.class, "com.obric.aiagent.plugin");
        this.clearActionContainer = r13;
        View r14 = findViewById(ZeusTransformUtils.mapRes(R.id.clear_action, DbHelper.COL_ID, "clear_action"));
        o.c(r14, "findViewById(R.id.clear_action)");
        ImageView r15 = (ImageView) ZeusTransformUtils.preCheckCast(r14, ImageView.class, "com.obric.aiagent.plugin");
        this.clearAction = r15;
        Context r16 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r16, "context");
        int[] r17 = R.styleable.OSearchBar;
        o.c(r17, TAG);
        TypedArray r18 = r16.obtainStyledAttributes(r9, r17, 0, 0);
        o.c(r18, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        OUILinearLayout r19 = null;
        this.bgColor = r18.getColor(ZeusTransformUtils.mapRes(R.styleable.OSearchBar_oui_widgetBgColor, "styleable", "OSearchBar_oui_widgetBgColor"), ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_searchbar_bg, "color", "oui_searchbar_bg"), null));
        this.bgColorResting = r18.getColor(ZeusTransformUtils.mapRes(R.styleable.OSearchBar_oui_widgetBgColorResting, "styleable", "OSearchBar_oui_widgetBgColorResting"), ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_searchbar_bg_resting, "color", "oui_searchbar_bg_resting"), null));
        getInputView().setTextColor(r18.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.OSearchBar_oui_widgetTextColor, "styleable", "OSearchBar_oui_widgetTextColor")));
        ColorStateList r0 = r18.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.OSearchBar_oui_widgetTextColorHint, "styleable", "OSearchBar_oui_widgetTextColorHint"));
        getInputView().setHintTextColor(r0);
        r15.setImageTintList(r0);
        getInputView().setHint((CharSequence) ZeusTransformUtils.preCheckCast(r18.getString(ZeusTransformUtils.mapRes(R.styleable.OSearchBar_android_hint, "styleable", "OSearchBar_android_hint")), CharSequence.class, "com.obric.aiagent.plugin"));
        getInputView().setText((CharSequence) ZeusTransformUtils.preCheckCast(r18.getString(ZeusTransformUtils.mapRes(R.styleable.OSearchBar_android_text, "styleable", "OSearchBar_android_text")), CharSequence.class, "com.obric.aiagent.plugin"));
        if (r18.hasValue(ZeusTransformUtils.mapRes(R.styleable.OSearchBar_android_ellipsize, "styleable", "OSearchBar_android_ellipsize")) == false) goto L11;
        int r2 = 0;
        setEllipsize(parseEllipsize(r18.getInt(ZeusTransformUtils.mapRes(R.styleable.OSearchBar_android_ellipsize, "styleable", "OSearchBar_android_ellipsize"), 0)));
    L12:
        int r20 = r18.getLayoutDimension(ZeusTransformUtils.mapRes(R.styleable.OSearchBar_android_layout_height, "styleable", "OSearchBar_android_layout_height"), r2);
        if (r20 > 0) goto L15;
        com.obric.oui.d.a.b.e(TAG, o.a("searchBarHeight must be greater than 0, ", Integer.valueOf(r20)));
    L15:
        int r21 = r18.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OSearchBar_oui_search_postfixView, "styleable", "OSearchBar_oui_search_postfixView"), r2);
        if (r21 == 0) goto L18;
        FrameLayout.inflate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r21, (ViewGroup) ZeusTransformUtils.preCheckCast(r11, ViewGroup.class, "com.obric.aiagent.plugin"));
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.aiagent.plugin"));
    L18:
        int r22 = r18.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OSearchBar_oui_search_prefixView, "styleable", "OSearchBar_oui_search_prefixView"), ZeusTransformUtils.mapRes(R.layout.o_widget_search_bar_prefix_v2, "layout", "o_widget_search_bar_prefix_v2"));
        if (r22 == 0) goto L21;
        FrameLayout.inflate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r22, (ViewGroup) ZeusTransformUtils.preCheckCast(r8, ViewGroup.class, "com.obric.aiagent.plugin"));
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin"));
        updateViewWidth((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin"), r20);
    L21:
        updateViewWidth((View) ZeusTransformUtils.preCheckCast(r13, View.class, "com.obric.aiagent.plugin"), r20);
        r13.setOnClickListener(new $$Lambda$OSearchBar$jhWeaav6reO0PmnK8mg7muNgDp8(this));
        Context r23 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r23, "context");
        initShadows(r23, r18);
        if (this.enabledMaterial == false) goto L24;
        this.materialSrcType = r18.getInt(ZeusTransformUtils.mapRes(R.styleable.OSearchBar_oui_widgetMaterialSrcType, "styleable", "OSearchBar_oui_widgetMaterialSrcType"), -1);
        this.enabledMaterial = r18.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OSearchBar_oui_widgetEnableMaterial, "styleable", "OSearchBar_oui_widgetEnableMaterial"), false);
    L24:
        boolean r24 = isDarkTheme();
        if (this.enabledMaterial == false) goto L52;
        String r27 = r18.getString(ZeusTransformUtils.mapRes(R.styleable.OSearchBar_oui_widgetMaterial, "styleable", "OSearchBar_oui_widgetMaterial"));
        this.materialToken = r27;
        if (r27 != null) goto L29;
        this.materialToken = ZeusTransformUtils.getResources(r18, "com.obric.aiagent.plugin").getString(ZeusTransformUtils.mapRes(R.string.oui_material_bg_floating, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_material_bg_floating"));
    L29:
        this.materialTokenResting = r18.getString(ZeusTransformUtils.mapRes(R.styleable.OSearchBar_oui_widgetMaterialResting, "styleable", "OSearchBar_oui_widgetMaterialResting"));
        this.materialsActive = MaterialToken.parseSet(this.materialToken, !r24);
        String r28 = this.materialTokenResting;
        if (r28 == null) goto L32;
        c[] r29 = MaterialToken.parseSet(r28, !r24);
    L33:
        this.materialsResting = r29;
        if (r29 != null) goto L36;
        r29 = this.materialsActive;
    L36:
        this.currentMaterials = r29;
        if (r29 != null) goto L39;
        x r30 = null;
    L50:
        if (r30 != null) goto L52;
        this.enabledMaterial = false;
        goto L52
    L39:
        setBackground(null);
        int r31 = this.materialSrcType;
        if (r31 != (-1)) goto L43;
        r31 = 2;
    L43:
        int r210 = r31;
        OUILinearLayout r32 = this.searchBarContainer;
        if (r32 != null) goto L46;
        o.c("searchBarContainer");
        r32 = null;
    L46:
        GradientDrawable r33 = new GradientDrawable();
        r33.setShape(0);
        r33.setCornerRadius(com.obric.oui.common.util.g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 99));
        r33.setColor(0);
        r32.setBackground((Drawable) ZeusTransformUtils.preCheckCast(r33, Drawable.class, "com.obric.aiagent.plugin"));
        OUILinearLayout r34 = this.searchBarContainer;
        if (r34 != null) goto L49;
        o.c("searchBarContainer");
        r34 = null;
    L49:
        k.a((View) ZeusTransformUtils.preCheckCast(r34, View.class, "com.obric.aiagent.plugin"), r29, false, r210, null, 10, null);
        r30 = x.f38692a;
        goto L50
    L32:
        r29 = null;
    L52:
        r18.recycle();
        if ((!isDarkTheme()) == false) goto L58;
        OUILinearLayout r35 = this.searchBarContainer;
        if (r35 != null) goto L57;
        o.c("searchBarContainer");
        r35 = null;
    L57:
        r35.setOverridePressColor(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_fill_element_2_light, "color", "oui_basic_fill_element_2_light")));
    L62:
        OUILinearLayout r36 = this.searchBarContainer;
        if (r36 != null) goto L65;
        o.c("searchBarContainer");
    L66:
        r19.refreshColors(TAG);
        r6.onTextChanged$OUI_standardRelease((r) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this), r.class, "com.obric.aiagent.plugin"));
        r6.onFocusChange$OUI_standardRelease((d.h.a.b) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this), d.h.a.b.class, "com.obric.aiagent.plugin"));
        updateStateInternal();
        updateInputViewPadding();
        return;
    L65:
        r19 = r36;
        goto L66
    L58:
        OUILinearLayout r37 = this.searchBarContainer;
        if (r37 != null) goto L61;
        o.c("searchBarContainer");
        r37 = null;
    L61:
        r37.setOverridePressColor(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_fill_element_2_dark, "color", "oui_basic_fill_element_2_dark")));
        goto L62
    L11:
        r2 = 0;
        goto L12
    L5:
        if (l.d() == false) goto L7;
        r3 = true;
        goto L8
    }

    public final boolean isBackdropView() {
        return this.isBackdropView;
    }

    public final void setBackdropView(boolean r1) {
        this.isBackdropView = r1;
    }

    public final OEditText getInputView() {
        return this.inputView;
    }

    public final int getCurrentTheme() {
        return this.currentTheme;
    }

    public final void setCurrentTheme(int r1) {
        this.currentTheme = r1;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r2) {
        this.inputView.setEnabled(r2);
        super.setEnabled(r2);
    }

    /* JADX INFO: renamed from: lambda-4$lambda-0, reason: not valid java name */
    private static final void m1151lambda4$lambda0(OSearchBar r2, View r3) {
        o.e(r2, "this$0");
        r2.inputView.setText((CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.material.g
    public void applyContentMaterial(boolean r3) {
        com.obric.oui.material.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r3, this.isBackdropView);
    }

    @Override // com.obric.oui.material.g
    public void setBackdropTarget(View r3) {
        k.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r3);
    }

    @Override // com.obric.oui.material.g
    public void updateBackdropTargetType(boolean r3) {
        if (this.isBackdropView == r3) goto L12;
        this.isBackdropView = r3;
        if (this.materialSrcType == (-1)) goto L7;
        return;
    L7:
        OUILinearLayout r2 = this.searchBarContainer;
        if (r2 != null) goto L10;
        o.c("searchBarContainer");
        r2 = null;
    L10:
        k.c((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"), r3);
        return;
    }

    @Override // com.obric.oui.material.g
    public void updateBackdropSrcType(int r3) {
        this.materialSrcType = r3;
        OUILinearLayout r2 = this.searchBarContainer;
        if (r2 != null) goto L5;
        o.c("searchBarContainer");
        r2 = null;
    L5:
        k.a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"), r3);
    }

    private final void updateViewWidth(View r1, int r2) {
        if (r2 > 0) goto L5;
        com.obric.oui.d.a.b.e(TAG, o.a("newWidth must be greater than 0, ", Integer.valueOf(r2)));
        return;
    L5:
        ViewGroup.LayoutParams r0 = r1.getLayoutParams();
        r0.width = r2;
        r1.setLayoutParams(r0);
    }

    public void applyDynamicTheme(int r9) {
        if (this.currentTheme == r9) goto L16;
        this.currentTheme = r9;
        if (this.enabledMaterial == false) goto L17;
        String r10 = this.materialToken;
        if (r10 == null) goto L18;
        c[] r2 = MaterialToken.parseSet(r10, !isDarkTheme());
        if (r2 == null) goto L19;
        OUILinearLayout r8 = this.searchBarContainer;
        if (r8 != null) goto L14;
        o.c("searchBarContainer");
        r8 = null;
    L14:
        k.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin"), r2, false, 0, null, 14, null);
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }

    public boolean isDarkTheme() {
        int r0 = this.bgColor;
        if (r0 != 0) goto L7;
        return i.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"));
    L7:
        if (this.currentTheme != 2) goto L9;
    L12:
        return true;
    L9:
        if (d.a(r0) == true) goto L12;
        return false;
    }

    private final void initShadows(Context r4, TypedArray r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        List<j> r0 = f.a(r6, r5, ZeusTransformUtils.mapRes(R.styleable.OSearchBar_oui_widgetShadowNormal, "styleable", "OSearchBar_oui_widgetShadowNormal"));
        if (r0 == null) goto L5;
        this.shadowsNormal = r0;
    L5:
        List<j> r7 = f.a(r6, r5, ZeusTransformUtils.mapRes(R.styleable.OSearchBar_oui_widgetShadowResting, "styleable", "OSearchBar_oui_widgetShadowResting"));
        if (r7 == null) goto L9;
        this.shadowsResting = r7;
        return;
    }

    static /* synthetic */ void updateShadows$default(OSearchBar r0, a.EnumC0986a r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        r0.updateShadows(r1, r2);
    }

    private final void updateShadows(a.EnumC0986a r5, boolean r6) {
        if (this.shadowsNormal != null) goto L6;
        setShadow(j.f34540b, j.f34540b, false);
        return;
    L6:
        int r0 = com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 99);
        setShadowCornerRadius(r0);
        OUILinearLayout r3 = this.searchBarContainer;
        if (r3 != null) goto L9;
        o.c("searchBarContainer");
        r3 = null;
    L9:
        r3.setRadius(r0);
        if (r6 == true) goto L12;
        setShadow(j.f34540b, j.f34540b, true);
        return;
    L12:
        if (b.f36140a[r5.ordinal()] != 1) goto L17;
        List<j> r7 = this.shadowsResting;
        if (r7 == null) goto L16;
        o.a(r7);
        j r8 = (j) ZeusTransformUtils.preCheckCast(d.a.p.d(r7, 0), j.class, "com.obric.aiagent.plugin");
        List<j> r9 = this.shadowsResting;
        o.a(r9);
        setShadow(r8, (j) ZeusTransformUtils.preCheckCast(d.a.p.d(r9, 1), j.class, "com.obric.aiagent.plugin"), true);
        return;
    L16:
        setShadow(j.f34540b, j.f34540b, true);
        return;
    L17:
        List<j> r10 = this.shadowsNormal;
        o.a(r10);
        j r11 = (j) ZeusTransformUtils.preCheckCast(d.a.p.d(r10, 0), j.class, "com.obric.aiagent.plugin");
        List<j> r12 = this.shadowsNormal;
        o.a(r12);
        setShadow(r11, (j) ZeusTransformUtils.preCheckCast(d.a.p.d(r12, 1), j.class, "com.obric.aiagent.plugin"), true);
    }

    private final void updateStateInternal() {
        if (this.inputView.hasFocus() == false) goto L5;
        a.EnumC0986a r0 = a.EnumC0986a.f36137b;
    L15:
        int r3 = b.f36140a[r0.ordinal()];
        if (r3 == 1) goto L36;
        if (r3 == 2) goto L29;
        if (r3 == 3) goto L22;
    L42:
        updateMaterials(r0);
        return;
    L22:
        if (this.enabledMaterial == true) goto L27;
        OUILinearLayout r4 = this.searchBarContainer;
        if (r4 != null) goto L26;
        o.c("searchBarContainer");
        r4 = null;
    L26:
        r4.setBackgroundColor(this.bgColor);
    L27:
        this.leftContainer.setSelected(true);
        updateShadows$default(this, r0, false, 2, null);
        goto L42
    L29:
        if (this.enabledMaterial == true) goto L34;
        OUILinearLayout r5 = this.searchBarContainer;
        if (r5 != null) goto L33;
        o.c("searchBarContainer");
        r5 = null;
    L33:
        r5.setBackgroundColor(this.bgColor);
    L34:
        this.leftContainer.setSelected(true);
        updateShadows$default(this, r0, false, 2, null);
        goto L42
    L36:
        if (this.enabledMaterial == true) goto L41;
        OUILinearLayout r1 = this.searchBarContainer;
        if (r1 != null) goto L40;
        o.c("searchBarContainer");
        r1 = null;
    L40:
        r1.setBackgroundColor(this.bgColorResting);
    L41:
        this.leftContainer.setSelected(false);
        updateShadows$default(this, r0, false, 2, null);
        goto L42
    L5:
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(this.inputView.getText(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L8;
    L11:
        boolean r6 = true;
    L12:
        if (r6 == false) goto L14;
        r0 = a.EnumC0986a.f36136a;
        goto L15
    L14:
        r0 = a.EnumC0986a.f36138c;
        goto L15
    L8:
        if (r2.length() == 0) goto L11;
        r6 = false;
        goto L12
    }

    private final void updateMaterials(a.EnumC0986a r8) {
        if (this.enabledMaterial == true) goto L6;
        return;
    L6:
        if (r8 != a.EnumC0986a.f36136a) goto L10;
        c[] r9 = this.materialsResting;
        if (r9 != null) goto L11;
        r9 = this.materialsActive;
    L11:
        c[] r1 = r9;
        this.currentMaterials = r1;
        if (r1 == null) goto L23;
        int r10 = this.materialSrcType;
        if (r10 != (-1)) goto L18;
        r10 = 2;
    L18:
        int r3 = r10;
        OUILinearLayout r7 = this.searchBarContainer;
        if (r7 != null) goto L21;
        o.c("searchBarContainer");
        r7 = null;
    L21:
        k.a((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.aiagent.plugin"), r1, false, r3, null, 10, null);
        return;
    L23:
        return;
    L10:
        r9 = this.materialsActive;
        goto L11
    }

    private final void updateClear() {
        int r1 = 8;
        boolean r2 = true;
        if (this.canShowClear == true) goto L5;
        this.clearActionContainer.setVisibility(8);
    L16:
        if (((View) ZeusTransformUtils.preCheckCast(this.clearActionContainer, View.class, "com.obric.aiagent.plugin")).getVisibility() != 0) goto L18;
        boolean r0 = true;
    L19:
        if (r0 == false) goto L22;
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(this.rightContainer, View.class, "com.obric.aiagent.plugin"));
    L27:
        updateInputViewPadding();
        return;
    L22:
        if (((ViewGroup) ZeusTransformUtils.preCheckCast(this.rightContainer, ViewGroup.class, "com.obric.aiagent.plugin")).getChildCount() != 0) goto L25;
        r2 = false;
    L25:
        if (r2 == false) goto L27;
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(this.rightContainer, View.class, "com.obric.aiagent.plugin"));
        goto L27
    L18:
        r0 = false;
        goto L19
    L5:
        ViewGroup r3 = this.clearActionContainer;
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(this.inputView.getText(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L8;
    L11:
        boolean r6 = true;
    L12:
        if (r6 == true) goto L14;
        r1 = 0;
    L14:
        r3.setVisibility(r1);
        goto L16
    L8:
        if (r5.length() == 0) goto L11;
        r6 = false;
        goto L12
    }

    private final void updateInputViewPadding() {
        if (this.leftContainer.getVisibility() != 0) goto L5;
        int r0 = 0;
    L6:
        boolean r4 = true;
        if (((View) ZeusTransformUtils.preCheckCast(this.clearActionContainer, View.class, "com.obric.aiagent.plugin")).getVisibility() != 0) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L12;
    L18:
        int r1 = com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 0);
    L19:
        this.inputView.setPaddingRelative(r0, 0, r1, 0);
        return;
    L12:
        if (((View) ZeusTransformUtils.preCheckCast(this.rightContainer, View.class, "com.obric.aiagent.plugin")).getVisibility() == 0) goto L15;
        r4 = false;
    L15:
        if (r4 == true) goto L18;
        r1 = com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 8);
        goto L19
    L9:
        r3 = false;
        goto L10
    L5:
        r0 = com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12);
        goto L6
    }

    public final void setText(String r3) {
        o.e(r3, "text");
        this.inputView.setText((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"));
    }

    public final CharSequence getText() {
        Editable r2 = this.inputView.getText();
        if (r2 != null) goto L5;
        Object r3 = ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin");
    L7:
        return (CharSequence) r3;
    L5:
        r3 = ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin");
        goto L7
    }

    public final void setEllipsize(TextUtils.TruncateAt r1) {
        this.inputView.setEllipsize(r1);
    }

    public final TextUtils.TruncateAt getEllipsize() {
        return this.inputView.getEllipsize();
    }

    public final void setOnInputFocusChange(View.OnFocusChangeListener r3) {
        View.OnFocusChangeListener r4 = (View.OnFocusChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnFocusChangeListener.class, "com.obric.aiagent.plugin");
        o.e(r4, "onFocusChangeListener");
        this.inputView.setOnFocusChangeListener(r4);
    }

    public final View getPrefixView() {
        if (((ViewGroup) ZeusTransformUtils.preCheckCast(this.leftContainer, ViewGroup.class, "com.obric.aiagent.plugin")).getChildCount() == 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L10;
        return null;
    L10:
        return this.leftContainer.getChildAt(0);
    L5:
        r0 = false;
        goto L6
    }

    public final View getPostfixView() {
        if (((ViewGroup) ZeusTransformUtils.preCheckCast(this.rightContainer, ViewGroup.class, "com.obric.aiagent.plugin")).getChildCount() == 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L10;
        return null;
    L10:
        return this.rightContainer.getChildAt(0);
    L5:
        r0 = false;
        goto L6
    }

    public final void setPrefixView(View r3) {
        this.leftContainer.removeAllViews();
        if (r3 != null) goto L5;
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(this.leftContainer, View.class, "com.obric.aiagent.plugin"));
    L6:
        updateInputViewPadding();
        return;
    L5:
        r3.setDuplicateParentStateEnabled(true);
        this.leftContainer.addView(r3);
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(this.leftContainer, View.class, "com.obric.aiagent.plugin"));
        goto L6
    }

    public final void setPostfixView(View r3) {
        this.rightContainer.removeAllViews();
        if (r3 != null) goto L5;
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(this.rightContainer, View.class, "com.obric.aiagent.plugin"));
    L6:
        updateInputViewPadding();
        return;
    L5:
        this.rightContainer.addView(r3);
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(this.rightContainer, View.class, "com.obric.aiagent.plugin"));
        goto L6
    }

    public final void setCanShowClear(boolean r1) {
        this.canShowClear = r1;
        updateClear();
    }

    private final TextUtils.TruncateAt parseEllipsize(int r1) {
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L19;
        if (r1 == 3) goto L18;
        if (r1 == 4) goto L17;
        return null;
    L17:
        return TextUtils.TruncateAt.MARQUEE;
    L18:
        return TextUtils.TruncateAt.END;
    L19:
        return TextUtils.TruncateAt.MIDDLE;
    L15:
        return TextUtils.TruncateAt.START;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r3) {
        super.onConfigurationChanged(r3);
        this.materialsActive = MaterialToken.parseSet(this.materialToken, !i.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin")));
        String r4 = this.materialTokenResting;
        if (r4 == null) goto L5;
        c[] r5 = MaterialToken.parseSet(r4, !i.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin")));
    L6:
        this.materialsResting = r5;
        updateStateInternal();
        return;
    L5:
        r5 = null;
        goto L6
    }
}
