package com.bytedance.android.ec.sdk.plugin.fallback;

import com.bytedance.android.ec.core.utils.y;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements y.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f48156a;

    public a(Function1 r100) {
        this.f48156a = r100;
    }

    @Override // com.bytedance.android.ec.core.utils.y.c
    public final /* synthetic */ void accept(Object r100) {
        this.f48156a.invoke(r100);
    }
}
