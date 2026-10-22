package com.android.server.companion.utils;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.ResultReceiver;

/* JADX INFO: loaded from: classes.dex */
public final class Utils {
    public static <T extends ResultReceiver> ResultReceiver prepareForIpc(T resultReceiver) {
        Parcel parcel = Parcel.obtain();
        resultReceiver.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ResultReceiver ipcFriendly = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        return ipcFriendly;
    }

    public static String btDeviceToString(BluetoothDevice btDevice) {
        StringBuilder sb = new StringBuilder(btDevice.getAddress());
        sb.append(" [name=");
        String name = btDevice.getName();
        if (name == null) goto L5;
        sb.append('\'');
        sb.append(name);
        sb.append('\'');
    L6:
        String alias = btDevice.getAlias();
        if (alias == null) goto L9;
        sb.append(", alias='");
        sb.append(alias);
        sb.append("'");
    L9:
        sb.append(']');
        return sb.toString();
    L5:
        sb.append("null");
        goto L6
    }

    private Utils() {
    }
}
