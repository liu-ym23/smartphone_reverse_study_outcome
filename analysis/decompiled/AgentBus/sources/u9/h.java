package u9;

/* loaded from: classes.dex */
public class h implements p7.a {

    /* renamed from: f, reason: collision with root package name */
    public final k f10199f;

    /* renamed from: g, reason: collision with root package name */
    public final p7.a f10200g;

    /* renamed from: h, reason: collision with root package name */
    public volatile Object f10201h;

    public h(k kVar, p7.a aVar) {
        if (kVar == null) {
            a(0);
            throw null;
        }
        this.f10201h = j.f10202f;
        this.f10199f = kVar;
        this.f10200g = aVar;
    }

    public static /* synthetic */ void a(int i2) {
        String str = (i2 == 2 || i2 == 3) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 2 || i2 == 3) ? 2 : 3];
        if (i2 == 1) {
            objArr[0] = "computable";
        } else if (i2 == 2 || i2 == 3) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
        } else {
            objArr[0] = "storageManager";
        }
        if (i2 == 2) {
            objArr[1] = "recursionDetected";
        } else if (i2 != 3) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
        } else {
            objArr[1] = "renderDebugInformation";
        }
        if (i2 != 2 && i2 != 3) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i2 != 2 && i2 != 3) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004d A[Catch: all -> 0x0026, TRY_LEAVE, TryCatch #0 {all -> 0x0026, blocks: (B:7:0x0015, B:9:0x001b, B:15:0x002a, B:17:0x0035, B:22:0x0042, B:24:0x004a, B:25:0x004d, B:29:0x005c, B:31:0x0062, B:33:0x0066, B:34:0x006d, B:35:0x0074, B:36:0x0075, B:37:0x007b, B:26:0x004f), top: B:40:0x0015, inners: #1 }] */
    @Override // p7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c() throws java.lang.Throwable {
        /*
            r5 = this;
            u9.j r0 = u9.j.f10204h
            u9.j r1 = u9.j.f10203g
            java.lang.Object r2 = r5.f10201h
            boolean r3 = r2 instanceof u9.j
            if (r3 != 0) goto Le
            ea.k.j(r2)
            return r2
        Le:
            u9.k r2 = r5.f10199f
            u9.m r2 = r2.f10208a
            r2.lock()
            java.lang.Object r2 = r5.f10201h     // Catch: java.lang.Throwable -> L26
            boolean r3 = r2 instanceof u9.j     // Catch: java.lang.Throwable -> L26
            if (r3 != 0) goto L28
            ea.k.j(r2)     // Catch: java.lang.Throwable -> L26
            u9.k r5 = r5.f10199f
            u9.m r5 = r5.f10208a
            r5.unlock()
            return r2
        L26:
            r0 = move-exception
            goto L7c
        L28:
            if (r2 != r1) goto L3f
            r5.f10201h = r0     // Catch: java.lang.Throwable -> L26
            r3 = 1
            a7.c r3 = r5.f(r3)     // Catch: java.lang.Throwable -> L26
            boolean r4 = r3.f408b     // Catch: java.lang.Throwable -> L26
            if (r4 != 0) goto L3f
            java.lang.Object r0 = r3.f409c     // Catch: java.lang.Throwable -> L26
        L37:
            u9.k r5 = r5.f10199f
            u9.m r5 = r5.f10208a
            r5.unlock()
            return r0
        L3f:
            if (r2 != r0) goto L4d
            r0 = 0
            a7.c r0 = r5.f(r0)     // Catch: java.lang.Throwable -> L26
            boolean r2 = r0.f408b     // Catch: java.lang.Throwable -> L26
            if (r2 != 0) goto L4d
            java.lang.Object r0 = r0.f409c     // Catch: java.lang.Throwable -> L26
            goto L37
        L4d:
            r5.f10201h = r1     // Catch: java.lang.Throwable -> L26
            p7.a r0 = r5.f10200g     // Catch: java.lang.Throwable -> L5b
            java.lang.Object r0 = r0.c()     // Catch: java.lang.Throwable -> L5b
            r5.d(r0)     // Catch: java.lang.Throwable -> L5b
            r5.f10201h = r0     // Catch: java.lang.Throwable -> L5b
            goto L37
        L5b:
            r0 = move-exception
            boolean r2 = ea.k.h(r0)     // Catch: java.lang.Throwable -> L26
            if (r2 != 0) goto L75
            java.lang.Object r2 = r5.f10201h     // Catch: java.lang.Throwable -> L26
            if (r2 != r1) goto L6d
            ea.j r1 = new ea.j     // Catch: java.lang.Throwable -> L26
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L26
            r5.f10201h = r1     // Catch: java.lang.Throwable -> L26
        L6d:
            u9.k r1 = r5.f10199f     // Catch: java.lang.Throwable -> L26
            u9.a r1 = r1.f10209b     // Catch: java.lang.Throwable -> L26
            r1.getClass()     // Catch: java.lang.Throwable -> L26
            throw r0     // Catch: java.lang.Throwable -> L26
        L75:
            u9.j r1 = u9.j.f10202f     // Catch: java.lang.Throwable -> L26
            r5.f10201h = r1     // Catch: java.lang.Throwable -> L26
            java.lang.RuntimeException r0 = (java.lang.RuntimeException) r0     // Catch: java.lang.Throwable -> L26
            throw r0     // Catch: java.lang.Throwable -> L26
        L7c:
            u9.k r5 = r5.f10199f
            u9.m r5 = r5.f10208a
            r5.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: u9.h.c():java.lang.Object");
    }

    public void d(Object obj) {
    }

    public a7.c f(boolean z4) {
        a7.c cVarD = this.f10199f.d(null, "in a lazy value");
        if (cVarD != null) {
            return cVarD;
        }
        a(2);
        throw null;
    }
}
