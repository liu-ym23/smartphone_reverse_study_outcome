package android.hardware.health.V2_1;

import android.hardware.health.V2_0.DiskStats;
import android.hardware.health.V2_0.StorageInfo;
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
import org.apache.commons.compress.archivers.tar.TarConstants;

/* JADX INFO: loaded from: classes.dex */
public interface IHealth extends android.hardware.health.V2_0.IHealth {
    public static final String kInterfaceName = "android.hardware.health@2.1::IHealth";

    public static final class Proxy implements IHealth {
        private IHwBinder mRemote;

        public Proxy(IHwBinder remote) {
            remote.getClass();
            this.mRemote = remote;
        }

        @Override // android.hardware.health.V2_1.IHealth, android.hardware.health.V2_0.IHealth, android.hidl.base.V1_0.IBase
        public IHwBinder asBinder() {
            return this.mRemote;
        }

        public String toString() {
            return interfaceDescriptor() + "@Proxy";
        L5:
            return "[class or subclass of android.hardware.health@2.1::IHealth]@Proxy";
        }

        public final boolean equals(Object other) {
            return HidlSupport.interfacesEqual(this, other);
        }

        public final int hashCode() {
            return asBinder().hashCode();
        }

        @Override // android.hardware.health.V2_0.IHealth
        public int registerCallback(android.hardware.health.V2_0.IHealthInfoCallback callback) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(android.hardware.health.V2_0.IHealth.kInterfaceName);
            if (callback != null) goto L5;
            IHwBinder r1 = null;
        L6:
            _hidl_request.writeStrongBinder(r1);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(1, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L10
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L10
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L10
            int _hidl_out_result = _hidl_reply.readInt32();     // Catch: Throwable -> L10
            _hidl_reply.release();
            return _hidl_out_result;
        L10:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        L5:
            r1 = callback.asBinder();
            goto L6
        }

        @Override // android.hardware.health.V2_0.IHealth
        public int unregisterCallback(android.hardware.health.V2_0.IHealthInfoCallback callback) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(android.hardware.health.V2_0.IHealth.kInterfaceName);
            if (callback != null) goto L5;
            IHwBinder r1 = null;
        L6:
            _hidl_request.writeStrongBinder(r1);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(2, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L10
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L10
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L10
            int _hidl_out_result = _hidl_reply.readInt32();     // Catch: Throwable -> L10
            _hidl_reply.release();
            return _hidl_out_result;
        L10:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        L5:
            r1 = callback.asBinder();
            goto L6
        }

