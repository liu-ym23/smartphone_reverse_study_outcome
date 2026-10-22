package com.bytedance.android.accessibilityLib_Core.base.largertoucharea;

import android.content.Context;
import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.h;
import com.bytedance.android.accessibilityLib_Core.processor.ViewAccessibilityDelegateProcessor;
import com.bytedance.android.accessibilityLib_Core.tool.AccessibilityCommonToolExtKt;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements com.bytedance.android.accessibilityLib_Core.processor.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f38140f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f38141g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakHashMap<View, WeakReference<TouchDelegateComposite>> f38142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f38143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakHashMap<View, Boolean> f38144c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k6.a f38145d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.accessibilityLib_Core.processor.a f38146e;

    /* JADX INFO: renamed from: com.bytedance.android.accessibilityLib_Core.base.largertoucharea.a$a, reason: collision with other inner class name */
    public static final class C0721a {
    }

    static {
        f38140f = AccessibilityCommonToolExtKt.c();
        f38141g = AccessibilityCommonToolExtKt.c();
    }

    public final void d(ViewAccessibilityDelegateProcessor.a r100) {
        View r101 = r100.a();     // Catch: Exception -> L34
        if (r101 == null) goto L33;
        Boolean r102 = this.f38144c.get(r101);     // Catch: Exception -> L34
        if (Intrinsics.areEqual(r102, Boolean.TRUE) == false) goto L11;
        com.bytedance.android.accessibilityLib_Core.processor.a r103 = this.f38146e;     // Catch: Exception -> L34
        if (r103 == null) goto L46;
        r103.b(r101, r100.f38294b, true);     // Catch: Exception -> L34
        return;
    L46:
        return;
    L11:
        if (Intrinsics.areEqual(r102, Boolean.FALSE) == false) goto L17;
        com.bytedance.android.accessibilityLib_Core.processor.a r104 = this.f38146e;     // Catch: Exception -> L34
        if (r104 == null) goto L47;
        r104.b(r101, r100.f38294b, false);     // Catch: Exception -> L34
        return;
    L47:
        return;
    L17:
        if (f(r101, LargeTouchAreaProcessor$shouldLargerTouchArea$1.INSTANCE) == false) goto L29;
        boolean r105 = e(this, r101);     // Catch: Exception -> L34
        com.bytedance.android.accessibilityLib_Core.processor.a r106 = this.f38146e;     // Catch: Exception -> L34
        if (r106 == null) goto L21;
        r106.b(r101, r100.f38294b, r105);     // Catch: Exception -> L34
    L21:
        WeakHashMap<View, Boolean> r107 = this.f38144c;     // Catch: Exception -> L34
        monitor-enter(r107);     // Catch: Exception -> L34
        this.f38144c.put(r101, Boolean.valueOf(r105));     // Catch: Throwable -> L26
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L26
        monitor-exit(r107);     // Catch: Exception -> L34
        return;
    L26:
        th = move-exception;
        throw th;     // Catch: Exception -> L34
    L29:
        com.bytedance.android.accessibilityLib_Core.processor.a r109 = this.f38146e;     // Catch: Exception -> L34
        if (r109 == null) goto L49;
        r109.b(r101, r100.f38294b, false);     // Catch: Exception -> L34
        Unit r110 = Unit.INSTANCE;     // Catch: Exception -> L34
        return;
    L49:
        return;
    L33:
        return;
    L34:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L39;
        Context r111 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L39:
        if (("expandInternal fail, e = " + e.getMessage()) == null) goto L41;
        Context r112 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L41:
        Unit r113 = Unit.INSTANCE;
    }

    public a(k6.a r100, ViewAccessibilityDelegateProcessor r101) {
        this.f38145d = r100;
        this.f38146e = r101;
        this.f38142a = new WeakHashMap();
        this.f38143b = new Rect();
        this.f38144c = new WeakHashMap();
    }

    public static boolean c(a r100, View r101) {
        LargeTouchAreaProcessor$canLargerTouch$1 r102 = LargeTouchAreaProcessor$canLargerTouch$1.INSTANCE;
        r100.getClass();
        return f(r101, r102);
    }

    public static boolean e(a r100, View r101) {
        int r102 = f38140f;
        int r103 = f38141g;
        r100.getClass();
        ViewParent r104 = r101.getParent();
    L4:
        if (r104 == null) goto L24;
        if ((r104 instanceof ViewGroup) == false) goto L23;
        View r105 = (View) r104;
        if (r105.getWidth() >= f38140f) goto L10;
    L12:
        boolean r106 = false;
    L13:
        if (r106 == false) goto L23;
        if (r105.isClickable() == false) goto L17;
    L20:
        boolean r107 = true;
    L21:
        if (r107 == false) goto L23;
        ViewGroup r108 = (ViewGroup) r104;
    L25:
        if (r108 == null) goto L47;
        r108.getHitRect(r100.f38143b);
        Rect r109 = new Rect();
        r101.getHitRect(r109);
        int r110 = RangesKt.coerceAtLeast((r102 - r109.width()) / 2, 0);
        int r111 = RangesKt.coerceAtLeast((r103 - r109.height()) / 2, 0);
        if (r110 != 0) goto L30;
        if (r111 == 0) goto L47;
    L30:
        if (r110 <= 0) goto L32;
        r109.left = RangesKt.coerceAtLeast(r109.left - r110, r100.f38143b.left);
        r109.right = RangesKt.coerceAtMost(r109.right + r110, r100.f38143b.right);
    L32:
        if (r111 <= 0) goto L34;
        r109.top = RangesKt.coerceAtLeast(r109.top - r111, r100.f38143b.top);
        r109.bottom = RangesKt.coerceAtMost(r109.bottom + r111, r100.f38143b.bottom);
    L34:
        TouchDelegate r112 = new TouchDelegate(r109, r101);
        WeakReference<TouchDelegateComposite> r113 = r100.f38142a.get(r108);
        if (r113 == null) goto L39;
        TouchDelegateComposite r114 = r113.get();
        if (r114 == null) goto L39;
        r108.setTouchDelegate(r114);
        r114.f38139a.put(new WeakReference(r101), r112);
        return true;
    L39:
        Rect r115 = new Rect();
        r108.getHitRect(r115);
        TouchDelegateComposite r116 = new TouchDelegateComposite(r108, r115);
        WeakHashMap<View, WeakReference<TouchDelegateComposite>> r117 = r100.f38142a;
        monitor-enter(r117);
        r100.f38142a.put(r108, new WeakReference(r116));     // Catch: Throwable -> L44
        Unit r118 = Unit.INSTANCE;     // Catch: Throwable -> L44
        monitor-exit(r117);
        r108.setTouchDelegate(r116);
        r116.f38139a.put(new WeakReference(r101), r112);
        return true;
    L44:
        th = move-exception;
        throw th;
    L47:
        return false;
    L17:
        if (r105.isLongClickable() == true) goto L20;
        r107 = false;
        goto L21
    L10:
        if (r105.getHeight() < f38141g) goto L12;
        r106 = true;
    L23:
        r104 = r104.getParent();
        goto L4
    L24:
        r108 = null;
        goto L25
    }

    public static boolean f(View r100, Function0 r101) {
        if (r100.isClickable() == false) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
    L75:
        return false;
    L11:
        if (r100.getWidth() != 0) goto L13;
    L20:
        boolean r103 = false;
    L21:
        if (r103 == false) goto L75;
    L33:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L37;
        Context r104 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L37:
        boolean r105 = false;
    L38:
        if (r105 == false) goto L75;
        Object r106 = r100;
    L41:
        if ((r106 instanceof View) == false) goto L49;
        View r107 = (View) r106;
        if (r107.getAlpha() <= 0.0f) goto L48;
        if (r107.getVisibility() != 0) goto L48;
        r106 = r107.getParent();
    L48:
        boolean r108 = false;
    L50:
        if (r108 == true) goto L52;
    L70:
        boolean r109 = false;
    L71:
        if (r109 == false) goto L75;
        if (((Boolean) r101.invoke()).booleanValue() == false) goto L75;
        return true;
    L52:
        if (r100.isImportantForAccessibility() == false) goto L70;
        if (com.bytedance.android.accessibilityLib_Core.util.a.d(r100) == false) goto L66;
        boolean r110 = r100 instanceof ViewGroup;
        if (r110 == false) goto L69;
        if (r110 == false) goto L63;
        if (com.bytedance.android.accessibilityLib_Core.util.a.a((ViewGroup) r100) == false) goto L69;
    L63:
        if (com.bytedance.android.accessibilityLib_Core.util.a.e(r100) == false) goto L70;
    L69:
        r109 = true;
        goto L71
    L66:
        if (com.bytedance.android.accessibilityLib_Core.util.a.c(r100) == false) goto L70;
        if (com.bytedance.android.accessibilityLib_Core.util.a.b(r100) == true) goto L70;
    L49:
        r108 = r100.getGlobalVisibleRect(new Rect());
        goto L50
    L23:
        if ((r100 instanceof ViewGroup) == false) goto L32;
        CharSequence r111 = ((ViewGroup) r100).getContentDescription();     // Catch: Exception -> L33
        if (r111 == null) goto L30;
        if (r111.length() == 0) goto L30;
        boolean r112 = false;
    L31:
        if (r112 == true) goto L37;
    L30:
        r112 = true;
    L32:
        r105 = true;
        goto L38
    L13:
        if (r100.getHeight() == 0) goto L20;
        if (r100.getWidth() >= f38140f) goto L20;
        if (r100.getHeight() >= f38141g) goto L20;
        r103 = true;
        goto L21
    L5:
        if (r100.isLongClickable() == true) goto L8;
        r102 = false;
        goto L9
    }

    @Override // com.bytedance.android.accessibilityLib_Core.processor.a
    public final void a(WeakReference<View> r100, h r101) {
        com.bytedance.android.accessibilityLib_Core.processor.a r102 = this.f38146e;
        if (r102 == null) goto L6;
        r102.a(r100, r101);
        return;
    }

    @Override // com.bytedance.android.accessibilityLib_Core.processor.a
    public final void b(View r100, int r101, boolean r102) {
    L19:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L23;
        Context r103 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L23:
        Context r104 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
        Unit r105 = Unit.INSTANCE;
        return;
    L4:
        if (("[[LargeTouchAreaProcessor]]>>>consumeViewDirectly,view = " + r100) == null) goto L6;
        Context r106 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;     // Catch: Exception -> L19
    L6:
        int r107 = r100.getWidth();     // Catch: Exception -> L19
        int r108 = r100.getHeight();     // Catch: Exception -> L19
        if (r107 <= 0) goto L15;
        if (r108 <= 0) goto L15;
        if (f(r100, LargeTouchAreaProcessor$shouldLargerTouchArea$1.INSTANCE) == false) goto L12;
        d(this.f38145d.a(r100, r101));     // Catch: Exception -> L19
        Unit r109 = Unit.INSTANCE;     // Catch: Exception -> L19
        return;
    L12:
        com.bytedance.android.accessibilityLib_Core.processor.a r110 = this.f38146e;     // Catch: Exception -> L19
        if (r110 == null) goto L27;
        r110.b(r100, r101, false);     // Catch: Exception -> L19
        Unit r111 = Unit.INSTANCE;     // Catch: Exception -> L19
        return;
    L27:
        return;
    L15:
        com.bytedance.android.accessibilityLib_Core.processor.a r112 = this.f38146e;     // Catch: Exception -> L19
        if (r112 == null) goto L29;
        r112.b(r100, r101, false);     // Catch: Exception -> L19
        Unit r113 = Unit.INSTANCE;     // Catch: Exception -> L19
        return;
    }
}
