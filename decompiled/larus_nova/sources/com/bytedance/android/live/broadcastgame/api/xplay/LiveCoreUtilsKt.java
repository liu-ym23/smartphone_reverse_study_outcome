package com.bytedance.android.live.broadcastgame.api.xplay;

import android.util.Log;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;

/* JADX INFO: loaded from: classes45.dex */
public final class LiveCoreUtilsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f59435a = null;

    static {
        f59435a = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, LiveCoreUtilsKt$gson$2.INSTANCE);
    }

    public static final void a(d0 r100, i r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$collectSdkParams");
        Intrinsics.checkNotNullParameter(r101, Argument.OUT);
        d0.a r102 = r100.getBuilder();
        if (r102 == null) goto L6;
        r101.k(Integer.valueOf(r102.getVideoWidth()));
        r101.h(Integer.valueOf(r102.getVideoHeight()));
        r101.j(Integer.valueOf(r102.n()));
        r101.i(Integer.valueOf(r102.u0()));
        r102.D();
        r101.f(null);
        r101.g(Integer.valueOf(r102.n()));
        r101.e(Integer.valueOf(r102.u0()));
        ALogger.i("XplayLiveCoreUtils", "collectSdkParams: " + r101 + ", stack = " + Log.getStackTraceString(new Exception()));
        return;
    }

    public static final void b(d0 r100, i r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$updateSdkParams");
        Intrinsics.checkNotNullParameter(r101, "params");
        JsonObject r102 = new JsonObject();
        Lazy r103 = f59435a;
        r102.add("PushBase", GsonProtectorUtils.toJsonTree((Gson) r103.getValue(), r101));
        GsonProtectorUtils.toJson((Gson) r103.getValue(), r102);
        r100.A();
    }
}
