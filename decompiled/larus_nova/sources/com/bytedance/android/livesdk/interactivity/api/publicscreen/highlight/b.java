package com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight;

import android.content.Context;
import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: classes9.dex */
public abstract class b implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f133429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k f133430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.live.datacontext.j<vlc.d> f133431c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f133432d;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.i
    public void a() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.i
    public void b() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.i
    public void onUnload() {
        this.f133429a = null;
        this.f133430b = null;
        this.f133432d.clear();
    }

    public b() {
        this.f133432d = new CompositeDisposable();
    }

    public final Context getContext() {
        return this.f133429a;
    }
}
