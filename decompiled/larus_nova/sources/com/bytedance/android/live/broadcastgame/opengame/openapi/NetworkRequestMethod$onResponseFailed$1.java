package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.concurrent.TimeoutException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class NetworkRequestMethod$onResponseFailed$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Throwable $t;
    final /* synthetic */ NetworkRequestMethod this$0;

    public NetworkRequestMethod$onResponseFailed$1(NetworkRequestMethod r100, Throwable r101) {
        this.this$0 = r100;
        this.$t = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Throwable r100 = this.$t;
        if ((r100 instanceof TimeoutException) == false) goto L5;
        NetworkRequestMethod r101 = this.this$0;
        OpenApiErrorInfo r102 = OpenApiErrorInfo.NET_REQUEST_TIMEOUT;
        int r103 = BaseOpenMethod.f60302g;
        r101.n(r102, null);
        return;
    L5:
        this.this$0.n(OpenApiErrorInfo.NETWORK_ERROR, r100);
        ALogger.d("NetworkRequestMethod", this.$t.toString());
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
