package com.stepos.openidsdk;

import android.content.Context;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b {
    public static volatile b i = null;

    /* renamed from: j, reason: collision with root package name */
    public static boolean f2764j = false;

    /* renamed from: f, reason: collision with root package name */
    public c f2770f;

    /* renamed from: g, reason: collision with root package name */
    public a f2771g;

    /* renamed from: h, reason: collision with root package name */
    public IOAIDChangeListener f2772h;

    /* renamed from: a, reason: collision with root package name */
    public final OpenId f2765a = new OpenId("udid");

    /* renamed from: b, reason: collision with root package name */
    public final OpenId f2766b = new OpenId("oaid");

    /* renamed from: d, reason: collision with root package name */
    public final OpenId f2768d = new OpenId("vaid");

    /* renamed from: c, reason: collision with root package name */
    public final OpenId f2767c = new OpenId("aaid");

    /* renamed from: e, reason: collision with root package name */
    public final SupportInfo f2769e = new SupportInfo();

    public final String a(Context context, OpenId openId) throws Throwable {
        Throwable th;
        Exception exc;
        String str;
        Cursor cursorQuery;
        Cursor cursor = null;
        str = null;
        str = null;
        String str2 = null;
        cursor = null;
        if (openId == null) {
            a("getId, openId = null.");
            return null;
        }
        if (openId.isValid()) {
            return openId.value;
        }
        if (!a(context, true)) {
            a("getId, isSupported = false.");
            return null;
        }
        a("queryId : " + openId.type);
        c cVarA = a(context);
        if (cVarA == null || !cVarA.f2775c) {
            return null;
        }
        try {
            try {
                cursorQuery = context.getContentResolver().query(Uri.parse(cVarA.f2774b), null, null, new String[]{openId.type}, null);
            } catch (Exception e10) {
                exc = e10;
                str = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            if (cursorQuery != null) {
                ValueData valueDataA = a(cursorQuery);
                str2 = valueDataA.value;
                openId.updateValue(str2);
                openId.updateExpiredTime(valueDataA.expired);
                openId.updateCode(valueDataA.code);
                a(openId.type + " errorCode : " + openId.code);
                if (valueDataA.code != 1000) {
                    a(context, cVarA.f2773a);
                    if (!a(context, false)) {
                        a("not support, forceQuery isSupported: " + a(context, true));
                    }
                }
            } else if (a(context, false)) {
                a("forceQuery isSupported : " + a(context, true));
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return str2;
        } catch (Exception e11) {
            exc = e11;
            str = str2;
            cursor = cursorQuery;
            a("queryId, Exception : " + exc.getMessage());
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

    public static ValueData a(Cursor cursor) {
        ValueData valueData = new ValueData(null, 0);
        if (cursor.isClosed()) {
            a("parseValue fail, cursor is closed.");
            return valueData;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex("value");
        if (columnIndex >= 0) {
            valueData.value = cursor.getString(columnIndex);
        } else {
            a("parseValue fail, index < 0.");
        }
        int columnIndex2 = cursor.getColumnIndex("code");
        if (columnIndex2 >= 0) {
            valueData.code = cursor.getInt(columnIndex2);
        } else {
            a("parseCode fail, index < 0.");
        }
        int columnIndex3 = cursor.getColumnIndex("expired");
        if (columnIndex3 >= 0) {
            valueData.expired = cursor.getLong(columnIndex3);
            return valueData;
        }
        a("parseExpired fail, index < 0.");
        return valueData;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.openidsdk.c a(android.content.Context r8) {
        /*
            r7 = this;
            com.stepos.openidsdk.c r0 = r7.f2770f
            if (r0 == 0) goto L9
            boolean r1 = r0.f2775c
            if (r1 == 0) goto L9
            return r0
        L9:
            android.content.pm.PackageManager r8 = r8.getPackageManager()
            r0 = 0
            if (r8 != 0) goto L16
            java.lang.String r7 = "makeSureProviderData, packageManager is null"
            a(r7)
            return r0
        L16:
            java.lang.String r1 = "com.stepos.secureservice.openidsdk"
            r2 = 0
            android.content.pm.ProviderInfo r1 = r8.resolveContentProvider(r1, r2)
            java.lang.String r3 = "fetchProviderPackageName, providerInfoFlags is not system"
            java.lang.String r4 = "fetchProviderPackageName, providerInfo is null"
            r5 = 1
            if (r1 != 0) goto L29
            a(r4)
        L27:
            r1 = r0
            goto L36
        L29:
            android.content.pm.ApplicationInfo r6 = r1.applicationInfo
            int r6 = r6.flags
            r6 = r6 & r5
            if (r6 != 0) goto L34
            a(r3)
            goto L27
        L34:
            java.lang.String r1 = r1.packageName
        L36:
            boolean r6 = android.text.TextUtils.isEmpty(r1)
            if (r6 == 0) goto L5c
            java.lang.String r1 = "com.stepos.openidsdk"
            android.content.pm.ProviderInfo r8 = r8.resolveContentProvider(r1, r2)
            if (r8 != 0) goto L48
            a(r4)
            goto L55
        L48:
            android.content.pm.ApplicationInfo r1 = r8.applicationInfo
            int r1 = r1.flags
            r1 = r1 & r5
            if (r1 != 0) goto L53
            a(r3)
            goto L55
        L53:
            java.lang.String r0 = r8.packageName
        L55:
            java.lang.String r8 = "makeSureProviderData, use SAFE_AUTHORITIES"
            a(r8)
            r1 = r0
            goto L62
        L5c:
            java.lang.String r8 = "makeSureProviderData, use SECURESERVICE_AUTHORITIES"
            a(r8)
            r2 = r5
        L62:
            com.stepos.openidsdk.c r8 = new com.stepos.openidsdk.c
            r8.<init>(r1, r2)
            r7.f2770f = r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.openidsdk.b.a(android.content.Context):com.stepos.openidsdk.c");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(android.content.Context r10, boolean r11) {
        /*
            r9 = this;
            com.stepos.openidsdk.SupportInfo r0 = r9.f2769e
            boolean r0 = r0.isCached()
            if (r0 == 0) goto L11
            if (r11 != 0) goto L11
            com.stepos.openidsdk.SupportInfo r9 = r9.f2769e
            boolean r9 = r9.isSupport()
            return r9
        L11:
            com.stepos.openidsdk.c r11 = r9.a(r10)
            r1 = 0
            if (r11 == 0) goto L9c
            boolean r11 = r11.f2775c
            if (r11 == 0) goto L9c
            java.lang.String r11 = "querySupport, Exception : "
            java.lang.String r0 = "querySupport version : 1.0.0"
            a(r0)
            com.stepos.openidsdk.c r0 = r9.a(r10)
            if (r0 == 0) goto L86
            boolean r2 = r0.f2775c
            if (r2 == 0) goto L86
            r2 = 0
            java.lang.String r0 = r0.f2774b     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5f
            android.net.Uri r4 = android.net.Uri.parse(r0)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5f
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5f
            java.lang.String r10 = "supported"
            java.lang.String[] r7 = new java.lang.String[]{r10}     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5f
            r8 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5f
            if (r2 == 0) goto L67
            com.stepos.openidsdk.ValueData r10 = a(r2)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5f
            int r0 = r10.code     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5f
            r3 = 1000(0x3e8, float:1.401E-42)
            if (r3 != r0) goto L62
            java.lang.String r0 = "0"
            java.lang.String r10 = r10.value     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5f
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
            a(r10)     // Catch: java.lang.Throwable -> L5c
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
            a(r10)
            com.stepos.openidsdk.SupportInfo r9 = r9.f2769e
            r9.setSupport(r1)
        L9c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.openidsdk.b.a(android.content.Context, boolean):boolean");
    }

    public static void a(String str) {
        if (f2764j) {
            Log.d("OpenIdManager", str);
        }
    }

    public static final b a() {
        if (i == null) {
            synchronized (b.class) {
                try {
                    if (i == null) {
                        i = new b();
                    }
                } finally {
                }
            }
        }
        return i;
    }

    public final synchronized void a(Context context, String str) {
        if (this.f2771g != null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.stepos.openid.ACTION_OPEN_ID_CHANGE");
        a aVar = new a();
        this.f2771g = aVar;
        context.registerReceiver(aVar, intentFilter, str, null);
        a("registerReceivers, permission : " + str);
    }
}
