package com.bytedance.android.livesdk.revenue.pushstream;

import fr2.g0;
import fr2.l1;
import kotlin.jvm.internal.Intrinsics;
import xh6.c;

/* JADX INFO: loaded from: classes11.dex */
public abstract class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f157274a;

    public abstract void b();

    public b() {
        Intrinsics.checkNotNullParameter(this, "impl");
        l1 r100 = ((g0) vh6.c.b(g0.class)).o6();
        Object r101 = null;
        if (hr2.c.class.isAssignableFrom(r100.getClass()) == true) goto L6;
        r100 = null;
    L6:
        if (r100 == null) goto L8;
        r101 = r100.a(this);
    L8:
        if (r101 != null) goto L10;
        r101 = new Object();
    L10:
        this.f157274a = r101;
    }

    @Override // xh6.c
    public final Object getReal() {
        return this.f157274a;
    }
}
