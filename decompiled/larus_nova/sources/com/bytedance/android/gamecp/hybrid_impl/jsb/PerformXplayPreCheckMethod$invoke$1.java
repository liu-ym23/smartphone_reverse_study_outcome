package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "code", "Ljava/lang/Integer;", "msg", "", "userServiceAgreementUrl", "privacyAgreementUrl", "<anonymous parameter 4>", "<anonymous parameter 5>", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class PerformXplayPreCheckMethod$invoke$1 extends Lambda implements Function6<Integer, String, String, String, String, String, Unit> {
    final /* synthetic */ PerformXPlayPreCheckResultModel $result;
    final /* synthetic */ m5 this$0;

    public PerformXplayPreCheckMethod$invoke$1(m5 r100, PerformXPlayPreCheckResultModel r101) {
        this.this$0 = r100;
        this.$result = r101;
        super(6);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Integer r100, String r101, String r102, String r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "code");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r102, "userServiceAgreementUrl");
        Intrinsics.checkNotNullParameter(r103, "privacyAgreementUrl");
        Intrinsics.checkNotNullParameter(r104, "<anonymous parameter 4>");
        Intrinsics.checkNotNullParameter(r105, "<anonymous parameter 5>");
        PerformXPlayPreCheckResultModel.a r106 = this.$result.a();
        if (r106 == null) goto L7;
        JsonObject r107 = r106.a();
        if (r107 == null) goto L7;
        r107.addProperty("code", r100);
        r107.addProperty("msg", r101);
        r107.addProperty("user_service_agreement_url", r102);
        r107.addProperty("privacy_agreement_url", r103);
    L7:
        m5 r108 = this.this$0;
        PerformXPlayPreCheckResultModel r109 = this.$result;
        int r110 = m5.f57527a;
        r108.finishWithResult(r109);
    }

    @Override // kotlin.jvm.functions.Function6
    public /* bridge */ /* synthetic */ Unit invoke(Integer r100, String r101, String r110, String r111, String r112, String r113) {
        invoke2(r100, r101, r110, r111, r112, r113);
        return Unit.INSTANCE;
    }
}
