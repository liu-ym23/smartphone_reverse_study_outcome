package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.IMultiInstanceInvalidationService;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ExperimentalRoomApi
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/room/MultiInstanceInvalidationService;", "Landroid/app/Service;", "<init>", "()V", "room-runtime_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class MultiInstanceInvalidationService extends Service {

    /* renamed from: a, reason: collision with root package name */
    public int f4194a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f4195b = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name */
    public final t f4196c = new t(this);

    /* renamed from: d, reason: collision with root package name */
    public final MultiInstanceInvalidationService$binder$1 f4197d = new IMultiInstanceInvalidationService.Stub() { // from class: androidx.room.MultiInstanceInvalidationService$binder$1
        @Override // androidx.room.IMultiInstanceInvalidationService
        public void broadcastInvalidation(int clientId, @NotNull String[] tables) {
            Intrinsics.checkNotNullParameter(tables, "tables");
            MultiInstanceInvalidationService multiInstanceInvalidationService = this.this$0;
            synchronized (multiInstanceInvalidationService.f4196c) {
                String str = (String) multiInstanceInvalidationService.f4195b.get(Integer.valueOf(clientId));
                if (str == null) {
                    Log.w("ROOM", "Remote invalidation client ID not registered");
                    return;
                }
                int iBeginBroadcast = multiInstanceInvalidationService.f4196c.beginBroadcast();
                for (int i4 = 0; i4 < iBeginBroadcast; i4++) {
                    try {
                        Object broadcastCookie = multiInstanceInvalidationService.f4196c.getBroadcastCookie(i4);
                        Intrinsics.checkNotNull(broadcastCookie, "null cannot be cast to non-null type kotlin.Int");
                        Integer num = (Integer) broadcastCookie;
                        int iIntValue = num.intValue();
                        String str2 = (String) multiInstanceInvalidationService.f4195b.get(num);
                        if (clientId != iIntValue && Intrinsics.areEqual(str, str2)) {
                            try {
                                ((IMultiInstanceInvalidationCallback) multiInstanceInvalidationService.f4196c.getBroadcastItem(i4)).onInvalidation(tables);
                            } catch (RemoteException e4) {
                                Log.w("ROOM", "Error invoking a remote callback", e4);
                            }
                        }
                    } catch (Throwable th) {
                        multiInstanceInvalidationService.f4196c.finishBroadcast();
                        throw th;
                    }
                }
                multiInstanceInvalidationService.f4196c.finishBroadcast();
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public int registerCallback(@NotNull IMultiInstanceInvalidationCallback callback, @Nullable String name) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            int i4 = 0;
            if (name == null) {
                return 0;
            }
            MultiInstanceInvalidationService multiInstanceInvalidationService = this.this$0;
            synchronized (multiInstanceInvalidationService.f4196c) {
                try {
                    int i5 = multiInstanceInvalidationService.f4194a + 1;
                    multiInstanceInvalidationService.f4194a = i5;
                    if (multiInstanceInvalidationService.f4196c.register(callback, Integer.valueOf(i5))) {
                        multiInstanceInvalidationService.f4195b.put(Integer.valueOf(i5), name);
                        i4 = i5;
                    } else {
                        multiInstanceInvalidationService.f4194a--;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return i4;
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public void unregisterCallback(@NotNull IMultiInstanceInvalidationCallback callback, int clientId) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            MultiInstanceInvalidationService multiInstanceInvalidationService = this.this$0;
            synchronized (multiInstanceInvalidationService.f4196c) {
                multiInstanceInvalidationService.f4196c.unregister(callback);
            }
        }
    };

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return this.f4197d;
    }
}
