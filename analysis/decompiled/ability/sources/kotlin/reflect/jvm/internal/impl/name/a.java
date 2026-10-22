package kotlin.reflect.jvm.internal.impl.name;

/* loaded from: classes4.dex */
public abstract class a {
    /* JADX WARN: Removed duplicated region for block: B:25:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0038 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean a(java.lang.String r6) {
        /*
            r0 = 0
            if (r6 != 0) goto L4
            return r0
        L4:
            kotlin.reflect.jvm.internal.impl.name.State r1 = kotlin.reflect.jvm.internal.impl.name.State.f5098a
            r2 = r0
        L7:
            int r3 = r6.length()
            r4 = 1
            if (r2 >= r3) goto L3e
            char r3 = r6.charAt(r2)
            int r5 = r1.ordinal()
            if (r5 == 0) goto L32
            if (r5 == r4) goto L24
            r1 = 2
            if (r5 != r1) goto L1e
            goto L32
        L1e:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        L24:
            r4 = 46
            if (r3 != r4) goto L2b
            kotlin.reflect.jvm.internal.impl.name.State r1 = kotlin.reflect.jvm.internal.impl.name.State.c
            goto L3b
        L2b:
            boolean r3 = java.lang.Character.isJavaIdentifierPart(r3)
            if (r3 != 0) goto L3b
            return r0
        L32:
            boolean r1 = java.lang.Character.isJavaIdentifierStart(r3)
            if (r1 != 0) goto L39
            return r0
        L39:
            kotlin.reflect.jvm.internal.impl.name.State r1 = kotlin.reflect.jvm.internal.impl.name.State.b
        L3b:
            int r2 = r2 + 1
            goto L7
        L3e:
            kotlin.reflect.jvm.internal.impl.name.State r6 = kotlin.reflect.jvm.internal.impl.name.State.c
            if (r1 == r6) goto L43
            return r4
        L43:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.name.a.a(java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final G8.c b(G8.c r3, G8.c r4) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.k.f(r3, r0)
            java.lang.String r0 = "prefix"
            kotlin.jvm.internal.k.f(r4, r0)
            boolean r0 = r3.equals(r4)
            if (r0 == 0) goto L11
            goto L33
        L11:
            boolean r0 = r4.d()
            if (r0 == 0) goto L18
            goto L33
        L18:
            java.lang.String r0 = r3.b()
            java.lang.String r1 = r4.b()
            r2 = 0
            boolean r2 = j9.t.e0(r0, r1, r2)
            if (r2 == 0) goto L65
            int r1 = r1.length()
            char r0 = r0.charAt(r1)
            r1 = 46
            if (r0 != r1) goto L65
        L33:
            boolean r0 = r4.d()
            if (r0 == 0) goto L3a
            goto L65
        L3a:
            boolean r0 = r3.equals(r4)
            if (r0 == 0) goto L48
            G8.c r3 = G8.c.c
            java.lang.String r4 = "ROOT"
            kotlin.jvm.internal.k.e(r3, r4)
            return r3
        L48:
            G8.c r0 = new G8.c
            java.lang.String r3 = r3.b()
            java.lang.String r4 = r4.b()
            int r4 = r4.length()
            int r4 = r4 + 1
            java.lang.String r3 = r3.substring(r4)
            java.lang.String r4 = "substring(...)"
            kotlin.jvm.internal.k.e(r3, r4)
            r0.<init>(r3)
            return r0
        L65:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.name.a.b(G8.c, G8.c):G8.c");
    }
}
