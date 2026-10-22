package com.autonavi.aps.protocol.aps.a;

import com.autonavi.aps.protocol.aps.common.a.c;
import com.autonavi.aps.protocol.aps.common.enums.Version;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    static Map<Version, com.autonavi.aps.protocol.aps.common.d.a> f18473c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    static Map<Version, com.autonavi.aps.protocol.aps.common.d.b> f18474d = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    private com.autonavi.aps.protocol.aps.common.c.a f18475a = new com.autonavi.aps.protocol.aps.common.c.a();

    /* renamed from: b, reason: collision with root package name */
    private com.autonavi.aps.protocol.aps.common.c.b f18476b = new com.autonavi.aps.protocol.aps.common.c.b();

    static {
        Map<Version, com.autonavi.aps.protocol.aps.common.d.a> map = f18473c;
        Version version = Version.V56;
        map.put(version, com.autonavi.aps.protocol.aps.impl.v56.b.a.b());
        Map<Version, com.autonavi.aps.protocol.aps.common.d.a> map2 = f18473c;
        Version version2 = Version.V57;
        map2.put(version2, com.autonavi.aps.protocol.aps.impl.v57.b.a.b());
        f18474d.put(version, com.autonavi.aps.protocol.aps.impl.v56.b.b.b());
        f18474d.put(version2, com.autonavi.aps.protocol.aps.impl.v57.b.b.b());
    }

    public void a(com.autonavi.aps.protocol.aps.authority.a aVar) {
        this.f18476b.a(aVar);
        this.f18475a.a(f18473c);
        this.f18475a.a(aVar);
        this.f18476b.a(f18474d);
    }

    public com.autonavi.aps.protocol.aps.request.model.message.a a(com.autonavi.aps.protocol.aps.request.model.a.a aVar) {
        return (com.autonavi.aps.protocol.aps.request.model.message.a) a(f18473c.get(aVar.a()).a(aVar));
    }

    public com.autonavi.aps.protocol.aps.common.a.b a(com.autonavi.aps.protocol.aps.request.model.b.a aVar) {
        return this.f18475a.a(aVar);
    }

    public com.autonavi.aps.protocol.aps.response.model.vo.a a(c cVar) {
        return this.f18476b.a(cVar);
    }
}
