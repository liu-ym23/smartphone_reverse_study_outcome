package com.obric.aiagent.executionengine.capabilitymanager.publish;

import android.content.Intent;
import android.os.IBinder;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.volcengine.zeus.service.PluginService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: RegistrationServiceImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RegistrationServiceImpl extends PluginService {
    private final RegistrationServiceImpl$registerBinder$1 registerBinder;

    public void onCreate() {
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.aiagent.executionengine.capabilitymanager.publish.RegistrationServiceImpl$registerBinder$1] */
    public RegistrationServiceImpl() {
        this.registerBinder = new RegistrationServiceImpl$registerBinder$1(this);
    }

    public IBinder onBind(Intent r2) {
        o.e(r2, MemorySourceLinkType.INTENT);
        return (IBinder) ZeusTransformUtils.preCheckCast(this.registerBinder, IBinder.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int onStartCommand(Intent r1, int r2, int r3) {
        ILogDepend.Companion.d("RegistrationServiceImpl", "onStartCommand result: " + super/*android.app.Service*/.onStartCommand(r1, r2, r3));
        return 2;
    }
}
