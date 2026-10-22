package d.f;

import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes4.dex */
public class h extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f38438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f38439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f38440c;

    public /* synthetic */ h(File r2, File r3, String r4, int r5, d.h.b.h r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        this(r2, r3, r4);
    }

    public h(File r2, File r3, String r4) {
        d.h.b.o.e(r2, "file");
        super(d.a(r2, r3, r4));
        this.f38438a = r2;
        this.f38439b = r3;
        this.f38440c = r4;
    }
}
