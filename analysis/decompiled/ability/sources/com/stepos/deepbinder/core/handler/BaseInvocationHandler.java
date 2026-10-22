package com.stepos.deepbinder.core.handler;

import Y7.e;
import Y7.f;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.deepbinder.annotation.parameter.Inout;
import com.stepos.deepbinder.annotation.parameter.Out;
import com.stepos.deepbinder.core.api.IDataFlow;
import com.stepos.deepbinder.core.constant.Constants;
import com.stepos.deepbinder.core.entity.Reply;
import com.stepos.deepbinder.core.entity.wrapper.ParameterWrapper;
import com.stepos.deepbinder.core.exception.IPCException;
import com.stepos.deepbinder.core.log.IPCLog;
import com.stepos.deepbinder.core.utils.ConvertUtils;
import com.stepos.deepbinder.core.utils.TypeUtils;
import java.lang.annotation.Annotation;
import java.lang.ref.Cleaner;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.p;

@Keep
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u0000 52\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ;\u0010\u0013\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\r2\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u000fH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J;\u0010\u0018\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00172\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\r2\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\b¢\u0006\u0004\b\u001a\u0010\u0003J\u000f\u0010\u001b\u001a\u00020\bH\u0004¢\u0006\u0004\b\u001b\u0010\u0003J'\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u000fH&¢\u0006\u0004\b\u001d\u0010\u001eJ8\u0010 \u001a\u0004\u0018\u00010\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0012\b\u0001\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u000fH\u0097\u0002¢\u0006\u0004\b \u0010!J/\u0010\"\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u000f¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\bH&¢\u0006\u0004\b$\u0010\u0003J\u0017\u0010'\u001a\u00020\b2\b\u0010&\u001a\u0004\u0018\u00010%¢\u0006\u0004\b'\u0010(R(\u0010&\u001a\u0004\u0018\u00010%2\b\u0010)\u001a\u0004\u0018\u00010%8\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\b&\u0010*\u001a\u0004\b+\u0010,R\u0018\u0010-\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u001a\u00100\u001a\u00020/8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b0\u00102R\u001a\u00103\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104¨\u00066"}, d2 = {"Lcom/stepos/deepbinder/core/handler/BaseInvocationHandler;", "Ljava/lang/reflect/InvocationHandler;", AppAgent.CONSTRUCT, "()V", "Lcom/stepos/deepbinder/core/entity/Reply;", Constants.PARAM_REPLY, "Ljava/lang/reflect/Method;", GuiTaskProgressKt.GuiTaskProgress_KEY_METHOD, "LC7/r;", "checkResult", "(Lcom/stepos/deepbinder/core/entity/Reply;Ljava/lang/reflect/Method;)V", "", "obj", "Ljava/lang/Class;", "cls", "", "objArr", "", "index", "processEachFlowParameter", "(Ljava/lang/Object;Ljava/lang/Class;[Ljava/lang/Object;I)V", "processFlowParameter", "(Lcom/stepos/deepbinder/core/entity/Reply;Ljava/lang/reflect/Method;[Ljava/lang/Object;)V", "Landroid/os/Parcelable;", "processParcelableObject", "(Landroid/os/Parcelable;Ljava/lang/Class;[Ljava/lang/Object;I)V", "clean", "finalize", "args", "internalInvoke", "(Ljava/lang/reflect/Method;[Ljava/lang/Object;)Lcom/stepos/deepbinder/core/entity/Reply;", "proxy", "invoke", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "processReply", "(Lcom/stepos/deepbinder/core/entity/Reply;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "recycleOriginObjects", "Ljava/lang/ref/Cleaner$Cleanable;", "cleanable", "updateCleanable", "(Ljava/lang/ref/Cleaner$Cleanable;)V", "value", "Ljava/lang/ref/Cleaner$Cleanable;", "getCleanable", "()Ljava/lang/ref/Cleaner$Cleanable;", "methodReadFromParcel", "Ljava/lang/reflect/Method;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isCleaned", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "emptyArgs", "[Ljava/lang/Object;", "Companion", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class BaseInvocationHandler implements InvocationHandler {
    private static final String TAG = "BaseInvocationHandler";
    private Cleaner.Cleanable cleanable;
    private Method methodReadFromParcel;
    private final AtomicBoolean isCleaned = new AtomicBoolean(false);
    private final Object[] emptyArgs = new Object[0];

    private final void checkResult(Reply reply, Method method) {
        if (reply.getResult() == null && !k.b(method.getReturnType(), Void.TYPE) && method.getReturnType().isPrimitive()) {
            IPCLog.INSTANCE.e(TAG, "[processReply] the primitive result is null!", new Object[0]);
            throw new IPCException(30, "the primitive result is null!");
        }
        if (reply.getResult() != null) {
            Object result = reply.getResult();
            k.c(result);
            Class<?> cls = result.getClass();
            Class<?> returnType = method.getReturnType();
            TypeUtils typeUtils = TypeUtils.INSTANCE;
            k.c(returnType);
            if (typeUtils.classMatch(returnType, cls) || returnType.isAssignableFrom(cls)) {
                return;
            }
            throw new IPCException(31, cls.getName() + " can't cast to " + returnType);
        }
    }

    private final void processEachFlowParameter(Object obj, Class<?> cls, Object[] objArr, int index) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (objArr[index] == null) {
            objArr[index] = obj;
            return;
        }
        if (cls.isArray()) {
            ConvertUtils convertUtils = ConvertUtils.INSTANCE;
            String name = cls.getName();
            Object obj2 = objArr[index];
            k.c(obj2);
            convertUtils.convertObjectToArray(name, obj2, obj);
            return;
        }
        if (List.class.isAssignableFrom(cls)) {
            Object obj3 = objArr[index];
            k.d(obj3, "null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.Any?>");
            List listB = p.b(obj3);
            k.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Collections.copy(listB, (List) obj);
            return;
        }
        if (Map.class.isAssignableFrom(cls)) {
            Object obj4 = objArr[index];
            k.d(obj4, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.Any?, kotlin.Any?>");
            Map mapC = p.c(obj4);
            mapC.clear();
            k.d(obj, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.Any?, kotlin.Any?>");
            mapC.putAll((Map) obj);
            return;
        }
        if (IDataFlow.class.isAssignableFrom(cls)) {
            Object obj5 = objArr[index];
            k.d(obj5, "null cannot be cast to non-null type com.stepos.deepbinder.core.api.IDataFlow<kotlin.Any?>");
            ((IDataFlow) obj5).readFromObject(obj);
        } else if (Parcelable.class.isAssignableFrom(cls)) {
            k.d(obj, "null cannot be cast to non-null type android.os.Parcelable");
            processParcelableObject((Parcelable) obj, cls, objArr, index);
        }
    }

    private final void processFlowParameter(Reply reply, Method method, Object[] objArr) {
        ParameterWrapper[] flowParameterWrappers = reply.getFlowParameterWrappers();
        if (flowParameterWrappers != null) {
            if (flowParameterWrappers.length == 0) {
                flowParameterWrappers = null;
            }
            if (flowParameterWrappers != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                Annotation[][] parameterAnnotations = method.getParameterAnnotations();
                k.f(objArr, "<this>");
                int i = 0;
                e it = new f(0, objArr.length - 1, 1).iterator();
                while (it.c) {
                    int iNextInt = it.nextInt();
                    Annotation[] annotationArr = parameterAnnotations[iNextInt];
                    k.d(annotationArr, "null cannot be cast to non-null type kotlin.Array<java.lang.annotation.Annotation>");
                    TypeUtils typeUtils = TypeUtils.INSTANCE;
                    if (typeUtils.arrayContainsAnnotation(annotationArr, Out.class) || typeUtils.arrayContainsAnnotation(annotationArr, Inout.class)) {
                        Object data = flowParameterWrappers[i].getData();
                        if (data != null) {
                            try {
                                Class<?> cls = parameterTypes[iNextInt];
                                k.e(cls, "get(...)");
                                processEachFlowParameter(data, cls, objArr, iNextInt);
                            } catch (Throwable th) {
                                IPCLog.INSTANCE.w(TAG, "[processReply]", th);
                                throw new IPCException(25, th);
                            }
                        }
                        i++;
                    }
                }
            }
        }
    }

    private final void processParcelableObject(Parcelable obj, Class<?> cls, Object[] objArr, int index) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (this.methodReadFromParcel == null) {
            Method declaredMethod = cls.getDeclaredMethod("readFromParcel", Parcel.class);
            this.methodReadFromParcel = declaredMethod;
            declaredMethod.setAccessible(true);
        }
        Parcel parcelObtain = Parcel.obtain();
        k.e(parcelObtain, "obtain(...)");
        obj.writeToParcel(parcelObtain, 0);
        parcelObtain.setDataPosition(0);
        Method method = this.methodReadFromParcel;
        k.c(method);
        method.invoke(objArr[index], parcelObtain);
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

    public abstract Reply internalInvoke(Method method, Object[] args);

    @Override // java.lang.reflect.InvocationHandler
    @Keep
    public Object invoke(Object proxy, Method method, @Nullable Object[] args) {
        k.f(method, "method");
        if (!k.b(method.getDeclaringClass(), Object.class)) {
            if (args == null) {
                args = this.emptyArgs;
            }
            return processReply(internalInvoke(method, args), method, args);
        }
        if (args == null) {
            try {
                args = new Object[0];
            } catch (Throwable th) {
                IPCLog.INSTANCE.w(TAG, "[invoke]", th);
                throw new IPCException(18, th);
            }
        }
        return method.invoke(this, Arrays.copyOf(args, args.length));
    }

    /* renamed from: isCleaned, reason: from getter */
    public final AtomicBoolean getIsCleaned() {
        return this.isCleaned;
    }

    public final Object processReply(Reply reply, Method method, Object[] args) {
        k.f(reply, "reply");
        k.f(method, "method");
        k.f(args, "args");
        TypeUtils typeUtils = TypeUtils.INSTANCE;
        Class<?> returnType = method.getReturnType();
        k.e(returnType, "getReturnType(...)");
        if (typeUtils.isVoid(returnType)) {
            if (reply.getFlowParameterWrappers() == null) {
                return null;
            }
            ParameterWrapper[] flowParameterWrappers = reply.getFlowParameterWrappers();
            k.c(flowParameterWrappers);
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
