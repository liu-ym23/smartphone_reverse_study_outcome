package com.obric.aiagent.product.platform.impl.a;

import android.os.AssistantDeviceIdleController;
import com.obric.aiagent.product.platform.api.device.IObricDeviceIdleController;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: AssistantDeviceIdleControllerImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements IObricDeviceIdleController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0399a f18802a = null;

    /* JADX INFO: renamed from: com.obric.aiagent.product.platform.impl.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AssistantDeviceIdleControllerImpl.kt */
    public static final class C0399a {
        public /* synthetic */ C0399a(h r1) {
            this();
        }

        private C0399a() {
        }
    }

    static {
        f18802a = new C0399a(null);
    }

    public a() {
    }

    @Override // com.obric.aiagent.product.platform.api.device.IObricDeviceIdleController
    public boolean addToTemporaryAllowList(String[] r1, long r2, String r4) {
        o.e(r1, "pkgList");
        o.e(r4, "reason");
        return AssistantDeviceIdleController.getInstance().addToTemporaryAllowList(r1, r2, r4);
    }

    @Override // com.obric.aiagent.product.platform.api.device.IObricDeviceIdleController
    public boolean removeFromTemporaryAllowList(String[] r1, String r2) {
        o.e(r1, "pkgList");
        o.e(r2, "reason");
        return AssistantDeviceIdleController.getInstance().removeFromTemporaryAllowList(r1, r2);
    }
}
