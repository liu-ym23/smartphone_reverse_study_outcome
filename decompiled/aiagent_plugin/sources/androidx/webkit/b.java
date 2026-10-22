package androidx.webkit;

import androidx.webkit.internal.p;

/* JADX INFO: compiled from: ProfileStore.java */
/* JADX INFO: loaded from: classes.dex */
public interface b {
    a a(String r1);

    static b a() {
        if (p.ac.d() == false) goto L7;
        return androidx.webkit.internal.j.b();
    L7:
        throw p.a();
    }
}
