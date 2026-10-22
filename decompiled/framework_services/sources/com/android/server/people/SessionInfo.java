package com.android.server.people;

import android.app.prediction.AppPredictionContext;
import android.app.prediction.AppTarget;
import android.app.prediction.IPredictionCallback;
import android.content.Context;
import android.content.pm.ParceledListSlice;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Slog;
import com.android.server.people.data.DataManager;
import com.android.server.people.prediction.AppTargetPredictor;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class SessionInfo {
    private static final String TAG = "SessionInfo";
    private final AppTargetPredictor mAppTargetPredictor;
    private final RemoteCallbackList<IPredictionCallback> mCallbacks;

    public static /* synthetic */ void $r8$lambda$sHp6Z6lzwX0x2Cp_Vv4tKZWK4qc(SessionInfo r0, List r1) {
        r0.updatePredictions(r1);
    }

    SessionInfo(AppPredictionContext predictionContext, DataManager dataManager, int callingUserId, Context context) {
        this.mCallbacks = new RemoteCallbackList();
        this.mAppTargetPredictor = AppTargetPredictor.create(predictionContext, new SessionInfo$$ExternalSyntheticLambda0(this), dataManager, callingUserId, context);
    }

    void addCallback(IPredictionCallback callback) {
        this.mCallbacks.register(callback);
    }

    void removeCallback(IPredictionCallback callback) {
        this.mCallbacks.unregister(callback);
    }

    AppTargetPredictor getPredictor() {
        return this.mAppTargetPredictor;
    }

    void onDestroy() {
        this.mCallbacks.kill();
    }

    private void updatePredictions(List<AppTarget> targets) {
        int callbackCount = this.mCallbacks.beginBroadcast();
        int i = 0;
    L3:
        if (i >= callbackCount) goto L9;
        this.mCallbacks.getBroadcastItem(i).onResult(new ParceledListSlice(targets));     // Catch: RemoteException -> L6
    L8:
        i = i + 1;
    L6:
        e = move-exception;
        Slog.e(TAG, "Failed to calling callback" + e);
        goto L8
    L9:
        this.mCallbacks.finishBroadcast();
    }
}
