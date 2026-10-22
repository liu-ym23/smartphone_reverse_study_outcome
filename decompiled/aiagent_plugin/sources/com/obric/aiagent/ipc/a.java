package com.obric.aiagent.ipc;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: AgentIPCClient.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0388a f18601a = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final a f18602d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f18603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f18604c;

    /* JADX INFO: renamed from: com.obric.aiagent.ipc.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AgentIPCClient.kt */
    public static final class C0388a {
        public /* synthetic */ C0388a(h r1) {
            this();
        }

        private C0388a() {
        }

        public final a a() {
            return a.b();
        }
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (o.a(this.f18603b, r6.f18603b) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f18604c, r6.f18604c) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f18603b.hashCode() * 31) + this.f18604c.hashCode();
    }

    public String toString() {
        return "AgentIPCClient(name=" + this.f18603b + ", pkg=" + this.f18604c + ')';
    }

    public a(String r2, String r3) {
        o.e(r2, "name");
        o.e(r3, "pkg");
        this.f18603b = r2;
        this.f18604c = r3;
    }

    public static final /* synthetic */ a b() {
        return f18602d;
    }

    public final String a() {
        return this.f18604c;
    }

    static {
        f18601a = new C0388a(null);
        f18602d = new a("nova_ai", "com.larus.nova");
    }
}
