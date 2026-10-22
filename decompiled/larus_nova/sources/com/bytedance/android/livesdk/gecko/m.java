package com.bytedance.android.livesdk.gecko;

import android.text.TextUtils;
import com.ss.android.common.lib.AppLogNewUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class m implements az5.a {
    public m() {
    }

    @Override // az5.a
    public final void a(String r100, JSONObject r101) {
        if (TextUtils.isEmpty(r100) == true) goto L7;
        if (r101 == null) goto L8;
        AppLogNewUtils.onEventV3(r100, r101);
        return;
    L8:
        return;
    }
}
