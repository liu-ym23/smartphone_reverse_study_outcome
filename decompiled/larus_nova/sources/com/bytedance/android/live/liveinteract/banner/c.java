package com.bytedance.android.live.liveinteract.banner;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.core.log.ALogger;
import java.util.Arrays;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes46.dex */
public final class c extends ka0.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BannerWidget f71645c;

    @Override // ka0.b
    public final void a(HybridCard r100, String r101) {
        StringCompanionObject r102 = StringCompanionObject.INSTANCE;
        ALogger.e("BannerWidget", String.format("initBannerView, onLoadFailed failed, bannerId: %s, errMsg: %s", Arrays.copyOf(new Object[]{Long.valueOf(this.f71645c.f71638f), r101}, 2)));
        ViewGroup r103 = this.f71645c.containerView;
        if (r103 == null) goto L5;
        r103.setVisibility(8);
    L5:
        View r104 = this.f71645c.f71639g;
        if (r104 == null) goto L9;
        r104.setVisibility(8);
        return;
    }

    @Override // ka0.b
    public final void b(HybridCard r100, View r101, int r102) {
        StringCompanionObject r103 = StringCompanionObject.INSTANCE;
        ALogger.i("BannerWidget", String.format("initBannerView, onViewCreated success, bannerId: %s", Arrays.copyOf(new Object[]{Long.valueOf(this.f71645c.f71638f)}, 1)));
        ViewGroup r104 = this.f71645c.containerView;
        if (r104 == null) goto L5;
        r104.removeAllViews();
    L5:
        ViewGroup r105 = this.f71645c.containerView;
        if (r105 == null) goto L8;
        r105.addView(r100);
    L8:
        ViewGroup r106 = this.f71645c.containerView;
        if (r106 == null) goto L11;
        r106.setVisibility(0);
    L11:
        View r107 = this.f71645c.f71639g;
        if (r107 == null) goto L14;
        r107.setVisibility(0);
    L14:
        this.f71645c.xq();
    }

    public c(BannerWidget r100, Context r101, Uri r102, int r103) {
        this.f71645c = r100;
        super(r101, r102, r103);
    }
}
