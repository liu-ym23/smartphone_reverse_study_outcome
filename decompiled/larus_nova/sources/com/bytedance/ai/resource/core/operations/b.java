package com.bytedance.ai.resource.core.operations;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements Function1<Throwable, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference<i<String>> f37478a;

    public b(AtomicReference<i<String>> r100) {
        this.f37478a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Throwable r100) {
        this.f37478a.set(null);
        return Unit.INSTANCE;
    }
}
