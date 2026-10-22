package io.ktor.server.application;

import Z8.C1173v;
import io.ktor.server.config.ApplicationConfigValue;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.time.DurationUnit;
import kotlin.time.a;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\t\u001a\u00020\u0006*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0015\u0010\r\u001a\u00020\n*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lio/ktor/server/application/ApplicationEnvironment;", "", "", "getModuleConfigReferences", "(Lio/ktor/server/application/ApplicationEnvironment;)Ljava/util/List;", "moduleConfigReferences", "Lio/ktor/server/application/ApplicationStartupMode;", "getStartupMode", "(Lio/ktor/server/application/ApplicationEnvironment;)Lio/ktor/server/application/ApplicationStartupMode;", "startupMode", "Lkotlin/time/a;", "getStartupTimeout", "(Lio/ktor/server/application/ApplicationEnvironment;)J", "startupTimeout", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ApplicationModulesKt {
    public static final List<String> getModuleConfigReferences(ApplicationEnvironment applicationEnvironment) {
        p.i(applicationEnvironment, "<this>");
        ApplicationConfigValue applicationConfigValuePropertyOrNull = applicationEnvironment.getConfig().propertyOrNull("ktor.application.modules");
        List<String> list = applicationConfigValuePropertyOrNull != null ? applicationConfigValuePropertyOrNull.getList() : null;
        return list == null ? C1173v.m() : list;
    }

    public static final ApplicationStartupMode getStartupMode(ApplicationEnvironment applicationEnvironment) {
        String lowerCase;
        String string;
        p.i(applicationEnvironment, "<this>");
        ApplicationConfigValue applicationConfigValuePropertyOrNull = applicationEnvironment.getConfig().propertyOrNull("ktor.application.startup");
        if (applicationConfigValuePropertyOrNull == null || (string = applicationConfigValuePropertyOrNull.getString()) == null) {
            lowerCase = null;
        } else {
            lowerCase = string.toLowerCase(Locale.ROOT);
            p.h(lowerCase, "toLowerCase(...)");
        }
        if (p.d(lowerCase, "concurrent")) {
            return ApplicationStartupMode.CONCURRENT;
        }
        if (p.d(lowerCase, "sequential") || lowerCase == null) {
            return ApplicationStartupMode.SEQUENTIAL;
        }
        throw new IllegalStateException(("Invalid startup mode: " + lowerCase).toString());
    }

    public static final long getStartupTimeout(ApplicationEnvironment applicationEnvironment) throws NumberFormatException {
        String string;
        p.i(applicationEnvironment, "<this>");
        ApplicationConfigValue applicationConfigValuePropertyOrNull = applicationEnvironment.getConfig().propertyOrNull("ktor.application.startupTimeoutMillis");
        if (applicationConfigValuePropertyOrNull == null || (string = applicationConfigValuePropertyOrNull.getString()) == null) {
            a.Companion companion = kotlin.time.a.INSTANCE;
            return kotlin.time.b.s(10, DurationUnit.SECONDS);
        }
        long j10 = Long.parseLong(string);
        a.Companion companion2 = kotlin.time.a.INSTANCE;
        return kotlin.time.b.t(j10, DurationUnit.MILLISECONDS);
    }
}
