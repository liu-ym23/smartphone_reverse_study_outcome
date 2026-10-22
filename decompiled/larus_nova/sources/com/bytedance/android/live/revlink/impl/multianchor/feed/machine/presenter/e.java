package com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Unit;

/* JADX INFO: loaded from: classes47.dex */
public final class e<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f94255a;

    public e(a r100) {
        this.f94255a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Unit r101 = (Unit) r100;
        a r102 = this.f94255a;
        mx0.a r103 = r102.f94246q.f569772c;
        if (r102.f94231b == false) goto L7;
        if (r103 == null) goto L8;
        r102.d(r103);
        return;
    L8:
        return;
    }
}
