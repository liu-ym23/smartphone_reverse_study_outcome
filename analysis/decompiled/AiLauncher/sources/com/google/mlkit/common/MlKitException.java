package com.google.mlkit.common;

import com.google.android.gms.common.internal.C1669j;

/* loaded from: classes2.dex */
public class MlKitException extends Exception {

    /* renamed from: a, reason: collision with root package name */
    public final int f21802a;

    public MlKitException(String str, int i10) {
        super(C1669j.f(str, "Provided message must not be empty."));
        this.f21802a = i10;
    }

    public int a() {
        return this.f21802a;
    }

    public MlKitException(String str, int i10, Throwable th) {
        super(C1669j.f(str, "Provided message must not be empty."), th);
        this.f21802a = i10;
    }
}
