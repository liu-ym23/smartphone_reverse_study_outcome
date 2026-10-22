package com.bytedance.android.live.core.utils;

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

/* JADX INFO: loaded from: classes45.dex */
public final class NitaInflateUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f66074a = null;

    static {
        f66074a = LazyKt.lazy(NitaInflateUtil$hostBusiness$2.INSTANCE);
    }

    @JvmStatic
    public static final View a(int r110, String r111, Activity r112, ViewGroup r113, boolean r210) {
        Intrinsics.checkNotNullParameter(r111, "nitaTag");
        Intrinsics.checkNotNullParameter(r112, "activity");
        long r114 = System.currentTimeMillis();
        ALogger.i("VSNitaInflate", r111 + " start to get view");
        Lazy r100 = f66074a;
        if (((IMiddlewareHostBusiness) r100.getValue()) != null) goto L5;
    L13:
        ALogger.w("VSNitaInflate", r111 + "  hostBusiness is null or nitaTag is empty.");
        View r101 = LayoutInflater.from(r112).inflate(r110, r113, r210);
    L14:
        if (r101 != null) goto L16;
        r101 = LayoutInflater.from(r112).inflate(r110, r113, r210);
    L16:
        ALogger.i("VSNitaInflate", r111 + " get view duration: " + (System.currentTimeMillis() - r114) + "ms");
        return r101;
    L5:
        if (r111.length() <= 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == false) goto L13;
        IMiddlewareHostBusiness r103 = (IMiddlewareHostBusiness) r100.getValue();
        if (r103 == null) goto L12;
        r101 = r103.tryGetPreLoadLiveLayouts(r110, r111, r112, r113, Boolean.valueOf(r210), Boolean.FALSE, null);
        goto L14
    L12:
        r101 = null;
        goto L14
    L7:
        r102 = false;
        goto L8
    }
}
