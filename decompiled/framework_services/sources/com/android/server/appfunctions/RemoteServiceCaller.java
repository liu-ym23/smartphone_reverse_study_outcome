package com.android.server.appfunctions;

import android.content.Intent;
import android.os.CancellationSignal;
import android.os.IBinder;
import android.os.UserHandle;

/* JADX INFO: loaded from: classes.dex */
public interface RemoteServiceCaller<T> {

    public interface RunServiceCallCallback<T> {
        void onCancelled();

        void onFailedToConnect();

        void onServiceConnected(T r1, ServiceUsageCompleteListener r2);
    }

    public interface ServiceUsageCompleteListener {
        void onCompleted();
    }

    boolean runServiceCall(Intent r1, int r2, UserHandle r3, long r4, CancellationSignal r6, RunServiceCallCallback<T> r7, IBinder r8);
}
