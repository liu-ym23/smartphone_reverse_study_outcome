package com.baidu.location.b;

import android.annotation.TargetApi;
import android.location.GnssNavigationMessage;
import android.text.TextUtils;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class y {

    /* renamed from: a, reason: collision with root package name */
    private b f5497a;

    /* renamed from: b, reason: collision with root package name */
    private long f5498b = 0;

    /* renamed from: c, reason: collision with root package name */
    private long f5499c = 0;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static y f5500a = new y();
    }

    public static y a() {
        return a.f5500a;
    }

    public void b() {
        ArrayList<String> arrayListB;
        if (this.f5498b == 0 || Math.abs(System.currentTimeMillis() - this.f5498b) >= 20000) {
            return;
        }
        if (this.f5497a == null) {
            this.f5497a = new b();
        }
        b bVar = this.f5497a;
        if (bVar == null || bVar.b() || (arrayListB = t.a().b()) == null || arrayListB.size() <= 0) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<String> it = arrayListB.iterator();
        int i4 = 0;
        while (it.hasNext()) {
            stringBuffer.append(it.next());
            i4++;
            if (i4 != arrayListB.size()) {
                stringBuffer.append(";");
            }
        }
        this.f5497a.a(stringBuffer.toString(), this.f5499c);
    }

    @TargetApi(24)
    public void a(GnssNavigationMessage gnssNavigationMessage, long j4) {
        t.a().a(gnssNavigationMessage, j4);
        this.f5498b = System.currentTimeMillis();
        this.f5499c = j4;
    }

    public class b extends com.baidu.location.e.f {

        /* renamed from: d, reason: collision with root package name */
        private boolean f5504d = false;

        /* renamed from: e, reason: collision with root package name */
        private String f5505e = null;

        /* renamed from: a, reason: collision with root package name */
        public boolean f5501a = false;

        /* renamed from: b, reason: collision with root package name */
        public long f5502b = 0;

        public b() {
            this.el = new HashMap();
        }

        @Override // com.baidu.location.e.f
        public void a() {
            String strC = com.baidu.location.e.b.a().c();
            if (strC != null) {
                StringBuilder sbV = B0.g.v(strC, "&gnsst=");
                sbV.append(this.f5502b);
                strC = sbV.toString();
            }
            String strA = n.a().a(strC);
            String strReplaceAll = !TextUtils.isEmpty(strA) ? strA.trim().replaceAll("\r|\n", "") : "null";
            String strA2 = n.a().a(this.f5505e);
            String strReplaceAll2 = TextUtils.isEmpty(strA2) ? "null" : strA2.trim().replaceAll("\r|\n", "");
            try {
                this.el.put("info", URLEncoder.encode(strReplaceAll, "utf-8"));
                this.el.put("enl", URLEncoder.encode(strReplaceAll2, "utf-8"));
            } catch (Exception unused) {
            }
        }

        public boolean b() {
            return this.f5504d;
        }

        public void a(String str, long j4) {
            if (this.f5504d) {
                return;
            }
            this.f5504d = true;
            this.f5505e = str;
            this.f5502b = j4;
            ExecutorService executorServiceC = x.a().c();
            if (executorServiceC != null) {
                a(executorServiceC, com.baidu.location.e.d.f5852n);
            } else {
                b(com.baidu.location.e.d.f5852n);
            }
        }

        @Override // com.baidu.location.e.f
        public void a(boolean z4) {
            if (z4 && this.ej != null) {
                try {
                    new JSONObject(this.ej);
                    this.f5501a = true;
                } catch (Throwable unused) {
                }
            }
            Map<String, Object> map = this.el;
            if (map != null) {
                map.clear();
            }
            this.f5504d = false;
        }
    }
}
