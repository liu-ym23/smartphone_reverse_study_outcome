package android.net;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.StringJoiner;

/* JADX INFO: loaded from: classes.dex */
public class DataStallReportParcelable implements Parcelable {
    public static final Parcelable.Creator<DataStallReportParcelable> CREATOR = null;
    public int detectionMethod;
    public int dnsConsecutiveTimeouts;
    public int tcpMetricsCollectionPeriodMillis;
    public int tcpPacketFailRate;
    public long timestampMillis;

    public DataStallReportParcelable() {
        this.timestampMillis = 0;
        this.detectionMethod = 1;
        this.tcpPacketFailRate = 2;
        this.tcpMetricsCollectionPeriodMillis = 3;
        this.dnsConsecutiveTimeouts = 4;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel _aidl_parcel, int _aidl_flag) {
        int _aidl_start_pos = _aidl_parcel.dataPosition();
        _aidl_parcel.writeInt(0);
        _aidl_parcel.writeLong(this.timestampMillis);
        _aidl_parcel.writeInt(this.detectionMethod);
        _aidl_parcel.writeInt(this.tcpPacketFailRate);
        _aidl_parcel.writeInt(this.tcpMetricsCollectionPeriodMillis);
        _aidl_parcel.writeInt(this.dnsConsecutiveTimeouts);
        int _aidl_end_pos = _aidl_parcel.dataPosition();
        _aidl_parcel.setDataPosition(_aidl_start_pos);
        _aidl_parcel.writeInt(_aidl_end_pos - _aidl_start_pos);
        _aidl_parcel.setDataPosition(_aidl_end_pos);
    }

    public final void readFromParcel(Parcel _aidl_parcel) {
        int _aidl_start_pos = _aidl_parcel.dataPosition();
        int _aidl_parcelable_size = _aidl_parcel.readInt();
        if (_aidl_parcelable_size < 4) goto L59;
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L8;
        this.timestampMillis = _aidl_parcel.readLong();     // Catch: Throwable -> L56
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
        this.detectionMethod = _aidl_parcel.readInt();     // Catch: Throwable -> L56
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L26;
        this.tcpPacketFailRate = _aidl_parcel.readInt();     // Catch: Throwable -> L56
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L35;
        this.tcpMetricsCollectionPeriodMillis = _aidl_parcel.readInt();     // Catch: Throwable -> L56
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L44;
        this.dnsConsecutiveTimeouts = _aidl_parcel.readInt();     // Catch: Throwable -> L56
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L55;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L55:
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
    L59:
        throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L56
    L56:
        th = move-exception;
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L63;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        throw th;
    L63:
        throw new BadParcelableException("Overflow in the size of parcelable");
    }

    public String toString() {
        StringJoiner _aidl_sj = new StringJoiner(", ", "{", "}");
        _aidl_sj.add("timestampMillis: " + this.timestampMillis);
        _aidl_sj.add("detectionMethod: " + this.detectionMethod);
        _aidl_sj.add("tcpPacketFailRate: " + this.tcpPacketFailRate);
        _aidl_sj.add("tcpMetricsCollectionPeriodMillis: " + this.tcpMetricsCollectionPeriodMillis);
        _aidl_sj.add("dnsConsecutiveTimeouts: " + this.dnsConsecutiveTimeouts);
        return "DataStallReportParcelable" + _aidl_sj.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
