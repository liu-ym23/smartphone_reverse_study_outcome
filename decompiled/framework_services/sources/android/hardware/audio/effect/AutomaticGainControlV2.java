package android.hardware.audio.effect;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class AutomaticGainControlV2 implements Parcelable {
    public static final Parcelable.Creator<AutomaticGainControlV2> CREATOR = null;
    public static final int fixedDigitalGainMb = 1;
    public static final int levelEstimator = 2;
    public static final int saturationMarginMb = 3;

    /* JADX INFO: renamed from: vendor, reason: collision with root package name */
    public static final int f5vendor = 0;
    private int _tag;
    private Object _value;

    public static final class Id implements Parcelable {
        public static final Parcelable.Creator<Id> CREATOR = null;
        public static final int commonTag = 1;
        public static final int vendorExtensionTag = 0;
        private int _tag;
        private Object _value;

        public @interface Tag {
            public static final int commonTag = 1;
            public static final int vendorExtensionTag = 0;
        }

        /* synthetic */ Id(Parcel r1, AutomaticGainControlV2IA r2) {
            this(r1);
        }

        public Id() {
            this._tag = 0;
            this._value = null;
        }

        private Id(Parcel _aidl_parcel) {
            readFromParcel(_aidl_parcel);
        }

        private Id(int _tag, Object _value) {
            this._tag = _tag;
            this._value = _value;
        }

        public int getTag() {
            return this._tag;
        }

        public static Id vendorExtensionTag(VendorExtension _value) {
            return new Id(0, _value);
        }

        public VendorExtension getVendorExtensionTag() {
            _assertTag(0);
            return (VendorExtension) this._value;
        }

        public void setVendorExtensionTag(VendorExtension _value) {
            _set(0, _value);
        }

        public static Id commonTag(int _value) {
            return new Id(1, Integer.valueOf(_value));
        }

        public int getCommonTag() {
            _assertTag(1);
            return ((Integer) this._value).intValue();
        }

        public void setCommonTag(int _value) {
            _set(1, Integer.valueOf(_value));
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
            _aidl_parcel.writeInt(getCommonTag());
            return;
        L6:
            _aidl_parcel.writeTypedObject(getVendorExtensionTag(), _aidl_flag);
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
            int _aidl_value = _aidl_parcel.readInt();
            _set(_aidl_tag, Integer.valueOf(_aidl_value));
            return;
        L8:
            VendorExtension _aidl_value2 = (VendorExtension) _aidl_parcel.readTypedObject(VendorExtension.CREATOR);
            _set(_aidl_tag, _aidl_value2);
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
            int _mask = 0 | describeContents(getVendorExtensionTag());
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
            return "commonTag";
        L7:
            return "vendorExtensionTag";
        L4:
            throw new IllegalStateException("unknown field: " + _tag);
        }

        private void _set(int _tag, Object _value) {
            this._tag = _tag;
            this._value = _value;
        }
    }

    public @interface LevelEstimator {
        public static final int PEAK = 1;
        public static final int RMS = 0;
    }

    public @interface Tag {
        public static final int fixedDigitalGainMb = 1;
        public static final int levelEstimator = 2;
        public static final int saturationMarginMb = 3;

        /* JADX INFO: renamed from: vendor, reason: collision with root package name */
        public static final int f6vendor = 0;
    }

    /* synthetic */ AutomaticGainControlV2(Parcel r1, AutomaticGainControlV2IA r2) {
        this(r1);
    }

    public AutomaticGainControlV2() {
        this._tag = 0;
        this._value = null;
    }

    private AutomaticGainControlV2(Parcel _aidl_parcel) {
        readFromParcel(_aidl_parcel);
    }

    private AutomaticGainControlV2(int _tag, Object _value) {
        this._tag = _tag;
        this._value = _value;
    }

    public int getTag() {
        return this._tag;
    }

    public static AutomaticGainControlV2 vendor(VendorExtension _value) {
        return new AutomaticGainControlV2(0, _value);
    }

    public VendorExtension getVendor() {
        _assertTag(0);
        return (VendorExtension) this._value;
    }

    public void setVendor(VendorExtension _value) {
        _set(0, _value);
    }

    public static AutomaticGainControlV2 fixedDigitalGainMb(int _value) {
        return new AutomaticGainControlV2(1, Integer.valueOf(_value));
    }

    public int getFixedDigitalGainMb() {
        _assertTag(1);
        return ((Integer) this._value).intValue();
    }

    public void setFixedDigitalGainMb(int _value) {
        _set(1, Integer.valueOf(_value));
    }

    public static AutomaticGainControlV2 levelEstimator(int _value) {
        return new AutomaticGainControlV2(2, Integer.valueOf(_value));
    }

    public int getLevelEstimator() {
        _assertTag(2);
        return ((Integer) this._value).intValue();
    }

    public void setLevelEstimator(int _value) {
        _set(2, Integer.valueOf(_value));
    }

    public static AutomaticGainControlV2 saturationMarginMb(int _value) {
        return new AutomaticGainControlV2(3, Integer.valueOf(_value));
    }

    public int getSaturationMarginMb() {
        _assertTag(3);
        return ((Integer) this._value).intValue();
    }

    public void setSaturationMarginMb(int _value) {
        _set(3, Integer.valueOf(_value));
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
        _aidl_parcel.writeInt(getSaturationMarginMb());
        return;
    L6:
        _aidl_parcel.writeInt(getLevelEstimator());
        return;
    L7:
        _aidl_parcel.writeInt(getFixedDigitalGainMb());
        return;
    L8:
        _aidl_parcel.writeTypedObject(getVendor(), _aidl_flag);
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
        int _aidl_value = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value));
        return;
    L8:
        int _aidl_value2 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value2));
        return;
    L10:
        int _aidl_value3 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value3));
        return;
    L12:
        VendorExtension _aidl_value4 = (VendorExtension) _aidl_parcel.readTypedObject(VendorExtension.CREATOR);
        _set(_aidl_tag, _aidl_value4);
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
        int _mask = 0 | describeContents(getVendor());
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
            case 0: goto L11;
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L5;
            default: goto L4;
        };
    L5:
        return "saturationMarginMb";
    L7:
        return "levelEstimator";
    L9:
        return "fixedDigitalGainMb";
    L11:
        return "vendor";
    L4:
        throw new IllegalStateException("unknown field: " + _tag);
    }

    private void _set(int _tag, Object _value) {
        this._tag = _tag;
        this._value = _value;
    }
}
