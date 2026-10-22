package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.broadcastgame.opengame.cloud.CloudResultType$ClientResultType;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "resultType", "Lcom/bytedance/android/live/broadcastgame/opengame/cloud/CloudResultType$ClientResultType;", "errMsg", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class UserLoginMethod$callLogin$2 extends Lambda implements Function2<CloudResultType$ClientResultType, String, Unit> {
    final /* synthetic */ i1 this$0;

    public UserLoginMethod$callLogin$2(i1 r100) {
        this.this$0 = r100;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(CloudResultType$ClientResultType r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "resultType");
        Intrinsics.checkNotNullParameter(r101, "errMsg");
        ALogger.i("UserLoginMethod_callLogin", "login fail: resultType=" + r100 + ", errMsg=" + r101);
        int r102 = j1.f60501a[r100.ordinal()];
        if (r102 != 1) goto L5;
        i1 r103 = this.this$0;
        OpenApiErrorInfo r104 = OpenApiErrorInfo.NET_REQUEST_TIMEOUT;
        int r105 = BaseOpenMethod.f60302g;
        r103.n(r104, null);
        return;
    L5:
        if (r102 != 2) goto L7;
        i1 r106 = this.this$0;
        OpenApiErrorInfo r107 = OpenApiErrorInfo.NETWORK_ERROR;
        int r108 = BaseOpenMethod.f60302g;
        r106.n(r107, null);
        return;
    L7:
        if (r102 != 3) goto L9;
    L11:
        BaseOpenMethod.p(this.this$0, r100.getErrNo(), r101, null, 12);
        return;
    L9:
        if (r102 == 4) goto L11;
        i1 r109 = this.this$0;
        OpenApiErrorInfo r110 = OpenApiErrorInfo.INTERNAL_ERROR;
        int r111 = BaseOpenMethod.f60302g;
        r109.n(r110, null);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(CloudResultType$ClientResultType r100, String r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
