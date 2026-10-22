package com.bytedance.android.livesdk.livecommerce.hybrid.bridges;

import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.FlashController;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "filePath", "", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final class ECAnchorFlashScreenShot$handle$1 extends Lambda implements Function2<String, String, Unit> {
    final /* synthetic */ FlashController $controller;
    final /* synthetic */ ECBaseBridgeMethod.a $iReturn;
    final /* synthetic */ ECAnchorFlashScreenShot this$0;

    public ECAnchorFlashScreenShot$handle$1(ECAnchorFlashScreenShot r100, FlashController r101, ECBaseBridgeMethod.a r102) {
        this.this$0 = r100;
        this.$controller = r101;
        this.$iReturn = r102;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r100, String r110) {
        dm.a.a("ECAnchorFlashScreenShot").a("filePath = " + r100 + " errorReason = " + r110);
        if (r100 != null) goto L5;
    L8:
        boolean r111 = true;
    L9:
        if (r111 == false) goto L19;
        return;
    L19:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L13
        Object r102 = Result.m9449constructorimpl(BuildersKt.launch$default(this.$controller.f151685a, null, null, new ECAnchorFlashScreenShot$handle$1$$special$$inlined$runCatching$lambda$1(null, this, r100), 3, null));     // Catch: Throwable -> L13
    L16:
        if (Result.m9452exceptionOrNullimpl(r102) == null) goto L22;
        dm.a.a("ECAnchorFlashScreenShot").b("error", null);
        return;
    L22:
        return;
    L13:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L5:
        if (r100.length() == 0) goto L8;
        r111 = false;
        goto L9
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String r100, String r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
