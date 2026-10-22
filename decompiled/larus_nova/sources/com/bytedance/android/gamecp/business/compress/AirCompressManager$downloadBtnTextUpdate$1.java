package com.bytedance.android.gamecp.business.compress;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class AirCompressManager$downloadBtnTextUpdate$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $checkSumAndChannelInfoErrno;
    final /* synthetic */ String $gameId;

    public AirCompressManager$downloadBtnTextUpdate$1(String r100, int r101) {
        this.$gameId = r100;
        this.$checkSumAndChannelInfoErrno = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        boolean r100 = AirCompressManager.f52225a;
        Map<String, List<com.bytedance.android.gamecp.base.core.service.depend.b>> r101 = AirCompressManager.f52231g;
        LinkedHashMap r102 = (LinkedHashMap) r101;
        List r103 = (List) r102.get(this.$gameId);
        if (r103 == null) goto L8;
        Iterator r104 = r103.iterator();
    L6:
        if (r104.hasNext() == false) goto L10;
        ((com.bytedance.android.gamecp.base.core.service.depend.b) r104.next()).onAirCompressSuccess(this.$checkSumAndChannelInfoErrno);
        goto L6
    L10:
        return;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
