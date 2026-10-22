package ms.bd.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class m implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IBinder f39551a;

    public m(IBinder r3) {
        this.f39551a = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
    }

    public final String a() {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "80464a", new byte[]{42, 61, 74, 12, 9, 99, 53, 95, 105, 111, 43, 124, 106, 81, 10, 95, 63, 56, 107, 114, 44, 32, 65, 67, 8, 115}), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L5
        this.f39551a.transact(3, r0, r1, 0);     // Catch: Throwable -> L5
        r1.readException();     // Catch: Throwable -> L5
        String r12 = r1.readString();     // Catch: Throwable -> L5
    L6:
        r1.recycle();
        r0.recycle();
        return r12;
    L5:
        r1.recycle();
        r0.recycle();
        r12 = null;
        goto L6
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f39551a;
    }
}
