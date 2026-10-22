package com.stepos.ability.commoninternal;

import C4.c;
import C7.r;
import S7.a;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.b;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0007\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\t\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\t\u0010\bJ\r\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u0003R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R \u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/ability/commoninternal/NetworkStateBridge;", "", AppAgent.CONSTRUCT, "()V", "Lkotlin/Function0;", "LC7/r;", "listener", "registerOnNetworkLost", "(LS7/a;)V", "unregisterOnNetworkLost", "notifyNetworkLost", "", "TAG", "Ljava/lang/String;", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "", "listeners", "Ljava/util/Set;", "commonInternal_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NetworkStateBridge {
    private static final String TAG = "NetworkStateBridge";
    public static final NetworkStateBridge INSTANCE = new NetworkStateBridge();
    private static final Handler handler = new Handler(Looper.getMainLooper());
    private static final Set<a> listeners = new LinkedHashSet();

    private NetworkStateBridge() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyNetworkLost$lambda$0() {
        Object objA;
        Iterator<T> it = listeners.iterator();
        while (it.hasNext()) {
            try {
                ((a) it.next()).invoke();
                objA = r.f317a;
            } catch (Throwable th) {
                objA = b.a(th);
            }
            Throwable thA = Result.a(objA);
            if (thA != null) {
                Log.e(TAG, "onNetworkLost listener failed", thA);
            }
        }
    }

    public final void notifyNetworkLost() {
        Log.w(TAG, "notifyNetworkLost: dispatching to " + listeners.size() + " listener(s)");
        handler.post(new c(4));
    }

    public final void registerOnNetworkLost(a listener) {
        k.f(listener, "listener");
        listeners.add(listener);
    }

    public final void unregisterOnNetworkLost(a listener) {
        k.f(listener, "listener");
        listeners.remove(listener);
    }
}
