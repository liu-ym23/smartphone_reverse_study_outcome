package io.ktor.server.logging;

import io.ktor.server.application.Application;
import io.ktor.server.application.ApplicationPluginKt;
import io.ktor.server.request.ApplicationRequest;
import io.ktor.server.request.ApplicationRequestPropertiesKt;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\"\u0015\u0010\b\u001a\u00020\u0005*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lio/ktor/server/request/ApplicationRequest;", "", "toLogString", "(Lio/ktor/server/request/ApplicationRequest;)Ljava/lang/String;", "Lio/ktor/server/application/Application;", "Lio/ktor/server/logging/MDCProvider;", "getMdcProvider", "(Lio/ktor/server/application/Application;)Lio/ktor/server/logging/MDCProvider;", "mdcProvider", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LoggingKt {
    public static final MDCProvider getMdcProvider(Application application) {
        MDCProvider mDCProvider;
        p.i(application, "<this>");
        Iterator<T> it = ApplicationPluginKt.getPluginRegistry(application).getAllKeys().iterator();
        do {
            mDCProvider = null;
            if (!it.hasNext()) {
                break;
            }
            AttributeKey attributeKey = (AttributeKey) it.next();
            Attributes pluginRegistry = ApplicationPluginKt.getPluginRegistry(application);
            p.g(attributeKey, "null cannot be cast to non-null type io.ktor.util.AttributeKey<kotlin.Any>");
            Object orNull = pluginRegistry.getOrNull(attributeKey);
            if (orNull instanceof MDCProvider) {
                mDCProvider = (MDCProvider) orNull;
            }
        } while (mDCProvider == null);
        return mDCProvider == null ? EmptyMDCProvider.INSTANCE : mDCProvider;
    }

    public static final String toLogString(ApplicationRequest applicationRequest) {
        p.i(applicationRequest, "<this>");
        return ApplicationRequestPropertiesKt.getHttpMethod(applicationRequest).getValue() + " - " + ApplicationRequestPropertiesKt.path(applicationRequest);
    }
}
