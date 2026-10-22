package com.bytedance.android.livesdk.feed.preview;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes8.dex */
public final class d<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveFeedPreview f124296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LifecycleOwner f124297b;

    public d(LiveFeedPreview r100, LifecycleOwner r101) {
        this.f124296a = r100;
        this.f124297b = r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (((String) r100) == null) goto L7;
        LiveFeedPreview r101 = this.f124296a;
        int r102 = LiveFeedPreview.f124283h;
        r101.getClass();
        return;
    }
}
