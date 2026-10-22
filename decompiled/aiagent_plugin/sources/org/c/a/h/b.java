package org.c.a.h;

import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import org.c.a.c.c;

/* JADX INFO: compiled from: StreamReader.java */
/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f40468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Reader f40469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int[] f40470c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f40471d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f40472e;
    private boolean f;
    private int g;
    private int h;
    private int i;
    private char[] j;

    public static boolean a(int r1) {
        if (r1 < 32) goto L7;
        if (r1 > 126) goto L7;
    L28:
        return true;
    L7:
        if (r1 == 9) goto L28;
        if (r1 == 10) goto L28;
        if (r1 == 13) goto L28;
        if (r1 == 133) goto L28;
        if (r1 < 160) goto L19;
        if (r1 <= 55295) goto L28;
    L19:
        if (r1 < 57344) goto L23;
        if (r1 <= 65533) goto L28;
    L23:
        if (r1 >= 65536) goto L25;
    L27:
        return false;
    L25:
        if (r1 > 1114111) goto L27;
        goto L27
    }

    public b(Reader r3) {
        this.f40472e = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.f40468a = "'reader'";
        this.f40470c = new int[0];
        this.f40471d = 0;
        this.f40469b = r3;
        this.f = false;
        this.j = new char[DownloadErrorCode.ERROR_ANOTHER_TASK_EXIST];
    }

    public org.c.a.c.a a() {
        return new org.c.a.c.a(this.f40468a, this.g, this.h, this.i, this.f40470c, this.f40472e);
    }

    public void b() {
        b(1);
    }

    public void b(int r6) {
        int r1 = 0;
    L3:
        if (r1 >= r6) goto L20;
        if (g() == false) goto L26;
        int[] r2 = this.f40470c;
        int r3 = this.f40472e;
        this.f40472e = r3 + 1;
        int r4 = r2[r3];
        this.g++;
        if (org.c.a.j.a.f40482a.a(r4) == false) goto L9;
    L18:
        this.h++;
        this.i = 0;
    L19:
        r1 = r1 + 1;
        goto L3
    L9:
        if (r4 != 13) goto L16;
        if (g() == false) goto L16;
        if (this.f40470c[this.f40472e] != 10) goto L18;
    L16:
        if (r4 == 65279) goto L19;
        this.i++;
        goto L19
    L26:
        return;
    }

    public int c() {
        if (g() == true) goto L7;
        return 0;
    L7:
        return this.f40470c[this.f40472e];
    }

    public int c(int r2) {
        if (f(r2) == true) goto L7;
        return 0;
    L7:
        return this.f40470c[this.f40472e + r2];
    }

    public String d(int r4) {
        if (r4 != 0) goto L6;
        return "";
    L6:
        if (f(r4) == true) goto L8;
        int[] r1 = this.f40470c;
        int r2 = this.f40472e;
        return new String(r1, r2, Math.min(r4, this.f40471d - r2));
    L8:
        return new String(this.f40470c, this.f40472e, r4);
    }

    public String e(int r3) {
        String r0 = d(r3);
        this.f40472e += r3;
        this.g += r3;
        this.i += r3;
        return r0;
    }

    private boolean g() {
        return f(0);
    }

    private boolean f(int r3) {
        if (this.f == true) goto L8;
        if ((this.f40472e + r3) < this.f40471d) goto L8;
        update();
    L8:
        if ((this.f40472e + r3) >= this.f40471d) goto L10;
        return true;
    L10:
        return false;
    }

    private void update() {
        int r0 = this.f40469b.read(this.j, 0, 1024);     // Catch: IOException -> L24
        if (r0 <= 0) goto L22;
        int r2 = this.f40471d;     // Catch: IOException -> L24
        int r4 = this.f40472e;     // Catch: IOException -> L24
        int r5 = r2 - r4;     // Catch: IOException -> L24
        this.f40470c = Arrays.copyOfRange(this.f40470c, r4, r2 + r0);     // Catch: IOException -> L24
        if (Character.isHighSurrogate(this.j[r0 - 1]) == true) goto L7;
    L10:
        int r6 = 32;
        int r7 = 0;
    L11:
        if (r7 >= r0) goto L17;
        int r8 = Character.codePointAt(this.j, r7);     // Catch: IOException -> L24
        this.f40470c[r5] = r8;     // Catch: IOException -> L24
        if (a(r8) == false) goto L15;
        r7 = r7 + Character.charCount(r8);     // Catch: IOException -> L24
    L16:
        r5 = r5 + 1;     // Catch: IOException -> L24
        goto L11
    L15:
        r7 = r0;
        r6 = r8;
        goto L16
    L17:
        this.f40471d = r5;     // Catch: IOException -> L24
        this.f40472e = 0;     // Catch: IOException -> L24
        if (r6 != 32) goto L21;
        return;
    L21:
        throw new a(this.f40468a, r5 - 1, r6, "special characters are not allowed");     // Catch: IOException -> L24
    L7:
        if (this.f40469b.read(this.j, r0, 1) != (-1)) goto L9;
        this.f = true;     // Catch: IOException -> L24
        goto L10
    L9:
        r0 = r0 + 1;     // Catch: IOException -> L24
        goto L10
    L22:
        this.f = true;     // Catch: IOException -> L24
        return;
    L24:
        e = move-exception;
        throw new c(e);
    }

    public int d() {
        return this.i;
    }

    public int e() {
        return this.g;
    }

    public int f() {
        return this.h;
    }
}
