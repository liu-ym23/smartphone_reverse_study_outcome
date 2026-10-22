package com.bytedance.android.livesdk.chatroom.room.apm;

import com.bytedance.android.live.livepullstream.api.apm.APMEvent;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes7.dex */
public final class o implements Observer<APMEvent> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f110710a;

    public o(p r100) {
        this.f110710a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        APMEvent r101 = (APMEvent) r100;
        if (r101 == null) goto L6;
        this.f110710a.b(r101);
        return;
    }
}
