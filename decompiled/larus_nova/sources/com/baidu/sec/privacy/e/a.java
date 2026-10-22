package com.baidu.sec.privacy.e;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public class a implements com.baidu.sec.privacy.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile a f33511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Context f33512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.baidu.sec.privacy.e.d.a<String> f33513c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.baidu.sec.privacy.e.d.a<Integer> f33514d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.baidu.sec.privacy.e.d.a<Integer> f33515e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.baidu.sec.privacy.e.d.a<String> f33516f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.baidu.sec.privacy.e.d.a<String> f33517g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.baidu.sec.privacy.e.d.a<String> f33518h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.baidu.sec.privacy.e.d.a<String> f33519i;

    /* JADX INFO: renamed from: com.baidu.sec.privacy.e.a$a, reason: collision with other inner class name */
    public class C0671a implements com.baidu.sec.privacy.e.d.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f33520a;

        public C0671a(a r100) {
            this.f33520a = r100;
        }

        @Override // com.baidu.sec.privacy.e.d.a
        public /* bridge */ /* synthetic */ String a(String r100, Object[] r101) {
            return b(r100, r101);
        }

        public String b(String r100, Object... r101) {
            return (String) a.a(this.f33520a, r100);
        }
    }

    public class b implements com.baidu.sec.privacy.e.d.a<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f33521a;

        public b(a r100) {
            this.f33521a = r100;
        }

        @Override // com.baidu.sec.privacy.e.d.a
        public /* bridge */ /* synthetic */ Integer a(String r100, Object[] r101) {
            return b(r100, r101);
        }

        public Integer b(String r100, Object... r101) {
            return (Integer) a.a(this.f33521a, r100);
        }
    }

    public class c implements com.baidu.sec.privacy.e.d.a<Integer> {
        public c(a r100) {
        }

        @Override // com.baidu.sec.privacy.e.d.a
        public /* bridge */ /* synthetic */ Integer a(String r100, Object[] r101) {
            return b(r100, r101);
        }

        public Integer b(String r100, Object... r101) {
            return (Integer) a.b(r100);
        }
    }

    public class d implements com.baidu.sec.privacy.e.d.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f33522a;

        public d(a r100) {
            this.f33522a = r100;
        }

        @Override // com.baidu.sec.privacy.e.d.a
        public /* bridge */ /* synthetic */ String a(String r100, Object[] r101) {
            return b(r100, r101);
        }

        public String b(String r100, Object... r101) {
            return a.a(this.f33522a);
        }
    }

    public class e implements com.baidu.sec.privacy.e.d.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f33523a;

        public e(a r100) {
            this.f33523a = r100;
        }

        @Override // com.baidu.sec.privacy.e.d.a
        public /* bridge */ /* synthetic */ String a(String r100, Object[] r101) {
            return b(r100, r101);
        }

        public String b(String r100, Object... r101) {
            return a.b(this.f33523a);
        }
    }

    public class f implements com.baidu.sec.privacy.e.d.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f33524a;

        public f(a r100) {
            this.f33524a = r100;
        }

        @Override // com.baidu.sec.privacy.e.d.a
        public /* bridge */ /* synthetic */ String a(String r100, Object[] r101) {
            return b(r100, r101);
        }

        public String b(String r100, Object... r101) {
            return a.c(this.f33524a);
        }
    }

    public class g implements com.baidu.sec.privacy.e.d.a<String> {
        public g(a r100) {
        }

        @Override // com.baidu.sec.privacy.e.d.a
        public /* bridge */ /* synthetic */ String a(String r100, Object[] r101) {
            return b(r100, r101);
        }

        public String b(String r100, Object... r101) {
            return Build.MANUFACTURER;
        }
    }

    @Override // com.baidu.sec.privacy.b.a
    public boolean a() {
        return com.baidu.sec.privacy.d.b.b(com.baidu.sec.privacy.d.a.f33501e);
    }

    public String b() {
        if (this.f33519i != null) goto L6;
        this.f33519i = new g(this);
    L6:
        return com.baidu.sec.privacy.f.f.a(f33512b, 71, false, this.f33519i, new Object[0]);
    }

    public Pair<String, String> c() {
        if (this.f33518h != null) goto L5;
        this.f33518h = new f(this);
    L5:
        String r100 = com.baidu.sec.privacy.f.f.a(f33512b, 64, false, this.f33518h, new Object[0]);
        String r101 = "";
        if (com.baidu.sec.privacy.f.f.a(BDLocationException.ERROR_RESTRICTED_MODE_ON) == false) goto L9;
        r101 = "" + com.baidu.sec.privacy.d.a.a("64la_in", 0);
    L9:
        return new Pair(r100, r101);
    }

    public final String d() {
        return com.baidu.sec.privacy.f.d.b(f33512b);
    L4:
        th = move-exception;
        com.baidu.sec.privacy.f.c.a(th);
        return "";
    }

    public final String e() {
        return com.baidu.sec.privacy.f.b.a(f33512b);
    }

    public final String f() {
        return com.baidu.sec.privacy.f.b.b(f33512b);
    }

    public boolean g() {
        if (com.baidu.sec.privacy.f.c.d(f33512b) == false) goto L7;
        return true;
    L7:
        return com.baidu.sec.privacy.d.a.a();
    }

    public a(Context r100) {
        f33512b = r100;
    }

    public static Object c(String r100) {
    L17:
        th = move-exception;
        com.baidu.sec.privacy.f.c.a(th);
    L19:
        return null;
    L4:
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        String[] r101 = r100.split("&&");     // Catch: Throwable -> L17
        if (r101.length == 2) goto L9;
        return null;
    L9:
        String r102 = r101[0];     // Catch: Throwable -> L17
        String r103 = r101[1];     // Catch: Throwable -> L17
        if ("1".equals(r102) == false) goto L14;
        return a(com.baidu.sec.privacy.b.b.a()).g(r103);
    L14:
        if ("2".equals(r102) == false) goto L19;
        return Integer.valueOf(a(com.baidu.sec.privacy.b.b.a()).e(r103));
    }

    public String a(boolean r100) {
        if (this.f33517g != null) goto L6;
        this.f33517g = new e(this);
    L6:
        return com.baidu.sec.privacy.f.f.a(f33512b, 8, r100, this.f33517g, new Object[0]);
    }

    public String b(boolean r100) {
        if (this.f33516f != null) goto L6;
        this.f33516f = new d(this);
    L6:
        return com.baidu.sec.privacy.f.f.a(f33512b, 7, r100, this.f33516f, new Object[0]);
    }

    public final Object d(String r100) {
    L17:
        th = move-exception;
        com.baidu.sec.privacy.f.c.a(th);
    L19:
        return null;
    L4:
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        String[] r101 = r100.split("&&");     // Catch: Throwable -> L17
        if (r101.length == 2) goto L9;
        return null;
    L9:
        String r102 = r101[0];     // Catch: Throwable -> L17
        String r103 = r101[1];     // Catch: Throwable -> L17
        if ("1".equals(r102) == false) goto L14;
        return h(r103);
    L14:
        if ("2".equals(r102) == false) goto L19;
        return Integer.valueOf(f(r103));
    }

    public final int e(String r100) {
        return Settings.Secure.getInt(f33512b.getContentResolver(), r100);
    L4:
        return -1;
    }

    public final int f(String r100) {
        return Settings.System.getInt(f33512b.getContentResolver(), r100);
    L4:
        return -1;
    }

    public final String g(String r100) {
        return com_baidu_sec_privacy_e_a_android_provider_Settings$Secure_getString(f33512b.getContentResolver(), r100);
    L4:
        th = move-exception;
        com.baidu.sec.privacy.f.c.a(th);
        return "";
    }

    public final String h(String r100) {
        return com_baidu_sec_privacy_e_a_android_provider_Settings$System_getString(f33512b.getContentResolver(), r100);
    L4:
        th = move-exception;
        com.baidu.sec.privacy.f.c.a(th);
        return "";
    }

    public static /* synthetic */ Object b(String r100) {
        return c(r100);
    }

    public static /* synthetic */ String c(a r100) {
        return r100.d();
    }

    @Override // com.baidu.sec.privacy.b.a
    public File a(String r100) {
    L8:
        th = move-exception;
        com.baidu.sec.privacy.f.c.a(th);
        return null;
    L4:
        if (com.baidu.sec.privacy.f.f.a(f33512b, 44) == true) goto L6;
        return null;
    L6:
        return new PolarisFileWrapper(r100);
    }

    public static a a(Context r100) {
        if (f33511a != null) goto L13;
        monitor-enter(a.class);
        f33511a = new a(r100);     // Catch: Throwable -> L9
        monitor-exit(a.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L13:
        return f33511a;
    }

    public static /* synthetic */ String b(a r100) {
        return r100.e();
    }

    public static /* synthetic */ String a(a r100) {
        return r100.f();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKEVIRTUAL_com_baidu_sec_privacy_e_a_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader r100, String r101) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r104 = r100.loadClass(r101);     // Catch: Throwable -> L8
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L8
    L7:
        return r104;
    L8:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r101);
    L12:
        throw th;
    L34:
        Class<?> r105 = r100.loadClass(r101);     // Catch: Throwable -> L17
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L17
    L16:
        return r105;
    L17:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r101);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.loadClass(r101);
    }

    private static String com_baidu_sec_privacy_e_a_android_provider_Settings$Secure_getString(ContentResolver r110, String r111) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r110, r111};
        f06.b r112 = new f06.b();
        f06.d r113 = r100.b(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, "java.lang.String", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, null, r112, false);
        return (String) r113.f474983b;
    L6:
        String r114 = Settings.Secure.getString(r110, r111);
        r100.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, r114, r112, true);
        return r114;
    }

    private static String com_baidu_sec_privacy_e_a_android_provider_Settings$System_getString(ContentResolver r110, String r111) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r110, r111};
        f06.b r112 = new f06.b();
        f06.d r113 = r100.b(102003, "android/provider/Settings$System", "getString", Settings.System.class, r101, "java.lang.String", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(102003, "android/provider/Settings$System", "getString", Settings.System.class, r101, null, r112, false);
        return (String) r113.f474983b;
    L6:
        String r114 = Settings.System.getString(r110, r111);
        r100.a(102003, "android/provider/Settings$System", "getString", Settings.System.class, r101, r114, r112, true);
        return r114;
    }

    public boolean a(String r100, String r101) {
    L11:
        th = move-exception;
        com.baidu.sec.privacy.f.c.a(th);
        return false;
    L4:
        if (com.baidu.sec.privacy.f.f.a(f33512b, 42) == true) goto L7;
        return false;
    L7:
        if (com.baidu.sec.privacy.f.e.a(f33512b, new String[]{"android.permission.WRITE_SETTINGS"}) == true) goto L9;
        return false;
    L9:
        return Settings.System.putString(f33512b.getContentResolver(), r100, r101);
    }

    public int b(String r100, boolean r101) {
        return b(r100, r101, false);
    }

    public String c(String r100, boolean r101) {
        return c(r100, r101, false);
    }

    @Override // com.baidu.sec.privacy.b.a
    public Class a(ClassLoader r100, String r101) throws ClassNotFoundException {
        if (com.baidu.sec.privacy.f.f.a(f33512b, 54) == true) goto L7;
        return null;
    L7:
        return INVOKEVIRTUAL_com_baidu_sec_privacy_e_a_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(r100, r101);
    }

    public int a(String r100, boolean r101) {
        return a(r100, r101, false);
    }

    public static /* synthetic */ Object a(a r100, String r101) {
        return r100.d(r101);
    }

    public int a(String r100, boolean r101, boolean r110) {
        if (r101 == false) goto L9;
        if (this.f33515e != null) goto L7;
        this.f33515e = new c(this);
    L7:
        return com.baidu.sec.privacy.f.f.a(f33512b, 48, "2&&" + r100, -1, r110, this.f33515e, new Object[0]);
    L9:
        if (com.baidu.sec.privacy.f.f.a(f33512b, 48) == false) goto L13;
        return e(r100);
    L13:
        return com.baidu.sec.privacy.f.f.a(f33512b, -1, r110);
    }

    public int b(String r100, boolean r101, boolean r110) {
        if (r101 == false) goto L9;
        if (this.f33514d != null) goto L7;
        this.f33514d = new b(this);
    L7:
        return com.baidu.sec.privacy.f.f.a(f33512b, 42, "2&&" + r100, -1, r110, this.f33514d, new Object[0]);
    L9:
        if (com.baidu.sec.privacy.f.f.a(f33512b, 42) == false) goto L13;
        return f(r100);
    L13:
        return com.baidu.sec.privacy.f.f.a(f33512b, -1, r110);
    }

    public String c(String r100, boolean r101, boolean r102) {
        if (r101 == false) goto L9;
        if (this.f33513c != null) goto L7;
        this.f33513c = new C0671a(this);
    L7:
        return com.baidu.sec.privacy.f.f.a(f33512b, 42, "1&&" + r100, r102, this.f33513c, new Object[0]);
    L9:
        if (com.baidu.sec.privacy.f.f.a(f33512b, 42) == false) goto L13;
        return h(r100);
    L13:
        return com.baidu.sec.privacy.f.f.a(f33512b, r102);
    }
}
