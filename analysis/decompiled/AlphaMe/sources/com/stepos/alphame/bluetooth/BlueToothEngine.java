package com.stepos.alphame.bluetooth;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.NotProguard;
import com.stepos.alphame.engine.EngineBase;
import com.stepos.alphame.engine.EngineFunc;
import com.stepos.alphame.manager.ActionManager;
import com.stepos.alphame.utils.AlphaMeLogger;
import com.stepos.alphame.utils.LocalConsts;
import com.stepos.alphame.utils.Property;
import com.stepos.alphame.utils.ReceiverUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class BlueToothEngine extends EngineBase {
    private static final int AUTO = 0;
    private static final int AUTO_AND_CHOSEN = 2;
    private static final int CHOSEN = 1;

    @SuppressLint({"StaticFieldLeak"})
    private static BlueToothEngine sInstance;
    private final Context mContext;
    private HashMap<String, BluetoothDevice> mDevices = new HashMap<>();
    private BroadcastReceiver mReceiver = new BroadcastReceiver() { // from class: com.stepos.alphame.bluetooth.BlueToothEngine.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            action.getClass();
            if (action.equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                if (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 0) != 10) {
                    return;
                }
                Iterator it = BlueToothEngine.this.mDevices.values().iterator();
                while (it.hasNext()) {
                    BlueToothEngine.this.broadcast((BluetoothDevice) it.next(), false);
                }
                BlueToothEngine.this.mDevices.clear();
                return;
            }
            if (action.equals("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED")) {
                int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", -1);
                BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if (bluetoothDevice == null) {
                    return;
                }
                if (intExtra == 0) {
                    if (BlueToothEngine.this.mDevices.containsKey(bluetoothDevice.getAddress())) {
                        BlueToothEngine.this.mDevices.remove(bluetoothDevice.getAddress());
                        BlueToothEngine.this.broadcast(bluetoothDevice, false);
                        return;
                    }
                    return;
                }
                if (intExtra == 2) {
                    if (BlueToothEngine.this.mDevices.containsKey(bluetoothDevice.getAddress())) {
                        return;
                    }
                    BlueToothEngine.this.mDevices.put(bluetoothDevice.getAddress(), bluetoothDevice);
                    BlueToothEngine.this.broadcast(bluetoothDevice, true);
                    return;
                }
                if (intExtra == 3 && BlueToothEngine.this.mDevices.containsKey(bluetoothDevice.getAddress())) {
                    BlueToothEngine.this.mDevices.remove(bluetoothDevice.getAddress());
                    BlueToothEngine.this.broadcast(bluetoothDevice, false);
                }
            }
        }
    };

    public class ChooseVehicleBluetooth extends EngineFunc {
        public ChooseVehicleBluetooth(EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_CHOOSE_VEHICLE_BLUETOOTH;
            this.argsType = new byte[]{6};
            this.argsName = new String[]{"macAddress"};
            this.returnType = (byte) 0;
            this.annotation = new String[]{"保存用户选择的车载蓝牙", "@param 蓝牙的物理地址", "@author lxh", "@return 无"};
        }
    }

    public class GetVehicleBluetoothInfo extends EngineFunc {
        public GetVehicleBluetoothInfo(EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_GET_VEHICLE_BLUETOOTH_INFO;
            this.argsType = new byte[]{2};
            this.argsName = new String[]{"useChosen"};
            this.returnType = (byte) 9;
            this.annotation = new String[]{"返回车载蓝牙信息", "@author lxh", "@return 类型为String[] 其中", "        [0]蓝牙名称", "        [1]地址", "        [2]上车时间", "        [3]上车位置坐标", "        [4]上车位置地址", "        [5]下车时间", "        [6]下车位置坐标", "        [7]下车位置地址"};
        }
    }

    public class GetVehicleBluetoothes extends EngineFunc {
        public GetVehicleBluetoothes(EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_GET_VEHICLE_BLUETOOTHES;
            this.argsType = new byte[]{0};
            this.argsName = new String[]{""};
            this.returnType = (byte) 12;
            this.annotation = new String[]{"返回车载蓝牙信息", "@author lxh", "@return 返回全部车载蓝牙的信息 格式为", "'蓝牙地址1, 是否手动设置(0 自动,1 手动,2 自动且手动), 上次连接时间', '蓝牙地址2, 是否手动设置, 上次连接时间'"};
        }
    }

    public class GetVehicles extends EngineFunc {
        public GetVehicles(EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_GET_VEHICLES;
            this.argsType = new byte[]{0};
            this.argsName = new String[]{""};
            this.returnType = (byte) 12;
            this.annotation = new String[]{"返回车载蓝牙信息", "@author lxh", "@return 返回全部车载蓝牙的信息 每个蓝牙信息占四个位置格式为", "[0] 蓝牙名称1[1]蓝牙地址1[2]是否手动设置(0 自动,1 手动,2 自动且手动)[3]上次连接时间[4]蓝牙名称2[5]蓝牙地址2[6]是否手动设置[7]上次连接时间。。。。。。"};
        }
    }

    private BlueToothEngine(Context context) {
        this.mContext = context;
        EngineBase.addFunc(new GetVehicleBluetoothInfo(this));
        EngineBase.addFunc(new ChooseVehicleBluetooth(this));
        EngineBase.addFunc(new GetVehicleBluetoothes(this));
        EngineBase.addFunc(new GetVehicles(this));
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        ReceiverUtils.registerReceiverExported(context, this.mReceiver, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void broadcast(BluetoothDevice bluetoothDevice, boolean z4) {
        ActionManager actionManager = ActionManager.getInstance();
        String[] strArr = new String[4];
        strArr[0] = String.valueOf(z4 ? 1 : 0);
        strArr[1] = bluetoothDevice.getName();
        strArr[2] = bluetoothDevice.getAddress();
        strArr[3] = VehicleBluetoothManager.getInstance(this.mContext).isVehicle(bluetoothDevice) ? "1" : "0";
        actionManager.broadcast(LocalConsts.ACTION_BLUETOOTH_CHANGED, strArr);
    }

    public static BlueToothEngine getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new BlueToothEngine(context);
        }
        return sInstance;
    }

    private String getVehicleStr(BluetoothRecord bluetoothRecord, int i4) {
        return bluetoothRecord.getAddress() + "," + i4 + "," + bluetoothRecord.getStartTime();
    }

    @NotProguard
    public void chooseVehicleBluetooth(String str) {
        Property.setChosenVehicleBluetooth(str);
    }

    public Set<String> getConnectedDevices() {
        return this.mDevices.keySet();
    }

    @NotProguard
    public String[] getVehicleBluetoothInfo(boolean z4) {
        BluetoothRecord lastVehicle;
        if (z4) {
            String chosenVehicleBluetooth = Property.getChosenVehicleBluetooth(this.mContext.getContentResolver());
            lastVehicle = !TextUtils.isEmpty(chosenVehicleBluetooth) ? VehicleBluetoothManager.getInstance(ApplicationImpl.getApplication()).getLastChosenVehicle(chosenVehicleBluetooth) : null;
        } else {
            lastVehicle = VehicleBluetoothManager.getInstance(ApplicationImpl.getApplication()).getLastVehicle();
        }
        if (lastVehicle != null) {
            return new String[]{lastVehicle.getName(), lastVehicle.getAddress(), String.valueOf(lastVehicle.getStartTime()), lastVehicle.getStartLocation(), lastVehicle.getStartAddress(), String.valueOf(lastVehicle.getParkingTime()), lastVehicle.getParkingLocation(), lastVehicle.getParkingAddress()};
        }
        return null;
    }

    @NotProguard
    @Deprecated
    public List<String> getVehicleBluetoothes() {
        BluetoothRecord byAddress;
        ArrayList arrayList = new ArrayList();
        String chosenVehicleBluetooth = Property.getChosenVehicleBluetooth(this.mContext.getContentResolver());
        List<BluetoothRecord> allVehicle = VehicleBluetoothManager.getInstance(ApplicationImpl.getApplication()).getAllVehicle();
        if (TextUtils.isEmpty(chosenVehicleBluetooth)) {
            byAddress = null;
        } else {
            byAddress = VehicleBluetoothManager.getInstance(ApplicationImpl.getApplication()).getByAddress(chosenVehicleBluetooth);
            if (byAddress == null) {
                byAddress = new BluetoothRecord();
                byAddress.setAddress(chosenVehicleBluetooth);
                for (BluetoothDevice bluetoothDevice : BluetoothAdapter.getDefaultAdapter().getBondedDevices()) {
                    if (chosenVehicleBluetooth.equals(bluetoothDevice.getAddress())) {
                        byAddress.setName(bluetoothDevice.getName());
                    }
                }
            }
        }
        for (BluetoothRecord bluetoothRecord : allVehicle) {
            arrayList.add(getVehicleStr(bluetoothRecord, TextUtils.equals(bluetoothRecord.getAddress(), chosenVehicleBluetooth) ? 2 : 0));
        }
        if (byAddress != null && !allVehicle.contains(byAddress)) {
            arrayList.add(getVehicleStr(byAddress, 1));
        }
        return arrayList;
    }

    @NotProguard
    public List<String> getVehicles() {
        BluetoothRecord byAddress;
        ArrayList arrayList = new ArrayList();
        String chosenVehicleBluetooth = Property.getChosenVehicleBluetooth(this.mContext.getContentResolver());
        List<BluetoothRecord> allVehicle = VehicleBluetoothManager.getInstance(ApplicationImpl.getApplication()).getAllVehicle();
        if (TextUtils.isEmpty(chosenVehicleBluetooth)) {
            byAddress = null;
        } else {
            byAddress = VehicleBluetoothManager.getInstance(ApplicationImpl.getApplication()).getByAddress(chosenVehicleBluetooth);
            if (byAddress == null) {
                byAddress = new BluetoothRecord();
                byAddress.setAddress(chosenVehicleBluetooth);
                for (BluetoothDevice bluetoothDevice : BluetoothAdapter.getDefaultAdapter().getBondedDevices()) {
                    AlphaMeLogger.debugLog("getBondedDevices " + bluetoothDevice.getAddress() + ", " + bluetoothDevice.getName());
                    if (chosenVehicleBluetooth.equals(bluetoothDevice.getAddress())) {
                        byAddress.setName(bluetoothDevice.getName());
                    }
                }
            }
        }
        for (BluetoothRecord bluetoothRecord : allVehicle) {
            boolean zEquals = TextUtils.equals(bluetoothRecord.getAddress(), chosenVehicleBluetooth);
            arrayList.add(bluetoothRecord.getAddress());
            arrayList.add(bluetoothRecord.getName());
            arrayList.add(String.valueOf(zEquals ? 2 : 0));
            arrayList.add(String.valueOf(bluetoothRecord.getStartTime()));
        }
        if (byAddress != null && !allVehicle.contains(byAddress)) {
            arrayList.add(byAddress.getAddress());
            arrayList.add(byAddress.getName());
            arrayList.add(String.valueOf(1));
            arrayList.add(String.valueOf(byAddress.getStartTime()));
        }
        return arrayList;
    }

    @Override // com.stepos.alphame.engine.EngineBase
    public void onStart() {
        super.onStart();
    }

    @Override // com.stepos.alphame.engine.EngineBase
    public void onStop() {
        super.onStop();
        this.mContext.unregisterReceiver(this.mReceiver);
    }
}
