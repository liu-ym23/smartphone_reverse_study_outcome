package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video;

/* JADX INFO: loaded from: classes13.dex */
public interface t {

    public static final class a {
        public static /* synthetic */ void a(t r100, boolean r101, boolean r102, boolean r103, boolean r104, int r105) {
            if ((r105 & 2) == 0) goto L6;
            r102 = false;
        L6:
            if ((r105 & 4) == 0) goto L9;
            r103 = false;
        L9:
            if ((r105 & 8) == 0) goto L11;
            r104 = false;
        L11:
            r100.a(r101, r102, r103, r104);
        }
    }

    void a(boolean r100, boolean r101, boolean r102, boolean r103);

    boolean b();

    void c(boolean r100);

    void d();

    gj.b e();

    l getParams();
}
