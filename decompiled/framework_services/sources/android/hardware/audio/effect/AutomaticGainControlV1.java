package android.hardware.audio.effect;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class AutomaticGainControlV1 implements Parcelable {
    public static final Parcelable.Creator<AutomaticGainControlV1> CREATOR = null;
    public static final int enableLimiter = 3;
    public static final int maxCompressionGainDb = 2;
    public static final int targetPeakLevelDbFs = 1;

    /* JADX INFO: renamed from: vendor, reason: collision with root package name */
    public static final int f3vendor = 0;
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

        /* synthetic */ Id(Parcel r1, AutomaticGainControlV1IA r2) {
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

    public @interface Tag {
        public static final int enableLimiter = 3;
        public static final int maxCompressionGainDb = 2;
        public static final int targetPeakLevelDbFs = 1;

        /* JADX INFO: renamed from: vendor, reason: collision with root package name */
        public static final int f4vendor = 0;
    }

    /* synthetic */ AutomaticGainControlV1(Parcel r1, AutomaticGainControlV1IA r2) {
        this(r1);
    }

    public AutomaticGainControlV1() {
        this._tag = 0;
        this._value = null;
    }

    private AutomaticGainControlV1(Parcel _aidl_parcel) {
        readFromParcel(_aidl_parcel);
    }

    private AutomaticGainControlV1(int _tag, Object _value) {
        this._tag = _tag;
        this._value = _value;
    }

    public int getTag() {
        return this._tag;
    }

    public static AutomaticGainControlV1 vendor(VendorExtension _value) {
        return new AutomaticGainControlV1(0, _value);
    }

    public VendorExtension getVendor() {
        _assertTag(0);
        return (VendorExtension) this._value;
    }

    public void setVendor(VendorExtension _value) {
        _set(0, _value);
    }

    public static AutomaticGainControlV1 targetPeakLevelDbFs(int _value) {
        return new AutomaticGainControlV1(1, Integer.valueOf(_value));
    }

    public int getTargetPeakLevelDbFs() {
        _assertTag(1);
        return ((Integer) this._value).intValue();
    }

    public void setTargetPeakLevelDbFs(int _value) {
        _set(1, Integer.valueOf(_value));
    }

    public static AutomaticGainControlV1 maxCompressionGainDb(int _value) {
        return new AutomaticGainControlV1(2, Integer.valueOf(_value));
    }

    public int getMaxCompressionGainDb() {
        _assertTag(2);
        return ((Integer) this._value).intValue();
    }

    public void setMaxCompressionGainDb(int _value) {
        _set(2, Integer.valueOf(_value));
    }

    public static AutomaticGainControlV1 enableLimiter(boolean _value) {
        return new AutomaticGainControlV1(3, Boolean.valueOf(_value));
    }

    public boolean getEnableLimiter() {
        _assertTag(3);
        return ((Boolean) this._value).booleanValue();
    }

    public void setEnableLimiter(boolean _value) {
        _set(3, Boolean.valueOf(_value));
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
        _aidl_parcel.writeBoolean(getEnableLimiter());
        return;
    L6:
        _aidl_parcel.writeInt(getMaxCompressionGainDb());
        return;
    L7:
        _aidl_parcel.writeInt(getTargetPeakLevelDbFs());
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
        boolean _aidl_value = _aidl_parcel.readBoolean();
        _set(_aidl_tag, Boolean.valueOf(_aidl_value));
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
        return "enableLimiter";
    L7:
        return "maxCompressionGainDb";
    L9:
        return "targetPeakLevelDbFs";
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
