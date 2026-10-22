package android.hardware.tv.mediaquality;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class AmbientBacklightColorFormat implements Parcelable {
    public static final Parcelable.Creator<AmbientBacklightColorFormat> CREATOR = null;
    public static final int RGB888 = 0;
    private int _tag;
    private Object _value;

    public @interface Tag {
        public static final int RGB888 = 0;
    }

    /* synthetic */ AmbientBacklightColorFormat(Parcel r1, AmbientBacklightColorFormatIA r2) {
        this(r1);
    }

    public AmbientBacklightColorFormat() {
        this._tag = 0;
        this._value = 0;
    }

    private AmbientBacklightColorFormat(Parcel _aidl_parcel) {
        readFromParcel(_aidl_parcel);
    }

    private AmbientBacklightColorFormat(int _tag, Object _value) {
        this._tag = _tag;
        this._value = _value;
    }

    public int getTag() {
        return this._tag;
    }

    public static AmbientBacklightColorFormat RGB888(int _value) {
        return new AmbientBacklightColorFormat(0, Integer.valueOf(_value));
    }

    public int getRGB888() {
        _assertTag(0);
        return ((Integer) this._value).intValue();
    }

    public void setRGB888(int _value) {
        _set(0, Integer.valueOf(_value));
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
        _aidl_parcel.writeInt(getRGB888());
        return;
    }

    public void readFromParcel(Parcel _aidl_parcel) {
        int _aidl_tag = _aidl_parcel.readInt();
        switch(_aidl_tag) {
            case 0: goto L6;
            default: goto L5;
        };
    L6:
        int _aidl_value = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value));
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
            case 0: goto L5;
            default: goto L4;
        };
    L5:
        return "RGB888";
    L4:
        throw new IllegalStateException("unknown field: " + _tag);
    }

    private void _set(int _tag, Object _value) {
        this._tag = _tag;
        this._value = _value;
    }
}
