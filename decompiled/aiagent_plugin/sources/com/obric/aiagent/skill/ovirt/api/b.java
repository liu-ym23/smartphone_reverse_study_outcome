package com.obric.aiagent.skill.ovirt.api;

import com.bytedance.common.wschannel.WsConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: IOVirtService.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b<T> {

    /* JADX INFO: compiled from: IOVirtService.kt */
    public static final class a<T> extends b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final T f20965a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f20965a, r6.f20965a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            T r0 = this.f20965a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public String toString() {
            return "Acquired(value=" + this.f20965a + ')';
        }

        public a(T r2) {
            super(null);
            this.f20965a = r2;
        }

        public final T a() {
            return this.f20965a;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiagent.skill.ovirt.api.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IOVirtService.kt */
    public static final class C0439b extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.aiagent.skill.ovirt.api.b.b.c f20966a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f20967b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0439b.class) == true) goto L8;
            return false;
        L8:
            C0439b r6 = (C0439b) ZeusTransformUtils.preCheckCast(r5, C0439b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f20966a, r6.f20966a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f20967b, r6.f20967b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            com.obric.aiagent.skill.ovirt.api.b.b.c r0 = this.f20966a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + this.f20967b.hashCode();
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "Blocked(active=" + this.f20966a + ", reason=" + this.f20967b + ')';
        }

        public /* synthetic */ C0439b(com.obric.aiagent.skill.ovirt.api.b.b.c r1, String r2, int r3, d.h.b.h r4) {
            if ((r3 & 1) == 0) goto L5;
            r1 = null;
        L5:
            this(r1, r2);
        }

        public final String a() {
            return this.f20967b;
        }

        public C0439b(com.obric.aiagent.skill.ovirt.api.b.b.c r2, String r3) {
            o.e(r3, "reason");
            super(null);
            this.f20966a = r2;
            this.f20967b = r3;
        }
    }

    /* JADX INFO: compiled from: IOVirtService.kt */
    public static final class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Throwable f20968a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (o.a(this.f20968a, r6.f20968a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f20968a.hashCode();
        }

        public String toString() {
            return "Failure(error=" + this.f20968a + ')';
        }

        public c(Throwable r2) {
            o.e(r2, WsConstants.KEY_CONNECTION_ERROR);
            super(null);
            this.f20968a = r2;
        }

        public final Throwable a() {
            return this.f20968a;
        }
    }

    /* JADX INFO: compiled from: IOVirtService.kt */
    public static final class d extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f20969a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
            if (o.a(this.f20969a, r6.f20969a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f20969a.hashCode();
        }

        public String toString() {
            return "Unavailable(reason=" + this.f20969a + ')';
        }

        public d(String r2) {
            o.e(r2, "reason");
            super(null);
            this.f20969a = r2;
        }
    }

    public /* synthetic */ b(d.h.b.h r1) {
        this();
    }

    private b() {
    }
}
