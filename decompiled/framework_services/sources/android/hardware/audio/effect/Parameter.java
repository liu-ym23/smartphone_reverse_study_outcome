package android.hardware.audio.effect;

import android.media.audio.common.AudioConfig;
import android.media.audio.common.AudioDeviceDescription;
import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import com.android.server.location.StarLocation;

/* JADX INFO: loaded from: classes.dex */
public final class Parameter implements Parcelable {
    public static final Parcelable.Creator<Parameter> CREATOR = null;
    public static final int common = 0;
    public static final int deviceDescription = 1;
    public static final int mode = 2;
    public static final int offload = 4;
    public static final int source = 3;
    public static final int specific = 6;
    public static final int volumeStereo = 5;
    private int _tag;
    private Object _value;

    public static class Common implements Parcelable {
        public static final Parcelable.Creator<Common> CREATOR = null;
        public AudioConfig input;
        public int ioHandle;
        public AudioConfig output;
        public int session;

        public Common() {
            this.session = 0;
            this.ioHandle = 0;
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
            _aidl_parcel.writeInt(this.session);
            _aidl_parcel.writeInt(this.ioHandle);
            _aidl_parcel.writeTypedObject(this.input, _aidl_flag);
            _aidl_parcel.writeTypedObject(this.output, _aidl_flag);
            int _aidl_end_pos = _aidl_parcel.dataPosition();
            _aidl_parcel.setDataPosition(_aidl_start_pos);
            _aidl_parcel.writeInt(_aidl_end_pos - _aidl_start_pos);
            _aidl_parcel.setDataPosition(_aidl_end_pos);
        }

