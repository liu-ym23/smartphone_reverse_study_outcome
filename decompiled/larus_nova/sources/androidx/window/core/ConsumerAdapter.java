package androidx.window.core;

import android.app.Activity;
import androidx.exifinterface.media.ExifInterface;
import com.alipay.sdk.m.p.e;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClasses;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001:\u0002\u001a\u001bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JB\u0010\u0005\u001a\u00020\u0006\"\b\b\u0000\u0010\u0007*\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u00060\u000eJ4\u0010\u000f\u001a\u00020\u0001\"\b\b\u0000\u0010\u0007*\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u00060\u000eH\u0002J\u0013\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0011H\u0000¢\u0006\u0002\b\u0012JT\u0010\u0013\u001a\u00020\u0014\"\b\b\u0000\u0010\u0007*\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00182\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u00060\u000eH\u0007J\f\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/window/core/ConsumerAdapter;", "", "loader", "Ljava/lang/ClassLoader;", "(Ljava/lang/ClassLoader;)V", "addConsumer", "", ExifInterface.GPS_DIRECTION_TRUE, MapBundleKey.MapObjKey.OBJ_SL_OBJ, "clazz", "Lkotlin/reflect/KClass;", "methodName", "", "consumer", "Lkotlin/Function1;", "buildConsumer", "consumerClassOrNull", "Ljava/lang/Class;", "consumerClassOrNull$window_release", "createSubscription", "Landroidx/window/core/ConsumerAdapter$Subscription;", "addMethodName", "removeMethodName", "activity", "Landroid/app/Activity;", "unsafeConsumerClass", "ConsumerHandler", "Subscription", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ConsumerAdapter {
    private final ClassLoader loader;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B'\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ0\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0010\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\u000fH\u0096\u0002¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00028\u0000¢\u0006\u0002\u0010\u0013J#\u0010\u0014\u001a\u00020\u0015*\u00020\r2\u0010\u0010\u0016\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\u000fH\u0002¢\u0006\u0002\u0010\u0017J#\u0010\u0018\u001a\u00020\u0015*\u00020\r2\u0010\u0010\u0016\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\u000fH\u0002¢\u0006\u0002\u0010\u0017J#\u0010\u0019\u001a\u00020\u0015*\u00020\r2\u0010\u0010\u0016\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\u000fH\u0002¢\u0006\u0002\u0010\u0017J#\u0010\u001a\u001a\u00020\u0015*\u00020\r2\u0010\u0010\u0016\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\u000fH\u0002¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/window/core/ConsumerAdapter$ConsumerHandler;", ExifInterface.GPS_DIRECTION_TRUE, "", "Ljava/lang/reflect/InvocationHandler;", "clazz", "Lkotlin/reflect/KClass;", "consumer", "Lkotlin/Function1;", "", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function1;)V", AbsMethodDelegate.TAG_INVOKE, MapBundleKey.MapObjKey.OBJ_SL_OBJ, e.f25671s, "Ljava/lang/reflect/Method;", "parameters", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "invokeAccept", "parameter", "(Ljava/lang/Object;)V", "isAccept", "", "args", "(Ljava/lang/reflect/Method;[Ljava/lang/Object;)Z", "isEquals", "isHashCode", "isToString", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ConsumerHandler<T> implements InvocationHandler {
        private final KClass<T> clazz;
        private final Function1<T, Unit> consumer;

        public final void invokeAccept(T r100) {
            Intrinsics.checkNotNullParameter(r100, "parameter");
            this.consumer.invoke(r100);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ConsumerHandler(KClass<T> r100, Function1<? super T, Unit> r101) {
            Intrinsics.checkNotNullParameter(r100, "clazz");
            Intrinsics.checkNotNullParameter(r101, "consumer");
            this.clazz = r100;
            this.consumer = r101;
        }

        private final boolean isAccept(Method r100, Object[] r101) {
            if (Intrinsics.areEqual(r100.getName(), "accept") == true) goto L5;
            return false;
        L5:
            if (r101 != null) goto L7;
        L9:
            boolean r102 = false;
        L10:
            if (r102 == false) goto L14;
            return true;
        L14:
            return false;
        L7:
            if (r101.length != 1) goto L9;
            r102 = true;
            goto L10
        }

        private final boolean isEquals(Method r100, Object[] r101) {
            if (Intrinsics.areEqual(r100.getName(), "equals") == true) goto L5;
            return false;
        L5:
            if (r100.getReturnType().equals(Boolean.TYPE) == true) goto L7;
            return false;
        L7:
            if (r101 != null) goto L9;
        L11:
            boolean r102 = false;
        L12:
            if (r102 == false) goto L17;
            return true;
        L17:
            return false;
        L9:
            if (r101.length != 1) goto L11;
            r102 = true;
            goto L12
        }

        private final boolean isHashCode(Method r100, Object[] r101) {
            if (Intrinsics.areEqual(r100.getName(), "hashCode") == true) goto L5;
        L8:
            return false;
        L5:
            if (r100.getReturnType().equals(Integer.TYPE) == false) goto L8;
            if (r101 != null) goto L8;
            return true;
        }

        private final boolean isToString(Method r100, Object[] r101) {
            if (Intrinsics.areEqual(r100.getName(), "toString") == true) goto L5;
        L8:
            return false;
        L5:
            if (r100.getReturnType().equals(String.class) == false) goto L8;
            if (r101 != null) goto L8;
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object r100, Method r101, Object[] r102) {
            Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
            Intrinsics.checkNotNullParameter(r101, e.f25671s);
            Object r103 = null;
            boolean r104 = false;
            if (isAccept(r101, r102) == false) goto L9;
            KClass<T> r105 = this.clazz;
            if (r102 == null) goto L7;
            r103 = r102[0];
        L7:
            invokeAccept(KClasses.cast(r105, r103));
            return Unit.INSTANCE;
        L9:
            if (isEquals(r101, r102) == false) goto L16;
            if (r102 == null) goto L12;
            r103 = r102[0];
        L12:
            if (r100 != r103) goto L25;
            r104 = true;
        L25:
            return Boolean.valueOf(r104);
        L16:
            if (isHashCode(r101, r102) == false) goto L19;
            return Integer.valueOf(this.consumer.hashCode());
        L19:
            if (isToString(r101, r102) == false) goto L23;
            return this.consumer.toString();
        L23:
            throw new UnsupportedOperationException("Unexpected method call object:" + r100 + ", method: " + r101 + ", args: " + r102);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Landroidx/window/core/ConsumerAdapter$Subscription;", "", "dispose", "", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Subscription {
        void dispose();
    }

    private final Class<?> unsafeConsumerClass() {
        return INVOKEVIRTUAL_androidx_window_core_ConsumerAdapter_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(this.loader, "java.util.function.Consumer");
    }

    public final Class<?> consumerClassOrNull$window_release() {
        return unsafeConsumerClass();
    L4:
        return null;
    }

    public ConsumerAdapter(ClassLoader r100) {
        Intrinsics.checkNotNullParameter(r100, "loader");
        this.loader = r100;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKEVIRTUAL_androidx_window_core_ConsumerAdapter_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader r100, String r101) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class<?> r104 = r100.loadClass(r101);     // Catch: Throwable -> L8
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L8
    L7:
        return r104;
    L8:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r101);
    L12:
        throw th;
    L34:
        Class<?> r105 = r100.loadClass(r101);     // Catch: Throwable -> L17
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L17
    L16:
        return r105;
    L17:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r101);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.loadClass(r101);
    }

    private final <T> Object buildConsumer(KClass<T> r100, Function1<? super T, Unit> r101) {
        ConsumerHandler r102 = new ConsumerHandler(r100, r101);
        return Proxy.newProxyInstance(this.loader, new Class[]{unsafeConsumerClass()}, r102);
    }

    public final <T> void addConsumer(Object r100, KClass<T> r101, String r102, Function1<? super T, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        Intrinsics.checkNotNullParameter(r101, "clazz");
        Intrinsics.checkNotNullParameter(r102, "methodName");
        Intrinsics.checkNotNullParameter(r103, "consumer");
        r100.getClass().getMethod(r102, new Class[]{unsafeConsumerClass()}).invoke(r100, new Object[]{buildConsumer(r101, r103)});
    }

    public final <T> Subscription createSubscription(final Object r100, KClass<T> r101, String r102, String r103, Activity r110, Function1<? super T, Unit> r111) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        Intrinsics.checkNotNullParameter(r101, "clazz");
        Intrinsics.checkNotNullParameter(r102, "addMethodName");
        Intrinsics.checkNotNullParameter(r103, "removeMethodName");
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "consumer");
        final Object r104 = buildConsumer(r101, r111);
        r100.getClass().getMethod(r102, new Class[]{Activity.class, unsafeConsumerClass()}).invoke(r100, new Object[]{r110, r104});
        final Method r105 = r100.getClass().getMethod(r103, new Class[]{unsafeConsumerClass()});
        return new AnonymousClass1(r105, r100, r104);
    }
}
