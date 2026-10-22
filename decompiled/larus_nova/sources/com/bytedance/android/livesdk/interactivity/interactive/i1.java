package com.bytedance.android.livesdk.interactivity.interactive;

import com.bytedance.android.livesdkapi.interact.RefreshVSMessageBoardDataEvent;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class i1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i1 f137418a = null;

    static {
        f137418a = new i1();
    }

    public i1() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = (String) r100;
        xs2.b.a().post(new RefreshVSMessageBoardDataEvent());
    }
}
