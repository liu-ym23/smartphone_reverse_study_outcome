package a30;

import com.bytedance.android.live.browser.jsbridge.base.LiveGetEffectGameStateResultModel;
import com.bytedance.android.livesdk.gift.platform.business.effect.service.EffectGameStatus;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import i12.o;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import w20.t2;

/* JADX INFO: loaded from: classes45.dex */
public final class b extends t2<JsonObject, LiveGetEffectGameStateResultModel> {
    public b() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter((JsonObject) r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        i12.e r102 = o.b();
        String r103 = null;
        if (r102 == null) goto L5;
        Object r104 = com.bytedance.android.scope.m.f163449e.d(r102, l02.e.class);
    L6:
        l02.e r105 = (l02.e) r104;
        LiveGetEffectGameStateResultModel r106 = new LiveGetEffectGameStateResultModel();
        r106.a(LiveGetEffectGameStateResultModel.Code.Success);
        LiveGetEffectGameStateResultModel.a r107 = new LiveGetEffectGameStateResultModel.a();
        if (r105 == null) goto L9;
        Integer r108 = r105.f506857b;
    L10:
        r107.b(r108);
        if (r105 == null) goto L15;
        EffectGameStatus r109 = r105.f506856a;
        if (r109 == null) goto L15;
        Integer r110 = Integer.valueOf(r109.getValue());
    L16:
        r107.c(r110);
        if (r105 == null) goto L19;
        r103 = r105.f506858c;
    L19:
        r107.a(r103);
        Unit r111 = Unit.INSTANCE;
        r106.b(r107);
        finishWithResult(r106);
        return;
    L15:
        r110 = null;
        goto L16
    L9:
        r108 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }
}
