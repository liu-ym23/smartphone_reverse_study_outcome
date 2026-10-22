package n3;

import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class k0 {

    /* renamed from: a, reason: collision with root package name */
    public static WeakHashMap f8724a;

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f8725b = {R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};

    /* renamed from: c, reason: collision with root package name */
    public static final c0 f8726c;

    static {
        c0 c0Var = new c0();
        c0Var.f8697c = new WeakHashMap();
        VarHandle.storeStoreFence();
        f8726c = c0Var;
    }

    public static o0 a(View view) {
        if (f8724a == null) {
            f8724a = new WeakHashMap();
        }
        o0 o0Var = (o0) f8724a.get(view);
        if (o0Var != null) {
            return o0Var;
        }
        o0 o0Var2 = new o0();
        o0Var2.f8739a = new WeakReference(view);
        VarHandle.storeStoreFence();
        f8724a.put(view, o0Var2);
        return o0Var2;
    }

    public static ArrayList b(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_accessibility_actions);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(R.id.tag_accessibility_actions, arrayList2);
        return arrayList2;
    }

    public static void c(int i, View view) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z10 = h0.a(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (view.getAccessibilityLiveRegion() != 0 || z10) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z10 ? 32 : RecyclerView.ItemAnimator.FLAG_MOVED);
                accessibilityEventObtain.setContentChangeTypes(i);
                if (z10) {
                    accessibilityEventObtain.getText().add(h0.a(view));
                    if (view.getImportantForAccessibility() == 0) {
                        view.setImportantForAccessibility(1);
                    }
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i != 32) {
                if (view.getParent() != null) {
                    try {
                        view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i);
                        return;
                    } catch (AbstractMethodError e10) {
                        Log.e("ViewCompat", view.getParent().getClass().getSimpleName().concat(" does not fully implement ViewParent"), e10);
                        return;
                    }
                }
                return;
            }
            AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
            view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
            accessibilityEventObtain2.setEventType(32);
            accessibilityEventObtain2.setContentChangeTypes(i);
            accessibilityEventObtain2.setSource(view);
            view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
            accessibilityEventObtain2.getText().add(h0.a(view));
            accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
        }
    }

    public static m1 d(View view, m1 m1Var) {
        WindowInsets windowInsetsG = m1Var.g();
        if (windowInsetsG != null) {
            WindowInsets windowInsetsOnApplyWindowInsets = view.onApplyWindowInsets(windowInsetsG);
            if (!windowInsetsOnApplyWindowInsets.equals(windowInsetsG)) {
                return m1.h(view, windowInsetsOnApplyWindowInsets);
            }
        }
        return m1Var;
    }

    public static void e(int i, View view) {
        ArrayList arrayListB = b(view);
        for (int i3 = 0; i3 < arrayListB.size(); i3++) {
            if (((o3.b) arrayListB.get(i3)).a() == i) {
                arrayListB.remove(i3);
                return;
            }
        }
    }

    public static void f(View view, o3.b bVar, o3.o oVar) {
        o3.b bVar2 = new o3.b(null, bVar.f9146b, null, oVar, bVar.f9147c);
        View.AccessibilityDelegate accessibilityDelegateA = i0.a(view);
        b bVar3 = accessibilityDelegateA == null ? null : accessibilityDelegateA instanceof a ? ((a) accessibilityDelegateA).f8679a : new b(accessibilityDelegateA);
        if (bVar3 == null) {
            bVar3 = new b();
        }
        g(view, bVar3);
        e(bVar2.a(), view);
        b(view).add(bVar2);
        c(0, view);
    }

    public static void g(View view, b bVar) {
        if (bVar == null && (i0.a(view) instanceof a)) {
            bVar = new b();
        }
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
        view.setAccessibilityDelegate(bVar == null ? null : bVar.getBridge());
    }

    public static void h(View view, CharSequence charSequence) {
        new b0(R.id.tag_accessibility_pane_title, CharSequence.class, 8, 28, 0).f(view, charSequence);
        c0 c0Var = f8726c;
        if (charSequence == null) {
            c0Var.f8697c.remove(view);
            view.removeOnAttachStateChangeListener(c0Var);
            view.getViewTreeObserver().removeOnGlobalLayoutListener(c0Var);
        } else {
            c0Var.f8697c.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(c0Var);
            if (view.isAttachedToWindow()) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(c0Var);
            }
        }
    }

    public static void i(View view, r0 r0Var) {
        s0 s0Var;
        if (r0Var != null) {
            s0Var = new s0(r0Var.f8745c);
            s0Var.f8749d = new HashMap();
            s0Var.f8746a = r0Var;
            VarHandle.storeStoreFence();
        } else {
            s0Var = null;
        }
        view.setWindowInsetsAnimationCallback(s0Var);
    }
}
