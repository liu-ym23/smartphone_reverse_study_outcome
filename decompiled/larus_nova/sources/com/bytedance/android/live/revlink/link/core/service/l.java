package com.bytedance.android.live.revlink.link.core.service;

import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class l implements com.bytedance.android.live.revlink.link.biz.service.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f98350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f98351b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AnchorUILayoutManager f98352c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final yz0.f f98353d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a f98354e;

    @Override // com.bytedance.android.live.revlink.link.biz.service.a, com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.a, com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a getContext() {
        return this.f98354e;
    }

    public l(AnchorUILayoutManager r100, yz0.f r101, com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r102) {
        Intrinsics.checkNotNullParameter(r100, "uiLayoutManager");
        Intrinsics.checkNotNullParameter(r101, "messageService");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f98352c = r100;
        this.f98353d = r101;
        this.f98354e = r102;
        this.f98350a = new CompositeDisposable();
    }
}
