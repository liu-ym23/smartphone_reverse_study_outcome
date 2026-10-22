package ms.bd.c;

import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: loaded from: classes4.dex */
final class h1 implements FilenameFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f39508a;

    h1(String r1) {
        this.f39508a = r1;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File r1, String r2) {
        return r2.startsWith(this.f39508a);
    }
}
