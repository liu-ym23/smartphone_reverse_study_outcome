package com.bytedance.android.shopping.anchorv4.voavhs.head.base;

/* JADX INFO: loaded from: classes13.dex */
public interface e {

    public static final class a {
        public static /* synthetic */ void a(e r100, Integer r101, p r102, Boolean r103, int r104) {
            if ((r104 & 1) == 0) goto L6;
            r101 = null;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = null;
        L9:
            if ((r104 & 4) == 0) goto L11;
            r103 = Boolean.FALSE;
        L11:
            r100.a(r101, r102, r103);
        }
    }

    void a(Integer r100, p r101, Boolean r102);

    void d(int r100);
}
