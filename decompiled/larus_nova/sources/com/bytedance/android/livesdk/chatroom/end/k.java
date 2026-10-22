package com.bytedance.android.livesdk.chatroom.end;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class k<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveCoverStreamPlayView f106081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LifecycleOwner f106082b;

    public k(LiveCoverStreamPlayView r100, LifecycleOwner r101) {
        this.f106081a = r100;
        this.f106082b = r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (Intrinsics.areEqual((Boolean) r100, Boolean.TRUE) == false) goto L9;
        LivePlayerView r101 = this.f106081a.f105913b;
        if (r101 == null) goto L7;
        r101.setVisibility(0);
    L7:
        LiveCoverStreamPlayView r102 = this.f106081a;
        System.currentTimeMillis();
        r102.getClass();
        return;
    }
}
