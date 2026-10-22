package com.autonavi.aps.amapapi.trans;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.amap.api.col.jmsl.C1567j0;
import com.amap.api.col.jmsl.S0;
import com.amap.location.support.bean.wifi.AmapWifi;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.restruct.Cgi;
import com.autonavi.aps.amapapi.restruct.CgiManager;
import com.autonavi.aps.amapapi.restruct.HistoryLocation;
import com.autonavi.aps.amapapi.restruct.HistoryLocationRecorder;
import com.autonavi.aps.amapapi.restruct.WifiInfoWrapper;
import com.autonavi.aps.amapapi.restruct.WifiManagerWrapper;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.autonavi.aps.amapapi.utils.Utils;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class Req {
    protected static String adiu;
    protected static String utdid;
    public String action = "1";
    protected short respctrl = 0;
    protected String src = null;
    protected String license = null;
    protected String srvip = null;
    protected String model = null;
    protected String os = null;
    public String appname = null;
    public String iscdma = null;
    protected String gtype = null;
    protected String gmock = null;
    protected String glon = null;
    protected String glat = null;
    protected String accu = null;
    protected String extrakey = null;
    protected String imeimeid = null;
    protected String imsi = null;
    protected String uuid = null;
    protected String id = null;
    protected String smac = null;
    protected String phnum = null;
    protected String sdkv = null;
    protected String colv = null;
    protected String nettype = null;
    protected String inftype = null;
    protected int cgiflag = 0;
    protected ArrayList<Cgi> cellsV1 = new ArrayList<>();
    protected ArrayList<Cgi> cellsV2 = new ArrayList<>();
    protected String networkOperator = null;
    protected String mmac = null;
    protected ArrayList<AmapWifi> wifiScanResultList = new ArrayList<>();
    protected String macsage = null;
    protected String poiid = null;
    protected byte[] cor = null;

    /* renamed from: a, reason: collision with root package name */
    private byte[] f18406a = null;

    /* renamed from: b, reason: collision with root package name */
    private int f18407b = 0;
    protected String sCxtFromServer = null;
    protected String clientContext = null;
    protected String sn = null;
    protected String oaid = null;
    protected int mmacAge = 0;

    /* renamed from: c, reason: collision with root package name */
    private List<HistoryLocation> f18408c = null;

    /* renamed from: d, reason: collision with root package name */
    private List<Cgi> f18409d = Collections.synchronizedList(new ArrayList());

    /* JADX WARN: Removed duplicated region for block: B:11:0x0017 A[Catch: all -> 0x0010, LOOP:0: B:10:0x0015->B:11:0x0017, LOOP_END, TryCatch #0 {all -> 0x0010, blocks: (B:4:0x000c, B:13:0x001f, B:15:0x0022, B:17:0x002b, B:18:0x0033, B:9:0x0012, B:11:0x0017), top: B:23:0x000c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private byte[] a(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = ":"
            java.lang.String[] r0 = r7.split(r0)
            r1 = 6
            byte[] r2 = new byte[r1]
            r3 = 0
            if (r0 == 0) goto L12
            int r4 = r0.length     // Catch: java.lang.Throwable -> L10
            if (r4 == r1) goto L1e
            goto L12
        L10:
            r0 = move-exception
            goto L42
        L12:
            java.lang.String[] r0 = new java.lang.String[r1]     // Catch: java.lang.Throwable -> L10
            r4 = r3
        L15:
            if (r4 >= r1) goto L1e
            java.lang.String r5 = "0"
            r0[r4] = r5     // Catch: java.lang.Throwable -> L10
            int r4 = r4 + 1
            goto L15
        L1e:
            r1 = r3
        L1f:
            int r4 = r0.length     // Catch: java.lang.Throwable -> L10
            if (r1 >= r4) goto L41
            r4 = r0[r1]     // Catch: java.lang.Throwable -> L10
            int r4 = r4.length()     // Catch: java.lang.Throwable -> L10
            r5 = 2
            if (r4 <= r5) goto L33
            r4 = r0[r1]     // Catch: java.lang.Throwable -> L10
            java.lang.String r4 = r4.substring(r3, r5)     // Catch: java.lang.Throwable -> L10
            r0[r1] = r4     // Catch: java.lang.Throwable -> L10
        L33:
            r4 = r0[r1]     // Catch: java.lang.Throwable -> L10
            r5 = 16
            int r4 = java.lang.Integer.parseInt(r4, r5)     // Catch: java.lang.Throwable -> L10
            byte r4 = (byte) r4     // Catch: java.lang.Throwable -> L10
            r2[r1] = r4     // Catch: java.lang.Throwable -> L10
            int r1 = r1 + 1
            goto L1f
        L41:
            return r2
        L42:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "getMacBa "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            java.lang.String r1 = "Req"
            com.autonavi.aps.amapapi.utils.CoreUtil.reportError(r0, r1, r7)
            java.lang.String r7 = "00:00:00:00:00:00"
            byte[] r6 = r6.a(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.trans.Req.a(java.lang.String):byte[]");
    }

    public static void addHistoryCell(Cgi cgi, List<Cgi> list, int i10) {
        if (cgi == null || list == null) {
            return;
        }
        int size = list.size();
        if (size == 0) {
            list.add(cgi);
            return;
        }
        int i11 = -1;
        long jMin = Long.MAX_VALUE;
        int i12 = 0;
        int i13 = -1;
        while (true) {
            if (i12 >= size) {
                i11 = i13;
                break;
            }
            Cgi cgi2 = list.get(i12);
            if (cgi.getKeyWithDifferentApi() == null || !cgi.getKeyWithDifferentApi().equals(cgi2.getKeyWithDifferentApi())) {
                jMin = Math.min(jMin, cgi2.lastUpdateUtcMills);
                if (jMin == cgi2.lastUpdateUtcMills) {
                    i13 = i12;
                }
                i12++;
            } else {
                int i14 = cgi.signalStrength;
                if (i14 != cgi2.signalStrength) {
                    cgi2.lastUpdateUtcMills = cgi.lastUpdateUtcMills;
                    cgi2.signalStrength = i14;
                }
            }
        }
        if (i11 >= 0) {
            if (size < i10) {
                list.add(cgi);
            } else {
                if (cgi.lastUpdateUtcMills <= jMin || i11 >= size) {
                    return;
                }
                list.remove(i11);
                list.add(cgi);
            }
        }
    }

    public static void save(byte[] bArr, int i10) {
    }

    /* JADX WARN: Can't wrap try/catch for region: R(47:14|15|21|(8:26|(1:28)(1:29)|30|(7:32|(1:34)(1:35)|36|(1:38)(1:39)|40|(1:42)(1:43)|44)(12:(11:47|(1:49)(1:50)|51|(1:53)(1:54)|55|(1:57)(1:58)|59|(1:61)(1:62)|63|(1:65)(1:66)|67)|68|(1:70)(1:71)|(1:75)|76|(1:78)(1:79)|80|(1:82)|83|(1:85)(1:86)|87|(2:89|(2:91|92)(3:93|(10:95|(1:97)(1:98)|99|(1:101)(1:102)|103|(1:105)(1:106)|(1:110)|111|(1:410)(8:113|(1:115)(1:116)|117|(1:119)|120|(1:122)(1:123)|124|409)|125)|408))(1:(2:127|92)(1:128)))|45|68|(0)(0)|(9:75|76|(0)(0)|80|(0)|83|(0)(0)|87|(0)(0))(0))(1:25)|129|(1:137)(43:386|133|134|138|(1:204)(4:141|(11:143|(2:145|(1:149)(6:(3:151|(1:153)|154)(2:155|(4:157|(1:159)|160|161))|167|(1:172)|173|(2:191|(1:399)(5:193|(1:195)|(1:198)|199|(3:201|190|398)(1:400)))(2:179|(1:397)(6:183|(1:185)|(1:188)|189|190|398))|202))(1:162)|163|(1:165)|166|161|167|(2:170|172)(0)|173|(3:175|191|(0)(0))(0)|202)|395|203)|205|(1:234)(15:210|391|211|212|388|213|(1:215)|216|217|218|221|(1:226)|227|(2:229|230)|231)|235|(1:237)(7:238|(1:240)(1:241)|(1:243)|244|(10:246|373|247|248|250|(1:255)|256|(1:263)|(2:265|406)(1:407)|266)|405|267)|268|390|269|(1:271)(3:272|(1:274)|(1:276)(31:279|280|278|282|375|283|(1:285)|286|380|288|289|(3:377|291|292)|293|393|296|297|384|298|299|(1:301)(1:303)|302|304|(1:306)|307|(5:309|(1:311)(1:312)|313|(5:382|315|(6:318|(4:324|337|(1:339)|340)(2:325|(3:327|(1:329)|330)(4:331|(3:333|(1:335)|336)|342|343))|341|342|343|316)|401|344)|346)|347|(4:349|(1:351)(1:352)|353|(3:355|(6:358|(1:360)|361|(2:363|403)(1:404)|364|356)|402))|365|(1:367)|368|369))|277|278|282|375|283|(0)|286|380|288|289|(0)|293|393|296|297|384|298|299|(0)(0)|302|304|(0)|307|(0)|347|(0)|365|(0)|368|369)|136|138|(1:204)(0)|205|(2:207|234)(0)|235|(0)(0)|268|390|269|(0)(0)|277|278|282|375|283|(0)|286|380|288|289|(0)|293|393|296|297|384|298|299|(0)(0)|302|304|(0)|307|(0)|347|(0)|365|(0)|368|369) */
    /* JADX WARN: Code restructure failed: missing block: B:281:0x06ee, code lost:
    
        r7[r0] = 0;
        r28 = 1;
        r5 = r0 + 1;
        r2 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:287:0x0710, code lost:
    
        r2 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:294:0x0726, code lost:
    
        r2 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:295:0x0727, code lost:
    
        r5 = r5 + r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:126:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0374 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x048c  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x04ed  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x04fb  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x054b  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x055f  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x05ff  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0616  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x061c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x06c8 A[Catch: all -> 0x06ee, TryCatch #9 {all -> 0x06ee, blocks: (B:269:0x06c4, B:271:0x06c8, B:277:0x06d9, B:272:0x06cb, B:276:0x06d7, B:279:0x06e0), top: B:390:0x06c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:272:0x06cb A[Catch: all -> 0x06ee, TryCatch #9 {all -> 0x06ee, blocks: (B:269:0x06c4, B:271:0x06c8, B:277:0x06d9, B:272:0x06cb, B:276:0x06d7, B:279:0x06e0), top: B:390:0x06c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0704 A[Catch: all -> 0x0710, TRY_LEAVE, TryCatch #1 {all -> 0x0710, blocks: (B:283:0x06fc, B:285:0x0704), top: B:375:0x06fc }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0741  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0744  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0752  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x076a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x0851  */
    /* JADX WARN: Removed duplicated region for block: B:367:0x08f0  */
    /* JADX WARN: Removed duplicated region for block: B:377:0x0718 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:399:0x0534 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0220 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x026e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public byte[] buildBinary() throws java.io.UnsupportedEncodingException {
        /*
            Method dump skipped, instructions count: 2335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.trans.Req.buildBinary():byte[]");
    }

    public void createReq(Context context, boolean z10, boolean z11, CgiManager cgiManager, WifiManagerWrapper wifiManagerWrapper, ConnectivityManager connectivityManager, String str, String str2, boolean z12, HistoryLocationRecorder historyLocationRecorder) {
        String str3;
        String str4;
        NetworkInfo activeNetworkInfo;
        boolean z13;
        String netMode;
        ArrayList<AmapWifi> arrayList;
        int length;
        String strN = C1567j0.n(context);
        int iRandomInt = Utils.randomInt(-32768, 32767);
        this.sCxtFromServer = str2;
        this.f18408c = null;
        if (z11) {
            str3 = CoreUtil.AMAP_SRC;
            str4 = CoreUtil.AMAP_LICENSE;
        } else {
            str3 = CoreUtil.STR_ORIGN_SRC;
            str4 = CoreUtil.STR_ORIGN_LICENSE;
        }
        String str5 = str4;
        String str6 = str3;
        StringBuilder sb2 = new StringBuilder();
        int cgiFlag = cgiManager.getCgiFlag();
        int mainCgiTypeMasked = cgiManager.getMainCgiTypeMasked();
        TelephonyManager telephonyManagerInstance = cgiManager.getTelephonyManagerInstance();
        ArrayList<Cgi> detectedCgiList = cgiManager.getDetectedCgiList();
        ArrayList<Cgi> detectedCgiV2List = cgiManager.getDetectedCgiV2List();
        ArrayList<AmapWifi> scanResultsParam = wifiManagerWrapper.getScanResultsParam();
        String str7 = "1";
        String str8 = mainCgiTypeMasked == 2 ? "1" : "0";
        if (telephonyManagerInstance != null) {
            if (TextUtils.isEmpty(CoreUtil.strImeiMeid)) {
                try {
                    CoreUtil.strImeiMeid = S0.h();
                } catch (Throwable th) {
                    CoreUtil.reportError(th, "Aps", "getApsReq part4");
                }
            }
            TextUtils.isEmpty(CoreUtil.strImeiMeid);
            if (TextUtils.isEmpty(CoreUtil.strImsi)) {
                try {
                    String str9 = S0.f16312a;
                    CoreUtil.strImsi = "";
                } catch (SecurityException unused) {
                } catch (Throwable th2) {
                    CoreUtil.reportError(th2, "Aps", "getApsReq part2");
                }
            }
            TextUtils.isEmpty(CoreUtil.strImsi);
        }
        try {
            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Throwable th3) {
            CoreUtil.reportError(th3, "Aps", "getApsReq part");
            activeNetworkInfo = null;
        }
        boolean zWifiAccess = wifiManagerWrapper.wifiAccess(connectivityManager);
        if (Utils.getNetT(activeNetworkInfo) != -1) {
            z13 = zWifiAccess;
            netMode = Utils.getNetMode(context, connectivityManager);
            if (z13) {
                str7 = "2";
            }
        } else {
            z13 = zWifiAccess;
            netMode = "";
            str7 = netMode;
        }
        if ((cgiFlag & 4) != 4 || detectedCgiV2List.isEmpty()) {
            this.cellsV2.clear();
        } else {
            this.cellsV2.clear();
            this.cellsV2.addAll(detectedCgiV2List);
        }
        this.cellsV1.clear();
        this.cellsV1.addAll(detectedCgiList);
        StringBuilder sb3 = new StringBuilder();
        if (wifiManagerWrapper.isWifiEnabled()) {
            if (z13) {
                WifiInfoWrapper wifiAccess = wifiManagerWrapper.getWifiAccess();
                if (wifiManagerWrapper.wifiUseful(wifiAccess)) {
                    sb3.append(wifiAccess.getBSSID());
                    sb3.append(Const.STR_MART_COMMA);
                    int rssi = wifiAccess.getRssi();
                    if (rssi < -128 || rssi > 127) {
                        rssi = 0;
                    }
                    sb3.append(rssi);
                    sb3.append(Const.STR_MART_COMMA);
                    String ssid = wifiAccess.getSSID();
                    try {
                        length = ssid.getBytes("UTF-8").length;
                    } catch (Exception unused2) {
                        length = 32;
                    }
                    if (length >= 32) {
                        ssid = "unkwn";
                    }
                    sb3.append(ssid.replace("*", "."));
                }
            }
            if (scanResultsParam != null && (arrayList = this.wifiScanResultList) != null) {
                arrayList.clear();
                this.wifiScanResultList.addAll(scanResultsParam);
            }
        } else {
            wifiManagerWrapper.resetWifiData();
            ArrayList<AmapWifi> arrayList2 = this.wifiScanResultList;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
        }
        this.respctrl = (short) 0;
        if (!z10) {
            this.respctrl = (short) 2;
        }
        if (z12) {
            this.respctrl = (short) (this.respctrl | 22);
        }
        this.src = str6;
        this.license = str5;
        this.model = Build.MODEL;
        this.os = UxipConstants.f30662a + Build.VERSION.RELEASE;
        this.appname = Utils.getAppName(context);
        this.iscdma = str8;
        this.gtype = "0";
        this.gmock = "0";
        this.glon = "0";
        this.glat = "0";
        this.accu = "0";
        this.extrakey = strN;
        this.imeimeid = CoreUtil.strImeiMeid;
        this.imsi = CoreUtil.strImsi;
        this.id = String.valueOf(iRandomInt);
        this.smac = Utils.getDeviceMac(context);
        this.sdkv = CoreUtil.STR_CONFIG_VERSION;
        this.colv = str;
        this.phnum = "";
        this.nettype = netMode;
        this.inftype = str7;
        this.cgiflag = cgiFlag;
        this.networkOperator = cgiManager.getRawOperatorStr();
        this.macsage = wifiManagerWrapper.getWifiAge();
        this.mmac = sb3.toString();
        this.mmacAge = (int) ((Utils.getTimeBoot() - wifiManagerWrapper.getMMacUpdateTime()) / 1000);
        try {
            if (TextUtils.isEmpty(utdid)) {
                utdid = S0.D(context);
            }
        } catch (Throwable unused3) {
        }
        try {
            if (TextUtils.isEmpty(adiu)) {
                adiu = S0.q(context);
            }
        } catch (Throwable unused4) {
        }
        try {
            if (TextUtils.isEmpty(this.sn)) {
                String str10 = S0.f16312a;
                this.sn = "";
            }
        } catch (Throwable unused5) {
        }
        try {
            if (TextUtils.isEmpty(this.oaid)) {
                this.oaid = S0.A(context);
            }
        } catch (Throwable unused6) {
        }
        try {
            this.f18408c = historyLocationRecorder.produceContextContent(this.cellsV2, this.wifiScanResultList);
            ArrayList<Cgi> arrayList3 = this.cellsV1;
            ArrayList<Cgi> arrayList4 = this.cellsV2;
            if (arrayList4 != null && arrayList4.size() > 0) {
                Iterator<Cgi> it = arrayList4.iterator();
                while (it.hasNext()) {
                    Cgi next = it.next();
                    if (next.newApi && next.isMain) {
                        addHistoryCell(next, this.f18409d, 3);
                        break;
                    }
                }
                if (arrayList3 != null) {
                    addHistoryCell(arrayList3.get(0), this.f18409d, 3);
                }
            } else if (arrayList3 != null && arrayList3.size() > 0) {
                addHistoryCell(arrayList3.get(0), this.f18409d, 3);
            }
        } catch (Throwable th4) {
            th4.printStackTrace();
        }
        sb2.delete(0, sb2.length());
        sb3.delete(0, sb3.length());
    }

    public void a() {
        String[] strArr = new String[27];
        strArr[0] = this.action;
        strArr[1] = this.src;
        strArr[2] = this.license;
        strArr[3] = this.srvip;
        strArr[4] = this.model;
        strArr[5] = this.os;
        strArr[6] = this.appname;
        strArr[7] = this.iscdma;
        strArr[8] = this.glon;
        strArr[9] = this.glat;
        strArr[10] = this.accu;
        strArr[11] = this.extrakey;
        strArr[12] = this.imeimeid;
        strArr[13] = this.imsi;
        strArr[14] = this.uuid;
        strArr[15] = this.id;
        strArr[16] = this.smac;
        strArr[17] = this.phnum;
        strArr[18] = this.sdkv;
        strArr[19] = this.colv;
        strArr[20] = this.nettype;
        strArr[21] = this.mmac;
        strArr[22] = this.macsage;
        strArr[23] = this.poiid;
        strArr[24] = utdid;
        strArr[25] = this.sn;
        strArr[26] = this.oaid;
        for (int i10 = 0; i10 < 27; i10++) {
            if (TextUtils.isEmpty(strArr[i10])) {
                strArr[i10] = "";
            }
        }
        if (TextUtils.isEmpty(this.gtype)) {
            this.gtype = "0";
        } else if (!"0".equals(this.gtype) && !"2".equals(this.gtype)) {
            this.gtype = "0";
        }
        if (TextUtils.isEmpty(this.gmock)) {
            this.gmock = "0";
        } else if (!"0".equals(this.gmock) && !"1".equals(this.gmock)) {
            this.gmock = "0";
        }
        if (TextUtils.isEmpty(this.inftype)) {
            this.inftype = "0";
        } else if (!"1".equals(this.inftype) && !"2".equals(this.inftype)) {
            this.inftype = "0";
        }
        if (!CgiManager.isValidCgiFlag(this.cgiflag)) {
            this.cgiflag = 0;
        }
        if (this.cor == null) {
            this.cor = new byte[0];
        }
    }

    private int a(String str, byte[] bArr, int i10) {
        try {
            if (TextUtils.isEmpty(str)) {
                bArr[i10] = 0;
                return i10 + 1;
            }
            byte[] bytes = str.getBytes(Const.STR_APS_ENCODE);
            int length = bytes.length;
            if (length > 127) {
                length = 127;
            }
            bArr[i10] = (byte) length;
            int i11 = i10 + 1;
            System.arraycopy(bytes, 0, bArr, i11, length);
            return i11 + length;
        } catch (Throwable th) {
            CoreUtil.reportError(th, "Req", "copyContentWithByteLen");
            bArr[i10] = 0;
            return i10 + 1;
        }
    }
}
