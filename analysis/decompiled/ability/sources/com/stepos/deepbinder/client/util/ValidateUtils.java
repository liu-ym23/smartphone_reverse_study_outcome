package com.stepos.deepbinder.client.util;

import B7.a;
import android.content.ComponentName;
import android.text.TextUtils;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.deepbinder.annotation.type.SameProcess;
import com.stepos.deepbinder.annotation.type.ServiceName;
import com.stepos.deepbinder.annotation.type.ValidityCheck;
import com.stepos.deepbinder.core.exception.IPCException;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u000b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/deepbinder/client/util/ValidateUtils;", "", AppAgent.CONSTRUCT, "()V", "Ljava/lang/Class;", "serviceInterface", "LC7/r;", "validateServiceInterface", "(Ljava/lang/Class;)V", "", "serviceName", "validateAndGetServiceName", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/String;", "Landroid/content/ComponentName;", "componentName", "validateComponentName", "(Landroid/content/ComponentName;)V", "deepbinder-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ValidateUtils {
    public static final ValidateUtils INSTANCE = new ValidateUtils();

    private ValidateUtils() {
    }

    private final void validateServiceInterface(Class<?> serviceInterface) {
        if (serviceInterface == null) {
            throw new IPCException(20, "The interface parameter is null, please check.");
        }
        if (!serviceInterface.isInterface()) {
            throw new IPCException(20, a.m("The parameter ", serviceInterface.getName(), " is not an interface, only interfaces can be passed as parameters, please check."));
        }
        if (serviceInterface.getAnnotation(ValidityCheck.class) == null && serviceInterface.getAnnotation(SameProcess.class) == null) {
            throw new IPCException(20, a.m("The interface: ", serviceInterface.getName(), " must have @ValidityCheck annotation during cross-process calls."));
        }
    }

    public final String validateAndGetServiceName(String serviceName, Class<?> serviceInterface) {
        k.f(serviceInterface, "serviceInterface");
        validateServiceInterface(serviceInterface);
        if (!TextUtils.isEmpty(serviceName)) {
            k.c(serviceName);
            return serviceName;
        }
        ServiceName serviceName2 = (ServiceName) serviceInterface.getAnnotation(ServiceName.class);
        if (serviceName2 == null || TextUtils.isEmpty(serviceName2.value())) {
            throw new IPCException(20, "The interface must have @ServiceName annotation.");
        }
        return serviceName2.value();
    }

    public final void validateComponentName(ComponentName componentName) {
        if (componentName == null || TextUtils.isEmpty(componentName.getClassName()) || TextUtils.isEmpty(componentName.getPackageName())) {
            throw new IPCException(27, "The component name or its contained info is null, please check!");
        }
    }
}
