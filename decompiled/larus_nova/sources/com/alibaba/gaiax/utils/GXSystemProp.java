package com.alibaba.gaiax.utils;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import el9.a;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0086\u0002J\b\u0010\f\u001a\u00020\rH\u0003J\u0019\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0086\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/alibaba/gaiax/utils/GXSystemProp;", "", "()V", "classType", "Ljava/lang/Class;", "getMethod", "Ljava/lang/reflect/Method;", "setMethod", MonitorConstants.CONNECT_TYPE_GET, "", "key", "value", "init", "", "set", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXSystemProp {
    public static final GXSystemProp INSTANCE = null;
    private static Class<?> classType;
    private static Method getMethod;
    private static Method setMethod;

    static {
        INSTANCE = new GXSystemProp();
    }

    private GXSystemProp() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private final void init() {
    L13:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (classType != null) goto L18;
        Class<?> r100 = INVOKESTATIC_com_alibaba_gaiax_utils_GXSystemProp_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties");     // Catch: Exception -> L13
        classType = r100;     // Catch: Exception -> L13
        Method r101 = null;
        if (r100 == null) goto L7;
        Method r102 = r100.getDeclaredMethod("set", new Class[]{String.class, String.class});     // Catch: Exception -> L13
    L8:
        setMethod = r102;     // Catch: Exception -> L13
        Class<?> r103 = classType;     // Catch: Exception -> L13
        if (r103 == null) goto L11;
        r101 = r103.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class});     // Catch: Exception -> L13
    L11:
        getMethod = r101;     // Catch: Exception -> L13
        return;
    L7:
        r102 = null;
        goto L8
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_alibaba_gaiax_utils_GXSystemProp_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public final String get(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        init();
        Method r102 = getMethod;     // Catch: Exception -> L12
        if (r102 == null) goto L6;
        Object r103 = r102.invoke(classType, new Object[]{r100, r101});     // Catch: Exception -> L12
    L8:
        if ((r103 instanceof String) == false) goto L18;
        return (String) r103;
    L18:
        return null;
    L6:
        r103 = null;
    L12:
        e = move-exception;
        e.printStackTrace();
        return r101;
    }

    public final void set(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        init();
        Method r102 = setMethod;     // Catch: Exception -> L7
        if (r102 == null) goto L12;
        r102.invoke(classType, new Object[]{r100, r101});     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }
}
