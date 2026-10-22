package ch0;

import com.bytedance.android.livesdk.message.model.f6;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f23751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f6 f23752b;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == false) goto L10;
        l r101 = (l) r100;
        if (this.f23751a == r101.f23751a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f23752b, r101.f23752b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f23751a * 31;
        f6 r101 = this.f23752b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "audienceLimit = " + this.f23751a + ", anchorInfo = " + this.f23752b;
    }

    public l(int r100, f6 r101) {
        this.f23751a = r100;
        this.f23752b = r101;
    }
}
