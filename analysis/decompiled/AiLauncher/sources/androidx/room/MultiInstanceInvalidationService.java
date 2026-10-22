package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.IMultiInstanceInvalidationService;
import com.autonavi.aps.amapapi.config.Const;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\t8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR&\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00120\u00118\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\n\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u001d¨\u0006\u001f"}, d2 = {"Landroidx/room/MultiInstanceInvalidationService;", "Landroid/app/Service;", "<init>", "()V", "Landroid/content/Intent;", "intent", "Landroid/os/IBinder;", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "", Const.INTENT_KEY_APIKEY, "I", "c", "()I", Const.INTENT_KEY_UMID, "(I)V", "maxClientId", "", "", Const.INTENT_KEY_PKGNAME, "Ljava/util/Map;", "()Ljava/util/Map;", "clientNames", "Landroid/os/RemoteCallbackList;", "Landroidx/room/IMultiInstanceInvalidationCallback;", "Landroid/os/RemoteCallbackList;", "()Landroid/os/RemoteCallbackList;", "callbackList", "Landroidx/room/IMultiInstanceInvalidationService$Stub;", "Landroidx/room/IMultiInstanceInvalidationService$Stub;", "binder", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MultiInstanceInvalidationService extends Service {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public int maxClientId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Map<Integer, String> clientNames = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final RemoteCallbackList<IMultiInstanceInvalidationCallback> callbackList = new a();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final IMultiInstanceInvalidationService.Stub binder = new IMultiInstanceInvalidationService.Stub() { // from class: androidx.room.MultiInstanceInvalidationService$binder$1
        @Override // androidx.room.IMultiInstanceInvalidationService
        public void broadcastInvalidation(int clientId, String[] tables) {
            kotlin.jvm.internal.p.i(tables, "tables");
            RemoteCallbackList<IMultiInstanceInvalidationCallback> remoteCallbackListA = this.this$0.a();
            MultiInstanceInvalidationService multiInstanceInvalidationService = this.this$0;
            synchronized (remoteCallbackListA) {
                String str = multiInstanceInvalidationService.b().get(Integer.valueOf(clientId));
                if (str == null) {
                    Log.w("ROOM", "Remote invalidation client ID not registered");
                    return;
                }
                int iBeginBroadcast = multiInstanceInvalidationService.a().beginBroadcast();
                for (int i10 = 0; i10 < iBeginBroadcast; i10++) {
                    try {
                        Object broadcastCookie = multiInstanceInvalidationService.a().getBroadcastCookie(i10);
                        kotlin.jvm.internal.p.g(broadcastCookie, "null cannot be cast to non-null type kotlin.Int");
                        Integer num = (Integer) broadcastCookie;
                        int iIntValue = num.intValue();
                        String str2 = multiInstanceInvalidationService.b().get(num);
                        if (clientId != iIntValue && kotlin.jvm.internal.p.d(str, str2)) {
                            try {
                                ((IMultiInstanceInvalidationCallback) multiInstanceInvalidationService.a().getBroadcastItem(i10)).onInvalidation(tables);
                                Y8.t tVar = Y8.t.f7040a;
                            } catch (RemoteException e10) {
                                Log.w("ROOM", "Error invoking a remote callback", e10);
                            }
                        }
                    } catch (Throwable th) {
                        multiInstanceInvalidationService.a().finishBroadcast();
                        throw th;
                    }
                }
                multiInstanceInvalidationService.a().finishBroadcast();
                Y8.t tVar2 = Y8.t.f7040a;
            }
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public int registerCallback(IMultiInstanceInvalidationCallback callback, String name) {
            kotlin.jvm.internal.p.i(callback, "callback");
            int i10 = 0;
            if (name == null) {
                return 0;
            }
            RemoteCallbackList<IMultiInstanceInvalidationCallback> remoteCallbackListA = this.this$0.a();
            MultiInstanceInvalidationService multiInstanceInvalidationService = this.this$0;
            synchronized (remoteCallbackListA) {
                try {
                    multiInstanceInvalidationService.d(multiInstanceInvalidationService.getMaxClientId() + 1);
                    int maxClientId = multiInstanceInvalidationService.getMaxClientId();
                    if (multiInstanceInvalidationService.a().register(callback, Integer.valueOf(maxClientId))) {
                        multiInstanceInvalidationService.b().put(Integer.valueOf(maxClientId), name);
                        i10 = maxClientId;
                    } else {
                        multiInstanceInvalidationService.d(multiInstanceInvalidationService.getMaxClientId() - 1);
                        multiInstanceInvalidationService.getMaxClientId();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return i10;
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public void unregisterCallback(IMultiInstanceInvalidationCallback callback, int clientId) {
            kotlin.jvm.internal.p.i(callback, "callback");
            RemoteCallbackList<IMultiInstanceInvalidationCallback> remoteCallbackListA = this.this$0.a();
            MultiInstanceInvalidationService multiInstanceInvalidationService = this.this$0;
            synchronized (remoteCallbackListA) {
                multiInstanceInvalidationService.a().unregister(callback);
                multiInstanceInvalidationService.b().remove(Integer.valueOf(clientId));
            }
        }
    };

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"androidx/room/MultiInstanceInvalidationService$a", "Landroid/os/RemoteCallbackList;", "Landroidx/room/IMultiInstanceInvalidationCallback;", "callback", "", "cookie", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroidx/room/IMultiInstanceInvalidationCallback;Ljava/lang/Object;)V", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends RemoteCallbackList<IMultiInstanceInvalidationCallback> {
        public a() {
        }

        @Override // android.os.RemoteCallbackList
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onCallbackDied(IMultiInstanceInvalidationCallback callback, Object cookie) {
            kotlin.jvm.internal.p.i(callback, "callback");
            kotlin.jvm.internal.p.i(cookie, "cookie");
            MultiInstanceInvalidationService.this.b().remove((Integer) cookie);
        }
    }

    public final RemoteCallbackList<IMultiInstanceInvalidationCallback> a() {
        return this.callbackList;
    }

    public final Map<Integer, String> b() {
        return this.clientNames;
    }

    /* renamed from: c, reason: from getter */
    public final int getMaxClientId() {
        return this.maxClientId;
    }

    public final void d(int i10) {
        this.maxClientId = i10;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        kotlin.jvm.internal.p.i(intent, "intent");
        return this.binder;
    }
}
