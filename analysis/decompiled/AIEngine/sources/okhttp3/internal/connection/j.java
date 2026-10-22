package okhttp3.internal.connection;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class j implements ed.e {

    /* renamed from: a, reason: collision with root package name */
    public final f f11097a;

    public j(f fVar) {
        this.f11097a = fVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0041, code lost:
    
        return r3.a();
     */
    @Override // ed.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final ed.g a() throws java.lang.Throwable {
        /*
            r6 = this;
            r0 = 0
            r1 = r0
        L2:
            okhttp3.internal.connection.f r2 = r6.f11097a
            ed.c r3 = r2.f11079l
            boolean r3 = r3.isCanceled()
            if (r3 != 0) goto L51
            okhttp3.internal.connection.h$b r3 = r2.c()     // Catch: java.io.IOException -> L2c
            boolean r4 = r3.isReady()     // Catch: java.io.IOException -> L2c
            if (r4 != 0) goto L3d
            okhttp3.internal.connection.h$a r4 = r3.g()     // Catch: java.io.IOException -> L2c
            okhttp3.internal.connection.h$b r5 = r4.f11086b     // Catch: java.io.IOException -> L2c
            if (r5 != 0) goto L24
            java.lang.Throwable r5 = r4.f11087c     // Catch: java.io.IOException -> L2c
            if (r5 != 0) goto L24
            r5 = 1
            goto L25
        L24:
            r5 = 0
        L25:
            if (r5 == 0) goto L2e
            okhttp3.internal.connection.h$a r4 = r3.c()     // Catch: java.io.IOException -> L2c
            goto L2e
        L2c:
            r3 = move-exception
            goto L42
        L2e:
            okhttp3.internal.connection.h$b r5 = r4.f11086b     // Catch: java.io.IOException -> L2c
            java.lang.Throwable r4 = r4.f11087c     // Catch: java.io.IOException -> L2c
            if (r4 != 0) goto L3c
            if (r5 == 0) goto L3d
            mb.k<okhttp3.internal.connection.h$b> r3 = r2.f11083p     // Catch: java.io.IOException -> L2c
            r3.addFirst(r5)     // Catch: java.io.IOException -> L2c
            goto L2
        L3c:
            throw r4     // Catch: java.io.IOException -> L2c
        L3d:
            ed.g r6 = r3.a()     // Catch: java.io.IOException -> L2c
            return r6
        L42:
            if (r1 != 0) goto L46
            r1 = r3
            goto L49
        L46:
            jd.b.c(r1, r3)
        L49:
            boolean r2 = r2.e(r0)
            if (r2 == 0) goto L50
            goto L2
        L50:
            throw r1
        L51:
            java.io.IOException r6 = new java.io.IOException
            java.lang.String r0 = "Canceled"
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.j.a():ed.g");
    }

    @Override // ed.e
    public final h b() {
        return this.f11097a;
    }
}
