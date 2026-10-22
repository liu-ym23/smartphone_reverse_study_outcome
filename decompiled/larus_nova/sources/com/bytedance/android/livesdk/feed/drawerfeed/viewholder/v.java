package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class v extends b7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DrawerLynxViewHolder f123987a;

    public v(DrawerLynxViewHolder r100) {
        this.f123987a = r100;
    }

    @Override // b7.a, b7.b
    public final void onLoadSuccess(View r100) {
        super.onLoadSuccess(r100);
        DrawerLynxViewHolder r101 = this.f123987a;
        r101.f123917h.post(new x(r101));
        ALogger.i(this.f123987a.a4(), "onLoadSuccess");
    }

    @Override // b7.a, b7.b
    public final boolean onFallback(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        DrawerLynxViewHolder r102 = this.f123987a;
        r102.f123917h.post(new w(r102));
        ALogger.e(this.f123987a.a4(), "onFallback  " + r100 + "   " + r101);
        return super.onFallback(r100, r101);
    }
}
