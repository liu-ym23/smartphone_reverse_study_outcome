package com.bytedance.android.livesdk.chatroom.replay.toolbar.presenter;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f110163a;

    public g(View r100) {
        this.f110163a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Drawable r101 = (Drawable) r100;
        View r102 = this.f110163a.findViewById(R.id.icon);
        if (r102 == null) goto L6;
        r102.setBackgroundDrawable(r101);
        return;
    }
}
