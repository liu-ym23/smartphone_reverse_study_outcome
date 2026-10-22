package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes46.dex */
public final class j implements fd0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f72321a;

    public j(Function0 r100) {
        this.f72321a = r100;
    }

    @Override // fd0.b
    public final void onStop() {
        Function0 r100 = this.f72321a;
        if (r100 == null) goto L6;
        Unit r101 = (Unit) r100.invoke();
        return;
    }
}
