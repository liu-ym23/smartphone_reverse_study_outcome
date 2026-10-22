package com.bytedance.android.gamecp.business.instantplay;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "result", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class GameCpInstantPlayService$openTeamPlayMobileGame$dispose$1$2 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ String $openGameSchema;
    final /* synthetic */ String $roomId;
    final /* synthetic */ b this$0;

    public GameCpInstantPlayService$openTeamPlayMobileGame$dispose$1$2(b r100, String r101, String r102) {
        this.$roomId = r101;
        this.$openGameSchema = r102;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean r100) {
        invoke(r100.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean r100) {
        throw null;
    }
}
