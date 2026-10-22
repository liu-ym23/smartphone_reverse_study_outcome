package com.bytedance.android.livesdk.livecommerce.event;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ecom.bcm.track.api.EcomBcmTracker;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public abstract class u0 extends ECEventV3 {
    public u0(String r100) {
        super(r100);
        this.f147721c.c("follow_status", l0.f());
    }

    public final void n(String r100) {
        if (r100 == null) goto L19;
        k0 r101 = this.f147721c;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.f147739a == null) goto L30;
        Map<String, Object> r102 = EcomBcmTracker.f(PageFinder.via(r100), this.f147721c.f147739a);
        if (r102 == null) goto L31;
        Iterator<Map.Entry<String, Object>> r103 = r102.entrySet().iterator();
    L11:
        if (r103.hasNext() == false) goto L32;
        Map.Entry<String, Object> r104 = r103.next();
        if (r104.getKey() == null) goto L11;
        if (r104.getKey().isEmpty() == true) goto L11;
        if (r104.getValue() == null) goto L11;
        f(r104.getKey(), r104.getValue().toString());
        goto L11
    L32:
        return;
    L31:
        return;
    L30:
        return;
    }

    public u0(RoomContextController r100, String r101) {
        super(r100, r101);
        this.f147721c.c("follow_status", l0.f());
    }
}
