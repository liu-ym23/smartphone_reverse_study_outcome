package x9;

import android.content.Context;
import android.os.IBinder;
import android.util.Pair;
import com.stepos.deepbinder.annotation.parameter.ImmediateEviction;
import com.stepos.deepbinder.annotation.parameter.Inout;
import com.stepos.deepbinder.annotation.parameter.Out;
import com.stepos.deepbinder.annotation.parameter.WeakRef;
import com.stepos.deepbinder.annotation.type.Callback;
import com.stepos.deepbinder.core.DeepBinderInternal;
import com.stepos.deepbinder.core.entity.wrapper.ParameterWrapper;
import com.stepos.deepbinder.core.handler.CallbackInvocationHandler;
import com.stepos.deepbinder.core.log.IPCLog;
import com.stepos.deepbinder.core.provider.ClientServiceProvider;
import java.lang.annotation.Annotation;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import lb.n;
import mb.m;
import n9.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e {
    public static ParameterWrapper[] a(Object[] args, ArrayList arrayList) {
        kotlin.jvm.internal.g.f(args, "args");
        ArrayList arrayList2 = new ArrayList(m.Z(arrayList, 10));
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            int iIntValue = ((Number) obj).intValue();
            ParameterWrapper parameterWrapperObtain = ParameterWrapper.Companion.obtain();
            parameterWrapperObtain.setData(args[iIntValue]);
            Object data = parameterWrapperObtain.getData();
            parameterWrapperObtain.setName(data != null ? data.getClass().getName() : "");
            arrayList2.add(parameterWrapperObtain);
        }
        return (ParameterWrapper[]) arrayList2.toArray(new ParameterWrapper[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ParameterWrapper b(String methodName, Class cls, Object obj, Annotation[] annotationArr) {
        Object[] objArr;
        Object[] objArr2;
        boolean z;
        long jLongValue;
        ClientServiceProvider clientServiceProvider;
        kotlin.jvm.internal.g.f(methodName, "methodName");
        int i10 = 1;
        boolean z3 = true;
        if (!cls.isInterface() || cls.getAnnotation(Callback.class) == null) {
            if (obj instanceof Context) {
                ParameterWrapper parameterWrapperObtain = ParameterWrapper.Companion.obtain();
                parameterWrapperObtain.setName(Context.class.getName());
                return parameterWrapperObtain;
            }
            int length = annotationArr.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    objArr = false;
                    break;
                }
                if (annotationArr[i11] instanceof Out) {
                    objArr = true;
                    break;
                }
                i11++;
            }
            int length2 = annotationArr.length;
            int i12 = 0;
            while (true) {
                if (i12 >= length2) {
                    objArr2 = false;
                    break;
                }
                if (annotationArr[i12] instanceof Inout) {
                    objArr2 = true;
                    break;
                }
                i12++;
            }
            ParameterWrapper parameterWrapperObtain2 = ParameterWrapper.Companion.obtain();
            parameterWrapperObtain2.setName(cls.getName());
            if (objArr2 == true) {
                i10 = 2;
            } else if (objArr == false) {
                i10 = 0;
            }
            parameterWrapperObtain2.setFlowFlag(i10);
            parameterWrapperObtain2.setData(obj);
            return parameterWrapperObtain2;
        }
        if (obj == null) {
            ParameterWrapper parameterWrapperObtain3 = ParameterWrapper.Companion.obtain();
            parameterWrapperObtain3.setName(cls.getName());
            return parameterWrapperObtain3;
        }
        int length3 = annotationArr.length;
        int i13 = 0;
        while (true) {
            if (i13 >= length3) {
                z = false;
                break;
            }
            if (annotationArr[i13] instanceof WeakRef) {
                z = true;
                break;
            }
            i13++;
        }
        int length4 = annotationArr.length;
        int i14 = 0;
        while (true) {
            if (i14 >= length4) {
                z3 = false;
                break;
            }
            if (annotationArr[i14] instanceof ImmediateEviction) {
                break;
            }
            i14++;
        }
        ParameterWrapper parameterWrapperObtain4 = ParameterWrapper.Companion.obtain();
        parameterWrapperObtain4.setName(cls.getName());
        parameterWrapperObtain4.setHashCodeValue(obj.hashCode());
        ClientServiceProvider.Companion.getClass();
        ClientServiceProvider clientServiceProvider2 = ClientServiceProvider.instance;
        if (clientServiceProvider2 == null) {
            synchronized (ClientServiceProvider.class) {
                clientServiceProvider = ClientServiceProvider.instance;
                if (clientServiceProvider == null) {
                    clientServiceProvider = new ClientServiceProvider();
                    ClientServiceProvider.instance = clientServiceProvider;
                }
            }
            clientServiceProvider2 = clientServiceProvider;
        }
        parameterWrapperObtain4.setClientServiceBinder(clientServiceProvider2);
        synchronized (n9.b.f10675a) {
            try {
                Set<Map.Entry<Pair<String, Long>, b.a>> setEntrySet = n9.b.f10676b.entrySet();
                kotlin.jvm.internal.g.e(setEntrySet, "<get-entries>(...)");
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : setEntrySet) {
                    if (((b.a) ((Map.Entry) obj2).getValue()).a() == obj) {
                        arrayList.add(obj2);
                    }
                }
                Set setR0 = kotlin.collections.a.R0(arrayList);
                if (setR0.isEmpty()) {
                    long jA = w9.g.f13619a.a();
                    Pair<String, Long> pair = new Pair<>(methodName, Long.valueOf(jA));
                    n9.b.f10676b.put(pair, new b.a(z, z3, obj));
                    IPCLog.INSTANCE.d("CallbackCache", "[putCallback]", "key", pair);
                    w9.c.f13608a.a().b(jA, obj);
                    jLongValue = jA;
                } else {
                    Object objS0 = kotlin.collections.a.s0(setR0);
                    kotlin.jvm.internal.g.e(objS0, "first(...)");
                    Map.Entry entry = (Map.Entry) objS0;
                    IPCLog.INSTANCE.d("CallbackCache", "[putCallback][Exists]", "key", entry.getKey());
                    Object second = ((Pair) entry.getKey()).second;
                    kotlin.jvm.internal.g.e(second, "second");
                    jLongValue = ((Number) second).longValue();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        parameterWrapperObtain4.setTimeStamp(jLongValue);
        return parameterWrapperObtain4;
    }

    public static Object[] c(String str, ParameterWrapper[] parameterWrapperArr, List outParameters, int i10) {
        Class<?> clsA;
        boolean z;
        Object data;
        kotlin.jvm.internal.g.f(outParameters, "outParameters");
        boolean z3 = false;
        if (parameterWrapperArr == null) {
            return new Object[0];
        }
        int length = parameterWrapperArr.length;
        Object[] objArr = new Object[length];
        int i11 = 0;
        while (i11 < length) {
            ParameterWrapper parameterWrapper = parameterWrapperArr[i11];
            if (parameterWrapper == null || (clsA = n9.e.f10682e.a().a(parameterWrapper)) == null) {
                z = z3;
                data = null;
            } else if (!clsA.isInterface() || clsA.getAnnotation(Callback.class) == null || parameterWrapper.getClientServiceBinder() == null) {
                z = z3;
                if (Context.class.isAssignableFrom(clsA)) {
                    data = DeepBinderInternal.getContext();
                } else {
                    if (parameterWrapper.getFlowFlag() != 0) {
                        outParameters.add(Integer.valueOf(i11));
                    }
                    data = parameterWrapper.getData();
                }
            } else {
                synchronized (n9.c.f10679a) {
                    try {
                        long timeStamp = parameterWrapper.getTimeStamp();
                        ConcurrentHashMap<Long, WeakReference<Object>> concurrentHashMap = n9.c.f10680b;
                        WeakReference<Object> weakReference = concurrentHashMap.get(Long.valueOf(timeStamp));
                        Object obj = weakReference != null ? weakReference.get() : null;
                        if (obj != null) {
                            IPCLog.INSTANCE.d("CallbackProxyCache", "[getCallbackProxy][Exists]", "timeStamp", Long.valueOf(timeStamp));
                            data = obj;
                        } else {
                            IPCLog.INSTANCE.d("CallbackProxyCache", "[getCallbackProxy][Create]", "timeStamp", Long.valueOf(timeStamp));
                            concurrentHashMap.remove(Long.valueOf(timeStamp));
                            IBinder clientServiceBinder = parameterWrapper.getClientServiceBinder();
                            if (clientServiceBinder == null) {
                                data = null;
                            } else {
                                data = Proxy.newProxyInstance(clsA.getClassLoader(), new Class[]{clsA}, new CallbackInvocationHandler(clientServiceBinder, timeStamp, parameterWrapper.hashCode(), i10, str));
                                concurrentHashMap.put(Long.valueOf(timeStamp), new WeakReference<>(data));
                                w9.c.f13608a.a();
                                kotlin.jvm.internal.g.c(data);
                                w9.c.a(data);
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (data == null) {
                    z = false;
                    IPCLog.INSTANCE.w("ParameterTransformerUtils", "[createParameter] Failed to create callback proxy for ".concat(str), new Object[0]);
                } else {
                    z = false;
                }
            }
            objArr[i11] = data;
            i11++;
            z3 = z;
        }
        return objArr;
    }

    public static ParameterWrapper[] d(String methodName, Method method, Object[] objArr) {
        ParameterWrapper parameterWrapperObtain;
        kotlin.jvm.internal.g.f(methodName, "methodName");
        Class<?>[] parameterTypes = method.getParameterTypes();
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        int length = objArr.length;
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
                Class<?> cls = parameterTypes[i10];
                kotlin.jvm.internal.g.e(cls, "get(...)");
                parameterWrapperObtain = b(methodName, cls, objArr[i10], annotationArr);
            } catch (Exception e10) {
                IPCLog.INSTANCE.w("ParameterTransformerUtils", ai.onnxruntime.providers.a.a(i10, "[wrapParameters] Failed to wrap parameter at index "), e10);
                parameterWrapperObtain = ParameterWrapper.Companion.obtain();
                parameterWrapperObtain.setName(parameterTypes[i10].getName());
                parameterWrapperObtain.setData(objArr[i10]);
                n nVar = n.f10413a;
            }
            parameterWrapperArr[i10] = parameterWrapperObtain;
        }
        return parameterWrapperArr;
    }
}
