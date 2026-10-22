package com.obric.aikernel.sdk.config;

import com.obric.aikernel.core.data.IdlKeys;
import d.h.a.a;
import d.h.b.p;

/* JADX INFO: compiled from: RequestParams.kt */
/* JADX INFO: loaded from: classes3.dex */
final class RequestParams$traceIdStr$2 extends p implements a<String> {
    final /* synthetic */ RequestParams this$0;

    RequestParams$traceIdStr$2(RequestParams r1) {
        this.this$0 = r1;
        super(0);
    }

    @Override // d.h.a.a
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }

    @Override // d.h.a.a
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        return String.valueOf(this.this$0.getBackend().getString(IdlKeys.Args_TraceId));
    }
}
