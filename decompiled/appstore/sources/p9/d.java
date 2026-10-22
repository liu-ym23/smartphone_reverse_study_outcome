package p9;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f23407a;

    public d() {
        this.f23407a = new ArrayList();
    }

    public boolean a(s9.b r10) {
        return this.f23407a.contains(r10);
    }

    public int b() {
        int r10 = 0;
        int r11 = 0;
    L11:
    L9:
        o0.a.d("DownloadQueue getDownloadingCount failed.");
    L10:
        return r11;
    L4:
        if (r10 >= this.f23407a.size()) goto L10;
        if (d((s9.b) this.f23407a.get(r10)) == false) goto L8;
        r11 = r11 + 1;
    L8:
        r10 = r10 + 1;
        goto L11
    }

    public boolean c(s9.b r10) {
        if (r10.f() != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean d(s9.b r10) {
        int r11 = r10.f();
        if (r11 != 1) goto L5;
        return true;
    L5:
        if (r11 != 2) goto L7;
        return true;
    L7:
        if (r11 != 3) goto L9;
        return true;
    L9:
        if (r11 == 4) goto L16;
        return false;
    L16:
        return true;
    }

    public s9.b e() {
        int r10 = 0;
    L12:
    L9:
        o0.a.d("DownloadQueue getDownloadingCount failed.");
        return null;
    L4:
        if (r10 >= this.f23407a.size()) goto L16;
        s9.b r11 = (s9.b) this.f23407a.get(r10);     // Catch: Exception -> L9
        if (c(r11) == true) goto L7;
        r10 = r10 + 1;
        goto L12
    L7:
        return r11;
    L16:
        return null;
    }

    public boolean f(s9.b r10) {
        if (a(r10) == true) goto L5;
        return false;
    L5:
        return this.f23407a.remove(r10);
    }

    public int g() {
        return this.f23407a.size();
    }
}
