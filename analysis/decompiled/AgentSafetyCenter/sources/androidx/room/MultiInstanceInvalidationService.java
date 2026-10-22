package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.IMultiInstanceInvalidationService;
import java.util.LinkedHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class MultiInstanceInvalidationService extends Service {

    /* renamed from: c, reason: collision with root package name */
    public int f1480c;

    /* renamed from: f, reason: collision with root package name */
    public final LinkedHashMap f1481f = new LinkedHashMap();

    /* renamed from: g, reason: collision with root package name */
    public final h f1482g = new h(this);

    /* renamed from: h, reason: collision with root package name */
    public final MultiInstanceInvalidationService$binder$1 f1483h = new IMultiInstanceInvalidationService.Stub() { // from class: androidx.room.MultiInstanceInvalidationService$binder$1
        @Override // androidx.room.IMultiInstanceInvalidationService
        public void broadcastInvalidation(int i, String[] strArr) {
            strArr.getClass();
            MultiInstanceInvalidationService multiInstanceInvalidationService = this.this$0;
            synchronized (multiInstanceInvalidationService.f1482g) {
                String str = (String) multiInstanceInvalidationService.f1481f.get(Integer.valueOf(i));
                if (str == null) {
                    Log.w("ROOM", "Remote invalidation client ID not registered");
                    return;
                }
                int iBeginBroadcast = multiInstanceInvalidationService.f1482g.beginBroadcast();
                int i3 = 0;
                while (true) {
                    h hVar = multiInstanceInvalidationService.f1482g;
                    if (i3 >= iBeginBroadcast) {
                        hVar.finishBroadcast();
                        return;
                    }
                    try {
                        Object broadcastCookie = hVar.getBroadcastCookie(i3);
                        broadcastCookie.getClass();
                        Integer num = (Integer) broadcastCookie;
                        int iIntValue = num.intValue();
                        String str2 = (String) multiInstanceInvalidationService.f1481f.get(num);
                        if (i != iIntValue && str.equals(str2)) {
                            try {
                                ((IMultiInstanceInvalidationCallback) multiInstanceInvalidationService.f1482g.getBroadcastItem(i3)).onInvalidation(strArr);
                            } catch (RemoteException e10) {
                                Log.w("ROOM", "Error invoking a remote callback", e10);
                            }
                        }
                        i3++;
                    } catch (Throwable th) {
                        multiInstanceInvalidationService.f1482g.finishBroadcast();
                        throw th;
                    }
                }
            }
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public int registerCallback(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, String str) {
            iMultiInstanceInvalidationCallback.getClass();
            int i = 0;
            if (str == null) {
                return 0;
            }
            MultiInstanceInvalidationService multiInstanceInvalidationService = this.this$0;
            synchronized (multiInstanceInvalidationService.f1482g) {
                try {
                    int i3 = multiInstanceInvalidationService.f1480c + 1;
                    multiInstanceInvalidationService.f1480c = i3;
                    if (multiInstanceInvalidationService.f1482g.register(iMultiInstanceInvalidationCallback, Integer.valueOf(i3))) {
                        multiInstanceInvalidationService.f1481f.put(Integer.valueOf(i3), str);
                        i = i3;
                    } else {
                        multiInstanceInvalidationService.f1480c--;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return i;
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public void unregisterCallback(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, int i) {
            iMultiInstanceInvalidationCallback.getClass();
            MultiInstanceInvalidationService multiInstanceInvalidationService = this.this$0;
            synchronized (multiInstanceInvalidationService.f1482g) {
                multiInstanceInvalidationService.f1482g.unregister(iMultiInstanceInvalidationCallback);
            }
        }
    };

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        intent.getClass();
        return this.f1483h;
    }
}
