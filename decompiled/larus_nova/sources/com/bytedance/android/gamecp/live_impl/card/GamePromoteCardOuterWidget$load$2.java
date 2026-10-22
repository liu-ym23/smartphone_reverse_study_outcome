package com.bytedance.android.gamecp.live_impl.card;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "msg", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class GamePromoteCardOuterWidget$load$2 extends Lambda implements Function2<Integer, String, Unit> {
    final /* synthetic */ xr.l $lifecycle;

    public GamePromoteCardOuterWidget$load$2(xr.l r100) {
        super(2);
    }

    public final void invoke(int r100, String r101) {
        if (r101 != null) goto L4;
    L7:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        throw null;
    L11:
        throw null;
    L4:
        if (r101.length() == 0) goto L7;
        r102 = false;
        goto L9
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer r100, String r101) {
        invoke(r100.intValue(), r101);
        return Unit.INSTANCE;
    }
}
