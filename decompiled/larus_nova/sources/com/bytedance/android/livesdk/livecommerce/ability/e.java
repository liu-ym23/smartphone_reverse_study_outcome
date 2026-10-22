package com.bytedance.android.livesdk.livecommerce.ability;

/* JADX INFO: loaded from: classes10.dex */
public interface e {

    public static final class a {
        public static /* synthetic */ void a(e r100, int r101, String r102, int r103) {
            if ((r103 & 1) == 0) goto L6;
            r101 = 0;
        L6:
            if ((r103 & 2) == 0) goto L8;
            r102 = null;
        L8:
            r100.onFail(r101, r102);
        }
    }

    void onFail(int r100, String r101);

    void onSuccess();
}
