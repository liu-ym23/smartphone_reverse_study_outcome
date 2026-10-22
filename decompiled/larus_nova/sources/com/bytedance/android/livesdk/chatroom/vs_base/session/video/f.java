package com.bytedance.android.livesdk.chatroom.vs_base.session.video;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes8.dex */
public final class f<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplayVideoMetrics f118124a;

    public f(ReplayVideoMetrics r100) {
        this.f118124a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        if (r101 == null) goto L15;
        r101.booleanValue();
        if (r101.booleanValue() == false) goto L10;
        com.bytedance.android.livesdk.chatroom.vs_base.log.g r102 = this.f118124a.f118077d;
        if (r102.f118018e == true) goto L17;
        r102.f118021h = false;
        r102.c(false);
        return;
    L17:
        return;
    L10:
        com.bytedance.android.livesdk.chatroom.vs_base.log.g r103 = this.f118124a.f118077d;
        if (r103.f118018e == true) goto L18;
        r103.b();
        r103.f118021h = true;
        return;
    L18:
        return;
    }
}
