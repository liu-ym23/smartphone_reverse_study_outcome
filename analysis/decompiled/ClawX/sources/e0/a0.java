package e0;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import com.stepos.stepclaw.R;
import java.util.ArrayList;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class a0 {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f2285a = {R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};

    /* renamed from: b, reason: collision with root package name */
    public static final s f2286b = new s();

    public static ArrayList a(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_accessibility_actions);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(R.id.tag_accessibility_actions, arrayList2);
        return arrayList2;
    }

    public static void b(View view, int i8) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z = x.a(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (view.getAccessibilityLiveRegion() != 0 || z) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z ? 32 : 2048);
                accessibilityEventObtain.setContentChangeTypes(i8);
                if (z) {
                    accessibilityEventObtain.getText().add(x.a(view));
                    if (view.getImportantForAccessibility() == 0) {
                        view.setImportantForAccessibility(1);
                    }
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i8 != 32) {
                if (view.getParent() != null) {
                    try {
                        view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i8);
                        return;
                    } catch (AbstractMethodError e9) {
                        Log.e("ViewCompat", view.getParent().getClass().getSimpleName().concat(" does not fully implement ViewParent"), e9);
                        return;
                    }
                }
                return;
            }
            AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
            view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
            accessibilityEventObtain2.setEventType(32);
            accessibilityEventObtain2.setContentChangeTypes(i8);
            accessibilityEventObtain2.setSource(view);
            view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
            accessibilityEventObtain2.getText().add(x.a(view));
            accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
        }
    }

    public static void c(View view, int i8) {
        ArrayList arrayListA = a(view);
        for (int i9 = 0; i9 < arrayListA.size(); i9++) {
            if (((f0.c) arrayListA.get(i9)).a() == i8) {
                arrayListA.remove(i9);
                return;
            }
        }
    }

    public static void d(View view, f0.c cVar, f0.p pVar) {
        f0.c cVar2 = new f0.c(null, cVar.f2540b, null, pVar, cVar.f2541c);
        View.AccessibilityDelegate accessibilityDelegateA = y.a(view);
        b bVar = accessibilityDelegateA == null ? null : accessibilityDelegateA instanceof a ? ((a) accessibilityDelegateA).f2284a : new b(accessibilityDelegateA);
        if (bVar == null) {
            bVar = new b();
        }
        e(view, bVar);
        c(view, cVar2.a());
        a(view).add(cVar2);
        b(view, 0);
    }

    public static void e(View view, b bVar) {
        if (bVar == null && (y.a(view) instanceof a)) {
            bVar = new b();
        }
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
        view.setAccessibilityDelegate(bVar == null ? null : bVar.f2289b);
    }

    public static void f(View view, CharSequence charSequence) {
        Object tag;
        androidx.datastore.preferences.protobuf.j jVar = new androidx.datastore.preferences.protobuf.j(R.id.tag_accessibility_pane_title, CharSequence.class, 8, 28);
        if (Build.VERSION.SDK_INT >= jVar.f502c) {
            x.d(view, charSequence);
        } else {
            if (Build.VERSION.SDK_INT >= jVar.f502c) {
                tag = x.a(view);
            } else {
                tag = view.getTag(jVar.f501b);
                if (!((Class) jVar.f503e).isInstance(tag)) {
                    tag = null;
                }
            }
            if (!TextUtils.equals((CharSequence) tag, charSequence)) {
                View.AccessibilityDelegate accessibilityDelegateA = y.a(view);
                b bVar = accessibilityDelegateA != null ? accessibilityDelegateA instanceof a ? ((a) accessibilityDelegateA).f2284a : new b(accessibilityDelegateA) : null;
                if (bVar == null) {
                    bVar = new b();
                }
                e(view, bVar);
                view.setTag(jVar.f501b, charSequence);
                b(view, jVar.d);
            }
        }
        s sVar = f2286b;
        if (charSequence == null) {
            sVar.f2333a.remove(view);
            view.removeOnAttachStateChangeListener(sVar);
            view.getViewTreeObserver().removeOnGlobalLayoutListener(sVar);
        } else {
            sVar.f2333a.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(sVar);
            if (view.isAttachedToWindow()) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(sVar);
            }
        }
    }
}
