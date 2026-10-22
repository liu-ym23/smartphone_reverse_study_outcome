package com.stepos.alphame.engine;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.stepos.common.alphame.AlphaMeClientNative;
import com.stepos.common.alphame.IAlphaMeClient;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class AppClient {
    public static final int FLAG_BROADCAST_EXACTLY_GAME_INFO = 1;
    private static final String TAG = "AlphaMe";
    public IAlphaMeClient client;
    private IBinder.DeathRecipient deathRecipient;
    public int flag;
    public int pid;
    public final ArrayList<ReceiverList> receivers = new ArrayList<>();
    public boolean active = true;

    public AppClient(IBinder iBinder, int i4) {
        this.pid = i4;
        this.client = AlphaMeClientNative.asInterface(iBinder);
    }

    public void linkToDeath(IBinder.DeathRecipient deathRecipient) throws RemoteException {
        IAlphaMeClient iAlphaMeClient = this.client;
        if (iAlphaMeClient == null || this.deathRecipient != null) {
            return;
        }
        try {
            this.deathRecipient = deathRecipient;
            iAlphaMeClient.asBinder().linkToDeath(this.deathRecipient, 0);
        } catch (RemoteException e4) {
            Log.e(TAG, "linkToDeath fail " + e4);
        }
    }

    public void unlinkDeathRecipient() {
        IAlphaMeClient iAlphaMeClient;
        if (this.deathRecipient != null && (iAlphaMeClient = this.client) != null) {
            iAlphaMeClient.asBinder().unlinkToDeath(this.deathRecipient, 0);
        }
        this.deathRecipient = null;
    }
}
