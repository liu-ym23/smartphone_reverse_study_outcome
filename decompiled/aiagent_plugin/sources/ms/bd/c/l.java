package ms.bd.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes4.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f39540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f39541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f39542c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ServiceConnection f39543d;

    final class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ l f39544a;

        a(l r1) {
            this.f39544a = r1;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r2, IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            this.f39544a.f39542c.put(r4);     // Catch: Exception -> L5
            return;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r1) {
        }
    }

    public l(Context r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        this.f39541b = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "95b9e4", new byte[]{43, 56, 28, 3, 87, 39, 51, 16, 125, 100, 59, 54}), String.class, "com.obric.aiagent.plugin");
        this.f39542c = new LinkedBlockingQueue(1);
        this.f39543d = new a(this);
        this.f39540a = ZeusTransformUtils.wrapperContext(r10, "com.obric.aiagent.plugin");
    }

    public final void a(p.a r22) {
        p.a r0 = (p.a) ZeusTransformUtils.wrapperContextForParams(r22, p.a.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT > 28) goto L5;
        boolean r3 = false;
    L6:
        if (r3 == true) goto L8;
        return;
    L8:
        String r4 = this.f39540a.getPackageName();
        Intent r5 = new Intent();
        r5.setClassName(this.f39541b, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "7bbb2d", new byte[]{37, 111, 28, 88, 0, 119, 61, 71, 125, 63, 53, 97, 95, 5, 8, 97, 34, 74, 48, 55, 104, 77, 2, 23, 38, 127, 7, 70, 33, 36, 47, 99, 20}), String.class, "com.obric.aiagent.plugin"));
        r5.setAction((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "f83a9a", new byte[]{116, 53, 77, 91, 4, 99, 107, 87, 111, 34, 118, 116, 65, 22, 18, 127, 106, 23, 44, 34, 99, 59, 82, 1, 72, 101, 96, 11, 116, 56, 116, 63}), String.class, "com.obric.aiagent.plugin"));
        r5.putExtra((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "d322a2", new byte[]{118, 62, 76, 8, 92, 48, 105, 92, 110, 113, 116, 127, 81, 71, 76, 36, 106, 92, 115, 105, 114, 63, 64, 75, 91}), String.class, "com.obric.aiagent.plugin"), r4);
        int r6 = 12;
        r5.putExtra((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "c32c6a", new byte[]{113, 62, 76, 89, 11, 99, 110, 92, 110, 32, 115, 127, 81, 22, 27, 119, 109, 92, 113, 38, 124, 56, 79, 4, 12, 98}), String.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L25
        ZeusTransformUtils.startService(this.f39540a, r5, "com.obric.aiagent.plugin");     // Catch: Exception -> L25
    L14:
        Intent r7 = new Intent();
        byte[] r15 = new byte[r6];
        r15 = {x0208: FILL_ARRAY_DATA , data: [115, 63, 75, 89, 4, 35, 107, 23, 42, 62, 99, 49} // fill-array;
        r7.setClassName((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "a25c60", r15), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "ba8fe0", new byte[]{112, 108, 70, 92, 87, 35, 104, 68, 39, 59, 96, 98, 5, 1, 95, 53, 119, 73, 106, 51, 61, 78, 88, 19, 115, 35, 82, 69, 123, 32, 122, 96, 78}), String.class, "com.obric.aiagent.plugin"));
        r7.setAction((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "a7931c", new byte[]{115, 58, 71, 9, 12, 97, 108, 88, 101, 112, 113, 123, 75, 68, 26, 125, 109, 24, 38, 97, 121, 59, 78, 83, 1, 58, 113, 19, 122, 117, 121, 54, 79}), String.class, "com.obric.aiagent.plugin"));
        r7.putExtra((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "bb9b7a", new byte[]{112, 111, 71, 88, 10, 99, 111, 13, 101, 33, 114, 46, 90, 23, 26, 119, 108, 13, 120, 57, 116, 110, 75, 27, 13}), String.class, "com.obric.aiagent.plugin"), r4);
        if (ZeusTransformUtils.bindService(this.f39540a, r7, this.f39543d, 1, "com.obric.aiagent.plugin") == false) goto L33;
        String r8 = new m((IBinder) ZeusTransformUtils.preCheckCast(this.f39542c.take(), IBinder.class, "com.obric.aiagent.plugin")).a();     // Catch: Throwable -> L20 Exception -> L26
        if (r0 == null) goto L23;
        r0.a(r8);     // Catch: Throwable -> L20 Exception -> L26
    L20:
        th = move-exception;
        ZeusTransformUtils.unbindService(this.f39540a, this.f39543d, "com.obric.aiagent.plugin");
        throw th;
    L23:
        ZeusTransformUtils.unbindService(this.f39540a, this.f39543d, "com.obric.aiagent.plugin");
        return;
    L33:
        return;
    L13:
        r6 = 12;
        goto L14
    L5:
        r3 = c1.a(this.f39540a, this.f39541b);
        goto L6
    }
}
