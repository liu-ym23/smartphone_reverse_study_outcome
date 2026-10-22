package com.airbnb.lottie;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile i f24785a;

    public static final class a {
    }

    static {
    }

    public i() {
    }

    public static final i a() {
        if (f24785a == null) goto L5;
    L15:
        i r100 = f24785a;
        if (r100 != null) goto L18;
        Intrinsics.throwNpe();
    L18:
        return r100;
    L5:
        monitor-enter(i.class);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (f24785a != null) goto L9;
        f24785a = new i();     // Catch: Throwable -> L12
    L9:
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(i.class);
        goto L15
    }
}
