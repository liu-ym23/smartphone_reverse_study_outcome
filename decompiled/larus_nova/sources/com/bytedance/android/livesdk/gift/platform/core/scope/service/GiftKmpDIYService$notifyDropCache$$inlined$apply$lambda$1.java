package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE, "com/bytedance/android/livesdk/gift/platform/core/scope/service/GiftKmpDIYService$notifyDropCache$2$1"}, k = 3, mv = {1, 5, 1})
final class GiftKmpDIYService$notifyDropCache$$inlined$apply$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ArrayList $diskCardList$inlined;
    final /* synthetic */ long $giftId$inlined;
    final /* synthetic */ v0 this$0;

    public GiftKmpDIYService$notifyDropCache$$inlined$apply$lambda$1(v0 r100, ArrayList r101, long r102) {
        this.this$0 = r100;
        this.$diskCardList$inlined = r101;
        this.$giftId$inlined = r102;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.a(this.$diskCardList$inlined, this.$giftId$inlined);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
