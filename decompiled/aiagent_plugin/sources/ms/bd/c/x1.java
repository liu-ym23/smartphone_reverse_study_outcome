package ms.bd.c;

import android.os.Build;

/* JADX INFO: loaded from: classes4.dex */
final class x1 implements g1.b {
    x1() {
    }

    public final String[] a() {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        String[] r4 = Build.SUPPORTED_ABIS;
        if (r4.length <= 0) goto L7;
        return r4;
    L7:
        String r5 = Build.CPU_ABI2;
        if (r5 != null) goto L10;
    L13:
        boolean r2 = true;
    L14:
        if (r2 == true) goto L18;
        return new String[]{Build.CPU_ABI, r5};
    L18:
        return new String[]{Build.CPU_ABI};
    L10:
        if (r5.length() == 0) goto L13;
        r2 = false;
        goto L14
    }
}
