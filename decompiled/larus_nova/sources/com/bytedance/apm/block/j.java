package com.bytedance.apm.block;

import android.os.Build;
import android.os.Looper;
import android.os.Message;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f190349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f190350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Object f190351c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Method f190352d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Method f190353e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Method f190354f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Thread f190355g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static a f190356h;

    public static class a {
        volatile boolean haveAdd;
        volatile boolean haveRemove;
        List<i> mAddObservers;
        final List<i> mObservers;
        List<i> mRemoveObservers;

        public void setup(Object r100) {
        }

        public a() {
            this.mObservers = new ArrayList();
            this.mRemoveObservers = new ArrayList();
            this.mAddObservers = new ArrayList();
            this.haveRemove = false;
            this.haveAdd = false;
        }

        public void addMessageObserver(i r100) {
            List<i> r101 = this.mObservers;
            monitor-enter(r101);
            if (r100 != null) goto L13;
        L8:
            monitor-exit(r101);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        L13:
            if (this.mAddObservers.contains(r100) == true) goto L8;
            this.mAddObservers.add(r100);     // Catch: Throwable -> L10
            this.haveAdd = true;     // Catch: Throwable -> L10
            goto L8
        }

        public void messageDispatchStarting(String r100) {
            if (this.haveAdd == false) goto L18;
            List<i> r101 = this.mObservers;
            monitor-enter(r101);
            Iterator<i> r102 = this.mAddObservers.iterator();     // Catch: Throwable -> L15
        L8:
            if (r102.hasNext() == false) goto L12;
            i r103 = r102.next();     // Catch: Throwable -> L15
            if (this.mObservers.contains(r103) == true) goto L8;
            this.mObservers.add(r103);     // Catch: Throwable -> L15
            goto L8
        L12:
            this.mAddObservers.clear();     // Catch: Throwable -> L15
            this.haveAdd = false;     // Catch: Throwable -> L15
            monitor-exit(r101);     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            throw th;
        L18:
            Iterator<i> r104 = this.mObservers.iterator();
        L20:
            if (r104.hasNext() == false) goto L24;
            i r105 = r104.next();
            if (r105 == null) goto L20;
            r105.b(r100);
            goto L20
        }

        public void removeMessageObserver(i r100) {
            List<i> r101 = this.mObservers;
            monitor-enter(r101);
            if (r100 != null) goto L13;
        L8:
            monitor-exit(r101);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        L13:
            if (this.mRemoveObservers.contains(r100) == true) goto L8;
            this.mRemoveObservers.add(r100);     // Catch: Throwable -> L10
            this.haveRemove = true;     // Catch: Throwable -> L10
            goto L8
        }

        public void messageDispatched(String r100, Message r101) {
            Iterator<i> r102 = this.mObservers.iterator();
        L4:
            if (r102.hasNext() == false) goto L9;
            i r103 = r102.next();
            if (r103 == null) goto L4;
            r103.a(r100, r101);
            goto L4
        L9:
            if (this.haveRemove == false) goto L22;
            List<i> r104 = this.mObservers;
            monitor-enter(r104);
            Iterator<i> r105 = this.mRemoveObservers.iterator();     // Catch: Throwable -> L19
        L14:
            if (r105.hasNext() == false) goto L16;
            i r106 = r105.next();     // Catch: Throwable -> L19
            this.mObservers.remove(r106);     // Catch: Throwable -> L19
            this.mAddObservers.remove(r106);     // Catch: Throwable -> L19
            goto L14
        L16:
            this.mRemoveObservers.clear();     // Catch: Throwable -> L19
            this.haveRemove = false;     // Catch: Throwable -> L19
            monitor-exit(r104);     // Catch: Throwable -> L19
            return;
        L19:
            th = move-exception;
            throw th;
        }
    }

    public static List<i> b() {
        a r100 = f190356h;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.mObservers;
    }

    public static synchronized boolean c() {
        monitor-enter(j.class);
    L38:
        th = move-exception;
        throw th;
    L6:
        if (f190349a == false) goto L11;
        monitor-exit(j.class);
        return true;
    L11:
        if (Build.VERSION.SDK_INT >= 29) goto L41;
    L35:
        f190356h = new a();     // Catch: Throwable -> L38
        f190351c = null;     // Catch: Throwable -> L38
        f190350b = true;     // Catch: Throwable -> L38
        f190349a = true;     // Catch: Throwable -> L38
        boolean r100 = f190349a;     // Catch: Throwable -> L38
        monitor-exit(j.class);
        return r100;
    L41:
        Field r101 = (Field) Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class}).invoke(Looper.class, new Object[]{"sObserver"});     // Catch: Exception -> L16 Throwable -> L34
        r101.setAccessible(true);     // Catch: Exception -> L16 Throwable -> L34
        Object r102 = r101.get(null);     // Catch: Exception -> L16 Throwable -> L34
    L18:
        f190351c = r102;     // Catch: Throwable -> L34
        if (r102 == null) goto L22;
        f190352d = d(r102.getClass(), "messageDispatchStarting", new Class[0]);     // Catch: Throwable -> L34
        f190353e = d(f190351c.getClass(), "messageDispatched", new Class[]{Object.class, Message.class});     // Catch: Throwable -> L34
        f190354f = d(f190351c.getClass(), "dispatchingThrewException", new Class[]{Object.class, Message.class, Exception.class});     // Catch: Throwable -> L34
    L22:
        if (f190352d != null) goto L24;
    L27:
        f190351c = null;     // Catch: Throwable -> L34
    L28:
        f190356h = (a) a("com.bytedance.observer.ObserverWrapper").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Throwable -> L34
        if (f190351c == null) goto L31;
        System.out.println("LooperObserverMonitor.init: " + f190351c);     // Catch: Throwable -> L34
        f190356h.setup(f190351c);     // Catch: Throwable -> L34
    L31:
        d(Looper.class, "setObserver", new Class[]{a("android.os.Looper$Observer")}).invoke(null, new Object[]{f190356h});     // Catch: Throwable -> L34
        f190349a = true;     // Catch: Throwable -> L34
        boolean r103 = f190349a;     // Catch: Throwable -> L34
        monitor-exit(j.class);
        return r103;
    L24:
        if (f190353e == null) goto L27;
        if (f190354f != null) goto L28;
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L34
        r102 = null;
    L34:
        f190351c = null;     // Catch: Throwable -> L38
        goto L35
    }

    static {
        f190355g = ThreadMethodProxy.getLooperThread(Looper.getMainLooper());
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static Method d(Class r100, String r101, Class<?>... r102) {
        Method r103 = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class}).invoke(r100, new Object[]{r101, r102});     // Catch: Exception -> L4
        r103.setAccessible(true);     // Catch: Exception -> L4
        return r103;
    L4:
        return null;
    }
}
