package com.bytedance.android.live.profit.redpacket;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lds2/b;", "", AbsMethodDelegate.TAG_INVOKE, "(Lds2/b;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class RedPacketIconModel$login$1 extends Lambda implements Function1<ds2.b, Unit> {
    public static final RedPacketIconModel$login$1 INSTANCE = null;

    static {
        INSTANCE = new RedPacketIconModel$login$1();
    }

    public RedPacketIconModel$login$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ds2.b r100) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        r100.setMessage(s1.B(R.string.ttlive_login_dialog_red_envelope));
        r100.a(5);
        r100.setEnterFrom("live_detail");
        r100.setActionType("red_envelope");
        r100.setSource("live");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ds2.b r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
