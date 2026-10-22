package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.manager;

import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.KtvComponentUIContext;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.n;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000*\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lvb0/a;", AbsMethodDelegate.TAG_INVOKE, "(Lvb0/a;)Lvb0/a;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class KtvComponentFirstLevelTabManager$updateOrderSongUnreadCount$1 extends Lambda implements Function1<vb0.a, vb0.a> {
    public static final KtvComponentFirstLevelTabManager$updateOrderSongUnreadCount$1 INSTANCE = null;

    static {
        INSTANCE = new KtvComponentFirstLevelTabManager$updateOrderSongUnreadCount$1();
    }

    public KtvComponentFirstLevelTabManager$updateOrderSongUnreadCount$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final vb0.a invoke2(vb0.a r110) {
        Intrinsics.checkNotNullParameter(r110, "$receiver");
        KtvComponentContext r100 = KtvComponentContext.Companion.getContext();
        if (r100 == null) goto L13;
        n<KtvComponentUIContext> r101 = r100.getKtvComponentUIContext();
        if (r101 == null) goto L13;
        KtvComponentUIContext r102 = r101.getValue();
        if (r102 == null) goto L13;
        NextLiveData<Integer> r103 = r102.getOrderSongUnReadNum();
        if (r103 == null) goto L13;
        Integer r104 = r103.getValue();
        if (r104 == null) goto L13;
        long r105 = r104.intValue();
    L15:
        return vb0.a.a(r110, Long.valueOf(r105), null, null, null, null, null, null, null, null, false, 1022);
    L13:
        r105 = 0;
        goto L15
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ vb0.a invoke(vb0.a r100) {
        return invoke2(r100);
    }
}
