package com.obric.aikernel.sdk.config;

import d.h.a.a;
import d.h.b.p;

/* JADX INFO: compiled from: RequestParams.kt */
/* JADX INFO: loaded from: classes3.dex */
final class RequestParams$clientId$2 extends p implements a<String> {
    final /* synthetic */ RequestParams this$0;

    RequestParams$clientId$2(RequestParams r1) {
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
        Object r0 = RequestParams.access$getCallerName(this.this$0);
        if (r0 != null) goto L6;
        r0 = Integer.valueOf(this.this$0.getBackend().getInt(RequestParams.Args_Uid));
    L6:
        return String.valueOf(r0);
    }
}
