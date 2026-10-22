package android.hardware.tv.mediaquality;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class NumberRange implements Parcelable {
    public static final Parcelable.Creator<NumberRange> CREATOR = null;
    public static final int doubleMinMax = 2;
    public static final int doubleValuesSupported = 5;
    public static final int intMinMax = 0;
    public static final int intValuesSupported = 3;
    public static final int longMinMax = 1;
    public static final int longValuesSupported = 4;
    private int _tag;
    private Object _value;

    public @interface Tag {
        public static final int doubleMinMax = 2;
        public static final int doubleValuesSupported = 5;
        public static final int intMinMax = 0;
        public static final int intValuesSupported = 3;
        public static final int longMinMax = 1;
        public static final int longValuesSupported = 4;
    }

    /* synthetic */ NumberRange(Parcel r1, NumberRangeIA r2) {
        this(r1);
    }

    public NumberRange() {
        this._tag = 0;
        this._value = null;
    }

    private NumberRange(Parcel _aidl_parcel) {
        readFromParcel(_aidl_parcel);
    }

    private NumberRange(int _tag, Object _value) {
        this._tag = _tag;
        this._value = _value;
    }

    public int getTag() {
        return this._tag;
    }

    public static NumberRange intMinMax(int[] _value) {
        return new NumberRange(0, _value);
    }

    public int[] getIntMinMax() {
        _assertTag(0);
        return (int[]) this._value;
    }

    public void setIntMinMax(int[] _value) {
        _set(0, _value);
    }

    public static NumberRange longMinMax(long[] _value) {
        return new NumberRange(1, _value);
    }

    public long[] getLongMinMax() {
        _assertTag(1);
        return (long[]) this._value;
    }

    public void setLongMinMax(long[] _value) {
        _set(1, _value);
    }

    public static NumberRange doubleMinMax(double[] _value) {
        return new NumberRange(2, _value);
    }

    public double[] getDoubleMinMax() {
        _assertTag(2);
        return (double[]) this._value;
    }

    public void setDoubleMinMax(double[] _value) {
        _set(2, _value);
    }

    public static NumberRange intValuesSupported(int[] _value) {
        return new NumberRange(3, _value);
    }

    public int[] getIntValuesSupported() {
        _assertTag(3);
        return (int[]) this._value;
    }

    public void setIntValuesSupported(int[] _value) {
        _set(3, _value);
    }

    public static NumberRange longValuesSupported(long[] _value) {
        return new NumberRange(4, _value);
    }

    public long[] getLongValuesSupported() {
        _assertTag(4);
        return (long[]) this._value;
    }

    public void setLongValuesSupported(long[] _value) {
        _set(4, _value);
    }

    public static NumberRange doubleValuesSupported(double[] _value) {
        return new NumberRange(5, _value);
    }

    public double[] getDoubleValuesSupported() {
        _assertTag(5);
        return (double[]) this._value;
    }

    public void setDoubleValuesSupported(double[] _value) {
        _set(5, _value);
    }

    public final int getStability() {
        return 1;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel _aidl_parcel, int _aidl_flag) {
        _aidl_parcel.writeInt(this._tag);
        switch(this._tag) {
            case 0: goto L10;
            case 1: goto L9;
            case 2: goto L8;
            case 3: goto L7;
            case 4: goto L6;
            case 5: goto L5;
            default: goto L17;
        };
    L5:
        _aidl_parcel.writeDoubleArray(getDoubleValuesSupported());
        return;
    L6:
        _aidl_parcel.writeLongArray(getLongValuesSupported());
        return;
    L7:
        _aidl_parcel.writeIntArray(getIntValuesSupported());
        return;
    L8:
        _aidl_parcel.writeFixedArray(getDoubleMinMax(), _aidl_flag, new int[]{2});
        return;
    L9:
        _aidl_parcel.writeFixedArray(getLongMinMax(), _aidl_flag, new int[]{2});
        return;
    L10:
        _aidl_parcel.writeFixedArray(getIntMinMax(), _aidl_flag, new int[]{2});
        return;
    }

    public void readFromParcel(Parcel _aidl_parcel) {
        int _aidl_tag = _aidl_parcel.readInt();
        switch(_aidl_tag) {
            case 0: goto L16;
            case 1: goto L14;
            case 2: goto L12;
            case 3: goto L10;
            case 4: goto L8;
            case 5: goto L6;
            default: goto L5;
        };
    L6:
        double[] _aidl_value = _aidl_parcel.createDoubleArray();
        _set(_aidl_tag, _aidl_value);
        return;
    L8:
        long[] _aidl_value2 = _aidl_parcel.createLongArray();
        _set(_aidl_tag, _aidl_value2);
        return;
    L10:
        int[] _aidl_value3 = _aidl_parcel.createIntArray();
        _set(_aidl_tag, _aidl_value3);
        return;
    L12:
        double[] _aidl_value4 = (double[]) _aidl_parcel.createFixedArray(double[].class, new int[]{2});
        _set(_aidl_tag, _aidl_value4);
        return;
    L14:
        long[] _aidl_value5 = (long[]) _aidl_parcel.createFixedArray(long[].class, new int[]{2});
        _set(_aidl_tag, _aidl_value5);
        return;
    L16:
        int[] _aidl_value6 = (int[]) _aidl_parcel.createFixedArray(int[].class, new int[]{2});
        _set(_aidl_tag, _aidl_value6);
        return;
    L5:
        throw new IllegalArgumentException("union: unknown tag: " + _aidl_tag);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        getTag();
        return 0;
    }

    private void _assertTag(int tag) {
        if (getTag() != tag) goto L6;
        return;
    L6:
        throw new IllegalStateException("bad access: " + _tagString(tag) + ", " + _tagString(getTag()) + " is available.");
    }

    private String _tagString(int _tag) {
        switch(_tag) {
            case 0: goto L15;
            case 1: goto L13;
            case 2: goto L11;
            case 3: goto L9;
            case 4: goto L7;
            case 5: goto L5;
            default: goto L4;
        };
    L5:
        return "doubleValuesSupported";
    L7:
        return "longValuesSupported";
    L9:
        return "intValuesSupported";
    L11:
        return "doubleMinMax";
    L13:
        return "longMinMax";
    L15:
        return "intMinMax";
    L4:
        throw new IllegalStateException("unknown field: " + _tag);
    }

    private void _set(int _tag, Object _value) {
        this._tag = _tag;
        this._value = _value;
    }
}
