package com.baidu.location.b;

import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.room.AbstractC0351g;
import com.baidu.location.Jni;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public abstract class m {

    /* renamed from: d, reason: collision with root package name */
    public static String f5345d;

    /* renamed from: e, reason: collision with root package name */
    public a f5349e;

    /* renamed from: a, reason: collision with root package name */
    public com.baidu.location.c.k f5346a = null;

    /* renamed from: b, reason: collision with root package name */
    public com.baidu.location.c.a f5347b = null;

    /* renamed from: c, reason: collision with root package name */
    public HashSet<String> f5348c = null;

    /* renamed from: g, reason: collision with root package name */
    private boolean f5351g = true;

    /* renamed from: h, reason: collision with root package name */
    private boolean f5352h = true;

    /* renamed from: i, reason: collision with root package name */
    private boolean f5353i = false;

    /* renamed from: j, reason: collision with root package name */
    private long f5354j = 0;

    /* renamed from: f, reason: collision with root package name */
    final Handler f5350f = new b();

    /* renamed from: k, reason: collision with root package name */
    private String f5355k = null;

    /* renamed from: l, reason: collision with root package name */
    private String f5356l = null;

    /* renamed from: m, reason: collision with root package name */
    private boolean f5357m = false;

    /* renamed from: n, reason: collision with root package name */
    private long f5358n = 0;

    /* renamed from: o, reason: collision with root package name */
    private int f5359o = 0;

    public static class a extends com.baidu.location.e.f {

        /* renamed from: a, reason: collision with root package name */
        private long f5360a;

        /* renamed from: b, reason: collision with root package name */
        private int f5361b;

        public a() {
            this.el = new HashMap();
        }

        @Override // com.baidu.location.e.f
        public void a() {
            StringBuffer stringBuffer = new StringBuffer(256);
            stringBuffer.append("os=A");
            stringBuffer.append(Build.VERSION.SDK_INT);
            stringBuffer.append("&prod=");
            stringBuffer.append(com.baidu.location.e.b.f5798e);
            stringBuffer.append("&resid=12&mapver=");
            String str = com.baidu.location.e.b.f5802i;
            if (str == null) {
                str = "";
            }
            stringBuffer.append(str);
            stringBuffer.append(com.baidu.location.e.h.e(com.baidu.location.f.getServiceContext()));
            stringBuffer.append("&cu=");
            stringBuffer.append(com.baidu.location.e.b.a().b());
            stringBuffer.append("&error=");
            stringBuffer.append(this.f5361b);
            if (this.f5360a > 0) {
                stringBuffer.append("&tm=");
                stringBuffer.append(this.f5360a);
            }
            this.el.put("info", Jni.encodeTp4(stringBuffer.toString()));
            this.el.put("qt", "monitor");
        }

        @Override // com.baidu.location.e.f
        public void a(boolean z4) {
            Map<String, Object> map = this.el;
            if (map != null) {
                map.clear();
            }
        }
    }

    public class b extends Handler {
        public b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (com.baidu.location.f.isServing) {
                int i4 = message.what;
                if (i4 == 21) {
                    m.this.a(message);
                } else if (i4 == 62 || i4 == 63) {
                    m.this.a();
                }
            }
        }
    }

    public abstract void a();

    public abstract void a(Message message);

    public String b() throws IOException {
        String strC = com.baidu.location.b.b.a().c();
        String strP = com.baidu.location.c.f.a().l() ? "&cn=32" : String.format(Locale.CHINA, "&cn=%d", Integer.valueOf(com.baidu.location.c.f.a().g()));
        if (System.currentTimeMillis() - this.f5358n > 60000) {
            this.f5358n = System.currentTimeMillis();
            String strC2 = com.baidu.location.e.h.c();
            if (!TextUtils.isEmpty(strC2)) {
                strP = AbstractC0351g.q(strP, "&qcip6c=", strC2);
            }
        }
        if (this.f5351g) {
            this.f5351g = false;
        } else if (!this.f5353i) {
            String strE = z.e();
            if (strE != null) {
                strP = AbstractC0351g.p(strP, strE);
            }
            this.f5353i = true;
        }
        return AbstractC0351g.p(strP, strC);
    }

    public String a(String str) {
        com.baidu.location.c.k kVar;
        String strO;
        if (this.f5355k == null) {
            this.f5355k = com.baidu.location.a.a.b(com.baidu.location.f.getServiceContext());
        }
        if (this.f5356l == null) {
            this.f5356l = com.baidu.location.a.a.c(com.baidu.location.f.getServiceContext());
        }
        com.baidu.location.c.a aVar = this.f5347b;
        if (aVar == null || !aVar.a()) {
            this.f5347b = com.baidu.location.c.f.a().f();
        }
        com.baidu.location.c.k kVar2 = this.f5346a;
        if (kVar2 == null || !kVar2.b()) {
            this.f5346a = com.baidu.location.c.f.a().r();
        }
        Location locationG = com.baidu.location.c.d.a().j() ? com.baidu.location.c.d.a().g() : null;
        com.baidu.location.c.a aVar2 = this.f5347b;
        if ((aVar2 == null || aVar2.d() || this.f5347b.c()) && (((kVar = this.f5346a) == null || kVar.a() == 0) && locationG == null)) {
            return null;
        }
        String strB = b();
        if (k.a().d() == -2) {
            strB = AbstractC0351g.p(strB, "&imo=1");
        }
        int iB = com.baidu.location.e.h.b(com.baidu.location.f.getServiceContext());
        if (iB >= 0) {
            strB = strB + "&lmd=" + iB;
            if (!this.f5357m) {
                this.f5357m = true;
                try {
                    if (com.baidu.location.f.getServiceContext().getPackageManager().hasSystemFeature("android.hardware.wifi.rtt")) {
                        strB = strB + "&rtt=1";
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        com.baidu.location.c.k kVar3 = this.f5346a;
        if ((kVar3 == null || kVar3.a() == 0) && (strO = com.baidu.location.c.f.a().o()) != null) {
            strB = AbstractC0351g.p(strO, strB);
        }
        if (com.baidu.location.c.f.a().m()) {
            strB = AbstractC0351g.p(strB, "&wf_freq=1");
        }
        String str2 = strB;
        if (!this.f5352h) {
            return com.baidu.location.e.h.a(this.f5347b, this.f5346a, locationG, str2, 0);
        }
        this.f5352h = false;
        return com.baidu.location.e.h.a(this.f5347b, this.f5346a, locationG, str2, 0, true);
    }

    public class c extends com.baidu.location.e.f {

        /* renamed from: a, reason: collision with root package name */
        String f5363a = null;

        /* renamed from: b, reason: collision with root package name */
        String f5364b = null;

        /* renamed from: c, reason: collision with root package name */
        long f5365c = 0;

        /* renamed from: d, reason: collision with root package name */
        long f5366d = 0;

        /* renamed from: e, reason: collision with root package name */
        long f5367e = 0;

        public c() {
            this.el = new HashMap();
        }

        @Override // com.baidu.location.e.f
        public void a() {
            if ((com.baidu.location.e.h.f5921g || com.baidu.location.e.h.f5923i) && m.this.f5355k != null && m.this.f5356l != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f5364b);
                Locale locale = Locale.CHINA;
                sb.append("&ki=" + m.this.f5355k + "&sn=" + m.this.f5356l);
                this.f5364b = sb.toString();
            }
            if (n.a().b()) {
                this.f5364b = B0.g.r(new StringBuilder(), this.f5364b, "&enc=2");
            }
            String strQ = com.baidu.location.c.f.a().q();
            if (strQ != null) {
                this.er = Jni.encodeTp4(strQ);
            }
            String strEncodeTp4 = Jni.encodeTp4(this.f5364b);
            this.f5364b = null;
            if (this.f5363a == null) {
                this.f5363a = z.b();
            }
            this.el.put("bloc", strEncodeTp4);
            String str = this.f5363a;
            if (str != null) {
                this.el.put("up", str);
            }
            this.el.put("trtm", String.format(Locale.CHINA, "%d", Long.valueOf(System.currentTimeMillis())));
            this.es = 0L;
        }

        public void a(String str, long j4) {
            this.f5364b = str;
            this.f5366d = System.currentTimeMillis();
            this.f5365c = j4;
            ExecutorService executorServiceB = x.a().b();
            if (com.baidu.location.e.h.b()) {
                a(executorServiceB, false, null);
            } else if (executorServiceB != null) {
                a(executorServiceB, com.baidu.location.e.d.f5843e);
            } else {
                b(com.baidu.location.e.d.f5843e);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:4:0x000c, code lost:
        
            r12 = r11.ej;
         */
        @Override // com.baidu.location.e.f
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void a(boolean r12) {
            /*
                Method dump skipped, instructions count: 300
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.m.c.a(boolean):void");
        }
    }
}
