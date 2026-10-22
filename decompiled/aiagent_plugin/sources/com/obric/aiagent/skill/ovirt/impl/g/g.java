package com.obric.aiagent.skill.ovirt.impl.g;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ShellOutputSanitiser.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface g {

    /* JADX INFO: compiled from: ShellOutputSanitiser.kt */
    public static final class a implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f21417a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f21417a, r6.f21417a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f21417a.hashCode();
        }

        public String toString() {
            return "Append(delta=" + this.f21417a + ')';
        }

        public a(String r2) {
            o.e(r2, "delta");
            this.f21417a = r2;
        }

        public final String a() {
            return this.f21417a;
        }
    }

    /* JADX INFO: compiled from: ShellOutputSanitiser.kt */
    public static final class b implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f21418a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f21418a, r6.f21418a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f21418a.hashCode();
        }

        public String toString() {
            return "Replace(snapshot=" + this.f21418a + ')';
        }

        public b(String r2) {
            o.e(r2, "snapshot");
            this.f21418a = r2;
        }

        public final String a() {
            return this.f21418a;
        }
    }
}
