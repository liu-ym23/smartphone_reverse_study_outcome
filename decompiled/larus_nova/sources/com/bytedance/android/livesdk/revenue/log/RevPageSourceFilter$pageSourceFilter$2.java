package com.bytedance.android.livesdk.revenue.log;

import com.bytedance.android.livesdk.log.filter.n0;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/log/filter/n0;", AbsMethodDelegate.TAG_INVOKE, "()Lcom/bytedance/android/livesdk/log/filter/n0;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class RevPageSourceFilter$pageSourceFilter$2 extends Lambda implements Function0<n0> {
    final /* synthetic */ o $filter;

    public RevPageSourceFilter$pageSourceFilter$2(o r100) {
        this.$filter = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final n0 invoke() {
        o r100 = this.$filter;
        if ((r100 instanceof n0) == true) goto L6;
        r100 = null;
    L6:
        return (n0) r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ n0 invoke() {
        return invoke();
    }
}
