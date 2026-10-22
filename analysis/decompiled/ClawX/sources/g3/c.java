package g3;

import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.emoji2.text.m;
import com.google.crypto.tink.shaded.protobuf.c0;
import com.google.crypto.tink.shaded.protobuf.h;
import com.google.crypto.tink.shaded.protobuf.i;
import com.google.crypto.tink.shaded.protobuf.o;
import java.io.ByteArrayInputStream;
import java.io.CharConversionException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.ProviderException;
import k2.c1;
import k2.e1;
import k2.f1;
import k2.j1;
import k2.m0;
import k2.n0;
import k2.y0;
import k4.z;
import m0.f;
import y1.g;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: h, reason: collision with root package name */
    public static volatile c f2953h;

    /* renamed from: a, reason: collision with root package name */
    public Object f2954a;

    /* renamed from: b, reason: collision with root package name */
    public Object f2955b;

    /* renamed from: c, reason: collision with root package name */
    public Object f2956c;
    public Object d;

    /* renamed from: e, reason: collision with root package name */
    public Object f2957e;

    /* renamed from: f, reason: collision with root package name */
    public Object f2958f;

    /* renamed from: g, reason: collision with root package name */
    public Object f2959g;

    public c(int i8) {
        switch (i8) {
            case 1:
                this.f2954a = null;
                this.f2955b = null;
                this.f2956c = null;
                this.d = null;
                this.f2957e = null;
                this.f2958f = null;
                break;
            default:
                this.f2954a = new a("udid");
                this.f2955b = new a("oaid");
                this.d = new a("vaid");
                this.f2956c = new a("aaid");
                this.f2957e = new m();
                break;
        }
    }

    public static com.google.crypto.tink.shaded.protobuf.d a(Cursor cursor) {
        com.google.crypto.tink.shaded.protobuf.d dVar = new com.google.crypto.tink.shaded.protobuf.d(1);
        dVar.d = null;
        dVar.f1441b = 0;
        dVar.f1442c = System.currentTimeMillis() + 86400000;
        if (!cursor.isClosed()) {
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex("value");
            if (columnIndex >= 0) {
                dVar.d = cursor.getString(columnIndex);
            }
            int columnIndex2 = cursor.getColumnIndex("code");
            if (columnIndex2 >= 0) {
                dVar.f1441b = cursor.getInt(columnIndex2);
            }
            int columnIndex3 = cursor.getColumnIndex("expired");
            if (columnIndex3 >= 0) {
                dVar.f1442c = cursor.getLong(columnIndex3);
            }
        }
        return dVar;
    }

    public static final c b() {
        if (f2953h == null) {
            synchronized (c.class) {
                try {
                    if (f2953h == null) {
                        f2953h = new c(0);
                    }
                } finally {
                }
            }
        }
        return f2953h;
    }

    public static byte[] h(Context context, String str, String str2) throws CharConversionException {
        if (str == null) {
            throw new IllegalArgumentException("keysetName cannot be null");
        }
        Context applicationContext = context.getApplicationContext();
        try {
            String string = (str2 == null ? PreferenceManager.getDefaultSharedPreferences(applicationContext) : applicationContext.getSharedPreferences(str2, 0)).getString(str, null);
            if (string == null) {
                return null;
            }
            return z.n(string);
        } catch (ClassCastException | IllegalArgumentException unused) {
            throw new CharConversionException(f.d("can't read keyset; the pref value ", str, " is not a valid hex string"));
        }
    }

    public static y1.f i(byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            f1 f1VarD = f1.D(byteArrayInputStream, o.a());
            byteArrayInputStream.close();
            return new y1.f(3, (c1) ((f1) a4.d.p(f1VarD).f96b).v());
        } catch (Throwable th) {
            byteArrayInputStream.close();
            throw th;
        }
    }

    public d c(Context context) {
        d dVar = (d) this.f2958f;
        if (dVar != null && dVar.f2962c) {
            return dVar;
        }
        PackageManager packageManager = context.getPackageManager();
        String str = null;
        if (packageManager == null) {
            return null;
        }
        boolean z = false;
        ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider("com.flyme.secureservice.openidsdk", 0);
        String str2 = (providerInfoResolveContentProvider == null || (providerInfoResolveContentProvider.applicationInfo.flags & 1) == 0) ? null : providerInfoResolveContentProvider.packageName;
        if (TextUtils.isEmpty(str2)) {
            ProviderInfo providerInfoResolveContentProvider2 = packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0);
            if (providerInfoResolveContentProvider2 != null && (providerInfoResolveContentProvider2.applicationInfo.flags & 1) != 0) {
                str = providerInfoResolveContentProvider2.packageName;
            }
            str2 = str;
        } else {
            z = true;
        }
        d dVar2 = new d(str2, z);
        this.f2958f = dVar2;
        return dVar2;
    }

    public synchronized void d(Context context, String str) {
        if (((b) this.f2959g) != null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
        b bVar = new b();
        this.f2959g = bVar;
        context.registerReceiver(bVar, intentFilter, str, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean e(android.content.Context r10, boolean r11) {
        /*
            r9 = this;
            java.lang.Object r0 = r9.f2957e
            r1 = r0
            androidx.emoji2.text.m r1 = (androidx.emoji2.text.m) r1
            java.lang.Object r0 = r1.f621a
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            if (r0 == 0) goto L12
            if (r11 != 0) goto L12
            boolean r9 = r0.booleanValue()
            return r9
        L12:
            g3.d r11 = r9.c(r10)
            r2 = 0
            if (r11 == 0) goto L78
            boolean r11 = r11.f2962c
            if (r11 == 0) goto L78
            g3.d r9 = r9.c(r10)
            if (r9 == 0) goto L72
            boolean r11 = r9.f2962c
            if (r11 == 0) goto L72
            r11 = 0
            java.lang.String r9 = r9.f2961b     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5b
            android.net.Uri r4 = android.net.Uri.parse(r9)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5b
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5b
            java.lang.String r9 = "supported"
            java.lang.String[] r7 = new java.lang.String[]{r9}     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5b
            r8 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r11 = r3.query(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5b
            if (r11 == 0) goto L63
            com.google.crypto.tink.shaded.protobuf.d r9 = a(r11)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5b
            int r10 = r9.f1441b     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5b
            r0 = 1000(0x3e8, float:1.401E-42)
            if (r0 != r10) goto L5e
            java.lang.String r10 = "0"
            java.lang.Object r9 = r9.d     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5b
            java.lang.String r9 = (java.lang.String) r9     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5b
            boolean r9 = r10.equals(r9)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5b
            if (r9 == 0) goto L5f
            goto L5e
        L58:
            r0 = move-exception
            r9 = r0
            goto L6c
        L5b:
            r0 = move-exception
            r9 = r0
            goto L66
        L5e:
            r2 = 1
        L5f:
            r11.close()
            goto L72
        L63:
            if (r11 == 0) goto L72
            goto L6b
        L66:
            r9.getMessage()     // Catch: java.lang.Throwable -> L58
            if (r11 == 0) goto L72
        L6b:
            goto L5f
        L6c:
            if (r11 == 0) goto L71
            r11.close()
        L71:
            throw r9
        L72:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r2)
            r1.f621a = r9
        L78:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: g3.c.e(android.content.Context, boolean):boolean");
    }

    public synchronized e2.a f() {
        e2.a aVar;
        try {
            if (((String) this.f2955b) == null) {
                throw new IllegalArgumentException("keysetName cannot be null");
            }
            synchronized (e2.a.f2348b) {
                try {
                    byte[] bArrH = h((Context) this.f2954a, (String) this.f2955b, (String) this.f2956c);
                    if (bArrH == null) {
                        if (((String) this.d) != null) {
                            this.f2957e = k();
                        }
                        this.f2959g = g();
                    } else if (((String) this.d) != null) {
                        this.f2959g = j(bArrH);
                    } else {
                        this.f2959g = i(bArrH);
                    }
                    aVar = new e2.a(this);
                } finally {
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return aVar;
    }

    public y1.f g() throws GeneralSecurityException, InterruptedException, IOException {
        if (((g) this.f2958f) == null) {
            throw new GeneralSecurityException("cannot read or generate keyset");
        }
        y1.f fVar = new y1.f(3, f1.C());
        g gVar = (g) this.f2958f;
        synchronized (fVar) {
            fVar.a(gVar.f6319a);
        }
        int iA = y1.o.a((f1) fVar.c().f96b).y().A();
        synchronized (fVar) {
            for (int i8 = 0; i8 < ((f1) ((c1) fVar.f6318b).f1537b).z(); i8++) {
                try {
                    e1 e1VarY = ((f1) ((c1) fVar.f6318b).f1537b).y(i8);
                    if (e1VarY.B() == iA) {
                        if (!e1VarY.D().equals(y0.ENABLED)) {
                            throw new GeneralSecurityException("cannot set key as primary because it's not enabled: " + iA);
                        }
                        c1 c1Var = (c1) fVar.f6318b;
                        c1Var.e();
                        f1.w((f1) c1Var.f1537b, iA);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            throw new GeneralSecurityException("key not found: " + iA);
        }
        Context context = (Context) this.f2954a;
        String str = (String) this.f2955b;
        String str2 = (String) this.f2956c;
        if (str == null) {
            throw new IllegalArgumentException("keysetName cannot be null");
        }
        Context applicationContext = context.getApplicationContext();
        SharedPreferences.Editor editorEdit = str2 == null ? PreferenceManager.getDefaultSharedPreferences(applicationContext).edit() : applicationContext.getSharedPreferences(str2, 0).edit();
        if (((e2.b) this.f2957e) != null) {
            a4.d dVarC = fVar.c();
            e2.b bVar = (e2.b) this.f2957e;
            byte[] bArr = new byte[0];
            f1 f1Var = (f1) dVarC.f96b;
            byte[] bArrA = bVar.a(f1Var.e(), bArr);
            try {
                if (!f1.E(bVar.b(bArrA, bArr), o.a()).equals(f1Var)) {
                    throw new GeneralSecurityException("cannot encrypt keyset");
                }
                m0 m0VarZ = n0.z();
                h hVarH = i.h(0, bArrA.length, bArrA);
                m0VarZ.e();
                n0.w((n0) m0VarZ.f1537b, hVarH);
                j1 j1VarA = y1.o.a(f1Var);
                m0VarZ.e();
                n0.x((n0) m0VarZ.f1537b, j1VarA);
                if (!editorEdit.putString(str, z.q(((n0) m0VarZ.b()).e())).commit()) {
                    throw new IOException("Failed to write to SharedPreferences");
                }
            } catch (c0 unused) {
                throw new GeneralSecurityException("invalid keyset, corrupted key material");
            }
        } else if (!editorEdit.putString(str, z.q(((f1) fVar.c().f96b).e())).commit()) {
            throw new IOException("Failed to write to SharedPreferences");
        }
        return fVar;
    }

    public y1.f j(byte[] bArr) {
        try {
            this.f2957e = new e2.c().c((String) this.d);
            try {
                return new y1.f(3, (c1) ((f1) a4.d.G(new y1.f(1, new ByteArrayInputStream(bArr)), (e2.b) this.f2957e).f96b).v());
            } catch (IOException | GeneralSecurityException e9) {
                try {
                    return i(bArr);
                } catch (IOException unused) {
                    throw e9;
                }
            }
        } catch (GeneralSecurityException | ProviderException e10) {
            try {
                y1.f fVarI = i(bArr);
                Log.w("a", "cannot use Android Keystore, it'll be disabled", e10);
                return fVarI;
            } catch (IOException unused2) {
                throw e10;
            }
        }
    }

    public e2.b k() throws KeyStoreException {
        e2.c cVar = new e2.c();
        try {
            boolean zA = e2.c.a((String) this.d);
            try {
                return cVar.c((String) this.d);
            } catch (GeneralSecurityException | ProviderException e9) {
                if (!zA) {
                    throw new KeyStoreException(f.d("the master key ", (String) this.d, " exists but is unusable"), e9);
                }
                Log.w("a", "cannot use Android Keystore, it'll be disabled", e9);
                return null;
            }
        } catch (GeneralSecurityException | ProviderException e10) {
            Log.w("a", "cannot use Android Keystore, it'll be disabled", e10);
            return null;
        }
    }
}
