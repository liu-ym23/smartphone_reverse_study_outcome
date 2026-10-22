package com.bytedance.android.livesdk.feed.squarefeed;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes8.dex */
public final class h<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f124457a;

    public h(Function1 r100) {
        this.f124457a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(T r100) {
        if (r100 == null) goto L5;
        this.f124457a.invoke(r100);
        return;
    }
}
