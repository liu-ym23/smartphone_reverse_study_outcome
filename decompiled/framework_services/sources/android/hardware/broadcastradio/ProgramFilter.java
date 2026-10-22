package android.hardware.broadcastradio;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringJoiner;

/* JADX INFO: loaded from: classes.dex */
public class ProgramFilter implements Parcelable {
    public static final Parcelable.Creator<ProgramFilter> CREATOR = null;
    public boolean excludeModifications;
    public int[] identifierTypes;
    public ProgramIdentifier[] identifiers;
    public boolean includeCategories;

    public ProgramFilter() {
        this.includeCategories = false;
        this.excludeModifications = false;
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
        _aidl_parcel.writeIntArray(this.identifierTypes);
        _aidl_parcel.writeTypedArray(this.identifiers, _aidl_flag);
        _aidl_parcel.writeBoolean(this.includeCategories);
        _aidl_parcel.writeBoolean(this.excludeModifications);
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
        this.identifierTypes = _aidl_parcel.createIntArray();     // Catch: Throwable -> L47
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
        this.identifiers = (ProgramIdentifier[]) _aidl_parcel.createTypedArray(ProgramIdentifier.CREATOR);     // Catch: Throwable -> L47
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L26;
        this.includeCategories = _aidl_parcel.readBoolean();     // Catch: Throwable -> L47
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L35;
        this.excludeModifications = _aidl_parcel.readBoolean();     // Catch: Throwable -> L47
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
        _aidl_sj.add("identifierTypes: " + IdentifierType$$.arrayToString(this.identifierTypes));
        _aidl_sj.add("identifiers: " + Arrays.toString(this.identifiers));
        _aidl_sj.add("includeCategories: " + this.includeCategories);
        _aidl_sj.add("excludeModifications: " + this.excludeModifications);
        return "ProgramFilter" + _aidl_sj.toString();
    }

    public boolean equals(Object other) {
        if (this != other) goto L6;
        return true;
    L6:
        if (other != null) goto L9;
        return false;
    L9:
        if ((other instanceof ProgramFilter) == true) goto L11;
        return false;
    L11:
        ProgramFilter that = (ProgramFilter) other;
        if (Objects.deepEquals(this.identifierTypes, that.identifierTypes) == true) goto L15;
        return false;
    L15:
        if (Objects.deepEquals(this.identifiers, that.identifiers) == true) goto L18;
        return false;
    L18:
        if (Objects.deepEquals(Boolean.valueOf(this.includeCategories), Boolean.valueOf(that.includeCategories)) == true) goto L21;
        return false;
    L21:
        if (Objects.deepEquals(Boolean.valueOf(this.excludeModifications), Boolean.valueOf(that.excludeModifications)) == true) goto L23;
        return false;
    L23:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        return Arrays.deepHashCode(Arrays.asList(new Serializable[]{this.identifierTypes, this.identifiers, Boolean.valueOf(this.includeCategories), Boolean.valueOf(this.excludeModifications)}).toArray());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        int _mask = 0 | describeContents(this.identifiers);
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
