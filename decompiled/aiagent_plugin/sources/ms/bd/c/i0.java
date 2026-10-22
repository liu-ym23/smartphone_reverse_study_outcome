package ms.bd.c;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes4.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private k0 f39516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private n0 f39517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f39518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f39519d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Handler f39520e;
    private Handler f;
    private HandlerThread g;
    private CountDownLatch h;

    final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i0 f39521a;

        a(i0 r1) {
            this.f39521a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            i0.f(this.f39521a).await();     // Catch: InterruptedException -> L5
        L3:
            i0.g(this.f39521a).quitSafely();
            String r8 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "fa1e18", new byte[]{83, 108, 87, 40, 7, 33, 73, 73, 118, 48}), String.class, "com.obric.aiagent.plugin");
            String r9 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "3da0b0", new byte[]{22, 110, 23, 4, 74, 40, 34, 73, 52, 32, 53, 103, 1, 4, 83, 40, 39, 5, 33, 117, 43, 99, 6, 10}), String.class, "com.obric.aiagent.plugin");
        }
    }

    static {
        String r0 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "f8ea3e", new byte[]{83, 53, 3, 44, 5, 124, 73, 16, 34, 52}), String.class, "com.obric.aiagent.plugin");
    }

    public i0(k0 r10, String r11) {
        this.f39519d = false;
        if (TextUtils.isEmpty(r11) == false) goto L6;
        String r9 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "2cba6a", new byte[]{7, 110, 4, 44, 0, 120, 29, 75, 37, 52}), String.class, "com.obric.aiagent.plugin");
        String r12 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "92962b", new byte[]{1, 62, 67, 86, 77, 115, 59, 26, 100, 99, 44, 124, 10, 67, 29, 101, 19, 55, 40, 111, 59, 112, 88, 71, 28, 96, 51, 1, 109, 98, 102}), String.class, "com.obric.aiagent.plugin");
        return;
    L6:
        n0 r0 = new n0();
        this.f39517b = r0;
        if (r0.a() == false) goto L10;
        String r1 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "e72817", new byte[]{80, 58, 84, 117, 7, 46, 74, 31, 117, 109}), String.class, "com.obric.aiagent.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "361a9f", new byte[]{11, 58, 84, 20, 10, 120, 52, 87, 115, 52, 54, 32, 75, 27, 1, 98, 126}), String.class, "com.obric.aiagent.plugin");
    L10:
        if (this.f39517b.b() == false) goto L13;
        this.f39518c = r11;
        this.f39516a = r10;
        this.h = new CountDownLatch(1);
        this.f39519d = true;
        return;
    }

    static /* synthetic */ String a(i0 r0) {
        return r0.f39518c;
    }

    static /* synthetic */ k0 b(i0 r0) {
        return r0.f39516a;
    }

    static /* synthetic */ n0 c(i0 r0) {
        return r0.f39517b;
    }

    static /* synthetic */ Handler d(i0 r0) {
        return r0.f;
    }

    static /* synthetic */ Handler e(i0 r0) {
        return r0.f39520e;
    }

    static /* synthetic */ CountDownLatch f(i0 r0) {
        return r0.h;
    }

    static /* synthetic */ HandlerThread g(i0 r0) {
        return r0.g;
    }

    public final void a() {
        if (this.f39519d == true) goto L5;
        return;
    L5:
        if (this.f39516a.a() == false) goto L9;
        this.f = new Handler(Looper.getMainLooper());
        HandlerThread r0 = new HandlerThread((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "ee93ee", new byte[]{120, 110, 92, 66, 101, 102, 99, 87}), String.class, "com.obric.aiagent.plugin"));
        this.g = r0;
        r0.start();
        this.f39520e = new h0(this, this.g.getLooper());
        Message r1 = new Message();
        r1.what = 1;
        this.f39520e.sendMessage(r1);
        Message r2 = new Message();
        r2.what = 3;
        this.f39520e.sendMessageDelayed(r2, this.f39517b.f());
        return;
    }

    public final void b() {
        if (this.f39519d == true) goto L5;
        return;
    L5:
        if (this.f39516a.a() == false) goto L9;
        Message r0 = new Message();
        r0.what = 4;
        this.f39520e.sendMessage(r0);
        new Thread(new a(this)).start();
        return;
    }

    public final String c() {
        n0 r0 = this.f39517b;
        if (r0 == null) goto L9;
        if (r0.a() == false) goto L9;
        m0 r2 = new m0();
        r2.f39553b = -2;
        return r2.toString();
    L9:
        if (this.f39519d == true) goto L11;
        return "";
    L11:
        return this.f39516a.d();
    }
}
