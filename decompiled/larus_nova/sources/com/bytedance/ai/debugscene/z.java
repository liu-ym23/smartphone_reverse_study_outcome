package com.bytedance.ai.debugscene;

import com.bytedance.ai.model.objects.Widget;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class z implements Function1<Throwable, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.i<Widget> f36568a;

    public z(kotlinx.coroutines.j r100) {
        this.f36568a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        this.f36568a.resumeWith(Result.m9449constructorimpl(null));
        return Unit.INSTANCE;
    }
}
