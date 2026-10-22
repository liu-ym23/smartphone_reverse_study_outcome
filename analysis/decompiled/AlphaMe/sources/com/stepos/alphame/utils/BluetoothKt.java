package com.stepos.alphame.utils;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.text.TextUtils;
import com.stepos.alphame.persona.carbluetooth.bean.BluetoothInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"getConnectedBtList", "", "Lcom/stepos/alphame/persona/carbluetooth/bean/BluetoothInfo;", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BluetoothKt {
    @NotNull
    public static final List<BluetoothInfo> getConnectedBtList() {
        Set<BluetoothDevice> bondedDevices = BluetoothAdapter.getDefaultAdapter().getBondedDevices();
        ArrayList arrayList = new ArrayList();
        for (BluetoothDevice bluetoothDevice : bondedDevices) {
            BluetoothInfo bluetoothInfo = new BluetoothInfo();
            AlphaMeLogger.debugLog("Personal", "bluetoothInfo " + bluetoothInfo);
            if (!TextUtils.isEmpty(bluetoothDevice.getName())) {
                String name = bluetoothDevice.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                bluetoothInfo.setBluetoothName(name);
            }
            if (!TextUtils.isEmpty(bluetoothDevice.getAddress())) {
                String address = bluetoothDevice.getAddress();
                Intrinsics.checkNotNullExpressionValue(address, "getAddress(...)");
                bluetoothInfo.setBluetoothAddress(address);
            }
            arrayList.add(bluetoothInfo);
        }
        return arrayList;
    }
}