        public final void readFromParcel(Parcel _aidl_parcel) {
            int _aidl_start_pos = _aidl_parcel.dataPosition();
            int _aidl_parcelable_size = _aidl_parcel.readInt();
            if (_aidl_parcelable_size < 4) goto L50;
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L8;
            this.session = _aidl_parcel.readInt();     // Catch: Throwable -> L47
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
            this.ioHandle = _aidl_parcel.readInt();     // Catch: Throwable -> L47
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L26;
            this.input = (AudioConfig) _aidl_parcel.readTypedObject(AudioConfig.CREATOR);     // Catch: Throwable -> L47
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L35;
            this.output = (AudioConfig) _aidl_parcel.readTypedObject(AudioConfig.CREATOR);     // Catch: Throwable -> L47
            if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L46;
            _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
            return;
        L46:
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
        L50:
            throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L47
        L47:
            th = move-exception;
            if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L54;
            _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
            throw th;
        L54:
            throw new BadParcelableException("Overflow in the size of parcelable");
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            int _mask = 0 | describeContents(this.input);
            return _mask | describeContents(this.output);
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

    public static final class Id implements Parcelable {
        public static final Parcelable.Creator<Id> CREATOR = null;
        public static final int acousticEchoCancelerTag = 1;
        public static final int automaticGainControlV1Tag = 2;
        public static final int automaticGainControlV2Tag = 3;
        public static final int bassBoostTag = 4;
        public static final int commonTag = 16;
        public static final int downmixTag = 5;
        public static final int dynamicsProcessingTag = 6;
        public static final int environmentalReverbTag = 7;
        public static final int equalizerTag = 8;
        public static final int hapticGeneratorTag = 9;
        public static final int loudnessEnhancerTag = 10;
        public static final int noiseSuppressionTag = 11;
        public static final int presetReverbTag = 12;
        public static final int vendorEffectTag = 0;
        public static final int virtualizerTag = 13;
        public static final int visualizerTag = 14;
        public static final int volumeTag = 15;
        private int _tag;
        private Object _value;

        public @interface Tag {
            public static final int acousticEchoCancelerTag = 1;
            public static final int automaticGainControlV1Tag = 2;
            public static final int automaticGainControlV2Tag = 3;
            public static final int bassBoostTag = 4;
            public static final int commonTag = 16;
            public static final int downmixTag = 5;
            public static final int dynamicsProcessingTag = 6;
            public static final int environmentalReverbTag = 7;
            public static final int equalizerTag = 8;
            public static final int hapticGeneratorTag = 9;
            public static final int loudnessEnhancerTag = 10;
            public static final int noiseSuppressionTag = 11;
            public static final int presetReverbTag = 12;
            public static final int vendorEffectTag = 0;
            public static final int virtualizerTag = 13;
            public static final int visualizerTag = 14;
            public static final int volumeTag = 15;
        }

        /* synthetic */ Id(Parcel r1, ParameterIA r2) {
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

        public static Id vendorEffectTag(VendorExtension _value) {
            return new Id(0, _value);
        }

        public VendorExtension getVendorEffectTag() {
            _assertTag(0);
            return (VendorExtension) this._value;
        }

        public void setVendorEffectTag(VendorExtension _value) {
            _set(0, _value);
        }

        public static Id acousticEchoCancelerTag(AcousticEchoCanceler.Id _value) {
            return new Id(1, _value);
        }

        public AcousticEchoCanceler.Id getAcousticEchoCancelerTag() {
            _assertTag(1);
            return (AcousticEchoCanceler.Id) this._value;
        }

        public void setAcousticEchoCancelerTag(AcousticEchoCanceler.Id _value) {
            _set(1, _value);
        }

        public static Id automaticGainControlV1Tag(AutomaticGainControlV1.Id _value) {
            return new Id(2, _value);
        }

        public AutomaticGainControlV1.Id getAutomaticGainControlV1Tag() {
            _assertTag(2);
            return (AutomaticGainControlV1.Id) this._value;
        }

        public void setAutomaticGainControlV1Tag(AutomaticGainControlV1.Id _value) {
            _set(2, _value);
        }

        public static Id automaticGainControlV2Tag(AutomaticGainControlV2.Id _value) {
            return new Id(3, _value);
        }

        public AutomaticGainControlV2.Id getAutomaticGainControlV2Tag() {
            _assertTag(3);
            return (AutomaticGainControlV2.Id) this._value;
        }

        public void setAutomaticGainControlV2Tag(AutomaticGainControlV2.Id _value) {
            _set(3, _value);
        }

        public static Id bassBoostTag(BassBoost.Id _value) {
            return new Id(4, _value);
        }

        public BassBoost.Id getBassBoostTag() {
            _assertTag(4);
            return (BassBoost.Id) this._value;
        }

        public void setBassBoostTag(BassBoost.Id _value) {
            _set(4, _value);
        }

        public static Id downmixTag(Downmix.Id _value) {
            return new Id(5, _value);
        }

        public Downmix.Id getDownmixTag() {
            _assertTag(5);
            return (Downmix.Id) this._value;
        }

        public void setDownmixTag(Downmix.Id _value) {
            _set(5, _value);
        }

        public static Id dynamicsProcessingTag(DynamicsProcessing.Id _value) {
            return new Id(6, _value);
        }

        public DynamicsProcessing.Id getDynamicsProcessingTag() {
            _assertTag(6);
            return (DynamicsProcessing.Id) this._value;
        }

        public void setDynamicsProcessingTag(DynamicsProcessing.Id _value) {
            _set(6, _value);
        }

        public static Id environmentalReverbTag(EnvironmentalReverb.Id _value) {
            return new Id(7, _value);
        }

        public EnvironmentalReverb.Id getEnvironmentalReverbTag() {
            _assertTag(7);
            return (EnvironmentalReverb.Id) this._value;
        }

        public void setEnvironmentalReverbTag(EnvironmentalReverb.Id _value) {
            _set(7, _value);
        }

        public static Id equalizerTag(Equalizer.Id _value) {
            return new Id(8, _value);
        }

        public Equalizer.Id getEqualizerTag() {
            _assertTag(8);
            return (Equalizer.Id) this._value;
        }

        public void setEqualizerTag(Equalizer.Id _value) {
            _set(8, _value);
        }

        public static Id hapticGeneratorTag(HapticGenerator.Id _value) {
            return new Id(9, _value);
        }

        public HapticGenerator.Id getHapticGeneratorTag() {
            _assertTag(9);
            return (HapticGenerator.Id) this._value;
        }

        public void setHapticGeneratorTag(HapticGenerator.Id _value) {
            _set(9, _value);
        }

        public static Id loudnessEnhancerTag(LoudnessEnhancer.Id _value) {
            return new Id(10, _value);
        }

        public LoudnessEnhancer.Id getLoudnessEnhancerTag() {
            _assertTag(10);
            return (LoudnessEnhancer.Id) this._value;
        }

        public void setLoudnessEnhancerTag(LoudnessEnhancer.Id _value) {
            _set(10, _value);
        }

        public static Id noiseSuppressionTag(NoiseSuppression.Id _value) {
            return new Id(11, _value);
        }

        public NoiseSuppression.Id getNoiseSuppressionTag() {
            _assertTag(11);
            return (NoiseSuppression.Id) this._value;
        }

        public void setNoiseSuppressionTag(NoiseSuppression.Id _value) {
            _set(11, _value);
        }

        public static Id presetReverbTag(PresetReverb.Id _value) {
            return new Id(12, _value);
        }

        public PresetReverb.Id getPresetReverbTag() {
            _assertTag(12);
            return (PresetReverb.Id) this._value;
        }

        public void setPresetReverbTag(PresetReverb.Id _value) {
            _set(12, _value);
        }

        public static Id virtualizerTag(Virtualizer.Id _value) {
            return new Id(13, _value);
        }

        public Virtualizer.Id getVirtualizerTag() {
            _assertTag(13);
            return (Virtualizer.Id) this._value;
        }

        public void setVirtualizerTag(Virtualizer.Id _value) {
            _set(13, _value);
        }

        public static Id visualizerTag(Visualizer.Id _value) {
            return new Id(14, _value);
        }

        public Visualizer.Id getVisualizerTag() {
            _assertTag(14);
            return (Visualizer.Id) this._value;
        }

        public void setVisualizerTag(Visualizer.Id _value) {
            _set(14, _value);
        }

        public static Id volumeTag(Volume.Id _value) {
            return new Id(15, _value);
        }

        public Volume.Id getVolumeTag() {
            _assertTag(15);
            return (Volume.Id) this._value;
        }

        public void setVolumeTag(Volume.Id _value) {
            _set(15, _value);
        }

        public static Id commonTag(int _value) {
            return new Id(16, Integer.valueOf(_value));
        }

        public int getCommonTag() {
            _assertTag(16);
            return ((Integer) this._value).intValue();
        }

        public void setCommonTag(int _value) {
            _set(16, Integer.valueOf(_value));
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
                case 0: goto L21;
                case 1: goto L20;
                case 2: goto L19;
                case 3: goto L18;
                case 4: goto L17;
                case 5: goto L16;
                case 6: goto L15;
                case 7: goto L14;
                case 8: goto L13;
                case 9: goto L12;
                case 10: goto L11;
                case 11: goto L10;
                case 12: goto L9;
                case 13: goto L8;
                case 14: goto L7;
                case 15: goto L6;
                case 16: goto L5;
                default: goto L39;
            };
        L5:
            _aidl_parcel.writeInt(getCommonTag());
            return;
        L6:
            _aidl_parcel.writeTypedObject(getVolumeTag(), _aidl_flag);
            return;
        L7:
            _aidl_parcel.writeTypedObject(getVisualizerTag(), _aidl_flag);
            return;
        L8:
            _aidl_parcel.writeTypedObject(getVirtualizerTag(), _aidl_flag);
            return;
        L9:
            _aidl_parcel.writeTypedObject(getPresetReverbTag(), _aidl_flag);
            return;
        L10:
            _aidl_parcel.writeTypedObject(getNoiseSuppressionTag(), _aidl_flag);
            return;
        L11:
            _aidl_parcel.writeTypedObject(getLoudnessEnhancerTag(), _aidl_flag);
            return;
        L12:
            _aidl_parcel.writeTypedObject(getHapticGeneratorTag(), _aidl_flag);
            return;
        L13:
            _aidl_parcel.writeTypedObject(getEqualizerTag(), _aidl_flag);
            return;
        L14:
            _aidl_parcel.writeTypedObject(getEnvironmentalReverbTag(), _aidl_flag);
            return;
        L15:
            _aidl_parcel.writeTypedObject(getDynamicsProcessingTag(), _aidl_flag);
            return;
        L16:
            _aidl_parcel.writeTypedObject(getDownmixTag(), _aidl_flag);
            return;
        L17:
            _aidl_parcel.writeTypedObject(getBassBoostTag(), _aidl_flag);
            return;
        L18:
            _aidl_parcel.writeTypedObject(getAutomaticGainControlV2Tag(), _aidl_flag);
            return;
        L19:
            _aidl_parcel.writeTypedObject(getAutomaticGainControlV1Tag(), _aidl_flag);
            return;
        L20:
            _aidl_parcel.writeTypedObject(getAcousticEchoCancelerTag(), _aidl_flag);
            return;
        L21:
            _aidl_parcel.writeTypedObject(getVendorEffectTag(), _aidl_flag);
            return;
        }

        public void readFromParcel(Parcel _aidl_parcel) {
            int _aidl_tag = _aidl_parcel.readInt();
            switch(_aidl_tag) {
                case 0: goto L38;
                case 1: goto L36;
                case 2: goto L34;
                case 3: goto L32;
                case 4: goto L30;
                case 5: goto L28;
                case 6: goto L26;
                case 7: goto L24;
                case 8: goto L22;
                case 9: goto L20;
                case 10: goto L18;
                case 11: goto L16;
                case 12: goto L14;
                case 13: goto L12;
                case 14: goto L10;
                case 15: goto L8;
                case 16: goto L6;
                default: goto L5;
            };
        L6:
            int _aidl_value = _aidl_parcel.readInt();
            _set(_aidl_tag, Integer.valueOf(_aidl_value));
            return;
        L8:
            Volume.Id _aidl_value2 = (Volume.Id) _aidl_parcel.readTypedObject(Volume.Id.CREATOR);
            _set(_aidl_tag, _aidl_value2);
            return;
        L10:
            Visualizer.Id _aidl_value3 = (Visualizer.Id) _aidl_parcel.readTypedObject(Visualizer.Id.CREATOR);
            _set(_aidl_tag, _aidl_value3);
            return;
        L12:
            Virtualizer.Id _aidl_value4 = (Virtualizer.Id) _aidl_parcel.readTypedObject(Virtualizer.Id.CREATOR);
            _set(_aidl_tag, _aidl_value4);
            return;
        L14:
            PresetReverb.Id _aidl_value5 = (PresetReverb.Id) _aidl_parcel.readTypedObject(PresetReverb.Id.CREATOR);
            _set(_aidl_tag, _aidl_value5);
            return;
        L16:
            NoiseSuppression.Id _aidl_value6 = (NoiseSuppression.Id) _aidl_parcel.readTypedObject(NoiseSuppression.Id.CREATOR);
            _set(_aidl_tag, _aidl_value6);
            return;
        L18:
            LoudnessEnhancer.Id _aidl_value7 = (LoudnessEnhancer.Id) _aidl_parcel.readTypedObject(LoudnessEnhancer.Id.CREATOR);
            _set(_aidl_tag, _aidl_value7);
            return;
        L20:
            HapticGenerator.Id _aidl_value8 = (HapticGenerator.Id) _aidl_parcel.readTypedObject(HapticGenerator.Id.CREATOR);
            _set(_aidl_tag, _aidl_value8);
            return;
        L22:
            Equalizer.Id _aidl_value9 = (Equalizer.Id) _aidl_parcel.readTypedObject(Equalizer.Id.CREATOR);
            _set(_aidl_tag, _aidl_value9);
            return;
        L24:
            EnvironmentalReverb.Id _aidl_value10 = (EnvironmentalReverb.Id) _aidl_parcel.readTypedObject(EnvironmentalReverb.Id.CREATOR);
            _set(_aidl_tag, _aidl_value10);
            return;
        L26:
            DynamicsProcessing.Id _aidl_value11 = (DynamicsProcessing.Id) _aidl_parcel.readTypedObject(DynamicsProcessing.Id.CREATOR);
            _set(_aidl_tag, _aidl_value11);
            return;
        L28:
            Downmix.Id _aidl_value12 = (Downmix.Id) _aidl_parcel.readTypedObject(Downmix.Id.CREATOR);
            _set(_aidl_tag, _aidl_value12);
            return;
        L30:
            BassBoost.Id _aidl_value13 = (BassBoost.Id) _aidl_parcel.readTypedObject(BassBoost.Id.CREATOR);
            _set(_aidl_tag, _aidl_value13);
            return;
        L32:
            AutomaticGainControlV2.Id _aidl_value14 = (AutomaticGainControlV2.Id) _aidl_parcel.readTypedObject(AutomaticGainControlV2.Id.CREATOR);
            _set(_aidl_tag, _aidl_value14);
            return;
        L34:
            AutomaticGainControlV1.Id _aidl_value15 = (AutomaticGainControlV1.Id) _aidl_parcel.readTypedObject(AutomaticGainControlV1.Id.CREATOR);
            _set(_aidl_tag, _aidl_value15);
            return;
        L36:
            AcousticEchoCanceler.Id _aidl_value16 = (AcousticEchoCanceler.Id) _aidl_parcel.readTypedObject(AcousticEchoCanceler.Id.CREATOR);
            _set(_aidl_tag, _aidl_value16);
            return;
        L38:
            VendorExtension _aidl_value17 = (VendorExtension) _aidl_parcel.readTypedObject(VendorExtension.CREATOR);
            _set(_aidl_tag, _aidl_value17);
            return;
        L5:
            throw new IllegalArgumentException("union: unknown tag: " + _aidl_tag);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            switch(getTag()) {
                case 0: goto L20;
                case 1: goto L19;
                case 2: goto L18;
                case 3: goto L17;
                case 4: goto L16;
                case 5: goto L15;
                case 6: goto L14;
                case 7: goto L13;
                case 8: goto L12;
                case 9: goto L11;
                case 10: goto L10;
                case 11: goto L9;
                case 12: goto L8;
                case 13: goto L7;
                case 14: goto L6;
                case 15: goto L5;
                default: goto L37;
            };
        L5:
            int _mask = 0 | describeContents(getVolumeTag());
            return _mask;
        L6:
            int _mask2 = 0 | describeContents(getVisualizerTag());
            return _mask2;
        L7:
            int _mask3 = 0 | describeContents(getVirtualizerTag());
            return _mask3;
        L8:
            int _mask4 = 0 | describeContents(getPresetReverbTag());
            return _mask4;
        L9:
            int _mask5 = 0 | describeContents(getNoiseSuppressionTag());
            return _mask5;
        L10:
            int _mask6 = 0 | describeContents(getLoudnessEnhancerTag());
            return _mask6;
        L11:
            int _mask7 = 0 | describeContents(getHapticGeneratorTag());
            return _mask7;
        L12:
            int _mask8 = 0 | describeContents(getEqualizerTag());
            return _mask8;
        L13:
            int _mask9 = 0 | describeContents(getEnvironmentalReverbTag());
            return _mask9;
        L14:
            int _mask10 = 0 | describeContents(getDynamicsProcessingTag());
            return _mask10;
        L15:
            int _mask11 = 0 | describeContents(getDownmixTag());
            return _mask11;
        L16:
            int _mask12 = 0 | describeContents(getBassBoostTag());
            return _mask12;
        L17:
            int _mask13 = 0 | describeContents(getAutomaticGainControlV2Tag());
            return _mask13;
        L18:
            int _mask14 = 0 | describeContents(getAutomaticGainControlV1Tag());
            return _mask14;
        L19:
            int _mask15 = 0 | describeContents(getAcousticEchoCancelerTag());
            return _mask15;
        L20:
            int _mask16 = 0 | describeContents(getVendorEffectTag());
            return _mask16;
        L37:
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
                case 0: goto L37;
                case 1: goto L35;
                case 2: goto L33;
                case 3: goto L31;
                case 4: goto L29;
                case 5: goto L27;
                case 6: goto L25;
                case 7: goto L23;
                case 8: goto L21;
                case 9: goto L19;
                case 10: goto L17;
                case 11: goto L15;
                case 12: goto L13;
                case 13: goto L11;
                case 14: goto L9;
                case 15: goto L7;
                case 16: goto L5;
                default: goto L4;
            };
        L5:
            return "commonTag";
        L7:
            return "volumeTag";
        L9:
            return "visualizerTag";
        L11:
            return "virtualizerTag";
        L13:
            return "presetReverbTag";
        L15:
            return "noiseSuppressionTag";
        L17:
            return "loudnessEnhancerTag";
        L19:
            return "hapticGeneratorTag";
        L21:
            return "equalizerTag";
        L23:
            return "environmentalReverbTag";
        L25:
            return "dynamicsProcessingTag";
        L27:
            return "downmixTag";
        L29:
            return "bassBoostTag";
        L31:
            return "automaticGainControlV2Tag";
        L33:
            return "automaticGainControlV1Tag";
        L35:
            return "acousticEchoCancelerTag";
        L37:
            return "vendorEffectTag";
        L4:
            throw new IllegalStateException("unknown field: " + _tag);
        }

        private void _set(int _tag, Object _value) {
            this._tag = _tag;
            this._value = _value;
        }
    }

