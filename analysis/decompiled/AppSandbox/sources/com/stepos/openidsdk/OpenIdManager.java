package com.stepos.openidsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.pps.logpull.LogPullAuthActivity;

/* loaded from: classes.dex */
class OpenIdManager {
    private static final String TAG = "OpenIdManager";
    private static boolean sDebug = true;
    private static volatile OpenIdManager sInstance;
    private BroadcastReceiver mBroadcastReceiver;
    private IOAIDChangeListener mOAIDChangeListener;
    private ProviderData mProviderData;
    private OpenId mUDID = new OpenId("udid");
    private OpenId mOAID = new OpenId(LogPullAuthActivity.EXTRA_OAID);
    private OpenId mVAID = new OpenId("vaid");
    private OpenId mAAID = new OpenId("aaid");
    private SupportInfo mSupportInfo = new SupportInfo();

    private OpenIdManager() {
    }

    public static final OpenIdManager getInstance() {
        if (sInstance == null) {
            synchronized (OpenIdManager.class) {
                if (sInstance == null) {
                    sInstance = new OpenIdManager();
                }
            }
        }
        return sInstance;
    }

    public synchronized void setOAIDChangeListener(IOAIDChangeListener iOAIDChangeListener) {
        this.mOAIDChangeListener = iOAIDChangeListener;
    }

    public synchronized void clearOAIDChangeListener() {
        this.mOAIDChangeListener = null;
    }

    public synchronized void onOAIDChanged() {
        IOAIDChangeListener iOAIDChangeListener = this.mOAIDChangeListener;
        if (iOAIDChangeListener != null) {
            iOAIDChangeListener.onChanged();
        }
    }

    public void setDebug(boolean z) {
        sDebug = z;
    }

