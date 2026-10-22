package com.bytedance.android.anya;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.SubStatePropertyImpl;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes43.dex */
@AnyaDSL
public final class k<STATE extends MVIState<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final STATE f41738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DiffContext f41739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.anya.internal.s<STATE> f41740c;

    public k() {
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends MVIState<?>> k<T> a(u0<?, T> r100) {
        com.bytedance.android.anya.internal.s<STATE> r101 = this.f41740c;
        if (r101.f41710e == false) goto L9;
        com.bytedance.android.anya.internal.s<?> r102 = r101.f41707b.get(r100);
        if ((r102 instanceof com.bytedance.android.anya.internal.s) == true) goto L7;
        r102 = null;
    L7:
        com.bytedance.android.anya.internal.s<?> r103 = r102;
    L15:
        if (r103 != null) goto L17;
        return null;
    L17:
        return new k(r103.f41708c, this.f41739b, r103);
    L9:
        if (r101.f41709d == false) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == false) goto L14;
        r103 = new com.bytedance.android.anya.internal.s((MVIState) ((SubStatePropertyImpl) r100).c(), r101.f41709d, false, null);
        goto L15
    L14:
        r103 = null;
        goto L15
    L11:
        r104 = CollectionsKt.contains(r101.f41708c.modifiedProperties, r100);
        goto L12
    }

    public k(MVIState r100, DiffContext r101, boolean r102) {
        this(r100, r101, new com.bytedance.android.anya.internal.s(r100, r102, false, null));
    }

    public k(STATE r100, DiffContext r101, com.bytedance.android.anya.internal.s<STATE> r102) {
        this.f41738a = r100;
        this.f41739b = r101;
        this.f41740c = r102;
    }
}
