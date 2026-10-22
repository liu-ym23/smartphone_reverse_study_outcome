package s8;

import android.content.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j1 extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f11691c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Context f11692f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f11693g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j1(Context context, String str, nb.c cVar, int i) {
        super(2, cVar);
        this.f11691c = i;
        this.f11692f = context;
        this.f11693g = str;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f11691c) {
            case 0:
                return new j1(this.f11692f, this.f11693g, cVar, 0);
            default:
                return new j1(this.f11692f, this.f11693g, cVar, 1);
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        kc.t tVar = (kc.t) obj;
        nb.c cVar = (nb.c) obj2;
        switch (this.f11691c) {
        }
        return ((j1) create(tVar, cVar)).invokeSuspend(jb.v.f6774a);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0097  */
    @Override // pb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r4) {
        /*
            r3 = this;
            int r0 = r3.f11691c
            r1 = 0
            java.lang.String r2 = r3.f11693g
            android.content.Context r3 = r3.f11692f
            switch(r0) {
                case 0: goto L55;
                default: goto La;
            }
        La:
            ob.a r0 = ob.a.f9351c
            id.c.I(r4)
            android.content.ContentResolver r3 = r3.getContentResolver()
            r3.getClass()
            if (r2 == 0) goto L4c
            boolean r4 = hc.h.g0(r2)
            if (r4 != 0) goto L1f
            goto L20
        L1f:
            r2 = r1
        L20:
            if (r2 != 0) goto L23
            goto L4c
        L23:
            android.net.Uri r4 = android.net.Uri.parse(r2)     // Catch: java.lang.Throwable -> L35
            java.io.InputStream r3 = r3.openInputStream(r4)     // Catch: java.lang.Throwable -> L35
            if (r3 == 0) goto L3e
            android.graphics.Bitmap r4 = android.graphics.BitmapFactory.decodeStream(r3)     // Catch: java.lang.Throwable -> L37
            r3.close()     // Catch: java.lang.Throwable -> L35
            goto L44
        L35:
            r3 = move-exception
            goto L40
        L37:
            r4 = move-exception
            throw r4     // Catch: java.lang.Throwable -> L39
        L39:
            r0 = move-exception
            t.o.d(r3, r4)     // Catch: java.lang.Throwable -> L35
            throw r0     // Catch: java.lang.Throwable -> L35
        L3e:
            r4 = r1
            goto L44
        L40:
            jb.h r4 = id.c.l(r3)
        L44:
            boolean r3 = r4 instanceof jb.h
            if (r3 == 0) goto L49
            r4 = r1
        L49:
            android.graphics.Bitmap r4 = (android.graphics.Bitmap) r4
            goto L4d
        L4c:
            r4 = r1
        L4d:
            if (r4 == 0) goto L54
            d1.e r1 = new d1.e
            r1.<init>(r4)
        L54:
            return r1
        L55:
            ob.a r0 = ob.a.f9351c
            id.c.I(r4)
            android.content.ContentResolver r3 = r3.getContentResolver()
            r3.getClass()
            if (r2 == 0) goto L97
            boolean r4 = hc.h.g0(r2)
            if (r4 != 0) goto L6a
            goto L6b
        L6a:
            r2 = r1
        L6b:
            if (r2 != 0) goto L6e
            goto L97
        L6e:
            android.net.Uri r4 = android.net.Uri.parse(r2)     // Catch: java.lang.Throwable -> L80
            java.io.InputStream r3 = r3.openInputStream(r4)     // Catch: java.lang.Throwable -> L80
            if (r3 == 0) goto L89
            android.graphics.Bitmap r4 = android.graphics.BitmapFactory.decodeStream(r3)     // Catch: java.lang.Throwable -> L82
            r3.close()     // Catch: java.lang.Throwable -> L80
            goto L8f
        L80:
            r3 = move-exception
            goto L8b
        L82:
            r4 = move-exception
            throw r4     // Catch: java.lang.Throwable -> L84
        L84:
            r0 = move-exception
            t.o.d(r3, r4)     // Catch: java.lang.Throwable -> L80
            throw r0     // Catch: java.lang.Throwable -> L80
        L89:
            r4 = r1
            goto L8f
        L8b:
            jb.h r4 = id.c.l(r3)
        L8f:
            boolean r3 = r4 instanceof jb.h
            if (r3 == 0) goto L94
            r4 = r1
        L94:
            android.graphics.Bitmap r4 = (android.graphics.Bitmap) r4
            goto L98
        L97:
            r4 = r1
        L98:
            if (r4 == 0) goto L9f
            d1.e r1 = new d1.e
            r1.<init>(r4)
        L9f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: s8.j1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
