package c62;

import com.bytedance.android.livehostapi.foundation.IHostNetwork;

/* JADX INFO: loaded from: classes9.dex */
public final class i implements amc.i {
    public i() {
    }

    @Override // amc.i
    public final boolean b() {
        return false;
    }

    @Override // amc.i
    public final lmc.h c() {
        return null;
    }

    @Override // amc.i
    public final boolean d() {
        return false;
    }

    @Override // amc.i
    public final boolean enable() {
        return true;
    }

    @Override // amc.i
    public final String e() {
        return "https://" + ((IHostNetwork) jc1.k.n(IHostNetwork.class)).getHostDomain() + "/webcast/im/gw/uplink/message/";
    }

    @Override // amc.i
    public final long a() {
        return ac2.k.a();
    }
}
