package K7;

import android.content.Context;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: i, reason: collision with root package name */
    public static volatile i f4118i = null;

    /* renamed from: j, reason: collision with root package name */
    public static boolean f4119j = false;

    /* renamed from: a, reason: collision with root package name */
    public final b f4120a;

    /* renamed from: b, reason: collision with root package name */
    public final b f4121b;

    /* renamed from: c, reason: collision with root package name */
    public final b f4122c;

    /* renamed from: d, reason: collision with root package name */
    public final b f4123d;

    /* renamed from: e, reason: collision with root package name */
    public final f f4124e;

    /* renamed from: f, reason: collision with root package name */
    public e f4125f;

    /* renamed from: g, reason: collision with root package name */
    public h f4126g;

    /* renamed from: h, reason: collision with root package name */
    public a f4127h;

    public i() {
        Log.i("OpenIdManager", "OpenIdManager create");
        this.f4120a = new b(Parameters.UDID);
        this.f4121b = new b(Parameters.OAID);
        this.f4123d = new b(Parameters.VAID);
        this.f4122c = new b(Parameters.AAID);
        this.f4124e = new f();
    }

    public static g b(Cursor cursor) {
        g gVar = new g(null, 0);
        if (cursor.isClosed()) {
            f("parseValue fail, cursor is closed.");
            return gVar;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex(UxipConstants.f30680s);
        if (columnIndex >= 0) {
            gVar.f4115a = cursor.getString(columnIndex);
        } else {
            f("parseValue fail, index < 0.");
        }
        int columnIndex2 = cursor.getColumnIndex("code");
        if (columnIndex2 >= 0) {
            gVar.f4116b = cursor.getInt(columnIndex2);
        } else {
            f("parseCode fail, index < 0.");
        }
        int columnIndex3 = cursor.getColumnIndex("expired");
        if (columnIndex3 >= 0) {
            gVar.f4117c = cursor.getLong(columnIndex3);
            return gVar;
        }
        f("parseExpired fail, index < 0.");
        return gVar;
    }

    public static final i c() {
        if (f4118i == null) {
            synchronized (i.class) {
                try {
                    if (f4118i == null) {
                        f4118i = new i();
                    }
                } finally {
                }
            }
        }
        return f4118i;
    }

    public static void f(String str) {
        if (f4119j) {
            Log.d("OpenIdManager", str);
        }
    }

    public static boolean g(e eVar) {
        return eVar != null && eVar.d();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x007e A[LOOP:0: B:11:0x001d->B:29:0x007e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0059 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final K7.e a(android.content.Context r9) {
        /*
            r8 = this;
            K7.e r0 = r8.f4125f
            boolean r0 = g(r0)
            if (r0 == 0) goto Lb
            K7.e r8 = r8.f4125f
            return r8
        Lb:
            android.content.pm.PackageManager r9 = r9.getPackageManager()
            r0 = 0
            if (r9 != 0) goto L18
            java.lang.String r8 = "makeSureProviderData, packageManager is null"
            f(r8)
            return r0
        L18:
            K7.d[] r1 = K7.d.f4106e
            int r2 = r1.length
            r3 = 0
            r4 = r3
        L1d:
            if (r4 >= r2) goto L81
            r5 = r1[r4]
            java.lang.String r6 = r5.f4107a
            if (r6 != 0) goto L2c
            java.lang.String r6 = "fetchProviderPackageName, packageManager or auth is null"
            f(r6)
        L2a:
            r6 = r0
            goto L53
        L2c:
            android.content.pm.ProviderInfo r6 = r9.resolveContentProvider(r6, r3)
            if (r6 != 0) goto L38
            java.lang.String r6 = "fetchProviderPackageName, providerInfo is null"
            f(r6)
            goto L2a
        L38:
            android.content.pm.ApplicationInfo r7 = r6.applicationInfo
            int r7 = r7.flags
            r7 = r7 & 1
            if (r7 != 0) goto L51
            java.lang.String r7 = "fetchProviderPackageName, providerInfoFlags is not system"
            f(r7)
            boolean r7 = K7.i.f4119j
            if (r7 == 0) goto L2a
            java.lang.String r7 = "fetchProviderPackageName, bypass FLAG_SYSTEM check due to debug"
            f(r7)
            java.lang.String r6 = r6.packageName
            goto L53
        L51:
            java.lang.String r6 = r6.packageName
        L53:
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r7 != 0) goto L7e
            K7.e r9 = new K7.e
            r9.<init>(r6, r5)
            r8.f4125f = r9
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r0 = "makeSureProviderData, authority="
            r9.<init>(r0)
            java.lang.String r0 = r5.f4107a
            r9.append(r0)
            java.lang.String r0 = " pkg="
            r9.append(r0)
            r9.append(r6)
            java.lang.String r9 = r9.toString()
            f(r9)
            K7.e r8 = r8.f4125f
            return r8
        L7e:
            int r4 = r4 + 1
            goto L1d
        L81:
            java.lang.String r8 = "makeSureProviderData, no system OpenId provider resolved"
            f(r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: K7.i.a(android.content.Context):K7.e");
    }

    public final String d(Context context, b bVar) throws Throwable {
        Throwable th;
        Exception exc;
        String str;
        Cursor cursorQuery;
        Cursor cursor = null;
        str = null;
        str = null;
        String str2 = null;
        cursor = null;
        if (bVar == null) {
            f("getId, openId = null.");
            return null;
        }
        if (bVar.a()) {
            return bVar.f4103b;
        }
        if (!h(context, true)) {
            f("getId, isSupported = false.");
            return null;
        }
        f("queryId : " + bVar.f4104c);
        e eVarA = a(context);
        if (!g(eVarA)) {
            return null;
        }
        try {
            try {
                cursorQuery = context.getContentResolver().query(Uri.parse(eVarA.c()), null, null, new String[]{bVar.f4104c}, null);
            } catch (Exception e10) {
                exc = e10;
                str = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            if (cursorQuery != null) {
                g gVarB = b(cursorQuery);
                str2 = gVarB.f4115a;
                bVar.e(str2);
                bVar.d(gVarB.f4117c);
                bVar.c(gVarB.f4116b);
                f(bVar.f4104c + " errorCode : " + bVar.f4105d);
                if (gVarB.f4116b != 1000) {
                    e(context, eVarA);
                    if (!h(context, false)) {
                        f("not support, forceQuery isSupported: " + h(context, true));
                    }
                }
            } else if (h(context, false)) {
                f("forceQuery isSupported : " + h(context, true));
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return str2;
        } catch (Exception e11) {
            exc = e11;
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

    public final synchronized void e(Context context, e eVar) {
        if (this.f4126g == null && g(eVar)) {
            String strA = eVar.a();
            String strB = eVar.b();
            if (!TextUtils.isEmpty(strA) && !TextUtils.isEmpty(strB)) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(strA);
                h hVar = new h();
                this.f4126g = hVar;
                context.registerReceiver(hVar, intentFilter, strB, null);
                f("registerReceivers, action=" + strA + " permission=" + strB);
                return;
            }
            f("registerReceivers, missing action or permission");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean h(android.content.Context r10, boolean r11) {
        /*
            r9 = this;
            K7.f r0 = r9.f4124e
            boolean r0 = r0.a()
            if (r0 == 0) goto L11
            if (r11 != 0) goto L11
            K7.f r9 = r9.f4124e
            boolean r9 = r9.b()
            return r9
        L11:
            K7.e r11 = r9.a(r10)
            boolean r11 = g(r11)
            r1 = 0
            if (r11 != 0) goto L1d
            return r1
        L1d:
            java.lang.String r11 = "querySupport, Exception : "
            java.lang.String r0 = "querySupport version : 1.1.0"
            f(r0)
            K7.e r0 = r9.a(r10)
            boolean r2 = g(r0)
            if (r2 != 0) goto L2f
            goto L84
        L2f:
            r2 = 0
            java.lang.String r0 = r0.c()     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            android.net.Uri r4 = android.net.Uri.parse(r0)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            java.lang.String r10 = "supported"
            java.lang.String[] r7 = new java.lang.String[]{r10}     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            r8 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            if (r2 == 0) goto L6b
            K7.g r10 = b(r2)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            int r0 = r10.f4116b     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            r3 = 1000(0x3e8, float:1.401E-42)
            if (r3 != r0) goto L66
            java.lang.String r0 = "0"
            java.lang.String r10 = r10.f4115a     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            boolean r10 = r0.equals(r10)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            if (r10 == 0) goto L67
            goto L66
        L60:
            r0 = move-exception
            r9 = r0
            goto L9b
        L63:
            r0 = move-exception
            r10 = r0
            goto L6e
        L66:
            r1 = 1
        L67:
            r2.close()
            goto L84
        L6b:
            if (r2 == 0) goto L84
            goto L83
        L6e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L60
            r0.<init>(r11)     // Catch: java.lang.Throwable -> L60
            java.lang.String r10 = r10.getMessage()     // Catch: java.lang.Throwable -> L60
            r0.append(r10)     // Catch: java.lang.Throwable -> L60
            java.lang.String r10 = r0.toString()     // Catch: java.lang.Throwable -> L60
            f(r10)     // Catch: java.lang.Throwable -> L60
            if (r2 == 0) goto L84
        L83:
            goto L67
        L84:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "query support, result : "
            r10.<init>(r11)
            r10.append(r1)
            java.lang.String r10 = r10.toString()
            f(r10)
            K7.f r9 = r9.f4124e
            r9.c(r1)
            return r1
        L9b:
            if (r2 == 0) goto La0
            r2.close()
        La0:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: K7.i.h(android.content.Context, boolean):boolean");
    }
}
