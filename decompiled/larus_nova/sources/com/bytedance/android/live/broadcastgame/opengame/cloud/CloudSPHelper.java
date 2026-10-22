package com.bytedance.android.live.broadcastgame.opengame.cloud;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ies.utility.SharedPrefHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class CloudSPHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f59807a = null;

    static {
        f59807a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, CloudSPHelper$sidHelper$2.INSTANCE);
    }

    public static String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        String r101 = new JSONObject(((SharedPrefHelper) f59807a.getValue()).j(r100, new JSONObject().toString())).optString(WsConstants.KEY_SESSION_ID);
        ALogger.d("CloudSPHelper_getSid", "appId:" + r100 + ", sid:" + r101);
        return r101;
    }

    public static long b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        long r101 = new JSONObject(((SharedPrefHelper) f59807a.getValue()).j(r100, new JSONObject().toString())).optLong("expiredTime", -1);
        ALogger.d("CloudSPHelper_getSidExpiredTime", "appId:" + r100 + ", expiredTime:" + r101);
        return r101;
    }

    public static boolean c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        boolean r101 = ((SharedPrefHelper) f59807a.getValue()).f249252a.contains(r100);
        ALogger.d("CloudSPHelper_sidExist", "appId:" + r100 + ", exist:" + r101);
        return r101;
    }
}
