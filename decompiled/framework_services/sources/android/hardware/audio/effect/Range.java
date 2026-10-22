package android.hardware.audio.effect;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class Range implements Parcelable {
    public static final Parcelable.Creator<Range> CREATOR = null;
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
    public static final int vendorExtension = 0;
    public static final int virtualizer = 13;
    public static final int visualizer = 14;
    public static final int volume = 15;
    private int _tag;
    private Object _value;

    public static class AcousticEchoCancelerRange implements Parcelable {
        public static final Parcelable.Creator<AcousticEchoCancelerRange> CREATOR = null;
        public AcousticEchoCanceler max;
        public AcousticEchoCanceler min;

        public AcousticEchoCancelerRange() {
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
            _aidl_parcel.writeTypedObject(this.min, _aidl_flag);
            _aidl_parcel.writeTypedObject(this.max, _aidl_flag);
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
            this.min = (AcousticEchoCanceler) _aidl_parcel.readTypedObject(AcousticEchoCanceler.CREATOR);     // Catch: Throwable -> L29
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
            this.max = (AcousticEchoCanceler) _aidl_parcel.readTypedObject(AcousticEchoCanceler.CREATOR);     // Catch: Throwable -> L29
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
            int _mask = 0 | describeContents(this.min);
            return _mask | describeContents(this.max);
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

    public static class AutomaticGainControlV1Range implements Parcelable {
        public static final Parcelable.Creator<AutomaticGainControlV1Range> CREATOR = null;
        public AutomaticGainControlV1 max;
        public AutomaticGainControlV1 min;

        public AutomaticGainControlV1Range() {
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
            _aidl_parcel.writeTypedObject(this.min, _aidl_flag);
            _aidl_parcel.writeTypedObject(this.max, _aidl_flag);
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
            this.min = (AutomaticGainControlV1) _aidl_parcel.readTypedObject(AutomaticGainControlV1.CREATOR);     // Catch: Throwable -> L29
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
            this.max = (AutomaticGainControlV1) _aidl_parcel.readTypedObject(AutomaticGainControlV1.CREATOR);     // Catch: Throwable -> L29
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
            int _mask = 0 | describeContents(this.min);
            return _mask | describeContents(this.max);
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

    public static class AutomaticGainControlV2Range implements Parcelable {
        public static final Parcelable.Creator<AutomaticGainControlV2Range> CREATOR = null;
        public AutomaticGainControlV2 max;
        public AutomaticGainControlV2 min;

        public AutomaticGainControlV2Range() {
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
            _aidl_parcel.writeTypedObject(this.min, _aidl_flag);
            _aidl_parcel.writeTypedObject(this.max, _aidl_flag);
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
            this.min = (AutomaticGainControlV2) _aidl_parcel.readTypedObject(AutomaticGainControlV2.CREATOR);     // Catch: Throwable -> L29
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
            this.max = (AutomaticGainControlV2) _aidl_parcel.readTypedObject(AutomaticGainControlV2.CREATOR);     // Catch: Throwable -> L29
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
            int _mask = 0 | describeContents(this.min);
            return _mask | describeContents(this.max);
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

    public static class BassBoostRange implements Parcelable {
        public static final Parcelable.Creator<BassBoostRange> CREATOR = null;
        public BassBoost max;
        public BassBoost min;

        public BassBoostRange() {
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
            _aidl_parcel.writeTypedObject(this.min, _aidl_flag);
            _aidl_parcel.writeTypedObject(this.max, _aidl_flag);
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
            this.min = (BassBoost) _aidl_parcel.readTypedObject(BassBoost.CREATOR);     // Catch: Throwable -> L29
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
            this.max = (BassBoost) _aidl_parcel.readTypedObject(BassBoost.CREATOR);     // Catch: Throwable -> L29
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
            int _mask = 0 | describeContents(this.min);
            return _mask | describeContents(this.max);
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

    public static class DownmixRange implements Parcelable {
        public static final Parcelable.Creator<DownmixRange> CREATOR = null;
        public Downmix max;
        public Downmix min;

        public DownmixRange() {
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
            _aidl_parcel.writeTypedObject(this.min, _aidl_flag);
            _aidl_parcel.writeTypedObject(this.max, _aidl_flag);
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
            this.min = (Downmix) _aidl_parcel.readTypedObject(Downmix.CREATOR);     // Catch: Throwable -> L29
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
            this.max = (Downmix) _aidl_parcel.readTypedObject(Downmix.CREATOR);     // Catch: Throwable -> L29
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
            int _mask = 0 | describeContents(this.min);
            return _mask | describeContents(this.max);
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

    public static class DynamicsProcessingRange implements Parcelable {
        public static final Parcelable.Creator<DynamicsProcessingRange> CREATOR = null;
        public DynamicsProcessing max;
        public DynamicsProcessing min;

        public DynamicsProcessingRange() {
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
            _aidl_parcel.writeTypedObject(this.min, _aidl_flag);
            _aidl_parcel.writeTypedObject(this.max, _aidl_flag);
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
            this.min = (DynamicsProcessing) _aidl_parcel.readTypedObject(DynamicsProcessing.CREATOR);     // Catch: Throwable -> L29
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
            this.max = (DynamicsProcessing) _aidl_parcel.readTypedObject(DynamicsProcessing.CREATOR);     // Catch: Throwable -> L29
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
            int _mask = 0 | describeContents(this.min);
            return _mask | describeContents(this.max);
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

    public static class EnvironmentalReverbRange implements Parcelable {
        public static final Parcelable.Creator<EnvironmentalReverbRange> CREATOR = null;
        public EnvironmentalReverb max;
        public EnvironmentalReverb min;

        public EnvironmentalReverbRange() {
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
            _aidl_parcel.writeTypedObject(this.min, _aidl_flag);
            _aidl_parcel.writeTypedObject(this.max, _aidl_flag);
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
            this.min = (EnvironmentalReverb) _aidl_parcel.readTypedObject(EnvironmentalReverb.CREATOR);     // Catch: Throwable -> L29
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
            this.max = (EnvironmentalReverb) _aidl_parcel.readTypedObject(EnvironmentalReverb.CREATOR);     // Catch: Throwable -> L29
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
            int _mask = 0 | describeContents(this.min);
            return _mask | describeContents(this.max);
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

    public static class EqualizerRange implements Parcelable {
        public static final Parcelable.Creator<EqualizerRange> CREATOR = null;
        public Equalizer max;
        public Equalizer min;

        public EqualizerRange() {
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
            _aidl_parcel.writeTypedObject(this.min, _aidl_flag);
            _aidl_parcel.writeTypedObject(this.max, _aidl_flag);
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
            this.min = (Equalizer) _aidl_parcel.readTypedObject(Equalizer.CREATOR);     // Catch: Throwable -> L29
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
            this.max = (Equalizer) _aidl_parcel.readTypedObject(Equalizer.CREATOR);     // Catch: Throwable -> L29
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
            int _mask = 0 | describeContents(this.min);
            return _mask | describeContents(this.max);
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

    public static class HapticGeneratorRange implements Parcelable {
        public static final Parcelable.Creator<HapticGeneratorRange> CREATOR = null;
        public HapticGenerator max;
        public HapticGenerator min;

        public HapticGeneratorRange() {
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
            _aidl_parcel.writeTypedObject(this.min, _aidl_flag);
            _aidl_parcel.writeTypedObject(this.max, _aidl_flag);
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
            this.min = (HapticGenerator) _aidl_parcel.readTypedObject(HapticGenerator.CREATOR);     // Catch: Throwable -> L29
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
            this.max = (HapticGenerator) _aidl_parcel.readTypedObject(HapticGenerator.CREATOR);     // Catch: Throwable -> L29
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
            int _mask = 0 | describeContents(this.min);
            return _mask | describeContents(this.max);
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

    public static class LoudnessEnhancerRange implements Parcelable {
        public static final Parcelable.Creator<LoudnessEnhancerRange> CREATOR = null;
        public LoudnessEnhancer max;
        public LoudnessEnhancer min;

        public LoudnessEnhancerRange() {
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
            _aidl_parcel.writeTypedObject(this.min, _aidl_flag);
            _aidl_parcel.writeTypedObject(this.max, _aidl_flag);
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
            this.min = (LoudnessEnhancer) _aidl_parcel.readTypedObject(LoudnessEnhancer.CREATOR);     // Catch: Throwable -> L29
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
            this.max = (LoudnessEnhancer) _aidl_parcel.readTypedObject(LoudnessEnhancer.CREATOR);     // Catch: Throwable -> L29
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
            int _mask = 0 | describeContents(this.min);
            return _mask | describeContents(this.max);
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

    public static class NoiseSuppressionRange implements Parcelable {
        public static final Parcelable.Creator<NoiseSuppressionRange> CREATOR = null;
        public NoiseSuppression max;
        public NoiseSuppression min;

        public NoiseSuppressionRange() {
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
            _aidl_parcel.writeTypedObject(this.min, _aidl_flag);
            _aidl_parcel.writeTypedObject(this.max, _aidl_flag);
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
            this.min = (NoiseSuppression) _aidl_parcel.readTypedObject(NoiseSuppression.CREATOR);     // Catch: Throwable -> L29
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
            this.max = (NoiseSuppression) _aidl_parcel.readTypedObject(NoiseSuppression.CREATOR);     // Catch: Throwable -> L29
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
            int _mask = 0 | describeContents(this.min);
            return _mask | describeContents(this.max);
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

    public static class PresetReverbRange implements Parcelable {
        public static final Parcelable.Creator<PresetReverbRange> CREATOR = null;
        public PresetReverb max;
        public PresetReverb min;

        public PresetReverbRange() {
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
            _aidl_parcel.writeTypedObject(this.min, _aidl_flag);
            _aidl_parcel.writeTypedObject(this.max, _aidl_flag);
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
            this.min = (PresetReverb) _aidl_parcel.readTypedObject(PresetReverb.CREATOR);     // Catch: Throwable -> L29
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
            this.max = (PresetReverb) _aidl_parcel.readTypedObject(PresetReverb.CREATOR);     // Catch: Throwable -> L29
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
            int _mask = 0 | describeContents(this.min);
            return _mask | describeContents(this.max);
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
        public static final int vendorExtension = 0;
        public static final int virtualizer = 13;
        public static final int visualizer = 14;
        public static final int volume = 15;
    }

    public static class VendorExtensionRange implements Parcelable {
        public static final Parcelable.Creator<VendorExtensionRange> CREATOR = null;
        public VendorExtension max;
        public VendorExtension min;

        public VendorExtensionRange() {
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
            _aidl_parcel.writeTypedObject(this.min, _aidl_flag);
            _aidl_parcel.writeTypedObject(this.max, _aidl_flag);
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
            this.min = (VendorExtension) _aidl_parcel.readTypedObject(VendorExtension.CREATOR);     // Catch: Throwable -> L29
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
            this.max = (VendorExtension) _aidl_parcel.readTypedObject(VendorExtension.CREATOR);     // Catch: Throwable -> L29
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
            int _mask = 0 | describeContents(this.min);
            return _mask | describeContents(this.max);
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

    public static class VirtualizerRange implements Parcelable {
        public static final Parcelable.Creator<VirtualizerRange> CREATOR = null;
        public Virtualizer max;
        public Virtualizer min;

        public VirtualizerRange() {
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
            _aidl_parcel.writeTypedObject(this.min, _aidl_flag);
            _aidl_parcel.writeTypedObject(this.max, _aidl_flag);
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
            this.min = (Virtualizer) _aidl_parcel.readTypedObject(Virtualizer.CREATOR);     // Catch: Throwable -> L29
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
            this.max = (Virtualizer) _aidl_parcel.readTypedObject(Virtualizer.CREATOR);     // Catch: Throwable -> L29
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
            int _mask = 0 | describeContents(this.min);
            return _mask | describeContents(this.max);
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

    public static class VisualizerRange implements Parcelable {
        public static final Parcelable.Creator<VisualizerRange> CREATOR = null;
        public Visualizer max;
        public Visualizer min;

        public VisualizerRange() {
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
            _aidl_parcel.writeTypedObject(this.min, _aidl_flag);
            _aidl_parcel.writeTypedObject(this.max, _aidl_flag);
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
            this.min = (Visualizer) _aidl_parcel.readTypedObject(Visualizer.CREATOR);     // Catch: Throwable -> L29
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
            this.max = (Visualizer) _aidl_parcel.readTypedObject(Visualizer.CREATOR);     // Catch: Throwable -> L29
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
            int _mask = 0 | describeContents(this.min);
            return _mask | describeContents(this.max);
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

    public static class VolumeRange implements Parcelable {
        public static final Parcelable.Creator<VolumeRange> CREATOR = null;
        public Volume max;
        public Volume min;

        public VolumeRange() {
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
            _aidl_parcel.writeTypedObject(this.min, _aidl_flag);
            _aidl_parcel.writeTypedObject(this.max, _aidl_flag);
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
            this.min = (Volume) _aidl_parcel.readTypedObject(Volume.CREATOR);     // Catch: Throwable -> L29
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
            this.max = (Volume) _aidl_parcel.readTypedObject(Volume.CREATOR);     // Catch: Throwable -> L29
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
            int _mask = 0 | describeContents(this.min);
            return _mask | describeContents(this.max);
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

    /* synthetic */ Range(Parcel r1, RangeIA r2) {
        this(r1);
    }

    public Range() {
        VendorExtensionRange[] _value = new VendorExtensionRange[0];
        this._tag = 0;
        this._value = _value;
    }

    private Range(Parcel _aidl_parcel) {
        readFromParcel(_aidl_parcel);
    }

    private Range(int _tag, Object _value) {
        this._tag = _tag;
        this._value = _value;
    }

    public int getTag() {
        return this._tag;
    }

    public static Range vendorExtension(VendorExtensionRange[] _value) {
        return new Range(0, _value);
    }

    public VendorExtensionRange[] getVendorExtension() {
        _assertTag(0);
        return (VendorExtensionRange[]) this._value;
    }

    public void setVendorExtension(VendorExtensionRange[] _value) {
        _set(0, _value);
    }

    public static Range acousticEchoCanceler(AcousticEchoCancelerRange[] _value) {
        return new Range(1, _value);
    }

    public AcousticEchoCancelerRange[] getAcousticEchoCanceler() {
        _assertTag(1);
        return (AcousticEchoCancelerRange[]) this._value;
    }

    public void setAcousticEchoCanceler(AcousticEchoCancelerRange[] _value) {
        _set(1, _value);
    }

    public static Range automaticGainControlV1(AutomaticGainControlV1Range[] _value) {
        return new Range(2, _value);
    }

    public AutomaticGainControlV1Range[] getAutomaticGainControlV1() {
        _assertTag(2);
        return (AutomaticGainControlV1Range[]) this._value;
    }

    public void setAutomaticGainControlV1(AutomaticGainControlV1Range[] _value) {
        _set(2, _value);
    }

    public static Range automaticGainControlV2(AutomaticGainControlV2Range[] _value) {
        return new Range(3, _value);
    }

    public AutomaticGainControlV2Range[] getAutomaticGainControlV2() {
        _assertTag(3);
        return (AutomaticGainControlV2Range[]) this._value;
    }

    public void setAutomaticGainControlV2(AutomaticGainControlV2Range[] _value) {
        _set(3, _value);
    }

    public static Range bassBoost(BassBoostRange[] _value) {
        return new Range(4, _value);
    }

    public BassBoostRange[] getBassBoost() {
        _assertTag(4);
        return (BassBoostRange[]) this._value;
    }

    public void setBassBoost(BassBoostRange[] _value) {
        _set(4, _value);
    }

    public static Range downmix(DownmixRange[] _value) {
        return new Range(5, _value);
    }

    public DownmixRange[] getDownmix() {
        _assertTag(5);
        return (DownmixRange[]) this._value;
    }

    public void setDownmix(DownmixRange[] _value) {
        _set(5, _value);
    }

    public static Range dynamicsProcessing(DynamicsProcessingRange[] _value) {
        return new Range(6, _value);
    }

    public DynamicsProcessingRange[] getDynamicsProcessing() {
        _assertTag(6);
        return (DynamicsProcessingRange[]) this._value;
    }

    public void setDynamicsProcessing(DynamicsProcessingRange[] _value) {
        _set(6, _value);
    }

    public static Range environmentalReverb(EnvironmentalReverbRange[] _value) {
        return new Range(7, _value);
    }

    public EnvironmentalReverbRange[] getEnvironmentalReverb() {
        _assertTag(7);
        return (EnvironmentalReverbRange[]) this._value;
    }

    public void setEnvironmentalReverb(EnvironmentalReverbRange[] _value) {
        _set(7, _value);
    }

    public static Range equalizer(EqualizerRange[] _value) {
        return new Range(8, _value);
    }

    public EqualizerRange[] getEqualizer() {
        _assertTag(8);
        return (EqualizerRange[]) this._value;
    }

    public void setEqualizer(EqualizerRange[] _value) {
        _set(8, _value);
    }

    public static Range hapticGenerator(HapticGeneratorRange[] _value) {
        return new Range(9, _value);
    }

    public HapticGeneratorRange[] getHapticGenerator() {
        _assertTag(9);
        return (HapticGeneratorRange[]) this._value;
    }

    public void setHapticGenerator(HapticGeneratorRange[] _value) {
        _set(9, _value);
    }

    public static Range loudnessEnhancer(LoudnessEnhancerRange[] _value) {
        return new Range(10, _value);
    }

    public LoudnessEnhancerRange[] getLoudnessEnhancer() {
        _assertTag(10);
        return (LoudnessEnhancerRange[]) this._value;
    }

    public void setLoudnessEnhancer(LoudnessEnhancerRange[] _value) {
        _set(10, _value);
    }

    public static Range noiseSuppression(NoiseSuppressionRange[] _value) {
        return new Range(11, _value);
    }

    public NoiseSuppressionRange[] getNoiseSuppression() {
        _assertTag(11);
        return (NoiseSuppressionRange[]) this._value;
    }

    public void setNoiseSuppression(NoiseSuppressionRange[] _value) {
        _set(11, _value);
    }

    public static Range presetReverb(PresetReverbRange[] _value) {
        return new Range(12, _value);
    }

    public PresetReverbRange[] getPresetReverb() {
        _assertTag(12);
        return (PresetReverbRange[]) this._value;
    }

    public void setPresetReverb(PresetReverbRange[] _value) {
        _set(12, _value);
    }

    public static Range virtualizer(VirtualizerRange[] _value) {
        return new Range(13, _value);
    }

    public VirtualizerRange[] getVirtualizer() {
        _assertTag(13);
        return (VirtualizerRange[]) this._value;
    }

    public void setVirtualizer(VirtualizerRange[] _value) {
        _set(13, _value);
    }

    public static Range visualizer(VisualizerRange[] _value) {
        return new Range(14, _value);
    }

    public VisualizerRange[] getVisualizer() {
        _assertTag(14);
        return (VisualizerRange[]) this._value;
    }

    public void setVisualizer(VisualizerRange[] _value) {
        _set(14, _value);
    }

    public static Range volume(VolumeRange[] _value) {
        return new Range(15, _value);
    }

    public VolumeRange[] getVolume() {
        _assertTag(15);
        return (VolumeRange[]) this._value;
    }

    public void setVolume(VolumeRange[] _value) {
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
        _aidl_parcel.writeTypedArray(getVolume(), _aidl_flag);
        return;
    L6:
        _aidl_parcel.writeTypedArray(getVisualizer(), _aidl_flag);
        return;
    L7:
        _aidl_parcel.writeTypedArray(getVirtualizer(), _aidl_flag);
        return;
    L8:
        _aidl_parcel.writeTypedArray(getPresetReverb(), _aidl_flag);
        return;
    L9:
        _aidl_parcel.writeTypedArray(getNoiseSuppression(), _aidl_flag);
        return;
    L10:
        _aidl_parcel.writeTypedArray(getLoudnessEnhancer(), _aidl_flag);
        return;
    L11:
        _aidl_parcel.writeTypedArray(getHapticGenerator(), _aidl_flag);
        return;
    L12:
        _aidl_parcel.writeTypedArray(getEqualizer(), _aidl_flag);
        return;
    L13:
        _aidl_parcel.writeTypedArray(getEnvironmentalReverb(), _aidl_flag);
        return;
    L14:
        _aidl_parcel.writeTypedArray(getDynamicsProcessing(), _aidl_flag);
        return;
    L15:
        _aidl_parcel.writeTypedArray(getDownmix(), _aidl_flag);
        return;
    L16:
        _aidl_parcel.writeTypedArray(getBassBoost(), _aidl_flag);
        return;
    L17:
        _aidl_parcel.writeTypedArray(getAutomaticGainControlV2(), _aidl_flag);
        return;
    L18:
        _aidl_parcel.writeTypedArray(getAutomaticGainControlV1(), _aidl_flag);
        return;
    L19:
        _aidl_parcel.writeTypedArray(getAcousticEchoCanceler(), _aidl_flag);
        return;
    L20:
        _aidl_parcel.writeTypedArray(getVendorExtension(), _aidl_flag);
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
        VolumeRange[] _aidl_value = (VolumeRange[]) _aidl_parcel.createTypedArray(VolumeRange.CREATOR);
        _set(_aidl_tag, _aidl_value);
        return;
    L8:
        VisualizerRange[] _aidl_value2 = (VisualizerRange[]) _aidl_parcel.createTypedArray(VisualizerRange.CREATOR);
        _set(_aidl_tag, _aidl_value2);
        return;
    L10:
        VirtualizerRange[] _aidl_value3 = (VirtualizerRange[]) _aidl_parcel.createTypedArray(VirtualizerRange.CREATOR);
        _set(_aidl_tag, _aidl_value3);
        return;
    L12:
        PresetReverbRange[] _aidl_value4 = (PresetReverbRange[]) _aidl_parcel.createTypedArray(PresetReverbRange.CREATOR);
        _set(_aidl_tag, _aidl_value4);
        return;
    L14:
        NoiseSuppressionRange[] _aidl_value5 = (NoiseSuppressionRange[]) _aidl_parcel.createTypedArray(NoiseSuppressionRange.CREATOR);
        _set(_aidl_tag, _aidl_value5);
        return;
    L16:
        LoudnessEnhancerRange[] _aidl_value6 = (LoudnessEnhancerRange[]) _aidl_parcel.createTypedArray(LoudnessEnhancerRange.CREATOR);
        _set(_aidl_tag, _aidl_value6);
        return;
    L18:
        HapticGeneratorRange[] _aidl_value7 = (HapticGeneratorRange[]) _aidl_parcel.createTypedArray(HapticGeneratorRange.CREATOR);
        _set(_aidl_tag, _aidl_value7);
        return;
    L20:
        EqualizerRange[] _aidl_value8 = (EqualizerRange[]) _aidl_parcel.createTypedArray(EqualizerRange.CREATOR);
        _set(_aidl_tag, _aidl_value8);
        return;
    L22:
        EnvironmentalReverbRange[] _aidl_value9 = (EnvironmentalReverbRange[]) _aidl_parcel.createTypedArray(EnvironmentalReverbRange.CREATOR);
        _set(_aidl_tag, _aidl_value9);
        return;
    L24:
        DynamicsProcessingRange[] _aidl_value10 = (DynamicsProcessingRange[]) _aidl_parcel.createTypedArray(DynamicsProcessingRange.CREATOR);
        _set(_aidl_tag, _aidl_value10);
        return;
    L26:
        DownmixRange[] _aidl_value11 = (DownmixRange[]) _aidl_parcel.createTypedArray(DownmixRange.CREATOR);
        _set(_aidl_tag, _aidl_value11);
        return;
    L28:
        BassBoostRange[] _aidl_value12 = (BassBoostRange[]) _aidl_parcel.createTypedArray(BassBoostRange.CREATOR);
        _set(_aidl_tag, _aidl_value12);
        return;
    L30:
        AutomaticGainControlV2Range[] _aidl_value13 = (AutomaticGainControlV2Range[]) _aidl_parcel.createTypedArray(AutomaticGainControlV2Range.CREATOR);
        _set(_aidl_tag, _aidl_value13);
        return;
    L32:
        AutomaticGainControlV1Range[] _aidl_value14 = (AutomaticGainControlV1Range[]) _aidl_parcel.createTypedArray(AutomaticGainControlV1Range.CREATOR);
        _set(_aidl_tag, _aidl_value14);
        return;
    L34:
        AcousticEchoCancelerRange[] _aidl_value15 = (AcousticEchoCancelerRange[]) _aidl_parcel.createTypedArray(AcousticEchoCancelerRange.CREATOR);
        _set(_aidl_tag, _aidl_value15);
        return;
    L36:
        VendorExtensionRange[] _aidl_value16 = (VendorExtensionRange[]) _aidl_parcel.createTypedArray(VendorExtensionRange.CREATOR);
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
        int _mask16 = 0 | describeContents(getVendorExtension());
        return _mask16;
    L37:
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
        return "vendorExtension";
    L4:
        throw new IllegalStateException("unknown field: " + _tag);
    }

    private void _set(int _tag, Object _value) {
        this._tag = _tag;
        this._value = _value;
    }
}
