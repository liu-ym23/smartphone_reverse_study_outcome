package com.baidu.location.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityNr;
import android.telephony.CellIdentityTdscdma;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoTdscdma;
import android.telephony.CellInfoWcdma;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthNr;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import androidx.room.AbstractC0351g;
import ch.qos.logback.core.spi.AbstractComponentTracker;
import com.baidu.location.b.aa;
import com.baidu.location.b.p;
import com.baidu.location.b.v;
import com.baidu.location.c.g;
import com.baidu.location.pb.CellCommonValue;
import com.baidu.location.pb.CellValue;
import com.baidu.location.pb.CellValueList;
import com.baidu.location.pb.LteCellValue;
import com.baidu.location.pb.NrCellValue;
import com.stepos.activeview.utils.Constants;
import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.alphame.suggest.AppSuggestStorable;
import com.stepos.alphame.utils.Consts;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: classes.dex */
public class f {

    /* renamed from: e, reason: collision with root package name */
    private g f5696e;

    /* renamed from: f, reason: collision with root package name */
    private b f5697f;

    /* renamed from: g, reason: collision with root package name */
    private TelephonyManager f5698g;

    /* renamed from: a, reason: collision with root package name */
    private final String f5692a = "NetLocDataManager";

    /* renamed from: b, reason: collision with root package name */
    private final int f5693b = 2000;

    /* renamed from: c, reason: collision with root package name */
    private final int f5694c = 100;

    /* renamed from: d, reason: collision with root package name */
    private final int f5695d = 30000;

    /* renamed from: h, reason: collision with root package name */
    private ConnectivityManager f5699h = null;

    /* renamed from: i, reason: collision with root package name */
    private WifiManager f5700i = null;

    /* renamed from: j, reason: collision with root package name */
    private Handler f5701j = null;

    /* renamed from: k, reason: collision with root package name */
    private String f5702k = null;

    /* renamed from: l, reason: collision with root package name */
    private boolean f5703l = false;

    /* renamed from: m, reason: collision with root package name */
    private long f5704m = 0;

    /* renamed from: n, reason: collision with root package name */
    private long f5705n = 0;

    /* renamed from: o, reason: collision with root package name */
    private long f5706o = 0;

    /* renamed from: p, reason: collision with root package name */
    private long f5707p = 0;

    /* renamed from: q, reason: collision with root package name */
    private boolean f5708q = false;

    /* renamed from: r, reason: collision with root package name */
    private boolean f5709r = false;

