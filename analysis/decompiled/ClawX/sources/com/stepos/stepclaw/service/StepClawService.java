package com.stepos.stepclaw.service;

import a6.i0;
import a6.p1;
import a6.t;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.base.framework.ServiceLocator;
import com.stepos.stepclaw.bridge.memory.MemoryBridge;
import com.stepos.stepclaw.service.command.CommandRegistry;
import com.stepos.stepclaw.service.command.DumpCommandHandler;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0003J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ7\u0010\u0014\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0012\u0010\u0013\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0011H\u0014¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/stepos/stepclaw/service/StepClawService;", "Landroid/app/Service;", "<init>", "()V", "Lb5/a0;", "initCommandRegistry", "onCreate", "onDestroy", "Landroid/content/Intent;", "intent", "Landroid/os/IBinder;", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "Ljava/io/FileDescriptor;", "fd", "Ljava/io/PrintWriter;", "writer", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "args", "dump", "(Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V", "Landroid/os/Binder;", "binder", "Landroid/os/Binder;", "La6/t;", "serviceJob", "La6/t;", "Lcom/stepos/stepclaw/service/command/CommandRegistry;", "commandRegistry", "Lcom/stepos/stepclaw/service/command/CommandRegistry;", "Companion", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class StepClawService extends Service {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Binder binder = new Binder();
    private final t serviceJob = i0.c();
    private final CommandRegistry commandRegistry = new CommandRegistry();

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/stepclaw/service/StepClawService$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "Landroid/content/Context;", "context", "Lb5/a0;", "startService", "(Landroid/content/Context;)V", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final void startService(Context context) {
            p.e(context, "context");
            context.startService(new Intent(context, (Class<?>) StepClawService.class));
        }

        private Companion() {
        }
    }

    private final void initCommandRegistry() {
        this.commandRegistry.registerAll(new DumpCommandHandler(), ((MemoryBridge) ServiceLocator.INSTANCE.get(MemoryBridge.class)).getMemoryDumpCommandHandler());
    }

    @Override // android.app.Service
    public void dump(FileDescriptor fd, PrintWriter writer, String[] args) {
        if (writer == null) {
            return;
        }
        this.commandRegistry.execute(this, writer, args);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        p.e(intent, "intent");
        return this.binder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        initCommandRegistry();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ((p1) this.serviceJob).e(null);
    }
}
