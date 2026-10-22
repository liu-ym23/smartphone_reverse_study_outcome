package e0;

import android.os.Bundle;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeProvider;
import com.stepos.stepclaw.R;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    public static final View.AccessibilityDelegate f2287c = new View.AccessibilityDelegate();

    /* renamed from: a, reason: collision with root package name */
    public final View.AccessibilityDelegate f2288a;

    /* renamed from: b, reason: collision with root package name */
    public final a f2289b;

    public b() {
        this(f2287c);
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f2288a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public androidx.emoji2.text.m b(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider = this.f2288a.getAccessibilityNodeProvider(view);
        if (accessibilityNodeProvider != null) {
            return new androidx.emoji2.text.m(accessibilityNodeProvider);
        }
        return null;
    }

    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.f2288a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void d(View view, f0.g gVar) {
        this.f2288a.onInitializeAccessibilityNodeInfo(view, gVar.f2542a);
    }

    public void e(View view, AccessibilityEvent accessibilityEvent) {
        this.f2288a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f2288a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean g(View view, int i8, Bundle bundle) {
        boolean zPerformAccessibilityAction;
        WeakReference weakReference;
        ClickableSpan clickableSpan;
        List list = (List) view.getTag(R.id.tag_accessibility_actions);
        if (list == null) {
            list = Collections.EMPTY_LIST;
        }
        boolean z = false;
        int i9 = 0;
        while (true) {
            if (i9 >= list.size()) {
                break;
            }
            f0.c cVar = (f0.c) list.get(i9);
            if (cVar.a() == i8) {
                Class cls = cVar.f2541c;
                f0.p pVar = cVar.d;
                if (pVar != null) {
                    if (cls != null) {
                        try {
                            if (cls.getDeclaredConstructor(null).newInstance(null) == null) {
                                throw null;
                            }
                            throw new ClassCastException();
                        } catch (Exception e9) {
                            Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: ".concat(cls.getName()), e9);
                        }
                    }
                    zPerformAccessibilityAction = pVar.c(view);
                }
            } else {
                i9++;
            }
        }
        zPerformAccessibilityAction = false;
        if (!zPerformAccessibilityAction) {
            zPerformAccessibilityAction = this.f2288a.performAccessibilityAction(view, i8, bundle);
        }
        if (zPerformAccessibilityAction || i8 != R.id.accessibility_action_clickable_span || bundle == null) {
            return zPerformAccessibilityAction;
        }
        int i10 = bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1);
        SparseArray sparseArray = (SparseArray) view.getTag(R.id.tag_accessibility_clickable_spans);
        if (sparseArray != null && (weakReference = (WeakReference) sparseArray.get(i10)) != null && (clickableSpan = (ClickableSpan) weakReference.get()) != null) {
            CharSequence text = view.createAccessibilityNodeInfo().getText();
            ClickableSpan[] clickableSpanArr = text instanceof Spanned ? (ClickableSpan[]) ((Spanned) text).getSpans(0, text.length(), ClickableSpan.class) : null;
            int i11 = 0;
            while (true) {
                if (clickableSpanArr == null || i11 >= clickableSpanArr.length) {
                    break;
                }
                if (clickableSpan.equals(clickableSpanArr[i11])) {
                    clickableSpan.onClick(view);
                    z = true;
                    break;
                }
                i11++;
            }
        }
        return z;
    }

    public void h(View view, int i8) {
        this.f2288a.sendAccessibilityEvent(view, i8);
    }

    public void i(View view, AccessibilityEvent accessibilityEvent) {
        this.f2288a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public b(View.AccessibilityDelegate accessibilityDelegate) {
        this.f2288a = accessibilityDelegate;
        this.f2289b = new a(this);
    }
}
