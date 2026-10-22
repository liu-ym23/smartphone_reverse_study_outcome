package ms.bd.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    g0 f39497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ServiceConnection f39498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f39499c;

    final class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f0 f39500a;

        a(f0 r1) {
            this.f39500a = r1;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r2, IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            f0 r1 = this.f39500a;
            r1.f39497a = new g0(r4);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r1) {
        }
    }

    public f0(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.f39498b = new a(this);
        this.f39499c = ZeusTransformUtils.wrapperContext(r4, "com.obric.aiagent.plugin");
    }

    public final void a(p.a r11) {
        p.a r12 = (p.a) ZeusTransformUtils.wrapperContextForParams(r11, p.a.class, "com.obric.aiagent.plugin");
        Intent r0 = new Intent();
        r0.setClassName((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "fef608", new byte[]{116, 104, 24, 12, 21, 58, 108, 10, 51, 99, 97, 110, 22, 71, 6, 43, 118, 65, 37, 112, 126, 100, 16}), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "576fc9", new byte[]{39, 58, 72, 92, 70, 59, 63, 88, 99, 51, 50, 60, 70, 23, 85, 42, 37, 19, 117, 32, 45, 54, 64, 92, 120, 43, 32, 31, 100, 51, 45, 49, 118, 23, 78, 56, 63, 21, 98}), String.class, "com.obric.aiagent.plugin"));
        if (ZeusTransformUtils.bindService(this.f39499c, r0, this.f39498b, 1, "com.obric.aiagent.plugin") == false) goto L14;
        g0 r1 = this.f39497a;     // Catch: Throwable -> L11
        if (r1 == null) goto L9;
        String r2 = r1.a();     // Catch: Throwable -> L11
        if (r12 == null) goto L9;
        r12.a(r2);     // Catch: Throwable -> L11
    L9:
        ZeusTransformUtils.unbindService(this.f39499c, this.f39498b, "com.obric.aiagent.plugin");
        return;
    }
}
