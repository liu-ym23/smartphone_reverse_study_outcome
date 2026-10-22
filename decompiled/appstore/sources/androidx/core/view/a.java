package androidx.core.view;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.R$id;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final View.AccessibilityDelegate DEFAULT_DELEGATE = null;
    private final View.AccessibilityDelegate mBridge;
    private final View.AccessibilityDelegate mOriginalDelegate;

    /* JADX INFO: renamed from: androidx.core.view.a$a, reason: collision with other inner class name */
    public static final class C0020a extends View.AccessibilityDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f2733a;

        public C0020a(a r10) {
            this.f2733a = r10;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View r10, AccessibilityEvent r11) {
            return this.f2733a.dispatchPopulateAccessibilityEvent(r10, r11);
        }

        @Override // android.view.View.AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View r10) {
            r.b r11 = this.f2733a.getAccessibilityNodeProvider(r10);
            if (r11 != null) goto L7;
            return null;
        L7:
            return (AccessibilityNodeProvider) r11.e();
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View r10, AccessibilityEvent r11) {
            this.f2733a.onInitializeAccessibilityEvent(r10, r11);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View r10, AccessibilityNodeInfo r11) {
            AccessibilityNodeInfoCompat r12 = AccessibilityNodeInfoCompat.B0(r11);
            r12.q0(ViewCompat.W(r10));
            r12.f0(ViewCompat.R(r10));
            r12.l0(ViewCompat.o(r10));
            r12.w0(ViewCompat.I(r10));
            this.f2733a.onInitializeAccessibilityNodeInfo(r10, r12);
            r12.e(r11.getText(), r10);
            List<AccessibilityNodeInfoCompat.a> r13 = a.getActionList(r10);
            int r14 = 0;
        L4:
            if (r14 >= r13.size()) goto L6;
            r12.b(r13.get(r14));
            r14 = r14 + 1;
            goto L4
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View r10, AccessibilityEvent r11) {
            this.f2733a.onPopulateAccessibilityEvent(r10, r11);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup r10, View r11, AccessibilityEvent r12) {
            return this.f2733a.onRequestSendAccessibilityEvent(r10, r11, r12);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View r10, int r11, Bundle r12) {
            return this.f2733a.performAccessibilityAction(r10, r11, r12);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View r10, int r11) {
            this.f2733a.sendAccessibilityEvent(r10, r11);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View r10, AccessibilityEvent r11) {
            this.f2733a.sendAccessibilityEventUnchecked(r10, r11);
        }
    }

    public static class b {
        @DoNotInline
        public static AccessibilityNodeProvider a(View.AccessibilityDelegate r10, View r11) {
            return r10.getAccessibilityNodeProvider(r11);
        }

        @DoNotInline
        public static boolean b(View.AccessibilityDelegate r10, View r11, int r12, Bundle r13) {
            return r10.performAccessibilityAction(r11, r12, r13);
        }
    }

    static {
        DEFAULT_DELEGATE = new View.AccessibilityDelegate();
    }

    public a() {
        this(DEFAULT_DELEGATE);
    }

    public static List<AccessibilityNodeInfoCompat.a> getActionList(View r10) {
        List<AccessibilityNodeInfoCompat.a> r11 = (List) r10.getTag(R$id.tag_accessibility_actions);
        if (r11 == null) goto L5;
        return r11;
    L5:
        return Collections.emptyList();
    }

    public final boolean a(ClickableSpan r10, View r11) {
        if (r10 == null) goto L13;
        ClickableSpan[] r12 = AccessibilityNodeInfoCompat.n(r11.createAccessibilityNodeInfo().getText());
        int r13 = 0;
    L5:
        if (r12 == null) goto L13;
        if (r13 >= r12.length) goto L13;
        if (r10.equals(r12[r13]) == true) goto L10;
        r13 = r13 + 1;
        goto L5
    L10:
        return true;
    L13:
        return false;
    }

    public final boolean b(int r10, View r11) {
        SparseArray r12 = (SparseArray) r11.getTag(R$id.tag_accessibility_clickable_spans);
        if (r12 == null) goto L10;
        WeakReference r13 = (WeakReference) r12.get(r10);
        if (r13 == null) goto L12;
        ClickableSpan r14 = (ClickableSpan) r13.get();
        if (a(r14, r11) == false) goto L13;
        r14.onClick(r11);
        return true;
    L13:
        return false;
    L12:
        return false;
    L10:
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(@NonNull View r10, @NonNull AccessibilityEvent r11) {
        return this.mOriginalDelegate.dispatchPopulateAccessibilityEvent(r10, r11);
    }

    @Nullable
    public r.b getAccessibilityNodeProvider(@NonNull View r10) {
        AccessibilityNodeProvider r11 = b.a(this.mOriginalDelegate, r10);
        if (r11 != null) goto L5;
        return null;
    L5:
        return new r.b(r11);
    }

    public View.AccessibilityDelegate getBridge() {
        return this.mBridge;
    }

    public void onInitializeAccessibilityEvent(@NonNull View r10, @NonNull AccessibilityEvent r11) {
        this.mOriginalDelegate.onInitializeAccessibilityEvent(r10, r11);
    }

    public void onInitializeAccessibilityNodeInfo(View r10, AccessibilityNodeInfoCompat r11) {
        this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(r10, r11.A0());
    }

    public void onPopulateAccessibilityEvent(@NonNull View r10, @NonNull AccessibilityEvent r11) {
        this.mOriginalDelegate.onPopulateAccessibilityEvent(r10, r11);
    }

    public boolean onRequestSendAccessibilityEvent(@NonNull ViewGroup r10, @NonNull View r11, @NonNull AccessibilityEvent r12) {
        return this.mOriginalDelegate.onRequestSendAccessibilityEvent(r10, r11, r12);
    }

    public boolean performAccessibilityAction(@NonNull View r10, int r11, @Nullable Bundle r12) {
        List<AccessibilityNodeInfoCompat.a> r13 = getActionList(r10);
        boolean r14 = false;
        int r15 = 0;
    L4:
        if (r15 >= r13.size()) goto L9;
        AccessibilityNodeInfoCompat.a r16 = r13.get(r15);
        if (r16.b() == r11) goto L7;
        r15 = r15 + 1;
        goto L4
    L7:
        r14 = r16.d(r10, r12);
    L9:
        if (r14 == true) goto L11;
        r14 = b.b(this.mOriginalDelegate, r10, r11, r12);
    L11:
        if (r14 == false) goto L13;
        return r14;
    L13:
        if (r11 != R$id.accessibility_action_clickable_span) goto L20;
        if (r12 != null) goto L16;
        return r14;
    L16:
        return b(r12.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), r10);
    L20:
        return r14;
    }

    public void sendAccessibilityEvent(@NonNull View r10, int r11) {
        this.mOriginalDelegate.sendAccessibilityEvent(r10, r11);
    }

    public void sendAccessibilityEventUnchecked(@NonNull View r10, @NonNull AccessibilityEvent r11) {
        this.mOriginalDelegate.sendAccessibilityEventUnchecked(r10, r11);
    }

    public a(View.AccessibilityDelegate r10) {
        this.mOriginalDelegate = r10;
        this.mBridge = new C0020a(this);
    }
}
