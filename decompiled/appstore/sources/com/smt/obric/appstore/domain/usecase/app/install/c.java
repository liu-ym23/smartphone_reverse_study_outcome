package com.smt.obric.appstore.domain.usecase.app.install;

import com.bytedanceos.common.toolbox.j;
import com.smt.obric.appstore.domain.downloader.ODownloader;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
public final class c {
    public c() {
    }

    public final Object a(com.smt.obric.appstore.domain.app.entity.a r10, Continuation r11) {
        Long r12 = r10.o();
        if (r12 == null) goto L9;
        Object r13 = ODownloader.f18038a.r(r12.longValue(), r11);
        if (r13 != kotlin.coroutines.intrinsics.a.d()) goto L8;
        return r13;
    L8:
        return Unit.f21064a;
    L9:
        j.s("[AppStatus][PauseAppDownloadUseCase] invoke: no downloadId found, task=" + r10);
        return Unit.f21064a;
    }
}
