package android.hardware.soundtrigger.V2_0;

import android.hardware.audio.common.V2_0.AudioConfig;
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
public interface ISoundTriggerHwCallback extends IBase {
    public static final String kInterfaceName = "android.hardware.soundtrigger@2.0::ISoundTriggerHwCallback";

    public static final class ModelEvent {
        public ArrayList<Byte> data;
        public int model;
        public int status;

        public ModelEvent() {
            this.status = 0;
            this.model = 0;
            this.data = new ArrayList();
        }

        public final boolean equals(Object otherObject) {
            if (this != otherObject) goto L6;
            return true;
        L6:
            if (otherObject != null) goto L9;
            return false;
        L9:
            if (otherObject.getClass() == ModelEvent.class) goto L11;
            return false;
        L11:
            ModelEvent other = (ModelEvent) otherObject;
            if (this.status == other.status) goto L15;
            return false;
        L15:
            if (this.model == other.model) goto L18;
            return false;
        L18:
            if (HidlSupport.deepEquals(this.data, other.data) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.status))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.model))), Integer.valueOf(HidlSupport.deepHashCode(this.data))});
        }

        public final String toString() {
            return "{.status = " + SoundModelStatus.toString(this.status) + ", .model = " + this.model + ", .data = " + this.data + "}";
        }

        public final void readFromParcel(HwParcel parcel) {
            HwBlob blob = parcel.readBuffer(24);
            readEmbeddedFromParcel(parcel, blob, 0);
        }

        public static final ArrayList<ModelEvent> readVectorFromParcel(HwParcel parcel) {
            ArrayList<ModelEvent> _hidl_vec = new ArrayList();
            HwBlob _hidl_blob = parcel.readBuffer(16);
            int _hidl_vec_size = _hidl_blob.getInt32(8);
            HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 24, _hidl_blob.handle(), 0, true);
            _hidl_vec.clear();
            int _hidl_index_0 = 0;
        L3:
            if (_hidl_index_0 >= _hidl_vec_size) goto L6;
            ModelEvent _hidl_vec_element = new ModelEvent();
            _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 24);
            _hidl_vec.add(_hidl_vec_element);
            _hidl_index_0 = _hidl_index_0 + 1;
            goto L3
        L6:
            return _hidl_vec;
        }

        public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
            this.status = _hidl_blob.getInt32(_hidl_offset + 0);
            this.model = _hidl_blob.getInt32(_hidl_offset + 4);
            int _hidl_vec_size = _hidl_blob.getInt32((_hidl_offset + 8) + 8);
            HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 1, _hidl_blob.handle(), (_hidl_offset + 8) + 0, true);
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
            HwBlob _hidl_blob = new HwBlob(24);
            writeEmbeddedToBlob(_hidl_blob, 0);
            parcel.writeBuffer(_hidl_blob);
        }

        public static final void writeVectorToParcel(HwParcel parcel, ArrayList<ModelEvent> _hidl_vec) {
            HwBlob _hidl_blob = new HwBlob(16);
            int _hidl_vec_size = _hidl_vec.size();
            _hidl_blob.putInt32(8, _hidl_vec_size);
            _hidl_blob.putBool(12, false);
            HwBlob childBlob = new HwBlob(_hidl_vec_size * 24);
            int _hidl_index_0 = 0;
        L3:
            if (_hidl_index_0 >= _hidl_vec_size) goto L5;
            _hidl_vec.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 24);
            _hidl_index_0 = _hidl_index_0 + 1;
            goto L3
        L5:
            _hidl_blob.putBlob(0, childBlob);
            parcel.writeBuffer(_hidl_blob);
        }

        public final void writeEmbeddedToBlob(HwBlob _hidl_blob, long _hidl_offset) {
            _hidl_blob.putInt32(_hidl_offset + 0, this.status);
            _hidl_blob.putInt32(4 + _hidl_offset, this.model);
            int _hidl_vec_size = this.data.size();
            _hidl_blob.putInt32((_hidl_offset + 8) + 8, _hidl_vec_size);
            _hidl_blob.putBool((_hidl_offset + 8) + 12, false);
            HwBlob childBlob = new HwBlob(_hidl_vec_size * 1);
            int _hidl_index_0 = 0;
        L3:
            if (_hidl_index_0 >= _hidl_vec_size) goto L5;
            childBlob.putInt8(_hidl_index_0 * 1, this.data.get(_hidl_index_0).byteValue());
            _hidl_index_0 = _hidl_index_0 + 1;
            goto L3
        L5:
            _hidl_blob.putBlob((8 + _hidl_offset) + 0, childBlob);
        }
    }

    public static final class PhraseRecognitionEvent {
        public RecognitionEvent common;
        public ArrayList<PhraseRecognitionExtra> phraseExtras;

        public PhraseRecognitionEvent() {
            this.common = new RecognitionEvent();
            this.phraseExtras = new ArrayList();
        }

        public final boolean equals(Object otherObject) {
            if (this != otherObject) goto L6;
            return true;
        L6:
            if (otherObject != null) goto L9;
            return false;
        L9:
            if (otherObject.getClass() == PhraseRecognitionEvent.class) goto L11;
            return false;
        L11:
            PhraseRecognitionEvent other = (PhraseRecognitionEvent) otherObject;
            if (HidlSupport.deepEquals(this.common, other.common) == true) goto L15;
            return false;
        L15:
            if (HidlSupport.deepEquals(this.phraseExtras, other.phraseExtras) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(HidlSupport.deepHashCode(this.common)), Integer.valueOf(HidlSupport.deepHashCode(this.phraseExtras))});
        }

        public final String toString() {
            return "{.common = " + this.common + ", .phraseExtras = " + this.phraseExtras + "}";
        }

        public final void readFromParcel(HwParcel parcel) {
            HwBlob blob = parcel.readBuffer(136);
            readEmbeddedFromParcel(parcel, blob, 0);
        }

        public static final ArrayList<PhraseRecognitionEvent> readVectorFromParcel(HwParcel parcel) {
            ArrayList<PhraseRecognitionEvent> _hidl_vec = new ArrayList();
            HwBlob _hidl_blob = parcel.readBuffer(16);
            int _hidl_vec_size = _hidl_blob.getInt32(8);
            HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 136, _hidl_blob.handle(), 0, true);
            _hidl_vec.clear();
            int _hidl_index_0 = 0;
        L3:
            if (_hidl_index_0 >= _hidl_vec_size) goto L6;
            PhraseRecognitionEvent _hidl_vec_element = new PhraseRecognitionEvent();
            _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 136);
            _hidl_vec.add(_hidl_vec_element);
            _hidl_index_0 = _hidl_index_0 + 1;
            goto L3
        L6:
            return _hidl_vec;
        }

        public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
            this.common.readEmbeddedFromParcel(parcel, _hidl_blob, _hidl_offset + 0);
            int _hidl_vec_size = _hidl_blob.getInt32((_hidl_offset + 120) + 8);
            HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 32, _hidl_blob.handle(), (120 + _hidl_offset) + 0, true);
            this.phraseExtras.clear();
            int _hidl_index_0 = 0;
        L3:
            if (_hidl_index_0 >= _hidl_vec_size) goto L6;
            PhraseRecognitionExtra _hidl_vec_element = new PhraseRecognitionExtra();
            _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 32);
            this.phraseExtras.add(_hidl_vec_element);
            _hidl_index_0 = _hidl_index_0 + 1;
            goto L3
        }

        public final void writeToParcel(HwParcel parcel) {
            HwBlob _hidl_blob = new HwBlob(136);
            writeEmbeddedToBlob(_hidl_blob, 0);
            parcel.writeBuffer(_hidl_blob);
        }

        public static final void writeVectorToParcel(HwParcel parcel, ArrayList<PhraseRecognitionEvent> _hidl_vec) {
            HwBlob _hidl_blob = new HwBlob(16);
            int _hidl_vec_size = _hidl_vec.size();
            _hidl_blob.putInt32(8, _hidl_vec_size);
            _hidl_blob.putBool(12, false);
            HwBlob childBlob = new HwBlob(_hidl_vec_size * 136);
            int _hidl_index_0 = 0;
        L3:
            if (_hidl_index_0 >= _hidl_vec_size) goto L5;
            _hidl_vec.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 136);
            _hidl_index_0 = _hidl_index_0 + 1;
            goto L3
        L5:
            _hidl_blob.putBlob(0, childBlob);
            parcel.writeBuffer(_hidl_blob);
        }

        public final void writeEmbeddedToBlob(HwBlob _hidl_blob, long _hidl_offset) {
            this.common.writeEmbeddedToBlob(_hidl_blob, _hidl_offset + 0);
            int _hidl_vec_size = this.phraseExtras.size();
            _hidl_blob.putInt32((_hidl_offset + 120) + 8, _hidl_vec_size);
            _hidl_blob.putBool((_hidl_offset + 120) + 12, false);
            HwBlob childBlob = new HwBlob(_hidl_vec_size * 32);
            int _hidl_index_0 = 0;
        L3:
            if (_hidl_index_0 >= _hidl_vec_size) goto L5;
            this.phraseExtras.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 32);
            _hidl_index_0 = _hidl_index_0 + 1;
            goto L3
        L5:
            _hidl_blob.putBlob((120 + _hidl_offset) + 0, childBlob);
        }
    }

    public static final class Proxy implements ISoundTriggerHwCallback {
        private IHwBinder mRemote;

        public Proxy(IHwBinder remote) {
            remote.getClass();
            this.mRemote = remote;
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHwCallback, android.hidl.base.V1_0.IBase
        public IHwBinder asBinder() {
            return this.mRemote;
        }

        public String toString() {
            return interfaceDescriptor() + "@Proxy";
        L5:
            return "[class or subclass of android.hardware.soundtrigger@2.0::ISoundTriggerHwCallback]@Proxy";
        }

        public final boolean equals(Object other) {
            return HidlSupport.interfacesEqual(this, other);
        }

        public final int hashCode() {
            return asBinder().hashCode();
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHwCallback
        public void recognitionCallback(RecognitionEvent event, int cookie) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(ISoundTriggerHwCallback.kInterfaceName);
            event.writeToParcel(_hidl_request);
            _hidl_request.writeInt32(cookie);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(1, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            _hidl_reply.release();
            return;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHwCallback
        public void phraseRecognitionCallback(PhraseRecognitionEvent event, int cookie) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(ISoundTriggerHwCallback.kInterfaceName);
            event.writeToParcel(_hidl_request);
            _hidl_request.writeInt32(cookie);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(2, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            _hidl_reply.release();
            return;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHwCallback
        public void soundModelCallback(ModelEvent event, int cookie) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(ISoundTriggerHwCallback.kInterfaceName);
            event.writeToParcel(_hidl_request);
            _hidl_request.writeInt32(cookie);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(3, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            _hidl_reply.release();
            return;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHwCallback, android.hidl.base.V1_0.IBase
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

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHwCallback, android.hidl.base.V1_0.IBase
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

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHwCallback, android.hidl.base.V1_0.IBase
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

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHwCallback, android.hidl.base.V1_0.IBase
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

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHwCallback, android.hidl.base.V1_0.IBase
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

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHwCallback, android.hidl.base.V1_0.IBase
        public boolean linkToDeath(IHwBinder.DeathRecipient recipient, long cookie) throws RemoteException {
            return this.mRemote.linkToDeath(recipient, cookie);
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHwCallback, android.hidl.base.V1_0.IBase
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

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHwCallback, android.hidl.base.V1_0.IBase
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

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHwCallback, android.hidl.base.V1_0.IBase
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

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHwCallback, android.hidl.base.V1_0.IBase
        public boolean unlinkToDeath(IHwBinder.DeathRecipient recipient) throws RemoteException {
            return this.mRemote.unlinkToDeath(recipient);
        }
    }

    public static final class RecognitionEvent {
        public AudioConfig audioConfig;
        public boolean captureAvailable;
        public int captureDelayMs;
        public int capturePreambleMs;
        public int captureSession;
        public ArrayList<Byte> data;
        public int model;
        public int status;
        public boolean triggerInData;
        public int type;

        public RecognitionEvent() {
            this.status = 0;
            this.type = 0;
            this.model = 0;
            this.captureAvailable = false;
            this.captureSession = 0;
            this.captureDelayMs = 0;
            this.capturePreambleMs = 0;
            this.triggerInData = false;
            this.audioConfig = new AudioConfig();
            this.data = new ArrayList();
        }

        public final boolean equals(Object otherObject) {
            if (this != otherObject) goto L6;
            return true;
        L6:
            if (otherObject != null) goto L9;
            return false;
        L9:
            if (otherObject.getClass() == RecognitionEvent.class) goto L11;
            return false;
        L11:
            RecognitionEvent other = (RecognitionEvent) otherObject;
            if (this.status == other.status) goto L15;
            return false;
        L15:
            if (this.type == other.type) goto L18;
            return false;
        L18:
            if (this.model == other.model) goto L21;
            return false;
        L21:
            if (this.captureAvailable == other.captureAvailable) goto L24;
            return false;
        L24:
            if (this.captureSession == other.captureSession) goto L27;
            return false;
        L27:
            if (this.captureDelayMs == other.captureDelayMs) goto L30;
            return false;
        L30:
            if (this.capturePreambleMs == other.capturePreambleMs) goto L33;
            return false;
        L33:
            if (this.triggerInData == other.triggerInData) goto L36;
            return false;
        L36:
            if (HidlSupport.deepEquals(this.audioConfig, other.audioConfig) == true) goto L39;
            return false;
        L39:
            if (HidlSupport.deepEquals(this.data, other.data) == true) goto L41;
            return false;
        L41:
            return true;
        }

        public final int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.status))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.type))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.model))), Integer.valueOf(HidlSupport.deepHashCode(Boolean.valueOf(this.captureAvailable))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.captureSession))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.captureDelayMs))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.capturePreambleMs))), Integer.valueOf(HidlSupport.deepHashCode(Boolean.valueOf(this.triggerInData))), Integer.valueOf(HidlSupport.deepHashCode(this.audioConfig)), Integer.valueOf(HidlSupport.deepHashCode(this.data))});
        }

        public final String toString() {
            return "{.status = " + RecognitionStatus.toString(this.status) + ", .type = " + SoundModelType.toString(this.type) + ", .model = " + this.model + ", .captureAvailable = " + this.captureAvailable + ", .captureSession = " + this.captureSession + ", .captureDelayMs = " + this.captureDelayMs + ", .capturePreambleMs = " + this.capturePreambleMs + ", .triggerInData = " + this.triggerInData + ", .audioConfig = " + this.audioConfig + ", .data = " + this.data + "}";
        }

        public final void readFromParcel(HwParcel parcel) {
            HwBlob blob = parcel.readBuffer(120);
            readEmbeddedFromParcel(parcel, blob, 0);
        }

        public static final ArrayList<RecognitionEvent> readVectorFromParcel(HwParcel parcel) {
            ArrayList<RecognitionEvent> _hidl_vec = new ArrayList();
            HwBlob _hidl_blob = parcel.readBuffer(16);
            int _hidl_vec_size = _hidl_blob.getInt32(8);
            HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 120, _hidl_blob.handle(), 0, true);
            _hidl_vec.clear();
            int _hidl_index_0 = 0;
        L3:
            if (_hidl_index_0 >= _hidl_vec_size) goto L6;
            RecognitionEvent _hidl_vec_element = new RecognitionEvent();
            _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 120);
            _hidl_vec.add(_hidl_vec_element);
            _hidl_index_0 = _hidl_index_0 + 1;
            goto L3
        L6:
            return _hidl_vec;
        }

        public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
            this.status = _hidl_blob.getInt32(_hidl_offset + 0);
            this.type = _hidl_blob.getInt32(_hidl_offset + 4);
            this.model = _hidl_blob.getInt32(_hidl_offset + 8);
            this.captureAvailable = _hidl_blob.getBool(_hidl_offset + 12);
            this.captureSession = _hidl_blob.getInt32(_hidl_offset + 16);
            this.captureDelayMs = _hidl_blob.getInt32(_hidl_offset + 20);
            this.capturePreambleMs = _hidl_blob.getInt32(_hidl_offset + 24);
            this.triggerInData = _hidl_blob.getBool(_hidl_offset + 28);
            this.audioConfig.readEmbeddedFromParcel(parcel, _hidl_blob, _hidl_offset + 32);
            int _hidl_vec_size = _hidl_blob.getInt32((_hidl_offset + 104) + 8);
            HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 1, _hidl_blob.handle(), (_hidl_offset + 104) + 0, true);
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
            HwBlob _hidl_blob = new HwBlob(120);
            writeEmbeddedToBlob(_hidl_blob, 0);
            parcel.writeBuffer(_hidl_blob);
        }

        public static final void writeVectorToParcel(HwParcel parcel, ArrayList<RecognitionEvent> _hidl_vec) {
            HwBlob _hidl_blob = new HwBlob(16);
            int _hidl_vec_size = _hidl_vec.size();
            _hidl_blob.putInt32(8, _hidl_vec_size);
            _hidl_blob.putBool(12, false);
            HwBlob childBlob = new HwBlob(_hidl_vec_size * 120);
            int _hidl_index_0 = 0;
        L3:
            if (_hidl_index_0 >= _hidl_vec_size) goto L5;
            _hidl_vec.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 120);
            _hidl_index_0 = _hidl_index_0 + 1;
            goto L3
        L5:
            _hidl_blob.putBlob(0, childBlob);
            parcel.writeBuffer(_hidl_blob);
        }

        public final void writeEmbeddedToBlob(HwBlob _hidl_blob, long _hidl_offset) {
            _hidl_blob.putInt32(_hidl_offset + 0, this.status);
            _hidl_blob.putInt32(4 + _hidl_offset, this.type);
            _hidl_blob.putInt32(_hidl_offset + 8, this.model);
            _hidl_blob.putBool(_hidl_offset + 12, this.captureAvailable);
            _hidl_blob.putInt32(16 + _hidl_offset, this.captureSession);
            _hidl_blob.putInt32(20 + _hidl_offset, this.captureDelayMs);
            _hidl_blob.putInt32(24 + _hidl_offset, this.capturePreambleMs);
            _hidl_blob.putBool(28 + _hidl_offset, this.triggerInData);
            this.audioConfig.writeEmbeddedToBlob(_hidl_blob, 32 + _hidl_offset);
            int _hidl_vec_size = this.data.size();
            _hidl_blob.putInt32((_hidl_offset + 104) + 8, _hidl_vec_size);
            _hidl_blob.putBool((_hidl_offset + 104) + 12, false);
            HwBlob childBlob = new HwBlob(_hidl_vec_size * 1);
            int _hidl_index_0 = 0;
        L3:
            if (_hidl_index_0 >= _hidl_vec_size) goto L5;
            childBlob.putInt8(_hidl_index_0 * 1, this.data.get(_hidl_index_0).byteValue());
            _hidl_index_0 = _hidl_index_0 + 1;
            goto L3
        L5:
            _hidl_blob.putBlob((104 + _hidl_offset) + 0, childBlob);
        }
    }

    public static final class RecognitionStatus {
        public static final int ABORT = 1;
        public static final int FAILURE = 2;
        public static final int SUCCESS = 0;

        public RecognitionStatus() {
        }

        public static final String toString(int o) {
            if (o != 0) goto L6;
            return "SUCCESS";
        L6:
            if (o != 1) goto L10;
            return "ABORT";
        L10:
            if (o != 2) goto L14;
            return "FAILURE";
        L14:
            return "0x" + Integer.toHexString(o);
        }

        public static final String dumpBitfield(int o) {
            ArrayList<String> list = new ArrayList();
            int flipped = 0;
            list.add("SUCCESS");
            if ((o & 1) != 1) goto L6;
            list.add("ABORT");
            flipped = 0 | 1;
        L6:
            if ((o & 2) != 2) goto L8;
            list.add("FAILURE");
            flipped = flipped | 2;
        L8:
            if (o == flipped) goto L11;
            list.add("0x" + Integer.toHexString((~flipped) & o));
        L11:
            return String.join(" | ", list);
        }
    }

    public static final class SoundModelStatus {
        public static final int UPDATED = 0;

        public SoundModelStatus() {
        }

        public static final String toString(int o) {
            if (o != 0) goto L6;
            return "UPDATED";
        L6:
            return "0x" + Integer.toHexString(o);
        }

        public static final String dumpBitfield(int o) {
            ArrayList<String> list = new ArrayList();
            list.add("UPDATED");
            if (o == 0) goto L6;
            list.add("0x" + Integer.toHexString((~0) & o));
        L6:
            return String.join(" | ", list);
        }
    }

    public static abstract class Stub extends HwBinder implements ISoundTriggerHwCallback {
        public Stub() {
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHwCallback, android.hidl.base.V1_0.IBase
        public IHwBinder asBinder() {
            return this;
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHwCallback, android.hidl.base.V1_0.IBase
        public final ArrayList<String> interfaceChain() {
            return new ArrayList(Arrays.asList(new String[]{ISoundTriggerHwCallback.kInterfaceName, IBase.kInterfaceName}));
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHwCallback, android.hidl.base.V1_0.IBase
        public void debug(NativeHandle fd, ArrayList<String> options) {
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHwCallback, android.hidl.base.V1_0.IBase
        public final String interfaceDescriptor() {
            return ISoundTriggerHwCallback.kInterfaceName;
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHwCallback, android.hidl.base.V1_0.IBase
        public final ArrayList<byte[]> getHashChain() {
            return new ArrayList(Arrays.asList(new byte[][]{new byte[]{ParameterName.AUTO_SUPER_RESOLUTION_ENABLED, 110, ParameterName.ELEVEN_POINT_RED, -46, -119, -14, 41, 49, -59, ParameterName.COLOR_TEMPERATURE_GREEN_GAIN, -78, ParameterName.AUTO_PICTUREQUALITY_ENABLED, ParameterName.COLOR_TUNE, -111, 15, ParameterName.PC_MODE, 76, ParameterName.COLOR_TUNER_SATURATION_BLUE, 107, 122, -53, -107, ParameterName.ENHANCED_AUDIO_RETURN_CHANNEL_ENABLED, -28, 36, ParameterName.COLOR_TUNER_HUE_CYAN, -28, -50, -114, 108, -62, -28}, new byte[]{-20, 127, -41, -98, -48, ParameterName.ELEVEN_POINT_BLUE, -6, -123, -68, ParameterName.COLOR_TUNER_LUMINANCE_GREEN, -108, ParameterName.COLOR_TEMPERATURE_GREEN_GAIN, -83, -82, ParameterName.COLOR_TUNER_HUE_MAGENTA, -66, 35, -17, 5, 36, -13, -51, 105, ParameterName.AUTO_VOLUME_CONTROL, ParameterName.FILM_MODE, -109, 36, -72, ParameterName.COLOR_TUNER_HUE_GREEN, ParameterName.GLOBE_DIMMING, -54, 76}}));
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHwCallback, android.hidl.base.V1_0.IBase
        public final void setHALInstrumentation() {
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHwCallback, android.hidl.base.V1_0.IBase
        public final boolean linkToDeath(IHwBinder.DeathRecipient recipient, long cookie) {
            return true;
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHwCallback, android.hidl.base.V1_0.IBase
        public final void ping() {
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHwCallback, android.hidl.base.V1_0.IBase
        public final DebugInfo getDebugInfo() {
            DebugInfo info = new DebugInfo();
            info.pid = HidlSupport.getPidIfSharable();
            info.ptr = 0;
            info.arch = 0;
            return info;
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHwCallback, android.hidl.base.V1_0.IBase
        public final void notifySyspropsChanged() {
            HwBinder.enableInstrumentation();
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHwCallback, android.hidl.base.V1_0.IBase
        public final boolean unlinkToDeath(IHwBinder.DeathRecipient recipient) {
            return true;
        }

        public IHwInterface queryLocalInterface(String descriptor) {
            if (ISoundTriggerHwCallback.kInterfaceName.equals(descriptor) == false) goto L5;
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

        public void onTransact(int _hidl_code, HwParcel _hidl_request, HwParcel _hidl_reply, int _hidl_flags) throws RemoteException {
            switch(_hidl_code) {
                case 1: goto L25;
                case 2: goto L24;
                case 3: goto L23;
                case 256067662: goto L22;
                case 256131655: goto L21;
                case 256136003: goto L20;
                case 256398152: goto L10;
                case 256462420: goto L9;
                case 256660548: goto L40;
                case 256921159: goto L7;
                case 257049926: goto L6;
                case 257120595: goto L5;
                default: goto L40;
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
            _hidl_request.enforceInterface(ISoundTriggerHwCallback.kInterfaceName);
            ModelEvent event = new ModelEvent();
            event.readFromParcel(_hidl_request);
            int cookie = _hidl_request.readInt32();
            soundModelCallback(event, cookie);
            _hidl_reply.writeStatus(0);
            _hidl_reply.send();
            return;
        L24:
            _hidl_request.enforceInterface(ISoundTriggerHwCallback.kInterfaceName);
            PhraseRecognitionEvent event2 = new PhraseRecognitionEvent();
            event2.readFromParcel(_hidl_request);
            int cookie2 = _hidl_request.readInt32();
            phraseRecognitionCallback(event2, cookie2);
            _hidl_reply.writeStatus(0);
            _hidl_reply.send();
            return;
        L25:
            _hidl_request.enforceInterface(ISoundTriggerHwCallback.kInterfaceName);
            RecognitionEvent event3 = new RecognitionEvent();
            event3.readFromParcel(_hidl_request);
            int cookie3 = _hidl_request.readInt32();
            recognitionCallback(event3, cookie3);
            _hidl_reply.writeStatus(0);
            _hidl_reply.send();
            return;
        }
    }

    @Override // android.hidl.base.V1_0.IBase
    IHwBinder asBinder();

    @Override // android.hidl.base.V1_0.IBase
    void debug(NativeHandle r1, ArrayList<String> r2) throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    DebugInfo getDebugInfo() throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    ArrayList<byte[]> getHashChain() throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    ArrayList<String> interfaceChain() throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    String interfaceDescriptor() throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    boolean linkToDeath(IHwBinder.DeathRecipient r1, long r2) throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    void notifySyspropsChanged() throws RemoteException;

    void phraseRecognitionCallback(PhraseRecognitionEvent r1, int r2) throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    void ping() throws RemoteException;

    void recognitionCallback(RecognitionEvent r1, int r2) throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    void setHALInstrumentation() throws RemoteException;

    void soundModelCallback(ModelEvent r1, int r2) throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    boolean unlinkToDeath(IHwBinder.DeathRecipient r1) throws RemoteException;

    static ISoundTriggerHwCallback asInterface(IHwBinder binder) {
        if (binder != null) goto L5;
        return null;
    L5:
        IHwInterface iface = binder.queryLocalInterface(kInterfaceName);
        if (iface != null) goto L8;
    L11:
        ISoundTriggerHwCallback proxy = new Proxy(binder);
        Iterator<String> r4 = proxy.interfaceChain().iterator();     // Catch: RemoteException -> L19
    L14:
        if (r4.hasNext() == false) goto L22;
        String descriptor = r4.next();     // Catch: RemoteException -> L19
        if (descriptor.equals(kInterfaceName) == false) goto L14;
        return proxy;
    L22:
        return null;
    L8:
        if ((iface instanceof ISoundTriggerHwCallback) == false) goto L11;
        return (ISoundTriggerHwCallback) iface;
    }

    static ISoundTriggerHwCallback castFrom(IHwInterface iface) {
        if (iface != null) goto L5;
        return null;
    L5:
        return asInterface(iface.asBinder());
    }

    static ISoundTriggerHwCallback getService(String serviceName, boolean retry) throws RemoteException {
        return asInterface(HwBinder.getService(kInterfaceName, serviceName, retry));
    }

    static ISoundTriggerHwCallback getService(boolean retry) throws RemoteException {
        return getService("default", retry);
    }

    @Deprecated
    static ISoundTriggerHwCallback getService(String serviceName) throws RemoteException {
        return asInterface(HwBinder.getService(kInterfaceName, serviceName));
    }

    @Deprecated
    static ISoundTriggerHwCallback getService() throws RemoteException {
        return getService("default");
    }
}
