package com.bytedance.android.livesdk.dynamic;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livehostapi.business.depend.locallife.ILiveLocalLifeService;
import com.bytedance.android.livehostapi.business.depend.locallife.ShortTermState;
import com.bytedance.android.livesdk.gameguess.widget.GameGuessPredictorWidget;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public class a implements IDynamicExternalService {
    public a() {
    }

    @Override // com.bytedance.android.livesdk.dynamic.IDynamicExternalService
    public Class<? extends Widget> getGameGuessPredictorWidget() {
        return GameGuessPredictorWidget.class;
    }

    @Override // com.bytedance.android.livesdk.dynamic.IDynamicExternalService
    public void liveLocalLifeSetShortTermState(FragmentActivity r100, ShortTermState r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "state");
        ILiveService r102 = TTLiveService.getLiveService();
        if (r102 == null) goto L8;
        ILiveLocalLifeService r103 = (ILiveLocalLifeService) r102.liveLocalLifeService(ILiveLocalLifeService.class);
        if (r103 == null) goto L9;
        r103.setShortTermState(r100, r101);
        return;
    L9:
        return;
    }
}
