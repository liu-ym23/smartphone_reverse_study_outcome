package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: RecyclerViewAccessibilityDelegate.java */
/* JADX INFO: loaded from: classes.dex */
public class w extends AccessibilityDelegateCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final RecyclerView f2588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f2589b;

    /* JADX INFO: compiled from: RecyclerViewAccessibilityDelegate.java */
    public static class a extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final w f2590a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Map<View, AccessibilityDelegateCompat> f2591b;

        public a(w r2) {
            this.f2591b = new WeakHashMap();
            this.f2590a = r2;
        }

        void c(View r2) {
            AccessibilityDelegateCompat r0 = ViewCompat.c(r2);
            if (r0 == null) goto L7;
            if (r0 == this) goto L8;
            this.f2591b.put(r2, r0);
            return;
        L8:
            return;
        }

        AccessibilityDelegateCompat d(View r2) {
            return (AccessibilityDelegateCompat) ZeusTransformUtils.preCheckCast(this.f2591b.remove(r2), AccessibilityDelegateCompat.class, "com.obric.aiagent.plugin");
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void a(View r4, androidx.core.view.accessibility.b r5) {
            if (this.f2590a.b() == false) goto L5;
        L10:
            super.a(r4, r5);
            return;
        L5:
            if (this.f2590a.f2588a.getLayoutManager() == null) goto L10;
            this.f2590a.f2588a.getLayoutManager().a(r4, r5);
            AccessibilityDelegateCompat r0 = (AccessibilityDelegateCompat) ZeusTransformUtils.preCheckCast(this.f2591b.get(r4), AccessibilityDelegateCompat.class, "com.obric.aiagent.plugin");
            if (r0 == null) goto L9;
            r0.a(r4, r5);
            return;
        L9:
            super.a(r4, r5);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean a(View r4, int r5, Bundle r6) {
            if (this.f2590a.b() == true) goto L17;
            if (this.f2590a.f2588a.getLayoutManager() == null) goto L17;
            AccessibilityDelegateCompat r0 = (AccessibilityDelegateCompat) ZeusTransformUtils.preCheckCast(this.f2591b.get(r4), AccessibilityDelegateCompat.class, "com.obric.aiagent.plugin");
            if (r0 == null) goto L12;
            if (r0.a(r4, r5, r6) == false) goto L15;
            return true;
        L15:
            return this.f2590a.f2588a.getLayoutManager().a(r4, r5, r6);
        L12:
            if (super.a(r4, r5, r6) == false) goto L15;
            return true;
        L17:
            return super.a(r4, r5, r6);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void a(View r4, int r5) {
            AccessibilityDelegateCompat r0 = (AccessibilityDelegateCompat) ZeusTransformUtils.preCheckCast(this.f2591b.get(r4), AccessibilityDelegateCompat.class, "com.obric.aiagent.plugin");
            if (r0 == null) goto L5;
            r0.a(r4, r5);
            return;
        L5:
            super.a(r4, r5);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void a(View r4, AccessibilityEvent r5) {
            AccessibilityDelegateCompat r0 = (AccessibilityDelegateCompat) ZeusTransformUtils.preCheckCast(this.f2591b.get(r4), AccessibilityDelegateCompat.class, "com.obric.aiagent.plugin");
            if (r0 == null) goto L5;
            r0.a(r4, r5);
            return;
        L5:
            super.a(r4, r5);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean b(View r4, AccessibilityEvent r5) {
            AccessibilityDelegateCompat r0 = (AccessibilityDelegateCompat) ZeusTransformUtils.preCheckCast(this.f2591b.get(r4), AccessibilityDelegateCompat.class, "com.obric.aiagent.plugin");
            if (r0 == null) goto L7;
            return r0.b(r4, r5);
        L7:
            return super.b(r4, r5);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void c(View r4, AccessibilityEvent r5) {
            AccessibilityDelegateCompat r0 = (AccessibilityDelegateCompat) ZeusTransformUtils.preCheckCast(this.f2591b.get(r4), AccessibilityDelegateCompat.class, "com.obric.aiagent.plugin");
            if (r0 == null) goto L5;
            r0.c(r4, r5);
            return;
        L5:
            super.c(r4, r5);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void d(View r4, AccessibilityEvent r5) {
            AccessibilityDelegateCompat r0 = (AccessibilityDelegateCompat) ZeusTransformUtils.preCheckCast(this.f2591b.get(r4), AccessibilityDelegateCompat.class, "com.obric.aiagent.plugin");
            if (r0 == null) goto L5;
            r0.d(r4, r5);
            return;
        L5:
            super.d(r4, r5);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean a(ViewGroup r4, View r5, AccessibilityEvent r6) {
            AccessibilityDelegateCompat r0 = (AccessibilityDelegateCompat) ZeusTransformUtils.preCheckCast(this.f2591b.get(r4), AccessibilityDelegateCompat.class, "com.obric.aiagent.plugin");
            if (r0 == null) goto L7;
            return r0.a(r4, r5, r6);
        L7:
            return super.a(r4, r5, r6);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public AccessibilityNodeProviderCompat a(View r4) {
            AccessibilityDelegateCompat r0 = (AccessibilityDelegateCompat) ZeusTransformUtils.preCheckCast(this.f2591b.get(r4), AccessibilityDelegateCompat.class, "com.obric.aiagent.plugin");
            if (r0 == null) goto L7;
            return r0.a(r4);
        L7:
            return super.a(r4);
        }
    }

    public w(RecyclerView r3) {
        this.f2588a = r3;
        AccessibilityDelegateCompat r4 = c();
        if (r4 != null) goto L5;
    L7:
        this.f2589b = new a(this);
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, a.class) == false) goto L7;
        this.f2589b = (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.aiagent.plugin");
    }

    boolean b() {
        return this.f2588a.hasPendingAdapterUpdates();
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public boolean a(View r1, int r2, Bundle r3) {
        if (super.a(r1, r2, r3) == false) goto L7;
        return true;
    L7:
        if (b() == false) goto L9;
        return false;
    L9:
        if (this.f2588a.getLayoutManager() != null) goto L11;
        return false;
    L11:
        return this.f2588a.getLayoutManager().a(r2, r3);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void a(View r1, androidx.core.view.accessibility.b r2) {
        super.a(r1, r2);
        if (b() == false) goto L5;
        return;
    L5:
        if (this.f2588a.getLayoutManager() == null) goto L9;
        this.f2588a.getLayoutManager().a(r2);
        return;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void d(View r2, AccessibilityEvent r3) {
        super.d(r2, r3);
        if (ZeusTransformUtils.instanceOf(r2, RecyclerView.class) == true) goto L5;
        return;
    L5:
        if (b() == true) goto L11;
        RecyclerView r1 = (RecyclerView) ZeusTransformUtils.preCheckCast(r2, RecyclerView.class, "com.obric.aiagent.plugin");
        if (r1.getLayoutManager() == null) goto L12;
        r1.getLayoutManager().a(r3);
        return;
    L12:
        return;
    }

    public AccessibilityDelegateCompat c() {
        return this.f2589b;
    }
}
