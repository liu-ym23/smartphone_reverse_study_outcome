package com.bytedance.android.live.liveinteract.jsbridge.method;

import android.app.Application;
import android.content.Context;
import com.bytedance.android.live.browser.jsbridge.base.LinkminkToolsCommonResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import w20.fa;
import w20.g2;

/* JADX INFO: loaded from: classes46.dex */
@XBridgeMethod(biz = "webcast", name = "linkminkToolsCommon")
public final class b0 extends g2<fa, LinkminkToolsCommonResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f74199a = null;

    public static final class a {
        public a() {
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class a() throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class<?> r102 = Class.forName("com.bytedance.android.livesdk.debugtools.floatwindow.DebugToolInstance");     // Catch: Throwable -> L8
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a("com.bytedance.android.livesdk.debugtools.floatwindow.DebugToolInstance");     // Catch: Throwable -> L8
        L7:
            return r102;
        L8:
            th = move-exception;
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b("com.bytedance.android.livesdk.debugtools.floatwindow.DebugToolInstance");
        L12:
            throw th;
        L34:
            Class<?> r103 = Class.forName("com.bytedance.android.livesdk.debugtools.floatwindow.DebugToolInstance");     // Catch: Throwable -> L17
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a("com.bytedance.android.livesdk.debugtools.floatwindow.DebugToolInstance");     // Catch: Throwable -> L17
        L16:
            return r103;
        L17:
            th = move-exception;
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b("com.bytedance.android.livesdk.debugtools.floatwindow.DebugToolInstance");
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName("com.bytedance.android.livesdk.debugtools.floatwindow.DebugToolInstance");
        }

        public static void b(Context r100, String r101) {
            Class r102 = a();     // Catch: Throwable -> L12
            Object r103 = null;
            Object r104 = r102.getDeclaredField("INSTANCE").get(null);     // Catch: Throwable -> L12
            Iterator r105 = ArraysKt.asList(r102.getDeclaredMethods()).iterator();     // Catch: Throwable -> L12
        L4:
            if (r105.hasNext() == false) goto L8;
            Object r106 = r105.next();     // Catch: Throwable -> L12
            if (Intrinsics.areEqual(((Method) r106).getName(), r101) == false) goto L4;
            r103 = r106;
        L8:
            Method r107 = (Method) r103;     // Catch: Throwable -> L12
            if (r107 == null) goto L20;
            r107.invoke(r104, new Object[]{r100});     // Catch: Throwable -> L12
            return;
        L20:
            return;
        L12:
            th = move-exception;
            ALogger.d("DebugToolInstance", r101 + " error: " + th);
        }
    }

    static {
        f74199a = new a();
    }

    public b0() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        fa r102 = (fa) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        fa.a r103 = r102.a();
        if (r103 == null) goto L5;
        Boolean r104 = r103.a();
    L6:
        Boolean r105 = Boolean.TRUE;
        if (Intrinsics.areEqual(r104, r105) == false) goto L13;
        a r106 = f74199a;
        Application r107 = jc1.a.b();
        r106.getClass();
        Intrinsics.checkNotNullParameter(r107, PerfLog.PARAM_KEY_CONTEXT_ID);
        a.b(r107, "init");
        Context r108 = com.bytedance.android.live.core.utils.a.d();
        if (r108 != null) goto L12;
        r108 = r101.getContext();
    L12:
        r106.getClass();
        Intrinsics.checkNotNullParameter(r108, PerfLog.PARAM_KEY_CONTEXT_ID);
        a.b(r108, "show");
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r109 = b6.H;
        r109.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r109, r105);
        return;
    L13:
        a r110 = f74199a;
        Context r111 = r101.getContext();
        r110.getClass();
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        a.b(r111, "hide");
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r112 = b6.H;
        Boolean r113 = Boolean.FALSE;
        r112.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r112, r113);
        return;
    L5:
        r104 = null;
        goto L6
    }
}
