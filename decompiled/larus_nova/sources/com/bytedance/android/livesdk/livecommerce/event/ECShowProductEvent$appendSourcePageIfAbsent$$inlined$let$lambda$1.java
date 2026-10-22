package com.bytedance.android.livesdk.livecommerce.event;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "Lcom/bytedance/android/livesdk/livecommerce/event/ECEventV3;", "enterFromMerge", "", "enterFrom", AbsMethodDelegate.TAG_INVOKE, "com/bytedance/android/livesdk/livecommerce/event/ECShowProductEvent$appendSourcePageIfAbsent$1$1"}, k = 3, mv = {1, 4, 3})
final class ECShowProductEvent$appendSourcePageIfAbsent$$inlined$let$lambda$1 extends Lambda implements Function2<String, String, ECEventV3> {
    final /* synthetic */ z1 this$0;

    public ECShowProductEvent$appendSourcePageIfAbsent$$inlined$let$lambda$1(z1 r100) {
        this.this$0 = r100;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ECEventV3 invoke2(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "enterFromMerge");
        Intrinsics.checkNotNullParameter(r101, "enterFrom");
        z1 r102 = this.this$0;
        r102.f147721c.c("source_page", r100 + "_temai_" + r101);
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ ECEventV3 invoke(String r100, String r101) {
        return invoke2(r100, r101);
    }
}
