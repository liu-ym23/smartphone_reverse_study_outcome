package com.bytedance.android.gamecp.business.download.ai;

import android.os.SystemClock;
import com.bytedance.android.gamecp.business.AiPushLimitManager;
import com.bytedance.common.utility.Logger;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import wu.f2;

/* JADX INFO: loaded from: classes44.dex */
public final class AiPushPredictor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f52454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f52455b = 0;

    public static final class a implements nv.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function2 f52456a;

        public a(Function2 r100) {
            this.f52456a = r100;
        }
    }

    static {
    }

    public static void a(int r100, JSONObject r101, Function2 r110) {
        Logger.i("game-promote", "触发端智能进行预测");
        int r102 = AiPushPredictorMonitor.f52457a;
        AiPushPredictorMonitor.a(r100, AiPushPredictorMonitor.Status.PREDICT, null, null, null, null, 60);
        com.bytedance.android.gamecp.host_api.a.b().getAiService().g1(r101, new a(r110));
    }

    public static void b(int r100, JSONObject r101, Function2 r102) {
        Intrinsics.checkNotNullParameter(r102, "onResult");
        yr.c.e("push_calculate_trigger_predict", "triggerInstallPushPredict sense =" + r100 + " params =" + r101);
        if (r101 != null) goto L6;
        yr.c.e("push_calculate_trigger_predict", "params is null.");
        int r103 = AiPushPredictorMonitor.f52457a;
        AiPushPredictorMonitor.a(r100, AiPushPredictorMonitor.Status.FAIL, "params_empty", null, null, null, 56);
        return;
    L6:
        long r104 = SystemClock.elapsedRealtime() - f52454a;
        if (r104 >= ((f2.f561308a.getValue().j() * 60) * 1000)) goto L10;
        yr.c.e("push_calculate_trigger_predict", "push:召回预测失败,上次预测距今才" + r104 + " 毫秒");
        int r105 = AiPushPredictorMonitor.f52457a;
        AiPushPredictorMonitor.a(r100, AiPushPredictorMonitor.Status.FAIL, "too_fast_frequency_to_trigger", null, null, null, 56);
        return;
    L10:
        f52454a = SystemClock.elapsedRealtime();
        if (AiPushLimitManager.b(r100) == true) goto L14;
        yr.c.e("push_calculate_trigger_predict", "passive sense =" + r100 + " exceeded the limit");
        return;
    L14:
        com.bytedance.android.gamecp.host_api.a.b().getHostBusiness().isEnablePersonalRecommend();
        a(r100, r101, r102);
    }
}