    public static final class Specific implements Parcelable {
        public static final Parcelable.Creator<Specific> CREATOR = null;
        public static final int acousticEchoCanceler = 1;
        public static final int automaticGainControlV1 = 2;
        public static final int automaticGainControlV2 = 3;
        public static final int bassBoost = 4;
        public static final int downmix = 5;
        public static final int dynamicsProcessing = 6;
        public static final int environmentalReverb = 7;
        public static final int equalizer = 8;
        public static final int hapticGenerator = 9;
        public static final int loudnessEnhancer = 10;
        public static final int noiseSuppression = 11;
        public static final int presetReverb = 12;
        public static final int vendorEffect = 0;
        public static final int virtualizer = 13;
        public static final int visualizer = 14;
        public static final int volume = 15;
        private int _tag;
        private Object _value;

        public @interface Tag {
            public static final int acousticEchoCanceler = 1;
            public static final int automaticGainControlV1 = 2;
            public static final int automaticGainControlV2 = 3;
            public static final int bassBoost = 4;
            public static final int downmix = 5;
            public static final int dynamicsProcessing = 6;
            public static final int environmentalReverb = 7;
            public static final int equalizer = 8;
            public static final int hapticGenerator = 9;
            public static final int loudnessEnhancer = 10;
            public static final int noiseSuppression = 11;
            public static final int presetReverb = 12;
            public static final int vendorEffect = 0;
            public static final int virtualizer = 13;
            public static final int visualizer = 14;
            public static final int volume = 15;
        }

