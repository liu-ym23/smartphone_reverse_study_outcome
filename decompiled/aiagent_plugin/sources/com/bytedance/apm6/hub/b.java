package com.bytedance.apm6.hub;

import com.bytedance.apm6.consumer.slardar.g;
import com.bytedance.apm6.frequency.d;
import com.bytedance.apm6.hub.a.f;
import com.bytedance.apm6.hub.a.h;
import com.bytedance.apm6.hub.a.i;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.e;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: ApmAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b implements com.bytedance.apm6.foundation.context.b {
    public abstract IHttpService a();

    public abstract e n();

    public abstract com.bytedance.apm6.service.b.a o();

    @Override // com.bytedance.apm6.foundation.context.b
    public JSONObject p() {
        return null;
    }

    @Override // com.bytedance.apm6.foundation.context.b
    public JSONObject q() {
        return null;
    }

    @Override // com.bytedance.apm6.foundation.context.b
    public Map<String, String> r() {
        return null;
    }

    public g t() {
        return null;
    }

    public com.bytedance.apm6.a.a v() {
        return null;
    }

    public com.bytedance.apm6.service.a.a w() {
        return null;
    }

    public long x() {
        return 0;
    }

    public b() {
    }

    public com.bytedance.apm6.consumer.slardar.a.b y() {
        return new i(s());
    }

    public com.bytedance.apm6.commonevent.a.b z() {
        return new com.bytedance.apm6.hub.a.a();
    }

    public com.bytedance.apm6.hub.a.b A() {
        return new com.bytedance.apm6.hub.a.b();
    }

    public com.bytedance.apm6.hub.a.e B() {
        return new com.bytedance.apm6.hub.a.e();
    }

    public com.bytedance.apm6.a.b.b u() {
        return new h();
    }

    public com.bytedance.apm6.hub.a.g C() {
        return new com.bytedance.apm6.hub.a.g();
    }

    public d D() {
        return new f();
    }
}
