package com.stepos.deepbinder.core.handler;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.deepbinder.annotation.parameter.Inout;
import com.stepos.deepbinder.annotation.parameter.Out;
import com.stepos.deepbinder.core.api.IDataFlow;
import com.stepos.deepbinder.core.entity.Reply;
import com.stepos.deepbinder.core.entity.wrapper.ParameterWrapper;
import com.stepos.deepbinder.core.exception.IPCException;
import com.stepos.deepbinder.core.log.IPCLog;
import dc.e;
import java.lang.annotation.Annotation;
import java.lang.ref.Cleaner;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import mb.t;
import x9.h;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@f.a
/* loaded from: classes.dex */
public abstract class BaseInvocationHandler implements InvocationHandler {
    public static final a Companion = new a();
    private static final String TAG = "BaseInvocationHandler";
    private Cleaner.Cleanable cleanable;
    private Method methodReadFromParcel;
    private final AtomicBoolean isCleaned = new AtomicBoolean(false);
    private final Object[] emptyArgs = new Object[0];

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
    }

    private final void checkResult(Reply reply, Method method) {
        if (reply.getResult() == null && !g.b(method.getReturnType(), Void.TYPE) && method.getReturnType().isPrimitive()) {
            IPCLog.INSTANCE.e(TAG, "[processReply] the primitive result is null!", new Object[0]);
            throw new IPCException(30, "the primitive result is null!");
        }
        if (reply.getResult() != null) {
            Object result = reply.getResult();
            g.c(result);
            Class<?> cls = result.getClass();
            Class<?> returnType = method.getReturnType();
            g.c(returnType);
            if (h.b(returnType, cls) || returnType.isAssignableFrom(cls)) {
                return;
            }
            throw new IPCException(31, cls.getName() + " can't cast to " + returnType);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    private final void processEachFlowParameter(Object obj, Class<?> cls, Object[] objArr, int i10) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (objArr[i10] == null) {
            objArr[i10] = obj;
            return;
        }
        if (!cls.isArray()) {
            if (List.class.isAssignableFrom(cls)) {
                Object obj2 = objArr[i10];
                g.d(obj2, "null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.Any?>");
                List listA = k.a(obj2);
                g.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                Collections.copy(listA, (List) obj);
                return;
            }
            if (Map.class.isAssignableFrom(cls)) {
                Object obj3 = objArr[i10];
                g.d(obj3, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.Any?, kotlin.Any?>");
                Map mapB = k.b(obj3);
                mapB.clear();
                g.d(obj, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.Any?, kotlin.Any?>");
                mapB.putAll((Map) obj);
                return;
            }
            if (IDataFlow.class.isAssignableFrom(cls)) {
                Object obj4 = objArr[i10];
                g.d(obj4, "null cannot be cast to non-null type com.stepos.deepbinder.core.api.IDataFlow<kotlin.Any?>");
                ((IDataFlow) obj4).readFromObject(obj);
                return;
            } else {
                if (Parcelable.class.isAssignableFrom(cls)) {
                    g.d(obj, "null cannot be cast to non-null type android.os.Parcelable");
                    processParcelableObject((Parcelable) obj, cls, objArr, i10);
                    return;
                }
                return;
            }
        }
        String name = cls.getName();
        Object obj5 = objArr[i10];
        g.c(obj5);
        if (obj == null) {
            return;
        }
        int iHashCode = name.hashCode();
        if (iHashCode != 2891) {
            if (iHashCode != 2904) {
                if (iHashCode != 2911) {
                    if (iHashCode != 2894) {
                        if (iHashCode != 2895) {
                            switch (iHashCode) {
                                case 2887:
                                    if (name.equals("[B")) {
                                        byte[] bArr = (byte[]) obj5;
                                        System.arraycopy((byte[]) obj, 0, bArr, 0, bArr.length);
                                        return;
                                    }
                                    break;
                                case 2888:
                                    if (name.equals("[C")) {
                                        char[] cArr = (char[]) obj5;
                                        System.arraycopy((char[]) obj, 0, cArr, 0, cArr.length);
                                        return;
                                    }
                                    break;
                                case 2889:
                                    if (name.equals("[D")) {
                                        double[] dArr = (double[]) obj5;
                                        System.arraycopy((double[]) obj, 0, dArr, 0, dArr.length);
                                        return;
                                    }
                                    break;
                            }
                        } else if (name.equals("[J")) {
                            long[] jArr = (long[]) obj5;
                            System.arraycopy((long[]) obj, 0, jArr, 0, jArr.length);
                            return;
                        }
                    } else if (name.equals("[I")) {
                        int[] iArr = (int[]) obj5;
                        System.arraycopy((int[]) obj, 0, iArr, 0, iArr.length);
                        return;
                    }
                } else if (name.equals("[Z")) {
                    boolean[] zArr = (boolean[]) obj5;
                    System.arraycopy((boolean[]) obj, 0, zArr, 0, zArr.length);
                    return;
                }
            } else if (name.equals("[S")) {
                short[] sArr = (short[]) obj5;
                System.arraycopy((short[]) obj, 0, sArr, 0, sArr.length);
                return;
            }
        } else if (name.equals("[F")) {
            float[] fArr = (float[]) obj5;
            System.arraycopy((float[]) obj, 0, fArr, 0, fArr.length);
            return;
        }
        Object[] objArr2 = (Object[]) obj5;
        System.arraycopy((Object[]) obj, 0, objArr2, 0, objArr2.length);
    }

    private final void processFlowParameter(Reply reply, Method method, Object[] objArr) {
        boolean z;
        boolean z3;
        ParameterWrapper[] flowParameterWrappers = reply.getFlowParameterWrappers();
        if (flowParameterWrappers != null) {
            if (flowParameterWrappers.length == 0) {
                flowParameterWrappers = null;
            }
            if (flowParameterWrappers != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                Annotation[][] parameterAnnotations = method.getParameterAnnotations();
                g.f(objArr, "<this>");
                Iterator<Integer> it = new e(0, objArr.length - 1, 1).iterator();
                int i10 = 0;
                while (it.hasNext()) {
                    int iNextInt = ((t) it).nextInt();
                    Annotation[] annotationArr = parameterAnnotations[iNextInt];
                    g.d(annotationArr, "null cannot be cast to non-null type kotlin.Array<java.lang.annotation.Annotation>");
                    int length = annotationArr.length;
                    int i11 = 0;
                    while (true) {
                        if (i11 >= length) {
                            z = false;
                            break;
                        } else {
                            if (Out.class.isInstance(annotationArr[i11])) {
                                z = true;
                                break;
                            }
                            i11++;
                        }
                    }
                    if (!z) {
                        int length2 = annotationArr.length;
                        int i12 = 0;
                        while (true) {
                            if (i12 >= length2) {
                                z3 = false;
                                break;
                            } else {
                                if (Inout.class.isInstance(annotationArr[i12])) {
                                    z3 = true;
                                    break;
                                }
                                i12++;
                            }
                        }
                        if (!z3) {
                            continue;
                        }
                    }
                    Object data = flowParameterWrappers[i10].getData();
                    if (data != null) {
                        try {
                            Class<?> cls = parameterTypes[iNextInt];
                            g.e(cls, "get(...)");
                            processEachFlowParameter(data, cls, objArr, iNextInt);
                        } catch (Throwable th) {
                            IPCLog.INSTANCE.w(TAG, "[processReply]", th);
                            throw new IPCException(25, th);
                        }
                    }
                    i10++;
                }
            }
        }
    }

    private final void processParcelableObject(Parcelable parcelable, Class<?> cls, Object[] objArr, int i10) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (this.methodReadFromParcel == null) {
            Method declaredMethod = cls.getDeclaredMethod("readFromParcel", Parcel.class);
            this.methodReadFromParcel = declaredMethod;
            declaredMethod.setAccessible(true);
        }
        Parcel parcelObtain = Parcel.obtain();
        g.e(parcelObtain, "obtain(...)");
        parcelable.writeToParcel(parcelObtain, 0);
        parcelObtain.setDataPosition(0);
        Method method = this.methodReadFromParcel;
        g.c(method);
        method.invoke(objArr[i10], parcelObtain);
        parcelObtain.recycle();
    }

    public final void clean() {
        if (this.isCleaned.getAndSet(true)) {
            return;
        }
        IPCLog.INSTANCE.d(TAG, "[clean]", new Object[0]);
        Cleaner.Cleanable cleanable = this.cleanable;
        if (cleanable != null) {
            cleanable.clean();
        } else {
            recycleOriginObjects();
        }
    }

    public final void finalize() {
        if (this.isCleaned.get() || this.cleanable != null) {
            return;
        }
        recycleOriginObjects();
    }

    public final Cleaner.Cleanable getCleanable() {
        return this.cleanable;
    }

    public abstract Reply internalInvoke(Method method, Object[] objArr);

    @Override // java.lang.reflect.InvocationHandler
    @f.a
    public Object invoke(Object obj, Method method, Object[] objArr) {
        g.f(method, "method");
        if (!g.b(method.getDeclaringClass(), Object.class)) {
            if (objArr == null) {
                objArr = this.emptyArgs;
            }
            return processReply(internalInvoke(method, objArr), method, objArr);
        }
        if (objArr == null) {
            try {
                objArr = new Object[0];
            } catch (Throwable th) {
                IPCLog.INSTANCE.w(TAG, "[invoke]", th);
                throw new IPCException(18, th);
            }
        }
        return method.invoke(this, Arrays.copyOf(objArr, objArr.length));
    }

    public final AtomicBoolean isCleaned() {
        return this.isCleaned;
    }

    public final Object processReply(Reply reply, Method method, Object[] args) {
        g.f(reply, "reply");
        g.f(method, "method");
        g.f(args, "args");
        Class<?> returnType = method.getReturnType();
        g.e(returnType, "getReturnType(...)");
        if (g.b(Void.TYPE, returnType)) {
            if (reply.getFlowParameterWrappers() == null) {
                return null;
            }
            ParameterWrapper[] flowParameterWrappers = reply.getFlowParameterWrappers();
            g.c(flowParameterWrappers);
            if (flowParameterWrappers.length == 0) {
                return null;
            }
        }
        processFlowParameter(reply, method, args);
        checkResult(reply, method);
        return (reply.getResult() == null || !method.getReturnType().isPrimitive()) ? reply.getResult() : reply.getResult();
    }

    public abstract void recycleOriginObjects();

    public final void updateCleanable(Cleaner.Cleanable cleanable) {
        this.cleanable = cleanable;
    }
}
