package com.autonavi.aps.protocol.aps.request.model.b;

import com.autonavi.aps.protocol.aps.request.model.message.a;
import com.autonavi.aps.protocol.aps.response.model.vo.b;

/* loaded from: classes.dex */
public abstract class a extends b {

    /* renamed from: b, reason: collision with root package name */
    protected a.C0215a f18920b = new a.C0215a();

    /* renamed from: c, reason: collision with root package name */
    protected a.b f18921c = new a.b();

    /* renamed from: d, reason: collision with root package name */
    protected byte[] f18922d = null;

    public void a(a.C0215a c0215a) {
        this.f18920b = c0215a;
    }

    public a.C0215a c() {
        return this.f18920b;
    }

    public a.b d() {
        return this.f18921c.a(b());
    }

    public void a(a.b bVar) {
        this.f18921c = bVar;
    }
}
