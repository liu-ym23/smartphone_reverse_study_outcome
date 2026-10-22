package com.autonavi.aps.protocol.aps.response.model.vo;

import com.autonavi.aps.protocol.aps.common.d.f;
import com.autonavi.aps.protocol.aps.common.enums.Status;
import com.autonavi.aps.protocol.aps.common.enums.Version;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class b implements f {

    /* renamed from: e, reason: collision with root package name */
    protected Status f19107e = Status.SUCCESS;

    /* renamed from: f, reason: collision with root package name */
    protected Map<String, String> f19108f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    protected Map<String, String> f19109g = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    protected Version f19110h = Version.UNKNOWN;

    public void a(Status status) {
        this.f19107e = status;
    }

    public abstract Version b();

    public Status f() {
        return this.f19107e;
    }

    public void a(Version version) {
        this.f19110h = version;
    }
}
