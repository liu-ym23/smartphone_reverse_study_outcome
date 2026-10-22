package com.bytedance.android.live.liveinteract.bgComponent.theme;

import com.bytedance.android.livesdkapi.depend.model.live.audio.ThemeUpLoadListener;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes46.dex */
public final class k implements km3.g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f71775a;

    public k(j r100) {
        this.f71775a = r100;
    }

    @Override // km3.g.a
    public final void onClose() {
        WeakReference<ThemeUpLoadListener> r100 = this.f71775a.f71754g;
        if (r100 == null) goto L7;
        ThemeUpLoadListener r101 = r100.get();
        if (r101 == null) goto L7;
        r101.onUploadFailed();
    L7:
        Disposable r102 = this.f71775a.f71753f;
        if (r102 == null) goto L11;
        r102.dispose();
        return;
    }
}
