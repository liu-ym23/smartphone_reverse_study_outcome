package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter;

import com.bytedance.android.livesdk.interactivity.l;
import com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.strategy.SelectedMsgBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements SelectedMsgBuffer.a {
    public b() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.strategy.SelectedMsgBuffer.a
    public final void a(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r100, SelectedMsgBuffer.DropReason r101) {
        Intrinsics.checkNotNullParameter(r100, "absTextMessage");
        Intrinsics.checkNotNullParameter(r101, "reason");
        int r102 = ga2.d.f480547a;
        Intrinsics.checkNotNullParameter(r100, "msg");
        Intrinsics.checkNotNullParameter(r101, "reason");
        l.a("chosen_screen_message_drop", "reason: " + r101.name() + ",msg_type: " + r100.f133141b.getMessageMethod() + ", msg_id: " + r100.f133141b.getMessageId() + ", msg_drop_diff_time: " + (System.currentTimeMillis() - r100.p().longValue()));
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.strategy.SelectedMsgBuffer.a
    public final void b(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "absTextMessage");
        int r102 = ga2.d.f480547a;
        Intrinsics.checkNotNullParameter(r100, "msg");
        StringBuilder r103 = new StringBuilder("queue_size: ");
        r103.append(r101);
        r103.append(", msg_id: ");
        r103.append(r100.f133141b.getMessageId());
        r103.append(", msg_type：");
        T r104 = r100.f133141b;
        if (r104 == 0) goto L5;
        String r105 = r104.getMessageMethod();
    L6:
        r103.append(r105);
        l.a("chosen_screen_message_enqueue", r103.toString());
        return;
    L5:
        r105 = null;
        goto L6
    }
}
