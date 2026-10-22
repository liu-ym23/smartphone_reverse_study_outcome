package android.hardware.audio.effect;

import android.media.audio.common.AudioChannelLayout;
import android.media.audio.common.AudioDeviceDescription;
import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class Virtualizer implements Parcelable {
    public static final Parcelable.Creator<Virtualizer> CREATOR = null;
    public static final int device = 3;
    public static final int speakerAngles = 2;
    public static final int strengthPm = 1;

    /* JADX INFO: renamed from: vendor, reason: collision with root package name */
    public static final int f25vendor = 0;
    private int _tag;
    private Object _value;

    public static class ChannelAngle implements Parcelable {
        public static final Parcelable.Creator<ChannelAngle> CREATOR = null;
        public int azimuthDegree;
        public int channel;
        public int elevationDegree;

        public ChannelAngle() {
            this.channel = 0;
            this.azimuthDegree = 0;
            this.elevationDegree = 0;
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
            _aidl_parcel.writeInt(this.channel);
            _aidl_parcel.writeInt(this.azimuthDegree);
            _aidl_parcel.writeInt(this.elevationDegree);
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
            this.channel = _aidl_parcel.readInt();     // Catch: Throwable -> L38
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
            this.azimuthDegree = _aidl_parcel.readInt();     // Catch: Throwable -> L38
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L26;
            this.elevationDegree = _aidl_parcel.readInt();     // Catch: Throwable -> L38
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

    public static final class Id implements Parcelable {
        public static final Parcelable.Creator<Id> CREATOR = null;
        public static final int commonTag = 1;
        public static final int speakerAnglesPayload = 2;
        public static final int vendorExtensionTag = 0;
        private int _tag;
        private Object _value;

        public @interface Tag {
            public static final int commonTag = 1;
            public static final int speakerAnglesPayload = 2;
            public static final int vendorExtensionTag = 0;
        }

        /* synthetic */ Id(Parcel r1, VirtualizerIA r2) {
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

        public static Id speakerAnglesPayload(SpeakerAnglesPayload _value) {
            return new Id(2, _value);
        }

        public SpeakerAnglesPayload getSpeakerAnglesPayload() {
            _assertTag(2);
            return (SpeakerAnglesPayload) this._value;
        }

        public void setSpeakerAnglesPayload(SpeakerAnglesPayload _value) {
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
            _aidl_parcel.writeTypedObject(getSpeakerAnglesPayload(), _aidl_flag);
            return;
        L6:
            _aidl_parcel.writeInt(getCommonTag());
            return;
        L7:
            _aidl_parcel.writeTypedObject(getVendorExtensionTag(), _aidl_flag);
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
            SpeakerAnglesPayload _aidl_value = (SpeakerAnglesPayload) _aidl_parcel.readTypedObject(SpeakerAnglesPayload.CREATOR);
            _set(_aidl_tag, _aidl_value);
            return;
        L8:
            int _aidl_value2 = _aidl_parcel.readInt();
            _set(_aidl_tag, Integer.valueOf(_aidl_value2));
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
                case 0: goto L6;
                case 1: goto L9;
                case 2: goto L5;
                default: goto L9;
            };
        L5:
            int _mask = 0 | describeContents(getSpeakerAnglesPayload());
            return _mask;
        L6:
            int _mask2 = 0 | describeContents(getVendorExtensionTag());
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
                case 0: goto L9;
                case 1: goto L7;
                case 2: goto L5;
                default: goto L4;
            };
        L5:
            return "speakerAnglesPayload";
        L7:
            return "commonTag";
        L9:
            return "vendorExtensionTag";
        L4:
            throw new IllegalStateException("unknown field: " + _tag);
        }

        private void _set(int _tag, Object _value) {
            this._tag = _tag;
            this._value = _value;
        }
    }

    public static class SpeakerAnglesPayload implements Parcelable {
        public static final Parcelable.Creator<SpeakerAnglesPayload> CREATOR = null;
        public AudioDeviceDescription device;
        public AudioChannelLayout layout;

        public SpeakerAnglesPayload() {
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
            _aidl_parcel.writeTypedObject(this.layout, _aidl_flag);
            _aidl_parcel.writeTypedObject(this.device, _aidl_flag);
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
            this.layout = (AudioChannelLayout) _aidl_parcel.readTypedObject(AudioChannelLayout.CREATOR);     // Catch: Throwable -> L29
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
            this.device = (AudioDeviceDescription) _aidl_parcel.readTypedObject(AudioDeviceDescription.CREATOR);     // Catch: Throwable -> L29
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
            int _mask = 0 | describeContents(this.layout);
            return _mask | describeContents(this.device);
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
    }

    public @interface Tag {
        public static final int device = 3;
        public static final int speakerAngles = 2;
        public static final int strengthPm = 1;

        /* JADX INFO: renamed from: vendor, reason: collision with root package name */
        public static final int f26vendor = 0;
    }

    /* synthetic */ Virtualizer(Parcel r1, VirtualizerIA r2) {
        this(r1);
    }

    public Virtualizer() {
        this._tag = 0;
        this._value = null;
    }

    private Virtualizer(Parcel _aidl_parcel) {
        readFromParcel(_aidl_parcel);
    }

    private Virtualizer(int _tag, Object _value) {
        this._tag = _tag;
        this._value = _value;
    }

    public int getTag() {
        return this._tag;
    }

    public static Virtualizer vendor(VendorExtension _value) {
        return new Virtualizer(0, _value);
    }

    public VendorExtension getVendor() {
        _assertTag(0);
        return (VendorExtension) this._value;
    }

    public void setVendor(VendorExtension _value) {
        _set(0, _value);
    }

    public static Virtualizer strengthPm(int _value) {
        return new Virtualizer(1, Integer.valueOf(_value));
    }

    public int getStrengthPm() {
        _assertTag(1);
        return ((Integer) this._value).intValue();
    }

    public void setStrengthPm(int _value) {
        _set(1, Integer.valueOf(_value));
    }

    public static Virtualizer speakerAngles(ChannelAngle[] _value) {
        return new Virtualizer(2, _value);
    }

    public ChannelAngle[] getSpeakerAngles() {
        _assertTag(2);
        return (ChannelAngle[]) this._value;
    }

    public void setSpeakerAngles(ChannelAngle[] _value) {
        _set(2, _value);
    }

    public static Virtualizer device(AudioDeviceDescription _value) {
        return new Virtualizer(3, _value);
    }

    public AudioDeviceDescription getDevice() {
        _assertTag(3);
        return (AudioDeviceDescription) this._value;
    }

    public void setDevice(AudioDeviceDescription _value) {
        _set(3, _value);
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
        _aidl_parcel.writeTypedObject(getDevice(), _aidl_flag);
        return;
    L6:
        _aidl_parcel.writeTypedArray(getSpeakerAngles(), _aidl_flag);
        return;
    L7:
        _aidl_parcel.writeInt(getStrengthPm());
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
        AudioDeviceDescription _aidl_value = (AudioDeviceDescription) _aidl_parcel.readTypedObject(AudioDeviceDescription.CREATOR);
        _set(_aidl_tag, _aidl_value);
        return;
    L8:
        ChannelAngle[] _aidl_value2 = (ChannelAngle[]) _aidl_parcel.createTypedArray(ChannelAngle.CREATOR);
        _set(_aidl_tag, _aidl_value2);
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
            case 0: goto L7;
            case 1: goto L11;
            case 2: goto L6;
            case 3: goto L5;
            default: goto L11;
        };
    L5:
        int _mask = 0 | describeContents(getDevice());
        return _mask;
    L6:
        int _mask2 = 0 | describeContents(getSpeakerAngles());
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
            case 0: goto L11;
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L5;
            default: goto L4;
        };
    L5:
        return "device";
    L7:
        return "speakerAngles";
    L9:
        return "strengthPm";
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
