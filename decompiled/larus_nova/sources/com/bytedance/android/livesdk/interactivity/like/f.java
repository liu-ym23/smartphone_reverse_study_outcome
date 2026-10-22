package com.bytedance.android.livesdk.interactivity.like;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f137664a;

    public f(d r100) {
        this.f137664a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        StringBuilder r102 = new StringBuilder("post remaining digg failed: ");
        if (r101 == null) goto L5;
        String r103 = r101.getMessage();
    L6:
        r102.append(r103);
        r102.append(", room id: ");
        r102.append(this.f137664a.f137656d);
        r102.append(", target uid ");
        r102.append(this.f137664a.f137657e);
        ALogger.e("DiggHandler", r102.toString());
        return;
    L5:
        r103 = null;
        goto L6
    }
}
