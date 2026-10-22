package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.button;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f116514a = null;

    static {
        f116514a = new c();
    }

    public c() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.d("AbsAudienceToolbarButtonMoreDialog", ((Throwable) r100).toString());
    }
}
