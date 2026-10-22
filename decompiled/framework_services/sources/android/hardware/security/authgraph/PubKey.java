package android.hardware.security.authgraph;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class PubKey implements Parcelable {
    public static final Parcelable.Creator<PubKey> CREATOR = null;
    public static final int plainKey = 0;
    public static final int signedKey = 1;
    private int _tag;
    private Object _value;

    public @interface Tag {
        public static final int plainKey = 0;
        public static final int signedKey = 1;
    }

    /* synthetic */ PubKey(Parcel r1, PubKeyIA r2) {
        this(r1);
    }

    public PubKey() {
        this._tag = 0;
        this._value = null;
    }

    private PubKey(Parcel _aidl_parcel) {
        readFromParcel(_aidl_parcel);
    }

    private PubKey(int _tag, Object _value) {
        this._tag = _tag;
        this._value = _value;
    }

    public int getTag() {
        return this._tag;
    }

    public static PubKey plainKey(PlainPubKey _value) {
        return new PubKey(0, _value);
    }

    public PlainPubKey getPlainKey() {
        _assertTag(0);
        return (PlainPubKey) this._value;
    }

    public void setPlainKey(PlainPubKey _value) {
        _set(0, _value);
    }

    public static PubKey signedKey(SignedPubKey _value) {
        return new PubKey(1, _value);
    }

    public SignedPubKey getSignedKey() {
        _assertTag(1);
        return (SignedPubKey) this._value;
    }

    public void setSignedKey(SignedPubKey _value) {
        _set(1, _value);
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
            case 0: goto L6;
            case 1: goto L5;
            default: goto L9;
        };
    L5:
        _aidl_parcel.writeTypedObject(getSignedKey(), _aidl_flag);
        return;
    L6:
        _aidl_parcel.writeTypedObject(getPlainKey(), _aidl_flag);
        return;
    }

    public void readFromParcel(Parcel _aidl_parcel) {
        int _aidl_tag = _aidl_parcel.readInt();
        switch(_aidl_tag) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L5;
        };
    L6:
        SignedPubKey _aidl_value = (SignedPubKey) _aidl_parcel.readTypedObject(SignedPubKey.CREATOR);
        _set(_aidl_tag, _aidl_value);
        return;
    L8:
        PlainPubKey _aidl_value2 = (PlainPubKey) _aidl_parcel.readTypedObject(PlainPubKey.CREATOR);
        _set(_aidl_tag, _aidl_value2);
        return;
    L5:
        throw new IllegalArgumentException("union: unknown tag: " + _aidl_tag);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        switch(getTag()) {
            case 0: goto L6;
            case 1: goto L5;
            default: goto L9;
        };
    L5:
        int _mask = 0 | describeContents(getSignedKey());
        return _mask;
    L6:
        int _mask2 = 0 | describeContents(getPlainKey());
        return _mask2;
    L9:
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
            case 0: goto L7;
            case 1: goto L5;
            default: goto L4;
        };
    L5:
        return "signedKey";
    L7:
        return "plainKey";
    L4:
        throw new IllegalStateException("unknown field: " + _tag);
    }

    private void _set(int _tag, Object _value) {
        this._tag = _tag;
        this._value = _value;
    }
}
