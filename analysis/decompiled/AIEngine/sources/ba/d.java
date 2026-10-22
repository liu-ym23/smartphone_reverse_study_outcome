package ba;

import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.text.TextUtils;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d {
    public static volatile d h;

    /* renamed from: f, reason: collision with root package name */
    public e f3152f;

    /* renamed from: g, reason: collision with root package name */
    public c f3153g;

    /* renamed from: a, reason: collision with root package name */
    public final a f3147a = new a("udid");

    /* renamed from: b, reason: collision with root package name */
    public final a f3148b = new a("oaid");

    /* renamed from: d, reason: collision with root package name */
    public final a f3150d = new a("vaid");

    /* renamed from: c, reason: collision with root package name */
    public final a f3149c = new a("aaid");

    /* renamed from: e, reason: collision with root package name */
    public final stepos.support.v7.app.palette.b f3151e = new stepos.support.v7.app.palette.b(2);

    public static b a(Cursor cursor) {
        b bVar = new b();
        bVar.f3144a = null;
        bVar.f3145b = 0;
        bVar.f3146c = System.currentTimeMillis() + 86400000;
        if (cursor.isClosed()) {
            return bVar;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex("value");
        if (columnIndex >= 0) {
            bVar.f3144a = cursor.getString(columnIndex);
        }
        int columnIndex2 = cursor.getColumnIndex("code");
        if (columnIndex2 >= 0) {
            bVar.f3145b = cursor.getInt(columnIndex2);
        }
        int columnIndex3 = cursor.getColumnIndex("expired");
        if (columnIndex3 >= 0) {
            bVar.f3146c = cursor.getLong(columnIndex3);
        }
        return bVar;
    }

    public static final d b() {
        if (h == null) {
            synchronized (d.class) {
                try {
                    if (h == null) {
                        h = new d();
                    }
                } finally {
                }
            }
        }
        return h;
    }

    public final e c(Context context) {
        e eVar = this.f3152f;
        if (eVar != null && eVar.f3156c) {
            return eVar;
        }
        PackageManager packageManager = context.getPackageManager();
        String str = null;
        if (packageManager == null) {
            return null;
        }
        boolean z = false;
        ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider("com.stepos.secureservice.openidsdk", 0);
        String str2 = (providerInfoResolveContentProvider == null || (providerInfoResolveContentProvider.applicationInfo.flags & 1) == 0) ? null : providerInfoResolveContentProvider.packageName;
        if (TextUtils.isEmpty(str2)) {
            ProviderInfo providerInfoResolveContentProvider2 = packageManager.resolveContentProvider("com.stepos.openidsdk", 0);
            if (providerInfoResolveContentProvider2 != null && (providerInfoResolveContentProvider2.applicationInfo.flags & 1) != 0) {
                str = providerInfoResolveContentProvider2.packageName;
            }
            str2 = str;
        } else {
            z = true;
        }
        e eVar2 = new e(str2, z);
        this.f3152f = eVar2;
        return eVar2;
    }

    public final synchronized void d(Context context, String str) {
        if (this.f3153g != null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.stepos.openid.ACTION_OPEN_ID_CHANGE");
        c cVar = new c();
        this.f3153g = cVar;
        context.registerReceiver(cVar, intentFilter, str, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e(android.content.Context r10, boolean r11) {
        /*
            r9 = this;
            stepos.support.v7.app.palette.b r1 = r9.f3151e
            java.lang.Object r0 = r1.h
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            if (r0 == 0) goto Lf
            if (r11 != 0) goto Lf
            boolean r9 = r0.booleanValue()
            return r9
        Lf:
            ba.e r11 = r9.c(r10)
            r2 = 0
            if (r11 == 0) goto L73
            boolean r11 = r11.f3156c
            if (r11 == 0) goto L73
            ba.e r9 = r9.c(r10)
            if (r9 == 0) goto L6d
            boolean r11 = r9.f3156c
            if (r11 == 0) goto L6d
            r11 = 0
            java.lang.String r9 = r9.f3155b     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L56
            android.net.Uri r4 = android.net.Uri.parse(r9)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L56
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L56
            java.lang.String r9 = "supported"
            java.lang.String[] r7 = new java.lang.String[]{r9}     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L56
            r8 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r11 = r3.query(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L56
            if (r11 == 0) goto L5e
            ba.b r9 = a(r11)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L56
            int r10 = r9.f3145b     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L56
            r0 = 1000(0x3e8, float:1.401E-42)
            if (r0 != r10) goto L59
            java.lang.String r10 = "0"
            java.lang.String r9 = r9.f3144a     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L56
            boolean r9 = r10.equals(r9)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L56
            if (r9 == 0) goto L5a
            goto L59
        L53:
            r0 = move-exception
            r9 = r0
            goto L67
        L56:
            r0 = move-exception
            r9 = r0
            goto L61
        L59:
            r2 = 1
        L5a:
            r11.close()
            goto L6d
        L5e:
            if (r11 == 0) goto L6d
            goto L66
        L61:
            r9.getMessage()     // Catch: java.lang.Throwable -> L53
            if (r11 == 0) goto L6d
        L66:
            goto L5a
        L67:
            if (r11 == 0) goto L6c
            r11.close()
        L6c:
            throw r9
        L6d:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r2)
            r1.h = r9
        L73:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: ba.d.e(android.content.Context, boolean):boolean");
    }
}
