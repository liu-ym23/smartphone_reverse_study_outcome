package android.hardware.broadcastradio;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringJoiner;

/* JADX INFO: loaded from: classes.dex */
public class AlertInfo implements Parcelable {
    public static final Parcelable.Creator<AlertInfo> CREATOR = null;
    public AlertArea[] areas;
    public int[] categoryArray;
    public int certainty;
    public String description;
    public String language;
    public int severity;
    public int urgency;

    public AlertInfo() {
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
        _aidl_parcel.writeIntArray(this.categoryArray);
        _aidl_parcel.writeInt(this.urgency);
        _aidl_parcel.writeInt(this.severity);
        _aidl_parcel.writeInt(this.certainty);
        _aidl_parcel.writeString(this.description);
        _aidl_parcel.writeTypedArray(this.areas, _aidl_flag);
        _aidl_parcel.writeString(this.language);
        int _aidl_end_pos = _aidl_parcel.dataPosition();
        _aidl_parcel.setDataPosition(_aidl_start_pos);
        _aidl_parcel.writeInt(_aidl_end_pos - _aidl_start_pos);
        _aidl_parcel.setDataPosition(_aidl_end_pos);
    }

    public final void readFromParcel(Parcel _aidl_parcel) {
        int _aidl_start_pos = _aidl_parcel.dataPosition();
        int _aidl_parcelable_size = _aidl_parcel.readInt();
        if (_aidl_parcelable_size < 4) goto L77;
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L8;
        this.categoryArray = _aidl_parcel.createIntArray();     // Catch: Throwable -> L74
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
        this.urgency = _aidl_parcel.readInt();     // Catch: Throwable -> L74
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L26;
        this.severity = _aidl_parcel.readInt();     // Catch: Throwable -> L74
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L35;
        this.certainty = _aidl_parcel.readInt();     // Catch: Throwable -> L74
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L44;
        this.description = _aidl_parcel.readString();     // Catch: Throwable -> L74
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L53;
        this.areas = (AlertArea[]) _aidl_parcel.createTypedArray(AlertArea.CREATOR);     // Catch: Throwable -> L74
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L62;
        this.language = _aidl_parcel.readString();     // Catch: Throwable -> L74
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L73;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L73:
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
    L77:
        throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L74
    L74:
        th = move-exception;
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L81;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        throw th;
    L81:
        throw new BadParcelableException("Overflow in the size of parcelable");
    }

    public String toString() {
        StringJoiner _aidl_sj = new StringJoiner(", ", "{", "}");
        _aidl_sj.add("categoryArray: " + AlertCategory$$.arrayToString(this.categoryArray));
        _aidl_sj.add("urgency: " + AlertUrgency$$.toString(this.urgency));
        _aidl_sj.add("severity: " + AlertSeverity$$.toString(this.severity));
        _aidl_sj.add("certainty: " + AlertCertainty$$.toString(this.certainty));
        _aidl_sj.add("description: " + Objects.toString(this.description));
        _aidl_sj.add("areas: " + Arrays.toString(this.areas));
        _aidl_sj.add("language: " + Objects.toString(this.language));
        return "AlertInfo" + _aidl_sj.toString();
    }

    public boolean equals(Object other) {
        if (this != other) goto L6;
        return true;
    L6:
        if (other != null) goto L9;
        return false;
    L9:
        if ((other instanceof AlertInfo) == true) goto L11;
        return false;
    L11:
        AlertInfo that = (AlertInfo) other;
        if (Objects.deepEquals(this.categoryArray, that.categoryArray) == true) goto L15;
        return false;
    L15:
        if (Objects.deepEquals(Integer.valueOf(this.urgency), Integer.valueOf(that.urgency)) == true) goto L18;
        return false;
    L18:
        if (Objects.deepEquals(Integer.valueOf(this.severity), Integer.valueOf(that.severity)) == true) goto L21;
        return false;
    L21:
        if (Objects.deepEquals(Integer.valueOf(this.certainty), Integer.valueOf(that.certainty)) == true) goto L24;
        return false;
    L24:
        if (Objects.deepEquals(this.description, that.description) == true) goto L27;
        return false;
    L27:
        if (Objects.deepEquals(this.areas, that.areas) == true) goto L30;
        return false;
    L30:
        if (Objects.deepEquals(this.language, that.language) == true) goto L32;
        return false;
    L32:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        return Arrays.deepHashCode(Arrays.asList(new Serializable[]{this.categoryArray, Integer.valueOf(this.urgency), Integer.valueOf(this.severity), Integer.valueOf(this.certainty), this.description, this.areas, this.language}).toArray());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        int _mask = 0 | describeContents(this.areas);
        return _mask;
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
