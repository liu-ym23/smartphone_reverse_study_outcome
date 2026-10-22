package W0;

import android.util.Log;
import g1.AbstractC1451a;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class j implements Y0.c {

    /* renamed from: a, reason: collision with root package name */
    public LinkedHashMap f1481a;
    public C0.b b;
    public long c;
    public long d;
    public long e;

    /* JADX WARN: Removed duplicated region for block: B:119:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02e4 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void d(W0.j r19) {
        /*
            Method dump skipped, instructions count: 804
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: W0.j.d(W0.j):void");
    }

    public static void f(ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            V0.a aVar = (V0.a) it.next();
            try {
                File file = aVar.d;
                if (file != null) {
                    S0.b.G(file);
                }
            } catch (Exception unused) {
                String str = S0.a.f1163a;
                String str2 = "delete LogFile's source File failed. logFile=" + aVar.d;
                if (AbstractC1451a.f4467a) {
                    Log.w(str, str2);
                }
            }
        }
    }

    @Override // Y0.c
    public final String a() {
        return "second_log_dir";
    }

    @Override // Y0.c
    public final long b() {
        c cVar = a.f1471a;
        cVar.b();
        File file = cVar.c;
        File[] fileArrListFiles = file == null ? null : file.listFiles();
        long length = 0;
        if (fileArrListFiles == null) {
            return 0L;
        }
        for (File file2 : fileArrListFiles) {
            length += file2.length();
        }
        return length;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0038 A[SYNTHETIC] */
    @Override // Y0.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(long r8) {
        /*
            r7 = this;
            W0.c r7 = W0.a.f1471a
            r7.b()
            java.io.File r7 = r7.c
            if (r7 != 0) goto Lb
            r7 = 0
            goto Lf
        Lb:
            java.io.File[] r7 = r7.listFiles()
        Lf:
            if (r7 != 0) goto L12
            goto L3b
        L12:
            int r0 = r7.length
            r1 = 0
            r2 = r1
        L15:
            if (r2 >= r0) goto L3b
            r3 = r7[r2]
            java.lang.String r4 = r3.getName()     // Catch: java.lang.Throwable -> L2f
            java.lang.String r5 = "_"
            java.lang.String[] r4 = r4.split(r5)     // Catch: java.lang.Throwable -> L2f
            int r5 = r4.length     // Catch: java.lang.Throwable -> L2f
            r6 = 2
            if (r5 == r6) goto L28
            goto L2f
        L28:
            r4 = r4[r1]     // Catch: java.lang.Throwable -> L2f
            long r4 = java.lang.Long.parseLong(r4)     // Catch: java.lang.Throwable -> L2f
            goto L31
        L2f:
            r4 = -1
        L31:
            int r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r4 > 0) goto L38
            S0.b.G(r3)
        L38:
            int r2 = r2 + 1
            goto L15
        L3b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: W0.j.c(long):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0065 A[SYNTHETIC] */
    @Override // Y0.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(long r12) {
        /*
            r11 = this;
            W0.c r11 = W0.a.f1471a
            r11.b()
            java.io.File r11 = r11.c
            if (r11 != 0) goto Lb
            r11 = 0
            goto Lf
        Lb:
            java.io.File[] r11 = r11.listFiles()
        Lf:
            if (r11 != 0) goto L12
            goto L68
        L12:
            M.d r0 = new M.d
            r1 = 6
            r0.<init>(r1)
            java.util.Arrays.sort(r11, r0)
            int r0 = r11.length
            r1 = 0
            r3 = 0
            r5 = r1
            r4 = r3
        L21:
            if (r4 >= r0) goto L39
            r7 = r11[r4]
            boolean r8 = r7.exists()
            if (r8 == 0) goto L36
            boolean r8 = r7.isFile()
            if (r8 == 0) goto L36
            long r7 = r7.length()
            long r5 = r5 + r7
        L36:
            int r4 = r4 + 1
            goto L21
        L39:
            int r0 = r11.length
            r4 = r3
        L3b:
            if (r4 >= r0) goto L68
            r7 = r11[r4]
            long r8 = r5 - r1
            int r8 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r8 <= 0) goto L68
            boolean r8 = r7.exists()
            if (r8 == 0) goto L65
            boolean r8 = r7.isFile()
            if (r8 == 0) goto L65
            long r8 = r7.length()
            boolean r10 = r7.exists()
            if (r10 != 0) goto L5c
            goto L61
        L5c:
            boolean r7 = r7.delete()     // Catch: java.lang.Throwable -> L61
            goto L62
        L61:
            r7 = r3
        L62:
            if (r7 == 0) goto L65
            long r1 = r1 + r8
        L65:
            int r4 = r4 + 1
            goto L3b
        L68:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: W0.j.e(long):void");
    }

    public final void g(ArrayList arrayList, int i) {
        boolean z10;
        boolean zE;
        int i6;
        long j5;
        long j6;
        ConcurrentLinkedQueue concurrentLinkedQueue;
        ArrayList arrayListB;
        try {
            g gVar = f.f1476a;
            if (gVar.m) {
                long jCurrentTimeMillis = System.currentTimeMillis() - gVar.k.get();
                long j10 = gVar.b > gVar.d ? gVar.b : gVar.d;
                if (j10 <= gVar.e) {
                    j10 = gVar.e;
                }
                z10 = jCurrentTimeMillis <= j10;
            } else {
                z10 = gVar.m;
            }
            if (z10) {
                if (AbstractC1451a.f4467a) {
                    H4.o.f(S0.a.f1163a, "stop collect log");
                }
                Iterator it = arrayList.iterator();
                long j11 = 0;
                long j12 = 0;
                while (it.hasNext()) {
                    V0.a aVar = (V0.a) it.next();
                    j11 += aVar.b;
                    j12 += aVar.c;
                }
                d.f1474a.b(j11, j12, System.currentTimeMillis());
                f(arrayList);
                return;
            }
            HashMap mapA = o.a(arrayList, i);
            if (mapA == null) {
                f(arrayList);
                return;
            }
            boolean zF = D2.b.f(AbstractC1451a.b);
            boolean z11 = false;
            for (n nVar : mapA.keySet()) {
                byte[] bArr = (byte[]) mapA.get(nVar);
                if (bArr != null) {
                    if (f.f1476a.b() && zF) {
                        if (AbstractC1451a.f4467a && (arrayListB = k0.a.b(bArr)) != null) {
                            Iterator it2 = arrayListB.iterator();
                            while (it2.hasNext()) {
                                k0.a.c("DATA_SEND_BEGIN", (JSONObject) it2.next());
                            }
                        }
                        zE = k.b(nVar).f(bArr);
                        if (AbstractC1451a.f4467a) {
                            if (zE) {
                                Iterator it3 = k0.a.b(bArr).iterator();
                                while (it3.hasNext()) {
                                    JSONObject jSONObject = (JSONObject) it3.next();
                                    try {
                                        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("DATA_DOCTOR");
                                        if (jSONObjectOptJSONObject != null) {
                                            jSONObjectOptJSONObject.put("DATA_SEND_RESULT", 200);
                                        }
                                    } catch (Exception unused) {
                                    }
                                    k0.a.c("DATA_SEND_SUCCESS", jSONObject);
                                    k0.a.c("DATA_SEND_END", jSONObject);
                                }
                            } else {
                                Iterator it4 = k0.a.b(bArr).iterator();
                                while (it4.hasNext()) {
                                    JSONObject jSONObject2 = (JSONObject) it4.next();
                                    k0.a.c("DATA_SEND_FAIL", jSONObject2);
                                    k0.a.c("DATA_SEND_END", jSONObject2);
                                }
                            }
                        }
                        this.d = System.currentTimeMillis();
                        z11 |= zE;
                        i6 = 1;
                    } else {
                        zE = false;
                        i6 = 0;
                    }
                    if (AbstractC1451a.f4467a) {
                        H4.o.f(S0.a.f1163a, "sendDirect:isReportLogEnable " + f.f1476a.b() + " :sendResult " + zE);
                    }
                    if (!zE) {
                        f.f1476a.getClass();
                        long jA = g.a(i6);
                        long jCurrentTimeMillis2 = System.currentTimeMillis() + jA;
                        if (AbstractC1451a.P()) {
                            j6 = jCurrentTimeMillis2;
                            j5 = jA;
                            zE = a.f1471a.e(j6, nVar.a(), bArr, i6);
                        } else {
                            j5 = jA;
                            j6 = jCurrentTimeMillis2;
                        }
                        if (AbstractC1451a.f4467a) {
                            H4.o.f(S0.a.f1163a, "saveFile:Result:" + zE + ":isMaiProcess:" + AbstractC1451a.P() + " :" + i6 + " " + j5);
                        }
                        if (!zE) {
                            if (this.f1481a.containsKey(nVar)) {
                                concurrentLinkedQueue = (ConcurrentLinkedQueue) this.f1481a.get(nVar);
                            } else {
                                concurrentLinkedQueue = new ConcurrentLinkedQueue();
                                i iVar = new i();
                                iVar.f1480a = bArr;
                                iVar.b = i6;
                                iVar.c = j6;
                                concurrentLinkedQueue.add(iVar);
                            }
                            if (concurrentLinkedQueue.size() > 10) {
                                concurrentLinkedQueue.poll();
                            }
                        }
                    }
                }
            }
            if (z11) {
                this.e = 1L;
                this.c = 30000L;
            }
            f(arrayList);
        } catch (Throwable th) {
            H4.o.g(S0.a.f1163a, "sendLog", th);
        }
    }
}
