package q5;

import android.app.Application;
import com.bytedance.platform.godzilla.common.Logger;

/* JADX INFO: loaded from: classes.dex */
public class b extends c6.a {
    public b() {
    }

    @Override // c6.a
    public String a() {
        return "SpPlugin";
    }

    @Override // c6.a
    public void b(Application r10) {
        super.b(r10);
    }

    @Override // c6.a
    public void c() {
        super.c();
        s5.b.a();
        Logger.c(a(), "start");
    }
}
