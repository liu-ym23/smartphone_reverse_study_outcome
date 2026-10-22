package w2;

import android.os.RemoteException;
import com.stepos.digitalwellbeing.server.data.WhitelistAppInfo;
import f2.C0702g;

/* loaded from: classes.dex */
public class o1 extends W0 implements V0 {
    public o1(v2.e eVar) {
        super(eVar);
        C0702g.b("USALF11LP", "UsageStatsAndLimitF11LocalProxy() proxyImpl = " + eVar);
    }

    public int U(WhitelistAppInfo whitelistAppInfo) {
        try {
            S().addWhitelistApp(whitelistAppInfo);
            return 0;
        } catch (RemoteException e6) {
            e6.printStackTrace();
            return -1;
        }
    }

    public int V(long j5) {
        try {
            S().clearAdminLimit(j5);
            return 0;
        } catch (RemoteException e6) {
            e6.printStackTrace();
            return 0;
        }
    }

    public int W(WhitelistAppInfo whitelistAppInfo) {
        try {
            S().removeWhitelistApp(whitelistAppInfo);
            return 0;
        } catch (RemoteException e6) {
            e6.printStackTrace();
            return -1;
        }
    }
}
