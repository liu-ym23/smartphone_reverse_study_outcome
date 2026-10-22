package com.bytedance.android.livesdk.preview;

import com.bytedance.android.livesdkapi.roomplayer.IPreviewStateListener;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes11.dex */
public final class h1<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LivePurePreviewView f156556a;

    public h1(LivePurePreviewView r100) {
        this.f156556a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        String r101 = (String) r100;
        IPreviewStateListener r102 = this.f156556a.f156410l;
        if (r102 == null) goto L6;
        r102.onPlayError(r101);
        return;
    }
}
