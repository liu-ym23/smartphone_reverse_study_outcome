package com.bytedance.applet.utils;

/* JADX INFO: loaded from: classes14.dex */
public interface d {

    public static final class a {
        public static /* synthetic */ void a(d r100, boolean r101, boolean r102, boolean r103, int r104) {
            if ((r104 & 2) == 0) goto L6;
            r102 = false;
        L6:
            if ((r104 & 4) == 0) goto L8;
            r103 = false;
        L8:
            r100.a(r101, r102, r103);
        }
    }

    void a(boolean r100, boolean r101, boolean r102);
}
