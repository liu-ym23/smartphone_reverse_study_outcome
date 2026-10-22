package ms.bd.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.MessageDigest;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes4.dex */
public final class d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ServiceConnection f39475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f39476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f39477c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private e1 f39478d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final CountDownLatch f39479e;

    final class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d1 f39480a;

        a(d1 r1) {
            this.f39480a = r1;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r2, IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            d1.a(this.f39480a, new e1(r4));
            d1.a(this.f39480a).countDown();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r2) {
            d1.a(this.f39480a, null);
            d1.a(this.f39480a).countDown();
        }
    }

    public d1(Context r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        String r0 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "018b3d", new byte[]{14, 6, 98, 50}), String.class, "com.obric.aiagent.plugin");
        this.f39475a = new a(this);
        this.f39476b = ZeusTransformUtils.wrapperContext(r10, "com.obric.aiagent.plugin");
        this.f39479e = new CountDownLatch(1);
    }

    static /* synthetic */ CountDownLatch a(d1 r0) {
        return r0.f39479e;
    }

    static /* synthetic */ void a(d1 r0, e1 r1) {
        r0.f39478d = r1;
    }

    public final void a(p.a r14) {
        p.a r15 = (p.a) ZeusTransformUtils.wrapperContextForParams(r14, p.a.class, "com.obric.aiagent.plugin");
        if (c1.a(this.f39476b, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "0c8ec0", new byte[]{34, 110, 70, 95, 84, 34, 42, 86, 104, 37, 111, 110, 91, 20, 82, 46, 55}), String.class, "com.obric.aiagent.plugin")) == true) goto L6;
        return;
    L6:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L30;
        Intent r0 = new Intent();
        r0.setComponent(new ComponentName((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "052069", new byte[]{34, 56, 76, 10, 1, 43, 42, 0, 98, 112, 111, 56, 81, 65, 7, 39, 55}), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "061275", new byte[]{34, 59, 79, 8, 0, 39, 42, 3, 97, 114, 111, 59, 82, 67, 6, 43, 55, 89, 73, 102, 36, 58, 86, 79, 14, 59, 0, 18, 114, 116, 40, 55, 71}), String.class, "com.obric.aiagent.plugin")));
        r0.setAction((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "d1fe86", new byte[]{116, 48, 1, 24, 8, 47, 41, 19, 56, 56, 59, 59, 16, 8, 19, 32, 119, 94, 56, 37, 112, 61, 28, 21, 73, 14, 87, 53, 25, 10, 92, 23, 42, 34, 34, 19, 81, 57, 20, 16}), String.class, "com.obric.aiagent.plugin"));
        boolean r3 = false;
        if (ZeusTransformUtils.bindService(this.f39476b, r0, this.f39475a, 1, "com.obric.aiagent.plugin") == true) goto L35;
    L17:
        if (r3 == false) goto L37;
    L23:
        ZeusTransformUtils.unbindService(this.f39476b, this.f39475a, "com.obric.aiagent.plugin");
        return;
    L37:
        return;
    L35:
        this.f39479e.await();     // Catch: Throwable -> L16
        e1 r1 = this.f39478d;     // Catch: Throwable -> L16
        if (r1 == null) goto L15;
        String r2 = a(r1, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "4662e2", new byte[]{10, 1, 108, 98}), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L16
        if (r15 == null) goto L15;
        r15.a(r2);     // Catch: Throwable -> L16
    L15:
        r3 = true;
    L16:
        boolean r16 = true;
    L33:
        String r4 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "1d71ee", new byte[]{47, 118}), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r16 == true) goto L23;
        return;
    L25:
        th = move-exception;
        if (r16 == false) goto L28;
        ZeusTransformUtils.unbindService(this.f39476b, this.f39475a, "com.obric.aiagent.plugin");
    L28:
        throw th;
    L19:
        r16 = false;
        goto L33
    L30:
        throw new IllegalStateException((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "b3e1fe", new byte[]{80, 48, 24, 75, 86, 102, 33, 0, 33, 111, 51, 62, 24, 5, 116, 115, 104, 28, 0, 105, 97, 52, 23, 65}), String.class, "com.obric.aiagent.plugin"));
    }

    private String a(e1 r19, String r20) {
        String r1 = this.f39476b.getPackageName();
        if (this.f39477c == null) goto L38;
    L20:
        String r0 = this.f39477c;
        r19.getClass();
        Parcel r2 = Parcel.obtain();
        Parcel r7 = Parcel.obtain();
        r2.writeInterfaceToken((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "e00bb5", new byte[]{119, 61, 78, 88, 85, 39, 127, 5, 96, 34, 58, 61, 83, 19, 83, 43, 98, 95, 72, 29, 100, 55, 77, 63, 121}), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L23 Exception -> L25
        r2.writeString(r1);     // Catch: Throwable -> L23 Exception -> L25
        r2.writeString(r0);     // Catch: Throwable -> L23 Exception -> L25
        r2.writeString(r20);     // Catch: Throwable -> L23 Exception -> L25
        r19.f39491a.transact(1, r2, r7, 0);     // Catch: Throwable -> L23 Exception -> L25
        r7.readException();     // Catch: Throwable -> L23 Exception -> L25
        String r3 = r7.readString();     // Catch: Throwable -> L23 Exception -> L25
    L28:
        r2.recycle();
        r7.recycle();
        return r3;
    L23:
        th = move-exception;
        r2.recycle();
        r7.recycle();
        throw th;
    L26:
        String r4 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "03d197", new byte[]{46, 33, 30}), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L23
        r3 = null;
        goto L28
    L38:
        Signature[] r5 = this.f39476b.getPackageManager().getPackageInfo(r1, 64).signatures;     // Catch: Exception -> L6
    L7:
        if (r5 != null) goto L9;
    L18:
        String r6 = null;
    L19:
        this.f39477c = r6;
        goto L20
    L9:
        if (r5.length <= 0) goto L18;
        byte[] r8 = r5[0].toByteArray();
        MessageDigest r9 = MessageDigest.getInstance((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "91c449", new byte[]{27, 27, 49, 17}), String.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L32
        if (r9 == null) goto L18;
        byte[] r10 = r9.digest(r8);     // Catch: Exception -> L32
        StringBuilder r11 = new StringBuilder();     // Catch: Exception -> L32
        int r12 = r10.length;     // Catch: Exception -> L32
        int r13 = 0;
    L14:
        if (r13 >= r12) goto L16;
        r11.append(Integer.toHexString((r10[r13] & 255) | 256).substring(1, 3));     // Catch: Exception -> L32
        r13 = r13 + 1;     // Catch: Exception -> L32
        goto L14
    L16:
        r6 = r11.toString();     // Catch: Exception -> L32
    L6:
        r5 = null;
        goto L7
    }
}
