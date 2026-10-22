package com.bytedance.android.live.platformplayer.layout;

import com.bytedance.android.live.feature.api.FeatureType;
import com.bytedance.android.live.feature.api.IFeatureService;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class LivePlayerWidget$setResolutionBaseFPS$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $currentResolutionFPS;

    public LivePlayerWidget$setResolutionBaseFPS$1(int r100) {
        this.$currentResolutionFPS = r100;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        IFeatureService r100 = (IFeatureService) jc1.k.f(IFeatureService.class);
        if (r100 == null) goto L8;
        z90.a r101 = r100.getFeatureManager();
        if (r101 == null) goto L9;
        r101.i("current_resolution_base_fps", Integer.valueOf(this.$currentResolutionFPS), FeatureType.MONITOR);
        return;
    L9:
        return;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
