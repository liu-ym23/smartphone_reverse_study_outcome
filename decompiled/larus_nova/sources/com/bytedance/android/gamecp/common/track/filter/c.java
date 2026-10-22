package com.bytedance.android.gamecp.common.track.filter;

import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
public final class c extends a<zu.b> {
    public final String b() {
        Map<String, String> r100 = this.f56801a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get(AudienceGamePromoteDetailActionHandler.PARA_RESERVE_ID);
    }

    public c() {
    }
}
