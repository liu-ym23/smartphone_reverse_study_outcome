package cib;

import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes36.dex */
public final class e {
    public static final String a(Fragment r100) {
        StringBuilder r101 = new StringBuilder();
        if (r100 == null) goto L5;
        String r102 = r100.getClass().getSimpleName();
    L6:
        r101.append(r102);
        if (r100 == null) goto L9;
        int r103 = r100.hashCode();
    L10:
        r101.append(r103);
        return r101.toString();
    L9:
        r103 = 0;
        goto L10
    L5:
        r102 = null;
        goto L6
    }
}
