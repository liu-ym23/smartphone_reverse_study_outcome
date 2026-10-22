package android.hardware.tv.mediaquality;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class ParameterDefaultValue implements Parcelable {
    public static final Parcelable.Creator<ParameterDefaultValue> CREATOR = null;
    public static final int doubleDefault = 2;
    public static final int intDefault = 0;
    public static final int longDefault = 1;
    public static final int stringDefault = 3;
    private int _tag;
    private Object _value;

    public @interface Tag {
        public static final int doubleDefault = 2;
        public static final int intDefault = 0;
        public static final int longDefault = 1;
        public static final int stringDefault = 3;
    }

    /* synthetic */ ParameterDefaultValue(Parcel r1, ParameterDefaultValueIA r2) {
        this(r1);
    }

    public ParameterDefaultValue() {
        this._tag = 0;
        this._value = 0;
    }

    private ParameterDefaultValue(Parcel _aidl_parcel) {
        readFromParcel(_aidl_parcel);
    }

    private ParameterDefaultValue(int _tag, Object _value) {
        this._tag = _tag;
        this._value = _value;
    }

    public int getTag() {
        return this._tag;
    }

    public static ParameterDefaultValue intDefault(int _value) {
        return new ParameterDefaultValue(0, Integer.valueOf(_value));
    }

    public int getIntDefault() {
        _assertTag(0);
        return ((Integer) this._value).intValue();
    }

    public void setIntDefault(int _value) {
        _set(0, Integer.valueOf(_value));
    }

    public static ParameterDefaultValue longDefault(long _value) {
        return new ParameterDefaultValue(1, Long.valueOf(_value));
    }

    public long getLongDefault() {
        _assertTag(1);
        return ((Long) this._value).longValue();
    }

    public void setLongDefault(long _value) {
        _set(1, Long.valueOf(_value));
    }

    public static ParameterDefaultValue doubleDefault(double _value) {
        return new ParameterDefaultValue(2, Double.valueOf(_value));
    }

    public double getDoubleDefault() {
        _assertTag(2);
        return ((Double) this._value).doubleValue();
    }

    public void setDoubleDefault(double _value) {
        _set(2, Double.valueOf(_value));
    }

    public static ParameterDefaultValue stringDefault(String _value) {
        return new ParameterDefaultValue(3, _value);
    }

    public String getStringDefault() {
        _assertTag(3);
        return (String) this._value;
    }

    public void setStringDefault(String _value) {
        _set(3, _value);
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
            case 0: goto L8;
            case 1: goto L7;
            case 2: goto L6;
            case 3: goto L5;
            default: goto L13;
        };
    L5:
        _aidl_parcel.writeString(getStringDefault());
        return;
    L6:
        _aidl_parcel.writeDouble(getDoubleDefault());
        return;
    L7:
        _aidl_parcel.writeLong(getLongDefault());
        return;
    L8:
        _aidl_parcel.writeInt(getIntDefault());
        return;
    }

    public void readFromParcel(Parcel _aidl_parcel) {
        int _aidl_tag = _aidl_parcel.readInt();
        switch(_aidl_tag) {
            case 0: goto L12;
            case 1: goto L10;
            case 2: goto L8;
            case 3: goto L6;
            default: goto L5;
        };
    L6:
        String _aidl_value = _aidl_parcel.readString();
        _set(_aidl_tag, _aidl_value);
        return;
    L8:
        double _aidl_value2 = _aidl_parcel.readDouble();
        _set(_aidl_tag, Double.valueOf(_aidl_value2));
        return;
    L10:
        long _aidl_value3 = _aidl_parcel.readLong();
        _set(_aidl_tag, Long.valueOf(_aidl_value3));
        return;
    L12:
        int _aidl_value4 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value4));
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
            case 0: goto L11;
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L5;
            default: goto L4;
        };
    L5:
        return "stringDefault";
    L7:
        return "doubleDefault";
    L9:
        return "longDefault";
    L11:
        return "intDefault";
    L4:
        throw new IllegalStateException("unknown field: " + _tag);
    }

    private void _set(int _tag, Object _value) {
        this._tag = _tag;
        this._value = _value;
    }
}
