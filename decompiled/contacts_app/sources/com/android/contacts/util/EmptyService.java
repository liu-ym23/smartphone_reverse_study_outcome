package com.android.contacts.util;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: loaded from: classes2.dex */
public class EmptyService extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent r1) {
        return null;
    }

    public EmptyService() {
    }
}
