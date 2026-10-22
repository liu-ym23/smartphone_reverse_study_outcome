package com.bytedance.android.live.soloktv.karaokestation.view;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class n extends ka0.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakReference<ViewGroup> f101342c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f101343d;

    @Override // ka0.b
    public final void a(HybridCard r100, String r101) {
        ALogger.e("BannerWidget", "initBannerView, onLoadFailed failed, infoLynxUrl: " + this.f101343d + ", errMsg: " + r101);
        ViewGroup r102 = this.f101342c.get();
        if (r102 == null) goto L6;
        r102.setVisibility(8);
        return;
    }

    @Override // ka0.b
    public final void b(HybridCard r100, View r101, int r102) {
        ALogger.i("BannerWidget", "initRTChorusLaunchPage onViewCreated success, infoLynxUrl: " + this.f101343d);
        ViewGroup r103 = this.f101342c.get();
        if (r103 == null) goto L5;
        r103.removeAllViews();
    L5:
        ViewGroup r104 = this.f101342c.get();
        if (r104 == null) goto L8;
        r104.addView(r100);
    L8:
        ViewGroup r105 = this.f101342c.get();
        if (r105 == null) goto L12;
        r105.setVisibility(0);
        return;
    }

    public n(WeakReference<ViewGroup> r100, String r101, Context r102, Uri r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "finalLynxUrl");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "originUri");
        super(r102, r103, r104);
        this.f101342c = r100;
        this.f101343d = r101;
    }
}
