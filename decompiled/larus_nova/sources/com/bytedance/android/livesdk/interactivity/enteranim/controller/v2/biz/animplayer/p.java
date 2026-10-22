package com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer;

import com.bytedance.android.live.profit.player.profilepreview.ProfilePreviewEvent;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class p<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Mp4EnhancedEnterPlayer f136701a;

    public p(Mp4EnhancedEnterPlayer r100) {
        this.f136701a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ProfilePreviewEvent r101 = (ProfilePreviewEvent) r100;
        if ((r101.f88353b instanceof uu0.b.a) == false) goto L17;
        ProfilePreviewEvent.EventType r102 = r101.getType();
        int r103 = o.f136700a[r102.ordinal()];
        if (r103 != 1) goto L8;
        Mp4EnhancedEnterPlayer r104 = this.f136701a;
        r104.f136619e = true;
        Disposable r105 = r104.f136620f;
        if (r105 == null) goto L16;
        r105.dispose();
        return;
    L16:
        return;
    L8:
        if (r103 != 2) goto L18;
        this.f136701a.f136619e = false;
        return;
    L18:
        return;
    }
}
