package com.autonavi.base.amap.mapcore;

import com.amap.api.mapcore.util.z3;
import com.autonavi.base.amap.mapcore.annotations.ParameterIsClass;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes39.dex */
public abstract class NativeBase {
    private static final String CREATE_OVERLAY = "createOverlay";
    private static final int LOG_SIZE = 10;
    private static final int STACK_NUMBER = 3;
    private static final String UPDATE_OPTIONS = "updateOptions";
    protected volatile boolean destroy;
    private int logSizeCount;
    private boolean mCalledFuntion;
    ArrayList<Method> methodMap;
    ArrayList<NativeFunctionRunnable> runnableArrayList;
    protected boolean useRunnable;

    public static class Method {
        private boolean baseClass;
        private Class<?>[] clazz;
        private String methodName;
        private Object object;
        private Object[] param;

        public static /* synthetic */ Object access$000(Method r100) {
            return r100.object;
        }

        public static /* synthetic */ String access$100(Method r100) {
            return r100.methodName;
        }

        public static /* synthetic */ Class[] access$200(Method r100) {
            return r100.clazz;
        }

        public static /* synthetic */ Object[] access$300(Method r100) {
            return r100.param;
        }

        public Method(Object r100, String r101, boolean r102, Object... r103) {
            this.object = r100;
            this.methodName = r101;
            this.baseClass = r102;
            if (r103 != null) goto L31;
            return;
        L31:
            if (r103.length <= 0) goto L38;
            this.clazz = new Class[r103.length];     // Catch: Throwable -> L30
            if ("createOverlay".equals(r101) == false) goto L9;
        L10:
            r102 = true;
        L11:
            int r104 = 0;
            if (r102 == false) goto L20;
            int r105 = 0;
        L15:
            if (r105 >= r103.length) goto L24;
            if (r105 != 1) goto L18;
            this.clazz[r105] = r103[r105].getClass().getSuperclass();     // Catch: Throwable -> L30
        L19:
            r105 = r105 + 1;     // Catch: Throwable -> L30
            goto L15
        L18:
            this.clazz[r105] = r103[r105].getClass();     // Catch: Throwable -> L30
        L24:
            this.param = new Object[r103.length];     // Catch: Throwable -> L30
        L25:
            if (r104 >= r103.length) goto L40;
            this.param[r104] = r103[r104];     // Catch: Throwable -> L30
            r104 = r104 + 1;
            goto L25
        L40:
            return;
        L20:
            int r106 = 0;
        L22:
            if (r106 >= r103.length) goto L24;
            this.clazz[r106] = r103[r106].getClass();     // Catch: Throwable -> L30
            r106 = r106 + 1;     // Catch: Throwable -> L30
            goto L22
        L9:
            if ("updateOptions".equals(r101) == false) goto L11;
        L38:
            return;
        }
    }

    public synchronized void callAllFunction() {
        monitor-enter(this);
    L48:
        th = move-exception;
        throw th;
    L4:
        if (isReady() == true) goto L6;
    L46:
        monitor-exit(this);
        return;
    L6:
        if (this.destroy == true) goto L46;
        if (this.mCalledFuntion != true) goto L57;
        monitor-exit(this);
        return;
    L57:
        this.mCalledFuntion = true;     // Catch: Throwable -> L52
        if (this.useRunnable == true) goto L16;
        Iterator<Method> r100 = this.methodMap.iterator();     // Catch: Throwable -> L52
    L31:
        if (r100.hasNext() == false) goto L43;
        Method r101 = r100.next();     // Catch: Throwable -> L52
        if (this.destroy == true) goto L43;
        if (Method.access$000(r101) == null) goto L31;
        java.lang.reflect.Method r102 = Method.access$000(r101).getClass().getDeclaredMethod(Method.access$100(r101), Method.access$200(r101));     // Catch: Throwable -> L51
        if (r102 == null) goto L31;
        r102.setAccessible(true);     // Catch: Throwable -> L51
        r102.invoke(Method.access$000(r101), Method.access$300(r101));     // Catch: Throwable -> L51
    L43:
        this.methodMap.clear();     // Catch: Throwable -> L52
    L16:
        if (this.runnableArrayList.size() <= 0) goto L26;
        if (this.destroy == true) goto L26;
        NativeFunctionRunnable r103 = this.runnableArrayList.get(0);     // Catch: Throwable -> L52
        if (r103 == null) goto L25;
        Runnable r104 = r103.getRunnable();     // Catch: Throwable -> L52
        if (r104 == null) goto L25;
        r104.run();     // Catch: Throwable -> L52
    L25:
        this.runnableArrayList.remove(0);     // Catch: Throwable -> L52
    L26:
        this.logSizeCount = 1;     // Catch: Throwable -> L52
        monitor-exit(this);
        return;
    L44:
        monitor-exit(this);
    }

    public abstract void createNative();

