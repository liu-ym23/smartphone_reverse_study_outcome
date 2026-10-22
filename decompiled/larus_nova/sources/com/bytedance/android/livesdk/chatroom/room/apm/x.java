package com.bytedance.android.livesdk.chatroom.room.apm;

import com.bytedance.android.live.livepullstream.api.apm.APMEvent;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes7.dex */
public final class x implements Observer<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f110744a;

    public x(p r100) {
        this.f110744a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        this.f110744a.b(com.bytedance.android.live.livepullstream.api.apm.a.a(APMEvent.Level.I, "update interaction"));
    }
}
