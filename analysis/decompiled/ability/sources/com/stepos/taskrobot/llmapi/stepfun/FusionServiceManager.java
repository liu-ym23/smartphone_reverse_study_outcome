package com.stepos.taskrobot.llmapi.stepfun;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.zyql.screenperception.api.IFusion;
import com.zyql.screenperception.api.IFusionCallback;
import f6.AbstractC1436a;
import kotlin.Metadata;

@Metadata(d1 = {"\u00007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0005*\u0001\u001e\u0018\u0000 !2\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\n\u001a\u00020\u00072\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ-\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR$\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/FusionServiceManager;", "", "Landroid/content/Context;", "context", AppAgent.CONSTRUCT, "(Landroid/content/Context;)V", "Lkotlin/Function1;", "", "LC7/r;", "callback", "bindService", "(LS7/k;)Z", "unbindService", "()V", "screenshot", "viewtree", "ocr", "Lcom/zyql/screenperception/api/IFusionCallback;", "getFusionData", "(ZZZLcom/zyql/screenperception/api/IFusionCallback;)Z", "isBound", "()Z", "Landroid/content/Context;", "Lcom/zyql/screenperception/api/IFusion;", "fusionService", "Lcom/zyql/screenperception/api/IFusion;", "isServiceBound", "Z", "connectionCallback", "LS7/k;", "com/stepos/taskrobot/llmapi/stepfun/FusionServiceManager$serviceConnection$1", "serviceConnection", "Lcom/stepos/taskrobot/llmapi/stepfun/FusionServiceManager$serviceConnection$1;", "Companion", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FusionServiceManager {
    private static final String TAG = "FusionServiceManager";
    private S7.k connectionCallback;
    private final Context context;
    private IFusion fusionService;
    private boolean isServiceBound;
    private final FusionServiceManager$serviceConnection$1 serviceConnection;

    /* JADX WARN: Type inference failed for: r2v1, types: [com.stepos.taskrobot.llmapi.stepfun.FusionServiceManager$serviceConnection$1] */
    public FusionServiceManager(Context context) {
        kotlin.jvm.internal.k.f(context, "context");
        this.context = context;
        this.serviceConnection = new ServiceConnection() { // from class: com.stepos.taskrobot.llmapi.stepfun.FusionServiceManager$serviceConnection$1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName name, IBinder service) {
                AbstractC1436a.a("FusionServiceManager", "融合服务连接成功", true);
                this.this$0.fusionService = IFusion.Stub.asInterface(service);
                this.this$0.isServiceBound = true;
                S7.k kVar = this.this$0.connectionCallback;
                if (kVar != null) {
                    kVar.invoke(Boolean.TRUE);
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName name) {
                AbstractC1436a.a("FusionServiceManager", "融合服务断开连接", true);
                this.this$0.isServiceBound = false;
                this.this$0.fusionService = null;
                S7.k kVar = this.this$0.connectionCallback;
                if (kVar != null) {
                    kVar.invoke(Boolean.FALSE);
                }
            }
        };
    }

    public static /* synthetic */ boolean bindService$default(FusionServiceManager fusionServiceManager, S7.k kVar, int i, Object obj) {
        if ((i & 1) != 0) {
            kVar = null;
        }
        return fusionServiceManager.bindService(kVar);
    }

    public final boolean bindService(S7.k callback) {
        this.connectionCallback = callback;
        AbstractC1436a.a(TAG, "开始绑定融合服务", true);
        try {
            Intent intent = new Intent("com.zyql.screenperception.api.FusionService");
            intent.setPackage("com.zyql.screenperception.api");
            if (this.context.getPackageManager().resolveService(intent, 0) != null) {
                boolean zBindService = this.context.bindService(intent, this.serviceConnection, 1);
                if (!zBindService) {
                    AbstractC1436a.b(TAG, "绑定融合服务失败", true);
                }
                return zBindService;
            }
            AbstractC1436a.b(TAG, "没有找到融合服务组件", true);
            if (callback == null) {
                return false;
            }
            callback.invoke(Boolean.FALSE);
            return false;
        } catch (Exception e) {
            AbstractC1436a.c(TAG, "绑定融合服务异常", e);
            return false;
        }
    }

    public final boolean getFusionData(boolean screenshot, boolean viewtree, boolean ocr, IFusionCallback callback) {
        kotlin.jvm.internal.k.f(callback, "callback");
        if (!this.isServiceBound) {
            AbstractC1436a.b(TAG, "服务未连接", true);
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("screenshot", screenshot);
        bundle.putBoolean("viewtree", viewtree);
        bundle.putBoolean("ocr", ocr);
        try {
            IFusion iFusion = this.fusionService;
            if (iFusion != null) {
                iFusion.getFusionData(bundle, callback);
            }
            return true;
        } catch (RemoteException e) {
            AbstractC1436a.c(TAG, "执行融合数据获取失败", e);
            return false;
        }
    }

    /* renamed from: isBound, reason: from getter */
    public final boolean getIsServiceBound() {
        return this.isServiceBound;
    }

    public final void unbindService() {
        if (this.isServiceBound) {
            this.context.unbindService(this.serviceConnection);
            this.isServiceBound = false;
        }
    }
}
