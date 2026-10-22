package com.amap.api.maps.model;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes28.dex */
public final class RuntimeRemoteException extends RuntimeException {
    private static final long serialVersionUID = -3541841807100437802L;

    public RuntimeRemoteException(RemoteException r100) {
        super(r100);
    }

    public RuntimeRemoteException(String r100) {
        super(r100);
    }
}
