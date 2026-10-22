package ms.bd.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes4.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f39453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f39454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ServiceConnection f39455c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f39456d;

    final class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b0 f39457a;

        a(b0 r1) {
            this.f39457a = r1;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r2, IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            this.f39457a.f39454b.put(r4);     // Catch: Exception -> L5
            return;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r1) {
        }
    }

    public class b extends c0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private volatile String f39458b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private p.a f39459c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ b0 f39460d;

        public b(b0 r3, p.a r4) {
            p.a r5 = (p.a) ZeusTransformUtils.wrapperContextForParams(r4, p.a.class, "com.obric.aiagent.plugin");
            this.f39460d = r3;
            this.f39458b = "";
            this.f39459c = r5;
        }

        public final void a(int r2, Bundle r3) {
            this.f39460d.getClass();
            if (r2 != 0) goto L9;
            if (r3 == null) goto L10;
            this.f39458b = r3.getString(this.f39460d.f39453a);
            p.a r4 = this.f39459c;
            if (r4 == null) goto L11;
            r4.a(this.f39458b);
            return;
        L11:
            return;
        L10:
            return;
        }
    }

    public b0(Context r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        this.f39453a = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "b20635", new byte[]{124, 49, 124, 75, 8, 29, 103, 31, 96, 97}), String.class, "com.obric.aiagent.plugin");
        this.f39454b = new LinkedBlockingQueue(1);
        this.f39455c = new a(this);
        this.f39456d = ZeusTransformUtils.wrapperContext(r10, "com.obric.aiagent.plugin");
    }

    public final void a(p.a r11) {
        p.a r12 = (p.a) ZeusTransformUtils.wrapperContextForParams(r11, p.a.class, "com.obric.aiagent.plugin");
        if (c1.a(this.f39456d, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "2f50e1", new byte[]{32, 107, 75, 10, 82, 47, 57, 72, 106, 111, 49, 42, 79, 64}), String.class, "com.obric.aiagent.plugin")) == true) goto L5;
        return;
    L5:
        Intent r0 = new Intent();
        r0.setAction((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "70a0ea", new byte[]{37, 61, 31, 10, 82, 127, 60, 30, 62, 111, 52, 124, 27, 64, 20, 94, 58, 62, 49, 73, 34, 1, 23, 86, 76, 127, 55, 20}), String.class, "com.obric.aiagent.plugin"));
        r0.setPackage((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "1fe429", new byte[]{35, 107, 27, 14, 5, 39, 58, 72, 58, 107, 50, 42, 31, 68}), String.class, "com.obric.aiagent.plugin"));
        if (ZeusTransformUtils.bindService(this.f39456d, r0, this.f39455c, 1, "com.obric.aiagent.plugin") == false) goto L17;
        d0.a.a((IBinder) ZeusTransformUtils.preCheckCast(this.f39454b.take(), IBinder.class, "com.obric.aiagent.plugin")).a(new b(this, r12));     // Catch: Throwable -> L9 Exception -> L14
    L9:
        th = move-exception;
        ZeusTransformUtils.unbindService(this.f39456d, this.f39455c, "com.obric.aiagent.plugin");
        throw th;
    L12:
        ZeusTransformUtils.unbindService(this.f39456d, this.f39455c, "com.obric.aiagent.plugin");
        return;
    }
}
