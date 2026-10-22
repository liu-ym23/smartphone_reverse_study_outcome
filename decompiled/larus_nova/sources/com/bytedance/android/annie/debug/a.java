package com.bytedance.android.annie.debug;

import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.forest.model.Request;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements com.bytedance.forest.interceptor.a {
    public a() {
    }

    @Override // com.bytedance.forest.interceptor.a
    public final void a(Request r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        if (AnnieConfigSettingKeys.OFFLINE_SWITCH.a().booleanValue() == true) goto L6;
        r100.setOnlyOnline(true);
        r100.setEnableCDNCache(false);
        return;
    }
}
