package com.bytedance.android.live.broadcastgame.opengame.control.report;

import android.util.LruCache;
import com.bytedance.android.live.broadcastgame.opengame.network.l0;
import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReportSubmitControl f59954a;

    public e(ReportSubmitControl r100) {
        this.f59954a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        LruCache<String, byte[]> r101 = ReportPicUploader.f59913a;
        ReportPicUploader.e(((l0) ((Response) r100).data).a(), String.valueOf(this.f59954a.f59943h));
        c r102 = this.f59954a.f59937b;
        if (r102 == null) goto L6;
        r102.G0();
        return;
    }
}
