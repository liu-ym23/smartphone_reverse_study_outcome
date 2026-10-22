package com.bytedance.android.livesdk.chatroom.roommanage.manage.banuser;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.utils.f2;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f111468a;

    public c(f r100) {
        this.f111468a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        if ((r101 instanceof ApiServerException) == false) goto L5;
        f2.c(((ApiServerException) r101).getPrompt(), 0);
    L6:
        this.f111468a.f111475d = false;
        return;
    L5:
        f2.b(R.string.ttlive_network_error, 0);
        goto L6
    }
}
