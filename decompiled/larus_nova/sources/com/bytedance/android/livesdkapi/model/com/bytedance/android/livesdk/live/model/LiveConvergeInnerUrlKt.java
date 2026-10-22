package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.live.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0002¨\u0006\u0003"}, d2 = {"isNotNullOrEmpty", "", "", "infrastructure_saasRelease"}, k = 2, mv = {1, 4, 3})
public final class LiveConvergeInnerUrlKt {
    public static final /* synthetic */ boolean access$isNotNullOrEmpty(String r100) {
        return isNotNullOrEmpty(r100);
    }

    private static final boolean isNotNullOrEmpty(String r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.length() <= 0) goto L6;
        return true;
    }
}
