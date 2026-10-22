package ad6;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f3024d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<c> f3026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3027c;

    /* JADX INFO: renamed from: ad6.a$a, reason: collision with other inner class name */
    public static final class C0055a {
    }

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f3025a, r101.f3025a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f3026b, r101.f3026b) == true) goto L10;
        return false;
    L10:
        if (this.f3027c == r101.f3027c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f3025a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<c> r104 = this.f3026b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return ((r103 + r101) * 31) + this.f3027c;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "CurrentSendTogetherInfo(sendTogetherId=" + this.f3025a + ", slotList=" + this.f3026b + ", currentCount=" + this.f3027c + ")";
    }

    static {
        f3024d = new a(0);
    }

    public /* synthetic */ a(int r100) {
        this(null, null, 0);
    }

    public a(String r100, List<c> r101, int r102) {
        this.f3025a = r100;
        this.f3026b = r101;
        this.f3027c = r102;
    }
}
