package com.bytedance.android.livesdk.utils;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livesdk.preinflate.LiveNitaViewInfo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class LiveInflateUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f158750a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f158751b = null;

    static {
        f158750a = LazyKt.lazy(LiveInflateUtil$nitaInflaterEnabled$2.INSTANCE);
        f158751b = LazyKt.lazy(LiveInflateUtil$hostBusiness$2.INSTANCE);
    }

    @JvmStatic
    public static final View b(String r100, LiveNitaViewInfo r101, Activity r102, ViewGroup r103) {
        Intrinsics.checkNotNullParameter(r100, "logTag");
        Intrinsics.checkNotNullParameter(r101, "nitaViewInfo");
        Intrinsics.checkNotNullParameter(r102, "activity");
        return a(r100, r101.getResId(), r101.getTag(), r102, r103, null);
    }

    @JvmStatic
    public static final View a(String r110, int r111, String r112, Activity r113, ViewGroup r114, LayoutInflater r115) {
        Intrinsics.checkNotNullParameter(r110, "logTag");
        Intrinsics.checkNotNullParameter(r112, "nitaTag");
        Intrinsics.checkNotNullParameter(r113, "activity");
        long r100 = System.currentTimeMillis();
        Lazy r101 = f158751b;
        if (((IHostBusiness) r101.getValue()) != null) goto L5;
    L13:
        ALogger.w(r110, "hostBusiness is null or nitaInflaterEnabled is closed or activity is not LivePlayActivity");
        if (r115 == null) goto L19;
        View r102 = r115.inflate(r111, r114, false);
        if (r102 == null) goto L19;
        View r103 = r102;
    L20:
        ALogger.i(r110, "NitaInflate: enabled: " + ((Boolean) f158750a.getValue()).booleanValue() + ", duration: " + (System.currentTimeMillis() - r100) + "ms");
        return r103;
    L19:
        r103 = LayoutInflater.from(r113).inflate(r111, r114, false);
        goto L20
    L5:
        if (((Boolean) f158750a.getValue()).booleanValue() == false) goto L13;
        if (Intrinsics.areEqual(r113.getClass().getCanonicalName(), "com.ss.android.ugc.aweme.live.LivePlayActivity") == false) goto L9;
    L12:
        IHostBusiness r104 = (IHostBusiness) r101.getValue();
        Intrinsics.checkNotNull(r104);
        r103 = r104.tryGetPreLoadLiveLayouts(r111, r112, r113, r114, Boolean.FALSE, Boolean.TRUE, r115);
        goto L20
    L9:
        if (Intrinsics.areEqual(r113.getClass().getCanonicalName(), "com.ss.android.ugc.aweme.live.LivePlayActivityV2") == true) goto L12;
        if (Intrinsics.areEqual(r113.getClass().getCanonicalName(), "com.ss.android.ugc.aweme.live.multitask.LivePlayShadowActivity") == false) goto L13;
        goto L12
    }
}
