package android.hardware.tv.mediaquality;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.server.timezonedetector.ServiceConfigAccessor;

/* JADX INFO: loaded from: classes.dex */
public final class AmbientBacklightEvent implements Parcelable {
    public static final Parcelable.Creator<AmbientBacklightEvent> CREATOR = null;
    public static final int enabled = 0;
    public static final int metadata = 1;
    private int _tag;
    private Object _value;

    public @interface Tag {
        public static final int enabled = 0;
        public static final int metadata = 1;
    }

    /* synthetic */ AmbientBacklightEvent(Parcel r1, AmbientBacklightEventIA r2) {
        this(r1);
    }

    public AmbientBacklightEvent() {
        this._tag = 0;
        this._value = false;
    }

    private AmbientBacklightEvent(Parcel _aidl_parcel) {
        readFromParcel(_aidl_parcel);
    }

    private AmbientBacklightEvent(int _tag, Object _value) {
        this._tag = _tag;
        this._value = _value;
    }

    public int getTag() {
        return this._tag;
    }

    public static AmbientBacklightEvent enabled(boolean _value) {
        return new AmbientBacklightEvent(0, Boolean.valueOf(_value));
    }

    public boolean getEnabled() {
        _assertTag(0);
        return ((Boolean) this._value).booleanValue();
    }

    public void setEnabled(boolean _value) {
        _set(0, Boolean.valueOf(_value));
    }

    public static AmbientBacklightEvent metadata(AmbientBacklightMetadata _value) {
        return new AmbientBacklightEvent(1, _value);
    }

    public AmbientBacklightMetadata getMetadata() {
        _assertTag(1);
        return (AmbientBacklightMetadata) this._value;
    }

    public void setMetadata(AmbientBacklightMetadata _value) {
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
        _aidl_parcel.writeTypedObject(getMetadata(), _aidl_flag);
        return;
    L6:
        _aidl_parcel.writeBoolean(getEnabled());
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
        AmbientBacklightMetadata _aidl_value = (AmbientBacklightMetadata) _aidl_parcel.readTypedObject(AmbientBacklightMetadata.CREATOR);
        _set(_aidl_tag, _aidl_value);
        return;
    L8:
        boolean _aidl_value2 = _aidl_parcel.readBoolean();
        _set(_aidl_tag, Boolean.valueOf(_aidl_value2));
        return;
    L5:
        throw new IllegalArgumentException("union: unknown tag: " + _aidl_tag);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        switch(getTag()) {
            case 1: goto L5;
            default: goto L7;
        };
    L5:
        int _mask = 0 | describeContents(getMetadata());
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
            case 0: goto L7;
            case 1: goto L5;
            default: goto L4;
        };
    L5:
        return "metadata";
    L7:
        return ServiceConfigAccessor.PROVIDER_MODE_ENABLED;
    L4:
        throw new IllegalStateException("unknown field: " + _tag);
    }

    private void _set(int _tag, Object _value) {
        this._tag = _tag;
        this._value = _value;
    }
}
