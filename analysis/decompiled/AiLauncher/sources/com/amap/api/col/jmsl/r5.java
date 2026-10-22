package com.amap.api.col.jmsl;

import android.content.Context;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.speech.model.ErrorModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class r5 {

    /* renamed from: a, reason: collision with root package name */
    public static volatile d f16818a = d.Unknow;

    /* renamed from: b, reason: collision with root package name */
    public static volatile f f16819b = f.Unknow;

    /* renamed from: c, reason: collision with root package name */
    public static volatile String f16820c = "";

    /* renamed from: d, reason: collision with root package name */
    public static volatile String f16821d = "";

    /* renamed from: e, reason: collision with root package name */
    public static volatile long f16822e = -1;

    /* renamed from: f, reason: collision with root package name */
    public static volatile c f16823f = c.Unknow;

    /* renamed from: g, reason: collision with root package name */
    public static volatile long f16824g = -1;

    /* renamed from: h, reason: collision with root package name */
    public static volatile String f16825h = "";

    /* renamed from: i, reason: collision with root package name */
    public static volatile String f16826i = "";

    /* renamed from: j, reason: collision with root package name */
    public static volatile long f16827j = 0;

    /* renamed from: k, reason: collision with root package name */
    public static volatile long f16828k = 0;

    /* renamed from: l, reason: collision with root package name */
    public static volatile boolean f16829l = false;

    /* renamed from: m, reason: collision with root package name */
    public static volatile boolean f16830m = true;

    public static class a extends AbstractRunnableC1545d2 {

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f16831d;

        public a(Context context) {
            this.f16831d = context;
        }

        @Override // com.amap.api.col.jmsl.AbstractRunnableC1545d2
        public final void runTask() {
            Iterator it = r5.k(r5.r(this.f16831d)).iterator();
            while (it.hasNext()) {
                r5.e(this.f16831d, ((File) it.next()).getName());
            }
            r5.l(this.f16831d);
        }
    }

    public static class b extends AbstractRunnableC1545d2 {

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f16832d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Context f16833e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ long f16834f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ JSONObject f16835g;

        public b(boolean z10, Context context, long j10, JSONObject jSONObject) {
            this.f16832d = z10;
            this.f16833e = context;
            this.f16834f = j10;
            this.f16835g = jSONObject;
        }

        @Override // com.amap.api.col.jmsl.AbstractRunnableC1545d2
        public final void runTask() {
            if (this.f16832d) {
                Iterator it = r5.k(r5.r(this.f16833e)).iterator();
                while (it.hasNext()) {
                    r5.e(this.f16833e, ((File) it.next()).getName());
                }
            }
            r5.p(this.f16833e);
            r5.f(this.f16833e, this.f16835g, this.f16834f);
            boolean zN = r5.n(this.f16833e, this.f16835g);
            if (zN) {
                r5.m(this.f16833e, r5.j(this.f16834f));
            }
            if (this.f16832d) {
                r5.l(this.f16833e);
            }
            if (zN) {
                return;
            }
            r5.e(this.f16833e, r5.j(this.f16834f));
        }
    }

    public enum c {
        Unknow(-1),
        NotAgree(0),
        DidAgree(1);


        /* renamed from: a, reason: collision with root package name */
        private int f16840a;

        c(int i10) {
            this.f16840a = i10;
        }

        public final int f() {
            return this.f16840a;
        }
    }

    public enum d {
        Unknow(-1),
        NotContain(0),
        DidContain(1);


        /* renamed from: a, reason: collision with root package name */
        private int f16845a;

        d(int i10) {
            this.f16845a = i10;
        }

        public final int f() {
            return this.f16845a;
        }
    }

    public enum e {
        SuccessCode(0),
        ShowUnknowCode(555570),
        ShowNoShowCode(555571),
        InfoUnknowCode(555572),
        InfoNotContainCode(555573),
        AgreeUnknowCode(555574),
        AgreeNotAgreeCode(555575),
        InvaildUserKeyCode(10001),
        IllegalArgument(ErrorModel.Err_ASR);


        /* renamed from: a, reason: collision with root package name */
        private final int f16856a;

        e(int i10) {
            this.f16856a = i10;
        }

        public final int f() {
            return this.f16856a;
        }
    }

    public enum f {
        Unknow(-1),
        NotShow(0),
        DidShow(1);


        /* renamed from: a, reason: collision with root package name */
        private int f16861a;

        f(int i10) {
            this.f16861a = i10;
        }

        public final int f() {
            return this.f16861a;
        }
    }

    public static synchronized C1537b2 a(Context context, C1569j2 c1569j2) {
        boolean z10;
        Context context2;
        try {
            if (context == null || c1569j2 == null) {
                return new C1537b2(e.IllegalArgument, c1569j2);
            }
            if (!f16829l) {
                q(context);
                f16829l = true;
            }
            C1537b2 c1537b2 = null;
            if (f16819b != f.DidShow) {
                if (f16819b == f.Unknow) {
                    c1537b2 = new C1537b2(e.ShowUnknowCode, c1569j2);
                } else if (f16819b == f.NotShow) {
                    c1537b2 = new C1537b2(e.ShowNoShowCode, c1569j2);
                }
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10 && f16818a != d.DidContain) {
                if (f16818a == d.Unknow) {
                    c1537b2 = new C1537b2(e.InfoUnknowCode, c1569j2);
                } else if (f16818a == d.NotContain) {
                    c1537b2 = new C1537b2(e.InfoNotContainCode, c1569j2);
                }
                z10 = false;
            }
            if (z10 && f16823f != c.DidAgree) {
                if (f16823f == c.Unknow) {
                    c1537b2 = new C1537b2(e.AgreeUnknowCode, c1569j2);
                } else if (f16823f == c.NotAgree) {
                    c1537b2 = new C1537b2(e.AgreeNotAgreeCode, c1569j2);
                }
                z10 = false;
            }
            if (f16828k != f16827j) {
                long j10 = f16827j;
                f16828k = f16827j;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("privacyInfo", f16818a.f());
                    jSONObject.put("privacyShow", f16819b.f());
                    jSONObject.put("showTime", f16822e);
                    jSONObject.put("show2SDK", f16820c);
                    jSONObject.put("show2SDKVer", f16821d);
                    jSONObject.put("privacyAgree", f16823f.f());
                    jSONObject.put("agreeTime", f16824g);
                    jSONObject.put("agree2SDK", f16825h);
                    jSONObject.put("agree2SDKVer", f16826i);
                    context2 = context;
                    V1.h().f(new b(f16830m, context2, j10, jSONObject));
                } catch (Throwable unused) {
                    context2 = context;
                }
            } else {
                context2 = context;
                if (f16830m) {
                    V1.h().f(new a(context2));
                }
            }
            f16830m = false;
            String strN = C1567j0.n(context2);
            if (strN == null || strN.length() <= 0) {
                c1537b2 = new C1537b2(e.InvaildUserKeyCode, c1569j2);
                Log.e(c1569j2.g(), String.format("获取apikey失败：\nerrorCode : %d\n原因：%s", Integer.valueOf(c1537b2.f16534a.f()), c1537b2.f16535b));
            }
            if (z10) {
                c1537b2 = new C1537b2(e.SuccessCode, c1569j2);
            } else {
                Log.e(c1569j2.g(), String.format("隐私合规校验失败：\nerrorCode : %d\n原因：%s", Integer.valueOf(c1537b2.f16534a.f()), c1537b2.f16535b));
            }
            return c1537b2;
        } catch (Throwable th) {
            throw th;
        }
    }

    public static void e(Context context, String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            File file = new File(r(context) + "/" + str);
            if (file.exists()) {
                File file2 = new File((context.getFilesDir().getAbsolutePath() + "/AMap/Privacy/Reload") + "/" + str);
                if (!file2.getParentFile().exists()) {
                    file2.getParentFile().mkdirs();
                }
                file.renameTo(file2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static /* synthetic */ void f(Context context, JSONObject jSONObject, long j10) {
        Throwable th;
        FileOutputStream fileOutputStream;
        byte[] bArrL;
        try {
            bArrL = C1575l0.l(context, jSONObject.toString().getBytes());
            String strJ = j(j10);
            File file = new File(r(context) + "/" + strJ);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
        try {
            fileOutputStream.write(bArrL);
            try {
                fileOutputStream.close();
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
        } catch (Throwable th4) {
            th = th4;
            try {
                th.printStackTrace();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
            } catch (Throwable th6) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th7) {
                        th7.printStackTrace();
                    }
                }
                throw th6;
            }
        }
    }

    public static void g(Context context, boolean z10, C1569j2 c1569j2) {
        c cVar = z10 ? c.DidAgree : c.NotAgree;
        synchronized (r5.class) {
            if (context != null && c1569j2 != null) {
                try {
                    if (!f16829l) {
                        q(context);
                        f16829l = true;
                    }
                    if (cVar != f16823f) {
                        f16823f = cVar;
                        f16825h = c1569j2.g();
                        f16826i = c1569j2.h();
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        f16824g = jCurrentTimeMillis;
                        f16827j = jCurrentTimeMillis;
                        p(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static void h(Context context, boolean z10, boolean z11, C1569j2 c1569j2) {
        f fVar = z11 ? f.DidShow : f.NotShow;
        d dVar = z10 ? d.DidContain : d.NotContain;
        synchronized (r5.class) {
            if (context != null && c1569j2 != null) {
                try {
                    if (!f16829l) {
                        q(context);
                        f16829l = true;
                    }
                    Boolean bool = Boolean.FALSE;
                    if (fVar != f16819b) {
                        bool = Boolean.TRUE;
                        f16819b = fVar;
                    }
                    if (dVar != f16818a) {
                        bool = Boolean.TRUE;
                        f16818a = dVar;
                    }
                    if (bool.booleanValue()) {
                        f16820c = c1569j2.g();
                        f16821d = c1569j2.h();
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        f16822e = jCurrentTimeMillis;
                        f16827j = jCurrentTimeMillis;
                        p(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static String j(long j10) {
        return String.format("%d-%s", Long.valueOf(j10), "privacy.data");
    }

    public static ArrayList<File> k(String str) {
        ArrayList<File> arrayList = new ArrayList<>();
        if (str != null && str.length() != 0) {
            File file = new File(str);
            if (file.exists()) {
                File[] fileArrListFiles = file.listFiles();
                for (File file2 : fileArrListFiles) {
                    if (file2.isFile()) {
                        arrayList.add(file2);
                    }
                }
            }
        }
        return arrayList;
    }

    public static void l(Context context) {
        try {
            Iterator<File> it = k(context.getFilesDir().getAbsolutePath() + "/AMap/Privacy/Reload").iterator();
            while (it.hasNext()) {
                File next = it.next();
                try {
                    String name = next.getName();
                    if (name.endsWith("-privacy.data")) {
                        String[] strArrSplit = name.split(O6.l.DATE_SEPARATOR);
                        if (strArrSplit == null && strArrSplit.length != 2) {
                            next.delete();
                        } else if (Long.parseLong(strArrSplit[0]) <= 0) {
                            next.delete();
                        } else {
                            FileInputStream fileInputStream = new FileInputStream(next);
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            if (n(context, new JSONObject(new String(C1575l0.o(context, bArr))))) {
                                next.delete();
                            }
                        }
                    } else {
                        next.delete();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static /* synthetic */ void m(Context context, String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            File file = new File(r(context) + "/" + str);
            if (file.exists()) {
                file.delete();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean n(Context context, JSONObject jSONObject) {
        try {
            C1608t2 c1608t2 = new C1608t2();
            c1608t2.f16967z = context;
            c1608t2.f16966y = jSONObject;
            JSONObject jSONObject2 = new JSONObject(C1604s2.n(new C1540c1().d(c1608t2).f16719a));
            if (jSONObject2.has("status")) {
                return jSONObject2.getInt("status") == 1;
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static synchronized void p(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (!f16829l) {
                q(context);
                f16829l = true;
            }
            try {
                C1575l0.d(context, "AMap.privacy.data", "AMap.privacy.data", String.format("%d&%d&%d&%s&%s&%d&%d&%s&%s&%d&%d", Integer.valueOf(f16818a.f()), Integer.valueOf(f16819b.f()), Long.valueOf(f16822e), f16820c, f16821d, Integer.valueOf(f16823f.f()), Long.valueOf(f16824g), f16825h, f16826i, Long.valueOf(f16827j), Long.valueOf(f16828k)));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public static void q(Context context) {
        String strC;
        try {
            strC = C1575l0.c(context, "AMap.privacy.data", "AMap.privacy.data");
        } catch (Throwable th) {
            th.printStackTrace();
            strC = null;
        }
        if (strC == null) {
            return;
        }
        String[] strArrSplit = strC.split(Const.STR_MART_ADD);
        if (strArrSplit.length != 11) {
            return;
        }
        try {
            int i10 = Integer.parseInt(strArrSplit[0]);
            d dVar = d.NotContain;
            if (i10 != 0) {
                dVar = d.DidContain;
                if (i10 != 1) {
                    dVar = d.Unknow;
                }
            }
            f16818a = dVar;
            int i11 = Integer.parseInt(strArrSplit[1]);
            f fVar = f.NotShow;
            if (i11 != 0) {
                fVar = f.DidShow;
                if (i11 != 1) {
                    fVar = f.Unknow;
                }
            }
            f16819b = fVar;
            f16822e = Long.parseLong(strArrSplit[2]);
            f16821d = strArrSplit[3];
            f16821d = strArrSplit[4];
            int i12 = Integer.parseInt(strArrSplit[5]);
            c cVar = c.NotAgree;
            if (i12 != 0) {
                cVar = c.DidAgree;
                if (i12 != 1) {
                    cVar = c.Unknow;
                }
            }
            f16823f = cVar;
            f16824g = Long.parseLong(strArrSplit[6]);
            f16825h = strArrSplit[7];
            f16826i = strArrSplit[8];
            f16827j = Long.parseLong(strArrSplit[9]);
            f16828k = Long.parseLong(strArrSplit[10]);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static String r(Context context) {
        return context.getFilesDir().getAbsolutePath() + "/AMap/Privacy/Upload";
    }
}
