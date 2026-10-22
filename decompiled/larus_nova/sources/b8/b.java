package b8;

import com.bytedance.android.annie.log.LogLevel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LogLevel f18001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Throwable f18002c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f18003d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f18000a, r101.f18000a) == true) goto L12;
        return false;
    L12:
        if (this.f18001b == r101.f18001b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f18002c, r101.f18002c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f18003d, r101.f18003d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f18000a.hashCode() * 31) + this.f18001b.hashCode()) * 31;
        Throwable r101 = this.f18002c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f18003d;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "BaseLogModel(tag=" + this.f18000a + ", level=" + this.f18001b + ", throwable=" + this.f18002c + ", msg=" + this.f18003d + ')';
    }

    public b(String r100, LogLevel r101, Throwable r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "level");
        this.f18000a = r100;
        this.f18001b = r101;
        this.f18002c = r102;
        this.f18003d = r103;
    }

    public /* synthetic */ b(String r100, LogLevel r101, Throwable r102, String r103, int r104) {
        if ((r104 & 4) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = null;
    L8:
        this(r100, r101, r102, r103);
    }
}
