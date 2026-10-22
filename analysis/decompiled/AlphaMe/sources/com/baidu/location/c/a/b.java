package com.baidu.location.c.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.DhcpInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import ch.qos.logback.classic.net.SyslogAppender;
import ch.qos.logback.core.CoreConstants;
import com.baidu.location.c.e;
import com.baidu.location.c.g;
import com.baidu.location.c.k;
import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.alphame.suggest.AppSuggestStorable;
import com.stepos.alphame.utils.Consts;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import s.AbstractC0831a;

/* loaded from: classes.dex */
public class b implements com.baidu.location.c.b.a {

    /* renamed from: h, reason: collision with root package name */
    private Context f5603h;

    /* renamed from: b, reason: collision with root package name */
    private boolean f5599b = false;

    /* renamed from: e, reason: collision with root package name */
    private WifiManager f5600e = null;

    /* renamed from: f, reason: collision with root package name */
    private C0011b f5601f = null;

    /* renamed from: g, reason: collision with root package name */
    private k f5602g = null;

    /* renamed from: i, reason: collision with root package name */
    private AtomicInteger f5604i = new AtomicInteger(0);

    /* renamed from: a, reason: collision with root package name */
    public long f5598a = 0;

    /* renamed from: j, reason: collision with root package name */
    private long f5605j = 0;

    /* renamed from: k, reason: collision with root package name */
    private long f5606k = 0;

    /* renamed from: l, reason: collision with root package name */
    private long f5607l = 0;

    /* renamed from: m, reason: collision with root package name */
    private String f5608m = null;

    /* renamed from: n, reason: collision with root package name */
    private final Object f5609n = new Object();

    /* renamed from: o, reason: collision with root package name */
    private final Object f5610o = new Object();

    /* renamed from: p, reason: collision with root package name */
    private Handler f5611p = null;

