package ci7;

import android.app.Application;
import android.net.Uri;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes22.dex */
public final class n implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Uri f23876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f23877b;

    @Override // ci7.t
    public final void a() {
        ((CopyOnWriteArraySet) fi7.d.f477414d).remove(this);
        Application r100 = l.f23871a;
        l.b(this.f23876a, this.f23877b);
    }

    public n(Uri r100) {
        this.f23876a = r100;
        this.f23877b = true;
    }
}
