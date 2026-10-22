package vendor.bytedance.hardware.ahm;

import android.os.IBinder;

/* JADX INFO: compiled from: AHMCallbackIDLExt.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface IAHMCallbackIDLSPI extends IAHMCallbackIDL {
    public static final a Companion = null;
    public static final String TAG = "IAHMCallbackIDLSPI";

    /* JADX INFO: compiled from: AHMCallbackIDLExt.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f40704a = null;

        static {
            f40704a = new a();
        }

        private a() {
        }
    }

    static {
        Companion = a.f40704a;
    }

    @Override // android.os.IInterface
    IBinder asBinder();
}
