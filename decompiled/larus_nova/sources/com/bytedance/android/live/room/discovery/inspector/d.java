package com.bytedance.android.live.room.discovery.inspector;

import android.animation.AnimatorSet;
import android.widget.LinearLayout;
import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficialInspectorWidget f99549a;

    public d(OfficialInspectorWidget r100) {
        this.f99549a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        Disposable r102 = this.f99549a.f99537g;
        if (r102 == null) goto L5;
        r102.dispose();
    L5:
        OfficialInspectorWidget r103 = this.f99549a;
        if (r103.f99535e == true) goto L8;
        return;
    L8:
        if (r103.isViewValid() == false) goto L29;
        LinearLayout r104 = r103.f99531a;
        if (r104 == null) goto L13;
        r104.setOnClickListener(null);
    L13:
        AnimatorSet r105 = r103.f99539i;
        if (r105 != null) goto L16;
    L20:
        AnimatorSet r106 = r103.f99540j;
        if (r106 != null) goto L23;
    L25:
        r103.xq();
        return;
    L23:
        if (r106.isRunning() != true) goto L25;
        r103.f99541k = true;
        return;
    L16:
        if (r105.isRunning() != true) goto L20;
        ALogger.e("OfficialInspectorWidget", "enter room animation is running when onShowEnd");
        AnimatorSet r107 = r103.f99539i;
        if (r107 == null) goto L20;
        r107.cancel();
        goto L20
    }
}
