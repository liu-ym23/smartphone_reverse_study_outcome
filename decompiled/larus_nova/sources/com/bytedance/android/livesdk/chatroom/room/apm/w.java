package com.bytedance.android.livesdk.chatroom.room.apm;

import com.bytedance.android.live.livepullstream.api.apm.APMEvent;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes7.dex */
public final class w implements Observer<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f110743a;

    public w(p r100) {
        this.f110743a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (Boolean.TRUE.equals((Boolean) r100) == false) goto L13;
        p r101 = this.f110743a;
        if (r101.f110727q.f110736c == true) goto L14;
        r101.c("point_finish_resume_time", String.valueOf(System.currentTimeMillis()));
        long r102 = System.currentTimeMillis() - this.f110743a.e();
        if (this.f110743a.e() <= 0) goto L11;
        p r103 = this.f110743a;
        if (r102 >= r103.f110722l.enterRoomTimeout) goto L11;
        r103.d("start_to_resume_cost", r102);
    L11:
        this.f110743a.b(com.bytedance.android.live.livepullstream.api.apm.a.a(APMEvent.Level.I, "interaction resume"));
        p r104 = this.f110743a;
        r104.f110727q.f110736c = true;
        r104.h(0, "");
        return;
    L14:
        return;
    }
}
