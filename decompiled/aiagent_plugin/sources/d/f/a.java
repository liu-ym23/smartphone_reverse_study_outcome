package d.f;

import java.io.File;

/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends h {
    public /* synthetic */ a(File r2, File r3, String r4, int r5, d.h.b.h r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        this(r2, r3, r4);
    }

    public a(File r2, File r3, String r4) {
        d.h.b.o.e(r2, "file");
        super(r2, r3, r4);
    }
}
