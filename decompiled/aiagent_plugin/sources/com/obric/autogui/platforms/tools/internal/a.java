package com.obric.autogui.platforms.tools.internal;

import android.app.ActivityManager;
import android.app.ActivityTaskManager;
import android.app.IScreenShotTickCallback;
import android.app.TaskInfo;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ComponentInfo;
import android.graphics.Rect;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.obric.aiagent.product.ObricProductSdk;
import com.obric.aiagent.product.platform.api.app.ObricAutoVirtualDisplayRecordSetListener;
import com.obric.aiagent.product.platform.api.app.ObricBackNavigationListener;
import com.obric.aiagent.product.platform.api.app.ObricTaskStackListener;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.annotation.CallingPlatform;
import com.obric.autogui.common.api.platform.annotation.SignaturePermission;
import com.obric.autogui.common.api.platform.display.DisplayAccessor;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotConfig;
import com.obric.autogui.common.api.platform.input.CoordinateScrollResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.i;
import d.a.p;
import d.h.b.o;
import d.j;
import d.x;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.n;

/* JADX INFO: compiled from: AOPlatformApis.kt */
/* JADX INFO: loaded from: classes3.dex */
@CallingPlatform
public final class a {
    private static final String TAG = "AOPlatformApis";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f30314a = null;

    /* JADX INFO: renamed from: com.obric.autogui.platforms.tools.internal.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AOPlatformApis.kt */
    public static final class C0812a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0812a f30315a = null;

        static {
            f30315a = new C0812a();
        }

        private C0812a() {
        }

        public final Boolean a() {
            return ObricProductSdk.INSTANCE.platformService().activityManager().isAutoActionTopActivityInSystemAnimation();
        }

        public final boolean b() {
            return ObricProductSdk.INSTANCE.platformService().activityManager().supportsAutoVirtualDisplayRecordSet();
        }

        public final long a(int r1, int r2, ObricAutoVirtualDisplayRecordSetListener r3) {
            o.e(r3, "listener");
            return ObricProductSdk.INSTANCE.platformService().activityManager().beginAutoVirtualDisplayRecordSet(r1, r2, r3);
        }

        public final boolean a(long r1, String[] r3) {
            o.e(r3, "packageNames");
            return ObricProductSdk.INSTANCE.platformService().activityManager().addAutoVirtualDisplayRecordPackages(r1, r3);
        }

        public final void a(long r1) {
            ObricProductSdk.INSTANCE.platformService().activityManager().endAutoVirtualDisplayRecordSet(r1);
        }

        public final TaskInfo a(int r2) {
            return (TaskInfo) ZeusTransformUtils.preCheckCast(ObricProductSdk.INSTANCE.platformService().activityManager().getCurrentTaskInfo(r2), TaskInfo.class, "com.obric.aiagent.plugin");
        }

        public final void a(String[] r1) {
            o.e(r1, "pkgNames");
            ObricProductSdk.INSTANCE.platformService().activityManager().addDisablePackage(r1);
        }

        public final boolean a(String r1, int r2) {
            o.e(r1, "packageName");
            return ObricProductSdk.INSTANCE.platformService().activityManager().isPackageVisibleOnDisplay(r1, r2);
        }

        public final boolean a(int r1, int r2, boolean r3) {
            return ObricProductSdk.INSTANCE.platformService().activityManager().moveTaskToDisplay(r1, r2, r3);
        }

