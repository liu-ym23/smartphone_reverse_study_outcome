package com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: AppFunctionSkillSpellManager.kt */
/* JADX INFO: loaded from: classes2.dex */
interface ak {

    /* JADX INFO: compiled from: AppFunctionSkillSpellManager.kt */
    public static final class a implements ak {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f18226a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f18227b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f18228c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List<al> f18229d;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (this.f18226a == r6.f18226a) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f18227b, r6.f18227b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f18228c, r6.f18228c) == true) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(this.f18229d, r6.f18229d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.f18226a) * 31) + this.f18227b.hashCode()) * 31) + this.f18228c.hashCode()) * 31) + this.f18229d.hashCode();
        }

        public String toString() {
            return "Accepted(providerCode=" + this.f18226a + ", providerMessage=" + this.f18227b + ", outcome=" + this.f18228c + ", failedItems=" + this.f18229d + ')';
        }

        public a(int r3, String r4, String r5, List<al> r6) {
            List<al> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r4, "providerMessage");
            d.h.b.o.e(r5, "outcome");
            d.h.b.o.e(r7, "failedItems");
            this.f18226a = r3;
            this.f18227b = r4;
            this.f18228c = r5;
            this.f18229d = r7;
        }

        public final int a() {
            return this.f18226a;
        }

        public final String b() {
            return this.f18227b;
        }

        public final String c() {
            return this.f18228c;
        }

        public final List<al> d() {
            return this.f18229d;
        }
    }

    /* JADX INFO: compiled from: AppFunctionSkillSpellManager.kt */
    public static final class b implements ak {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f18230a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f18231b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (this.f18230a == r6.f18230a) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f18231b, r6.f18231b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Integer.hashCode(this.f18230a) * 31) + this.f18231b.hashCode();
        }

        public String toString() {
            return "TransportFailure(providerCode=" + this.f18230a + ", providerMessage=" + this.f18231b + ')';
        }

        public b(int r2, String r3) {
            d.h.b.o.e(r3, "providerMessage");
            this.f18230a = r2;
            this.f18231b = r3;
        }

        public final int a() {
            return this.f18230a;
        }

        public final String b() {
            return this.f18231b;
        }
    }
}
