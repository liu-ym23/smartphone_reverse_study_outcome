package com.stepos.stepclaw.base.framework;

import a6.w;
import a8.b;
import android.content.Context;
import android.os.Process;
import android.util.Log;
import c5.m;
import com.stepos.stepclaw.SecurePrefs;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import m0.f;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\t\u001a\u00020\u00012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ+\u0010\u000e\u001a\u0004\u0018\u00010\u00012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0010\u001a\u0004\u0018\u00010\u00012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ+\u0010\u0011\u001a\u0004\u0018\u00010\u00012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\u000fJ[\u0010\u0018\u001a\u0004\u0018\u00010\u00012\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0013\u001a\u00020\f2\u0010\u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0017\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J[\u0010\u001a\u001a\u0004\u0018\u00010\u00012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0013\u001a\u00020\f2\u0010\u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0017\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001a\u0010\u0019J=\u0010\u001c\u001a\u00020\f2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\b\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u001bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b!\u0010\"J%\u0010%\u001a\u00028\u0000\"\b\b\u0000\u0010#*\u00020\u00012\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b%\u0010&J\u001c\u0010%\u001a\u00028\u0000\"\n\b\u0000\u0010#\u0018\u0001*\u00020\u0001H\u0086\b¢\u0006\u0004\b%\u0010'J-\u0010)\u001a\u00020 \"\b\b\u0000\u0010#*\u00020\u00012\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010(\u001a\u00028\u0000¢\u0006\u0004\b)\u0010*J$\u0010)\u001a\u00020 \"\n\b\u0000\u0010#\u0018\u0001*\u00020\u00012\u0006\u0010(\u001a\u00028\u0000H\u0086\b¢\u0006\u0004\b)\u0010+J\r\u0010,\u001a\u00020 ¢\u0006\u0004\b,\u0010\u0003R\u0018\u0010-\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R$\u00100\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\u00010/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R$\u00102\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\u00010/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00101¨\u00063"}, d2 = {"Lcom/stepos/stepclaw/base/framework/ServiceLocator;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "Ljava/lang/Class;", "ifaceClass", "implClass", "Lcom/stepos/stepclaw/base/framework/Factory;", "factory", "createInstance", "(Ljava/lang/Class;Ljava/lang/Class;Lcom/stepos/stepclaw/base/framework/Factory;)Ljava/lang/Object;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "errors", "tryCompanionCreate", "(Ljava/lang/Class;Ljava/util/List;)Ljava/lang/Object;", "tryConstructorWithContext", "tryConstructorNoArg", "cls", "methodName", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "paramTypes", "args", "label", "invokeStatic", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;Ljava/util/List;Ljava/lang/String;)Ljava/lang/Object;", "invokeOnCompanion", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "buildErrorMessage", "(Ljava/lang/Class;Ljava/lang/Class;Lcom/stepos/stepclaw/base/framework/Factory;Ljava/util/List;)Ljava/lang/String;", "Landroid/content/Context;", "context", "Lb5/a0;", "init", "(Landroid/content/Context;)V", "T", "clazz", "get", "(Ljava/lang/Class;)Ljava/lang/Object;", "()Ljava/lang/Object;", "instance", "provide", "(Ljava/lang/Class;Ljava/lang/Object;)V", "(Ljava/lang/Object;)V", "reset", "appContext", "Landroid/content/Context;", "Ljava/util/concurrent/ConcurrentHashMap;", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "overrides", "step-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ServiceLocator {
    private static volatile Context appContext;
    public static final ServiceLocator INSTANCE = new ServiceLocator();
    private static final ConcurrentHashMap<Class<?>, Object> cache = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<Class<?>, Object> overrides = new ConcurrentHashMap<>();

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Factory.values().length];
            try {
                iArr[Factory.AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Factory.COMPANION_CREATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Factory.CONSTRUCTOR_WITH_CONTEXT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Factory.CONSTRUCTOR_NO_ARG.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private ServiceLocator() {
    }

    private final String buildErrorMessage(Class<?> ifaceClass, Class<?> implClass, Factory factory, List<String> errors) {
        String strA0 = errors.isEmpty() ? "(none)" : m.A0(errors, "\n    - ", "    - ", null, null, 60);
        String name = implClass.getName();
        String name2 = ifaceClass.getName();
        String simpleName = implClass.getSimpleName();
        StringBuilder sbV = b.v("ServiceLocator: cannot instantiate ", name, " for interface ", name2, " (factory=");
        sbV.append(factory);
        sbV.append(")\n  Tried in order:\n");
        sbV.append(strA0);
        sbV.append("\n  Hint: ensure ");
        return f.f(sbV, simpleName, " has one of:\n    - companion object { @JvmStatic fun create(context: Context): T = ... }\n    - companion object { @JvmStatic fun create(): T = ... }\n    - constructor(context: Context)\n    - constructor()\n  Or override factory= via @ImplementedBy(factory = Factory.XXX) to narrow the lookup.");
    }

    private final Object createInstance(Class<?> ifaceClass, Class<?> implClass, Factory factory) {
        ArrayList arrayList = new ArrayList();
        int i8 = WhenMappings.$EnumSwitchMapping$0[factory.ordinal()];
        if (i8 == 1) {
            Object objTryCompanionCreate = tryCompanionCreate(implClass, arrayList);
            if (objTryCompanionCreate != null) {
                return objTryCompanionCreate;
            }
            Object objTryConstructorWithContext = tryConstructorWithContext(implClass, arrayList);
            if (objTryConstructorWithContext != null) {
                return objTryConstructorWithContext;
            }
            Object objTryConstructorNoArg = tryConstructorNoArg(implClass, arrayList);
            if (objTryConstructorNoArg != null) {
                return objTryConstructorNoArg;
            }
        } else if (i8 == 2) {
            Object objTryCompanionCreate2 = tryCompanionCreate(implClass, arrayList);
            if (objTryCompanionCreate2 != null) {
                return objTryCompanionCreate2;
            }
        } else if (i8 == 3) {
            Object objTryConstructorWithContext2 = tryConstructorWithContext(implClass, arrayList);
            if (objTryConstructorWithContext2 != null) {
                return objTryConstructorWithContext2;
            }
        } else {
            if (i8 != 4) {
                throw new w();
            }
            Object objTryConstructorNoArg2 = tryConstructorNoArg(implClass, arrayList);
            if (objTryConstructorNoArg2 != null) {
                return objTryConstructorNoArg2;
            }
        }
        throw new ServiceLocatorException(buildErrorMessage(ifaceClass, implClass, factory, arrayList), null, 2, null);
    }

    private final Object invokeOnCompanion(Class<?> implClass, String methodName, Class<?>[] paramTypes, Object[] args, List<String> errors, String label) {
        try {
            Field declaredField = implClass.getDeclaredField("Companion");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            if (obj == null) {
                return null;
            }
            try {
                Method declaredMethod = obj.getClass().getDeclaredMethod(methodName, (Class[]) Arrays.copyOf(paramTypes, paramTypes.length));
                declaredMethod.setAccessible(true);
                Object objInvoke = declaredMethod.invoke(obj, Arrays.copyOf(args, args.length));
                if (objInvoke != null) {
                    return objInvoke;
                }
                throw new ServiceLocatorException(label + " on " + implClass.getName() + " returned null", null, 2, null);
            } catch (NoSuchMethodException unused) {
                errors.add(label + ": not found");
                return null;
            } catch (InvocationTargetException e9) {
                String name = implClass.getName();
                String simpleName = e9.getTargetException().getClass().getSimpleName();
                String message = e9.getTargetException().getMessage();
                StringBuilder sb = new StringBuilder();
                sb.append(label);
                sb.append(" on ");
                sb.append(name);
                sb.append(" threw: ");
                sb.append(simpleName);
                throw new ServiceLocatorException(f.f(sb, ": ", message), e9.getTargetException());
            } catch (Throwable th) {
                errors.add(label + ": failed (" + th.getClass().getSimpleName() + ": " + th.getMessage() + ")");
                return null;
            }
        } catch (NoSuchFieldException unused2) {
            return null;
        } catch (Throwable th2) {
            errors.add(label + ": failed reading Companion field (" + th2.getClass().getSimpleName() + ": " + th2.getMessage() + ")");
            return null;
        }
    }

    private final Object invokeStatic(Class<?> cls, String methodName, Class<?>[] paramTypes, Object[] args, List<String> errors, String label) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(methodName, (Class[]) Arrays.copyOf(paramTypes, paramTypes.length));
            if (!Modifier.isStatic(declaredMethod.getModifiers())) {
                errors.add(label + ": method exists but is not static (try @JvmStatic on companion object's " + methodName + ")");
                return null;
            }
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, Arrays.copyOf(args, args.length));
            if (objInvoke != null) {
                return objInvoke;
            }
            throw new ServiceLocatorException(label + " on " + cls.getName() + " returned null", null, 2, null);
        } catch (NoSuchMethodException unused) {
            errors.add(label + ": not found");
            return null;
        } catch (InvocationTargetException e9) {
            String name = cls.getName();
            String simpleName = e9.getTargetException().getClass().getSimpleName();
            String message = e9.getTargetException().getMessage();
            StringBuilder sb = new StringBuilder();
            sb.append(label);
            sb.append(" on ");
            sb.append(name);
            sb.append(" threw: ");
            sb.append(simpleName);
            throw new ServiceLocatorException(f.f(sb, ": ", message), e9.getTargetException());
        } catch (Throwable th) {
            errors.add(label + ": failed (" + th.getClass().getSimpleName() + ": " + th.getMessage() + ")");
            return null;
        }
    }

    private final Object tryCompanionCreate(Class<?> implClass, List<String> errors) {
        ServiceLocator serviceLocator;
        Class<?> cls;
        List<String> list;
        Context context = appContext;
        if (context != null) {
            serviceLocator = this;
            cls = implClass;
            list = errors;
            Object objInvokeStatic = serviceLocator.invokeStatic(cls, "create", new Class[]{Context.class}, new Object[]{context}, list, "create(Context) [JvmStatic]");
            if (objInvokeStatic != null) {
                return objInvokeStatic;
            }
        } else {
            serviceLocator = this;
            cls = implClass;
            list = errors;
            list.add("create(Context) [JvmStatic]: skipped (ServiceLocator.init(Context) not called)");
        }
        Object objInvokeStatic2 = serviceLocator.invokeStatic(cls, "create", new Class[0], new Object[0], list, "create() [JvmStatic]");
        if (objInvokeStatic2 != null) {
            return objInvokeStatic2;
        }
        if (context != null) {
            Object objInvokeOnCompanion = serviceLocator.invokeOnCompanion(cls, "create", new Class[]{Context.class}, new Object[]{context}, list, "Companion.create(Context)");
            if (objInvokeOnCompanion != null) {
                return objInvokeOnCompanion;
            }
        } else {
            list.add("Companion.create(Context): skipped (ServiceLocator.init(Context) not called)");
        }
        Object objInvokeOnCompanion2 = serviceLocator.invokeOnCompanion(cls, "create", new Class[0], new Object[0], list, "Companion.create()");
        if (objInvokeOnCompanion2 != null) {
            return objInvokeOnCompanion2;
        }
        return null;
    }

    private final Object tryConstructorNoArg(Class<?> implClass, List<String> errors) {
        try {
            Constructor<?> declaredConstructor = implClass.getDeclaredConstructor(null);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(null);
        } catch (NoSuchMethodException unused) {
            errors.add("constructor(): not found");
            return null;
        } catch (InvocationTargetException e9) {
            String name = implClass.getName();
            String simpleName = e9.getTargetException().getClass().getSimpleName();
            String message = e9.getTargetException().getMessage();
            StringBuilder sbV = b.v("constructor() on ", name, " threw: ", simpleName, ": ");
            sbV.append(message);
            throw new ServiceLocatorException(sbV.toString(), e9.getTargetException());
        } catch (Throwable th) {
            errors.add(b.q("constructor(): failed (", th.getClass().getSimpleName(), ": ", th.getMessage(), ")"));
            return null;
        }
    }

    private final Object tryConstructorWithContext(Class<?> implClass, List<String> errors) {
        Context context = appContext;
        if (context == null) {
            errors.add("constructor(Context): skipped (ServiceLocator.init(Context) not called)");
            return null;
        }
        try {
            Constructor<?> declaredConstructor = implClass.getDeclaredConstructor(Context.class);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(context);
        } catch (NoSuchMethodException unused) {
            errors.add("constructor(Context): not found");
            return null;
        } catch (InvocationTargetException e9) {
            String name = implClass.getName();
            String simpleName = e9.getTargetException().getClass().getSimpleName();
            String message = e9.getTargetException().getMessage();
            StringBuilder sbV = b.v("constructor(Context) on ", name, " threw: ", simpleName, ": ");
            sbV.append(message);
            throw new ServiceLocatorException(sbV.toString(), e9.getTargetException());
        } catch (Throwable th) {
            errors.add(b.q("constructor(Context): failed (", th.getClass().getSimpleName(), ": ", th.getMessage(), ")"));
            return null;
        }
    }

    public final <T> T get(Class<T> clazz) throws ClassNotFoundException {
        T t8;
        p.e(clazz, "clazz");
        T t9 = (T) overrides.get(clazz);
        if (t9 != null) {
            return t9;
        }
        ConcurrentHashMap<Class<?>, Object> concurrentHashMap = cache;
        T t10 = (T) concurrentHashMap.get(clazz);
        if (t10 != null) {
            return t10;
        }
        String simpleName = clazz.getSimpleName();
        String str = appContext == null ? "NULL" : "set";
        int iMyPid = Process.myPid();
        int iMyTid = Process.myTid();
        String name = Thread.currentThread().getName();
        StringBuilder sbV = b.v("get(", simpleName, "): cache miss, appContext=", str, " pid=");
        b.z(sbV, iMyPid, " tid=", iMyTid, " callerThread=");
        sbV.append(name);
        Log.i("ServiceLocator", sbV.toString());
        ImplementedBy implementedBy = (ImplementedBy) clazz.getAnnotation(ImplementedBy.class);
        if (implementedBy == null) {
            throw new ServiceLocatorException(b.q("interface ", clazz.getName(), " lacks @ImplementedBy annotation\n  Hint: add @ImplementedBy(\"<full.qualified.ImplName>\") on the interface, or use ServiceLocator.provide(", clazz.getSimpleName(), "::class.java, instance) for testing."), null, 2, null);
        }
        try {
            Class<?> cls = Class.forName(implementedBy.implClass());
            if (clazz.isAssignableFrom(cls)) {
                T t11 = (T) createInstance(clazz, cls, implementedBy.factory());
                p.c(t11, "null cannot be cast to non-null type T of com.stepos.stepclaw.base.framework.ServiceLocator.get");
                return (implementedBy.lifecycle() != Lifecycle.SINGLETON || (t8 = (T) concurrentHashMap.putIfAbsent(clazz, t11)) == null) ? t11 : t8;
            }
            throw new ServiceLocatorException(cls.getName() + " does not implement " + clazz.getName() + "\n  Hint: check the @ImplementedBy(\"" + implementedBy.implClass() + "\") on " + clazz.getName() + " points to a class implementing this interface.", null, 2, null);
        } catch (ClassNotFoundException e9) {
            throw new ServiceLocatorException(b.q("ClassNotFoundException: ", implementedBy.implClass(), "\n  Hint: ensure @ImplementedBy(\"...\") on ", clazz.getName(), " points to a class on the runtime classpath, and that R8/ProGuard keeps it (see :step-base/consumer-rules.pro)."), e9);
        }
    }

    public final void init(Context context) {
        p.e(context, "context");
        appContext = context;
        Context context2 = appContext;
        String name = context2 != null ? context2.getClass().getName() : null;
        int iMyPid = Process.myPid();
        int iMyTid = Process.myTid();
        String name2 = Thread.currentThread().getName();
        StringBuilder sbU = b.u("init() called: appContext=", iMyPid, name, " pid=", " tid=");
        sbU.append(iMyTid);
        sbU.append(" callerThread=");
        sbU.append(name2);
        Log.e("ServiceLocator", sbU.toString());
    }

    public final <T> void provide(Class<T> clazz, T instance) {
        p.e(clazz, "clazz");
        p.e(instance, "instance");
        if (!clazz.isInstance(instance)) {
            throw new IllegalArgumentException(b.p("instance ", instance.getClass().getName(), " is not an instance of ", clazz.getName()).toString());
        }
        overrides.put(clazz, instance);
    }

    public final void reset() {
        cache.clear();
        overrides.clear();
    }

    public final /* synthetic */ <T> void provide(T instance) {
        p.e(instance, "instance");
        p.i();
        throw null;
    }

    public final /* synthetic */ <T> T get() {
        p.i();
        throw null;
    }
}
