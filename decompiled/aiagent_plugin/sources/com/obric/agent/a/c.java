package com.obric.agent.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: AlarmCardSyncContext.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface c {

    /* JADX INFO: compiled from: AlarmCardSyncContext.kt */
    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f14228a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f14228a, r6.f14228a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f14228a.hashCode();
        }

        public String toString() {
            return "Legacy(intentName=" + this.f14228a + ')';
        }

        public a(String r2) {
            o.e(r2, "intentName");
            this.f14228a = r2;
        }

        public final String a() {
            return this.f14228a;
        }
    }

    /* JADX INFO: compiled from: AlarmCardSyncContext.kt */
    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f14229a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f14230b;

        public static /* synthetic */ b a(b r0, String r1, String r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.f14229a;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.f14230b;
        L9:
            return r0.a(r1, r2);
        }

        public final b a(String r1, String r2) {
            o.e(r1, "blockId");
            o.e(r2, "renderData");
            return new b(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f14229a, r6.f14229a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f14230b, r6.f14230b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f14229a.hashCode() * 31) + this.f14230b.hashCode();
        }

        public String toString() {
            return "Widget(blockId=" + this.f14229a + ", renderData=" + this.f14230b + ')';
        }

        public b(String r2, String r3) {
            o.e(r2, "blockId");
            o.e(r3, "renderData");
            this.f14229a = r2;
            this.f14230b = r3;
        }

        public final String a() {
            return this.f14229a;
        }

        public final String b() {
            return this.f14230b;
        }
    }
}