        /* synthetic */ Specific(Parcel r1, ParameterIA r2) {
            this(r1);
        }

        public Specific() {
            this._tag = 0;
            this._value = null;
        }

        private Specific(Parcel _aidl_parcel) {
            readFromParcel(_aidl_parcel);
        }

        private Specific(int _tag, Object _value) {
            this._tag = _tag;
            this._value = _value;
        }

        public int getTag() {
            return this._tag;
        }

        public static Specific vendorEffect(VendorExtension _value) {
            return new Specific(0, _value);
        }

        public VendorExtension getVendorEffect() {
            _assertTag(0);
            return (VendorExtension) this._value;
        }

        public void setVendorEffect(VendorExtension _value) {
            _set(0, _value);
        }

        public static Specific acousticEchoCanceler(AcousticEchoCanceler _value) {
            return new Specific(1, _value);
        }

        public AcousticEchoCanceler getAcousticEchoCanceler() {
            _assertTag(1);
            return (AcousticEchoCanceler) this._value;
        }

        public void setAcousticEchoCanceler(AcousticEchoCanceler _value) {
            _set(1, _value);
        }

        public static Specific automaticGainControlV1(AutomaticGainControlV1 _value) {
            return new Specific(2, _value);
        }

        public AutomaticGainControlV1 getAutomaticGainControlV1() {
            _assertTag(2);
            return (AutomaticGainControlV1) this._value;
        }

