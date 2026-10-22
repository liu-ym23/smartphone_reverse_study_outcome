package com.bytedance.ai.applet.app.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.ai.model.objects.Applet;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 G2\u00020\u0001:\u0002GHB\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010(\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tJ\u0014\u0010)\u001a\u00020\f2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u0014\u0010+\u001a\u00020\f2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u0006\u0010,\u001a\u00020\fJ\u0006\u0010-\u001a\u00020.J\u0006\u0010/\u001a\u00020'J\u0006\u00100\u001a\u00020'J\u0006\u00101\u001a\u00020\fJ\u0010\u00102\u001a\u00020\f2\b\b\u0002\u00103\u001a\u000204J\u0012\u00105\u001a\u00020\f2\b\u00106\u001a\u0004\u0018\u000107H\u0014J\b\u00108\u001a\u00020\fH\u0014J\u0010\u00109\u001a\u0002042\u0006\u0010:\u001a\u00020;H\u0016J\u0010\u0010<\u001a\u00020\f2\u0006\u0010=\u001a\u00020>H\u0014J\u0018\u0010?\u001a\u00020\f2\u0006\u0010=\u001a\u00020>2\u0006\u0010@\u001a\u00020\u001fH\u0002J\u001a\u0010A\u001a\u0004\u0018\u00010%2\u0006\u0010B\u001a\u00020\u001f2\u0006\u0010C\u001a\u00020\u001fH\u0002J\u0012\u0010D\u001a\u00020\f2\b\u0010E\u001a\u0004\u0018\u00010%H\u0002J\u0010\u0010F\u001a\u00020\f2\u0006\u0010E\u001a\u00020%H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/bytedance/ai/applet/app/view/AppletAppActionBar;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "applet", "Lcom/bytedance/ai/model/objects/Applet;", "onCloseListener", "Lkotlin/Function0;", "", "onOpenListener", "contentView", "Landroid/view/View;", "btnMiniMenu", "btnMiniClose", "ivMiniMenu", "Landroid/widget/ImageView;", "ivMiniClose", "shadowPaint", "Landroid/graphics/Paint;", "shadowClearPaint", "fillPaint", "strokePaint", "bgRect", "Landroid/graphics/RectF;", "shadowLayerRect", "expandedTouchRect", "shadowPaddingPx", "", "shadowRadiusPx", "cornerRadiusPx", "strokeWidthPx", "expandedTouchInsetPx", "activeTouchTarget", "Lcom/bytedance/ai/applet/app/view/AppletAppActionBar$TouchTarget;", "appliedNightMode", "", "setApplet", "setOnCloseListener", "listener", "setOnOpenListener", "release", "getContentViewLocationInWindow", "", "getContentViewWidth", "getContentViewHeight", "initBackground", "refreshTheme", "force", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onAttachedToWindow", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "drawOuterShadow", "radius", "findExpandedTouchTarget", "x", "y", "updatePressedState", PickerReporterConstants.KEY.TARGET, "performExpandedTouchClick", "Companion", "TouchTarget", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletAppActionBar extends FrameLayout {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f34449v = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<Unit> f34450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f34451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f34452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f34453d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f34454e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f34455f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ImageView f34456g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f34457h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Paint f34458i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Paint f34459j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Paint f34460k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final RectF f34461l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final RectF f34462m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final RectF f34463n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f34464o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f34465p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f34466q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f34467r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f34468s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public TouchTarget f34469t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f34470u;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/applet/app/view/AppletAppActionBar$TouchTarget;", "", "<init>", "(Ljava/lang/String;I)V", "MENU", "CLOSE", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TouchTarget extends Enum<TouchTarget> {
        public static final TouchTarget CLOSE = null;
        public static final TouchTarget MENU = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TouchTarget[] f34471a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f34472b = null;

        public static EnumEntries<TouchTarget> getEntries() {
            return f34472b;
        }

        static {
            TouchTarget r100 = new TouchTarget("MENU", 0);
            MENU = r100;
            TouchTarget r101 = new TouchTarget("CLOSE", 1);
            CLOSE = r101;
            TouchTarget[] r102 = {r100, r101};
            f34471a = r102;
            f34472b = EnumEntriesKt.enumEntries(r102);
        }

        public static TouchTarget[] values() {
            return (TouchTarget[]) f34471a.clone();
        }

        public static TouchTarget valueOf(String r100) {
            return (TouchTarget) r27.a.a(TouchTarget.class, r100);
        }

        public TouchTarget(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f34473a = null;

        static {
            int[] r100 = new int[TouchTarget.values().length];
            r100[TouchTarget.MENU.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[TouchTarget.CLOSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f34473a = r100;
        }
    }

    static {
    }

    public final int[] getContentViewLocationInWindow() {
        int[] r100 = new int[2];
        this.f34452c.getLocationInWindow(r100);
        return r100;
    }

    public final void setApplet(Applet r100) {
        Intrinsics.checkNotNullParameter(r100, "applet");
    }

    public final int getContentViewHeight() {
        return this.f34452c.getHeight();
    }

    public final int getContentViewWidth() {
        return this.f34452c.getWidth();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        a(false);
    }

    public AppletAppActionBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void a(boolean r100) {
        int r101 = getResources().getConfiguration().uiMode & 48;     // Catch: Exception -> L9
        if (r100 == false) goto L5;
    L7:
        this.f34470u = r101;     // Catch: Exception -> L9
        int r102 = t2.a.c(getContext(), R.attr.applet_action_bar_bg_color, R.color.applet_app_action_bar_bg_color);     // Catch: Exception -> L9
        int r103 = t2.a.c(getContext(), R.attr.applet_action_bar_stroke_color, R.color.applet_app_action_bar_stroke_color);     // Catch: Exception -> L9
        int r104 = t2.a.c(getContext(), R.attr.applet_action_bar_shadow_color, R.color.applet_app_action_bar_shadow_color);     // Catch: Exception -> L9
        int r105 = t2.a.c(getContext(), R.attr.applet_action_bar_icon_color, R.color.neutral_100);     // Catch: Exception -> L9
        int r106 = t2.a.c(getContext(), R.attr.applet_action_bar_icon_press_color, R.color.applet_app_action_bar_button_press);     // Catch: Exception -> L9
        this.f34457h.setStyle(Paint.Style.FILL);     // Catch: Exception -> L9
        this.f34457h.setColor(r104);     // Catch: Exception -> L9
        this.f34457h.setShadowLayer(this.f34465p, 0.0f, 0.0f, r104);     // Catch: Exception -> L9
        this.f34459j.setStyle(Paint.Style.FILL);     // Catch: Exception -> L9
        this.f34459j.setColor(r102);     // Catch: Exception -> L9
        this.f34460k.setStyle(Paint.Style.STROKE);     // Catch: Exception -> L9
        this.f34460k.setColor(r103);     // Catch: Exception -> L9
        this.f34460k.setStrokeWidth(this.f34467r);     // Catch: Exception -> L9
        ColorStateList r107 = new ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed}, new int[0]}, new int[]{r106, r105});     // Catch: Exception -> L9
        this.f34455f.setImageTintList(r107);     // Catch: Exception -> L9
        this.f34456g.setImageTintList(r107);     // Catch: Exception -> L9
        this.f34455f.setImageResource(R.drawable.applet_app_icon_more_selector);     // Catch: Exception -> L9
        this.f34456g.setImageResource(R.drawable.applet_app_icon_close_selector);     // Catch: Exception -> L9
        invalidate();     // Catch: Exception -> L9
        return;
    L5:
        if (r101 != this.f34470u) goto L7;
        return;
    L9:
        e = move-exception;
        com.bytedance.ai.utils.g.f37637a.e("AppletAppActionBar", "refreshTheme error", e);
    }

    public final void b(TouchTarget r100) {
        View r101 = this.f34453d;
        boolean r102 = true;
        if (r100 != TouchTarget.MENU) goto L5;
        boolean r103 = true;
    L6:
        r101.setPressed(r103);
        View r104 = this.f34454e;
        if (r100 == TouchTarget.CLOSE) goto L10;
        r102 = false;
    L10:
        r104.setPressed(r102);
        return;
    L5:
        r103 = false;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        a(false);
        if (getWidth() > 0) goto L5;
    L13:
        super.dispatchDraw(r100);
        return;
    L5:
        if (getHeight() <= 0) goto L13;
        if (this.f34464o <= 0.0f) goto L13;
        if (this.f34452c.getWidth() <= 0) goto L13;
        if (this.f34452c.getHeight() <= 0) goto L13;
        float r101 = this.f34467r / 2.0f;
        this.f34461l.set(this.f34452c.getLeft() + r101, this.f34452c.getTop() + r101, this.f34452c.getRight() - r101, this.f34452c.getBottom() - r101);
        float r102 = Math.min(this.f34466q, Math.min(this.f34461l.width(), this.f34461l.height()) / 2.0f);
        float r103 = this.f34465p + this.f34467r;
        this.f34462m.set(this.f34461l);
        float r104 = -r103;
        this.f34462m.inset(r104, r104);
        int r105 = r100.saveLayer(this.f34462m, null);
        r100.drawRoundRect(this.f34461l, r102, r102, this.f34457h);
        r100.drawRoundRect(this.f34461l, r102, r102, this.f34458i);
        r100.restoreToCount(r105);
        r100.drawRoundRect(this.f34461l, r102, r102, this.f34459j);
        r100.drawRoundRect(this.f34461l, r102, r102, this.f34460k);
        goto L13
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        float r100 = r110.getX();
        float r101 = r110.getY();
        TouchTarget r102 = null;
        if (this.f34452c.getWidth() > 0) goto L5;
    L41:
        TouchTarget r103 = null;
    L42:
        int r104 = r110.getActionMasked();
        if (r104 != 0) goto L45;
        if (r103 == null) goto L81;
        this.f34469t = r103;
        b(r103);
        ViewParent r111 = getParent();
        if (r111 == null) goto L79;
        r111.requestDisallowInterceptTouchEvent(true);
    L79:
        return true;
    L81:
        return super.dispatchTouchEvent(r110);
    L45:
        if (r104 == 1) goto L60;
        if (r104 != 2) goto L48;
        TouchTarget r105 = this.f34469t;
        if (r105 == null) goto L81;
        if (r103 != r105) goto L58;
        r102 = r105;
    L58:
        b(r102);
        return true;
    L48:
        if (r104 != 3) goto L81;
        if (this.f34469t == null) goto L81;
        this.f34469t = null;
        b(null);
        return true;
    L60:
        TouchTarget r106 = this.f34469t;
        if (r106 == null) goto L81;
        if (r103 == r106) goto L65;
        r106 = null;
    L65:
        this.f34469t = null;
        b(null);
        if (r106 == null) goto L74;
        int r112 = b.f34473a[r106.ordinal()];
        if (r112 == 1) goto L73;
        if (r112 != 2) goto L72;
        this.f34454e.performClick();
        goto L74
    L72:
        throw new NoWhenBranchMatchedException();
    L73:
        this.f34453d.performClick();
    L74:
        return true;
    L5:
        if (this.f34452c.getHeight() <= 0) goto L41;
        this.f34463n.set(this.f34452c.getLeft() - this.f34468s, this.f34452c.getTop() - this.f34468s, this.f34452c.getRight() + this.f34468s, this.f34452c.getBottom() + this.f34468s);
        if (this.f34463n.contains(r100, r101) == false) goto L41;
        float r107 = (this.f34452c.getLeft() + this.f34453d.getLeft()) - this.f34468s;
        float r108 = (this.f34452c.getTop() + this.f34453d.getTop()) - this.f34468s;
        float r109 = (this.f34452c.getLeft() + this.f34453d.getRight()) + this.f34468s;
        float r113 = (this.f34452c.getTop() + this.f34453d.getBottom()) + this.f34468s;
        float r114 = (this.f34452c.getLeft() + this.f34454e.getLeft()) - this.f34468s;
        float r115 = (this.f34452c.getTop() + this.f34454e.getTop()) - this.f34468s;
        float r116 = (this.f34452c.getLeft() + this.f34454e.getRight()) + this.f34468s;
        float r117 = (this.f34452c.getTop() + this.f34454e.getBottom()) + this.f34468s;
        boolean r118 = false;
        if (r100 >= r107) goto L13;
    L19:
        boolean r119 = false;
    L21:
        if (r100 >= r114) goto L23;
    L29:
        if (r119 == false) goto L32;
        if (r118 == true) goto L32;
        r103 = TouchTarget.MENU;
    L32:
        if (r118 == false) goto L35;
        if (r119 == true) goto L35;
        r103 = TouchTarget.CLOSE;
    L35:
        if (r119 == false) goto L41;
        if (r118 == false) goto L41;
        float r120 = r100 - ((this.f34452c.getLeft() + this.f34453d.getLeft()) + (this.f34453d.getWidth() / 2.0f));
        float r121 = r100 - ((this.f34452c.getLeft() + this.f34454e.getLeft()) + (this.f34454e.getWidth() / 2.0f));
        if ((r120 * r120) > (r121 * r121)) goto L40;
        r103 = TouchTarget.MENU;
        goto L42
    L40:
        r103 = TouchTarget.CLOSE;
        goto L42
    L23:
        if (r100 > r116) goto L29;
        if (r101 < r115) goto L29;
        if (r101 > r117) goto L29;
        r118 = true;
        goto L29
    L13:
        if (r100 > r109) goto L19;
        if (r101 < r108) goto L19;
        if (r101 > r113) goto L19;
        r119 = true;
        goto L21
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        a(false);
    }

    public final void setOnCloseListener(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f34450a = r100;
    }

    public final void setOnOpenListener(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f34451b = r100;
    }

    public AppletAppActionBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f34457h = new Paint(1);
        Paint r102 = new Paint(1);
        r102.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.f34458i = r102;
        this.f34459j = new Paint(1);
        this.f34460k = new Paint(1);
        this.f34461l = new RectF();
        this.f34462m = new RectF();
        this.f34463n = new RectF();
        LayoutInflater.from(r100).inflate(R.layout.applet_action_bar_layout, this, true);
        View r103 = findViewById(R.id.action_bar_root);
        this.f34452c = r103;
        View r104 = findViewById(R.id.btn_mini_menu);
        this.f34453d = r104;
        View r105 = findViewById(R.id.btn_mini_close);
        this.f34454e = r105;
        this.f34455f = (ImageView) findViewById(R.id.iv_mini_menu);
        this.f34456g = (ImageView) findViewById(R.id.iv_mini_close);
        r104.setOnClickListener(new i(this));
        r105.setOnClickListener(new j(this));
        setWillNotDraw(false);     // Catch: Exception -> L8
        setLayerType(1, null);     // Catch: Exception -> L8
        this.f34464o = n2.a.b(12);     // Catch: Exception -> L8
        this.f34465p = n2.a.b(12);     // Catch: Exception -> L8
        this.f34466q = n2.a.b(18);     // Catch: Exception -> L8
        this.f34467r = n2.a.b(Double.valueOf(0.5d));     // Catch: Exception -> L8
        this.f34468s = n2.a.b(4);     // Catch: Exception -> L8
        ViewGroup.LayoutParams r106 = r103.getLayoutParams();     // Catch: Exception -> L8
        if ((r106 instanceof FrameLayout.LayoutParams) == false) goto L6;
        ((FrameLayout.LayoutParams) r106).gravity = 17;     // Catch: Exception -> L8
        int r107 = (int) this.f34464o;     // Catch: Exception -> L8
        ((FrameLayout.LayoutParams) r106).leftMargin = r107;     // Catch: Exception -> L8
        ((FrameLayout.LayoutParams) r106).topMargin = r107;     // Catch: Exception -> L8
        ((FrameLayout.LayoutParams) r106).rightMargin = r107;     // Catch: Exception -> L8
        ((FrameLayout.LayoutParams) r106).bottomMargin = r107;     // Catch: Exception -> L8
        r103.setLayoutParams(r106);     // Catch: Exception -> L8
    L6:
        a(true);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        com.bytedance.ai.utils.g.f37637a.e("AppletAppActionBar", "initBackground error", e);
    }
}
