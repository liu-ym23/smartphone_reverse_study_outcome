package com.obric.aiagent.skill.ovirt.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: IOVirtService.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class i {

    /* JADX INFO: compiled from: IOVirtService.kt */
    public static final class a extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f21008a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (this.f21008a == r6.f21008a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f21008a);
        }

        public String toString() {
            return "Closed(cleanupSucceeded=" + this.f21008a + ')';
        }

        public a(boolean r2) {
            super(null);
            this.f21008a = r2;
        }

        public final boolean a() {
            return this.f21008a;
        }
    }

    /* JADX INFO: compiled from: IOVirtService.kt */
    public static final class b extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f21009a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f21009a, r6.f21009a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f21009a.hashCode();
        }

        public String toString() {
            return "Skipped(reason=" + this.f21009a + ')';
        }

        public b(String r2) {
            o.e(r2, "reason");
            super(null);
            this.f21009a = r2;
        }
    }

    public /* synthetic */ i(d.h.b.h r1) {
        this();
    }

    private i() {
    }
}
