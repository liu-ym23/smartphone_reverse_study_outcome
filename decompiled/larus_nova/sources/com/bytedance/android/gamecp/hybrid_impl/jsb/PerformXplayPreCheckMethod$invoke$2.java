package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.android.ttcjpaysdk.base.weboffline.CJPayWebOfflineWorker;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "code", "", "msg", "", CJPayWebOfflineWorker.CJ_PAY_WEB_OFFLINE_FINISHED, "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class PerformXplayPreCheckMethod$invoke$2 extends Lambda implements Function3<Integer, String, Boolean, Unit> {
    final /* synthetic */ PerformXPlayPreCheckResultModel $result;
    final /* synthetic */ m5 this$0;

    public PerformXplayPreCheckMethod$invoke$2(m5 r100, PerformXPlayPreCheckResultModel r101) {
        this.this$0 = r100;
        this.$result = r101;
        super(3);
    }

    public final void invoke(int r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        PerformXPlayPreCheckResultModel.a r103 = this.$result.a();
        if (r103 == null) goto L7;
        JsonObject r104 = r103.a();
        if (r104 == null) goto L7;
        r104.addProperty("code", Integer.valueOf(r100));
        r104.addProperty("msg", r101);
        r104.addProperty(CJPayWebOfflineWorker.CJ_PAY_WEB_OFFLINE_FINISHED, Boolean.valueOf(r102));
    L7:
        m5 r105 = this.this$0;
        PerformXPlayPreCheckResultModel r106 = this.$result;
        int r107 = m5.f57527a;
        r105.finishWithResult(r106);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Integer r100, String r101, Boolean r102) {
        invoke(r100.intValue(), r101, r102.booleanValue());
        return Unit.INSTANCE;
    }
}
