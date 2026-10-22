package com.bytedance.android.live.room.util;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class AudienceInflateUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f100380a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f100381b = null;

    static {
        f100380a = LazyKt.lazy(AudienceInflateUtil$nitaInflaterEnabled$2.INSTANCE);
        f100381b = LazyKt.lazy(AudienceInflateUtil$hostBusiness$2.INSTANCE);
    }

    @JvmStatic
    public static final View a(AudienceViewInfo r100, Activity r101, ViewGroup r102) {
        Intrinsics.checkNotNullParameter("AudienceView", "logTag");
        Intrinsics.checkNotNullParameter(r100, "nitaViewInfo");
        Intrinsics.checkNotNullParameter(r101, "activity");
        return b("AudienceView", r100.getResId(), r100.getTag(), r101, r102, false, null);
    }

    @JvmStatic
    public static final View b(String r110, int r111, String r112, Activity r113, ViewGroup r114, boolean r115, LayoutInflater r116) {
        Intrinsics.checkNotNullParameter(r110, "logTag");
        Intrinsics.checkNotNullParameter(r112, "nitaTag");
        Intrinsics.checkNotNullParameter(r113, "activity");
        long r100 = System.currentTimeMillis();
        Lazy r101 = f100381b;
        if (((IMiddlewareHostBusiness) r101.getValue()) != null) goto L5;
    L13:
        ALogger.w(r110, "hostBusiness is null or nitaInflaterEnabled is closed or activity is not LivePlayActivity");
        if (r116 == null) goto L19;
        View r102 = r116.inflate(r111, r114, r115);
        if (r102 == null) goto L19;
        View r103 = r102;
    L20:
        ALogger.i(r110, "NitaInflate: enabled: " + ((Boolean) f100380a.getValue()).booleanValue() + ", duration: " + (System.currentTimeMillis() - r100) + "ms");
        return r103;
    L19:
        r103 = LayoutInflater.from(r113).inflate(r111, r114, r115);
        goto L20
    L5:
        if (((Boolean) f100380a.getValue()).booleanValue() == false) goto L13;
        if (Intrinsics.areEqual(r113.getClass().getCanonicalName(), "com.ss.android.ugc.aweme.live.LivePlayActivity") == false) goto L9;
    L12:
        IMiddlewareHostBusiness r104 = (IMiddlewareHostBusiness) r101.getValue();
        Intrinsics.checkNotNull(r104);
        r103 = r104.tryGetPreLoadLiveLayouts(r111, r112, r113, r114, Boolean.valueOf(r115), Boolean.TRUE, r116);
        goto L20
    L9:
        if (Intrinsics.areEqual(r113.getClass().getCanonicalName(), "com.ss.android.ugc.aweme.live.LivePlayActivityV2") == true) goto L12;
        if (Intrinsics.areEqual(r113.getClass().getCanonicalName(), "com.ss.android.ugc.aweme.live.multitask.LivePlayShadowActivity") == false) goto L13;
        goto L12
    }
}
