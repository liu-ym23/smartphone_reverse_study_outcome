package android.hardware.soundtrigger.V2_2;

import android.hardware.soundtrigger.V2_0.ISoundTriggerHwCallback;
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
import com.android.server.usb.descriptors.UsbASFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public interface ISoundTriggerHw extends android.hardware.soundtrigger.V2_1.ISoundTriggerHw {
    public static final String kInterfaceName = "android.hardware.soundtrigger@2.2::ISoundTriggerHw";

    public static final class Proxy implements ISoundTriggerHw {
        private IHwBinder mRemote;

        public Proxy(IHwBinder remote) {
            remote.getClass();
            this.mRemote = remote;
        }

        @Override // android.hardware.soundtrigger.V2_2.ISoundTriggerHw, android.hardware.soundtrigger.V2_1.ISoundTriggerHw, android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
        public IHwBinder asBinder() {
            return this.mRemote;
        }

        public String toString() {
            return interfaceDescriptor() + "@Proxy";
        L5:
            return "[class or subclass of android.hardware.soundtrigger@2.2::ISoundTriggerHw]@Proxy";
        }

        public final boolean equals(Object other) {
            return HidlSupport.interfacesEqual(this, other);
        }

        public final int hashCode() {
            return asBinder().hashCode();
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHw
        public void getProperties(android.hardware.soundtrigger.V2_0.ISoundTriggerHw.getPropertiesCallback _hidl_cb) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(android.hardware.soundtrigger.V2_0.ISoundTriggerHw.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(1, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            int _hidl_out_retval = _hidl_reply.readInt32();     // Catch: Throwable -> L6
            android.hardware.soundtrigger.V2_0.ISoundTriggerHw.Properties _hidl_out_properties = new android.hardware.soundtrigger.V2_0.ISoundTriggerHw.Properties();     // Catch: Throwable -> L6
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
        public void loadSoundModel(android.hardware.soundtrigger.V2_0.ISoundTriggerHw.SoundModel soundModel, ISoundTriggerHwCallback callback, int cookie, android.hardware.soundtrigger.V2_0.ISoundTriggerHw.loadSoundModelCallback _hidl_cb) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(android.hardware.soundtrigger.V2_0.ISoundTriggerHw.kInterfaceName);
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
        public void loadPhraseSoundModel(android.hardware.soundtrigger.V2_0.ISoundTriggerHw.PhraseSoundModel soundModel, ISoundTriggerHwCallback callback, int cookie, android.hardware.soundtrigger.V2_0.ISoundTriggerHw.loadPhraseSoundModelCallback _hidl_cb) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(android.hardware.soundtrigger.V2_0.ISoundTriggerHw.kInterfaceName);
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
            _hidl_request.writeInterfaceToken(android.hardware.soundtrigger.V2_0.ISoundTriggerHw.kInterfaceName);
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
        public int startRecognition(int modelHandle, android.hardware.soundtrigger.V2_0.ISoundTriggerHw.RecognitionConfig config, ISoundTriggerHwCallback callback, int cookie) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(android.hardware.soundtrigger.V2_0.ISoundTriggerHw.kInterfaceName);
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
            _hidl_request.writeInterfaceToken(android.hardware.soundtrigger.V2_0.ISoundTriggerHw.kInterfaceName);
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
            _hidl_request.writeInterfaceToken(android.hardware.soundtrigger.V2_0.ISoundTriggerHw.kInterfaceName);
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

        @Override // android.hardware.soundtrigger.V2_1.ISoundTriggerHw
        public void loadSoundModel_2_1(android.hardware.soundtrigger.V2_1.ISoundTriggerHw.SoundModel soundModel, android.hardware.soundtrigger.V2_1.ISoundTriggerHwCallback callback, int cookie, android.hardware.soundtrigger.V2_1.ISoundTriggerHw.loadSoundModel_2_1Callback _hidl_cb) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(android.hardware.soundtrigger.V2_1.ISoundTriggerHw.kInterfaceName);
            soundModel.writeToParcel(_hidl_request);
            if (callback != null) goto L5;
            IHwBinder r1 = null;
        L6:
            _hidl_request.writeStrongBinder(r1);
            _hidl_request.writeInt32(cookie);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(8, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L10
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

        @Override // android.hardware.soundtrigger.V2_1.ISoundTriggerHw
        public void loadPhraseSoundModel_2_1(android.hardware.soundtrigger.V2_1.ISoundTriggerHw.PhraseSoundModel soundModel, android.hardware.soundtrigger.V2_1.ISoundTriggerHwCallback callback, int cookie, android.hardware.soundtrigger.V2_1.ISoundTriggerHw.loadPhraseSoundModel_2_1Callback _hidl_cb) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(android.hardware.soundtrigger.V2_1.ISoundTriggerHw.kInterfaceName);
            soundModel.writeToParcel(_hidl_request);
            if (callback != null) goto L5;
            IHwBinder r1 = null;
        L6:
            _hidl_request.writeStrongBinder(r1);
            _hidl_request.writeInt32(cookie);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(9, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L10
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

        @Override // android.hardware.soundtrigger.V2_1.ISoundTriggerHw
        public int startRecognition_2_1(int modelHandle, android.hardware.soundtrigger.V2_1.ISoundTriggerHw.RecognitionConfig config, android.hardware.soundtrigger.V2_1.ISoundTriggerHwCallback callback, int cookie) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(android.hardware.soundtrigger.V2_1.ISoundTriggerHw.kInterfaceName);
            _hidl_request.writeInt32(modelHandle);
            config.writeToParcel(_hidl_request);
            if (callback != null) goto L5;
            IHwBinder r1 = null;
        L6:
            _hidl_request.writeStrongBinder(r1);
            _hidl_request.writeInt32(cookie);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(10, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L10
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

        @Override // android.hardware.soundtrigger.V2_2.ISoundTriggerHw
        public int getModelState(int modelHandle) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(ISoundTriggerHw.kInterfaceName);
            _hidl_request.writeInt32(modelHandle);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(11, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
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

        @Override // android.hardware.soundtrigger.V2_2.ISoundTriggerHw, android.hardware.soundtrigger.V2_1.ISoundTriggerHw, android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
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

        @Override // android.hardware.soundtrigger.V2_2.ISoundTriggerHw, android.hardware.soundtrigger.V2_1.ISoundTriggerHw, android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
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

        @Override // android.hardware.soundtrigger.V2_2.ISoundTriggerHw, android.hardware.soundtrigger.V2_1.ISoundTriggerHw, android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
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

        @Override // android.hardware.soundtrigger.V2_2.ISoundTriggerHw, android.hardware.soundtrigger.V2_1.ISoundTriggerHw, android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
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

        @Override // android.hardware.soundtrigger.V2_2.ISoundTriggerHw, android.hardware.soundtrigger.V2_1.ISoundTriggerHw, android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
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

        @Override // android.hardware.soundtrigger.V2_2.ISoundTriggerHw, android.hardware.soundtrigger.V2_1.ISoundTriggerHw, android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
        public boolean linkToDeath(IHwBinder.DeathRecipient recipient, long cookie) throws RemoteException {
            return this.mRemote.linkToDeath(recipient, cookie);
        }

        @Override // android.hardware.soundtrigger.V2_2.ISoundTriggerHw, android.hardware.soundtrigger.V2_1.ISoundTriggerHw, android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
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

        @Override // android.hardware.soundtrigger.V2_2.ISoundTriggerHw, android.hardware.soundtrigger.V2_1.ISoundTriggerHw, android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
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

        @Override // android.hardware.soundtrigger.V2_2.ISoundTriggerHw, android.hardware.soundtrigger.V2_1.ISoundTriggerHw, android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
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

        @Override // android.hardware.soundtrigger.V2_2.ISoundTriggerHw, android.hardware.soundtrigger.V2_1.ISoundTriggerHw, android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
        public boolean unlinkToDeath(IHwBinder.DeathRecipient recipient) throws RemoteException {
            return this.mRemote.unlinkToDeath(recipient);
        }
    }

    public static abstract class Stub extends HwBinder implements ISoundTriggerHw {
        public Stub() {
        }

        @Override // android.hardware.soundtrigger.V2_2.ISoundTriggerHw, android.hardware.soundtrigger.V2_1.ISoundTriggerHw, android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
        public IHwBinder asBinder() {
            return this;
        }

        @Override // android.hardware.soundtrigger.V2_2.ISoundTriggerHw, android.hardware.soundtrigger.V2_1.ISoundTriggerHw, android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
        public final ArrayList<String> interfaceChain() {
            return new ArrayList(Arrays.asList(new String[]{ISoundTriggerHw.kInterfaceName, android.hardware.soundtrigger.V2_1.ISoundTriggerHw.kInterfaceName, android.hardware.soundtrigger.V2_0.ISoundTriggerHw.kInterfaceName, IBase.kInterfaceName}));
        }

        @Override // android.hardware.soundtrigger.V2_2.ISoundTriggerHw, android.hardware.soundtrigger.V2_1.ISoundTriggerHw, android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
        public void debug(NativeHandle fd, ArrayList<String> options) {
        }

        @Override // android.hardware.soundtrigger.V2_2.ISoundTriggerHw, android.hardware.soundtrigger.V2_1.ISoundTriggerHw, android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
        public final String interfaceDescriptor() {
            return ISoundTriggerHw.kInterfaceName;
        }

        @Override // android.hardware.soundtrigger.V2_2.ISoundTriggerHw, android.hardware.soundtrigger.V2_1.ISoundTriggerHw, android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
        public final ArrayList<byte[]> getHashChain() {
            return new ArrayList(Arrays.asList(new byte[][]{new byte[]{-50, 75, -104, 33, ParameterName.AUTO_PICTUREQUALITY_ENABLED, ParameterName.DTS_DRC, ParameterName.COLOR_TUNER_SATURATION_CYAN, -109, 97, ParameterName.BLACK_STRETCH, 109, 75, ParameterName.LOW_LATENCY, ParameterName.SPEAKERS_DELAY_MS, ParameterName.SPEAKERS_ENABLED, -36, -124, ParameterName.GAMUT_MAPPING, -21, ParameterName.COLOR_TUNER_LUMINANCE_YELLOW, ParameterName.COLOR_TUNER_SATURATION_MAGENTA, 119, ParameterName.BLUE_STRETCH, ParameterName.COLOR_TUNER_LUMINANCE_YELLOW, 123, ParameterName.LD_MODE, -74, -47, -21, ParameterName.BASS, ParameterName.BALANCE, 118}, new byte[]{-76, -11, 7, -76, -36, -101, ParameterName.DTS_VIRTUAL_X, -43, -16, -28, ParameterName.COLOR_TUNER_SATURATION_CYAN, ParameterName.DTS_DRC, ParameterName.COLOR_TEMPERATURE_GREEN_GAIN, -84, -73, -39, ParameterName.COLOR_TUNER_SATURATION_MAGENTA, 37, -82, 96, -36, 48, 123, ParameterName.COLOR_TUNER_SWITCH, ParameterName.TREBLE, ParameterName.BLACK_STRETCH, 34, UsbASFormat.EXT_FORMAT_TYPE_III, 99, 34, 7, -74}, new byte[]{ParameterName.DOLBY_DIALOGUE_ENHANCER, -17, -64, ParameterName.AUTO_PICTUREQUALITY_ENABLED, -53, -23, ParameterName.COLOR_TUNER_LUMINANCE_GREEN, 83, 102, ParameterName.LOW_LATENCY, ParameterName.ELEVEN_POINT_GREEN, -37, -107, -29, -49, 100, -11, -27, 101, -62, -108, 3, -31, -62, -38, -20, -62, -66, ParameterName.COLOR_TUNER_SATURATION_CYAN, -32, -91, ParameterName.DTS_VIRTUAL_X}, new byte[]{-20, 127, -41, -98, -48, ParameterName.ELEVEN_POINT_BLUE, -6, -123, -68, ParameterName.COLOR_TUNER_LUMINANCE_GREEN, -108, ParameterName.COLOR_TEMPERATURE_GREEN_GAIN, -83, -82, ParameterName.COLOR_TUNER_HUE_MAGENTA, -66, 35, -17, 5, 36, -13, -51, 105, ParameterName.AUTO_VOLUME_CONTROL, ParameterName.FILM_MODE, -109, 36, -72, ParameterName.COLOR_TUNER_HUE_GREEN, ParameterName.GLOBE_DIMMING, -54, 76}}));
        }

        @Override // android.hardware.soundtrigger.V2_2.ISoundTriggerHw, android.hardware.soundtrigger.V2_1.ISoundTriggerHw, android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
        public final void setHALInstrumentation() {
        }

        @Override // android.hardware.soundtrigger.V2_2.ISoundTriggerHw, android.hardware.soundtrigger.V2_1.ISoundTriggerHw, android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
        public final boolean linkToDeath(IHwBinder.DeathRecipient recipient, long cookie) {
            return true;
        }

        @Override // android.hardware.soundtrigger.V2_2.ISoundTriggerHw, android.hardware.soundtrigger.V2_1.ISoundTriggerHw, android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
        public final void ping() {
        }

        @Override // android.hardware.soundtrigger.V2_2.ISoundTriggerHw, android.hardware.soundtrigger.V2_1.ISoundTriggerHw, android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
        public final DebugInfo getDebugInfo() {
            DebugInfo info = new DebugInfo();
            info.pid = HidlSupport.getPidIfSharable();
            info.ptr = 0;
            info.arch = 0;
            return info;
        }

        @Override // android.hardware.soundtrigger.V2_2.ISoundTriggerHw, android.hardware.soundtrigger.V2_1.ISoundTriggerHw, android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
        public final void notifySyspropsChanged() {
            HwBinder.enableInstrumentation();
        }

        @Override // android.hardware.soundtrigger.V2_2.ISoundTriggerHw, android.hardware.soundtrigger.V2_1.ISoundTriggerHw, android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
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
                case 1: goto L33;
                case 2: goto L32;
                case 3: goto L31;
                case 4: goto L30;
                case 5: goto L29;
                case 6: goto L28;
                case 7: goto L27;
                case 8: goto L26;
                case 9: goto L25;
                case 10: goto L24;
                case 11: goto L23;
                case 256067662: goto L22;
                case 256131655: goto L21;
                case 256136003: goto L20;
                case 256398152: goto L10;
                case 256462420: goto L9;
                case 256660548: goto L56;
                case 256921159: goto L7;
                case 257049926: goto L6;
                case 257120595: goto L5;
                default: goto L56;
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
            int modelHandle = _hidl_request.readInt32();
            int _hidl_out_retval = getModelState(modelHandle);
            _hidl_reply.writeStatus(0);
            _hidl_reply.writeInt32(_hidl_out_retval);
            _hidl_reply.send();
            return;
        L24:
            _hidl_request.enforceInterface(android.hardware.soundtrigger.V2_1.ISoundTriggerHw.kInterfaceName);
            int modelHandle2 = _hidl_request.readInt32();
            android.hardware.soundtrigger.V2_1.ISoundTriggerHw.RecognitionConfig config = new android.hardware.soundtrigger.V2_1.ISoundTriggerHw.RecognitionConfig();
            config.readFromParcel(_hidl_request);
            android.hardware.soundtrigger.V2_1.ISoundTriggerHwCallback callback = android.hardware.soundtrigger.V2_1.ISoundTriggerHwCallback.asInterface(_hidl_request.readStrongBinder());
            int cookie = _hidl_request.readInt32();
            int _hidl_out_retval2 = startRecognition_2_1(modelHandle2, config, callback, cookie);
            _hidl_reply.writeStatus(0);
            _hidl_reply.writeInt32(_hidl_out_retval2);
            _hidl_reply.send();
            return;
        L25:
            _hidl_request.enforceInterface(android.hardware.soundtrigger.V2_1.ISoundTriggerHw.kInterfaceName);
            android.hardware.soundtrigger.V2_1.ISoundTriggerHw.PhraseSoundModel soundModel = new android.hardware.soundtrigger.V2_1.ISoundTriggerHw.PhraseSoundModel();
            soundModel.readFromParcel(_hidl_request);
            android.hardware.soundtrigger.V2_1.ISoundTriggerHwCallback callback2 = android.hardware.soundtrigger.V2_1.ISoundTriggerHwCallback.asInterface(_hidl_request.readStrongBinder());
            int cookie2 = _hidl_request.readInt32();
            loadPhraseSoundModel_2_1(soundModel, callback2, cookie2, new AnonymousClass5(this, _hidl_reply));
            return;
        L26:
            _hidl_request.enforceInterface(android.hardware.soundtrigger.V2_1.ISoundTriggerHw.kInterfaceName);
            android.hardware.soundtrigger.V2_1.ISoundTriggerHw.SoundModel soundModel2 = new android.hardware.soundtrigger.V2_1.ISoundTriggerHw.SoundModel();
            soundModel2.readFromParcel(_hidl_request);
            android.hardware.soundtrigger.V2_1.ISoundTriggerHwCallback callback3 = android.hardware.soundtrigger.V2_1.ISoundTriggerHwCallback.asInterface(_hidl_request.readStrongBinder());
            int cookie3 = _hidl_request.readInt32();
            loadSoundModel_2_1(soundModel2, callback3, cookie3, new AnonymousClass4(this, _hidl_reply));
            return;
        L27:
            _hidl_request.enforceInterface(android.hardware.soundtrigger.V2_0.ISoundTriggerHw.kInterfaceName);
            int _hidl_out_retval3 = stopAllRecognitions();
            _hidl_reply.writeStatus(0);
            _hidl_reply.writeInt32(_hidl_out_retval3);
            _hidl_reply.send();
            return;
        L28:
            _hidl_request.enforceInterface(android.hardware.soundtrigger.V2_0.ISoundTriggerHw.kInterfaceName);
            int modelHandle3 = _hidl_request.readInt32();
            int _hidl_out_retval4 = stopRecognition(modelHandle3);
            _hidl_reply.writeStatus(0);
            _hidl_reply.writeInt32(_hidl_out_retval4);
            _hidl_reply.send();
            return;
        L29:
            _hidl_request.enforceInterface(android.hardware.soundtrigger.V2_0.ISoundTriggerHw.kInterfaceName);
            int modelHandle4 = _hidl_request.readInt32();
            android.hardware.soundtrigger.V2_0.ISoundTriggerHw.RecognitionConfig config2 = new android.hardware.soundtrigger.V2_0.ISoundTriggerHw.RecognitionConfig();
            config2.readFromParcel(_hidl_request);
            ISoundTriggerHwCallback callback4 = ISoundTriggerHwCallback.asInterface(_hidl_request.readStrongBinder());
            int cookie4 = _hidl_request.readInt32();
            int _hidl_out_retval5 = startRecognition(modelHandle4, config2, callback4, cookie4);
            _hidl_reply.writeStatus(0);
            _hidl_reply.writeInt32(_hidl_out_retval5);
            _hidl_reply.send();
            return;
        L30:
            _hidl_request.enforceInterface(android.hardware.soundtrigger.V2_0.ISoundTriggerHw.kInterfaceName);
            int modelHandle5 = _hidl_request.readInt32();
            int _hidl_out_retval6 = unloadSoundModel(modelHandle5);
            _hidl_reply.writeStatus(0);
            _hidl_reply.writeInt32(_hidl_out_retval6);
            _hidl_reply.send();
            return;
        L31:
            _hidl_request.enforceInterface(android.hardware.soundtrigger.V2_0.ISoundTriggerHw.kInterfaceName);
            android.hardware.soundtrigger.V2_0.ISoundTriggerHw.PhraseSoundModel soundModel3 = new android.hardware.soundtrigger.V2_0.ISoundTriggerHw.PhraseSoundModel();
            soundModel3.readFromParcel(_hidl_request);
            ISoundTriggerHwCallback callback5 = ISoundTriggerHwCallback.asInterface(_hidl_request.readStrongBinder());
            int cookie5 = _hidl_request.readInt32();
            loadPhraseSoundModel(soundModel3, callback5, cookie5, new AnonymousClass3(this, _hidl_reply));
            return;
        L32:
            _hidl_request.enforceInterface(android.hardware.soundtrigger.V2_0.ISoundTriggerHw.kInterfaceName);
            android.hardware.soundtrigger.V2_0.ISoundTriggerHw.SoundModel soundModel4 = new android.hardware.soundtrigger.V2_0.ISoundTriggerHw.SoundModel();
            soundModel4.readFromParcel(_hidl_request);
            ISoundTriggerHwCallback callback6 = ISoundTriggerHwCallback.asInterface(_hidl_request.readStrongBinder());
            int cookie6 = _hidl_request.readInt32();
            loadSoundModel(soundModel4, callback6, cookie6, new AnonymousClass2(this, _hidl_reply));
            return;
        L33:
            _hidl_request.enforceInterface(android.hardware.soundtrigger.V2_0.ISoundTriggerHw.kInterfaceName);
            getProperties(new AnonymousClass1(this, _hidl_reply));
            return;
        }
    }

    @Override // android.hardware.soundtrigger.V2_1.ISoundTriggerHw, android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
    IHwBinder asBinder();

    @Override // android.hardware.soundtrigger.V2_1.ISoundTriggerHw, android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
    void debug(NativeHandle r1, ArrayList<String> r2) throws RemoteException;

    @Override // android.hardware.soundtrigger.V2_1.ISoundTriggerHw, android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
    DebugInfo getDebugInfo() throws RemoteException;

    @Override // android.hardware.soundtrigger.V2_1.ISoundTriggerHw, android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
    ArrayList<byte[]> getHashChain() throws RemoteException;

    int getModelState(int r1) throws RemoteException;

    @Override // android.hardware.soundtrigger.V2_1.ISoundTriggerHw, android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
    ArrayList<String> interfaceChain() throws RemoteException;

    @Override // android.hardware.soundtrigger.V2_1.ISoundTriggerHw, android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
    String interfaceDescriptor() throws RemoteException;

    @Override // android.hardware.soundtrigger.V2_1.ISoundTriggerHw, android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
    boolean linkToDeath(IHwBinder.DeathRecipient r1, long r2) throws RemoteException;

    @Override // android.hardware.soundtrigger.V2_1.ISoundTriggerHw, android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
    void notifySyspropsChanged() throws RemoteException;

    @Override // android.hardware.soundtrigger.V2_1.ISoundTriggerHw, android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
    void ping() throws RemoteException;

    @Override // android.hardware.soundtrigger.V2_1.ISoundTriggerHw, android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
    void setHALInstrumentation() throws RemoteException;

    @Override // android.hardware.soundtrigger.V2_1.ISoundTriggerHw, android.hardware.soundtrigger.V2_0.ISoundTriggerHw, android.hidl.base.V1_0.IBase
    boolean unlinkToDeath(IHwBinder.DeathRecipient r1) throws RemoteException;

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