    private static ValueData parseValue(Cursor cursor) {
        ValueData valueData = new ValueData(null, 0);
        if (cursor == null) {
            log("parseValue fail, cursor is null.");
            return valueData;
        }
        if (cursor.isClosed()) {
            log("parseValue fail, cursor is closed.");
            return valueData;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex("value");
        if (columnIndex >= 0) {
            valueData.value = cursor.getString(columnIndex);
        } else {
            log("parseValue fail, index < 0.");
        }
        int columnIndex2 = cursor.getColumnIndex("code");
        if (columnIndex2 >= 0) {
            valueData.code = cursor.getInt(columnIndex2);
        } else {
            log("parseCode fail, index < 0.");
        }
        int columnIndex3 = cursor.getColumnIndex("expired");
        if (columnIndex3 >= 0) {
            valueData.expired = cursor.getLong(columnIndex3);
            return valueData;
        }
        log("parseExpired fail, index < 0.");
        return valueData;
    }

    private static String fetchProviderPackageName(PackageManager packageManager, String str) {
        if (packageManager == null || str == null) {
            log("fetchProviderPackageName, packageManager or auth is null");
            return null;
        }
        ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(str, 0);
        if (providerInfoResolveContentProvider == null) {
            log("fetchProviderPackageName, providerInfo is null");
            return null;
        }
        if ((providerInfoResolveContentProvider.applicationInfo.flags & 1) == 0) {
            log("fetchProviderPackageName, providerInfoFlags is not system");
            return null;
        }
        return providerInfoResolveContentProvider.packageName;
    }

    private static boolean isValid(ProviderData providerData) {
        return providerData != null && providerData.isValid();
    }

    public boolean isSupported(Context context) {
        return isSupported(context, false);
    }

    private ProviderData makeSureProviderData(Context context) {
        boolean z;
        if (isValid(this.mProviderData)) {
            return this.mProviderData;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            log("makeSureProviderData, packageManager is null");
            return null;
        }
        String strFetchProviderPackageName = fetchProviderPackageName(packageManager, "com.stepos.secureservice.openidsdk");
        if (TextUtils.isEmpty(strFetchProviderPackageName)) {
            strFetchProviderPackageName = fetchProviderPackageName(packageManager, "com.stepos.openidsdk");
            log("makeSureProviderData, use SAFE_AUTHORITIES");
            z = false;
        } else {
            log("makeSureProviderData, use SECURESERVICE_AUTHORITIES");
            z = true;
        }
        ProviderData providerData = new ProviderData(strFetchProviderPackageName, z);
        this.mProviderData = providerData;
        return providerData;
    }

    private boolean isSupported(Context context, boolean z) {
        if (this.mSupportInfo.isCached() && !z) {
            return this.mSupportInfo.isSupport();
        }
        if (!isValid(makeSureProviderData(context))) {
            return false;
        }
        boolean zQuerySupport = querySupport(context);
        log("query support, result : " + zQuerySupport);
        this.mSupportInfo.setSupport(zQuerySupport);
        return zQuerySupport;
    }

    public String getUDID(Context context) {
        return getId(context, this.mUDID);
    }

    public String getOAID(Context context) {
        return getId(context, this.mOAID);
    }

    public String getVAID(Context context) {
        return getId(context, this.mVAID);
    }

    public String getAAID(Context context) {
        return getId(context, this.mAAID);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0047 A[Catch: Exception -> 0x0052, all -> 0x0070, TRY_LEAVE, TryCatch #0 {all -> 0x0070, blocks: (B:8:0x0024, B:10:0x002a, B:12:0x0032, B:16:0x0041, B:17:0x0047, B:26:0x0059), top: B:35:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004e A[PHI: r9
      0x004e: PHI (r9v3 android.database.Cursor) = (r9v2 android.database.Cursor), (r9v5 android.database.Cursor) binds: [B:27:0x006c, B:18:0x004c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String getDeviceDsid(android.content.Context r9) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.String r8 = "getDeviceDsid, Exception : "
            r1 = 0
            if (r9 != 0) goto Lb
            java.lang.String r8 = "getDeviceDsid, context is null."
            log(r8)
            return r1
        Lb:
            java.lang.String r0 = "content://com.stepos.secureservice.open.DataProvider/"
            android.net.Uri r3 = android.net.Uri.parse(r0)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            android.content.ContentResolver r2 = r9.getContentResolver()     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            java.lang.String r9 = "5"
            java.lang.String[] r6 = new java.lang.String[]{r9}     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            r7 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r9 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            if (r9 == 0) goto L47
            boolean r0 = r9.moveToFirst()     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> L70
            if (r0 == 0) goto L47
            java.lang.String r0 = "value"
            int r0 = r9.getColumnIndex(r0)     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> L70
            if (r0 < 0) goto L41
            java.lang.String r0 = r9.getString(r0)     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> L70
            java.lang.String r2 = "getDeviceDsid success."
            log(r2)     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> L70
            if (r9 == 0) goto L40
            r9.close()
        L40:
            return r0
        L41:
            java.lang.String r0 = "getDeviceDsid, value column index < 0."
            log(r0)     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> L70
            goto L4c
        L47:
            java.lang.String r0 = "getDeviceDsid, cursor is null or empty."
            log(r0)     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> L70
        L4c:
            if (r9 == 0) goto L6f
        L4e:
            r9.close()
            goto L6f
        L52:
            r0 = move-exception
            goto L59
        L54:
            r0 = move-exception
            r8 = r0
            goto L73
        L57:
            r0 = move-exception
            r9 = r1
        L59:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L70
            r2.<init>(r8)     // Catch: java.lang.Throwable -> L70
            java.lang.String r8 = r0.getMessage()     // Catch: java.lang.Throwable -> L70
            r2.append(r8)     // Catch: java.lang.Throwable -> L70
            java.lang.String r8 = r2.toString()     // Catch: java.lang.Throwable -> L70
            log(r8)     // Catch: java.lang.Throwable -> L70
            if (r9 == 0) goto L6f
            goto L4e
        L6f:
            return r1
        L70:
            r0 = move-exception
            r8 = r0
            r1 = r9
        L73:
            if (r1 == 0) goto L78
            r1.close()
        L78:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.openidsdk.OpenIdManager.getDeviceDsid(android.content.Context):java.lang.String");
    }

    OpenId getOpenId(String str) {
        if (LogPullAuthActivity.EXTRA_OAID.equals(str)) {
            return this.mOAID;
        }
        if ("vaid".equals(str)) {
            return this.mVAID;
        }
        if ("aaid".equals(str)) {
            return this.mAAID;
        }
        if ("udid".equals(str)) {
            return this.mUDID;
        }
        return null;
    }

    static void log(String str) {
        if (sDebug) {
            Log.d(TAG, str);
        }
    }

    private String getId(Context context, OpenId openId) {
        if (openId == null) {
            log("getId, openId = null.");
            return null;
        }
        if (!isSupported(context, true)) {
            log("getId, isSupported = false.");
            return null;
        }
        return queryId(context, openId);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean querySupport(android.content.Context r11) {
        /*
            r10 = this;
            java.lang.String r1 = "querySupport, Exception : "
            java.lang.String r0 = "querySupport version : 1.1.0"
            log(r0)
            com.stepos.openidsdk.ProviderData r10 = r10.makeSureProviderData(r11)
            boolean r0 = isValid(r10)
            r2 = 0
            if (r0 != 0) goto L13
            return r2
        L13:
            r3 = 0
            java.lang.String r10 = r10.getUrl()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
            android.net.Uri r5 = android.net.Uri.parse(r10)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
            android.content.ContentResolver r4 = r11.getContentResolver()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
            java.lang.String r10 = "supported"
            java.lang.String[] r8 = new java.lang.String[]{r10}     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
            r9 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r3 = r4.query(r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
            if (r3 == 0) goto L4a
            com.stepos.openidsdk.ValueData r10 = parseValue(r3)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
            int r11 = r10.code     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
            r0 = 1000(0x3e8, float:1.401E-42)
            if (r0 != r11) goto L43
            java.lang.String r11 = "0"
            java.lang.String r10 = r10.value     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
            boolean r10 = r11.equals(r10)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
            if (r10 == 0) goto L44
        L43:
            r2 = 1
        L44:
            if (r3 == 0) goto L49
            r3.close()
        L49:
            return r2
        L4a:
            if (r3 == 0) goto L6b
        L4c:
            r3.close()
            goto L6b
        L50:
            r0 = move-exception
            r10 = r0
            goto L6c
        L53:
            r0 = move-exception
            r10 = r0
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L50
            r11.<init>(r1)     // Catch: java.lang.Throwable -> L50
            java.lang.String r10 = r10.getMessage()     // Catch: java.lang.Throwable -> L50
            r11.append(r10)     // Catch: java.lang.Throwable -> L50
            java.lang.String r10 = r11.toString()     // Catch: java.lang.Throwable -> L50
            log(r10)     // Catch: java.lang.Throwable -> L50
            if (r3 == 0) goto L6b
            goto L4c
        L6b:
            return r2
        L6c:
            if (r3 == 0) goto L71
            r3.close()
        L71:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.openidsdk.OpenIdManager.querySupport(android.content.Context):boolean");
    }

    private String queryId(Context context, OpenId openId) throws Throwable {
        Throwable th;
        Exception exc;
        String str;
        Cursor cursorQuery;
        log("queryId : " + openId.type);
        ProviderData providerDataMakeSureProviderData = makeSureProviderData(context);
        Cursor cursor = null;
        str = null;
        str = null;
        String str2 = null;
        cursor = null;
        try {
            if (!isValid(providerDataMakeSureProviderData)) {
                return null;
            }
            try {
                cursorQuery = context.getContentResolver().query(Uri.parse(providerDataMakeSureProviderData.getUrl()), null, null, new String[]{openId.type}, null);
            } catch (Exception e) {
                exc = e;
                str = null;
            }
            try {
                if (cursorQuery != null) {
                    ValueData value = parseValue(cursorQuery);
                    str2 = value.value;
                    openId.updateValue(str2);
                    openId.updateExpiredTime(value.expired);
                    openId.updateCode(value.code);
                    log(openId.type + " errorCode : " + openId.code);
                    if (value.code != 1000) {
                        registerReceivers(context, providerDataMakeSureProviderData.getOpenIdChangePermission());
                        if (!isSupported(context)) {
                            log("not support, forceQuery isSupported: " + isSupported(context, true));
                        }
                    }
                } else if (isSupported(context)) {
                    log("forceQuery isSupported : " + isSupported(context, true));
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return str2;
            } catch (Exception e2) {
                exc = e2;
                str = str2;
                cursor = cursorQuery;
                log("queryId, Exception : " + exc.getMessage());
                if (cursor != null) {
                    cursor.close();
                }
                return str;
            } catch (Throwable th2) {
                th = th2;
                cursor = cursorQuery;
                if (cursor != null) {
                    cursor.close();
                    throw th;
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private synchronized void registerReceivers(Context context, String str) {
        if (this.mBroadcastReceiver != null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.stepos.openid.ACTION_OPEN_ID_CHANGE");
        OpenIdChangeReceiver openIdChangeReceiver = new OpenIdChangeReceiver();
        this.mBroadcastReceiver = openIdChangeReceiver;
        context.registerReceiver(openIdChangeReceiver, intentFilter, str, null);
        log("registerReceivers, permission : " + str);
    }
}
