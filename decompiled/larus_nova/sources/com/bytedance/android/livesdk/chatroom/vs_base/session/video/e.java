package com.bytedance.android.livesdk.chatroom.vs_base.session.video;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes8.dex */
public final class e<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplayVideoMetrics f118123a;

    public e(ReplayVideoMetrics r100) {
        this.f118123a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        if (r101 == null) goto L9;
        r101.booleanValue();
        if (r101.booleanValue() == false) goto L7;
        this.f118123a.f118077d.c(true);
        return;
    L7:
        this.f118123a.f118077d.b();
        return;
    }
}
