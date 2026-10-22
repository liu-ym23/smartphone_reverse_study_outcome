package com.bytedance.android.livesdk.gift.platform.core.sticker;

import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/o7;", "p1", "p2", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/message/model/o7;Lcom/bytedance/android/livesdk/message/model/o7;)I", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class StickerMessageInfo$otherMessages$1 extends FunctionReferenceImpl implements Function2<o7, o7, Integer> {
    public StickerMessageInfo$otherMessages$1(StickerMessageInfo r100) {
        super(2, r100, StickerMessageInfo.class, "compare", "compare(Lcom/bytedance/android/livesdk/message/model/IGiftMessage;Lcom/bytedance/android/livesdk/message/model/IGiftMessage;)I", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2(o7 r100, o7 r101) {
        ((StickerMessageInfo) this.receiver).getClass();
        if (r100 == null) goto L19;
        if (r101 == null) goto L19;
        int r102 = 0;
        if (r100.getGift() == null) goto L9;
        h1 r103 = r100.getGift();
        Intrinsics.checkNotNull(r103);
        int r104 = r103.getDiamondCount();
    L10:
        long r105 = r104;
        if (r101.getGift() == null) goto L13;
        h1 r106 = r101.getGift();
        Intrinsics.checkNotNull(r106);
        r102 = r106.getDiamondCount();
    L13:
        long r107 = r102;
        if (r105 != r107) goto L21;
        Intrinsics.checkNotNullParameter(r100, "$this$getGiftTimeStamp");
        long r108 = r100.getGiftTimeStamp();
        Intrinsics.checkNotNullParameter(r101, "$this$getGiftTimeStamp");
        if ((r108 - r101.getGiftTimeStamp()) <= 0) goto L19;
        return 1;
    L21:
        return (int) (r107 - r105);
    L9:
        r104 = 0;
    L19:
        return -1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Integer invoke(o7 r100, o7 r101) {
        return Integer.valueOf(invoke2(r100, r101));
    }
}