        public void setAutomaticGainControlV1(AutomaticGainControlV1 _value) {
            _set(2, _value);
        }

        public static Specific automaticGainControlV2(AutomaticGainControlV2 _value) {
            return new Specific(3, _value);
        }

        public AutomaticGainControlV2 getAutomaticGainControlV2() {
            _assertTag(3);
            return (AutomaticGainControlV2) this._value;
        }

        public void setAutomaticGainControlV2(AutomaticGainControlV2 _value) {
            _set(3, _value);
        }

        public static Specific bassBoost(BassBoost _value) {
            return new Specific(4, _value);
        }

        public BassBoost getBassBoost() {
            _assertTag(4);
            return (BassBoost) this._value;
        }

        public void setBassBoost(BassBoost _value) {
            _set(4, _value);
        }

        public static Specific downmix(Downmix _value) {
            return new Specific(5, _value);
        }

        public Downmix getDownmix() {
            _assertTag(5);
            return (Downmix) this._value;
        }

        public void setDownmix(Downmix _value) {
            _set(5, _value);
        }

        public static Specific dynamicsProcessing(DynamicsProcessing _value) {
            return new Specific(6, _value);
        }

        public DynamicsProcessing getDynamicsProcessing() {
            _assertTag(6);
            return (DynamicsProcessing) this._value;
        }

        public void setDynamicsProcessing(DynamicsProcessing _value) {
            _set(6, _value);
        }

        public static Specific environmentalReverb(EnvironmentalReverb _value) {
            return new Specific(7, _value);
        }

        public EnvironmentalReverb getEnvironmentalReverb() {
            _assertTag(7);
            return (EnvironmentalReverb) this._value;
        }

        public void setEnvironmentalReverb(EnvironmentalReverb _value) {
            _set(7, _value);
        }

        public static Specific equalizer(Equalizer _value) {
            return new Specific(8, _value);
        }

        public Equalizer getEqualizer() {
            _assertTag(8);
            return (Equalizer) this._value;
        }

        public void setEqualizer(Equalizer _value) {
            _set(8, _value);
        }

        public static Specific hapticGenerator(HapticGenerator _value) {
            return new Specific(9, _value);
        }

        public HapticGenerator getHapticGenerator() {
            _assertTag(9);
            return (HapticGenerator) this._value;
        }

        public void setHapticGenerator(HapticGenerator _value) {
            _set(9, _value);
        }

        public static Specific loudnessEnhancer(LoudnessEnhancer _value) {
            return new Specific(10, _value);
        }

        public LoudnessEnhancer getLoudnessEnhancer() {
            _assertTag(10);
            return (LoudnessEnhancer) this._value;
        }

        public void setLoudnessEnhancer(LoudnessEnhancer _value) {
            _set(10, _value);
        }

        public static Specific noiseSuppression(NoiseSuppression _value) {
            return new Specific(11, _value);
        }

        public NoiseSuppression getNoiseSuppression() {
            _assertTag(11);
            return (NoiseSuppression) this._value;
        }

        public void setNoiseSuppression(NoiseSuppression _value) {
            _set(11, _value);
        }

        public static Specific presetReverb(PresetReverb _value) {
            return new Specific(12, _value);
        }

        public PresetReverb getPresetReverb() {
            _assertTag(12);
            return (PresetReverb) this._value;
        }

        public void setPresetReverb(PresetReverb _value) {
            _set(12, _value);
        }

        public static Specific virtualizer(Virtualizer _value) {
            return new Specific(13, _value);
        }

        public Virtualizer getVirtualizer() {
            _assertTag(13);
            return (Virtualizer) this._value;
        }

