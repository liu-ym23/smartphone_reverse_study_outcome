package com.bytedance.android.livesdk.chatroom.room;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes7.dex */
public final class z<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f111176a = null;

    static {
        f111176a = new z();
    }

    public z() {
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (((IRoom) r100) == null) goto L6;
        in1.b.c("pre show interact loaded ");
        return;
    }
}
