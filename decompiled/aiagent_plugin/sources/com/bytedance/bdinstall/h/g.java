package com.bytedance.bdinstall.h;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: compiled from: DeviceParamsProvider.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends a {
    g(Context r3, k r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4);
    }

    @Override // com.bytedance.bdinstall.g.a
    public void c() {
        this.f6260c.a(Arrays.asList(new String[]{"openudid", "clientudid", "device_id", "install_id"}));
    }
}
