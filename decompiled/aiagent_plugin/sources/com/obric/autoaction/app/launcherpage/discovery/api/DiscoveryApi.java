package com.obric.autoaction.app.launcherpage.discovery.api;

import com.bytedance.retrofit2.b.b;
import com.bytedance.retrofit2.c.h;
import com.bytedance.retrofit2.c.l;
import com.bytedance.retrofit2.c.z;
import com.obric.autoaction.app.launcherpage.discovery.a.c;
import d.c.d;
import java.util.List;

/* JADX INFO: compiled from: DiscoveryApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface DiscoveryApi {
    @h(a = "/auto_action/api/instruction/groups")
    Object getDiscoveryData(@l List<b> r1, @z(a = "version") String r2, d<? super c> r3);
}
