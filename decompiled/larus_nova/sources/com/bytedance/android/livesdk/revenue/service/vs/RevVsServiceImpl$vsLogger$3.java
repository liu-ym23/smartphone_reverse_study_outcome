package com.bytedance.android.livesdk.revenue.service.vs;

import com.bytedance.android.livesdk.vs.f;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/ies/sdk/widgets/DataCenter;", "p1", "Les2/a;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)Les2/a;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class RevVsServiceImpl$vsLogger$3 extends FunctionReferenceImpl implements Function1<DataCenter, es2.a> {
    public RevVsServiceImpl$vsLogger$3(es2.b r100) {
        super(1, r100, es2.b.class, "fromVsLogger", "fromVsLogger(Lcom/bytedance/ies/sdk/widgets/DataCenter;)Lcom/bytedance/android/livesdk/revenue/vs/IRevVsLogger;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final es2.a invoke2(DataCenter r100) {
        ((es2.b) this.receiver).getClass();
        if (r100 == null) goto L6;
        f r101 = f.a(r100);
        if (r101 == null) goto L6;
    L8:
        return new es2.b.a(r101);
    L6:
        r101 = f.f159373c;
        goto L8
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ es2.a invoke(DataCenter r100) {
        return invoke2(r100);
    }
}
