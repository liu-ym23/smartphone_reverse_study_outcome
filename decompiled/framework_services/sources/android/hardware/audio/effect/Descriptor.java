package android.hardware.audio.effect;

import android.media.audio.common.AudioUuid;
import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class Descriptor implements Parcelable {
    public static final Parcelable.Creator<Descriptor> CREATOR = null;
    public static final String EFFECT_TYPE_UUID_AEC = "7b491460-8d4d-11e0-bd61-0002a5d5c51b";
    public static final String EFFECT_TYPE_UUID_AGC1 = "0a8abfe0-654c-11e0-ba26-0002a5d5c51b";
    public static final String EFFECT_TYPE_UUID_AGC2 = "ae3c653b-be18-4ab8-8938-418f0a7f06ac";
    public static final String EFFECT_TYPE_UUID_BASS_BOOST = "0634f220-ddd4-11db-a0fc-0002a5d5c51b";
    public static final String EFFECT_TYPE_UUID_DOWNMIX = "381e49cc-a858-4aa2-87f6-e8388e7601b2";
    public static final String EFFECT_TYPE_UUID_DYNAMICS_PROCESSING = "7261676f-6d75-7369-6364-28e2fd3ac39e";
    public static final String EFFECT_TYPE_UUID_ENV_REVERB = "c2e5d5f0-94bd-4763-9cac-4e234d06839e";
    public static final String EFFECT_TYPE_UUID_EQUALIZER = "0bed4300-ddd6-11db-8f34-0002a5d5c51b";
    public static final String EFFECT_TYPE_UUID_HAPTIC_GENERATOR = "1411e6d6-aecd-4021-a1cf-a6aceb0d71e5";
    public static final String EFFECT_TYPE_UUID_LOUDNESS_ENHANCER = "fe3199be-aed0-413f-87bb-11260eb63cf1";
    public static final String EFFECT_TYPE_UUID_NS = "58b4b260-8e06-11e0-aa8e-0002a5d5c51b";
    public static final String EFFECT_TYPE_UUID_PRESET_REVERB = "47382d60-ddd8-11db-bf3a-0002a5d5c51b";
    public static final String EFFECT_TYPE_UUID_SPATIALIZER = "ccd4cf09-a79d-46c2-9aae-06a1698d6c8f";
    public static final String EFFECT_TYPE_UUID_VIRTUALIZER = "37cc2c00-dddd-11db-8577-0002a5d5c51b";
    public static final String EFFECT_TYPE_UUID_VISUALIZER = "e46b26a0-dddd-11db-8afd-0002a5d5c51b";
    public static final String EFFECT_TYPE_UUID_VOLUME = "09e8ede0-ddde-11db-b4f6-0002a5d5c51b";
    public Capability capability;
    public Common common;

    public static class Common implements Parcelable {
        public static final Parcelable.Creator<Common> CREATOR = null;
        public int cpuLoad;
        public Flags flags;
        public Identity id;
        public String implementor;
        public int memoryUsage;
        public String name;

        public Common() {
            this.cpuLoad = 0;
            this.memoryUsage = 0;
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
            _aidl_parcel.writeTypedObject(this.id, _aidl_flag);
            _aidl_parcel.writeTypedObject(this.flags, _aidl_flag);
            _aidl_parcel.writeInt(this.cpuLoad);
            _aidl_parcel.writeInt(this.memoryUsage);
            _aidl_parcel.writeString(this.name);
            _aidl_parcel.writeString(this.implementor);
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
            this.id = (Identity) _aidl_parcel.readTypedObject(Identity.CREATOR);     // Catch: Throwable -> L65
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
            this.flags = (Flags) _aidl_parcel.readTypedObject(Flags.CREATOR);     // Catch: Throwable -> L65
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L26;
            this.cpuLoad = _aidl_parcel.readInt();     // Catch: Throwable -> L65
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L35;
            this.memoryUsage = _aidl_parcel.readInt();     // Catch: Throwable -> L65
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L44;
            this.name = _aidl_parcel.readString();     // Catch: Throwable -> L65
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L53;
            this.implementor = _aidl_parcel.readString();     // Catch: Throwable -> L65
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
            int _mask = 0 | describeContents(this.id);
            return _mask | describeContents(this.flags);
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

    public static class Identity implements Parcelable {
        public static final Parcelable.Creator<Identity> CREATOR = null;
        public AudioUuid proxy;
        public AudioUuid type;
        public AudioUuid uuid;

        public Identity() {
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
            _aidl_parcel.writeTypedObject(this.type, _aidl_flag);
            _aidl_parcel.writeTypedObject(this.uuid, _aidl_flag);
            _aidl_parcel.writeTypedObject(this.proxy, _aidl_flag);
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
            this.type = (AudioUuid) _aidl_parcel.readTypedObject(AudioUuid.CREATOR);     // Catch: Throwable -> L38
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
            this.uuid = (AudioUuid) _aidl_parcel.readTypedObject(AudioUuid.CREATOR);     // Catch: Throwable -> L38
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L26;
            this.proxy = (AudioUuid) _aidl_parcel.readTypedObject(AudioUuid.CREATOR);     // Catch: Throwable -> L38
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
            int _mask = 0 | describeContents(this.type);
            return (_mask | describeContents(this.uuid)) | describeContents(this.proxy);
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

    public Descriptor() {
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
        _aidl_parcel.writeTypedObject(this.common, _aidl_flag);
        _aidl_parcel.writeTypedObject(this.capability, _aidl_flag);
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
        this.common = (Common) _aidl_parcel.readTypedObject(Common.CREATOR);     // Catch: Throwable -> L29
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
        this.capability = (Capability) _aidl_parcel.readTypedObject(Capability.CREATOR);     // Catch: Throwable -> L29
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
        int _mask = 0 | describeContents(this.common);
        return _mask | describeContents(this.capability);
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
