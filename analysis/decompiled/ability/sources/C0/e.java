package C0;

import B0.f;
import H4.o;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import cc.dd.ee.jj.a;
import g1.AbstractC1451a;

/* loaded from: classes2.dex */
public final class e implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f280a;

    public e(f fVar) {
        this.f280a = fVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        cc.dd.ee.jj.a aVarA = a.AbstractBinderC0142a.a(iBinder);
        f fVar = this.f280a;
        fVar.f177a = aVarA;
        if (AbstractC1451a.f4467a) {
            StringBuilder sb = new StringBuilder("onServiceConnected :");
            sb.append(((cc.dd.ee.jj.a) fVar.f177a) != null);
            o.r("APM-Traffic-Detail", sb.toString());
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f280a.f177a = null;
    }
}
