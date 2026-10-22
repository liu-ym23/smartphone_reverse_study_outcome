package com.bytedance.android.live.revlink.impl.multianchor.connect;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements gq2.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f93161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f93162b;

    @Override // gq2.c
    public final void onSuccess() {
        this.f93161a.invoke();
    }

    @Override // gq2.c
    public final void onFailed(int r100) {
        this.f93162b.invoke(Integer.valueOf(r100));
    }

    public a(Function0 r100, Function1 r101) {
        this.f93161a = r100;
        this.f93162b = r101;
    }
}
