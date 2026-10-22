package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "code", "", "msg", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class PerformXplayPreCheckMethod$invoke$3 extends Lambda implements Function2<Integer, String, Unit> {
    final /* synthetic */ PerformXPlayPreCheckResultModel $result;
    final /* synthetic */ m5 this$0;

    public PerformXplayPreCheckMethod$invoke$3(m5 r100, PerformXPlayPreCheckResultModel r101) {
        this.this$0 = r100;
        this.$result = r101;
        super(2);
    }

    public final void invoke(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        PerformXPlayPreCheckResultModel.a r102 = this.$result.a();
        if (r102 == null) goto L7;
        JsonObject r103 = r102.a();
        if (r103 == null) goto L7;
        r103.addProperty("code", Integer.valueOf(r100));
        r103.addProperty("msg", r101);
    L7:
        m5 r104 = this.this$0;
        PerformXPlayPreCheckResultModel r105 = this.$result;
        int r106 = m5.f57527a;
        r104.finishWithResult(r105);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer r100, String r101) {
        invoke(r100.intValue(), r101);
        return Unit.INSTANCE;
    }
}
