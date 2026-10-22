package com.stepos.deepbinder.core.utils;

import Y8.t;
import Z8.C1174w;
import android.content.Context;
import com.stepos.deepbinder.annotation.parameter.ImmediateEviction;
import com.stepos.deepbinder.annotation.parameter.Inout;
import com.stepos.deepbinder.annotation.parameter.Out;
import com.stepos.deepbinder.annotation.parameter.WeakRef;
import com.stepos.deepbinder.annotation.type.Callback;
import com.stepos.deepbinder.core.DeepBinderInternal;
import com.stepos.deepbinder.core.cache.CallbackCache;
import com.stepos.deepbinder.core.cache.CallbackProxyCache;
import com.stepos.deepbinder.core.cache.TypeCache;
import com.stepos.deepbinder.core.entity.wrapper.ParameterWrapper;
import com.stepos.deepbinder.core.log.IPCLog;
import com.stepos.deepbinder.core.provider.ClientServiceProvider;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010\u0006\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J/\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u00102\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u00112\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010¢\u0006\u0002\u0010\u0013J9\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00052\f\b\u0001\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0010¢\u0006\u0002\u0010\u001aJ\u0014\u0010\u001b\u001a\u00020\u001c2\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u0016H\u0002JA\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00102\u0006\u0010\u0007\u001a\u00020\u00052\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00102\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0002\u0010 J3\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\u00102\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020#2\u0010\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0010¢\u0006\u0002\u0010$R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/stepos/deepbinder/core/utils/ParameterTransformerUtils;", "", "<init>", "()V", "TAG", "", "createParameter", "methodName", "wrapper", "Lcom/stepos/deepbinder/core/entity/wrapper/ParameterWrapper;", "outParameters", "", "", "version", "index", "getFlowParameterWrappers", "", "", "args", "(Ljava/util/List;[Ljava/lang/Object;)[Lcom/stepos/deepbinder/core/entity/wrapper/ParameterWrapper;", "internalWrapParameter", "paramClass", "Ljava/lang/Class;", "paramObj", "annotations", "Ljava/lang/annotation/Annotation;", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Object;[Ljava/lang/annotation/Annotation;)Lcom/stepos/deepbinder/core/entity/wrapper/ParameterWrapper;", "isCallbackClass", "", "clazz", "unwrapParameters", "wrappers", "(Ljava/lang/String;[Lcom/stepos/deepbinder/core/entity/wrapper/ParameterWrapper;Ljava/util/List;I)[Ljava/lang/Object;", "wrapParameters", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/String;Ljava/lang/reflect/Method;[Ljava/lang/Object;)[Lcom/stepos/deepbinder/core/entity/wrapper/ParameterWrapper;", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ParameterTransformerUtils {
    public static final ParameterTransformerUtils INSTANCE = new ParameterTransformerUtils();
    private static final String TAG = "ParameterTransformerUtils";

    private ParameterTransformerUtils() {
    }

    private final Object createParameter(String methodName, ParameterWrapper wrapper, List<Integer> outParameters, int version, int index) {
        Class<?> classType;
        if (wrapper == null || (classType = TypeCache.INSTANCE.getInstance().getClassType(wrapper)) == null) {
            return null;
        }
        if (!isCallbackClass(classType) || wrapper.getClientServiceBinder() == null) {
            if (Context.class.isAssignableFrom(classType)) {
                return DeepBinderInternal.getContext();
            }
            if (wrapper.getFlowFlag() != 0) {
                outParameters.add(Integer.valueOf(index));
            }
            return wrapper.getData();
        }
        Object callbackProxy = CallbackProxyCache.INSTANCE.getCallbackProxy(classType, wrapper, version, methodName);
        if (callbackProxy == null) {
            IPCLog.INSTANCE.w(TAG, "[createParameter] Failed to create callback proxy for " + methodName, new Object[0]);
        }
        return callbackProxy;
    }

    private final boolean isCallbackClass(Class<?> clazz) {
        return clazz.isInterface() && clazz.getAnnotation(Callback.class) != null;
    }

    public final ParameterWrapper[] getFlowParameterWrappers(List<Integer> outParameters, Object[] args) {
        p.i(outParameters, "outParameters");
        p.i(args, "args");
        List<Integer> list = outParameters;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            int iIntValue = ((Number) it.next()).intValue();
            ParameterWrapper parameterWrapperObtain = ParameterWrapper.INSTANCE.obtain();
            parameterWrapperObtain.setData(args[iIntValue]);
            Object data = parameterWrapperObtain.getData();
            parameterWrapperObtain.setName(data != null ? data.getClass().getName() : "");
            arrayList.add(parameterWrapperObtain);
        }
        return (ParameterWrapper[]) arrayList.toArray(new ParameterWrapper[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ParameterWrapper internalWrapParameter(String methodName, Class<?> paramClass, Object paramObj, Annotation[] annotations) {
        Object[] objArr;
        Object[] objArr2;
        boolean z10;
        p.i(methodName, "methodName");
        p.i(paramClass, "paramClass");
        p.i(annotations, "annotations");
        int i10 = 1;
        boolean z11 = true;
        if (isCallbackClass(paramClass)) {
            if (paramObj == null) {
                ParameterWrapper parameterWrapperObtain = ParameterWrapper.INSTANCE.obtain();
                parameterWrapperObtain.setName(paramClass.getName());
                return parameterWrapperObtain;
            }
            int length = annotations.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    z10 = false;
                    break;
                }
                if (annotations[i11] instanceof WeakRef) {
                    z10 = true;
                    break;
                }
                i11++;
            }
            int length2 = annotations.length;
            int i12 = 0;
            while (true) {
                if (i12 >= length2) {
                    z11 = false;
                    break;
                }
                if (annotations[i12] instanceof ImmediateEviction) {
                    break;
                }
                i12++;
            }
            ParameterWrapper parameterWrapperObtain2 = ParameterWrapper.INSTANCE.obtain();
            parameterWrapperObtain2.setName(paramClass.getName());
            parameterWrapperObtain2.setHashCodeValue(paramObj.hashCode());
            parameterWrapperObtain2.setClientServiceBinder(ClientServiceProvider.INSTANCE.getClientService());
            parameterWrapperObtain2.setTimeStamp(CallbackCache.INSTANCE.putCallback(methodName, paramObj, z10, z11));
            return parameterWrapperObtain2;
        }
        if (paramObj instanceof Context) {
            ParameterWrapper parameterWrapperObtain3 = ParameterWrapper.INSTANCE.obtain();
            parameterWrapperObtain3.setName(Context.class.getName());
            return parameterWrapperObtain3;
        }
        int length3 = annotations.length;
        int i13 = 0;
        while (true) {
            if (i13 >= length3) {
                objArr = false;
                break;
            }
            if (annotations[i13] instanceof Out) {
                objArr = true;
                break;
            }
            i13++;
        }
        int length4 = annotations.length;
        int i14 = 0;
        while (true) {
            if (i14 >= length4) {
                objArr2 = false;
                break;
            }
            if (annotations[i14] instanceof Inout) {
                objArr2 = true;
                break;
            }
            i14++;
        }
        ParameterWrapper parameterWrapperObtain4 = ParameterWrapper.INSTANCE.obtain();
        parameterWrapperObtain4.setName(paramClass.getName());
        if (objArr2 == true) {
            i10 = 2;
        } else if (objArr == false) {
            i10 = 0;
        }
        parameterWrapperObtain4.setFlowFlag(i10);
        parameterWrapperObtain4.setData(paramObj);
        return parameterWrapperObtain4;
    }

    public final Object[] unwrapParameters(String methodName, ParameterWrapper[] wrappers, List<Integer> outParameters, int version) {
        p.i(methodName, "methodName");
        p.i(outParameters, "outParameters");
        if (wrappers == null) {
            return new Object[0];
        }
        int length = wrappers.length;
        Object[] objArr = new Object[length];
        for (int i10 = 0; i10 < length; i10++) {
            objArr[i10] = INSTANCE.createParameter(methodName, wrappers[i10], outParameters, version, i10);
        }
        return objArr;
    }

    public final ParameterWrapper[] wrapParameters(String methodName, Method method, Object[] args) {
        ParameterWrapper parameterWrapperObtain;
        p.i(methodName, "methodName");
        p.i(method, "method");
        if (args == null) {
            return new ParameterWrapper[0];
        }
        Class<?>[] parameterTypes = method.getParameterTypes();
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        int length = args.length;
        ParameterWrapper[] parameterWrapperArr = new ParameterWrapper[length];
        for (int i10 = 0; i10 < length; i10++) {
            try {
                Annotation[] annotationArr = parameterAnnotations[i10];
                if (annotationArr == null) {
                    annotationArr = null;
                }
                if (annotationArr == null) {
                    annotationArr = new Annotation[0];
                }
                ParameterTransformerUtils parameterTransformerUtils = INSTANCE;
                Class<?> cls = parameterTypes[i10];
                p.h(cls, "get(...)");
                parameterWrapperObtain = parameterTransformerUtils.internalWrapParameter(methodName, cls, args[i10], annotationArr);
            } catch (Exception e10) {
                IPCLog.INSTANCE.w(TAG, "[wrapParameters] Failed to wrap parameter at index " + i10, e10);
                parameterWrapperObtain = ParameterWrapper.INSTANCE.obtain();
                parameterWrapperObtain.setName(parameterTypes[i10].getName());
                parameterWrapperObtain.setData(args[i10]);
                t tVar = t.f7040a;
            }
            parameterWrapperArr[i10] = parameterWrapperObtain;
        }
        return parameterWrapperArr;
    }
}
