package com.stepos.alphame.bluetooth;

import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.os.ParcelUuid;
import android.util.Log;
import com.stepos.alphame.perfbinder.PerfBinderHelper;

/* loaded from: classes.dex */
public final class BluetoothDeviceFilter {
    static final ParcelUuid[] A2dpProfile_SINK_UUIDS;
    public static final Filter ALL_FILTER;
    public static final Filter BONDED_DEVICE_FILTER;
    public static final int BluetoothClass_PROFILE_A2DP = 1;
    public static final int BluetoothClass_PROFILE_HEADSET = 0;
    public static final int BluetoothClass_PROFILE_HID = 3;
    public static final int BluetoothClass_PROFILE_NAP = 5;
    public static final int BluetoothClass_PROFILE_OPP = 2;
    public static final int BluetoothClass_PROFILE_PANU = 4;
    private static final Filter[] FILTERS;
    public static final int FILTER_TYPE_AUDIO = 1;
    static final ParcelUuid[] HeadsetProfile_UUIDS;
    private static final String TAG = "BluetoothDeviceFilter";
    public static final Filter UNBONDED_DEVICE_FILTER;

    public static final class AllFilter implements Filter {
        private AllFilter() {
        }

        public /* synthetic */ AllFilter(int i4) {
            this();
        }

        @Override // com.stepos.alphame.bluetooth.BluetoothDeviceFilter.Filter
        public boolean matches(BluetoothDevice bluetoothDevice) {
            return true;
        }
    }

    public static final class AudioFilter extends ClassUuidFilter {
        public /* synthetic */ AudioFilter(int i4) {
            this();
        }

        @Override // com.stepos.alphame.bluetooth.BluetoothDeviceFilter.ClassUuidFilter
        public boolean matches(ParcelUuid[] parcelUuidArr, BluetoothClass bluetoothClass) {
            if (parcelUuidArr != null) {
                if (BluetoothUuid.containsAnyUuid(parcelUuidArr, BluetoothDeviceFilter.A2dpProfile_SINK_UUIDS) || BluetoothUuid.containsAnyUuid(parcelUuidArr, BluetoothDeviceFilter.HeadsetProfile_UUIDS)) {
                    return true;
                }
            } else if (bluetoothClass != null && (BluetoothDeviceFilter.doesClassMatch(bluetoothClass, 1) || BluetoothDeviceFilter.doesClassMatch(bluetoothClass, 0))) {
                return true;
            }
            return false;
        }

        private AudioFilter() {
            super(0);
        }
    }

    public static final class BondedDeviceFilter implements Filter {
        private BondedDeviceFilter() {
        }

        public /* synthetic */ BondedDeviceFilter(int i4) {
            this();
        }

        @Override // com.stepos.alphame.bluetooth.BluetoothDeviceFilter.Filter
        public boolean matches(BluetoothDevice bluetoothDevice) {
            return bluetoothDevice.getBondState() == 12;
        }
    }

    public static abstract class ClassUuidFilter implements Filter {
        private ClassUuidFilter() {
        }

        public /* synthetic */ ClassUuidFilter(int i4) {
            this();
        }

        @Override // com.stepos.alphame.bluetooth.BluetoothDeviceFilter.Filter
        public boolean matches(BluetoothDevice bluetoothDevice) {
            return matches(bluetoothDevice.getUuids(), bluetoothDevice.getBluetoothClass());
        }

        public abstract boolean matches(ParcelUuid[] parcelUuidArr, BluetoothClass bluetoothClass);
    }

    public interface Filter {
        boolean matches(BluetoothDevice bluetoothDevice);
    }

    public static final class NapFilter extends ClassUuidFilter {
        public /* synthetic */ NapFilter(int i4) {
            this();
        }

        @Override // com.stepos.alphame.bluetooth.BluetoothDeviceFilter.ClassUuidFilter
        public boolean matches(ParcelUuid[] parcelUuidArr, BluetoothClass bluetoothClass) {
            if (parcelUuidArr == null || !BluetoothUuid.isUuidPresent(parcelUuidArr, BluetoothUuid.NAP)) {
                return bluetoothClass != null && BluetoothDeviceFilter.doesClassMatch(bluetoothClass, 5);
            }
            return true;
        }

        private NapFilter() {
            super(0);
        }
    }

    public static final class PanuFilter extends ClassUuidFilter {
        public /* synthetic */ PanuFilter(int i4) {
            this();
        }

        @Override // com.stepos.alphame.bluetooth.BluetoothDeviceFilter.ClassUuidFilter
        public boolean matches(ParcelUuid[] parcelUuidArr, BluetoothClass bluetoothClass) {
            if (parcelUuidArr == null || !BluetoothUuid.isUuidPresent(parcelUuidArr, BluetoothUuid.PANU)) {
                return bluetoothClass != null && BluetoothDeviceFilter.doesClassMatch(bluetoothClass, 4);
            }
            return true;
        }

        private PanuFilter() {
            super(0);
        }
    }

    public static final class TransferFilter extends ClassUuidFilter {
        public /* synthetic */ TransferFilter(int i4) {
            this();
        }

        @Override // com.stepos.alphame.bluetooth.BluetoothDeviceFilter.ClassUuidFilter
        public boolean matches(ParcelUuid[] parcelUuidArr, BluetoothClass bluetoothClass) {
            if (parcelUuidArr == null || !BluetoothUuid.isUuidPresent(parcelUuidArr, BluetoothUuid.ObexObjectPush)) {
                return bluetoothClass != null && BluetoothDeviceFilter.doesClassMatch(bluetoothClass, 2);
            }
            return true;
        }

        private TransferFilter() {
            super(0);
        }
    }

    public static final class UnbondedDeviceFilter implements Filter {
        private UnbondedDeviceFilter() {
        }

        public /* synthetic */ UnbondedDeviceFilter(int i4) {
            this();
        }

        @Override // com.stepos.alphame.bluetooth.BluetoothDeviceFilter.Filter
        public boolean matches(BluetoothDevice bluetoothDevice) {
            return bluetoothDevice.getBondState() != 12;
        }
    }

    static {
        int i4 = 0;
        AllFilter allFilter = new AllFilter(i4);
        ALL_FILTER = allFilter;
        BONDED_DEVICE_FILTER = new BondedDeviceFilter(i4);
        UNBONDED_DEVICE_FILTER = new UnbondedDeviceFilter(i4);
        FILTERS = new Filter[]{allFilter, new AudioFilter(i4), new TransferFilter(i4), new PanuFilter(i4), new NapFilter(i4)};
        A2dpProfile_SINK_UUIDS = new ParcelUuid[]{BluetoothUuid.AudioSink, BluetoothUuid.AdvAudioDist};
        HeadsetProfile_UUIDS = new ParcelUuid[]{BluetoothUuid.HSP, BluetoothUuid.Handsfree};
    }

    private BluetoothDeviceFilter() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean doesClassMatch(BluetoothClass bluetoothClass, int i4) {
        return PerfBinderHelper.bluetoothClassDoesMatch(bluetoothClass, i4);
    }

    public static Filter getFilter(int i4) {
        if (i4 >= 0) {
            Filter[] filterArr = FILTERS;
            if (i4 < filterArr.length) {
                return filterArr[i4];
            }
        }
        Log.w(TAG, "Invalid filter type " + i4 + " for device picker");
        return ALL_FILTER;
    }
}
