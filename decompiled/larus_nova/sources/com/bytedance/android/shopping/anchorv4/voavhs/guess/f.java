package com.bytedance.android.shopping.anchorv4.voavhs.guess;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.anchorv3.guessulike.model.GULFeedbackDislikeReq;
import com.bytedance.android.shopping.anchorv3.guessulike.model.ItemCardRecommendReasonStruct;

/* JADX INFO: loaded from: classes13.dex */
public interface f {

    public static final class a {
        public static /* synthetic */ void a(f r100, String r101, String r102, PageFinder r103, int r104) {
            if ((r104 & 2) == 0) goto L6;
            r102 = null;
        L6:
            if ((r104 & 4) == 0) goto L9;
            r103 = null;
        L9:
            if ((r104 & 8) == 0) goto L11;
            boolean r105 = true;
        L12:
            r100.q(r101, r102, r103, r105);
            return;
        L11:
            r105 = false;
            goto L12
        }
    }

    void p(GULFeedbackDislikeReq r100);

    void q(String r100, String r101, PageFinder r102, boolean r103);

    void r(String r100, String r101, String r102, String r103, String r104);

    void s(String r100, String r101, String r102, String r103);

    void t(String r100, String r101, String r102, String r103);

    void u(ItemCardRecommendReasonStruct r100, j63.c r101, Integer r102);

    void v(j63.c r100, String r101);

    void w(String r100, String r101, String r102, boolean r103, String r104, j63.c r105);
}
