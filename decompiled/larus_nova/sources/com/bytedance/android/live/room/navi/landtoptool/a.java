package com.bytedance.android.live.room.navi.landtoptool;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LandscapeTopToolbarWidget f99715a;

    public a(LandscapeTopToolbarWidget r100) {
        this.f99715a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        c0.d r101 = (c0.d) r100;
        Intrinsics.checkNotNullParameter(r101, "event");
        View r102 = this.f99715a.f99711f.get(r101.f115860a);
        if (r102 != null) goto L5;
        return;
    L5:
        if (r101.f115861b == false) goto L7;
        r102.setAlpha(0.4f);
        return;
    L7:
        r102.setAlpha(1.0f);
    }
}
