package a7;

import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import c8.h;
import com.google.crypto.tink.shaded.protobuf.b0;
import com.google.crypto.tink.shaded.protobuf.n;
import d7.a0;
import d7.r;
import d7.t;
import f4.k1;
import f4.o1;
import f4.q1;
import f4.r1;
import f4.v1;
import f4.y0;
import f4.z0;
import f8.n0;
import f8.q0;
import fa.p;
import g8.j;
import i5.l;
import j9.q;
import j9.s;
import java.io.ByteArrayInputStream;
import java.io.CharConversionException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.ProviderException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import n7.m;
import nb.i;
import r9.x;
import r9.y;
import v9.h0;
import v9.i0;
import v9.m0;
import v9.p0;
import v9.v;
import v9.z;
import x8.k;
import z8.u0;

/* loaded from: classes.dex */
public final class g implements k {

    /* renamed from: n, reason: collision with root package name */
    public static volatile g f416n;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f417f;

    /* renamed from: g, reason: collision with root package name */
    public Object f418g;

    /* renamed from: h, reason: collision with root package name */
    public Object f419h;

    /* renamed from: i, reason: collision with root package name */
    public Object f420i;

    /* renamed from: j, reason: collision with root package name */
    public Object f421j;

    /* renamed from: k, reason: collision with root package name */
    public Object f422k;

    /* renamed from: l, reason: collision with root package name */
    public Object f423l;

    /* renamed from: m, reason: collision with root package name */
    public Object f424m;

    public g(int i2) {
        this.f417f = i2;
        switch (i2) {
            case 3:
                this.f418g = null;
                this.f419h = null;
                this.f420i = null;
                this.f421j = null;
                this.f422k = null;
                this.f423l = null;
                break;
            default:
                Log.i("OpenIdManager", "OpenIdManager create");
                this.f418g = new a("udid");
                this.f419h = new a("oaid");
                this.f421j = new a("vaid");
                this.f420i = new a("aaid");
                this.f422k = new d(0);
                break;
        }
    }

    public static e c(Cursor cursor) {
        e eVar = new e(0);
        eVar.f415d = null;
        eVar.f413b = 0;
        eVar.f414c = System.currentTimeMillis() + 86400000;
        if (!cursor.isClosed()) {
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex("value");
            if (columnIndex >= 0) {
                eVar.f415d = cursor.getString(columnIndex);
            }
            int columnIndex2 = cursor.getColumnIndex("code");
            if (columnIndex2 >= 0) {
                eVar.f413b = cursor.getInt(columnIndex2);
            }
            int columnIndex3 = cursor.getColumnIndex("expired");
            if (columnIndex3 >= 0) {
                eVar.f414c = cursor.getLong(columnIndex3);
            }
        }
        return eVar;
    }

    public static final g d() {
        if (f416n == null) {
            synchronized (g.class) {
                try {
                    if (f416n == null) {
                        f416n = new g(0);
                    }
                } finally {
                }
            }
        }
        return f416n;
    }

    public static z j(z zVar, v vVar) {
        h hVarR = m.r(zVar);
        j annotations = zVar.getAnnotations();
        v vVarV = s7.a.v(zVar);
        List listT = s7.a.t(zVar);
        List listL0 = r.L0(s7.a.A(zVar));
        ArrayList arrayList = new ArrayList(t.A0(listL0, 10));
        Iterator it = listL0.iterator();
        while (it.hasNext()) {
            arrayList.add(((p0) it.next()).b());
        }
        return s7.a.m(hVarR, annotations, vVarV, listT, arrayList, vVar, true).I0(zVar.F0());
    }

    public static byte[] q(Context context, String str, String str2) throws CharConversionException {
        if (str == null) {
            throw new IllegalArgumentException("keysetName cannot be null");
        }
        Context applicationContext = context.getApplicationContext();
        try {
            String string = (str2 == null ? PreferenceManager.getDefaultSharedPreferences(applicationContext) : applicationContext.getSharedPreferences(str2, 0)).getString(str, null);
            if (string == null) {
                return null;
            }
            return a.a.o(string);
        } catch (ClassCastException | IllegalArgumentException unused) {
            throw new CharConversionException(a1.a.j("can't read keyset; the pref value ", str, " is not a valid hex string"));
        }
    }

