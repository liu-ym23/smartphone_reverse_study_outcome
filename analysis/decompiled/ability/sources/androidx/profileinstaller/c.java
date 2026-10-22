package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageManager;

/* loaded from: classes2.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1992a;
    public final /* synthetic */ Context b;

    public /* synthetic */ c(Context context, int i) {
        this.f1992a = i;
        this.b = context;
    }

    @Override // java.lang.Runnable
    public final void run() throws PackageManager.NameNotFoundException {
        int i = this.f1992a;
        Context context = this.b;
        switch (i) {
            case 0:
                ProfileInstallerInitializer.writeInBackground(context);
                break;
            default:
                ProfileInstaller.writeProfile(context);
                break;
        }
    }
}
