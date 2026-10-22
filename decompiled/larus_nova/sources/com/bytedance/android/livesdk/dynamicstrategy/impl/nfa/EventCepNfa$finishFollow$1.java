package com.bytedance.android.livesdk.dynamicstrategy.impl.nfa;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/dynamicstrategy/impl/nfa/a;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/dynamicstrategy/impl/nfa/a;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class EventCepNfa$finishFollow$1 extends Lambda implements Function1<a, Boolean> {
    final /* synthetic */ long $lastTime;
    final /* synthetic */ String $reason;
    final /* synthetic */ long $startTime;
    final /* synthetic */ e this$0;

    public EventCepNfa$finishFollow$1(e r100, long r101, long r102, String r103) {
        this.this$0 = r100;
        this.$startTime = r101;
        this.$lastTime = r102;
        this.$reason = r103;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(a r110) {
        Intrinsics.checkNotNullParameter(r110, "it");
        long r100 = r110.f123208b;
        long r101 = this.$startTime;
        if (r100 != r101) goto L10;
        int r102 = b.f123213a;
        b.a(this.this$0.f123233j, r110.f123207a, r101, this.$lastTime, this.$reason);
        m r111 = r110.f123210d;
        if (r111 == null) goto L9;
        l r103 = this.this$0.f123225b;
        if (r103 == null) goto L9;
        r103.c(r111);
    L9:
        return true;
    L10:
        return false;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(a r100) {
        return Boolean.valueOf(invoke2(r100));
    }
}
