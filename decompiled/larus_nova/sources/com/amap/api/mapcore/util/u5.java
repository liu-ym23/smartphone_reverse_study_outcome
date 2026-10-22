package com.amap.api.mapcore.util;

import android.content.Context;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class u5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile d f28055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile f f28056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile String f28057c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile String f28058d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile long f28059e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile c f28060f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile long f28061g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile String f28062h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile String f28063i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static volatile long f28064j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static volatile long f28065k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static volatile boolean f28066l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static volatile boolean f28067m;

    public static class a extends a9 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f28068b;

        @Override // com.amap.api.mapcore.util.a9
        public final void runTask() {
            Iterator r100 = u5.a(u5.a(this.f28068b)).iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            File r101 = (File) r100.next();
            u5.a(this.f28068b, r101.getName());
            goto L4
        L6:
            u5.b(this.f28068b);
        }

        public a(Context r100) {
            this.f28068b = r100;
        }
    }

    public static class b extends a9 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f28069b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f28070c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f28071d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ JSONObject f28072e;

        @Override // com.amap.api.mapcore.util.a9
        public final void runTask() {
            if (this.f28069b == false) goto L8;
            Iterator r100 = u5.a(u5.a(this.f28070c)).iterator();
        L6:
            if (r100.hasNext() == false) goto L8;
            File r101 = (File) r100.next();
            u5.a(this.f28070c, r101.getName());
        L8:
            u5.c(this.f28070c);
            u5.a(this.f28070c, this.f28072e, this.f28071d);
            boolean r102 = u5.a(this.f28070c, this.f28072e);
            if (r102 != true) goto L12;
            u5.b(this.f28070c, u5.a(this.f28071d));
        L12:
            if (this.f28069b == false) goto L14;
            u5.b(this.f28070c);
        L14:
            if (r102 == true) goto L18;
            u5.a(this.f28070c, u5.a(this.f28071d));
            return;
        }

        public b(boolean r100, Context r101, long r102, JSONObject r103) {
            this.f28069b = r100;
            this.f28070c = r101;
            this.f28071d = r102;
            this.f28072e = r103;
        }
    }

    public static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f28073b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f28074c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f28075d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ c[] f28076e = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f28077a;

        static {
            c r100 = new c("Unknow", 0, -1);
            f28073b = r100;
            c r101 = new c("NotAgree", 1, 0);
            f28074c = r101;
            c r102 = new c("DidAgree", 2, 1);
            f28075d = r102;
            f28076e = new c[]{r100, r101, r102};
        }

        public static c[] values() {
            return (c[]) f28076e.clone();
        }

        public final int a() {
            return this.f28077a;
        }

        public static c valueOf(String r100) {
            return (c) r27.a.a(c.class, r100);
        }

        private c(String r100, int r101, int r102) {
            super(r100, r101);
            this.f28077a = r102;
        }
    }

    public static final enum d extends Enum<d> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f28078b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d f28079c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final d f28080d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ d[] f28081e = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f28082a;

        static {
            d r100 = new d("Unknow", 0, -1);
            f28078b = r100;
            d r101 = new d("NotContain", 1, 0);
            f28079c = r101;
            d r102 = new d("DidContain", 2, 1);
            f28080d = r102;
            f28081e = new d[]{r100, r101, r102};
        }

        public static d[] values() {
            return (d[]) f28081e.clone();
        }

        public final int a() {
            return this.f28082a;
        }

        public static d valueOf(String r100) {
            return (d) r27.a.a(d.class, r100);
        }

        private d(String r100, int r101, int r102) {
            super(r100, r101);
            this.f28082a = r102;
        }
    }

    public static final enum e extends Enum<e> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f28083b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final e f28084c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final e f28085d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final e f28086e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final e f28087f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final e f28088g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final e f28089h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final e f28090i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final e f28091j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final /* synthetic */ e[] f28092k = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f28093a;

        static {
            e r100 = new e("SuccessCode", 0, 0);
            f28083b = r100;
            e r101 = new e("ShowUnknowCode", 1, 555570);
            f28084c = r101;
            e r102 = new e("ShowNoShowCode", 2, 555571);
            f28085d = r102;
            e r103 = new e("InfoUnknowCode", 3, 555572);
            f28086e = r103;
            e r104 = new e("InfoNotContainCode", 4, 555573);
            f28087f = r104;
            e r105 = new e("AgreeUnknowCode", 5, 555574);
            f28088g = r105;
            e r110 = new e("AgreeNotAgreeCode", 6, 555575);
            f28089h = r110;
            e r111 = new e("InvaildUserKeyCode", 7, 10001);
            f28090i = r111;
            e r112 = new e("IllegalArgument", 8, 20001);
            f28091j = r112;
            f28092k = new e[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
        }

        public static e[] values() {
            return (e[]) f28092k.clone();
        }

        public final int a() {
            return this.f28093a;
        }

        public static e valueOf(String r100) {
            return (e) r27.a.a(e.class, r100);
        }

        private e(String r100, int r101, int r102) {
            super(r100, r101);
            this.f28093a = r102;
        }
    }

    public static final enum f extends Enum<f> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final f f28094b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final f f28095c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final f f28096d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ f[] f28097e = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f28098a;

        static {
            f r100 = new f("Unknow", 0, -1);
            f28094b = r100;
            f r101 = new f("NotShow", 1, 0);
            f28095c = r101;
            f r102 = new f("DidShow", 2, 1);
            f28096d = r102;
            f28097e = new f[]{r100, r101, r102};
        }

        public static f[] values() {
            return (f[]) f28097e.clone();
        }

        public final int a() {
            return this.f28098a;
        }

        public static f valueOf(String r100) {
            return (f) r27.a.a(f.class, r100);
        }

        private f(String r100, int r101, int r102) {
            super(r100, r101);
            this.f28098a = r102;
        }
    }

    static {
        f28055a = d.f28078b;
        f28056b = f.f28094b;
        f28057c = "";
        f28058d = "";
        f28059e = -1;
        f28060f = c.f28073b;
        f28061g = -1;
        f28062h = "";
        f28063i = "";
        f28064j = 0;
        f28065k = 0;
        f28066l = false;
        f28067m = true;
    }

    public static /* synthetic */ String a(long r100) {
        return b(r100);
    }

    public static void b(Context r100) {
        Iterator<File> r101 = b(r100.getFilesDir().getAbsolutePath() + "/AMap/Privacy/Reload").iterator();     // Catch: Throwable -> L25
    L3:
        if (r101.hasNext() == false) goto L24;
        File r102 = r101.next();     // Catch: Throwable -> L25
        String r103 = r102.getName();     // Catch: Throwable -> L21
    L7:
        if (r103.endsWith("-privacy.data") == false) goto L8;
        String[] r104 = r103.split("-");     // Catch: Throwable -> L21
        if (r104 != null) goto L15;
        if (r104.length == 2) goto L15;
        r102.delete();     // Catch: Throwable -> L21
    L15:
        if (Long.parseLong(r104[0]) <= 0) goto L16;
        PolarisFileInputStreamWrapper r105 = new PolarisFileInputStreamWrapper(r102);     // Catch: Throwable -> L21
        byte[] r106 = new byte[r105.available()];     // Catch: Throwable -> L21
        r105.read(r106);     // Catch: Throwable -> L21
        if (b(r100, new JSONObject(new String(m7.b(r100, r106)))) == false) goto L3;
        r102.delete();     // Catch: Throwable -> L21
        goto L3
    L16:
        r102.delete();     // Catch: Throwable -> L21
        goto L3
    L8:
        r102.delete();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L25
        goto L3
    L24:
        return;
    L25:
        th = move-exception;
        th.printStackTrace();
    }

    public static /* synthetic */ void c(Context r100) {
        d(r100);
    }

    private static synchronized void d(Context r100) {
        monitor-enter(u5.class);
        if (r100 != null) goto L24;
        monitor-exit(u5.class);
        return;
    L24:
    L19:
        th = move-exception;
        throw th;
    L8:
        if (f28066l == true) goto L22;
        e(r100);     // Catch: Throwable -> L19
        f28066l = true;     // Catch: Throwable -> L19
    L22:
        m7.a(r100, "AMap.privacy.data", "AMap.privacy.data", String.format("%d&%d&%d&%s&%s&%d&%d&%s&%s&%d&%d", new Object[]{Integer.valueOf(f28055a.a()), Integer.valueOf(f28056b.a()), Long.valueOf(f28059e), f28057c, f28058d, Integer.valueOf(f28060f.a()), Long.valueOf(f28061g), f28062h, f28063i, Long.valueOf(f28064j), Long.valueOf(f28065k)}));     // Catch: Throwable -> L15
        monitor-exit(u5.class);
        return;
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L19
    }

    private static void e(Context r100) {
        String r101 = m7.a(r100, "AMap.privacy.data", "AMap.privacy.data");     // Catch: Throwable -> L5
    L7:
        if (r101 != null) goto L9;
        return;
    L9:
        String[] r102 = r101.split("&");
        if (r102.length == 11) goto L39;
        return;
    L39:
        int r103 = Integer.parseInt(r102[0]);     // Catch: Throwable -> L36
        d r104 = d.f28079c;     // Catch: Throwable -> L36
        if (r103 == 0) goto L20;
        r104 = d.f28080d;     // Catch: Throwable -> L36
        if (r103 == 1) goto L20;
        r104 = d.f28078b;     // Catch: Throwable -> L36
    L20:
        f28055a = r104;     // Catch: Throwable -> L36
        int r105 = Integer.parseInt(r102[1]);     // Catch: Throwable -> L36
        f r106 = f.f28095c;     // Catch: Throwable -> L36
        if (r105 == 0) goto L27;
        r106 = f.f28096d;     // Catch: Throwable -> L36
        if (r105 == 1) goto L27;
        r106 = f.f28094b;     // Catch: Throwable -> L36
    L27:
        f28056b = r106;     // Catch: Throwable -> L36
        f28059e = Long.parseLong(r102[2]);     // Catch: Throwable -> L36
        f28058d = r102[3];     // Catch: Throwable -> L36
        f28058d = r102[4];     // Catch: Throwable -> L36
        int r107 = Integer.parseInt(r102[5]);     // Catch: Throwable -> L36
        c r108 = c.f28074c;     // Catch: Throwable -> L36
        if (r107 == 0) goto L34;
        r108 = c.f28075d;     // Catch: Throwable -> L36
        if (r107 == 1) goto L34;
        r108 = c.f28073b;     // Catch: Throwable -> L36
    L34:
        f28060f = r108;     // Catch: Throwable -> L36
        f28061g = Long.parseLong(r102[6]);     // Catch: Throwable -> L36
        f28062h = r102[7];     // Catch: Throwable -> L36
        f28063i = r102[8];     // Catch: Throwable -> L36
        f28064j = Long.parseLong(r102[9]);     // Catch: Throwable -> L36
        f28065k = Long.parseLong(r102[10]);     // Catch: Throwable -> L36
        return;
    L36:
        th = move-exception;
        th.printStackTrace();
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        r101 = null;
        goto L7
    }

    private static String f(Context r100) {
        return r100.getFilesDir().getAbsolutePath() + "/AMap/Privacy/Upload";
    }

    public static /* synthetic */ String a(Context r100) {
        return f(r100);
    }

    private static ArrayList<File> b(String r100) {
        ArrayList<File> r101 = new ArrayList();
        if (r100 != null) goto L5;
    L17:
        return r101;
    L5:
        if (r100.length() == 0) goto L17;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        if (r102.exists() == true) goto L10;
        return r101;
    L10:
        File[] r103 = r102.listFiles();
        int r104 = 0;
    L12:
        if (r104 >= r103.length) goto L17;
        File r105 = r103[r104];
        if (r105.isFile() == false) goto L16;
        r101.add(r105);
    L16:
        r104 = r104 + 1;
        goto L12
    }

    public static /* synthetic */ ArrayList a(String r100) {
        return b(r100);
    }

    private static String b(long r100) {
        return String.format("%d-%s", new Object[]{Long.valueOf(r100), "privacy.data"});
    }

    public static synchronized v5 a(Context r110, w5 r111) {
        monitor-enter(u5.class);
        if (r110 == null) goto L76;
        if (r111 == null) goto L76;
        if (f28066l == true) goto L10;
        e(r110);     // Catch: Throwable -> L79
        f28066l = true;     // Catch: Throwable -> L79
    L10:
        v5 r100 = null;
        if (f28056b != f.f28096d) goto L13;
        boolean r101 = true;
    L20:
        if (r101 == true) goto L22;
    L30:
        if (r101 != true) goto L41;
        if (f28060f == c.f28075d) goto L41;
        if (f28060f != c.f28073b) goto L37;
        r100 = new v5(e.f28088g, r111);     // Catch: Throwable -> L79
    L39:
        r101 = false;
        goto L41
    L37:
        if (f28060f != c.f28074c) goto L39;
        r100 = new v5(e.f28089h, r111);     // Catch: Throwable -> L79
    L41:
        if (f28065k == f28064j) goto L64;
        long r102 = f28064j;     // Catch: Throwable -> L79
        f28065k = f28064j;     // Catch: Throwable -> L79
        JSONObject r112 = new JSONObject();     // Catch: Throwable -> L82
        r112.put("privacyInfo", f28055a.a());     // Catch: Throwable -> L82
        r112.put("privacyShow", f28056b.a());     // Catch: Throwable -> L82
        r112.put("showTime", f28059e);     // Catch: Throwable -> L82
        r112.put("show2SDK", f28057c);     // Catch: Throwable -> L82
        r112.put("show2SDKVer", f28058d);     // Catch: Throwable -> L82
        r112.put("privacyAgree", f28060f.a());     // Catch: Throwable -> L82
        r112.put("agreeTime", f28061g);     // Catch: Throwable -> L82
        r112.put("agree2SDK", f28062h);     // Catch: Throwable -> L82
        r112.put("agree2SDKVer", f28063i);     // Catch: Throwable -> L82
        z8.f().d(new b(f28067m, r110, r102, r112));     // Catch: Throwable -> L79
    L66:
        f28067m = false;     // Catch: Throwable -> L79
        String r113 = l5.e(r110);     // Catch: Throwable -> L79
        if (r113 != null) goto L69;
    L70:
        r100 = new v5(e.f28090i, r111);     // Catch: Throwable -> L79
        r111.d();     // Catch: Throwable -> L79
        String.format("获取apikey失败：\nerrorCode : %d\n原因：%s", new Object[]{Integer.valueOf(r100.f28191a.a()), r100.f28192b});     // Catch: Throwable -> L79
    L71:
        if (r101 == false) goto L73;
        r100 = new v5(e.f28083b, r111);     // Catch: Throwable -> L79
    L74:
        monitor-exit(u5.class);
        return r100;
    L73:
        r111.d();     // Catch: Throwable -> L79
        String.format("隐私合规校验失败：\nerrorCode : %d\n原因：%s", new Object[]{Integer.valueOf(r100.f28191a.a()), r100.f28192b});     // Catch: Throwable -> L79
        goto L74
    L69:
        if (r113.length() > 0) goto L71;
    L64:
        if (f28067m == false) goto L66;
        z8.f().d(new a(r110));     // Catch: Throwable -> L79
        goto L66
    L22:
        if (f28055a == d.f28080d) goto L30;
        if (f28055a != d.f28078b) goto L27;
        r100 = new v5(e.f28086e, r111);     // Catch: Throwable -> L79
    L29:
        r101 = false;
        goto L30
    L27:
        if (f28055a != d.f28079c) goto L29;
        r100 = new v5(e.f28087f, r111);     // Catch: Throwable -> L79
        goto L29
    L13:
        if (f28056b != f.f28094b) goto L16;
        r100 = new v5(e.f28084c, r111);     // Catch: Throwable -> L79
    L18:
        r101 = false;
        goto L20
    L16:
        if (f28056b != f.f28095c) goto L18;
        r100 = new v5(e.f28085d, r111);     // Catch: Throwable -> L79
    L76:
        v5 r114 = new v5(e.f28091j, r111);     // Catch: Throwable -> L79
        monitor-exit(u5.class);
        return r114;
    L79:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void b(Context r100, String r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r101.length() == 0) goto L17;
        PolarisFileWrapper r102 = new PolarisFileWrapper(f(r100) + HTTP.URL_DEFAULT + r101);     // Catch: Throwable -> L11
        if (r102.exists() == true) goto L9;
        return;
    L9:
        r102.delete();     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public static void a(Context r100, String r101) {
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.length() == 0) goto L21;
        PolarisFileWrapper r102 = new PolarisFileWrapper(f(r100) + HTTP.URL_DEFAULT + r101);     // Catch: Throwable -> L15
        if (r102.exists() == true) goto L10;
        return;
    L10:
        PolarisFileWrapper r103 = new PolarisFileWrapper((r100.getFilesDir().getAbsolutePath() + "/AMap/Privacy/Reload") + HTTP.URL_DEFAULT + r101);     // Catch: Throwable -> L15
        if (r103.getParentFile().exists() == true) goto L13;
        r103.getParentFile().mkdirs();     // Catch: Throwable -> L15
    L13:
        r102.renameTo(r103);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    private static boolean b(Context r100, JSONObject r101) {
        a7 r102 = new a7();     // Catch: Throwable -> L9
        r102.f26886p = r100;     // Catch: Throwable -> L9
        r102.f26885o = r101;     // Catch: Throwable -> L9
        JSONObject r103 = new JSONObject(x5.c(new r7().a(r102).f28591a));     // Catch: Throwable -> L9
        if (r103.has("status") == false) goto L11;
        if (r103.getInt("status") != 1) goto L11;
        return true;
    L11:
        return false;
    L9:
        th = move-exception;
        th.printStackTrace();
        goto L11
    }

    public static /* synthetic */ boolean a(Context r100, JSONObject r101) {
        return b(r100, r101);
    }

    public static /* synthetic */ void a(Context r100, JSONObject r101, long r102) {
        byte[] r103 = m7.a(r100, r101.toString().getBytes());     // Catch: Throwable -> L14
        String r104 = b(r102);     // Catch: Throwable -> L14
        PolarisFileWrapper r105 = new PolarisFileWrapper(f(r100) + HTTP.URL_DEFAULT + r104);     // Catch: Throwable -> L14
        if (r105.getParentFile().exists() == true) goto L5;
        r105.getParentFile().mkdirs();     // Catch: Throwable -> L14
    L5:
        PolarisFileOutputStreamWrapper r106 = new PolarisFileOutputStreamWrapper(r105);     // Catch: Throwable -> L14
        r106.write(r103);     // Catch: Throwable -> L12
        r106.close();     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        th.printStackTrace();
        return;
    L12:
        Throwable th10 = th;
    L32:
        th10.printStackTrace();     // Catch: Throwable -> L23
        if (r106 == null) goto L42;
        r106.close();     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        th.printStackTrace();
        return;
    L42:
        return;
    L23:
        th = move-exception;
        if (r106 != null) goto L36;
    L29:
        throw th;
    L36:
        r106.close();     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        th.printStackTrace();
    L14:
        th = move-exception;
        th10 = th;
        r106 = null;
        goto L32
    }

    public static void a(Context r100, boolean r101, w5 r102) {
        if (r101 == false) goto L4;
        c r103 = c.f28075d;
    L6:
        monitor-enter(u5.class);
        if (r100 == null) goto L20;
        if (r102 == null) goto L20;
    L17:
        th = move-exception;
        throw th;
    L11:
        if (f28066l == true) goto L14;
        e(r100);     // Catch: Throwable -> L17
        f28066l = true;     // Catch: Throwable -> L17
    L14:
        if (r103 == f28060f) goto L20;
        f28060f = r103;     // Catch: Throwable -> L17
        f28062h = r102.d();     // Catch: Throwable -> L17
        f28063i = r102.e();     // Catch: Throwable -> L17
        long r104 = System.currentTimeMillis();     // Catch: Throwable -> L17
        f28061g = r104;     // Catch: Throwable -> L17
        f28064j = r104;     // Catch: Throwable -> L17
        d(r100);     // Catch: Throwable -> L17
    L20:
        monitor-exit(u5.class);
        return;
    L4:
        r103 = c.f28074c;
        goto L6
    }

    public static void a(Context r100, boolean r101, boolean r102, w5 r103) {
        if (r102 == false) goto L4;
        f r104 = f.f28096d;
    L5:
        if (r101 == false) goto L7;
        d r105 = d.f28080d;
    L9:
        monitor-enter(u5.class);
        if (r100 == null) goto L29;
        if (r103 == null) goto L29;
    L26:
        th = move-exception;
        throw th;
    L14:
        if (f28066l == true) goto L16;
        e(r100);     // Catch: Throwable -> L26
        f28066l = true;     // Catch: Throwable -> L26
    L16:
        Boolean r106 = Boolean.FALSE;     // Catch: Throwable -> L26
        if (r104 == f28056b) goto L20;
        r106 = Boolean.TRUE;     // Catch: Throwable -> L26
        f28056b = r104;     // Catch: Throwable -> L26
    L20:
        if (r105 == f28055a) goto L23;
        r106 = Boolean.TRUE;     // Catch: Throwable -> L26
        f28055a = r105;     // Catch: Throwable -> L26
    L23:
        if (r106.booleanValue() == false) goto L29;
        f28057c = r103.d();     // Catch: Throwable -> L26
        f28058d = r103.e();     // Catch: Throwable -> L26
        long r107 = System.currentTimeMillis();     // Catch: Throwable -> L26
        f28059e = r107;     // Catch: Throwable -> L26
        f28064j = r107;     // Catch: Throwable -> L26
        d(r100);     // Catch: Throwable -> L26
    L29:
        monitor-exit(u5.class);
        return;
    L7:
        r105 = d.f28079c;
        goto L9
    L4:
        r104 = f.f28095c;
        goto L5
    }
}
