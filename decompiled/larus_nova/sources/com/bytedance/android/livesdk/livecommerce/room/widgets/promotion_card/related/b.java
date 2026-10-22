package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related;

import com.bytedance.android.livesdk.livecommerce.model.ProductInfo;

/* JADX INFO: loaded from: classes10.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ void a(b r100, String r101, String r102, int r103) {
            if ((r103 & 1) == 0) goto L6;
            r101 = null;
        L6:
            if ((r103 & 2) == 0) goto L8;
            r102 = null;
        L8:
            r100.b(r101, r102);
        }
    }

    void a(String r100);

    void b(String r100, String r101);

    void c(String r100, ProductInfo r101);
}
