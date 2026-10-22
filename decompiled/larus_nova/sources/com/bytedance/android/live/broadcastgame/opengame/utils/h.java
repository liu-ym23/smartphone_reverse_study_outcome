package com.bytedance.android.live.broadcastgame.opengame.utils;

import android.graphics.Bitmap;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.bdp.serviceapi.hostimpl.hostmethod.BdpInteractHostMethodService;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f61158a = 0;

    public interface a {
        void onFail();

        void onSuccess(Bitmap r100);
    }

    static {
    }

    public static void a(String r100, int r101, int r102, final PluginContext.b r103) {
        Intrinsics.checkNotNullParameter(r100, "appid");
        Intrinsics.checkNotNullParameter(r103, "processorListener");
        BdpInteractHostMethodService r104 = com.bytedance.bdp.live.livecontainer.sonicgame.f.f201520a;
        new ImageUtils$getBlurBackground$1(r103);
        Function1<Throwable, Unit> r105 = new ImageUtils$getBlurBackground$2(r103);
        BdpInteractHostMethodService r106 = com.bytedance.bdp.live.livecontainer.sonicgame.f.f201520a;
        if (r106 != null) goto L5;
        r105.invoke(new IllegalStateException("BdpInteractHostMethodService is null"));
        return;
    L5:
        r106.p();
    }
}
