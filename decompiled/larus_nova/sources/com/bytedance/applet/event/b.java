package com.bytedance.applet.event;

import java.util.Arrays;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final /* synthetic */ class b implements Function3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f191810a;

    public /* synthetic */ b(Function1 r100) {
        this.f191810a = r100;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object r100, Object r101, Object r102) {
        Function1 r103 = this.f191810a;
        int r104 = ((Integer) r100).intValue();
        String r105 = (String) r101;
        Intrinsics.checkNotNullParameter(r105, "message");
        return Boolean.valueOf(((Boolean) r103.invoke(String.format("{\"code\": %d,\"msg\": \"%s\", \"data\": \"%s\"}", Arrays.copyOf(new Object[]{Integer.valueOf(r104), r105, (String) r102}, 3)))).booleanValue());
    }
}
