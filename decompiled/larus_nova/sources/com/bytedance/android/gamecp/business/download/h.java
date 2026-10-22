package com.bytedance.android.gamecp.business.download;

import com.bytedance.android.gamecp.business.GamePromoteTrack;
import com.lynx.tasm.LynxError;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2 f52715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f52716b;

    public h(Function2 r100, p r101) {
        this.f52715a = r100;
        this.f52716b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        this.f52715a.invoke(Boolean.FALSE, new Pair(4, "need login"));
        String r102 = r101.getMessage();
        if (r102 == null) goto L5;
        yr.c.b("DownloadView", r102);
    L5:
        int r103 = GamePromoteTrack.f51759a;
        GamePromoteTrack.q("fail", this.f52716b);
    }
}
