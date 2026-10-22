package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.IMultiInstanceInvalidationService;
import java.util.LinkedHashMap;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class MultiInstanceInvalidationService extends Service {

    /* renamed from: a, reason: collision with root package name */
    public int f2486a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f2487b = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name */
    public final a f2488c = new a();

    /* renamed from: d, reason: collision with root package name */
    public final MultiInstanceInvalidationService$binder$1 f2489d = new IMultiInstanceInvalidationService.Stub() { // from class: androidx.room.MultiInstanceInvalidationService$binder$1
        @Override // androidx.room.IMultiInstanceInvalidationService
        public void broadcastInvalidation(int i10, String[] tables) {
            kotlin.jvm.internal.g.f(tables, "tables");
            MultiInstanceInvalidationService multiInstanceInvalidationService = this.this$0;
            synchronized (multiInstanceInvalidationService.f2488c) {
                String str = (String) multiInstanceInvalidationService.f2487b.get(Integer.valueOf(i10));
                if (str == null) {
                    Log.w("ROOM", "Remote invalidation client ID not registered");
                    return;
                }
                int iBeginBroadcast = multiInstanceInvalidationService.f2488c.beginBroadcast();
                for (int i11 = 0; i11 < iBeginBroadcast; i11++) {
                    try {
                        Object broadcastCookie = multiInstanceInvalidationService.f2488c.getBroadcastCookie(i11);
                        kotlin.jvm.internal.g.d(broadcastCookie, "null cannot be cast to non-null type kotlin.Int");
                        Integer num = (Integer) broadcastCookie;
                        int iIntValue = num.intValue();
                        String str2 = (String) multiInstanceInvalidationService.f2487b.get(num);
                        if (i10 != iIntValue && str.equals(str2)) {
                            try {
                                multiInstanceInvalidationService.f2488c.getBroadcastItem(i11).onInvalidation(tables);
                            } catch (RemoteException e10) {
                                Log.w("ROOM", "Error invoking a remote callback", e10);
                            }
                        }
                    } catch (Throwable th) {
                        multiInstanceInvalidationService.f2488c.finishBroadcast();
                        throw th;
                    }
                }
                multiInstanceInvalidationService.f2488c.finishBroadcast();
                lb.n nVar = lb.n.f10413a;
            }
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public int registerCallback(IMultiInstanceInvalidationCallback callback, String str) {
            kotlin.jvm.internal.g.f(callback, "callback");
            int i10 = 0;
            if (str == null) {
                return 0;
            }
            MultiInstanceInvalidationService multiInstanceInvalidationService = this.this$0;
            synchronized (multiInstanceInvalidationService.f2488c) {
                try {
                    int i11 = multiInstanceInvalidationService.f2486a + 1;
                    multiInstanceInvalidationService.f2486a = i11;
                    if (multiInstanceInvalidationService.f2488c.register(callback, Integer.valueOf(i11))) {
                        multiInstanceInvalidationService.f2487b.put(Integer.valueOf(i11), str);
                        i10 = i11;
                    } else {
                        multiInstanceInvalidationService.f2486a--;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return i10;
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public void unregisterCallback(IMultiInstanceInvalidationCallback callback, int i10) {
            kotlin.jvm.internal.g.f(callback, "callback");
            MultiInstanceInvalidationService multiInstanceInvalidationService = this.this$0;
            synchronized (multiInstanceInvalidationService.f2488c) {
                multiInstanceInvalidationService.f2488c.unregister(callback);
            }
        }
    };

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a extends RemoteCallbackList<IMultiInstanceInvalidationCallback> {
        public a() {
        }

        @Override // android.os.RemoteCallbackList
        public final void onCallbackDied(IInterface iInterface, Object cookie) {
            IMultiInstanceInvalidationCallback callback = (IMultiInstanceInvalidationCallback) iInterface;
            kotlin.jvm.internal.g.f(callback, "callback");
            kotlin.jvm.internal.g.f(cookie, "cookie");
            MultiInstanceInvalidationService.this.f2487b.remove((Integer) cookie);
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        kotlin.jvm.internal.g.f(intent, "intent");
        return this.f2489d;
    }
}
