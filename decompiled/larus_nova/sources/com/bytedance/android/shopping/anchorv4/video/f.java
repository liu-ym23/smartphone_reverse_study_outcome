package com.bytedance.android.shopping.anchorv4.video;

/* JADX INFO: loaded from: classes12.dex */
public interface f {

    public static final class a {
        public static /* synthetic */ void b(f r100, e r101, boolean r102, int r103) {
            if ((r103 & 2) == 0) goto L5;
            boolean r104 = true;
        L7:
            if ((r103 & 4) == 0) goto L9;
            r102 = false;
        L9:
            r100.b(r101, r104, r102);
            return;
        L5:
            r104 = false;
            goto L7
        }

        public static /* synthetic */ void a(f r100, e r101, boolean r102, boolean r103, int r104) {
            if ((r104 & 2) == 0) goto L6;
            r102 = true;
        L6:
            if ((r104 & 4) == 0) goto L8;
            r103 = false;
        L8:
            r100.j(r101, r102, r103);
        }
    }

    void a(d r100);

    void b(e r100, boolean r101, boolean r102);

    void c(e r100);

    void d(boolean r100);

    boolean e();

    void f(boolean r100, boolean r101, e r102);

    void g(e r100);

    boolean h(e r100);

    boolean i();

    void j(e r100, boolean r101, boolean r102);
}
