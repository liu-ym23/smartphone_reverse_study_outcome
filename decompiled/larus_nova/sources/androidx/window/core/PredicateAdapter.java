package androidx.window.core;

import android.util.Pair;
import androidx.exifinterface.media.ExifInterface;
import com.alipay.sdk.m.p.e;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import el9.a;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClasses;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001:\u0003\u0015\u0016\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JP\u0010\u0005\u001a\u00020\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00070\t2\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\r0\fJ2\u0010\u000e\u001a\u00020\u0001\"\b\b\u0000\u0010\u0006*\u00020\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00060\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\r0\u0010J\u0013\u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0012H\u0000¢\u0006\u0002\b\u0013J\f\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/window/core/PredicateAdapter;", "", "loader", "Ljava/lang/ClassLoader;", "(Ljava/lang/ClassLoader;)V", "buildPairPredicate", ExifInterface.GPS_DIRECTION_TRUE, "U", "firstClazz", "Lkotlin/reflect/KClass;", "secondClazz", "predicate", "Lkotlin/Function2;", "", "buildPredicate", "clazz", "Lkotlin/Function1;", "predicateClassOrNull", "Ljava/lang/Class;", "predicateClassOrNull$window_release", "predicateClassOrThrow", "BaseHandler", "PairPredicateStubHandler", "PredicateStubHandler", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PredicateAdapter {
    private final ClassLoader loader;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\"\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0006J0\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0010\u0010\u000b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\fH\u0096\u0002¢\u0006\u0002\u0010\rJ\u001d\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0011J#\u0010\u0012\u001a\u00020\u000f*\u00020\n2\u0010\u0010\u0013\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\fH\u0004¢\u0006\u0002\u0010\u0014J#\u0010\u0015\u001a\u00020\u000f*\u00020\n2\u0010\u0010\u0013\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\fH\u0004¢\u0006\u0002\u0010\u0014J#\u0010\u0016\u001a\u00020\u000f*\u00020\n2\u0010\u0010\u0013\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\fH\u0004¢\u0006\u0002\u0010\u0014J#\u0010\u0017\u001a\u00020\u000f*\u00020\n2\u0010\u0010\u0013\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\fH\u0004¢\u0006\u0002\u0010\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/window/core/PredicateAdapter$BaseHandler;", ExifInterface.GPS_DIRECTION_TRUE, "", "Ljava/lang/reflect/InvocationHandler;", "clazz", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)V", AbsMethodDelegate.TAG_INVOKE, MapBundleKey.MapObjKey.OBJ_SL_OBJ, e.f25671s, "Ljava/lang/reflect/Method;", "parameters", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "invokeTest", "", "parameter", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "isEquals", "args", "(Ljava/lang/reflect/Method;[Ljava/lang/Object;)Z", "isHashCode", "isTest", "isToString", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static abstract class BaseHandler<T> implements InvocationHandler {
        private final KClass<T> clazz;

        public abstract boolean invokeTest(Object r100, T r101);

        public BaseHandler(KClass<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "clazz");
            this.clazz = r100;
        }

        public final boolean isEquals(Method r100, Object[] r101) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
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

        public final boolean isHashCode(Method r100, Object[] r101) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            if (Intrinsics.areEqual(r100.getName(), "hashCode") == true) goto L5;
        L8:
            return false;
        L5:
            if (r100.getReturnType().equals(Integer.TYPE) == false) goto L8;
            if (r101 != null) goto L8;
            return true;
        }

        public final boolean isTest(Method r100, Object[] r101) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            if (Intrinsics.areEqual(r100.getName(), EffectConstants.CHANNEL_TEST) == true) goto L5;
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

        public final boolean isToString(Method r100, Object[] r101) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
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
            if (isTest(r101, r102) == false) goto L9;
            KClass<T> r105 = this.clazz;
            if (r102 == null) goto L25;
            r103 = r102[0];
        L25:
            return Boolean.valueOf(invokeTest(r100, KClasses.cast(r105, r103)));
        L9:
            if (isEquals(r101, r102) == false) goto L17;
            if (r102 == null) goto L12;
            r103 = r102[0];
        L12:
            Intrinsics.checkNotNull(r103);
            if (r100 != r103) goto L26;
            r104 = true;
        L26:
            return Boolean.valueOf(r104);
        L17:
            if (isHashCode(r101, r102) == false) goto L20;
            return Integer.valueOf(hashCode());
        L20:
            if (isToString(r101, r102) == false) goto L24;
            return toString();
        L24:
            throw new UnsupportedOperationException("Unexpected method call object:" + r100 + ", method: " + r101 + ", args: " + r102);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00050\u0004B;\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00022\u000e\u0010\u0011\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/window/core/PredicateAdapter$PairPredicateStubHandler;", ExifInterface.GPS_DIRECTION_TRUE, "", "U", "Landroidx/window/core/PredicateAdapter$BaseHandler;", "Landroid/util/Pair;", "clazzT", "Lkotlin/reflect/KClass;", "clazzU", "predicate", "Lkotlin/Function2;", "", "(Lkotlin/reflect/KClass;Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function2;)V", "hashCode", "", "invokeTest", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "parameter", "toString", "", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class PairPredicateStubHandler<T, U> extends BaseHandler<Pair<?, ?>> {
        private final KClass<T> clazzT;
        private final KClass<U> clazzU;
        private final Function2<T, U, Boolean> predicate;

        public int hashCode() {
            return this.predicate.hashCode();
        }

        public String toString() {
            return this.predicate.toString();
        }

        /* JADX INFO: renamed from: invokeTest, reason: avoid collision after fix types in other method */
        public boolean invokeTest2(Object r100, Pair<?, ?> r101) {
            Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
            Intrinsics.checkNotNullParameter(r101, "parameter");
            Object r102 = KClasses.cast(this.clazzT, r101.first);
            Object r103 = KClasses.cast(this.clazzU, r101.second);
            return this.predicate.invoke((T) r102, (U) r103).booleanValue();
        }

        @Override // androidx.window.core.PredicateAdapter.BaseHandler
        public /* bridge */ /* synthetic */ boolean invokeTest(Object r100, Pair<?, ?> r101) {
            return invokeTest2(r100, r101);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public PairPredicateStubHandler(KClass<T> r100, KClass<U> r101, Function2<? super T, ? super U, Boolean> r102) {
            Intrinsics.checkNotNullParameter(r100, "clazzT");
            Intrinsics.checkNotNullParameter(r101, "clazzU");
            Intrinsics.checkNotNullParameter(r102, "predicate");
            super(Reflection.getOrCreateKotlinClass(Pair.class));
            this.clazzT = r100;
            this.clazzU = r101;
            this.predicate = r102;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B'\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\u001d\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/window/core/PredicateAdapter$PredicateStubHandler;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/window/core/PredicateAdapter$BaseHandler;", "clazzT", "Lkotlin/reflect/KClass;", "predicate", "Lkotlin/Function1;", "", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function1;)V", "hashCode", "", "invokeTest", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "parameter", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "toString", "", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class PredicateStubHandler<T> extends BaseHandler<T> {
        private final Function1<T, Boolean> predicate;

        public int hashCode() {
            return this.predicate.hashCode();
        }

        public String toString() {
            return this.predicate.toString();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public PredicateStubHandler(KClass<T> r100, Function1<? super T, Boolean> r101) {
            Intrinsics.checkNotNullParameter(r100, "clazzT");
            Intrinsics.checkNotNullParameter(r101, "predicate");
            super(r100);
            this.predicate = r101;
        }

        @Override // androidx.window.core.PredicateAdapter.BaseHandler
        public boolean invokeTest(Object r100, T r101) {
            Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
            Intrinsics.checkNotNullParameter(r101, "parameter");
            return this.predicate.invoke(r101).booleanValue();
        }
    }

    private final Class<?> predicateClassOrThrow() {
        return INVOKEVIRTUAL_androidx_window_core_PredicateAdapter_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(this.loader, "java.util.function.Predicate");
    }

    public final Class<?> predicateClassOrNull$window_release() {
        return predicateClassOrThrow();
    L4:
        return null;
    }

    public PredicateAdapter(ClassLoader r100) {
        Intrinsics.checkNotNullParameter(r100, "loader");
        this.loader = r100;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKEVIRTUAL_androidx_window_core_PredicateAdapter_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader r100, String r101) throws ClassNotFoundException {
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

    public final <T> Object buildPredicate(KClass<T> r100, Function1<? super T, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "predicate");
        PredicateStubHandler r102 = new PredicateStubHandler(r100, r101);
        return Proxy.newProxyInstance(this.loader, new Class[]{predicateClassOrThrow()}, r102);
    }

    public final <T, U> Object buildPairPredicate(KClass<T> r100, KClass<U> r101, Function2<? super T, ? super U, Boolean> r102) {
        Intrinsics.checkNotNullParameter(r100, "firstClazz");
        Intrinsics.checkNotNullParameter(r101, "secondClazz");
        Intrinsics.checkNotNullParameter(r102, "predicate");
        PairPredicateStubHandler r103 = new PairPredicateStubHandler(r100, r101, r102);
        return Proxy.newProxyInstance(this.loader, new Class[]{predicateClassOrThrow()}, r103);
    }
}
