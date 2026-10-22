package io.ktor.server.engine.internal;

import Z8.C1173v;
import Z8.F;
import io.ktor.server.application.Application;
import io.ktor.server.application.ApplicationEnvironment;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.nio.file.WatchEvent;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.reflect.KParameter;
import kotlin.reflect.full.KCallables;
import o9.C5013a;
import p9.InterfaceC5074l;
import w9.InterfaceC5745d;
import w9.InterfaceC5748g;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0004\u001a!\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\t*\u00020\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a#\u0010\r\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\tH\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a-\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0011\"\u0004\b\u0000\u0010\u000f*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00110\u0010H\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0017\u0010\u0014\u001a\u00020\u0002*\u0006\u0012\u0002\b\u00030\u0011H\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001d\u0010\u0017\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0016*\u0006\u0012\u0002\b\u00030\tH\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0011\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0000¢\u0006\u0004\b\u001a\u0010\u001b\"&\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u001d0\u001c8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\" \u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\" \u0010(\u001a\b\u0012\u0004\u0012\u00020'0\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b(\u0010$\u001a\u0004\b)\u0010&¨\u0006*"}, d2 = {"Lkotlin/reflect/KParameter;", "parameter", "", "isApplicationEnvironment", "(Lkotlin/reflect/KParameter;)Z", "isApplication", "Ljava/lang/ClassLoader;", "", "name", "Ljava/lang/Class;", "loadClassOrNull", "(Ljava/lang/ClassLoader;Ljava/lang/String;)Ljava/lang/Class;", "type", "isParameterOfType", "(Lkotlin/reflect/KParameter;Ljava/lang/Class;)Z", "R", "", "Lw9/g;", "bestFunction", "(Ljava/util/List;)Lw9/g;", "isApplicableFunction", "(Lw9/g;)Z", "Lw9/d;", "takeIfNotFacade", "(Ljava/lang/Class;)Lw9/d;", "Ljava/nio/file/WatchEvent$Modifier;", "get_com_sun_nio_file_SensitivityWatchEventModifier_HIGH", "()Ljava/nio/file/WatchEvent$Modifier;", "Ljava/lang/ThreadLocal;", "", "currentStartupModules", "Ljava/lang/ThreadLocal;", "getCurrentStartupModules", "()Ljava/lang/ThreadLocal;", "Lio/ktor/server/application/ApplicationEnvironment;", "ApplicationEnvironmentClassInstance", "Ljava/lang/Class;", "getApplicationEnvironmentClassInstance", "()Ljava/lang/Class;", "Lio/ktor/server/application/Application;", "ApplicationClassInstance", "getApplicationClassInstance", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AutoReloadUtilsKt {
    private static final ThreadLocal<List<String>> currentStartupModules = new ThreadLocal<>();
    private static final Class<ApplicationEnvironment> ApplicationEnvironmentClassInstance = ApplicationEnvironment.class;
    private static final Class<Application> ApplicationClassInstance = Application.class;

    public static final <R> InterfaceC5748g<R> bestFunction(List<? extends InterfaceC5748g<? extends R>> list) {
        p.i(list, "<this>");
        return (InterfaceC5748g) F.E0(F.c1(list, b9.b.b(new InterfaceC5074l() { // from class: io.ktor.server.engine.internal.b
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AutoReloadUtilsKt.bestFunction$lambda$1((InterfaceC5748g) obj);
            }
        }, new InterfaceC5074l() { // from class: io.ktor.server.engine.internal.c
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AutoReloadUtilsKt.bestFunction$lambda$3((InterfaceC5748g) obj);
            }
        }, new InterfaceC5074l() { // from class: io.ktor.server.engine.internal.d
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AutoReloadUtilsKt.bestFunction$lambda$4((InterfaceC5748g) obj);
            }
        })));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable bestFunction$lambda$1(InterfaceC5748g it) {
        p.i(it, "it");
        boolean z10 = false;
        if (!it.getParameters().isEmpty() && isApplication(it.getParameters().get(0))) {
            z10 = true;
        }
        return Boolean.valueOf(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable bestFunction$lambda$3(InterfaceC5748g it) {
        p.i(it, "it");
        List<KParameter> parameters = it.getParameters();
        int i10 = 0;
        if (!(parameters instanceof Collection) || !parameters.isEmpty()) {
            Iterator<T> it2 = parameters.iterator();
            while (it2.hasNext()) {
                if (!((KParameter) it2.next()).v() && (i10 = i10 + 1) < 0) {
                    C1173v.v();
                }
            }
        }
        return Integer.valueOf(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable bestFunction$lambda$4(InterfaceC5748g it) {
        p.i(it, "it");
        return Integer.valueOf(it.getParameters().size());
    }

    public static final Class<Application> getApplicationClassInstance() {
        return ApplicationClassInstance;
    }

    public static final Class<ApplicationEnvironment> getApplicationEnvironmentClassInstance() {
        return ApplicationEnvironmentClassInstance;
    }

    public static final ThreadLocal<List<String>> getCurrentStartupModules() {
        return currentStartupModules;
    }

    public static final WatchEvent.Modifier get_com_sun_nio_file_SensitivityWatchEventModifier_HIGH() {
        if (System.getenv("ANDROID_DATA") != null) {
            return null;
        }
        try {
            Class<?> cls = Class.forName("com.sun.nio.file.SensitivityWatchEventModifier");
            Object obj = cls.getField("HIGH").get(cls);
            if (obj instanceof WatchEvent.Modifier) {
                return (WatchEvent.Modifier) obj;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static final boolean isApplicableFunction(InterfaceC5748g<?> interfaceC5748g) {
        p.i(interfaceC5748g, "<this>");
        if (interfaceC5748g.isOperator() || interfaceC5748g.isInfix() || interfaceC5748g.isInline() || interfaceC5748g.isAbstract()) {
            return false;
        }
        KParameter kParameterC = KCallables.c(interfaceC5748g);
        if (kParameterC != null && !isApplication(kParameterC) && !isApplicationEnvironment(kParameterC)) {
            return false;
        }
        Method methodE = y9.d.e(interfaceC5748g);
        if (methodE == null) {
            return true;
        }
        if (methodE.isSynthetic()) {
            return false;
        }
        return (Modifier.isStatic(methodE.getModifiers()) && interfaceC5748g.getParameters().isEmpty()) ? false : true;
    }

    public static final boolean isApplication(KParameter parameter) {
        p.i(parameter, "parameter");
        return isParameterOfType(parameter, ApplicationClassInstance);
    }

    public static final boolean isApplicationEnvironment(KParameter parameter) {
        p.i(parameter, "parameter");
        return isParameterOfType(parameter, ApplicationEnvironmentClassInstance);
    }

    public static final boolean isParameterOfType(KParameter parameter, Class<?> type) {
        p.i(parameter, "parameter");
        p.i(type, "type");
        Type typeG = y9.d.g(parameter.getType());
        Class<?> cls = typeG instanceof Class ? (Class) typeG : null;
        if (cls != null) {
            return type.isAssignableFrom(cls);
        }
        return false;
    }

    public static final Class<?> loadClassOrNull(ClassLoader classLoader, String name) {
        p.i(classLoader, "<this>");
        p.i(name, "name");
        try {
            return classLoader.loadClass(name);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static final InterfaceC5745d<?> takeIfNotFacade(Class<?> cls) {
        p.i(cls, "<this>");
        Metadata metadata = (Metadata) cls.getAnnotation(Metadata.class);
        if (metadata == null || metadata.k() != 1) {
            metadata = null;
        }
        if (metadata != null) {
            return C5013a.e(cls);
        }
        return null;
    }
}
