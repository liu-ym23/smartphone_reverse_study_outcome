package bytekn.foundation.io.file;

import java.io.Writer;

/* JADX INFO: loaded from: classes3.dex */
public class i implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Writer f21800a;

    public final void a() {
        this.f21800a.flush();
    }

    @Override // bytekn.foundation.io.file.g
    public final void close() {
        this.f21800a.close();
    }

    public i(Writer r100) {
        this.f21800a = r100;
    }

    public final void b(String r100) {
        this.f21800a.write(r100);
    }
}
