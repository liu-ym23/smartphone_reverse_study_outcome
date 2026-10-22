package N2;

import android.content.Context;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: h, reason: collision with root package name */
    public static volatile f f4232h = null;

    /* renamed from: i, reason: collision with root package name */
    public static boolean f4233i = false;

    /* renamed from: f, reason: collision with root package name */
    public g f4239f;

    /* renamed from: g, reason: collision with root package name */
    public e f4240g;

    /* renamed from: a, reason: collision with root package name */
    public final a f4234a = new a("udid");

    /* renamed from: b, reason: collision with root package name */
    public final a f4235b = new a("oaid");

    /* renamed from: d, reason: collision with root package name */
    public final a f4237d = new a("vaid");

    /* renamed from: c, reason: collision with root package name */
    public final a f4236c = new a("aaid");

    /* renamed from: e, reason: collision with root package name */
    public final c f4238e = new c();

    public static d a(Cursor cursor) {
        d dVar = new d(null, 0);
        if (cursor.isClosed()) {
            f("parseValue fail, cursor is closed.");
            return dVar;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex("value");
        if (columnIndex >= 0) {
            dVar.f4229a = cursor.getString(columnIndex);
        } else {
            f("parseValue fail, index < 0.");
        }
        int columnIndex2 = cursor.getColumnIndex("code");
        if (columnIndex2 >= 0) {
            dVar.f4230b = cursor.getInt(columnIndex2);
        } else {
            f("parseCode fail, index < 0.");
        }
        int columnIndex3 = cursor.getColumnIndex("expired");
        if (columnIndex3 >= 0) {
            dVar.f4231c = cursor.getLong(columnIndex3);
            return dVar;
        }
        f("parseExpired fail, index < 0.");
        return dVar;
    }

    public static final f b() {
        if (f4232h == null) {
            synchronized (f.class) {
                try {
                    if (f4232h == null) {
                        f4232h = new f();
                    }
                } finally {
                }
            }
        }
        return f4232h;
    }

    public static void f(String str) {
        if (f4233i) {
            Log.d("OpenIdManager", str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final N2.g c(android.content.Context r8) {
        /*
            r7 = this;
            N2.g r0 = r7.f4239f
            if (r0 == 0) goto L9
            boolean r1 = r0.f4243c
            if (r1 == 0) goto L9
            return r0
        L9:
            android.content.pm.PackageManager r8 = r8.getPackageManager()
            r0 = 0
            if (r8 != 0) goto L16
            java.lang.String r7 = "makeSureProviderData, packageManager is null"
            f(r7)
            return r0
        L16:
            java.lang.String r1 = "com.stepos.secureservice.openidsdk"
            r2 = 0
            android.content.pm.ProviderInfo r1 = r8.resolveContentProvider(r1, r2)
            java.lang.String r3 = "fetchProviderPackageName, providerInfoFlags is not system"
            java.lang.String r4 = "fetchProviderPackageName, providerInfo is null"
            r5 = 1
            if (r1 != 0) goto L29
            f(r4)
        L27:
            r1 = r0
            goto L36
        L29:
            android.content.pm.ApplicationInfo r6 = r1.applicationInfo
            int r6 = r6.flags
            r6 = r6 & r5
            if (r6 != 0) goto L34
            f(r3)
            goto L27
        L34:
            java.lang.String r1 = r1.packageName
        L36:
            boolean r6 = android.text.TextUtils.isEmpty(r1)
            if (r6 == 0) goto L5c
            java.lang.String r1 = "com.stepos.openidsdk"
            android.content.pm.ProviderInfo r8 = r8.resolveContentProvider(r1, r2)
            if (r8 != 0) goto L48
            f(r4)
            goto L55
        L48:
            android.content.pm.ApplicationInfo r1 = r8.applicationInfo
            int r1 = r1.flags
            r1 = r1 & r5
            if (r1 != 0) goto L53
            f(r3)
            goto L55
        L53:
            java.lang.String r0 = r8.packageName
        L55:
            java.lang.String r8 = "makeSureProviderData, use SAFE_AUTHORITIES"
            f(r8)
            r1 = r0
            goto L62
        L5c:
            java.lang.String r8 = "makeSureProviderData, use SECURESERVICE_AUTHORITIES"
            f(r8)
            r2 = r5
        L62:
            N2.g r8 = new N2.g
            r8.<init>(r1, r2)
            r7.f4239f = r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: N2.f.c(android.content.Context):N2.g");
    }

    public final String d(Context context, a aVar) throws Throwable {
        Throwable th;
        Exception exc;
        String str;
        Cursor cursorQuery;
        Cursor cursor = null;
        str = null;
        str = null;
        String str2 = null;
        cursor = null;
        if (aVar == null) {
            f("getId, openId = null.");
            return null;
        }
        if (aVar.a()) {
            return aVar.f4225b;
        }
        if (!g(context, true)) {
            f("getId, isSupported = false.");
            return null;
        }
        f("queryId : " + aVar.f4226c);
        g gVarC = c(context);
        if (gVarC == null || !gVarC.f4243c) {
            return null;
        }
        try {
            try {
                cursorQuery = context.getContentResolver().query(Uri.parse(gVarC.f4242b), null, null, new String[]{aVar.f4226c}, null);
            } catch (Exception e6) {
                exc = e6;
                str = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            if (cursorQuery != null) {
                d dVarA = a(cursorQuery);
                str2 = dVarA.f4229a;
                aVar.e(str2);
                aVar.d(dVarA.f4231c);
                aVar.c(dVarA.f4230b);
                f(aVar.f4226c + " errorCode : " + aVar.f4227d);
                if (dVarA.f4230b != 1000) {
                    e(context, gVarC.f4241a);
                    if (!g(context, false)) {
                        f("not support, forceQuery isSupported: " + g(context, true));
                    }
                }
            } else if (g(context, false)) {
                f("forceQuery isSupported : " + g(context, true));
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return str2;
        } catch (Exception e7) {
            exc = e7;
            str = str2;
            cursor = cursorQuery;
            f("queryId, Exception : " + exc.getMessage());
            if (cursor != null) {
                cursor.close();
            }
            return str;
        } catch (Throwable th3) {
            th = th3;
            cursor = cursorQuery;
            if (cursor == null) {
                throw th;
            }
            cursor.close();
            throw th;
        }
    }

    public final synchronized void e(Context context, String str) {
        if (this.f4240g != null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.stepos.openid.ACTION_OPEN_ID_CHANGE");
        e eVar = new e();
        this.f4240g = eVar;
        context.registerReceiver(eVar, intentFilter, str, null);
        f("registerReceivers, permission : " + str);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(android.content.Context r10, boolean r11) {
        /*
            r9 = this;
            N2.c r0 = r9.f4238e
            boolean r0 = r0.a()
            if (r0 == 0) goto L11
            if (r11 != 0) goto L11
            N2.c r9 = r9.f4238e
            boolean r9 = r9.b()
            return r9
        L11:
            N2.g r11 = r9.c(r10)
            r1 = 0
            if (r11 == 0) goto L9c
            boolean r11 = r11.f4243c
            if (r11 == 0) goto L9c
            java.lang.String r11 = "querySupport, Exception : "
            java.lang.String r0 = "querySupport version : 1.0.0"
            f(r0)
            N2.g r0 = r9.c(r10)
            if (r0 == 0) goto L86
            boolean r2 = r0.f4243c
            if (r2 == 0) goto L86
            r2 = 0
            java.lang.String r0 = r0.f4242b     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5f
            android.net.Uri r4 = android.net.Uri.parse(r0)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5f
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5f
            java.lang.String r10 = "supported"
            java.lang.String[] r7 = new java.lang.String[]{r10}     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5f
            r8 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5f
            if (r2 == 0) goto L67
            N2.d r10 = a(r2)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5f
            int r0 = r10.f4230b     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5f
            r3 = 1000(0x3e8, float:1.401E-42)
            if (r3 != r0) goto L62
            java.lang.String r0 = "0"
            java.lang.String r10 = r10.f4229a     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5f
            boolean r10 = r0.equals(r10)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5f
            if (r10 == 0) goto L63
            goto L62
        L5c:
            r0 = move-exception
            r9 = r0
            goto L80
        L5f:
            r0 = move-exception
            r10 = r0
            goto L6a
        L62:
            r1 = 1
        L63:
            r2.close()
            goto L86
        L67:
            if (r2 == 0) goto L86
            goto L7f
        L6a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5c
            r0.<init>(r11)     // Catch: java.lang.Throwable -> L5c
            java.lang.String r10 = r10.getMessage()     // Catch: java.lang.Throwable -> L5c
            r0.append(r10)     // Catch: java.lang.Throwable -> L5c
            java.lang.String r10 = r0.toString()     // Catch: java.lang.Throwable -> L5c
            f(r10)     // Catch: java.lang.Throwable -> L5c
            if (r2 == 0) goto L86
        L7f:
            goto L63
        L80:
            if (r2 == 0) goto L85
            r2.close()
        L85:
            throw r9
        L86:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "query support, result : "
            r10.<init>(r11)
            r10.append(r1)
            java.lang.String r10 = r10.toString()
            f(r10)
            N2.c r9 = r9.f4238e
            r9.c(r1)
        L9c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: N2.f.g(android.content.Context, boolean):boolean");
    }
}
