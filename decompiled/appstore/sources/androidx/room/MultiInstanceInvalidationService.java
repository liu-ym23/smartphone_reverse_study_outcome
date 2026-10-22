package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalRoomApi
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\t8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR&\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00120\u00118\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\n\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u001d¨\u0006\u001f"}, d2 = {"Landroidx/room/MultiInstanceInvalidationService;", "Landroid/app/Service;", "<init>", "()V", "Landroid/content/Intent;", MemorySourceLinkType.INTENT, "Landroid/os/IBinder;", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "", "a", "I", "c", "()I", "d", "(I)V", "maxClientId", "", "", "b", "Ljava/util/Map;", "()Ljava/util/Map;", "clientNames", "Landroid/os/RemoteCallbackList;", "Landroidx/room/IMultiInstanceInvalidationCallback;", "Landroid/os/RemoteCallbackList;", "()Landroid/os/RemoteCallbackList;", "callbackList", "Landroidx/room/IMultiInstanceInvalidationService$a;", "Landroidx/room/IMultiInstanceInvalidationService$a;", "binder", "room-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MultiInstanceInvalidationService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f4452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RemoteCallbackList f4453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IMultiInstanceInvalidationService.a f4454d;

    public static final class a extends IMultiInstanceInvalidationService.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MultiInstanceInvalidationService f4455a;

        public a(MultiInstanceInvalidationService r10) {
            this.f4455a = r10;
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public void broadcastInvalidation(int r10, String[] r11) {
            kotlin.jvm.internal.q.g(r11, "tables");
            RemoteCallbackList r12 = this.f4455a.a();
            MultiInstanceInvalidationService r13 = this.f4455a;
            monitor-enter(r12);
            String r14 = (String) r13.b().get(Integer.valueOf(r10));     // Catch: Throwable -> L9
            if (r14 != null) goto L11;
            Log.w("ROOM", "Remote invalidation client ID not registered");     // Catch: Throwable -> L9
            monitor-exit(r12);
            return;
        L11:
            int r15 = r13.a().beginBroadcast();     // Catch: Throwable -> L9
            int r16 = 0;
        L13:
            if (r16 >= r15) goto L28;
            Object r17 = r13.a().getBroadcastCookie(r16);     // Catch: Throwable -> L21
            kotlin.jvm.internal.q.e(r17, "null cannot be cast to non-null type kotlin.Int");     // Catch: Throwable -> L21
            Integer r18 = (Integer) r17;     // Catch: Throwable -> L21
            int r19 = r18.intValue();     // Catch: Throwable -> L21
            String r20 = (String) r13.b().get(r18);     // Catch: Throwable -> L21
            if (r10 == r19) goto L25;
            if (kotlin.jvm.internal.q.b(r14, r20) == false) goto L25;
            ((IMultiInstanceInvalidationCallback) r13.a().getBroadcastItem(r16)).onInvalidation(r11);     // Catch: Throwable -> L21 RemoteException -> L23
        L23:
            e = move-exception;
            Log.w("ROOM", "Error invoking a remote callback", e);     // Catch: Throwable -> L21
        L25:
            r16 = r16 + 1;
            goto L13
        L21:
            th = move-exception;
            r13.a().finishBroadcast();     // Catch: Throwable -> L9
            throw th;     // Catch: Throwable -> L9
        L28:
            r13.a().finishBroadcast();     // Catch: Throwable -> L9
            Unit r21 = Unit.f21064a;     // Catch: Throwable -> L9
            monitor-exit(r12);
            return;
        L9:
            th = move-exception;
            throw th;
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public int registerCallback(IMultiInstanceInvalidationCallback r10, String r11) {
            kotlin.jvm.internal.q.g(r10, "callback");
            int r12 = 0;
            if (r11 != null) goto L5;
            return 0;
        L5:
            RemoteCallbackList r13 = this.f4455a.a();
            MultiInstanceInvalidationService r14 = this.f4455a;
            monitor-enter(r13);
            r14.d(r14.c() + 1);     // Catch: Throwable -> L10
            int r15 = r14.c();     // Catch: Throwable -> L10
            if (r14.a().register(r10, Integer.valueOf(r15)) == false) goto L12;
            r14.b().put(Integer.valueOf(r15), r11);     // Catch: Throwable -> L10
            r12 = r15;
        L13:
            monitor-exit(r13);
            return r12;
        L12:
            r14.d(r14.c() - 1);     // Catch: Throwable -> L10
            r14.c();     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public void unregisterCallback(IMultiInstanceInvalidationCallback r10, int r11) {
            kotlin.jvm.internal.q.g(r10, "callback");
            RemoteCallbackList r12 = this.f4455a.a();
            MultiInstanceInvalidationService r13 = this.f4455a;
            monitor-enter(r12);
            r13.a().unregister(r10);     // Catch: Throwable -> L7
            String r14 = (String) r13.b().remove(Integer.valueOf(r11));     // Catch: Throwable -> L7
            monitor-exit(r12);
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public static final class b extends RemoteCallbackList {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MultiInstanceInvalidationService f4456a;

        public b(MultiInstanceInvalidationService r10) {
            this.f4456a = r10;
        }

        public void a(IMultiInstanceInvalidationCallback r10, Object r11) {
            kotlin.jvm.internal.q.g(r10, "callback");
            kotlin.jvm.internal.q.g(r11, "cookie");
            this.f4456a.b().remove((Integer) r11);
        }

        @Override // android.os.RemoteCallbackList
        public /* bridge */ /* synthetic */ void onCallbackDied(IInterface r10, Object r11) {
            a((IMultiInstanceInvalidationCallback) r10, r11);
        }
    }

    public MultiInstanceInvalidationService() {
        this.f4452b = new LinkedHashMap();
        this.f4453c = new b(this);
        this.f4454d = new a(this);
    }

    public final RemoteCallbackList a() {
        return this.f4453c;
    }

    public final Map b() {
        return this.f4452b;
    }

    public final int c() {
        return this.f4451a;
    }

    public final void d(int r10) {
        this.f4451a = r10;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r10) {
        kotlin.jvm.internal.q.g(r10, MemorySourceLinkType.INTENT);
        return this.f4454d;
    }
}
