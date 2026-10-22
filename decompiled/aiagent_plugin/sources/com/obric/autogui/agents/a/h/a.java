package com.obric.autogui.agents.a.h;

import com.obric.autogui.agents.a.f.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ActionEffectActionResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface a {

    /* JADX INFO: renamed from: com.obric.autogui.agents.a.h.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActionEffectActionResolver.kt */
    public static final class C0666a implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final h f26497a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0666a.class) == true) goto L8;
            return false;
        L8:
            C0666a r6 = (C0666a) ZeusTransformUtils.preCheckCast(r5, C0666a.class, "com.obric.aiagent.plugin");
            if (this.f26497a == r6.f26497a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f26497a.hashCode();
        }

        public String toString() {
            return "ExecutionResult(action=" + this.f26497a + ')';
        }

        public C0666a(h r2) {
            o.e(r2, "action");
            this.f26497a = r2;
        }

        public final h a() {
            return this.f26497a;
        }
    }

    /* JADX INFO: compiled from: ActionEffectActionResolver.kt */
    public static final class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.autogui.agents.a.f.a f26498a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (this.f26498a == r6.f26498a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f26498a.hashCode();
        }

        public String toString() {
            return "PageDetection(action=" + this.f26498a + ')';
        }

        public b(com.obric.autogui.agents.a.f.a r2) {
            o.e(r2, "action");
            this.f26498a = r2;
        }

        public final com.obric.autogui.agents.a.f.a a() {
            return this.f26498a;
        }
    }

    /* JADX INFO: compiled from: ActionEffectActionResolver.kt */
    public static final class c implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f26499a = null;

        static {
            f26499a = new c();
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, c.class) == true) goto L9;
            return false;
        L9:
            c r2 = (c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.aiagent.plugin");
            return true;
        }

        public int hashCode() {
            return -1506814399;
        }

        public String toString() {
            return "Unsupported";
        }

        private c() {
        }
    }
}
