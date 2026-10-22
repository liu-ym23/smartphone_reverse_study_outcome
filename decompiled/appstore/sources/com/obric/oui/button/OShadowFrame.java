package com.obric.oui.button;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$string;
import com.obric.common.oui.R$styleable;
import com.obric.oui.color.i0;
import com.obric.oui.common.style.ODynamicThemeWidget;
import com.obric.oui.common.style.OUILayoutHelper;
import com.obric.oui.common.style.OUIStyleProvider;
import com.obric.oui.common.style.Shadow;
import com.obric.oui.common.style.ShadowAnimator;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.material.MaterialOwner;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.b;
import com.obric.oui.material.f;
import com.obric.oui.utils.log.L;
import java.util.List;
import jb.d;
import kotlin.Metadata;
import kotlin.collections.b0;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import td.c;
import td.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b/\b&\u0018\u0000 \u0091\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0016B1\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0019\u0010\u0017J5\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0004¢\u0006\u0004\b\u001e\u0010\u0013J\u0017\u0010 \u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\bH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u0014H\u0016¢\u0006\u0004\b#\u0010\u0017J\u0017\u0010%\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u0014H\u0016¢\u0006\u0004\b%\u0010\u0017J\u0019\u0010(\u001a\u00020\r2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010+\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u0014H\u0016¢\u0006\u0004\b+\u0010\u0017J\u0019\u0010-\u001a\u00020\r2\b\b\u0001\u0010,\u001a\u00020\bH\u0016¢\u0006\u0004\b-\u0010!J7\u00103\u001a\u00020\r2\b\b\u0001\u0010.\u001a\u00020\b2\b\b\u0001\u0010/\u001a\u00020\b2\b\u00101\u001a\u0004\u0018\u0001002\b\u00102\u001a\u0004\u0018\u000100H\u0016¢\u0006\u0004\b3\u00104JC\u00109\u001a\u00020\r2\b\b\u0001\u0010.\u001a\u00020\b2\b\b\u0001\u0010/\u001a\u00020\b2\u000e\u00107\u001a\n\u0012\u0004\u0012\u000206\u0018\u0001052\u000e\u00108\u001a\n\u0012\u0004\u0012\u000206\u0018\u000105H\u0016¢\u0006\u0004\b9\u0010:J\u0019\u0010;\u001a\u00020\r2\b\b\u0001\u0010,\u001a\u00020\bH\u0016¢\u0006\u0004\b;\u0010!J-\u0010=\u001a\u00020\r2\b\u00101\u001a\u0004\u0018\u0001002\b\u00102\u001a\u0004\u0018\u0001002\b\b\u0002\u0010<\u001a\u00020\u0014H\u0017¢\u0006\u0004\b=\u0010>J9\u0010A\u001a\u00020\r2\u000e\u0010?\u001a\n\u0012\u0004\u0012\u000206\u0018\u0001052\u000e\u0010@\u001a\n\u0012\u0004\u0012\u000206\u0018\u0001052\b\b\u0002\u0010<\u001a\u00020\u0014H\u0017¢\u0006\u0004\bA\u0010BJ\u0017\u0010D\u001a\u00020\r2\u0006\u0010C\u001a\u00020\bH\u0016¢\u0006\u0004\bD\u0010!J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010EJ\u0017\u0010F\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u0014H\u0014¢\u0006\u0004\bF\u0010\u0017J\u0017\u0010I\u001a\u00020\u00142\u0006\u0010H\u001a\u00020GH\u0016¢\u0006\u0004\bI\u0010JR\u0018\u0010M\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010LR\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010LR\u0016\u0010P\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010OR\"\u0010T\u001a\u00020\b8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010O\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010!R\"\u0010W\u001a\u00020\b8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010O\u001a\u0004\bU\u0010R\"\u0004\bV\u0010!R\u0014\u0010Z\u001a\u00020X8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u000e\u0010YR\u0016\u0010[\u001a\u00020X8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u0010YR\u0016\u0010\\\u001a\u00020X8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010YR\"\u0010\u001b\u001a\u00020\u00018\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b=\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u001e\u0010e\u001a\n\u0012\u0004\u0012\u00020c\u0018\u00010b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010dR\u001e\u0010f\u001a\n\u0012\u0004\u0012\u00020c\u0018\u00010b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010dR\"\u0010j\u001a\u00020\b8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bg\u0010O\u001a\u0004\bh\u0010R\"\u0004\bi\u0010!R\"\u0010o\u001a\u00020\u00148\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bk\u0010l\u001a\u0004\bm\u0010E\"\u0004\bn\u0010\u0017R$\u0010v\u001a\u0004\u0018\u0001008\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bp\u0010q\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR$\u0010z\u001a\u0004\u0018\u0001008\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bw\u0010q\u001a\u0004\bx\u0010s\"\u0004\by\u0010uR+\u0010?\u001a\n\u0012\u0004\u0012\u000206\u0018\u0001058\u0004@\u0004X\u0084\u000e¢\u0006\u0013\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R&\u0010\u0084\u0001\u001a\u00020\u00148\u0004@\u0004X\u0084\u000e¢\u0006\u0015\n\u0005\b\u0081\u0001\u0010l\u001a\u0005\b\u0082\u0001\u0010E\"\u0005\b\u0083\u0001\u0010\u0017R$\u0010*\u001a\u00020\u00148\u0004@\u0004X\u0084\u000e¢\u0006\u0014\n\u0005\b\u0085\u0001\u0010l\u001a\u0004\b*\u0010E\"\u0005\b\u0086\u0001\u0010\u0017R.\u0010@\u001a\n\u0012\u0004\u0012\u000206\u0018\u0001058\u0004@\u0004X\u0084\u000e¢\u0006\u0016\n\u0005\b\u0087\u0001\u0010|\u001a\u0005\b\u0088\u0001\u0010~\"\u0006\b\u0089\u0001\u0010\u0080\u0001R&\u0010\u008d\u0001\u001a\u00020\b8\u0004@\u0004X\u0084\u000e¢\u0006\u0015\n\u0005\b\u008a\u0001\u0010O\u001a\u0005\b\u008b\u0001\u0010R\"\u0005\b\u008c\u0001\u0010!R&\u0010\u008f\u0001\u001a\u00020\u00148\u0004@\u0004X\u0084\u000e¢\u0006\u0015\n\u0005\b\u008e\u0001\u0010l\u001a\u0005\b\u008f\u0001\u0010E\"\u0005\b\u0090\u0001\u0010\u0017¨\u0006\u0092\u0001"}, d2 = {"Lcom/obric/oui/button/OShadowFrame;", "Lcom/obric/oui/layout/OUIFrameLayout;", "Lcom/obric/oui/material/MaterialOwner;", "Lcom/obric/oui/common/style/ODynamicThemeWidget;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "", "f", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/content/res/TypedArray;", "typedArray", "e", "(Landroid/content/Context;Landroid/content/res/TypedArray;)V", "", "isDarkTheme", "a", "(Z)V", "pressed", "b", "Landroid/widget/FrameLayout;", "contentView", "c", "(Landroid/content/Context;Landroid/widget/FrameLayout;Landroid/util/AttributeSet;Landroid/content/res/TypedArray;)V", "d", "srcType", "updateBackdropSrcType", "(I)V", "enabled", "setEnabled", "apply", "applyContentMaterial", "Landroid/view/View;", "view", "setBackdropTarget", "(Landroid/view/View;)V", "isBackdropView", "updateBackdropTargetType", "color", "setBgColor", "normal", "disabled", "", "tokenString", "disabledTokenString", "g", "(IILjava/lang/String;Ljava/lang/String;)V", "", "Lcom/obric/oui/material/b;", "normalMaterialConfigs", "disabledMaterialConfigs", "h", "(II[Lcom/obric/oui/material/b;[Lcom/obric/oui/material/b;)V", "setPressColor", "invalidate", "i", "(Ljava/lang/String;Ljava/lang/String;Z)V", "materials", "materialsDisabled", "j", "([Lcom/obric/oui/material/b;[Lcom/obric/oui/material/b;Z)V", "themeStyle", "applyDynamicTheme", "()Z", "k", "Landroid/view/MotionEvent;", "event", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "Ljb/d;", "Ljb/d;", "pressAnim", "releaseAnim", "I", "pressColor", "getBgColorNormal", "()I", "setBgColorNormal", "bgColorNormal", "getBgColorDisabled", "setBgColorDisabled", "bgColorDisabled", "", "F", "initScale", "pressScale", "animAccuracy", "Lcom/obric/oui/layout/OUIFrameLayout;", "getContentView", "()Lcom/obric/oui/layout/OUIFrameLayout;", "setContentView", "(Lcom/obric/oui/layout/OUIFrameLayout;)V", "", "Lcom/obric/oui/common/style/Shadow;", "Ljava/util/List;", "shadowsNormal", "shadowsPressed", "l", "getCurrentTheme", "setCurrentTheme", "currentTheme", "m", "Z", "getEnableMaterial", "setEnableMaterial", "enableMaterial", "n", "Ljava/lang/String;", "getMaterialTokenString", "()Ljava/lang/String;", "setMaterialTokenString", "(Ljava/lang/String;)V", "materialTokenString", "o", "getMaterialDisabledTokenString", "setMaterialDisabledTokenString", "materialDisabledTokenString", "p", "[Lcom/obric/oui/material/b;", "getMaterials", "()[Lcom/obric/oui/material/b;", "setMaterials", "([Lcom/obric/oui/material/b;)V", "q", "getMaterialApplied", "setMaterialApplied", "materialApplied", "r", "setBackdropView", "s", "getMaterialsDisabled", "setMaterialsDisabled", "t", "getMaterialSrcType", "setMaterialSrcType", "materialSrcType", "u", "isMaterialFromDrawable", "setMaterialFromDrawable", "v", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class OShadowFrame extends OUIFrameLayout implements MaterialOwner, ODynamicThemeWidget {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final a f12520v = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f12521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f12522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12523c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12524d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f12525e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f12526f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f12527g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f12528h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public OUIFrameLayout f12529i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List f12530j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List f12531k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f12532l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f12533m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f12534n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f12535o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public b[] f12536p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f12537q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f12538r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public b[] f12539s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f12540t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f12541u;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f12520v = new a(null);
    }

    @JvmOverloads
    public OShadowFrame(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        int r13 = 0;
        this(r10, r11, r12, r13, 14, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void f(Context r12, AttributeSet r13) {
        TypedArray r10 = r12.obtainStyledAttributes(r13, R$styleable.OShadowFrame);
        q.f(r10, "context.obtainStyledAttr…R.styleable.OShadowFrame)");
        if (this.f12533m == false) goto L5;
        boolean r11 = r10.getBoolean(R$styleable.OShadowFrame_oui_widgetEnableMaterial, true);
        this.f12533m = r11;
        this.f12537q = r11;
    L5:
        OUIFrameLayout r14 = null;
        Object[] r15 = 0 == true ? 1 : 0;
        setContentView(new OUIFrameLayout(r12, r15, 0, null, 14, null));
        getContentView().setDuplicateParentStateEnabled(true);
        int r16 = R$styleable.OShadowFrame_oui_widgetBgColor;
        Resources r17 = getResources();
        int r18 = R$color.oui_floating_button_bg_color_1;
        this.f12524d = r10.getColor(r16, r17.getColor(r18, null));
        this.f12525e = r10.getColor(R$styleable.OShadowFrame_oui_widgetBgColorDisabled, getResources().getColor(r18, null));
        if (this.f12524d == 0) goto L8;
        getContentView().setBackgroundColor(this.f12524d);
    L8:
        this.f12527g = r10.getFloat(R$styleable.OShadowFrame_oui_widgetPressScale, 1.0f);
        setChangeAlphaWhenPress(false);
        int r19 = r10.getDimensionPixelSize(R$styleable.OShadowFrame_oui_widgetPaddingL, 0);
        int r20 = r10.getDimensionPixelSize(R$styleable.OShadowFrame_oui_widgetPaddingR, 0);
        int r21 = r10.getDimensionPixelSize(R$styleable.OShadowFrame_oui_widgetPaddingT, 0);
        int r22 = r10.getDimensionPixelSize(R$styleable.OShadowFrame_oui_widgetPaddingB, 0);
        int r23 = r10.getDimensionPixelSize(R$styleable.OShadowFrame_oui_widgetRadius, 0);
        Drawable r24 = r10.getDrawable(R$styleable.OShadowFrame_oui_widgetMaterialBackground);
        getContentView().setPadding(r19, r21, r20, r22);
        getContentView().setRadius(r23);
        this.f12523c = r10.getColor(R$styleable.OShadowFrame_oui_widgetPressColor, 0);
        getContentView().setOverridePressColor(this.f12523c);
        getContentView().refreshColors("OShadowFrame");
        addView(getContentView(), new FrameLayout.LayoutParams(-1, -1));
        setShadowCornerRadius(r23);
        c(r12, getContentView(), r13, r10);
        if (r24 == null) goto L11;
        boolean r110 = true;
    L12:
        this.f12541u = r110;
        if (r110 == false) goto L15;
        getContentView().setBackground(r24);
        getContentView().setChangeAlphaWhenPress(false);
        getContentView().setChangeAlphaWhenDisable(false);
    L15:
        c r111 = c.f24796a;
        OUIFrameLayout r112 = getContentView();
        if (r112 == null) goto L19;
        r14 = r112;
    L19:
        if (r14 == null) goto L22;
        r14.setChangeAlphaWhenDisable(false);
    L22:
        setChangeAlphaWhenDisable(false);
        e(r12, r10);
        r10.recycle();
        setClipChildren(false);
        setClickable(true);
        k(isEnabled());
        return;
    L11:
        r110 = false;
        goto L12
    }

    public final void a(boolean r10) {
        androidx.core.graphics.d.k(this.f12524d, 48);
        if (i0.b(this.f12524d) == false) goto L9;
        com.obric.oui.material.c r11 = com.obric.oui.material.c.f15225a;
        Function1<Boolean, b[]> r12 = MaterialToken.OUI_Bg_Floating_Tinted;
        b[] r13 = r11.b(r12.invoke(Boolean.valueOf(!r10)), this.f12524d);
        if (this.f12525e == 0) goto L7;
        b[] r14 = r11.b(r12.invoke(Boolean.valueOf(!r10)), this.f12525e);
    L8:
        j(r13, r14, false);
        return;
    L7:
        r14 = null;
        goto L8
    L9:
        String r15 = this.f12534n;
        if (r15 == null) goto L15;
        b[] r16 = MaterialToken.parseSet(r15, !r10);
        this.f12536p = r16;
        String r17 = this.f12535o;
        if (r17 == null) goto L14;
        this.f12539s = MaterialToken.parseSet(r17, !r10);
        return;
    L14:
        this.f12539s = r16;
        return;
    L15:
        Function1<Boolean, b[]> r18 = MaterialToken.OUI_Bg_Floating;
        j(r18.invoke(Boolean.valueOf(!r10)), r18.invoke(Boolean.valueOf(!r10)), false);
    }

    @Override // com.obric.oui.material.MaterialOwner
    public void applyContentMaterial(boolean r10) {
        this.f12537q = r10;
        f.a(getContentView(), r10, this.f12540t);
        k(isEnabled());
        invalidate();
    }

    public void applyDynamicTheme(int r10) {
        if (this.f12532l == r10) goto L14;
        this.f12532l = r10;
        String r11 = this.f12534n;
        if (r11 == null) goto L8;
        setMaterials(MaterialToken.parseSet(r11, !isDarkTheme()));
    L8:
        String r12 = this.f12535o;
        if (r12 == null) goto L12;
        setMaterialsDisabled(MaterialToken.parseSet(r12, !isDarkTheme()));
    L12:
        k(isEnabled());
        return;
    }

    public final void b(boolean r10) {
        if (isEnabled() == true) goto L6;
        L.a("OShadowFrame", "doPressAnim, skip, isEnabled=false");
        return;
    L6:
        L.a("OShadowFrame", q.p("doPressAnim: ", Boolean.valueOf(r10)));
        d r11 = this.f12521a;
        if (r11 == null) goto L10;
        d.c(r11, false, 1, null);
    L10:
        d r12 = this.f12522b;
        if (r12 == null) goto L14;
        d.c(r12, false, 1, null);
    L14:
        if (r10 == false) goto L16;
        this.f12521a = ShadowAnimator.c(this, this.f12526f, this.f12527g, getCurrentShadows(), this.f12531k);
        return;
    L16:
        this.f12522b = ShadowAnimator.c(this, this.f12527g, this.f12526f, getCurrentShadows(), this.f12530j);
    }

    public abstract void c(Context r10, FrameLayout r11, AttributeSet r12, TypedArray r13);

    public final void d(Context r10, TypedArray r11) {
        q.g(r10, "context");
        q.g(r11, "typedArray");
        this.f12540t = r11.getInt(R$styleable.OShadowFrame_oui_widgetMaterialSrcType, 2);
        String r12 = r11.getString(R$styleable.OShadowFrame_oui_widgetMaterial);
        boolean r13 = i0.b(this.f12524d);
        if (r12 != null) goto L6;
        if (r13 == true) goto L6;
        r12 = getResources().getString(R$string.oui_material_bg_floating);
    L6:
        this.f12534n = r12;
        boolean r14 = isDarkTheme();
        if (r13 == false) goto L12;
        com.obric.oui.material.c r15 = com.obric.oui.material.c.f15225a;
        Function1<Boolean, b[]> r16 = MaterialToken.OUI_Bg_Floating_Tinted;
        this.f12536p = r15.b(r16.invoke(Boolean.valueOf(!r14)), this.f12524d);
        if (this.f12525e == 0) goto L17;
        this.f12539s = r15.b(r16.invoke(Boolean.valueOf(!r14)), this.f12525e);
    L17:
        if (this.f12536p != null) goto L20;
        this.f12533m = false;
        this.f12537q = false;
        return;
    L20:
        return;
    L12:
        if (this.f12534n == null) goto L17;
        this.f12536p = MaterialToken.parseSet(r12, !r14);
        String r17 = r11.getString(R$styleable.OShadowFrame_oui_widgetMaterialDisabled);
        this.f12535o = r17;
        if (r17 == null) goto L17;
        this.f12539s = MaterialToken.parseSet(r17, !r14);
        goto L17
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r10) {
        q.g(r10, "event");
        boolean r11 = super.dispatchTouchEvent(r10);
        int r12 = r10.getAction();
        if (r12 == 0) goto L9;
        if (r12 != 1) goto L6;
    L8:
        b(false);
    L10:
        return r11;
    L6:
        if (r12 == 3) goto L8;
    L9:
        b(true);
        goto L10
    }

    public final void e(Context r10, TypedArray r11) {
        List r12 = OUILayoutHelper.p(r10, r11, R$styleable.OShadowFrame_oui_widgetShadowNormal);
        if (r12 == null) goto L5;
        this.f12530j = r12;
        q.d(r12);
        Shadow r13 = (Shadow) b0.a0(r12, 0);
        List r14 = this.f12530j;
        q.d(r14);
        setShadow(r13, (Shadow) b0.a0(r14, 1));
    L5:
        List r15 = OUILayoutHelper.p(r10, r11, R$styleable.OShadowFrame_oui_widgetShadowPressed);
        if (r15 == null) goto L9;
        this.f12531k = r15;
        return;
    }

    public void g(int r10, int r11, String r12, String r13) {
        this.f12524d = r10;
        this.f12525e = r11;
        if (r12 == null) goto L7;
        i(r12, r13, false);
    L7:
        if (i0.c(r10) == false) goto L9;
        int r14 = 2;
    L11:
        if (r14 == this.f12532l) goto L14;
        applyDynamicTheme(r14);
        return;
    L14:
        k(isEnabled());
        return;
    L9:
        r14 = 1;
        goto L11
    }

    public final int getBgColorDisabled() {
        return this.f12525e;
    }

    public final int getBgColorNormal() {
        return this.f12524d;
    }

    @NotNull
    public final OUIFrameLayout getContentView() {
        OUIFrameLayout r10 = this.f12529i;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("contentView");
        return null;
    }

    public final int getCurrentTheme() {
        return this.f12532l;
    }

    public final boolean getEnableMaterial() {
        return this.f12533m;
    }

    public final boolean getMaterialApplied() {
        return this.f12537q;
    }

    @Nullable
    public final String getMaterialDisabledTokenString() {
        return this.f12535o;
    }

    public final int getMaterialSrcType() {
        return this.f12540t;
    }

    @Nullable
    public final String getMaterialTokenString() {
        return this.f12534n;
    }

    @Nullable
    public final b[] getMaterials() {
        return this.f12536p;
    }

    @Nullable
    public final b[] getMaterialsDisabled() {
        return this.f12539s;
    }

    public void h(int r10, int r11, b[] r12, b[] r13) {
        this.f12524d = r10;
        this.f12525e = r11;
        j(r12, r13, false);
        if (i0.c(r10) == false) goto L5;
        int r14 = 2;
    L7:
        if (r14 == this.f12532l) goto L10;
        applyDynamicTheme(r14);
        return;
    L10:
        k(isEnabled());
        return;
    L5:
        r14 = 1;
        goto L7
    }

    public void i(String r10, String r11, boolean r12) {
        if (q.b(this.f12534n, r10) == true) goto L5;
        this.f12534n = r10;
        this.f12536p = MaterialToken.parseSet(r10, !isDarkTheme());
    L5:
        String r13 = this.f12535o;
        if (r13 != null) goto L8;
        boolean r14 = true;
    L9:
        if (r14 == true) goto L11;
        this.f12535o = r11;
        this.f12539s = MaterialToken.parseSet(r11, !isDarkTheme());
    L11:
        if (r12 == false) goto L14;
        k(isEnabled());
        return;
    L14:
        return;
    L8:
        r14 = o.m(r13, r11);
        goto L9
    }

    @Override // com.obric.oui.common.style.ODynamicThemeWidget
    public boolean isDarkTheme() {
        int r10 = this.f12524d;
        if (r10 != 0) goto L7;
        return i.a(this);
    L7:
        if (this.f12532l != 2) goto L9;
    L12:
        return true;
    L9:
        if (i0.c(r10) == true) goto L12;
        return false;
    }

    public void j(b[] r10, b[] r11, boolean r12) {
        this.f12536p = r10;
        this.f12539s = r11;
        this.f12534n = null;
        this.f12535o = null;
        if (r12 == false) goto L6;
        k(isEnabled());
        return;
    }

    public void k(boolean r18) {
        if (this.f12537q == true) goto L9;
        getContentView().setBorderWidth(0);
        getContentView().setBorderColor(0);
        if (r18 == false) goto L7;
        getContentView().setBackgroundColor(this.f12524d);
        return;
    L7:
        getContentView().setBackgroundColor(this.f12525e);
        return;
    L9:
        if (this.f12541u == false) goto L11;
        return;
    L11:
        getContentView().setBackgroundColor(0);
        if (r18 == false) goto L17;
        b[] r10 = this.f12536p;
        if (r10 == null) goto L25;
        com.obric.oui.material.o.j(getContentView(), r10, false, getMaterialSrcType(), null, 10, null);
        return;
    L25:
        return;
    L17:
        b[] r11 = this.f12539s;
        if (r11 == null) goto L26;
        com.obric.oui.material.o.j(getContentView(), r11, false, getMaterialSrcType(), null, 10, null);
        return;
    }

    @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
    public void setBackdropTarget(@Nullable View r10) {
        com.obric.oui.material.o.n(getContentView(), r10);
    }

    public final void setBackdropView(boolean r10) {
        this.f12538r = r10;
    }

    public void setBgColor(@ColorInt int r10) {
        if (this.f12524d == r10) goto L14;
        this.f12524d = r10;
        this.f12525e = r10;
        boolean r11 = i0.c(r10);
        a(r11);
        if (r11 == false) goto L7;
        int r12 = 2;
    L9:
        if (r12 == this.f12532l) goto L12;
        applyDynamicTheme(r12);
        return;
    L12:
        k(isEnabled());
        return;
    L7:
        r12 = 1;
        goto L9
    }

    public final void setBgColorDisabled(int r10) {
        this.f12525e = r10;
    }

    public final void setBgColorNormal(int r10) {
        this.f12524d = r10;
    }

    public final void setContentView(@NotNull OUIFrameLayout r10) {
        q.g(r10, "<set-?>");
        this.f12529i = r10;
    }

    public final void setCurrentTheme(int r10) {
        this.f12532l = r10;
    }

    public final void setEnableMaterial(boolean r10) {
        this.f12533m = r10;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r10) {
        super.setEnabled(r10);
        getContentView().setEnabled(r10);
        k(r10);
    }

    public final void setMaterialApplied(boolean r10) {
        this.f12537q = r10;
    }

    public final void setMaterialDisabledTokenString(@Nullable String r10) {
        this.f12535o = r10;
    }

    public final void setMaterialFromDrawable(boolean r10) {
        this.f12541u = r10;
    }

    public final void setMaterialSrcType(int r10) {
        this.f12540t = r10;
    }

    public final void setMaterialTokenString(@Nullable String r10) {
        this.f12534n = r10;
    }

    public final void setMaterials(@Nullable b[] r10) {
        this.f12536p = r10;
    }

    public final void setMaterialsDisabled(@Nullable b[] r10) {
        this.f12539s = r10;
    }

    public void setPressColor(@ColorInt int r10) {
        this.f12523c = r10;
        getContentView().setOverridePressColor(this.f12523c);
        getContentView().refreshColors("OShadowFrame");
    }

    @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
    public void updateBackdropSrcType(int r10) {
        this.f12540t = r10;
        com.obric.oui.material.o.p(getContentView(), r10);
    }

    @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
    public void updateBackdropTargetType(boolean r10) {
        if (this.f12538r == r10) goto L6;
        this.f12538r = r10;
        com.obric.oui.material.o.q(getContentView(), r10);
        return;
    }

    @JvmOverloads
    public OShadowFrame(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        int r13 = 0;
        this(r10, r11, r12, r13, 12, null);
    }

    @JvmOverloads
    public OShadowFrame(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        int r13 = 0;
        this(r10, r11, r12, r13, 8, null);
    }

    public /* synthetic */ OShadowFrame(Context r10, AttributeSet r11, int r12, int r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = 0;
    L9:
        if ((r14 & 8) == 0) goto L11;
        r13 = 0;
    L11:
        this(r10, r11, r12, r13);
    }

    public OShadowFrame(Context r10, AttributeSet r11, int r12, int r13) {
        q.g(r10, "context");
        OUIStyleProvider r14 = null;
        super(r10, r11, r12, r14, 8, null);
        this.f12526f = 1.0f;
        this.f12527g = 1.0f;
        this.f12528h = 0.01f;
        boolean r15 = true;
        this.f12538r = true;
        this.f12540t = 2;
        if (com.obric.oui.material.o.f(this) == true) goto L5;
    L7:
        r15 = false;
    L8:
        this.f12533m = r15;
        this.f12537q = r15;
        f(r10, r11);
        return;
    L5:
        if (OMaterialHelper.w() == false) goto L7;
        goto L7
    }
}
