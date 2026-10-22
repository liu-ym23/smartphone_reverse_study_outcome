package org.lsposed.hiddenapibypass;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.bytedanceos.common.toolbox.ServerElements;
import dalvik.system.VMRuntime;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandleInfo;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(28)
public final class HiddenApiBypass {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Unsafe f23052a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f23053b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f23054c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f23055d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f23056e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final long f23057f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final long f23058g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final long f23059h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final long f23060i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final long f23061j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final long f23062k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final long f23063l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final long f23064m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final Set f23065n = null;

    static {
        f23065n = new HashSet();
        Unsafe r10 = (Unsafe) Unsafe.class.getDeclaredMethod("getUnsafe", null).invoke(null, null);     // Catch: ReflectiveOperationException -> L5
        f23052a = r10;     // Catch: ReflectiveOperationException -> L5
        f23053b = r10.objectFieldOffset(Helper$Executable.class.getDeclaredField("artMethod"));     // Catch: ReflectiveOperationException -> L5
        f23054c = r10.objectFieldOffset(Helper$Executable.class.getDeclaredField("declaringClass"));     // Catch: ReflectiveOperationException -> L5
        long r11 = r10.objectFieldOffset(Helper$MethodHandle.class.getDeclaredField("artFieldOrMethod"));     // Catch: ReflectiveOperationException -> L5
        f23055d = r11;     // Catch: ReflectiveOperationException -> L5
        f23056e = r10.objectFieldOffset(Helper$MethodHandleImpl.class.getDeclaredField(ServerElements.INFO));     // Catch: ReflectiveOperationException -> L5
        long r12 = r10.objectFieldOffset(Helper$Class.class.getDeclaredField("methods"));     // Catch: ReflectiveOperationException -> L5
        f23057f = r12;     // Catch: ReflectiveOperationException -> L5
        long r13 = r10.objectFieldOffset(Helper$Class.class.getDeclaredField("iFields"));     // Catch: ReflectiveOperationException -> L5
        f23058g = r13;     // Catch: ReflectiveOperationException -> L5
        f23059h = r10.objectFieldOffset(Helper$Class.class.getDeclaredField("sFields"));     // Catch: ReflectiveOperationException -> L5
        f23060i = r10.objectFieldOffset(Helper$HandleInfo.class.getDeclaredField("member"));     // Catch: ReflectiveOperationException -> L5
        Method r14 = Helper$NeverCall.class.getDeclaredMethod("a", null);     // Catch: ReflectiveOperationException -> L5
        Method r15 = Helper$NeverCall.class.getDeclaredMethod("b", null);     // Catch: ReflectiveOperationException -> L5
        r14.setAccessible(true);     // Catch: ReflectiveOperationException -> L5
        r15.setAccessible(true);     // Catch: ReflectiveOperationException -> L5
        MethodHandle r16 = MethodHandles.lookup().unreflect(r14);     // Catch: ReflectiveOperationException -> L5
        MethodHandle r17 = MethodHandles.lookup().unreflect(r15);     // Catch: ReflectiveOperationException -> L5
        long r18 = r10.getLong(r16, r11);     // Catch: ReflectiveOperationException -> L5
        long r19 = r10.getLong(r17, r11);     // Catch: ReflectiveOperationException -> L5
        long r20 = r10.getLong(Helper$NeverCall.class, r12);     // Catch: ReflectiveOperationException -> L5
        long r21 = r19 - r18;     // Catch: ReflectiveOperationException -> L5
        f23061j = r21;     // Catch: ReflectiveOperationException -> L5
        f23062k = (r18 - r20) - r21;     // Catch: ReflectiveOperationException -> L5
        Field r22 = Helper$NeverCall.class.getDeclaredField("i");     // Catch: ReflectiveOperationException -> L5
        Field r23 = Helper$NeverCall.class.getDeclaredField("j");     // Catch: ReflectiveOperationException -> L5
        r22.setAccessible(true);     // Catch: ReflectiveOperationException -> L5
        r23.setAccessible(true);     // Catch: ReflectiveOperationException -> L5
        MethodHandle r24 = MethodHandles.lookup().unreflectGetter(r22);     // Catch: ReflectiveOperationException -> L5
        MethodHandle r25 = MethodHandles.lookup().unreflectGetter(r23);     // Catch: ReflectiveOperationException -> L5
        long r26 = r10.getLong(r24, r11);     // Catch: ReflectiveOperationException -> L5
        long r27 = r10.getLong(r25, r11);     // Catch: ReflectiveOperationException -> L5
        long r28 = r10.getLong(Helper$NeverCall.class, r13);     // Catch: ReflectiveOperationException -> L5
        f23063l = r27 - r26;     // Catch: ReflectiveOperationException -> L5
        f23064m = r26 - r28;     // Catch: ReflectiveOperationException -> L5
        return;
    L5:
        e = move-exception;
        Log.e("HiddenApiBypass", "Initialize error", e);
        throw new ExceptionInInitializerError(e);
    }

