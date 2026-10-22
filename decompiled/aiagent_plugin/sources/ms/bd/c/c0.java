package ms.bd.c;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public abstract class c0 extends Binder implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f39465a = null;

    static {
        f39465a = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "24b211", new byte[]{32, 57, 28, 8, 6, 47, 57, 26, 61, 109, 49, 120, 18, 74, 1, 51, 53, 6, 54, 112, 53, 63, 18, 67, 64, 41, 48, 28, 55, 44, 10, 25, 48, 111, 42, 5, 48, 25, 63, 64, 34, 53, 26}), String.class, "com.obric.aiagent.plugin");
    }

    public c0() {
        attachInterface(this, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "5402c1", new byte[]{39, 57, 78, 8, 84, 47, 62, 26, 111, 109, 54, 120, 64, 74, 83, 51, 50, 6, 100, 112, 50, 63, 64, 67, 18, 41, 55, 28, 101, 44, 13, 25, 98, 111, 120, 5, 55, 25, 109, 64, 37, 53, 72}), String.class, "com.obric.aiagent.plugin"));
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
        String r0 = f39465a;
        if (r4 != 1) goto L5;
        r5.enforceInterface(r0);
        r5.readInt();
        r5.readLong();
        r5.readInt();
        r5.readFloat();
        r5.readDouble();
        r5.readString();
    L17:
        r6.writeNoException();
        return true;
    L5:
        if (r4 != 2) goto L7;
        r5.enforceInterface(r0);
        int r8 = r5.readInt();
        if (r5.readInt() == 0) goto L15;
        Bundle r9 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r5), Bundle.class, "com.obric.aiagent.plugin");
    L16:
        ((b0.b) ZeusTransformUtils.preCheckCast(this, b0.b.class, "com.obric.aiagent.plugin")).a(r8, r9);
        goto L17
    L15:
        r9 = null;
        goto L16
    L7:
        if (r4 != 1598968902) goto L9;
        r6.writeString(r0);
        return true;
    L9:
        return super.onTransact(r4, r5, r6, r7);
    }
}
