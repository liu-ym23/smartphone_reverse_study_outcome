package com.bytedance.android.livesdk.widget;

/* JADX INFO: loaded from: classes11.dex */
public final class d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f161687a;

    public d1() {
        this(false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d1) == true) goto L6;
        return false;
    L6:
        if (this.f161687a == ((d1) r100).f161687a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        boolean r100 = this.f161687a;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public final String toString() {
        return "LiveGuidePageViewStatusEvent(isShowing=" + this.f161687a + ")";
    }

    public d1(boolean r100) {
        this.f161687a = r100;
    }
}
