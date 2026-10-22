package z1;

import F1.q;
import android.content.Context;
import android.net.ConnectivityManager;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import z1.InterfaceC6056f;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroid/content/Context;", "context", "Lz1/f$a;", "listener", "LF1/q;", "logger", "Lz1/f;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Lz1/f$a;LF1/q;)Lz1/f;", "coil-base_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class g {
    public static final InterfaceC6056f a(Context context, InterfaceC6056f.a aVar, q qVar) {
        ConnectivityManager connectivityManager = (ConnectivityManager) androidx.core.content.a.i(context, ConnectivityManager.class);
        if (connectivityManager == null || !F1.d.e(context, "android.permission.ACCESS_NETWORK_STATE")) {
            if (qVar != null && qVar.getLevel() <= 5) {
                qVar.a("NetworkObserver", 5, "Unable to register network observer.", null);
            }
            return new C6055e();
        }
        try {
            return new h(connectivityManager, aVar);
        } catch (Exception e10) {
            if (qVar != null) {
                F1.g.a(qVar, "NetworkObserver", new RuntimeException("Failed to register network observer.", e10));
            }
            return new C6055e();
        }
    }
}
