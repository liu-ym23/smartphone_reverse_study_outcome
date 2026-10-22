package com.baidu.location.e;

import android.os.Looper;
import com.baidu.location.b.r;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* loaded from: classes.dex */
public abstract class f {
    public String eh = null;
    public int ei = 1;
    public String ej = null;
    public byte[] ek = null;
    public Map<String, Object> el = null;
    public String em = null;
    public byte[] en = null;
    public byte[] eo = null;
    public String ep = null;
    public boolean eq = false;
    public String er = null;
    public long es = 0;
    public static int eg = com.baidu.location.e.a.f5779f;

    /* renamed from: a, reason: collision with root package name */
    private static String f5869a = "10.0.0.172";

    /* renamed from: b, reason: collision with root package name */
    private static int f5870b = 80;
    protected static int et = 0;

    public static class a implements HostnameVerifier {

        /* renamed from: a, reason: collision with root package name */
        private HttpsURLConnection f5887a;

        public a(HttpsURLConnection httpsURLConnection) {
            this.f5887a = httpsURLConnection;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            String requestProperty = this.f5887a.getRequestProperty("Host");
            if (requestProperty == null) {
                requestProperty = this.f5887a.getURL().getHost();
            }
            return HttpsURLConnection.getDefaultHostnameVerifier().verify(requestProperty, sSLSession);
        }
    }

    public abstract void a();

    public abstract void a(boolean z4);

    public void b(final String str) {
        if (com.baidu.location.b.c.b().ds == 1) {
            (Looper.getMainLooper().getThread() == Thread.currentThread() ? new Thread(new Runnable() { // from class: com.baidu.location.e.f.3
                @Override // java.lang.Runnable
                public void run() {
                    f.this.a(str);
                }
            }) : new Thread(new Runnable() { // from class: com.baidu.location.e.f.4
                @Override // java.lang.Runnable
                public void run() {
                    f.this.a(str);
                }
            })).start();
            return;
        }
        try {
            new Thread() { // from class: com.baidu.location.e.f.5
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Not initialized variable reg: 11, insn: 0x019f: MOVE (r16 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]), block:B:72:0x019e */
                /* JADX WARN: Removed duplicated region for block: B:101:0x020c  */
                /* JADX WARN: Removed duplicated region for block: B:115:0x023a  */
                /* JADX WARN: Removed duplicated region for block: B:128:0x0255  */
                /* JADX WARN: Removed duplicated region for block: B:142:0x026c A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:149:0x021a A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:151:0x025a A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:153:0x0263 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:157:0x0248 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:159:0x0211 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:161:0x023f A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:176:? A[RETURN, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:177:? A[RETURN, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:178:? A[SYNTHETIC] */
                /* JADX WARN: Type inference failed for: r6v15 */
                /* JADX WARN: Type inference failed for: r6v2, types: [java.io.ByteArrayOutputStream] */
                /* JADX WARN: Type inference failed for: r6v20 */
                /* JADX WARN: Type inference failed for: r6v26 */
                /* JADX WARN: Type inference failed for: r6v27 */
                /* JADX WARN: Type inference failed for: r9v1 */
                /* JADX WARN: Type inference failed for: r9v10 */
                /* JADX WARN: Type inference failed for: r9v13 */
                /* JADX WARN: Type inference failed for: r9v17 */
                /* JADX WARN: Type inference failed for: r9v2, types: [java.net.HttpURLConnection] */
                @Override // java.lang.Thread, java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void run() throws java.lang.Throwable {
                    /*
                        Method dump skipped, instructions count: 628
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.e.f.AnonymousClass5.run():void");
                }
            }.start();
        } catch (Throwable unused) {
            a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        r rVarA;
        String str2;
        a();
        final long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.er != null) {
            rVarA = r.a();
            str2 = this.er;
        } else {
            rVarA = r.a();
            str2 = null;
        }
        rVarA.a(str2);
        r.a().a(this.el, str, new r.a() { // from class: com.baidu.location.e.f.1
            @Override // com.baidu.location.b.r.a
            public void a(int i4, String str3) {
                f fVar = f.this;
                fVar.ej = null;
                fVar.a(false);
            }

            @Override // com.baidu.location.b.r.a
            public void a(int i4, String str3, byte[] bArr) {
                f fVar;
                boolean z4;
                if (i4 == 200) {
                    f.this.es = System.currentTimeMillis() - jCurrentTimeMillis;
                    fVar = f.this;
                    fVar.ej = str3;
                    fVar.ek = bArr;
                    z4 = true;
                } else {
                    fVar = f.this;
                    fVar.ej = null;
                    z4 = false;
                }
                fVar.a(z4);
            }
        });
    }

    public void a(ExecutorService executorService, final String str) {
        try {
            executorService.execute(new Runnable() { // from class: com.baidu.location.e.f.6
                /* JADX WARN: Removed duplicated region for block: B:110:0x01e8  */
                /* JADX WARN: Removed duplicated region for block: B:128:0x01ed A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:139:0x01f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:143:0x01ff A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:159:? A[SYNTHETIC] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void run() throws java.lang.Throwable {
                    /*
                        Method dump skipped, instructions count: 519
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.e.f.AnonymousClass6.run():void");
                }
            });
        } catch (Throwable unused) {
            a(false);
        }
    }

    public void a(ExecutorService executorService, final boolean z4, final String str) {
        try {
            executorService.execute(new Runnable() { // from class: com.baidu.location.e.f.2
                /* JADX WARN: Removed duplicated region for block: B:109:0x01d7 A[Catch: Exception -> 0x01b1, TRY_ENTER, TRY_LEAVE, TryCatch #8 {Exception -> 0x01b1, blocks: (B:91:0x01ad, B:109:0x01d7), top: B:141:0x01ad }] */
                /* JADX WARN: Removed duplicated region for block: B:113:0x01de A[LOOP:0: B:3:0x001a->B:113:0x01de, LOOP_END] */
                /* JADX WARN: Removed duplicated region for block: B:115:0x01e4  */
                /* JADX WARN: Removed duplicated region for block: B:135:0x01e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:139:0x01f2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:141:0x01ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:143:0x019b A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:147:0x01a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:151:0x01c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:153:0x01ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:155:0x01fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:170:0x0203 A[EDGE_INSN: B:170:0x0203->B:129:0x0203 BREAK  A[LOOP:0: B:3:0x001a->B:113:0x01de], SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:173:? A[SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:81:0x0196  */
                /* JADX WARN: Removed duplicated region for block: B:99:0x01c0  */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void run() throws java.lang.Throwable {
                    /*
                        Method dump skipped, instructions count: 536
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.e.f.AnonymousClass2.run():void");
                }
            });
        } catch (Throwable unused) {
            a(false);
        }
    }
}
