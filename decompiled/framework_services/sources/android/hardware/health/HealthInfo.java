package android.hardware.health;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class HealthInfo implements Parcelable {
    public static final int BATTERY_CHARGE_TIME_TO_FULL_NOW_SECONDS_UNSUPPORTED = -1;
    public static final Parcelable.Creator<HealthInfo> CREATOR = null;
    public int batteryCapacityLevel;
    public int batteryChargeCounterUah;
    public long batteryChargeTimeToFullNowSeconds;
    public int batteryCurrentAverageMicroamps;
    public int batteryCurrentMicroamps;
    public int batteryCycleCount;
    public int batteryFullChargeDesignCapacityUah;
    public int batteryFullChargeUah;
    public int batteryHealth;
    public BatteryHealthData batteryHealthData;
    public int batteryLevel;
    public boolean batteryPresent;
    public int batteryStatus;
    public String batteryTechnology;
    public int batteryTemperatureTenthsCelsius;
    public int batteryVoltageMillivolts;
    public boolean chargerAcOnline;
    public boolean chargerDockOnline;
    public boolean chargerUsbOnline;
    public boolean chargerWirelessOnline;
    public int chargingPolicy;
    public int chargingState;
    public DiskStats[] diskStats;
    public HingeInfo[] hingeInfos;
    public int maxChargingCurrentMicroamps;
    public int maxChargingVoltageMicrovolts;
    public StorageInfo[] storageInfos;

    public HealthInfo() {
        this.chargerAcOnline = false;
        this.chargerUsbOnline = false;
        this.chargerWirelessOnline = false;
        this.chargerDockOnline = false;
        this.maxChargingCurrentMicroamps = 0;
        this.maxChargingVoltageMicrovolts = 0;
        this.batteryPresent = false;
        this.batteryLevel = 0;
        this.batteryVoltageMillivolts = 0;
        this.batteryTemperatureTenthsCelsius = 0;
        this.batteryCurrentMicroamps = 0;
        this.batteryCycleCount = 0;
        this.batteryFullChargeUah = 0;
        this.batteryChargeCounterUah = 0;
        this.batteryCurrentAverageMicroamps = 0;
        this.batteryChargeTimeToFullNowSeconds = 0;
        this.batteryFullChargeDesignCapacityUah = 0;
    }

    public final int getStability() {
        return 1;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel _aidl_parcel, int _aidl_flag) {
        int _aidl_start_pos = _aidl_parcel.dataPosition();
        _aidl_parcel.writeInt(0);
        _aidl_parcel.writeBoolean(this.chargerAcOnline);
        _aidl_parcel.writeBoolean(this.chargerUsbOnline);
        _aidl_parcel.writeBoolean(this.chargerWirelessOnline);
        _aidl_parcel.writeBoolean(this.chargerDockOnline);
        _aidl_parcel.writeInt(this.maxChargingCurrentMicroamps);
        _aidl_parcel.writeInt(this.maxChargingVoltageMicrovolts);
        _aidl_parcel.writeInt(this.batteryStatus);
        _aidl_parcel.writeInt(this.batteryHealth);
        _aidl_parcel.writeBoolean(this.batteryPresent);
        _aidl_parcel.writeInt(this.batteryLevel);
        _aidl_parcel.writeInt(this.batteryVoltageMillivolts);
        _aidl_parcel.writeInt(this.batteryTemperatureTenthsCelsius);
        _aidl_parcel.writeInt(this.batteryCurrentMicroamps);
        _aidl_parcel.writeInt(this.batteryCycleCount);
        _aidl_parcel.writeInt(this.batteryFullChargeUah);
        _aidl_parcel.writeInt(this.batteryChargeCounterUah);
        _aidl_parcel.writeString(this.batteryTechnology);
        _aidl_parcel.writeInt(this.batteryCurrentAverageMicroamps);
        _aidl_parcel.writeTypedArray(this.diskStats, _aidl_flag);
        _aidl_parcel.writeTypedArray(this.storageInfos, _aidl_flag);
        _aidl_parcel.writeInt(this.batteryCapacityLevel);
        _aidl_parcel.writeLong(this.batteryChargeTimeToFullNowSeconds);
        _aidl_parcel.writeInt(this.batteryFullChargeDesignCapacityUah);
        _aidl_parcel.writeInt(this.chargingState);
        _aidl_parcel.writeInt(this.chargingPolicy);
        _aidl_parcel.writeTypedObject(this.batteryHealthData, _aidl_flag);
        _aidl_parcel.writeTypedArray(this.hingeInfos, _aidl_flag);
        int _aidl_end_pos = _aidl_parcel.dataPosition();
        _aidl_parcel.setDataPosition(_aidl_start_pos);
        _aidl_parcel.writeInt(_aidl_end_pos - _aidl_start_pos);
        _aidl_parcel.setDataPosition(_aidl_end_pos);
    }

    public final void readFromParcel(Parcel _aidl_parcel) {
        int _aidl_start_pos = _aidl_parcel.dataPosition();
        int _aidl_parcelable_size = _aidl_parcel.readInt();
        if (_aidl_parcelable_size < 4) goto L257;
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L8;
        this.chargerAcOnline = _aidl_parcel.readBoolean();     // Catch: Throwable -> L254
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
        this.chargerUsbOnline = _aidl_parcel.readBoolean();     // Catch: Throwable -> L254
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L26;
        this.chargerWirelessOnline = _aidl_parcel.readBoolean();     // Catch: Throwable -> L254
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L35;
        this.chargerDockOnline = _aidl_parcel.readBoolean();     // Catch: Throwable -> L254
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L44;
        this.maxChargingCurrentMicroamps = _aidl_parcel.readInt();     // Catch: Throwable -> L254
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L53;
        this.maxChargingVoltageMicrovolts = _aidl_parcel.readInt();     // Catch: Throwable -> L254
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L62;
        this.batteryStatus = _aidl_parcel.readInt();     // Catch: Throwable -> L254
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L71;
        this.batteryHealth = _aidl_parcel.readInt();     // Catch: Throwable -> L254
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L80;
        this.batteryPresent = _aidl_parcel.readBoolean();     // Catch: Throwable -> L254
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L89;
        this.batteryLevel = _aidl_parcel.readInt();     // Catch: Throwable -> L254
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L98;
        this.batteryVoltageMillivolts = _aidl_parcel.readInt();     // Catch: Throwable -> L254
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L107;
        this.batteryTemperatureTenthsCelsius = _aidl_parcel.readInt();     // Catch: Throwable -> L254
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L116;
        this.batteryCurrentMicroamps = _aidl_parcel.readInt();     // Catch: Throwable -> L254
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L125;
        this.batteryCycleCount = _aidl_parcel.readInt();     // Catch: Throwable -> L254
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L134;
        this.batteryFullChargeUah = _aidl_parcel.readInt();     // Catch: Throwable -> L254
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L143;
        this.batteryChargeCounterUah = _aidl_parcel.readInt();     // Catch: Throwable -> L254
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L152;
        this.batteryTechnology = _aidl_parcel.readString();     // Catch: Throwable -> L254
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L161;
        this.batteryCurrentAverageMicroamps = _aidl_parcel.readInt();     // Catch: Throwable -> L254
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L170;
        this.diskStats = (DiskStats[]) _aidl_parcel.createTypedArray(DiskStats.CREATOR);     // Catch: Throwable -> L254
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L179;
        this.storageInfos = (StorageInfo[]) _aidl_parcel.createTypedArray(StorageInfo.CREATOR);     // Catch: Throwable -> L254
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L188;
        this.batteryCapacityLevel = _aidl_parcel.readInt();     // Catch: Throwable -> L254
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L197;
        this.batteryChargeTimeToFullNowSeconds = _aidl_parcel.readLong();     // Catch: Throwable -> L254
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L206;
        this.batteryFullChargeDesignCapacityUah = _aidl_parcel.readInt();     // Catch: Throwable -> L254
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L215;
        this.chargingState = _aidl_parcel.readInt();     // Catch: Throwable -> L254
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L224;
        this.chargingPolicy = _aidl_parcel.readInt();     // Catch: Throwable -> L254
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L233;
        this.batteryHealthData = (BatteryHealthData) _aidl_parcel.readTypedObject(BatteryHealthData.CREATOR);     // Catch: Throwable -> L254
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L242;
        this.hingeInfos = (HingeInfo[]) _aidl_parcel.createTypedArray(HingeInfo.CREATOR);     // Catch: Throwable -> L254
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L253;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L253:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L242:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L246;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L246:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L233:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L237;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L237:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L224:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L228;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L228:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L215:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L219;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L219:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L206:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L210;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L210:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L197:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L201;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L201:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L188:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L192;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L192:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L179:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L183;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L183:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L170:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L174;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L174:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L161:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L165;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L165:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L152:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L156;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L156:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L143:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L147;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L147:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L134:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L138;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L138:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L125:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L129;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L129:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L116:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L120;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L120:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L107:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L111;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L111:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L98:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L102;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L102:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L89:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L93;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L93:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L80:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L84;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L84:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L71:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L75;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L75:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L62:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L66;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L66:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L53:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L57;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L57:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L44:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L48;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L48:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L35:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L39;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L39:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L26:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L30;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L30:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L17:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L21;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L21:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L8:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L12;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L12:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L257:
        throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L254
    L254:
        th = move-exception;
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L261;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        throw th;
    L261:
        throw new BadParcelableException("Overflow in the size of parcelable");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        int _mask = 0 | describeContents(this.diskStats);
        return ((_mask | describeContents(this.storageInfos)) | describeContents(this.batteryHealthData)) | describeContents(this.hingeInfos);
    }

    private int describeContents(Object _v) {
        int r0 = 0;
        if (_v != null) goto L6;
        return 0;
    L6:
        if ((_v instanceof Object[]) == false) goto L12;
        int _mask = 0;
        Object[] r2 = (Object[]) _v;
        int r3 = r2.length;
    L8:
        if (r0 >= r3) goto L10;
        Object o = r2[r0];
        _mask = _mask | describeContents(o);
        r0 = r0 + 1;
        goto L8
    L10:
        return _mask;
    L12:
        if ((_v instanceof Parcelable) == true) goto L14;
        return 0;
    L14:
        return ((Parcelable) _v).describeContents();
    }
}
