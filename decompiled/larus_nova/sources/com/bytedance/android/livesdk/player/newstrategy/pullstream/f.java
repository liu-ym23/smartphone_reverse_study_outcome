package com.bytedance.android.livesdk.player.newstrategy.pullstream;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.strategy.api.IStrategyService;
import com.bytedance.android.livesdkapi.model.P2PSuggestInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class f implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f155959a = null;

    public static final class a implements e.a {
        public a() {
        }

        @Override // com.bytedance.android.livesdk.player.newstrategy.pullstream.e.a
        public final e create() {
            return new f();
        }
    }

    public static final class b {
    }

    public f() {
    }

    static {
        f155959a = new a();
    }

    @Override // com.bytedance.android.livesdk.player.newstrategy.pullstream.e
    public final void a(j r100, q r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "result");
        IStrategyService r102 = (IStrategyService) jc1.k.f(IStrategyService.class);
        Integer r103 = 0;
        if (r102 == null) goto L10;
        LiveData r104 = IStrategyService.a.a(r102, "p2p_suggest_strategy", r103, false, 8);
        if (r104 == null) goto L10;
        Integer r105 = (Integer) r104.getValue();
        if (r105 == null) goto L10;
        r103 = r105;
    L10:
        r101.f155987i = new P2PSuggestInfo(-1, r103.intValue());
    }
}
