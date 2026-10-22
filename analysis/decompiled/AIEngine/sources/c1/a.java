package c1;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import c1.b;
import com.google.android.material.chip.Chip;
import com.stepos.core.common.util.TraceIdKeys;
import java.util.ArrayList;
import java.util.WeakHashMap;
import v0.e0;
import v0.h0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class a extends v0.a {

    /* renamed from: k, reason: collision with root package name */
    public static final Rect f3243k = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* renamed from: l, reason: collision with root package name */
    public static final C0026a f3244l = new C0026a();

    /* renamed from: m, reason: collision with root package name */
    public static final b f3245m = new b();

    /* renamed from: e, reason: collision with root package name */
    public final AccessibilityManager f3250e;

    /* renamed from: f, reason: collision with root package name */
    public final Chip f3251f;

    /* renamed from: g, reason: collision with root package name */
    public c f3252g;

    /* renamed from: a, reason: collision with root package name */
    public final Rect f3246a = new Rect();

    /* renamed from: b, reason: collision with root package name */
    public final Rect f3247b = new Rect();

    /* renamed from: c, reason: collision with root package name */
    public final Rect f3248c = new Rect();

    /* renamed from: d, reason: collision with root package name */
    public final int[] f3249d = new int[2];
    public int h = Integer.MIN_VALUE;

    /* renamed from: i, reason: collision with root package name */
    public int f3253i = Integer.MIN_VALUE;

    /* renamed from: j, reason: collision with root package name */
    public int f3254j = Integer.MIN_VALUE;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: c1.a$a, reason: collision with other inner class name */
    public class C0026a implements b.a<w0.b> {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c extends w0.c {
        public c() {
        }

        @Override // w0.c
        public final w0.b b(int i10) {
            return new w0.b(AccessibilityNodeInfo.obtain(a.this.e(i10).f13532a));
        }

        @Override // w0.c
        public final w0.b c(int i10) {
            a aVar = a.this;
            int i11 = i10 == 2 ? aVar.h : aVar.f3253i;
            if (i11 == Integer.MIN_VALUE) {
                return null;
            }
            return b(i11);
        }

        @Override // w0.c
        public final boolean d(int i10, int i11, Bundle bundle) {
            int i12;
            a aVar = a.this;
            Chip chip = aVar.f3251f;
            if (i10 == -1) {
                WeakHashMap<View, h0> weakHashMap = e0.f13274a;
                return chip.performAccessibilityAction(i11, bundle);
            }
            if (i11 == 1) {
                return aVar.h(i10);
            }
            if (i11 == 2) {
                return aVar.a(i10);
            }
            boolean z = false;
            if (i11 == 64) {
                AccessibilityManager accessibilityManager = aVar.f3250e;
                if (!accessibilityManager.isEnabled() || !accessibilityManager.isTouchExplorationEnabled() || (i12 = aVar.h) == i10) {
                    return false;
                }
                if (i12 != Integer.MIN_VALUE) {
                    aVar.h = Integer.MIN_VALUE;
                    chip.invalidate();
                    aVar.i(i12, 65536);
                }
                aVar.h = i10;
                chip.invalidate();
                aVar.i(i10, 32768);
                return true;
            }
            if (i11 == 128) {
                if (aVar.h != i10) {
                    return false;
                }
                aVar.h = Integer.MIN_VALUE;
                chip.invalidate();
                aVar.i(i10, 65536);
                return true;
            }
            Chip chip2 = Chip.this;
            if (i11 == 16) {
                if (i10 == 0) {
                    return chip2.performClick();
                }
                if (i10 == 1) {
                    chip2.playSoundEffect(0);
                    View.OnClickListener onClickListener = chip2.f4860k;
                    if (onClickListener != null) {
                        onClickListener.onClick(chip2);
                        z = true;
                    }
                    if (chip2.f4870v) {
                        chip2.f4869u.i(1, 1);
                    }
                }
            }
            return z;
        }
    }

    public a(Chip chip) {
        this.f3251f = chip;
        this.f3250e = (AccessibilityManager) chip.getContext().getSystemService("accessibility");
        chip.setFocusable(true);
        WeakHashMap<View, h0> weakHashMap = e0.f13274a;
        if (chip.getImportantForAccessibility() == 0) {
            chip.setImportantForAccessibility(1);
        }
    }

    public final boolean a(int i10) {
        if (this.f3253i != i10) {
            return false;
        }
        this.f3253i = Integer.MIN_VALUE;
        g(i10, false);
        i(i10, 8);
        return true;
    }

    public final w0.b b(int i10) {
        AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain();
        w0.b bVar = new w0.b(accessibilityNodeInfoObtain);
        accessibilityNodeInfoObtain.setEnabled(true);
        accessibilityNodeInfoObtain.setFocusable(true);
        bVar.h("android.view.View");
        Rect rect = f3243k;
        accessibilityNodeInfoObtain.setBoundsInParent(rect);
        accessibilityNodeInfoObtain.setBoundsInScreen(rect);
        bVar.f13533b = -1;
        Chip chip = this.f3251f;
        accessibilityNodeInfoObtain.setParent(chip);
        f(i10, bVar);
        if (bVar.g() == null && accessibilityNodeInfoObtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        Rect rect2 = this.f3247b;
        bVar.f(rect2);
        if (rect2.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int actions = accessibilityNodeInfoObtain.getActions();
        if ((actions & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((actions & TraceIdKeys.MAX_LENGTH) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        accessibilityNodeInfoObtain.setPackageName(chip.getContext().getPackageName());
        bVar.f13534c = i10;
        accessibilityNodeInfoObtain.setSource(chip, i10);
        if (this.h == i10) {
            accessibilityNodeInfoObtain.setAccessibilityFocused(true);
            bVar.a(TraceIdKeys.MAX_LENGTH);
        } else {
            accessibilityNodeInfoObtain.setAccessibilityFocused(false);
            bVar.a(64);
        }
        boolean z = this.f3253i == i10;
        if (z) {
            bVar.a(2);
        } else if (accessibilityNodeInfoObtain.isFocusable()) {
            bVar.a(1);
        }
        accessibilityNodeInfoObtain.setFocused(z);
        int[] iArr = this.f3249d;
        chip.getLocationOnScreen(iArr);
        Rect rect3 = this.f3246a;
        accessibilityNodeInfoObtain.getBoundsInScreen(rect3);
        if (rect3.equals(rect)) {
            bVar.f(rect3);
            if (bVar.f13533b != -1) {
                w0.b bVar2 = new w0.b(AccessibilityNodeInfo.obtain());
                for (int i11 = bVar.f13533b; i11 != -1; i11 = bVar2.f13533b) {
                    bVar2.f13533b = -1;
                    AccessibilityNodeInfo accessibilityNodeInfo = bVar2.f13532a;
                    accessibilityNodeInfo.setParent(chip, -1);
                    accessibilityNodeInfo.setBoundsInParent(rect);
                    f(i11, bVar2);
                    bVar2.f(rect2);
                    rect3.offset(rect2.left, rect2.top);
                }
            }
            rect3.offset(iArr[0] - chip.getScrollX(), iArr[1] - chip.getScrollY());
        }
        Rect rect4 = this.f3248c;
        if (chip.getLocalVisibleRect(rect4)) {
            rect4.offset(iArr[0] - chip.getScrollX(), iArr[1] - chip.getScrollY());
            if (rect3.intersect(rect4)) {
                AccessibilityNodeInfo accessibilityNodeInfo2 = bVar.f13532a;
                accessibilityNodeInfo2.setBoundsInScreen(rect3);
                if (!rect3.isEmpty() && chip.getWindowVisibility() == 0) {
                    Object parent = chip.getParent();
                    while (true) {
                        if (parent instanceof View) {
                            View view = (View) parent;
                            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                                break;
                            }
                            parent = view.getParent();
                        } else if (parent != null) {
                            accessibilityNodeInfo2.setVisibleToUser(true);
                        }
                    }
                }
            }
        }
        return bVar;
    }

    public abstract void c(ArrayList arrayList);

    /* JADX WARN: Removed duplicated region for block: B:40:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d(int r19, android.graphics.Rect r20) {
        /*
            Method dump skipped, instructions count: 488
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.a.d(int, android.graphics.Rect):boolean");
    }

    public final w0.b e(int i10) {
        if (i10 != -1) {
            return b(i10);
        }
        Chip chip = this.f3251f;
        AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(chip);
        w0.b bVar = new w0.b(accessibilityNodeInfoObtain);
        WeakHashMap<View, h0> weakHashMap = e0.f13274a;
        chip.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoObtain);
        ArrayList arrayList = new ArrayList();
        c(arrayList);
        if (accessibilityNodeInfoObtain.getChildCount() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            bVar.f13532a.addChild(chip, ((Integer) arrayList.get(i11)).intValue());
        }
        return bVar;
    }

    public abstract void f(int i10, w0.b bVar);

    public abstract void g(int i10, boolean z);

    @Override // v0.a
    public final w0.c getAccessibilityNodeProvider(View view) {
        if (this.f3252g == null) {
            this.f3252g = new c();
        }
        return this.f3252g;
    }

    public final boolean h(int i10) {
        int i11;
        Chip chip = this.f3251f;
        if ((!chip.isFocused() && !chip.requestFocus()) || (i11 = this.f3253i) == i10) {
            return false;
        }
        if (i11 != Integer.MIN_VALUE) {
            a(i11);
        }
        if (i10 == Integer.MIN_VALUE) {
            return false;
        }
        this.f3253i = i10;
        g(i10, true);
        i(i10, 8);
        return true;
    }

    public final void i(int i10, int i11) {
        View view;
        ViewParent parent;
        AccessibilityEvent accessibilityEventObtain;
        if (i10 == Integer.MIN_VALUE || !this.f3250e.isEnabled() || (parent = (view = this.f3251f).getParent()) == null) {
            return;
        }
        if (i10 != -1) {
            accessibilityEventObtain = AccessibilityEvent.obtain(i11);
            w0.b bVarE = e(i10);
            accessibilityEventObtain.getText().add(bVarE.g());
            AccessibilityNodeInfo accessibilityNodeInfo = bVarE.f13532a;
            accessibilityEventObtain.setContentDescription(accessibilityNodeInfo.getContentDescription());
            accessibilityEventObtain.setScrollable(accessibilityNodeInfo.isScrollable());
            accessibilityEventObtain.setPassword(accessibilityNodeInfo.isPassword());
            accessibilityEventObtain.setEnabled(accessibilityNodeInfo.isEnabled());
            accessibilityEventObtain.setChecked(accessibilityNodeInfo.isChecked());
            if (accessibilityEventObtain.getText().isEmpty() && accessibilityEventObtain.getContentDescription() == null) {
                throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
            }
            accessibilityEventObtain.setClassName(accessibilityNodeInfo.getClassName());
            accessibilityEventObtain.setSource(view, i10);
            accessibilityEventObtain.setPackageName(view.getContext().getPackageName());
        } else {
            accessibilityEventObtain = AccessibilityEvent.obtain(i11);
            view.onInitializeAccessibilityEvent(accessibilityEventObtain);
        }
        parent.requestSendAccessibilityEvent(view, accessibilityEventObtain);
    }

    @Override // v0.a
    public final void onInitializeAccessibilityNodeInfo(View view, w0.b bVar) {
        super.onInitializeAccessibilityNodeInfo(view, bVar);
        Chip chip = Chip.this;
        com.google.android.material.chip.a aVar = chip.f4858e;
        bVar.f13532a.setCheckable(aVar != null && aVar.f4876a0);
        bVar.f13532a.setClickable(chip.isClickable());
        bVar.h(chip.getAccessibilityClassName());
        bVar.m(chip.getText());
    }
}
