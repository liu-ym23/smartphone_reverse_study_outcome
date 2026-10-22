package com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Unit;

/* JADX INFO: loaded from: classes47.dex */
public final class f<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f94256a;

    public f(a r100) {
        this.f94256a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Unit r101 = (Unit) r100;
        a r102 = this.f94256a;
        r102.b(r102.f94243n);
    }
}
