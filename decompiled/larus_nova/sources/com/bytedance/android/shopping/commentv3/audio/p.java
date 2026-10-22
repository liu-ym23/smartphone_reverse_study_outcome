package com.bytedance.android.shopping.commentv3.audio;

import com.bytedance.android.ecom.arch.slice.action.IAction;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class p implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<fc3.a> f172632a;

    public p(Function0<fc3.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "actionContextProvider");
        this.f172632a = r100;
    }

    @Override // com.bytedance.android.shopping.commentv3.audio.a
    public final void a(IAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        fc3.a r101 = this.f172632a.invoke();
        if (r101 == null) goto L6;
        r101.a(new fc3.c(r100, null, null, 14));
        return;
    }
}
