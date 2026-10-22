package com.autonavi.aps.amapapi.trans;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.amap.api.col.jmsl.C1532a1;
import com.amap.api.col.jmsl.C1602s0;
import com.autonavi.aps.amapapi.DNSIPDelegate;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.utils.AuthUtil;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.autonavi.aps.amapapi.utils.ReportUtil;
import com.autonavi.aps.amapapi.utils.SPUtil;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes.dex */
public class AMapDnsManager {
    public static int IPV4_TYPE = 1;
    public static int IPV6_TYPE = 2;

    /* renamed from: i, reason: collision with root package name */
    private static AMapDnsManager f18371i;

    /* renamed from: f, reason: collision with root package name */
    private Context f18377f;

    /* renamed from: g, reason: collision with root package name */
    private String f18378g;

    /* renamed from: a, reason: collision with root package name */
    private long f18372a = 0;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<String> f18373b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private DNSIPDelegate f18374c = new DNSIPDelegate();

    /* renamed from: d, reason: collision with root package name */
    private DNSIPDelegate f18375d = new DNSIPDelegate();

    /* renamed from: e, reason: collision with root package name */
    private long f18376e = 120000;

    /* renamed from: h, reason: collision with root package name */
    private boolean f18379h = false;

    private AMapDnsManager(Context context) {
        this.f18377f = context;
    }

    public static String[] a(AMapDnsManager aMapDnsManager, JSONArray jSONArray, int i10) throws JSONException {
        aMapDnsManager.getClass();
        if (jSONArray == null || jSONArray.length() == 0) {
            return new String[0];
        }
        int length = jSONArray.length();
        String[] strArr = new String[length];
        for (int i11 = 0; i11 < length; i11++) {
            String string = jSONArray.getString(i11);
            if (!TextUtils.isEmpty(string)) {
                if (i10 == IPV6_TYPE) {
                    string = "[" + string + "]";
                }
                strArr[i11] = string;
            }
        }
        return strArr;
    }

    public static void b(AMapDnsManager aMapDnsManager, int i10) {
        if ((i10 == IPV6_TYPE ? aMapDnsManager.f18375d : aMapDnsManager.f18374c).getLocationIPs() != null) {
            if ((i10 == IPV6_TYPE ? aMapDnsManager.f18375d : aMapDnsManager.f18374c).getLocationIPs().length <= 0) {
                return;
            }
            String str = (i10 == IPV6_TYPE ? aMapDnsManager.f18375d : aMapDnsManager.f18374c).getLocationIPs()[0];
            if (str.equals(aMapDnsManager.f18378g) || aMapDnsManager.f18373b.contains(str)) {
                return;
            }
            aMapDnsManager.f18378g = str;
            SharedPreferences.Editor editorStartEdit = SPUtil.startEdit(aMapDnsManager.f18377f, Const.STR_PREF_KEY7);
            SPUtil.setPrefsStr(editorStartEdit, aMapDnsManager.a(i10), str);
            SPUtil.endEdit(editorStartEdit);
        }
    }

