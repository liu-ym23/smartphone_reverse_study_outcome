package com.bytedance.reparo.core;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.widget.Toast;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class WandTrick {
    private static final String TAG = "WandTrick";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile WandTrick f9136a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static File f9137c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Context f9138b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f9139d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f9140e;
    private int f;

    class DummyInnerClass {
        final /* synthetic */ WandTrick this$0;

        private void first() {
        }

        private void second() {
        }

        DummyInnerClass(WandTrick r1) {
            this.this$0 = r1;
        }
    }

    public static abstract class a {
        public static a o;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f9141a;

        public abstract int a();

        public abstract boolean a(int r1);

        public a() {
        }

        public boolean b() {
            int r0 = a();
            this.f9141a = r0;
            return a(r0);
        }

        public int c() {
            return this.f9141a;
        }

        static {
            o = new AnonymousClass1();
        }
    }

    static {
    }

    static native Object allocObject(Class r0);

    static native Object callMethodDirect(Class r0, Object r1, Object r2, Object[] r3, Object[] r4, String r5, Class r6);

    static native Object createInstance(Class r0, Constructor r1, Object[] r2, Object[] r3);

    private native int deoptimizeNative(Object[] r1, int[] r2, boolean r3, String[] r4, String[] r5, long[] r6);

    private native int initNative(boolean r1, String r2, boolean r3, String[] r4);

    public static native void removeClassesFromClassLinker(String[] r0, Object r1);

    public abstract a a(Application r1, boolean r2, Map<Class, f> r3, List<String> r4, List<String> r5, List<Object> r6, com.bytedance.reparo.core.h.b r7, com.bytedance.reparo.core.h.d r8);

    native void changeClinitToPreverified(Class r1);

    native void changeConstructorToPublic(Constructor r1);

    native void changeFieldToPublic(Field r1);

    native void changeMethodProtectedToPublic(Method r1);

    native void changeMethodToPreverified(Object r1);

    native void clearPointerArrayMemory(long r1, int r3);

    public native Constructor getClinitMethod(Class r1);

    public native boolean isSoLoaded(String r1);

    native int redefineClassesNative(Class[] r1, byte[][] r2, Object[] r3, int[] r4, Object[] r5, String[] r6, String[] r7, long[] r8);

    native int replaceMethodNative(Object[] r1, Object[] r2, int[] r3, String[] r4, String[] r5, long[] r6);

    public static boolean a(String r5) {
        String[] r0 = BuildConfig.DEPENDENT_SO;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        if (r0[r3].equals(r5) == true) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static WandTrick a() {
        if (f9136a != null) goto L18;
        monitor-enter(WandTrick.class);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (f9136a == null) goto L9;
    L12:
        monitor-exit(WandTrick.class);     // Catch: Throwable -> L14
        goto L18
    L9:
        if (Build.VERSION.SDK_INT < 26) goto L11;
        f9136a = new b();     // Catch: Throwable -> L14
        goto L12
    L11:
        f9136a = new d();     // Catch: Throwable -> L14
    L18:
        return f9136a;
    }

    public static WandTrick b() {
        a();
        if (f9136a.f != Integer.MIN_VALUE) goto L15;
        WandTrick r0 = f9136a;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f9136a.f != Integer.MIN_VALUE) goto L9;
        f9136a.a(m.a().i());     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L15:
        if (f9136a.f == 0) goto L17;
        int r1 = f9136a.f;
        throw new com.bytedance.reparo.core.b.d("Failed to initialize wand trick, load skipped, initialize ret = " + r1, r1);
    L17:
        return f9136a;
    }

    static boolean c() {
        int r1 = 0;
        if (f9137c == null) goto L18;
        String[] r0 = BuildConfig.DEPENDENT_SO;
        int r2 = r0.length;
        boolean r3 = false;
    L5:
        if (r1 >= r2) goto L13;
        String r4 = r0[r1];
        File r5 = new File(f9137c, r4);
        if (r5.exists() == false) goto L11;
        System.load(r5.getAbsolutePath());
        if (r4.equals("libreparo.so") == false) goto L11;
        r3 = true;
    L11:
        r1 = r1 + 1;
        goto L5
    L13:
        return r3;
    L18:
        return false;
    }

    WandTrick() {
        this.f = Integer.MIN_VALUE;
        if (c() == true) goto L17;
        System.loadLibrary("reparo");
    L17:
        System.loadLibrary("jato");     // Catch: Throwable -> L7
    L13:
        this.f9139d = true;
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
        System.loadLibrary("jatolite");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.printStackTrace();
        goto L13
    }

    int a(Application r2, boolean r3, Map<Class, f> r4, List<String> r5, List<String> r6, List<Object> r7, com.bytedance.reparo.core.h.b r8) {
        Application r9 = (Application) ZeusTransformUtils.wrapperContextForParams(r2, Application.class, "com.obric.aiagent.plugin");
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L24;
        if (r10.isEmpty() == true) goto L24;
        r8.a("prepare_for_deopt");
        ArrayList<Class> r14 = l.a(this.f9138b, r11, r12);
        if (r11 != null) goto L9;
    L15:
        ArrayList r15 = new ArrayList();
        Iterator<Class> r16 = r14.iterator();
    L17:
        if (r16.hasNext() == false) goto L19;
        Class r17 = (Class) ZeusTransformUtils.preCheckCast(r16.next(), Class.class, "com.obric.aiagent.plugin");
        r15.addAll(a(r17));
        r15.addAll(b(r17));
        goto L17
    L19:
        if (r13 == null) goto L21;
        r15.addAll(r13);
    L21:
        r8.b("prepare_for_deopt");
        return a(r15.toArray(), r8);
    L9:
        if (r11.isEmpty() == true) goto L15;
        if (r14.isEmpty() == false) goto L15;
        throw new Exception("Invalid additional class.");
    L24:
        throw new Exception("Invalid patch info.");
    }

    int a(Object[] r10, com.bytedance.reparo.core.h.b r11) {
        if (Build.VERSION.SDK_INT >= 21) goto L6;
        return -1;
    L6:
        String[] r0 = new String[10];
        int[] r3 = a(r10);
        r11.a("deoptimizeNative");
        int r9 = deoptimizeNative(r10, r3, true, r0, r11.a(), r11.b());
        r11.b("deoptimizeNative");
        j.a("deopt", r0);
        return r9;
    }

    public int[] a(Object[] r7) {
        int r6 = r7.length;
        int[] r0 = new int[r6];
        int r2 = 0;
    L3:
        if (r2 >= r6) goto L12;
        if (ZeusTransformUtils.instanceOf(r7[r2], Method.class) == false) goto L8;
        r0[r2] = ((Method) ZeusTransformUtils.preCheckCast(r7[r2], Method.class, "com.obric.aiagent.plugin")).getModifiers();
    L11:
        r2 = r2 + 1;
        goto L3
    L8:
        if (ZeusTransformUtils.instanceOf(r7[r2], Constructor.class) == false) goto L10;
        r0[r2] = ((Constructor) ZeusTransformUtils.preCheckCast(r7[r2], Constructor.class, "com.obric.aiagent.plugin")).getModifiers();
        goto L11
    L10:
        r0[r2] = 0;
        goto L11
    L12:
        return r0;
    }

    private void a(g r2) {
        a(r2, true);
    }

    private synchronized void a(g r8, boolean r9) {
        monitor-enter(this);
        com.bytedance.reparo.core.i.k r1 = null;
    L42:
        th = move-exception;
        throw th;
    L36:
        th = th;
    L38:
        if (this.f == (-13)) goto L41;
        if (r1 == null) goto L41;
        r1.e();     // Catch: Throwable -> L42
    L41:
        throw th;     // Catch: Throwable -> L42
    L6:
        if (this.f == Integer.MIN_VALUE) goto L9;
        monitor-exit(this);
        return;
    L9:
        com.bytedance.reparo.core.i.k r2 = new com.bytedance.reparo.core.i.k(r8.b(), "_init.info", 2, com.bytedance.reparo.core.i.i.a(this.f9138b));     // Catch: Throwable -> L36
    L34:
        th = th;
        r1 = r2;
        goto L38
    L11:
        if (com.bytedance.reparo.core.i.k.f9292b == false) goto L13;
        r2.d();     // Catch: Throwable -> L34
    L13:
        this.f9140e = r9;     // Catch: Throwable -> L34
        Context r10 = ZeusTransformUtils.wrapperContext((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.a(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
        this.f9138b = r10;     // Catch: Throwable -> L34
        String r11 = r8.a(r10).getAbsolutePath();     // Catch: Throwable -> L34
        if ((this.f9138b.getApplicationInfo().flags & 2) == 0) goto L16;
        boolean r3 = true;
    L17:
        if (r3 == false) goto L25;
        if (r8.f() == true) goto L25;
        com.bytedance.reparo.core.f.a.d("Hotfix disabled under debuggable mode.");     // Catch: Throwable -> L34
        Toast.makeText(this.f9138b, "Hotfix disabled under debuggable mode.", 0).show();     // Catch: Throwable -> L34
        this.f = -1;     // Catch: Throwable -> L34
        r2.e();     // Catch: Throwable -> L42
        monitor-exit(this);
        return;
    L25:
        if (this.f9139d == false) goto L27;
        String[] r4 = new String[10];     // Catch: Throwable -> L34
        this.f = initNative(this.f9140e, r11, r8.g(), r4);     // Catch: Throwable -> L34
        j.a(r4);     // Catch: Throwable -> L34
    L28:
        j.b(TAG, "initialize wand trick complete, ret = " + this.f);     // Catch: Throwable -> L34
        if (this.f == (-13)) goto L32;
        r2.e();     // Catch: Throwable -> L42
    L32:
        monitor-exit(this);
        return;
    L27:
        this.f = -2;     // Catch: Throwable -> L34
        goto L28
    L16:
        r3 = false;
        goto L17
    }

    ArrayList<Method> a(Class r6) {
        ArrayList<Method> r5 = new ArrayList();
        Method[] r0 = (Method[]) ZeusTransformUtils.preCheckCast(com.bytedance.reparo.core.i.j.a(r6).a(), Method[].class, "com.obric.aiagent.plugin");
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        Method r3 = r0[r2];
        if (r3.getDeclaringClass() != r6) goto L7;
        r5.add(r3);
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        return r5;
    }

    ArrayList<Constructor> b(Class r6) {
        ArrayList<Constructor> r5 = new ArrayList();
        Constructor<?>[] r0 = r6.getDeclaredConstructors();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        Constructor<?> r3 = r0[r2];
        if (r3.getDeclaringClass() != r6) goto L7;
        r5.add(r3);
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        return r5;
    }
}
