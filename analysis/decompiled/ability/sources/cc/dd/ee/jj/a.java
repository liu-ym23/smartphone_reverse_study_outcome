package cc.dd.ee.jj;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.bytedance.apm6.traffic.TrafficTransportService;

/* loaded from: classes2.dex */
public interface a extends IInterface {
    void a(long j5, String str, String str2, String str3, String str4, String str5);

    void a(String str);

    void a(String str, String str2);

    void a(String str, boolean z10);

    void b(String str);

    void c(String str);

    /* renamed from: cc.dd.ee.jj.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0142a extends Binder implements a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f2140a = 0;

        public AbstractBinderC0142a() {
            attachInterface(this, "com.bytedance.apm6.traffic.ITrafficTransportInterface");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bytedance.apm6.traffic.ITrafficTransportInterface");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0143a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i6) {
            if (i == 1598968902) {
                parcel2.writeString("com.bytedance.apm6.traffic.ITrafficTransportInterface");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.bytedance.apm6.traffic.ITrafficTransportInterface");
                    ((TrafficTransportService.a) this).a(parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.bytedance.apm6.traffic.ITrafficTransportInterface");
                    ((TrafficTransportService.a) this).a(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.bytedance.apm6.traffic.ITrafficTransportInterface");
                    ((TrafficTransportService.a) this).b(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.bytedance.apm6.traffic.ITrafficTransportInterface");
                    ((TrafficTransportService.a) this).a(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.bytedance.apm6.traffic.ITrafficTransportInterface");
                    ((TrafficTransportService.a) this).c(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.bytedance.apm6.traffic.ITrafficTransportInterface");
                    ((TrafficTransportService.a) this).a(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i6);
            }
        }

        /* renamed from: cc.dd.ee.jj.a$a$a, reason: collision with other inner class name */
        public static class C0143a implements a {

            /* renamed from: a, reason: collision with root package name */
            public IBinder f2141a;

            public C0143a(IBinder iBinder) {
                this.f2141a = iBinder;
            }

            @Override // cc.dd.ee.jj.a
            public void a(String str, boolean z10) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.apm6.traffic.ITrafficTransportInterface");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    if (!this.f2141a.transact(1, parcelObtain, parcelObtain2, 0)) {
                        int i = AbstractBinderC0142a.f2140a;
                    }
                    parcelObtain2.readException();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2141a;
            }

            @Override // cc.dd.ee.jj.a
            public void b(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.apm6.traffic.ITrafficTransportInterface");
                    parcelObtain.writeString(str);
                    if (!this.f2141a.transact(3, parcelObtain, parcelObtain2, 0)) {
                        int i = AbstractBinderC0142a.f2140a;
                    }
                    parcelObtain2.readException();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // cc.dd.ee.jj.a
            public void c(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.apm6.traffic.ITrafficTransportInterface");
                    parcelObtain.writeString(str);
                    if (!this.f2141a.transact(5, parcelObtain, parcelObtain2, 0)) {
                        int i = AbstractBinderC0142a.f2140a;
                    }
                    parcelObtain2.readException();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // cc.dd.ee.jj.a
            public void a(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.apm6.traffic.ITrafficTransportInterface");
                    parcelObtain.writeString(str);
                    if (!this.f2141a.transact(2, parcelObtain, parcelObtain2, 0)) {
                        int i = AbstractBinderC0142a.f2140a;
                    }
                    parcelObtain2.readException();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // cc.dd.ee.jj.a
            public void a(long j5, String str, String str2, String str3, String str4, String str5) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.apm6.traffic.ITrafficTransportInterface");
                    parcelObtain.writeLong(j5);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    parcelObtain.writeString(str5);
                    if (!this.f2141a.transact(4, parcelObtain, parcelObtain2, 0)) {
                        int i = AbstractBinderC0142a.f2140a;
                    }
                    parcelObtain2.readException();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // cc.dd.ee.jj.a
            public void a(String str, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.apm6.traffic.ITrafficTransportInterface");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.f2141a.transact(6, parcelObtain, parcelObtain2, 0)) {
                        int i = AbstractBinderC0142a.f2140a;
                    }
                    parcelObtain2.readException();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }
        }
    }
}
