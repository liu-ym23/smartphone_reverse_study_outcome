package h4;

import b0.d0;
import java.nio.ByteBuffer;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import m4.w0;

/* loaded from: classes.dex */
public final class e implements w {

    /* renamed from: a, reason: collision with root package name */
    public long f4124a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f4125b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f4126c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f4127d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f4128e;

    public e(w0 w0Var, i5.l lVar, long j2, k5.t tVar) {
        d0 d0Var = new d0(13);
        q7.k.e(tVar, "logger");
        this.f4125b = w0Var;
        this.f4126c = lVar;
        this.f4124a = j2;
        this.f4127d = tVar;
        this.f4128e = d0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static o4.l0 c(java.lang.String r5) {
        /*
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L6
            r0.<init>(r5)     // Catch: java.lang.Throwable -> L6
            goto Lb
        L6:
            r0 = move-exception
            c7.l r0 = w7.e0.n(r0)
        Lb:
            boolean r1 = r0 instanceof c7.l
            r2 = 0
            if (r1 == 0) goto L11
            r0 = r2
        L11:
            org.json.JSONObject r0 = (org.json.JSONObject) r0
            r1 = 1
            if (r0 != 0) goto L1c
            o4.l0 r0 = new o4.l0
            r0.<init>(r1, r5, r2)
            return r0
        L1c:
            java.lang.String r3 = "ok"
            boolean r3 = r0.optBoolean(r3, r1)
            if (r3 != 0) goto L62
            java.lang.String r5 = "error"
            org.json.JSONObject r5 = r0.optJSONObject(r5)
            if (r5 == 0) goto L3e
            java.lang.String r0 = "code"
            java.lang.String r0 = r5.optString(r0)
            if (r0 == 0) goto L3e
            int r1 = r0.length()
            if (r1 <= 0) goto L3b
            goto L3c
        L3b:
            r0 = r2
        L3c:
            if (r0 != 0) goto L40
        L3e:
            java.lang.String r0 = "STEPCLAW_BRIDGE_ERROR"
        L40:
            if (r5 == 0) goto L54
            java.lang.String r1 = "message"
            java.lang.String r5 = r5.optString(r1)
            if (r5 == 0) goto L54
            int r1 = r5.length()
            if (r1 <= 0) goto L51
            goto L52
        L51:
            r5 = r2
        L52:
            if (r5 != 0) goto L56
        L54:
            java.lang.String r5 = "target invoke returned ok=false"
        L56:
            o4.l0 r1 = new o4.l0
            o4.j0 r3 = new o4.j0
            r3.<init>(r0, r5, r2)
            r5 = 0
            r1.<init>(r5, r2, r3)
            return r1
        L62:
            java.lang.String r3 = "payload"
            java.lang.Object r3 = r0.opt(r3)
            if (r3 == 0) goto L7f
            java.lang.Object r4 = org.json.JSONObject.NULL
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto L73
            goto L74
        L73:
            r3 = r2
        L74:
            if (r3 == 0) goto L7f
            java.lang.String r3 = r3.toString()
            if (r3 != 0) goto L7d
            goto L7f
        L7d:
            r5 = r3
            goto L94
        L7f:
            java.lang.String r3 = "payloadJSON"
            java.lang.String r0 = r0.optString(r3)
            q7.k.b(r0)
            int r3 = r0.length()
            if (r3 <= 0) goto L8f
            goto L90
        L8f:
            r0 = r2
        L90:
            if (r0 != 0) goto L93
            goto L94
        L93:
            r5 = r0
        L94:
            o4.l0 r0 = new o4.l0
            r0.<init>(r1, r5, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: h4.e.c(java.lang.String):o4.l0");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0193 A[Catch: all -> 0x0042, TryCatch #0 {all -> 0x0042, blocks: (B:15:0x003d, B:76:0x0186, B:78:0x0193, B:80:0x01ab, B:83:0x01b1, B:85:0x01b5), top: B:95:0x003d }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0206  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(o4.k0 r22, g7.d r23) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 539
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h4.e.a(o4.k0, g7.d):java.lang.Object");
    }

    @Override // h4.w
    public synchronized void b(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3) {
        try {
            ((Cipher) this.f4126c).init(1, (SecretKeySpec) this.f4125b, f.i((byte[]) this.f4127d, this.f4124a, false));
            this.f4124a++;
            if (byteBuffer2.hasRemaining()) {
                ((Cipher) this.f4126c).update(byteBuffer, byteBuffer3);
                ((Cipher) this.f4126c).doFinal(byteBuffer2, byteBuffer3);
            } else {
                ((Cipher) this.f4126c).doFinal(byteBuffer, byteBuffer3);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // h4.w
    public ByteBuffer h() {
        return ((ByteBuffer) this.f4128e).asReadOnlyBuffer();
    }

    @Override // h4.w
    public synchronized void j(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        ((Cipher) this.f4126c).init(1, (SecretKeySpec) this.f4125b, f.i((byte[]) this.f4127d, this.f4124a, true));
        this.f4124a++;
        ((Cipher) this.f4126c).doFinal(byteBuffer, byteBuffer2);
    }

    public e(f fVar, byte[] bArr) {
        this.f4124a = 0L;
        this.f4126c = (Cipher) m.f4149b.f4151a.a("AES/GCM/NoPadding");
        this.f4124a = 0L;
        int i2 = fVar.f4129a;
        byte[] bArrA = u.a(i2);
        byte[] bArrA2 = u.a(7);
        this.f4127d = bArrA2;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(fVar.e());
        this.f4128e = byteBufferAllocate;
        byteBufferAllocate.put((byte) fVar.e());
        byteBufferAllocate.put(bArrA);
        byteBufferAllocate.put(bArrA2);
        byteBufferAllocate.flip();
        this.f4125b = new SecretKeySpec(ib.c.p(fVar.f4132d, fVar.f4133e, bArrA, bArr, i2), "AES");
    }
}
