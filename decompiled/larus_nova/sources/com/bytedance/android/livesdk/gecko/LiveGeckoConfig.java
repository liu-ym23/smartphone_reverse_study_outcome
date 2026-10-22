package com.bytedance.android.livesdk.gecko;

import android.app.Application;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.z5;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes8.dex */
public final class LiveGeckoConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f125784a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f125785b;

    static {
        f125784a = LazyKt.lazy(LiveGeckoConfig$geckoConfigGetOpt$2.INSTANCE);
        f125785b = "";
    }

    @JvmStatic
    public static final String b() {
        if (z5.f65472a.getValue().booleanValue() == false) goto L6;
        return "5fb33cde3ebff01c8433ddc22aac0816";
    L6:
        if (((IMiddleWareHostContext) jc1.k.n(IMiddleWareHostContext.class)).isBoe() == false) goto L9;
        return "68f927652a5370ec9f4ae1dbaf56fd85";
    L9:
        if (v.a() == false) goto L13;
        return "36723dc3e85a23e701d1697d57de07ed";
    L13:
        return "5fb33cde3ebff01c8433ddc22aac0816";
    }

    @JvmStatic
    public static final String c() {
        if (((Boolean) f125784a.getValue()).booleanValue() == false) goto L18;
        String r100 = f125785b;
        boolean r101 = false;
        if (r100 != null) goto L7;
    L12:
        if (r101 == true) goto L15;
        r100 = null;
    L15:
        if (r100 != null) goto L20;
        String r102 = a();
        f125785b = r102;
        return r102;
    L20:
        return r100;
    L7:
        if (r100.length() <= 0) goto L9;
        boolean r103 = true;
    L10:
        if (r103 != true) goto L12;
        r101 = true;
        goto L12
    L9:
        r103 = false;
        goto L10
    L18:
        String r104 = a();
        ALogger.d("LiveGeckoConfig", "geckox save path: " + r104);
        return r104;
    }

    public static String a() {
        Application r100 = jc1.a.b();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getFilesDir().getAbsolutePath() + "/offlineX";
    }
}
