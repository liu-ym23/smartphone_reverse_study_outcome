package android.hardware.audio.effect;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class Flags implements Parcelable {
    public static final Parcelable.Creator<Flags> CREATOR = null;
    public boolean audioModeIndication;
    public boolean audioSourceIndication;
    public boolean bypass;
    public boolean deviceIndication;
    public byte hwAcceleratorMode;
    public byte insert;
    public boolean offloadIndication;
    public byte type;
    public byte volume;

    public @interface HardwareAccelerator {
        public static final byte NONE = 0;
        public static final byte SIMPLE = 1;
        public static final byte TUNNEL = 2;
    }

    public @interface Insert {
        public static final byte ANY = 0;
        public static final byte EXCLUSIVE = 3;
        public static final byte FIRST = 1;
        public static final byte LAST = 2;
    }

    public @interface Type {
        public static final byte AUXILIARY = 1;
        public static final byte INSERT = 0;
        public static final byte POST_PROC = 4;
        public static final byte PRE_PROC = 3;
        public static final byte REPLACE = 2;
    }

    public @interface Volume {
        public static final byte CTRL = 1;
        public static final byte IND = 2;
        public static final byte MONITOR = 3;
        public static final byte NONE = 0;
    }

    public Flags() {
        this.type = 0;
        this.insert = 0;
        this.volume = 0;
        this.hwAcceleratorMode = 0;
        this.offloadIndication = false;
        this.deviceIndication = false;
        this.audioModeIndication = false;
        this.audioSourceIndication = false;
        this.bypass = false;
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
        _aidl_parcel.writeByte(this.type);
        _aidl_parcel.writeByte(this.insert);
        _aidl_parcel.writeByte(this.volume);
        _aidl_parcel.writeByte(this.hwAcceleratorMode);
        _aidl_parcel.writeBoolean(this.offloadIndication);
        _aidl_parcel.writeBoolean(this.deviceIndication);
        _aidl_parcel.writeBoolean(this.audioModeIndication);
        _aidl_parcel.writeBoolean(this.audioSourceIndication);
        _aidl_parcel.writeBoolean(this.bypass);
        int _aidl_end_pos = _aidl_parcel.dataPosition();
        _aidl_parcel.setDataPosition(_aidl_start_pos);
        _aidl_parcel.writeInt(_aidl_end_pos - _aidl_start_pos);
        _aidl_parcel.setDataPosition(_aidl_end_pos);
    }

    public final void readFromParcel(Parcel _aidl_parcel) {
        int _aidl_start_pos = _aidl_parcel.dataPosition();
        int _aidl_parcelable_size = _aidl_parcel.readInt();
        if (_aidl_parcelable_size < 4) goto L95;
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L8;
        this.type = _aidl_parcel.readByte();     // Catch: Throwable -> L92
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
        this.insert = _aidl_parcel.readByte();     // Catch: Throwable -> L92
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L26;
        this.volume = _aidl_parcel.readByte();     // Catch: Throwable -> L92
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L35;
        this.hwAcceleratorMode = _aidl_parcel.readByte();     // Catch: Throwable -> L92
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L44;
        this.offloadIndication = _aidl_parcel.readBoolean();     // Catch: Throwable -> L92
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L53;
        this.deviceIndication = _aidl_parcel.readBoolean();     // Catch: Throwable -> L92
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L62;
        this.audioModeIndication = _aidl_parcel.readBoolean();     // Catch: Throwable -> L92
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L71;
        this.audioSourceIndication = _aidl_parcel.readBoolean();     // Catch: Throwable -> L92
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L80;
        this.bypass = _aidl_parcel.readBoolean();     // Catch: Throwable -> L92
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L91;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L91:
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
    L95:
        throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L92
    L92:
        th = move-exception;
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L99;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        throw th;
    L99:
        throw new BadParcelableException("Overflow in the size of parcelable");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
