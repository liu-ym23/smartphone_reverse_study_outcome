package com.bytedance.android.livesdk.widgetdescriptor.delegate.element;

import com.bytedance.android.livesdk.chatroom.ui.VideoViewParams;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes11.dex */
public final class c<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f162370a;

    public c(b r100) {
        this.f162370a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        VideoViewParams r101 = (VideoViewParams) r100;
        if (r101 == null) goto L6;
        this.f162370a.e(r101);
        return;
    }
}
