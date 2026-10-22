package c4;

import Y8.t;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentcache.ipc.ILogIngestService;
import com.stepos.agentcache.ipc.LogEventParcel;
import com.stepos.agentcache.ipc.LogRecordParcel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004*\u0001)\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0001\u001cB+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0014\u001a\u00020\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u001b\u001a\u00020\u000b2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00160\u0012¢\u0006\u0004\b\u001b\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001c\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010$R\u0014\u0010(\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010'R\u0014\u0010+\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010*¨\u0006,"}, d2 = {"Lc4/a;", "", "Landroid/content/Context;", "context", "", "servicePackageName", "Lkotlin/Function0;", "LY8/t;", "onConnected", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lp9/a;)V", "", Const.INTENT_KEY_UMID, "()Z", "Lcom/stepos/agentcache/ipc/LogEventParcel;", "event", "e", "(Lcom/stepos/agentcache/ipc/LogEventParcel;)Z", "", "events", "f", "(Ljava/util/List;)Z", "Lcom/stepos/agentcache/ipc/LogRecordParcel;", com.stepos.statsapp.v3.lib.plugin.events.b.f30786f, Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcom/stepos/agentcache/ipc/LogRecordParcel;)Z", "logs", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_APIKEY, "Landroid/content/Context;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", "c", "Lp9/a;", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/stepos/agentcache/ipc/ILogIngestService;", "Ljava/util/concurrent/atomic/AtomicReference;", "serviceRef", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "bindRequested", "c4/a$b", "Lc4/a$b;", "serviceConnection", "sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: c4.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1495a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String servicePackageName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5063a<t> onConnected;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final AtomicReference<ILogIngestService> serviceRef;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final AtomicBoolean bindRequested;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final b serviceConnection;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"c4/a$b", "Landroid/content/ServiceConnection;", "Landroid/content/ComponentName;", "name", "Landroid/os/IBinder;", "service", "LY8/t;", "onServiceConnected", "(Landroid/content/ComponentName;Landroid/os/IBinder;)V", "onServiceDisconnected", "(Landroid/content/ComponentName;)V", "sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: c4.a$b */
    public static final class b implements ServiceConnection {
        public b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            C1495a.this.serviceRef.set(ILogIngestService.Stub.asInterface(service));
            Log.d("LogSdkClient", "service connected: " + name);
            InterfaceC5063a interfaceC5063a = C1495a.this.onConnected;
            if (interfaceC5063a != null) {
                interfaceC5063a.invoke();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            C1495a.this.serviceRef.set(null);
            C1495a.this.bindRequested.set(false);
            Log.w("LogSdkClient", "service disconnected: " + name);
        }
    }

    public C1495a(Context context, String servicePackageName, InterfaceC5063a<t> interfaceC5063a) {
        p.i(context, "context");
        p.i(servicePackageName, "servicePackageName");
        this.context = context;
        this.servicePackageName = servicePackageName;
        this.onConnected = interfaceC5063a;
        this.serviceRef = new AtomicReference<>();
        this.bindRequested = new AtomicBoolean(false);
        this.serviceConnection = new b();
    }

    public final boolean d() {
        Object objB;
        if (this.serviceRef.get() != null || !this.bindRequested.compareAndSet(false, true)) {
            return true;
        }
        Intent intent = new Intent("com.stepos.agentcache.action.BIND_AGENT_CACHE_SERVICE");
        intent.setPackage(this.servicePackageName);
        try {
            Result.Companion companion = Result.INSTANCE;
            boolean zBindService = this.context.bindService(intent, this.serviceConnection, 1);
            if (zBindService) {
                Log.d("LogSdkClient", "bind requested, package=" + this.servicePackageName);
            } else {
                this.bindRequested.set(false);
                Log.w("LogSdkClient", "bind failed, package=" + this.servicePackageName);
            }
            objB = Result.b(Boolean.valueOf(zBindService));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            this.bindRequested.set(false);
            Log.w("LogSdkClient", "bind exception: " + thE.getMessage());
            objB = Boolean.FALSE;
        }
        return ((Boolean) objB).booleanValue();
    }

    public final boolean e(LogEventParcel event) {
        Object objB;
        p.i(event, "event");
        try {
            Result.Companion companion = Result.INSTANCE;
            ILogIngestService iLogIngestService = this.serviceRef.get();
            if (iLogIngestService != null) {
                iLogIngestService.cacheEvent(event);
            }
            boolean z10 = this.serviceRef.get() != null;
            Log.d("LogSdkClient", "cacheEvent traceId=" + event.getTraceId() + ", success=" + z10);
            objB = Result.b(Boolean.valueOf(z10));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w("LogSdkClient", "cacheEvent failed: " + thE.getMessage());
            objB = Boolean.FALSE;
        }
        return ((Boolean) objB).booleanValue();
    }

    public final boolean f(List<LogEventParcel> events) {
        Object objB;
        p.i(events, "events");
        try {
            Result.Companion companion = Result.INSTANCE;
            ILogIngestService iLogIngestService = this.serviceRef.get();
            if (iLogIngestService != null) {
                iLogIngestService.cacheEvents(new ArrayList(events));
            }
            boolean z10 = this.serviceRef.get() != null;
            Log.d("LogSdkClient", "cacheEvents count=" + events.size() + ", success=" + z10);
            objB = Result.b(Boolean.valueOf(z10));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w("LogSdkClient", "cacheEvents failed: " + thE.getMessage());
            objB = Boolean.FALSE;
        }
        return ((Boolean) objB).booleanValue();
    }

    public final boolean g(LogRecordParcel log) {
        Object objB;
        p.i(log, "log");
        try {
            Result.Companion companion = Result.INSTANCE;
            ILogIngestService iLogIngestService = this.serviceRef.get();
            if (iLogIngestService != null) {
                iLogIngestService.cacheLog(log);
            }
            boolean z10 = this.serviceRef.get() != null;
            Log.d("LogSdkClient", "cacheLog traceId=" + log.getTraceId() + ", success=" + z10);
            objB = Result.b(Boolean.valueOf(z10));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w("LogSdkClient", "cacheLog failed: " + thE.getMessage());
            objB = Boolean.FALSE;
        }
        return ((Boolean) objB).booleanValue();
    }

    public final boolean h(List<LogRecordParcel> logs) {
        Object objB;
        p.i(logs, "logs");
        try {
            Result.Companion companion = Result.INSTANCE;
            ILogIngestService iLogIngestService = this.serviceRef.get();
            if (iLogIngestService != null) {
                iLogIngestService.cacheLogs(new ArrayList(logs));
            }
            boolean z10 = this.serviceRef.get() != null;
            Log.d("LogSdkClient", "cacheLogs count=" + logs.size() + ", success=" + z10);
            objB = Result.b(Boolean.valueOf(z10));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w("LogSdkClient", "cacheLogs failed: " + thE.getMessage());
            objB = Boolean.FALSE;
        }
        return ((Boolean) objB).booleanValue();
    }
}
