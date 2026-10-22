package com.bytedance.android.btm.impl.util;

import com.bytedance.android.btm.api.BtmHostDependManager;
import com.bytedance.android.btm.impl.setting.BtmSetting;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final boolean a() {
        if (BtmHostDependManager.F.c() == false) goto L5;
        return true;
    L5:
        if (BtmSetting.f42469d.c().c().a() == 1) goto L10;
        return false;
    L10:
        return true;
    }
}
