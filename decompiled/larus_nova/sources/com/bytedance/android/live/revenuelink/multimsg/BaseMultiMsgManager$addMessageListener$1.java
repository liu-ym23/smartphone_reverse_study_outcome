package com.bytedance.android.live.revenuelink.multimsg;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\f\b\u0000\u0010\u0002*\u00060\u0000j\u0002`\u00012\n\u0010\u0003\u001a\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", ExifInterface.GPS_DIRECTION_TRUE, "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class BaseMultiMsgManager$addMessageListener$1 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
    public BaseMultiMsgManager$addMessageListener$1(a r100) {
        super(1, r100, a.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(yh6.c r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        a r101 = (a) this.receiver;
        int r102 = a.f91850j;
        r101.k(0, r100, null);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(yh6.c r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
