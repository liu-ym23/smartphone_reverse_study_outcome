package v5;

import android.app.Application;
import android.os.storage.StorageManager;
import com.bytedance.platform.godzilla.common.Logger;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class b extends c6.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f25086b;

    public b() {
        this.f25086b = false;
    }

    @Override // c6.a
    public String a() {
        return "SpFetcherDeadObjectPlugin";
    }

    @Override // c6.a
    public void b(Application r10) {
        super.b(r10);
        this.f25086b = false;
    }

    @Override // c6.a
    public void c() {
        super.c();
        if (this.f25086b == false) goto L9;
        new y5.b().i();
        Field r10 = StorageManager.class.getDeclaredField("sStorageManager");     // Catch: Exception -> L7
        r10.setAccessible(true);     // Catch: Exception -> L7
        r10.set(null, null);     // Catch: Exception -> L7
        Logger.a("DeadObjectFixer", "Fix success.");     // Catch: Exception -> L7
    L7:
        e = move-exception;
        Logger.a("DeadObjectFixer", "Fix fail " + e);
    L9:
        Logger.c(a(), "start");
    }
}
