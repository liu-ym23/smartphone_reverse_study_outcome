package com.obric.aiagent.executionengine.scheduler.impl.appfunction.dsl;

import com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.m;
import com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.x;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: AppFunctionNodeResolver.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f18183a = null;

    /* JADX INFO: compiled from: AppFunctionNodeResolver.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f18184a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f18185b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f18184a, r6.f18184a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f18185b, r6.f18185b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f18184a.hashCode() * 31) + this.f18185b.hashCode();
        }

        public String toString() {
            return "ResolvedFunction(packageName=" + this.f18184a + ", functionId=" + this.f18185b + ')';
        }

        public a(String r2, String r3) {
            o.e(r2, "packageName");
            o.e(r3, "functionId");
            this.f18184a = r2;
            this.f18185b = r3;
        }

        public final String a() {
            return this.f18184a;
        }

        public final String b() {
            return this.f18185b;
        }
    }

    static {
        f18183a = new c();
    }

    private c() {
    }

    public final a a(AppFunctionNode r7) {
        o.e(r7, "node");
        String r6 = r7.getSchemaCategory();
        String r0 = r7.getSchemaName();
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        boolean r3 = false;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == true) goto L24;
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L14;
    L17:
        boolean r5 = true;
    L18:
        if (r5 == true) goto L24;
        m r8 = x.f18310a.query(r6, r0);
        if (r8 != null) goto L23;
        return null;
    L23:
        return new a(r8.c(), r8.d());
    L14:
        if (d.o.o.d(r4) == true) goto L17;
        r5 = false;
    L24:
        String r9 = r7.getPackageName();
        String r10 = r7.getFunctionId();
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin");
        if (r11 != null) goto L27;
    L30:
        boolean r12 = true;
    L31:
        if (r12 == true) goto L40;
        CharSequence r13 = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin");
        if (r13 != null) goto L35;
    L36:
        r3 = true;
    L37:
        if (r3 == true) goto L40;
        return new a(r9, r10);
    L35:
        if (d.o.o.d(r13) == false) goto L37;
    L40:
        return null;
    L27:
        if (d.o.o.d(r11) == true) goto L30;
        r12 = false;
        goto L31
    L5:
        if (d.o.o.d(r1) == true) goto L8;
        r2 = false;
        goto L10
    }

    public final boolean b(AppFunctionNode r3) {
        o.e(r3, "node");
        a r2 = a(r3);
        if (r2 != null) goto L6;
        return false;
    L6:
        if (x.f18310a.a(r2.a(), r2.b()) == null) goto L9;
        return true;
    L9:
        return false;
    }
}
