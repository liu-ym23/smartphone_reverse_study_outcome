package com.bytedance.android.livesdk.authorize;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes7.dex */
public final class c implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f104202a = null;

    static {
        f104202a = new c();
    }

    public c() {
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        AuthorizeGuideService.a();
    }
}
