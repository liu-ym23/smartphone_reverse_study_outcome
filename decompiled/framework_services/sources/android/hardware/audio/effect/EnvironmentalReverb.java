package android.hardware.audio.effect;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class EnvironmentalReverb implements Parcelable {
    public static final Parcelable.Creator<EnvironmentalReverb> CREATOR = null;
    public static final int bypass = 11;
    public static final int decayHfRatioPm = 4;
    public static final int decayTimeMs = 3;
    public static final int delayMs = 8;
    public static final int densityPm = 10;
    public static final int diffusionPm = 9;
    public static final int levelMb = 7;
    public static final int reflectionsDelayMs = 6;
    public static final int reflectionsLevelMb = 5;
    public static final int roomHfLevelMb = 2;
    public static final int roomLevelMb = 1;

    /* JADX INFO: renamed from: vendor, reason: collision with root package name */
    public static final int f13vendor = 0;
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

        /* synthetic */ Id(Parcel r1, EnvironmentalReverbIA r2) {
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
        public static final int bypass = 11;
        public static final int decayHfRatioPm = 4;
        public static final int decayTimeMs = 3;
        public static final int delayMs = 8;
        public static final int densityPm = 10;
        public static final int diffusionPm = 9;
        public static final int levelMb = 7;
        public static final int reflectionsDelayMs = 6;
        public static final int reflectionsLevelMb = 5;
        public static final int roomHfLevelMb = 2;
        public static final int roomLevelMb = 1;

        /* JADX INFO: renamed from: vendor, reason: collision with root package name */
        public static final int f14vendor = 0;
    }

    /* synthetic */ EnvironmentalReverb(Parcel r1, EnvironmentalReverbIA r2) {
        this(r1);
    }

    public EnvironmentalReverb() {
        this._tag = 0;
        this._value = null;
    }

    private EnvironmentalReverb(Parcel _aidl_parcel) {
        readFromParcel(_aidl_parcel);
    }

    private EnvironmentalReverb(int _tag, Object _value) {
        this._tag = _tag;
        this._value = _value;
    }

    public int getTag() {
        return this._tag;
    }

    public static EnvironmentalReverb vendor(VendorExtension _value) {
        return new EnvironmentalReverb(0, _value);
    }

    public VendorExtension getVendor() {
        _assertTag(0);
        return (VendorExtension) this._value;
    }

    public void setVendor(VendorExtension _value) {
        _set(0, _value);
    }

    public static EnvironmentalReverb roomLevelMb(int _value) {
        return new EnvironmentalReverb(1, Integer.valueOf(_value));
    }

    public int getRoomLevelMb() {
        _assertTag(1);
        return ((Integer) this._value).intValue();
    }

    public void setRoomLevelMb(int _value) {
        _set(1, Integer.valueOf(_value));
    }

    public static EnvironmentalReverb roomHfLevelMb(int _value) {
        return new EnvironmentalReverb(2, Integer.valueOf(_value));
    }

    public int getRoomHfLevelMb() {
        _assertTag(2);
        return ((Integer) this._value).intValue();
    }

    public void setRoomHfLevelMb(int _value) {
        _set(2, Integer.valueOf(_value));
    }

    public static EnvironmentalReverb decayTimeMs(int _value) {
        return new EnvironmentalReverb(3, Integer.valueOf(_value));
    }

    public int getDecayTimeMs() {
        _assertTag(3);
        return ((Integer) this._value).intValue();
    }

    public void setDecayTimeMs(int _value) {
        _set(3, Integer.valueOf(_value));
    }

    public static EnvironmentalReverb decayHfRatioPm(int _value) {
        return new EnvironmentalReverb(4, Integer.valueOf(_value));
    }

    public int getDecayHfRatioPm() {
        _assertTag(4);
        return ((Integer) this._value).intValue();
    }

    public void setDecayHfRatioPm(int _value) {
        _set(4, Integer.valueOf(_value));
    }

    public static EnvironmentalReverb reflectionsLevelMb(int _value) {
        return new EnvironmentalReverb(5, Integer.valueOf(_value));
    }

    public int getReflectionsLevelMb() {
        _assertTag(5);
        return ((Integer) this._value).intValue();
    }

    public void setReflectionsLevelMb(int _value) {
        _set(5, Integer.valueOf(_value));
    }

    public static EnvironmentalReverb reflectionsDelayMs(int _value) {
        return new EnvironmentalReverb(6, Integer.valueOf(_value));
    }

    public int getReflectionsDelayMs() {
        _assertTag(6);
        return ((Integer) this._value).intValue();
    }

    public void setReflectionsDelayMs(int _value) {
        _set(6, Integer.valueOf(_value));
    }

    public static EnvironmentalReverb levelMb(int _value) {
        return new EnvironmentalReverb(7, Integer.valueOf(_value));
    }

    public int getLevelMb() {
        _assertTag(7);
        return ((Integer) this._value).intValue();
    }

    public void setLevelMb(int _value) {
        _set(7, Integer.valueOf(_value));
    }

    public static EnvironmentalReverb delayMs(int _value) {
        return new EnvironmentalReverb(8, Integer.valueOf(_value));
    }

    public int getDelayMs() {
        _assertTag(8);
        return ((Integer) this._value).intValue();
    }

    public void setDelayMs(int _value) {
        _set(8, Integer.valueOf(_value));
    }

    public static EnvironmentalReverb diffusionPm(int _value) {
        return new EnvironmentalReverb(9, Integer.valueOf(_value));
    }

    public int getDiffusionPm() {
        _assertTag(9);
        return ((Integer) this._value).intValue();
    }

    public void setDiffusionPm(int _value) {
        _set(9, Integer.valueOf(_value));
    }

    public static EnvironmentalReverb densityPm(int _value) {
        return new EnvironmentalReverb(10, Integer.valueOf(_value));
    }

    public int getDensityPm() {
        _assertTag(10);
        return ((Integer) this._value).intValue();
    }

    public void setDensityPm(int _value) {
        _set(10, Integer.valueOf(_value));
    }

    public static EnvironmentalReverb bypass(boolean _value) {
        return new EnvironmentalReverb(11, Boolean.valueOf(_value));
    }

    public boolean getBypass() {
        _assertTag(11);
        return ((Boolean) this._value).booleanValue();
    }

    public void setBypass(boolean _value) {
        _set(11, Boolean.valueOf(_value));
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
            case 0: goto L16;
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            case 10: goto L6;
            case 11: goto L5;
            default: goto L29;
        };
    L5:
        _aidl_parcel.writeBoolean(getBypass());
        return;
    L6:
        _aidl_parcel.writeInt(getDensityPm());
        return;
    L7:
        _aidl_parcel.writeInt(getDiffusionPm());
        return;
    L8:
        _aidl_parcel.writeInt(getDelayMs());
        return;
    L9:
        _aidl_parcel.writeInt(getLevelMb());
        return;
    L10:
        _aidl_parcel.writeInt(getReflectionsDelayMs());
        return;
    L11:
        _aidl_parcel.writeInt(getReflectionsLevelMb());
        return;
    L12:
        _aidl_parcel.writeInt(getDecayHfRatioPm());
        return;
    L13:
        _aidl_parcel.writeInt(getDecayTimeMs());
        return;
    L14:
        _aidl_parcel.writeInt(getRoomHfLevelMb());
        return;
    L15:
        _aidl_parcel.writeInt(getRoomLevelMb());
        return;
    L16:
        _aidl_parcel.writeTypedObject(getVendor(), _aidl_flag);
        return;
    }

    public void readFromParcel(Parcel _aidl_parcel) {
        int _aidl_tag = _aidl_parcel.readInt();
        switch(_aidl_tag) {
            case 0: goto L28;
            case 1: goto L26;
            case 2: goto L24;
            case 3: goto L22;
            case 4: goto L20;
            case 5: goto L18;
            case 6: goto L16;
            case 7: goto L14;
            case 8: goto L12;
            case 9: goto L10;
            case 10: goto L8;
            case 11: goto L6;
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
        int _aidl_value4 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value4));
        return;
    L14:
        int _aidl_value5 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value5));
        return;
    L16:
        int _aidl_value6 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value6));
        return;
    L18:
        int _aidl_value7 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value7));
        return;
    L20:
        int _aidl_value8 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value8));
        return;
    L22:
        int _aidl_value9 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value9));
        return;
    L24:
        int _aidl_value10 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value10));
        return;
    L26:
        int _aidl_value11 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value11));
        return;
    L28:
        VendorExtension _aidl_value12 = (VendorExtension) _aidl_parcel.readTypedObject(VendorExtension.CREATOR);
        _set(_aidl_tag, _aidl_value12);
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
            case 0: goto L27;
            case 1: goto L25;
            case 2: goto L23;
            case 3: goto L21;
            case 4: goto L19;
            case 5: goto L17;
            case 6: goto L15;
            case 7: goto L13;
            case 8: goto L11;
            case 9: goto L9;
            case 10: goto L7;
            case 11: goto L5;
            default: goto L4;
        };
    L5:
        return "bypass";
    L7:
        return "densityPm";
    L9:
        return "diffusionPm";
    L11:
        return "delayMs";
    L13:
        return "levelMb";
    L15:
        return "reflectionsDelayMs";
    L17:
        return "reflectionsLevelMb";
    L19:
        return "decayHfRatioPm";
    L21:
        return "decayTimeMs";
    L23:
        return "roomHfLevelMb";
    L25:
        return "roomLevelMb";
    L27:
        return "vendor";
    L4:
        throw new IllegalStateException("unknown field: " + _tag);
    }

    private void _set(int _tag, Object _value) {
        this._tag = _tag;
        this._value = _value;
    }
}
