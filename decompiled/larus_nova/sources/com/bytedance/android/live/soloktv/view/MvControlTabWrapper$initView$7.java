package com.bytedance.android.live.soloktv.view;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.message.model.od;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class MvControlTabWrapper$initView$7 implements com.bytedance.android.live.soloktv.viewmodel.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MvControlTabWrapper f101749a;

    public MvControlTabWrapper$initView$7(MvControlTabWrapper r100) {
        this.f101749a = r100;
    }

    @Override // com.bytedance.android.live.soloktv.viewmodel.c
    public final void b(final od r100, final int r110) {
        Intrinsics.checkNotNullParameter(r100, "info");
        String r101 = "onMvDownLoadFail:" + r100;
        Intrinsics.checkNotNullParameter(r101, "str");
        ALogger.e("ktv-opus", r101);
        UtilityKotlinExtentionsKt.s(0, false, false, new MvControlTabWrapper$initView$7$onMvDownLoadFail$1(this, r100, r110), 7);
    }

    @Override // com.bytedance.android.live.soloktv.viewmodel.c
    public final void a(final od r110, final String r111, final String r112, final int r113) {
        Intrinsics.checkNotNullParameter(r110, "info");
        Intrinsics.checkNotNullParameter(r111, DBDefinition.SAVE_PATH);
        Intrinsics.checkNotNullParameter(r112, "category");
        com.bytedance.android.live.ktv.common.util.g.f("onMvDownLoadSuccess:" + r110);
        UtilityKotlinExtentionsKt.s(0, false, false, new MvControlTabWrapper$initView$7$onMvDownLoadSuccess$1(this, r110, r111, r112, r113), 7);
    }
}
