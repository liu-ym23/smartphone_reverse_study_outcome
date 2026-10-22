package bytekn.foundation.io.file;

import java.util.Arrays;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f21784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21785b;

    /* JADX INFO: renamed from: bytekn.foundation.io.file.a$a, reason: collision with other inner class name */
    public static final class C0383a {
    }

    static {
    }

    public String toString() {
        return this.f21784a.toString();
    }

    public a(int r100) {
        if (r100 < 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L10;
        this.f21784a = new byte[r100];
        return;
    L10:
        throw new IllegalArgumentException(("Negative initial size: " + r100).toString());
    L5:
        r101 = false;
        goto L6
    }

    public final void a(byte[] r100, int r101, int r110) {
        if (r101 < 0) goto L28;
        if (r101 > r100.length) goto L28;
        if (r110 < 0) goto L28;
        int r102 = r101 + r110;
        if ((r102 - r100.length) > 0) goto L28;
        int r103 = this.f21785b + r110;
        byte[] r104 = this.f21784a;
        if ((r103 - r104.length) <= 0) goto L25;
        boolean r105 = true;
        int r106 = r104.length << 1;
        if ((r106 - r103) >= 0) goto L14;
        r106 = r103;
    L14:
        if ((r106 - 2147483639) <= 0) goto L24;
        if (r103 >= 0) goto L18;
        r105 = false;
    L18:
        if (r105 == false) goto L23;
        if (r103 <= 2147483639) goto L21;
        r106 = Integer.MAX_VALUE;
        goto L24
    L21:
        r106 = 2147483639;
        goto L24
    L23:
        throw new IllegalStateException("out of memory!".toString());
    L24:
        this.f21784a = Arrays.copyOf(r104, r106);
    L25:
        ArraysKt.copyInto(r100, this.f21784a, this.f21785b, r101, r102);
        this.f21785b += r110;
        return;
    L28:
        throw new IndexOutOfBoundsException();
    }
}
