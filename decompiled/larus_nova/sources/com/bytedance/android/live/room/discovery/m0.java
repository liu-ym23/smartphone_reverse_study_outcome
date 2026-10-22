package com.bytedance.android.live.room.discovery;

import android.view.View;
import com.bytedance.android.livesdk.utils.g7;
import io.reactivex.functions.Consumer;
import zg1.q3;

/* JADX INFO: loaded from: classes47.dex */
public final class m0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NetSpeedMonitorWidget f99572a;

    public m0(NetSpeedMonitorWidget r100) {
        this.f99572a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        if (((q3) r100) == null) goto L7;
        View r101 = this.f99572a.contentView;
        if (r101 == null) goto L11;
        g7.a(r101);
        return;
    L11:
        return;
    L7:
        View r102 = this.f99572a.contentView;
        if (r102 == null) goto L13;
        g7.b(r102);
        return;
    }
}
