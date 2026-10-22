package android.hardware.tv.mediaquality;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class SoundParameter implements Parcelable {
    public static final Parcelable.Creator<SoundParameter> CREATOR = null;
    public static final int activeProfile = 16;
    public static final int autoVolumeControl = 8;
    public static final int balance = 0;
    public static final int bass = 1;
    public static final int digitalOutput = 14;
    public static final int digitalOutputDelayMs = 15;
    public static final int dolbyAudioProcessing = 11;
    public static final int dolbyDialogueEnhancer = 12;
    public static final int downmixMode = 9;
    public static final int dtsDrc = 10;
    public static final int dtsVirtualX = 13;
    public static final int enhancedAudioReturnChannelEnabled = 7;
    public static final int equalizerDetail = 4;
    public static final int soundStyle = 17;
    public static final int speakersDelayMs = 6;
    public static final int speakersEnabled = 5;
    public static final int surroundSoundEnabled = 3;
    public static final int treble = 2;
    private int _tag;
    private Object _value;

    public @interface Tag {
        public static final int activeProfile = 16;
        public static final int autoVolumeControl = 8;
        public static final int balance = 0;
        public static final int bass = 1;
        public static final int digitalOutput = 14;
        public static final int digitalOutputDelayMs = 15;
        public static final int dolbyAudioProcessing = 11;
        public static final int dolbyDialogueEnhancer = 12;
        public static final int downmixMode = 9;
        public static final int dtsDrc = 10;
        public static final int dtsVirtualX = 13;
        public static final int enhancedAudioReturnChannelEnabled = 7;
        public static final int equalizerDetail = 4;
        public static final int soundStyle = 17;
        public static final int speakersDelayMs = 6;
        public static final int speakersEnabled = 5;
        public static final int surroundSoundEnabled = 3;
        public static final int treble = 2;
    }

    /* synthetic */ SoundParameter(Parcel r1, SoundParameterIA r2) {
        this(r1);
    }

    public SoundParameter() {
        this._tag = 0;
        this._value = 0;
    }

    private SoundParameter(Parcel _aidl_parcel) {
        readFromParcel(_aidl_parcel);
    }

    private SoundParameter(int _tag, Object _value) {
        this._tag = _tag;
        this._value = _value;
    }

    public int getTag() {
        return this._tag;
    }

    public static SoundParameter balance(int _value) {
        return new SoundParameter(0, Integer.valueOf(_value));
    }

    public int getBalance() {
        _assertTag(0);
        return ((Integer) this._value).intValue();
    }

    public void setBalance(int _value) {
        _set(0, Integer.valueOf(_value));
    }

    public static SoundParameter bass(int _value) {
        return new SoundParameter(1, Integer.valueOf(_value));
    }

    public int getBass() {
        _assertTag(1);
        return ((Integer) this._value).intValue();
    }

    public void setBass(int _value) {
        _set(1, Integer.valueOf(_value));
    }

    public static SoundParameter treble(int _value) {
        return new SoundParameter(2, Integer.valueOf(_value));
    }

    public int getTreble() {
        _assertTag(2);
        return ((Integer) this._value).intValue();
    }

    public void setTreble(int _value) {
        _set(2, Integer.valueOf(_value));
    }

    public static SoundParameter surroundSoundEnabled(boolean _value) {
        return new SoundParameter(3, Boolean.valueOf(_value));
    }

    public boolean getSurroundSoundEnabled() {
        _assertTag(3);
        return ((Boolean) this._value).booleanValue();
    }

    public void setSurroundSoundEnabled(boolean _value) {
        _set(3, Boolean.valueOf(_value));
    }

    public static SoundParameter equalizerDetail(EqualizerDetail _value) {
        return new SoundParameter(4, _value);
    }

    public EqualizerDetail getEqualizerDetail() {
        _assertTag(4);
        return (EqualizerDetail) this._value;
    }

    public void setEqualizerDetail(EqualizerDetail _value) {
        _set(4, _value);
    }

    public static SoundParameter speakersEnabled(boolean _value) {
        return new SoundParameter(5, Boolean.valueOf(_value));
    }

    public boolean getSpeakersEnabled() {
        _assertTag(5);
        return ((Boolean) this._value).booleanValue();
    }

    public void setSpeakersEnabled(boolean _value) {
        _set(5, Boolean.valueOf(_value));
    }

    public static SoundParameter speakersDelayMs(int _value) {
        return new SoundParameter(6, Integer.valueOf(_value));
    }

    public int getSpeakersDelayMs() {
        _assertTag(6);
        return ((Integer) this._value).intValue();
    }

    public void setSpeakersDelayMs(int _value) {
        _set(6, Integer.valueOf(_value));
    }

    public static SoundParameter enhancedAudioReturnChannelEnabled(boolean _value) {
        return new SoundParameter(7, Boolean.valueOf(_value));
    }

    public boolean getEnhancedAudioReturnChannelEnabled() {
        _assertTag(7);
        return ((Boolean) this._value).booleanValue();
    }

    public void setEnhancedAudioReturnChannelEnabled(boolean _value) {
        _set(7, Boolean.valueOf(_value));
    }

    public static SoundParameter autoVolumeControl(boolean _value) {
        return new SoundParameter(8, Boolean.valueOf(_value));
    }

    public boolean getAutoVolumeControl() {
        _assertTag(8);
        return ((Boolean) this._value).booleanValue();
    }

    public void setAutoVolumeControl(boolean _value) {
        _set(8, Boolean.valueOf(_value));
    }

    public static SoundParameter downmixMode(byte _value) {
        return new SoundParameter(9, Byte.valueOf(_value));
    }

    public byte getDownmixMode() {
        _assertTag(9);
        return ((Byte) this._value).byteValue();
    }

    public void setDownmixMode(byte _value) {
        _set(9, Byte.valueOf(_value));
    }

    public static SoundParameter dtsDrc(boolean _value) {
        return new SoundParameter(10, Boolean.valueOf(_value));
    }

    public boolean getDtsDrc() {
        _assertTag(10);
        return ((Boolean) this._value).booleanValue();
    }

    public void setDtsDrc(boolean _value) {
        _set(10, Boolean.valueOf(_value));
    }

    public static SoundParameter dolbyAudioProcessing(DolbyAudioProcessing _value) {
        return new SoundParameter(11, _value);
    }

    public DolbyAudioProcessing getDolbyAudioProcessing() {
        _assertTag(11);
        return (DolbyAudioProcessing) this._value;
    }

    public void setDolbyAudioProcessing(DolbyAudioProcessing _value) {
        _set(11, _value);
    }

    public static SoundParameter dolbyDialogueEnhancer(byte _value) {
        return new SoundParameter(12, Byte.valueOf(_value));
    }

    public byte getDolbyDialogueEnhancer() {
        _assertTag(12);
        return ((Byte) this._value).byteValue();
    }

    public void setDolbyDialogueEnhancer(byte _value) {
        _set(12, Byte.valueOf(_value));
    }

    public static SoundParameter dtsVirtualX(DtsVirtualX _value) {
        return new SoundParameter(13, _value);
    }

    public DtsVirtualX getDtsVirtualX() {
        _assertTag(13);
        return (DtsVirtualX) this._value;
    }

    public void setDtsVirtualX(DtsVirtualX _value) {
        _set(13, _value);
    }

    public static SoundParameter digitalOutput(byte _value) {
        return new SoundParameter(14, Byte.valueOf(_value));
    }

    public byte getDigitalOutput() {
        _assertTag(14);
        return ((Byte) this._value).byteValue();
    }

    public void setDigitalOutput(byte _value) {
        _set(14, Byte.valueOf(_value));
    }

    public static SoundParameter digitalOutputDelayMs(int _value) {
        return new SoundParameter(15, Integer.valueOf(_value));
    }

    public int getDigitalOutputDelayMs() {
        _assertTag(15);
        return ((Integer) this._value).intValue();
    }

    public void setDigitalOutputDelayMs(int _value) {
        _set(15, Integer.valueOf(_value));
    }

    public static SoundParameter activeProfile(boolean _value) {
        return new SoundParameter(16, Boolean.valueOf(_value));
    }

    public boolean getActiveProfile() {
        _assertTag(16);
        return ((Boolean) this._value).booleanValue();
    }

    public void setActiveProfile(boolean _value) {
        _set(16, Boolean.valueOf(_value));
    }

    public static SoundParameter soundStyle(byte _value) {
        return new SoundParameter(17, Byte.valueOf(_value));
    }

    public byte getSoundStyle() {
        _assertTag(17);
        return ((Byte) this._value).byteValue();
    }

    public void setSoundStyle(byte _value) {
        _set(17, Byte.valueOf(_value));
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
            case 0: goto L22;
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L14;
            case 9: goto L13;
            case 10: goto L12;
            case 11: goto L11;
            case 12: goto L10;
            case 13: goto L9;
            case 14: goto L8;
            case 15: goto L7;
            case 16: goto L6;
            case 17: goto L5;
            default: goto L41;
        };
    L5:
        _aidl_parcel.writeByte(getSoundStyle());
        return;
    L6:
        _aidl_parcel.writeBoolean(getActiveProfile());
        return;
    L7:
        _aidl_parcel.writeInt(getDigitalOutputDelayMs());
        return;
    L8:
        _aidl_parcel.writeByte(getDigitalOutput());
        return;
    L9:
        _aidl_parcel.writeTypedObject(getDtsVirtualX(), _aidl_flag);
        return;
    L10:
        _aidl_parcel.writeByte(getDolbyDialogueEnhancer());
        return;
    L11:
        _aidl_parcel.writeTypedObject(getDolbyAudioProcessing(), _aidl_flag);
        return;
    L12:
        _aidl_parcel.writeBoolean(getDtsDrc());
        return;
    L13:
        _aidl_parcel.writeByte(getDownmixMode());
        return;
    L14:
        _aidl_parcel.writeBoolean(getAutoVolumeControl());
        return;
    L15:
        _aidl_parcel.writeBoolean(getEnhancedAudioReturnChannelEnabled());
        return;
    L16:
        _aidl_parcel.writeInt(getSpeakersDelayMs());
        return;
    L17:
        _aidl_parcel.writeBoolean(getSpeakersEnabled());
        return;
    L18:
        _aidl_parcel.writeTypedObject(getEqualizerDetail(), _aidl_flag);
        return;
    L19:
        _aidl_parcel.writeBoolean(getSurroundSoundEnabled());
        return;
    L20:
        _aidl_parcel.writeInt(getTreble());
        return;
    L21:
        _aidl_parcel.writeInt(getBass());
        return;
    L22:
        _aidl_parcel.writeInt(getBalance());
        return;
    }

    public void readFromParcel(Parcel _aidl_parcel) {
        int _aidl_tag = _aidl_parcel.readInt();
        switch(_aidl_tag) {
            case 0: goto L40;
            case 1: goto L38;
            case 2: goto L36;
            case 3: goto L34;
            case 4: goto L32;
            case 5: goto L30;
            case 6: goto L28;
            case 7: goto L26;
            case 8: goto L24;
            case 9: goto L22;
            case 10: goto L20;
            case 11: goto L18;
            case 12: goto L16;
            case 13: goto L14;
            case 14: goto L12;
            case 15: goto L10;
            case 16: goto L8;
            case 17: goto L6;
            default: goto L5;
        };
    L6:
        byte _aidl_value = _aidl_parcel.readByte();
        _set(_aidl_tag, Byte.valueOf(_aidl_value));
        return;
    L8:
        boolean _aidl_value2 = _aidl_parcel.readBoolean();
        _set(_aidl_tag, Boolean.valueOf(_aidl_value2));
        return;
    L10:
        int _aidl_value3 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value3));
        return;
    L12:
        byte _aidl_value4 = _aidl_parcel.readByte();
        _set(_aidl_tag, Byte.valueOf(_aidl_value4));
        return;
    L14:
        DtsVirtualX _aidl_value5 = (DtsVirtualX) _aidl_parcel.readTypedObject(DtsVirtualX.CREATOR);
        _set(_aidl_tag, _aidl_value5);
        return;
    L16:
        byte _aidl_value6 = _aidl_parcel.readByte();
        _set(_aidl_tag, Byte.valueOf(_aidl_value6));
        return;
    L18:
        DolbyAudioProcessing _aidl_value7 = (DolbyAudioProcessing) _aidl_parcel.readTypedObject(DolbyAudioProcessing.CREATOR);
        _set(_aidl_tag, _aidl_value7);
        return;
    L20:
        boolean _aidl_value8 = _aidl_parcel.readBoolean();
        _set(_aidl_tag, Boolean.valueOf(_aidl_value8));
        return;
    L22:
        byte _aidl_value9 = _aidl_parcel.readByte();
        _set(_aidl_tag, Byte.valueOf(_aidl_value9));
        return;
    L24:
        boolean _aidl_value10 = _aidl_parcel.readBoolean();
        _set(_aidl_tag, Boolean.valueOf(_aidl_value10));
        return;
    L26:
        boolean _aidl_value11 = _aidl_parcel.readBoolean();
        _set(_aidl_tag, Boolean.valueOf(_aidl_value11));
        return;
    L28:
        int _aidl_value12 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value12));
        return;
    L30:
        boolean _aidl_value13 = _aidl_parcel.readBoolean();
        _set(_aidl_tag, Boolean.valueOf(_aidl_value13));
        return;
    L32:
        EqualizerDetail _aidl_value14 = (EqualizerDetail) _aidl_parcel.readTypedObject(EqualizerDetail.CREATOR);
        _set(_aidl_tag, _aidl_value14);
        return;
    L34:
        boolean _aidl_value15 = _aidl_parcel.readBoolean();
        _set(_aidl_tag, Boolean.valueOf(_aidl_value15));
        return;
    L36:
        int _aidl_value16 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value16));
        return;
    L38:
        int _aidl_value17 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value17));
        return;
    L40:
        int _aidl_value18 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value18));
        return;
    L5:
        throw new IllegalArgumentException("union: unknown tag: " + _aidl_tag);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        switch(getTag()) {
            case 4: goto L7;
            case 11: goto L6;
            case 13: goto L5;
            default: goto L11;
        };
    L5:
        int _mask = 0 | describeContents(getDtsVirtualX());
        return _mask;
    L6:
        int _mask2 = 0 | describeContents(getDolbyAudioProcessing());
        return _mask2;
    L7:
        int _mask3 = 0 | describeContents(getEqualizerDetail());
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
            case 0: goto L39;
            case 1: goto L37;
            case 2: goto L35;
            case 3: goto L33;
            case 4: goto L31;
            case 5: goto L29;
            case 6: goto L27;
            case 7: goto L25;
            case 8: goto L23;
            case 9: goto L21;
            case 10: goto L19;
            case 11: goto L17;
            case 12: goto L15;
            case 13: goto L13;
            case 14: goto L11;
            case 15: goto L9;
            case 16: goto L7;
            case 17: goto L5;
            default: goto L4;
        };
    L5:
        return "soundStyle";
    L7:
        return "activeProfile";
    L9:
        return "digitalOutputDelayMs";
    L11:
        return "digitalOutput";
    L13:
        return "dtsVirtualX";
    L15:
        return "dolbyDialogueEnhancer";
    L17:
        return "dolbyAudioProcessing";
    L19:
        return "dtsDrc";
    L21:
        return "downmixMode";
    L23:
        return "autoVolumeControl";
    L25:
        return "enhancedAudioReturnChannelEnabled";
    L27:
        return "speakersDelayMs";
    L29:
        return "speakersEnabled";
    L31:
        return "equalizerDetail";
    L33:
        return "surroundSoundEnabled";
    L35:
        return "treble";
    L37:
        return "bass";
    L39:
        return "balance";
    L4:
        throw new IllegalStateException("unknown field: " + _tag);
    }

    private void _set(int _tag, Object _value) {
        this._tag = _tag;
        this._value = _value;
    }
}
