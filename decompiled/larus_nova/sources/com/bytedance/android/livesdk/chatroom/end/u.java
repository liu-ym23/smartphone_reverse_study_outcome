package com.bytedance.android.livesdk.chatroom.end;

import com.bytedance.android.livesdkapi.depend.model.live.PadLoggerData;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class u<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HashMap f106122a;

    public u(HashMap r100) {
        this.f106122a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f106122a.putAll((Map) r100);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_live_show", this.f106122a, new Object[]{am2.u.class, PadLoggerData.class});
    }
}
