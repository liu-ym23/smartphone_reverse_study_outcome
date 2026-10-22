package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class c {
    public static final Boolean a(Parcel r1) {
        o.e(r1, "<this>");
        int r2 = r1.readInt();
        if (r2 == (-1)) goto L7;
        if (r2 == 0) goto L10;
        return Boolean.TRUE;
    L10:
        return Boolean.FALSE;
    L7:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [android.os.Parcel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    public static final void a(Parcel r1, Boolean r2) {
        o.e(r1, "<this>");
        if (r2 == null) goto L5;
        ?? r3 = r2.booleanValue();
    L6:
        r1.writeInt(r3);
        return;
    L5:
        r3 = -1;
        goto L6
    }
}
