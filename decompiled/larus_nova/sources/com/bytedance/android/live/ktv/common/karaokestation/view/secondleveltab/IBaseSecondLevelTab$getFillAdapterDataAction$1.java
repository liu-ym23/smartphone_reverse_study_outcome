package com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab;

import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\n\u001a\u00020\u00072\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "Lcom/bytedance/android/livesdk/message/model/MusicPanel;", "musicList", "", "data", "Lcom/bytedance/android/live/ktv/common/karaokestation/model/y;", "secondLevelTabData", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/util/List;Ljava/util/List;Lcom/bytedance/android/live/ktv/common/karaokestation/model/y;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class IBaseSecondLevelTab$getFillAdapterDataAction$1 extends Lambda implements Function3<List<MusicPanel>, List<Object>, y, Unit> {
    public static final IBaseSecondLevelTab$getFillAdapterDataAction$1 INSTANCE = null;

    static {
        INSTANCE = new IBaseSecondLevelTab$getFillAdapterDataAction$1();
    }

    public IBaseSecondLevelTab$getFillAdapterDataAction$1() {
        super(3);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<MusicPanel> r100, List<Object> r101, y r102) {
        Intrinsics.checkNotNullParameter(r100, "musicList");
        Intrinsics.checkNotNullParameter(r101, "data");
        Intrinsics.checkNotNullParameter(r102, "secondLevelTabData");
        r101.addAll(r100);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(List<MusicPanel> r100, List<Object> r101, y r102) {
        invoke2(r100, r101, r102);
        return Unit.INSTANCE;
    }
}
