package com.obric.oui.orecyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class g extends androidx.core.view.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f15701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f15702b;

    public static class a extends androidx.core.view.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g f15703a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map f15704b;

        public a(g r10) {
            this.f15704b = new WeakHashMap();
            this.f15703a = r10;
        }

        public androidx.core.view.a c(View r10) {
            return (androidx.core.view.a) this.f15704b.remove(r10);
        }

        public void d(View r10) {
            androidx.core.view.a r11 = ViewCompat.l(r10);
            if (r11 == null) goto L7;
            if (r11 == this) goto L8;
            this.f15704b.put(r10, r11);
            return;
        L8:
            return;
        }

        @Override // androidx.core.view.a
        public boolean dispatchPopulateAccessibilityEvent(View r10, AccessibilityEvent r11) {
            androidx.core.view.a r12 = (androidx.core.view.a) this.f15704b.get(r10);
            if (r12 == null) goto L7;
            return r12.dispatchPopulateAccessibilityEvent(r10, r11);
        L7:
            return super.dispatchPopulateAccessibilityEvent(r10, r11);
        }

        @Override // androidx.core.view.a
        public r.b getAccessibilityNodeProvider(View r10) {
            androidx.core.view.a r11 = (androidx.core.view.a) this.f15704b.get(r10);
            if (r11 == null) goto L7;
            return r11.getAccessibilityNodeProvider(r10);
        L7:
            return super.getAccessibilityNodeProvider(r10);
        }

        @Override // androidx.core.view.a
        public void onInitializeAccessibilityEvent(View r10, AccessibilityEvent r11) {
            androidx.core.view.a r12 = (androidx.core.view.a) this.f15704b.get(r10);
            if (r12 == null) goto L5;
            r12.onInitializeAccessibilityEvent(r10, r11);
            return;
        L5:
            super.onInitializeAccessibilityEvent(r10, r11);
        }

        @Override // androidx.core.view.a
        public void onInitializeAccessibilityNodeInfo(View r10, AccessibilityNodeInfoCompat r11) {
            if (this.f15703a.shouldIgnore() == false) goto L5;
        L10:
            super.onInitializeAccessibilityNodeInfo(r10, r11);
            return;
        L5:
            if (this.f15703a.f15701a.getLayoutManager() == null) goto L10;
            this.f15703a.f15701a.getLayoutManager().I0(r10, r11);
            androidx.core.view.a r12 = (androidx.core.view.a) this.f15704b.get(r10);
            if (r12 == null) goto L9;
            r12.onInitializeAccessibilityNodeInfo(r10, r11);
            return;
        L9:
            super.onInitializeAccessibilityNodeInfo(r10, r11);
        }

        @Override // androidx.core.view.a
        public void onPopulateAccessibilityEvent(View r10, AccessibilityEvent r11) {
            androidx.core.view.a r12 = (androidx.core.view.a) this.f15704b.get(r10);
            if (r12 == null) goto L5;
            r12.onPopulateAccessibilityEvent(r10, r11);
            return;
        L5:
            super.onPopulateAccessibilityEvent(r10, r11);
        }

        @Override // androidx.core.view.a
        public boolean onRequestSendAccessibilityEvent(ViewGroup r10, View r11, AccessibilityEvent r12) {
            androidx.core.view.a r13 = (androidx.core.view.a) this.f15704b.get(r10);
            if (r13 == null) goto L7;
            return r13.onRequestSendAccessibilityEvent(r10, r11, r12);
        L7:
            return super.onRequestSendAccessibilityEvent(r10, r11, r12);
        }

        @Override // androidx.core.view.a
        public boolean performAccessibilityAction(View r10, int r11, Bundle r12) {
            if (this.f15703a.shouldIgnore() == true) goto L17;
            if (this.f15703a.f15701a.getLayoutManager() == null) goto L17;
            androidx.core.view.a r13 = (androidx.core.view.a) this.f15704b.get(r10);
            if (r13 == null) goto L12;
            if (r13.performAccessibilityAction(r10, r11, r12) == false) goto L15;
            return true;
        L15:
            return this.f15703a.f15701a.getLayoutManager().b1(r10, r11, r12);
        L12:
            if (super.performAccessibilityAction(r10, r11, r12) == false) goto L15;
            return true;
        L17:
            return super.performAccessibilityAction(r10, r11, r12);
        }

        @Override // androidx.core.view.a
        public void sendAccessibilityEvent(View r10, int r11) {
            androidx.core.view.a r12 = (androidx.core.view.a) this.f15704b.get(r10);
            if (r12 == null) goto L5;
            r12.sendAccessibilityEvent(r10, r11);
            return;
        L5:
            super.sendAccessibilityEvent(r10, r11);
        }

        @Override // androidx.core.view.a
        public void sendAccessibilityEventUnchecked(View r10, AccessibilityEvent r11) {
            androidx.core.view.a r12 = (androidx.core.view.a) this.f15704b.get(r10);
            if (r12 == null) goto L5;
            r12.sendAccessibilityEventUnchecked(r10, r11);
            return;
        L5:
            super.sendAccessibilityEventUnchecked(r10, r11);
        }
    }

    public g(RecyclerView r10) {
        this.f15701a = r10;
        androidx.core.view.a r11 = getItemDelegate();
        if (r11 != null) goto L5;
    L7:
        this.f15702b = new a(this);
        return;
    L5:
        if ((r11 instanceof a) == false) goto L7;
        this.f15702b = (a) r11;
    }

    public androidx.core.view.a getItemDelegate() {
        return this.f15702b;
    }

    @Override // androidx.core.view.a
    public void onInitializeAccessibilityEvent(View r10, AccessibilityEvent r11) {
        super.onInitializeAccessibilityEvent(r10, r11);
        if ((r10 instanceof RecyclerView) == true) goto L5;
        return;
    L5:
        if (shouldIgnore() == true) goto L11;
        RecyclerView r12 = (RecyclerView) r10;
        if (r12.getLayoutManager() == null) goto L12;
        r12.getLayoutManager().onInitializeAccessibilityEvent(r11);
        return;
    L12:
        return;
    }

    @Override // androidx.core.view.a
    public void onInitializeAccessibilityNodeInfo(View r10, AccessibilityNodeInfoCompat r11) {
        super.onInitializeAccessibilityNodeInfo(r10, r11);
        if (shouldIgnore() == false) goto L5;
        return;
    L5:
        if (this.f15701a.getLayoutManager() == null) goto L9;
        this.f15701a.getLayoutManager().G0(r11);
        return;
    }

    @Override // androidx.core.view.a
    public boolean performAccessibilityAction(View r10, int r11, Bundle r12) {
        if (super.performAccessibilityAction(r10, r11, r12) == false) goto L7;
        return true;
    L7:
        if (shouldIgnore() == false) goto L9;
        return false;
    L9:
        if (this.f15701a.getLayoutManager() != null) goto L11;
        return false;
    L11:
        return this.f15701a.getLayoutManager().Z0(r11, r12);
    }

    public boolean shouldIgnore() {
        return this.f15701a.j0();
    }
}
