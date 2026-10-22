package com.autonavi.aps.protocol.aps.common.c;

import com.autonavi.aps.protocol.aps.common.a.c;
import com.autonavi.aps.protocol.aps.common.enums.Status;
import com.autonavi.aps.protocol.aps.common.enums.Version;
import com.autonavi.aps.protocol.aps.response.model.vo.a;
import java.util.Map;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private Map<Version, com.autonavi.aps.protocol.aps.common.d.b> f18504a;

    /* renamed from: b, reason: collision with root package name */
    private com.autonavi.aps.protocol.aps.authority.a f18505b;

    public void a(com.autonavi.aps.protocol.aps.authority.a aVar) {
        this.f18505b = aVar;
    }

    public void a(Map<Version, com.autonavi.aps.protocol.aps.common.d.b> map) {
        this.f18504a = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public com.autonavi.aps.protocol.aps.response.model.vo.a a(c cVar) {
        if (cVar != null && cVar.a() != null) {
            com.autonavi.aps.protocol.aps.common.d.b bVar = this.f18504a.get(cVar.a());
            bVar.a(this.f18505b);
            com.autonavi.aps.protocol.aps.response.model.vo.a aVar = (com.autonavi.aps.protocol.aps.response.model.vo.a) bVar.a((com.autonavi.aps.protocol.aps.common.d.b) cVar);
            if (aVar.b() != null && aVar.b() != Version.INVALID) {
                return aVar;
            }
            aVar.a(cVar.a());
            return aVar;
        }
        a.C0217a c0217aC = a.C0217a.c();
        c0217aC.a(Status.REQ_DEC_MSG_IS_NULL);
        return c0217aC;
    }
}
