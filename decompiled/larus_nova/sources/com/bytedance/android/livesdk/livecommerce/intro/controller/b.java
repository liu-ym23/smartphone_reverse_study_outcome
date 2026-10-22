package com.bytedance.android.livesdk.livecommerce.intro.controller;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ void a(b r100, String r101, String r102, boolean r103, boolean r104, int r105) {
            if ((r105 & 1) == 0) goto L6;
            r101 = null;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = null;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = false;
        L12:
            if ((r105 & 8) == 0) goto L14;
            r104 = false;
        L14:
            r100.l(r101, r102, r103, r104);
        }
    }

    void a(JSONObject r100);

    boolean i();

    String j();

    void k(boolean r100);

    void l(String r100, String r101, boolean r102, boolean r103);

    void m(uh2.a r100, boolean r101, boolean r102);

    boolean n();

    void o();

    void onDestroy();
}
