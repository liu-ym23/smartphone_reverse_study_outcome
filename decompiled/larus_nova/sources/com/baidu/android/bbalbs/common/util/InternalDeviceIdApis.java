package com.baidu.android.bbalbs.common.util;

import android.content.Context;
import com.baidu.bbalbscesium.h;
import com.baidu.bbalbscesium.j.b;

/* JADX INFO: loaded from: classes39.dex */
public class InternalDeviceIdApis {

    public static class TargetPackageCuidV270Info {
        public String iscChannelCuid;
        public String upcChannelCuid;

        public TargetPackageCuidV270Info() {
        }
    }

    public InternalDeviceIdApis() {
    }

    private static h a(Context r100) {
        DeviceId.getCUID(r100);
        return DeviceId.a(r100).b();
    }

    public static String getSelfC270Ids(Context r100) {
        h.a r101 = a(r100).b();
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.d();
    }

    public static TargetPackageCuidV270Info getTargetPackageCuid270Info(Context r100, String r101) {
        h r102 = a(r100);
        TargetPackageCuidV270Info r103 = new TargetPackageCuidV270Info();
        h.a r104 = r102.a(r101, b.f30211c);
        if (r104 == null) goto L5;
        r103.upcChannelCuid = r104.d();
    L5:
        h.a r105 = r102.a(r101, b.f30213e);
        if (r105 == null) goto L8;
        r103.iscChannelCuid = r105.d();
    L8:
        return r103;
    }
}
