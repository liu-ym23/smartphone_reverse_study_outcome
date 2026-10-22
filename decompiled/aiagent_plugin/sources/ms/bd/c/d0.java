package ms.bd.c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public interface d0 extends IInterface {

    public static abstract class a extends Binder implements d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String f39472a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int f39473b = 0;

        /* JADX INFO: renamed from: ms.bd.c.d0$a$a, reason: collision with other inner class name */
        private static class C1063a implements d0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f39474a;

            C1063a(IBinder r3) {
                this.f39474a = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            }

            @Override // ms.bd.c.d0
            public final void a(b0.b r18) {
                Parcel r1 = Parcel.obtain();
                Parcel r2 = Parcel.obtain();
                r1.writeInterfaceToken((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "ee6aa3", new byte[]{119, 104, 72, 91, 86, 45, 110, 75, 105, 62, 102, 41, 70, 25, 81, 49, 98, 87, 98, 35, 98, 110, 70, 16, 16, 43, 103, 77, 99, 127, 93, 72, 100, 60, 122, 23, 99, 86, 113, 56, 119, 98}), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L9
                r1.writeStrongBinder(r18);     // Catch: Throwable -> L9
                if (this.f39474a.transact(2, r1, r2, 0) == true) goto L6;
                int r0 = a.f39473b;     // Catch: Throwable -> L9
            L6:
                r2.readException();     // Catch: Throwable -> L9
                r2.recycle();
                r1.recycle();
                return;
            L9:
                th = move-exception;
                r2.recycle();
                r1.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f39474a;
            }
        }

        static {
            f39472a = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "2331ea", new byte[]{32, 62, 77, 11, 82, 127, 57, 29, 108, 110, 49, 127, 67, 73, 85, 99, 53, 1, 103, 115, 53, 56, 67, 64, 20, 121, 48, 27, 102, 47, 10, 30, 97, 108, 126, 69, 52, 0, 116, 104, 32, 52}), String.class, "com.obric.aiagent.plugin");
        }

        public static d0 a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(f39472a);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, d0.class) == false) goto L13;
            return (d0) ZeusTransformUtils.preCheckCast(r0, d0.class, "com.obric.aiagent.plugin");
        L13:
            return new C1063a(r4);
        }
    }

    void a(b0.b r1);
}
