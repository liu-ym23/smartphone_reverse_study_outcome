package com.bytedance.android.live.revlink.impl.multianchor.connect;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements gq2.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f93163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f93164b;

    @Override // gq2.c
    public final void onSuccess() {
        this.f93163a.invoke();
    }

    @Override // gq2.c
    public final void onFailed(int r100) {
        this.f93164b.invoke(Integer.valueOf(r100));
    }

    public b(Function0 r100, Function1 r101) {
        this.f93163a = r100;
        this.f93164b = r101;
    }
}