        @SignaturePermission
        public final boolean a(Context r2, int r3) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            o.e(r1, "context");
            Object r4 = r1.getSystemService("activity");
            if (ZeusTransformUtils.instanceOf(r4, ActivityManager.class) == false) goto L5;
            ActivityManager r5 = (ActivityManager) ZeusTransformUtils.preCheckCast(r4, ActivityManager.class, "com.obric.aiagent.plugin");
        L7:
            if (r5 == null) goto L10;
            r5.moveTaskToFront(r3, 0);
            return true;
        L10:
            return false;
        L5:
            r5 = null;
            goto L7
        }

        public final void a(boolean r1) {
            ObricProductSdk.INSTANCE.platformService().activityManager().enableCallUser(r1);
        }

        public final void a(ObricBackNavigationListener r1) {
            o.e(r1, "listener");
            ObricProductSdk.INSTANCE.platformService().activityManager().registerBackNavigationInVirtualDisplayListenerEx(r1);
        }

        public final void b(ObricBackNavigationListener r1) {
            o.e(r1, "listener");
            ObricProductSdk.INSTANCE.platformService().activityManager().unregisterBackNavigationInVirtualDisplayListenerEx(r1);
        }

        public final void a(ObricTaskStackListener r1) {
            o.e(r1, "listener");
            ObricProductSdk.INSTANCE.platformService().activityManager().registerTaskStackListenerEx(r1);
        }

        public final void b(ObricTaskStackListener r1) {
            o.e(r1, "listener");
            ObricProductSdk.INSTANCE.platformService().activityManager().unregisterTaskStackListenerEx(r1);
        }

        public final void b(boolean r1) {
            ObricProductSdk.INSTANCE.platformService().activityManager().tryToMute(r1);
        }
    }

    /* JADX INFO: compiled from: AOPlatformApis.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f30316a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final d.f f30317b = null;

        public static /* synthetic */ ActivityTaskManager lambda$62Hm9VwTMZZiVgcL9vc6wFwZ3Lw() {
            return b();
        }

        private b() {
        }

        static {
            f30316a = new b();
            f30317b = d.g.a($$Lambda$a$b$62Hm9VwTMZZiVgcL9vc6wFwZ3Lw.INSTANCE);
        }

        private final ActivityTaskManager a() {
            Object r2 = f30317b.b();
            o.c(r2, "getValue(...)");
            return (ActivityTaskManager) ZeusTransformUtils.preCheckCast(r2, ActivityTaskManager.class, "com.obric.aiagent.plugin");
        }

        private static final ActivityTaskManager b() {
            return ActivityTaskManager.getInstance();
        }

        public final List<TaskInfo> a(int r1, boolean r2, boolean r3, int r4) {
            List<ActivityManager.RunningTaskInfo> r0 = a().getTasks(r1, r2, r3, r4);
            if (r0 == null) goto L5;
            return r0;
        L5:
            return p.b();
        }

        public final boolean a(int r1) {
            return a().removeTask(r1);
        }
    }

    /* JADX INFO: compiled from: AOPlatformApis.kt */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f30318a = null;

        static {
            f30318a = new c();
        }

        private c() {
        }

        public final void a(Context r2) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            o.e(r1, "context");
            com.obric.autogui.platforms.tools.internal.a.a.f30337a.a(r1);
        }

        public final void b(Context r2) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            o.e(r1, "context");
            com.obric.autogui.platforms.tools.internal.a.a.f30337a.b(r1);
        }

        public final void a(Context r2, ClipboardManager.OnPrimaryClipChangedListener r3) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            ClipboardManager.OnPrimaryClipChangedListener r4 = (ClipboardManager.OnPrimaryClipChangedListener) ZeusTransformUtils.wrapperContextForParams(r3, ClipboardManager.OnPrimaryClipChangedListener.class, "com.obric.aiagent.plugin");
            o.e(r1, "context");
            o.e(r4, "listener");
            com.obric.autogui.platforms.tools.internal.a.a.f30337a.a(r1, r4);
        }

        public final void b(Context r2, ClipboardManager.OnPrimaryClipChangedListener r3) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            ClipboardManager.OnPrimaryClipChangedListener r4 = (ClipboardManager.OnPrimaryClipChangedListener) ZeusTransformUtils.wrapperContextForParams(r3, ClipboardManager.OnPrimaryClipChangedListener.class, "com.obric.aiagent.plugin");
            o.e(r1, "context");
            o.e(r4, "listener");
            com.obric.autogui.platforms.tools.internal.a.a.f30337a.b(r1, r4);
        }

        public final ClipData c(Context r2) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            o.e(r1, "context");
            return com.obric.autogui.platforms.tools.internal.a.a.f30337a.c(r1);
        }
    }

    /* JADX INFO: compiled from: AOPlatformApis.kt */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f30319a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final d.f f30320b = null;

        /* JADX INFO: renamed from: com.obric.autogui.platforms.tools.internal.a$d$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AOPlatformApis.kt */
        static final class C0813a implements d.h.a.b<Throwable, x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AtomicBoolean f30321a;

            C0813a(AtomicBoolean r1) {
                this.f30321a = r1;
            }

            @Override // d.h.a.b
            public /* synthetic */ x invoke(Throwable r3) {
                a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
                return x.f38692a;
            }

            public final void a(Throwable r1) {
                this.f30321a.set(true);
            }
        }

        /* JADX INFO: compiled from: AOPlatformApis.kt */
        static final class b implements InvocationHandler {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ d.h.a.b<CoordinateScrollResult, x> f30322a;

            b(d.h.a.b<? super CoordinateScrollResult, x> r3) {
                this.f30322a = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
            }

            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object r4, Method r5, Object[] r6) {
                boolean r1 = true;
                Object r2 = null;
                if (o.a(r5.getName(), "onResult") == false) goto L20;
                if (r5.getParameterCount() != 1) goto L20;
                if (r6 == null) goto L8;
                Object r7 = i.c(r6);
            L10:
                if (ZeusTransformUtils.instanceOf(r7, Integer.class) == false) goto L12;
                Integer r8 = (Integer) ZeusTransformUtils.preCheckCast(r7, Integer.class, "com.obric.aiagent.plugin");
            L13:
                d.h.a.b<CoordinateScrollResult, x> r3 = this.f30322a;
                if (r8 == null) goto L17;
                CoordinateScrollResult r9 = CoordinateScrollResult.Companion.fromFrameworkCode(((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.aiagent.plugin")).intValue());
                if (r9 == null) goto L17;
            L18:
                r3.invoke(r9);
                return null;
            L17:
                r9 = CoordinateScrollResult.Companion.unknown();
                goto L18
            L12:
                r8 = null;
                goto L13
            L8:
                r7 = null;
            L20:
                if (o.a(r5.getName(), "equals") == false) goto L28;
                if (r6 == null) goto L23;
                r2 = i.c(r6);
            L23:
                if (r4 == r2) goto L35;
                r1 = false;
            L35:
                return Boolean.valueOf(r1);
            L28:
                if (o.a(r5.getName(), "hashCode") == false) goto L31;
                return Integer.valueOf(System.identityHashCode(r4));
            L31:
                if (o.a(r5.getName(), "toString") == false) goto L37;
                return "CoordinateScrollCallbackProxy";
            L37:
                return null;
            }
        }

        /* JADX INFO: compiled from: AOPlatformApis.kt */
        static final class c implements d.h.a.b<CoordinateScrollResult, x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AtomicBoolean f30323a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ n<CoordinateScrollResult> f30324b;

            c(AtomicBoolean r3, n<? super CoordinateScrollResult> r4) {
                n<CoordinateScrollResult> r5 = (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.aiagent.plugin");
                this.f30323a = r3;
                this.f30324b = r5;
            }

            @Override // d.h.a.b
            public /* synthetic */ x invoke(CoordinateScrollResult r3) {
                a((CoordinateScrollResult) ZeusTransformUtils.preCheckCast(r3, CoordinateScrollResult.class, "com.obric.aiagent.plugin"));
                return x.f38692a;
            }

            public final void a(CoordinateScrollResult r4) {
                o.e(r4, "result");
                if (this.f30323a.compareAndSet(false, true) == false) goto L6;
                d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f30324b, d.c.d.class, "com.obric.aiagent.plugin");
                d.n.a r0 = d.n.f38560a;
                r3.resumeWith(d.n.f(r4));
                return;
            }
        }

        public static /* synthetic */ Method lambda$fSkVwvun_ZUfXZUZijbDRZky95M() {
            return b();
        }

        private d() {
        }

        public static final /* synthetic */ Method a(d r0) {
            return r0.a();
        }

        static {
            f30319a = new d();
            f30320b = d.g.a(j.f38505a, $$Lambda$a$d$fSkVwvun_ZUfXZUZijbDRZky95M.INSTANCE);
        }

        private final Method a() {
            return (Method) ZeusTransformUtils.preCheckCast(f30320b.b(), Method.class, "com.obric.aiagent.plugin");
        }

        private static final Method b() {
            Method[] r4 = ZeusTransformUtils.forName("android.app.ObricActivityTaskManager", "com.obric.aiagent.plugin").getMethods();     // Catch: Exception -> L49 CancellationException -> L51 LinkageError -> L53 SecurityException -> L55 ReflectiveOperationException -> L57
            o.c(r4, "getMethods(...)");     // Catch: Exception -> L49 CancellationException -> L51 LinkageError -> L53 SecurityException -> L55 ReflectiveOperationException -> L57
            Object[] r5 = (Object[]) ZeusTransformUtils.preCheckCast(r4, Object[].class, "com.obric.aiagent.plugin");     // Catch: Exception -> L49 CancellationException -> L51 LinkageError -> L53 SecurityException -> L55 ReflectiveOperationException -> L57
            int r6 = r5.length;     // Catch: Exception -> L49 CancellationException -> L51 LinkageError -> L53 SecurityException -> L55 ReflectiveOperationException -> L57
            int r7 = 0;
        L4:
            if (r7 >= r6) goto L43;
            Object r8 = r5[r7];     // Catch: Exception -> L49 CancellationException -> L51 LinkageError -> L53 SecurityException -> L55 ReflectiveOperationException -> L57
            Method r9 = (Method) ZeusTransformUtils.preCheckCast(r8, Method.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L49 CancellationException -> L51 LinkageError -> L53 SecurityException -> L55 ReflectiveOperationException -> L57
            Class<?>[] r10 = r9.getParameterTypes();     // Catch: Exception -> L49 CancellationException -> L51 LinkageError -> L53 SecurityException -> L55 ReflectiveOperationException -> L57
            boolean r11 = true;
            if (o.a(r9.getName(), "scrollAtCoordinate") == true) goto L8;
        L39:
            r11 = false;
        L40:
            if (r11 == true) goto L44;
            r7 = r7 + 1;     // Catch: Exception -> L49 CancellationException -> L51 LinkageError -> L53 SecurityException -> L55 ReflectiveOperationException -> L57
        L44:
            Method r0 = (Method) ZeusTransformUtils.preCheckCast(r8, Method.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L49 CancellationException -> L51 LinkageError -> L53 SecurityException -> L55 ReflectiveOperationException -> L57
            if (r0 == null) goto L48;
            return r0;
        L48:
            throw new NoSuchMethodException("android.app.ObricActivityTaskManager.scrollAtCoordinate(int, float, float, int, int, Executor, callback)");     // Catch: Exception -> L49 CancellationException -> L51 LinkageError -> L53 SecurityException -> L55 ReflectiveOperationException -> L57
        L8:
            if (r10.length != 7) goto L39;
            if (o.a(r10[0], Integer.TYPE) == false) goto L39;
            if (o.a(r10[1], Float.TYPE) == false) goto L39;
            if (o.a(r10[2], Float.TYPE) == false) goto L39;
            if (o.a(r10[3], Integer.TYPE) == false) goto L39;
            if (o.a(r10[4], Integer.TYPE) == false) goto L39;
            if (Executor.class.isAssignableFrom(r10[5]) == false) goto L39;
            if (r10[6].isInterface() == false) goto L39;
            Method[] r12 = r10[6].getMethods();     // Catch: Exception -> L49 CancellationException -> L51 LinkageError -> L53 SecurityException -> L55 ReflectiveOperationException -> L57
            o.c(r12, "getMethods(...)");     // Catch: Exception -> L49 CancellationException -> L51 LinkageError -> L53 SecurityException -> L55 ReflectiveOperationException -> L57
            Object[] r13 = (Object[]) ZeusTransformUtils.preCheckCast(r12, Object[].class, "com.obric.aiagent.plugin");     // Catch: Exception -> L49 CancellationException -> L51 LinkageError -> L53 SecurityException -> L55 ReflectiveOperationException -> L57
            int r14 = r13.length;     // Catch: Exception -> L49 CancellationException -> L51 LinkageError -> L53 SecurityException -> L55 ReflectiveOperationException -> L57
            int r15 = 0;
        L24:
            if (r15 >= r14) goto L36;
            Method r16 = (Method) ZeusTransformUtils.preCheckCast(r13[r15], Method.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L49 CancellationException -> L51 LinkageError -> L53 SecurityException -> L55 ReflectiveOperationException -> L57
            if (o.a(r16.getName(), "onResult") == true) goto L28;
        L32:
            boolean r17 = false;
        L33:
            if (r17 == true) goto L34;
            r15 = r15 + 1;     // Catch: Exception -> L49 CancellationException -> L51 LinkageError -> L53 SecurityException -> L55 ReflectiveOperationException -> L57
            goto L24
        L34:
            boolean r18 = true;
        L37:
            if (r18 == false) goto L39;
        L28:
            if (r16.getParameterTypes().length != 1) goto L32;
            if (o.a(r16.getParameterTypes()[0], Integer.TYPE) == false) goto L32;
            r17 = true;
            goto L33
        L36:
            r18 = false;
            goto L37
        L43:
            r8 = null;
        L57:
            e = move-exception;
            Loog.INSTANCE.w(a.TAG, "Framework coordinate scroll is unsupported.", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            return null;
        L55:
            e = move-exception;
            Loog.INSTANCE.w(a.TAG, "Framework coordinate scroll method is inaccessible.", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            return null;
        L51:
            e = move-exception;
            throw e;
        L49:
            e = move-exception;
            Loog.INSTANCE.w(a.TAG, "Framework coordinate scroll method lookup failed.", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            return null;
        L53:
            e = move-exception;
            Loog.INSTANCE.w(a.TAG, "Framework coordinate scroll linkage is unavailable.", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            return null;
        }

        public final Object a(int r17, float r18, float r19, int r20, int r21, Executor r22, d.c.d<? super CoordinateScrollResult> r23) {
            Executor r0 = (Executor) ZeusTransformUtils.wrapperContextForParams(r22, Executor.class, "com.obric.aiagent.plugin");
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r23, d.c.d.class, "com.obric.aiagent.plugin");
            kotlinx.coroutines.o r5 = new kotlinx.coroutines.o(d.c.a.b.a(r4), 1);
            r5.e();
            n r6 = (n) ZeusTransformUtils.preCheckCast(r5, n.class, "com.obric.aiagent.plugin");
            Method r8 = a(f30319a);
            if (r8 != null) goto L5;
            d.c.d r1 = (d.c.d) ZeusTransformUtils.preCheckCast(r6, d.c.d.class, "com.obric.aiagent.plugin");
            d.n.a r2 = d.n.f38560a;
            r1.resumeWith(d.n.f(CoordinateScrollResult.Companion.unsupported()));
        L37:
            Object r3 = r5.h();
            if (r3 != d.c.a.b.a()) goto L40;
            d.c.b.a.h.c(r4);
        L40:
            return r3;
        L5:
            AtomicBoolean r9 = new AtomicBoolean(false);
            d.h.a.b r11 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new c(r9, r6), d.h.a.b.class, "com.obric.aiagent.plugin");
            r6.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new C0813a(r9), d.h.a.b.class, "com.obric.aiagent.plugin"));
            Class<?> r10 = r8.getParameterTypes()[6];
            CoordinateScrollResult r14 = null;
            r8.invoke(null, new Object[]{d.c.b.a.b.a(r17), d.c.b.a.b.a(r18), d.c.b.a.b.a(r19), d.c.b.a.b.a(r20), d.c.b.a.b.a(r21), r0, Proxy.newProxyInstance(r10.getClassLoader(), new Class[]{r10}, (InvocationHandler) ZeusTransformUtils.preCheckCast(new b(r11), InvocationHandler.class, "com.obric.aiagent.plugin"))});     // Catch: Exception -> L10 CancellationException -> L12 LinkageError -> L14 InvocationTargetException -> L16 IllegalArgumentException -> L25 IllegalAccessException -> L27 SecurityException -> L29
        L31:
            if (r14 == null) goto L37;
            r11.invoke(r14);
            goto L37
        L27:
            e = move-exception;
            Loog.INSTANCE.w(a.TAG, "Framework coordinate scroll became inaccessible.", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            r14 = CoordinateScrollResult.Companion.unsupported();
        L25:
            e = move-exception;
            Loog.INSTANCE.w(a.TAG, "Framework coordinate scroll arguments are invalid.", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            r14 = CoordinateScrollResult.Companion.unsupported();
        L14:
            e = move-exception;
            Loog.INSTANCE.e(a.TAG, "Framework coordinate scroll linkage failed.", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            r14 = CoordinateScrollResult.Companion.remoteError();
        L29:
            e = move-exception;
            Loog.INSTANCE.w(a.TAG, "Framework coordinate scroll permission denied.", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            r14 = CoordinateScrollResult.Companion.permissionDenied();
        L16:
            e = move-exception;
            Throwable r7 = e.getTargetException();
            if (ZeusTransformUtils.instanceOf(r7, CancellationException.class) == false) goto L21;
            r6.b(r7);
            goto L31
        L21:
            if (ZeusTransformUtils.instanceOf(r7, SecurityException.class) == false) goto L23;
            Loog.INSTANCE.w(a.TAG, "Framework coordinate scroll permission denied.", r7);
            CoordinateScrollResult r12 = CoordinateScrollResult.Companion.permissionDenied();
        L24:
            r14 = r12;
            goto L31
        L23:
            Loog.INSTANCE.e(a.TAG, "Framework coordinate scroll invocation failed.", r7);
            r12 = CoordinateScrollResult.Companion.remoteError();
        L12:
            e = move-exception;
            r6.b((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        L10:
            e = move-exception;
            Loog.INSTANCE.e(a.TAG, "Framework coordinate scroll failed unexpectedly.", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            r14 = CoordinateScrollResult.Companion.remoteError();
            goto L31
        L33:
            e = move-exception;
            Loog.INSTANCE.e(a.TAG, "Framework coordinate scroll callback creation failed.", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            r11.invoke(CoordinateScrollResult.Companion.unsupported());
        L35:
            e = move-exception;
            Loog.INSTANCE.e(a.TAG, "Framework coordinate scroll callback linkage failed.", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            r11.invoke(CoordinateScrollResult.Companion.remoteError());
            goto L37
        }
    }

    /* JADX INFO: compiled from: AOPlatformApis.kt */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f30325a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static Field f30326b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static com.obric.autogui.platforms.tools.internal.c f30327c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static Field f30328d;

        private e() {
        }

        public final ComponentName a(TaskInfo r3) {
            o.e(r3, "taskInfo");
            Field r0 = f30326b;
            if (r0 != null) goto L5;
            e r2 = (e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.aiagent.plugin");
            r0 = TaskInfo.class.getDeclaredField("realActivity");
            r0.setAccessible(true);
        L5:
            f30326b = r0;
            return (ComponentName) ZeusTransformUtils.preCheckCast(r0.get(r3), ComponentName.class, "com.obric.aiagent.plugin");
        }

        static {
            f30325a = new e();
            f30327c = new com.obric.autogui.platforms.tools.internal.c(TaskInfo.class, "getWindowingMode");
        }

        public final int b(TaskInfo r2) {
            o.e(r2, "taskInfo");
            Object r1 = f30327c.a(r2, new Object[0]);
            o.a(r1);
            return ((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.aiagent.plugin")).intValue();
        }

        public final ActivityInfo c(TaskInfo r3) {
            o.e(r3, "taskInfo");
            Field r0 = f30328d;
            if (r0 != null) goto L5;
            e r2 = (e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.aiagent.plugin");
            r0 = TaskInfo.class.getDeclaredField("topActivityInfo");
            r0.setAccessible(true);
        L5:
            f30328d = r0;
            return (ActivityInfo) ZeusTransformUtils.preCheckCast(r0.get(r3), ActivityInfo.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: AOPlatformApis.kt */
    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f30329a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final com.obric.autogui.platforms.tools.internal.c f30330b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static Method f30331c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static com.obric.autogui.platforms.tools.internal.c f30332d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static Method f30333e;
        private static final com.obric.autogui.platforms.tools.internal.c f = null;
        private static final com.obric.autogui.platforms.tools.internal.c g = null;
        private static final com.obric.autogui.platforms.tools.internal.c h = null;

        private f() {
        }

        static {
            f30329a = new f();
            f30330b = new com.obric.autogui.platforms.tools.internal.c(MotionEvent.class, "obtain");
            f30332d = new com.obric.autogui.platforms.tools.internal.c(TaskInfo.class, "getDisplayId");
            f = new com.obric.autogui.platforms.tools.internal.c(ComponentInfo.class, "getComponentName");
            g = new com.obric.autogui.platforms.tools.internal.c("android.app.CollaborationManager", "reportOAutoEvent");
            h = new com.obric.autogui.platforms.tools.internal.c("android.app.CollaborationManager", "registerScreenShotTick");
        }

        public final MotionEvent a(long r7, long r9, int r11, int r12, MotionEvent.PointerProperties[] r13, MotionEvent.PointerCoords[] r14, int r15, int r16, float r17, float r18, int r19, int r20, int r21, int r22, int r23) {
            o.e(r13, "pointerProperties");
            o.e(r14, "pointerCoords");
            return (MotionEvent) ZeusTransformUtils.preCheckCast(f30330b.a(new Object[]{Long.valueOf(r7), Long.valueOf(r9), Integer.valueOf(r11), Integer.valueOf(r12), r13, r14, Integer.valueOf(r15), Integer.valueOf(r16), Float.valueOf(r17), Float.valueOf(r18), Integer.valueOf(r19), Integer.valueOf(r20), Integer.valueOf(r21), Integer.valueOf(r22), Integer.valueOf(r23)}), MotionEvent.class, "com.obric.aiagent.plugin");
        }

        public final void a(InputEvent r5, int r6) {
            o.e(r5, "event");
            Method r0 = f30331c;
            if (r0 != null) goto L5;
            f r4 = (f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.aiagent.plugin");
            r0 = InputEvent.class.getDeclaredMethod("setDisplayId", new Class[]{Integer.TYPE});
            r0.setAccessible(true);
        L5:
            f30331c = r0;
            r0.invoke(r5, new Object[]{Integer.valueOf(r6)});
        }

        public final int a(TaskInfo r2) {
            o.e(r2, "taskInfo");
            Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(f30332d.a(r2, new Object[0]), Integer.class, "com.obric.aiagent.plugin");
            if (r1 != null) goto L7;
            return -1;
        L7:
            return r1.intValue();
        }

        public final void a(KeyEvent r4) {
            o.e(r4, "keyEvent");
            Method r0 = f30333e;
            if (r0 != null) goto L5;
            f r3 = (f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.aiagent.plugin");
            r0 = KeyEvent.class.getDeclaredMethod("recycle", new Class[0]);
            r0.setAccessible(true);
        L5:
            f30333e = r0;
            r0.invoke(r4, new Object[0]);
        }

        public final ComponentName a(ComponentInfo r2) {
            o.e(r2, "activityInfo");
            return (ComponentName) ZeusTransformUtils.preCheckCast(f.a(r2, new Object[0]), ComponentName.class, "com.obric.aiagent.plugin");
        }

        public final void a(int r3, int r4, int r5, String r6) {
            g.a(new Object[]{Integer.valueOf(r3), Integer.valueOf(r4), Integer.valueOf(r5), r6});
        }

        public final boolean a(int r8, String r9, int r10, String r11, IScreenShotTickCallback r12) {
            IScreenShotTickCallback r7 = (IScreenShotTickCallback) ZeusTransformUtils.wrapperContextForParams(r12, IScreenShotTickCallback.class, "com.obric.aiagent.plugin");
            o.e(r9, "pkg");
            o.e(r7, "cb");
            com.obric.autogui.platforms.tools.internal.c r13 = h;
            if (r13.b(new Object[]{Integer.valueOf(r8), r9, Integer.valueOf(r10), r11, r7}) == true) goto L5;
            return false;
        L5:
            r13.a(new Object[]{Integer.valueOf(r8), r9, Integer.valueOf(r10), r11, r7});
            return true;
        }
    }

    /* JADX INFO: compiled from: AOPlatformApis.kt */
    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f30334a = null;

        static {
            f30334a = new g();
        }

        private g() {
        }

        public final boolean a(CharSequence r2, boolean r3) {
            CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
            o.e(r1, "text");
            return ObricProductSdk.INSTANCE.platformService().inputmethodManager().injectText(r1, r3);
        }

        public final void a() {
            ObricProductSdk.INSTANCE.platformService().inputmethodManager().clearInputMethodState();
        }

        public final boolean a(com.obric.framework.inputmethod.api.a r4) {
            o.e(r4, "listener");
            d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L5
            g r3 = (g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
            Object r5 = d.n.f(Boolean.valueOf(ObricProductSdk.INSTANCE.platformService().inputmethodManager().registerObricInjectEventCallback(r4)));     // Catch: Throwable -> L5
        L7:
            Throwable r6 = d.n.c(r5);
            if (r6 == null) goto L12;
            Loog.INSTANCE.e(a.TAG, "registerObricInjectEventListener failed", r6);
            r5 = false;
        L12:
            return ((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        L5:
            th = move-exception;
            d.n.a r7 = d.n.f38560a;
            r5 = d.n.f(d.o.a(th));
            goto L7
        }

        public final boolean b(com.obric.framework.inputmethod.api.a r4) {
            o.e(r4, "listener");
            d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L5
            g r3 = (g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
            Object r5 = d.n.f(Boolean.valueOf(ObricProductSdk.INSTANCE.platformService().inputmethodManager().unregisterObricInjectEventCallback(r4)));     // Catch: Throwable -> L5
        L7:
            Throwable r6 = d.n.c(r5);
            if (r6 == null) goto L12;
            Loog.INSTANCE.e(a.TAG, "unregisterObricInjectEventListener failed", r6);
            r5 = false;
        L12:
            return ((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        L5:
            th = move-exception;
            d.n.a r7 = d.n.f38560a;
            r5 = d.n.f(d.o.a(th));
            goto L7
        }

        public final boolean a(com.obric.framework.inputmethod.api.b r4) {
            o.e(r4, "listener");
            d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L5
            g r3 = (g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
            Object r5 = d.n.f(Boolean.valueOf(ObricProductSdk.INSTANCE.platformService().inputmethodManager().registerInjectTextResponseCallback(r4)));     // Catch: Throwable -> L5
        L7:
            Throwable r6 = d.n.c(r5);
            if (r6 == null) goto L12;
            Loog.INSTANCE.e(a.TAG, "registerInjectTextResponseListener failed", r6);
            r5 = false;
        L12:
            return ((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        L5:
            th = move-exception;
            d.n.a r7 = d.n.f38560a;
            r5 = d.n.f(d.o.a(th));
            goto L7
        }

        public final boolean b(com.obric.framework.inputmethod.api.b r4) {
            o.e(r4, "listener");
            d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L5
            g r3 = (g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
            Object r5 = d.n.f(Boolean.valueOf(ObricProductSdk.INSTANCE.platformService().inputmethodManager().unregisterInjectTextResponseCallback(r4)));     // Catch: Throwable -> L5
        L7:
            Throwable r6 = d.n.c(r5);
            if (r6 == null) goto L12;
            Loog.INSTANCE.e(a.TAG, "unregisterInjectTextResponseListener failed", r6);
            r5 = false;
        L12:
            return ((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        L5:
            th = move-exception;
            d.n.a r7 = d.n.f38560a;
            r5 = d.n.f(d.o.a(th));
            goto L7
        }
    }

    /* JADX INFO: compiled from: AOPlatformApis.kt */
    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f30335a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final com.obric.autogui.platforms.tools.internal.d f30336b = null;

        private h() {
        }

        static {
            f30335a = new h();
            f30336b = new com.obric.autogui.platforms.tools.internal.d();
        }

        public final com.obric.autogui.platforms.tools.internal.b.a a(Context r2, List<String> r3, List<String> r4, float r5) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            o.e(r1, "context");
            return f30336b.a(r1, r6, r7, r5);
        }

        public final com.obric.autogui.platforms.tools.internal.b.a a(Context r8, DisplayAccessor r9, Rect r10, float r11, ScreenshotConfig.HeifConfig r12) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
            DisplayAccessor r3 = (DisplayAccessor) ZeusTransformUtils.wrapperContextForParams(r9, DisplayAccessor.class, "com.obric.aiagent.plugin");
            o.e(r2, "context");
            o.e(r3, "displayAccessor");
            o.e(r10, "area");
            if (r12 == null) goto L9;
            if (com.obric.autogui.common.a.d.f28974a.v() == false) goto L9;
            return f30336b.b(r2, r3, r10, r11, r12);
        L9:
            return f30336b.a(r2, r3, r10, r11, r12);
        }

        public final boolean a() {
            return ObricProductSdk.INSTANCE.platformService().windowManager().isAutoImeReady();
        }
    }

    static {
        f30314a = new a();
    }

    private a() {
    }
}
