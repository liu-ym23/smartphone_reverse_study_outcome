package com.bytedance.applet.utils;

import com.larus.platform.api.e5;
import com.larus.platform.api.f5;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class p implements e5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f192311a;

    public p(q r100) {
        this.f192311a = r100;
    }

    @Override // com.larus.platform.api.e5
    public final void a(f5 r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        Function1<Boolean, Unit> r101 = this.f192311a;
        String r102 = r100.f365109a;
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        r101.invoke(Boolean.valueOf(!r103));
        return;
    L5:
        if (StringsKt.isBlank(r102) == true) goto L8;
        r103 = false;
        goto L9
    }
}
