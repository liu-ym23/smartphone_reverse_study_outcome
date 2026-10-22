package com.obric.aiagent.skill.ovirt.api;

import com.bytedance.common.wschannel.WsConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: IOVirtService.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: com.obric.aiagent.skill.ovirt.api.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IOVirtService.kt */
    public static final class C0438a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0438a f20940a = null;

        static {
            f20940a = new C0438a();
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, C0438a.class) == true) goto L9;
            return false;
        L9:
            C0438a r2 = (C0438a) ZeusTransformUtils.preCheckCast(r3, C0438a.class, "com.obric.aiagent.plugin");
            return true;
        }

        public int hashCode() {
            return 109891553;
        }

        public String toString() {
            return "Blocked";
        }

        private C0438a() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: IOVirtService.kt */
    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Throwable f20941a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f20941a, r6.f20941a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f20941a.hashCode();
        }

        public String toString() {
            return "Failure(error=" + this.f20941a + ')';
        }

        public b(Throwable r2) {
            o.e(r2, WsConstants.KEY_CONNECTION_ERROR);
            super(null);
            this.f20941a = r2;
        }

        public final Throwable a() {
            return this.f20941a;
        }
    }

    /* JADX INFO: compiled from: IOVirtService.kt */
    public static final class c<T> extends a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final T f20942a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (o.a(this.f20942a, r6.f20942a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            T r0 = this.f20942a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public String toString() {
            return "Success(value=" + this.f20942a + ')';
        }

        public c(T r2) {
            super(null);
            this.f20942a = r2;
        }

        public final T a() {
            return this.f20942a;
        }
    }

    /* JADX INFO: compiled from: IOVirtService.kt */
    public static final class d extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f20943a = null;

        static {
            f20943a = new d();
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, d.class) == true) goto L9;
            return false;
        L9:
            d r2 = (d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin");
            return true;
        }

        public int hashCode() {
            return 1994301762;
        }

        public String toString() {
            return "TimedOut";
        }

        private d() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: IOVirtService.kt */
    public static final class e extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f20944a = null;

        static {
            f20944a = new e();
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, e.class) == true) goto L9;
            return false;
        L9:
            e r2 = (e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.aiagent.plugin");
            return true;
        }

        public int hashCode() {
            return -672676923;
        }

        public String toString() {
            return "Unavailable";
        }

        private e() {
            super(null);
        }
    }

    public /* synthetic */ a(d.h.b.h r1) {
        this();
    }

    private a() {
    }
}
