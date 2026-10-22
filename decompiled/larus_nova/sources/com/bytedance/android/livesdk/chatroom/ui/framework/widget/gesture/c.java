package com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudiencePortraitGestureWidget f113389a;

    public c(AudiencePortraitGestureWidget r100) {
        this.f113389a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        AudiencePortraitGestureWidget r101 = this.f113389a;
        int r102 = AudiencePortraitGestureWidget.F;
        r101.nr((gh1.a) r100);
    }
}
