package androidx.core.view;

import android.os.Build;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.view.accessibility.AccessibilityClickableSpanCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AccessibilityDelegateCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final View.AccessibilityDelegate f1376a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final View.AccessibilityDelegate f1377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final View.AccessibilityDelegate f1378c;

    static final class AccessibilityDelegateAdapter extends View.AccessibilityDelegate {
        final AccessibilityDelegateCompat mCompat;

        AccessibilityDelegateAdapter(AccessibilityDelegateCompat r1) {
            this.mCompat = r1;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View r1, AccessibilityEvent r2) {
            return this.mCompat.b(r1, r2);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View r1, AccessibilityEvent r2) {
            this.mCompat.d(r1, r2);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View r4, AccessibilityNodeInfo r5) {
            androidx.core.view.accessibility.b r0 = androidx.core.view.accessibility.b.a(r5);
            r0.n(ViewCompat.L(r4));
            r0.p(ViewCompat.N(r4));
            r0.i(ViewCompat.M(r4));
            r0.f(ViewCompat.h(r4));
            this.mCompat.a(r4, r0);
            r0.a(r5.getText(), r4);
            List<androidx.core.view.accessibility.b.a> r3 = AccessibilityDelegateCompat.b(r4);
            int r6 = 0;
        L4:
            if (r6 >= r3.size()) goto L6;
            r0.a((androidx.core.view.accessibility.b.a) ZeusTransformUtils.preCheckCast(r3.get(r6), androidx.core.view.accessibility.b.a.class, "com.obric.aiagent.plugin"));
            r6 = r6 + 1;
            goto L4
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View r1, AccessibilityEvent r2) {
            this.mCompat.c(r1, r2);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup r1, View r2, AccessibilityEvent r3) {
            return this.mCompat.a(r1, r2, r3);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View r1, int r2) {
            this.mCompat.a(r1, r2);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View r1, AccessibilityEvent r2) {
            this.mCompat.a(r1, r2);
        }

        @Override // android.view.View.AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View r2) {
            AccessibilityNodeProviderCompat r1 = this.mCompat.a(r2);
            if (r1 != null) goto L7;
            return null;
        L7:
            return (AccessibilityNodeProvider) ZeusTransformUtils.preCheckCast(r1.a(), AccessibilityNodeProvider.class, "com.obric.aiagent.plugin");
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View r1, int r2, Bundle r3) {
            return this.mCompat.a(r1, r2, r3);
        }
    }

    static class a {
        static AccessibilityNodeProvider a(View.AccessibilityDelegate r0, View r1) {
            return r0.getAccessibilityNodeProvider(r1);
        }

        static boolean a(View.AccessibilityDelegate r0, View r1, int r2, Bundle r3) {
            return r0.performAccessibilityAction(r1, r2, r3);
        }
    }

    static {
        f1376a = new View.AccessibilityDelegate();
    }

    public AccessibilityDelegateCompat() {
        this(f1376a);
    }

    public AccessibilityDelegateCompat(View.AccessibilityDelegate r1) {
        this.f1377b = r1;
        this.f1378c = new AccessibilityDelegateAdapter(this);
    }

    View.AccessibilityDelegate a() {
        return this.f1378c;
    }

    public void a(View r1, int r2) {
        this.f1377b.sendAccessibilityEvent(r1, r2);
    }

    public void a(View r1, AccessibilityEvent r2) {
        this.f1377b.sendAccessibilityEventUnchecked(r1, r2);
    }

    public boolean b(View r1, AccessibilityEvent r2) {
        return this.f1377b.dispatchPopulateAccessibilityEvent(r1, r2);
    }

    public void c(View r1, AccessibilityEvent r2) {
        this.f1377b.onPopulateAccessibilityEvent(r1, r2);
    }

    public void d(View r1, AccessibilityEvent r2) {
        this.f1377b.onInitializeAccessibilityEvent(r1, r2);
    }

    public void a(View r1, androidx.core.view.accessibility.b r2) {
        this.f1377b.onInitializeAccessibilityNodeInfo(r1, r2.a());
    }

    public boolean a(ViewGroup r1, View r2, AccessibilityEvent r3) {
        return this.f1377b.onRequestSendAccessibilityEvent(r1, r2, r3);
    }

    public AccessibilityNodeProviderCompat a(View r3) {
        if (Build.VERSION.SDK_INT < 16) goto L8;
        AccessibilityNodeProvider r2 = a.a(this.f1377b, r3);
        if (r2 != null) goto L7;
        return null;
    L7:
        return new AccessibilityNodeProviderCompat(r2);
    L8:
        return null;
    }

    public boolean a(View r7, int r8, Bundle r9) {
        List<androidx.core.view.accessibility.b.a> r0 = b(r7);
        boolean r1 = false;
        int r2 = 0;
    L4:
        if (r2 >= r0.size()) goto L9;
        androidx.core.view.accessibility.b.a r3 = (androidx.core.view.accessibility.b.a) ZeusTransformUtils.preCheckCast(r0.get(r2), androidx.core.view.accessibility.b.a.class, "com.obric.aiagent.plugin");
        if (r3.a() == r8) goto L7;
        r2 = r2 + 1;
        goto L4
    L7:
        r1 = r3.a(r7, r9);
    L9:
        if (r1 == false) goto L11;
    L13:
        if (r1 == false) goto L15;
        return r1;
    L15:
        if (r8 != ZeusTransformUtils.mapRes(R.id.accessibility_action_clickable_span, DbHelper.COL_ID, "accessibility_action_clickable_span")) goto L22;
        if (r9 != null) goto L18;
        return r1;
    L18:
        return a(r9.getInt(AccessibilityClickableSpanCompat.SPAN_ID, -1), r7);
    L22:
        return r1;
    L11:
        if (Build.VERSION.SDK_INT < 16) goto L13;
        r1 = a.a(this.f1377b, r7, r8, r9);
        goto L13
    }

    private boolean a(int r4, View r5) {
        SparseArray r0 = (SparseArray) ZeusTransformUtils.preCheckCast(r5.getTag(ZeusTransformUtils.mapRes(R.id.tag_accessibility_clickable_spans, DbHelper.COL_ID, "tag_accessibility_clickable_spans")), SparseArray.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L10;
        WeakReference r6 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.get(r4), WeakReference.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L12;
        ClickableSpan r7 = (ClickableSpan) ZeusTransformUtils.preCheckCast(r6.get(), ClickableSpan.class, "com.obric.aiagent.plugin");
        if (a(r7, r5) == false) goto L13;
        r7.onClick(r5);
        return true;
    L13:
        return false;
    L12:
        return false;
    L10:
        return false;
    }

    private boolean a(ClickableSpan r3, View r4) {
        if (r3 == null) goto L13;
        ClickableSpan[] r5 = androidx.core.view.accessibility.b.d(r4.createAccessibilityNodeInfo().getText());
        int r0 = 0;
    L5:
        if (r5 == null) goto L13;
        if (r0 >= r5.length) goto L13;
        if (r3.equals(r5[r0]) == true) goto L10;
        r0 = r0 + 1;
        goto L5
    L10:
        return true;
    L13:
        return false;
    }

    static List<androidx.core.view.accessibility.b.a> b(View r3) {
        List<androidx.core.view.accessibility.b.a> r4 = (List) ZeusTransformUtils.preCheckCast(r3.getTag(ZeusTransformUtils.mapRes(R.id.tag_accessibility_actions, DbHelper.COL_ID, "tag_accessibility_actions")), List.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L5;
        return r4;
    L5:
        return Collections.emptyList();
    }
}
