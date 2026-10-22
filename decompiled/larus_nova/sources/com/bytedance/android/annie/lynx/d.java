package com.bytedance.android.annie.lynx;

import com.bytedance.crash.AttachUserData;
import com.bytedance.crash.CrashType;
import com.lynx.tasm.eventreport.LynxEventReporter;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes43.dex */
public final class d implements AttachUserData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f39483a = null;

    static {
        f39483a = new d();
    }

    public d() {
    }

    @Override // com.bytedance.crash.AttachUserData
    public final Map<? extends String, ? extends String> getUserData(CrashType r100) {
        HashMap r101 = new HashMap();
        d8.b r102 = e.f39484a;
        r101.put("last_lynx_url", e.f39486c);
        r101.put(LynxEventReporter.PROP_NAME_LYNX_SDK_VERSION, e.f39486c);
        return r101;
    }
}
