package com.bytedance.android.anniex.assemble.initialize;

import android.app.Application;
import com.bytedance.android.anniex.base.depend.ApplicationDepend;
import com.bytedance.android.anniex.base.depend.DeviceDepend;
import com.bytedance.android.anniex.base.service.AnnieXServiceProvider;
import com.larus.common.apphost.AppHost;
import com.ss.android.lark.utils.statistics.PerfLog;
import ha.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/anniex/assemble/initialize/AnnieXHostDepend;", "Lcom/bytedance/android/anniex/assemble/initialize/IAnnieXHostDepend;", "<init>", "()V", "createApplicationDepend", "Lcom/bytedance/android/anniex/base/depend/ApplicationDepend;", "createDeviceDepend", "Lcom/bytedance/android/anniex/base/depend/DeviceDepend;", "createServiceProvider", "Lcom/bytedance/android/anniex/base/service/AnnieXServiceProvider;", "bid", "", "ensureRuntimeReady", "", "initRelax", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/app/Application;", "ivykit-host-default_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AnnieXHostDepend implements ha.a {

    public static final class a extends ApplicationDepend {
        @Override // com.bytedance.android.anniex.base.depend.ApplicationDepend
        public final Boolean b() {
            AppHost.Companion r100 = AppHost.f326268a;
            if (r100.isTestChannel() == false) goto L5;
        L8:
            boolean r101 = true;
        L10:
            return Boolean.valueOf(r101);
        L5:
            if (r100.isDebug() == true) goto L8;
            r101 = false;
            goto L10
        }

        public a() {
        }
    }

    public AnnieXHostDepend() {
    }

    @Override // ha.a
    public DeviceDepend createDeviceDepend() {
        return null;
    }

    public void ensureRuntimeReady() {
    }

    @Override // ha.a
    public void initRelax(Application r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // ha.a
    public ApplicationDepend createApplicationDepend() {
        return new a();
    }

    @Override // ha.a
    public AnnieXServiceProvider createServiceProvider(String r100) {
        Intrinsics.checkNotNullParameter(r100, "bid");
        if (Intrinsics.areEqual(r100, "webcast") == true) goto L7;
        return null;
    L7:
        return new b();
    }
}