    public HiddenApiBypass() {
    }

    @VisibleForTesting
    public static boolean a(Class[] r10, Object[] r11) {
        if (r10.length == r11.length) goto L5;
        return false;
    L5:
        int r12 = 0;
    L7:
        if (r12 >= r10.length) goto L56;
        if (r10[r12].isPrimitive() == false) goto L50;
        Class r13 = r10[r12];
        if (r13 != Integer.TYPE) goto L16;
        if ((r11[r12] instanceof Integer) == true) goto L16;
        return false;
    L16:
        if (r13 != Byte.TYPE) goto L21;
        if ((r11[r12] instanceof Byte) == true) goto L21;
        return false;
    L21:
        if (r13 != Character.TYPE) goto L26;
        if ((r11[r12] instanceof Character) == true) goto L26;
        return false;
    L26:
        if (r13 != Boolean.TYPE) goto L31;
        if ((r11[r12] instanceof Boolean) == true) goto L31;
        return false;
    L31:
        if (r13 != Double.TYPE) goto L36;
        if ((r11[r12] instanceof Double) == true) goto L36;
        return false;
    L36:
        if (r13 != Float.TYPE) goto L41;
        if ((r11[r12] instanceof Float) == true) goto L41;
        return false;
    L41:
        if (r13 != Long.TYPE) goto L46;
        if ((r11[r12] instanceof Long) == true) goto L46;
        return false;
    L46:
        if (r13 != Short.TYPE) goto L55;
        if ((r11[r12] instanceof Short) == true) goto L55;
        return false;
    L55:
        r12 = r12 + 1;
        goto L7
    L50:
        Object r14 = r11[r12];
        if (r14 == null) goto L55;
        if (r10[r12].isInstance(r14) == true) goto L55;
        return false;
    L56:
        return true;
    }

    public static boolean addHiddenApiExemptions(String... r10) {
        Set r11 = f23065n;
        r11.addAll(Arrays.asList(r10));
        String[] r12 = new String[((HashSet) r11).size()];
        r11.toArray(r12);
        return setHiddenApiExemptions(r12);
    }

    public static boolean clearHiddenApiExemptions() {
        ((HashSet) f23065n).clear();
        return setHiddenApiExemptions(new String[0]);
    }

    @NonNull
    public static Constructor getDeclaredConstructor(@NonNull Class r10, @NonNull Class... r11) {
        Iterator r12 = getDeclaredMethods(r10).iterator();
    L4:
        if (r12.hasNext() == false) goto L21;
        Executable r13 = (Executable) r12.next();
        if ((r13 instanceof Constructor) == false) goto L4;
        Class<?>[] r14 = r13.getParameterTypes();
        if (r14.length != r11.length) goto L4;
        int r15 = 0;
    L13:
        if (r15 >= r11.length) goto L19;
        if (r11[r15] != r14[r15]) goto L4;
        r15 = r15 + 1;
        goto L13
    L19:
        return (Constructor) r13;
    L21:
        throw new NoSuchMethodException("Cannot find matching constructor");
    }

