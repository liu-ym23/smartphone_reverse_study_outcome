package i0;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.emoji2.text.m;
import com.google.android.material.chip.Chip;
import e0.a0;
import f0.g;
import java.util.ArrayList;
import t1.f;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class b extends e0.b {

    /* renamed from: n, reason: collision with root package name */
    public static final Rect f3090n = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* renamed from: o, reason: collision with root package name */
    public static final f f3091o = new f(15);

    /* renamed from: p, reason: collision with root package name */
    public static final f f3092p = new f(16);

    /* renamed from: h, reason: collision with root package name */
    public final AccessibilityManager f3096h;

    /* renamed from: i, reason: collision with root package name */
    public final Chip f3097i;

    /* renamed from: j, reason: collision with root package name */
    public a f3098j;
    public final Rect d = new Rect();

    /* renamed from: e, reason: collision with root package name */
    public final Rect f3093e = new Rect();

    /* renamed from: f, reason: collision with root package name */
    public final Rect f3094f = new Rect();

    /* renamed from: g, reason: collision with root package name */
    public final int[] f3095g = new int[2];

    /* renamed from: k, reason: collision with root package name */
    public int f3099k = Integer.MIN_VALUE;

    /* renamed from: l, reason: collision with root package name */
    public int f3100l = Integer.MIN_VALUE;

    /* renamed from: m, reason: collision with root package name */
    public int f3101m = Integer.MIN_VALUE;

    public b(Chip chip) {
        this.f3097i = chip;
        this.f3096h = (AccessibilityManager) chip.getContext().getSystemService("accessibility");
        chip.setFocusable(true);
        int[] iArr = a0.f2285a;
        if (chip.getImportantForAccessibility() == 0) {
            chip.setImportantForAccessibility(1);
        }
    }

    @Override // e0.b
    public final m b(View view) {
        if (this.f3098j == null) {
            this.f3098j = new a(this);
        }
        return this.f3098j;
    }

    @Override // e0.b
    public final void d(View view, g gVar) {
        AccessibilityNodeInfo accessibilityNodeInfo = gVar.f2542a;
        this.f2288a.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        Chip chip = ((l1.d) this).f3737q;
        l1.f fVar = chip.f1291e;
        accessibilityNodeInfo.setCheckable(fVar != null && fVar.X);
        accessibilityNodeInfo.setClickable(chip.isClickable());
        gVar.h(chip.getAccessibilityClassName());
        accessibilityNodeInfo.setText(chip.getText());
    }

    public final boolean j(int i8) {
        if (this.f3100l != i8) {
            return false;
        }
        this.f3100l = Integer.MIN_VALUE;
        p(i8, false);
        r(i8, 8);
        return true;
    }

    public final g k(int i8) {
        AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain();
        g gVar = new g(accessibilityNodeInfoObtain);
        accessibilityNodeInfoObtain.setEnabled(true);
        accessibilityNodeInfoObtain.setFocusable(true);
        gVar.h("android.view.View");
        Rect rect = f3090n;
        accessibilityNodeInfoObtain.setBoundsInParent(rect);
        accessibilityNodeInfoObtain.setBoundsInScreen(rect);
        Chip chip = this.f3097i;
        accessibilityNodeInfoObtain.setParent(chip);
        o(i8, gVar);
        if (gVar.g() == null && accessibilityNodeInfoObtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        Rect rect2 = this.f3093e;
        gVar.f(rect2);
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
        accessibilityNodeInfoObtain.setPackageName(chip.getContext().getPackageName());
        gVar.f2543b = i8;
        accessibilityNodeInfoObtain.setSource(chip, i8);
        if (this.f3099k == i8) {
            accessibilityNodeInfoObtain.setAccessibilityFocused(true);
            gVar.a(128);
        } else {
            accessibilityNodeInfoObtain.setAccessibilityFocused(false);
            gVar.a(64);
        }
        boolean z = this.f3100l == i8;
        if (z) {
            gVar.a(2);
        } else if (accessibilityNodeInfoObtain.isFocusable()) {
            gVar.a(1);
        }
        accessibilityNodeInfoObtain.setFocused(z);
        int[] iArr = this.f3095g;
        chip.getLocationOnScreen(iArr);
        Rect rect3 = this.d;
        accessibilityNodeInfoObtain.getBoundsInScreen(rect3);
        if (rect3.equals(rect)) {
            gVar.f(rect3);
            rect3.offset(iArr[0] - chip.getScrollX(), iArr[1] - chip.getScrollY());
        }
        Rect rect4 = this.f3094f;
        if (chip.getLocalVisibleRect(rect4)) {
            rect4.offset(iArr[0] - chip.getScrollX(), iArr[1] - chip.getScrollY());
            if (rect3.intersect(rect4)) {
                accessibilityNodeInfoObtain.setBoundsInScreen(rect3);
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
                            gVar.f2542a.setVisibleToUser(true);
                        }
                    }
                }
            }
        }
        return gVar;
    }

    public abstract void l(ArrayList arrayList);

    /* JADX WARN: Removed duplicated region for block: B:40:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean m(int r19, android.graphics.Rect r20) {
        /*
            Method dump skipped, instructions count: 488
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i0.b.m(int, android.graphics.Rect):boolean");
    }

    public final g n(int i8) {
        if (i8 != -1) {
            return k(i8);
        }
        Chip chip = this.f3097i;
        AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(chip);
        g gVar = new g(accessibilityNodeInfoObtain);
        int[] iArr = a0.f2285a;
        chip.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoObtain);
        ArrayList arrayList = new ArrayList();
        l(arrayList);
        if (accessibilityNodeInfoObtain.getChildCount() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i9 = 0; i9 < size; i9++) {
            gVar.f2542a.addChild(chip, ((Integer) arrayList.get(i9)).intValue());
        }
        return gVar;
    }

    public abstract void o(int i8, g gVar);

    public abstract void p(int i8, boolean z);

    public final boolean q(int i8) {
        int i9;
        Chip chip = this.f3097i;
        if ((!chip.isFocused() && !chip.requestFocus()) || (i9 = this.f3100l) == i8) {
            return false;
        }
        if (i9 != Integer.MIN_VALUE) {
            j(i9);
        }
        if (i8 == Integer.MIN_VALUE) {
            return false;
        }
        this.f3100l = i8;
        p(i8, true);
        r(i8, 8);
        return true;
    }

    public final void r(int i8, int i9) {
        View view;
        ViewParent parent;
        AccessibilityEvent accessibilityEventObtain;
        if (i8 == Integer.MIN_VALUE || !this.f3096h.isEnabled() || (parent = (view = this.f3097i).getParent()) == null) {
            return;
        }
        if (i8 != -1) {
            accessibilityEventObtain = AccessibilityEvent.obtain(i9);
            g gVarN = n(i8);
            accessibilityEventObtain.getText().add(gVarN.g());
            AccessibilityNodeInfo accessibilityNodeInfo = gVarN.f2542a;
            accessibilityEventObtain.setContentDescription(accessibilityNodeInfo.getContentDescription());
            accessibilityEventObtain.setScrollable(accessibilityNodeInfo.isScrollable());
            accessibilityEventObtain.setPassword(accessibilityNodeInfo.isPassword());
            accessibilityEventObtain.setEnabled(accessibilityNodeInfo.isEnabled());
            accessibilityEventObtain.setChecked(accessibilityNodeInfo.isChecked());
            if (accessibilityEventObtain.getText().isEmpty() && accessibilityEventObtain.getContentDescription() == null) {
                throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
            }
            accessibilityEventObtain.setClassName(accessibilityNodeInfo.getClassName());
            accessibilityEventObtain.setSource(view, i8);
            accessibilityEventObtain.setPackageName(view.getContext().getPackageName());
        } else {
            accessibilityEventObtain = AccessibilityEvent.obtain(i9);
            view.onInitializeAccessibilityEvent(accessibilityEventObtain);
        }
        parent.requestSendAccessibilityEvent(view, accessibilityEventObtain);
    }
}
