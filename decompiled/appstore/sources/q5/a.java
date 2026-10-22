package q5;

import android.app.Application;
import com.bytedance.platform.godzilla.common.Logger;

/* JADX INFO: loaded from: classes.dex */
public class a extends c6.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Application f23543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f23544c;

    public a() {
    }

    @Override // c6.a
    public String a() {
        return "CookieManagerPlugin";
    }

    @Override // c6.a
    public void b(Application r10) {
        super.b(r10);
        this.f23543b = r10;
        this.f23544c = false;
    }

    @Override // c6.a
    public void c() {
        super.c();
        if (this.f23543b == null) goto L10;
        Logger.c(a(), "start");
        if (this.f23544c == true) goto L7;
        return;
    L7:
        new t5.a().a(this.f23543b);
        return;
    L10:
        throw new RuntimeException("mApplication must not null!!!");
    }
}
