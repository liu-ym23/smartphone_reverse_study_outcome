package com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom;

import com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.ui.TouchEventFrameLayout;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PortraitHorizontalLinkedCameraTetris f159637a;

    public k(PortraitHorizontalLinkedCameraTetris r100) {
        this.f159637a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        TouchEventFrameLayout r102 = this.f159637a.f159596p;
        if (r102 != null) goto L5;
    L7:
        this.f159637a.W(false);
        return;
    L5:
        if (r102.getAnyTouchEvent() != true) goto L7;
    }
}
