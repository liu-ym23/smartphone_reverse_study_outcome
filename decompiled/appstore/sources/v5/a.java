package v5;

import android.app.Application;
import com.bytedance.platform.godzilla.common.Logger;

/* JADX INFO: loaded from: classes.dex */
public class a extends c6.a {
    public a() {
    }

    @Override // c6.a
    public String a() {
        return "ProviderInstalledFailedPlugin";
    }

    @Override // c6.a
    public void b(Application r10) {
        super.b(r10);
        x5.a.a(new z5.a());
        x5.a.a(new z5.b());
    }

    @Override // c6.a
    public void c() {
        super.c();
        x5.a.b();
        Logger.c(a(), "start");
    }
}
