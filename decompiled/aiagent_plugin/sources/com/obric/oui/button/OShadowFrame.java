package com.obric.oui.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.graphics.e;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.common.oea.foundation.animation.manager.d;
import com.obric.oui.common.style.f;
import com.obric.oui.common.style.i;
import com.obric.oui.common.style.j;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.g;
import com.obric.oui.material.k;
import com.obric.oui.material.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.m;
import d.h.a.q;
import d.h.b.h;
import d.h.b.o;
import d.h.b.p;
import d.l.n;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: OShadowFrame.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class OShadowFrame extends OUIFrameLayout implements g {
    public static final a Companion = null;
    private static final String TAG = "OShadowFrame";
    private float animAccuracy;
    private int bgColorDisabled;
    private int bgColorNormal;
    protected OUIFrameLayout contentContainer;
    protected OUIFrameLayout contentView;
    private int currentTheme;
    private boolean enableMaterial;
    private final float initScale;
    private boolean isBackdropView;
    private boolean isMaterialFromDrawable;
    private boolean materialApplied;
    private String materialDisabledTokenString;
    private int materialSrcType;
    private String materialTokenString;
    private com.obric.oui.material.c[] materials;
    private com.obric.oui.material.c[] materialsDisabled;
    private d pressAnim;
    private int pressColor;
    private float pressScale;
    private d releaseAnim;
    private float shadowAlphaProgress;
    private List<j> shadowsNormal;
    private List<j> shadowsPressed;

    /* JADX INFO: compiled from: OShadowFrame.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OShadowFrame.kt */
    static final class b extends p implements q<String, Object, Object, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OShadowFrame f34310a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f34311b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f34312c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ List<j> f34313d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ List<j> f34314e;

        b(OShadowFrame r3, float r4, float r5, List<j> r6, List<j> r7) {
            List<j> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
            List<j> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
            this.f34310a = r3;
            this.f34311b = r4;
            this.f34312c = r5;
            this.f34313d = r8;
            this.f34314e = r9;
            super(3);
        }

        @Override // d.h.a.q
        public /* synthetic */ x invoke(String r3, Object r4, Object r5) {
            a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), r4, r5);
            return x.f38692a;
        }

        public final void a(String r7, Object r8, Object r9) {
            o.e(r7, "$noName_0");
            o.e(r8, "value");
            o.e(r9, "$noName_2");
            float r1 = ((Float) ZeusTransformUtils.preCheckCast(r8, Float.class, "com.obric.aiagent.plugin")).floatValue();
            this.f34310a.applyPressScaleForAnimation(r1);
            List<j> r10 = j.f34539a.a(r1, this.f34311b, this.f34312c, this.f34313d, this.f34314e);
            if (r10 == null) goto L6;
            this.f34310a.updateShadows(r10);
            return;
        }
    }

    /* JADX INFO: compiled from: OShadowFrame.kt */
    static final class c extends p implements m<Boolean, Throwable, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OShadowFrame f34315a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<j> f34316b;

        c(OShadowFrame r3, List<j> r4) {
            List<j> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            this.f34315a = r3;
            this.f34316b = r5;
            super(2);
        }

        @Override // d.h.a.m
        public /* synthetic */ x invoke(Boolean r3, Throwable r4) {
            a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue(), (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(boolean r4, Throwable r5) {
            if (r4 == false) goto L13;
            OShadowFrame r6 = this.f34315a;
            List<j> r7 = this.f34316b;
            j r0 = null;
            if (r7 != null) goto L6;
            j r8 = null;
        L7:
            List<j> r3 = this.f34316b;
            if (r3 == null) goto L11;
            r0 = (j) ZeusTransformUtils.preCheckCast(d.a.p.d(r3, 1), j.class, "com.obric.aiagent.plugin");
        L11:
            r6.a(r8, r0);
            return;
        L6:
            r8 = (j) ZeusTransformUtils.preCheckCast(d.a.p.d(r7, 0), j.class, "com.obric.aiagent.plugin");
            goto L7
        }
    }

    static {
        Companion = new a(null);
    }

    public OShadowFrame(Context r8) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 0, 14, null);
    }

    public OShadowFrame(Context r10, AttributeSet r11) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 0, 12, null);
    }

    public OShadowFrame(Context r10, AttributeSet r11, int r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, r12, 0, 8, null);
    }

    public abstract void initContent(Context r1, FrameLayout r2, AttributeSet r3, TypedArray r4);

    public final void setMaterialByTokenString(String r7, String r8) {
        setMaterialByTokenString$default(this, r7, r8, false, 4, null);
    }

    public final void setMaterialConfigs(com.obric.oui.material.c r7, com.obric.oui.material.c r8) {
        setMaterialConfigs$default(this, r7, r8, false, 4, null);
    }

    public final void setMaterialConfigs(com.obric.oui.material.c[] r7, com.obric.oui.material.c[] r8) {
        setMaterialConfigs$default(this, r7, r8, false, 4, null);
    }

    public boolean shouldHandlePressAnimation(boolean r1) {
        return true;
    }

    public /* synthetic */ OShadowFrame(Context r2, AttributeSet r3, int r4, int r5, int r6, h r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r6 & 2) == 0) goto L6;
        r9 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = 0;
    L11:
        this(r8, r9, r4, r5);
    }

    public OShadowFrame(Context r9, AttributeSet r10, int r11, int r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r14 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r13, "context");
        super(r13, r14, r11, null, 8, null);
        this.initScale = 1.0f;
        this.pressScale = 1.0f;
        this.animAccuracy = 0.01f;
        this.shadowAlphaProgress = 1.0f;
        boolean r15 = true;
        this.isBackdropView = true;
        this.materialSrcType = 2;
        if (k.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin")) == true) goto L5;
    L7:
        r15 = false;
    L8:
        this.enableMaterial = r15;
        this.materialApplied = r15;
        initView(r13, r14);
        return;
    L5:
        if (l.d() == false) goto L7;
        goto L7
    }

    public final int getBgColorNormal() {
        return this.bgColorNormal;
    }

    public final void setBgColorNormal(int r1) {
        this.bgColorNormal = r1;
    }

    public final int getBgColorDisabled() {
        return this.bgColorDisabled;
    }

    public final void setBgColorDisabled(int r1) {
        this.bgColorDisabled = r1;
    }

    public final OUIFrameLayout getContentView() {
        OUIFrameLayout r0 = this.contentView;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("contentView");
        return null;
    }

    public final void setContentView(OUIFrameLayout r2) {
        o.e(r2, "<set-?>");
        this.contentView = r2;
    }

    public final OUIFrameLayout getContentContainer() {
        OUIFrameLayout r0 = this.contentContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("contentContainer");
        return null;
    }

    public final void setContentContainer(OUIFrameLayout r2) {
        o.e(r2, "<set-?>");
        this.contentContainer = r2;
    }

    public final int getCurrentTheme() {
        return this.currentTheme;
    }

    public final void setCurrentTheme(int r1) {
        this.currentTheme = r1;
    }

    public final boolean getEnableMaterial() {
        return this.enableMaterial;
    }

    public final void setEnableMaterial(boolean r1) {
        this.enableMaterial = r1;
    }

    public final String getMaterialTokenString() {
        return this.materialTokenString;
    }

    public final void setMaterialTokenString(String r1) {
        this.materialTokenString = r1;
    }

    public final String getMaterialDisabledTokenString() {
        return this.materialDisabledTokenString;
    }

    public final void setMaterialDisabledTokenString(String r1) {
        this.materialDisabledTokenString = r1;
    }

    public final com.obric.oui.material.c[] getMaterials() {
        return this.materials;
    }

    public final void setMaterials(com.obric.oui.material.c[] r1) {
        this.materials = r1;
    }

    public final boolean getMaterialApplied() {
        return this.materialApplied;
    }

    public final void setMaterialApplied(boolean r1) {
        this.materialApplied = r1;
    }

    public final boolean isBackdropView() {
        return this.isBackdropView;
    }

    public final void setBackdropView(boolean r1) {
        this.isBackdropView = r1;
    }

    public final com.obric.oui.material.c[] getMaterialsDisabled() {
        return this.materialsDisabled;
    }

    public final void setMaterialsDisabled(com.obric.oui.material.c[] r1) {
        this.materialsDisabled = r1;
    }

    public final int getMaterialSrcType() {
        return this.materialSrcType;
    }

    public final void setMaterialSrcType(int r1) {
        this.materialSrcType = r1;
    }

    public final boolean isMaterialFromDrawable() {
        return this.isMaterialFromDrawable;
    }

    public final void setMaterialFromDrawable(boolean r1) {
        this.isMaterialFromDrawable = r1;
    }

    private final void initView(Context r14, AttributeSet r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r14, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r17 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r15, AttributeSet.class, "com.obric.aiagent.plugin");
        TypedArray r0 = r16.obtainStyledAttributes(r17, R.styleable.OShadowFrame);
        o.c(r0, "context.obtainStyledAttr…R.styleable.OShadowFrame)");
        if (this.enableMaterial == false) goto L5;
        boolean r2 = r0.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetEnableMaterial, "styleable", "OShadowFrame_oui_widgetEnableMaterial"), true);
        this.enableMaterial = r2;
        this.materialApplied = r2;
    L5:
        AttributeSet r4 = null;
        int r5 = 0;
        i r6 = null;
        int r7 = 14;
        h r8 = null;
        setContentView(new OUIFrameLayout(r16, r4, r5, r6, r7, r8));
        setContentContainer(new OUIFrameLayout(r16, r4, r5, r6, r7, r8));
        getContentView().setDuplicateParentStateEnabled(true);
        getContentContainer().setDuplicateParentStateEnabled(true);
        OUIFrameLayout r9 = null;
        this.bgColorNormal = r0.getColor(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetBgColor, "styleable", "OShadowFrame_oui_widgetBgColor"), ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_floating_button_bg_color_1, "color", "oui_floating_button_bg_color_1"), null));
        this.bgColorDisabled = r0.getColor(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetBgColorDisabled, "styleable", "OShadowFrame_oui_widgetBgColorDisabled"), ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_floating_button_bg_color_1, "color", "oui_floating_button_bg_color_1"), null));
        if (this.bgColorNormal == 0) goto L8;
        getContentView().setBackgroundColor(this.bgColorNormal);
    L8:
        this.pressScale = r0.getFloat(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetPressScale, "styleable", "OShadowFrame_oui_widgetPressScale"), 1.0f);
        setChangeAlphaWhenPress(false);
        int r3 = r0.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetPaddingL, "styleable", "OShadowFrame_oui_widgetPaddingL"), 0);
        int r10 = r0.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetPaddingR, "styleable", "OShadowFrame_oui_widgetPaddingR"), 0);
        int r11 = r0.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetPaddingT, "styleable", "OShadowFrame_oui_widgetPaddingT"), 0);
        int r12 = r0.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetPaddingB, "styleable", "OShadowFrame_oui_widgetPaddingB"), 0);
        int r13 = r0.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetRadius, "styleable", "OShadowFrame_oui_widgetRadius"), 0);
        Drawable r18 = r0.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetMaterialBackground, "styleable", "OShadowFrame_oui_widgetMaterialBackground"));
        getContentView().setRadius(r13);
        getContentContainer().setPadding(r3, r11, r10, r12);
        getContentContainer().setRadius(r13);
        this.pressColor = r0.getColor(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetPressColor, "styleable", "OShadowFrame_oui_widgetPressColor"), 0);
        getContentView().setOverridePressColor(this.pressColor);
        getContentView().refreshColors(TAG);
        getContentView().addView((View) ZeusTransformUtils.preCheckCast(getContentContainer(), View.class, "com.obric.aiagent.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -1), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        addView((View) ZeusTransformUtils.preCheckCast(getContentView(), View.class, "com.obric.aiagent.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -1), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        setShadowCornerRadius(r13);
        initContent(r16, (FrameLayout) ZeusTransformUtils.preCheckCast(getContentContainer(), FrameLayout.class, "com.obric.aiagent.plugin"), r17, r0);
        if (r18 == null) goto L11;
        boolean r19 = true;
    L12:
        this.isMaterialFromDrawable = r19;
        if (r19 == false) goto L15;
        getContentView().setBackground(r18);
        getContentView().setChangeAlphaWhenPress(false);
        getContentView().setChangeAlphaWhenDisable(false);
    L15:
        com.obric.oui.d.c r110 = com.obric.oui.d.c.f35012a;
        OUIFrameLayout r111 = getContentView();
        if (r111 != null) goto L19;
    L17:
        r111 = null;
    L20:
        com.obric.oui.common.style.a r112 = (com.obric.oui.common.style.a) ZeusTransformUtils.preCheckCast(r111, com.obric.oui.common.style.a.class, "com.obric.aiagent.plugin");
        if (r112 == null) goto L24;
        r112.setChangeAlphaWhenDisable(false);
    L24:
        com.obric.oui.d.c r113 = com.obric.oui.d.c.f35012a;
        OUIFrameLayout r114 = getContentView();
        if (r114 != null) goto L28;
    L26:
        r114 = null;
    L29:
        com.obric.oui.common.style.a r115 = (com.obric.oui.common.style.a) ZeusTransformUtils.preCheckCast(r114, com.obric.oui.common.style.a.class, "com.obric.aiagent.plugin");
        if (r115 == null) goto L33;
        r115.setChangeAlphaWhenEnabledChanged(false);
    L33:
        com.obric.oui.d.c r116 = com.obric.oui.d.c.f35012a;
        OUIFrameLayout r117 = getContentContainer();
        if (r117 != null) goto L37;
    L39:
        com.obric.oui.common.style.a r118 = (com.obric.oui.common.style.a) ZeusTransformUtils.preCheckCast(r9, com.obric.oui.common.style.a.class, "com.obric.aiagent.plugin");
        if (r118 == null) goto L43;
        r118.setChangeAlphaWhenDisable(false);
    L43:
        setChangeAlphaWhenDisable(false);
        initShadows(r16, r0);
        r0.recycle();
        setClipChildren(false);
        setClickable(true);
        updateUIOnEnableChanged(isEnabled());
        return;
    L37:
        if (ZeusTransformUtils.instanceOf(r117, com.obric.oui.common.style.a.class) == false) goto L39;
        r9 = r117;
        goto L39
    L28:
        if (ZeusTransformUtils.instanceOf(r114, com.obric.oui.common.style.a.class) == false) goto L26;
    L19:
        if (ZeusTransformUtils.instanceOf(r111, com.obric.oui.common.style.a.class) == false) goto L17;
    L11:
        r19 = false;
        goto L12
    }

    private final void initShadows(Context r6, TypedArray r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        List<j> r0 = f.a(r8, r7, ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetShadowNormal, "styleable", "OShadowFrame_oui_widgetShadowNormal"));
        if (r0 == null) goto L5;
        this.shadowsNormal = r0;
        o.a(r0);
        j r1 = (j) ZeusTransformUtils.preCheckCast(d.a.p.d(r0, 0), j.class, "com.obric.aiagent.plugin");
        List<j> r3 = this.shadowsNormal;
        o.a(r3);
        a(r1, (j) ZeusTransformUtils.preCheckCast(d.a.p.d(r3, 1), j.class, "com.obric.aiagent.plugin"));
    L5:
        List<j> r9 = f.a(r8, r7, ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetShadowPressed, "styleable", "OShadowFrame_oui_widgetShadowPressed"));
        if (r9 == null) goto L9;
        this.shadowsPressed = r9;
        return;
    }

    public static /* synthetic */ void initContent$default(OShadowFrame r2, Context r3, FrameLayout r4, AttributeSet r5, TypedArray r6, int r7, Object r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L10;
        if ((r7 & 8) == 0) goto L7;
        r6 = null;
    L7:
        r2.initContent(r9, r4, r10, r6);
        return;
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initContent");
    }

    public final void initMaterials(Context r7, TypedArray r8) {
        o.e((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin"), "context");
        o.e(r8, "typedArray");
        this.materialSrcType = r8.getInt(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetMaterialSrcType, "styleable", "OShadowFrame_oui_widgetMaterialSrcType"), 2);
        String r9 = r8.getString(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetMaterial, "styleable", "OShadowFrame_oui_widgetMaterial"));
        boolean r2 = com.obric.oui.color.d.c(this.bgColorNormal);
        if (r9 != null) goto L6;
        if (r2 == true) goto L6;
        r9 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getString(ZeusTransformUtils.mapRes(R.string.oui_material_bg_floating, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_material_bg_floating"));
    L6:
        this.materialTokenString = r9;
        boolean r3 = isDarkTheme();
        if (r2 == false) goto L12;
        this.materials = com.obric.oui.material.d.f35485a.a((com.obric.oui.material.c[]) ZeusTransformUtils.preCheckCast(MaterialToken.OUI_Bg_Floating_Tinted.invoke(Boolean.valueOf(!r3)), com.obric.oui.material.c[].class, "com.obric.aiagent.plugin"), this.bgColorNormal);
        if (this.bgColorDisabled == 0) goto L17;
        this.materialsDisabled = com.obric.oui.material.d.f35485a.a((com.obric.oui.material.c[]) ZeusTransformUtils.preCheckCast(MaterialToken.OUI_Bg_Floating_Tinted.invoke(Boolean.valueOf(!r3)), com.obric.oui.material.c[].class, "com.obric.aiagent.plugin"), this.bgColorDisabled);
    L17:
        if (this.materials != null) goto L20;
        this.enableMaterial = false;
        this.materialApplied = false;
        return;
    L20:
        return;
    L12:
        if (this.materialTokenString == null) goto L17;
        this.materials = MaterialToken.parseSet(r9, !r3);
        String r10 = r8.getString(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetMaterialDisabled, "styleable", "OShadowFrame_oui_widgetMaterialDisabled"));
        this.materialDisabledTokenString = r10;
        if (r10 == null) goto L17;
        this.materialsDisabled = MaterialToken.parseSet(r10, !r3);
        goto L17
    }

    @Override // com.obric.oui.material.g
    public void updateBackdropSrcType(int r3) {
        this.materialSrcType = r3;
        k.a((View) ZeusTransformUtils.preCheckCast(getContentView(), View.class, "com.obric.aiagent.plugin"), r3);
    }

    private final void checkColorfulBgMaterial(boolean r6) {
        e.b(this.bgColorNormal, 48);
        if (com.obric.oui.color.d.c(this.bgColorNormal) == false) goto L9;
        com.obric.oui.material.c[] r0 = com.obric.oui.material.d.f35485a.a((com.obric.oui.material.c[]) ZeusTransformUtils.preCheckCast(MaterialToken.OUI_Bg_Floating_Tinted.invoke(Boolean.valueOf(!r6)), com.obric.oui.material.c[].class, "com.obric.aiagent.plugin"), this.bgColorNormal);
        if (this.bgColorDisabled == 0) goto L7;
        com.obric.oui.material.c[] r7 = com.obric.oui.material.d.f35485a.a((com.obric.oui.material.c[]) ZeusTransformUtils.preCheckCast(MaterialToken.OUI_Bg_Floating_Tinted.invoke(Boolean.valueOf(!r6)), com.obric.oui.material.c[].class, "com.obric.aiagent.plugin"), this.bgColorDisabled);
    L8:
        setMaterialConfigs(r0, r7, false);
        return;
    L7:
        r7 = null;
        goto L8
    L9:
        String r1 = this.materialTokenString;
        if (r1 == null) goto L15;
        com.obric.oui.material.c[] r2 = MaterialToken.parseSet(r1, !r6);
        this.materials = r2;
        String r3 = this.materialDisabledTokenString;
        if (r3 == null) goto L14;
        this.materialsDisabled = MaterialToken.parseSet(r3, !r6);
        return;
    L14:
        this.materialsDisabled = r2;
        return;
    L15:
        setMaterialConfigs((com.obric.oui.material.c[]) ZeusTransformUtils.preCheckCast(MaterialToken.OUI_Bg_Floating.invoke(Boolean.valueOf(!r6)), com.obric.oui.material.c[].class, "com.obric.aiagent.plugin"), (com.obric.oui.material.c[]) ZeusTransformUtils.preCheckCast(MaterialToken.OUI_Bg_Floating.invoke(Boolean.valueOf(!r6)), com.obric.oui.material.c[].class, "com.obric.aiagent.plugin"), false);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        getContentView().setEnabled(r2);
        getContentContainer().setEnabled(r2);
        updateUIOnEnableChanged(r2);
    }

    @Override // com.obric.oui.material.g
    public void applyContentMaterial(boolean r4) {
        this.materialApplied = r4;
        com.obric.oui.material.h.a((View) ZeusTransformUtils.preCheckCast(getContentView(), View.class, "com.obric.aiagent.plugin"), r4, this.materialSrcType);
        updateUIOnEnableChanged(isEnabled());
        invalidate();
    }

    @Override // com.obric.oui.material.g
    public void setBackdropTarget(View r3) {
        k.a((View) ZeusTransformUtils.preCheckCast(getContentView(), View.class, "com.obric.aiagent.plugin"), r3);
    }

    @Override // com.obric.oui.material.g
    public void updateBackdropTargetType(boolean r3) {
        if (this.isBackdropView == r3) goto L6;
        this.isBackdropView = r3;
        k.c((View) ZeusTransformUtils.preCheckCast(getContentView(), View.class, "com.obric.aiagent.plugin"), r3);
        return;
    }

    public final void setContentSelfBlur(float r6) {
        l.a(getContentContainer(), 1, 0, (View) ZeusTransformUtils.preCheckCast(getContentContainer(), View.class, "com.obric.aiagent.plugin"));
        OUIFrameLayout r0 = getContentContainer();
        Float r5 = com.obric.oui.material.m.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r6);
        if (r5 == null) goto L6;
        r6 = r5.floatValue();
    L6:
        l.a(r0, r6);
    }

    public final void setContentShadowAlphaProgress(float r6) {
        float r7 = n.a(r6, 0.0f, 1.0f);
        if (this.shadowAlphaProgress != r7) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        this.shadowAlphaProgress = r7;
        List<j> r1 = this.shadowsNormal;
        if (r1 != null) goto L12;
        return;
    L12:
        if (r7 < 1.0f) goto L14;
        updateShadows(r1);
        return;
    L14:
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r2, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r4 = r2.iterator();
    L16:
        if (r4.hasNext() == false) goto L18;
        r3.add(copyWithAlphaProgress((j) ZeusTransformUtils.preCheckCast(r4.next(), j.class, "com.obric.aiagent.plugin"), r7));
        goto L16
    L18:
        updateShadows((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        r0 = false;
        goto L6
    }

    private final j copyWithAlphaProgress(j r3, float r4) {
        j r2 = r3.j();
        r2.a(e.b(r3.a(), n.a(d.i.a.a(Color.alpha(r3.a()) * r4), 0, 255)));
        return r2;
    }

    public void setBgColor(int r2) {
        if (this.bgColorNormal == r2) goto L14;
        this.bgColorNormal = r2;
        this.bgColorDisabled = r2;
        boolean r3 = com.obric.oui.color.d.a(r2);
        checkColorfulBgMaterial(r3);
        if (r3 == false) goto L7;
        int r4 = 2;
    L9:
        if (r4 == this.currentTheme) goto L12;
        applyDynamicTheme(r4);
        return;
    L12:
        updateUIOnEnableChanged(isEnabled());
        return;
    L7:
        r4 = 1;
        goto L9
    }

    public void setBgColors(int r1, int r2) {
        this.bgColorNormal = r1;
        this.bgColorDisabled = r2;
        boolean r3 = com.obric.oui.color.d.a(r1);
        checkColorfulBgMaterial(r3);
        if (r3 == false) goto L5;
        int r4 = 2;
    L7:
        if (r4 == this.currentTheme) goto L10;
        applyDynamicTheme(r4);
        return;
    L10:
        updateUIOnEnableChanged(isEnabled());
        return;
    L5:
        r4 = 1;
        goto L7
    }

    public void setBgColors(int r1, int r2, String r3, String r4) {
        this.bgColorNormal = r1;
        this.bgColorDisabled = r2;
        if (r3 == null) goto L7;
        setMaterialByTokenString(r3, r4, false);
    L7:
        if (com.obric.oui.color.d.a(r1) == false) goto L9;
        int r5 = 2;
    L11:
        if (r5 == this.currentTheme) goto L14;
        applyDynamicTheme(r5);
        return;
    L14:
        updateUIOnEnableChanged(isEnabled());
        return;
    L9:
        r5 = 1;
        goto L11
    }

    public void setBgColors(int r1, int r2, com.obric.oui.material.c[] r3, com.obric.oui.material.c[] r4) {
        this.bgColorNormal = r1;
        this.bgColorDisabled = r2;
        setMaterialConfigs(r3, r4, false);
        if (com.obric.oui.color.d.a(r1) == false) goto L5;
        int r5 = 2;
    L7:
        if (r5 == this.currentTheme) goto L10;
        applyDynamicTheme(r5);
        return;
    L10:
        updateUIOnEnableChanged(isEnabled());
        return;
    L5:
        r5 = 1;
        goto L7
    }

    public void setPressColor(int r2) {
        this.pressColor = r2;
        getContentView().setOverridePressColor(this.pressColor);
        getContentView().refreshColors(TAG);
    }

    public static /* synthetic */ void setMaterialByTokenString$default(OShadowFrame r0, String r1, String r2, boolean r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 4) == 0) goto L6;
        r3 = true;
    L6:
        r0.setMaterialByTokenString(r1, r2, r3);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMaterialByTokenString");
    }

    public void setMaterialByTokenString(String r4, String r5, boolean r6) {
        if ((!o.a(this.materialTokenString, r4)) == false) goto L5;
        this.materialTokenString = r4;
        this.materials = MaterialToken.parseSet(r4, !isDarkTheme());
    L5:
        String r7 = this.materialDisabledTokenString;
        if (r7 != null) goto L8;
        boolean r8 = true;
    L10:
        if ((!r8) == false) goto L12;
        this.materialDisabledTokenString = r5;
        this.materialsDisabled = MaterialToken.parseSet(r5, !isDarkTheme());
    L12:
        if (r6 == false) goto L15;
        updateUIOnEnableChanged(isEnabled());
        return;
    L15:
        return;
    L8:
        r8 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"));
        goto L10
    }

    public static /* synthetic */ void setMaterialConfigs$default(OShadowFrame r0, com.obric.oui.material.c r1, com.obric.oui.material.c r2, boolean r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 4) == 0) goto L6;
        r3 = true;
    L6:
        r0.setMaterialConfigs(r1, r2, r3);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMaterialConfigs");
    }

    public void setMaterialConfigs(com.obric.oui.material.c r5, com.obric.oui.material.c r6, boolean r7) {
        com.obric.oui.material.c[] r0 = null;
        if (r5 != null) goto L5;
        com.obric.oui.material.c[] r3 = null;
    L6:
        if (r6 == null) goto L9;
        r0 = new com.obric.oui.material.c[]{r6};
    L9:
        setMaterialConfigs(r3, r0, r7);
        return;
    L5:
        r3 = new com.obric.oui.material.c[]{r5};
        goto L6
    }

    public static /* synthetic */ void setMaterialConfigs$default(OShadowFrame r0, com.obric.oui.material.c[] r1, com.obric.oui.material.c[] r2, boolean r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 4) == 0) goto L6;
        r3 = true;
    L6:
        r0.setMaterialConfigs(r1, r2, r3);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMaterialConfigs");
    }

    public void setMaterialConfigs(com.obric.oui.material.c[] r1, com.obric.oui.material.c[] r2, boolean r3) {
        this.materials = r1;
        this.materialsDisabled = r2;
        this.materialTokenString = null;
        this.materialDisabledTokenString = null;
        if (r3 == false) goto L6;
        updateUIOnEnableChanged(isEnabled());
        return;
    }

    public void applyDynamicTheme(int r2) {
        if (this.currentTheme == r2) goto L14;
        this.currentTheme = r2;
        String r3 = this.materialTokenString;
        if (r3 == null) goto L8;
        setMaterials(MaterialToken.parseSet(r3, !isDarkTheme()));
    L8:
        String r4 = this.materialDisabledTokenString;
        if (r4 == null) goto L12;
        setMaterialsDisabled(MaterialToken.parseSet(r4, !isDarkTheme()));
    L12:
        updateUIOnEnableChanged(isEnabled());
        return;
    }

    public boolean isDarkTheme() {
        int r0 = this.bgColorNormal;
        if (r0 != 0) goto L7;
        return com.obric.oui.d.i.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"));
    L7:
        if (this.currentTheme != 2) goto L9;
    L12:
        return true;
    L9:
        if (com.obric.oui.color.d.a(r0) == true) goto L12;
        return false;
    }

    public void updateUIOnEnableChanged(boolean r17) {
        if (this.materialApplied == true) goto L9;
        getContentView().setBorderWidth(0);
        getContentView().setBorderColor(0);
        if (r17 == false) goto L7;
        getContentView().setBackgroundColor(this.bgColorNormal);
        return;
    L7:
        getContentView().setBackgroundColor(this.bgColorDisabled);
        return;
    L9:
        if (this.isMaterialFromDrawable == false) goto L11;
        return;
    L11:
        getContentView().setBackgroundColor(0);
        if (r17 == false) goto L17;
        com.obric.oui.material.c[] r3 = this.materials;
        if (r3 == null) goto L25;
        k.a((View) ZeusTransformUtils.preCheckCast(getContentView(), View.class, "com.obric.aiagent.plugin"), r3, false, getMaterialSrcType(), null, 10, null);
        return;
    L25:
        return;
    L17:
        com.obric.oui.material.c[] r10 = this.materialsDisabled;
        if (r10 == null) goto L26;
        k.a((View) ZeusTransformUtils.preCheckCast(getContentView(), View.class, "com.obric.aiagent.plugin"), r10, false, getMaterialSrcType(), null, 10, null);
        return;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r3) {
        o.e(r3, "event");
        boolean r0 = super.dispatchTouchEvent(r3);
        int r4 = r3.getAction();
        if (r4 == 0) goto L9;
        if (r4 != 1) goto L6;
    L8:
        doPressAnim(false);
    L10:
        return r0;
    L6:
        if (r4 == 3) goto L8;
    L9:
        doPressAnim(true);
        goto L10
    }

    private final void doPressAnim(boolean r4) {
        if (isEnabled() == true) goto L7;
        com.obric.oui.d.a.b.b(TAG, "doPressAnim, skip, isEnabled=false");
        return;
    L7:
        if (shouldHandlePressAnimation(r4) == true) goto L10;
        cancelPressAnimation();
        return;
    L10:
        com.obric.oui.d.a.b.b(TAG, o.a("doPressAnim: ", Boolean.valueOf(r4)));
        cancelPressAnimation();
        float r0 = getCurrentPressScaleForAnimation();
        List<j> r1 = currentShadowSnapshot();
        if (r4 == false) goto L13;
        this.pressAnim = startPressScaleAnimation(r0, this.pressScale, r1, this.shadowsPressed);
        return;
    L13:
        this.releaseAnim = startPressScaleAnimation(r0, this.initScale, r1, this.shadowsNormal);
    }

    public final void cancelPressAnimation() {
        d r0 = this.pressAnim;
        if (r0 == null) goto L6;
        d.a(r0, false, 1, null);
    L6:
        d r1 = this.releaseAnim;
        if (r1 == null) goto L10;
        d.a(r1, false, 1, null);
    L10:
        this.pressAnim = null;
        this.releaseAnim = null;
    }

    public final void resetPressScaleForAnimation() {
        applyPressScaleForAnimation(this.initScale);
    }

    public final void resetPressAnimationState() {
        cancelPressAnimation();
        resetPressScaleForAnimation();
        List<j> r0 = this.shadowsNormal;
        j r1 = null;
        if (r0 != null) goto L5;
        j r2 = null;
    L6:
        List<j> r3 = this.shadowsNormal;
        if (r3 == null) goto L10;
        r1 = (j) ZeusTransformUtils.preCheckCast(d.a.p.d(r3, 1), j.class, "com.obric.aiagent.plugin");
    L10:
        a(r2, r1);
        return;
    L5:
        r2 = (j) ZeusTransformUtils.preCheckCast(d.a.p.d(r0, 0), j.class, "com.obric.aiagent.plugin");
        goto L6
    }

    public float getCurrentPressScaleForAnimation() {
        return getScaleX();
    }

    public void applyPressScaleForAnimation(float r1) {
        setScaleX(r1);
        setScaleY(r1);
    }

    public final List<j> currentShadowSnapshot() {
        List<j> r4 = getCurrentShadows();
        if (r4 != null) goto L5;
        return null;
    L5:
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r5, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L10;
        r0.add(((j) ZeusTransformUtils.preCheckCast(r6.next(), j.class, "com.obric.aiagent.plugin")).j());
        goto L7
    L10:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
    }

    public final List<j> normalShadowSnapshotWithAlphaProgress(float r6) {
        List<j> r0 = this.shadowsNormal;
        if (r0 != null) goto L5;
        return null;
    L5:
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r1, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r3 = r1.iterator();
    L7:
        if (r3.hasNext() == false) goto L10;
        r2.add(copyWithAlphaProgress((j) ZeusTransformUtils.preCheckCast(r3.next(), j.class, "com.obric.aiagent.plugin"), r6));
        goto L7
    L10:
        return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
    }

    public final void updateContentShadowAlphaTransition(float r3, float r4, List<j> r5, List<j> r6) {
        List<j> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        List<j> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        List<j> r9 = j.f34539a.a(r4, r7, r8);
        if (r9 == null) goto L5;
        this.shadowAlphaProgress = n.a(r3, 0.0f, 1.0f);
        updateShadows(r9);
        return;
    L5:
        setContentShadowAlphaProgress(r3);
    }

    private final d startPressScaleAnimation(float r17, float r18, List<j> r19, List<j> r20) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.aiagent.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.aiagent.plugin");
        com.obric.common.oea.foundation.animation.a.d.a r9 = new com.obric.common.oea.foundation.animation.a.d.a();
        com.obric.common.oea.foundation.animation.g.a.b r0 = com.obric.common.oea.foundation.animation.g.b.a(com.obric.common.oea.foundation.animation.h.e.a.f32432e, com.obric.common.oea.foundation.animation.h.e.c.g, 0, 4, null);
        r0.a(this.animAccuracy);
        x r1 = x.f38692a;
        return com.obric.common.oea.foundation.animation.a.d.a.a(r9, r17, r18, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(r0, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 8, null).a((q) ZeusTransformUtils.preCheckCast(new b(this, r17, r18, r4, r8), q.class, "com.obric.aiagent.plugin")).a((m) ZeusTransformUtils.preCheckCast(new c(this, r8), m.class, "com.obric.aiagent.plugin")).a().a();
    }
}