    public static t3.f r(byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            r1 r1VarC = r1.C(byteArrayInputStream, n.a());
            byteArrayInputStream.close();
            return new t3.f(3, (o1) ((r1) l.w(r1VarC).f4687g).u());
        } catch (Throwable th) {
            byteArrayInputStream.close();
            throw th;
        }
    }

    public static final ArrayList v(z8.p0 p0Var, g gVar) {
        List list = p0Var.f12302i;
        q7.k.d(list, "argumentList");
        z8.p0 p0VarZ = a.a.Z(p0Var, (b9.g) ((r9.k) gVar.f418g).f9073i);
        Iterable iterableV = p0VarZ != null ? v(p0VarZ, gVar) : null;
        if (iterableV == null) {
            iterableV = d7.z.f2978f;
        }
        return r.c1(list, iterableV);
    }

    public static i0 w(List list, j jVar, m0 m0Var, f8.j jVar2) {
        ArrayList arrayList = new ArrayList(t.A0(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((v9.k) ((h0) it.next())).a(jVar));
        }
        ArrayList arrayListB0 = t.B0(arrayList);
        i0.f10557g.getClass();
        return nb.f.q(arrayListB0);
    }

    public static final f8.e y(g gVar, z8.p0 p0Var, int i2) {
        r9.k kVar = (r9.k) gVar.f418g;
        e9.b bVarS = i.s((b9.f) kVar.f9071g, i2);
        p pVarT0 = fa.l.t0(fa.l.s0(p0Var, new x(gVar, 2)), r9.z.f9112h);
        ArrayList arrayList = new ArrayList();
        Iterator it = pVarT0.f3642a.iterator();
        while (it.hasNext()) {
            arrayList.add(pVarT0.f3643b.invoke(it.next()));
        }
        int iP0 = fa.l.p0(fa.l.s0(bVarS, y.f9111n));
        while (arrayList.size() < iP0) {
            arrayList.add(0);
        }
        return ((r9.i) kVar.f9070f).f9058l.I(bVarS, arrayList);
    }

    public void A(Context context, String str, String str2) {
        if (context == null) {
            throw new IllegalArgumentException("need an Android context");
        }
        this.f418g = context;
        this.f419h = str;
        this.f420i = str2;
    }

    public c a(Context context) {
        c cVar = (c) this.f423l;
        if (cVar != null && cVar.f408b) {
            return cVar;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            for (int i2 = 0; i2 < 4; i2++) {
                b bVar = b.f402e[i2];
                ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(bVar.f403a, 0);
                String str = (providerInfoResolveContentProvider == null || (providerInfoResolveContentProvider.applicationInfo.flags & 1) == 0) ? null : providerInfoResolveContentProvider.packageName;
                if (!TextUtils.isEmpty(str)) {
                    c cVar2 = new c(str, bVar);
                    this.f423l = cVar2;
                    return cVar2;
                }
            }
        }
        return null;
    }

    @Override // x8.k
    public void b() {
        a4.p pVar = (a4.p) this.f420i;
        e9.b bVar = (e9.b) this.f422k;
        HashMap map = (HashMap) this.f419h;
        q7.k.e(map, "arguments");
        boolean z4 = false;
        if (bVar.equals(b8.a.f1548b)) {
            Object obj = map.get(e9.f.e("value"));
            s sVar = obj instanceof s ? (s) obj : null;
            if (sVar != null) {
                Object obj2 = sVar.f5408a;
                q qVar = obj2 instanceof q ? (q) obj2 : null;
                if (qVar != null) {
                    z4 = pVar.z(qVar.f5416a.f5406a);
                }
            }
        }
        if (z4 || pVar.z(bVar)) {
            return;
        }
        ((List) this.f423l).add(new g8.d(((f8.e) this.f421j).k(), map, (n0) this.f424m));
    }

    @Override // x8.k
    public void e(e9.f fVar, Object obj) {
        ((HashMap) this.f419h).put(fVar, a4.p.t((a4.p) this.f418g, fVar, obj));
    }

    public synchronized void f(Context context, c cVar) {
        boolean z4;
        if (((f) this.f424m) == null && (z4 = cVar.f408b)) {
            String str = z4 ? ((b) cVar.f409c).f406d : null;
            String str2 = z4 ? ((b) cVar.f409c).f405c : null;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(str);
                f fVar = new f();
                this.f424m = fVar;
                context.registerReceiver(fVar, intentFilter, str2, null);
            }
        }
    }

    @Override // x8.k
    public void g(e9.f fVar, e9.b bVar, e9.f fVar2) {
        ((HashMap) this.f419h).put(fVar, new j9.i(bVar, fVar2));
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean h(android.content.Context r11, boolean r12) {
        /*
            r10 = this;
            java.lang.Object r0 = r10.f422k
            r1 = r0
            a7.d r1 = (a7.d) r1
            java.lang.Object r0 = r1.f411g
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            if (r0 == 0) goto L12
            if (r12 != 0) goto L12
            boolean r10 = r0.booleanValue()
            return r10
        L12:
            a7.c r12 = r10.a(r11)
            r2 = 0
            if (r12 == 0) goto L80
            boolean r12 = r12.f408b
            if (r12 == 0) goto L80
            a7.c r10 = r10.a(r11)
            if (r10 == 0) goto L7a
            boolean r12 = r10.f408b
            if (r12 == 0) goto L7a
            r3 = 0
            if (r12 == 0) goto L31
            java.lang.Object r10 = r10.f409c     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            a7.b r10 = (a7.b) r10     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            java.lang.String r10 = r10.f404b     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            goto L32
        L31:
            r10 = r3
        L32:
            android.net.Uri r5 = android.net.Uri.parse(r10)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            android.content.ContentResolver r4 = r11.getContentResolver()     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            java.lang.String r10 = "supported"
            java.lang.String[] r8 = new java.lang.String[]{r10}     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            r9 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r3 = r4.query(r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            if (r3 == 0) goto L6b
            a7.e r10 = c(r3)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            int r11 = r10.f413b     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            r12 = 1000(0x3e8, float:1.401E-42)
            if (r12 != r11) goto L66
            java.lang.String r11 = "0"
            java.lang.Object r10 = r10.f415d     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            java.lang.String r10 = (java.lang.String) r10     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            boolean r10 = r11.equals(r10)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            if (r10 == 0) goto L67
            goto L66
        L60:
            r0 = move-exception
            r10 = r0
            goto L74
        L63:
            r0 = move-exception
            r10 = r0
            goto L6e
        L66:
            r2 = 1
        L67:
            r3.close()
            goto L7a
        L6b:
            if (r3 == 0) goto L7a
            goto L73
        L6e:
            r10.getMessage()     // Catch: java.lang.Throwable -> L60
            if (r3 == 0) goto L7a
        L73:
            goto L67
        L74:
            if (r3 == 0) goto L79
            r3.close()
        L79:
            throw r10
        L7a:
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r2)
            r1.f411g = r10
        L80:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: a7.g.h(android.content.Context, boolean):boolean");
    }

    public synchronized z3.a i() {
        z3.a aVar;
        try {
            if (((String) this.f419h) == null) {
                throw new IllegalArgumentException("keysetName cannot be null");
            }
            synchronized (z3.a.f11799b) {
                try {
                    byte[] bArrQ = q((Context) this.f418g, (String) this.f419h, (String) this.f420i);
                    if (bArrQ == null) {
                        if (((String) this.f421j) != null) {
                            this.f422k = t();
                        }
                        this.f424m = m();
                    } else if (((String) this.f421j) != null) {
                        this.f424m = s(bArrQ);
                    } else {
                        this.f424m = r(bArrQ);
                    }
                    aVar = new z3.a(this);
                } finally {
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return aVar;
    }

    @Override // x8.k
    public void k(e9.f fVar, j9.f fVar2) {
        ((HashMap) this.f419h).put(fVar, new s(new q(fVar2)));
    }

    @Override // x8.k
    public x8.l l(e9.f fVar) {
        return new i5.f((a4.p) this.f418g, fVar, this);
    }

    public t3.f m() throws GeneralSecurityException, InterruptedException, IOException {
        if (((t3.g) this.f423l) == null) {
            throw new GeneralSecurityException("cannot read or generate keyset");
        }
        t3.f fVar = new t3.f(3, r1.B());
        t3.g gVar = (t3.g) this.f423l;
        synchronized (fVar) {
            fVar.a(gVar.f9714a);
        }
        int iZ = t3.p.a((r1) fVar.c().f4687g).x().z();
        synchronized (fVar) {
            for (int i2 = 0; i2 < ((r1) ((o1) fVar.f9713b).f2287g).y(); i2++) {
                try {
                    q1 q1VarX = ((r1) ((o1) fVar.f9713b).f2287g).x(i2);
                    if (q1VarX.A() == iZ) {
                        if (!q1VarX.C().equals(k1.ENABLED)) {
                            throw new GeneralSecurityException("cannot set key as primary because it's not enabled: " + iZ);
                        }
                        o1 o1Var = (o1) fVar.f9713b;
                        o1Var.d();
                        r1.v((r1) o1Var.f2287g, iZ);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            throw new GeneralSecurityException("key not found: " + iZ);
        }
        Context context = (Context) this.f418g;
        String str = (String) this.f419h;
        String str2 = (String) this.f420i;
        if (str == null) {
            throw new IllegalArgumentException("keysetName cannot be null");
        }
        Context applicationContext = context.getApplicationContext();
        SharedPreferences.Editor editorEdit = str2 == null ? PreferenceManager.getDefaultSharedPreferences(applicationContext).edit() : applicationContext.getSharedPreferences(str2, 0).edit();
        if (((z3.b) this.f422k) != null) {
            l lVarC = fVar.c();
            z3.b bVar = (z3.b) this.f422k;
            byte[] bArr = new byte[0];
            r1 r1Var = (r1) lVarC.f4687g;
            byte[] bArrA = bVar.a(r1Var.d(), bArr);
            try {
                if (!r1.D(bVar.b(bArrA, bArr), n.a()).equals(r1Var)) {
                    throw new GeneralSecurityException("cannot encrypt keyset");
                }
                y0 y0VarY = z0.y();
                com.google.crypto.tink.shaded.protobuf.g gVarH = com.google.crypto.tink.shaded.protobuf.h.h(bArrA, 0, bArrA.length);
                y0VarY.d();
                z0.v((z0) y0VarY.f2287g, gVarH);
                v1 v1VarA = t3.p.a(r1Var);
                y0VarY.d();
                z0.w((z0) y0VarY.f2287g, v1VarA);
                if (!editorEdit.putString(str, a.a.J(((z0) y0VarY.a()).d())).commit()) {
                    throw new IOException("Failed to write to SharedPreferences");
                }
            } catch (b0 unused) {
                throw new GeneralSecurityException("invalid keyset, corrupted key material");
            }
        } else if (!editorEdit.putString(str, a.a.J(((r1) fVar.c().f4687g).d())).commit()) {
            throw new IOException("Failed to write to SharedPreferences");
        }
        return fVar;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.Map] */
    public List n() {
        return r.m1(this.f424m.values());
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.util.Map] */
    public q0 o(int i2) {
        q0 q0Var = (q0) this.f424m.get(Integer.valueOf(i2));
        if (q0Var != null) {
            return q0Var;
        }
        g gVar = (g) this.f419h;
        if (gVar != null) {
            return gVar.o(i2);
        }
        return null;
    }

    @Override // x8.k
    public k p(e9.b bVar, e9.f fVar) {
        ArrayList arrayList = new ArrayList();
        return new a3.b(((a4.p) this.f418g).A(bVar, n0.f3487b, arrayList), this, fVar, arrayList);
    }

    public t3.f s(byte[] bArr) {
        try {
            this.f422k = new z3.c().c((String) this.f421j);
            try {
                return new t3.f(3, (o1) ((r1) l.J(new t3.f(1, new ByteArrayInputStream(bArr)), (z3.b) this.f422k).f4687g).u());
            } catch (IOException | GeneralSecurityException e10) {
                try {
                    return r(bArr);
                } catch (IOException unused) {
                    throw e10;
                }
            }
        } catch (GeneralSecurityException | ProviderException e11) {
            try {
                t3.f fVarR = r(bArr);
                Log.w("a", "cannot use Android Keystore, it'll be disabled", e11);
                return fVarR;
            } catch (IOException unused2) {
                throw e11;
            }
        }
    }

    public z3.b t() throws KeyStoreException {
        z3.c cVar = new z3.c();
        try {
            boolean zA = z3.c.a((String) this.f421j);
            try {
                return cVar.c((String) this.f421j);
            } catch (GeneralSecurityException | ProviderException e10) {
                if (!zA) {
                    throw new KeyStoreException(a1.a.j("the master key ", (String) this.f421j, " exists but is unusable"), e10);
                }
                Log.w("a", "cannot use Android Keystore, it'll be disabled", e10);
                return null;
            }
        } catch (GeneralSecurityException | ProviderException e11) {
            Log.w("a", "cannot use Android Keystore, it'll be disabled", e11);
            return null;
        }
    }

    public String toString() {
        String str;
        switch (this.f417f) {
            case 1:
                StringBuilder sb2 = new StringBuilder();
                sb2.append((String) this.f420i);
                g gVar = (g) this.f419h;
                if (gVar == null) {
                    str = "";
                } else {
                    str = ". Child of " + ((String) gVar.f420i);
                }
                sb2.append(str);
                return sb2.toString();
            default:
                return super.toString();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x013e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public v9.z u(z8.p0 r26, boolean r27) {
        /*
            Method dump skipped, instructions count: 1046
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a7.g.u(z8.p0, boolean):v9.z");
    }

    public v x(z8.p0 p0Var) {
        r9.k kVar = (r9.k) this.f418g;
        q7.k.e(p0Var, "proto");
        if ((p0Var.f12301h & 2) != 2) {
            return u(p0Var, true);
        }
        String string = ((b9.f) kVar.f9071g).getString(p0Var.f12304k);
        z zVarU = u(p0Var, true);
        b9.g gVar = (b9.g) kVar.f9073i;
        int i2 = p0Var.f12301h;
        z8.p0 p0VarA = (i2 & 4) == 4 ? p0Var.f12305l : (i2 & 8) == 8 ? gVar.a(p0Var.f12306m) : null;
        q7.k.b(p0VarA);
        return ((r9.i) kVar.f9070f).f9056j.c(p0Var, string, zVarU, u(p0VarA, true));
    }

    public void z(String str) {
        if (!str.startsWith("android-keystore://")) {
            throw new IllegalArgumentException("key URI must start with android-keystore://");
        }
        this.f421j = str;
    }

    public g(r9.k kVar, g gVar, List list, String str, String str2) {
        Map linkedHashMap;
        this.f417f = 1;
        q7.k.e(list, "typeParameterProtos");
        q7.k.e(str, "debugName");
        this.f418g = kVar;
        this.f419h = gVar;
        this.f420i = str;
        this.f421j = str2;
        r9.i iVar = (r9.i) kVar.f9070f;
        this.f422k = iVar.f9047a.c(new x(this, 0));
        this.f423l = iVar.f9047a.c(new x(this, 1));
        if (list.isEmpty()) {
            linkedHashMap = a0.f2944f;
        } else {
            linkedHashMap = new LinkedHashMap();
            Iterator it = list.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                u0 u0Var = (u0) it.next();
                linkedHashMap.put(Integer.valueOf(u0Var.f12391i), new t9.t((r9.k) this.f418g, u0Var, i2));
                i2++;
            }
        }
        this.f424m = linkedHashMap;
    }

    public g(a4.p pVar, f8.e eVar, e9.b bVar, List list, n0 n0Var) {
        this.f417f = 2;
        this.f420i = pVar;
        this.f421j = eVar;
        this.f422k = bVar;
        this.f423l = list;
        this.f424m = n0Var;
        this.f418g = pVar;
        this.f419h = new HashMap();
    }
}
