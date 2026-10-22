package I1;

/* loaded from: classes.dex */
public class a extends J1.d {

    /* renamed from: e, reason: collision with root package name */
    public J1.f f3253e;

    public a(l lVar, Class<?> cls, L1.a aVar) {
        super(cls, aVar, 2);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0077  */
    @Override // J1.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(I1.b r6, java.lang.Object r7, java.lang.reflect.Type r8, java.util.Map<java.lang.String, java.lang.Object> r9) {
        /*
            r5 = this;
            J1.f r0 = r5.f3253e
            if (r0 != 0) goto L12
            I1.l r0 = r6.f3255b
            L1.a r1 = r5.f3694a
            java.lang.Class<?> r2 = r1.f4267g
            java.lang.reflect.Type r1 = r1.f4268h
            J1.f r0 = r0.b(r2, r1)
            r5.f3253e = r0
        L12:
            L1.a r0 = r5.f3694a
            java.lang.reflect.Type r0 = r0.f4268h
            boolean r1 = r8 instanceof java.lang.reflect.ParameterizedType
            if (r1 == 0) goto L2e
            I1.k r2 = r6.f3259f
            if (r2 == 0) goto L20
            r2.f3329d = r8
        L20:
            java.lang.Class<?> r2 = r5.f3695b
            java.lang.reflect.Type r0 = L1.a.i(r2, r8, r0)
            I1.l r2 = r6.f3255b
            J1.f r2 = r2.c(r0)
            r5.f3253e = r2
        L2e:
            boolean r2 = r0 instanceof java.lang.reflect.ParameterizedType
            if (r2 == 0) goto L62
            if (r1 == 0) goto L62
            r1 = r0
            java.lang.reflect.ParameterizedType r1 = (java.lang.reflect.ParameterizedType) r1
            java.lang.reflect.ParameterizedType r8 = (java.lang.reflect.ParameterizedType) r8
            java.lang.reflect.Type[] r2 = r1.getActualTypeArguments()
            java.lang.reflect.Type r3 = r8.getRawType()
            boolean r4 = r3 instanceof java.lang.Class
            if (r4 == 0) goto L62
            java.lang.Class r3 = (java.lang.Class) r3
            java.lang.reflect.TypeVariable[] r3 = r3.getTypeParameters()
            java.lang.reflect.Type[] r8 = r8.getActualTypeArguments()
            boolean r8 = L1.d.w(r2, r3, r8)
            if (r8 == 0) goto L62
            L1.c r0 = new L1.c
            java.lang.reflect.Type r8 = r1.getOwnerType()
            java.lang.reflect.Type r1 = r1.getRawType()
            r0.<init>(r2, r8, r1)
        L62:
            L1.a r8 = r5.f3694a
            java.lang.String r1 = r8.f4274n
            if (r1 == 0) goto L77
            J1.f r2 = r5.f3253e
            boolean r3 = r2 instanceof K1.h
            if (r3 == 0) goto L77
            K1.h r2 = (K1.h) r2
            java.lang.String r8 = r8.f4261a
            java.lang.Object r8 = r2.d(r6, r0, r8, r1)
            goto L7f
        L77:
            J1.f r1 = r5.f3253e
            java.lang.String r8 = r8.f4261a
            java.lang.Object r8 = r1.b(r6, r0, r8)
        L7f:
            int r0 = r6.f3263j
            r1 = 1
            if (r0 != r1) goto L92
            I1.b$a r7 = r6.A()
            r7.f3269c = r5
            I1.k r5 = r6.f3259f
            r7.f3270d = r5
            r5 = 0
            r6.f3263j = r5
            return
        L92:
            if (r7 != 0) goto L9c
            L1.a r5 = r5.f3694a
            java.lang.String r5 = r5.f4261a
            r9.put(r5, r8)
            return
        L9c:
            if (r8 != 0) goto Lb3
            L1.a r6 = r5.f3694a
            java.lang.Class<?> r6 = r6.f4267g
            java.lang.Class r9 = java.lang.Byte.TYPE
            if (r6 == r9) goto Lb2
            java.lang.Class r9 = java.lang.Short.TYPE
            if (r6 == r9) goto Lb2
            java.lang.Class r9 = java.lang.Float.TYPE
            if (r6 == r9) goto Lb2
            java.lang.Class r9 = java.lang.Double.TYPE
            if (r6 != r9) goto Lb3
        Lb2:
            return
        Lb3:
            r5.g(r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: I1.a.b(I1.b, java.lang.Object, java.lang.reflect.Type, java.util.Map):void");
    }

    public J1.f h(l lVar) {
        if (this.f3253e == null) {
            L1.a aVar = this.f3694a;
            this.f3253e = lVar.b(aVar.f4267g, aVar.f4268h);
        }
        return this.f3253e;
    }
}