    /* renamed from: s, reason: collision with root package name */
    private long f5710s = 0;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final f f5711a = new f();
    }

    public class b extends e {

        /* renamed from: b, reason: collision with root package name */
        private long f5713b = 0;

        /* renamed from: c, reason: collision with root package name */
        private boolean f5714c = false;

        public b() {
        }

        @Override // com.baidu.location.c.e
        public void a(String str) {
        }

        @Override // com.baidu.location.c.e
        public boolean a(Intent intent) {
            String action = intent.getAction();
            if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                final boolean booleanExtra = intent.getBooleanExtra("resultsUpdated", true);
                f.this.f5705n = System.currentTimeMillis() / 1000;
                if (f.this.f5701j == null) {
                    return true;
                }
                f.this.f5701j.post(new Runnable() { // from class: com.baidu.location.c.f.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!f.this.f5703l) {
                            f.this.f5703l = booleanExtra;
                        }
                        p.c().i();
                        if (System.currentTimeMillis() - v.b() <= 5000) {
                            aa.a().c();
                        }
                    }
                });
            } else if (action.equals("android.net.wifi.STATE_CHANGE")) {
                if (!((NetworkInfo) intent.getParcelableExtra("networkInfo")).getState().equals(NetworkInfo.State.CONNECTED) || System.currentTimeMillis() - this.f5713b < 5000) {
                    return false;
                }
                this.f5713b = System.currentTimeMillis();
                if (!this.f5714c) {
                    this.f5714c = true;
                    return false;
                }
                if (f.this.f5701j == null) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.baidu.location.c.e
        public boolean a(List<CellInfo> list) {
            return true;
        }
    }

    public static class c implements Comparator<ScanResult> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(ScanResult scanResult, ScanResult scanResult2) {
            return scanResult2.level - scanResult.level;
        }
    }

    public static class d implements Comparator<h> {
        private d() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(h hVar, h hVar2) {
            return hVar.f5733g - hVar2.f5733g;
        }
    }

    private synchronized String s() {
        String str;
        str = this.f5702k;
        return (str == null || str.length() == 0) ? null : this.f5702k.replace("\n", "");
    }

    private int t() {
        try {
            TelephonyManager telephonyManager = this.f5698g;
            if (telephonyManager != null) {
                return com.baidu.location.e.h.a(telephonyManager.getSignalStrength(), "getLteRssnr");
            }
            return Integer.MAX_VALUE;
        } catch (Exception unused) {
            return Integer.MAX_VALUE;
        }
    }

    public int a(CellIdentityNr cellIdentityNr) {
        try {
            return com.baidu.location.e.h.a(cellIdentityNr, "getHwTac");
        } catch (Throwable unused) {
            return -1;
        }
    }

    @SuppressLint({"NewApi"})
    public long b(k kVar) {
        long jElapsedRealtimeNanos;
        long j4;
        List<ScanResult> list = kVar.f5755a;
        if (list == null || list.size() == 0) {
            return 0L;
        }
        try {
            jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos() / 1000;
        } catch (Error | Exception unused) {
            jElapsedRealtimeNanos = 0;
        }
        boolean z4 = jElapsedRealtimeNanos > 0;
        if (!z4) {
            return 0L;
        }
        int size = kVar.f5755a.size();
        if (size > 16) {
            size = 16;
        }
        long j5 = 2147483647L;
        for (int i4 = 0; i4 < size; i4++) {
            if (kVar.f5755a.get(i4) != null && kVar.f5755a.get(i4).level != 0 && z4) {
                try {
                    j4 = (jElapsedRealtimeNanos - kVar.f5755a.get(i4).timestamp) / 1000000;
                } catch (Error | Exception unused2) {
                    j4 = 0;
                }
                if (j4 < j5) {
                    j5 = j4;
                }
            }
        }
        if (!z4) {
            j5 = 0;
        }
        if (j5 < 0) {
            return 0L;
        }
        return j5;
    }

    public long c(k kVar) {
        long jElapsedRealtimeNanos;
        long j4;
        if (kVar.a() == 0) {
            return 0L;
        }
        try {
            jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos() / 1000;
        } catch (Error | Exception unused) {
            jElapsedRealtimeNanos = 0;
        }
        boolean z4 = jElapsedRealtimeNanos > 0;
        if (!z4) {
            return 0L;
        }
        int size = kVar.f5755a.size();
        if (size > 16) {
            size = 16;
        }
        long j5 = 0;
        long j6 = 0;
        long j7 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            if (kVar.f5755a.get(i4) != null && kVar.f5755a.get(i4).level != 0 && z4) {
                try {
                    j4 = (jElapsedRealtimeNanos - kVar.f5755a.get(i4).timestamp) / 1000000;
                } catch (Error | Exception unused2) {
                    j4 = 0;
                }
                j7 += j4;
                j5++;
                if (j4 > j6) {
                    j6 = j4;
                }
            }
        }
        return j5 > 1 ? (j7 - j6) / (j5 - 1) : j6;
    }

    public synchronized void d() {
        c();
        this.f5698g = null;
        this.f5700i = null;
        this.f5697f = null;
    }

    public boolean e() {
        g gVar = this.f5696e;
        if (gVar != null) {
            return gVar.d();
        }
        return false;
    }

    public synchronized com.baidu.location.c.a f() {
        if (this.f5696e == null) {
            return null;
        }
        a(this.f5698g, com.baidu.location.e.h.aJ, com.baidu.location.e.h.aK, com.baidu.location.e.h.aL, com.baidu.location.e.h.aM);
        com.baidu.location.c.a aVarD = this.f5696e.d(30000);
        this.f5708q = a(aVarD, 30000, com.baidu.location.b.c.b().dI);
        return aVarD;
    }

    public int g() {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = this.f5699h;
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return 0;
            }
            return activeNetworkInfo.getSubtype();
        } catch (Exception unused) {
            return 0;
        }
    }

    public String h() {
        int simState = -1;
        try {
            TelephonyManager telephonyManager = this.f5698g;
            if (telephonyManager != null) {
                simState = telephonyManager.getSimState();
            }
        } catch (Exception unused) {
        }
        return AbstractC0351g.m("&sim=", simState);
    }

    public void i() {
        this.f5710s = 0L;
    }

    public boolean j() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j4 = this.f5704m;
        if (jCurrentTimeMillis - j4 > 0 && jCurrentTimeMillis - j4 <= 5000) {
            return false;
        }
        this.f5704m = jCurrentTimeMillis;
        i();
        return k();
    }

    public boolean k() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        g gVar = this.f5696e;
        long jC = gVar != null ? gVar.c() : 0L;
        long j4 = jCurrentTimeMillis - jC;
        if (j4 > 0) {
            long j5 = this.f5710s;
            if (j4 <= j5 + 5000 || jCurrentTimeMillis - (this.f5705n * 1000) <= j5 + 5000 || j4 < 25000) {
                return false;
            }
            if (l() && !m() && j4 <= this.f5710s + AbstractComponentTracker.LINGERING_TIMEOUT) {
                return false;
            }
        }
        return a(jC);
    }

    public boolean l() {
        try {
            ConnectivityManager connectivityManager = this.f5699h;
            if (connectivityManager != null) {
                return connectivityManager.getNetworkInfo(1).isConnected();
            }
        } catch (Error | Exception unused) {
        }
        return false;
    }

    public boolean m() {
        return false;
    }

    @SuppressLint({"NewApi"})
    public String n() {
        WifiManager wifiManager = this.f5700i;
        if (wifiManager == null) {
            return "";
        }
        try {
            if (!wifiManager.isWifiEnabled()) {
                if (!this.f5700i.isScanAlwaysAvailable()) {
                    return "";
                }
            }
            return "&wifio=1";
        } catch (Exception | NoSuchMethodError unused) {
            return "";
        }
    }

    public String o() {
        g gVar = this.f5696e;
        if (gVar == null || com.baidu.location.e.h.f5920f == 4) {
            return null;
        }
        return gVar.e();
    }

    public WifiInfo p() {
        g gVar;
        if (com.baidu.location.e.h.f5920f == 4 || (gVar = this.f5696e) == null) {
            return null;
        }
        return gVar.f();
    }

    public String q() {
        k kVarR;
        if (com.baidu.location.b.c.b().dl == 0 || (kVarR = r()) == null || kVarR.a() < 1) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (ScanResult scanResult : kVarR.f5755a) {
            if (scanResult != null && scanResult.level != 0 && scanResult.BSSID != null) {
                arrayList.add(scanResult);
            }
        }
        Collections.sort(arrayList, new c());
        int iMin = Math.min(com.baidu.location.b.c.b().dn, arrayList.size());
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < iMin; i4++) {
            String strReplace = ((ScanResult) arrayList.get(i4)).BSSID.replace(AwarenessDataItem.USERID_SPLITTER, "");
            String strB = b(((ScanResult) arrayList.get(i4)).SSID);
            int i5 = ((ScanResult) arrayList.get(i4)).level;
            if (i5 < 0) {
                i5 = -i5;
            }
            sb.append(strReplace + "," + strB + "," + i5);
            sb.append(";");
        }
        return sb.toString();
    }

    public k r() {
        g gVar = this.f5696e;
        return (gVar == null || com.baidu.location.e.h.f5920f == 4) ? new k(null, 0L) : gVar.g();
    }

    private String c(String str) {
        return str != null ? (str.contains("&") || str.contains(";")) ? str.replace("&", "_").replace(";", "_") : str : str;
    }

    public int a(k kVar) {
        int i4;
        for (int i5 = 0; i5 < kVar.a(); i5++) {
            if (kVar.f5755a.get(i5) != null && (i4 = -kVar.f5755a.get(i5).level) > 0) {
                return i4;
            }
        }
        return 0;
    }

    public String b(com.baidu.location.c.a aVar) {
        if (this.f5696e == null) {
            return null;
        }
        return this.f5696e.c(aVar) + "&cl_list=" + s();
    }

    private String b(String str) {
        if (str != null && str.length() > com.baidu.location.b.c.b().dm) {
            str = str.substring(0, com.baidu.location.b.c.b().dm);
        }
        return str != null ? (str.contains("&") || str.contains(";")) ? str.replace("&", "_").replace(";", "_") : str : str;
    }

    public int a(String str) {
        if (str == null || !str.contains("mNrTac")) {
            return -1;
        }
        Matcher matcher = Pattern.compile("mNrTac=(.+?)\\}").matcher(str.replace(AwarenessDataItem.PERMISSION_SPLITTER, ""));
        while (true) {
            int i4 = -1;
            while (matcher.find()) {
                if (matcher.groupCount() >= 1) {
                    try {
                        i4 = Integer.parseInt(matcher.group(1));
                    } catch (Throwable unused) {
                    }
                }
            }
            return i4;
        }
    }

    public HashSet<String> c(com.baidu.location.c.a aVar) {
        g gVar = this.f5696e;
        if (gVar != null) {
            return gVar.b(aVar);
        }
        return null;
    }

    public synchronized void b() {
        if (this.f5696e == null) {
            this.f5696e = new g();
        }
        try {
            b bVar = new b();
            this.f5697f = bVar;
            g gVar = this.f5696e;
            if (gVar != null) {
                gVar.a(bVar);
            }
        } catch (Exception unused) {
        }
    }

    public void c() {
        g gVar = this.f5696e;
        if (gVar != null) {
            gVar.b();
        }
    }

    @SuppressLint({"NewApi"})
    public boolean b(long j4) {
        k kVarR;
        try {
            if ((!this.f5700i.isWifiEnabled() && !this.f5700i.isScanAlwaysAvailable()) || l() || (kVarR = r()) == null) {
                return false;
            }
            return a(kVarR, j4);
        } catch (Exception | NoSuchMethodError unused) {
            return false;
        }
    }

    public com.baidu.location.c.a a(com.baidu.location.c.a aVar, TelephonyManager telephonyManager) {
        g gVar = this.f5696e;
        if (gVar != null) {
            return gVar.a(aVar, telephonyManager);
        }
        return null;
    }

    public static f a() {
        return a.f5711a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.baidu.location.c.f] */
    /* JADX WARN: Type inference failed for: r7v1, types: [com.baidu.location.c.h] */
    /* JADX WARN: Type inference failed for: r7v31, types: [com.baidu.location.c.h] */
    /* JADX WARN: Type inference failed for: r7v33 */
    /* JADX WARN: Type inference failed for: r7v34 */
    /* JADX WARN: Type inference failed for: r7v35 */
    /* JADX WARN: Type inference failed for: r7v36 */
    /* JADX WARN: Type inference failed for: r9v27 */
    /* JADX WARN: Type inference failed for: r9v28 */
    /* JADX WARN: Type inference failed for: r9v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v4, types: [com.baidu.location.c.h] */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v8 */
    private h a(CellInfo cellInfo, TelephonyManager telephonyManager) {
        long jElapsedRealtime;
        long jCurrentTimeMillis;
        try {
            if (cellInfo instanceof CellInfoGsm) {
                h hVar = new h();
                CellIdentityGsm cellIdentity = ((CellInfoGsm) cellInfo).getCellIdentity();
                hVar.f5727a = 1;
                if (cellInfo.isRegistered()) {
                    hVar.f5730d = 1;
                }
                hVar.f5728b = cellIdentity.getMccString();
                hVar.f5729c = cellIdentity.getMncString();
                hVar.f5732f = cellInfo.getCellConnectionStatus();
                jElapsedRealtime = SystemClock.elapsedRealtime() - cellInfo.getTimestampMillis();
                jCurrentTimeMillis = System.currentTimeMillis();
                this = hVar;
            } else {
                CellIdentityNr cellIdentityNr = null;
                if (cellInfo instanceof CellInfoCdma) {
                    h hVar2 = new h();
                    CellIdentityCdma cellIdentity2 = ((CellInfoCdma) cellInfo).getCellIdentity();
                    hVar2.f5727a = 2;
                    hVar2.f5729c = cellIdentity2.getSystemId() != Integer.MAX_VALUE ? String.valueOf(cellIdentity2.getSystemId()) : null;
                    if (cellInfo.isRegistered()) {
                        hVar2.f5730d = 1;
                    }
                    hVar2.f5732f = cellInfo.getCellConnectionStatus();
                    try {
                        String networkOperator = telephonyManager.getNetworkOperator();
                        if (!TextUtils.isEmpty(networkOperator) && networkOperator.length() >= 3) {
                            hVar2.f5728b = networkOperator.substring(0, 3);
                        }
                    } catch (Exception unused) {
                    }
                    jElapsedRealtime = SystemClock.elapsedRealtime() - cellInfo.getTimestampMillis();
                    jCurrentTimeMillis = System.currentTimeMillis();
                    this = hVar2;
                } else if (cellInfo instanceof CellInfoWcdma) {
                    h hVar3 = new h();
                    CellIdentityWcdma cellIdentity3 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                    hVar3.f5727a = 4;
                    if (cellInfo.isRegistered()) {
                        hVar3.f5730d = 1;
                    }
                    hVar3.f5728b = cellIdentity3.getMccString();
                    hVar3.f5729c = cellIdentity3.getMncString();
                    hVar3.f5732f = cellInfo.getCellConnectionStatus();
                    jElapsedRealtime = SystemClock.elapsedRealtime() - cellInfo.getTimestampMillis();
                    jCurrentTimeMillis = System.currentTimeMillis();
                    this = hVar3;
                } else {
                    if (!(cellInfo instanceof CellInfoTdscdma)) {
                        h hVar4 = cellInfo instanceof CellInfoLte;
                        try {
                            if (hVar4 != 0) {
                                i iVar = new i();
                                CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                                CellIdentityLte cellIdentity4 = cellInfoLte.getCellIdentity();
                                CellSignalStrengthLte cellSignalStrength = cellInfoLte.getCellSignalStrength();
                                iVar.f5727a = 3;
                                if (cellInfo.isRegistered()) {
                                    iVar.f5730d = 1;
                                }
                                iVar.f5734h = cellIdentity4.getCi();
                                iVar.f5735i = cellIdentity4.getPci();
                                iVar.f5736j = cellIdentity4.getTac();
                                iVar.f5744r = cellSignalStrength.getTimingAdvance();
                                iVar.f5728b = cellIdentity4.getMccString();
                                iVar.f5729c = cellIdentity4.getMncString();
                                iVar.f5732f = cellInfo.getCellConnectionStatus();
                                iVar.f5738l = cellIdentity4.getBandwidth();
                                iVar.f5737k = cellIdentity4.getEarfcn();
                                iVar.f5739m = Math.abs(cellSignalStrength.getRssi());
                                iVar.f5740n = Math.abs(cellSignalStrength.getRsrp());
                                iVar.f5733g = Math.abs(cellSignalStrength.getRsrp());
                                iVar.f5741o = cellSignalStrength.getRsrq();
                                int rssnr = cellSignalStrength.getRssnr();
                                if (rssnr == Integer.MAX_VALUE && cellInfo.isRegistered()) {
                                    rssnr = t();
                                }
                                iVar.f5742p = rssnr;
                                iVar.f5743q = cellSignalStrength.getCqi();
                                iVar.f5731e = System.currentTimeMillis() - (SystemClock.elapsedRealtime() - cellInfo.getTimestampMillis());
                                hVar4 = iVar;
                            } else {
                                if (!(cellInfo instanceof CellInfoNr)) {
                                    return null;
                                }
                                j jVar = new j();
                                try {
                                    cellIdentityNr = (CellIdentityNr) ((CellInfoNr) cellInfo).getCellIdentity();
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                                CellSignalStrengthNr cellSignalStrengthNr = (CellSignalStrengthNr) ((CellInfoNr) cellInfo).getCellSignalStrength();
                                if (cellIdentityNr != null) {
                                    jVar.f5727a = 6;
                                    jVar.f5728b = cellIdentityNr.getMccString();
                                    jVar.f5729c = cellIdentityNr.getMncString();
                                    jVar.f5745h = cellIdentityNr.getNci();
                                    jVar.f5746i = cellIdentityNr.getPci();
                                    int tac = cellIdentityNr.getTac();
                                    jVar.f5747j = tac;
                                    if (tac == Integer.MAX_VALUE) {
                                        try {
                                            jVar.f5747j = a(cellIdentityNr);
                                        } catch (Throwable unused2) {
                                        }
                                    }
                                    if (jVar.f5747j == Integer.MAX_VALUE) {
                                        try {
                                            jVar.f5747j = a(cellIdentityNr.toString());
                                        } catch (Throwable unused3) {
                                        }
                                    }
                                    jVar.f5748k = cellIdentityNr.getNrarfcn();
                                }
                                if (cellInfo.isRegistered()) {
                                    jVar.f5730d = 1;
                                }
                                jVar.f5732f = cellInfo.getCellConnectionStatus();
                                jVar.f5749l = Math.abs(cellSignalStrengthNr.getSsRsrp());
                                jVar.f5733g = Math.abs(cellSignalStrengthNr.getSsRsrp());
                                jVar.f5750m = Math.abs(cellSignalStrengthNr.getSsRsrq());
                                jVar.f5751n = cellSignalStrengthNr.getSsSinr();
                                jVar.f5752o = Math.abs(cellSignalStrengthNr.getCsiRsrp());
                                jVar.f5753p = Math.abs(cellSignalStrengthNr.getCsiRsrq());
                                jVar.f5754q = cellSignalStrengthNr.getCsiSinr();
                                jVar.f5731e = System.currentTimeMillis() - (SystemClock.elapsedRealtime() - cellInfo.getTimestampMillis());
                                hVar4 = jVar;
                            }
                        } catch (Error unused4) {
                            hVar4.f5731e = System.currentTimeMillis();
                        }
                        return hVar4;
                    }
                    h hVar5 = new h();
                    CellIdentityTdscdma cellIdentity5 = ((CellInfoTdscdma) cellInfo).getCellIdentity();
                    hVar5.f5727a = 5;
                    if (cellInfo.isRegistered()) {
                        hVar5.f5730d = 1;
                    }
                    hVar5.f5728b = cellIdentity5.getMccString();
                    hVar5.f5729c = cellIdentity5.getMncString();
                    hVar5.f5732f = cellInfo.getCellConnectionStatus();
                    jElapsedRealtime = SystemClock.elapsedRealtime() - cellInfo.getTimestampMillis();
                    jCurrentTimeMillis = System.currentTimeMillis();
                    this = hVar5;
                }
            }
            this.f5731e = jCurrentTimeMillis - jElapsedRealtime;
            return this;
        } catch (Error unused5) {
            this.f5731e = System.currentTimeMillis();
            return this;
        }
    }

    public k a(int i4) {
        g gVar = this.f5696e;
        if (gVar != null) {
            return gVar.e(i4);
        }
        return null;
    }

    public String a(int i4, k kVar) {
        if (i4 == 0) {
            return null;
        }
        int i5 = 1;
        if (kVar.a() < 1) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(256);
        int size = kVar.f5755a.size();
        int i6 = com.baidu.location.e.h.f5903N;
        if (size > i6) {
            size = i6;
        }
        int i7 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            if (kVar.f5755a.get(i8) != null) {
                if ((i5 & i4) != 0 && kVar.f5755a.get(i8).BSSID != null) {
                    stringBuffer.append(i7 == 0 ? "&ssid=" : Consts.SPLITTER_DETAIL);
                    stringBuffer.append(kVar.f5755a.get(i8).BSSID.replace(AwarenessDataItem.USERID_SPLITTER, ""));
                    stringBuffer.append(";");
                    stringBuffer.append(c(kVar.f5755a.get(i8).SSID));
                    i7++;
                }
                i5 <<= 1;
            }
        }
        return stringBuffer.toString();
    }

    public String a(int i4, boolean z4, k kVar, int i5) {
        g gVar = this.f5696e;
        if (gVar != null) {
            return gVar.a(i4, z4, kVar, i5);
        }
        return null;
    }

    public String a(WifiInfo wifiInfo, String str) {
        g gVar = this.f5696e;
        if (gVar != null) {
            return gVar.a(wifiInfo, str);
        }
        return null;
    }

    public String a(com.baidu.location.c.a aVar) {
        g gVar = this.f5696e;
        if (gVar != null) {
            return gVar.a(aVar);
        }
        return null;
    }

    public String a(k kVar, int i4, String str, boolean z4, int i5) {
        g gVar = this.f5696e;
        if (gVar != null) {
            return gVar.a(kVar, i4, str, z4, i5);
        }
        return null;
    }

    private String a(List<CellInfo> list, TelephonyManager telephonyManager, int i4, int[] iArr, boolean z4, int i5) {
        ArrayList arrayList = new ArrayList();
        if (i4 != 1 && com.baidu.location.b.c.b().cb != 1) {
            return null;
        }
        boolean z5 = com.baidu.location.b.c.b().cb != 1 && z4;
        Iterator<CellInfo> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next(), telephonyManager));
        }
        return a(a(arrayList, i5), iArr, z5);
    }

    private static List<h> a(List<h> list, int i4) {
        if (list.size() == 0) {
            return null;
        }
        if (list.size() == 1) {
            return list;
        }
        Collections.sort(list.subList(1, list.size()), new d());
        list.size();
        return list.subList(0, Math.min(list.size(), i4));
    }

    public synchronized void a(Context context) {
        try {
            if (this.f5696e == null) {
                return;
            }
            try {
                this.f5698g = (TelephonyManager) context.getSystemService("phone");
                this.f5700i = (WifiManager) context.getSystemService(AppSuggestStorable.COLUMN_WIFI);
                this.f5699h = (ConnectivityManager) context.getSystemService("connectivity");
                if (Looper.myLooper() != null) {
                    this.f5701j = new Handler();
                }
                this.f5696e.a(g.a.GET_ALL_DATA);
                a(true);
                this.f5696e.b(true);
                this.f5696e.c(30);
                this.f5696e.a(false);
                this.f5696e.a(context, new ArrayList());
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void a(TelephonyManager telephonyManager, int i4, int[] iArr, boolean z4, int i5) {
        if (telephonyManager != null) {
            try {
                this.f5702k = a(telephonyManager.getAllCellInfo(), telephonyManager, i4, iArr, z4, i5);
            } catch (Throwable unused) {
            }
        }
    }

    public void a(boolean z4) {
        int i4;
        g gVar;
        g gVar2 = this.f5696e;
        if (gVar2 == null || this.f5709r == z4) {
            return;
        }
        if (z4) {
            gVar2.a(100);
            gVar = this.f5696e;
            i4 = 2000;
        } else {
            i4 = 0;
            gVar2.a(0);
            gVar = this.f5696e;
        }
        gVar.b(i4);
        this.f5709r = z4;
    }

    public boolean a(long j4) {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f5706o;
        if (jCurrentTimeMillis >= 0 && jCurrentTimeMillis <= 2000) {
            return false;
        }
        this.f5706o = System.currentTimeMillis();
        if (com.baidu.location.e.h.f5920f != 4) {
            a(0);
        }
        g gVar = this.f5696e;
        return gVar != null && gVar.c() - j4 > 0;
    }

    private boolean a(com.baidu.location.c.a aVar, int i4, int i5) {
        return false;
    }

    public boolean a(com.baidu.location.c.a aVar, com.baidu.location.c.a aVar2) {
        g gVar = this.f5696e;
        if (gVar != null) {
            return gVar.a(aVar, aVar2);
        }
        return false;
    }

    private boolean a(k kVar, long j4) {
        long jElapsedRealtimeNanos;
        List<ScanResult> list;
        long j5;
        try {
            jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos() / 1000;
        } catch (Error | Exception unused) {
            jElapsedRealtimeNanos = 0;
        }
        boolean z4 = jElapsedRealtimeNanos > 0;
        if (!z4 || (list = kVar.f5755a) == null || list.size() == 0) {
            return false;
        }
        int size = kVar.f5755a.size();
        if (size > 16) {
            size = 16;
        }
        long j6 = 0;
        long j7 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            if (kVar.f5755a.get(i4) != null && kVar.f5755a.get(i4).level != 0 && z4) {
                try {
                    j5 = (jElapsedRealtimeNanos - kVar.f5755a.get(i4).timestamp) / 1000000;
                } catch (Error | Exception unused2) {
                    j5 = 0;
                }
                j6 += j5;
                if (j5 > j7) {
                    j7 = j5;
                }
            }
        }
        return j7 * 1000 > j4 || (j6 / ((long) size)) * 1000 > j4;
    }

    public boolean a(k kVar, k kVar2, float f4) {
        boolean zA = kVar2.a(kVar, f4);
        long jCurrentTimeMillis = System.currentTimeMillis() - com.baidu.location.b.b.f5124c;
        if (jCurrentTimeMillis <= 0 || jCurrentTimeMillis >= 30000 || !zA || c(kVar2) - c(kVar) <= 30) {
            return zA;
        }
        return false;
    }

    private String a(List<h> list, int[] iArr, boolean z4) {
        if (list == null || list.size() == 0) {
            return null;
        }
        CellValueList cellValueList = new CellValueList();
        for (h hVar : list) {
            CellValue cellValue = new CellValue();
            CellCommonValue cellCommonValue = new CellCommonValue();
            cellCommonValue.setCellType(hVar.f5727a);
            String str = hVar.f5728b;
            if (str != null) {
                try {
                    cellCommonValue.setMcc(new L1.a(str.getBytes(Constants.UTF_8_CODE)));
                } catch (UnsupportedEncodingException unused) {
                    throw new RuntimeException("UTF-8 not supported?");
                }
            }
            String str2 = hVar.f5729c;
            if (str2 != null) {
                try {
                    cellCommonValue.setMnc(new L1.a(str2.getBytes(Constants.UTF_8_CODE)));
                } catch (UnsupportedEncodingException unused2) {
                    throw new RuntimeException("UTF-8 not supported?");
                }
            }
            cellCommonValue.setRegistered(hVar.f5730d);
            cellCommonValue.setTimestamp(hVar.f5731e);
            int i4 = hVar.f5732f;
            if (i4 != Integer.MAX_VALUE) {
                cellCommonValue.setCellconnectionstatus(i4);
            }
            if (!z4) {
                cellValue.setCellCommonValue(cellCommonValue);
            }
            if (hVar instanceof i) {
                LteCellValue lteCellValue = new LteCellValue();
                i iVar = (i) hVar;
                int i5 = iVar.f5734h;
                if (i5 != Integer.MAX_VALUE && (!z4 || iArr[0] == 1)) {
                    lteCellValue.setCi(i5);
                }
                int i6 = iVar.f5735i;
                if (i6 != Integer.MAX_VALUE && (!z4 || iArr[1] == 1)) {
                    lteCellValue.setPci(i6);
                }
                int i7 = iVar.f5736j;
                if (i7 != Integer.MAX_VALUE && (!z4 || iArr[2] == 1)) {
                    lteCellValue.setTac(i7);
                }
                int i8 = iVar.f5737k;
                if (i8 != Integer.MAX_VALUE && (!z4 || iArr[3] == 1)) {
                    lteCellValue.setEarfcn(i8);
                }
                int i9 = iVar.f5738l;
                if (i9 != Integer.MAX_VALUE && (!z4 || iArr[4] == 1)) {
                    lteCellValue.setBandwidth(i9);
                }
                int i10 = iVar.f5739m;
                if (i10 != Integer.MAX_VALUE && (!z4 || iArr[5] == 1)) {
                    lteCellValue.setRssi(i10);
                }
                int i11 = iVar.f5740n;
                if (i11 != Integer.MAX_VALUE && (!z4 || iArr[6] == 1)) {
                    lteCellValue.setRsrp(i11);
                }
                int i12 = iVar.f5741o;
                if (i12 != Integer.MAX_VALUE && (!z4 || iArr[7] == 1)) {
                    lteCellValue.setRsrq(i12);
                }
                int i13 = iVar.f5742p;
                if (i13 != Integer.MAX_VALUE && (!z4 || iArr[8] == 1)) {
                    lteCellValue.setRssnr(i13);
                }
                int i14 = iVar.f5743q;
                if (i14 != Integer.MAX_VALUE && (!z4 || iArr[9] == 1)) {
                    lteCellValue.setCqi(i14);
                }
                int i15 = iVar.f5744r;
                if (i15 != Integer.MAX_VALUE && (!z4 || iArr[10] == 1)) {
                    lteCellValue.setTimingadvance(i15);
                }
                cellValue.setLteCellValue(lteCellValue);
            } else if (hVar instanceof j) {
                NrCellValue nrCellValue = new NrCellValue();
                j jVar = (j) hVar;
                long j4 = jVar.f5745h;
                if (j4 != LongCompanionObject.MAX_VALUE && (!z4 || iArr[0] == 1)) {
                    nrCellValue.setCi(j4);
                }
                int i16 = jVar.f5746i;
                if (i16 != Integer.MAX_VALUE && (!z4 || iArr[1] == 1)) {
                    nrCellValue.setPci(i16);
                }
                int i17 = jVar.f5747j;
                if (i17 != Integer.MAX_VALUE && (!z4 || iArr[2] == 1)) {
                    nrCellValue.setTac(i17);
                }
                int i18 = jVar.f5748k;
                if (i18 != Integer.MAX_VALUE && (!z4 || iArr[11] == 1)) {
                    nrCellValue.setNrarfcn(i18);
                }
                int i19 = jVar.f5749l;
                if (i19 != Integer.MAX_VALUE && (!z4 || iArr[12] == 1)) {
                    nrCellValue.setSsrsrp(i19);
                }
                int i20 = jVar.f5750m;
                if (i20 != Integer.MAX_VALUE && (!z4 || iArr[13] == 1)) {
                    nrCellValue.setSsrsrq(i20);
                }
                int i21 = jVar.f5751n;
                if (i21 != Integer.MAX_VALUE && (!z4 || iArr[14] == 1)) {
                    nrCellValue.setSssinr(i21);
                }
                int i22 = jVar.f5752o;
                if (i22 != Integer.MAX_VALUE && (!z4 || iArr[15] == 1)) {
                    nrCellValue.setCsirsrp(i22);
                }
                int i23 = jVar.f5753p;
                if (i23 != Integer.MAX_VALUE && (!z4 || iArr[16] == 1)) {
                    nrCellValue.setCsirsrq(i23);
                }
                int i24 = jVar.f5754q;
                if (i24 != Integer.MAX_VALUE && (!z4 || iArr[17] == 1)) {
                    nrCellValue.setCsisinr(i24);
                }
                cellValue.setNrCellValue(nrCellValue);
            }
            cellValueList.addCellValue(cellValue);
        }
        return Base64.encodeToString(cellValueList.toByteArray(), 0);
    }
}
