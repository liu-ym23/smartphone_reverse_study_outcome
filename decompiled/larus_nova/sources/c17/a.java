package c17;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f22067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f22069c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f22070d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OutputStream f22071e;

    public final void a() throws IOException {
        int r100 = this.f22068b;
        int r101 = this.f22070d;
        int r102 = r100 - r101;
        if (r102 != 0) goto L5;
        return;
    L5:
        this.f22071e.write(this.f22067a, r101, r102);
        if (this.f22068b < this.f22069c) goto L8;
        this.f22068b = 0;
    L8:
        this.f22070d = this.f22068b;
    }

    public a() {
        this.f22069c = 0;
    }
}
