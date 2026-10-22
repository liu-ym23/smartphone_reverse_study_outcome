package a74;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.bytedance.badger.service.SensorDataService;

/* JADX INFO: loaded from: classes47.dex */
public final class h implements ServiceConnection {
    public h() {
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r100) {
        p.f2009b = null;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r100, IBinder r101) {
        SensorDataService r102 = null;
        if ((r101 instanceof r) == false) goto L5;
        r r103 = (r) r101;
    L6:
        if (r103 == null) goto L8;
        r102 = r103.f2015a;
    L8:
        if (r102 != null) goto L12;
        com.bytedance.badger.utils.m r104 = com.bytedance.badger.utils.m.a();
        Runnable r105 = new f();
    L10:
        r104.b(r105);
        return;
    L12:
        p.f2009b = r102;
        r104 = com.bytedance.badger.utils.m.a();
        r105 = new g();
        goto L10
    L5:
        r103 = null;
        goto L6
    }
}
