package android.hardware.usb;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class AltModeData implements Parcelable {
    public static final Parcelable.Creator<AltModeData> CREATOR = null;
    public static final int displayPortAltModeData = 0;
    private int _tag;
    private Object _value;

    public static class DisplayPortAltModeData implements Parcelable {
        public static final Parcelable.Creator<DisplayPortAltModeData> CREATOR = null;
        public int cableStatus;
        public boolean hpd;
        public int linkTrainingStatus;
        public int partnerSinkStatus;
        public int pinAssignment;

        public DisplayPortAltModeData() {
            this.partnerSinkStatus = 0;
            this.cableStatus = 0;
            this.pinAssignment = 0;
            this.hpd = false;
            this.linkTrainingStatus = 0;
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
            _aidl_parcel.writeInt(this.partnerSinkStatus);
            _aidl_parcel.writeInt(this.cableStatus);
            _aidl_parcel.writeInt(this.pinAssignment);
            _aidl_parcel.writeBoolean(this.hpd);
            _aidl_parcel.writeInt(this.linkTrainingStatus);
            int _aidl_end_pos = _aidl_parcel.dataPosition();
            _aidl_parcel.setDataPosition(_aidl_start_pos);
            _aidl_parcel.writeInt(_aidl_end_pos - _aidl_start_pos);
            _aidl_parcel.setDataPosition(_aidl_end_pos);
        }

        public final void readFromParcel(Parcel _aidl_parcel) {
            int _aidl_start_pos = _aidl_parcel.dataPosition();
            int _aidl_parcelable_size = _aidl_parcel.readInt();
            if (_aidl_parcelable_size < 4) goto L59;
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L8;
            this.partnerSinkStatus = _aidl_parcel.readInt();     // Catch: Throwable -> L56
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
            this.cableStatus = _aidl_parcel.readInt();     // Catch: Throwable -> L56
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L26;
            this.pinAssignment = _aidl_parcel.readInt();     // Catch: Throwable -> L56
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L35;
            this.hpd = _aidl_parcel.readBoolean();     // Catch: Throwable -> L56
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L44;
            this.linkTrainingStatus = _aidl_parcel.readInt();     // Catch: Throwable -> L56
            if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L55;
            _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
            return;
        L55:
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
        L59:
            throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L56
        L56:
            th = move-exception;
            if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L63;
            _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
            throw th;
        L63:
            throw new BadParcelableException("Overflow in the size of parcelable");
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }
    }

    public @interface Tag {
        public static final int displayPortAltModeData = 0;
    }

    /* synthetic */ AltModeData(Parcel r1, AltModeDataIA r2) {
        this(r1);
    }

    public AltModeData() {
        this._tag = 0;
        this._value = null;
    }

    private AltModeData(Parcel _aidl_parcel) {
        readFromParcel(_aidl_parcel);
    }

    private AltModeData(int _tag, Object _value) {
        this._tag = _tag;
        this._value = _value;
    }

    public int getTag() {
        return this._tag;
    }

    public static AltModeData displayPortAltModeData(DisplayPortAltModeData _value) {
        return new AltModeData(0, _value);
    }

    public DisplayPortAltModeData getDisplayPortAltModeData() {
        _assertTag(0);
        return (DisplayPortAltModeData) this._value;
    }

    public void setDisplayPortAltModeData(DisplayPortAltModeData _value) {
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
        _aidl_parcel.writeTypedObject(getDisplayPortAltModeData(), _aidl_flag);
        return;
    }

    public void readFromParcel(Parcel _aidl_parcel) {
        int _aidl_tag = _aidl_parcel.readInt();
        switch(_aidl_tag) {
            case 0: goto L6;
            default: goto L5;
        };
    L6:
        DisplayPortAltModeData _aidl_value = (DisplayPortAltModeData) _aidl_parcel.readTypedObject(DisplayPortAltModeData.CREATOR);
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
        int _mask = 0 | describeContents(getDisplayPortAltModeData());
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
        return "displayPortAltModeData";
    L4:
        throw new IllegalStateException("unknown field: " + _tag);
    }

    private void _set(int _tag, Object _value) {
        this._tag = _tag;
        this._value = _value;
    }
}
