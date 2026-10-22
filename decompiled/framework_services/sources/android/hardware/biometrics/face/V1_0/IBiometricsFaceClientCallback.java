package android.hardware.biometrics.face.V1_0;

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

/* JADX INFO: loaded from: classes.dex */
public interface IBiometricsFaceClientCallback extends IBase {
    public static final String kInterfaceName = "android.hardware.biometrics.face@1.0::IBiometricsFaceClientCallback";

    public static final class Proxy implements IBiometricsFaceClientCallback {
        private IHwBinder mRemote;

        public Proxy(IHwBinder remote) {
            remote.getClass();
            this.mRemote = remote;
        }

        @Override // android.hardware.biometrics.face.V1_0.IBiometricsFaceClientCallback, android.hidl.base.V1_0.IBase
        public IHwBinder asBinder() {
            return this.mRemote;
        }

        public String toString() {
            return interfaceDescriptor() + "@Proxy";
        L5:
            return "[class or subclass of android.hardware.biometrics.face@1.0::IBiometricsFaceClientCallback]@Proxy";
        }

        public final boolean equals(Object other) {
            return HidlSupport.interfacesEqual(this, other);
        }

        public final int hashCode() {
            return asBinder().hashCode();
        }

        @Override // android.hardware.biometrics.face.V1_0.IBiometricsFaceClientCallback
        public void onEnrollResult(long deviceId, int faceId, int userId, int remaining) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IBiometricsFaceClientCallback.kInterfaceName);
            _hidl_request.writeInt64(deviceId);
            _hidl_request.writeInt32(faceId);
            _hidl_request.writeInt32(userId);
            _hidl_request.writeInt32(remaining);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(1, _hidl_request, _hidl_reply, 1);     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            _hidl_reply.release();
            return;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hardware.biometrics.face.V1_0.IBiometricsFaceClientCallback
        public void onAuthenticated(long deviceId, int faceId, int userId, ArrayList<Byte> token) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IBiometricsFaceClientCallback.kInterfaceName);
            _hidl_request.writeInt64(deviceId);
            _hidl_request.writeInt32(faceId);
            _hidl_request.writeInt32(userId);
            _hidl_request.writeInt8Vector(token);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(2, _hidl_request, _hidl_reply, 1);     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            _hidl_reply.release();
            return;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hardware.biometrics.face.V1_0.IBiometricsFaceClientCallback
        public void onAcquired(long deviceId, int userId, int acquiredInfo, int vendorCode) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IBiometricsFaceClientCallback.kInterfaceName);
            _hidl_request.writeInt64(deviceId);
            _hidl_request.writeInt32(userId);
            _hidl_request.writeInt32(acquiredInfo);
            _hidl_request.writeInt32(vendorCode);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(3, _hidl_request, _hidl_reply, 1);     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            _hidl_reply.release();
            return;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hardware.biometrics.face.V1_0.IBiometricsFaceClientCallback
        public void onError(long deviceId, int userId, int error, int vendorCode) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IBiometricsFaceClientCallback.kInterfaceName);
            _hidl_request.writeInt64(deviceId);
            _hidl_request.writeInt32(userId);
            _hidl_request.writeInt32(error);
            _hidl_request.writeInt32(vendorCode);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(4, _hidl_request, _hidl_reply, 1);     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            _hidl_reply.release();
            return;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hardware.biometrics.face.V1_0.IBiometricsFaceClientCallback
        public void onRemoved(long deviceId, ArrayList<Integer> removed, int userId) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IBiometricsFaceClientCallback.kInterfaceName);
            _hidl_request.writeInt64(deviceId);
            _hidl_request.writeInt32Vector(removed);
            _hidl_request.writeInt32(userId);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(5, _hidl_request, _hidl_reply, 1);     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            _hidl_reply.release();
            return;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hardware.biometrics.face.V1_0.IBiometricsFaceClientCallback
        public void onEnumerate(long deviceId, ArrayList<Integer> faceIds, int userId) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IBiometricsFaceClientCallback.kInterfaceName);
            _hidl_request.writeInt64(deviceId);
            _hidl_request.writeInt32Vector(faceIds);
            _hidl_request.writeInt32(userId);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(6, _hidl_request, _hidl_reply, 1);     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            _hidl_reply.release();
            return;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hardware.biometrics.face.V1_0.IBiometricsFaceClientCallback
        public void onLockoutChanged(long duration) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IBiometricsFaceClientCallback.kInterfaceName);
            _hidl_request.writeInt64(duration);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(7, _hidl_request, _hidl_reply, 1);     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            _hidl_reply.release();
            return;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hardware.biometrics.face.V1_0.IBiometricsFaceClientCallback, android.hidl.base.V1_0.IBase
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

        @Override // android.hardware.biometrics.face.V1_0.IBiometricsFaceClientCallback, android.hidl.base.V1_0.IBase
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

        @Override // android.hardware.biometrics.face.V1_0.IBiometricsFaceClientCallback, android.hidl.base.V1_0.IBase
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

        @Override // android.hardware.biometrics.face.V1_0.IBiometricsFaceClientCallback, android.hidl.base.V1_0.IBase
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

        @Override // android.hardware.biometrics.face.V1_0.IBiometricsFaceClientCallback, android.hidl.base.V1_0.IBase
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

        @Override // android.hardware.biometrics.face.V1_0.IBiometricsFaceClientCallback, android.hidl.base.V1_0.IBase
        public boolean linkToDeath(IHwBinder.DeathRecipient recipient, long cookie) throws RemoteException {
            return this.mRemote.linkToDeath(recipient, cookie);
        }

        @Override // android.hardware.biometrics.face.V1_0.IBiometricsFaceClientCallback, android.hidl.base.V1_0.IBase
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

        @Override // android.hardware.biometrics.face.V1_0.IBiometricsFaceClientCallback, android.hidl.base.V1_0.IBase
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

        @Override // android.hardware.biometrics.face.V1_0.IBiometricsFaceClientCallback, android.hidl.base.V1_0.IBase
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

        @Override // android.hardware.biometrics.face.V1_0.IBiometricsFaceClientCallback, android.hidl.base.V1_0.IBase
        public boolean unlinkToDeath(IHwBinder.DeathRecipient recipient) throws RemoteException {
            return this.mRemote.unlinkToDeath(recipient);
        }
    }

    public static abstract class Stub extends HwBinder implements IBiometricsFaceClientCallback {
        public Stub() {
        }

        @Override // android.hardware.biometrics.face.V1_0.IBiometricsFaceClientCallback, android.hidl.base.V1_0.IBase
        public IHwBinder asBinder() {
            return this;
        }

        @Override // android.hardware.biometrics.face.V1_0.IBiometricsFaceClientCallback, android.hidl.base.V1_0.IBase
        public final ArrayList<String> interfaceChain() {
            return new ArrayList(Arrays.asList(new String[]{IBiometricsFaceClientCallback.kInterfaceName, IBase.kInterfaceName}));
        }

        @Override // android.hardware.biometrics.face.V1_0.IBiometricsFaceClientCallback, android.hidl.base.V1_0.IBase
        public void debug(NativeHandle fd, ArrayList<String> options) {
        }

        @Override // android.hardware.biometrics.face.V1_0.IBiometricsFaceClientCallback, android.hidl.base.V1_0.IBase
        public final String interfaceDescriptor() {
            return IBiometricsFaceClientCallback.kInterfaceName;
        }

        @Override // android.hardware.biometrics.face.V1_0.IBiometricsFaceClientCallback, android.hidl.base.V1_0.IBase
        public final ArrayList<byte[]> getHashChain() {
            return new ArrayList(Arrays.asList(new byte[][]{new byte[]{-74, -27, ParameterName.DIGITAL_OUTPUT, 119, -107, -69, -81, -48, ParameterName.DE_CONTOUR, -5, -107, -93, -74, -45, -107, 75, -10, 108, 52, -98, ParameterName.BLACK_STRETCH, -49, 16, 127, ParameterName.COLOR_TUNER_HUE_GREEN, 114, 3, ParameterName.ELEVEN_POINT_GREEN, -29, -50, -76, ParameterName.COLOR_TUNER_LUMINANCE_RED}, new byte[]{-20, 127, -41, -98, -48, ParameterName.ELEVEN_POINT_BLUE, -6, -123, -68, ParameterName.COLOR_TUNER_LUMINANCE_GREEN, -108, ParameterName.COLOR_TEMPERATURE_GREEN_GAIN, -83, -82, ParameterName.COLOR_TUNER_HUE_MAGENTA, -66, 35, -17, 5, 36, -13, -51, 105, ParameterName.AUTO_VOLUME_CONTROL, ParameterName.FILM_MODE, -109, 36, -72, ParameterName.COLOR_TUNER_HUE_GREEN, ParameterName.GLOBE_DIMMING, -54, 76}}));
        }

        @Override // android.hardware.biometrics.face.V1_0.IBiometricsFaceClientCallback, android.hidl.base.V1_0.IBase
        public final void setHALInstrumentation() {
        }

        @Override // android.hardware.biometrics.face.V1_0.IBiometricsFaceClientCallback, android.hidl.base.V1_0.IBase
        public final boolean linkToDeath(IHwBinder.DeathRecipient recipient, long cookie) {
            return true;
        }

        @Override // android.hardware.biometrics.face.V1_0.IBiometricsFaceClientCallback, android.hidl.base.V1_0.IBase
        public final void ping() {
        }

        @Override // android.hardware.biometrics.face.V1_0.IBiometricsFaceClientCallback, android.hidl.base.V1_0.IBase
        public final DebugInfo getDebugInfo() {
            DebugInfo info = new DebugInfo();
            info.pid = HidlSupport.getPidIfSharable();
            info.ptr = 0;
            info.arch = 0;
            return info;
        }

        @Override // android.hardware.biometrics.face.V1_0.IBiometricsFaceClientCallback, android.hidl.base.V1_0.IBase
        public final void notifySyspropsChanged() {
            HwBinder.enableInstrumentation();
        }

        @Override // android.hardware.biometrics.face.V1_0.IBiometricsFaceClientCallback, android.hidl.base.V1_0.IBase
        public final boolean unlinkToDeath(IHwBinder.DeathRecipient recipient) {
            return true;
        }

        public IHwInterface queryLocalInterface(String descriptor) {
            if (IBiometricsFaceClientCallback.kInterfaceName.equals(descriptor) == false) goto L5;
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
            _hidl_request.enforceInterface(IBiometricsFaceClientCallback.kInterfaceName);
            long duration = _hidl_request.readInt64();
            onLockoutChanged(duration);
            return;
        L24:
            _hidl_request.enforceInterface(IBiometricsFaceClientCallback.kInterfaceName);
            long deviceId = _hidl_request.readInt64();
            ArrayList<Integer> faceIds = _hidl_request.readInt32Vector();
            int userId = _hidl_request.readInt32();
            onEnumerate(deviceId, faceIds, userId);
            return;
        L25:
            _hidl_request.enforceInterface(IBiometricsFaceClientCallback.kInterfaceName);
            long deviceId2 = _hidl_request.readInt64();
            ArrayList<Integer> removed = _hidl_request.readInt32Vector();
            int userId2 = _hidl_request.readInt32();
            onRemoved(deviceId2, removed, userId2);
            return;
        L26:
            _hidl_request.enforceInterface(IBiometricsFaceClientCallback.kInterfaceName);
            long deviceId3 = _hidl_request.readInt64();
            int userId3 = _hidl_request.readInt32();
            int error = _hidl_request.readInt32();
            int vendorCode = _hidl_request.readInt32();
            onError(deviceId3, userId3, error, vendorCode);
            return;
        L27:
            _hidl_request.enforceInterface(IBiometricsFaceClientCallback.kInterfaceName);
            long deviceId4 = _hidl_request.readInt64();
            int userId4 = _hidl_request.readInt32();
            int acquiredInfo = _hidl_request.readInt32();
            int vendorCode2 = _hidl_request.readInt32();
            onAcquired(deviceId4, userId4, acquiredInfo, vendorCode2);
            return;
        L28:
            _hidl_request.enforceInterface(IBiometricsFaceClientCallback.kInterfaceName);
            long deviceId5 = _hidl_request.readInt64();
            int faceId = _hidl_request.readInt32();
            int userId5 = _hidl_request.readInt32();
            ArrayList<Byte> token = _hidl_request.readInt8Vector();
            onAuthenticated(deviceId5, faceId, userId5, token);
            return;
        L29:
            _hidl_request.enforceInterface(IBiometricsFaceClientCallback.kInterfaceName);
            long deviceId6 = _hidl_request.readInt64();
            int faceId2 = _hidl_request.readInt32();
            int userId6 = _hidl_request.readInt32();
            int remaining = _hidl_request.readInt32();
            onEnrollResult(deviceId6, faceId2, userId6, remaining);
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

    void onAcquired(long r1, int r3, int r4, int r5) throws RemoteException;

    void onAuthenticated(long r1, int r3, int r4, ArrayList<Byte> r5) throws RemoteException;

    void onEnrollResult(long r1, int r3, int r4, int r5) throws RemoteException;

    void onEnumerate(long r1, ArrayList<Integer> r3, int r4) throws RemoteException;

    void onError(long r1, int r3, int r4, int r5) throws RemoteException;

    void onLockoutChanged(long r1) throws RemoteException;

    void onRemoved(long r1, ArrayList<Integer> r3, int r4) throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    void ping() throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    void setHALInstrumentation() throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    boolean unlinkToDeath(IHwBinder.DeathRecipient r1) throws RemoteException;

    static IBiometricsFaceClientCallback asInterface(IHwBinder binder) {
        if (binder != null) goto L5;
        return null;
    L5:
        IHwInterface iface = binder.queryLocalInterface(kInterfaceName);
        if (iface != null) goto L8;
    L11:
        IBiometricsFaceClientCallback proxy = new Proxy(binder);
        Iterator<String> r4 = proxy.interfaceChain().iterator();     // Catch: RemoteException -> L19
    L14:
        if (r4.hasNext() == false) goto L22;
        String descriptor = r4.next();     // Catch: RemoteException -> L19
        if (descriptor.equals(kInterfaceName) == false) goto L14;
        return proxy;
    L22:
        return null;
    L8:
        if ((iface instanceof IBiometricsFaceClientCallback) == false) goto L11;
        return (IBiometricsFaceClientCallback) iface;
    }

    static IBiometricsFaceClientCallback castFrom(IHwInterface iface) {
        if (iface != null) goto L5;
        return null;
    L5:
        return asInterface(iface.asBinder());
    }

    static IBiometricsFaceClientCallback getService(String serviceName, boolean retry) throws RemoteException {
        return asInterface(HwBinder.getService(kInterfaceName, serviceName, retry));
    }

    static IBiometricsFaceClientCallback getService(boolean retry) throws RemoteException {
        return getService("default", retry);
    }

    @Deprecated
    static IBiometricsFaceClientCallback getService(String serviceName) throws RemoteException {
        return asInterface(HwBinder.getService(kInterfaceName, serviceName));
    }

    @Deprecated
    static IBiometricsFaceClientCallback getService() throws RemoteException {
        return getService("default");
    }
}
