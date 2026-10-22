package android.hardware.broadcastradio;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringJoiner;

/* JADX INFO: loaded from: classes.dex */
public class ProgramInfo implements Parcelable {
    public static final Parcelable.Creator<ProgramInfo> CREATOR = null;
    public static final int FLAG_HD_AUDIO_ACQUISITION = 256;
    public static final int FLAG_HD_SIS_ACQUISITION = 128;
    public static final int FLAG_LIVE = 1;
    public static final int FLAG_MUTED = 2;
    public static final int FLAG_SIGNAL_ACQUISITION = 64;
    public static final int FLAG_STEREO = 32;
    public static final int FLAG_TRAFFIC_ANNOUNCEMENT = 8;
    public static final int FLAG_TRAFFIC_PROGRAM = 4;
    public static final int FLAG_TUNABLE = 16;
    public Alert emergencyAlert;
    public int infoFlags;
    public ProgramIdentifier logicallyTunedTo;
    public Metadata[] metadata;
    public ProgramIdentifier physicallyTunedTo;
    public ProgramIdentifier[] relatedContent;
    public ProgramSelector selector;
    public int signalQuality;
    public VendorKeyValue[] vendorInfo;

    public ProgramInfo() {
        this.infoFlags = 0;
        this.signalQuality = 0;
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
        _aidl_parcel.writeTypedObject(this.selector, _aidl_flag);
        _aidl_parcel.writeTypedObject(this.logicallyTunedTo, _aidl_flag);
        _aidl_parcel.writeTypedObject(this.physicallyTunedTo, _aidl_flag);
        _aidl_parcel.writeTypedArray(this.relatedContent, _aidl_flag);
        _aidl_parcel.writeInt(this.infoFlags);
        _aidl_parcel.writeInt(this.signalQuality);
        _aidl_parcel.writeTypedArray(this.metadata, _aidl_flag);
        _aidl_parcel.writeTypedArray(this.vendorInfo, _aidl_flag);
        _aidl_parcel.writeTypedObject(this.emergencyAlert, _aidl_flag);
        int _aidl_end_pos = _aidl_parcel.dataPosition();
        _aidl_parcel.setDataPosition(_aidl_start_pos);
        _aidl_parcel.writeInt(_aidl_end_pos - _aidl_start_pos);
        _aidl_parcel.setDataPosition(_aidl_end_pos);
    }

    public final void readFromParcel(Parcel _aidl_parcel) {
        int _aidl_start_pos = _aidl_parcel.dataPosition();
        int _aidl_parcelable_size = _aidl_parcel.readInt();
        if (_aidl_parcelable_size < 4) goto L95;
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L8;
        this.selector = (ProgramSelector) _aidl_parcel.readTypedObject(ProgramSelector.CREATOR);     // Catch: Throwable -> L92
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
        this.logicallyTunedTo = (ProgramIdentifier) _aidl_parcel.readTypedObject(ProgramIdentifier.CREATOR);     // Catch: Throwable -> L92
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L26;
        this.physicallyTunedTo = (ProgramIdentifier) _aidl_parcel.readTypedObject(ProgramIdentifier.CREATOR);     // Catch: Throwable -> L92
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L35;
        this.relatedContent = (ProgramIdentifier[]) _aidl_parcel.createTypedArray(ProgramIdentifier.CREATOR);     // Catch: Throwable -> L92
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L44;
        this.infoFlags = _aidl_parcel.readInt();     // Catch: Throwable -> L92
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L53;
        this.signalQuality = _aidl_parcel.readInt();     // Catch: Throwable -> L92
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L62;
        this.metadata = (Metadata[]) _aidl_parcel.createTypedArray(Metadata.CREATOR);     // Catch: Throwable -> L92
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L71;
        this.vendorInfo = (VendorKeyValue[]) _aidl_parcel.createTypedArray(VendorKeyValue.CREATOR);     // Catch: Throwable -> L92
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L80;
        this.emergencyAlert = (Alert) _aidl_parcel.readTypedObject(Alert.CREATOR);     // Catch: Throwable -> L92
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L91;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L91:
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
    L95:
        throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L92
    L92:
        th = move-exception;
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L99;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        throw th;
    L99:
        throw new BadParcelableException("Overflow in the size of parcelable");
    }

    public String toString() {
        StringJoiner _aidl_sj = new StringJoiner(", ", "{", "}");
        _aidl_sj.add("selector: " + Objects.toString(this.selector));
        _aidl_sj.add("logicallyTunedTo: " + Objects.toString(this.logicallyTunedTo));
        _aidl_sj.add("physicallyTunedTo: " + Objects.toString(this.physicallyTunedTo));
        _aidl_sj.add("relatedContent: " + Arrays.toString(this.relatedContent));
        _aidl_sj.add("infoFlags: " + this.infoFlags);
        _aidl_sj.add("signalQuality: " + this.signalQuality);
        _aidl_sj.add("metadata: " + Arrays.toString(this.metadata));
        _aidl_sj.add("vendorInfo: " + Arrays.toString(this.vendorInfo));
        _aidl_sj.add("emergencyAlert: " + Objects.toString(this.emergencyAlert));
        return "ProgramInfo" + _aidl_sj.toString();
    }

    public boolean equals(Object other) {
        if (this != other) goto L6;
        return true;
    L6:
        if (other != null) goto L9;
        return false;
    L9:
        if ((other instanceof ProgramInfo) == true) goto L11;
        return false;
    L11:
        ProgramInfo that = (ProgramInfo) other;
        if (Objects.deepEquals(this.selector, that.selector) == true) goto L15;
        return false;
    L15:
        if (Objects.deepEquals(this.logicallyTunedTo, that.logicallyTunedTo) == true) goto L18;
        return false;
    L18:
        if (Objects.deepEquals(this.physicallyTunedTo, that.physicallyTunedTo) == true) goto L21;
        return false;
    L21:
        if (Objects.deepEquals(this.relatedContent, that.relatedContent) == true) goto L24;
        return false;
    L24:
        if (Objects.deepEquals(Integer.valueOf(this.infoFlags), Integer.valueOf(that.infoFlags)) == true) goto L27;
        return false;
    L27:
        if (Objects.deepEquals(Integer.valueOf(this.signalQuality), Integer.valueOf(that.signalQuality)) == true) goto L30;
        return false;
    L30:
        if (Objects.deepEquals(this.metadata, that.metadata) == true) goto L33;
        return false;
    L33:
        if (Objects.deepEquals(this.vendorInfo, that.vendorInfo) == true) goto L36;
        return false;
    L36:
        if (Objects.deepEquals(this.emergencyAlert, that.emergencyAlert) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        return Arrays.deepHashCode(Arrays.asList(new Object[]{this.selector, this.logicallyTunedTo, this.physicallyTunedTo, this.relatedContent, Integer.valueOf(this.infoFlags), Integer.valueOf(this.signalQuality), this.metadata, this.vendorInfo, this.emergencyAlert}).toArray());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        int _mask = 0 | describeContents(this.selector);
        return (((((_mask | describeContents(this.logicallyTunedTo)) | describeContents(this.physicallyTunedTo)) | describeContents(this.relatedContent)) | describeContents(this.metadata)) | describeContents(this.vendorInfo)) | describeContents(this.emergencyAlert);
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
