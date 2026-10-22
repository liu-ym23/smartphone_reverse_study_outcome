package android.hardware.usb;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class PortRole implements Parcelable {
    public static final Parcelable.Creator<PortRole> CREATOR = null;
    public static final int dataRole = 1;
    public static final int mode = 2;
    public static final int powerRole = 0;
    private int _tag;
    private Object _value;

    public @interface Tag {
        public static final int dataRole = 1;
        public static final int mode = 2;
        public static final int powerRole = 0;
    }

    /* synthetic */ PortRole(Parcel r1, PortRoleIA r2) {
        this(r1);
    }

    public PortRole() {
        this._tag = 0;
        this._value = (byte) 0;
    }

    private PortRole(Parcel _aidl_parcel) {
        readFromParcel(_aidl_parcel);
    }

    private PortRole(int _tag, Object _value) {
        this._tag = _tag;
        this._value = _value;
    }

    public int getTag() {
        return this._tag;
    }

    public static PortRole powerRole(byte _value) {
        return new PortRole(0, Byte.valueOf(_value));
    }

    public byte getPowerRole() {
        _assertTag(0);
        return ((Byte) this._value).byteValue();
    }

    public void setPowerRole(byte _value) {
        _set(0, Byte.valueOf(_value));
    }

    public static PortRole dataRole(byte _value) {
        return new PortRole(1, Byte.valueOf(_value));
    }

    public byte getDataRole() {
        _assertTag(1);
        return ((Byte) this._value).byteValue();
    }

    public void setDataRole(byte _value) {
        _set(1, Byte.valueOf(_value));
    }

    public static PortRole mode(byte _value) {
        return new PortRole(2, Byte.valueOf(_value));
    }

    public byte getMode() {
        _assertTag(2);
        return ((Byte) this._value).byteValue();
    }

    public void setMode(byte _value) {
        _set(2, Byte.valueOf(_value));
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
            case 0: goto L7;
            case 1: goto L6;
            case 2: goto L5;
            default: goto L11;
        };
    L5:
        _aidl_parcel.writeByte(getMode());
        return;
    L6:
        _aidl_parcel.writeByte(getDataRole());
        return;
    L7:
        _aidl_parcel.writeByte(getPowerRole());
        return;
    }

    public void readFromParcel(Parcel _aidl_parcel) {
        int _aidl_tag = _aidl_parcel.readInt();
        switch(_aidl_tag) {
            case 0: goto L10;
            case 1: goto L8;
            case 2: goto L6;
            default: goto L5;
        };
    L6:
        byte _aidl_value = _aidl_parcel.readByte();
        _set(_aidl_tag, Byte.valueOf(_aidl_value));
        return;
    L8:
        byte _aidl_value2 = _aidl_parcel.readByte();
        _set(_aidl_tag, Byte.valueOf(_aidl_value2));
        return;
    L10:
        byte _aidl_value3 = _aidl_parcel.readByte();
        _set(_aidl_tag, Byte.valueOf(_aidl_value3));
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
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L4;
        };
    L5:
        return "mode";
    L7:
        return "dataRole";
    L9:
        return "powerRole";
    L4:
        throw new IllegalStateException("unknown field: " + _tag);
    }

    private void _set(int _tag, Object _value) {
        this._tag = _tag;
        this._value = _value;
    }
}
