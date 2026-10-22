package com.bytedance.android.livesdk.lottie;

/* JADX INFO: loaded from: classes10.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f153475a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == true) goto L6;
        return false;
    L6:
        if (this.f153475a == ((i) r100).f153475a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        boolean r100 = this.f153475a;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public final String toString() {
        return "FinishLottieAnimationEvent(finish=" + this.f153475a + ")";
    }

    public i() {
        this.f153475a = true;
    }
}
