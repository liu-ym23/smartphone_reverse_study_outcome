package ms.bd.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IBinder f39452a;

    public b(IBinder r3) {
        this.f39452a = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
    }

    public final String a() {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "dfca36", new byte[]{118, 107, 29, 91, 13, 50, 114, 84, 124, 60, 102, 101, 94, 38, 25, 49, 119, 75, 55, 60, 112, 106, 4, 20, 30, 56, 67, 110, 22, 127, 92, 64, 25, 17, 45, 40, 99, 75, 27, 63, 97, 97, 2, 19, 13, 34, 98}), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L5
        this.f39452a.transact(3, r0, r1, 0);     // Catch: Throwable -> L5
        r1.readException();     // Catch: Throwable -> L5
        String r2 = r1.readString();     // Catch: Throwable -> L5
    L6:
        r0.recycle();
        r1.recycle();
        return r2;
    L5:
        r0.recycle();
        r1.recycle();
        r2 = null;
        goto L6
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f39452a;
    }
}
