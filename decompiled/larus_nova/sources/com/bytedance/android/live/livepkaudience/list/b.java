package com.bytedance.android.live.livepkaudience.list;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes46.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f82086a;

    public b() {
        this.f82086a = null;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function1 r101 = this.f82086a;
        if (r101 == null) goto L6;
        Unit r102 = (Unit) r101.invoke(r100);
        return;
    }
}
