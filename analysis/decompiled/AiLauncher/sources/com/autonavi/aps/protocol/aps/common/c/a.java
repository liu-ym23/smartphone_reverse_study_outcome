package com.autonavi.aps.protocol.aps.common.c;

import com.autonavi.aps.protocol.aps.common.enums.Status;
import com.autonavi.aps.protocol.aps.common.enums.Version;
import java.util.Map;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Map<Version, com.autonavi.aps.protocol.aps.common.d.a> f18502a;

    /* renamed from: b, reason: collision with root package name */
    private com.autonavi.aps.protocol.aps.authority.a f18503b;

    public void a(com.autonavi.aps.protocol.aps.authority.a aVar) {
        this.f18503b = aVar;
    }

    public void a(Map<Version, com.autonavi.aps.protocol.aps.common.d.a> map) {
        this.f18502a = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public com.autonavi.aps.protocol.aps.common.a.b a(com.autonavi.aps.protocol.aps.request.model.b.a aVar) {
        com.autonavi.aps.protocol.aps.request.model.message.a aVar2 = new com.autonavi.aps.protocol.aps.request.model.message.a();
        if (aVar != null && aVar.b() != null) {
            com.autonavi.aps.protocol.aps.common.d.a aVar3 = this.f18502a.get(aVar.b());
            if (aVar3 == null) {
                aVar2.a(Status.REQ_ENC_INVALID_VERSION);
                return aVar2;
            }
            aVar3.a(this.f18503b);
            com.autonavi.aps.protocol.aps.request.model.message.a aVar4 = (com.autonavi.aps.protocol.aps.request.model.message.a) aVar3.a((com.autonavi.aps.protocol.aps.common.d.a) aVar);
            aVar4.a(this.f18503b);
            return aVar4;
        }
        aVar2.a(Status.RES_ENC_OBJECT_EMPTY);
        return aVar2;
    }
}
