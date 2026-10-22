package com.bytedance.android.live.revenue.platform.hybrid.impl.ui;

import android.view.View;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.revenue.platform.container.impl.d0;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.lynx.tasm.LynxView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes47.dex */
public final class e extends BaseHybridComponentContainer<HybridCard> implements zy0.b {
    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class e() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("m.l.lynx.svs.svsimpl.LynxSoLibLoader");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("m.l.lynx.svs.svsimpl.LynxSoLibLoader");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("m.l.lynx.svs.svsimpl.LynxSoLibLoader");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("m.l.lynx.svs.svsimpl.LynxSoLibLoader");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("m.l.lynx.svs.svsimpl.LynxSoLibLoader");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("m.l.lynx.svs.svsimpl.LynxSoLibLoader");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("m.l.lynx.svs.svsimpl.LynxSoLibLoader");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // zy0.b
    public final View c() {
        return (View) this.f91463d;
    }

    @Override // com.bytedance.android.live.revenue.common.j
    public final void d() {
        ((ArrayList) this.f91462c).clear();
        ((HybridCard) this.f91463d).release();
    }

    @Override // zy0.b
    public final void x() {
        HybridCard r100 = (HybridCard) this.f91463d;
        if (r100 == null) goto L26;
        View r101 = r100.getHybridView();
        if (r101 == null) goto L27;
    L19:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        Unit r102 = Unit.INSTANCE;
        return;
    L7:
        if ((r101 instanceof LynxView) == true) goto L9;
        return;
    L9:
        Class<?> r103 = e();     // Catch: Exception -> L19
        Method[] r104 = r103.getDeclaredMethods();     // Catch: Exception -> L19
        int r105 = r104.length;     // Catch: Exception -> L19
        int r106 = 0;
    L10:
        if (r106 >= r105) goto L15;
        Method r107 = r104[r106];     // Catch: Exception -> L19
        if (Intrinsics.areEqual(r107.getName(), "onLynxViewCreated") == true) goto L16;
        r106 = r106 + 1;     // Catch: Exception -> L19
    L16:
        if (r107 == null) goto L28;
        r107.invoke(Reflect.on(r103).field("INSTANCE", new Class[]{r103}).get(), new Object[]{r101});     // Catch: Exception -> L19
        return;
    L28:
        return;
    L15:
        r107 = null;
        goto L16
    L27:
        return;
    }

    public e(HybridCard r100, bz0.d r101) {
        Intrinsics.checkNotNullParameter(r100, "originalCard");
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        super(r100, r101);
    }

    @Override // uh6.a
    public final void b(String r100, d0 r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
        xy0.a<?> r102 = g();
        if (r102 == null) goto L6;
        com.bytedance.android.live.revenue.platform.hybrid.impl.component.d r103 = (com.bytedance.android.live.revenue.platform.hybrid.impl.component.d) r102;
        r103.registerMethod(r100, new d(r101));
        return;
    }

    @Override // uh6.a
    public final void sendJsEvent(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "data");
        xy0.a<?> r102 = g();
        if (r102 == null) goto L6;
        ((com.bytedance.android.live.revenue.platform.hybrid.impl.component.b) r102).sendJsEvent(r100, r101);
        return;
    }
}
