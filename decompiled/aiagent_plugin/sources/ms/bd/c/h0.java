package ms.bd.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
final class h0 extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.mobsec.metasec.ml.c f39504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ i0 f39505b;

    final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h0 f39506a;

        a(h0 r1) {
            this.f39506a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            i0.b(this.f39506a.f39505b).a(false);
            String r0 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "630331", new byte[]{3, 62, 86, 126, 5, 40, 25, 27, 119, 102}), String.class, "com.obric.aiagent.plugin");
            String r1 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "eb3b05", new byte[]{40, 60, 28, 86, 60, 54, 105, 83, 114, 55, 112, 44, 0, 1, 6, 46, 106, 3, 96, 55, 52, 114, 69, 5, 27, 35, 116, 87, 103, 54, 52, 97, 70, 2, 10, 48, 38, 6, 102, 33}), String.class, "com.obric.aiagent.plugin");
            int r9 = i0.c(this.f39506a.f39505b).e() / 1000;
        }
    }

    final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h0 f39507a;

        b(h0 r1) {
            this.f39507a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            i0.b(this.f39507a.f39505b).b();
            String r0 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "3d8cb7", new byte[]{6, 105, 94, 46, 84, 46, 28, 76, 127, 54}), String.class, "com.obric.aiagent.plugin");
            String r1 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "c0bd1b", new byte[]{44, 108, 79, 80, 61, 97, 97, 3, 39, 49, 118, 126, 81, 7, 7, 121, 108, 81, 49, 49, 50, 33, 5, 31, 30, 101, 101, 21, 115, 53, 116, 38, 20, 2, 78, 48, 100, 2}), String.class, "com.obric.aiagent.plugin");
            int r9 = i0.c(this.f39507a.f39505b).d() / 1000;
        }
    }

    h0(i0 r1, Looper r2) {
        this.f39505b = r1;
        super(r2);
    }

    private void a() {
        if (this.f39504a != null) goto L5;
        this.f39504a = com.bytedance.mobsec.metasec.ml.d.a(i0.a(this.f39505b));
    L5:
        String r0 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "a454a8", new byte[]{84, 57, 83, 121, 87, 33, 78, 28, 114, 97}), String.class, "com.obric.aiagent.plugin");
        String r1 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "ee7070", new byte[]{80, 104, 4, 119, 44, 12, 38, 86, 99, 112, 123, 117, 80, 77, 6, 32, 40, 10, 40}), String.class, "com.obric.aiagent.plugin");
        this.f39504a.d((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "464865", new byte[]{41, 61, 81, 73, 54, 54, 50, 4}), String.class, "com.obric.aiagent.plugin"));
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r5) {
        super.handleMessage(r5);
        int r6 = r5.what;
        if (r6 != 0) goto L5;
        i0.d(this.f39505b).post(new a(this));
        i0.b(this.f39505b).c();
        long r1 = i0.c(this.f39505b).e();
        Message r7 = new Message();
        r7.what = 1;
        sendMessageDelayed(r7, r1);
        return;
    L5:
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L8;
        i0.b(this.f39505b).c();
        long r2 = i0.c(this.f39505b).d();
        Message r8 = new Message();
        r8.what = 2;
        sendMessageDelayed(r8, r2);
        return;
    L8:
        if (r6 != 3) goto L10;
        a();
        long r3 = i0.c(this.f39505b).f();
        Message r9 = new Message();
        r9.what = 3;
        sendMessageDelayed(r9, r3);
        return;
    L10:
        if (r6 != 4) goto L26;
        a();
        i0.b(this.f39505b).a(true);
        i0.e(this.f39505b).removeCallbacks(null);
        i0.f(this.f39505b).countDown();
        return;
    L26:
        return;
    L15:
        i0.d(this.f39505b).post(new b(this));
        if (i0.c(this.f39505b).c() == false) goto L18;
        long r4 = i0.c(this.f39505b).d();
        Message r10 = new Message();
        r10.what = 2;
        sendMessageDelayed(r10, r4);
        return;
    L18:
        long r0 = i0.c(this.f39505b).d();
        Message r11 = new Message();
        r11.what = 0;
        sendMessageDelayed(r11, r0);
    }
}
