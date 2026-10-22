package m9;

import c8.j;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes.dex */
public enum c {
    BOOLEAN(j.BOOLEAN, "boolean", "Z", "java.lang.Boolean"),
    CHAR(j.CHAR, "char", "C", "java.lang.Character"),
    BYTE(j.BYTE, "byte", "B", "java.lang.Byte"),
    SHORT(j.SHORT, "short", "S", "java.lang.Short"),
    INT(j.INT, "int", "I", "java.lang.Integer"),
    FLOAT(j.FLOAT, "float", "F", "java.lang.Float"),
    LONG(j.LONG, "long", "J", "java.lang.Long"),
    DOUBLE(j.DOUBLE, "double", "D", "java.lang.Double");


    /* renamed from: r, reason: collision with root package name */
    public static final HashSet f6463r = new HashSet();

    /* renamed from: s, reason: collision with root package name */
    public static final HashMap f6464s = new HashMap();

    /* renamed from: t, reason: collision with root package name */
    public static final EnumMap f6465t = new EnumMap(j.class);

    /* renamed from: u, reason: collision with root package name */
    public static final HashMap f6466u = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public final j f6468f;

    /* renamed from: g, reason: collision with root package name */
    public final String f6469g;

    /* renamed from: h, reason: collision with root package name */
    public final String f6470h;

    /* renamed from: i, reason: collision with root package name */
    public final e9.c f6471i;

    static {
        for (c cVar : values()) {
            f6463r.add(cVar.e());
            f6464s.put(cVar.f6469g, cVar);
            f6465t.put((EnumMap) cVar.d(), (j) cVar);
            f6466u.put(cVar.c(), cVar);
        }
    }

    c(j jVar, String str, String str2, String str3) {
        if (jVar == null) {
            a(6);
            throw null;
        }
        this.f6468f = jVar;
        this.f6469g = str;
        this.f6470h = str2;
        this.f6471i = new e9.c(str3);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void a(int r7) {
        /*
            r0 = 4
            r1 = 2
            if (r7 == r1) goto Lc
            if (r7 == r0) goto Lc
            switch(r7) {
                case 10: goto Lc;
                case 11: goto Lc;
                case 12: goto Lc;
                case 13: goto Lc;
                default: goto L9;
            }
        L9:
            java.lang.String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            goto Le
        Lc:
            java.lang.String r2 = "@NotNull method %s.%s must not return null"
        Le:
            if (r7 == r1) goto L17
            if (r7 == r0) goto L17
            switch(r7) {
                case 10: goto L17;
                case 11: goto L17;
                case 12: goto L17;
                case 13: goto L17;
                default: goto L15;
            }
        L15:
            r3 = 3
            goto L18
        L17:
            r3 = r1
        L18:
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r4 = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType"
            r5 = 0
            switch(r7) {
                case 1: goto L3c;
                case 2: goto L39;
                case 3: goto L34;
                case 4: goto L39;
                case 5: goto L2f;
                case 6: goto L2a;
                case 7: goto L3c;
                case 8: goto L2f;
                case 9: goto L25;
                case 10: goto L39;
                case 11: goto L39;
                case 12: goto L39;
                case 13: goto L39;
                default: goto L20;
            }
        L20:
            java.lang.String r6 = "className"
            r3[r5] = r6
            goto L40
        L25:
            java.lang.String r6 = "wrapperClassName"
            r3[r5] = r6
            goto L40
        L2a:
            java.lang.String r6 = "primitiveType"
            r3[r5] = r6
            goto L40
        L2f:
            java.lang.String r6 = "desc"
            r3[r5] = r6
            goto L40
        L34:
            java.lang.String r6 = "type"
            r3[r5] = r6
            goto L40
        L39:
            r3[r5] = r4
            goto L40
        L3c:
            java.lang.String r6 = "name"
            r3[r5] = r6
        L40:
            java.lang.String r5 = "get"
            r6 = 1
            if (r7 == r1) goto L61
            if (r7 == r0) goto L61
            switch(r7) {
                case 10: goto L5c;
                case 11: goto L57;
                case 12: goto L52;
                case 13: goto L4d;
                default: goto L4a;
            }
        L4a:
            r3[r6] = r4
            goto L63
        L4d:
            java.lang.String r4 = "getWrapperFqName"
            r3[r6] = r4
            goto L63
        L52:
            java.lang.String r4 = "getDesc"
            r3[r6] = r4
            goto L63
        L57:
            java.lang.String r4 = "getJavaKeywordName"
            r3[r6] = r4
            goto L63
        L5c:
            java.lang.String r4 = "getPrimitiveType"
            r3[r6] = r4
            goto L63
        L61:
            r3[r6] = r5
        L63:
            switch(r7) {
                case 1: goto L75;
                case 2: goto L77;
                case 3: goto L75;
                case 4: goto L77;
                case 5: goto L70;
                case 6: goto L6b;
                case 7: goto L6b;
                case 8: goto L6b;
                case 9: goto L6b;
                case 10: goto L77;
                case 11: goto L77;
                case 12: goto L77;
                case 13: goto L77;
                default: goto L66;
            }
        L66:
            java.lang.String r4 = "isWrapperClassName"
            r3[r1] = r4
            goto L77
        L6b:
            java.lang.String r4 = "<init>"
            r3[r1] = r4
            goto L77
        L70:
            java.lang.String r4 = "getByDesc"
            r3[r1] = r4
            goto L77
        L75:
            r3[r1] = r5
        L77:
            java.lang.String r2 = java.lang.String.format(r2, r3)
            if (r7 == r1) goto L88
            if (r7 == r0) goto L88
            switch(r7) {
                case 10: goto L88;
                case 11: goto L88;
                case 12: goto L88;
                case 13: goto L88;
                default: goto L82;
            }
        L82:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            r7.<init>(r2)
            goto L8d
        L88:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            r7.<init>(r2)
        L8d:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: m9.c.a(int):void");
    }

    public static c b(String str) {
        c cVar = (c) f6464s.get(str);
        if (cVar != null) {
            return cVar;
        }
        throw new AssertionError("Non-primitive type name passed: ".concat(str));
    }

    public final String c() {
        String str = this.f6470h;
        if (str != null) {
            return str;
        }
        a(12);
        throw null;
    }

    public final j d() {
        j jVar = this.f6468f;
        if (jVar != null) {
            return jVar;
        }
        a(10);
        throw null;
    }

    public final e9.c e() {
        e9.c cVar = this.f6471i;
        if (cVar != null) {
            return cVar;
        }
        a(13);
        throw null;
    }
}
