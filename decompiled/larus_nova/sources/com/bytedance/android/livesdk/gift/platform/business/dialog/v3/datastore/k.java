package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class k<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f127304a = null;

    static {
        f127304a = new k();
    }

    public k() {
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        ds2.d r101 = (ds2.d) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        if (r101.f469851b != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.f469850a == false) goto L7;
        return true;
    }
}
