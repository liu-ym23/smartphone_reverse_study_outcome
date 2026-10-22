package o4;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Region;
import java.security.KeyStore;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public class d0 implements r9.e, u9.m, s2.f, x2.f, f8.n0, f8.s, f8.l {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f7325f;

    /* renamed from: g, reason: collision with root package name */
    public Object f7326g;

    public /* synthetic */ d0(int i2, Object obj) {
        this.f7325f = i2;
        this.f7326g = obj;
    }

    public static String N(String str, String str2) {
        return a1.a.k("dt:", str, ":", str2);
    }

    @Override // f8.l
    public Object A(i8.r0 r0Var, Object obj) {
        return null;
    }

    @Override // x2.f
    public void B(n7.a aVar) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new c6.b(1, "EmojiCompatInitializer"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.execute(new com.stepos.probe.a(this, aVar, threadPoolExecutor, 2));
    }

    @Override // f8.s
    public f8.s C() {
        return this;
    }

    @Override // f8.s
    public f8.s D() {
        return this;
    }

    @Override // s2.f
    public la.j E() {
        return ((s2.f) this.f7326g).E();
    }

    @Override // f8.l
    public Object F(i8.k0 k0Var, Object obj) {
        return y(k0Var, obj);
    }

    @Override // f8.l
    public Object G(f8.z zVar, Object obj) {
        return null;
    }

    @Override // f8.s
    public f8.s H() {
        return this;
    }

    public void I(CancellationException cancellationException) {
        d0.e eVar = (d0.e) this.f7326g;
        int i2 = eVar.f2751h;
        ia.k[] kVarArr = new ia.k[i2];
        for (int i10 = 0; i10 < i2; i10++) {
            kVarArr[i10] = ((p.h) eVar.f2749f[i10]).f8112b;
        }
        for (int i11 = 0; i11 < i2; i11++) {
            kVarArr[i11].a(cancellationException);
        }
        if (eVar.f2751h != 0) {
            throw new IllegalStateException("uncancelled requests present");
        }
    }

    public s2.h0 J() {
        return (s2.h0) ((la.u0) this.f7326g).getValue();
    }

    public b0.b3 K() {
        x2.g gVarA = x2.g.a();
        if (gVarA.b() == 1) {
            return new z1.k(true);
        }
        b0.o1 o1VarN = b0.b.n(Boolean.FALSE);
        z1.g gVar = new z1.g(o1VarN, this);
        gVarA.f11113a.writeLock().lock();
        try {
            if (gVarA.f11115c == 1 || gVarA.f11115c == 2) {
                gVarA.f11116d.post(new x2.e(Arrays.asList(gVar), gVarA.f11115c, null));
            } else {
                gVarA.f11114b.add(gVar);
            }
            gVarA.f11113a.writeLock().unlock();
            return o1VarN;
        } catch (Throwable th) {
            gVarA.f11113a.writeLock().unlock();
            throw th;
        }
    }

    public long L() {
        switch (this.f7325f) {
            case com.google.protobuf.x0.FEATURES_FIELD_NUMBER /* 21 */:
                y.n nVar = (y.n) this.f7326g;
                long jL = nVar.f11509y.L();
                if (jL != 16) {
                    return jL;
                }
                y.z zVar = (y.z) i1.l.h(nVar, y.b0.f11358b);
                if (zVar != null) {
                    long j2 = zVar.f11540a;
                    if (j2 != 16) {
                        return j2;
                    }
                }
                return ((u0.m) i1.l.h(nVar, y.l.f11487a)).f9918a;
            default:
                return ((y.c0) this.f7326g).f11367b;
        }
    }

    public Boolean M() {
        return Boolean.TRUE;
    }

    public String O(String str, String str2) {
        q7.k.e(str, "deviceId");
        String string = ((SharedPreferences) this.f7326g).getString(N(str, str2), null);
        if (string == null || ga.k.t0(string)) {
            return null;
        }
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object P(long r3, long r5, i7.c r7) {
        /*
            r2 = this;
            boolean r3 = r7 instanceof p.o0
            if (r3 == 0) goto L13
            r3 = r7
            p.o0 r3 = (p.o0) r3
            int r4 = r3.f8147i
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r4 & r0
            if (r1 == 0) goto L13
            int r4 = r4 - r0
            r3.f8147i = r4
            goto L18
        L13:
            p.o0 r3 = new p.o0
            r3.<init>(r2, r7)
        L18:
            java.lang.Object r4 = r3.f8145g
            h7.a r7 = h7.a.f4212f
            int r0 = r3.f8147i
            r1 = 1
            if (r0 == 0) goto L31
            if (r0 != r1) goto L29
            long r5 = r3.f8144f
            w7.e0.N(r4)
            goto L43
        L29:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "call to 'resume' before 'invoke' with coroutine"
            r2.<init>(r3)
            throw r2
        L31:
            w7.e0.N(r4)
            java.lang.Object r2 = r2.f7326g
            p.y0 r2 = (p.y0) r2
            r3.f8144f = r5
            r3.f8147i = r1
            java.lang.Object r4 = r2.b(r5, r3)
            if (r4 != r7) goto L43
            return r7
        L43:
            d2.p r4 = (d2.p) r4
            long r2 = r4.f2801a
            long r2 = d2.p.d(r5, r2)
            d2.p r4 = new d2.p
            r4.<init>(r2)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.d0.P(long, long, i7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object Q(g7.d r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof v4.q
            if (r0 == 0) goto L13
            r0 = r7
            v4.q r0 = (v4.q) r0
            int r1 = r0.f10507i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f10507i = r1
            goto L1a
        L13:
            v4.q r0 = new v4.q
            i7.c r7 = (i7.c) r7
            r0.<init>(r6, r7)
        L1a:
            java.lang.Object r7 = r0.f10505g
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f10507i
            c7.r r3 = c7.r.f1986a
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L3c
            if (r2 == r5) goto L36
            if (r2 != r4) goto L2e
            w7.e0.N(r7)
            return r3
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L36:
            o4.d0 r6 = r0.f10504f
            w7.e0.N(r7)
            goto L46
        L3c:
            w7.e0.N(r7)
            r0.f10504f = r6
            r0.f10507i = r5
            if (r3 != r1) goto L46
            goto L51
        L46:
            java.lang.Object r6 = r6.f7326g
            r6 = 0
            r0.f10504f = r6
            r0.f10507i = r4
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            if (r6 != r1) goto L52
        L51:
            return r1
        L52:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.d0.Q(g7.d):java.lang.Object");
    }

    public void R() {
        d0.e eVar = (d0.e) this.f7326g;
        int i2 = 0;
        int i10 = new v7.d(0, eVar.f2751h - 1, 1).f10524g;
        if (i10 >= 0) {
            while (true) {
                ((p.h) eVar.f2749f[i2]).f8112b.resumeWith(c7.r.f1986a);
                if (i2 == i10) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        eVar.g();
    }

    public void S(float f10, float f11) {
        ((u5.h) this.f7326g).a().f(f10, f11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0029  */
    /* JADX WARN: Type inference failed for: r2v4, types: [f8.x] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void T(s2.h0 r5) {
        /*
            r4 = this;
            java.lang.String r0 = "newState"
            q7.k.e(r5, r0)
            java.lang.Object r4 = r4.f7326g
            la.u0 r4 = (la.u0) r4
        L9:
            java.lang.Object r0 = r4.getValue()
            r1 = r0
            s2.h0 r1 = (s2.h0) r1
            boolean r2 = r1 instanceof s2.c0
            if (r2 == 0) goto L16
            r2 = 1
            goto L1c
        L16:
            s2.j0 r2 = s2.j0.f9395b
            boolean r2 = q7.k.a(r1, r2)
        L1c:
            if (r2 == 0) goto L1f
            goto L29
        L1f:
            boolean r2 = r1 instanceof s2.c
            if (r2 == 0) goto L2b
            int r2 = r5.f9379a
            int r3 = r1.f9379a
            if (r2 <= r3) goto L2f
        L29:
            r1 = r5
            goto L2f
        L2b:
            boolean r2 = r1 instanceof s2.a0
            if (r2 == 0) goto L3e
        L2f:
            f8.x r2 = ma.c.f6481b
            if (r0 != 0) goto L34
            r0 = r2
        L34:
            if (r1 != 0) goto L37
            r1 = r2
        L37:
            boolean r0 = r4.g(r0, r1)
            if (r0 == 0) goto L9
            return
        L3e:
            a4.u r4 = new a4.u
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.d0.T(s2.h0):void");
    }

    @Override // f8.s
    public f8.s a() {
        return this;
    }

    @Override // f8.s
    public f8.s b(g8.j jVar) {
        q7.k.e(jVar, "additionalAnnotations");
        return this;
    }

    @Override // f8.s
    public f8.t build() {
        return (x9.b) this.f7326g;
    }

    @Override // f8.s
    public f8.s c(e9.f fVar) {
        q7.k.e(fVar, "name");
        return this;
    }

    @Override // f8.s
    public f8.s d(List list) {
        return this;
    }

    @Override // f8.l
    public Object e(i8.x xVar, Object obj) {
        return null;
    }

    @Override // f8.l
    public Object f(i8.v vVar, Object obj) {
        return null;
    }

    @Override // f8.s
    public f8.s g() {
        return this;
    }

    @Override // s2.f
    public Object h(p7.n nVar, i7.c cVar) {
        return ((s2.f) this.f7326g).h(new w2.c(nVar, null, 0), cVar);
    }

    @Override // r9.e
    public r9.d i(e9.b bVar) {
        r9.d dVarI;
        q7.k.e(bVar, "classId");
        f8.h0 h0Var = (f8.h0) this.f7326g;
        e9.c cVarG = bVar.g();
        q7.k.d(cVarG, "classId.packageFqName");
        Iterator it = f8.v.i(h0Var, cVarG).iterator();
        while (it.hasNext()) {
            f8.e0 e0Var = (f8.e0) it.next();
            if ((e0Var instanceof s9.c) && (dVarI = ((s9.c) e0Var).f9625n.i(bVar)) != null) {
                return dVarI;
            }
        }
        return null;
    }

    @Override // f8.l
    public Object k(t9.s sVar, Object obj) {
        return null;
    }

    @Override // f8.l
    public Object l(i8.c0 c0Var, Object obj) {
        return null;
    }

    @Override // u9.m
    public void lock() {
        ((ReentrantLock) this.f7326g).lock();
    }

    @Override // f8.s
    public f8.s m() {
        return this;
    }

    @Override // f8.l
    public Object n(i8.z zVar, Object obj) {
        return null;
    }

    @Override // f8.s
    public f8.s o(int i2) {
        m.x.t(i2, "kind");
        return this;
    }

    @Override // f8.l
    public Object p(i8.h hVar, Object obj) {
        return null;
    }

    @Override // f8.l
    public Object q(i8.i0 i0Var, Object obj) {
        z7.e0 e0Var = (z7.e0) this.f7326g;
        q7.k.e(i0Var, "descriptor");
        int i2 = (i0Var.f4809y != null ? 1 : 0) + (i0Var.f4810z != null ? 1 : 0);
        if (i0Var.f4795k) {
            if (i2 == 0) {
                return new z7.i0(e0Var, i0Var);
            }
            if (i2 == 1) {
                return new z7.k0(e0Var, i0Var);
            }
            if (i2 == 2) {
                return new z7.m0(e0Var, i0Var);
            }
        } else {
            if (i2 == 0) {
                return new z7.x0(e0Var, i0Var);
            }
            if (i2 == 1) {
                return new z7.a1(e0Var, i0Var);
            }
            if (i2 == 2) {
                return new z7.d1(e0Var, i0Var);
            }
        }
        throw new c7.i("Unsupported property: " + i0Var, 3);
    }

    @Override // f8.s
    public f8.s r() {
        return this;
    }

    @Override // f8.s
    public f8.s s(f8.n nVar) {
        q7.k.e(nVar, "visibility");
        return this;
    }

    @Override // f8.l
    public Object t(i8.i iVar, Object obj) {
        return y(iVar, obj);
    }

    public String toString() {
        switch (this.f7325f) {
            case com.google.protobuf.x0.TARGETS_FIELD_NUMBER /* 19 */:
                StringBuilder sb2 = new StringBuilder();
                s8.r rVar = (s8.r) this.f7326g;
                sb2.append(rVar);
                sb2.append(": ");
                sb2.append(((Map) n7.b.q(rVar.f9601n, s8.r.f9598r[0])).keySet());
                return sb2.toString();
            default:
                return super.toString();
        }
    }

    @Override // f8.l
    public Object u(i8.j0 j0Var, Object obj) {
        return y(j0Var, obj);
    }

    @Override // u9.m
    public void unlock() {
        ((ReentrantLock) this.f7326g).unlock();
    }

    @Override // f8.s
    public f8.s v(i8.v vVar) {
        return this;
    }

    @Override // f8.s
    public f8.s w(v9.v vVar) {
        q7.k.e(vVar, "type");
        return this;
    }

    @Override // f8.s
    public f8.s x(f8.j jVar) {
        q7.k.e(jVar, "owner");
        return this;
    }

    @Override // f8.l
    public Object y(f8.t tVar, Object obj) {
        return new z7.g0((z7.e0) this.f7326g, tVar);
    }

    @Override // f8.s
    public f8.s z(int i2) {
        m.x.t(i2, "modality");
        return this;
    }

    public /* synthetic */ d0(int i2, boolean z4) {
        this.f7325f = i2;
    }

    public d0(Context context, int i2) {
        this.f7325f = i2;
        switch (i2) {
            case 17:
                this.f7326g = context.getApplicationContext();
                return;
            default:
                q7.k.e(context, "context");
                SharedPreferences sharedPreferencesO = a.o(context);
                if (sharedPreferencesO == null) {
                    try {
                        context.deleteSharedPreferences("openclaw_device_tokens");
                    } catch (Throwable th) {
                        w7.e0.n(th);
                    }
                    try {
                        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                        keyStore.load(null);
                        if (keyStore.containsAlias("_androidx_security_master_key_")) {
                            keyStore.deleteEntry("_androidx_security_master_key_");
                        }
                    } catch (Throwable th2) {
                        w7.e0.n(th2);
                    }
                    sharedPreferencesO = a.o(context);
                    if (sharedPreferencesO == null) {
                        throw new IllegalStateException("EncryptedSharedPreferences re-create failed after reset");
                    }
                }
                this.f7326g = sharedPreferencesO;
                return;
        }
    }

    public d0(int i2) {
        this.f7325f = i2;
        switch (i2) {
            case 3:
                this.f7326g = new Region();
                break;
            case 8:
                this.f7326g = new AtomicInteger(0);
                break;
            case 9:
                this.f7326g = la.k0.c(s2.j0.f9395b);
                break;
            case 10:
                this.f7326g = new u0.a();
                break;
            case 12:
                this.f7326g = new h4.n(29, false);
                break;
            default:
                this.f7326g = new d0.e(new p.h[16]);
                break;
        }
    }
}
