package a30;

import com.bytedance.android.live.browser.jsbridge.base.LiveUpdateEffectGameStateResultModel;
import com.bytedance.android.livesdk.gift.platform.business.effect.service.EffectGameStatus;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import i12.o;
import kotlin.jvm.internal.Intrinsics;
import w20.kb;
import w20.q3;

/* JADX INFO: loaded from: classes45.dex */
public final class c extends q3<kb, LiveUpdateEffectGameStateResultModel> {
    public c() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r110, CallContext r111) {
        kb r112 = (kb) r110;
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        i12.e r113 = o.b();
        EffectGameStatus r100 = null;
        if (r113 == null) goto L5;
        Object r114 = com.bytedance.android.scope.m.f163449e.d(r113, l02.e.class);
    L6:
        l02.e r115 = (l02.e) r114;
        if (r115 == null) goto L26;
        Integer r101 = r112.c();
        Integer r102 = r112.b();
        String r116 = r112.a();
        EffectGameStatus.Companion.getClass();
        EffectGameStatus[] r103 = EffectGameStatus.values();
        int r104 = r103.length;
        int r105 = 0;
    L9:
        if (r105 >= r104) goto L20;
        EffectGameStatus r106 = r103[r105];
        int r107 = r106.getValue();
        if (r101 != null) goto L14;
    L16:
        boolean r108 = false;
    L17:
        if (r108 == true) goto L18;
        r105 = r105 + 1;
        goto L9
    L18:
        r100 = r106;
        goto L20
    L14:
        if (r107 != r101.intValue()) goto L16;
        r108 = true;
    L20:
        if (r100 != null) goto L22;
        r100 = EffectGameStatus.IDLE;
    L22:
        r115.f506856a = r100;
        r115.f506857b = r102;
        r115.f506858c = r116;
        return;
    L26:
        return;
    L5:
        r114 = null;
        goto L6
    }
}
