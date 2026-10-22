package com.bytedance.android.livesdk.chatroom.utils;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.core.setting.CoreSettingKeys;
import com.bytedance.android.live.strategy.api.IStrategyService;
import com.bytedance.android.livesdk.config.op;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes8.dex */
public final class j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f114522a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f114523b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f114524c;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f114525a = null;

        static {
            f114525a = new a();
        }

        public a() {
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            int r101 = j1.f114522a;
            j1.f114524c = ((Integer) r100).intValue();
        }
    }

    static {
        f114522a = op.f120922a.getValue().intValue();
        int r100 = CoreSettingKeys.LIVE_FEED_PRELOAD.getValue().a();
        f114523b = r100;
        f114524c = 2;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L16
        IStrategyService r102 = (IStrategyService) jc1.k.f(IStrategyService.class);     // Catch: Throwable -> L16
        Unit r103 = null;
        if (r102 == null) goto L6;
        LiveData r104 = IStrategyService.a.a(r102, "live_preload_more_count", Integer.valueOf(r100), true, 8);     // Catch: Throwable -> L16
    L7:
        if (r104 == null) goto L11;
        Integer r105 = (Integer) r104.getValue();     // Catch: Throwable -> L16
        if (r105 == null) goto L11;
        r100 = r105.intValue();     // Catch: Throwable -> L16
    L11:
        f114524c = r100;     // Catch: Throwable -> L16
        if (r104 == null) goto L14;
        r104.observeForever(a.f114525a);     // Catch: Throwable -> L16
        r103 = Unit.INSTANCE;     // Catch: Throwable -> L16
    L14:
        Object r106 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L16
    L19:
        if (Result.m9452exceptionOrNullimpl(r106) == null) goto L24;
        f114524c = f114523b;
        return;
    L24:
        return;
    L6:
        r104 = null;
    L16:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    }
}
