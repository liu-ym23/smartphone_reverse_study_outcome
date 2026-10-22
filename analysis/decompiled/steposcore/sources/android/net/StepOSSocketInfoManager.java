package android.net;

import android.content.Context;
import android.os.RemoteException;
import com.stepos.net.IStepOSSocketInfoService;
import com.stepos.net.StepOSSocketInfo;
import java.util.List;

/* loaded from: classes.dex */
public class StepOSSocketInfoManager {
    private final Context mContext;
    private final IStepOSSocketInfoService mService;

    public StepOSSocketInfoManager(Context context, IStepOSSocketInfoService service) {
        this.mContext = context;
        this.mService = service;
    }

    public List<StepOSSocketInfo> getTcpSocketInfos(Network network) {
        try {
            return this.mService.getTcpSocketInfos(network);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }
}
