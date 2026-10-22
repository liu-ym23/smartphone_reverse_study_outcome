package ca7;

import java.util.Collection;

/* JADX INFO: loaded from: classes11.dex */
public final class e extends m {
    public e(Collection<String> r100) {
        super(r100);
    }

    @Override // ca7.m
    public final boolean g(String r100, String r101) {
        if (r100 == null) goto L6;
        if (r101 != null) goto L5;
        return false;
    L5:
        return r100.contains(r101);
    L6:
        return false;
    }
}
