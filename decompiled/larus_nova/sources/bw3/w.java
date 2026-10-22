package bw3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class w {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f21124c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h0 f21125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x f21126b;

    public static final class a {
        public static w b(h0 r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            return new w(h0.a(r100), 2);
        }

        public static w a(x r100, h0 r101) {
            Intrinsics.checkNotNullParameter(r100, "error");
            if (r101 == null) goto L5;
            h0 r102 = h0.a(r101);
        L7:
            return new w(r102, r100);
        L5:
            r102 = null;
            goto L7
        }
    }

    static {
    }

    public w() {
        this(null, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L8;
        return false;
    L8:
        w r101 = (w) r100;
        if (Intrinsics.areEqual(this.f21125a, r101.f21125a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f21126b, r101.f21126b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        h0 r100 = this.f21125a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        x r104 = this.f21126b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "InnerAudioCommandResult(state=" + this.f21125a + ", error=" + this.f21126b + ')';
    }

    public final boolean a() {
        if (this.f21126b != null) goto L5;
        return true;
    L5:
        return false;
    }

    public /* synthetic */ w(h0 r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100, null);
    }

    public w(h0 r100, x r101) {
        this.f21125a = r100;
        this.f21126b = r101;
    }
}
