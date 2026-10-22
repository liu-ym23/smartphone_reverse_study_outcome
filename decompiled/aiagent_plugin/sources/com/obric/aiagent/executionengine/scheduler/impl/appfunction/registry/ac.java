package com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppFunctionSkillSourceReader.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface ac {

    /* JADX INFO: compiled from: AppFunctionSkillSourceReader.kt */
    public static final class a implements ac {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f18207a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f18207a, r6.f18207a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f18207a.hashCode();
        }

        public String toString() {
            return "DeclaredMarkdown(value=" + this.f18207a + ')';
        }

        public a(String r2) {
            d.h.b.o.e(r2, "value");
            this.f18207a = r2;
        }

        public final String a() {
            return this.f18207a;
        }
    }

    /* JADX INFO: compiled from: AppFunctionSkillSourceReader.kt */
    public static final class b implements ac {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f18208a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f18208a, r6.f18208a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f18208a.hashCode();
        }

        public String toString() {
            return "Metadata(value=" + this.f18208a + ')';
        }

        public b(c r2) {
            d.h.b.o.e(r2, "value");
            this.f18208a = r2;
        }

        public final c a() {
            return this.f18208a;
        }
    }
}
