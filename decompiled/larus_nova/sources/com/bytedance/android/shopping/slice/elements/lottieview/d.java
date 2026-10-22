package com.bytedance.android.shopping.slice.elements.lottieview;

import android.content.Context;
import com.bytedance.android.ec.core.widget.ECLottieAnimationView;
import com.bytedance.android.ecom.arch.slice.render.widget.roundcorner.SlcRoundFrameLayout;
import com.bytedance.android.shopping.anchorv4.voavhs.e;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d extends SlcRoundFrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ECLottieAnimationView f183310c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ECDraweeView f183311d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e f183312e;

    public final e getPdpService() {
        return this.f183312e;
    }

    public d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null, 6, 0);
    }

    public final void setPdpService(e r100) {
        this.f183312e = r100;
    }
}