    @NonNull
    public static Method getDeclaredMethod(@NonNull Class r10, @NonNull String r11, @NonNull Class... r12) {
        Iterator r13 = getDeclaredMethods(r10).iterator();
    L4:
        if (r13.hasNext() == false) goto L24;
        Executable r14 = (Executable) r13.next();
        if (r14.getName().equals(r11) == false) goto L4;
        if ((r14 instanceof Method) == false) goto L4;
        Class<?>[] r15 = r14.getParameterTypes();
        if (r15.length != r12.length) goto L4;
        int r16 = 0;
    L16:
        if (r16 >= r12.length) goto L22;
        if (r12[r16] != r15[r16]) goto L4;
        r16 = r16 + 1;
        goto L16
    L22:
        return (Method) r14;
    L24:
        throw new NoSuchMethodException("Cannot find matching method");
    }

    @NonNull
    public static List getDeclaredMethods(@NonNull Class r14) {
        ArrayList r10 = new ArrayList();
        if (r14.isPrimitive() == false) goto L5;
    L16:
        return r10;
    L5:
        if (r14.isArray() == true) goto L16;
        Method r11 = Helper$NeverCall.class.getDeclaredMethod("a", null);     // Catch: Throwable -> L18
        r11.setAccessible(true);     // Catch: Throwable -> L18
        MethodHandle r12 = MethodHandles.lookup().unreflect(r11);     // Catch: Throwable -> L18
        Unsafe r13 = f23052a;
        long r15 = r13.getLong(r14, f23057f);
        if (r15 != 0) goto L11;
        return r10;
    L11:
        int r16 = r13.getInt(r15);
        int r17 = 0;
    L12:
        if (r17 >= r16) goto L16;
        long r18 = ((((long) r17) * f23061j) + r15) + f23062k;
        Unsafe r19 = f23052a;
        r19.putLong(r12, f23055d, r18);
        r19.putObject(r12, f23056e, null);
        MethodHandles.lookup().revealDirect(r12);     // Catch: Throwable -> L17
    L15:
        Unsafe r20 = f23052a;
        r10.add((Executable) r20.getObject((MethodHandleInfo) r20.getObject(r12, f23056e), f23060i));
        r17 = r17 + 1;
        goto L12
    }

    @NonNull
    public static List getInstanceFields(@NonNull Class r13) {
        ArrayList r10 = new ArrayList();
        if (r13.isPrimitive() == false) goto L5;
    L16:
        return r10;
    L5:
        if (r13.isArray() == true) goto L16;
        Field r11 = Helper$NeverCall.class.getDeclaredField("i");     // Catch: Throwable -> L18
        r11.setAccessible(true);     // Catch: Throwable -> L18
        MethodHandle r12 = MethodHandles.lookup().unreflectGetter(r11);     // Catch: Throwable -> L18
        Unsafe r14 = f23052a;
        long r15 = r14.getLong(r13, f23058g);
        if (r15 != 0) goto L11;
        return r10;
    L11:
        int r16 = r14.getInt(r15);
        int r17 = 0;
    L12:
        if (r17 >= r16) goto L16;
        long r18 = ((((long) r17) * f23063l) + r15) + f23064m;
        Unsafe r19 = f23052a;
        r19.putLong(r12, f23055d, r18);
        r19.putObject(r12, f23056e, null);
        MethodHandles.lookup().revealDirect(r12);     // Catch: Throwable -> L17
    L15:
        Unsafe r20 = f23052a;
        r10.add((Field) r20.getObject((MethodHandleInfo) r20.getObject(r12, f23056e), f23060i));
        r17 = r17 + 1;
        goto L12
    }

