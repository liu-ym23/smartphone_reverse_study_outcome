package com.bytedance.android.live.revlink.link.biz.utils;

import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.i;
import com.bytedance.android.livesdk.link.model.ILinkMicBattleInviteMessage;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class BattleInviteUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f98247a = 0;

    static {
    }

    public static a a(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a r100, final ILinkMicBattleInviteMessage r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "inviteMessage");
        Function1<com.bytedance.android.live.revlink.link.biz.service.a, a> r102 = new BattleInviteUtils$parseBattleInviteTitle$1(r101);
        Intrinsics.checkNotNullParameter(r100, "$this$holderScope");
        Intrinsics.checkNotNullParameter(r102, "scope");
        return r102.invoke(new i(r100));
    }
}
