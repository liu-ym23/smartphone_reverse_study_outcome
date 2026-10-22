package androidx.activity;

import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.i;
import androidx.lifecycle.m;
import androidx.lifecycle.p;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ArrayDeque<c> f131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Runnable f132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private androidx.core.util.a<Boolean> f133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private OnBackInvokedCallback f134d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private OnBackInvokedDispatcher f135e;
    private boolean f;

    private class LifecycleOnBackPressedCancellable implements androidx.activity.b, m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OnBackPressedDispatcher f136a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final i f137b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final c f138c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private androidx.activity.b f139d;

        LifecycleOnBackPressedCancellable(OnBackPressedDispatcher r1, i r2, c r3) {
            this.f136a = r1;
            this.f137b = r2;
            this.f138c = r3;
            r2.a(this);
        }

        @Override // androidx.lifecycle.m
        public void onStateChanged(p r3, i.a r4) {
            p r5 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
            if (r4 != i.a.ON_START) goto L6;
            this.f139d = this.f136a.b(this.f138c);
            return;
        L6:
            if (r4 != i.a.ON_STOP) goto L11;
            androidx.activity.b r2 = this.f139d;
            if (r2 == null) goto L15;
            r2.a();
            return;
        L15:
            return;
        L11:
            if (r4 != i.a.ON_DESTROY) goto L17;
            a();
            return;
        }

        @Override // androidx.activity.b
        public void a() {
            this.f137b.b(this);
            this.f138c.b(this);
            androidx.activity.b r0 = this.f139d;
            if (r0 == null) goto L6;
            r0.a();
            this.f139d = null;
            return;
        }
    }

    static class a {
        static void a(Object r2, int r3, Object r4) {
            ((OnBackInvokedDispatcher) ZeusTransformUtils.preCheckCast(r2, OnBackInvokedDispatcher.class, "com.obric.aiagent.plugin")).registerOnBackInvokedCallback(r3, (OnBackInvokedCallback) ZeusTransformUtils.preCheckCast(r4, OnBackInvokedCallback.class, "com.obric.aiagent.plugin"));
        }

        static void a(Object r2, Object r3) {
            ((OnBackInvokedDispatcher) ZeusTransformUtils.preCheckCast(r2, OnBackInvokedDispatcher.class, "com.obric.aiagent.plugin")).unregisterOnBackInvokedCallback((OnBackInvokedCallback) ZeusTransformUtils.preCheckCast(r3, OnBackInvokedCallback.class, "com.obric.aiagent.plugin"));
        }

        static OnBackInvokedCallback a(Runnable r2) {
            final Runnable r3 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin");
            Objects.requireNonNull(r3);
            return new $$Lambda$4ezOK7vdu_oWZDLTTMzgHr1uNF4(r3);
        }
    }

    private class b implements androidx.activity.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OnBackPressedDispatcher f140a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final c f141b;

        b(OnBackPressedDispatcher r1, c r2) {
            this.f140a = r1;
            this.f141b = r2;
        }

        @Override // androidx.activity.b
        public void a() {
            this.f140a.f131a.remove(this.f141b);
            this.f141b.b(this);
            if (androidx.core.os.a.a() == false) goto L6;
            this.f141b.a(null);
            this.f140a.a();
            return;
        }
    }

    public static /* synthetic */ void lambda$hDFt0VCWg11GiKwjXbcx7SwiYB4(OnBackPressedDispatcher r0, Boolean r1) {
        r0.a(r1);
    }

    public void a(OnBackInvokedDispatcher r3) {
        this.f135e = (OnBackInvokedDispatcher) ZeusTransformUtils.wrapperContextForParams(r3, OnBackInvokedDispatcher.class, "com.obric.aiagent.plugin");
        a();
    }

    void a() {
        boolean r0 = b();
        OnBackInvokedDispatcher r1 = this.f135e;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r0 == true) goto L7;
    L9:
        if (r0 == false) goto L11;
        return;
    L11:
        if (this.f == false) goto L17;
        a.a(r1, this.f134d);
        this.f = false;
        return;
    L17:
        return;
    L7:
        if (this.f == true) goto L9;
        a.a(r1, 0, this.f134d);
        this.f = true;
    }

    public OnBackPressedDispatcher() {
        this(null);
    }

    public OnBackPressedDispatcher(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        this.f131a = new ArrayDeque();
        this.f = false;
        this.f132b = r4;
        if (androidx.core.os.a.a() == false) goto L6;
        this.f133c = new $$Lambda$OnBackPressedDispatcher$hDFt0VCWg11GiKwjXbcx7SwiYB4(this);
        this.f134d = a.a(new $$Lambda$IaMU86yrik_UleCWJe4SlPMguT4(this));
        return;
    }

    private /* synthetic */ void a(Boolean r1) {
        if (androidx.core.os.a.a() == false) goto L6;
        a();
        return;
    }

    public void a(c r1) {
        b(r1);
    }

    androidx.activity.b b(c r3) {
        this.f131a.add(r3);
        b r0 = new b(this, r3);
        r3.a(r0);
        if (androidx.core.os.a.a() == false) goto L5;
        a();
        r3.a(this.f133c);
    L5:
        return r0;
    }

    public void a(p r3, c r4) {
        i r5 = ((p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin")).getLifecycle();
        if (r5.b() != i.b.f2054a) goto L5;
        return;
    L5:
        r4.a(new LifecycleOnBackPressedCancellable(this, r5, r4));
        if (androidx.core.os.a.a() == false) goto L9;
        a();
        r4.a(this.f133c);
        return;
    }

    public boolean b() {
        Iterator<c> r3 = this.f131a.descendingIterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (((c) ZeusTransformUtils.preCheckCast(r3.next(), c.class, "com.obric.aiagent.plugin")).a() == false) goto L4;
        return true;
    L9:
        return false;
    }

    public void c() {
        Iterator<c> r0 = this.f131a.descendingIterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        c r1 = (c) ZeusTransformUtils.preCheckCast(r0.next(), c.class, "com.obric.aiagent.plugin");
        if (r1.a() == false) goto L4;
        r1.c();
        return;
    L9:
        Runnable r4 = this.f132b;
        if (r4 == null) goto L16;
        r4.run();
        return;
    }
}
