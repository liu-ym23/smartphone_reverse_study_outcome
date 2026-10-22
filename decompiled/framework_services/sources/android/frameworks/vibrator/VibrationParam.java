package android.frameworks.vibrator;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class VibrationParam implements Parcelable {
    public static final Parcelable.Creator<VibrationParam> CREATOR = null;
    public static final int scale = 0;
    private int _tag;
    private Object _value;

    public @interface Tag {
        public static final int scale = 0;
    }

    /* synthetic */ VibrationParam(Parcel r1, VibrationParamIA r2) {
        this(r1);
    }

    public VibrationParam() {
        this._tag = 0;
        this._value = null;
    }

    private VibrationParam(Parcel _aidl_parcel) {
        readFromParcel(_aidl_parcel);
    }

    private VibrationParam(int _tag, Object _value) {
        this._tag = _tag;
        this._value = _value;
    }

    public int getTag() {
        return this._tag;
    }

    public static VibrationParam scale(ScaleParam _value) {
        return new VibrationParam(0, _value);
    }

    public ScaleParam getScale() {
        _assertTag(0);
        return (ScaleParam) this._value;
    }

    public void setScale(ScaleParam _value) {
        _set(0, _value);
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
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        _aidl_parcel.writeTypedObject(getScale(), _aidl_flag);
        return;
    }

    public void readFromParcel(Parcel _aidl_parcel) {
        int _aidl_tag = _aidl_parcel.readInt();
        switch(_aidl_tag) {
            case 0: goto L6;
            default: goto L5;
        };
    L6:
        ScaleParam _aidl_value = (ScaleParam) _aidl_parcel.readTypedObject(ScaleParam.CREATOR);
        _set(_aidl_tag, _aidl_value);
        return;
    L5:
        throw new IllegalArgumentException("union: unknown tag: " + _aidl_tag);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        switch(getTag()) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        int _mask = 0 | describeContents(getScale());
        return _mask;
    L7:
        return 0;
    }

    private int describeContents(Object _v) {
        if (_v != null) goto L6;
        return 0;
    L6:
        if ((_v instanceof Parcelable) == true) goto L8;
        return 0;
    L8:
        return ((Parcelable) _v).describeContents();
    }

    private void _assertTag(int tag) {
        if (getTag() != tag) goto L6;
        return;
    L6:
        throw new IllegalStateException("bad access: " + _tagString(tag) + ", " + _tagString(getTag()) + " is available.");
    }

    private String _tagString(int _tag) {
        switch(_tag) {
            case 0: goto L5;
            default: goto L4;
        };
    L5:
        return "scale";
    L4:
        throw new IllegalStateException("unknown field: " + _tag);
    }

    private void _set(int _tag, Object _value) {
        this._tag = _tag;
        this._value = _value;
    }
}
