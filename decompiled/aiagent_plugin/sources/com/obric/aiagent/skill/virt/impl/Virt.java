package com.obric.aiagent.skill.virt.impl;

import android.app.Application;
import android.content.Context;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.skill.virt.api.IVirtService;
import com.obric.aiagent.skill.virt.api.y;
import com.obric.aiagent.skill.virt.impl.a.k;
import com.obric.aiagent.skill.virt.impl.a.l;
import com.obric.aiagent.skill.virt.impl.a.m;
import com.obric.aiagent.skill.virt.impl.a.n;
import com.obric.aiagent.skill.virt.impl.c.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.d;
import d.f;
import d.g;
import d.h.b.h;
import d.h.b.o;
import d.j;
import d.x;
import java.io.File;

/* JADX INFO: compiled from: Virt.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Virt implements IVirtService, IVirtService.c {
    private static final a Companion = null;

    @Deprecated
    public static final String LEGACY_EXECUTION_STATE_DIR = "shell-executions";

    @Deprecated
    public static final String TAG = "Virt/Service";

    @Deprecated
    public static final String TRIGGER_MANUAL = "manual";

    @Deprecated
    public static final String TRIGGER_STARTUP = "startup";
    private final Context appContext;
    private final n backendSelection;
    private final f files$delegate;
    private final f shell$delegate;
    private final f shellManager$delegate;
    private final com.obric.aiagent.skill.virt.impl.c.b shellMonitor;

    /* JADX INFO: compiled from: Virt.kt */
    private static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: Virt.kt */
    @d.c.b.a.f(b = "Virt.kt", c = {66}, d = "drainDiagnostics", e = "com.obric.aiagent.skill.virt.impl.Virt")
    static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21632a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f21633b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Virt f21634c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f21635d;

        b(Virt r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21634c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f21633b = r3;
            this.f21635d |= Integer.MIN_VALUE;
            return this.f21634c.drainDiagnostics((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        Companion = new a(null);
    }

    /* JADX INFO: renamed from: lambda$3ZdC9OylLiz8rBu-2-xIL0DXeFY, reason: not valid java name */
    public static /* synthetic */ com.obric.aiagent.skill.virt.impl.b.a m371lambda$3ZdC9OylLiz8rBu2xIL0DXeFY(Virt r0) {
        return files_delegate$lambda$2(r0);
    }

    /* JADX INFO: renamed from: lambda$A4Mhh91vwJ07QEWTx-K7T8JkyBM, reason: not valid java name */
    public static /* synthetic */ com.obric.aiagent.skill.virt.impl.c.a m372lambda$A4Mhh91vwJ07QEWTxK7T8JkyBM(Virt r0) {
        return shellManager_delegate$lambda$0(r0);
    }

    public static /* synthetic */ e lambda$WhhvFXrH4E54RWrfAQjgvwelSQ0(Virt r0) {
        return shell_delegate$lambda$1(r0);
    }

    public Virt() {
        Context r0 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.appContext = r0;
        com.obric.aiagent.skill.virt.impl.c.b r1 = new com.obric.aiagent.skill.virt.impl.c.b(null, 1, null);
        this.shellMonitor = r1;
        m r2 = m.f22061a;
        o.c(r0, "appContext");
        this.backendSelection = r2.a(r0, r1);
        this.shellManager$delegate = g.a(j.f38505a, new $$Lambda$Virt$A4Mhh91vwJ07QEWTxK7T8JkyBM(this));
        clearLegacyExecutionState();
        l r3 = selectedDiagnostics();
        if (r3 == null) goto L5;
        r3.b(TRIGGER_STARTUP);
    L5:
        this.shell$delegate = g.a(j.f38505a, new $$Lambda$Virt$WhhvFXrH4E54RWrfAQjgvwelSQ0(this));
        this.files$delegate = g.a(j.f38505a, new $$Lambda$Virt$3ZdC9OylLiz8rBu2xIL0DXeFY(this));
    }

    private final k getBackend() {
        n r4 = this.backendSelection;
        if (ZeusTransformUtils.instanceOf(r4, n.a.class) == false) goto L7;
        return ((n.a) ZeusTransformUtils.preCheckCast(r4, n.a.class, "com.obric.aiagent.plugin")).b();
    L7:
        if (ZeusTransformUtils.instanceOf(r4, n.b.class) == false) goto L11;
        throw new IllegalStateException(("Virt Backend is unavailable: " + ((n.b) ZeusTransformUtils.preCheckCast(r4, n.b.class, "com.obric.aiagent.plugin")).b()).toString());
    L11:
        throw new d.k();
    }

    private final com.obric.aiagent.skill.virt.impl.c.a getShellManager() {
        return (com.obric.aiagent.skill.virt.impl.c.a) ZeusTransformUtils.preCheckCast(this.shellManager$delegate.b(), com.obric.aiagent.skill.virt.impl.c.a.class, "com.obric.aiagent.plugin");
    }

    private static final com.obric.aiagent.skill.virt.impl.c.a shellManager_delegate$lambda$0(Virt r2) {
        return new com.obric.aiagent.skill.virt.impl.c.a(r2.getBackend(), r2.shellMonitor);
    }

    @Override // com.obric.aiagent.skill.virt.api.IVirtService
    public IVirtService.c getLifecycle() {
        return (IVirtService.c) ZeusTransformUtils.preCheckCast(this, IVirtService.c.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.skill.virt.api.IVirtService
    public IVirtService.d getShell() {
        return (IVirtService.d) ZeusTransformUtils.preCheckCast(this.shell$delegate.b(), IVirtService.d.class, "com.obric.aiagent.plugin");
    }

    private static final e shell_delegate$lambda$1(Virt r3) {
        return new e(r3.getBackend(), r3.getShellManager(), r3.shellMonitor);
    }

    @Override // com.obric.aiagent.skill.virt.api.IVirtService
    public IVirtService.b getFiles() {
        return (IVirtService.b) ZeusTransformUtils.preCheckCast(this.files$delegate.b(), IVirtService.b.class, "com.obric.aiagent.plugin");
    }

    private static final com.obric.aiagent.skill.virt.impl.b.a files_delegate$lambda$2(Virt r2) {
        return new com.obric.aiagent.skill.virt.impl.b.a(r2.getBackend(), r2.getShellManager());
    }

    @Override // com.obric.aiagent.skill.virt.api.IVirtService.c
    public Object open(d.c.d<? super x> r3) {
        d.c.d<? super x> r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        Object r2 = getBackend().a(r4);
        if (r2 != d.c.a.b.a()) goto L6;
        return r2;
    L6:
        return x.f38692a;
    }

    @Override // com.obric.aiagent.skill.virt.api.IVirtService.c
    public Object close(d.c.d<? super x> r3) {
        d.c.d<? super x> r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        Object r2 = getBackend().b(r4);
        if (r2 != d.c.a.b.a()) goto L6;
        return r2;
    L6:
        return x.f38692a;
    }

    @Override // com.obric.aiagent.skill.virt.api.IVirtService.c
    public y getPaths() {
        com.obric.aiagent.skill.virt.impl.a.a r2 = getBackend().b();
        return y.f21622a.a(r2.a(), r2.b());
    }

    @Override // com.obric.aiagent.skill.virt.api.IVirtService.c
    public boolean isBackendSupported() {
        return ZeusTransformUtils.instanceOf(this.backendSelection, n.a.class);
    }

    public String getSelectedBackendType() {
        return this.backendSelection.a();
    }

    public Object drainDiagnostics(d.c.d<? super String> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.aiagent.plugin");
        if ((r0.f21635d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f21635d -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.f21633b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f21635d;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Virt this = (Virt) ZeusTransformUtils.preCheckCast(r0.f21632a, Virt.class, "com.obric.aiagent.plugin");
        d.o.a(r8);
    L19:
        String r9 = (String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L26;
    L21:
        StringBuilder r10 = new StringBuilder().append("supported=false\nbackendType=");
        String r5 = this.getSelectedBackendType();
        if (r5 != null) goto L25;
        r5 = "";
    L25:
        return r10.append(r5).toString();
    L26:
        return r9;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r8);
        l r11 = selectedDiagnostics();
        if (r11 == null) goto L21;
        r0.f21632a = this;
        r0.f21635d = 1;
        r8 = r11.a(TRIGGER_MANUAL, r0);
        if (r8 != r2) goto L19;
        return r2;
    L7:
        r0 = new b(this, r7);
        goto L8
    }

    public String diagnosticsStatus() {
        l r0 = selectedDiagnostics();
        if (r0 == null) goto L6;
        String r1 = r0.d();
        if (r1 == null) goto L6;
        return r1;
    L6:
        StringBuilder r2 = new StringBuilder().append("supported=false\nbackendType=");
        String r3 = getSelectedBackendType();
        if (r3 != null) goto L10;
        r3 = "";
    L10:
        return r2.append(r3).toString();
    }

    private final l selectedDiagnostics() {
        n r3 = this.backendSelection;
        if (ZeusTransformUtils.instanceOf(r3, n.a.class) == false) goto L5;
        n.a r4 = (n.a) ZeusTransformUtils.preCheckCast(r3, n.a.class, "com.obric.aiagent.plugin");
    L6:
        if (r4 == null) goto L8;
        k r5 = r4.b();
    L10:
        if (ZeusTransformUtils.instanceOf(r5, l.class) == true) goto L12;
        return null;
    L12:
        return (l) ZeusTransformUtils.preCheckCast(r5, l.class, "com.obric.aiagent.plugin");
    L8:
        r5 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    private final void clearLegacyExecutionState() {
        File r0 = new File(this.appContext.getFilesDir(), LEGACY_EXECUTION_STATE_DIR);
        if (r0.exists() == true) goto L6;
        return;
    L6:
        if (d.f.k.h(r0) == true) goto L9;
        ILogDepend.Companion.w(TAG, "Failed to clear legacy shell execution state");
        return;
    }
}
