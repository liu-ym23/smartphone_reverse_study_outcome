package com.bytedance.android.live.liveinteract.plantform.utils;

import com.bytedance.android.live.core.log.ALogger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.pushstream.d f77464a;

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.q
    public final void onClose() {
    }

    public c(com.bytedance.android.live.pushstream.d r100) {
        this.f77464a = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.q
    public final void a(String r100, JSONObject r110) {
        if (this.f77464a != null) goto L5;
        ALogger.e("SeiStreamInfoSender", "livestream is null");
    L5:
        com.bytedance.android.live.pushstream.d r101 = this.f77464a;
        if (r101 == null) goto L9;
        r101.c1(r100, r110, 1, false, false);
        return;
    }
}
