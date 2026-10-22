package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card;

/* JADX INFO: loaded from: classes10.dex */
public interface n {

    public static final class a {
        public static /* synthetic */ void b(ExplainCardWidgetController r100) {
            r100.f(null, null, false, null, null, null, null);
        }

        public static /* synthetic */ void a(n r100, String r101, String r102, int r103) {
            if ((r103 & 1) == 0) goto L6;
            r101 = null;
        L6:
            if ((r103 & 2) == 0) goto L8;
            r102 = null;
        L8:
            r100.a(r101, r102);
        }
    }

    void a(String r100, String r101);
}
