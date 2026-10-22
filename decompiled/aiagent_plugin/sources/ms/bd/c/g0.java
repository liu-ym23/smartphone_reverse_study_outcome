package ms.bd.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class g0 implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IBinder f39501a;

    public g0(IBinder r3) {
        this.f39501a = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
    }

    public final String a() {
        Parcel r1 = Parcel.obtain();
        Parcel r2 = Parcel.obtain();
        r1.writeInterfaceToken((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "914843", new byte[]{43, 60, 74, 2, 17, 49, 51, 94, 97, 109, 62, 58, 68, 73, 2, 32, 41, 21, 119, 126, 33, 48, 66, 2, 34, 0, 63, 6, 108, 107, 45, 58, 67, 101, 5, 48, 63, 2, 99, 105, 43, 54}), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L6 Exception -> L8
        this.f39501a.transact(1, r1, r2, 0);     // Catch: Throwable -> L6 Exception -> L8
        r2.readException();     // Catch: Throwable -> L6 Exception -> L8
        String r0 = r2.readString();     // Catch: Throwable -> L6 Exception -> L8
        r2.recycle();
        r1.recycle();
        return r0;
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L6
        r2.recycle();
        r1.recycle();
        return null;
    L6:
        th = move-exception;
        r2.recycle();
        r1.recycle();
        throw th;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return null;
    }
}
