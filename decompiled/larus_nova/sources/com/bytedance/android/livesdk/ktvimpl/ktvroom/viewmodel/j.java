package com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes10.dex */
public final class j<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f145502a;

    public j(Function1 r100) {
        this.f145502a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Long r101 = (Long) r100;
        if (r101 == null) goto L6;
        this.f145502a.invoke(r101);
        return;
    }
}
