package ms.bd.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class p1 implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IBinder f39584a;

    public p1(IBinder r3) {
        this.f39584a = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
    }

    public final String a() {
        Parcel r1 = Parcel.obtain();
        Parcel r2 = Parcel.obtain();
        r1.writeInterfaceToken((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "b57d6b", new byte[]{112, 56, 73, 94, 26, 116, 108, 7, 115, 58, 116, 121, 69, 30, 13, 103, 110, 29, 98, 122, 119, 50, 82, 25, 10, 112, 104, 16, 117, 49, 97, 33, 77, 19, 12, 59, 72, 48, 99, 34, 122, 52, 65, 57, 13, 70, 100, 6, 112, 61, 112, 50}), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L5
        this.f39584a.transact(1, r1, r2, 0);     // Catch: Throwable -> L5
        r2.readException();     // Catch: Throwable -> L5
        String r0 = r2.readString();     // Catch: Throwable -> L5
    L7:
        r2.recycle();
        r1.recycle();
        return r0;
    L5:
        th = move-exception;
        r2.recycle();
        r1.recycle();
        th.printStackTrace();
        r0 = null;
        goto L7
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f39584a;
    }
}