    /* renamed from: q, reason: collision with root package name */
    private String f5612q = null;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static b f5613a = new b();
    }

    /* renamed from: com.baidu.location.c.a.b$b, reason: collision with other inner class name */
    public class C0011b extends BroadcastReceiver {
        private C0011b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (context == null) {
                return;
            }
            if ((!com.baidu.location.c.b.a.f5617d || g.h().a(intent)) && intent.getAction().equals("android.net.wifi.SCAN_RESULTS")) {
                b.this.f5598a = System.currentTimeMillis() / 1000;
                b.this.f5611p.post(new Runnable() { // from class: com.baidu.location.c.a.b.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.i();
                        synchronized (b.this.f5609n) {
                            try {
                                b.this.f5609n.notifyAll();
                                if (com.baidu.location.c.b.a.f5616c && com.baidu.location.c.b.a.f5617d) {
                                    g.h().a("WifiScan finished, in callback.");
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                });
            }
        }
    }

    public static b a() {
        return a.f5613a;
    }

    private void g() {
        int i4;
        try {
            if (this.f5600e.isWifiEnabled() || this.f5600e.isScanAlwaysAvailable()) {
                this.f5600e.startScan();
                if (com.baidu.location.c.b.a.f5616c && com.baidu.location.c.b.a.f5617d) {
                    g.h().a("wifimanager start scan ...");
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        this.f5605j = System.currentTimeMillis();
        synchronized (this.f5609n) {
            try {
                i4 = this.f5604i.get();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            if (i4 != 0) {
                this.f5609n.wait(i4);
            }
        }
    }

    private String h() {
        DhcpInfo dhcpInfo;
        WifiManager wifiManager = this.f5600e;
        if (wifiManager == null || (dhcpInfo = wifiManager.getDhcpInfo()) == null) {
            return null;
        }
        return b(dhcpInfo.gateway);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        WifiManager wifiManager = this.f5600e;
        if (wifiManager == null) {
            return;
        }
        try {
            List<ScanResult> scanResults = wifiManager.getScanResults();
            if (com.baidu.location.c.b.a.f5616c && com.baidu.location.c.b.a.f5617d) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (scanResults != null && scanResults.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    long j4 = 0;
                    for (int i4 = 0; i4 < scanResults.size(); i4++) {
                        if (i4 == 0) {
                            try {
                                j4 = (jCurrentTimeMillis - scanResults.get(0).timestamp) / 1000000;
                            } catch (Exception e4) {
                                e4.printStackTrace();
                                j4 = 0;
                            }
                            sb.append(scanResults.get(0).BSSID + ";" + Math.abs(scanResults.get(0).level) + ";" + scanResults.get(0).SSID.trim() + ";" + scanResults.get(0).frequency + ";" + j4 + Consts.SPLITTER_DETAIL);
                        }
                        sb.append(scanResults.get(i4).BSSID + ";" + Math.abs(scanResults.get(i4).level) + ";" + scanResults.get(i4).SSID.trim() + ";" + scanResults.get(i4).frequency + ";" + (((jCurrentTimeMillis - scanResults.get(i4).timestamp) / 1000000) - j4) + Consts.SPLITTER_DETAIL);
                    }
                    sb.append(SyslogAppender.DEFAULT_STACKTRACE_PATTERN);
                    sb.append(simpleDateFormat.format(new Date(jCurrentTimeMillis)));
                    sb.append(SyslogAppender.DEFAULT_STACKTRACE_PATTERN);
                    sb.append(jCurrentTimeMillis);
                    sb.append("\tnull\n");
                    g.h().a(sb.toString());
                }
            }
            if (scanResults != null) {
                k kVar = new k(scanResults, System.currentTimeMillis());
                synchronized (this.f5610o) {
                    try {
                        k kVar2 = this.f5602g;
                        if (kVar2 == null || !a(kVar, kVar2)) {
                            this.f5602g = kVar;
                        }
                    } finally {
                    }
                }
            }
        } catch (Exception e5) {
            if (com.baidu.location.c.b.a.f5616c) {
                e5.printStackTrace();
            }
        }
    }

    public long c() {
        return this.f5605j;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0031 -> B:25:0x0036). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0033 -> B:25:0x0036). Please report as a decompilation issue!!! */
    public k d() {
        k kVarA;
        synchronized (this.f5610o) {
            kVarA = a(this.f5602g);
        }
        if (kVarA == null || !kVarA.b()) {
            try {
                WifiManager wifiManager = this.f5600e;
                kVarA = wifiManager != null ? new k(wifiManager.getScanResults(), this.f5605j) : new k(null, 0L);
            } catch (Exception e4) {
                if (com.baidu.location.c.b.a.f5616c) {
                    e4.printStackTrace();
                }
            }
        }
        return kVarA;
    }

    public String e() {
        StringBuffer stringBuffer = new StringBuffer("&wf=");
        WifiInfo wifiInfoF = a().f();
        String strA = a(wifiInfoF, (String) null);
        if (wifiInfoF == null || strA == null) {
            return null;
        }
        String strReplace = strA.replace(AwarenessDataItem.USERID_SPLITTER, "");
        int rssi = wifiInfoF.getRssi();
        String strH = a().h();
        if (rssi < 0) {
            rssi = -rssi;
        }
        if (strReplace == null || rssi >= 100 || "020000000000".equals(strReplace)) {
            return null;
        }
        stringBuffer.append(strReplace);
        stringBuffer.append(";");
        stringBuffer.append("" + rssi + ";");
        String ssid = wifiInfoF.getSSID();
        if (ssid != null && (ssid.contains("&") || ssid.contains(";"))) {
            ssid = ssid.replace("&", "_");
        }
        stringBuffer.append(ssid);
        stringBuffer.append("&wf_n=1");
        if (strH != null) {
            stringBuffer.append("&wf_gw=");
            stringBuffer.append(strH);
        }
        return stringBuffer.toString();
    }

    public WifiInfo f() {
        try {
            WifiManager wifiManager = this.f5600e;
            WifiInfo connectionInfo = wifiManager != null ? wifiManager.getConnectionInfo() : null;
            String strA = a(connectionInfo, (String) null);
            if (connectionInfo != null && strA != null && connectionInfo.getRssi() > -100) {
                String strReplace = strA.replace(AwarenessDataItem.USERID_SPLITTER, "");
                if (!"000000000000".equals(strReplace) && !"".equals(strReplace)) {
                    if (!"020000000000".equals(strReplace)) {
                        return connectionInfo;
                    }
                }
            }
        } catch (Error | Exception unused) {
        }
        return null;
    }

    private String b(long j4) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.valueOf((int) (j4 & 255)));
        stringBuffer.append(CoreConstants.DOT);
        stringBuffer.append(String.valueOf((int) ((j4 >> 8) & 255)));
        stringBuffer.append(CoreConstants.DOT);
        stringBuffer.append(String.valueOf((int) ((j4 >> 16) & 255)));
        stringBuffer.append(CoreConstants.DOT);
        stringBuffer.append(String.valueOf((int) ((j4 >> 24) & 255)));
        return stringBuffer.toString();
    }

    public k a(long j4) {
        e eVarH;
        String str;
        if (this.f5600e != null && j4 < 2147483647L) {
            boolean z4 = com.baidu.location.c.b.a.f5616c;
            if (z4 && com.baidu.location.c.b.a.f5617d) {
                e eVarH2 = g.h();
                StringBuilder sbE = AbstractC0831a.e("Wi-Fi diffTime = ", j4, "mLastDiffTime = ");
                sbE.append(this.f5606k);
                eVarH2.a(sbE.toString());
            }
            if (j4 == this.f5606k) {
                if (z4 && com.baidu.location.c.b.a.f5617d) {
                    g.h().a("System.currentTimeMillis() = " + System.currentTimeMillis() + "wifi diffTime = " + j4 + ", mScanTime = " + this.f5605j);
                }
                if (System.currentTimeMillis() - this.f5605j > j4) {
                    if (z4 && com.baidu.location.c.b.a.f5617d) {
                        eVarH = g.h();
                        str = "time is over";
                        eVarH.a(str);
                    }
                    g();
                }
            } else {
                if (z4 && com.baidu.location.c.b.a.f5617d) {
                    eVarH = g.h();
                    str = "diffTime is changed";
                    eVarH.a(str);
                }
                g();
            }
        }
        this.f5606k = j4;
        return this.f5602g;
    }

    private String b(String str) {
        return str != null ? (str.contains("&") || str.contains(";")) ? str.replace("&", "_").replace(";", "_") : str : str;
    }

    public void b() {
        if (this.f5599b) {
            try {
                this.f5603h.unregisterReceiver(this.f5601f);
                this.f5598a = 0L;
            } catch (Exception e4) {
                if (com.baidu.location.c.b.a.f5616c) {
                    e4.printStackTrace();
                }
            }
            this.f5601f = null;
            this.f5600e = null;
            this.f5599b = false;
            if (com.baidu.location.c.b.a.f5616c && com.baidu.location.c.b.a.f5617d) {
                g.h().a("wifimanager stop ...");
            }
        }
    }

    private k a(k kVar) {
        if (kVar != null) {
            return new k(kVar.f5755a, kVar.f5756b);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x03c8 A[Catch: Error | Exception -> 0x0083, Error | Exception -> 0x0083, TryCatch #5 {Error | Exception -> 0x0083, blocks: (B:7:0x0019, B:11:0x003f, B:11:0x003f, B:14:0x0052, B:14:0x0052, B:16:0x0056, B:16:0x0056, B:18:0x005a, B:18:0x005a, B:26:0x0093, B:38:0x00ae, B:38:0x00ae, B:48:0x00dc, B:48:0x00dc, B:50:0x00e4, B:50:0x00e4, B:54:0x00fd, B:62:0x011a, B:62:0x011a, B:64:0x011e, B:64:0x011e, B:66:0x0122, B:66:0x0122, B:68:0x0143, B:68:0x0143, B:71:0x0150, B:71:0x0150, B:86:0x0197, B:86:0x0197, B:88:0x019c, B:88:0x019c, B:90:0x01aa, B:90:0x01aa, B:92:0x01b6, B:92:0x01b6, B:95:0x01cd, B:95:0x01cd, B:97:0x01e7, B:97:0x01e7, B:99:0x01ed, B:99:0x01ed, B:106:0x0215, B:108:0x021b, B:110:0x0227, B:112:0x0237, B:137:0x0312, B:137:0x0312, B:125:0x02ab, B:125:0x02ab, B:127:0x02af, B:127:0x02af, B:117:0x0263, B:119:0x026b, B:121:0x0277, B:123:0x0287, B:129:0x02b5, B:129:0x02b5, B:131:0x02bd, B:131:0x02bd, B:133:0x02c1, B:133:0x02c1, B:134:0x02e3, B:134:0x02e3, B:89:0x01a4, B:89:0x01a4, B:58:0x0111, B:58:0x0111, B:60:0x0115, B:60:0x0115, B:138:0x0321, B:138:0x0321, B:140:0x0330, B:140:0x0330, B:142:0x0334, B:142:0x0334, B:145:0x0353, B:145:0x0353, B:147:0x035b, B:147:0x035b, B:149:0x0366, B:149:0x0366, B:153:0x0377, B:153:0x0377, B:155:0x0381, B:155:0x0381, B:157:0x038d, B:157:0x038d, B:160:0x03a1, B:160:0x03a1, B:166:0x03c1, B:166:0x03c1, B:154:0x037e, B:154:0x037e, B:168:0x03c8, B:168:0x03c8, B:170:0x03e0, B:170:0x03e0, B:174:0x03f3, B:174:0x03f3, B:177:0x040d, B:177:0x040d, B:179:0x0413, B:179:0x0413, B:181:0x0424, B:181:0x0424, B:182:0x043c, B:182:0x043c, B:184:0x0442, B:184:0x0442, B:186:0x044a, B:186:0x044a, B:190:0x046a, B:190:0x046a, B:187:0x0455, B:187:0x0455, B:189:0x0464, B:189:0x0464, B:191:0x046e, B:191:0x046e, B:193:0x0472, B:193:0x0472, B:195:0x0476, B:195:0x0476, B:196:0x0492, B:196:0x0492, B:197:0x0499, B:197:0x0499, B:199:0x04b9, B:199:0x04b9, B:201:0x04c8, B:201:0x04c8, B:202:0x04d2, B:202:0x04d2), top: B:221:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:204:0x04d7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0321 A[EDGE_INSN: B:223:0x0321->B:138:0x0321 BREAK  A[LOOP:0: B:45:0x00d0->B:137:0x0312], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x019c A[Catch: Error | Exception -> 0x0083, Error | Exception -> 0x0083, TryCatch #5 {Error | Exception -> 0x0083, blocks: (B:7:0x0019, B:11:0x003f, B:11:0x003f, B:14:0x0052, B:14:0x0052, B:16:0x0056, B:16:0x0056, B:18:0x005a, B:18:0x005a, B:26:0x0093, B:38:0x00ae, B:38:0x00ae, B:48:0x00dc, B:48:0x00dc, B:50:0x00e4, B:50:0x00e4, B:54:0x00fd, B:62:0x011a, B:62:0x011a, B:64:0x011e, B:64:0x011e, B:66:0x0122, B:66:0x0122, B:68:0x0143, B:68:0x0143, B:71:0x0150, B:71:0x0150, B:86:0x0197, B:86:0x0197, B:88:0x019c, B:88:0x019c, B:90:0x01aa, B:90:0x01aa, B:92:0x01b6, B:92:0x01b6, B:95:0x01cd, B:95:0x01cd, B:97:0x01e7, B:97:0x01e7, B:99:0x01ed, B:99:0x01ed, B:106:0x0215, B:108:0x021b, B:110:0x0227, B:112:0x0237, B:137:0x0312, B:137:0x0312, B:125:0x02ab, B:125:0x02ab, B:127:0x02af, B:127:0x02af, B:117:0x0263, B:119:0x026b, B:121:0x0277, B:123:0x0287, B:129:0x02b5, B:129:0x02b5, B:131:0x02bd, B:131:0x02bd, B:133:0x02c1, B:133:0x02c1, B:134:0x02e3, B:134:0x02e3, B:89:0x01a4, B:89:0x01a4, B:58:0x0111, B:58:0x0111, B:60:0x0115, B:60:0x0115, B:138:0x0321, B:138:0x0321, B:140:0x0330, B:140:0x0330, B:142:0x0334, B:142:0x0334, B:145:0x0353, B:145:0x0353, B:147:0x035b, B:147:0x035b, B:149:0x0366, B:149:0x0366, B:153:0x0377, B:153:0x0377, B:155:0x0381, B:155:0x0381, B:157:0x038d, B:157:0x038d, B:160:0x03a1, B:160:0x03a1, B:166:0x03c1, B:166:0x03c1, B:154:0x037e, B:154:0x037e, B:168:0x03c8, B:168:0x03c8, B:170:0x03e0, B:170:0x03e0, B:174:0x03f3, B:174:0x03f3, B:177:0x040d, B:177:0x040d, B:179:0x0413, B:179:0x0413, B:181:0x0424, B:181:0x0424, B:182:0x043c, B:182:0x043c, B:184:0x0442, B:184:0x0442, B:186:0x044a, B:186:0x044a, B:190:0x046a, B:190:0x046a, B:187:0x0455, B:187:0x0455, B:189:0x0464, B:189:0x0464, B:191:0x046e, B:191:0x046e, B:193:0x0472, B:193:0x0472, B:195:0x0476, B:195:0x0476, B:196:0x0492, B:196:0x0492, B:197:0x0499, B:197:0x0499, B:199:0x04b9, B:199:0x04b9, B:201:0x04c8, B:201:0x04c8, B:202:0x04d2, B:202:0x04d2), top: B:221:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01a4 A[Catch: Error | Exception -> 0x0083, Error | Exception -> 0x0083, TryCatch #5 {Error | Exception -> 0x0083, blocks: (B:7:0x0019, B:11:0x003f, B:11:0x003f, B:14:0x0052, B:14:0x0052, B:16:0x0056, B:16:0x0056, B:18:0x005a, B:18:0x005a, B:26:0x0093, B:38:0x00ae, B:38:0x00ae, B:48:0x00dc, B:48:0x00dc, B:50:0x00e4, B:50:0x00e4, B:54:0x00fd, B:62:0x011a, B:62:0x011a, B:64:0x011e, B:64:0x011e, B:66:0x0122, B:66:0x0122, B:68:0x0143, B:68:0x0143, B:71:0x0150, B:71:0x0150, B:86:0x0197, B:86:0x0197, B:88:0x019c, B:88:0x019c, B:90:0x01aa, B:90:0x01aa, B:92:0x01b6, B:92:0x01b6, B:95:0x01cd, B:95:0x01cd, B:97:0x01e7, B:97:0x01e7, B:99:0x01ed, B:99:0x01ed, B:106:0x0215, B:108:0x021b, B:110:0x0227, B:112:0x0237, B:137:0x0312, B:137:0x0312, B:125:0x02ab, B:125:0x02ab, B:127:0x02af, B:127:0x02af, B:117:0x0263, B:119:0x026b, B:121:0x0277, B:123:0x0287, B:129:0x02b5, B:129:0x02b5, B:131:0x02bd, B:131:0x02bd, B:133:0x02c1, B:133:0x02c1, B:134:0x02e3, B:134:0x02e3, B:89:0x01a4, B:89:0x01a4, B:58:0x0111, B:58:0x0111, B:60:0x0115, B:60:0x0115, B:138:0x0321, B:138:0x0321, B:140:0x0330, B:140:0x0330, B:142:0x0334, B:142:0x0334, B:145:0x0353, B:145:0x0353, B:147:0x035b, B:147:0x035b, B:149:0x0366, B:149:0x0366, B:153:0x0377, B:153:0x0377, B:155:0x0381, B:155:0x0381, B:157:0x038d, B:157:0x038d, B:160:0x03a1, B:160:0x03a1, B:166:0x03c1, B:166:0x03c1, B:154:0x037e, B:154:0x037e, B:168:0x03c8, B:168:0x03c8, B:170:0x03e0, B:170:0x03e0, B:174:0x03f3, B:174:0x03f3, B:177:0x040d, B:177:0x040d, B:179:0x0413, B:179:0x0413, B:181:0x0424, B:181:0x0424, B:182:0x043c, B:182:0x043c, B:184:0x0442, B:184:0x0442, B:186:0x044a, B:186:0x044a, B:190:0x046a, B:190:0x046a, B:187:0x0455, B:187:0x0455, B:189:0x0464, B:189:0x0464, B:191:0x046e, B:191:0x046e, B:193:0x0472, B:193:0x0472, B:195:0x0476, B:195:0x0476, B:196:0x0492, B:196:0x0492, B:197:0x0499, B:197:0x0499, B:199:0x04b9, B:199:0x04b9, B:201:0x04c8, B:201:0x04c8, B:202:0x04d2, B:202:0x04d2), top: B:221:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01b6 A[Catch: Error | Exception -> 0x0083, Error | Exception -> 0x0083, TryCatch #5 {Error | Exception -> 0x0083, blocks: (B:7:0x0019, B:11:0x003f, B:11:0x003f, B:14:0x0052, B:14:0x0052, B:16:0x0056, B:16:0x0056, B:18:0x005a, B:18:0x005a, B:26:0x0093, B:38:0x00ae, B:38:0x00ae, B:48:0x00dc, B:48:0x00dc, B:50:0x00e4, B:50:0x00e4, B:54:0x00fd, B:62:0x011a, B:62:0x011a, B:64:0x011e, B:64:0x011e, B:66:0x0122, B:66:0x0122, B:68:0x0143, B:68:0x0143, B:71:0x0150, B:71:0x0150, B:86:0x0197, B:86:0x0197, B:88:0x019c, B:88:0x019c, B:90:0x01aa, B:90:0x01aa, B:92:0x01b6, B:92:0x01b6, B:95:0x01cd, B:95:0x01cd, B:97:0x01e7, B:97:0x01e7, B:99:0x01ed, B:99:0x01ed, B:106:0x0215, B:108:0x021b, B:110:0x0227, B:112:0x0237, B:137:0x0312, B:137:0x0312, B:125:0x02ab, B:125:0x02ab, B:127:0x02af, B:127:0x02af, B:117:0x0263, B:119:0x026b, B:121:0x0277, B:123:0x0287, B:129:0x02b5, B:129:0x02b5, B:131:0x02bd, B:131:0x02bd, B:133:0x02c1, B:133:0x02c1, B:134:0x02e3, B:134:0x02e3, B:89:0x01a4, B:89:0x01a4, B:58:0x0111, B:58:0x0111, B:60:0x0115, B:60:0x0115, B:138:0x0321, B:138:0x0321, B:140:0x0330, B:140:0x0330, B:142:0x0334, B:142:0x0334, B:145:0x0353, B:145:0x0353, B:147:0x035b, B:147:0x035b, B:149:0x0366, B:149:0x0366, B:153:0x0377, B:153:0x0377, B:155:0x0381, B:155:0x0381, B:157:0x038d, B:157:0x038d, B:160:0x03a1, B:160:0x03a1, B:166:0x03c1, B:166:0x03c1, B:154:0x037e, B:154:0x037e, B:168:0x03c8, B:168:0x03c8, B:170:0x03e0, B:170:0x03e0, B:174:0x03f3, B:174:0x03f3, B:177:0x040d, B:177:0x040d, B:179:0x0413, B:179:0x0413, B:181:0x0424, B:181:0x0424, B:182:0x043c, B:182:0x043c, B:184:0x0442, B:184:0x0442, B:186:0x044a, B:186:0x044a, B:190:0x046a, B:190:0x046a, B:187:0x0455, B:187:0x0455, B:189:0x0464, B:189:0x0464, B:191:0x046e, B:191:0x046e, B:193:0x0472, B:193:0x0472, B:195:0x0476, B:195:0x0476, B:196:0x0492, B:196:0x0492, B:197:0x0499, B:197:0x0499, B:199:0x04b9, B:199:0x04b9, B:201:0x04c8, B:201:0x04c8, B:202:0x04d2, B:202:0x04d2), top: B:221:0x0019 }] */
    /* JADX WARN: Type inference failed for: r6v37 */
    /* JADX WARN: Type inference failed for: r6v39 */
    /* JADX WARN: Type inference failed for: r6v45 */
    /* JADX WARN: Type inference failed for: r6v47 */
    /* JADX WARN: Type inference failed for: r6v48 */
    /* JADX WARN: Type inference failed for: r6v54 */
    /* JADX WARN: Type inference failed for: r6v55 */
    /* JADX WARN: Type inference failed for: r6v56 */
    /* JADX WARN: Type inference failed for: r6v57 */
    /* JADX WARN: Type inference failed for: r6v58 */
    /* JADX WARN: Type inference failed for: r6v59 */
    /* JADX WARN: Type inference failed for: r6v60 */
    /* JADX WARN: Type inference failed for: r6v61 */
    /* JADX WARN: Type inference failed for: r6v62 */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String a(int r36, boolean r37, com.baidu.location.c.k r38, int r39) {
        /*
            Method dump skipped, instructions count: 1250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.c.a.b.a(int, boolean, com.baidu.location.c.k, int):java.lang.String");
    }

    public synchronized String a(WifiInfo wifiInfo, String str) {
        if (wifiInfo == null && str == null) {
            return null;
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.f5607l > 1000) {
                if (wifiInfo != null) {
                    this.f5608m = wifiInfo.getBSSID();
                } else {
                    this.f5608m = str;
                }
                this.f5607l = jCurrentTimeMillis;
            }
            return this.f5608m;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x0134 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0139  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String a(com.baidu.location.c.k r28, int r29, java.lang.String r30, boolean r31, int r32) {
        /*
            Method dump skipped, instructions count: 607
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.c.a.b.a(com.baidu.location.c.k, int, java.lang.String, boolean, int):java.lang.String");
    }

    public void a(int i4) {
        this.f5604i.set(i4);
    }

    public void a(Context context, List<String> list) {
        if (this.f5599b) {
            return;
        }
        this.f5603h = context;
        this.f5600e = (WifiManager) context.getApplicationContext().getSystemService(AppSuggestStorable.COLUMN_WIFI);
        this.f5601f = new C0011b();
        if (this.f5611p == null) {
            this.f5611p = new Handler(Looper.getMainLooper());
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        if (!list.contains("android.net.wifi.SCAN_RESULTS")) {
            list.add("android.net.wifi.SCAN_RESULTS");
        }
        try {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                this.f5603h.registerReceiver(this.f5601f, new IntentFilter(it.next()));
            }
        } catch (Exception e4) {
            if (com.baidu.location.c.b.a.f5616c) {
                e4.printStackTrace();
            }
        }
        this.f5599b = true;
        if (com.baidu.location.c.b.a.f5616c && com.baidu.location.c.b.a.f5617d) {
            g.h().a("wifimanager start ...");
        }
    }

    public boolean a(k kVar, k kVar2) {
        List<ScanResult> list = kVar.f5755a;
        if (list == null || kVar2 == null || kVar2.f5755a == null) {
            return false;
        }
        int iMin = Math.min(list.size(), kVar2.f5755a.size());
        for (int i4 = 0; i4 < iMin; i4++) {
            try {
                if (kVar.f5755a.get(i4) != null) {
                    String str = kVar.f5755a.get(i4).BSSID;
                    String str2 = kVar2.f5755a.get(i4).BSSID;
                    if (!TextUtils.isEmpty(str) && !str.equals(str2)) {
                        return false;
                    }
                }
            } catch (Exception e4) {
                if (com.baidu.location.c.b.a.f5616c) {
                    e4.printStackTrace();
                }
                return false;
            }
        }
        return true;
    }

    public static boolean a(k kVar, k kVar2, float f4) {
        if (kVar != null && kVar2 != null) {
            List<ScanResult> list = kVar.f5755a;
            List<ScanResult> list2 = kVar2.f5755a;
            if (list == list2) {
                return true;
            }
            if (list != null && list2 != null) {
                int size = list.size();
                int size2 = list2.size();
                if (size == 0 && size2 == 0) {
                    return true;
                }
                if (size != 0 && size2 != 0) {
                    int i4 = 0;
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = list.get(i5) != null ? list.get(i5).BSSID : null;
                        if (str != null) {
                            int i6 = 0;
                            while (true) {
                                if (i6 >= size2) {
                                    break;
                                }
                                String str2 = list2.get(i6) != null ? list2.get(i6).BSSID : null;
                                if (str2 != null && str.equals(str2)) {
                                    i4++;
                                    break;
                                }
                                i6++;
                            }
                        }
                    }
                    if (com.baidu.location.c.b.a.f5616c && com.baidu.location.c.b.a.f5617d) {
                        g.h().a("wifi same!" + (i4 / size));
                    }
                    if (i4 >= size * f4) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("wpa|wep", 2).matcher(str).find();
    }
}
