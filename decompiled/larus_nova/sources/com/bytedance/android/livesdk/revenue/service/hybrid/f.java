package com.bytedance.android.livesdk.revenue.service.hybrid;

import android.net.Uri;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class f implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b7.a f157343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Uri f157344b;

    @Override // com.bytedance.android.livesdk.revenue.service.hybrid.c
    public final void onRuntimeReady() {
    }

    public f(cz0.a r100, Uri r101) {
        this.f157343a = r100;
        this.f157344b = r101;
    }

    @Override // com.bytedance.android.livesdk.revenue.service.hybrid.c
    public final void onLoadFailed(View r100, String r101) {
        b7.a r102 = this.f157343a;
        if (r102 == null) goto L6;
        r102.onLoadFail(r100, this.f157344b.toString(), r101);
        return;
    }

    @Override // com.bytedance.android.livesdk.revenue.service.hybrid.c
    public final void onLoadStart(Uri r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        b7.a r102 = this.f157343a;
        if (r102 == null) goto L6;
        r102.onLoadStart(r101, true);
        return;
    }
}
