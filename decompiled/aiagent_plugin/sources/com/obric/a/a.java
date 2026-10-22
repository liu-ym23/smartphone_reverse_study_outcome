package com.obric.a;

import android.os.Parcel;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import d.h.b.o;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: ParcelUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13933a = null;

    static {
        f13933a = new a();
    }

    private final boolean a(int r1) {
        if (r1 != 2) goto L5;
    L17:
        return true;
    L5:
        if (r1 == 4) goto L17;
        if (r1 == 21) goto L17;
        if (r1 == 11) goto L17;
        if (r1 == 12) goto L17;
        if (r1 == 16) goto L17;
        if (r1 == 17) goto L17;
        return false;
    }

    private a() {
    }

    public static final void a(Parcel r3, ClassLoader r4) {
        o.e(r3, "parcel");
        int r0 = r3.dataPosition();
        int r1 = r3.readInt();
        a r2 = f13933a;
        if (r2.a(r1) == false) goto L8;
        int r5 = r3.readInt();
        if (r5 >= 0) goto L7;
        return;
    L7:
        r3.setDataPosition(r2.a(r3.dataPosition(), r5));
        return;
    L8:
        r3.setDataPosition(r0);
        r3.readValue(r4);
    }

    public static final Object b(Parcel r5, ClassLoader r6) {
        o.e(r5, "parcel");
        int r0 = r5.dataPosition();
        int r1 = r5.readInt();
        a r2 = f13933a;
        if (r2.a(r1) == false) goto L7;
        int r3 = r5.readInt();
        if (r3 < 0) goto L7;
        Integer r4 = Integer.valueOf(r2.a(r5.dataPosition(), r3));
    L14:
        r5.setDataPosition(r0);     // Catch: Exception -> L10
        return r5.readValue(r6);
    L10:
        a("ParcelUtils", "unsupported type");
        if (r4 == null) goto L13;
        r5.setDataPosition(r4.intValue());
    L13:
        return null;
    L7:
        r4 = null;
        goto L14
    }

    private final int a(int r3, int r4) {
        if (r4 != 0) goto L4;
        return r3;
    L4:
        if (r4 > 0) goto L6;
    L9:
        if (r4 >= 0) goto L15;
        if (r3 < (Integer.MIN_VALUE - r4)) goto L15;
        return r3 + r4;
    L15:
        throw new IllegalArgumentException("Addition overflow: " + r3 + " + " + r4);
    L6:
        if (r3 > (Integer.MAX_VALUE - r4)) goto L9;
        return r3 + r4;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }
}
