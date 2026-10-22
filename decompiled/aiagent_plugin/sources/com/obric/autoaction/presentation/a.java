package com.obric.autoaction.presentation;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: AIAgentState.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.obric.autoaction.presentation.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AIAgentState.kt */
    public static final class C0575a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f24805a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0575a.class) == true) goto L8;
            return false;
        L8:
            C0575a r6 = (C0575a) ZeusTransformUtils.preCheckCast(r5, C0575a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f24805a, r6.f24805a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f24805a.hashCode();
        }

        public String toString() {
            return "AddTaskFail(message=" + this.f24805a + ')';
        }

        public C0575a(String r2) {
            o.e(r2, "message");
            super(null);
            this.f24805a = r2;
        }
    }

    /* JADX INFO: compiled from: AIAgentState.kt */
    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f24806a = null;

        static {
            f24806a = new b();
        }

        private b() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: AIAgentState.kt */
    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f24807a = null;

        static {
            f24807a = new c();
        }

        private c() {
            super(null);
        }
    }

    public /* synthetic */ a(d.h.b.h r1) {
        this();
    }

    private a() {
    }
}
