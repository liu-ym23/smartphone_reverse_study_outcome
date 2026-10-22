package com.bytedance.android.livesdk.feedback.service;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.feedback.utils.FeedbackMonitor;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f124861a = null;

    static {
        f124861a = new g();
    }

    public g() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        ALogger.e("RoomLightFeedbackConfig", "获取问卷失败" + r101.getMessage(), r101);
        int r102 = FeedbackMonitor.f124865a;
        FeedbackMonitor.Monitor r103 = new FeedbackMonitor.Monitor();
        Intrinsics.checkNotNullParameter("RoomLightFeedbackConfig", "page");
        r103.f124866a = "RoomLightFeedbackConfig";
        r103.c("获取问卷数据失败");
        r103.b(new Pair[]{TuplesKt.to("error", r101.getMessage())});
        r103.d();
        if (v.a() == true) goto L5;
        return;
    L5:
        throw r101;
    }
}
