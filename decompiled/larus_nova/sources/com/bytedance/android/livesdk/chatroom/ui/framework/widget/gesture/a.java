package com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture;

import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudienceLandscapeGestureWidget f113387a;

    public a(AudienceLandscapeGestureWidget r100) {
        this.f113387a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        AudienceLandscapeGestureWidget r101 = this.f113387a;
        List<String> r102 = AudienceLandscapeGestureWidget.A;
        r101.kr((gh1.a) r100);
    }
}
