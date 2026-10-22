package com.bytedance.android.live.pushstream;

import com.bytedance.android.livesdk.config.i60;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import uf2.d0;

/* JADX INFO: loaded from: classes47.dex */
public final class q<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f89420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d0 f89421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ei6.a f89422c;

    public q(String r100, d0 r101, ei6.a r102) {
        this.f89420a = r100;
        this.f89421b = r101;
        this.f89422c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Unit r101 = (Unit) r100;
        String r102 = this.f89420a + "audio_metrics_v1.3.model";
        d0 r103 = this.f89421b;
        if (r103 == null) goto L5;
        r103.h();
    L5:
        ei6.a r104 = this.f89422c;
        if (r104 == null) goto L11;
        ri6.b r105 = r104.r();
        if (r105 == null) goto L12;
        r105.u(r102, i60.f120427a.getValue());
        return;
    L12:
        return;
    }
}
