package io.ktor.server.config;

import Z8.F;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0019\u0010\u0002\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0019\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0019\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"", "Lio/ktor/server/config/ApplicationConfig;", "merge", "(Ljava/util/List;)Lio/ktor/server/config/ApplicationConfig;", "other", "mergeWith", "(Lio/ktor/server/config/ApplicationConfig;Lio/ktor/server/config/ApplicationConfig;)Lio/ktor/server/config/ApplicationConfig;", "withFallback", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MergedApplicationConfigKt {
    public static final ApplicationConfig merge(List<? extends ApplicationConfig> list) {
        p.i(list, "<this>");
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List of configs can not be empty");
        }
        Object objC0 = F.C0(list);
        if (!list.isEmpty()) {
            ListIterator<? extends ApplicationConfig> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                objC0 = withFallback(listIterator.previous(), (ApplicationConfig) objC0);
            }
        }
        return (ApplicationConfig) objC0;
    }

    public static final ApplicationConfig mergeWith(ApplicationConfig applicationConfig, ApplicationConfig other) {
        p.i(applicationConfig, "<this>");
        p.i(other, "other");
        return applicationConfig.keys().isEmpty() ? other : other.keys().isEmpty() ? applicationConfig : new MergedApplicationConfig(other, applicationConfig);
    }

    public static final ApplicationConfig withFallback(ApplicationConfig applicationConfig, ApplicationConfig other) {
        p.i(applicationConfig, "<this>");
        p.i(other, "other");
        return new MergedApplicationConfig(applicationConfig, other);
    }
}
