package com.autonavi.aps.amapapi.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.amap.api.col.jmsl.C1568j1;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import com.autonavi.aps.amapapi.restruct.Cgi;
import com.autonavi.aps.amapapi.security.Encrypt;
import com.autonavi.aps.amapapi.utils.AuthUtil;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.autonavi.aps.amapapi.utils.Utils;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Hashtable;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Cache {

    /* renamed from: a, reason: collision with root package name */
    Hashtable<String, ArrayList<Item>> f18351a = new Hashtable<>();

    /* renamed from: b, reason: collision with root package name */
    private long f18352b = 0;

    /* renamed from: c, reason: collision with root package name */
    private boolean f18353c = false;

    /* renamed from: d, reason: collision with root package name */
    private String f18354d = Const.STR_VER.replace(".", "");

    /* renamed from: e, reason: collision with root package name */
    private String f18355e = null;

    /* renamed from: f, reason: collision with root package name */
    boolean f18356f = true;

    /* renamed from: g, reason: collision with root package name */
    long f18357g = 0;

    /* renamed from: h, reason: collision with root package name */
    String f18358h = null;

    /* renamed from: i, reason: collision with root package name */
    Cgi f18359i = null;

    /* renamed from: j, reason: collision with root package name */
    private String f18360j = null;

    /* renamed from: k, reason: collision with root package name */
    private long f18361k = 0;

    /* renamed from: l, reason: collision with root package name */
    boolean f18362l = true;

    /* renamed from: m, reason: collision with root package name */
    boolean f18363m = true;

    /* renamed from: n, reason: collision with root package name */
    String f18364n = String.valueOf(AMapLocationClientOption.GeoLanguage.DEFAULT);

    /* renamed from: com.autonavi.aps.amapapi.storage.Cache$1, reason: invalid class name */
    class AnonymousClass1 implements Comparator<Object> {
        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            try {
                throw null;
            } catch (Throwable th) {
                CoreUtil.reportError(th, "Cache", "print");
                return 0;
            }
        }
    }

    public static class Item {

        /* renamed from: a, reason: collision with root package name */
        private AMapLocationServer f18365a = null;

        /* renamed from: b, reason: collision with root package name */
        private String f18366b = null;

        public AMapLocationServer getAmapLoc() {
            return this.f18365a;
        }

        public String getNb() {
            return this.f18366b;
        }

        public void setAmapLoc(AMapLocationServer aMapLocationServer) {
            this.f18365a = aMapLocationServer;
        }

        public void setNb(String str) {
            if (TextUtils.isEmpty(str)) {
                this.f18366b = null;
            } else {
                this.f18366b = str.replace("##", Const.STR_MART_WELL);
            }
        }
    }

    private AMapLocationServer a(String str, StringBuilder sb2, boolean z10) {
        try {
            Item itemA = (str.contains(Const.STR_CACHE_CW) || str.contains("wifi")) ? a(sb2, str) : (str.contains("cgi") && this.f18351a.containsKey(str) && this.f18351a.get(str).size() > 0) ? this.f18351a.get(str).get(0) : null;
            if (itemA != null && Utils.locCorrect(itemA.getAmapLoc())) {
                AMapLocationServer amapLoc = itemA.getAmapLoc();
                amapLoc.setCacheType(Const.STR_MEM);
                amapLoc.setNb(itemA.getNb());
                if (!z10 && !AuthUtil.isCacheAble(amapLoc.getTime())) {
                    Hashtable<String, ArrayList<Item>> hashtable = this.f18351a;
                    if (hashtable != null && hashtable.containsKey(str)) {
                        this.f18351a.get(str).remove(itemA);
                    }
                }
                if (Utils.locCorrect(amapLoc)) {
                    this.f18357g = 0L;
                }
                amapLoc.setLocationType(4);
                return amapLoc;
            }
        } catch (Throwable th) {
            CoreUtil.reportError(th, "Cache", "get1");
        }
        return null;
    }

    public void add(String str, StringBuilder sb2, AMapLocationServer aMapLocationServer, Context context, boolean z10) {
        try {
            if (Utils.locCorrect(aMapLocationServer)) {
                String str2 = str + Const.STR_MART_ADD + aMapLocationServer.isOffset() + Const.STR_MART_ADD + aMapLocationServer.isReversegeo() + Const.STR_MART_ADD + aMapLocationServer.getGeoLanguage();
                if (((TextUtils.isEmpty(str2) || !Utils.locCorrect(aMapLocationServer) || str2.startsWith(Const.STR_MART_WELL)) ? false : str2.contains("network")) && !aMapLocationServer.getCacheType().equals(Const.STR_MEM) && !aMapLocationServer.getCacheType().equals(Const.STR_FILE) && !aMapLocationServer.getCacheType().equals(Const.TYPE_OFFLINE_WIFI) && !"-3".equals(aMapLocationServer.getRetype())) {
                    if (a()) {
                        b();
                    }
                    JSONObject extra = aMapLocationServer.getExtra();
                    if (Utils.joHasK(extra, Const.JSON_KEY_OFFPCT)) {
                        extra.remove(Const.JSON_KEY_OFFPCT);
                        aMapLocationServer.setExtra(extra);
                    }
                    if (str2.contains("wifi")) {
                        if (TextUtils.isEmpty(sb2)) {
                            return;
                        }
                        if (aMapLocationServer.getAccuracy() >= 300.0f) {
                            int i10 = 0;
                            for (String str3 : sb2.toString().split(Const.STR_MART_WELL)) {
                                if (str3.contains(Const.STR_MART_COMMA)) {
                                    i10++;
                                }
                            }
                            if (i10 >= 8) {
                                return;
                            }
                        } else if (aMapLocationServer.getAccuracy() <= 3.0f) {
                            return;
                        }
                        if (str2.contains(Const.STR_CACHE_CW) && !TextUtils.isEmpty(aMapLocationServer.getMcell())) {
                            String strReplace = str2.replace(Const.STR_CACHE_CW, "cgi");
                            AMapLocationServer mcellLoc = aMapLocationServer.getMcellLoc();
                            if (Utils.locCorrect(mcellLoc)) {
                                add(strReplace, new StringBuilder(), mcellLoc, context, true);
                            }
                        }
                    } else if (str2.contains("cgi")) {
                        if (sb2 != null) {
                            if (sb2.indexOf(Const.STR_MART_COMMA) != -1) {
                                return;
                            }
                        }
                        if (UxipConstants.f30661Y.equals(aMapLocationServer.getRetype())) {
                            return;
                        }
                    }
                    AMapLocationServer aMapLocationServerA = a(str2, sb2, false);
                    if (Utils.locCorrect(aMapLocationServerA) && aMapLocationServerA.toStr().equals(aMapLocationServer.toStr(3))) {
                        return;
                    }
                    this.f18352b = Utils.getTimeBoot();
                    Item item = new Item();
                    item.setAmapLoc(aMapLocationServer);
                    item.setNb(TextUtils.isEmpty(sb2) ? null : sb2.toString());
                    if (this.f18351a.containsKey(str2)) {
                        this.f18351a.get(str2).add(item);
                    } else {
                        ArrayList<Item> arrayList = new ArrayList<>();
                        arrayList.add(item);
                        this.f18351a.put(str2, arrayList);
                    }
                    if (z10) {
                        try {
                            updateHist(str2, aMapLocationServer, sb2, context);
                        } catch (Throwable th) {
                            CoreUtil.reportError(th, "Cache", "add");
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "Cache", "add");
        }
    }

    public void b() {
        this.f18352b = 0L;
        if (!this.f18351a.isEmpty()) {
            this.f18351a.clear();
        }
        this.f18353c = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.autonavi.aps.amapapi.model.AMapLocationServer checkCache(com.autonavi.aps.amapapi.restruct.CgiManager r17, boolean r18, com.autonavi.aps.amapapi.model.AMapLocationServer r19, com.autonavi.aps.amapapi.restruct.WifiManagerWrapper r20, java.lang.StringBuilder r21, java.lang.String r22, android.content.Context r23, boolean r24) {
        /*
            Method dump skipped, instructions count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.storage.Cache.checkCache(com.autonavi.aps.amapapi.restruct.CgiManager, boolean, com.autonavi.aps.amapapi.model.AMapLocationServer, com.autonavi.aps.amapapi.restruct.WifiManagerWrapper, java.lang.StringBuilder, java.lang.String, android.content.Context, boolean):com.autonavi.aps.amapapi.model.AMapLocationServer");
    }

    public void cleanLastNb() {
        this.f18357g = 0L;
        this.f18358h = null;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:16|(2:18|(6:20|52|25|(1:59)|41|42)(1:21))(2:23|24)|22|52|25|(2:32|59)(1:58)) */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005b, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005c, code lost:
    
        com.autonavi.aps.amapapi.utils.CoreUtil.reportError(r7, "DB", "clearHist");
        r7 = r7.getMessage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0069, code lost:
    
        if (android.text.TextUtils.isEmpty(r7) == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006b, code lost:
    
        r7.contains("no such table");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void clearHist(android.content.Context r8, int r9) throws java.lang.Exception {
        /*
            r7 = this;
            java.lang.String r0 = "DB"
            java.lang.String r1 = "hist"
            if (r8 != 0) goto L8
            goto L8b
        L8:
            r2 = 0
            java.lang.String r3 = "hmdb"
            r4 = 0
            android.database.sqlite.SQLiteDatabase r8 = r8.openOrCreateDatabase(r3, r4, r2)     // Catch: java.lang.Throwable -> L79
            boolean r3 = com.autonavi.aps.amapapi.utils.Utils.tableExisted(r8, r1)     // Catch: java.lang.Throwable -> L22
            if (r3 != 0) goto L25
            if (r8 == 0) goto L8b
            boolean r7 = r8.isOpen()     // Catch: java.lang.Throwable -> L22
            if (r7 == 0) goto L8b
            r8.close()     // Catch: java.lang.Throwable -> L22
            return
        L22:
            r7 = move-exception
            r2 = r8
            goto L7a
        L25:
            r3 = 1
            if (r9 == r3) goto L33
            r3 = 2
            if (r9 == r3) goto L2d
            r9 = r2
            goto L46
        L2d:
            java.lang.String r9 = "1"
        L2f:
            r6 = r2
            r2 = r9
            r9 = r6
            goto L46
        L33:
            long r2 = com.autonavi.aps.amapapi.utils.Utils.getTime()     // Catch: java.lang.Throwable -> L22
            r4 = 172800000(0xa4cb800, double:8.53745436E-316)
            long r2 = r2 - r4
            java.lang.String r9 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> L22
            java.lang.String[] r2 = new java.lang.String[]{r9}     // Catch: java.lang.Throwable -> L22
            java.lang.String r9 = "time<?"
            goto L2f
        L46:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5b
            r3.<init>()     // Catch: java.lang.Throwable -> L5b
            r3.append(r1)     // Catch: java.lang.Throwable -> L5b
            java.lang.String r7 = r7.f18354d     // Catch: java.lang.Throwable -> L5b
            r3.append(r7)     // Catch: java.lang.Throwable -> L5b
            java.lang.String r7 = r3.toString()     // Catch: java.lang.Throwable -> L5b
            r8.delete(r7, r2, r9)     // Catch: java.lang.Throwable -> L5b
            goto L70
        L5b:
            r7 = move-exception
            java.lang.String r9 = "clearHist"
            com.autonavi.aps.amapapi.utils.CoreUtil.reportError(r7, r0, r9)     // Catch: java.lang.Throwable -> L22
            java.lang.String r7 = r7.getMessage()     // Catch: java.lang.Throwable -> L22
            boolean r9 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> L22
            if (r9 != 0) goto L70
            java.lang.String r9 = "no such table"
            r7.contains(r9)     // Catch: java.lang.Throwable -> L22
        L70:
            if (r8 == 0) goto L8b
            boolean r7 = r8.isOpen()
            if (r7 == 0) goto L8b
            goto L88
        L79:
            r7 = move-exception
        L7a:
            java.lang.String r8 = "clearHist p2"
            com.autonavi.aps.amapapi.utils.CoreUtil.reportError(r7, r0, r8)     // Catch: java.lang.Throwable -> L8c
            if (r2 == 0) goto L8b
            boolean r7 = r2.isOpen()
            if (r7 == 0) goto L8b
            r8 = r2
        L88:
            r8.close()
        L8b:
            return
        L8c:
            r7 = move-exception
            if (r2 == 0) goto L98
            boolean r8 = r2.isOpen()
            if (r8 == 0) goto L98
            r2.close()
        L98:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.storage.Cache.clearHist(android.content.Context, int):void");
    }

    public void destroy(Context context) {
        try {
            b();
            clearHist(context, 1);
            this.f18353c = false;
            this.f18358h = null;
            this.f18361k = 0L;
        } catch (Throwable th) {
            CoreUtil.reportError(th, "Cache", "destroy part");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x0266 A[EDGE_INSN: B:112:0x0266->B:78:0x0266 BREAK  A[LOOP:0: B:37:0x00d3->B:80:0x0276], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0276 A[LOOP:0: B:37:0x00d3->B:80:0x0276, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void fetchHistWhereArgs(android.content.Context r18, java.lang.String r19, boolean r20) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 695
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.storage.Cache.fetchHistWhereArgs(android.content.Context, java.lang.String, boolean):void");
    }

    public AMapLocationServer get(Context context, String str, StringBuilder sb2, boolean z10, boolean z11) {
        if (TextUtils.isEmpty(str) || !AuthUtil.getCacheAble()) {
            return null;
        }
        String str2 = str + Const.STR_MART_ADD + this.f18362l + Const.STR_MART_ADD + this.f18363m + Const.STR_MART_ADD + this.f18364n;
        if (str2.contains("gps") || !AuthUtil.getCacheAble() || sb2 == null) {
            return null;
        }
        if (a()) {
            b();
            return null;
        }
        if (z10 && !this.f18353c) {
            try {
                String strA = a(str2, sb2, context);
                b();
                fetchHistWhereArgs(context, strA, z11);
            } catch (Throwable unused) {
            }
        }
        if (this.f18351a.isEmpty()) {
            return null;
        }
        return a(str2, sb2, z11);
    }

    public void loadDB(Context context) {
        if (this.f18353c) {
            return;
        }
        try {
            b();
            fetchHistWhereArgs(context, null, false);
        } catch (Throwable th) {
            CoreUtil.reportError(th, "Cache", "loadDB");
        }
        this.f18353c = true;
    }

    public void setLastCgi(Cgi cgi) {
        this.f18359i = cgi;
    }

    public void setLastNb(String str) {
        this.f18358h = str;
    }

    public void setOption(AMapLocationClientOption aMapLocationClientOption) {
        this.f18363m = aMapLocationClientOption.isNeedAddress();
        this.f18362l = aMapLocationClientOption.isOffset();
        this.f18356f = aMapLocationClientOption.isLocationCacheEnable();
        this.f18364n = String.valueOf(aMapLocationClientOption.getGeoLanguage());
    }

    public void updateHist(String str, AMapLocation aMapLocation, StringBuilder sb2, Context context) throws Exception {
        if (context == null) {
            return;
        }
        if (this.f18355e == null) {
            this.f18355e = Utils.getPackageNameMD5(context);
        }
        String strA = a(str, sb2, context);
        StringBuilder sb3 = new StringBuilder();
        SQLiteDatabase sQLiteDatabaseOpenOrCreateDatabase = null;
        try {
            sQLiteDatabaseOpenOrCreateDatabase = context.openOrCreateDatabase(Const.STR_DB, 0, null);
            sb3.append("CREATE TABLE IF NOT EXISTS ");
            sb3.append(Const.STR_TAB_HIST);
            sb3.append(this.f18354d);
            sb3.append(" (feature VARCHAR PRIMARY KEY, nb VARCHAR, loc VARCHAR, time VARCHAR);");
            sQLiteDatabaseOpenOrCreateDatabase.execSQL(sb3.toString());
            sb3.delete(0, sb3.length());
            sb3.append("REPLACE INTO ");
            sb3.append(Const.STR_TAB_HIST);
            sb3.append(this.f18354d);
            sb3.append(" VALUES (?, ?, ?, ?)");
            Object[] objArr = new Object[4];
            objArr[0] = strA;
            byte[] bArrAesEncrypt = Encrypt.aesEncrypt(sb2.toString().getBytes("UTF-8"), this.f18355e);
            objArr[1] = bArrAesEncrypt;
            objArr[2] = Encrypt.aesEncrypt(aMapLocation.toStr().getBytes("UTF-8"), this.f18355e);
            objArr[3] = Long.valueOf(aMapLocation.getTime());
            for (int i10 = 1; i10 < 3; i10++) {
                objArr[i10] = C1568j1.g((byte[]) objArr[i10]);
            }
            sQLiteDatabaseOpenOrCreateDatabase.execSQL(sb3.toString(), objArr);
            sb3.delete(0, sb3.length());
            if (!sQLiteDatabaseOpenOrCreateDatabase.isOpen()) {
                return;
            }
        } catch (Throwable th) {
            try {
                CoreUtil.reportError(th, "DB", "updateHist");
                sb3.delete(0, sb3.length());
                if (sQLiteDatabaseOpenOrCreateDatabase == null || !sQLiteDatabaseOpenOrCreateDatabase.isOpen()) {
                    return;
                }
            } finally {
                sb3.delete(0, sb3.length());
                if (sQLiteDatabaseOpenOrCreateDatabase != null && sQLiteDatabaseOpenOrCreateDatabase.isOpen()) {
                    sQLiteDatabaseOpenOrCreateDatabase.close();
                }
            }
        }
        sQLiteDatabaseOpenOrCreateDatabase.close();
    }

    private boolean a() {
        long timeBoot = Utils.getTimeBoot();
        long j10 = this.f18352b;
        long j11 = timeBoot - j10;
        if (j10 == 0) {
            return false;
        }
        return this.f18351a.size() > 360 || j11 > 172800000;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ee A[LOOP:1: B:40:0x00e6->B:42:0x00ee, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0106 A[LOOP:2: B:44:0x0100->B:46:0x0106, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01e2 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.autonavi.aps.amapapi.storage.Cache.Item a(java.lang.StringBuilder r33, java.lang.String r34) {
        /*
            Method dump skipped, instructions count: 508
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.storage.Cache.a(java.lang.StringBuilder, java.lang.String):com.autonavi.aps.amapapi.storage.Cache$Item");
    }

    private void a(String str, Hashtable<String, String> hashtable) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        hashtable.clear();
        for (String str2 : str.split(Const.STR_MART_WELL)) {
            if (!TextUtils.isEmpty(str2) && !str2.contains("|")) {
                hashtable.put(str2, "");
            }
        }
    }

    public String a(String str, StringBuilder sb2, Context context) {
        String strSubstring;
        if (context == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            this.f18355e = Utils.getPackageNameMD5(context);
            if (str.contains(Const.STR_MART_ADD)) {
                str = str.substring(0, str.indexOf(Const.STR_MART_ADD));
            }
            String strSubstring2 = str.substring(str.lastIndexOf(Const.STR_MART_WELL) + 1);
            if (strSubstring2.equals("cgi")) {
                jSONObject.put("cgi", str.substring(0, str.length() - 12));
            } else if (!TextUtils.isEmpty(sb2) && sb2.indexOf(",access") != -1) {
                jSONObject.put("cgi", str.substring(0, str.length() - (strSubstring2.length() + 9)));
                String[] strArrSplit = sb2.toString().split(",access");
                if (strArrSplit[0].contains(Const.STR_MART_WELL)) {
                    String str2 = strArrSplit[0];
                    strSubstring = str2.substring(str2.lastIndexOf(Const.STR_MART_WELL) + 1);
                } else {
                    strSubstring = strArrSplit[0];
                }
                jSONObject.put(Const.JSON_KEY_MMAC, strSubstring);
            }
            return C1568j1.g(Encrypt.aesEncrypt(jSONObject.toString().getBytes("UTF-8"), this.f18355e));
        } catch (Throwable unused) {
            return null;
        }
    }
}
