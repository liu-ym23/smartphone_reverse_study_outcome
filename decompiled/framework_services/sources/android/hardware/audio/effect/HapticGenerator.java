package android.hardware.audio.effect;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class HapticGenerator implements Parcelable {
    public static final Parcelable.Creator<HapticGenerator> CREATOR = null;
    public static final int hapticScales = 1;

    /* JADX INFO: renamed from: vendor, reason: collision with root package name */
    public static final int f17vendor = 0;
    public static final int vibratorInfo = 2;
    private int _tag;
    private Object _value;

    public static class HapticScale implements Parcelable {
        public static final Parcelable.Creator<HapticScale> CREATOR = null;
        public int id;
        public int scale;

        public HapticScale() {
            this.id = 0;
            this.scale = -100;
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
            _aidl_parcel.writeInt(this.id);
            _aidl_parcel.writeInt(this.scale);
            int _aidl_end_pos = _aidl_parcel.dataPosition();
            _aidl_parcel.setDataPosition(_aidl_start_pos);
            _aidl_parcel.writeInt(_aidl_end_pos - _aidl_start_pos);
            _aidl_parcel.setDataPosition(_aidl_end_pos);
        }

        public final void readFromParcel(Parcel _aidl_parcel) {
            int _aidl_start_pos = _aidl_parcel.dataPosition();
            int _aidl_parcelable_size = _aidl_parcel.readInt();
            if (_aidl_parcelable_size < 4) goto L32;
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L8;
            this.id = _aidl_parcel.readInt();     // Catch: Throwable -> L29
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
            this.scale = _aidl_parcel.readInt();     // Catch: Throwable -> L29
            if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L28;
            _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
            return;
        L28:
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
        L32:
            throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L29
        L29:
            th = move-exception;
            if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L36;
            _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
            throw th;
        L36:
            throw new BadParcelableException("Overflow in the size of parcelable");
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }
    }

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

        /* synthetic */ Id(Parcel r1, HapticGeneratorIA r2) {
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
        public static final int hapticScales = 1;

        /* JADX INFO: renamed from: vendor, reason: collision with root package name */
        public static final int f18vendor = 0;
        public static final int vibratorInfo = 2;
    }

    public static class VibratorInformation implements Parcelable {
        public static final Parcelable.Creator<VibratorInformation> CREATOR = null;
        public float maxAmplitude;
        public float qFactor;
        public float resonantFrequencyHz;

        public VibratorInformation() {
            this.resonantFrequencyHz = 0.0f;
            this.qFactor = 0.0f;
            this.maxAmplitude = 0.0f;
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
            _aidl_parcel.writeFloat(this.resonantFrequencyHz);
            _aidl_parcel.writeFloat(this.qFactor);
            _aidl_parcel.writeFloat(this.maxAmplitude);
            int _aidl_end_pos = _aidl_parcel.dataPosition();
            _aidl_parcel.setDataPosition(_aidl_start_pos);
            _aidl_parcel.writeInt(_aidl_end_pos - _aidl_start_pos);
            _aidl_parcel.setDataPosition(_aidl_end_pos);
        }

        public final void readFromParcel(Parcel _aidl_parcel) {
            int _aidl_start_pos = _aidl_parcel.dataPosition();
            int _aidl_parcelable_size = _aidl_parcel.readInt();
            if (_aidl_parcelable_size < 4) goto L41;
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L8;
            this.resonantFrequencyHz = _aidl_parcel.readFloat();     // Catch: Throwable -> L38
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
            this.qFactor = _aidl_parcel.readFloat();     // Catch: Throwable -> L38
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L26;
            this.maxAmplitude = _aidl_parcel.readFloat();     // Catch: Throwable -> L38
            if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L37;
            _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
            return;
        L37:
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
        L41:
            throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L38
        L38:
            th = move-exception;
            if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L45;
            _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
            throw th;
        L45:
            throw new BadParcelableException("Overflow in the size of parcelable");
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }
    }

    public @interface VibratorScale {
        public static final int HIGH = 1;
        public static final int LOW = -1;
        public static final int MUTE = -100;
        public static final int NONE = 0;
        public static final int VERY_HIGH = 2;
        public static final int VERY_LOW = -2;
    }

    /* synthetic */ HapticGenerator(Parcel r1, HapticGeneratorIA r2) {
        this(r1);
    }

    public HapticGenerator() {
        this._tag = 0;
        this._value = null;
    }

    private HapticGenerator(Parcel _aidl_parcel) {
        readFromParcel(_aidl_parcel);
    }

    private HapticGenerator(int _tag, Object _value) {
        this._tag = _tag;
        this._value = _value;
    }

    public int getTag() {
        return this._tag;
    }

    public static HapticGenerator vendor(VendorExtension _value) {
        return new HapticGenerator(0, _value);
    }

    public VendorExtension getVendor() {
        _assertTag(0);
        return (VendorExtension) this._value;
    }

    public void setVendor(VendorExtension _value) {
        _set(0, _value);
    }

    public static HapticGenerator hapticScales(HapticScale[] _value) {
        return new HapticGenerator(1, _value);
    }

    public HapticScale[] getHapticScales() {
        _assertTag(1);
        return (HapticScale[]) this._value;
    }

    public void setHapticScales(HapticScale[] _value) {
        _set(1, _value);
    }

    public static HapticGenerator vibratorInfo(VibratorInformation _value) {
        return new HapticGenerator(2, _value);
    }

    public VibratorInformation getVibratorInfo() {
        _assertTag(2);
        return (VibratorInformation) this._value;
    }

    public void setVibratorInfo(VibratorInformation _value) {
        _set(2, _value);
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
        _aidl_parcel.writeTypedObject(getVibratorInfo(), _aidl_flag);
        return;
    L6:
        _aidl_parcel.writeTypedArray(getHapticScales(), _aidl_flag);
        return;
    L7:
        _aidl_parcel.writeTypedObject(getVendor(), _aidl_flag);
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
        VibratorInformation _aidl_value = (VibratorInformation) _aidl_parcel.readTypedObject(VibratorInformation.CREATOR);
        _set(_aidl_tag, _aidl_value);
        return;
    L8:
        HapticScale[] _aidl_value2 = (HapticScale[]) _aidl_parcel.createTypedArray(HapticScale.CREATOR);
        _set(_aidl_tag, _aidl_value2);
        return;
    L10:
        VendorExtension _aidl_value3 = (VendorExtension) _aidl_parcel.readTypedObject(VendorExtension.CREATOR);
        _set(_aidl_tag, _aidl_value3);
        return;
    L5:
        throw new IllegalArgumentException("union: unknown tag: " + _aidl_tag);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        switch(getTag()) {
            case 0: goto L7;
            case 1: goto L6;
            case 2: goto L5;
            default: goto L11;
        };
    L5:
        int _mask = 0 | describeContents(getVibratorInfo());
        return _mask;
    L6:
        int _mask2 = 0 | describeContents(getHapticScales());
        return _mask2;
    L7:
        int _mask3 = 0 | describeContents(getVendor());
        return _mask3;
    L11:
        return 0;
    }

    private int describeContents(Object _v) {
        int r0 = 0;
        if (_v != null) goto L6;
        return 0;
    L6:
        if ((_v instanceof Object[]) == false) goto L12;
        int _mask = 0;
        Object[] r2 = (Object[]) _v;
        int r3 = r2.length;
    L8:
        if (r0 >= r3) goto L10;
        Object o = r2[r0];
        _mask = _mask | describeContents(o);
        r0 = r0 + 1;
        goto L8
    L10:
        return _mask;
    L12:
        if ((_v instanceof Parcelable) == true) goto L14;
        return 0;
    L14:
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
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L4;
        };
    L5:
        return "vibratorInfo";
    L7:
        return "hapticScales";
    L9:
        return "vendor";
    L4:
        throw new IllegalStateException("unknown field: " + _tag);
    }

    private void _set(int _tag, Object _value) {
        this._tag = _tag;
        this._value = _value;
    }
}
