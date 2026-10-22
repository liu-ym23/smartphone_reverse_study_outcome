package vendor.bytedance.hardware.ahm;

import android.os.IBinder;

/* JADX INFO: compiled from: AHMIDLExt.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface IAHMIDLSPI extends IAHMIDL {
    public static final a Companion = null;
    public static final String TAG = "IAHMIDLSPI";

    /* JADX INFO: compiled from: AHMIDLExt.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f40705a = null;

        static {
            f40705a = new a();
        }

        private a() {
        }
    }

    static {
        Companion = a.f40705a;
    }

    @Override // android.os.IInterface
    IBinder asBinder();
}
