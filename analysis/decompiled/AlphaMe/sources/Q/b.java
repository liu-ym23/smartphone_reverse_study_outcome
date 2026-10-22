package Q;

import K.C0069b;
import K.S;
import L.g;
import L.j;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.chip.Chip;
import com.stepos.alphame.utils.Property;
import java.util.ArrayList;
import java.util.WeakHashMap;
import y1.f;

/* loaded from: classes.dex */
public abstract class b extends C0069b {

    /* renamed from: k, reason: collision with root package name */
    public static final Rect f1586k = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* renamed from: l, reason: collision with root package name */
    public static final f f1587l = new f(9);

    /* renamed from: m, reason: collision with root package name */
    public static final f f1588m = new f(10);

    /* renamed from: e, reason: collision with root package name */
    public final AccessibilityManager f1593e;

    /* renamed from: f, reason: collision with root package name */
    public final View f1594f;

    /* renamed from: g, reason: collision with root package name */
    public a f1595g;

    /* renamed from: a, reason: collision with root package name */
    public final Rect f1589a = new Rect();

    /* renamed from: b, reason: collision with root package name */
    public final Rect f1590b = new Rect();

    /* renamed from: c, reason: collision with root package name */
    public final Rect f1591c = new Rect();

    /* renamed from: d, reason: collision with root package name */
    public final int[] f1592d = new int[2];

    /* renamed from: h, reason: collision with root package name */
    public int f1596h = Integer.MIN_VALUE;

    /* renamed from: i, reason: collision with root package name */
    public int f1597i = Integer.MIN_VALUE;

    /* renamed from: j, reason: collision with root package name */
    public int f1598j = Integer.MIN_VALUE;

    public b(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.f1594f = view;
        this.f1593e = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        WeakHashMap weakHashMap = S.f939a;
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
    }

    public final boolean a(int i4) {
        if (this.f1597i != i4) {
            return false;
        }
        this.f1597i = Integer.MIN_VALUE;
        g(i4, false);
        i(i4, 8);
        return true;
    }

