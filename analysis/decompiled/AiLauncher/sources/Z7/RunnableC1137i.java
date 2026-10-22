package Z7;

import android.content.Context;
import android.os.Process;
import android.util.Pair;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.br;
import com.tencent.bugly.proguard.bt;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* renamed from: Z7.i, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC1137i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public int f7523a;

    /* renamed from: b, reason: collision with root package name */
    public int f7524b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f7525c;

    /* renamed from: d, reason: collision with root package name */
    public final int f7526d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f7527e;

    /* renamed from: f, reason: collision with root package name */
    public final C1130b f7528f;

    /* renamed from: g, reason: collision with root package name */
    public final C1131c f7529g;

    /* renamed from: h, reason: collision with root package name */
    public final C1134f f7530h;

    /* renamed from: i, reason: collision with root package name */
    public final C1136h f7531i;

    /* renamed from: j, reason: collision with root package name */
    public final int f7532j;

    /* renamed from: k, reason: collision with root package name */
    public final InterfaceC1135g f7533k;

    /* renamed from: l, reason: collision with root package name */
    public final InterfaceC1135g f7534l;

    /* renamed from: m, reason: collision with root package name */
    public String f7535m;

    /* renamed from: n, reason: collision with root package name */
    public final String f7536n;

    /* renamed from: o, reason: collision with root package name */
    public final Map<String, String> f7537o;

    /* renamed from: p, reason: collision with root package name */
    public int f7538p;

    /* renamed from: q, reason: collision with root package name */
    public long f7539q;

    /* renamed from: r, reason: collision with root package name */
    public long f7540r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f7541s;

    public RunnableC1137i(Context context, int i10, int i11, byte[] bArr, String str, String str2, InterfaceC1135g interfaceC1135g, boolean z10) {
        this(context, i10, i11, bArr, str, str2, interfaceC1135g, 2, Const.I_LOC_JUMP_DELAY, z10);
    }

    public static void d(String str) {
        C1139k.j("[Upload] Failed to upload(%d): %s", 1, str);
    }

    public static boolean f(br brVar, C1130b c1130b, C1131c c1131c) throws NumberFormatException {
        if (brVar == null) {
            C1139k.i("resp == null!", new Object[0]);
            return false;
        }
        byte b10 = brVar.f31643a;
        if (b10 != 0) {
            C1139k.j("resp result error %d", Byte.valueOf(b10));
            return false;
        }
        try {
            if (!C1143o.G(brVar.f31649g) && !C1130b.l().w().equals(brVar.f31649g)) {
                V.f().s(C1131c.f7494f, Parameters.DEVICE, brVar.f31649g.getBytes("UTF-8"), true);
                c1130b.q(brVar.f31649g);
            }
        } catch (Throwable th) {
            C1139k.e(th);
        }
        c1130b.f7481s = brVar.f31647e;
        int i10 = brVar.f31644b;
        if (i10 == 510) {
            byte[] bArr = brVar.f31645c;
            if (bArr == null) {
                C1139k.j("[Upload] Strategy data is null. Response cmd: %d", Integer.valueOf(i10));
                return false;
            }
            bt btVar = (bt) C1133e.d(bArr, bt.class);
            if (btVar == null) {
                C1139k.j("[Upload] Failed to decode strategy from server. Response cmd: %d", Integer.valueOf(brVar.f31644b));
                return false;
            }
            c1131c.f(btVar);
        }
        return true;
    }

    public static String g(String str) {
        if (C1143o.G(str)) {
            return str;
        }
        try {
            return String.format("%s?aid=%s", str, UUID.randomUUID().toString());
        } catch (Throwable th) {
            C1139k.e(th);
            return str;
        }
    }

    public final Pair<Boolean, Boolean> a(Map<String, String> map) {
        int i10;
        if (map == null || map.size() == 0) {
            C1139k.i("[Upload] Headers is empty.", new Object[0]);
        } else if (!map.containsKey("status")) {
            C1139k.i("[Upload] Headers does not contain %s", "status");
        } else if (map.containsKey("Bugly-Version")) {
            String str = map.get("Bugly-Version");
            if (str.contains("bugly")) {
                C1139k.h("[Upload] Bugly version from headers is: %s", str);
                try {
                    i10 = Integer.parseInt(map.get("status"));
                } catch (Throwable unused) {
                    i10 = -1;
                }
                try {
                    C1139k.h("[Upload] Status from server is %d (pid=%d | tid=%d).", Integer.valueOf(i10), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                    if (i10 == 0) {
                        Boolean bool = Boolean.TRUE;
                        return new Pair<>(bool, bool);
                    }
                    e(false, 1, "status of server is ".concat(String.valueOf(i10)));
                    Boolean bool2 = Boolean.FALSE;
                    return new Pair<>(bool2, bool2);
                } catch (Throwable unused2) {
                    d("[Upload] Failed to upload for format of status header is invalid: " + Integer.toString(i10));
                    return new Pair<>(Boolean.FALSE, Boolean.TRUE);
                }
            }
            C1139k.i("[Upload] Bugly version is not valid: %s", str);
        } else {
            C1139k.i("[Upload] Headers does not contain %s", "Bugly-Version");
        }
        C1139k.h("[Upload] Headers from server is not valid, just try again (pid=%d | tid=%d).", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        d("[Upload] Failed to upload for no status header.");
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                C1139k.h(String.format("[key]: %s, [value]: %s", entry.getKey(), entry.getValue()), new Object[0]);
            }
        }
        C1139k.h("[Upload] Failed to upload for no status header.", new Object[0]);
        return new Pair<>(Boolean.FALSE, Boolean.TRUE);
    }

    public final Pair<Boolean, Boolean> b(byte[] bArr, Map<String, String> map) {
        if (bArr == null) {
            d("Failed to upload for no response!");
            return new Pair<>(Boolean.FALSE, Boolean.TRUE);
        }
        C1139k.h("[Upload] Received %d bytes", Integer.valueOf(bArr.length));
        if (bArr.length != 0) {
            Boolean bool = Boolean.TRUE;
            return new Pair<>(bool, bool);
        }
        e(false, 1, "response data from server is empty");
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                C1139k.h("[Upload] HTTP headers from server: key = %s, value = %s", entry.getKey(), entry.getValue());
            }
        }
        Boolean bool2 = Boolean.FALSE;
        return new Pair<>(bool2, bool2);
    }

    public final void c(long j10) {
        this.f7538p++;
        this.f7539q += j10;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(boolean r5, int r6, java.lang.String r7) {
        /*
            r4 = this;
            int r0 = r4.f7526d
            r1 = 630(0x276, float:8.83E-43)
            if (r0 == r1) goto L1a
            r1 = 640(0x280, float:8.97E-43)
            if (r0 == r1) goto L17
            r1 = 830(0x33e, float:1.163E-42)
            if (r0 == r1) goto L1a
            r1 = 840(0x348, float:1.177E-42)
            if (r0 == r1) goto L17
            java.lang.String r0 = java.lang.String.valueOf(r0)
            goto L1c
        L17:
            java.lang.String r0 = "userinfo"
            goto L1c
        L1a:
            java.lang.String r0 = "crash"
        L1c:
            if (r5 == 0) goto L28
            java.lang.String r6 = "[Upload] Success: %s"
            java.lang.Object[] r0 = new java.lang.Object[]{r0}
            Z7.C1139k.d(r6, r0)
            goto L35
        L28:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.Object[] r6 = new java.lang.Object[]{r6, r0, r7}
            java.lang.String r0 = "[Upload] Failed to upload(%d) %s: %s"
            Z7.C1139k.j(r0, r6)
        L35:
            long r0 = r4.f7539q
            long r2 = r4.f7540r
            long r0 = r0 + r2
            r2 = 0
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 <= 0) goto L55
            Z7.h r6 = r4.f7531i
            boolean r0 = r4.f7541s
            long r0 = r6.b(r0)
            long r2 = r4.f7539q
            long r0 = r0 + r2
            long r2 = r4.f7540r
            long r0 = r0 + r2
            Z7.h r6 = r4.f7531i
            boolean r2 = r4.f7541s
            r6.k(r0, r2)
        L55:
            Z7.g r6 = r4.f7533k
            if (r6 == 0) goto L5c
            r6.a(r5, r7)
        L5c:
            Z7.g r4 = r4.f7534l
            if (r4 == 0) goto L63
            r4.a(r5, r7)
        L63:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: Z7.RunnableC1137i.e(boolean, int, java.lang.String):void");
    }

    public final void h(long j10) {
        this.f7540r += j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        C1131c c1131c;
        Pair pair;
        boolean zBooleanValue;
        try {
            this.f7538p = 0;
            this.f7539q = 0L;
            this.f7540r = 0L;
            if (ab.f(this.f7525c) == null) {
                str = "network is not available";
            } else {
                byte[] bArr = this.f7527e;
                str = (bArr == null || bArr.length == 0) ? "request package is empty!" : (this.f7525c == null || this.f7528f == null || (c1131c = this.f7529g) == null || this.f7530h == null) ? "illegal access error" : c1131c.i() == null ? "illegal local strategy" : null;
            }
            if (str != null) {
                e(false, 0, str);
                return;
            }
            byte[] bArrY = C1143o.y(this.f7527e);
            if (bArrY == null) {
                e(false, 0, "failed to zip request body");
                return;
            }
            HashMap map = new HashMap(10);
            map.put("tls", "1");
            map.put("prodId", this.f7528f.r());
            map.put("bundleId", this.f7528f.f7453e);
            map.put("appVer", this.f7528f.f7422D);
            Map<String, String> map2 = this.f7537o;
            if (map2 != null) {
                map.putAll(map2);
            }
            map.put("cmd", Integer.toString(this.f7526d));
            map.put("platformId", Byte.toString((byte) 1));
            map.put("sdkVer", this.f7528f.f7463j);
            map.put("strategylastUpdateTime", Long.toString(this.f7529g.i().f31461o));
            this.f7531i.g(this.f7532j, System.currentTimeMillis());
            String strG = this.f7535m;
            this.f7529g.i();
            int i10 = 0;
            int i11 = 0;
            while (true) {
                int i12 = i10 + 1;
                if (i10 >= this.f7523a) {
                    e(false, i11, "failed after many attempts");
                    return;
                }
                if (i12 > 1) {
                    C1139k.i("[Upload] Failed to upload last time, wait and try(%d) again.", Integer.valueOf(i12));
                    C1143o.C(this.f7524b);
                    if (i12 == this.f7523a) {
                        C1139k.i("[Upload] Use the back-up url at the last time: %s", this.f7536n);
                        strG = this.f7536n;
                    }
                }
                C1139k.h("[Upload] Send %d bytes", Integer.valueOf(bArrY.length));
                strG = g(strG);
                C1139k.h("[Upload] Upload to %s with cmd %d (pid=%d | tid=%d).", strG, Integer.valueOf(this.f7526d), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                byte[] bArrD = this.f7530h.d(strG, bArrY, this, map);
                Map<String, String> map3 = this.f7530h.f7505b;
                Pair<Boolean, Boolean> pairB = b(bArrD, map3);
                if (((Boolean) pairB.first).booleanValue()) {
                    Pair<Boolean, Boolean> pairA = a(map3);
                    if (((Boolean) pairA.first).booleanValue()) {
                        byte[] bArrH = C1143o.H(bArrD);
                        if (bArrH != null) {
                            bArrD = bArrH;
                        }
                        br brVarB = C1133e.b(bArrD);
                        if (brVarB == null) {
                            e(false, 1, "failed to decode response package");
                            Boolean bool = Boolean.FALSE;
                            pair = new Pair(bool, bool);
                        } else {
                            Integer numValueOf = Integer.valueOf(brVarB.f31644b);
                            byte[] bArr2 = brVarB.f31645c;
                            C1139k.h("[Upload] Response cmd is: %d, length of sBuffer is: %d", numValueOf, Integer.valueOf(bArr2 == null ? 0 : bArr2.length));
                            if (f(brVarB, this.f7528f, this.f7529g)) {
                                e(true, 2, "successfully uploaded");
                                Boolean bool2 = Boolean.TRUE;
                                pair = new Pair(bool2, bool2);
                            } else {
                                e(false, 2, "failed to process response package");
                                Boolean bool3 = Boolean.FALSE;
                                pair = new Pair(bool3, bool3);
                            }
                        }
                        zBooleanValue = !((Boolean) pair.first).booleanValue() ? ((Boolean) pair.second).booleanValue() : false;
                    } else {
                        zBooleanValue = ((Boolean) pairA.second).booleanValue();
                    }
                } else {
                    zBooleanValue = ((Boolean) pairB.second).booleanValue();
                }
                if (!zBooleanValue) {
                    return;
                }
                i11 = 1;
                i10 = i12;
            }
        } catch (Throwable th) {
            if (C1139k.e(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public RunnableC1137i(Context context, int i10, int i11, byte[] bArr, String str, String str2, InterfaceC1135g interfaceC1135g, int i12, int i13, boolean z10) {
        this.f7523a = 2;
        this.f7524b = Const.I_LOC_JUMP_DELAY;
        this.f7535m = null;
        this.f7538p = 0;
        this.f7539q = 0L;
        this.f7540r = 0L;
        this.f7541s = false;
        this.f7525c = context;
        this.f7528f = C1130b.h(context);
        this.f7527e = bArr;
        this.f7529g = C1131c.a();
        if (C1134f.f7503c == null) {
            C1134f.f7503c = new C1134f(context);
        }
        this.f7530h = C1134f.f7503c;
        C1136h c1136hC = C1136h.c();
        this.f7531i = c1136hC;
        this.f7532j = i10;
        this.f7535m = str;
        this.f7536n = str2;
        this.f7533k = interfaceC1135g;
        this.f7534l = c1136hC.f7509c;
        this.f7526d = i11;
        if (i12 > 0) {
            this.f7523a = i12;
        }
        if (i13 > 0) {
            this.f7524b = i13;
        }
        this.f7541s = z10;
        this.f7537o = null;
    }
}
