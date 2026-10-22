package com.bytedance.android.live.anchorlink.utils;

import gy.f;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import nc0.s;

/* JADX INFO: loaded from: classes45.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MultiChannelOptManager f58577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f58578b;

    public b(MultiChannelOptManager r100, String r101) {
        this.f58577a = r100;
        this.f58578b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        f r102 = this.f58577a.f58575i;
        Integer r103 = null;
        if (r102 == null) goto L7;
        List<ui6.a> r104 = r102.L0();
        if (r104 == null) goto L7;
        Integer r105 = Integer.valueOf(r104.size());
    L8:
        f r106 = this.f58577a.f58575i;
        if (r106 == null) goto L14;
        s r107 = r106.L();
        if (r107 == null) goto L14;
        r103 = Integer.valueOf(r107.d());
    L14:
        if ((!Intrinsics.areEqual(r105, r103)) == false) goto L27;
        Integer r108 = this.f58577a.f58567a;
        if (r108 != null) goto L19;
    L20:
        Integer r109 = this.f58577a.f58567a;
        if (r109 != null) goto L24;
        return;
    L24:
        if (r109.intValue() != 3) goto L28;
    L25:
        MultiChannelOptManager r110 = this.f58577a;
        r110.b(r110.f58569c, this.f58578b);
        return;
    L28:
        return;
    L19:
        if (r108.intValue() == 2) goto L25;
    L27:
        return;
    L7:
        r105 = null;
        goto L8
    }
}
