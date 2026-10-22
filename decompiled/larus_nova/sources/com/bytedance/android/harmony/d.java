package com.bytedance.android.harmony;

import androidx.exifinterface.media.ExifInterface;
import java.io.PrintStream;
import kotlin.NoWhenBranchMatchedException;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PrintStream f58195b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f58196c = null;

    public d() {
    }

    static {
        f58196c = new d();
        f58195b = System.out;
    }

    public final void a(Severity r100, String r101, String r102) {
        int r103 = c.f58164a[r100.ordinal()];
        if (r103 == 1) goto L11;
        if (r103 != 2) goto L6;
        String r104 = "I";
    L12:
        f58195b.println("[" + r104 + "] | " + StringsKt.padEnd$default(r101, 24, 0, 2, null) + " | " + r102);
        return;
    L6:
        if (r103 != 3) goto L9;
        r104 = ExifInterface.LONGITUDE_EAST;
        goto L12
    L9:
        throw new NoWhenBranchMatchedException();
    L11:
        r104 = "D";
        goto L12
    }
}
