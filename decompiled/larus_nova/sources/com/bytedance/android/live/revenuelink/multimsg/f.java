package com.bytedance.android.live.revenuelink.multimsg;

import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.live.revenuelink.multimsg.api.TaskState;
import com.bytedance.android.livesdk.link.model.bridge.h2;
import com.bytedance.android.livesdk.revenue.message.i;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.live.kmp.statemachine.StateMachine;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class f extends com.bytedance.android.live.revenuelink.multimsg.api.a<ByteBuffer, g> {
    public f() {
    }

    @Override // com.bytedance.android.live.revenuelink.multimsg.api.a
    public final void b(ByteBuffer r100) {
        ByteBuffer r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "params");
        int r102 = r101.remaining();
        byte[] r103 = new byte[r102];
        r101.get(r103);
        if (r102 != 0) goto L5;
        boolean r104 = true;
    L7:
        if (r104 == false) goto L9;
        int r105 = com.bytedance.android.live.revenuelink.multimsg.api.e.f91874a;
        Exception r106 = new Exception("RtcMsgTask-->bytes is empty");
        Intrinsics.checkNotNullParameter(r106, BaseHttpRequestInfo.KEY_EXCEPTION);
        com.bytedance.android.live.revenuelink.multimsg.api.e.b r107 = new com.bytedance.android.live.revenuelink.multimsg.api.e.b(r106);
        Intrinsics.checkNotNullParameter(r107, "result");
        TaskState<INPUT, OUTPUT, com.bytedance.android.live.revenuelink.multimsg.api.a<INPUT, OUTPUT>> r108 = this.f91873a;
        r108.getClass();
        Intrinsics.checkNotNullParameter(r107, "result");
        StateMachine.c(r108.f91864d, new TaskState.a.C1427a(r107));
        return;
    L9:
        h2 r109 = (h2) vh7.f.b(r103, h2.class);
        com.bytedance.android.livesdk.revenue.service.message.d r110 = (com.bytedance.android.livesdk.revenue.service.message.d) ((dy0.b) com.bytedance.android.live.revenue.core.util.e.c(j.C0.a(), com.bytedance.android.livesdk.revenue.service.message.d.class));
        if (r110 == null) goto L14;
        i r111 = r110.getMessageManager();
        if (r111 == null) goto L14;
        yh6.c r112 = r111.a(r109);
    L15:
        if (r112 != null) goto L17;
        int r113 = com.bytedance.android.live.revenuelink.multimsg.api.e.f91874a;
        Exception r114 = new Exception("RtcMsgTask decode error}");
        Intrinsics.checkNotNullParameter(r114, BaseHttpRequestInfo.KEY_EXCEPTION);
        com.bytedance.android.live.revenuelink.multimsg.api.e.b r115 = new com.bytedance.android.live.revenuelink.multimsg.api.e.b(r114);
        Intrinsics.checkNotNullParameter(r115, "result");
        TaskState<INPUT, OUTPUT, com.bytedance.android.live.revenuelink.multimsg.api.a<INPUT, OUTPUT>> r116 = this.f91873a;
        r116.getClass();
        Intrinsics.checkNotNullParameter(r115, "result");
        StateMachine.c(r116.f91864d, new TaskState.a.C1427a(r115));
        return;
    L17:
        int r117 = com.bytedance.android.live.revenuelink.multimsg.api.e.f91874a;
        com.bytedance.android.live.revenuelink.multimsg.api.e.c r118 = new com.bytedance.android.live.revenuelink.multimsg.api.e.c(new g(r109, r112));
        Intrinsics.checkNotNullParameter(r118, "result");
        TaskState<INPUT, OUTPUT, com.bytedance.android.live.revenuelink.multimsg.api.a<INPUT, OUTPUT>> r119 = this.f91873a;
        r119.getClass();
        Intrinsics.checkNotNullParameter(r118, "result");
        StateMachine.c(r119.f91864d, new TaskState.a.C1427a(r118));
        return;
    L14:
        r112 = null;
        goto L15
    L5:
        r104 = false;
        goto L7
    }
}
