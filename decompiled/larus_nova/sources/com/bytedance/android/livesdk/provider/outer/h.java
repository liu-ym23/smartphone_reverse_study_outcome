package com.bytedance.android.livesdk.provider.outer;

import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class h<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f156744a;

    public h(e r100) {
        this.f156744a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if ((!Intrinsics.areEqual((Boolean) r100, Boolean.TRUE)) == true) goto L12;
        e r101 = this.f156744a;
        if (r101.f156729k == false) goto L10;
        LivePlayerView r102 = r101.f156721c;
        if (r102 == null) goto L10;
        r102.setVisibility(0);
    L10:
        this.f156744a.getLiveStatusListener();
        e r103 = this.f156744a;
        r103.setMute(r103.f156734p);
        return;
    }
}
