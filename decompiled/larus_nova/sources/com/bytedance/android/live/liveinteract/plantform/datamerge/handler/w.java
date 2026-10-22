package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes46.dex */
public final class w<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v f76539a;

    public w(v r100) {
        this.f76539a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        sh6.b r101 = (sh6.b) r100;
        ph0.b r102 = (ph0.b) sh6.c.b(r101);
        String r103 = null;
        if (r102 == null) goto L5;
        String r104 = r102.f529232b;
    L6:
        boolean r105 = true;
        if (r104 != null) goto L9;
    L12:
        boolean r106 = true;
    L13:
        if (r106 == true) goto L25;
        ph0.b r107 = (ph0.b) sh6.c.b(r101);
        if (r107 != null) goto L17;
    L19:
        r105 = false;
    L20:
        v.d r108 = this.f76539a.f76533i;
        ph0.b r109 = (ph0.b) sh6.c.b(r101);
        if (r109 == null) goto L23;
        r103 = r109.f529232b;
    L23:
        Intrinsics.checkNotNull(r103);
        r108.c(r103, r105);
        return;
    L17:
        if (r107.f529233c != 2) goto L19;
    L25:
        return;
    L9:
        if (StringsKt.isBlank(r104) == true) goto L12;
        r106 = false;
        goto L13
    L5:
        r104 = null;
        goto L6
    }
}
