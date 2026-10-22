package android.hardware.soundtrigger.V2_0;

import android.hardware.audio.common.V2_0.AudioDevice;
import android.hardware.audio.common.V2_0.Uuid;
import android.hardware.tv.mediaquality.ParameterName;
import android.hidl.base.V1_0.DebugInfo;
import android.hidl.base.V1_0.IBase;
import android.os.HidlSupport;
import android.os.HwBinder;
import android.os.HwBlob;
import android.os.HwParcel;
import android.os.IHwBinder;
import android.os.IHwInterface;
import android.os.NativeHandle;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public interface ISoundTriggerHw extends IBase {
    public static final String kInterfaceName = "android.hardware.soundtrigger@2.0::ISoundTriggerHw";

    public static final class Phrase {
        public int id;
        public String locale;
        public int recognitionModes;
        public String text;
        public ArrayList<Integer> users;

        public Phrase() {
            this.id = 0;
            this.recognitionModes = 0;
            this.users = new ArrayList();
            this.locale = new String();
            this.text = new String();
        }

        public final boolean equals(Object otherObject) {
            if (this != otherObject) goto L6;
            return true;
        L6:
            if (otherObject != null) goto L9;
            return false;
        L9:
            if (otherObject.getClass() == Phrase.class) goto L11;
            return false;
        L11:
            Phrase other = (Phrase) otherObject;
            if (this.id == other.id) goto L15;
            return false;
        L15:
            if (this.recognitionModes == other.recognitionModes) goto L18;
            return false;
        L18:
            if (HidlSupport.deepEquals(this.users, other.users) == true) goto L21;
            return false;
        L21:
            if (HidlSupport.deepEquals(this.locale, other.locale) == true) goto L24;
            return false;
        L24:
            if (HidlSupport.deepEquals(this.text, other.text) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.id))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.recognitionModes))), Integer.valueOf(HidlSupport.deepHashCode(this.users)), Integer.valueOf(HidlSupport.deepHashCode(this.locale)), Integer.valueOf(HidlSupport.deepHashCode(this.text))});
        }

        public final String toString() {
            return "{.id = " + this.id + ", .recognitionModes = " + this.recognitionModes + ", .users = " + this.users + ", .locale = " + this.locale + ", .text = " + this.text + "}";
        }

        public final void readFromParcel(HwParcel parcel) {
            HwBlob blob = parcel.readBuffer(56);
            readEmbeddedFromParcel(parcel, blob, 0);
        }

        public static final ArrayList<Phrase> readVectorFromParcel(HwParcel parcel) {
            ArrayList<Phrase> _hidl_vec = new ArrayList();
            HwBlob _hidl_blob = parcel.readBuffer(16);
            int _hidl_vec_size = _hidl_blob.getInt32(8);
            HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 56, _hidl_blob.handle(), 0, true);
            _hidl_vec.clear();
            int _hidl_index_0 = 0;
        L3:
            if (_hidl_index_0 >= _hidl_vec_size) goto L6;
            Phrase _hidl_vec_element = new Phrase();
            _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 56);
            _hidl_vec.add(_hidl_vec_element);
            _hidl_index_0 = _hidl_index_0 + 1;
            goto L3
        L6:
            return _hidl_vec;
        }

        public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
            this.id = _hidl_blob.getInt32(_hidl_offset + 0);
            this.recognitionModes = _hidl_blob.getInt32(_hidl_offset + 4);
            int _hidl_vec_size = _hidl_blob.getInt32((_hidl_offset + 8) + 8);
            HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 4, _hidl_blob.handle(), (_hidl_offset + 8) + 0, true);
            this.users.clear();
            int _hidl_index_0 = 0;
        L3:
            if (_hidl_index_0 >= _hidl_vec_size) goto L5;
            int _hidl_vec_element = childBlob.getInt32(_hidl_index_0 * 4);
            this.users.add(Integer.valueOf(_hidl_vec_element));
            _hidl_index_0 = _hidl_index_0 + 1;
            goto L3
        L5:
            this.locale = _hidl_blob.getString(_hidl_offset + 24);
            parcel.readEmbeddedBuffer(this.locale.getBytes().length + 1, _hidl_blob.handle(), (_hidl_offset + 24) + 0, false);
            this.text = _hidl_blob.getString(_hidl_offset + 40);
            parcel.readEmbeddedBuffer(this.text.getBytes().length + 1, _hidl_blob.handle(), (_hidl_offset + 40) + 0, false);
        }

        public final void writeToParcel(HwParcel parcel) {
            HwBlob _hidl_blob = new HwBlob(56);
            writeEmbeddedToBlob(_hidl_blob, 0);
            parcel.writeBuffer(_hidl_blob);
        }

        public static final void writeVectorToParcel(HwParcel parcel, ArrayList<Phrase> _hidl_vec) {
            HwBlob _hidl_blob = new HwBlob(16);
            int _hidl_vec_size = _hidl_vec.size();
            _hidl_blob.putInt32(8, _hidl_vec_size);
            _hidl_blob.putBool(12, false);
            HwBlob childBlob = new HwBlob(_hidl_vec_size * 56);
            int _hidl_index_0 = 0;
        L3:
            if (_hidl_index_0 >= _hidl_vec_size) goto L5;
            _hidl_vec.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 56);
            _hidl_index_0 = _hidl_index_0 + 1;
            goto L3
        L5:
            _hidl_blob.putBlob(0, childBlob);
            parcel.writeBuffer(_hidl_blob);
        }

        public final void writeEmbeddedToBlob(HwBlob _hidl_blob, long _hidl_offset) {
            _hidl_blob.putInt32(_hidl_offset + 0, this.id);
            _hidl_blob.putInt32(4 + _hidl_offset, this.recognitionModes);
            int _hidl_vec_size = this.users.size();
            _hidl_blob.putInt32((_hidl_offset + 8) + 8, _hidl_vec_size);
            _hidl_blob.putBool((_hidl_offset + 8) + 12, false);
            HwBlob childBlob = new HwBlob(_hidl_vec_size * 4);
            int _hidl_index_0 = 0;
        L3:
            if (_hidl_index_0 >= _hidl_vec_size) goto L5;
            childBlob.putInt32(_hidl_index_0 * 4, this.users.get(_hidl_index_0).intValue());
            _hidl_index_0 = _hidl_index_0 + 1;
            goto L3
        L5:
            _hidl_blob.putBlob((8 + _hidl_offset) + 0, childBlob);
            _hidl_blob.putString(24 + _hidl_offset, this.locale);
            _hidl_blob.putString(40 + _hidl_offset, this.text);
        }
    }

    public static final class PhraseSoundModel {
        public SoundModel common;
        public ArrayList<Phrase> phrases;

        public PhraseSoundModel() {
            this.common = new SoundModel();
            this.phrases = new ArrayList();
        }

        public final boolean equals(Object otherObject) {
            if (this != otherObject) goto L6;
            return true;
        L6:
            if (otherObject != null) goto L9;
            return false;
        L9:
            if (otherObject.getClass() == PhraseSoundModel.class) goto L11;
            return false;
        L11:
            PhraseSoundModel other = (PhraseSoundModel) otherObject;
            if (HidlSupport.deepEquals(this.common, other.common) == true) goto L15;
            return false;
        L15:
            if (HidlSupport.deepEquals(this.phrases, other.phrases) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(HidlSupport.deepHashCode(this.common)), Integer.valueOf(HidlSupport.deepHashCode(this.phrases))});
        }

        public final String toString() {
            return "{.common = " + this.common + ", .phrases = " + this.phrases + "}";
        }

        public final void readFromParcel(HwParcel parcel) {
            HwBlob blob = parcel.readBuffer(72);
            readEmbeddedFromParcel(parcel, blob, 0);
        }

        public static final ArrayList<PhraseSoundModel> readVectorFromParcel(HwParcel parcel) {
            ArrayList<PhraseSoundModel> _hidl_vec = new ArrayList();
            HwBlob _hidl_blob = parcel.readBuffer(16);
            int _hidl_vec_size = _hidl_blob.getInt32(8);
            HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 72, _hidl_blob.handle(), 0, true);
            _hidl_vec.clear();
            int _hidl_index_0 = 0;
        L3:
            if (_hidl_index_0 >= _hidl_vec_size) goto L6;
            PhraseSoundModel _hidl_vec_element = new PhraseSoundModel();
            _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 72);
            _hidl_vec.add(_hidl_vec_element);
            _hidl_index_0 = _hidl_index_0 + 1;
            goto L3
        L6:
            return _hidl_vec;
        }

        public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
            this.common.readEmbeddedFromParcel(parcel, _hidl_blob, _hidl_offset + 0);
            int _hidl_vec_size = _hidl_blob.getInt32((_hidl_offset + 56) + 8);
            HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 56, _hidl_blob.handle(), (56 + _hidl_offset) + 0, true);
            this.phrases.clear();
            int _hidl_index_0 = 0;
        L3:
            if (_hidl_index_0 >= _hidl_vec_size) goto L6;
            Phrase _hidl_vec_element = new Phrase();
            _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 56);
            this.phrases.add(_hidl_vec_element);
            _hidl_index_0 = _hidl_index_0 + 1;
            goto L3
        }

        public final void writeToParcel(HwParcel parcel) {
            HwBlob _hidl_blob = new HwBlob(72);
            writeEmbeddedToBlob(_hidl_blob, 0);
            parcel.writeBuffer(_hidl_blob);
        }

        public static final void writeVectorToParcel(HwParcel parcel, ArrayList<PhraseSoundModel> _hidl_vec) {
            HwBlob _hidl_blob = new HwBlob(16);
            int _hidl_vec_size = _hidl_vec.size();
            _hidl_blob.putInt32(8, _hidl_vec_size);
            _hidl_blob.putBool(12, false);
            HwBlob childBlob = new HwBlob(_hidl_vec_size * 72);
            int _hidl_index_0 = 0;
        L3:
            if (_hidl_index_0 >= _hidl_vec_size) goto L5;
            _hidl_vec.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 72);
            _hidl_index_0 = _hidl_index_0 + 1;
            goto L3
        L5:
            _hidl_blob.putBlob(0, childBlob);
            parcel.writeBuffer(_hidl_blob);
        }

        public final void writeEmbeddedToBlob(HwBlob _hidl_blob, long _hidl_offset) {
            this.common.writeEmbeddedToBlob(_hidl_blob, _hidl_offset + 0);
            int _hidl_vec_size = this.phrases.size();
            _hidl_blob.putInt32((_hidl_offset + 56) + 8, _hidl_vec_size);
            _hidl_blob.putBool((_hidl_offset + 56) + 12, false);
            HwBlob childBlob = new HwBlob(_hidl_vec_size * 56);
            int _hidl_index_0 = 0;
        L3:
            if (_hidl_index_0 >= _hidl_vec_size) goto L5;
            this.phrases.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 56);
            _hidl_index_0 = _hidl_index_0 + 1;
            goto L3
        L5:
            _hidl_blob.putBlob((56 + _hidl_offset) + 0, childBlob);
        }
    }

    public static final class Properties {
        public boolean captureTransition;
        public boolean concurrentCapture;
        public String description;
        public String implementor;
        public int maxBufferMs;
        public int maxKeyPhrases;
        public int maxSoundModels;
        public int maxUsers;
        public int powerConsumptionMw;
        public int recognitionModes;
        public boolean triggerInEvent;
        public Uuid uuid;
        public int version;

        public Properties() {
            this.implementor = new String();
            this.description = new String();
            this.version = 0;
            this.uuid = new Uuid();
            this.maxSoundModels = 0;
            this.maxKeyPhrases = 0;
            this.maxUsers = 0;
            this.recognitionModes = 0;
            this.captureTransition = false;
            this.maxBufferMs = 0;
            this.concurrentCapture = false;
            this.triggerInEvent = false;
            this.powerConsumptionMw = 0;
        }

        public final boolean equals(Object otherObject) {
            if (this != otherObject) goto L6;
            return true;
        L6:
            if (otherObject != null) goto L9;
            return false;
        L9:
            if (otherObject.getClass() == Properties.class) goto L11;
            return false;
        L11:
            Properties other = (Properties) otherObject;
            if (HidlSupport.deepEquals(this.implementor, other.implementor) == true) goto L15;
            return false;
        L15:
            if (HidlSupport.deepEquals(this.description, other.description) == true) goto L18;
            return false;
        L18:
            if (this.version == other.version) goto L21;
            return false;
        L21:
            if (HidlSupport.deepEquals(this.uuid, other.uuid) == true) goto L24;
            return false;
        L24:
            if (this.maxSoundModels == other.maxSoundModels) goto L27;
            return false;
        L27:
            if (this.maxKeyPhrases == other.maxKeyPhrases) goto L30;
            return false;
        L30:
            if (this.maxUsers == other.maxUsers) goto L33;
            return false;
        L33:
            if (this.recognitionModes == other.recognitionModes) goto L36;
            return false;
        L36:
            if (this.captureTransition == other.captureTransition) goto L39;
            return false;
        L39:
            if (this.maxBufferMs == other.maxBufferMs) goto L42;
            return false;
        L42:
            if (this.concurrentCapture == other.concurrentCapture) goto L45;
            return false;
        L45:
            if (this.triggerInEvent == other.triggerInEvent) goto L48;
            return false;
        L48:
            if (this.powerConsumptionMw == other.powerConsumptionMw) goto L50;
            return false;
        L50:
            return true;
        }

        public final int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(HidlSupport.deepHashCode(this.implementor)), Integer.valueOf(HidlSupport.deepHashCode(this.description)), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.version))), Integer.valueOf(HidlSupport.deepHashCode(this.uuid)), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.maxSoundModels))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.maxKeyPhrases))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.maxUsers))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.recognitionModes))), Integer.valueOf(HidlSupport.deepHashCode(Boolean.valueOf(this.captureTransition))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.maxBufferMs))), Integer.valueOf(HidlSupport.deepHashCode(Boolean.valueOf(this.concurrentCapture))), Integer.valueOf(HidlSupport.deepHashCode(Boolean.valueOf(this.triggerInEvent))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.powerConsumptionMw)))});
        }

        public final String toString() {
            return "{.implementor = " + this.implementor + ", .description = " + this.description + ", .version = " + this.version + ", .uuid = " + this.uuid + ", .maxSoundModels = " + this.maxSoundModels + ", .maxKeyPhrases = " + this.maxKeyPhrases + ", .maxUsers = " + this.maxUsers + ", .recognitionModes = " + this.recognitionModes + ", .captureTransition = " + this.captureTransition + ", .maxBufferMs = " + this.maxBufferMs + ", .concurrentCapture = " + this.concurrentCapture + ", .triggerInEvent = " + this.triggerInEvent + ", .powerConsumptionMw = " + this.powerConsumptionMw + "}";
        }

        public final void readFromParcel(HwParcel parcel) {
            HwBlob blob = parcel.readBuffer(88);
            readEmbeddedFromParcel(parcel, blob, 0);
        }

        public static final ArrayList<Properties> readVectorFromParcel(HwParcel parcel) {
            ArrayList<Properties> _hidl_vec = new ArrayList();
            HwBlob _hidl_blob = parcel.readBuffer(16);
            int _hidl_vec_size = _hidl_blob.getInt32(8);
            HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 88, _hidl_blob.handle(), 0, true);
            _hidl_vec.clear();
            int _hidl_index_0 = 0;
        L3:
            if (_hidl_index_0 >= _hidl_vec_size) goto L6;
            Properties _hidl_vec_element = new Properties();
            _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 88);
            _hidl_vec.add(_hidl_vec_element);
            _hidl_index_0 = _hidl_index_0 + 1;
            goto L3
        L6:
            return _hidl_vec;
        }

        public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
            this.implementor = _hidl_blob.getString(_hidl_offset + 0);
            parcel.readEmbeddedBuffer(this.implementor.getBytes().length + 1, _hidl_blob.handle(), (_hidl_offset + 0) + 0, false);
            this.description = _hidl_blob.getString(_hidl_offset + 16);
            parcel.readEmbeddedBuffer(this.description.getBytes().length + 1, _hidl_blob.handle(), (_hidl_offset + 16) + 0, false);
            this.version = _hidl_blob.getInt32(_hidl_offset + 32);
            this.uuid.readEmbeddedFromParcel(parcel, _hidl_blob, _hidl_offset + 36);
            this.maxSoundModels = _hidl_blob.getInt32(_hidl_offset + 52);
            this.maxKeyPhrases = _hidl_blob.getInt32(_hidl_offset + 56);
            this.maxUsers = _hidl_blob.getInt32(_hidl_offset + 60);
            this.recognitionModes = _hidl_blob.getInt32(_hidl_offset + 64);
            this.captureTransition = _hidl_blob.getBool(_hidl_offset + 68);
            this.maxBufferMs = _hidl_blob.getInt32(_hidl_offset + 72);
            this.concurrentCapture = _hidl_blob.getBool(_hidl_offset + 76);
            this.triggerInEvent = _hidl_blob.getBool(_hidl_offset + 77);
            this.powerConsumptionMw = _hidl_blob.getInt32(_hidl_offset + 80);
        }

        public final void writeToParcel(HwParcel parcel) {
            HwBlob _hidl_blob = new HwBlob(88);
            writeEmbeddedToBlob(_hidl_blob, 0);
            parcel.writeBuffer(_hidl_blob);
        }

        public static final void writeVectorToParcel(HwParcel parcel, ArrayList<Properties> _hidl_vec) {
            HwBlob _hidl_blob = new HwBlob(16);
            int _hidl_vec_size = _hidl_vec.size();
            _hidl_blob.putInt32(8, _hidl_vec_size);
            _hidl_blob.putBool(12, false);
            HwBlob childBlob = new HwBlob(_hidl_vec_size * 88);
            int _hidl_index_0 = 0;
        L3:
            if (_hidl_index_0 >= _hidl_vec_size) goto L5;
            _hidl_vec.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 88);
            _hidl_index_0 = _hidl_index_0 + 1;
            goto L3
        L5:
            _hidl_blob.putBlob(0, childBlob);
            parcel.writeBuffer(_hidl_blob);
        }

        public final void writeEmbeddedToBlob(HwBlob _hidl_blob, long _hidl_offset) {
            _hidl_blob.putString(0 + _hidl_offset, this.implementor);
            _hidl_blob.putString(16 + _hidl_offset, this.description);
            _hidl_blob.putInt32(32 + _hidl_offset, this.version);
            this.uuid.writeEmbeddedToBlob(_hidl_blob, 36 + _hidl_offset);
            _hidl_blob.putInt32(52 + _hidl_offset, this.maxSoundModels);
            _hidl_blob.putInt32(56 + _hidl_offset, this.maxKeyPhrases);
            _hidl_blob.putInt32(60 + _hidl_offset, this.maxUsers);
            _hidl_blob.putInt32(64 + _hidl_offset, this.recognitionModes);
            _hidl_blob.putBool(68 + _hidl_offset, this.captureTransition);
            _hidl_blob.putInt32(72 + _hidl_offset, this.maxBufferMs);
            _hidl_blob.putBool(76 + _hidl_offset, this.concurrentCapture);
            _hidl_blob.putBool(77 + _hidl_offset, this.triggerInEvent);
            _hidl_blob.putInt32(80 + _hidl_offset, this.powerConsumptionMw);
        }
    }

    public static final class Proxy implements ISoundTriggerHw {
        private IHwBinder mRemote;

        public Proxy(IHwBinder remote) {
            remote.getClass();
            this.mRemote = remote;
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
        public IHwBinder asBinder() {
            return this.mRemote;
        }

        public String toString() {
            return interfaceDescriptor() + "@Proxy";
        L5:
            return "[class or subclass of android.hardware.soundtrigger@2.0::ISoundTriggerHw]@Proxy";
        }

        public final boolean equals(Object other) {
            return HidlSupport.interfacesEqual(this, other);
        }

        public final int hashCode() {
            return asBinder().hashCode();
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHw
        public void getProperties(getPropertiesCallback _hidl_cb) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(ISoundTriggerHw.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(1, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            int _hidl_out_retval = _hidl_reply.readInt32();     // Catch: Throwable -> L6
            Properties _hidl_out_properties = new Properties();     // Catch: Throwable -> L6
            _hidl_out_properties.readFromParcel(_hidl_reply);     // Catch: Throwable -> L6
            _hidl_cb.onValues(_hidl_out_retval, _hidl_out_properties);     // Catch: Throwable -> L6
            _hidl_reply.release();
            return;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHw
        public void loadSoundModel(SoundModel soundModel, ISoundTriggerHwCallback callback, int cookie, loadSoundModelCallback _hidl_cb) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(ISoundTriggerHw.kInterfaceName);
            soundModel.writeToParcel(_hidl_request);
            if (callback != null) goto L5;
            IHwBinder r1 = null;
        L6:
            _hidl_request.writeStrongBinder(r1);
            _hidl_request.writeInt32(cookie);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(2, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L10
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L10
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L10
            int _hidl_out_retval = _hidl_reply.readInt32();     // Catch: Throwable -> L10
            int _hidl_out_modelHandle = _hidl_reply.readInt32();     // Catch: Throwable -> L10
            _hidl_cb.onValues(_hidl_out_retval, _hidl_out_modelHandle);     // Catch: Throwable -> L10
            _hidl_reply.release();
            return;
        L10:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        L5:
            r1 = callback.asBinder();
            goto L6
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHw
        public void loadPhraseSoundModel(PhraseSoundModel soundModel, ISoundTriggerHwCallback callback, int cookie, loadPhraseSoundModelCallback _hidl_cb) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(ISoundTriggerHw.kInterfaceName);
            soundModel.writeToParcel(_hidl_request);
            if (callback != null) goto L5;
            IHwBinder r1 = null;
        L6:
            _hidl_request.writeStrongBinder(r1);
            _hidl_request.writeInt32(cookie);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(3, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L10
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L10
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L10
            int _hidl_out_retval = _hidl_reply.readInt32();     // Catch: Throwable -> L10
            int _hidl_out_modelHandle = _hidl_reply.readInt32();     // Catch: Throwable -> L10
            _hidl_cb.onValues(_hidl_out_retval, _hidl_out_modelHandle);     // Catch: Throwable -> L10
            _hidl_reply.release();
            return;
        L10:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        L5:
            r1 = callback.asBinder();
            goto L6
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHw
        public int unloadSoundModel(int modelHandle) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(ISoundTriggerHw.kInterfaceName);
            _hidl_request.writeInt32(modelHandle);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(4, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            int _hidl_out_retval = _hidl_reply.readInt32();     // Catch: Throwable -> L6
            _hidl_reply.release();
            return _hidl_out_retval;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHw
        public int startRecognition(int modelHandle, RecognitionConfig config, ISoundTriggerHwCallback callback, int cookie) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(ISoundTriggerHw.kInterfaceName);
            _hidl_request.writeInt32(modelHandle);
            config.writeToParcel(_hidl_request);
            if (callback != null) goto L5;
            IHwBinder r1 = null;
        L6:
            _hidl_request.writeStrongBinder(r1);
            _hidl_request.writeInt32(cookie);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(5, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L10
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L10
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L10
            int _hidl_out_retval = _hidl_reply.readInt32();     // Catch: Throwable -> L10
            _hidl_reply.release();
            return _hidl_out_retval;
        L10:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        L5:
            r1 = callback.asBinder();
            goto L6
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHw
        public int stopRecognition(int modelHandle) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(ISoundTriggerHw.kInterfaceName);
            _hidl_request.writeInt32(modelHandle);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(6, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            int _hidl_out_retval = _hidl_reply.readInt32();     // Catch: Throwable -> L6
            _hidl_reply.release();
            return _hidl_out_retval;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHw
        public int stopAllRecognitions() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(ISoundTriggerHw.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(7, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            int _hidl_out_retval = _hidl_reply.readInt32();     // Catch: Throwable -> L6
            _hidl_reply.release();
            return _hidl_out_retval;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
        public ArrayList<String> interfaceChain() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IBase.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(256067662, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            ArrayList<String> _hidl_out_descriptors = _hidl_reply.readStringVector();     // Catch: Throwable -> L6
            _hidl_reply.release();
            return _hidl_out_descriptors;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
        public void debug(NativeHandle fd, ArrayList<String> options) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IBase.kInterfaceName);
            _hidl_request.writeNativeHandle(fd);
            _hidl_request.writeStringVector(options);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(256131655, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            _hidl_reply.release();
            return;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
        public String interfaceDescriptor() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IBase.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(256136003, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            String _hidl_out_descriptor = _hidl_reply.readString();     // Catch: Throwable -> L6
            _hidl_reply.release();
            return _hidl_out_descriptor;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
        public ArrayList<byte[]> getHashChain() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IBase.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(256398152, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L7
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L7
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L7
            ArrayList<byte[]> _hidl_out_hashchain = new ArrayList();     // Catch: Throwable -> L7
            HwBlob _hidl_blob = _hidl_reply.readBuffer(16);     // Catch: Throwable -> L7
            int _hidl_vec_size = _hidl_blob.getInt32(8);     // Catch: Throwable -> L7
            HwBlob childBlob = _hidl_reply.readEmbeddedBuffer(_hidl_vec_size * 32, _hidl_blob.handle(), 0, true);     // Catch: Throwable -> L7
            _hidl_out_hashchain.clear();     // Catch: Throwable -> L7
            int _hidl_index_0 = 0;
        L4:
            if (_hidl_index_0 >= _hidl_vec_size) goto L9;
            byte[] _hidl_vec_element = new byte[32];     // Catch: Throwable -> L7
            long _hidl_array_offset_1 = _hidl_index_0 * 32;     // Catch: Throwable -> L7
            childBlob.copyToInt8Array(_hidl_array_offset_1, _hidl_vec_element, 32);     // Catch: Throwable -> L7
            _hidl_out_hashchain.add(_hidl_vec_element);     // Catch: Throwable -> L7
            _hidl_index_0 = _hidl_index_0 + 1;
            goto L4
        L9:
            _hidl_reply.release();
            return _hidl_out_hashchain;
        L7:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
        public void setHALInstrumentation() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IBase.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(256462420, _hidl_request, _hidl_reply, 1);     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            _hidl_reply.release();
            return;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
        public boolean linkToDeath(IHwBinder.DeathRecipient recipient, long cookie) throws RemoteException {
            return this.mRemote.linkToDeath(recipient, cookie);
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
        public void ping() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IBase.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(256921159, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            _hidl_reply.release();
            return;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
        public DebugInfo getDebugInfo() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IBase.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(257049926, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            DebugInfo _hidl_out_info = new DebugInfo();     // Catch: Throwable -> L6
            _hidl_out_info.readFromParcel(_hidl_reply);     // Catch: Throwable -> L6
            _hidl_reply.release();
            return _hidl_out_info;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
        public void notifySyspropsChanged() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IBase.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(257120595, _hidl_request, _hidl_reply, 1);     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            _hidl_reply.release();
            return;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
        public boolean unlinkToDeath(IHwBinder.DeathRecipient recipient) throws RemoteException {
            return this.mRemote.unlinkToDeath(recipient);
        }
    }

    public static final class RecognitionConfig {
        public int captureDevice;
        public int captureHandle;
        public boolean captureRequested;
        public ArrayList<Byte> data;
        public ArrayList<PhraseRecognitionExtra> phrases;

        public RecognitionConfig() {
            this.captureHandle = 0;
            this.captureDevice = 0;
            this.captureRequested = false;
            this.phrases = new ArrayList();
            this.data = new ArrayList();
        }

        public final boolean equals(Object otherObject) {
            if (this != otherObject) goto L6;
            return true;
        L6:
            if (otherObject != null) goto L9;
            return false;
        L9:
            if (otherObject.getClass() == RecognitionConfig.class) goto L11;
            return false;
        L11:
            RecognitionConfig other = (RecognitionConfig) otherObject;
            if (this.captureHandle == other.captureHandle) goto L15;
            return false;
        L15:
            if (this.captureDevice == other.captureDevice) goto L18;
            return false;
        L18:
            if (this.captureRequested == other.captureRequested) goto L21;
            return false;
        L21:
            if (HidlSupport.deepEquals(this.phrases, other.phrases) == true) goto L24;
            return false;
        L24:
            if (HidlSupport.deepEquals(this.data, other.data) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.captureHandle))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.captureDevice))), Integer.valueOf(HidlSupport.deepHashCode(Boolean.valueOf(this.captureRequested))), Integer.valueOf(HidlSupport.deepHashCode(this.phrases)), Integer.valueOf(HidlSupport.deepHashCode(this.data))});
        }

        public final String toString() {
            return "{.captureHandle = " + this.captureHandle + ", .captureDevice = " + AudioDevice.toString(this.captureDevice) + ", .captureRequested = " + this.captureRequested + ", .phrases = " + this.phrases + ", .data = " + this.data + "}";
        }

        public final void readFromParcel(HwParcel parcel) {
            HwBlob blob = parcel.readBuffer(48);
            readEmbeddedFromParcel(parcel, blob, 0);
        }

        public static final ArrayList<RecognitionConfig> readVectorFromParcel(HwParcel parcel) {
            ArrayList<RecognitionConfig> _hidl_vec = new ArrayList();
            HwBlob _hidl_blob = parcel.readBuffer(16);
            int _hidl_vec_size = _hidl_blob.getInt32(8);
            HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 48, _hidl_blob.handle(), 0, true);
            _hidl_vec.clear();
            int _hidl_index_0 = 0;
        L3:
            if (_hidl_index_0 >= _hidl_vec_size) goto L6;
            RecognitionConfig _hidl_vec_element = new RecognitionConfig();
            _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 48);
            _hidl_vec.add(_hidl_vec_element);
            _hidl_index_0 = _hidl_index_0 + 1;
            goto L3
        L6:
            return _hidl_vec;
        }

        public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
            this.captureHandle = _hidl_blob.getInt32(_hidl_offset + 0);
            this.captureDevice = _hidl_blob.getInt32(_hidl_offset + 4);
            this.captureRequested = _hidl_blob.getBool(_hidl_offset + 8);
            int _hidl_vec_size = _hidl_blob.getInt32((_hidl_offset + 16) + 8);
            HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 32, _hidl_blob.handle(), (_hidl_offset + 16) + 0, true);
            this.phrases.clear();
            int _hidl_index_0 = 0;
        L3:
            if (_hidl_index_0 >= _hidl_vec_size) goto L5;
            PhraseRecognitionExtra _hidl_vec_element = new PhraseRecognitionExtra();
            _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 32);
            this.phrases.add(_hidl_vec_element);
            _hidl_index_0 = _hidl_index_0 + 1;
            goto L3
        L5:
            int _hidl_vec_size2 = _hidl_blob.getInt32((_hidl_offset + 32) + 8);
            HwBlob childBlob2 = parcel.readEmbeddedBuffer(_hidl_vec_size2 * 1, _hidl_blob.handle(), (_hidl_offset + 32) + 0, true);
            this.data.clear();
            int _hidl_index_1 = 0;
        L6:
            if (_hidl_index_1 >= _hidl_vec_size2) goto L9;
            this.data.add(Byte.valueOf(childBlob2.getInt8(_hidl_index_1 * 1)));
            _hidl_index_1 = _hidl_index_1 + 1;
            goto L6
        }

        public final void writeToParcel(HwParcel parcel) {
            HwBlob _hidl_blob = new HwBlob(48);
            writeEmbeddedToBlob(_hidl_blob, 0);
            parcel.writeBuffer(_hidl_blob);
        }

        public static final void writeVectorToParcel(HwParcel parcel, ArrayList<RecognitionConfig> _hidl_vec) {
            HwBlob _hidl_blob = new HwBlob(16);
            int _hidl_vec_size = _hidl_vec.size();
            _hidl_blob.putInt32(8, _hidl_vec_size);
            _hidl_blob.putBool(12, false);
            HwBlob childBlob = new HwBlob(_hidl_vec_size * 48);
            int _hidl_index_0 = 0;
        L3:
            if (_hidl_index_0 >= _hidl_vec_size) goto L5;
            _hidl_vec.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 48);
            _hidl_index_0 = _hidl_index_0 + 1;
            goto L3
        L5:
            _hidl_blob.putBlob(0, childBlob);
            parcel.writeBuffer(_hidl_blob);
        }

        public final void writeEmbeddedToBlob(HwBlob _hidl_blob, long _hidl_offset) {
            long r2 = 0;
            _hidl_blob.putInt32(_hidl_offset + 0, this.captureHandle);
            _hidl_blob.putInt32(_hidl_offset + 4, this.captureDevice);
            _hidl_blob.putBool(_hidl_offset + 8, this.captureRequested);
            int _hidl_vec_size = this.phrases.size();
            _hidl_blob.putInt32((_hidl_offset + 16) + 8, _hidl_vec_size);
            _hidl_blob.putBool((_hidl_offset + 16) + 12, false);
            HwBlob childBlob = new HwBlob(_hidl_vec_size * 32);
            int _hidl_index_0 = 0;
        L3:
            if (_hidl_index_0 >= _hidl_vec_size) goto L5;
            this.phrases.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 32);
            _hidl_index_0 = _hidl_index_0 + 1;
            r2 = r2;
            goto L3
        L5:
            long r16 = r2;
            _hidl_blob.putBlob((_hidl_offset + 16) + r16, childBlob);
            int _hidl_vec_size2 = this.data.size();
            _hidl_blob.putInt32((_hidl_offset + 32) + 8, _hidl_vec_size2);
            _hidl_blob.putBool((_hidl_offset + 32) + 12, false);
            HwBlob childBlob2 = new HwBlob(_hidl_vec_size2 * 1);
            int _hidl_index_1 = 0;
        L6:
            if (_hidl_index_1 >= _hidl_vec_size2) goto L8;
            childBlob2.putInt8(_hidl_index_1 * 1, this.data.get(_hidl_index_1).byteValue());
            _hidl_index_1 = _hidl_index_1 + 1;
            goto L6
        L8:
            _hidl_blob.putBlob((_hidl_offset + 32) + r16, childBlob2);
        }
    }

    public static final class SoundModel {
        public ArrayList<Byte> data;
        public int type;
        public Uuid uuid;
        public Uuid vendorUuid;

        public SoundModel() {
            this.type = 0;
            this.uuid = new Uuid();
            this.vendorUuid = new Uuid();
            this.data = new ArrayList();
        }

        public final boolean equals(Object otherObject) {
            if (this != otherObject) goto L6;
            return true;
        L6:
            if (otherObject != null) goto L9;
            return false;
        L9:
            if (otherObject.getClass() == SoundModel.class) goto L11;
            return false;
        L11:
            SoundModel other = (SoundModel) otherObject;
            if (this.type == other.type) goto L15;
            return false;
        L15:
            if (HidlSupport.deepEquals(this.uuid, other.uuid) == true) goto L18;
            return false;
        L18:
            if (HidlSupport.deepEquals(this.vendorUuid, other.vendorUuid) == true) goto L21;
            return false;
        L21:
            if (HidlSupport.deepEquals(this.data, other.data) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.type))), Integer.valueOf(HidlSupport.deepHashCode(this.uuid)), Integer.valueOf(HidlSupport.deepHashCode(this.vendorUuid)), Integer.valueOf(HidlSupport.deepHashCode(this.data))});
        }

        public final String toString() {
            return "{.type = " + SoundModelType.toString(this.type) + ", .uuid = " + this.uuid + ", .vendorUuid = " + this.vendorUuid + ", .data = " + this.data + "}";
        }

        public final void readFromParcel(HwParcel parcel) {
            HwBlob blob = parcel.readBuffer(56);
            readEmbeddedFromParcel(parcel, blob, 0);
        }

        public static final ArrayList<SoundModel> readVectorFromParcel(HwParcel parcel) {
            ArrayList<SoundModel> _hidl_vec = new ArrayList();
            HwBlob _hidl_blob = parcel.readBuffer(16);
            int _hidl_vec_size = _hidl_blob.getInt32(8);
            HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 56, _hidl_blob.handle(), 0, true);
            _hidl_vec.clear();
            int _hidl_index_0 = 0;
        L3:
            if (_hidl_index_0 >= _hidl_vec_size) goto L6;
            SoundModel _hidl_vec_element = new SoundModel();
            _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 56);
            _hidl_vec.add(_hidl_vec_element);
            _hidl_index_0 = _hidl_index_0 + 1;
            goto L3
        L6:
            return _hidl_vec;
        }

        public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
            this.type = _hidl_blob.getInt32(_hidl_offset + 0);
            this.uuid.readEmbeddedFromParcel(parcel, _hidl_blob, 4 + _hidl_offset);
            this.vendorUuid.readEmbeddedFromParcel(parcel, _hidl_blob, 20 + _hidl_offset);
            int _hidl_vec_size = _hidl_blob.getInt32((_hidl_offset + 40) + 8);
            HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 1, _hidl_blob.handle(), (40 + _hidl_offset) + 0, true);
            this.data.clear();
            int _hidl_index_0 = 0;
        L3:
            if (_hidl_index_0 >= _hidl_vec_size) goto L6;
            byte _hidl_vec_element = childBlob.getInt8(_hidl_index_0 * 1);
            this.data.add(Byte.valueOf(_hidl_vec_element));
            _hidl_index_0 = _hidl_index_0 + 1;
            goto L3
        }

        public final void writeToParcel(HwParcel parcel) {
            HwBlob _hidl_blob = new HwBlob(56);
            writeEmbeddedToBlob(_hidl_blob, 0);
            parcel.writeBuffer(_hidl_blob);
        }

        public static final void writeVectorToParcel(HwParcel parcel, ArrayList<SoundModel> _hidl_vec) {
            HwBlob _hidl_blob = new HwBlob(16);
            int _hidl_vec_size = _hidl_vec.size();
            _hidl_blob.putInt32(8, _hidl_vec_size);
            _hidl_blob.putBool(12, false);
            HwBlob childBlob = new HwBlob(_hidl_vec_size * 56);
            int _hidl_index_0 = 0;
        L3:
            if (_hidl_index_0 >= _hidl_vec_size) goto L5;
            _hidl_vec.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 56);
            _hidl_index_0 = _hidl_index_0 + 1;
            goto L3
        L5:
            _hidl_blob.putBlob(0, childBlob);
            parcel.writeBuffer(_hidl_blob);
        }

        public final void writeEmbeddedToBlob(HwBlob _hidl_blob, long _hidl_offset) {
            _hidl_blob.putInt32(_hidl_offset + 0, this.type);
            this.uuid.writeEmbeddedToBlob(_hidl_blob, 4 + _hidl_offset);
            this.vendorUuid.writeEmbeddedToBlob(_hidl_blob, 20 + _hidl_offset);
            int _hidl_vec_size = this.data.size();
            _hidl_blob.putInt32((_hidl_offset + 40) + 8, _hidl_vec_size);
            _hidl_blob.putBool((_hidl_offset + 40) + 12, false);
            HwBlob childBlob = new HwBlob(_hidl_vec_size * 1);
            int _hidl_index_0 = 0;
        L3:
            if (_hidl_index_0 >= _hidl_vec_size) goto L5;
            childBlob.putInt8(_hidl_index_0 * 1, this.data.get(_hidl_index_0).byteValue());
            _hidl_index_0 = _hidl_index_0 + 1;
            goto L3
        L5:
            _hidl_blob.putBlob((40 + _hidl_offset) + 0, childBlob);
        }
    }

    public static abstract class Stub extends HwBinder implements ISoundTriggerHw {
        public Stub() {
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
        public IHwBinder asBinder() {
            return this;
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
        public final ArrayList<String> interfaceChain() {
            return new ArrayList(Arrays.asList(new String[]{ISoundTriggerHw.kInterfaceName, IBase.kInterfaceName}));
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
        public void debug(NativeHandle fd, ArrayList<String> options) {
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
        public final String interfaceDescriptor() {
            return ISoundTriggerHw.kInterfaceName;
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
        public final ArrayList<byte[]> getHashChain() {
            return new ArrayList(Arrays.asList(new byte[][]{new byte[]{ParameterName.DOLBY_DIALOGUE_ENHANCER, -17, -64, ParameterName.AUTO_PICTUREQUALITY_ENABLED, -53, -23, ParameterName.COLOR_TUNER_LUMINANCE_GREEN, 83, 102, ParameterName.LOW_LATENCY, ParameterName.ELEVEN_POINT_GREEN, -37, -107, -29, -49, 100, -11, -27, 101, -62, -108, 3, -31, -62, -38, -20, -62, -66, ParameterName.COLOR_TUNER_SATURATION_CYAN, -32, -91, ParameterName.DTS_VIRTUAL_X}, new byte[]{-20, 127, -41, -98, -48, ParameterName.ELEVEN_POINT_BLUE, -6, -123, -68, ParameterName.COLOR_TUNER_LUMINANCE_GREEN, -108, ParameterName.COLOR_TEMPERATURE_GREEN_GAIN, -83, -82, ParameterName.COLOR_TUNER_HUE_MAGENTA, -66, 35, -17, 5, 36, -13, -51, 105, ParameterName.AUTO_VOLUME_CONTROL, ParameterName.FILM_MODE, -109, 36, -72, ParameterName.COLOR_TUNER_HUE_GREEN, ParameterName.GLOBE_DIMMING, -54, 76}}));
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
        public final void setHALInstrumentation() {
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
        public final boolean linkToDeath(IHwBinder.DeathRecipient recipient, long cookie) {
            return true;
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
        public final void ping() {
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
        public final DebugInfo getDebugInfo() {
            DebugInfo info = new DebugInfo();
            info.pid = HidlSupport.getPidIfSharable();
            info.ptr = 0;
            info.arch = 0;
            return info;
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
        public final void notifySyspropsChanged() {
            HwBinder.enableInstrumentation();
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
        public final boolean unlinkToDeath(IHwBinder.DeathRecipient recipient) {
            return true;
        }

        public IHwInterface queryLocalInterface(String descriptor) {
            if (ISoundTriggerHw.kInterfaceName.equals(descriptor) == false) goto L5;
            return this;
        L5:
            return null;
        }

        public void registerAsService(String serviceName) throws RemoteException {
            registerService(serviceName);
        }

        public String toString() {
            return interfaceDescriptor() + "@Stub";
        }

        public void onTransact(int _hidl_code, HwParcel _hidl_request, final HwParcel _hidl_reply, int _hidl_flags) throws RemoteException {
            switch(_hidl_code) {
                case 1: goto L29;
                case 2: goto L28;
                case 3: goto L27;
                case 4: goto L26;
                case 5: goto L25;
                case 6: goto L24;
                case 7: goto L23;
                case 256067662: goto L22;
                case 256131655: goto L21;
                case 256136003: goto L20;
                case 256398152: goto L10;
                case 256462420: goto L9;
                case 256660548: goto L48;
                case 256921159: goto L7;
                case 257049926: goto L6;
                case 257120595: goto L5;
                default: goto L48;
            };
        L5:
            _hidl_request.enforceInterface(IBase.kInterfaceName);
            notifySyspropsChanged();
            return;
        L6:
            _hidl_request.enforceInterface(IBase.kInterfaceName);
            DebugInfo _hidl_out_info = getDebugInfo();
            _hidl_reply.writeStatus(0);
            _hidl_out_info.writeToParcel(_hidl_reply);
            _hidl_reply.send();
            return;
        L7:
            _hidl_request.enforceInterface(IBase.kInterfaceName);
            ping();
            _hidl_reply.writeStatus(0);
            _hidl_reply.send();
            return;
        L9:
            _hidl_request.enforceInterface(IBase.kInterfaceName);
            setHALInstrumentation();
            return;
        L10:
            _hidl_request.enforceInterface(IBase.kInterfaceName);
            ArrayList<byte[]> _hidl_out_hashchain = getHashChain();
            _hidl_reply.writeStatus(0);
            HwBlob _hidl_blob = new HwBlob(16);
            int _hidl_vec_size = _hidl_out_hashchain.size();
            _hidl_blob.putInt32(8, _hidl_vec_size);
            _hidl_blob.putBool(12, false);
            HwBlob childBlob = new HwBlob(_hidl_vec_size * 32);
            int _hidl_index_0 = 0;
        L11:
            if (_hidl_index_0 >= _hidl_vec_size) goto L19;
            long _hidl_array_offset_1 = _hidl_index_0 * 32;
            byte[] _hidl_array_item_1 = _hidl_out_hashchain.get(_hidl_index_0);
            if (_hidl_array_item_1 == null) goto L18;
            if (_hidl_array_item_1.length != 32) goto L18;
            childBlob.putInt8Array(_hidl_array_offset_1, _hidl_array_item_1);
            _hidl_index_0 = _hidl_index_0 + 1;
        L18:
            throw new IllegalArgumentException("Array element is not of the expected length");
        L19:
            _hidl_blob.putBlob(0, childBlob);
            _hidl_reply.writeBuffer(_hidl_blob);
            _hidl_reply.send();
            return;
        L20:
            _hidl_request.enforceInterface(IBase.kInterfaceName);
            String _hidl_out_descriptor = interfaceDescriptor();
            _hidl_reply.writeStatus(0);
            _hidl_reply.writeString(_hidl_out_descriptor);
            _hidl_reply.send();
            return;
        L21:
            _hidl_request.enforceInterface(IBase.kInterfaceName);
            NativeHandle fd = _hidl_request.readNativeHandle();
            ArrayList<String> options = _hidl_request.readStringVector();
            debug(fd, options);
            _hidl_reply.writeStatus(0);
            _hidl_reply.send();
            return;
        L22:
            _hidl_request.enforceInterface(IBase.kInterfaceName);
            ArrayList<String> _hidl_out_descriptors = interfaceChain();
            _hidl_reply.writeStatus(0);
            _hidl_reply.writeStringVector(_hidl_out_descriptors);
            _hidl_reply.send();
            return;
        L23:
            _hidl_request.enforceInterface(ISoundTriggerHw.kInterfaceName);
            int _hidl_out_retval = stopAllRecognitions();
            _hidl_reply.writeStatus(0);
            _hidl_reply.writeInt32(_hidl_out_retval);
            _hidl_reply.send();
            return;
        L24:
            _hidl_request.enforceInterface(ISoundTriggerHw.kInterfaceName);
            int modelHandle = _hidl_request.readInt32();
            int _hidl_out_retval2 = stopRecognition(modelHandle);
            _hidl_reply.writeStatus(0);
            _hidl_reply.writeInt32(_hidl_out_retval2);
            _hidl_reply.send();
            return;
        L25:
            _hidl_request.enforceInterface(ISoundTriggerHw.kInterfaceName);
            int modelHandle2 = _hidl_request.readInt32();
            RecognitionConfig config = new RecognitionConfig();
            config.readFromParcel(_hidl_request);
            ISoundTriggerHwCallback callback = ISoundTriggerHwCallback.asInterface(_hidl_request.readStrongBinder());
            int cookie = _hidl_request.readInt32();
            int _hidl_out_retval3 = startRecognition(modelHandle2, config, callback, cookie);
            _hidl_reply.writeStatus(0);
            _hidl_reply.writeInt32(_hidl_out_retval3);
            _hidl_reply.send();
            return;
        L26:
            _hidl_request.enforceInterface(ISoundTriggerHw.kInterfaceName);
            int modelHandle3 = _hidl_request.readInt32();
            int _hidl_out_retval4 = unloadSoundModel(modelHandle3);
            _hidl_reply.writeStatus(0);
            _hidl_reply.writeInt32(_hidl_out_retval4);
            _hidl_reply.send();
            return;
        L27:
            _hidl_request.enforceInterface(ISoundTriggerHw.kInterfaceName);
            PhraseSoundModel soundModel = new PhraseSoundModel();
            soundModel.readFromParcel(_hidl_request);
            ISoundTriggerHwCallback callback2 = ISoundTriggerHwCallback.asInterface(_hidl_request.readStrongBinder());
            int cookie2 = _hidl_request.readInt32();
            loadPhraseSoundModel(soundModel, callback2, cookie2, new AnonymousClass3(this, _hidl_reply));
            return;
        L28:
            _hidl_request.enforceInterface(ISoundTriggerHw.kInterfaceName);
            SoundModel soundModel2 = new SoundModel();
            soundModel2.readFromParcel(_hidl_request);
            ISoundTriggerHwCallback callback3 = ISoundTriggerHwCallback.asInterface(_hidl_request.readStrongBinder());
            int cookie3 = _hidl_request.readInt32();
            loadSoundModel(soundModel2, callback3, cookie3, new AnonymousClass2(this, _hidl_reply));
            return;
        L29:
            _hidl_request.enforceInterface(ISoundTriggerHw.kInterfaceName);
            getProperties(new AnonymousClass1(this, _hidl_reply));
            return;
        }
    }

    @FunctionalInterface
    public interface getPropertiesCallback {
        void onValues(int r1, Properties r2);
    }

    @FunctionalInterface
    public interface loadPhraseSoundModelCallback {
        void onValues(int r1, int r2);
    }

    @FunctionalInterface
    public interface loadSoundModelCallback {
        void onValues(int r1, int r2);
    }

    @Override // android.hidl.base.V1_0.IBase
    IHwBinder asBinder();

    @Override // android.hidl.base.V1_0.IBase
    void debug(NativeHandle r1, ArrayList<String> r2) throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    DebugInfo getDebugInfo() throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    ArrayList<byte[]> getHashChain() throws RemoteException;

    void getProperties(getPropertiesCallback r1) throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    ArrayList<String> interfaceChain() throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    String interfaceDescriptor() throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    boolean linkToDeath(IHwBinder.DeathRecipient r1, long r2) throws RemoteException;

    void loadPhraseSoundModel(PhraseSoundModel r1, ISoundTriggerHwCallback r2, int r3, loadPhraseSoundModelCallback r4) throws RemoteException;

    void loadSoundModel(SoundModel r1, ISoundTriggerHwCallback r2, int r3, loadSoundModelCallback r4) throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    void notifySyspropsChanged() throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    void ping() throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    void setHALInstrumentation() throws RemoteException;

    int startRecognition(int r1, RecognitionConfig r2, ISoundTriggerHwCallback r3, int r4) throws RemoteException;

    int stopAllRecognitions() throws RemoteException;

    int stopRecognition(int r1) throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    boolean unlinkToDeath(IHwBinder.DeathRecipient r1) throws RemoteException;

    int unloadSoundModel(int r1) throws RemoteException;

    static ISoundTriggerHw asInterface(IHwBinder binder) {
        if (binder != null) goto L5;
        return null;
    L5:
        IHwInterface iface = binder.queryLocalInterface(kInterfaceName);
        if (iface != null) goto L8;
    L11:
        ISoundTriggerHw proxy = new Proxy(binder);
        Iterator<String> r4 = proxy.interfaceChain().iterator();     // Catch: RemoteException -> L19
    L14:
        if (r4.hasNext() == false) goto L22;
        String descriptor = r4.next();     // Catch: RemoteException -> L19
        if (descriptor.equals(kInterfaceName) == false) goto L14;
        return proxy;
    L22:
        return null;
    L8:
        if ((iface instanceof ISoundTriggerHw) == false) goto L11;
        return (ISoundTriggerHw) iface;
    }

    static ISoundTriggerHw castFrom(IHwInterface iface) {
        if (iface != null) goto L5;
        return null;
    L5:
        return asInterface(iface.asBinder());
    }

    static ISoundTriggerHw getService(String serviceName, boolean retry) throws RemoteException {
        return asInterface(HwBinder.getService(kInterfaceName, serviceName, retry));
    }

    static ISoundTriggerHw getService(boolean retry) throws RemoteException {
        return getService("default", retry);
    }

    @Deprecated
    static ISoundTriggerHw getService(String serviceName) throws RemoteException {
        return asInterface(HwBinder.getService(kInterfaceName, serviceName));
    }

    @Deprecated
    static ISoundTriggerHw getService() throws RemoteException {
        return getService("default");
    }
}
