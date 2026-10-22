package com.obric.autogui.agents.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ActionEffectLog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0657a f26155a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f26156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f26157c;

    /* JADX INFO: renamed from: com.obric.autogui.agents.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActionEffectLog.kt */
    public static final class C0657a {
        public /* synthetic */ C0657a(h r1) {
            this();
        }

        private C0657a() {
        }

        public final a a(com.obric.autogui.agents.a.a.a r2) {
            o.e(r2, "attempt");
            return new a(r2.b().a(), r2.a());
        }
    }

    static {
        f26155a = new C0657a(null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (o.a(this.f26156b, r6.f26156b) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f26157c, r6.f26157c) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f26156b.hashCode() * 31) + this.f26157c.hashCode();
    }

    public String toString() {
        return "ActionEffectLogContext(action=" + this.f26156b + ", attemptId=" + this.f26157c + ')';
    }

    public a(String r2, String r3) {
        o.e(r2, "action");
        o.e(r3, "attemptId");
        this.f26156b = r2;
        this.f26157c = r3;
    }

    public final String a() {
        return this.f26156b;
    }

    public final String b() {
        return this.f26157c;
    }
}
