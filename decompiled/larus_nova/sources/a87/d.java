package a87;

import android.content.Context;
import android.net.Uri;
import com.bytedance.push.settings.storage.MainProcessSettingsProvider;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f2166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f2167c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Context f2168d;

    public final void a() {
        String r100 = this.f2165a;
        String r101 = this.f2166b;
        String r102 = this.f2167c;
        Context r103 = this.f2168d;
        monitor-enter(MainProcessSettingsProvider.class);
    L22:
        th = move-exception;
        throw th;
    L6:
        if (MainProcessSettingsProvider.f267020b == null) goto L25;
    L13:
        Uri r104 = MainProcessSettingsProvider.f267020b.buildUpon().appendPath(r100).appendPath(r101).appendPath("val").appendPath(r102).build();     // Catch: Throwable -> L22
        monitor-exit(MainProcessSettingsProvider.class);
    L15:
        if (r104 != null) goto L27;
        return;
    L27:
        this.f2168d.getContentResolver().notifyChange(r104, null);     // Catch: Exception -> L19
        return;
    L19:
        e = move-exception;
        e.printStackTrace();
        return;
    L25:
        MainProcessSettingsProvider.b(r103);     // Catch: Exception -> L9 Throwable -> L22
    L9:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L22
        r104 = null;
        goto L15
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public d(String r100, String r101, String r102, Context r103) {
        this.f2165a = r100;
        this.f2166b = r101;
        this.f2167c = r102;
        this.f2168d = r103;
    }
}
