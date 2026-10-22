package com.bytedance.android.gamecp.business.download;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class GameCenterStrategy$onInstalled$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ p $downloadInfo;
    final /* synthetic */ int $downloadStatus;
    final /* synthetic */ com.bytedance.android.gamecp.base.core.service.depend.v $installedFinishData;
    final /* synthetic */ com.bytedance.android.gamecp.base.core.service.depend.n $listener;

    public GameCenterStrategy$onInstalled$1(p r100, int r101, com.bytedance.android.gamecp.base.core.service.depend.n r102, com.bytedance.android.gamecp.base.core.service.depend.v r103) {
        this.$downloadInfo = r100;
        this.$downloadStatus = r101;
        this.$listener = r102;
        this.$installedFinishData = r103;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        p r100 = this.$downloadInfo;
        r100.f52880w0 = this.$downloadStatus;
        this.$listener.onInstalled(this.$installedFinishData);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