        public void setVirtualizer(Virtualizer _value) {
            _set(13, _value);
        }

        public static Specific visualizer(Visualizer _value) {
            return new Specific(14, _value);
        }

        public Visualizer getVisualizer() {
            _assertTag(14);
            return (Visualizer) this._value;
        }

        public void setVisualizer(Visualizer _value) {
            _set(14, _value);
        }

        public static Specific volume(Volume _value) {
            return new Specific(15, _value);
        }

        public Volume getVolume() {
            _assertTag(15);
            return (Volume) this._value;
        }

        public void setVolume(Volume _value) {
            _set(15, _value);
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
                case 0: goto L20;
                case 1: goto L19;
                case 2: goto L18;
                case 3: goto L17;
                case 4: goto L16;
                case 5: goto L15;
                case 6: goto L14;
                case 7: goto L13;
                case 8: goto L12;
                case 9: goto L11;
                case 10: goto L10;
                case 11: goto L9;
                case 12: goto L8;
                case 13: goto L7;
                case 14: goto L6;
                case 15: goto L5;
                default: goto L37;
            };
        L5:
            _aidl_parcel.writeTypedObject(getVolume(), _aidl_flag);
            return;
        L6:
            _aidl_parcel.writeTypedObject(getVisualizer(), _aidl_flag);
            return;
        L7:
            _aidl_parcel.writeTypedObject(getVirtualizer(), _aidl_flag);
            return;
        L8:
            _aidl_parcel.writeTypedObject(getPresetReverb(), _aidl_flag);
            return;
        L9:
            _aidl_parcel.writeTypedObject(getNoiseSuppression(), _aidl_flag);
            return;
        L10:
            _aidl_parcel.writeTypedObject(getLoudnessEnhancer(), _aidl_flag);
            return;
        L11:
            _aidl_parcel.writeTypedObject(getHapticGenerator(), _aidl_flag);
            return;
        L12:
            _aidl_parcel.writeTypedObject(getEqualizer(), _aidl_flag);
            return;
        L13:
            _aidl_parcel.writeTypedObject(getEnvironmentalReverb(), _aidl_flag);
            return;
        L14:
            _aidl_parcel.writeTypedObject(getDynamicsProcessing(), _aidl_flag);
            return;
        L15:
            _aidl_parcel.writeTypedObject(getDownmix(), _aidl_flag);
            return;
        L16:
            _aidl_parcel.writeTypedObject(getBassBoost(), _aidl_flag);
            return;
        L17:
            _aidl_parcel.writeTypedObject(getAutomaticGainControlV2(), _aidl_flag);
            return;
        L18:
            _aidl_parcel.writeTypedObject(getAutomaticGainControlV1(), _aidl_flag);
            return;
        L19:
            _aidl_parcel.writeTypedObject(getAcousticEchoCanceler(), _aidl_flag);
            return;
        L20:
            _aidl_parcel.writeTypedObject(getVendorEffect(), _aidl_flag);
            return;
        }

