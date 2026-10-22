package os.teatracker;

import android.net.Uri;

/* JADX INFO: compiled from: TeaConst.java */
/* JADX INFO: loaded from: classes5.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Uri f40696a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Uri f40697b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Uri f40698c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Uri f40699d = null;

    static {
        Uri r0 = Uri.parse("content://os.teatracker");
        f40696a = r0;
        f40697b = Uri.parse("content://com.obric.idprovider");
        f40698c = Uri.parse("content://os.teatracker/event_data");
        f40699d = Uri.parse(r0 + "/getDeviceId");
    }
}
