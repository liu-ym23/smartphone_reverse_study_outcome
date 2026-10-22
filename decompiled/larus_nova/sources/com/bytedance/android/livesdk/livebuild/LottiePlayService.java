package com.bytedance.android.livesdk.livebuild;

import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.room.m;
import com.bytedance.common.utility.UIUtils;
import org.json.JSONObject;
import rg2.a;
import rg2.d;
import rg2.g;

/* JADX INFO: loaded from: classes10.dex */
public class LottiePlayService implements m {
    private g lottieHelper;

    public LottiePlayService() {
    }

    @Override // com.bytedance.android.live.room.m, com.bytedance.android.live.room.o
    public void startLotteryAnimation(JSONObject r100, LottieAnimationView r101) {
        if (this.lottieHelper != null) goto L5;
        this.lottieHelper = new g();
    L5:
        this.lottieHelper.getClass();
        if (r100 == null) goto L15;
        if (r101 == null) goto L16;
        UIUtils.setViewVisibility(r101, 0);
        r101.cancelAnimation();
        r101.setProgress(0.0f);
        d r102 = (d) a.a(d.class);     // Catch: Exception -> L12
        r101.getContext();     // Catch: Exception -> L12
        r102.a();     // Catch: Exception -> L12
        return;
    L17:
        return;
    L16:
        return;
    }

    public void startLotteryFullAnimation(vl2.m r100, LottieAnimationView r101, boolean r102) {
        if (this.lottieHelper != null) goto L5;
        this.lottieHelper = new g();
    L5:
        this.lottieHelper.a(r100, r101, r102);
    }
}
