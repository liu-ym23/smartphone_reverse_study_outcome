package com.obric.aiagent.product.platform.api.notification;

import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.a.b;
import com.obric.aiagent.product.platform.impl.d.a;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.framework.services.ServiceProvider;
import com.ss.android.ugc.aweme.framework.services.SingletonProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ObricNotificationManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObricNotificationManager {
    public static final Companion Companion = null;
    private static final String TAG = "ObricNotificationManager";
    private static IObricNotificationManager instance;

    /* JADX INFO: compiled from: ObricNotificationManager.kt */
    public static final class Companion implements IObricNotificationManager {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }

        @Override // com.obric.aiagent.product.platform.api.notification.IObricNotificationManager
        public boolean registerNotificationListener(ObricNotificationListener r1) {
            o.e(r1, "listener");
            IObricNotificationManager r0 = ObricNotificationManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.registerNotificationListener(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.notification.IObricNotificationManager
        public boolean unregisterNotificationListener(ObricNotificationListener r1) {
            o.e(r1, "listener");
            IObricNotificationManager r0 = ObricNotificationManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.unregisterNotificationListener(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.notification.IObricNotificationManager
        public boolean registerToastShowListener(ObricToastShowListener r1) {
            o.e(r1, "listener");
            IObricNotificationManager r0 = ObricNotificationManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.registerToastShowListener(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.notification.IObricNotificationManager
        public boolean unregisterToastShowListener(ObricToastShowListener r1) {
            o.e(r1, "listener");
            IObricNotificationManager r0 = ObricNotificationManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.unregisterToastShowListener(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.notification.IObricNotificationManager
        public boolean isPanelShown() {
            IObricNotificationManager r0 = ObricNotificationManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.isPanelShown();
        }
    }

    public static boolean isPanelShown() {
        return Companion.isPanelShown();
    }

    public static /* synthetic */ Object lambda$dFk3Gosn6WI0nsbOGiMd58n74qo() {
        return _init_$lambda$1();
    }

    /* JADX INFO: renamed from: lambda$pc2cedMKnPx-gaSEwoECvzpcRy0, reason: not valid java name */
    public static /* synthetic */ Object m220lambda$pc2cedMKnPxgaSEwoECvzpcRy0() {
        return _init_$lambda$0();
    }

    public static boolean registerNotificationListener(ObricNotificationListener r1) {
        return Companion.registerNotificationListener(r1);
    }

    public static boolean registerToastShowListener(ObricToastShowListener r1) {
        return Companion.registerToastShowListener(r1);
    }

    public static boolean unregisterNotificationListener(ObricNotificationListener r1) {
        return Companion.unregisterNotificationListener(r1);
    }

    public static boolean unregisterToastShowListener(ObricToastShowListener r1) {
        return Companion.unregisterToastShowListener(r1);
    }

    public ObricNotificationManager() {
    }

    public static final /* synthetic */ IObricNotificationManager access$getInstance$cp() {
        return instance;
    }

    static {
        Companion = new Companion(null);
    L9:
        th = move-exception;
        ILogDepend.Companion.e(TAG, "bind NotificationManager failed", th);
    L11:
        instance = (IObricNotificationManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IObricNotificationManager.class, false), IObricNotificationManager.class, "com.obric.aiagent.plugin");
        return;
    L4:
        if (b.f18770a.a() == false) goto L6;
        ServiceManager.get().bind(IObricNotificationManager.class, (ServiceProvider) ZeusTransformUtils.preCheckCast(new SingletonProvider($$Lambda$ObricNotificationManager$pc2cedMKnPxgaSEwoECvzpcRy0.INSTANCE), ServiceProvider.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L9
    L7:
        ILogDepend.Companion.i(TAG, "bind NotificationManager assistantApi=" + b.f18770a.a());     // Catch: Throwable -> L9
        goto L11
    L6:
        ServiceManager.get().bind(IObricNotificationManager.class, (ServiceProvider) ZeusTransformUtils.preCheckCast(new SingletonProvider($$Lambda$ObricNotificationManager$dFk3Gosn6WI0nsbOGiMd58n74qo.INSTANCE), ServiceProvider.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L9
        goto L7
    }

    private static final Object _init_$lambda$0() {
        return new a();
    }

    private static final Object _init_$lambda$1() {
        return new com.obric.aiagent.product.platform.impl.d.b();
    }
}
