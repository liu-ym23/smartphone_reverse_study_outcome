package com.bytedance.android.livesdk.gift.platform.core;

/* JADX INFO: loaded from: classes9.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f130483a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == true) goto L6;
        return false;
    L6:
        if (Float.compare(this.f130483a, ((e) r100).f130483a) == 0) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.f130483a);
    }

    public final String toString() {
        return "DirSize(appassetsSize=" + this.f130483a + ")";
    }

    public e(float r100) {
        this.f130483a = r100;
    }
}