    public void destroy() {
        this.destroy = true;
        monitor-enter(this);
        this.runnableArrayList.clear();     // Catch: Throwable -> L7
        this.methodMap.clear();     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public abstract void finalizeNative();

    public abstract long getNative();

    public NativeBase() {
        this.mCalledFuntion = false;
        this.useRunnable = true;
        this.destroy = false;
        this.logSizeCount = 1;
        this.methodMap = new ArrayList();
        this.runnableArrayList = new ArrayList();
    }

    public void finalize() throws Throwable {
        super.finalize();
        finalizeNative();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.toString();
    }

    public boolean isReady() {
        if (getNative() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void validate() {
        java.lang.reflect.Method[] r100 = getClass().getMethods();
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = r100.length;
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L26;
        java.lang.reflect.Method r103 = r100[r102];
        if (r103.isAnnotationPresent(ParameterIsClass.class) == false) goto L25;
        ParameterIsClass r104 = (ParameterIsClass) r103.getAnnotation(ParameterIsClass.class);
        if (r104 == null) goto L25;
        if (r104.required() == false) goto L25;
        Class<?>[] r105 = r103.getParameterTypes();
        if (r105 == null) goto L25;
        int r106 = r105.length;
        int r107 = 0;
    L19:
        if (r107 >= r106) goto L25;
        if ((r105[r107] instanceof Object) == false) goto L24;
        r107 = r107 + 1;
        goto L19
    L24:
        throw new RuntimeException("函数：" + r103 + " 参数不是对象类型");
    L25:
        r102 = r102 + 1;
        goto L6
    }

    public int findRunnableIndex(NativeFunctionRunnable r100) {
        if (this.runnableArrayList != null) goto L5;
        return -1;
    L5:
        if (r100 != null) goto L7;
        return -1;
    L7:
        int r101 = 0;
    L9:
        if (r101 >= this.runnableArrayList.size()) goto L16;
        NativeFunctionRunnable r102 = (NativeFunctionRunnable) ListProtector.get(this.runnableArrayList, r101);
        if (r102 == null) goto L15;
        if (r102.getKey().equals(r100.getKey()) == false) goto L15;
        return r101;
    L15:
        r101 = r101 + 1;
        goto L9
    L16:
        return -1;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public synchronized void storeUncallFunction(Object r100, Object r101, String r102, String r103, Object... r104) {
        monitor-enter(this);
        if (this.useRunnable == false) goto L27;
        if (r101 == null) goto L27;
        NativeFunctionRunnable r105 = new NativeFunctionRunnable(r103, r102, (Runnable) r101);     // Catch: Throwable -> L35
        ArrayList<NativeFunctionRunnable> r106 = this.runnableArrayList;     // Catch: Throwable -> L35
        monitor-enter(r106);     // Catch: Throwable -> L35
        int r107 = this.runnableArrayList.size();     // Catch: Throwable -> L24
        if (r107 > (this.logSizeCount * 10)) goto L13;
    L18:
        int r108 = findRunnableIndex(r105);     // Catch: Throwable -> L24
        if (r108 < 0) goto L21;
        this.runnableArrayList.remove(r108);     // Catch: Throwable -> L24
    L21:
        this.runnableArrayList.add(r105);     // Catch: Throwable -> L24
        monitor-exit(r106);     // Catch: Throwable -> L24
    L32:
        this.mCalledFuntion = false;     // Catch: Throwable -> L35
        goto L33
    L13:
        z3.d("[map][overlay]", "storeUncallFunction size = " + r107);     // Catch: Throwable -> L24
        this.logSizeCount = this.logSizeCount + 1;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L35
    L27:
        StackTraceElement[] r109 = ThreadMethodProxy.currentThread().getStackTrace();     // Catch: Throwable -> L35
        if (r109 == null) goto L32;
        if (r109.length < 3) goto L32;
        this.methodMap.add(new Method(r100, r109[3].getMethodName(), false, r104));     // Catch: Throwable -> L35
    L33:
        monitor-exit(this);
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public synchronized void storeUncallFunctionArray(Object r100, Object r101, String[] r102, String r103, Object[] r104) {
        monitor-enter(this);
        if (this.useRunnable == false) goto L29;
        if (r101 == null) goto L29;
        StringBuilder r105 = new StringBuilder("");     // Catch: Throwable -> L37
        int r106 = r102.length;     // Catch: Throwable -> L37
        int r107 = 0;
    L7:
        if (r107 >= r106) goto L9;
        r105.append(r102[r107]);     // Catch: Throwable -> L37
        r105.append(",");     // Catch: Throwable -> L37
        r107 = r107 + 1;     // Catch: Throwable -> L37
        goto L7
    L9:
        NativeFunctionRunnable r108 = new NativeFunctionRunnable(r103, r105.toString(), (Runnable) r101);     // Catch: Throwable -> L37
        ArrayList<NativeFunctionRunnable> r109 = this.runnableArrayList;     // Catch: Throwable -> L37
        monitor-enter(r109);     // Catch: Throwable -> L37
        int r110 = this.runnableArrayList.size();     // Catch: Throwable -> L26
        if (r110 > (this.logSizeCount * 10)) goto L15;
    L20:
        int r111 = findRunnableIndex(r108);     // Catch: Throwable -> L26
        if (r111 < 0) goto L23;
        this.runnableArrayList.remove(r111);     // Catch: Throwable -> L26
    L23:
        this.runnableArrayList.add(r108);     // Catch: Throwable -> L26
        monitor-exit(r109);     // Catch: Throwable -> L26
    L34:
        this.mCalledFuntion = false;     // Catch: Throwable -> L37
        goto L35
    L15:
        z3.d("[map][overlay]", "storeUncallFunctionArray size = " + r110);     // Catch: Throwable -> L26
        this.logSizeCount = this.logSizeCount + 1;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L37
    L29:
        StackTraceElement[] r112 = ThreadMethodProxy.currentThread().getStackTrace();     // Catch: Throwable -> L37
        if (r112 == null) goto L34;
        if (r112.length < 3) goto L34;
        this.methodMap.add(new Method(r100, r112[3].getMethodName(), false, r104));     // Catch: Throwable -> L37
    L35:
        monitor-exit(this);
    }
}
