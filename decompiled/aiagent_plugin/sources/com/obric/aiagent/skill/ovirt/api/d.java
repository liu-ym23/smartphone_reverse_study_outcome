package com.obric.aiagent.skill.ovirt.api;

import com.bytedance.common.wschannel.WsConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: IOVirtService.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d {

    /* JADX INFO: compiled from: IOVirtService.kt */
    public static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.aiagent.skill.ovirt.api.b.b.c f20988a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f20989b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f20988a, r6.f20988a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f20989b, r6.f20989b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            com.obric.aiagent.skill.ovirt.api.b.b.c r0 = this.f20988a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + this.f20989b.hashCode();
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "Blocked(active=" + this.f20988a + ", reason=" + this.f20989b + ')';
        }

        public /* synthetic */ a(com.obric.aiagent.skill.ovirt.api.b.b.c r1, String r2, int r3, d.h.b.h r4) {
            if ((r3 & 1) == 0) goto L5;
            r1 = null;
        L5:
            this(r1, r2);
        }

        public final com.obric.aiagent.skill.ovirt.api.b.b.c a() {
            return this.f20988a;
        }

        public final String b() {
            return this.f20989b;
        }

        public a(com.obric.aiagent.skill.ovirt.api.b.b.c r2, String r3) {
            o.e(r3, "reason");
            super(null);
            this.f20988a = r2;
            this.f20989b = r3;
        }
    }

    /* JADX INFO: compiled from: IOVirtService.kt */
    public static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Throwable f20990a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f20990a, r6.f20990a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f20990a.hashCode();
        }

        public String toString() {
            return "Failure(error=" + this.f20990a + ')';
        }

        public b(Throwable r2) {
            o.e(r2, WsConstants.KEY_CONNECTION_ERROR);
            super(null);
            this.f20990a = r2;
        }
    }

    /* JADX INFO: compiled from: IOVirtService.kt */
    public static final class c extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.aiagent.skill.ovirt.api.b.b f20991a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (o.a(this.f20991a, r6.f20991a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f20991a.hashCode();
        }

        public String toString() {
            return "Started(execution=" + this.f20991a + ')';
        }

        public c(com.obric.aiagent.skill.ovirt.api.b.b r3) {
            com.obric.aiagent.skill.ovirt.api.b.b r4 = (com.obric.aiagent.skill.ovirt.api.b.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.aiagent.skill.ovirt.api.b.b.class, "com.obric.aiagent.plugin");
            o.e(r4, "execution");
            super(null);
            this.f20991a = r4;
        }

        public final com.obric.aiagent.skill.ovirt.api.b.b a() {
            return this.f20991a;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiagent.skill.ovirt.api.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IOVirtService.kt */
    public static final class C0441d extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f20992a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0441d.class) == true) goto L8;
            return false;
        L8:
            C0441d r6 = (C0441d) ZeusTransformUtils.preCheckCast(r5, C0441d.class, "com.obric.aiagent.plugin");
            if (o.a(this.f20992a, r6.f20992a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f20992a.hashCode();
        }

        public String toString() {
            return "Unavailable(reason=" + this.f20992a + ')';
        }

        public C0441d(String r2) {
            o.e(r2, "reason");
            super(null);
            this.f20992a = r2;
        }
    }

    public /* synthetic */ d(d.h.b.h r1) {
        this();
    }

    private d() {
    }
}
