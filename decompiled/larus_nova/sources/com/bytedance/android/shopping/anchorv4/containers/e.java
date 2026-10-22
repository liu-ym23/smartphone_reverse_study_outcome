package com.bytedance.android.shopping.anchorv4.containers;

import com.bytedance.android.shopping.anchorv3.comment.model.StatTagItem;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public interface e {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(e r100, StatTagItem r101, int r102, Integer r103, Map r104, int r105) {
            if ((r105 & 4) == 0) goto L6;
            r103 = 0;
        L6:
            if ((r105 & 8) == 0) goto L8;
            r104 = null;
        L8:
            r100.K1(r101, r102, r103, r104);
        }
    }

    void K1(StatTagItem r100, int r101, Integer r102, Map<String, ? extends Object> r103);
}
