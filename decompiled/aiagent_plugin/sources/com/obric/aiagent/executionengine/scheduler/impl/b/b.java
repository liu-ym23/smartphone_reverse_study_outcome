package com.obric.aiagent.executionengine.scheduler.impl.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: AppFunctionErrorMapper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f18346a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<a> f18347b = null;

    /* JADX INFO: compiled from: AppFunctionErrorMapper.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f18348a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<String> f18349b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f18350c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (this.f18348a == r6.f18348a) goto L12;
            return false;
        L12:
            if (o.a(this.f18349b, r6.f18349b) == true) goto L15;
            return false;
        L15:
            if (this.f18350c == r6.f18350c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.f18348a) * 31) + this.f18349b.hashCode()) * 31) + Integer.hashCode(this.f18350c);
        }

        public String toString() {
            return "Rule(code=" + this.f18348a + ", messageKeywords=" + this.f18349b + ", target=" + this.f18350c + ')';
        }

        public a(int r3, List<String> r4, int r5) {
            List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            o.e(r6, "messageKeywords");
            this.f18348a = r3;
            this.f18349b = r6;
            this.f18350c = r5;
        }

        public final int a() {
            return this.f18348a;
        }

        public final List<String> b() {
            return this.f18349b;
        }

        public final int c() {
            return this.f18350c;
        }
    }

    private final int a(int r4) {
        if (r4 == (-2)) goto L17;
        if (r4 == (-1)) goto L22;
        if (r4 != 3000) goto L9;
        return -2002;
    L9:
        if (r4 == 3500) goto L14;
        switch(r4) {
            case 1000: goto L14;
            case 1001: goto L17;
            case 1002: goto L22;
            case 1003: goto L22;
            default: goto L11;
        };
    L11:
        switch(r4) {
            case 2000: goto L19;
            case 2001: goto L13;
            case 2002: goto L14;
            default: goto L19;
        };
    L13:
        return 1;
    L19:
        return -2002;
    L14:
        return 113;
    L22:
        return 999;
    L17:
        return 103;
    }

    private b() {
    }

    static {
        f18346a = new b();
        f18347b = p.a(new a(3500, p.a("privacy statement not agreed"), 201));
    }

    public final int a(int r11, String r12) {
        Object r0 = null;
        if (r12 == null) goto L5;
        String r13 = r12.toLowerCase(Locale.ROOT);
        o.c(r13, "toLowerCase(...)");
    L6:
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(f18347b, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L8:
        if (r1.hasNext() == false) goto L30;
        Object r2 = r1.next();
        a r4 = (a) ZeusTransformUtils.preCheckCast(r2, a.class, "com.obric.aiagent.plugin");
        boolean r6 = true;
        if (r4.a() == r11) goto L12;
    L27:
        r6 = false;
    L28:
        if (r6 == false) goto L8;
        r0 = r2;
        goto L30
    L12:
        if (r4.b().isEmpty() == true) goto L28;
        if (r13 == null) goto L27;
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r4.b(), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == true) goto L17;
    L19:
        Iterator r7 = r5.iterator();
    L21:
        if (r7.hasNext() == false) goto L18;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L21;
        boolean r8 = true;
    L25:
        if (r8 == false) goto L27;
    L18:
        r8 = false;
        goto L25
    L17:
        if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L19;
    L30:
        a r14 = (a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L35;
        return r14.c();
    L35:
        return a(r11);
    L5:
        r13 = null;
        goto L6
    }
}
