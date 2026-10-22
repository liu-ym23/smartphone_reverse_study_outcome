package ms.bd.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f39443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ServiceConnection f39444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f39445c;

    /* JADX INFO: renamed from: ms.bd.c.a$a, reason: collision with other inner class name */
    final class ServiceConnectionC1062a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f39446a;

        ServiceConnectionC1062a(a r1) {
            this.f39446a = r1;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r2, IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            this.f39446a.f39443a.put(r4);     // Catch: Exception -> L5
            return;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r1) {
        }
    }

    public a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        this.f39443a = new LinkedBlockingQueue(1);
        this.f39444b = new ServiceConnectionC1062a(this);
        this.f39445c = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
    }

    public final void a(p.a r12) {
        p.a r13 = (p.a) ZeusTransformUtils.wrapperContextForParams(r12, p.a.class, "com.obric.aiagent.plugin");
        if (c1.a(this.f39445c, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "147265", new byte[]{35, 57, 73, 8, 8, 49, 39, 6, 40, 111, 51, 55, 10, 117, 28, 50, 34, 25, 99, 111, 37, 56, 80, 71, 27, 59, 22, 60, 66}), String.class, "com.obric.aiagent.plugin")) == true) goto L5;
        return;
    L5:
        Intent r0 = new Intent();
        r0.setAction((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "d3e954", new byte[]{118, 62, 27, 3, 11, 48, 114, 1, 122, 100, 102, 48, 88, 76, 9, 55, 110, 29, 58, 39, 84, 18, 53, 104, 57, 16, 88, 54, 29, 77}), String.class, "com.obric.aiagent.plugin"));
        r0.setComponent(new ComponentName((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "1c3428", new byte[]{35, 110, 77, 14, 12, 60, 39, 81, 44, 105, 51, 96, 14, 115, 24, 63, 34, 78, 103, 105, 37, 111, 84, 65, 31, 54, 22, 107, 70}), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "ed3bff", new byte[]{119, 105, 77, 88, 88, 98, 115, 86, 44, 63, 103, 103, 14, 37, 76, 97, 118, 73, 103, 63, 113, 104, 84, 23, 75, 104, 66, 108, 70, 124, 71, 115, 80, 6, 85, 116, 107, 64, 108, 38, 117, 116, 89, 50, 112, 85, 85, 64, 112, 36, 125, 101, 69}), String.class, "com.obric.aiagent.plugin")));
        if (ZeusTransformUtils.bindService(this.f39445c, r0, this.f39444b, 1, "com.obric.aiagent.plugin") == false) goto L19;
        String r1 = new b((IBinder) ZeusTransformUtils.preCheckCast(this.f39443a.take(), IBinder.class, "com.obric.aiagent.plugin")).a();     // Catch: Throwable -> L11 Exception -> L16
        if (r13 == null) goto L14;
        r13.a(r1);     // Catch: Throwable -> L11 Exception -> L16
    L11:
        th = move-exception;
        ZeusTransformUtils.unbindService(this.f39445c, this.f39444b, "com.obric.aiagent.plugin");
        throw th;
    L14:
        ZeusTransformUtils.unbindService(this.f39445c, this.f39444b, "com.obric.aiagent.plugin");
        return;
    }
}
