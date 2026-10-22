package com.bytedance.android.ecom.bcm.track.impl.mall;

import com.bytedance.android.bcm.api.model.BcmParams;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public interface a {

    /* JADX INFO: renamed from: com.bytedance.android.ecom.bcm.track.impl.mall.a$a, reason: collision with other inner class name */
    public static final class C0868a {
        public static b a(a r100, List<? extends kc.a.C6534a> r101) {
            JSONObject r102 = null;
            b r103 = new b(null, -1);
            if (r101 != null) goto L5;
            return r103;
        L5:
            Iterator<? extends kc.a.C6534a> r104 = r101.iterator();
            int r105 = 0;
            int r106 = 0;
        L7:
            if (r104.hasNext() == false) goto L21;
            r105 = r105 + 1;
            kc.a.C6534a r107 = r104.next();
            r106 = r100.d()[r106][r100.b(r107)];
            if (r106 != r100.a()) goto L7;
            kc.a.C6534a.C6535a r108 = r107.f502360g;
            if (r108 == null) goto L15;
            BcmParams r109 = r108.f502361a;
            if (r109 == null) goto L15;
            r102 = r109.toJSONObject();
        L15:
            if (r102 == null) goto L21;
            if (r102.length() == 0) goto L21;
            return new b(r107, r105);
        L21:
            return r103;
        }
    }

    int a();

    int b(kc.a.C6534a r100);

    int[][] d();
}
