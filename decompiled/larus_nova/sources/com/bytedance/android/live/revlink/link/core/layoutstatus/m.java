package com.bytedance.android.live.revlink.link.core.layoutstatus;

import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class m implements c<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f98308a;

    @Override // com.bytedance.android.live.revlink.link.core.layoutstatus.c
    public final void attach() {
    }

    @Override // com.bytedance.android.live.revlink.link.core.layoutstatus.c
    public final void detach() {
        this.f98308a.clear();
    }

    public m(h r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f98308a = new CompositeDisposable();
    }
}
