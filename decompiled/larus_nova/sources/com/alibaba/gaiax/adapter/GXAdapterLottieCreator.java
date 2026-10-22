package com.alibaba.gaiax.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsoluteLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/alibaba/gaiax/adapter/GXAdapterLottieCreator;", "", "()V", "localCreateLottieView", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "GaiaX-Adapter"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXAdapterLottieCreator {
    public static final GXAdapterLottieCreator INSTANCE = null;

    static {
        INSTANCE = new GXAdapterLottieCreator();
    }

    private GXAdapterLottieCreator() {
    }

    public final View localCreateLottieView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        View r101 = LayoutInflater.from(r100).inflate(R.layout.gaiax_inner_lottie_auto_play, null);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
        LottieAnimationView r102 = (LottieAnimationView) r101;
        r102.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, -1, 0, 0));
        return r102;
    }
}
