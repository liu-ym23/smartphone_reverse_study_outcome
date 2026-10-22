package ch0;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f23713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f23714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Integer> f23715c;

    /* JADX INFO: renamed from: ch0.a$a, reason: collision with other inner class name */
    public static final class C0445a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (this.f23713a == r101.f23713a) goto L8;
        return false;
    L8:
        if (this.f23714b == r101.f23714b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f23715c, r101.f23715c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r100 = ((this.f23713a * 31) + this.f23714b) * 31;
        List<Integer> r101 = this.f23715c;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "FeedViewRoomState(uiLayout=" + this.f23713a + ", scene=" + this.f23714b + ", playModes=" + this.f23715c + ")";
    }

    public a(int r100, int r101, List<Integer> r102) {
        Intrinsics.checkNotNullParameter(r102, "playModes");
        this.f23713a = r100;
        this.f23714b = r101;
        this.f23715c = r102;
    }

    public static a a(a r100, int r101, int r102, List r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.f23713a;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.f23714b;
    L9:
        if ((r104 & 4) == 0) goto L11;
        r103 = r100.f23715c;
    L11:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r103, "playModes");
        return new a(r101, r102, r103);
    }
}
