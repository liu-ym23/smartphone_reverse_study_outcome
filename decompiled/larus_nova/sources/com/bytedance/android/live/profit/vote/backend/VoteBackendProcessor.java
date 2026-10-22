package com.bytedance.android.live.profit.vote.backend;

import com.bytedance.android.livesdk.revenue.service.room.b;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import vh6.c;

/* JADX INFO: loaded from: classes47.dex */
public final class VoteBackendProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f89194a = 0;

    static {
    }

    public static void a(long r110, final Function1 r111, final Function0 r112, CompositeDisposable r113) {
        Intrinsics.checkNotNullParameter(r111, "onSuccess");
        Intrinsics.checkNotNullParameter(r112, LynxVideoManagerLite.EVENT_ON_ERROR);
        Intrinsics.checkNotNullParameter(r113, "cd");
        b.a.a((b) c.b(b.class), r110, com.bytedance.android.live.profit.vote.transfer.a.class, new VoteBackendProcessor$processWithBackendData$1(r112), null, new VoteBackendProcessor$processWithBackendData$2(r111), null, r113, 40);
    }
}
