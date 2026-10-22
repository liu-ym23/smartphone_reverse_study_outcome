package ms.bd.c;

import android.hardware.display.DisplayManager;
import android.text.TextUtils;
import android.view.Display;

/* JADX INFO: loaded from: classes4.dex */
public final class q implements DisplayManager.DisplayListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DisplayManager f39585a;

    public q(DisplayManager r1) {
        this.f39585a = r1;
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayAdded(int r4) {
        Display[] r3 = this.f39585a.getDisplays();     // Catch: Exception -> L12
        int r5 = r3.length;     // Catch: Exception -> L12
        if (r5 <= 0) goto L15;
        q1 r0 = q1.a();     // Catch: Exception -> L12
        r0.getClass();     // Catch: Exception -> L12
        String r1 = q1.a(r3);     // Catch: Exception -> L12
        String r6 = q1.b(r3);     // Catch: Exception -> L12
        r0.a(r5);     // Catch: Exception -> L12
        if (TextUtils.isEmpty(r1) == true) goto L8;
        r0.a(r1);     // Catch: Exception -> L12
    L8:
        if (TextUtils.isEmpty(r6) == true) goto L10;
        r0.b(r6);     // Catch: Exception -> L12
    L10:
        r0.a(System.currentTimeMillis() / 1000);     // Catch: Exception -> L12
        return;
    L15:
        return;
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayChanged(int r1) {
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayRemoved(int r4) {
        Display[] r3 = this.f39585a.getDisplays();     // Catch: Exception -> L12
        int r5 = r3.length;     // Catch: Exception -> L12
        if (r5 <= 0) goto L15;
        q1 r0 = q1.a();     // Catch: Exception -> L12
        r0.getClass();     // Catch: Exception -> L12
        String r1 = q1.a(r3);     // Catch: Exception -> L12
        String r6 = q1.b(r3);     // Catch: Exception -> L12
        r0.a(r5);     // Catch: Exception -> L12
        if (TextUtils.isEmpty(r1) == true) goto L8;
        r0.a(r1);     // Catch: Exception -> L12
    L8:
        if (TextUtils.isEmpty(r6) == true) goto L10;
        r0.b(r6);     // Catch: Exception -> L12
    L10:
        r0.b(System.currentTimeMillis() / 1000);     // Catch: Exception -> L12
        return;
    L15:
        return;
    }
}
