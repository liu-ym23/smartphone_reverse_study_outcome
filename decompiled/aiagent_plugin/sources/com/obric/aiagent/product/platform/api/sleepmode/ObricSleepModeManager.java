package com.obric.aiagent.product.platform.api.sleepmode;

import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.a.b;
import com.obric.aiagent.product.platform.impl.e.a;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.framework.services.ServiceProvider;
import com.ss.android.ugc.aweme.framework.services.SingletonProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ObricSleepModeManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObricSleepModeManager {
    public static final Companion Companion = null;
    private static final String TAG = "ObricSleepModeManager";
    private static IObricSleepModeManager instance;

    /* JADX INFO: compiled from: ObricSleepModeManager.kt */
    public static final class Companion implements IObricSleepModeManager {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }

        @Override // com.obric.aiagent.product.platform.api.sleepmode.IObricSleepModeManager
        public boolean inSleepMode() {
            IObricSleepModeManager r0 = ObricSleepModeManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.inSleepMode();
        }

        @Override // com.obric.aiagent.product.platform.api.sleepmode.IObricSleepModeManager
        public void forceExitSleepMode(String r1, String r2) {
            o.e(r1, "pkgName");
            o.e(r2, "event");
            IObricSleepModeManager r0 = ObricSleepModeManager.access$getInstance$cp();
            if (r0 == null) goto L6;
            r0.forceExitSleepMode(r1, r2);
            return;
        }
    }

    public static void forceExitSleepMode(String r1, String r2) {
        Companion.forceExitSleepMode(r1, r2);
    }

    public static boolean inSleepMode() {
        return Companion.inSleepMode();
    }

    public static /* synthetic */ Object lambda$TQ0wggYuoBoIExqTLYSRtj3Lbxg() {
        return _init_$lambda$0();
    }

    public static /* synthetic */ Object lambda$fKWTz2KYPL3Iox85YtGseohtuk8() {
        return _init_$lambda$1();
    }

    public ObricSleepModeManager() {
    }

    public static final /* synthetic */ IObricSleepModeManager access$getInstance$cp() {
        return instance;
    }

    static {
        Companion = new Companion(null);
    L9:
        th = move-exception;
        ILogDepend.Companion.e(TAG, "bind SleepModeManager failed", th);
    L11:
        instance = (IObricSleepModeManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IObricSleepModeManager.class, false), IObricSleepModeManager.class, "com.obric.aiagent.plugin");
        return;
    L4:
        if (b.f18770a.a() == false) goto L6;
        ServiceManager.get().bind(IObricSleepModeManager.class, (ServiceProvider) ZeusTransformUtils.preCheckCast(new SingletonProvider($$Lambda$ObricSleepModeManager$TQ0wggYuoBoIExqTLYSRtj3Lbxg.INSTANCE), ServiceProvider.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L9
    L7:
        ILogDepend.Companion.i(TAG, "bind SleepModeManager success");     // Catch: Throwable -> L9
        goto L11
    L6:
        ServiceManager.get().bind(IObricSleepModeManager.class, (ServiceProvider) ZeusTransformUtils.preCheckCast(new SingletonProvider($$Lambda$ObricSleepModeManager$fKWTz2KYPL3Iox85YtGseohtuk8.INSTANCE), ServiceProvider.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L9
        goto L7
    }

    private static final Object _init_$lambda$0() {
        return new a();
    }

    private static final Object _init_$lambda$1() {
        return new com.obric.aiagent.product.platform.impl.e.b();
    }
}
