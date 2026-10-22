package ms.bd.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes4.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f39678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ServiceConnection f39679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f39680c;

    final class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ y f39681a;

        a(y r1) {
            this.f39681a = r1;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r2, IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            this.f39681a.f39678a.put(r4);     // Catch: Exception -> L5
            return;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r1) {
        }
    }

    public y(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        this.f39678a = new LinkedBlockingQueue(1024);
        this.f39679b = new a(this);
        this.f39680c = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
    }

    public final void a(p.a r11) {
        p.a r12 = (p.a) ZeusTransformUtils.wrapperContextForParams(r11, p.a.class, "com.obric.aiagent.plugin");
        if (c1.a(this.f39680c, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "c3d58d", new byte[]{113, 62, 26, 15, 15, 102, 97, 5, 48, 108, 60, 57, 0, 72, 3}), String.class, "com.obric.aiagent.plugin")) == true) goto L5;
        return;
    L5:
        Intent r0 = new Intent((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "ced107", new byte[]{113, 104, 26, 11, 26, 47, 100, 77, 38, 47, 125, 119, 18, 75, 11, 37, 118, 77, 54, 100, 60, 72, 39, 96, 33, 9, 68, 119, 10, 82, 87, 85, 33, 108, 44, 5}), String.class, "com.obric.aiagent.plugin"));
        r0.setPackage((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "d71739", new byte[]{118, 58, 79, 13, 4, 59, 102, 1, 101, 110, 59, 61, 85, 74, 8}), String.class, "com.obric.aiagent.plugin"));
        if (ZeusTransformUtils.bindService(this.f39680c, r0, this.f39679b, 1, "com.obric.aiagent.plugin") == false) goto L19;
        String r1 = new z((IBinder) ZeusTransformUtils.preCheckCast(this.f39678a.take(), IBinder.class, "com.obric.aiagent.plugin")).a();     // Catch: Throwable -> L11 Exception -> L16
        if (r12 == null) goto L14;
        r12.a(r1);     // Catch: Throwable -> L11 Exception -> L16
    L11:
        th = move-exception;
        ZeusTransformUtils.unbindService(this.f39680c, this.f39679b, "com.obric.aiagent.plugin");
        throw th;
    L14:
        ZeusTransformUtils.unbindService(this.f39680c, this.f39679b, "com.obric.aiagent.plugin");
        return;
    }
}
