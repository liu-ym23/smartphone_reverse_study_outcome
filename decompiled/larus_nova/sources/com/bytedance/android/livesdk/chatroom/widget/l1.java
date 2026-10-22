package com.bytedance.android.livesdk.chatroom.widget;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes8.dex */
public final class l1<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PlayerControlWidget f118835a;

    public l1(PlayerControlWidget r100) {
        this.f118835a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (((Boolean) r100).booleanValue() == false) goto L7;
        this.f118835a.Iq();
        return;
    }
}
