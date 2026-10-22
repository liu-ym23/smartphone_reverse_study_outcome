package com.bytedance.android.shopping.prepurchase.arch.container.ability;

import android.view.View;
import com.bytedance.android.btm.api.model.PageFinder;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public interface m {

    public static final class a {
        public static /* synthetic */ boolean a(m r100, String r101, boolean r102, String r103, PageFinder r104, int r105) {
            if ((r105 & 2) == 0) goto L6;
            r102 = true;
        L6:
            if ((r105 & 4) == 0) goto L9;
            r103 = "";
        L9:
            if ((r105 & 8) == 0) goto L12;
            r104 = null;
        L12:
            return r100.a(r101, r102, r103, r104);
        }
    }

    boolean a(String r100, boolean r101, String r102, PageFinder r103);

    m b(String r100);

    m c(View r100, String r101, PageFinder r102);

    m d(Map<String, ? extends Object> r100);
}