    public static synchronized AMapDnsManager getInstance(Context context) {
        try {
            if (f18371i == null) {
                f18371i = new AMapDnsManager(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f18371i;
    }

    public String changeLocationRequestURLAndHost(LocationRequest locationRequest, int i10) {
        try {
            if (AuthUtil.getHttpDNSAble() && locationRequest != null) {
                String url = locationRequest.getURL();
                String host = new URL(url).getHost();
                C1532a1 c1532a1C = C1532a1.c(this.f18377f);
                String strA = c1532a1C.a(40);
                if (!("http://" + c1532a1C.a(40) + ReportUtil.PATH_LOC).equals(url) && !strA.equals(host)) {
                    String str = c1532a1C.a(43).equalsIgnoreCase(host) ? CoreUtil.STR_API_DEFAULT_DNS_HOST : host;
                    if (!C1602s0.M(str)) {
                        return null;
                    }
                    String strB = b(i10);
                    if (!TextUtils.isEmpty(strB)) {
                        locationRequest.setIPV6Url(url.replace(host, strB));
                        locationRequest.getRequestHead().put("host", str);
                        locationRequest.setDnsHostName(str);
                        locationRequest.setIPV6Request(i10 == IPV6_TYPE);
                        return strB;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public void removeCacheIP(int i10) {
        if ((i10 == IPV6_TYPE ? this.f18375d : this.f18374c).isHasLocalCache()) {
            SharedPreferences.Editor editorStartEdit = SPUtil.startEdit(this.f18377f, Const.STR_PREF_KEY7);
            SPUtil.removeKeyData(editorStartEdit, a(i10));
            SPUtil.endEdit(editorStartEdit);
            (i10 == IPV6_TYPE ? this.f18375d : this.f18374c).setHasLocalCache(false);
        }
    }

    public void setDomainRequestStatus(boolean z10, int i10) {
        if (z10) {
            if (!(i10 == IPV6_TYPE ? this.f18375d : this.f18374c).isIsDNSOK()) {
                this.f18373b.add((i10 == IPV6_TYPE ? this.f18375d : this.f18374c).getUseIp());
                removeCacheIP(i10);
                a(true, i10);
                return;
            }
        }
        removeCacheIP(i10);
    }

    public void setRequestStatus(boolean z10, int i10) {
        (i10 == IPV6_TYPE ? this.f18375d : this.f18374c).setIsDNSOK(z10);
        if (z10) {
            String cacheIp = (i10 == IPV6_TYPE ? this.f18375d : this.f18374c).getCacheIp();
            String useIp = (i10 == IPV6_TYPE ? this.f18375d : this.f18374c).getUseIp();
            if (TextUtils.isEmpty(useIp) || useIp.equals(cacheIp)) {
                return;
            }
            SharedPreferences.Editor editorStartEdit = SPUtil.startEdit(this.f18377f, Const.STR_PREF_KEY7);
            SPUtil.setPrefsStr(editorStartEdit, a(i10), useIp);
            SPUtil.endEdit(editorStartEdit);
        }
    }

    public static boolean a(AMapDnsManager aMapDnsManager, String[] strArr, String[] strArr2) {
        aMapDnsManager.getClass();
        if (strArr.length != 0 && strArr2 != null && strArr2.length != 0 && strArr.length == strArr2.length) {
            int length = strArr.length;
            for (int i10 = 0; i10 < length; i10++) {
                if (strArr[i10].equals(strArr2[i10])) {
                }
            }
            return true;
        }
        return false;
    }

    private String b(int i10) {
        DNSIPDelegate dNSIPDelegate;
        DNSIPDelegate dNSIPDelegate2;
        DNSIPDelegate dNSIPDelegate3;
        DNSIPDelegate dNSIPDelegate4;
        DNSIPDelegate dNSIPDelegate5;
        String str;
        DNSIPDelegate dNSIPDelegate6;
        int i11 = 0;
        a(false, i10);
        if (i10 == IPV6_TYPE) {
            dNSIPDelegate = this.f18375d;
        } else {
            dNSIPDelegate = this.f18374c;
        }
        String[] locationIPs = dNSIPDelegate.getLocationIPs();
        if (locationIPs != null && locationIPs.length > 0) {
            int length = locationIPs.length;
            while (true) {
                if (i11 >= length) {
                    str = null;
                    break;
                }
                str = locationIPs[i11];
                if (!this.f18373b.contains(str)) {
                    break;
                }
                i11++;
            }
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (i10 == IPV6_TYPE) {
                dNSIPDelegate6 = this.f18375d;
            } else {
                dNSIPDelegate6 = this.f18374c;
            }
            dNSIPDelegate6.setUseIp(str);
            return str;
        }
        String prefsStr = SPUtil.getPrefsStr(this.f18377f, Const.STR_PREF_KEY7, a(i10), null);
        if (!TextUtils.isEmpty(prefsStr) && !this.f18373b.contains(prefsStr)) {
            if (i10 == IPV6_TYPE) {
                dNSIPDelegate3 = this.f18375d;
            } else {
                dNSIPDelegate3 = this.f18374c;
            }
            dNSIPDelegate3.setUseIp(prefsStr);
            if (i10 == IPV6_TYPE) {
                dNSIPDelegate4 = this.f18375d;
            } else {
                dNSIPDelegate4 = this.f18374c;
            }
            dNSIPDelegate4.setCacheIp(prefsStr);
            if (i10 == IPV6_TYPE) {
                dNSIPDelegate5 = this.f18375d;
            } else {
                dNSIPDelegate5 = this.f18374c;
            }
            dNSIPDelegate5.setHasLocalCache(true);
        }
        if (i10 == IPV6_TYPE) {
            dNSIPDelegate2 = this.f18375d;
        } else {
            dNSIPDelegate2 = this.f18374c;
        }
        return dNSIPDelegate2.getUseIp();
    }

    public static DNSIPDelegate a(AMapDnsManager aMapDnsManager, int i10) {
        if (i10 == IPV6_TYPE) {
            return aMapDnsManager.f18375d;
        }
        return aMapDnsManager.f18374c;
    }

    private String a(int i10) {
        return i10 == IPV6_TYPE ? "last_ip_6" : "last_ip_4";
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001a A[Catch: all -> 0x000f, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0009, B:12:0x0012, B:14:0x001a, B:23:0x0032, B:25:0x004c, B:26:0x0081), top: B:31:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004c A[Catch: all -> 0x000f, LOOP:0: B:24:0x004a->B:25:0x004c, LOOP_END, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0009, B:12:0x0012, B:14:0x001a, B:23:0x0032, B:25:0x004c, B:26:0x0081), top: B:31:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized void a(boolean r7, final int r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            if (r7 != 0) goto L12
            boolean r7 = com.autonavi.aps.amapapi.utils.AuthUtil.getNeedRefresh()     // Catch: java.lang.Throwable -> Lf
            if (r7 != 0) goto L12
            boolean r7 = r6.f18379h     // Catch: java.lang.Throwable -> Lf
            if (r7 == 0) goto L12
            monitor-exit(r6)
            return
        Lf:
            r7 = move-exception
            goto L8f
        L12:
            long r0 = r6.f18372a     // Catch: java.lang.Throwable -> Lf
            r2 = 0
            int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r7 == 0) goto L32
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Lf
            long r2 = r6.f18372a     // Catch: java.lang.Throwable -> Lf
            long r0 = r0 - r2
            long r2 = r6.f18376e     // Catch: java.lang.Throwable -> Lf
            int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r7 >= 0) goto L29
            monitor-exit(r6)
            return
        L29:
            r2 = 60000(0xea60, double:2.9644E-319)
            int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r7 >= 0) goto L32
            monitor-exit(r6)
            return
        L32:
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Lf
            r6.f18372a = r0     // Catch: java.lang.Throwable -> Lf
            r7 = 1
            r6.f18379h = r7     // Catch: java.lang.Throwable -> Lf
            java.lang.Thread r7 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> Lf
            java.lang.StackTraceElement[] r7 = r7.getStackTrace()     // Catch: java.lang.Throwable -> Lf
            java.lang.StringBuffer r0 = new java.lang.StringBuffer     // Catch: java.lang.Throwable -> Lf
            r0.<init>()     // Catch: java.lang.Throwable -> Lf
            int r1 = r7.length     // Catch: java.lang.Throwable -> Lf
            r2 = 0
        L4a:
            if (r2 >= r1) goto L81
            r3 = r7[r2]     // Catch: java.lang.Throwable -> Lf
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lf
            r4.<init>()     // Catch: java.lang.Throwable -> Lf
            java.lang.String r5 = r3.getClassName()     // Catch: java.lang.Throwable -> Lf
            r4.append(r5)     // Catch: java.lang.Throwable -> Lf
            java.lang.String r5 = "("
            r4.append(r5)     // Catch: java.lang.Throwable -> Lf
            java.lang.String r5 = r3.getMethodName()     // Catch: java.lang.Throwable -> Lf
            r4.append(r5)     // Catch: java.lang.Throwable -> Lf
            java.lang.String r5 = ":"
            r4.append(r5)     // Catch: java.lang.Throwable -> Lf
            int r3 = r3.getLineNumber()     // Catch: java.lang.Throwable -> Lf
            r4.append(r3)     // Catch: java.lang.Throwable -> Lf
            java.lang.String r3 = "),"
            r4.append(r3)     // Catch: java.lang.Throwable -> Lf
            java.lang.String r3 = r4.toString()     // Catch: java.lang.Throwable -> Lf
            r0.append(r3)     // Catch: java.lang.Throwable -> Lf
            int r2 = r2 + 1
            goto L4a
        L81:
            com.amap.api.col.jmsl.V1 r7 = com.amap.api.col.jmsl.V1.h()     // Catch: java.lang.Throwable -> Lf
            com.autonavi.aps.amapapi.trans.AMapDnsManager$1 r0 = new com.autonavi.aps.amapapi.trans.AMapDnsManager$1     // Catch: java.lang.Throwable -> Lf
            r0.<init>()     // Catch: java.lang.Throwable -> Lf
            r7.f(r0)     // Catch: java.lang.Throwable -> Lf
            monitor-exit(r6)
            return
        L8f:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> Lf
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.trans.AMapDnsManager.a(boolean, int):void");
    }
}
