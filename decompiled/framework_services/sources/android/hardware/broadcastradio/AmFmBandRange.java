package android.hardware.broadcastradio;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringJoiner;

/* JADX INFO: loaded from: classes.dex */
public class AmFmBandRange implements Parcelable {
    public static final Parcelable.Creator<AmFmBandRange> CREATOR = null;
    public int lowerBound;
    public int seekSpacing;
    public int spacing;
    public int upperBound;

    public AmFmBandRange() {
        this.lowerBound = 0;
        this.upperBound = 0;
        this.spacing = 0;
        this.seekSpacing = 0;
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
        _aidl_parcel.writeInt(this.lowerBound);
        _aidl_parcel.writeInt(this.upperBound);
        _aidl_parcel.writeInt(this.spacing);
        _aidl_parcel.writeInt(this.seekSpacing);
        int _aidl_end_pos = _aidl_parcel.dataPosition();
        _aidl_parcel.setDataPosition(_aidl_start_pos);
        _aidl_parcel.writeInt(_aidl_end_pos - _aidl_start_pos);
        _aidl_parcel.setDataPosition(_aidl_end_pos);
    }

    public final void readFromParcel(Parcel _aidl_parcel) {
        int _aidl_start_pos = _aidl_parcel.dataPosition();
        int _aidl_parcelable_size = _aidl_parcel.readInt();
        if (_aidl_parcelable_size < 4) goto L50;
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L8;
        this.lowerBound = _aidl_parcel.readInt();     // Catch: Throwable -> L47
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
        this.upperBound = _aidl_parcel.readInt();     // Catch: Throwable -> L47
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L26;
        this.spacing = _aidl_parcel.readInt();     // Catch: Throwable -> L47
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L35;
        this.seekSpacing = _aidl_parcel.readInt();     // Catch: Throwable -> L47
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L46;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L46:
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
    L50:
        throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L54;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        throw th;
    L54:
        throw new BadParcelableException("Overflow in the size of parcelable");
    }

    public String toString() {
        StringJoiner _aidl_sj = new StringJoiner(", ", "{", "}");
        _aidl_sj.add("lowerBound: " + this.lowerBound);
        _aidl_sj.add("upperBound: " + this.upperBound);
        _aidl_sj.add("spacing: " + this.spacing);
        _aidl_sj.add("seekSpacing: " + this.seekSpacing);
        return "AmFmBandRange" + _aidl_sj.toString();
    }

    public boolean equals(Object other) {
        if (this != other) goto L6;
        return true;
    L6:
        if (other != null) goto L9;
        return false;
    L9:
        if ((other instanceof AmFmBandRange) == true) goto L11;
        return false;
    L11:
        AmFmBandRange that = (AmFmBandRange) other;
        if (Objects.deepEquals(Integer.valueOf(this.lowerBound), Integer.valueOf(that.lowerBound)) == true) goto L15;
        return false;
    L15:
        if (Objects.deepEquals(Integer.valueOf(this.upperBound), Integer.valueOf(that.upperBound)) == true) goto L18;
        return false;
    L18:
        if (Objects.deepEquals(Integer.valueOf(this.spacing), Integer.valueOf(that.spacing)) == true) goto L21;
        return false;
    L21:
        if (Objects.deepEquals(Integer.valueOf(this.seekSpacing), Integer.valueOf(that.seekSpacing)) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return Arrays.deepHashCode(Arrays.asList(new Integer[]{Integer.valueOf(this.lowerBound), Integer.valueOf(this.upperBound), Integer.valueOf(this.spacing), Integer.valueOf(this.seekSpacing)}).toArray());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
