package com.bytedance.android.livesdk.chatroom.replay.player.seekbar;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class g<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f109743a = null;

    static {
        f109743a = new g();
    }

    public g() {
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        Boolean r101 = (Boolean) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return r101.booleanValue();
    }
}
