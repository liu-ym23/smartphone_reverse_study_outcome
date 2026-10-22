package com.bytedance.android.livesdk.utils;

import android.os.Bundle;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class EnterOptimizeUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f158747a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f158748b = null;

    static {
        f158747a = LazyKt.lazy(EnterOptimizeUtil$enable$2.INSTANCE);
        f158748b = LazyKt.lazy(EnterOptimizeUtil$configV2$2.INSTANCE);
    }

    @JvmStatic
    public static final boolean b() {
        return ((com.bytedance.android.livesdk.config.j6) f158748b.getValue()).b();
    }

    @JvmStatic
    public static final boolean a(Bundle r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "args");
        Intrinsics.checkNotNullParameter(r101, "enterMerge");
        Intrinsics.checkNotNullParameter(r102, "enterType");
        boolean r103 = r100.getBoolean(ILiveRoomPlayFragmentConstant.EXTRA_IS_GAME_LIVE);
        Iterator<T> r104 = ((com.bytedance.android.livesdk.config.j6) f158748b.getValue()).a().iterator();
    L4:
        if (r104.hasNext() == false) goto L15;
        Object r105 = r104.next();
        com.bytedance.android.livesdk.config.n4 r106 = (com.bytedance.android.livesdk.config.n4) r105;
        if (r106.a() == true) goto L8;
    L12:
        boolean r107 = false;
    L13:
        if (r107 == false) goto L4;
    L16:
        if (r105 == null) goto L18;
        boolean r108 = true;
    L20:
        if (b() == false) goto L25;
        if (r103 == false) goto L25;
        if (r108 == false) goto L25;
        ALogger.d("EnterOptimizeUtil", "disable local life backend");
        return false;
    L25:
        return true;
    L18:
        r108 = false;
        goto L20
    L8:
        if (Intrinsics.areEqual(r106.b(), r101) == false) goto L12;
        if (Intrinsics.areEqual(r106.c(), r102) == false) goto L12;
        r107 = true;
        goto L13
    L15:
        r105 = null;
        goto L16
    }
}
