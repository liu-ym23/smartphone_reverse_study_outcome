package com.bytedance.android.live.revenue.platform.hybrid.impl.shareview;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"release", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
final class RevShareViewServiceImpl$waitSharer$3$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c $sharer;
    final /* synthetic */ h this$0;

    public RevShareViewServiceImpl$waitSharer$3$1(h r100, com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c r101) {
        this.this$0 = r100;
        this.$sharer = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$sharer.release();
        h r100 = this.this$0;
        r100.f91453a.f91418b.remove(r100.f91454b);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
