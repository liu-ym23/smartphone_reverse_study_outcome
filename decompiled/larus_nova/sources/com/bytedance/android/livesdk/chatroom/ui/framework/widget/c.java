package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import com.bytedance.android.livesdk.castscreen.views.bytecast.LiveCastControlLayout;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveCastControlLayout f113304a;

    public c(LiveCastControlLayout r100) {
        this.f113304a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        if (((Boolean) r100).booleanValue() == false) goto L5;
        this.f113304a.setVisibility(0);
        return;
    L5:
        this.f113304a.setVisibility(8);
    }
}
