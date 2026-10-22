package com.bytedance.android.anniex.scene.handler.idle;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b extends c<Object> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ c.a<Object> f41197j;

    @Override // com.bytedance.android.anniex.scene.handler.idle.c
    public final void a(Object r100) {
        Function1<? super Object, Unit> r101 = this.f41197j.f41214h;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("runner");
        r101 = null;
    L5:
        r101.invoke(r100);
    }

    public b(TaskType r110, c.a<Object> r111, String r112, String r113, String r114, int r115, long r210, long r211, boolean r212, Object r213) {
        this.f41197j = r111;
        super(r112, r110, r113, r114, r115, r210, r211, r212, r213);
    }
}
