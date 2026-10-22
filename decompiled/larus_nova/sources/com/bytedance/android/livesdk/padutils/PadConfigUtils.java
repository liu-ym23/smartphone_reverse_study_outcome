package com.bytedance.android.livesdk.padutils;

import android.content.Context;
import android.provider.Settings;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import j40.r1;
import jc1.k;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class PadConfigUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f154208a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Boolean f154209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Boolean f154210c;

    @JvmStatic
    public static final boolean a() {
        LocalTestManager.a(new Class[]{wy.a.class});
        IMiddleWareHostContext r100 = (IMiddleWareHostContext) k.f(IMiddleWareHostContext.class);
        if (r100 == null) goto L5;
        String r101 = r100.getDevicePlatform();
    L7:
        return Intrinsics.areEqual("Android_Pad", r101);
    L5:
        r101 = null;
        goto L7
    }

    @JvmStatic
    public static final boolean c() {
        boolean r100 = true;
        LocalTestManager.a(new Class[]{wy.a.class});
        if (f154209b != null) goto L10;
        IMiddleWareHostContext r101 = (IMiddleWareHostContext) k.f(IMiddleWareHostContext.class);
        if (r101 == null) goto L7;
        Boolean r102 = Boolean.FALSE;
        Boolean r103 = (Boolean) r101.getHostABValue("douyin_pad_ui_opt_setting", "pad_ui_adapter", r102, r102);
    L8:
        f154209b = r103;
        String r104 = "get host pad ： " + f154209b;
        Intrinsics.checkNotNullParameter(r104, "msg");
        ALogger.i("PadConfig", r104);
        goto L10
    L7:
        r103 = null;
    L10:
        if (f154210c != null) goto L12;
        f154210c = Boolean.valueOf(r1.f497291a.getValue().booleanValue());
    L12:
        Boolean r105 = f154209b;
        Boolean r106 = Boolean.TRUE;
        if (Intrinsics.areEqual(r105, r106) == true) goto L15;
    L19:
        boolean r107 = false;
    L20:
        if (r107 == false) goto L42;
        b r108 = b.f154215c;
        IMiddlewareHostBusiness r109 = (IMiddlewareHostBusiness) k.f(IMiddlewareHostBusiness.class);
        if (r109 == null) goto L34;
        if (r109.isUserAgreePrivacyPolicy() != true) goto L34;
        if (b.f154213a != null) goto L42;
        Context r110 = s1.getContext();
        if (r110 == null) goto L42;
        a r111 = new a(r110, PadOrientationHelper$enableListener$1.INSTANCE);
        b.f154213a = r111;
        r111.enable();
    L34:
        if (b.f154214b == true) goto L42;
        if (r109 != null) goto L38;
    L40:
        r100 = false;
    L41:
        b.f154214b = r100;
        goto L42
    L38:
        if (r109.addPrivacyAgreeListener(r108) != true) goto L40;
    L42:
        return r107;
    L15:
        if (a() == false) goto L19;
        if ((!Intrinsics.areEqual(f154210c, r106)) == false) goto L19;
        r107 = true;
        goto L20
    }

    static {
        f154208a = LazyKt.lazy(PadConfigUtils$liveDebugSetting$2.INSTANCE);
    }

    @JvmStatic
    public static final boolean b() {
        String r100 = s1.getResources().getConfiguration().toString();
        if (StringsKt.contains$default(r100, "hw-magic-windows", false, 2, null) == false) goto L5;
    L6:
        return true;
    L5:
        if (StringsKt.contains$default(r100, "miui-magic-windows", false, 2, null) == true) goto L6;
        return false;
    }

    @Deprecated(message = "VSPad播放器实验命中时可能不准 VS下使用UIState")
    @JvmStatic
    public static final boolean d() {
        if (c() == false) goto L5;
        return true;
    L5:
        return false;
    }

    @JvmStatic
    public static final boolean e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (Settings.System.getInt(r100.getContentResolver(), "accelerometer_rotation", 0) != 1) goto L6;
        return true;
    L6:
        return false;
    }
}
