package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ogc;

import android.graphics.drawable.Drawable;
import android.view.View;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OgcVSWebActivityBehavior f116646a;

    public d(OgcVSWebActivityBehavior r100) {
        this.f116646a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Drawable r101 = (Drawable) r100;
        View r102 = this.f116646a.f116629g;
        if (r102 == null) goto L6;
        r102.setBackgroundDrawable(r101);
        return;
    }
}
