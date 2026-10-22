package com.ttnet.org.chromium.base.compat;

import android.content.Context;
import android.net.NetworkCapabilities;
import android.net.TransportInfo;
import android.os.PowerManager;
import android.provider.MediaStore;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;

/* JADX INFO: compiled from: ApiHelperForQ.java */
/* JADX INFO: loaded from: classes4.dex */
public final class e {
    public static Set<String> a(Context r2) {
        return MediaStore.getExternalVolumeNames((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"));
    }

    public static TransportInfo a(NetworkCapabilities r0) {
        return r0.getTransportInfo();
    }

    public static int a(PowerManager r0) {
        return r0.getCurrentThermalStatus();
    }
}
