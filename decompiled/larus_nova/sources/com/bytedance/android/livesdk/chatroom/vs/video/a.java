package com.bytedance.android.livesdk.chatroom.vs.video;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdkapi.hybridapi.SubscriberJsEvent;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FullHybridViewFragment f117833a;

    public a(FullHybridViewFragment r100) {
        this.f117833a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        SubscriberJsEvent r101 = (SubscriberJsEvent) r100;
        FragmentActivity r102 = this.f117833a.getActivity();
        if (r102 == null) goto L6;
        r102.finish();
        return;
    }
}
