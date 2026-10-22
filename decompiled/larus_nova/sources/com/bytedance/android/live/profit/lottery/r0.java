package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.message.model.na;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes47.dex */
public final class r0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LotteryIMDataSource f88181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ na f88182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.LongRef f88183c;

    public r0(LotteryIMDataSource r100, na r101, Ref.LongRef r102) {
        this.f88181a = r100;
        this.f88182b = r101;
        this.f88183c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        ALogger.i("HOT_LOTTERY", "time 2 = " + System.currentTimeMillis());
        this.f88181a.b(this.f88182b, this.f88183c.element);
    }
}
