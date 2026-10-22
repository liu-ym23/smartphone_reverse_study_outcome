package androidx.profileinstaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;

/* JADX INFO: loaded from: classes.dex */
public class ProfileInstallReceiver extends BroadcastReceiver {
    public static final String ACTION_BENCHMARK_OPERATION = "androidx.profileinstaller.action.BENCHMARK_OPERATION";
    public static final String ACTION_INSTALL_PROFILE = "androidx.profileinstaller.action.INSTALL_PROFILE";
    public static final String ACTION_SAVE_PROFILE = "androidx.profileinstaller.action.SAVE_PROFILE";
    public static final String ACTION_SKIP_FILE = "androidx.profileinstaller.action.SKIP_FILE";
    private static final String EXTRA_BENCHMARK_OPERATION = "EXTRA_BENCHMARK_OPERATION";
    private static final String EXTRA_BENCHMARK_OPERATION_DROP_SHADER_CACHE = "DROP_SHADER_CACHE";
    private static final String EXTRA_SKIP_FILE_OPERATION = "EXTRA_SKIP_FILE_OPERATION";
    private static final String EXTRA_SKIP_FILE_OPERATION_DELETE = "DELETE_SKIP_FILE";
    private static final String EXTRA_SKIP_FILE_OPERATION_WRITE = "WRITE_SKIP_FILE";

    class ResultDiagnostics implements ProfileInstaller.DiagnosticsCallback {
        final /* synthetic */ ProfileInstallReceiver this$0;

        ResultDiagnostics(ProfileInstallReceiver r1) {
            this.this$0 = r1;
        }

        @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
        public void onDiagnosticReceived(int r1, Object r2) {
            ProfileInstaller.LOG_DIAGNOSTICS.onDiagnosticReceived(r1, r2);
        }

        @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
        public void onResultReceived(int r2, Object r3) {
            ProfileInstaller.LOG_DIAGNOSTICS.onResultReceived(r2, r3);
            this.this$0.setResultCode(r2);
        }
    }

    public ProfileInstallReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r3, Intent r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        String r0 = r4.getAction();
        if (ACTION_INSTALL_PROFILE.equals(r0) == false) goto L8;
        ProfileInstaller.writeProfile(r3, new ProfileInstallReceiver$$ExternalSyntheticLambda0(), new ResultDiagnostics(this), true);
        return;
    L8:
        if (ACTION_SKIP_FILE.equals(r0) == false) goto L18;
        Bundle r5 = r4.getExtras();
        if (r5 == null) goto L30;
        String r6 = r5.getString(EXTRA_SKIP_FILE_OPERATION);
        if (EXTRA_SKIP_FILE_OPERATION_WRITE.equals(r6) == false) goto L15;
        ProfileInstaller.writeSkipFile(r3, new ProfileInstallReceiver$$ExternalSyntheticLambda0(), new ResultDiagnostics(this));
        return;
    L15:
        if (EXTRA_SKIP_FILE_OPERATION_DELETE.equals(r6) == false) goto L32;
        ProfileInstaller.deleteSkipFile(r3, new ProfileInstallReceiver$$ExternalSyntheticLambda0(), new ResultDiagnostics(this));
        return;
    L32:
        return;
    L30:
        return;
    L18:
        if (ACTION_SAVE_PROFILE.equals(r0) == false) goto L21;
        saveProfile(new ResultDiagnostics(this));
        return;
    L21:
        if (ACTION_BENCHMARK_OPERATION.equals(r0) == false) goto L35;
        Bundle r7 = r4.getExtras();
        if (r7 == null) goto L36;
        String r8 = r7.getString(EXTRA_BENCHMARK_OPERATION);
        ResultDiagnostics r1 = new ResultDiagnostics(this);
        if (EXTRA_BENCHMARK_OPERATION_DROP_SHADER_CACHE.equals(r8) == false) goto L27;
        BenchmarkOperation.dropShaderCache(r3, r1);
        return;
    L27:
        r1.onResultReceived(16, null);
        return;
    L36:
        return;
    }

    static void saveProfile(ProfileInstaller.DiagnosticsCallback r2) {
        Process.sendSignal(Process.myPid(), 10);
        r2.onResultReceived(12, null);
    }
}
