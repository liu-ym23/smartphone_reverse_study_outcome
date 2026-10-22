package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.graphics.Paint;
import com.bytedance.android.live.browser.jsbridge.base.MeasureTextResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "measureText")
public final class MeasureTextMethod extends w20.y3<w20.sb, MeasureTextResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f63258a;

    public MeasureTextMethod() {
        this.f63258a = LazyKt.lazy(MeasureTextMethod$paint$2.INSTANCE);
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w20.sb r102 = (w20.sb) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Integer r103 = r102.a();
        String r104 = r102.b();
        if (r103 == null) goto L7;
        if (r104 == null) goto L7;
        ((Paint) this.f63258a.getValue()).setTextSize(r103.intValue());
        float r105 = ((Paint) this.f63258a.getValue()).measureText(r102.b());
        MeasureTextResultModel r106 = new MeasureTextResultModel();
        MeasureTextResultModel.a r107 = new MeasureTextResultModel.a();
        r107.a(Float.valueOf(r105));
        Unit r108 = Unit.INSTANCE;
        r106.a(r107);
        finishWithResult(r106);
        return;
    L7:
        MeasureTextResultModel r109 = new MeasureTextResultModel();
        MeasureTextResultModel.a r110 = new MeasureTextResultModel.a();
        r110.a(Float.valueOf(0.0f));
        Unit r111 = Unit.INSTANCE;
        r109.a(r110);
        finishWithResult(r109);
    }
}
