package com.autonavi.aps.protocol.aps.impl.v57.vo;

import com.autonavi.aps.protocol.aps.common.enums.Version;

/* loaded from: classes.dex */
public class a extends com.autonavi.aps.protocol.aps.request.model.b.a {

    /* renamed from: a, reason: collision with root package name */
    com.autonavi.aps.protocol.aps.impl.v57.a.a f18863a;

    public com.autonavi.aps.protocol.aps.impl.v57.a.a a() {
        return this.f18863a;
    }

    @Override // com.autonavi.aps.protocol.aps.response.model.vo.b
    public Version b() {
        return Version.V57;
    }

    public void a(com.autonavi.aps.protocol.aps.impl.v57.a.a aVar) {
        this.f18863a = aVar;
    }
}
