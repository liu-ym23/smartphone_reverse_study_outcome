package com.obric.autogui.session;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ClientRiskyOperationState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f30740a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicReference<C0834b> f30741b;

    /* JADX INFO: compiled from: ClientRiskyOperationState.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.session.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ClientRiskyOperationState.kt */
    public static final class C0834b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f30742a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f30743b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0834b.class) == true) goto L8;
            return false;
        L8:
            C0834b r6 = (C0834b) ZeusTransformUtils.preCheckCast(r5, C0834b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f30742a, r6.f30742a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f30743b, r6.f30743b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = this.f30742a.hashCode() * 31;
            String r1 = this.f30743b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "Snapshot(operation=" + this.f30742a + ", computerControlApplyAppName=" + this.f30743b + ')';
        }

        public C0834b(String r2, String r3) {
            o.e(r2, "operation");
            this.f30742a = r2;
            this.f30743b = r3;
        }

        public final String a() {
            return this.f30742a;
        }

        public final String b() {
            return this.f30743b;
        }
    }

    static {
        f30740a = new a(null);
    }

    public b() {
        this.f30741b = new AtomicReference(null);
    }

    public final C0834b a() {
        return (C0834b) ZeusTransformUtils.preCheckCast(this.f30741b.get(), C0834b.class, "com.obric.aiagent.plugin");
    }

    public final String a(String r2, String r3) {
        o.e(r2, "operation");
        C0834b r1 = (C0834b) ZeusTransformUtils.preCheckCast(this.f30741b.getAndSet(new C0834b(r2, r3)), C0834b.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.a();
    }

    public final boolean a(String r4) {
        o.e(r4, "operation");
    L3:
        C0834b r0 = (C0834b) ZeusTransformUtils.preCheckCast(this.f30741b.get(), C0834b.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        if (o.a(r0.a(), r4) == false) goto L8;
        if (this.f30741b.compareAndSet(r0, null) == false) goto L3;
        return true;
    L8:
        return false;
    L5:
        return false;
    }
}