    @NonNull
    public static List getStaticFields(@NonNull Class r13) {
        ArrayList r10 = new ArrayList();
        if (r13.isPrimitive() == false) goto L5;
    L16:
        return r10;
    L5:
        if (r13.isArray() == true) goto L16;
        Field r11 = Helper$NeverCall.class.getDeclaredField("s");     // Catch: Throwable -> L18
        r11.setAccessible(true);     // Catch: Throwable -> L18
        MethodHandle r12 = MethodHandles.lookup().unreflectGetter(r11);     // Catch: Throwable -> L18
        Unsafe r14 = f23052a;
        long r15 = r14.getLong(r13, f23059h);
        if (r15 != 0) goto L11;
        return r10;
    L11:
        int r16 = r14.getInt(r15);
        int r17 = 0;
    L12:
        if (r17 >= r16) goto L16;
        long r18 = ((((long) r17) * f23063l) + r15) + f23064m;
        Unsafe r19 = f23052a;
        r19.putLong(r12, f23055d, r18);
        r19.putObject(r12, f23056e, null);
        MethodHandles.lookup().revealDirect(r12);     // Catch: Throwable -> L17
    L15:
        Unsafe r20 = f23052a;
        r10.add((Field) r20.getObject((MethodHandleInfo) r20.getObject(r12, f23056e), f23060i));
        r17 = r17 + 1;
        goto L12
    }

    public static Object invoke(@NonNull Class r12, @Nullable Object r13, @NonNull String r14, Object... r15) {
        if (r13 != null) goto L5;
    L9:
        Method r10 = Helper$InvokeStub.class.getDeclaredMethod("invoke", new Class[]{Object[].class});
        r10.setAccessible(true);
        Unsafe r11 = f23052a;
        long r16 = r11.getLong(r12, f23057f);
        if (r16 == 0) goto L23;
        int r17 = r11.getInt(r16);
        int r18 = 0;
    L12:
        if (r18 >= r17) goto L21;
        long r19 = ((((long) r18) * f23061j) + r16) + f23062k;
        f23052a.putLong(r10, f23053b, r19);
        if (r14.equals(r10.getName()) == false) goto L19;
        if (a(r10.getParameterTypes(), r15) == false) goto L19;
        return r10.invoke(r13, r15);
    L19:
        r18 = r18 + 1;
        goto L12
    L21:
        throw new NoSuchMethodException("Cannot find matching method");
    L23:
        throw new NoSuchMethodException("Cannot find matching method");
    L5:
        if (r12.isInstance(r13) == true) goto L9;
        throw new IllegalArgumentException("this object is not an instance of the given class");
    }

    public static Object newInstance(@NonNull Class r21, Object... r22) {
        Method r10 = Helper$InvokeStub.class.getDeclaredMethod("invoke", new Class[]{Object[].class});
        Constructor r11 = Helper$InvokeStub.class.getDeclaredConstructor(new Class[]{Object[].class});
        r11.setAccessible(true);
        Unsafe r12 = f23052a;
        long r13 = r12.getLong(r21, f23057f);
        if (r13 == 0) goto L16;
        int r14 = r12.getInt(r13);
        int r15 = 0;
    L5:
        if (r15 >= r14) goto L14;
        long r16 = ((((long) r15) * f23061j) + r13) + f23062k;
        Unsafe r17 = f23052a;
        long r18 = f23053b;
        r17.putLong(r10, r18, r16);
        if ("<init>".equals(r10.getName()) == false) goto L12;
        r17.putLong(r11, r18, r16);
        r17.putObject(r11, f23054c, r21);
        if (a(r11.getParameterTypes(), r22) == false) goto L12;
        return r11.newInstance(r22);
    L12:
        r15 = r15 + 1;
        goto L5
    L14:
        throw new NoSuchMethodException("Cannot find matching constructor");
    L16:
        throw new NoSuchMethodException("Cannot find matching constructor");
    }

    public static boolean setHiddenApiExemptions(@NonNull String... r10) {
        invoke(VMRuntime.class, invoke(VMRuntime.class, null, "getRuntime", new Object[0]), "setHiddenApiExemptions", new Object[]{r10});     // Catch: Throwable -> L6
        return true;
    L6:
        th = move-exception;
        Log.w("HiddenApiBypass", "setHiddenApiExemptions", th);
        return false;
    }
}
