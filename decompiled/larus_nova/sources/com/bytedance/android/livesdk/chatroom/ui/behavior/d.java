package com.bytedance.android.livesdk.chatroom.ui.behavior;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class d<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f112653a = null;

    static {
        f112653a = new d();
    }

    public d() {
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        Boolean r101 = (Boolean) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return r101.booleanValue();
    }
}
