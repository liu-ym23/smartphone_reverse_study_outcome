package com.airbnb.lottie;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class A {

    /* renamed from: a, reason: collision with root package name */
    public final Object f4519a;

    /* renamed from: b, reason: collision with root package name */
    public final Throwable f4520b;

    public A(LottieComposition lottieComposition) {
        this.f4519a = lottieComposition;
        this.f4520b = null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof A)) {
            return false;
        }
        A a4 = (A) obj;
        Object obj2 = this.f4519a;
        if (obj2 != null && obj2.equals(a4.f4519a)) {
            return true;
        }
        Throwable th = this.f4520b;
        if (th == null || a4.f4520b == null) {
            return false;
        }
        return th.toString().equals(th.toString());
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4519a, this.f4520b});
    }

    public A(Throwable th) {
        this.f4520b = th;
        this.f4519a = null;
    }
}
