package ms.bd.c;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static boolean f39482a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile int f39483b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile String f39484c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile String f39485d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static HashMap<Integer, com.bytedance.mobsec.metasec.ml.d.a> f39486e;
    private static HandlerThread f;
    private static AtomicBoolean g;
    private static Handler h;

    final class a implements Runnable {

        /* JADX INFO: renamed from: ms.bd.c.e$a$a, reason: collision with other inner class name */
        final class C1064a implements Application.ActivityLifecycleCallbacks {

            /* JADX INFO: renamed from: ms.bd.c.e$a$a$a, reason: collision with other inner class name */
            final class RunnableC1065a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ Activity f39487a;

                RunnableC1065a(Activity r3) {
                    this.f39487a = ZeusTransformUtils.wrapperContext2Activity((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
                }

                @Override // java.lang.Runnable
                public final void run() {
                    e.a(this.f39487a);
                    e.a(1);
                }
            }

            /* JADX INFO: renamed from: ms.bd.c.e$a$a$b */
            final class b implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ C1064a f39488a;

                /* JADX INFO: renamed from: ms.bd.c.e$a$a$b$a, reason: collision with other inner class name */
                final class RunnableC1066a implements Runnable {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final /* synthetic */ b f39489a;

                    RunnableC1066a(b r1) {
                        this.f39489a = r1;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        C1064a.a(this.f39489a.f39488a);
                    }
                }

                b(C1064a r1) {
                    this.f39488a = r1;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (C1064a.a(this.f39488a) == true) goto L6;
                    e.f().postDelayed(new RunnableC1066a(this), 1000);
                    return;
                }
            }

            C1064a() {
            }

            private static boolean a() {
                if (((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.a(), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin")) == null) goto L6;
                byte r0 = 1;
            L8:
                if (r0 != 0) goto L11;
                e.a(0);
                e.f39482a = false;
                return true;
            L11:
                return false;
            L6:
                r0 = 0;
            L7:
                r0 = -1;
                goto L8
            }

            static /* synthetic */ boolean a(C1064a r0) {
                r0.getClass();
                return a();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityCreated(Activity r1, Bundle r2) {
                Activity r0 = (Activity) ZeusTransformUtils.wrapperContextForParams(r1, Activity.class, "com.obric.aiagent.plugin");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityDestroyed(Activity r2) {
                Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityPaused(Activity r2) {
                Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityResumed(Activity r2) {
                Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
                if (e.f39482a == true) goto L6;
                e.f39482a = true;
                e.f().post(new RunnableC1065a(r1));
                return;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivitySaveInstanceState(Activity r1, Bundle r2) {
                Activity r0 = (Activity) ZeusTransformUtils.wrapperContextForParams(r1, Activity.class, "com.obric.aiagent.plugin");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityStarted(Activity r2) {
                Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityStopped(Activity r3) {
                Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
                if (e.f39482a == false) goto L6;
                e.f().post(new b(this));
                return;
            }
        }

        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (e.d().getAndSet(false) == false) goto L13;
            e.e().start();     // Catch: Exception -> L8
            e.a(new Handler(e.e().getLooper()));     // Catch: Exception -> L8
        L9:
            ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.b(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).registerActivityLifecycleCallbacks(new C1064a());     // Catch: Throwable -> L7
            return;
        L14:
            return;
        }
    }

    static {
        f39486e = new HashMap(3);
        f39482a = false;
        f = new HandlerThread((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "592094", new byte[]{41, 40, 82, 64, 13}), String.class, "com.obric.aiagent.plugin"));
        g = new AtomicBoolean(true);
        h = null;
    }

    public static int a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (f39483b > 0) goto L6;
        f39483b = r3.getPackageManager().getPackageInfo(r3.getPackageName(), 0).versionCode;     // Catch: Throwable -> L7
    L6:
        return f39483b;
    }

    public static Activity a() {
        Class r3 = ZeusTransformUtils.forName((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "3c10bb", new byte[]{35, 111, 70, 86, 82, 124, 52, 12, 97, 112, 50, 47, 99, 71, 73, 124, 38, 75, 116, 121, 22, 105, 80, 65, 92, 113}), String.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");     // Catch: Exception -> L21
        Object r4 = r3.getMethod((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "7e1e95", new byte[]{37, 114, 80, 3, 3, 44, 32, 101, 99, 33, 47, 113, 75, 5, 31, 22, 60, 86, 101, 52, 34}), String.class, "com.obric.aiagent.plugin"), new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L21
        if (r4 != null) goto L6;
        int r6 = Build.VERSION.SDK_INT;     // Catch: Exception -> L21
    L6:
        Field r5 = r3.getDeclaredField((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "f94d18", new byte[]{122, 26, 68, 4, 7, 57, 108, 12, 108, 49, 100}), String.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L21
        r5.setAccessible(true);     // Catch: Exception -> L21
        if (Build.VERSION.SDK_INT >= 19) goto L9;
        Map r7 = (HashMap) ZeusTransformUtils.preCheckCast(r5.get(r4), HashMap.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L21
    L11:
        if (r7.size() >= 1) goto L14;
        return null;
    L14:
        Iterator r8 = r7.values().iterator();     // Catch: Exception -> L21
    L16:
        if (r8.hasNext() == false) goto L29;
        Object r9 = r8.next();     // Catch: Exception -> L21
        Class<?> r10 = r9.getClass();     // Catch: Exception -> L21
        Field r11 = r10.getDeclaredField((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "f6ad62", new byte[]{100, 32, 29, 0, 25, 32, 97}), String.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L21
        r11.setAccessible(true);     // Catch: Exception -> L21
        if (r11.getBoolean(r9) == true) goto L16;
        Field r1 = r10.getDeclaredField((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "b43787", new byte[]{114, 53, 84, 74, 17, 41, 117, 12}), String.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L21
        r1.setAccessible(true);     // Catch: Exception -> L21
        return (Activity) ZeusTransformUtils.preCheckCast(r1.get(r9), Activity.class, "com.obric.aiagent.plugin");
    L29:
        return null;
    L9:
        r7 = (ArrayMap) ZeusTransformUtils.preCheckCast(r5.get(r4), ArrayMap.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L21
    L21:
        String r0 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "48b159", new byte[]{36, 51, 46, 66}), String.class, "com.obric.aiagent.plugin");
        return null;
    }

    public static void a(Activity r28) {
        Activity r0 = (Activity) ZeusTransformUtils.wrapperContextForParams(r28, Activity.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT >= 22) goto L10;
        return;
    L10:
        Field r2 = ZeusTransformUtils.forName((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "b54f3c", new byte[]{114, 57, 67, 0, 3, 125, 101, 90, 100, 38, 99, 121, 102, 17, 24, 125, 119, 29, 113, 47}), String.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDeclaredField((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "b4a67f", new byte[]{126, 4, 23, 68, 13, 99, 115, 16, 34}), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L9
        r2.setAccessible(true);     // Catch: Throwable -> L9
        String r3 = r2.get(r0).toString();     // Catch: Throwable -> L9
        String r1 = r0.getComponentName().getClassName();     // Catch: Throwable -> L9
        if (r1.contains(r3) == true) goto L13;
        com.bytedance.mobsec.matrix.a.a(16777222, 0, 0, r1 + ((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "b5db48", new byte[]{40}), String.class, "com.obric.aiagent.plugin")) + r3, null);     // Catch: Throwable -> L9
        return;
    L13:
        return;
    }

    static /* synthetic */ void a(Handler r0) {
        h = r0;
    }

    public static Application b() {
        return (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "126245", new byte[]{33, 62, 65, 84, 4, 43, 54, 93, 102, 114, 48, 126, 100, 69, 31, 43, 36, 26, 115, 123, 20, 56, 87, 67, 10, 38}), String.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getMethod((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "023e02", new byte[]{34, 37, 82, 3, 10, 43, 39, 50, 114, 37, 45, 57, 67, 16, 27, 44, 60, 29}), String.class, "com.obric.aiagent.plugin"), new Class[0]).invoke(null, null), Application.class, "com.obric.aiagent.plugin");
    L9:
        return null;
    }

    public static String b(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(f39484c) == false) goto L7;
        f39484c = r3.getPackageManager().getPackageInfo(r3.getPackageName(), 0).versionName;     // Catch: Throwable -> L8
    L7:
        return f39484c;
    }

    public static String c(Context r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(f39484c) == false) goto L7;
        f39484c = r12.getPackageManager().getApplicationInfo(r12.getPackageName(), 128).metaData.getString((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "2bfdd0", new byte[]{16, 83, 42, 38, 126, 21, 2, 106, 24, 26, 28, 78, 52, 61, 126}), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8
    L7:
        return f39484c;
    }

    public static void c() {
        new Thread(new a()).start();
    }

    public static String d(Context r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r15, Context.class, "com.obric.aiagent.plugin");
    L10:
        f39485d = "";
    L12:
        return f39485d;
    L4:
        if (f39485d != null) goto L7;
        f39485d = String.valueOf(r16.getPackageManager().getApplicationInfo(r16.getPackageName(), 128).metaData.get((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "609089", new byte[]{18, 2, 110, 101, 51, 11, 10, 39, 77, 82, 20, 27, 101, 106, 56, 13, 26, 53, 77}), String.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L10
    L7:
        if (f39485d != null) goto L12;
        f39485d = "";     // Catch: Throwable -> L10
        goto L12
    }

    static /* synthetic */ AtomicBoolean d() {
        return g;
    }

    static /* synthetic */ HandlerThread e() {
        return f;
    }

    static /* synthetic */ Handler f() {
        return h;
    }

    static void a(int r13) {
        HashMap<Integer, com.bytedance.mobsec.metasec.ml.d.a> r0 = f39486e;
        if (r0 != null) goto L5;
    L15:
        String r2 = null;
    L16:
        String r7 = r2;
        if (TextUtils.isEmpty(r7) == true) goto L25;
        com.bytedance.mobsec.matrix.a.a(16777223, r13, System.currentTimeMillis(), r7, null);
        return;
    L25:
        return;
    L5:
        if (r0.size() <= 0) goto L15;
        Iterator<Map.Entry<Integer, com.bytedance.mobsec.metasec.ml.d.a>> r1 = f39486e.entrySet().iterator();
        r2 = "";
        int r3 = 0;
    L8:
        if (r1.hasNext() == false) goto L16;
        int r4 = ((com.bytedance.mobsec.metasec.ml.d.a) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), com.bytedance.mobsec.metasec.ml.d.a.class, "com.obric.aiagent.plugin")).a();
        if (r4 == 0) goto L8;
        if (r3 <= 0) goto L14;
        r2 = r2 + ((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "bf4801", new byte[]{76}), String.class, "com.obric.aiagent.plugin"));
    L14:
        r2 = r2 + r4;
        r3 = r3 + 1;
        goto L8
    }
}
