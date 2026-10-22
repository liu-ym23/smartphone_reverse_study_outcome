package com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability;

import android.view.View;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public interface q {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(q r110, String r111, Map r112, boolean r113, String r114, View r115, String r116, Integer r210, Integer r211, int r212) {
            if ((r212 & 2) == 0) goto L5;
            Map r100 = null;
        L7:
            if ((r212 & 4) == 0) goto L9;
            boolean r101 = false;
        L11:
            if ((r212 & 8) == 0) goto L13;
            boolean r102 = true;
        L15:
            if ((r212 & 16) == 0) goto L17;
            String r103 = "";
        L19:
            if ((r212 & 32) == 0) goto L21;
            View r104 = null;
        L23:
            if ((r212 & 64) == 0) goto L25;
            String r117 = null;
        L27:
            if ((r212 & 128) == 0) goto L29;
            Integer r118 = null;
        L31:
            if ((r212 & 256) == 0) goto L33;
            Integer r119 = null;
        L34:
            r110.a(r111, r100, r101, r102, r103, r104, r117, r118, r119);
            return;
        L33:
            r119 = r211;
            goto L34
        L29:
            r118 = r210;
            goto L31
        L25:
            r117 = r116;
            goto L27
        L21:
            r104 = r115;
            goto L23
        L17:
            r103 = r114;
            goto L19
        L13:
            r102 = false;
            goto L15
        L9:
            r101 = r113;
            goto L11
        L5:
            r100 = r112;
            goto L7
        }
    }

    void a(String r100, Map<String, ? extends Object> r101, boolean r102, boolean r103, String r104, View r105, String r106, Integer r107, Integer r108);
}
