package androidx.profileinstaller;

import androidx.profileinstaller.ProfileInstaller;

/* loaded from: classes2.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1990a;
    public final /* synthetic */ ProfileInstaller.DiagnosticsCallback b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ a(ProfileInstaller.DiagnosticsCallback diagnosticsCallback, int i, Object obj, int i6) {
        this.f1990a = i6;
        this.b = diagnosticsCallback;
        this.c = i;
        this.d = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1990a) {
            case 0:
                this.b.onResultReceived(this.c, this.d);
                break;
            default:
                this.b.onDiagnosticReceived(this.c, this.d);
                break;
        }
    }
}
