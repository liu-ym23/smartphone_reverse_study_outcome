package com.bytedance.android.live.pushstream;

import com.bytedance.common.utility.StringUtils;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class k<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f89397a = null;

    static {
        f89397a = new k();
    }

    public k() {
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        String r101 = (String) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return !StringUtils.isEmpty(r101);
    }
}
