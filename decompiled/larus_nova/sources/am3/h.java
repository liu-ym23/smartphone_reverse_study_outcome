package am3;

import java.io.IOException;

/* JADX INFO: loaded from: classes14.dex */
public final class h {
    public static boolean a(g r100) throws IOException {
        int r101 = r100.i();
        if (r101 != 0) goto L6;
        return false;
    L6:
        if (r101 != 1) goto L9;
        return true;
    L9:
        throw new IOException(String.format("Invalid boolean value 0x%02x", new Object[]{Integer.valueOf(r101)}));
    }

    public static byte[] b(g r100) throws IOException {
        long r101 = r100.b();
        return r100.f4367b.readByteArray(r101);
    }

    public static String c(g r100) throws IOException {
        long r101 = r100.b();
        return r100.f4367b.readUtf8(r101);
    }

    public static void e(g r100) throws IOException {
        int r101 = r100.f4374i;
        if (r101 != 0) goto L5;
        r100.j();
        return;
    L5:
        if (r101 != 1) goto L7;
        r100.f4368c += 8;
        r100.f4367b.c(8);
        r100.a(1);
        return;
    L7:
        if (r101 != 2) goto L9;
        r100.f4367b.c(r100.b());
        return;
    L9:
        if (r101 != 5) goto L13;
        r100.f4368c += 4;
        r100.f4367b.c(4);
        r100.a(5);
        return;
    L13:
        throw new IllegalStateException("Unexpected field encoding found!");
    }

    public static void d(g.a r100, g r101) throws IOException {
        if (r100 == null) goto L8;
        long r102 = r101.f4368c;
        long r103 = r100.f4376a;
        if (r102 < r103) goto L6;
        boolean r104 = false;
    L7:
        if (r104 == false) goto L8;
        return;
    L6:
        r101.f4367b.c(r103 - r102);
        r101.f4368c = r100.f4376a;
        r101.f4369d = r100.f4377b;
        r101.f4370e = r100.f4378c;
        r101.f4371f = r100.f4379d;
        r101.f4372g = r100.f4380e;
        r101.f4373h = r100.f4381f;
        r101.f4374i = r100.f4382g;
        r104 = true;
    L8:
        e(r101);
    }
}
