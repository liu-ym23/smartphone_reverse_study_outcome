package com.bytedance.android.livesdk.log.filter;

import com.bytedance.android.livehostapi.business.IHostLiveLocalLife;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class j0 implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j0 f153300a = null;

    public j0() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void Rd() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void onRemove() {
    }

    static {
        f153300a = new j0();
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void L9(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        IHostLiveLocalLife r102 = (IHostLiveLocalLife) jc1.k.f(IHostLiveLocalLife.class);
        if (r102 == null) goto L5;
        boolean r103 = r102.useAppendExpoundCardIdInjector();
    L6:
        if (r103 == true) goto L9;
        return;
    L9:
        switch(r100.hashCode()) {
            case -1506213568: goto L33;
            case -1122536402: goto L30;
            case -1115849514: goto L27;
            case -804282046: goto L24;
            case -597919004: goto L21;
            case 21313630: goto L18;
            case 1499179894: goto L15;
            case 1499265855: goto L12;
            default: goto L61;
        };
    L61:
        return;
    L12:
        if (r100.equals("livesdk_live_show") == false) goto L53;
    L34:
        String r104 = r101.get("room_id");
        String r105 = null;
        if (r104 == null) goto L37;
        Long r106 = StringsKt.toLongOrNull(r104);
    L51:
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L48
        IHostLiveLocalLife r108 = (IHostLiveLocalLife) jc1.k.f(IHostLiveLocalLife.class);     // Catch: Throwable -> L48
        if (r108 == null) goto L46;
        if (r106 == null) goto L42;
        long r109 = r106.longValue();     // Catch: Throwable -> L48
    L43:
        String r110 = r108.getExpoundCardId(r109);     // Catch: Throwable -> L48
        if (r110 == null) goto L46;
        r105 = r101.put("explain_product_id", r110);     // Catch: Throwable -> L48
        goto L46
    L42:
        r109 = 0;
    L46:
        Result.m9449constructorimpl(r105);     // Catch: Throwable -> L48
        return;
    L48:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L37:
        r106 = null;
        goto L51
    L53:
        return;
    L15:
        if (r100.equals("livesdk_live_play") == true) goto L34;
        return;
    L18:
        if (r100.equals("livesdk_audience_live_message") == true) goto L34;
        return;
    L21:
        if (r100.equals("livesdk_live_click_user") == true) goto L34;
        return;
    L24:
        if (r100.equals("livesdk_follow") == true) goto L34;
        return;
    L27:
        if (r100.equals("livesdk_live_duration") == true) goto L34;
        return;
    L30:
        if (r100.equals("livesdk_share") == true) goto L34;
        return;
    L33:
        if (r100.equals("livesdk_lottery_participate_click") == true) goto L34;
        return;
    L5:
        r103 = false;
        goto L6
    }
}
