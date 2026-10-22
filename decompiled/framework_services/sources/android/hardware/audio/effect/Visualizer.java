package android.hardware.audio.effect;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class Visualizer implements Parcelable {
    public static final Parcelable.Creator<Visualizer> CREATOR = null;
    public static final int captureSampleBuffer = 3;
    public static final int captureSamples = 5;
    public static final int id = 0;
    public static final int latencyMs = 4;
    public static final int measurement = 2;
    public static final int measurementMode = 7;
    public static final int scalingMode = 6;

    /* JADX INFO: renamed from: vendor, reason: collision with root package name */
    public static final int f27vendor = 1;
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

        /* synthetic */ Id(Parcel r1, VisualizerIA r2) {
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

    public static class Measurement implements Parcelable {
        public static final Parcelable.Creator<Measurement> CREATOR = null;
        public int peak;
        public int rms;

        public Measurement() {
            this.rms = 0;
            this.peak = 0;
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
            _aidl_parcel.writeInt(this.rms);
            _aidl_parcel.writeInt(this.peak);
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
            this.rms = _aidl_parcel.readInt();     // Catch: Throwable -> L29
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
            this.peak = _aidl_parcel.readInt();     // Catch: Throwable -> L29
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

    public @interface MeasurementMode {
        public static final byte NONE = 0;
        public static final byte PEAK_RMS = 1;
    }

    public @interface ScalingMode {
        public static final byte AS_PLAYED = 1;
        public static final byte NORMALIZED = 0;
    }

    public @interface Tag {
        public static final int captureSampleBuffer = 3;
        public static final int captureSamples = 5;
        public static final int id = 0;
        public static final int latencyMs = 4;
        public static final int measurement = 2;
        public static final int measurementMode = 7;
        public static final int scalingMode = 6;

        /* JADX INFO: renamed from: vendor, reason: collision with root package name */
        public static final int f28vendor = 1;
    }

    /* synthetic */ Visualizer(Parcel r1, VisualizerIA r2) {
        this(r1);
    }

    public Visualizer() {
        this._tag = 0;
        this._value = null;
    }

    private Visualizer(Parcel _aidl_parcel) {
        readFromParcel(_aidl_parcel);
    }

    private Visualizer(int _tag, Object _value) {
        this._tag = _tag;
        this._value = _value;
    }

    public int getTag() {
        return this._tag;
    }

    public static Visualizer id(Id _value) {
        return new Visualizer(0, _value);
    }

    public Id getId() {
        _assertTag(0);
        return (Id) this._value;
    }

    public void setId(Id _value) {
        _set(0, _value);
    }

    public static Visualizer vendor(VendorExtension _value) {
        return new Visualizer(1, _value);
    }

    public VendorExtension getVendor() {
        _assertTag(1);
        return (VendorExtension) this._value;
    }

    public void setVendor(VendorExtension _value) {
        _set(1, _value);
    }

    public static Visualizer measurement(Measurement _value) {
        return new Visualizer(2, _value);
    }

    public Measurement getMeasurement() {
        _assertTag(2);
        return (Measurement) this._value;
    }

    public void setMeasurement(Measurement _value) {
        _set(2, _value);
    }

    public static Visualizer captureSampleBuffer(byte[] _value) {
        return new Visualizer(3, _value);
    }

    public byte[] getCaptureSampleBuffer() {
        _assertTag(3);
        return (byte[]) this._value;
    }

    public void setCaptureSampleBuffer(byte[] _value) {
        _set(3, _value);
    }

    public static Visualizer latencyMs(int _value) {
        return new Visualizer(4, Integer.valueOf(_value));
    }

    public int getLatencyMs() {
        _assertTag(4);
        return ((Integer) this._value).intValue();
    }

    public void setLatencyMs(int _value) {
        _set(4, Integer.valueOf(_value));
    }

    public static Visualizer captureSamples(int _value) {
        return new Visualizer(5, Integer.valueOf(_value));
    }

    public int getCaptureSamples() {
        _assertTag(5);
        return ((Integer) this._value).intValue();
    }

    public void setCaptureSamples(int _value) {
        _set(5, Integer.valueOf(_value));
    }

    public static Visualizer scalingMode(byte _value) {
        return new Visualizer(6, Byte.valueOf(_value));
    }

    public byte getScalingMode() {
        _assertTag(6);
        return ((Byte) this._value).byteValue();
    }

    public void setScalingMode(byte _value) {
        _set(6, Byte.valueOf(_value));
    }

    public static Visualizer measurementMode(byte _value) {
        return new Visualizer(7, Byte.valueOf(_value));
    }

    public byte getMeasurementMode() {
        _assertTag(7);
        return ((Byte) this._value).byteValue();
    }

    public void setMeasurementMode(byte _value) {
        _set(7, Byte.valueOf(_value));
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
            case 0: goto L12;
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L21;
        };
    L5:
        _aidl_parcel.writeByte(getMeasurementMode());
        return;
    L6:
        _aidl_parcel.writeByte(getScalingMode());
        return;
    L7:
        _aidl_parcel.writeInt(getCaptureSamples());
        return;
    L8:
        _aidl_parcel.writeInt(getLatencyMs());
        return;
    L9:
        _aidl_parcel.writeByteArray(getCaptureSampleBuffer());
        return;
    L10:
        _aidl_parcel.writeTypedObject(getMeasurement(), _aidl_flag);
        return;
    L11:
        _aidl_parcel.writeTypedObject(getVendor(), _aidl_flag);
        return;
    L12:
        _aidl_parcel.writeTypedObject(getId(), _aidl_flag);
        return;
    }

    public void readFromParcel(Parcel _aidl_parcel) {
        int _aidl_tag = _aidl_parcel.readInt();
        switch(_aidl_tag) {
            case 0: goto L20;
            case 1: goto L18;
            case 2: goto L16;
            case 3: goto L14;
            case 4: goto L12;
            case 5: goto L10;
            case 6: goto L8;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        byte _aidl_value = _aidl_parcel.readByte();
        _set(_aidl_tag, Byte.valueOf(_aidl_value));
        return;
    L8:
        byte _aidl_value2 = _aidl_parcel.readByte();
        _set(_aidl_tag, Byte.valueOf(_aidl_value2));
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
        byte[] _aidl_value5 = _aidl_parcel.createByteArray();
        _set(_aidl_tag, _aidl_value5);
        return;
    L16:
        Measurement _aidl_value6 = (Measurement) _aidl_parcel.readTypedObject(Measurement.CREATOR);
        _set(_aidl_tag, _aidl_value6);
        return;
    L18:
        VendorExtension _aidl_value7 = (VendorExtension) _aidl_parcel.readTypedObject(VendorExtension.CREATOR);
        _set(_aidl_tag, _aidl_value7);
        return;
    L20:
        Id _aidl_value8 = (Id) _aidl_parcel.readTypedObject(Id.CREATOR);
        _set(_aidl_tag, _aidl_value8);
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
        int _mask = 0 | describeContents(getMeasurement());
        return _mask;
    L6:
        int _mask2 = 0 | describeContents(getVendor());
        return _mask2;
    L7:
        int _mask3 = 0 | describeContents(getId());
        return _mask3;
    L11:
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
            case 0: goto L19;
            case 1: goto L17;
            case 2: goto L15;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L7;
            case 7: goto L5;
            default: goto L4;
        };
    L5:
        return "measurementMode";
    L7:
        return "scalingMode";
    L9:
        return "captureSamples";
    L11:
        return "latencyMs";
    L13:
        return "captureSampleBuffer";
    L15:
        return "measurement";
    L17:
        return "vendor";
    L19:
        return "id";
    L4:
        throw new IllegalStateException("unknown field: " + _tag);
    }

    private void _set(int _tag, Object _value) {
        this._tag = _tag;
        this._value = _value;
    }
}
