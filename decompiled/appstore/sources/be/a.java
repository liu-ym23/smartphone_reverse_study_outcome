package be;

import android.os.Parcel;
import android.util.Log;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5996a = null;

    static {
        f5996a = new a();
    }

    public a() {
    }

    public static final Object c(Parcel r10, ClassLoader r11) {
        q.g(r10, "parcel");
        int r12 = r10.dataPosition();
        int r13 = r10.readInt();
        a r14 = f5996a;
        if (r14.b(r13) == false) goto L7;
        int r15 = r10.readInt();
        if (r15 < 0) goto L7;
        Integer r16 = Integer.valueOf(r14.a(r10.dataPosition(), r15));
    L14:
        r10.setDataPosition(r12);     // Catch: Exception -> L10
        return r10.readValue(r11);
    L10:
        Log.w("ParcelUtils", "unsupported type");
        if (r16 == null) goto L13;
        r10.setDataPosition(r16.intValue());
    L13:
        return null;
    L7:
        r16 = null;
        goto L14
    }

    public static final void d(Parcel r10, ClassLoader r11) {
        q.g(r10, "parcel");
        int r12 = r10.dataPosition();
        int r13 = r10.readInt();
        a r14 = f5996a;
        if (r14.b(r13) == false) goto L8;
        int r15 = r10.readInt();
        if (r15 >= 0) goto L7;
        return;
    L7:
        r10.setDataPosition(r14.a(r10.dataPosition(), r15));
        return;
    L8:
        r10.setDataPosition(r12);
        r10.readValue(r11);
    }

    public final int a(int r10, int r11) {
        if (r11 != 0) goto L4;
        return r10;
    L4:
        if (r11 > 0) goto L6;
    L9:
        if (r11 >= 0) goto L15;
        if (r10 < (Integer.MIN_VALUE - r11)) goto L15;
        return r10 + r11;
    L15:
        throw new IllegalArgumentException("Addition overflow: " + r10 + " + " + r11);
    L6:
        if (r10 > (Channel.UNLIMITED - r11)) goto L9;
        return r10 + r11;
    }

    public final boolean b(int r10) {
        if (r10 != 2) goto L5;
    L17:
        return true;
    L5:
        if (r10 == 4) goto L17;
        if (r10 == 21) goto L17;
        if (r10 == 11) goto L17;
        if (r10 == 12) goto L17;
        if (r10 == 16) goto L17;
        if (r10 == 17) goto L17;
        return false;
    }
}
