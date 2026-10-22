package com.stepos.stepclaw.runtime;

import a8.b;
import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import m0.f;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0010J.\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0010J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000eJ\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u000eR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001d\u0010\u0010R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001e\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/stepos/stepclaw/runtime/ShellCommandResult;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "exitCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "stdout", "stderr", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "action", "Lb5/a0;", "requireSuccess", "(Ljava/lang/String;)V", "component1", "()I", "component2", "()Ljava/lang/String;", "component3", "copy", "(ILjava/lang/String;Ljava/lang/String;)Lcom/stepos/stepclaw/runtime/ShellCommandResult;", "toString", "hashCode", "other", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "equals", "(Ljava/lang/Object;)Z", "I", "getExitCode", "Ljava/lang/String;", "getStdout", "getStderr", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ShellCommandResult {
    private final int exitCode;
    private final String stderr;
    private final String stdout;

    public ShellCommandResult(int i8, String stdout, String stderr) {
        p.e(stdout, "stdout");
        p.e(stderr, "stderr");
        this.exitCode = i8;
        this.stdout = stdout;
        this.stderr = stderr;
    }

    public static /* synthetic */ ShellCommandResult copy$default(ShellCommandResult shellCommandResult, int i8, String str, String str2, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i8 = shellCommandResult.exitCode;
        }
        if ((i9 & 2) != 0) {
            str = shellCommandResult.stdout;
        }
        if ((i9 & 4) != 0) {
            str2 = shellCommandResult.stderr;
        }
        return shellCommandResult.copy(i8, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getExitCode() {
        return this.exitCode;
    }

    /* renamed from: component2, reason: from getter */
    public final String getStdout() {
        return this.stdout;
    }

    /* renamed from: component3, reason: from getter */
    public final String getStderr() {
        return this.stderr;
    }

    public final ShellCommandResult copy(int exitCode, String stdout, String stderr) {
        p.e(stdout, "stdout");
        p.e(stderr, "stderr");
        return new ShellCommandResult(exitCode, stdout, stderr);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShellCommandResult)) {
            return false;
        }
        ShellCommandResult shellCommandResult = (ShellCommandResult) other;
        return this.exitCode == shellCommandResult.exitCode && p.a(this.stdout, shellCommandResult.stdout) && p.a(this.stderr, shellCommandResult.stderr);
    }

    public final int getExitCode() {
        return this.exitCode;
    }

    public final String getStderr() {
        return this.stderr;
    }

    public final String getStdout() {
        return this.stdout;
    }

    public int hashCode() {
        return this.stderr.hashCode() + b.f(Integer.hashCode(this.exitCode) * 31, 31, this.stdout);
    }

    public final void requireSuccess(String action) {
        p.e(action, "action");
        if (this.exitCode == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        if (!n.t1(this.stderr)) {
            sb.append(this.stderr);
        }
        if (!n.t1(this.stdout)) {
            if (sb.length() > 0) {
                sb.append(" | ");
            }
            sb.append(this.stdout);
        }
        String string = sb.toString();
        if (n.t1(string)) {
            string = b.j(this.exitCode, "exit=");
        }
        throw new IllegalStateException(b.p("Failed to ", action, ": ", string));
    }

    public String toString() {
        int i8 = this.exitCode;
        String str = this.stdout;
        String str2 = this.stderr;
        StringBuilder sb = new StringBuilder("ShellCommandResult(exitCode=");
        sb.append(i8);
        sb.append(", stdout=");
        sb.append(str);
        sb.append(", stderr=");
        return f.f(sb, str2, ")");
    }
}
