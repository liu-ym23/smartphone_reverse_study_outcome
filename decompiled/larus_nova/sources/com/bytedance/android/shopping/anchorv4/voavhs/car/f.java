package com.bytedance.android.shopping.anchorv4.voavhs.car;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public interface f {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(f r110, String r111, Map r112, boolean r113, String r114, PageFinder r115, String r116, String r117, int r210) {
            if ((r210 & 2) == 0) goto L5;
            Map r100 = null;
        L7:
            if ((r210 & 8) == 0) goto L9;
            boolean r101 = true;
        L11:
            if ((r210 & 16) == 0) goto L13;
            String r102 = null;
        L15:
            if ((r210 & 32) == 0) goto L17;
            PageFinder r103 = null;
        L19:
            if ((r210 & 64) == 0) goto L21;
            String r118 = "";
        L23:
            if ((r210 & 128) == 0) goto L25;
            String r119 = null;
        L26:
            r110.g(r111, r100, false, r101, r102, r103, r118, r119);
            return;
        L25:
            r119 = r117;
            goto L26
        L21:
            r118 = r116;
            goto L23
        L17:
            r103 = r115;
            goto L19
        L13:
            r102 = r114;
            goto L15
        L9:
            r101 = r113;
            goto L11
        L5:
            r100 = r112;
            goto L7
        }
    }

    CommonMeta a();

    LinkedTreeMap<String, Object> b();

    String f();

    void g(String r100, Map<String, ? extends Object> r101, boolean r102, boolean r103, String r104, PageFinder r105, String r106, String r107);
}
