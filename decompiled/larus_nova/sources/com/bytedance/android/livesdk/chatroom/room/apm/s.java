package com.bytedance.android.livesdk.chatroom.room.apm;

import com.bytedance.android.live.livepullstream.api.apm.APMEvent;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes7.dex */
public final class s implements Observer<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f110739a;

    public s(p r100) {
        this.f110739a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = Boolean.TRUE;
        if (r101.equals((Boolean) r100) == false) goto L6;
        this.f110739a.b(com.bytedance.android.live.livepullstream.api.apm.a.a(APMEvent.Level.I, "playing state ready"));
        return;
    }
}
