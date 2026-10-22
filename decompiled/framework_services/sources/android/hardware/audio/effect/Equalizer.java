package android.hardware.audio.effect;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class Equalizer implements Parcelable {
    public static final Parcelable.Creator<Equalizer> CREATOR = null;
    public static final int bandFrequencies = 4;
    public static final int bandLevels = 1;
    public static final int centerFreqMh = 3;
    public static final int preset = 2;
    public static final int presets = 5;

    /* JADX INFO: renamed from: vendor, reason: collision with root package name */
    public static final int f15vendor = 0;
    private int _tag;
    private Object _value;

    public static class BandFrequency implements Parcelable {
        public static final Parcelable.Creator<BandFrequency> CREATOR = null;
        public int index;
        public int maxMh;
        public int minMh;

        public BandFrequency() {
            this.index = 0;
            this.minMh = 0;
            this.maxMh = 0;
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
            _aidl_parcel.writeInt(this.index);
            _aidl_parcel.writeInt(this.minMh);
            _aidl_parcel.writeInt(this.maxMh);
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
            this.index = _aidl_parcel.readInt();     // Catch: Throwable -> L38
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
            this.minMh = _aidl_parcel.readInt();     // Catch: Throwable -> L38
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L26;
            this.maxMh = _aidl_parcel.readInt();     // Catch: Throwable -> L38
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

    public static class BandLevel implements Parcelable {
        public static final Parcelable.Creator<BandLevel> CREATOR = null;
        public int index;
        public int levelMb;

        public BandLevel() {
            this.index = 0;
            this.levelMb = 0;
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
            _aidl_parcel.writeInt(this.index);
            _aidl_parcel.writeInt(this.levelMb);
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
            this.index = _aidl_parcel.readInt();     // Catch: Throwable -> L29
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
            this.levelMb = _aidl_parcel.readInt();     // Catch: Throwable -> L29
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

        /* synthetic */ Id(Parcel r1, EqualizerIA r2) {
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

    public static class Preset implements Parcelable {
        public static final Parcelable.Creator<Preset> CREATOR = null;
        public int index;
        public String name;

        public Preset() {
            this.index = 0;
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
            _aidl_parcel.writeInt(this.index);
            _aidl_parcel.writeString(this.name);
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
            this.index = _aidl_parcel.readInt();     // Catch: Throwable -> L29
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
            this.name = _aidl_parcel.readString();     // Catch: Throwable -> L29
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

    public @interface Tag {
        public static final int bandFrequencies = 4;
        public static final int bandLevels = 1;
        public static final int centerFreqMh = 3;
        public static final int preset = 2;
        public static final int presets = 5;

        /* JADX INFO: renamed from: vendor, reason: collision with root package name */
        public static final int f16vendor = 0;
    }

    /* synthetic */ Equalizer(Parcel r1, EqualizerIA r2) {
        this(r1);
    }

    public Equalizer() {
        this._tag = 0;
        this._value = null;
    }

    private Equalizer(Parcel _aidl_parcel) {
        readFromParcel(_aidl_parcel);
    }

    private Equalizer(int _tag, Object _value) {
        this._tag = _tag;
        this._value = _value;
    }

    public int getTag() {
        return this._tag;
    }

    public static Equalizer vendor(VendorExtension _value) {
        return new Equalizer(0, _value);
    }

    public VendorExtension getVendor() {
        _assertTag(0);
        return (VendorExtension) this._value;
    }

    public void setVendor(VendorExtension _value) {
        _set(0, _value);
    }

    public static Equalizer bandLevels(BandLevel[] _value) {
        return new Equalizer(1, _value);
    }

    public BandLevel[] getBandLevels() {
        _assertTag(1);
        return (BandLevel[]) this._value;
    }

    public void setBandLevels(BandLevel[] _value) {
        _set(1, _value);
    }

    public static Equalizer preset(int _value) {
        return new Equalizer(2, Integer.valueOf(_value));
    }

    public int getPreset() {
        _assertTag(2);
        return ((Integer) this._value).intValue();
    }

    public void setPreset(int _value) {
        _set(2, Integer.valueOf(_value));
    }

    public static Equalizer centerFreqMh(int[] _value) {
        return new Equalizer(3, _value);
    }

    public int[] getCenterFreqMh() {
        _assertTag(3);
        return (int[]) this._value;
    }

    public void setCenterFreqMh(int[] _value) {
        _set(3, _value);
    }

    public static Equalizer bandFrequencies(BandFrequency[] _value) {
        return new Equalizer(4, _value);
    }

    public BandFrequency[] getBandFrequencies() {
        _assertTag(4);
        return (BandFrequency[]) this._value;
    }

    public void setBandFrequencies(BandFrequency[] _value) {
        _set(4, _value);
    }

    public static Equalizer presets(Preset[] _value) {
        return new Equalizer(5, _value);
    }

    public Preset[] getPresets() {
        _assertTag(5);
        return (Preset[]) this._value;
    }

    public void setPresets(Preset[] _value) {
        _set(5, _value);
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
            case 0: goto L10;
            case 1: goto L9;
            case 2: goto L8;
            case 3: goto L7;
            case 4: goto L6;
            case 5: goto L5;
            default: goto L17;
        };
    L5:
        _aidl_parcel.writeTypedArray(getPresets(), _aidl_flag);
        return;
    L6:
        _aidl_parcel.writeTypedArray(getBandFrequencies(), _aidl_flag);
        return;
    L7:
        _aidl_parcel.writeIntArray(getCenterFreqMh());
        return;
    L8:
        _aidl_parcel.writeInt(getPreset());
        return;
    L9:
        _aidl_parcel.writeTypedArray(getBandLevels(), _aidl_flag);
        return;
    L10:
        _aidl_parcel.writeTypedObject(getVendor(), _aidl_flag);
        return;
    }

    public void readFromParcel(Parcel _aidl_parcel) {
        int _aidl_tag = _aidl_parcel.readInt();
        switch(_aidl_tag) {
            case 0: goto L16;
            case 1: goto L14;
            case 2: goto L12;
            case 3: goto L10;
            case 4: goto L8;
            case 5: goto L6;
            default: goto L5;
        };
    L6:
        Preset[] _aidl_value = (Preset[]) _aidl_parcel.createTypedArray(Preset.CREATOR);
        _set(_aidl_tag, _aidl_value);
        return;
    L8:
        BandFrequency[] _aidl_value2 = (BandFrequency[]) _aidl_parcel.createTypedArray(BandFrequency.CREATOR);
        _set(_aidl_tag, _aidl_value2);
        return;
    L10:
        int[] _aidl_value3 = _aidl_parcel.createIntArray();
        _set(_aidl_tag, _aidl_value3);
        return;
    L12:
        int _aidl_value4 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value4));
        return;
    L14:
        BandLevel[] _aidl_value5 = (BandLevel[]) _aidl_parcel.createTypedArray(BandLevel.CREATOR);
        _set(_aidl_tag, _aidl_value5);
        return;
    L16:
        VendorExtension _aidl_value6 = (VendorExtension) _aidl_parcel.readTypedObject(VendorExtension.CREATOR);
        _set(_aidl_tag, _aidl_value6);
        return;
    L5:
        throw new IllegalArgumentException("union: unknown tag: " + _aidl_tag);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        switch(getTag()) {
            case 0: goto L8;
            case 1: goto L7;
            case 2: goto L13;
            case 3: goto L13;
            case 4: goto L6;
            case 5: goto L5;
            default: goto L13;
        };
    L5:
        int _mask = 0 | describeContents(getPresets());
        return _mask;
    L6:
        int _mask2 = 0 | describeContents(getBandFrequencies());
        return _mask2;
    L7:
        int _mask3 = 0 | describeContents(getBandLevels());
        return _mask3;
    L8:
        int _mask4 = 0 | describeContents(getVendor());
        return _mask4;
    L13:
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
            case 0: goto L15;
            case 1: goto L13;
            case 2: goto L11;
            case 3: goto L9;
            case 4: goto L7;
            case 5: goto L5;
            default: goto L4;
        };
    L5:
        return "presets";
    L7:
        return "bandFrequencies";
    L9:
        return "centerFreqMh";
    L11:
        return "preset";
    L13:
        return "bandLevels";
    L15:
        return "vendor";
    L4:
        throw new IllegalStateException("unknown field: " + _tag);
    }

    private void _set(int _tag, Object _value) {
        this._tag = _tag;
        this._value = _value;
    }
}
