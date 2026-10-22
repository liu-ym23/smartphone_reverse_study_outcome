package androidx.core.view;

import E.c;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;
import z.C1332d;

/* renamed from: androidx.core.view.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0456a {
    private static final View.AccessibilityDelegate DEFAULT_DELEGATE = new View.AccessibilityDelegate();
    private final View.AccessibilityDelegate mBridge;
    private final View.AccessibilityDelegate mOriginalDelegate;

    /* renamed from: androidx.core.view.a$a, reason: collision with other inner class name */
    static final class C0121a extends View.AccessibilityDelegate {

        /* renamed from: a, reason: collision with root package name */
        final C0456a f9799a;

        C0121a(C0456a c0456a) {
            this.f9799a = c0456a;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f9799a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            E.d accessibilityNodeProvider = this.f9799a.getAccessibilityNodeProvider(view);
            if (accessibilityNodeProvider != null) {
                return (AccessibilityNodeProvider) accessibilityNodeProvider.e();
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f9799a.onInitializeAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            E.c cVarE0 = E.c.E0(accessibilityNodeInfo);
            cVarE0.v0(H.R(view));
            cVarE0.n0(H.O(view));
            cVarE0.s0(H.m(view));
            cVarE0.z0(H.E(view));
            this.f9799a.onInitializeAccessibilityNodeInfo(view, cVarE0);
            cVarE0.d(accessibilityNodeInfo.getText(), view);
            List<c.a> actionList = C0456a.getActionList(view);
            for (int i5 = 0; i5 < actionList.size(); i5++) {
                cVarE0.b(actionList.get(i5));
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f9799a.onPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f9799a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i5, Bundle bundle) {
            return this.f9799a.performAccessibilityAction(view, i5, bundle);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i5) {
            this.f9799a.sendAccessibilityEvent(view, i5);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f9799a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
        }
    }

    public C0456a() {
        this(DEFAULT_DELEGATE);
    }

    static List<c.a> getActionList(View view) {
        List<c.a> list = (List) view.getTag(C1332d.f23950H);
        return list == null ? Collections.EMPTY_LIST : list;
    }

    private boolean isSpanStillValid(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] clickableSpanArrO = E.c.o(view.createAccessibilityNodeInfo().getText());
            for (int i5 = 0; clickableSpanArrO != null && i5 < clickableSpanArrO.length; i5++) {
                if (clickableSpan.equals(clickableSpanArrO[i5])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean performClickableSpanAction(int i5, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(C1332d.f23951I);
        if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i5)) == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (!isSpanStillValid(clickableSpan, view)) {
            return false;
        }
        clickableSpan.onClick(view);
        return true;
    }

    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return this.mOriginalDelegate.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public E.d getAccessibilityNodeProvider(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider = this.mOriginalDelegate.getAccessibilityNodeProvider(view);
        if (accessibilityNodeProvider != null) {
            return new E.d(accessibilityNodeProvider);
        }
        return null;
    }

    View.AccessibilityDelegate getBridge() {
        return this.mBridge;
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(View view, E.c cVar) {
        this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, cVar.D0());
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.mOriginalDelegate.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean performAccessibilityAction(View view, int i5, Bundle bundle) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        List<c.a> actionList = getActionList(view);
        boolean zPerformAccessibilityAction = false;
        int i6 = 0;
        while (true) {
            if (i6 >= actionList.size()) {
                break;
            }
            c.a aVar = actionList.get(i6);
            if (aVar.b() == i5) {
                zPerformAccessibilityAction = aVar.d(view, bundle);
                break;
            }
            i6++;
        }
        if (!zPerformAccessibilityAction) {
            zPerformAccessibilityAction = this.mOriginalDelegate.performAccessibilityAction(view, i5, bundle);
        }
        return (zPerformAccessibilityAction || i5 != C1332d.f23958a || bundle == null) ? zPerformAccessibilityAction : performClickableSpanAction(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
    }

    public void sendAccessibilityEvent(View view, int i5) {
        this.mOriginalDelegate.sendAccessibilityEvent(view, i5);
    }

    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public C0456a(View.AccessibilityDelegate accessibilityDelegate) {
        this.mOriginalDelegate = accessibilityDelegate;
        this.mBridge = new C0121a(this);
    }
}
