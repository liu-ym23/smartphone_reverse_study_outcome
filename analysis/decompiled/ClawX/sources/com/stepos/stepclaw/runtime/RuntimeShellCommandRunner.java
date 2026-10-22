package com.stepos.stepclaw.runtime;

import c5.m;
import com.stepos.stepclaw.SecurePrefs;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.TimeUnit;
import k4.z;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import m0.f;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\f\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/stepos/stepclaw/runtime/RuntimeShellCommandRunner;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "CONTROLLER_COMMAND_TIMEOUT_SEC", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "ROOTFS_BIN_INSTALL_TIMEOUT_SEC", "execute", "Lcom/stepos/stepclaw/runtime/ShellCommandResult;", "command", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "timeoutSeconds", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RuntimeShellCommandRunner {
    public static final long CONTROLLER_COMMAND_TIMEOUT_SEC = 10;
    public static final RuntimeShellCommandRunner INSTANCE = new RuntimeShellCommandRunner();
    public static final long ROOTFS_BIN_INSTALL_TIMEOUT_SEC = 30;

    private RuntimeShellCommandRunner() {
    }

    public static /* synthetic */ ShellCommandResult execute$default(RuntimeShellCommandRunner runtimeShellCommandRunner, List list, long j4, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            j4 = 30;
        }
        return runtimeShellCommandRunner.execute(list, j4);
    }

    public final ShellCommandResult execute(List<String> command, long timeoutSeconds) {
        p.e(command, "command");
        Process processStart = new ProcessBuilder(command).redirectErrorStream(false).start();
        if (!processStart.waitFor(timeoutSeconds, TimeUnit.SECONDS)) {
            processStart.destroyForcibly();
            throw new IllegalStateException(f.c("Timed out running: ", m.A0(command, " ", null, null, null, 62)));
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processStart.getInputStream()));
        try {
            String string = n.T1(z.C(bufferedReader)).toString();
            bufferedReader.close();
            bufferedReader = new BufferedReader(new InputStreamReader(processStart.getErrorStream()));
            try {
                String string2 = n.T1(z.C(bufferedReader)).toString();
                bufferedReader.close();
                return new ShellCommandResult(processStart.exitValue(), string, string2);
            } finally {
            }
        } finally {
            try {
                throw th;
            } finally {
            }
        }
    }
}
