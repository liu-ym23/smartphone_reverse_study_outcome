package b6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.aiengine.AIEngineApplication;
import com.stepos.cloudsdk.ICloudListener;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class j extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3070a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f3071b;

    public /* synthetic */ j(Object obj, int i10) {
        this.f3070a = i10;
        this.f3071b = obj;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        ICloudListener iCloudListener;
        ICloudListener iCloudListener2;
        int i10 = this.f3070a;
        Object obj = this.f3071b;
        switch (i10) {
            case 0:
                AIEngineApplication aIEngineApplication = (AIEngineApplication) obj;
                kotlin.jvm.internal.g.f(context, "context");
                kotlin.jvm.internal.g.f(intent, "intent");
                if (kotlin.jvm.internal.g.b(intent.getAction(), "android.intent.action.USER_UNLOCKED")) {
                    Log.i("AIEngineApplication", "USER_UNLOCKED received, performing full initialization");
                    int i11 = AIEngineApplication.f5748d;
                    aIEngineApplication.b();
                    try {
                        aIEngineApplication.unregisterReceiver(this);
                        break;
                    } catch (Exception e10) {
                        Log.w("AIEngineApplication", "Failed to unregister USER_UNLOCKED receiver", e10);
                        return;
                    }
                }
                break;
            case 1:
                if (intent != null && "com.stepos.cloudconfig.ACTION_CONFIG_UPDATED".equals(intent.getAction())) {
                    String stringExtra = intent.getStringExtra("_key");
                    if (!TextUtils.isEmpty(stringExtra)) {
                        a4.a.k("ConfigUpdateReceiver", "onReceive: config updated, key=" + stringExtra);
                        com.stepos.cloudsdk.a aVar = (com.stepos.cloudsdk.a) ((bd.j) obj).f3234g;
                        ConcurrentHashMap concurrentHashMap = aVar.f6420c;
                        if (!concurrentHashMap.isEmpty()) {
                            StringBuilder sbQ = a0.a.q("notifyListeners: key=", stringExtra, ", listenerCount=");
                            sbQ.append(concurrentHashMap.size());
                            a4.a.k("CloudClientImpl", sbQ.toString());
                            if (concurrentHashMap.size() == 1) {
                                iCloudListener = (ICloudListener) concurrentHashMap.values().iterator().next();
                            } else if (TextUtils.isEmpty(stringExtra) || (iCloudListener2 = (ICloudListener) concurrentHashMap.get(stringExtra)) == null) {
                                iCloudListener = (ICloudListener) concurrentHashMap.get("__GLOBAL__");
                                if (iCloudListener != null) {
                                    a4.a.k("CloudClientImpl", "findMatchingListener: using global listener for key=" + stringExtra);
                                } else {
                                    a4.a.k("CloudClientImpl", "findMatchingListener: no matching listener for key=" + stringExtra);
                                    iCloudListener = null;
                                }
                            } else {
                                a4.a.k("CloudClientImpl", "findMatchingListener: matched by key=" + stringExtra);
                                iCloudListener = iCloudListener2;
                            }
                            if (iCloudListener != null) {
                                aVar.f6421d.execute(new com.stepos.core.model.manager.i((Object) aVar, stringExtra, (Object) iCloudListener, 3));
                                break;
                            } else {
                                a4.a.k("CloudClientImpl", "notifyListeners: no matching listener for key=" + stringExtra);
                                break;
                            }
                        } else {
                            a4.a.k("CloudClientImpl", "notifyListeners: no listeners, key=" + stringExtra);
                            break;
                        }
                    } else {
                        Log.w("CloudSDK_".concat("ConfigUpdateReceiver"), "onReceive: key is empty");
                        break;
                    }
                }
                break;
            default:
                kotlin.jvm.internal.g.f(context, "context");
                kotlin.jvm.internal.g.f(intent, "intent");
                ((o2.e) obj).f(intent);
                break;
        }
    }

    public j(bd.j jVar) {
        this.f3070a = 1;
        this.f3071b = jVar;
    }
}
