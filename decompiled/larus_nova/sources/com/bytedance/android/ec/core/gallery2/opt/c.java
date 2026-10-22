package com.bytedance.android.ec.core.gallery2.opt;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes43.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f44091a;

    public c(d r100) {
        this.f44091a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function0<Unit> r101 = this.f44091a.f44094c;
        if (r101 == null) goto L6;
        Unit r102 = r101.invoke();
        return;
    }
}