        public void readFromParcel(Parcel _aidl_parcel) {
            int _aidl_tag = _aidl_parcel.readInt();
            switch(_aidl_tag) {
                case 0: goto L36;
                case 1: goto L34;
                case 2: goto L32;
                case 3: goto L30;
                case 4: goto L28;
                case 5: goto L26;
                case 6: goto L24;
                case 7: goto L22;
                case 8: goto L20;
                case 9: goto L18;
                case 10: goto L16;
                case 11: goto L14;
                case 12: goto L12;
                case 13: goto L10;
                case 14: goto L8;
                case 15: goto L6;
                default: goto L5;
            };
        L6:
            Volume _aidl_value = (Volume) _aidl_parcel.readTypedObject(Volume.CREATOR);
            _set(_aidl_tag, _aidl_value);
            return;
        L8:
            Visualizer _aidl_value2 = (Visualizer) _aidl_parcel.readTypedObject(Visualizer.CREATOR);
            _set(_aidl_tag, _aidl_value2);
            return;
        L10:
            Virtualizer _aidl_value3 = (Virtualizer) _aidl_parcel.readTypedObject(Virtualizer.CREATOR);
            _set(_aidl_tag, _aidl_value3);
            return;
        L12:
            PresetReverb _aidl_value4 = (PresetReverb) _aidl_parcel.readTypedObject(PresetReverb.CREATOR);
            _set(_aidl_tag, _aidl_value4);
            return;
        L14:
            NoiseSuppression _aidl_value5 = (NoiseSuppression) _aidl_parcel.readTypedObject(NoiseSuppression.CREATOR);
            _set(_aidl_tag, _aidl_value5);
            return;
        L16:
            LoudnessEnhancer _aidl_value6 = (LoudnessEnhancer) _aidl_parcel.readTypedObject(LoudnessEnhancer.CREATOR);
            _set(_aidl_tag, _aidl_value6);
            return;
        L18:
            HapticGenerator _aidl_value7 = (HapticGenerator) _aidl_parcel.readTypedObject(HapticGenerator.CREATOR);
            _set(_aidl_tag, _aidl_value7);
            return;
        L20:
            Equalizer _aidl_value8 = (Equalizer) _aidl_parcel.readTypedObject(Equalizer.CREATOR);
            _set(_aidl_tag, _aidl_value8);
            return;
        L22:
            EnvironmentalReverb _aidl_value9 = (EnvironmentalReverb) _aidl_parcel.readTypedObject(EnvironmentalReverb.CREATOR);
            _set(_aidl_tag, _aidl_value9);
            return;
        L24:
            DynamicsProcessing _aidl_value10 = (DynamicsProcessing) _aidl_parcel.readTypedObject(DynamicsProcessing.CREATOR);
            _set(_aidl_tag, _aidl_value10);
            return;
        L26:
            Downmix _aidl_value11 = (Downmix) _aidl_parcel.readTypedObject(Downmix.CREATOR);
            _set(_aidl_tag, _aidl_value11);
            return;
        L28:
            BassBoost _aidl_value12 = (BassBoost) _aidl_parcel.readTypedObject(BassBoost.CREATOR);
            _set(_aidl_tag, _aidl_value12);
            return;
        L30:
            AutomaticGainControlV2 _aidl_value13 = (AutomaticGainControlV2) _aidl_parcel.readTypedObject(AutomaticGainControlV2.CREATOR);
            _set(_aidl_tag, _aidl_value13);
            return;
        L32:
            AutomaticGainControlV1 _aidl_value14 = (AutomaticGainControlV1) _aidl_parcel.readTypedObject(AutomaticGainControlV1.CREATOR);
            _set(_aidl_tag, _aidl_value14);
            return;
        L34:
            AcousticEchoCanceler _aidl_value15 = (AcousticEchoCanceler) _aidl_parcel.readTypedObject(AcousticEchoCanceler.CREATOR);
            _set(_aidl_tag, _aidl_value15);
            return;
        L36:
            VendorExtension _aidl_value16 = (VendorExtension) _aidl_parcel.readTypedObject(VendorExtension.CREATOR);
            _set(_aidl_tag, _aidl_value16);
            return;
        L5:
            throw new IllegalArgumentException("union: unknown tag: " + _aidl_tag);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            switch(getTag()) {
                case 0: goto L20;
                case 1: goto L19;
                case 2: goto L18;
                case 3: goto L17;
                case 4: goto L16;
                case 5: goto L15;
                case 6: goto L14;
                case 7: goto L13;
                case 8: goto L12;
                case 9: goto L11;
                case 10: goto L10;
                case 11: goto L9;
                case 12: goto L8;
                case 13: goto L7;
                case 14: goto L6;
                case 15: goto L5;
                default: goto L37;
            };
        L5:
            int _mask = 0 | describeContents(getVolume());
            return _mask;
        L6:
            int _mask2 = 0 | describeContents(getVisualizer());
            return _mask2;
        L7:
            int _mask3 = 0 | describeContents(getVirtualizer());
            return _mask3;
        L8:
            int _mask4 = 0 | describeContents(getPresetReverb());
            return _mask4;
        L9:
            int _mask5 = 0 | describeContents(getNoiseSuppression());
            return _mask5;
        L10:
            int _mask6 = 0 | describeContents(getLoudnessEnhancer());
            return _mask6;
        L11:
            int _mask7 = 0 | describeContents(getHapticGenerator());
            return _mask7;
        L12:
            int _mask8 = 0 | describeContents(getEqualizer());
            return _mask8;
        L13:
            int _mask9 = 0 | describeContents(getEnvironmentalReverb());
            return _mask9;
        L14:
            int _mask10 = 0 | describeContents(getDynamicsProcessing());
            return _mask10;
        L15:
            int _mask11 = 0 | describeContents(getDownmix());
            return _mask11;
        L16:
            int _mask12 = 0 | describeContents(getBassBoost());
            return _mask12;
        L17:
            int _mask13 = 0 | describeContents(getAutomaticGainControlV2());
            return _mask13;
        L18:
            int _mask14 = 0 | describeContents(getAutomaticGainControlV1());
            return _mask14;
        L19:
            int _mask15 = 0 | describeContents(getAcousticEchoCanceler());
            return _mask15;
        L20:
            int _mask16 = 0 | describeContents(getVendorEffect());
            return _mask16;
        L37:
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
                case 0: goto L35;
                case 1: goto L33;
                case 2: goto L31;
                case 3: goto L29;
                case 4: goto L27;
                case 5: goto L25;
                case 6: goto L23;
                case 7: goto L21;
                case 8: goto L19;
                case 9: goto L17;
                case 10: goto L15;
                case 11: goto L13;
                case 12: goto L11;
                case 13: goto L9;
                case 14: goto L7;
                case 15: goto L5;
                default: goto L4;
            };
        L5:
            return "volume";
        L7:
            return "visualizer";
        L9:
            return "virtualizer";
        L11:
            return "presetReverb";
        L13:
            return "noiseSuppression";
        L15:
            return "loudnessEnhancer";
        L17:
            return "hapticGenerator";
        L19:
            return "equalizer";
        L21:
            return "environmentalReverb";
        L23:
            return "dynamicsProcessing";
        L25:
            return "downmix";
        L27:
            return "bassBoost";
        L29:
            return "automaticGainControlV2";
        L31:
            return "automaticGainControlV1";
        L33:
            return "acousticEchoCanceler";
        L35:
            return "vendorEffect";
        L4:
            throw new IllegalStateException("unknown field: " + _tag);
        }

