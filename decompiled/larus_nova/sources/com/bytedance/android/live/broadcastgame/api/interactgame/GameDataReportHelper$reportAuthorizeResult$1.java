package com.bytedance.android.live.broadcastgame.api.interactgame;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"convertAuthResult", "", "authResult", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final class GameDataReportHelper$reportAuthorizeResult$1 extends Lambda implements Function1<String, String> {
    public static final GameDataReportHelper$reportAuthorizeResult$1 INSTANCE = null;

    static {
        INSTANCE = new GameDataReportHelper$reportAuthorizeResult$1();
    }

    public GameDataReportHelper$reportAuthorizeResult$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "authResult");
        int r101 = r100.hashCode();
        if (r101 == (-1738800519)) goto L16;
        if (r101 == (-266960777)) goto L13;
        if (r101 == 3548) goto L10;
        return r100;
    L10:
        if (r100.equals(com.bytedance.android.ec.core.event.a.VALUE_CLICK_TYPE) == false) goto L19;
        return "success";
    L19:
        return r100;
    L13:
        if (r100.equals("userDeny") == false) goto L21;
        return "user_decline";
    L21:
        return r100;
    L16:
        if (r100.equals("sysDeny") == false) goto L23;
        return "system_decline";
    L23:
        return r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(String r100) {
        return invoke2(r100);
    }
}
