package com.bytedance.android.livesdk.player.newstrategy.pullstream;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.strategy.api.IStrategyService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class k implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f155970a = null;

    public static final class a implements e.a {
        public a() {
        }

        @Override // com.bytedance.android.livesdk.player.newstrategy.pullstream.e.a
        public final e create() {
            return new k();
        }
    }

    public static final class b {
    }

    public k() {
    }

    static {
        f155970a = new a();
    }

    @Override // com.bytedance.android.livesdk.player.newstrategy.pullstream.e
    public final void a(j r100, q r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "result");
        IStrategyService r102 = (IStrategyService) jc1.k.f(IStrategyService.class);
        int r103 = 0;
        if (r102 == null) goto L9;
        LiveData r104 = IStrategyService.a.a(r102, "unify_qos_constraint", 0, true, 8);
        if (r104 == null) goto L9;
        Integer r105 = (Integer) r104.getValue();
        if (r105 == null) goto L9;
        r103 = r105.intValue();
    L9:
        ALogger.i("RtmInterceptor", "intercept: qosConstraint：" + r103);
        r101.f155981c = r103;
    }
}
