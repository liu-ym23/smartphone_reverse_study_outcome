package com.bytedance.android.gamecp.business.imagechoose;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class m<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f56093a = null;

    static {
        f56093a = new m();
    }

    public m() {
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        i.b r101 = (i.b) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return r101.f56087b.f530617a;
    }
}
