package com.bytedance.android.live.soloktv.karaokestation.view;

import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
final class SoloKtvHomeFragment$updateSecondLevelTabSongList$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.c $secondLevelTab;
    final /* synthetic */ y $secondLevelTabData;

    public SoloKtvHomeFragment$updateSecondLevelTabSongList$1(com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.c r100, y r101) {
        this.$secondLevelTab = r100;
        this.$secondLevelTabData = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.c r100 = this.$secondLevelTab;
        r100.ok(this.$secondLevelTabData, r100.ms(null));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
