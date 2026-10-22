package com.bytedance.android.livesdk.interactivity.seek.v2;

import com.bytedance.android.livehostapi.foundation.IHostNetwork;
import jc1.k;

/* JADX INFO: loaded from: classes9.dex */
public final class g implements amc.i {
    public g() {
    }

    @Override // amc.i
    public final lmc.h c() {
        return null;
    }

    @Override // amc.i
    public final boolean enable() {
        return true;
    }

    @Override // amc.i
    public final String e() {
        return "https://" + ((IHostNetwork) k.n(IHostNetwork.class)).getHostDomain() + "/webcast/im/gw/uplink/message/";
    }

    @Override // amc.i
    public final long a() {
        return ac2.k.a();
    }

    @Override // amc.i
    public final boolean b() {
        return ac2.k.d();
    }

    @Override // amc.i
    public final boolean d() {
        return ac2.k.b();
    }
}
