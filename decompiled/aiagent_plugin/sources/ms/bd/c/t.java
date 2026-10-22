package ms.bd.c;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile t f39609b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    c f39610a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Handler f39611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private HandlerThread f39612d;

    final class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ t f39613a;

        a(t r1, Looper r2) {
            this.f39613a = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r4) {
            int r1 = b.a()[r4.what].ordinal();
            if (r1 != 1) goto L5;
        L7:
            c r3 = this.f39613a.f39610a;
            if (r3 == null) goto L16;
            int r2 = r4.what;     // Catch: Exception -> L11
            String r5 = (String) ZeusTransformUtils.preCheckCast(r4.obj, String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L11
            ((u) ZeusTransformUtils.preCheckCast(r3, u.class, "com.obric.aiagent.plugin")).a(r5, r2);     // Catch: Exception -> L11
            return;
        L11:
            e = move-exception;
            e.getMessage();
            return;
        L16:
            return;
        L5:
            if (r1 == 2) goto L7;
        }
    }

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f39614a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f39615b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f39616c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ b[] f39617d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f39618e;

        private b(int r1, int r2, String r3) {
            super(r3, r1);
            this.f39618e = r2;
        }

        public static b[] a() {
            return (b[]) ZeusTransformUtils.preCheckCast(f39617d.clone(), b[].class, "com.obric.aiagent.plugin");
        }

        public final int b() {
            return this.f39618e;
        }

        static {
            b r0 = new b(0, 0, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "e8b7f5", new byte[]{80, 3, 46, 110, 106, 5, 89, 45, 10, 87, 81, 5, 63, 108, 119, 7}), String.class, "com.obric.aiagent.plugin"));
            b r1 = new b(1, 1, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "8c9d28", new byte[]{13, 88, 117, 61, 62, 8, 4, 118, 81, 4, 12, 94, 110, 41}), String.class, "com.obric.aiagent.plugin"));
            f39614a = r1;
            b r4 = new b(2, 2, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "f03b86", new byte[]{83, 11, 127, 59, 52, 6, 90, 37, 91, 2, 82, 13, 100, 47, 56, 9, 81, 37, 82, 13, 71, 19, 116, 62}), String.class, "com.obric.aiagent.plugin"));
            f39615b = r4;
            b r6 = new b(3, 3, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "282ede", new byte[]{7, 3, 126, 60, 104, 85, 14, 45, 90, 5, 6, 5, 101, 40, 100, 81, 29, 60, 66, 7, 28, 11, 116, 52, 110, 87}), String.class, "com.obric.aiagent.plugin"));
            f39616c = r6;
            f39617d = new b[]{r0, r1, r4, r6, new b(4, 4, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "c5289d", new byte[]{68, 22, 109, 121, 35, 76, 67, 57, 71, 87, 87, 25, 101}), String.class, "com.obric.aiagent.plugin"))};
        }
    }

    public interface c {
    }

    static {
        String r0 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "676b8c", new byte[]{3, 44, 104, 5, 0, 69, 32, 19, 114, 55}), String.class, "com.obric.aiagent.plugin");
        f39609b = null;
    }

    private t() {
        HandlerThread r0 = new HandlerThread((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "b8ec6a", new byte[]{87, 35, 59, 4, 14, 71, 116, 28, 33, 54}), String.class, "com.obric.aiagent.plugin"));
        this.f39612d = r0;
        r0.start();
        this.f39611c = new a(this, this.f39612d.getLooper());
    }

    public static t a() {
        if (f39609b != null) goto L15;
        monitor-enter(t.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f39609b != null) goto L9;
        f39609b = new t();     // Catch: Throwable -> L11
    L9:
        monitor-exit(t.class);     // Catch: Throwable -> L11
    L15:
        return f39609b;
    }

    public final void a(c r3) {
        this.f39610a = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
    }

    public final boolean a(b r3, String r4) {
        Handler r0 = this.f39611c;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r3 != b.f39616c) goto L8;
        r0.removeMessages(r3.b());
        return true;
    L8:
        Message r1 = new Message();
        r1.what = r3.ordinal();
        r1.obj = r4;
        return this.f39611c.sendMessage(r1);
    }
}
