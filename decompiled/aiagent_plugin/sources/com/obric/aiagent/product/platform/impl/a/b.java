package com.obric.aiagent.product.platform.impl.a;

import android.os.ObricDeviceIdleController;
import com.obric.aiagent.product.platform.api.device.IObricDeviceIdleController;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: CommonObricDeviceIdleController.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements IObricDeviceIdleController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18803a = null;

    /* JADX INFO: compiled from: CommonObricDeviceIdleController.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f18803a = new a(null);
    }

    public b() {
    }

    @Override // com.obric.aiagent.product.platform.api.device.IObricDeviceIdleController
    public boolean addToTemporaryAllowList(String[] r1, long r2, String r4) {
        o.e(r1, "pkgList");
        o.e(r4, "reason");
        return ObricDeviceIdleController.getInstance().addToTemporaryAllowList(r1, r2, r4);
    }

    @Override // com.obric.aiagent.product.platform.api.device.IObricDeviceIdleController
    public boolean removeFromTemporaryAllowList(String[] r1, String r2) {
        o.e(r1, "pkgList");
        o.e(r2, "reason");
        return ObricDeviceIdleController.getInstance().removeFromTemporaryAllowList(r1, r2);
    }
}
