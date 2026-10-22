package com.stepos.stepclaw.runtime;

import a.a;
import a8.b;
import android.util.Log;
import b5.a0;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.gateway.d;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.p;
import m0.f;
import p5.l;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 02\u00020\u0001:\u00010BA\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u001a\b\u0002\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0004¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000f\u001a\u00020\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u0006¢\u0006\u0004\b\u001f\u0010\u0019J\r\u0010 \u001a\u00020\u0007¢\u0006\u0004\b \u0010\u001eJ\r\u0010!\u001a\u00020\u0007¢\u0006\u0004\b!\u0010\u001eJ\u0013\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\"\u0010#J\r\u0010%\u001a\u00020$¢\u0006\u0004\b%\u0010&J\r\u0010'\u001a\u00020\u0007¢\u0006\u0004\b'\u0010\u001eJ\u0017\u0010)\u001a\u00020(2\b\b\u0002\u0010\u0014\u001a\u00020\t¢\u0006\u0004\b)\u0010*J\r\u0010+\u001a\u00020\n¢\u0006\u0004\b+\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010,R&\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010-R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010-R\u0014\u0010.\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00061"}, d2 = {"Lcom/stepos/stepclaw/runtime/SystemChrootRuntimeController;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/runtime/OpenClawRuntimeConfig;", "runtimeConfig", "Lkotlin/Function1;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/runtime/ShellCommandResult;", "commandRunner", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lb5/a0;", "sleep", "<init>", "(Lcom/stepos/stepclaw/runtime/OpenClawRuntimeConfig;Lp5/l;Lp5/l;)V", "command", "runCommand", "(Ljava/util/List;)Lcom/stepos/stepclaw/runtime/ShellCommandResult;", "waitForServiceToLeaveStoppedState", "()V", "expectedState", "timeoutSeconds", "action", "waitForServiceState", "(Ljava/lang/String;JLjava/lang/String;)V", "readServiceState", "()Ljava/lang/String;", "result", "buildStartFailureMessage", "(Lcom/stepos/stepclaw/runtime/ShellCommandResult;)Ljava/lang/String;", "stopRuntime", "()Lcom/stepos/stepclaw/runtime/ShellCommandResult;", "getRuntimeServiceState", "startOpenClawEnv", "startRuntime", "restartRuntime", "()Ljava/util/List;", "Ljava/lang/Process;", "openLogcatProcess", "()Ljava/lang/Process;", "requestRestore", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "waitForRestoreDone", "(J)Z", "clearRestoreProps", "Lcom/stepos/stepclaw/runtime/OpenClawRuntimeConfig;", "Lp5/l;", "runtimeServiceStateProperty", "Ljava/lang/String;", "Companion", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SystemChrootRuntimeController {
    private static final String GETPROP_BIN = "/system/bin/getprop";
    private static final String LOGCAT_BIN = "/system/bin/logcat";
    public static final String RESTORE_DONE_PROP = "sys.openclaw.rootfs.restore.done";
    private static final long RESTORE_POLL_MS = 1000;
    public static final String RESTORE_REQUEST_PROP = "sys.openclaw.rootfs.restore.request";
    private static final long SERVICE_START_LEAVE_STOPPED_TIMEOUT_SECONDS = 90;
    private static final long SERVICE_STATE_POLL_MS = 200;
    private static final String SETPROP_BIN = "/system/bin/setprop";
    private static final String STOP_BIN = "/system/bin/stop";
    private static final long STOP_TIMEOUT_SECONDS = 10;
    private static final String TAG = "SystemChrootRuntimeController";
    private final l commandRunner;
    private final OpenClawRuntimeConfig runtimeConfig;
    private final String runtimeServiceStateProperty;
    private final l sleep;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.runtime.SystemChrootRuntimeController$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends n implements l {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1, Thread.class, "sleep", "sleep(J)V", 0);
        }

        @Override // p5.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) throws InterruptedException {
            invoke(((Number) obj).longValue());
            return a0.f883a;
        }

        public final void invoke(long j4) throws InterruptedException {
            Thread.sleep(j4);
        }
    }

    public SystemChrootRuntimeController(OpenClawRuntimeConfig runtimeConfig, l commandRunner, l sleep) {
        p.e(runtimeConfig, "runtimeConfig");
        p.e(commandRunner, "commandRunner");
        p.e(sleep, "sleep");
        this.runtimeConfig = runtimeConfig;
        this.commandRunner = commandRunner;
        this.sleep = sleep;
        this.runtimeServiceStateProperty = f.c("init.svc.", runtimeConfig.getRuntimeServiceName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ShellCommandResult _init_$lambda$0(List it) {
        p.e(it, "it");
        return RuntimeShellCommandRunner.INSTANCE.execute(it, 10L);
    }

    private final String buildStartFailureMessage(ShellCommandResult result) {
        StringBuilder sb = new StringBuilder();
        if (!x5.n.t1(result.getStderr())) {
            sb.append(result.getStderr());
        }
        if (!x5.n.t1(result.getStdout())) {
            if (sb.length() > 0) {
                sb.append(" | ");
            }
            sb.append(result.getStdout());
        }
        String string = sb.toString();
        if (x5.n.t1(string)) {
            string = b.j(result.getExitCode(), "exit=");
        }
        String runtimeStartProperty = this.runtimeConfig.getRuntimeStartProperty();
        String runtimeStartValue = this.runtimeConfig.getRuntimeStartValue();
        String runtimeStartPropertyType = this.runtimeConfig.getRuntimeStartPropertyType();
        String runtimeStartProperty2 = this.runtimeConfig.getRuntimeStartProperty();
        StringBuilder sbV = b.v("Failed to set ", runtimeStartProperty, "=", runtimeStartValue, ": ");
        b.A(sbV, string, ". Likely SELinux denial: allow system_app ", runtimeStartPropertyType, ":property_service set for ");
        return f.f(sbV, runtimeStartProperty2, ", or remap the property to a dedicated type in property_contexts and allow system_app to set that type.");
    }

    private final String readServiceState() {
        ShellCommandResult shellCommandResultRunCommand = runCommand(c5.n.k0(GETPROP_BIN, this.runtimeServiceStateProperty));
        shellCommandResultRunCommand.requireSuccess("read " + this.runtimeServiceStateProperty);
        return x5.n.T1(shellCommandResultRunCommand.getStdout()).toString();
    }

    private final ShellCommandResult runCommand(List<String> command) {
        return (ShellCommandResult) this.commandRunner.invoke(command);
    }

    public static /* synthetic */ boolean waitForRestoreDone$default(SystemChrootRuntimeController systemChrootRuntimeController, long j4, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            j4 = 300;
        }
        return systemChrootRuntimeController.waitForRestoreDone(j4);
    }

    private final void waitForServiceState(String expectedState, long timeoutSeconds, String action) {
        Locale US = Locale.US;
        p.d(US, "US");
        String lowerCase = expectedState.toLowerCase(US);
        p.d(lowerCase, "toLowerCase(...)");
        long nanos = TimeUnit.SECONDS.toNanos(timeoutSeconds) + System.nanoTime();
        while (System.nanoTime() < nanos) {
            String serviceState = readServiceState();
            Locale US2 = Locale.US;
            p.d(US2, "US");
            String lowerCase2 = serviceState.toLowerCase(US2);
            p.d(lowerCase2, "toLowerCase(...)");
            if (lowerCase2.equals(lowerCase)) {
                return;
            } else {
                this.sleep.invoke(Long.valueOf(SERVICE_STATE_POLL_MS));
            }
        }
        String str = this.runtimeServiceStateProperty;
        throw new IllegalStateException(f.f(b.v("Timed out waiting for ", action, "; ", str, "='"), readServiceState(), "'"));
    }

    private final void waitForServiceToLeaveStoppedState() {
        long nanos = TimeUnit.SECONDS.toNanos(SERVICE_START_LEAVE_STOPPED_TIMEOUT_SECONDS) + System.nanoTime();
        while (System.nanoTime() < nanos) {
            String serviceState = readServiceState();
            if (serviceState.length() > 0 && !p.a(serviceState, "stopped")) {
                return;
            } else {
                this.sleep.invoke(Long.valueOf(SERVICE_STATE_POLL_MS));
            }
        }
        String serviceState2 = readServiceState();
        Log.e(TAG, b.q("openclaw_env still stopped after 90s (", this.runtimeServiceStateProperty, "=", serviceState2, "). 常见原因：init 脚本启动失败（如缺少 /usr/local/bin/openclaw）、chroot 内 node 崩溃、或需查看 logcat/init 日志。"));
        String runtimeServiceName = this.runtimeConfig.getRuntimeServiceName();
        String str = this.runtimeServiceStateProperty;
        String runtimeStartProperty = this.runtimeConfig.getRuntimeStartProperty();
        String runtimeStartValue = this.runtimeConfig.getRuntimeStartValue();
        StringBuilder sbV = b.v("Timed out waiting for ", runtimeServiceName, " to start; ", str, " remained '");
        b.A(sbV, serviceState2, "' after setting ", runtimeStartProperty, "=");
        sbV.append(runtimeStartValue);
        throw new IllegalStateException(sbV.toString());
    }

    public final void clearRestoreProps() {
        runCommand(c5.n.k0(SETPROP_BIN, RESTORE_REQUEST_PROP, "0"));
        runCommand(c5.n.k0(SETPROP_BIN, RESTORE_DONE_PROP, "0"));
    }

    public final String getRuntimeServiceState() {
        return readServiceState();
    }

    public final Process openLogcatProcess() throws IOException {
        Process processStart = new ProcessBuilder(LOGCAT_BIN, "-T", "1", "-v", "brief").redirectErrorStream(true).start();
        p.d(processStart, "start(...)");
        return processStart;
    }

    public final ShellCommandResult requestRestore() {
        return runCommand(c5.n.k0(SETPROP_BIN, RESTORE_REQUEST_PROP, "1"));
    }

    public final List<ShellCommandResult> restartRuntime() {
        return a.S(startOpenClawEnv());
    }

    public final ShellCommandResult startOpenClawEnv() {
        runCommand(c5.n.k0(SETPROP_BIN, this.runtimeConfig.getRuntimeStartProperty(), "0"));
        ShellCommandResult shellCommandResultRunCommand = runCommand(c5.n.k0(SETPROP_BIN, this.runtimeConfig.getRuntimeStartProperty(), this.runtimeConfig.getRuntimeStartValue()));
        if (shellCommandResultRunCommand.getExitCode() != 0) {
            throw new IllegalStateException(buildStartFailureMessage(shellCommandResultRunCommand));
        }
        waitForServiceToLeaveStoppedState();
        return shellCommandResultRunCommand;
    }

    public final ShellCommandResult startRuntime() {
        return startOpenClawEnv();
    }

    public final ShellCommandResult stopRuntime() {
        ShellCommandResult shellCommandResultRunCommand = runCommand(c5.n.k0(STOP_BIN, this.runtimeConfig.getRuntimeServiceName()));
        shellCommandResultRunCommand.requireSuccess("stop " + this.runtimeConfig.getRuntimeServiceName());
        waitForServiceState("stopped", 10L, f.c("stop ", this.runtimeConfig.getRuntimeServiceName()));
        return shellCommandResultRunCommand;
    }

    public final boolean waitForRestoreDone(long timeoutSeconds) {
        long nanos = TimeUnit.SECONDS.toNanos(timeoutSeconds) + System.nanoTime();
        while (System.nanoTime() < nanos) {
            if (p.a(x5.n.T1(runCommand(c5.n.k0(GETPROP_BIN, RESTORE_DONE_PROP)).getStdout()).toString(), "1")) {
                return true;
            }
            this.sleep.invoke(Long.valueOf(RESTORE_POLL_MS));
        }
        return false;
    }

    public /* synthetic */ SystemChrootRuntimeController(OpenClawRuntimeConfig openClawRuntimeConfig, l lVar, l lVar2, int i8, i iVar) {
        this(openClawRuntimeConfig, (i8 & 2) != 0 ? new d(16) : lVar, (i8 & 4) != 0 ? AnonymousClass2.INSTANCE : lVar2);
    }
}
