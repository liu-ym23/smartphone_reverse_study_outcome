package com.bytedance.android.livesdk.chatroom.room.apm;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes7.dex */
public final class g<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f110702a;

    public g(c r100) {
        this.f110702a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        c r102 = this.f110702a;
        if (r101 == null) goto L5;
        boolean r103 = r101.booleanValue();
    L6:
        r102.f110691b = r103;
        return;
    L5:
        r103 = false;
        goto L6
    }
}
