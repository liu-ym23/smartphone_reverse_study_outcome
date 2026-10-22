package com.bytedance.android.live.lynx.ui;

/* JADX INFO: loaded from: classes46.dex */
public final class h<T> implements e76.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveLynxAlphaPlayer f82739a;

    public h(LiveLynxAlphaPlayer r100) {
        this.f82739a = r100;
    }

    @Override // e76.b
    public final void onResult(Object r100) {
        this.f82739a.Q("unknown exception, " + ((Throwable) r100), this.f82739a.f82677g, -6);
        throw null;
    }
}
