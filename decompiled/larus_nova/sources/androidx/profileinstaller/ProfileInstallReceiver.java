package androidx.profileinstaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;

/* JADX INFO: loaded from: classes17.dex */
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

    public class ResultDiagnostics implements ProfileInstaller.DiagnosticsCallback {
        final /* synthetic */ ProfileInstallReceiver this$0;

        public ResultDiagnostics(ProfileInstallReceiver r100) {
            this.this$0 = r100;
        }

        @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
        public void onDiagnosticReceived(int r100, Object r101) {
            ProfileInstaller.LOG_DIAGNOSTICS.onDiagnosticReceived(r100, r101);
        }

        @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
        public void onResultReceived(int r100, Object r101) {
            ProfileInstaller.LOG_DIAGNOSTICS.onResultReceived(r100, r101);
            this.this$0.setResultCode(r100);
        }
    }

    public ProfileInstallReceiver() {
    }

    public static void saveProfile(ProfileInstaller.DiagnosticsCallback r100) {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        Process.sendSignal(Process.myPid(), 10);
        r100.onResultReceived(12, null);
        return;
    L5:
        r100.onResultReceived(13, null);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r100, Intent r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        String r102 = r101.getAction();
        if (ACTION_INSTALL_PROFILE.equals(r102) == false) goto L8;
        ProfileInstaller.writeProfile(r100, new b(), new ResultDiagnostics(this), true);
        return;
    L8:
        if (ACTION_SKIP_FILE.equals(r102) == false) goto L18;
        Bundle r103 = r101.getExtras();
        if (r103 == null) goto L30;
        String r104 = r103.getString(EXTRA_SKIP_FILE_OPERATION);
        if (EXTRA_SKIP_FILE_OPERATION_WRITE.equals(r104) == false) goto L15;
        ProfileInstaller.writeSkipFile(r100, new b(), new ResultDiagnostics(this));
        return;
    L15:
        if (EXTRA_SKIP_FILE_OPERATION_DELETE.equals(r104) == false) goto L32;
        ProfileInstaller.deleteSkipFile(r100, new b(), new ResultDiagnostics(this));
        return;
    L32:
        return;
    L30:
        return;
    L18:
        if (ACTION_SAVE_PROFILE.equals(r102) == false) goto L21;
        saveProfile(new ResultDiagnostics(this));
        return;
    L21:
        if (ACTION_BENCHMARK_OPERATION.equals(r102) == false) goto L35;
        Bundle r105 = r101.getExtras();
        if (r105 == null) goto L36;
        String r106 = r105.getString(EXTRA_BENCHMARK_OPERATION);
        ResultDiagnostics r107 = new ResultDiagnostics(this);
        if (EXTRA_BENCHMARK_OPERATION_DROP_SHADER_CACHE.equals(r106) == false) goto L27;
        BenchmarkOperation.dropShaderCache(r100, r107);
        return;
    L27:
        r107.onResultReceived(16, null);
        return;
    L36:
        return;
    }
}
