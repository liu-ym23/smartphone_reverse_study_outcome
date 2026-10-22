package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbsAudienceToolbarButtonMoreDialog f115752a;

    public a(AbsAudienceToolbarButtonMoreDialog r100) {
        this.f115752a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.d(this.f115752a.B, ((Throwable) r100).toString());
    }
}
