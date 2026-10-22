package com.bytedance.android.livesdk.widget;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class z1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MagicGestureActivityAudienceWidget f162271a;

    public z1(MagicGestureActivityAudienceWidget r100) {
        this.f162271a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        ALogger.e("MagicGestureActivityAudienceWidget", "autoClearMagicClickRect is running ");
        MagicGestureActivityAudienceWidget r102 = this.f162271a;
        int r103 = MagicGestureActivityAudienceWidget.f161203i;
        r102.getClass();
        ALogger.e("MagicGestureActivityAudienceWidget", "clearMagicClickRect is running ");
        r102.f161204a = null;
        r102.f161209f = null;
        GestureDetectLayout r104 = r102.f161206c;
        if (r104 == null) goto L6;
        r104.removeView(r102.f161205b);
        return;
    }
}
