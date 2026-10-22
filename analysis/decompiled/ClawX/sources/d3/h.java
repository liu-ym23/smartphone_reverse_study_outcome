package d3;

import android.content.Context;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Process;
import com.stepos.stepclaw.SecurePrefs;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class h extends Binder implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f1806a;

    public h(Context context) {
        this.f1806a = context;
        attachInterface(this, "com.meizu.aiservice.api.client.IWorkerClientUser");
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i8, Parcel parcel, Parcel parcel2, int i9) {
        if (i8 >= 1 && i8 <= 16777215) {
            parcel.enforceInterface("com.meizu.aiservice.api.client.IWorkerClientUser");
        }
        if (i8 == 1598968902) {
            parcel2.writeString("com.meizu.aiservice.api.client.IWorkerClientUser");
            return true;
        }
        if (i8 == 1) {
            int iMyUid = Process.myUid();
            parcel2.writeNoException();
            parcel2.writeInt(iMyUid);
        } else if (i8 != 2) {
            Context context = this.f1806a;
            if (i8 == 3) {
                String packageName = context.getPackageName();
                parcel2.writeNoException();
                parcel2.writeString(packageName);
            } else if (i8 == 4) {
                String str = context.getApplicationInfo().processName;
                parcel2.writeNoException();
                parcel2.writeString(str);
            } else {
                if (i8 != 5) {
                    return super.onTransact(i8, parcel, parcel2, i9);
                }
                String str2 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID + ((Object) context.getApplicationInfo().loadLabel(context.getPackageManager()));
                parcel2.writeNoException();
                parcel2.writeString(str2);
            }
        } else {
            int iMyPid = Process.myPid();
            parcel2.writeNoException();
            parcel2.writeInt(iMyPid);
        }
        return true;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}
