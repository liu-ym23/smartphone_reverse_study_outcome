package d;

/* JADX INFO: compiled from: Standard.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class l extends Error {
    /* JADX WARN: Multi-variable type inference failed */
    public l() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public l(String r2) {
        d.h.b.o.e(r2, "message");
        super(r2);
    }

    public /* synthetic */ l(String r1, int r2, d.h.b.h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = "An operation is not implemented.";
    L5:
        this(r1);
    }
}
