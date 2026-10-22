package com.bytedance.android.livesdk.interactivity.comment.mention;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f135305a = null;

    static {
        f135305a = new f();
    }

    public f() {
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        CharSequence r101 = (CharSequence) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        if (r101.length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }
}
