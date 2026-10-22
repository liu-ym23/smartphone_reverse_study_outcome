package android.net;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.stepos.net.IStepOSNetworkBoostService;
import com.stepos.net.StepOSSockEntry;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class StepOSNetworkBoostManager {
    public static final String SERVICE_NAME = "stepos_network_boost";
    private static final String TAG = "StepOSNetworkBoostMgr";
    private final Context mContext;
    private final IStepOSNetworkBoostService mService;

    public StepOSNetworkBoostManager(Context context, IStepOSNetworkBoostService service) {
        this.mContext = context;
        this.mService = service;
    }

    public int destroyTcpUdpSocketsByOwnerUids(Set<Integer> ownerUids) {
        if (this.mService == null || ownerUids == null || ownerUids.isEmpty()) {
            return 0;
        }
        int[] arr = new int[ownerUids.size()];
        int i = 0;
        for (Integer uid : ownerUids) {
            arr[i] = uid.intValue();
            i++;
        }
        try {
            return this.mService.destroyTcpUdpSocketsByOwnerUids(arr);
        } catch (RemoteException e) {
            Log.e(TAG, "destroyTcpUdpSocketsByOwnerUids failed", e);
            return 0;
        }
    }

    public int destroySocketsByPids(Set<Integer> pids) {
        if (this.mService == null || pids == null || pids.isEmpty()) {
            return 0;
        }
        int[] arr = new int[pids.size()];
        int i = 0;
        for (Integer pid : pids) {
            arr[i] = pid.intValue();
            i++;
        }
        try {
            return this.mService.destroySocketsByPids(arr);
        } catch (RemoteException e) {
            Log.e(TAG, "destroySocketsByPids failed", e);
            return 0;
        }
    }

    public List<StepOSSockEntry> querySocketsByPids(Set<Integer> pids) {
        if (this.mService == null || pids == null || pids.isEmpty()) {
            return Collections.emptyList();
        }
        int[] arr = new int[pids.size()];
        int i = 0;
        for (Integer pid : pids) {
            arr[i] = pid.intValue();
            i++;
        }
        try {
            return this.mService.querySocketsByPids(arr);
        } catch (RemoteException e) {
            Log.e(TAG, "querySocketsByPids failed", e);
            return Collections.emptyList();
        }
    }
}