    public final g b(int i4) {
        AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain();
        g gVar = new g(accessibilityNodeInfoObtain);
        accessibilityNodeInfoObtain.setEnabled(true);
        accessibilityNodeInfoObtain.setFocusable(true);
        gVar.g("android.view.View");
        Rect rect = f1586k;
        accessibilityNodeInfoObtain.setBoundsInParent(rect);
        accessibilityNodeInfoObtain.setBoundsInScreen(rect);
        gVar.f1143b = -1;
        View view = this.f1594f;
        accessibilityNodeInfoObtain.setParent(view);
        f(i4, gVar);
        if (gVar.f() == null && accessibilityNodeInfoObtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        Rect rect2 = this.f1590b;
        gVar.e(rect2);
        if (rect2.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int actions = accessibilityNodeInfoObtain.getActions();
        if ((actions & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((actions & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        accessibilityNodeInfoObtain.setPackageName(view.getContext().getPackageName());
        gVar.f1144c = i4;
        accessibilityNodeInfoObtain.setSource(view, i4);
        if (this.f1596h == i4) {
            accessibilityNodeInfoObtain.setAccessibilityFocused(true);
            gVar.a(128);
        } else {
            accessibilityNodeInfoObtain.setAccessibilityFocused(false);
            gVar.a(64);
        }
        boolean z4 = this.f1597i == i4;
        if (z4) {
            gVar.a(2);
        } else if (accessibilityNodeInfoObtain.isFocusable()) {
            gVar.a(1);
        }
        accessibilityNodeInfoObtain.setFocused(z4);
        int[] iArr = this.f1592d;
        view.getLocationOnScreen(iArr);
        Rect rect3 = this.f1589a;
        accessibilityNodeInfoObtain.getBoundsInScreen(rect3);
        if (rect3.equals(rect)) {
            gVar.e(rect3);
            if (gVar.f1143b != -1) {
                g gVar2 = new g(AccessibilityNodeInfo.obtain());
                for (int i5 = gVar.f1143b; i5 != -1; i5 = gVar2.f1143b) {
                    gVar2.f1143b = -1;
                    AccessibilityNodeInfo accessibilityNodeInfo = gVar2.f1142a;
                    accessibilityNodeInfo.setParent(view, -1);
                    accessibilityNodeInfo.setBoundsInParent(rect);
                    f(i5, gVar2);
                    gVar2.e(rect2);
                    rect3.offset(rect2.left, rect2.top);
                }
            }
            rect3.offset(iArr[0] - view.getScrollX(), iArr[1] - view.getScrollY());
        }
        Rect rect4 = this.f1591c;
        if (view.getLocalVisibleRect(rect4)) {
            rect4.offset(iArr[0] - view.getScrollX(), iArr[1] - view.getScrollY());
            if (rect3.intersect(rect4)) {
                AccessibilityNodeInfo accessibilityNodeInfo2 = gVar.f1142a;
                accessibilityNodeInfo2.setBoundsInScreen(rect3);
                if (!rect3.isEmpty() && view.getWindowVisibility() == 0) {
                    Object parent = view.getParent();
                    while (true) {
                        if (parent instanceof View) {
                            View view2 = (View) parent;
                            if (view2.getAlpha() <= Property.DEFAULT_FLOAT_VALUE || view2.getVisibility() != 0) {
                                break;
                            }
                            parent = view2.getParent();
                        } else if (parent != null) {
                            accessibilityNodeInfo2.setVisibleToUser(true);
                        }
                    }
                }
            }
        }
        return gVar;
    }

    public abstract void c(ArrayList arrayList);

    /* JADX WARN: Removed duplicated region for block: B:40:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d(int r20, android.graphics.Rect r21) {
        /*
            Method dump skipped, instructions count: 488
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Q.b.d(int, android.graphics.Rect):boolean");
    }

    public final g e(int i4) {
        if (i4 != -1) {
            return b(i4);
        }
        View view = this.f1594f;
        AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(view);
        g gVar = new g(accessibilityNodeInfoObtain);
        WeakHashMap weakHashMap = S.f939a;
        view.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoObtain);
        ArrayList arrayList = new ArrayList();
        c(arrayList);
        if (accessibilityNodeInfoObtain.getChildCount() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            gVar.f1142a.addChild(view, ((Integer) arrayList.get(i5)).intValue());
        }
        return gVar;
    }

    public abstract void f(int i4, g gVar);

    public abstract void g(int i4, boolean z4);

    @Override // K.C0069b
    public final j getAccessibilityNodeProvider(View view) {
        if (this.f1595g == null) {
            this.f1595g = new a(this);
        }
        return this.f1595g;
    }

    public final boolean h(int i4) {
        int i5;
        View view = this.f1594f;
        if ((!view.isFocused() && !view.requestFocus()) || (i5 = this.f1597i) == i4) {
            return false;
        }
        if (i5 != Integer.MIN_VALUE) {
            a(i5);
        }
        if (i4 == Integer.MIN_VALUE) {
            return false;
        }
        this.f1597i = i4;
        g(i4, true);
        i(i4, 8);
        return true;
    }

    public final void i(int i4, int i5) {
        View view;
        ViewParent parent;
        AccessibilityEvent accessibilityEventObtain;
        if (i4 == Integer.MIN_VALUE || !this.f1593e.isEnabled() || (parent = (view = this.f1594f).getParent()) == null) {
            return;
        }
        if (i4 != -1) {
            accessibilityEventObtain = AccessibilityEvent.obtain(i5);
            g gVarE = e(i4);
            accessibilityEventObtain.getText().add(gVarE.f());
            AccessibilityNodeInfo accessibilityNodeInfo = gVarE.f1142a;
            accessibilityEventObtain.setContentDescription(accessibilityNodeInfo.getContentDescription());
            accessibilityEventObtain.setScrollable(accessibilityNodeInfo.isScrollable());
            accessibilityEventObtain.setPassword(accessibilityNodeInfo.isPassword());
            accessibilityEventObtain.setEnabled(accessibilityNodeInfo.isEnabled());
            accessibilityEventObtain.setChecked(accessibilityNodeInfo.isChecked());
            if (accessibilityEventObtain.getText().isEmpty() && accessibilityEventObtain.getContentDescription() == null) {
                throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
            }
            accessibilityEventObtain.setClassName(accessibilityNodeInfo.getClassName());
            accessibilityEventObtain.setSource(view, i4);
            accessibilityEventObtain.setPackageName(view.getContext().getPackageName());
        } else {
            accessibilityEventObtain = AccessibilityEvent.obtain(i5);
            view.onInitializeAccessibilityEvent(accessibilityEventObtain);
        }
        parent.requestSendAccessibilityEvent(view, accessibilityEventObtain);
    }

    @Override // K.C0069b
    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    @Override // K.C0069b
    public final void onInitializeAccessibilityNodeInfo(View view, g gVar) {
        super.onInitializeAccessibilityNodeInfo(view, gVar);
        Chip chip = ((r1.d) this).f14011n;
        boolean zD = chip.d();
        AccessibilityNodeInfo accessibilityNodeInfo = gVar.f1142a;
        accessibilityNodeInfo.setCheckable(zD);
        accessibilityNodeInfo.setClickable(chip.isClickable());
        gVar.g(chip.getAccessibilityClassName());
        gVar.i(chip.getText());
    }
}
