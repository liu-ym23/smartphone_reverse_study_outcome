package android.hardware.audio.effect;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class DynamicsProcessing implements Parcelable {
    public static final Parcelable.Creator<DynamicsProcessing> CREATOR = null;
    public static final int engineArchitecture = 1;
    public static final int inputGain = 9;
    public static final int limiter = 8;
    public static final int mbc = 6;
    public static final int mbcBand = 7;
    public static final int postEq = 3;
    public static final int postEqBand = 5;
    public static final int preEq = 2;
    public static final int preEqBand = 4;

    /* JADX INFO: renamed from: vendor, reason: collision with root package name */
    public static final int f11vendor = 0;
    private int _tag;
    private Object _value;

    public static class ChannelConfig implements Parcelable {
        public static final Parcelable.Creator<ChannelConfig> CREATOR = null;
        public int channel;
        public boolean enable;

        public ChannelConfig() {
            this.channel = 0;
            this.enable = false;
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
            _aidl_parcel.writeBoolean(this.enable);
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
            this.channel = _aidl_parcel.readInt();     // Catch: Throwable -> L29
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
            this.enable = _aidl_parcel.readBoolean();     // Catch: Throwable -> L29
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

    public static class EngineArchitecture implements Parcelable {
        public static final Parcelable.Creator<EngineArchitecture> CREATOR = null;
        public boolean limiterInUse;
        public StageEnablement mbcStage;
        public StageEnablement postEqStage;
        public StageEnablement preEqStage;
        public float preferredProcessingDurationMs;
        public byte resolutionPreference;

        public EngineArchitecture() {
            this.resolutionPreference = 0;
            this.preferredProcessingDurationMs = 0.0f;
            this.limiterInUse = false;
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
            _aidl_parcel.writeByte(this.resolutionPreference);
            _aidl_parcel.writeFloat(this.preferredProcessingDurationMs);
            _aidl_parcel.writeTypedObject(this.preEqStage, _aidl_flag);
            _aidl_parcel.writeTypedObject(this.postEqStage, _aidl_flag);
            _aidl_parcel.writeTypedObject(this.mbcStage, _aidl_flag);
            _aidl_parcel.writeBoolean(this.limiterInUse);
            int _aidl_end_pos = _aidl_parcel.dataPosition();
            _aidl_parcel.setDataPosition(_aidl_start_pos);
            _aidl_parcel.writeInt(_aidl_end_pos - _aidl_start_pos);
            _aidl_parcel.setDataPosition(_aidl_end_pos);
        }

        public final void readFromParcel(Parcel _aidl_parcel) {
            int _aidl_start_pos = _aidl_parcel.dataPosition();
            int _aidl_parcelable_size = _aidl_parcel.readInt();
            if (_aidl_parcelable_size < 4) goto L68;
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L8;
            this.resolutionPreference = _aidl_parcel.readByte();     // Catch: Throwable -> L65
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
            this.preferredProcessingDurationMs = _aidl_parcel.readFloat();     // Catch: Throwable -> L65
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L26;
            this.preEqStage = (StageEnablement) _aidl_parcel.readTypedObject(StageEnablement.CREATOR);     // Catch: Throwable -> L65
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L35;
            this.postEqStage = (StageEnablement) _aidl_parcel.readTypedObject(StageEnablement.CREATOR);     // Catch: Throwable -> L65
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L44;
            this.mbcStage = (StageEnablement) _aidl_parcel.readTypedObject(StageEnablement.CREATOR);     // Catch: Throwable -> L65
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L53;
            this.limiterInUse = _aidl_parcel.readBoolean();     // Catch: Throwable -> L65
            if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L64;
            _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
            return;
        L64:
            throw new BadParcelableException("Overflow in the size of parcelable");
        L53:
            if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L57;
            _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
            return;
        L57:
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
        L68:
            throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L65
        L65:
            th = move-exception;
            if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L72;
            _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
            throw th;
        L72:
            throw new BadParcelableException("Overflow in the size of parcelable");
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            int _mask = 0 | describeContents(this.preEqStage);
            return (_mask | describeContents(this.postEqStage)) | describeContents(this.mbcStage);
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

    public static class EqBandConfig implements Parcelable {
        public static final Parcelable.Creator<EqBandConfig> CREATOR = null;
        public int band;
        public int channel;
        public float cutoffFrequencyHz;
        public boolean enable;
        public float gainDb;

        public EqBandConfig() {
            this.channel = 0;
            this.band = 0;
            this.enable = false;
            this.cutoffFrequencyHz = 0.0f;
            this.gainDb = 0.0f;
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
            _aidl_parcel.writeInt(this.band);
            _aidl_parcel.writeBoolean(this.enable);
            _aidl_parcel.writeFloat(this.cutoffFrequencyHz);
            _aidl_parcel.writeFloat(this.gainDb);
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
            this.channel = _aidl_parcel.readInt();     // Catch: Throwable -> L56
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
            this.band = _aidl_parcel.readInt();     // Catch: Throwable -> L56
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L26;
            this.enable = _aidl_parcel.readBoolean();     // Catch: Throwable -> L56
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L35;
            this.cutoffFrequencyHz = _aidl_parcel.readFloat();     // Catch: Throwable -> L56
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L44;
            this.gainDb = _aidl_parcel.readFloat();     // Catch: Throwable -> L56
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

        /* synthetic */ Id(Parcel r1, DynamicsProcessingIA r2) {
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

    public static class InputGain implements Parcelable {
        public static final Parcelable.Creator<InputGain> CREATOR = null;
        public int channel;
        public float gainDb;

        public InputGain() {
            this.channel = 0;
            this.gainDb = 0.0f;
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
            _aidl_parcel.writeFloat(this.gainDb);
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
            this.channel = _aidl_parcel.readInt();     // Catch: Throwable -> L29
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
            this.gainDb = _aidl_parcel.readFloat();     // Catch: Throwable -> L29
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

    public static class LimiterConfig implements Parcelable {
        public static final Parcelable.Creator<LimiterConfig> CREATOR = null;
        public float attackTimeMs;
        public int channel;
        public boolean enable;
        public int linkGroup;
        public float postGainDb;
        public float ratio;
        public float releaseTimeMs;
        public float thresholdDb;

        public LimiterConfig() {
            this.channel = 0;
            this.enable = false;
            this.linkGroup = 0;
            this.attackTimeMs = 0.0f;
            this.releaseTimeMs = 0.0f;
            this.ratio = 0.0f;
            this.thresholdDb = 0.0f;
            this.postGainDb = 0.0f;
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
            _aidl_parcel.writeBoolean(this.enable);
            _aidl_parcel.writeInt(this.linkGroup);
            _aidl_parcel.writeFloat(this.attackTimeMs);
            _aidl_parcel.writeFloat(this.releaseTimeMs);
            _aidl_parcel.writeFloat(this.ratio);
            _aidl_parcel.writeFloat(this.thresholdDb);
            _aidl_parcel.writeFloat(this.postGainDb);
            int _aidl_end_pos = _aidl_parcel.dataPosition();
            _aidl_parcel.setDataPosition(_aidl_start_pos);
            _aidl_parcel.writeInt(_aidl_end_pos - _aidl_start_pos);
            _aidl_parcel.setDataPosition(_aidl_end_pos);
        }

        public final void readFromParcel(Parcel _aidl_parcel) {
            int _aidl_start_pos = _aidl_parcel.dataPosition();
            int _aidl_parcelable_size = _aidl_parcel.readInt();
            if (_aidl_parcelable_size < 4) goto L86;
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L8;
            this.channel = _aidl_parcel.readInt();     // Catch: Throwable -> L83
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
            this.enable = _aidl_parcel.readBoolean();     // Catch: Throwable -> L83
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L26;
            this.linkGroup = _aidl_parcel.readInt();     // Catch: Throwable -> L83
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L35;
            this.attackTimeMs = _aidl_parcel.readFloat();     // Catch: Throwable -> L83
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L44;
            this.releaseTimeMs = _aidl_parcel.readFloat();     // Catch: Throwable -> L83
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L53;
            this.ratio = _aidl_parcel.readFloat();     // Catch: Throwable -> L83
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L62;
            this.thresholdDb = _aidl_parcel.readFloat();     // Catch: Throwable -> L83
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L71;
            this.postGainDb = _aidl_parcel.readFloat();     // Catch: Throwable -> L83
            if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L82;
            _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
            return;
        L82:
            throw new BadParcelableException("Overflow in the size of parcelable");
        L71:
            if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L75;
            _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
            return;
        L75:
            throw new BadParcelableException("Overflow in the size of parcelable");
        L62:
            if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L66;
            _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
            return;
        L66:
            throw new BadParcelableException("Overflow in the size of parcelable");
        L53:
            if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L57;
            _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
            return;
        L57:
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
        L86:
            throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L83
        L83:
            th = move-exception;
            if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L90;
            _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
            throw th;
        L90:
            throw new BadParcelableException("Overflow in the size of parcelable");
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }
    }

    public static class MbcBandConfig implements Parcelable {
        public static final Parcelable.Creator<MbcBandConfig> CREATOR = null;
        public float attackTimeMs;
        public int band;
        public int channel;
        public float cutoffFrequencyHz;
        public boolean enable;
        public float expanderRatio;
        public float kneeWidthDb;
        public float noiseGateThresholdDb;
        public float postGainDb;
        public float preGainDb;
        public float ratio;
        public float releaseTimeMs;
        public float thresholdDb;

        public MbcBandConfig() {
            this.channel = 0;
            this.band = 0;
            this.enable = false;
            this.cutoffFrequencyHz = 0.0f;
            this.attackTimeMs = 0.0f;
            this.releaseTimeMs = 0.0f;
            this.ratio = 0.0f;
            this.thresholdDb = 0.0f;
            this.kneeWidthDb = 0.0f;
            this.noiseGateThresholdDb = 0.0f;
            this.expanderRatio = 0.0f;
            this.preGainDb = 0.0f;
            this.postGainDb = 0.0f;
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
            _aidl_parcel.writeInt(this.band);
            _aidl_parcel.writeBoolean(this.enable);
            _aidl_parcel.writeFloat(this.cutoffFrequencyHz);
            _aidl_parcel.writeFloat(this.attackTimeMs);
            _aidl_parcel.writeFloat(this.releaseTimeMs);
            _aidl_parcel.writeFloat(this.ratio);
            _aidl_parcel.writeFloat(this.thresholdDb);
            _aidl_parcel.writeFloat(this.kneeWidthDb);
            _aidl_parcel.writeFloat(this.noiseGateThresholdDb);
            _aidl_parcel.writeFloat(this.expanderRatio);
            _aidl_parcel.writeFloat(this.preGainDb);
            _aidl_parcel.writeFloat(this.postGainDb);
            int _aidl_end_pos = _aidl_parcel.dataPosition();
            _aidl_parcel.setDataPosition(_aidl_start_pos);
            _aidl_parcel.writeInt(_aidl_end_pos - _aidl_start_pos);
            _aidl_parcel.setDataPosition(_aidl_end_pos);
        }

        public final void readFromParcel(Parcel _aidl_parcel) {
            int _aidl_start_pos = _aidl_parcel.dataPosition();
            int _aidl_parcelable_size = _aidl_parcel.readInt();
            if (_aidl_parcelable_size < 4) goto L131;
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L8;
            this.channel = _aidl_parcel.readInt();     // Catch: Throwable -> L128
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
            this.band = _aidl_parcel.readInt();     // Catch: Throwable -> L128
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L26;
            this.enable = _aidl_parcel.readBoolean();     // Catch: Throwable -> L128
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L35;
            this.cutoffFrequencyHz = _aidl_parcel.readFloat();     // Catch: Throwable -> L128
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L44;
            this.attackTimeMs = _aidl_parcel.readFloat();     // Catch: Throwable -> L128
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L53;
            this.releaseTimeMs = _aidl_parcel.readFloat();     // Catch: Throwable -> L128
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L62;
            this.ratio = _aidl_parcel.readFloat();     // Catch: Throwable -> L128
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L71;
            this.thresholdDb = _aidl_parcel.readFloat();     // Catch: Throwable -> L128
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L80;
            this.kneeWidthDb = _aidl_parcel.readFloat();     // Catch: Throwable -> L128
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L89;
            this.noiseGateThresholdDb = _aidl_parcel.readFloat();     // Catch: Throwable -> L128
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L98;
            this.expanderRatio = _aidl_parcel.readFloat();     // Catch: Throwable -> L128
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L107;
            this.preGainDb = _aidl_parcel.readFloat();     // Catch: Throwable -> L128
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L116;
            this.postGainDb = _aidl_parcel.readFloat();     // Catch: Throwable -> L128
            if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L127;
            _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
            return;
        L127:
            throw new BadParcelableException("Overflow in the size of parcelable");
        L116:
            if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L120;
            _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
            return;
        L120:
            throw new BadParcelableException("Overflow in the size of parcelable");
        L107:
            if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L111;
            _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
            return;
        L111:
            throw new BadParcelableException("Overflow in the size of parcelable");
        L98:
            if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L102;
            _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
            return;
        L102:
            throw new BadParcelableException("Overflow in the size of parcelable");
        L89:
            if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L93;
            _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
            return;
        L93:
            throw new BadParcelableException("Overflow in the size of parcelable");
        L80:
            if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L84;
            _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
            return;
        L84:
            throw new BadParcelableException("Overflow in the size of parcelable");
        L71:
            if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L75;
            _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
            return;
        L75:
            throw new BadParcelableException("Overflow in the size of parcelable");
        L62:
            if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L66;
            _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
            return;
        L66:
            throw new BadParcelableException("Overflow in the size of parcelable");
        L53:
            if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L57;
            _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
            return;
        L57:
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
        L131:
            throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L128
        L128:
            th = move-exception;
            if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L135;
            _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
            throw th;
        L135:
            throw new BadParcelableException("Overflow in the size of parcelable");
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }
    }

    public @interface ResolutionPreference {
        public static final byte FAVOR_FREQUENCY_RESOLUTION = 0;
        public static final byte FAVOR_TIME_RESOLUTION = 1;
    }

    public static class StageEnablement implements Parcelable {
        public static final Parcelable.Creator<StageEnablement> CREATOR = null;
        public int bandCount;
        public boolean inUse;

        public StageEnablement() {
            this.inUse = false;
            this.bandCount = 0;
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
            _aidl_parcel.writeBoolean(this.inUse);
            _aidl_parcel.writeInt(this.bandCount);
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
            this.inUse = _aidl_parcel.readBoolean();     // Catch: Throwable -> L29
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
            this.bandCount = _aidl_parcel.readInt();     // Catch: Throwable -> L29
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
        public static final int engineArchitecture = 1;
        public static final int inputGain = 9;
        public static final int limiter = 8;
        public static final int mbc = 6;
        public static final int mbcBand = 7;
        public static final int postEq = 3;
        public static final int postEqBand = 5;
        public static final int preEq = 2;
        public static final int preEqBand = 4;

        /* JADX INFO: renamed from: vendor, reason: collision with root package name */
        public static final int f12vendor = 0;
    }

    /* synthetic */ DynamicsProcessing(Parcel r1, DynamicsProcessingIA r2) {
        this(r1);
    }

    public DynamicsProcessing() {
        this._tag = 0;
        this._value = null;
    }

    private DynamicsProcessing(Parcel _aidl_parcel) {
        readFromParcel(_aidl_parcel);
    }

    private DynamicsProcessing(int _tag, Object _value) {
        this._tag = _tag;
        this._value = _value;
    }

    public int getTag() {
        return this._tag;
    }

    public static DynamicsProcessing vendor(VendorExtension _value) {
        return new DynamicsProcessing(0, _value);
    }

    public VendorExtension getVendor() {
        _assertTag(0);
        return (VendorExtension) this._value;
    }

    public void setVendor(VendorExtension _value) {
        _set(0, _value);
    }

    public static DynamicsProcessing engineArchitecture(EngineArchitecture _value) {
        return new DynamicsProcessing(1, _value);
    }

    public EngineArchitecture getEngineArchitecture() {
        _assertTag(1);
        return (EngineArchitecture) this._value;
    }

    public void setEngineArchitecture(EngineArchitecture _value) {
        _set(1, _value);
    }

    public static DynamicsProcessing preEq(ChannelConfig[] _value) {
        return new DynamicsProcessing(2, _value);
    }

    public ChannelConfig[] getPreEq() {
        _assertTag(2);
        return (ChannelConfig[]) this._value;
    }

    public void setPreEq(ChannelConfig[] _value) {
        _set(2, _value);
    }

    public static DynamicsProcessing postEq(ChannelConfig[] _value) {
        return new DynamicsProcessing(3, _value);
    }

    public ChannelConfig[] getPostEq() {
        _assertTag(3);
        return (ChannelConfig[]) this._value;
    }

    public void setPostEq(ChannelConfig[] _value) {
        _set(3, _value);
    }

    public static DynamicsProcessing preEqBand(EqBandConfig[] _value) {
        return new DynamicsProcessing(4, _value);
    }

    public EqBandConfig[] getPreEqBand() {
        _assertTag(4);
        return (EqBandConfig[]) this._value;
    }

    public void setPreEqBand(EqBandConfig[] _value) {
        _set(4, _value);
    }

    public static DynamicsProcessing postEqBand(EqBandConfig[] _value) {
        return new DynamicsProcessing(5, _value);
    }

    public EqBandConfig[] getPostEqBand() {
        _assertTag(5);
        return (EqBandConfig[]) this._value;
    }

    public void setPostEqBand(EqBandConfig[] _value) {
        _set(5, _value);
    }

    public static DynamicsProcessing mbc(ChannelConfig[] _value) {
        return new DynamicsProcessing(6, _value);
    }

    public ChannelConfig[] getMbc() {
        _assertTag(6);
        return (ChannelConfig[]) this._value;
    }

    public void setMbc(ChannelConfig[] _value) {
        _set(6, _value);
    }

    public static DynamicsProcessing mbcBand(MbcBandConfig[] _value) {
        return new DynamicsProcessing(7, _value);
    }

    public MbcBandConfig[] getMbcBand() {
        _assertTag(7);
        return (MbcBandConfig[]) this._value;
    }

    public void setMbcBand(MbcBandConfig[] _value) {
        _set(7, _value);
    }

    public static DynamicsProcessing limiter(LimiterConfig[] _value) {
        return new DynamicsProcessing(8, _value);
    }

    public LimiterConfig[] getLimiter() {
        _assertTag(8);
        return (LimiterConfig[]) this._value;
    }

    public void setLimiter(LimiterConfig[] _value) {
        _set(8, _value);
    }

    public static DynamicsProcessing inputGain(InputGain[] _value) {
        return new DynamicsProcessing(9, _value);
    }

    public InputGain[] getInputGain() {
        _assertTag(9);
        return (InputGain[]) this._value;
    }

    public void setInputGain(InputGain[] _value) {
        _set(9, _value);
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
            case 0: goto L14;
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            case 9: goto L5;
            default: goto L25;
        };
    L5:
        _aidl_parcel.writeTypedArray(getInputGain(), _aidl_flag);
        return;
    L6:
        _aidl_parcel.writeTypedArray(getLimiter(), _aidl_flag);
        return;
    L7:
        _aidl_parcel.writeTypedArray(getMbcBand(), _aidl_flag);
        return;
    L8:
        _aidl_parcel.writeTypedArray(getMbc(), _aidl_flag);
        return;
    L9:
        _aidl_parcel.writeTypedArray(getPostEqBand(), _aidl_flag);
        return;
    L10:
        _aidl_parcel.writeTypedArray(getPreEqBand(), _aidl_flag);
        return;
    L11:
        _aidl_parcel.writeTypedArray(getPostEq(), _aidl_flag);
        return;
    L12:
        _aidl_parcel.writeTypedArray(getPreEq(), _aidl_flag);
        return;
    L13:
        _aidl_parcel.writeTypedObject(getEngineArchitecture(), _aidl_flag);
        return;
    L14:
        _aidl_parcel.writeTypedObject(getVendor(), _aidl_flag);
        return;
    }

    public void readFromParcel(Parcel _aidl_parcel) {
        int _aidl_tag = _aidl_parcel.readInt();
        switch(_aidl_tag) {
            case 0: goto L24;
            case 1: goto L22;
            case 2: goto L20;
            case 3: goto L18;
            case 4: goto L16;
            case 5: goto L14;
            case 6: goto L12;
            case 7: goto L10;
            case 8: goto L8;
            case 9: goto L6;
            default: goto L5;
        };
    L6:
        InputGain[] _aidl_value = (InputGain[]) _aidl_parcel.createTypedArray(InputGain.CREATOR);
        _set(_aidl_tag, _aidl_value);
        return;
    L8:
        LimiterConfig[] _aidl_value2 = (LimiterConfig[]) _aidl_parcel.createTypedArray(LimiterConfig.CREATOR);
        _set(_aidl_tag, _aidl_value2);
        return;
    L10:
        MbcBandConfig[] _aidl_value3 = (MbcBandConfig[]) _aidl_parcel.createTypedArray(MbcBandConfig.CREATOR);
        _set(_aidl_tag, _aidl_value3);
        return;
    L12:
        ChannelConfig[] _aidl_value4 = (ChannelConfig[]) _aidl_parcel.createTypedArray(ChannelConfig.CREATOR);
        _set(_aidl_tag, _aidl_value4);
        return;
    L14:
        EqBandConfig[] _aidl_value5 = (EqBandConfig[]) _aidl_parcel.createTypedArray(EqBandConfig.CREATOR);
        _set(_aidl_tag, _aidl_value5);
        return;
    L16:
        EqBandConfig[] _aidl_value6 = (EqBandConfig[]) _aidl_parcel.createTypedArray(EqBandConfig.CREATOR);
        _set(_aidl_tag, _aidl_value6);
        return;
    L18:
        ChannelConfig[] _aidl_value7 = (ChannelConfig[]) _aidl_parcel.createTypedArray(ChannelConfig.CREATOR);
        _set(_aidl_tag, _aidl_value7);
        return;
    L20:
        ChannelConfig[] _aidl_value8 = (ChannelConfig[]) _aidl_parcel.createTypedArray(ChannelConfig.CREATOR);
        _set(_aidl_tag, _aidl_value8);
        return;
    L22:
        EngineArchitecture _aidl_value9 = (EngineArchitecture) _aidl_parcel.readTypedObject(EngineArchitecture.CREATOR);
        _set(_aidl_tag, _aidl_value9);
        return;
    L24:
        VendorExtension _aidl_value10 = (VendorExtension) _aidl_parcel.readTypedObject(VendorExtension.CREATOR);
        _set(_aidl_tag, _aidl_value10);
        return;
    L5:
        throw new IllegalArgumentException("union: unknown tag: " + _aidl_tag);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        switch(getTag()) {
            case 0: goto L14;
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            case 9: goto L5;
            default: goto L25;
        };
    L5:
        int _mask = 0 | describeContents(getInputGain());
        return _mask;
    L6:
        int _mask2 = 0 | describeContents(getLimiter());
        return _mask2;
    L7:
        int _mask3 = 0 | describeContents(getMbcBand());
        return _mask3;
    L8:
        int _mask4 = 0 | describeContents(getMbc());
        return _mask4;
    L9:
        int _mask5 = 0 | describeContents(getPostEqBand());
        return _mask5;
    L10:
        int _mask6 = 0 | describeContents(getPreEqBand());
        return _mask6;
    L11:
        int _mask7 = 0 | describeContents(getPostEq());
        return _mask7;
    L12:
        int _mask8 = 0 | describeContents(getPreEq());
        return _mask8;
    L13:
        int _mask9 = 0 | describeContents(getEngineArchitecture());
        return _mask9;
    L14:
        int _mask10 = 0 | describeContents(getVendor());
        return _mask10;
    L25:
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
            case 0: goto L23;
            case 1: goto L21;
            case 2: goto L19;
            case 3: goto L17;
            case 4: goto L15;
            case 5: goto L13;
            case 6: goto L11;
            case 7: goto L9;
            case 8: goto L7;
            case 9: goto L5;
            default: goto L4;
        };
    L5:
        return "inputGain";
    L7:
        return "limiter";
    L9:
        return "mbcBand";
    L11:
        return "mbc";
    L13:
        return "postEqBand";
    L15:
        return "preEqBand";
    L17:
        return "postEq";
    L19:
        return "preEq";
    L21:
        return "engineArchitecture";
    L23:
        return "vendor";
    L4:
        throw new IllegalStateException("unknown field: " + _tag);
    }

    private void _set(int _tag, Object _value) {
        this._tag = _tag;
        this._value = _value;
    }
}
