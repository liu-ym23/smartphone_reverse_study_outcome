package a87;

import android.content.Context;
import android.net.Uri;
import com.bytedance.push.settings.storage.SmpProcessSettingsProvider;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f2186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f2187c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Context f2188d;

    public final void a() {
        String r100 = this.f2185a;
        String r101 = this.f2186b;
        String r102 = this.f2187c;
        Context r103 = this.f2188d;
        monitor-enter(SmpProcessSettingsProvider.class);
    L22:
        th = move-exception;
        throw th;
    L6:
        if (SmpProcessSettingsProvider.f267024b == null) goto L25;
    L13:
        Uri r104 = SmpProcessSettingsProvider.f267024b.buildUpon().appendPath(r100).appendPath(r101).appendPath("val").appendPath(r102).build();     // Catch: Throwable -> L22
        monitor-exit(SmpProcessSettingsProvider.class);
    L15:
        if (r104 != null) goto L27;
        return;
    L27:
        this.f2188d.getContentResolver().notifyChange(r104, null);     // Catch: Exception -> L19
        return;
    L19:
        e = move-exception;
        e.printStackTrace();
        return;
    L25:
        SmpProcessSettingsProvider.b(r103);     // Catch: Exception -> L9 Throwable -> L22
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

    public j(String r100, String r101, String r102, Context r103) {
        this.f2185a = r100;
        this.f2186b = r101;
        this.f2187c = r102;
        this.f2188d = r103;
    }
}
