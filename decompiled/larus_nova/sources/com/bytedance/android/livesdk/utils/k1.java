package com.bytedance.android.livesdk.utils;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class k1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f159005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j1 f159006b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<View, Unit> f159007c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<View, Unit> f159008d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f159009e;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f159005a == true) goto L8;
        this.f159008d.invoke(r100);
        return;
    L8:
        this.f159005a = false;
        r100.postDelayed(this.f159006b, this.f159009e);
        this.f159007c.invoke(r100);
    }

    public k1(Function1 r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "onClickable");
        Intrinsics.checkNotNullParameter(r101, "onNotClickable");
        this.f159007c = r100;
        this.f159008d = r101;
        this.f159009e = 3000;
        this.f159005a = true;
        this.f159006b = new j1(this);
    }
}
