package com.bytedance.android.ec.core.arch.state;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes43.dex */
public final class d<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f43867a;

    public d(Function1 r100) {
        this.f43867a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        A r101 = ((f) r100).f43869a;
        this.f43867a.invoke(r101);
    }
}
