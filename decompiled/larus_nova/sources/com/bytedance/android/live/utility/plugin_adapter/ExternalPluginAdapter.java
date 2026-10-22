package com.bytedance.android.live.utility.plugin_adapter;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0012J\"\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00122\u0006\u0010\u0014\u001a\u00020\u00042\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0012J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R+\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/utility/plugin_adapter/ExternalPluginAdapter;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "classFinders", "Ljava/util/ArrayList;", "Lcom/bytedance/android/live/utility/plugin_adapter/IPluginClassFinder;", "Lkotlin/collections/ArrayList;", "getClassFinders", "()Ljava/util/ArrayList;", "classFinders$delegate", "Lkotlin/Lazy;", "enable", "", "api", "Ljava/lang/Class;", "findClass", "clazz", "registerClassFinder", "", "impl", "live-spi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExternalPluginAdapter {
    public static final ExternalPluginAdapter INSTANCE = null;
    private static final String TAG = null;
    private static final Lazy classFinders$delegate = null;

    private ExternalPluginAdapter() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private final ArrayList<IPluginClassFinder> getClassFinders() {
        return (ArrayList) classFinders$delegate.getValue();
    }

    static {
        INSTANCE = new ExternalPluginAdapter();
        TAG = "ExternalPluginAdapter";
        classFinders$delegate = LazyKt.lazy(ExternalPluginAdapter$classFinders$2.INSTANCE);
    }

    public final String getTAG() {
        return TAG;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_android_live_utility_plugin_adapter_ExternalPluginAdapter_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public final boolean enable(Class<?> r100) {
        boolean r101 = false;
        if (Intrinsics.areEqual(r100, IPluginClassFinder.class) == false) goto L5;
        return false;
    L5:
        Iterator<T> r102 = getClassFinders().iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        Object r103 = r102.next();
        if (((IPluginClassFinder) r103).enable() == false) goto L7;
    L12:
        if (r103 == null) goto L15;
        r101 = true;
    L15:
        return r101;
    L11:
        r103 = null;
        goto L12
    }

    public final void registerClassFinder(IPluginClassFinder r100) {
        Intrinsics.checkNotNullParameter(r100, "impl");
        ArrayList<IPluginClassFinder> r101 = getClassFinders();
        if (r101.contains(r100) == true) goto L6;
        r101.add(r100);
        return;
    }

    public final Class<?> findClass(String r100, Class<?> r101) throws ClassNotFoundException {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        if (Intrinsics.areEqual(r101, IPluginClassFinder.class) == true) goto L5;
        Iterator<T> r102 = getClassFinders().iterator();
    L8:
        if (r102.hasNext() == false) goto L12;
        Object r103 = r102.next();
        if (((IPluginClassFinder) r103).enable() == false) goto L8;
    L13:
        IPluginClassFinder r104 = (IPluginClassFinder) r103;
        if (r104 != null) goto L18;
        return INVOKESTATIC_com_bytedance_android_live_utility_plugin_adapter_ExternalPluginAdapter_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100);
    L18:
        return r104.findClass(r100);
    L12:
        r103 = null;
        goto L13
    L5:
        return INVOKESTATIC_com_bytedance_android_live_utility_plugin_adapter_ExternalPluginAdapter_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Class findClass$default(ExternalPluginAdapter r100, String r101, Class r102, int r103, Object r104) throws ClassNotFoundException {
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        return r100.findClass(r101, r102);
    }
}
