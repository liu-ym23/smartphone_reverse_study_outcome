package ms.bd.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class z implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IBinder f39684a;

    public z(IBinder r3) {
        this.f39684a = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
    }

    public final String a() {
        Parcel r1 = Parcel.obtain();
        Parcel r2 = Parcel.obtain();
        r1.writeInterfaceToken((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "350312", new byte[]{33, 56, 78, 9, 27, 42, 52, 29, 114, 45, 45, 39, 70, 73, 10, 32, 38, 29, 98, 102, 108, 54, 74, 67, 2, 107, 31, 4, 100, 109, 6, 50, 85, 78, 13, 32, 25, 16, 100, 109, 54, 62, 69, 78, 11, 55, 3, 17, 115, 117, 43, 52, 70}), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L5
        this.f39684a.transact(1, r1, r2, 0);     // Catch: Throwable -> L5
        r2.readException();     // Catch: Throwable -> L5
        String r0 = r2.readString();     // Catch: Throwable -> L5
    L7:
        r1.recycle();
        r2.recycle();
        return r0;
    L5:
        th = move-exception;
        r1.recycle();
        r2.recycle();
        th.printStackTrace();
        r0 = null;
        goto L7
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f39684a;
    }
}
