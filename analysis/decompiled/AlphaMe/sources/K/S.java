package K;

import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import com.stepos.alphame.R;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public abstract class S {

    /* renamed from: a, reason: collision with root package name */
    public static WeakHashMap f939a;

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f940b = {R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};

    /* renamed from: c, reason: collision with root package name */
    public static final F f941c = new F();

    public static e0 a(View view) {
        if (f939a == null) {
            f939a = new WeakHashMap();
        }
        e0 e0Var = (e0) f939a.get(view);
        if (e0Var != null) {
            return e0Var;
        }
        e0 e0Var2 = new e0(view);
        f939a.put(view, e0Var2);
        return e0Var2;
    }

    public static z0 b(View view, z0 z0Var) {
        WindowInsets windowInsetsE = z0Var.e();
        if (windowInsetsE != null) {
            WindowInsets windowInsetsA = H.a(view, windowInsetsE);
            if (!windowInsetsA.equals(windowInsetsE)) {
                return z0.f(view, windowInsetsA);
            }
        }
        return z0Var;
    }

    public static ArrayList c(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_accessibility_actions);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(R.id.tag_accessibility_actions, arrayList2);
        return arrayList2;
    }

    public static void d(int i4, View view) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z4 = N.b(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (view.getAccessibilityLiveRegion() != 0 || z4) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z4 ? 32 : 2048);
                accessibilityEventObtain.setContentChangeTypes(i4);
                if (z4) {
                    accessibilityEventObtain.getText().add(N.b(view));
                    if (view.getImportantForAccessibility() == 0) {
                        view.setImportantForAccessibility(1);
                    }
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i4 != 32) {
                if (view.getParent() != null) {
                    try {
                        view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i4);
                        return;
                    } catch (AbstractMethodError e4) {
                        Log.e("ViewCompat", view.getParent().getClass().getSimpleName().concat(" does not fully implement ViewParent"), e4);
                        return;
                    }
                }
                return;
            }
            AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
            view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
            accessibilityEventObtain2.setEventType(32);
            accessibilityEventObtain2.setContentChangeTypes(i4);
            accessibilityEventObtain2.setSource(view);
            view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
            accessibilityEventObtain2.getText().add(N.b(view));
            accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
        }
    }

    public static z0 e(View view, z0 z0Var) {
        WindowInsets windowInsetsE = z0Var.e();
        if (windowInsetsE != null) {
            WindowInsets windowInsetsB = H.b(view, windowInsetsE);
            if (!windowInsetsB.equals(windowInsetsE)) {
                return z0.f(view, windowInsetsB);
            }
        }
        return z0Var;
    }

    public static void f(int i4, View view) {
        ArrayList arrayListC = c(view);
        for (int i5 = 0; i5 < arrayListC.size(); i5++) {
            if (((L.b) arrayListC.get(i5)).a() == i4) {
                arrayListC.remove(i5);
                return;
            }
        }
    }

    public static void g(View view, L.b bVar, L.r rVar) {
        L.b bVar2 = new L.b(null, bVar.f1138b, null, rVar, bVar.f1139c);
        View.AccessibilityDelegate accessibilityDelegateA = O.a(view);
        C0069b c0069b = accessibilityDelegateA == null ? null : accessibilityDelegateA instanceof C0067a ? ((C0067a) accessibilityDelegateA).f947a : new C0069b(accessibilityDelegateA);
        if (c0069b == null) {
            c0069b = new C0069b();
        }
        h(view, c0069b);
        f(bVar2.a(), view);
        c(view).add(bVar2);
        d(0, view);
    }

    public static void h(View view, C0069b c0069b) {
        if (c0069b == null && (O.a(view) instanceof C0067a)) {
            c0069b = new C0069b();
        }
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
        view.setAccessibilityDelegate(c0069b == null ? null : c0069b.getBridge());
    }

    public static void i(View view, CharSequence charSequence) {
        new E(R.id.tag_accessibility_pane_title, 8, 28, 1 == true ? 1 : 0).b(view, charSequence);
        F f4 = f941c;
        if (charSequence == null) {
            f4.f932a.remove(view);
            view.removeOnAttachStateChangeListener(f4);
            view.getViewTreeObserver().removeOnGlobalLayoutListener(f4);
        } else {
            f4.f932a.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(f4);
            if (view.isAttachedToWindow()) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(f4);
            }
        }
    }
}
