package ms.bd.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes4.dex */
public final class o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f39574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ServiceConnection f39575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f39576c;

    final class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ o1 f39577a;

        a(o1 r1) {
            this.f39577a = r1;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r2, IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            this.f39577a.f39574a.put(r4);     // Catch: Exception -> L5
            return;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r1) {
        }
    }

    public o1(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        this.f39574a = new LinkedBlockingQueue(1);
        this.f39575b = new a(this);
        this.f39576c = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
    }

    public final void a(p.a r24) {
        p.a r0 = (p.a) ZeusTransformUtils.wrapperContextForParams(r24, p.a.class, "com.obric.aiagent.plugin");
        if (c1.a(this.f39576c, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "6b48f6", new byte[]{36, 111, 74, 2, 74, 32, 56, 80, 112, 102, 32, 46, 70, 66, 93, 51, 58, 74, 97, 38, 35, 101, 81, 69, 90, 36, 60, 71, 118, 109, 53, 118, 78, 79, 92}), String.class, "com.obric.aiagent.plugin")) == true) goto L5;
        return;
    L5:
        boolean r6 = false;
        this.f39576c.getPackageManager().getPackageInfo((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "e1cde6", new byte[]{119, 60, 29, 94, 73, 32, 107, 3, 39, 58, 115, 125, 17, 30, 94, 51, 105, 25, 54, 122, 112, 54, 6, 25, 89, 36, 111, 20, 33, 49, 102, 37, 25, 19, 95}), String.class, "com.obric.aiagent.plugin"), 0);     // Catch: Exception -> L22
    L7:
        Intent r7 = new Intent();
        r7.setClassName((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "2d1d8f", new byte[]{32, 105, 79, 94, 20, 112, 60, 86, 117, 58, 36, 40, 67, 30, 3, 99, 62, 76, 100, 122, 39, 99, 84, 25, 4, 116, 56, 65, 115, 49, 49, 112, 75, 19, 2}), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "7986fa", new byte[]{37, 52, 70, 12, 74, 119, 57, 11, 124, 104, 33, 117, 74, 76, 93, 100, 59, 17, 109, 40, 34, 62, 93, 75, 90, 115, 61, 28, 122, 99, 52, 45, 66, 65, 92, 56, 16, 29, 127, 111, 37, 62, 98, 70, 106, 115, 38, 14, 96, 101, 35}), String.class, "com.obric.aiagent.plugin"));
        r6 = ZeusTransformUtils.bindService(this.f39576c, r7, this.f39575b, 1, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15 Exception -> L19
        if (r6 == false) goto L13;
        String r3 = new p1((IBinder) ZeusTransformUtils.preCheckCast(this.f39574a.take(), IBinder.class, "com.obric.aiagent.plugin")).a();     // Catch: Throwable -> L15 Exception -> L19
        if (r0 == null) goto L13;
        r0.a(r3);     // Catch: Throwable -> L15 Exception -> L19
    L13:
        if (r6 == false) goto L27;
    L20:
        ZeusTransformUtils.unbindService(this.f39576c, this.f39575b, "com.obric.aiagent.plugin");
        return;
    L27:
        return;
    L19:
        if (r6 == true) goto L20;
        return;
    L15:
        th = move-exception;
        if (r6 == false) goto L18;
        ZeusTransformUtils.unbindService(this.f39576c, this.f39575b, "com.obric.aiagent.plugin");
    L18:
        throw th;
    }
}
