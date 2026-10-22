package com.bytedance.android.live.virtuallive.impl.rtc;

import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", "safeSeiBuffer", "Ljava/nio/ByteBuffer;", "safePopSei", "", AbsMethodDelegate.TAG_INVOKE, "com/bytedance/android/live/virtuallive/impl/rtc/VirtualLiveRTCEngineManager$getSei$1$1"}, k = 3, mv = {1, 5, 1})
final class VirtualLiveRTCEngineManager$getSei$$inlined$synchronized$lambda$1 extends Lambda implements Function2<ByteBuffer, String, Unit> {
    final /* synthetic */ String $seiString$inlined;
    final /* synthetic */ Ref.IntRef $size;
    final /* synthetic */ b this$0;

    public VirtualLiveRTCEngineManager$getSei$$inlined$synchronized$lambda$1(Ref.IntRef r100, b r101, String r102) {
        this.$size = r100;
        this.this$0 = r101;
        this.$seiString$inlined = r102;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ByteBuffer r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "safeSeiBuffer");
        Intrinsics.checkNotNullParameter(r101, "safePopSei");
        Ref.IntRef r102 = this.$size;
        b r103 = this.this$0;
        int r104 = b.f102642a;
        r103.getClass();
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r105 = ILiveWrappedLivePusher.a.b();
        if (r105 == null) goto L5;
        r105.getEffectWrapperAlgorithmResult();
    L5:
        r102.element = 0;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(ByteBuffer r100, String r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
