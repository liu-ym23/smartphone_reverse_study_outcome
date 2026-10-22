package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.watchlater;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f117466a;

    public i(k r100) {
        this.f117466a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        View r102 = this.f117466a.f117470c;
        if (r102 == null) goto L5;
        r102.setBackgroundResource(R.drawable.ttlive_ic_watch_later_button);
    L5:
        ALogger.e(this.f117466a.f117471d, r101.toString());
    }
}
