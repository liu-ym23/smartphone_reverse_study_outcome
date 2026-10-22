package com.bytedance.android.livesdk.asr;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "data", "", "length", "", "timestamp", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class GiftSpeechSdkManager$onAudioFrameAvailable$1 extends Lambda implements Function3<byte[], Integer, Long, Unit> {
    final /* synthetic */ GiftSpeechSdkManager this$0;

    public GiftSpeechSdkManager$onAudioFrameAvailable$1(GiftSpeechSdkManager r100) {
        this.this$0 = r100;
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(byte[] r100, Integer r101, Long r102) {
        invoke(r100, r101.intValue(), r102.longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(final byte[] r100, int r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.this$0.c("feedAudioData", false, false, new AnonymousClass1(r100));
    }
}
