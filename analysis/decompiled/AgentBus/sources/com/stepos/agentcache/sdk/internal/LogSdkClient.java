package com.stepos.agentcache.sdk.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import c7.m;
import c7.r;
import com.stepos.agentcache.core.ServiceContract;
import com.stepos.agentcache.ipc.ILogIngestService;
import com.stepos.agentcache.ipc.LogEventParcel;
import com.stepos.agentcache.ipc.LogRecordParcel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import m.x;
import p7.a;
import q7.f;
import q7.k;
import w7.e0;

@Metadata(d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005*\u0001(\b\u0000\u0018\u0000 +2\u00020\u0001:\u0001+B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0016\u001a\u00020\u000b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u001d\u001a\u00020\u000b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00180\u0014¢\u0006\u0004\b\u001d\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001eR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001fR\u001c\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010 R\u001c\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lcom/stepos/agentcache/sdk/internal/LogSdkClient;", "", "Landroid/content/Context;", "context", "", "servicePackageName", "Lkotlin/Function0;", "Lc7/r;", "onConnected", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lp7/a;)V", "", "bind", "()Z", "unbind", "()V", "Lcom/stepos/agentcache/ipc/LogEventParcel;", "event", "cacheEvent", "(Lcom/stepos/agentcache/ipc/LogEventParcel;)Z", "", "events", "cacheEvents", "(Ljava/util/List;)Z", "Lcom/stepos/agentcache/ipc/LogRecordParcel;", "log", "cacheLog", "(Lcom/stepos/agentcache/ipc/LogRecordParcel;)Z", "logs", "cacheLogs", "Landroid/content/Context;", "Ljava/lang/String;", "Lp7/a;", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/stepos/agentcache/ipc/ILogIngestService;", "serviceRef", "Ljava/util/concurrent/atomic/AtomicReference;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "bindRequested", "Ljava/util/concurrent/atomic/AtomicBoolean;", "com/stepos/agentcache/sdk/internal/LogSdkClient$serviceConnection$1", "serviceConnection", "Lcom/stepos/agentcache/sdk/internal/LogSdkClient$serviceConnection$1;", "Companion", "sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LogSdkClient {
    private static final String TAG = "LogSdkClient";
    private final AtomicBoolean bindRequested;
    private final Context context;
    private final a onConnected;
    private final LogSdkClient$serviceConnection$1 serviceConnection;
    private final String servicePackageName;
    private final AtomicReference<ILogIngestService> serviceRef;

    /* JADX WARN: Type inference failed for: r2v3, types: [com.stepos.agentcache.sdk.internal.LogSdkClient$serviceConnection$1] */
    public LogSdkClient(Context context, String str, a aVar) {
        k.e(context, "context");
        k.e(str, "servicePackageName");
        this.context = context;
        this.servicePackageName = str;
        this.onConnected = aVar;
        this.serviceRef = new AtomicReference<>();
        this.bindRequested = new AtomicBoolean(false);
        this.serviceConnection = new ServiceConnection() { // from class: com.stepos.agentcache.sdk.internal.LogSdkClient$serviceConnection$1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName name, IBinder service) {
                this.this$0.serviceRef.set(ILogIngestService.Stub.asInterface(service));
                Log.d("LogSdkClient", "service connected: " + name);
                a aVar2 = this.this$0.onConnected;
                if (aVar2 != null) {
                    aVar2.c();
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName name) {
                this.this$0.serviceRef.set(null);
                this.this$0.bindRequested.set(false);
                Log.w("LogSdkClient", "service disconnected: " + name);
            }
        };
    }

    public final boolean bind() {
        Object objN;
        if (this.serviceRef.get() != null || !this.bindRequested.compareAndSet(false, true)) {
            return true;
        }
        Intent intent = new Intent(ServiceContract.SERVICE_ACTION);
        intent.setPackage(this.servicePackageName);
        try {
            boolean zBindService = this.context.bindService(intent, this.serviceConnection, 1);
            if (zBindService) {
                Log.d(TAG, "bind requested, package=" + this.servicePackageName);
            } else {
                this.bindRequested.set(false);
                Log.w(TAG, "bind failed, package=" + this.servicePackageName);
            }
            objN = Boolean.valueOf(zBindService);
        } catch (Throwable th) {
            objN = e0.n(th);
        }
        Throwable thA = m.a(objN);
        if (thA != null) {
            this.bindRequested.set(false);
            x.v("bind exception: ", thA.getMessage(), TAG);
            objN = Boolean.FALSE;
        }
        return ((Boolean) objN).booleanValue();
    }

    public final boolean cacheEvent(LogEventParcel event) {
        Object objN;
        k.e(event, "event");
        try {
            ILogIngestService iLogIngestService = this.serviceRef.get();
            if (iLogIngestService != null) {
                iLogIngestService.cacheEvent(event);
            }
            boolean z4 = this.serviceRef.get() != null;
            Log.d(TAG, "cacheEvent traceId=" + event.getTraceId() + ", success=" + z4);
            objN = Boolean.valueOf(z4);
        } catch (Throwable th) {
            objN = e0.n(th);
        }
        Throwable thA = m.a(objN);
        if (thA != null) {
            x.v("cacheEvent failed: ", thA.getMessage(), TAG);
            objN = Boolean.FALSE;
        }
        return ((Boolean) objN).booleanValue();
    }

    public final boolean cacheEvents(List<LogEventParcel> events) {
        Object objN;
        k.e(events, "events");
        try {
            ILogIngestService iLogIngestService = this.serviceRef.get();
            if (iLogIngestService != null) {
                iLogIngestService.cacheEvents(new ArrayList(events));
            }
            boolean z4 = this.serviceRef.get() != null;
            Log.d(TAG, "cacheEvents count=" + events.size() + ", success=" + z4);
            objN = Boolean.valueOf(z4);
        } catch (Throwable th) {
            objN = e0.n(th);
        }
        Throwable thA = m.a(objN);
        if (thA != null) {
            x.v("cacheEvents failed: ", thA.getMessage(), TAG);
            objN = Boolean.FALSE;
        }
        return ((Boolean) objN).booleanValue();
    }

    public final boolean cacheLog(LogRecordParcel log) {
        Object objN;
        k.e(log, "log");
        try {
            ILogIngestService iLogIngestService = this.serviceRef.get();
            if (iLogIngestService != null) {
                iLogIngestService.cacheLog(log);
            }
            boolean z4 = this.serviceRef.get() != null;
            Log.d(TAG, "cacheLog traceId=" + log.getTraceId() + ", success=" + z4);
            objN = Boolean.valueOf(z4);
        } catch (Throwable th) {
            objN = e0.n(th);
        }
        Throwable thA = m.a(objN);
        if (thA != null) {
            x.v("cacheLog failed: ", thA.getMessage(), TAG);
            objN = Boolean.FALSE;
        }
        return ((Boolean) objN).booleanValue();
    }

    public final boolean cacheLogs(List<LogRecordParcel> logs) {
        Object objN;
        k.e(logs, "logs");
        try {
            ILogIngestService iLogIngestService = this.serviceRef.get();
            if (iLogIngestService != null) {
                iLogIngestService.cacheLogs(new ArrayList(logs));
            }
            boolean z4 = this.serviceRef.get() != null;
            Log.d(TAG, "cacheLogs count=" + logs.size() + ", success=" + z4);
            objN = Boolean.valueOf(z4);
        } catch (Throwable th) {
            objN = e0.n(th);
        }
        Throwable thA = m.a(objN);
        if (thA != null) {
            x.v("cacheLogs failed: ", thA.getMessage(), TAG);
            objN = Boolean.FALSE;
        }
        return ((Boolean) objN).booleanValue();
    }

    public final void unbind() {
        Object objN;
        if (this.bindRequested.compareAndSet(true, false)) {
            try {
                this.context.unbindService(this.serviceConnection);
                objN = r.f1986a;
            } catch (Throwable th) {
                objN = e0.n(th);
            }
            Throwable thA = m.a(objN);
            if (thA != null) {
                x.v("unbind ignored: ", thA.getMessage(), TAG);
            }
            this.serviceRef.set(null);
            Log.d(TAG, "service unbound");
        }
    }

    public /* synthetic */ LogSdkClient(Context context, String str, a aVar, int i2, f fVar) {
        this(context, (i2 & 2) != 0 ? ServiceContract.SERVICE_PACKAGE : str, (i2 & 4) != 0 ? null : aVar);
    }
}
