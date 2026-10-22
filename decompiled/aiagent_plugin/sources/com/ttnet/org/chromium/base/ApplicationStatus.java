package com.ttnet.org.chromium.base;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.Window;
import com.ttnet.org.chromium.build.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class ApplicationStatus {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f37590a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<Activity, a> f37591b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f37592c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Activity f37593d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static c f37594e;
    private static m<b> f;
    private static m<c> g;
    private static m<f> h;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.base.ApplicationStatus$1, reason: invalid class name */
    class AnonymousClass1 implements f {
        @Override // com.ttnet.org.chromium.base.ApplicationStatus.f
        public void a(Activity r2, boolean r3) {
            Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
            if (r3 == true) goto L5;
            return;
        L5:
            if (r1 == ((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ApplicationStatus.e(), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin"))) goto L16;
            int r4 = ApplicationStatus.a(r1);
            if (r4 != 6) goto L10;
            return;
        L10:
            if (r4 == 5) goto L15;
            Activity r5 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ApplicationStatus.b(r1), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin");
            return;
        L15:
            return;
        }
    }

    /* JADX INFO: renamed from: com.ttnet.org.chromium.base.ApplicationStatus$2, reason: invalid class name */
    class AnonymousClass2 implements Application.ActivityLifecycleCallbacks {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        static {
        }

        AnonymousClass2() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity r1, Bundle r2) {
            Activity r0 = (Activity) ZeusTransformUtils.wrapperContextForParams(r1, Activity.class, "com.obric.aiagent.plugin");
            ApplicationStatus.a(r0, 1);
            Window.Callback r3 = ZeusTransformUtils.getWindow(r0, "com.obric.aiagent.plugin").getCallback();
            ZeusTransformUtils.getWindow(r0, "com.obric.aiagent.plugin").setCallback(ApplicationStatus.a(r0, r3));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity r3) {
            Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
            ApplicationStatus.a(r4, 6);
            checkCallback(r4);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity r3) {
            Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
            ApplicationStatus.a(r4, 4);
            checkCallback(r4);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity r3) {
            Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
            ApplicationStatus.a(r4, 3);
            checkCallback(r4);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity r2, Bundle r3) {
            checkCallback((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin"));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity r3) {
            Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
            ApplicationStatus.a(r4, 2);
            checkCallback(r4);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity r3) {
            Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
            ApplicationStatus.a(r4, 5);
            checkCallback(r4);
        }

        private void checkCallback(Activity r2) {
            Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
            boolean r3 = BuildConfig.ENABLE_ASSERTS;
        }
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f37596a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private m<b> f37597b;

        private a() {
            this.f37596a = 6;
            this.f37597b = new m();
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }

        public int a() {
            return this.f37596a;
        }

        public void a(int r1) {
            this.f37596a = r1;
        }

        public m<b> b() {
            return this.f37597b;
        }
    }

    public interface b {
        void a(Activity r1, int r2);
    }

    public interface c {
        void onApplicationStateChange(int r1);
    }

    interface d {
        void a(int r1);
    }

    static class e implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Window.Callback f37598a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Activity f37599b;

        public e(Activity r3, Window.Callback r4) {
            Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
            this.f37598a = (Window.Callback) ZeusTransformUtils.wrapperContextForParams(r4, Window.Callback.class, "com.obric.aiagent.plugin");
            this.f37599b = ZeusTransformUtils.wrapperContext2Activity(r5, "com.obric.aiagent.plugin");
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object r3, Method r4, Object[] r5) {
            if (r4.getName().equals("onWindowFocusChanged") == true) goto L5;
        L18:
            return r4.invoke(this.f37598a, r5);
        L12:
            e = move-exception;
            if (ZeusTransformUtils.instanceOf(e.getCause(), AbstractMethodError.class) == true) goto L16;
            throw e;
        L16:
            throw e.getCause();
        L5:
            if (r5.length != 1) goto L18;
            if (ZeusTransformUtils.instanceOf(r5[0], Boolean.class) == false) goto L18;
            a(((Boolean) ZeusTransformUtils.preCheckCast(r5[0], Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
            return null;
        }

        public void a(boolean r5) {
            this.f37598a.onWindowFocusChanged(r5);
            if (ApplicationStatus.d() == null) goto L8;
            Iterator r0 = ApplicationStatus.d().iterator();
        L6:
            if (r0.hasNext() == false) goto L10;
            ((f) ZeusTransformUtils.preCheckCast(r0.next(), f.class, "com.obric.aiagent.plugin")).a(this.f37599b, r5);
            goto L6
        L10:
            return;
        }
    }

    public interface f {
        void a(Activity r1, boolean r2);
    }

    static /* synthetic */ void a(Activity r2, int r3) {
        b((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin"), r3);
    }

    static /* synthetic */ Activity b(Activity r2) {
        Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
        f37593d = r3;
        return r3;
    }

    static /* synthetic */ c c(c r2) {
        c r3 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.aiagent.plugin");
        f37594e = r3;
        return r3;
    }

    static /* synthetic */ m d() {
        return h;
    }

    static /* synthetic */ Activity e() {
        return f37593d;
    }

    static /* synthetic */ c f() {
        return f37594e;
    }

    static {
        f37591b = Collections.synchronizedMap(new HashMap());
        f37592c = 0;
    }

    private ApplicationStatus() {
    }

    public static boolean a() {
        Map<Activity, a> r0 = f37591b;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f37592c == 0) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    static Window.Callback a(Activity r5, Window.Callback r6) {
        Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r5, Activity.class, "com.obric.aiagent.plugin");
        Window.Callback r8 = (Window.Callback) ZeusTransformUtils.wrapperContextForParams(r6, Window.Callback.class, "com.obric.aiagent.plugin");
        return (Window.Callback) ZeusTransformUtils.preCheckCast(Proxy.newProxyInstance(Window.Callback.class.getClassLoader(), new Class[]{Window.Callback.class}, new e(r7, r8)), Window.Callback.class, "com.obric.aiagent.plugin");
    }

    static boolean a(Window.Callback r11) {
        Window.Callback r12 = (Window.Callback) ZeusTransformUtils.wrapperContextForParams(r11, Window.Callback.class, "com.obric.aiagent.plugin");
        if (r12 != null) goto L6;
        return false;
    L6:
        if (r12.getClass().getName().equals("androidx.appcompat.app.ToolbarActionBar$ToolbarCallbackWrapper") == false) goto L9;
        return true;
    L9:
        if (Proxy.isProxyClass(r12.getClass()) == true) goto L11;
        Class<?> r2 = r12.getClass();
    L14:
        if (r2 == Object.class) goto L30;
        Field[] r4 = r2.getDeclaredFields();
        int r5 = r4.length;
        int r6 = 0;
    L16:
        if (r6 >= r5) goto L29;
        Field r7 = r4[r6];
        if (r7.getType().isAssignableFrom(Window.Callback.class) == false) goto L28;
        boolean r8 = r7.isAccessible();
        r7.setAccessible(true);
        Window.Callback r9 = (Window.Callback) ZeusTransformUtils.preCheckCast(r7.get(r12), Window.Callback.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24 IllegalAccessException -> L27
        r7.setAccessible(r8);
        if (a(r9) == false) goto L28;
        return true;
    L27:
        r7.setAccessible(r8);
    L24:
        th = move-exception;
        r7.setAccessible(r8);
        throw th;
    L28:
        r6 = r6 + 1;
        goto L16
    L29:
        r2 = r2.getSuperclass();
        goto L14
    L30:
        return false;
    L11:
        return ZeusTransformUtils.instanceOf(Proxy.getInvocationHandler(r12), e.class);
    }

    private static void b(Activity r6, int r7) {
        Activity r8 = (Activity) ZeusTransformUtils.wrapperContextForParams(r6, Activity.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L48;
        if (f37593d != null) goto L7;
    L12:
        f37593d = r8;
    L13:
        int r0 = getStateForApplication();
        Map<Activity, a> r1 = f37591b;
        monitor-enter(r1);
        AnonymousClass1 r3 = null;
        if (r1.containsKey(r8) == true) goto L18;
        r1.put(r8, new a(r3));     // Catch: Throwable -> L44
    L18:
        a r2 = (a) ZeusTransformUtils.preCheckCast(r1.get(r8), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L44
        r2.a(r7);     // Catch: Throwable -> L44
        if (r7 != 6) goto L23;
        r1.remove(r8);     // Catch: Throwable -> L44
        if (r8 != f37593d) goto L23;
        f37593d = null;     // Catch: Throwable -> L44
    L23:
        f37592c = g();     // Catch: Throwable -> L44
        monitor-exit(r1);     // Catch: Throwable -> L44
        Iterator<b> r4 = r2.b().iterator();
    L27:
        if (r4.hasNext() == false) goto L29;
        ((b) ZeusTransformUtils.preCheckCast(r4.next(), b.class, "com.obric.aiagent.plugin")).a(r8, r7);
        goto L27
    L29:
        m<b> r5 = f;
        if (r5 == null) goto L35;
        Iterator<b> r9 = r5.iterator();
    L33:
        if (r9.hasNext() == false) goto L35;
        ((b) ZeusTransformUtils.preCheckCast(r9.next(), b.class, "com.obric.aiagent.plugin")).a(r8, r7);
    L35:
        int r10 = getStateForApplication();
        if (r10 == r0) goto L43;
        m<c> r11 = g;
        if (r11 == null) goto L54;
        Iterator<c> r12 = r11.iterator();
    L41:
        if (r12.hasNext() == false) goto L55;
        ((c) ZeusTransformUtils.preCheckCast(r12.next(), c.class, "com.obric.aiagent.plugin")).onApplicationStateChange(r10);
        goto L41
    L55:
        return;
    L54:
        return;
    L43:
        return;
    L44:
        th = move-exception;
        throw th;
    L7:
        if (r7 == 1) goto L12;
        if (r7 == 3) goto L12;
        if (r7 != 2) goto L13;
    L48:
        throw new IllegalArgumentException("null activity is not supported");
    }

    public static Activity b() {
        return f37593d;
    }

    public static List<Activity> c() {
        if (f37590a == false) goto L5;
    L9:
        Map<Activity, a> r0 = f37591b;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList(r0.keySet());     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return r1;
    L14:
        th = move-exception;
        throw th;
    L5:
        if (a() == true) goto L9;
        throw new AssertionError();
    }

    public static int a(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        if (f37590a == true) goto L10;
        if (a() == true) goto L10;
        throw new AssertionError();
    L10:
        if (r4 != null) goto L12;
        return 6;
    L12:
        a r5 = (a) ZeusTransformUtils.preCheckCast(f37591b.get(r4), a.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L15;
        return 6;
    L15:
        return r5.a();
    }

    public static int getStateForApplication() {
        Map<Activity, a> r0 = f37591b;
        monitor-enter(r0);
        int r1 = f37592c;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static boolean hasVisibleActivities() {
        if (f37590a == false) goto L5;
    L9:
        int r0 = getStateForApplication();
        if (r0 != 1) goto L12;
        return true;
    L12:
        if (r0 == 2) goto L17;
        return false;
    L17:
        return true;
    L5:
        if (a() == true) goto L9;
        throw new AssertionError();
    }

    public static void a(c r2) {
        c r3 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.aiagent.plugin");
        if (g != null) goto L5;
        g = new m();
    L5:
        g.a(r3);
    }

    public static void b(c r2) {
        c r3 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.aiagent.plugin");
        m<c> r0 = g;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.b(r3);
    }

    private static void registerThreadSafeNativeApplicationStateListener() {
        ThreadUtils.a(new AnonymousClass3());
    }

    private static int g() {
        Iterator<a> r0 = f37591b.values().iterator();
        boolean r1 = false;
        boolean r2 = false;
    L4:
        if (r0.hasNext() == false) goto L15;
        int r3 = ((a) ZeusTransformUtils.preCheckCast(r0.next(), a.class, "com.obric.aiagent.plugin")).a();
        if (r3 == 4) goto L11;
        if (r3 == 5) goto L11;
        if (r3 == 6) goto L11;
        return 1;
    L11:
        if (r3 == 4) goto L12;
        if (r3 != 5) goto L4;
        r2 = true;
        goto L4
    L12:
        r1 = true;
        goto L4
    L15:
        if (r1 == false) goto L18;
        return 2;
    L18:
        if (r2 == false) goto L21;
        return 3;
    L21:
        return 4;
    }
}
