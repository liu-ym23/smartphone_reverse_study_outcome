package com.bytedance.android.livesdk.chatroom.room.apm;

import com.bytedance.android.live.livepullstream.api.apm.APMEvent;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes7.dex */
public final class j implements Observer<IRoom> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f110705a;

    public j(p r100) {
        this.f110705a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        IRoom r101 = (IRoom) r100;
        this.f110705a.b(com.bytedance.android.live.livepullstream.api.apm.a.a(APMEvent.Level.I, "show interaction"));
    }
}
