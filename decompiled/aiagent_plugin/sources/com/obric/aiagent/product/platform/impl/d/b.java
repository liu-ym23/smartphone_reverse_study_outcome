package com.obric.aiagent.product.platform.impl.d;

import android.app.IObricNotificationListener;
import android.app.ObricNotificationManager;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.platform.api.notification.IObricNotificationManager;
import com.obric.aiagent.product.platform.api.notification.ObricNotificationListener;
import com.obric.aiagent.product.platform.api.notification.ObricToastShowListener;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: CommonObricNotificationManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements IObricNotificationManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18837a = null;

    /* JADX INFO: compiled from: CommonObricNotificationManager.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f18837a = new a(null);
    }

    public b() {
    }

    @Override // com.obric.aiagent.product.platform.api.notification.IObricNotificationManager
    public boolean registerNotificationListener(ObricNotificationListener r2) {
        o.e(r2, "listener");
        Object r1 = r2.getObricStub();
        o.a(r1, "null cannot be cast to non-null type android.app.IObricNotificationListener");
        return ObricNotificationManager.registerNotificationListener((IObricNotificationListener) ZeusTransformUtils.preCheckCast(r1, IObricNotificationListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.notification.IObricNotificationManager
    public boolean unregisterNotificationListener(ObricNotificationListener r2) {
        o.e(r2, "listener");
        Object r1 = r2.getObricStub();
        o.a(r1, "null cannot be cast to non-null type android.app.IObricNotificationListener");
        return ObricNotificationManager.unregisterNotificationListener((IObricNotificationListener) ZeusTransformUtils.preCheckCast(r1, IObricNotificationListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.notification.IObricNotificationManager
    public boolean registerToastShowListener(ObricToastShowListener r3) {
        o.e(r3, "listener");
        return c.f18838a.a(r3);
    L5:
        th = move-exception;
        ILogDepend.Companion.e("CommonObricNotificationManager", "registerToastShowListener failed", th);
        return false;
    }

    @Override // com.obric.aiagent.product.platform.api.notification.IObricNotificationManager
    public boolean unregisterToastShowListener(ObricToastShowListener r3) {
        o.e(r3, "listener");
        return c.f18838a.b(r3);
    L5:
        th = move-exception;
        ILogDepend.Companion.e("CommonObricNotificationManager", "unregisterToastShowListener failed", th);
        return false;
    }

    @Override // com.obric.aiagent.product.platform.api.notification.IObricNotificationManager
    public boolean isPanelShown() {
        return ObricNotificationManager.isPanelShown();
    }
}
