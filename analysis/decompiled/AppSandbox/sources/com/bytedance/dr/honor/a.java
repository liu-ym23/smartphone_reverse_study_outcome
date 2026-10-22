package com.bytedance.dr.honor;

import android.os.Bundle;
import com.bytedance.applog.log.IAppLogLogger;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.dr.aidl.f;

/* loaded from: classes.dex */
public class a extends f.a {
    public volatile String a = "";

    @Override // com.bytedance.dr.aidl.f
    public void a(int i, long j, boolean z, float f, double d, String str) {
    }

    @Override // com.bytedance.dr.aidl.f
    public void a(int i, Bundle bundle) {
        LoggerImpl.global().debug("honor# OAIDCallBack handleResult retCode= " + i + " retInfo= " + bundle, new Object[0]);
        if (i != 0 || bundle == null) {
            return;
        }
        this.a = bundle.getString("oa_id_flag");
        IAppLogLogger iAppLogLoggerGlobal = LoggerImpl.global();
        StringBuilder sbA = com.bytedance.bdtracker.a.a("honor# OAIDCallBack handleResult success ");
        sbA.append(this.a);
        iAppLogLoggerGlobal.debug(sbA.toString(), new Object[0]);
    }
}
