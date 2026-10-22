package com.stepos.deepbinder.core.utils;

import android.util.Pair;
import com.stepos.deepbinder.core.entity.wrapper.ParameterWrapper;
import com.stepos.deepbinder.core.exception.IPCException;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0016\u0010\u0005\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0002J9\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u001e\u0010\r\u001a\u001a\u0012\u0014\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\u00010\u0006\u0018\u00010\t¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/deepbinder/core/utils/ParameterWrapperUtil;", "", "<init>", "()V", "getParameterObject", "pair", "Landroid/util/Pair;", "Ljava/lang/Class;", "wrapperParameters", "", "Lcom/stepos/deepbinder/core/entity/wrapper/ParameterWrapper;", "methodName", "", "pairs", "(Ljava/lang/String;[Landroid/util/Pair;)[Lcom/stepos/deepbinder/core/entity/wrapper/ParameterWrapper;", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ParameterWrapperUtil {
    public static final ParameterWrapperUtil INSTANCE = new ParameterWrapperUtil();

    private ParameterWrapperUtil() {
    }

    private final Object getParameterObject(Pair<Class<?>, Object> pair) {
        Class cls = (Class) pair.first;
        if (cls == null) {
            throw new IPCException(32, "The pair and parameter class can't be null!");
        }
        Object obj = pair.second;
        if (obj == null || cls.isAssignableFrom(obj.getClass())) {
            return obj;
        }
        throw new IPCException(37, "The parameter object " + obj.getClass().getName() + " is not an instance of " + cls.getName() + ". Please check the pair's values!");
    }

    public final ParameterWrapper[] wrapperParameters(String methodName, Pair<Class<?>, Object>[] pairs) {
        p.i(methodName, "methodName");
        if (pairs == null) {
            return new ParameterWrapper[0];
        }
        ArrayList arrayList = new ArrayList(pairs.length);
        for (Pair<Class<?>, Object> pair : pairs) {
            Object parameterObject = INSTANCE.getParameterObject(pair);
            ParameterWrapper parameterWrapperObtain = ParameterWrapper.INSTANCE.obtain();
            String name = ((Class) pair.first).getName();
            p.h(name, "getName(...)");
            arrayList.add(parameterWrapperObtain.withParameterName(name).withData(parameterObject));
        }
        return (ParameterWrapper[]) arrayList.toArray(new ParameterWrapper[0]);
    }
}
