package androidx.profileinstaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;

/* JADX INFO: loaded from: classes.dex */
public class ProfileInstallReceiver extends BroadcastReceiver {

    public class a implements ProfileInstaller.DiagnosticsCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProfileInstallReceiver f3927a;

        public a(ProfileInstallReceiver r10) {
            this.f3927a = r10;
        }

        @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
        public void onDiagnosticReceived(int r10, Object r11) {
            ProfileInstaller.f3929b.onDiagnosticReceived(r10, r11);
        }

        @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
        public void onResultReceived(int r10, Object r11) {
            ProfileInstaller.f3929b.onResultReceived(r10, r11);
            this.f3927a.setResultCode(r10);
        }
    }

    public ProfileInstallReceiver() {
    }

    public static void a(ProfileInstaller.DiagnosticsCallback r10) {
        Process.sendSignal(Process.myPid(), 10);
        r10.onResultReceived(12, null);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r10, Intent r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        String r12 = r11.getAction();
        if ("androidx.profileinstaller.action.INSTALL_PROFILE".equals(r12) == false) goto L8;
        ProfileInstaller.k(r10, new f(), new a(this), true);
        return;
    L8:
        if ("androidx.profileinstaller.action.SKIP_FILE".equals(r12) == false) goto L18;
        Bundle r13 = r11.getExtras();
        if (r13 == null) goto L30;
        String r14 = r13.getString("EXTRA_SKIP_FILE_OPERATION");
        if ("WRITE_SKIP_FILE".equals(r14) == false) goto L15;
        ProfileInstaller.l(r10, new f(), new a(this));
        return;
    L15:
        if ("DELETE_SKIP_FILE".equals(r14) == false) goto L32;
        ProfileInstaller.c(r10, new f(), new a(this));
        return;
    L32:
        return;
    L30:
        return;
    L18:
        if ("androidx.profileinstaller.action.SAVE_PROFILE".equals(r12) == false) goto L21;
        a(new a(this));
        return;
    L21:
        if ("androidx.profileinstaller.action.BENCHMARK_OPERATION".equals(r12) == false) goto L35;
        Bundle r15 = r11.getExtras();
        if (r15 == null) goto L36;
        String r16 = r15.getString("EXTRA_BENCHMARK_OPERATION");
        a r17 = new a(this);
        if ("DROP_SHADER_CACHE".equals(r16) == false) goto L27;
        androidx.profileinstaller.a.b(r10, r17);
        return;
    L27:
        r17.onResultReceived(16, null);
        return;
    L36:
        return;
    }
}
