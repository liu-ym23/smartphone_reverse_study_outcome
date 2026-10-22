package com.bytedance.android.livesdk.gift.platform.business.jsbridge.methods;

import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.livesdk.gift.platform.core.model.SendGiftSource;
import com.bytedance.android.livesdk.gift.platform.core.model.SendGiftStrategy;
import com.bytedance.android.livesdk.gift.platform.core.model.b0;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class y extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f129745a;

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        Disposable r100 = this.f129745a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isDisposed() == true) goto L11;
        Disposable r101 = this.f129745a;
        if (r101 == null) goto L12;
        r101.dispose();
        return;
    L12:
        return;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onDestroy() {
        super.onDestroy();
        Disposable r100 = this.f129745a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isDisposed() == true) goto L11;
        Disposable r101 = this.f129745a;
        if (r101 == null) goto L12;
        r101.dispose();
        return;
    L12:
        return;
    }

    public y() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(JSONObject r610, CallContext r611) {
        JSONObject r100 = r610;
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r611, PerfLog.PARAM_KEY_CONTEXT_ID);
        long r101 = r100.optLong("propID", 0);
        int r102 = r100.optInt("count", 0);
        String r210 = r100.optString("ref_id", "");
        String r110 = r100.optString("gift_source", "jsbpage");
        if (r101 <= 0) goto L7;
        if (r102 <= 0) goto L8;
        String r111 = null;
        String r112 = null;
        String r113 = null;
        int r114 = 0;
        String r115 = null;
        ArrayList r116 = null;
        boolean r211 = false;
        SendGiftStrategy r212 = null;
        int r213 = 0;
        this.f129745a = ((IGiftService) jc1.k.n(IGiftService.class)).sendProp(new b0(r101, SendGiftSource.JsbPage, null, null, 0, 0, r110, r111, r112, r113, r114, r115, r116, r211, r212, r213, true, r210, 0, null, false, null, false, 0, null, null, null, null, null, null, null, null, 0, 0, null, null, false, null, null, null, null, null, null, false, null, null, null, null, 0, null, null, -196676, 8388607), r102).observeOn(AndroidSchedulers.mainThread()).subscribe(new w(this), new x(this));
        return;
    L8:
        return;
    }
}
