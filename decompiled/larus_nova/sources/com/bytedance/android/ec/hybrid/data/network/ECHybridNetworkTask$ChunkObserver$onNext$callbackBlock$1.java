package com.bytedance.android.ec.hybrid.data.network;

import com.bytedance.android.ec.hybrid.data.entity.ECHybridNetworkVO;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class ECHybridNetworkTask$ChunkObserver$onNext$callbackBlock$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $data;
    final /* synthetic */ long $timestamp;
    final /* synthetic */ ECHybridNetworkTask.ChunkObserver this$0;

    public ECHybridNetworkTask$ChunkObserver$onNext$callbackBlock$1(ECHybridNetworkTask.ChunkObserver r100, String r101, long r102) {
        this.this$0 = r100;
        this.$data = r101;
        this.$timestamp = r102;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ECHybridNetworkTask.ChunkObserver r100 = this.this$0;
        ECHybridNetworkTask.CallbackList r101 = r100.f46780f;
        String r102 = r100.f46777c;
        String r103 = this.$data;
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        final ECHybridNetworkVO r104 = r100.f46778d;
        kk.d.c(new ECHybridNetworkTask$ChunkObserver$onNext$callbackBlock$1$$special$$inlined$also$lambda$1(r104, this));
        Unit r105 = Unit.INSTANCE;
        r101.c(r102, r103, r104, this.this$0.f46779e);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