        @Override // android.hardware.health.V2_0.IHealth
        public int update() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(android.hardware.health.V2_0.IHealth.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(3, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            int _hidl_out_result = _hidl_reply.readInt32();     // Catch: Throwable -> L6
            _hidl_reply.release();
            return _hidl_out_result;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hardware.health.V2_0.IHealth
        public void getChargeCounter(android.hardware.health.V2_0.IHealth.getChargeCounterCallback _hidl_cb) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(android.hardware.health.V2_0.IHealth.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(4, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            int _hidl_out_result = _hidl_reply.readInt32();     // Catch: Throwable -> L6
            int _hidl_out_value = _hidl_reply.readInt32();     // Catch: Throwable -> L6
            _hidl_cb.onValues(_hidl_out_result, _hidl_out_value);     // Catch: Throwable -> L6
            _hidl_reply.release();
            return;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hardware.health.V2_0.IHealth
        public void getCurrentNow(android.hardware.health.V2_0.IHealth.getCurrentNowCallback _hidl_cb) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(android.hardware.health.V2_0.IHealth.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(5, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            int _hidl_out_result = _hidl_reply.readInt32();     // Catch: Throwable -> L6
            int _hidl_out_value = _hidl_reply.readInt32();     // Catch: Throwable -> L6
            _hidl_cb.onValues(_hidl_out_result, _hidl_out_value);     // Catch: Throwable -> L6
            _hidl_reply.release();
            return;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hardware.health.V2_0.IHealth
        public void getCurrentAverage(android.hardware.health.V2_0.IHealth.getCurrentAverageCallback _hidl_cb) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(android.hardware.health.V2_0.IHealth.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(6, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            int _hidl_out_result = _hidl_reply.readInt32();     // Catch: Throwable -> L6
            int _hidl_out_value = _hidl_reply.readInt32();     // Catch: Throwable -> L6
            _hidl_cb.onValues(_hidl_out_result, _hidl_out_value);     // Catch: Throwable -> L6
            _hidl_reply.release();
            return;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hardware.health.V2_0.IHealth
        public void getCapacity(android.hardware.health.V2_0.IHealth.getCapacityCallback _hidl_cb) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(android.hardware.health.V2_0.IHealth.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(7, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            int _hidl_out_result = _hidl_reply.readInt32();     // Catch: Throwable -> L6
            int _hidl_out_value = _hidl_reply.readInt32();     // Catch: Throwable -> L6
            _hidl_cb.onValues(_hidl_out_result, _hidl_out_value);     // Catch: Throwable -> L6
            _hidl_reply.release();
            return;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hardware.health.V2_0.IHealth
        public void getEnergyCounter(android.hardware.health.V2_0.IHealth.getEnergyCounterCallback _hidl_cb) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(android.hardware.health.V2_0.IHealth.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(8, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            int _hidl_out_result = _hidl_reply.readInt32();     // Catch: Throwable -> L6
            long _hidl_out_value = _hidl_reply.readInt64();     // Catch: Throwable -> L6
            _hidl_cb.onValues(_hidl_out_result, _hidl_out_value);     // Catch: Throwable -> L6
            _hidl_reply.release();
            return;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hardware.health.V2_0.IHealth
        public void getChargeStatus(android.hardware.health.V2_0.IHealth.getChargeStatusCallback _hidl_cb) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(android.hardware.health.V2_0.IHealth.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(9, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            int _hidl_out_result = _hidl_reply.readInt32();     // Catch: Throwable -> L6
            int _hidl_out_value = _hidl_reply.readInt32();     // Catch: Throwable -> L6
            _hidl_cb.onValues(_hidl_out_result, _hidl_out_value);     // Catch: Throwable -> L6
            _hidl_reply.release();
            return;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hardware.health.V2_0.IHealth
        public void getStorageInfo(android.hardware.health.V2_0.IHealth.getStorageInfoCallback _hidl_cb) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(android.hardware.health.V2_0.IHealth.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(10, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            int _hidl_out_result = _hidl_reply.readInt32();     // Catch: Throwable -> L6
            ArrayList<StorageInfo> _hidl_out_value = StorageInfo.readVectorFromParcel(_hidl_reply);     // Catch: Throwable -> L6
            _hidl_cb.onValues(_hidl_out_result, _hidl_out_value);     // Catch: Throwable -> L6
            _hidl_reply.release();
            return;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hardware.health.V2_0.IHealth
        public void getDiskStats(android.hardware.health.V2_0.IHealth.getDiskStatsCallback _hidl_cb) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(android.hardware.health.V2_0.IHealth.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(11, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            int _hidl_out_result = _hidl_reply.readInt32();     // Catch: Throwable -> L6
            ArrayList<DiskStats> _hidl_out_value = DiskStats.readVectorFromParcel(_hidl_reply);     // Catch: Throwable -> L6
            _hidl_cb.onValues(_hidl_out_result, _hidl_out_value);     // Catch: Throwable -> L6
            _hidl_reply.release();
            return;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hardware.health.V2_0.IHealth
        public void getHealthInfo(android.hardware.health.V2_0.IHealth.getHealthInfoCallback _hidl_cb) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(android.hardware.health.V2_0.IHealth.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(12, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            int _hidl_out_result = _hidl_reply.readInt32();     // Catch: Throwable -> L6
            android.hardware.health.V2_0.HealthInfo _hidl_out_value = new android.hardware.health.V2_0.HealthInfo();     // Catch: Throwable -> L6
            _hidl_out_value.readFromParcel(_hidl_reply);     // Catch: Throwable -> L6
            _hidl_cb.onValues(_hidl_out_result, _hidl_out_value);     // Catch: Throwable -> L6
            _hidl_reply.release();
            return;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hardware.health.V2_1.IHealth
        public void getHealthConfig(getHealthConfigCallback _hidl_cb) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IHealth.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(13, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            int _hidl_out_result = _hidl_reply.readInt32();     // Catch: Throwable -> L6
            HealthConfig _hidl_out_config = new HealthConfig();     // Catch: Throwable -> L6
            _hidl_out_config.readFromParcel(_hidl_reply);     // Catch: Throwable -> L6
            _hidl_cb.onValues(_hidl_out_result, _hidl_out_config);     // Catch: Throwable -> L6
            _hidl_reply.release();
            return;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hardware.health.V2_1.IHealth
        public void getHealthInfo_2_1(getHealthInfo_2_1Callback _hidl_cb) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IHealth.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(14, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            int _hidl_out_result = _hidl_reply.readInt32();     // Catch: Throwable -> L6
            HealthInfo _hidl_out_value = new HealthInfo();     // Catch: Throwable -> L6
            _hidl_out_value.readFromParcel(_hidl_reply);     // Catch: Throwable -> L6
            _hidl_cb.onValues(_hidl_out_result, _hidl_out_value);     // Catch: Throwable -> L6
            _hidl_reply.release();
            return;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hardware.health.V2_1.IHealth
        public void shouldKeepScreenOn(shouldKeepScreenOnCallback _hidl_cb) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IHealth.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(15, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            int _hidl_out_result = _hidl_reply.readInt32();     // Catch: Throwable -> L6
            boolean _hidl_out_value = _hidl_reply.readBool();     // Catch: Throwable -> L6
            _hidl_cb.onValues(_hidl_out_result, _hidl_out_value);     // Catch: Throwable -> L6
            _hidl_reply.release();
            return;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hardware.health.V2_1.IHealth, android.hardware.health.V2_0.IHealth, android.hidl.base.V1_0.IBase
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

        @Override // android.hardware.health.V2_1.IHealth, android.hardware.health.V2_0.IHealth, android.hidl.base.V1_0.IBase
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

        @Override // android.hardware.health.V2_1.IHealth, android.hardware.health.V2_0.IHealth, android.hidl.base.V1_0.IBase
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

        @Override // android.hardware.health.V2_1.IHealth, android.hardware.health.V2_0.IHealth, android.hidl.base.V1_0.IBase
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

        @Override // android.hardware.health.V2_1.IHealth, android.hardware.health.V2_0.IHealth, android.hidl.base.V1_0.IBase
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

        @Override // android.hardware.health.V2_1.IHealth, android.hardware.health.V2_0.IHealth, android.hidl.base.V1_0.IBase
        public boolean linkToDeath(IHwBinder.DeathRecipient recipient, long cookie) throws RemoteException {
            return this.mRemote.linkToDeath(recipient, cookie);
        }

        @Override // android.hardware.health.V2_1.IHealth, android.hardware.health.V2_0.IHealth, android.hidl.base.V1_0.IBase
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

        @Override // android.hardware.health.V2_1.IHealth, android.hardware.health.V2_0.IHealth, android.hidl.base.V1_0.IBase
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

        @Override // android.hardware.health.V2_1.IHealth, android.hardware.health.V2_0.IHealth, android.hidl.base.V1_0.IBase
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

        @Override // android.hardware.health.V2_1.IHealth, android.hardware.health.V2_0.IHealth, android.hidl.base.V1_0.IBase
        public boolean unlinkToDeath(IHwBinder.DeathRecipient recipient) throws RemoteException {
            return this.mRemote.unlinkToDeath(recipient);
        }
    }

    public static abstract class Stub extends HwBinder implements IHealth {
        public Stub() {
        }

        @Override // android.hardware.health.V2_1.IHealth, android.hardware.health.V2_0.IHealth, android.hidl.base.V1_0.IBase
        public IHwBinder asBinder() {
            return this;
        }

        @Override // android.hardware.health.V2_1.IHealth, android.hardware.health.V2_0.IHealth, android.hidl.base.V1_0.IBase
        public final ArrayList<String> interfaceChain() {
            return new ArrayList(Arrays.asList(new String[]{IHealth.kInterfaceName, android.hardware.health.V2_0.IHealth.kInterfaceName, IBase.kInterfaceName}));
        }

        @Override // android.hardware.health.V2_1.IHealth, android.hardware.health.V2_0.IHealth, android.hidl.base.V1_0.IBase
        public void debug(NativeHandle fd, ArrayList<String> options) {
        }

        @Override // android.hardware.health.V2_1.IHealth, android.hardware.health.V2_0.IHealth, android.hidl.base.V1_0.IBase
        public final String interfaceDescriptor() {
            return IHealth.kInterfaceName;
        }

        @Override // android.hardware.health.V2_1.IHealth, android.hardware.health.V2_0.IHealth, android.hidl.base.V1_0.IBase
        public final ArrayList<byte[]> getHashChain() {
            return new ArrayList(Arrays.asList(new byte[][]{new byte[]{-50, -115, -66, 118, -21, -98, -23, 75, ParameterName.COLOR_TUNER_SATURATION_YELLOW, -17, -104, -9, 37, -66, -103, ParameterName.LOW_BLUE_LIGHT, 118, 10, ParameterName.AUTO_VOLUME_CONTROL, ParameterName.TREBLE, 7, ParameterName.COLOR_TUNER_HUE_CYAN, ParameterName.BALANCE, ParameterName.COLOR_TUNER_LUMINANCE_GREEN, ParameterName.DYNAMIC_LUMA_CONTROL, ParameterName.COLOR_TUNER_LUMINANCE_RED, ParameterName.COLOR_TUNER_HUE_FLESH, ParameterName.COLOR_TEMPERATURE_GREEN_GAIN, ParameterName.SPEAKERS_ENABLED, ParameterName.FILM_MODE, 113, -13}, new byte[]{TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, ParameterName.ENHANCED_AUDIO_RETURN_CHANNEL_ENABLED, UsbASFormat.EXT_FORMAT_TYPE_II, -35, 48, 7, -128, ParameterName.DTS_VIRTUAL_X, -104, ParameterName.DIGITAL_OUTPUT_DELAY_MS, -86, -20, -111, 97, 42, -68, -120, -12, -62, ParameterName.DOLBY_DIALOGUE_ENHANCER, 52, 49, -5, -124, 7, 11, 117, -124, -95, -89, ParameterName.COLOR_TUNER_SATURATION_RED, -5}, new byte[]{-20, 127, -41, -98, -48, ParameterName.ELEVEN_POINT_BLUE, -6, -123, -68, ParameterName.COLOR_TUNER_LUMINANCE_GREEN, -108, ParameterName.COLOR_TEMPERATURE_GREEN_GAIN, -83, -82, ParameterName.COLOR_TUNER_HUE_MAGENTA, -66, 35, -17, 5, 36, -13, -51, 105, ParameterName.AUTO_VOLUME_CONTROL, ParameterName.FILM_MODE, -109, 36, -72, ParameterName.COLOR_TUNER_HUE_GREEN, ParameterName.GLOBE_DIMMING, -54, 76}}));
        }

        @Override // android.hardware.health.V2_1.IHealth, android.hardware.health.V2_0.IHealth, android.hidl.base.V1_0.IBase
        public final void setHALInstrumentation() {
        }

        @Override // android.hardware.health.V2_1.IHealth, android.hardware.health.V2_0.IHealth, android.hidl.base.V1_0.IBase
        public final boolean linkToDeath(IHwBinder.DeathRecipient recipient, long cookie) {
            return true;
        }

        @Override // android.hardware.health.V2_1.IHealth, android.hardware.health.V2_0.IHealth, android.hidl.base.V1_0.IBase
        public final void ping() {
        }

        @Override // android.hardware.health.V2_1.IHealth, android.hardware.health.V2_0.IHealth, android.hidl.base.V1_0.IBase
        public final DebugInfo getDebugInfo() {
            DebugInfo info = new DebugInfo();
            info.pid = HidlSupport.getPidIfSharable();
            info.ptr = 0;
            info.arch = 0;
            return info;
        }

        @Override // android.hardware.health.V2_1.IHealth, android.hardware.health.V2_0.IHealth, android.hidl.base.V1_0.IBase
        public final void notifySyspropsChanged() {
            HwBinder.enableInstrumentation();
        }

        @Override // android.hardware.health.V2_1.IHealth, android.hardware.health.V2_0.IHealth, android.hidl.base.V1_0.IBase
        public final boolean unlinkToDeath(IHwBinder.DeathRecipient recipient) {
            return true;
        }

        public IHwInterface queryLocalInterface(String descriptor) {
            if (IHealth.kInterfaceName.equals(descriptor) == false) goto L5;
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
                case 1: goto L37;
                case 2: goto L36;
                case 3: goto L35;
                case 4: goto L34;
                case 5: goto L33;
                case 6: goto L32;
                case 7: goto L31;
                case 8: goto L30;
                case 9: goto L29;
                case 10: goto L28;
                case 11: goto L27;
                case 12: goto L26;
                case 13: goto L25;
                case 14: goto L24;
                case 15: goto L23;
                case 256067662: goto L22;
                case 256131655: goto L21;
                case 256136003: goto L20;
                case 256398152: goto L10;
                case 256462420: goto L9;
                case 256660548: goto L64;
                case 256921159: goto L7;
                case 257049926: goto L6;
                case 257120595: goto L5;
                default: goto L64;
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
            _hidl_request.enforceInterface(IHealth.kInterfaceName);
            shouldKeepScreenOn(new AnonymousClass12(this, _hidl_reply));
            return;
        L24:
            _hidl_request.enforceInterface(IHealth.kInterfaceName);
            getHealthInfo_2_1(new AnonymousClass11(this, _hidl_reply));
            return;
        L25:
            _hidl_request.enforceInterface(IHealth.kInterfaceName);
            getHealthConfig(new AnonymousClass10(this, _hidl_reply));
            return;
        L26:
            _hidl_request.enforceInterface(android.hardware.health.V2_0.IHealth.kInterfaceName);
            getHealthInfo(new AnonymousClass9(this, _hidl_reply));
            return;
        L27:
            _hidl_request.enforceInterface(android.hardware.health.V2_0.IHealth.kInterfaceName);
            getDiskStats(new AnonymousClass8(this, _hidl_reply));
            return;
        L28:
            _hidl_request.enforceInterface(android.hardware.health.V2_0.IHealth.kInterfaceName);
            getStorageInfo(new AnonymousClass7(this, _hidl_reply));
            return;
        L29:
            _hidl_request.enforceInterface(android.hardware.health.V2_0.IHealth.kInterfaceName);
            getChargeStatus(new AnonymousClass6(this, _hidl_reply));
            return;
        L30:
            _hidl_request.enforceInterface(android.hardware.health.V2_0.IHealth.kInterfaceName);
            getEnergyCounter(new AnonymousClass5(this, _hidl_reply));
            return;
        L31:
            _hidl_request.enforceInterface(android.hardware.health.V2_0.IHealth.kInterfaceName);
            getCapacity(new AnonymousClass4(this, _hidl_reply));
            return;
        L32:
            _hidl_request.enforceInterface(android.hardware.health.V2_0.IHealth.kInterfaceName);
            getCurrentAverage(new AnonymousClass3(this, _hidl_reply));
            return;
        L33:
            _hidl_request.enforceInterface(android.hardware.health.V2_0.IHealth.kInterfaceName);
            getCurrentNow(new AnonymousClass2(this, _hidl_reply));
            return;
        L34:
            _hidl_request.enforceInterface(android.hardware.health.V2_0.IHealth.kInterfaceName);
            getChargeCounter(new AnonymousClass1(this, _hidl_reply));
            return;
        L35:
            _hidl_request.enforceInterface(android.hardware.health.V2_0.IHealth.kInterfaceName);
            int _hidl_out_result = update();
            _hidl_reply.writeStatus(0);
            _hidl_reply.writeInt32(_hidl_out_result);
            _hidl_reply.send();
            return;
        L36:
            _hidl_request.enforceInterface(android.hardware.health.V2_0.IHealth.kInterfaceName);
            android.hardware.health.V2_0.IHealthInfoCallback callback = android.hardware.health.V2_0.IHealthInfoCallback.asInterface(_hidl_request.readStrongBinder());
            int _hidl_out_result2 = unregisterCallback(callback);
            _hidl_reply.writeStatus(0);
            _hidl_reply.writeInt32(_hidl_out_result2);
            _hidl_reply.send();
            return;
        L37:
            _hidl_request.enforceInterface(android.hardware.health.V2_0.IHealth.kInterfaceName);
            android.hardware.health.V2_0.IHealthInfoCallback callback2 = android.hardware.health.V2_0.IHealthInfoCallback.asInterface(_hidl_request.readStrongBinder());
            int _hidl_out_result3 = registerCallback(callback2);
            _hidl_reply.writeStatus(0);
            _hidl_reply.writeInt32(_hidl_out_result3);
            _hidl_reply.send();
            return;
        }
    }

    @FunctionalInterface
    public interface getHealthConfigCallback {
        void onValues(int r1, HealthConfig r2);
    }

    @FunctionalInterface
    public interface getHealthInfo_2_1Callback {
        void onValues(int r1, HealthInfo r2);
    }

    @FunctionalInterface
    public interface shouldKeepScreenOnCallback {
        void onValues(int r1, boolean r2);
    }

    @Override // android.hardware.health.V2_0.IHealth, android.hidl.base.V1_0.IBase
    IHwBinder asBinder();

    @Override // android.hardware.health.V2_0.IHealth, android.hidl.base.V1_0.IBase
    void debug(NativeHandle r1, ArrayList<String> r2) throws RemoteException;

    @Override // android.hardware.health.V2_0.IHealth, android.hidl.base.V1_0.IBase
    DebugInfo getDebugInfo() throws RemoteException;

    @Override // android.hardware.health.V2_0.IHealth, android.hidl.base.V1_0.IBase
    ArrayList<byte[]> getHashChain() throws RemoteException;

    void getHealthConfig(getHealthConfigCallback r1) throws RemoteException;

    void getHealthInfo_2_1(getHealthInfo_2_1Callback r1) throws RemoteException;

    @Override // android.hardware.health.V2_0.IHealth, android.hidl.base.V1_0.IBase
    ArrayList<String> interfaceChain() throws RemoteException;

    @Override // android.hardware.health.V2_0.IHealth, android.hidl.base.V1_0.IBase
    String interfaceDescriptor() throws RemoteException;

    @Override // android.hardware.health.V2_0.IHealth, android.hidl.base.V1_0.IBase
    boolean linkToDeath(IHwBinder.DeathRecipient r1, long r2) throws RemoteException;

    @Override // android.hardware.health.V2_0.IHealth, android.hidl.base.V1_0.IBase
    void notifySyspropsChanged() throws RemoteException;

    @Override // android.hardware.health.V2_0.IHealth, android.hidl.base.V1_0.IBase
    void ping() throws RemoteException;

    @Override // android.hardware.health.V2_0.IHealth, android.hidl.base.V1_0.IBase
    void setHALInstrumentation() throws RemoteException;

    void shouldKeepScreenOn(shouldKeepScreenOnCallback r1) throws RemoteException;

    @Override // android.hardware.health.V2_0.IHealth, android.hidl.base.V1_0.IBase
    boolean unlinkToDeath(IHwBinder.DeathRecipient r1) throws RemoteException;

    static IHealth asInterface(IHwBinder binder) {
        if (binder != null) goto L5;
        return null;
    L5:
        IHwInterface iface = binder.queryLocalInterface(kInterfaceName);
        if (iface != null) goto L8;
    L11:
        IHealth proxy = new Proxy(binder);
        Iterator<String> r4 = proxy.interfaceChain().iterator();     // Catch: RemoteException -> L19
    L14:
        if (r4.hasNext() == false) goto L22;
        String descriptor = r4.next();     // Catch: RemoteException -> L19
        if (descriptor.equals(kInterfaceName) == false) goto L14;
        return proxy;
    L22:
        return null;
    L8:
        if ((iface instanceof IHealth) == false) goto L11;
        return (IHealth) iface;
    }

    static IHealth castFrom(IHwInterface iface) {
        if (iface != null) goto L5;
        return null;
    L5:
        return asInterface(iface.asBinder());
    }

    static IHealth getService(String serviceName, boolean retry) throws RemoteException {
        return asInterface(HwBinder.getService(kInterfaceName, serviceName, retry));
    }

    static IHealth getService(boolean retry) throws RemoteException {
        return getService("default", retry);
    }

    @Deprecated
    static IHealth getService(String serviceName) throws RemoteException {
        return asInterface(HwBinder.getService(kInterfaceName, serviceName));
    }

    @Deprecated
    static IHealth getService() throws RemoteException {
        return getService("default");
    }
}
