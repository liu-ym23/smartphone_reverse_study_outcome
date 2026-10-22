package com.bytedance.apm6.hub;

import com.bytedance.apm6.commonevent.config.CommonEventConfigService;
import com.bytedance.apm6.consumer.slardar.SlardarResponseService;
import com.bytedance.apm6.consumer.slardar.config.SlardarHandlerConfigService;
import com.bytedance.apm6.foundation.context.ApmContextAdapter;
import com.bytedance.apm6.memory.IMapsCollectService;
import com.bytedance.apm6.memory.config.MemoryConfigService;
import com.bytedance.apm6.service.device.IDeviceInfoService;
import com.bytedance.apm6.service.encrypt.EncryptService;
import com.bytedance.services.apm.api.IEncrypt;
import com.bytedance.services.apm.api.IHttpService;
import f3.b;
import f3.e;
import f3.f;
import f3.h;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements ApmContextAdapter {
    public a() {
    }

    public CommonEventConfigService a() {
        return new f3.a();
    }

    public b b() {
        return new b();
    }

    public abstract IDeviceInfoService c();

    public abstract EncryptService d();

    public abstract IEncrypt e();

    public e f() {
        return new e();
    }

    public abstract IHttpService g();

    @Override // com.bytedance.apm6.foundation.context.ApmContextAdapter
    public JSONObject getDynamicHeaderExtras() {
        return null;
    }

    public f h() {
        return new f();
    }

    public abstract IMapsCollectService i();

    public abstract MemoryConfigService j();

    public SlardarHandlerConfigService k() {
        return new h(getOutsideConfig());
    }

    public abstract SlardarResponseService l();

    public long m() {
        return 0;
    }
}