        private void _set(int _tag, Object _value) {
            this._tag = _tag;
            this._value = _value;
        }
    }

    public @interface Tag {
        public static final int common = 0;
        public static final int deviceDescription = 1;
        public static final int mode = 2;
        public static final int offload = 4;
        public static final int source = 3;
        public static final int specific = 6;
        public static final int volumeStereo = 5;
    }

    public static class VolumeStereo implements Parcelable {
        public static final Parcelable.Creator<VolumeStereo> CREATOR = null;
        public float left;
        public float right;

        public VolumeStereo() {
            this.left = 0.0f;
            this.right = 0.0f;
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
            _aidl_parcel.writeFloat(this.left);
            _aidl_parcel.writeFloat(this.right);
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
            this.left = _aidl_parcel.readFloat();     // Catch: Throwable -> L29
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
            this.right = _aidl_parcel.readFloat();     // Catch: Throwable -> L29
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

    /* synthetic */ Parameter(Parcel r1, ParameterIA r2) {
        this(r1);
    }

    public Parameter() {
        this._tag = 0;
        this._value = null;
    }

    private Parameter(Parcel _aidl_parcel) {
        readFromParcel(_aidl_parcel);
    }

    private Parameter(int _tag, Object _value) {
        this._tag = _tag;
        this._value = _value;
    }

    public int getTag() {
        return this._tag;
    }

    public static Parameter common(Common _value) {
        return new Parameter(0, _value);
    }

    public Common getCommon() {
        _assertTag(0);
        return (Common) this._value;
    }

    public void setCommon(Common _value) {
        _set(0, _value);
    }

    public static Parameter deviceDescription(AudioDeviceDescription[] _value) {
        return new Parameter(1, _value);
    }

    public AudioDeviceDescription[] getDeviceDescription() {
        _assertTag(1);
        return (AudioDeviceDescription[]) this._value;
    }

    public void setDeviceDescription(AudioDeviceDescription[] _value) {
        _set(1, _value);
    }

    public static Parameter mode(int _value) {
        return new Parameter(2, Integer.valueOf(_value));
    }

    public int getMode() {
        _assertTag(2);
        return ((Integer) this._value).intValue();
    }

    public void setMode(int _value) {
        _set(2, Integer.valueOf(_value));
    }

    public static Parameter source(int _value) {
        return new Parameter(3, Integer.valueOf(_value));
    }

    public int getSource() {
        _assertTag(3);
        return ((Integer) this._value).intValue();
    }

    public void setSource(int _value) {
        _set(3, Integer.valueOf(_value));
    }

    public static Parameter offload(boolean _value) {
        return new Parameter(4, Boolean.valueOf(_value));
    }

    public boolean getOffload() {
        _assertTag(4);
        return ((Boolean) this._value).booleanValue();
    }

    public void setOffload(boolean _value) {
        _set(4, Boolean.valueOf(_value));
    }

    public static Parameter volumeStereo(VolumeStereo _value) {
        return new Parameter(5, _value);
    }

    public VolumeStereo getVolumeStereo() {
        _assertTag(5);
        return (VolumeStereo) this._value;
    }

    public void setVolumeStereo(VolumeStereo _value) {
        _set(5, _value);
    }

    public static Parameter specific(Specific _value) {
        return new Parameter(6, _value);
    }

    public Specific getSpecific() {
        _assertTag(6);
        return (Specific) this._value;
    }

    public void setSpecific(Specific _value) {
        _set(6, _value);
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
            case 0: goto L11;
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            default: goto L19;
        };
    L5:
        _aidl_parcel.writeTypedObject(getSpecific(), _aidl_flag);
        return;
    L6:
        _aidl_parcel.writeTypedObject(getVolumeStereo(), _aidl_flag);
        return;
    L7:
        _aidl_parcel.writeBoolean(getOffload());
        return;
    L8:
        _aidl_parcel.writeInt(getSource());
        return;
    L9:
        _aidl_parcel.writeInt(getMode());
        return;
    L10:
        _aidl_parcel.writeTypedArray(getDeviceDescription(), _aidl_flag);
        return;
    L11:
        _aidl_parcel.writeTypedObject(getCommon(), _aidl_flag);
        return;
    }

    public void readFromParcel(Parcel _aidl_parcel) {
        int _aidl_tag = _aidl_parcel.readInt();
        switch(_aidl_tag) {
            case 0: goto L18;
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L12;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        Specific _aidl_value = (Specific) _aidl_parcel.readTypedObject(Specific.CREATOR);
        _set(_aidl_tag, _aidl_value);
        return;
    L8:
        VolumeStereo _aidl_value2 = (VolumeStereo) _aidl_parcel.readTypedObject(VolumeStereo.CREATOR);
        _set(_aidl_tag, _aidl_value2);
        return;
    L10:
        boolean _aidl_value3 = _aidl_parcel.readBoolean();
        _set(_aidl_tag, Boolean.valueOf(_aidl_value3));
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
        AudioDeviceDescription[] _aidl_value6 = (AudioDeviceDescription[]) _aidl_parcel.createTypedArray(AudioDeviceDescription.CREATOR);
        _set(_aidl_tag, _aidl_value6);
        return;
    L18:
        Common _aidl_value7 = (Common) _aidl_parcel.readTypedObject(Common.CREATOR);
        _set(_aidl_tag, _aidl_value7);
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
            case 4: goto L13;
            case 5: goto L6;
            case 6: goto L5;
            default: goto L13;
        };
    L5:
        int _mask = 0 | describeContents(getSpecific());
        return _mask;
    L6:
        int _mask2 = 0 | describeContents(getVolumeStereo());
        return _mask2;
    L7:
        int _mask3 = 0 | describeContents(getDeviceDescription());
        return _mask3;
    L8:
        int _mask4 = 0 | describeContents(getCommon());
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
            case 0: goto L17;
            case 1: goto L15;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L7;
            case 6: goto L5;
            default: goto L4;
        };
    L5:
        return "specific";
    L7:
        return "volumeStereo";
    L9:
        return "offload";
    L11:
        return StarLocation.KEY_LOCATION_SOURCE;
    L13:
        return "mode";
    L15:
        return "deviceDescription";
    L17:
        return "common";
    L4:
        throw new IllegalStateException("unknown field: " + _tag);
    }

    private void _set(int _tag, Object _value) {
        this._tag = _tag;
        this._value = _value;
    }
}
