package com.autonavi.aps.protocol.aps.response.model.vo;

import com.autonavi.aps.protocol.aps.common.enums.Version;
import com.autonavi.aps.protocol.aps.response.model.b.a;

/* loaded from: classes.dex */
public abstract class a extends b {

    /* renamed from: b, reason: collision with root package name */
    protected a.C0216a f19105b = new a.C0216a();

    /* renamed from: com.autonavi.aps.protocol.aps.response.model.vo.a$a, reason: collision with other inner class name */
    public static class C0217a extends a {

        /* renamed from: a, reason: collision with root package name */
        private static C0217a f19106a = new C0217a();

        private C0217a() {
        }

        public static C0217a c() {
            return f19106a;
        }

        @Override // com.autonavi.aps.protocol.aps.response.model.vo.a
        public com.autonavi.aps.protocol.aps.common.d.b a() {
            return null;
        }

        @Override // com.autonavi.aps.protocol.aps.response.model.vo.a, com.autonavi.aps.protocol.aps.response.model.vo.b
        public Version b() {
            return Version.UNKNOWN;
        }
    }

    public abstract com.autonavi.aps.protocol.aps.common.d.b a();

    @Override // com.autonavi.aps.protocol.aps.response.model.vo.b
    public Version b() {
        return this.f19110h;
    }

    public a.C0216a d() {
        return this.f19105b;
    }

    public com.autonavi.aps.protocol.aps.response.model.a.a e() {
        return a().a((com.autonavi.aps.protocol.aps.common.d.b) this);
    }
}
