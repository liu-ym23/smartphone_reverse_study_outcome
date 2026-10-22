package com.bytedance.android.monitorV2.exception;

import com.bytedance.android.monitorV2.util.u;
import com.bytedance.crash.AttachUserData;
import com.bytedance.crash.CrashType;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes12.dex */
public final class a implements AttachUserData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f163029a = null;

    static {
        f163029a = new a();
    }

    public a() {
    }

    @Override // com.bytedance.crash.AttachUserData
    public final Map<? extends String, ? extends String> getUserData(CrashType r100) {
        HashMap r101 = new HashMap();
        Pattern r102 = u.f163257a;
        r101.put("last_bdhm_url", u.a(HybridCrashHelper.f163027a));
        r101.put("last_bdhm_bid", HybridCrashHelper.f163028b);
        return r101;
    }
}
