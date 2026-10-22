package com.bytedance.android.live.broadcastgame.opengame.control.out_report;

import android.util.LruCache;
import com.bytedance.android.live.broadcastgame.opengame.control.report.ReportPicUploader;
import com.bytedance.android.live.broadcastgame.opengame.network.l0;
import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReportSubmitControl f59911a;

    public b(ReportSubmitControl r100) {
        this.f59911a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        LruCache<String, byte[]> r101 = ReportPicUploader.f59913a;
        String r102 = ((l0) ((Response) r100).data).a();
        Intrinsics.checkNotNull(r102);
        ReportPicUploader.e(r102, "-1");
        com.bytedance.android.live.broadcastgame.opengame.control.report.c r103 = this.f59911a.f59902b;
        if (r103 == null) goto L6;
        r103.G0();
        return;
    }
}
