package vendor.qti.hardware.servicetracker.V1_2;

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
import vendor.qti.hardware.servicetracker.V1_0.ClientConnection;
import vendor.qti.hardware.servicetracker.V1_0.ClientData;
import vendor.qti.hardware.servicetracker.V1_0.ClientRecord;
import vendor.qti.hardware.servicetracker.V1_0.ServiceConnection;
import vendor.qti.hardware.servicetracker.V1_0.ServiceData;
import vendor.qti.hardware.servicetracker.V1_0.ServiceRecord;

/* JADX INFO: loaded from: classes.dex */
public interface IServicetracker extends vendor.qti.hardware.servicetracker.V1_1.IServicetracker {
    public static final String kInterfaceName = "vendor.qti.hardware.servicetracker@1.2::IServicetracker";

    public static final class Proxy implements IServicetracker {
        private IHwBinder mRemote;

        public Proxy(IHwBinder remote) {
            remote.getClass();
            this.mRemote = remote;
        }

        @Override // vendor.qti.hardware.servicetracker.V1_2.IServicetracker, vendor.qti.hardware.servicetracker.V1_1.IServicetracker, vendor.qti.hardware.servicetracker.V1_0.IServicetracker, android.hidl.base.V1_0.IBase
        public IHwBinder asBinder() {
            return this.mRemote;
        }

        public String toString() {
            return interfaceDescriptor() + "@Proxy";
        L5:
            return "[class or subclass of vendor.qti.hardware.servicetracker@1.2::IServicetracker]@Proxy";
        }

        public final boolean equals(Object other) {
            return HidlSupport.interfacesEqual(this, other);
        }

        public final int hashCode() {
            return asBinder().hashCode();
        }

        @Override // vendor.qti.hardware.servicetracker.V1_0.IServicetracker
        public void startService(ServiceData serviceData) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(vendor.qti.hardware.servicetracker.V1_0.IServicetracker.kInterfaceName);
            serviceData.writeToParcel(_hidl_request);
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

        @Override // vendor.qti.hardware.servicetracker.V1_0.IServicetracker
        public void bindService(ServiceData serviceData, ClientData clientData) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(vendor.qti.hardware.servicetracker.V1_0.IServicetracker.kInterfaceName);
            serviceData.writeToParcel(_hidl_request);
            clientData.writeToParcel(_hidl_request);
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

        @Override // vendor.qti.hardware.servicetracker.V1_0.IServicetracker
        public void unbindService(ServiceData serviceData, ClientData clientData) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(vendor.qti.hardware.servicetracker.V1_0.IServicetracker.kInterfaceName);
            serviceData.writeToParcel(_hidl_request);
            clientData.writeToParcel(_hidl_request);
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

        @Override // vendor.qti.hardware.servicetracker.V1_0.IServicetracker
        public void destroyService(ServiceData serviceData) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(vendor.qti.hardware.servicetracker.V1_0.IServicetracker.kInterfaceName);
            serviceData.writeToParcel(_hidl_request);
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

        @Override // vendor.qti.hardware.servicetracker.V1_0.IServicetracker
        public void killProcess(int pid) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(vendor.qti.hardware.servicetracker.V1_0.IServicetracker.kInterfaceName);
            _hidl_request.writeInt32(pid);
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

        @Override // vendor.qti.hardware.servicetracker.V1_0.IServicetracker
        public void getclientInfo(String clientName, vendor.qti.hardware.servicetracker.V1_0.IServicetracker.getclientInfoCallback _hidl_cb) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(vendor.qti.hardware.servicetracker.V1_0.IServicetracker.kInterfaceName);
            _hidl_request.writeString(clientName);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(6, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            int _hidl_out_status = _hidl_reply.readInt32();     // Catch: Throwable -> L6
            ClientRecord _hidl_out_client = new ClientRecord();     // Catch: Throwable -> L6
            _hidl_out_client.readFromParcel(_hidl_reply);     // Catch: Throwable -> L6
            _hidl_cb.onValues(_hidl_out_status, _hidl_out_client);     // Catch: Throwable -> L6
            _hidl_reply.release();
            return;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // vendor.qti.hardware.servicetracker.V1_0.IServicetracker
        public void getserviceInfo(String serviceName, vendor.qti.hardware.servicetracker.V1_0.IServicetracker.getserviceInfoCallback _hidl_cb) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(vendor.qti.hardware.servicetracker.V1_0.IServicetracker.kInterfaceName);
            _hidl_request.writeString(serviceName);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(7, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            int _hidl_out_status = _hidl_reply.readInt32();     // Catch: Throwable -> L6
            ServiceRecord _hidl_out_service = new ServiceRecord();     // Catch: Throwable -> L6
            _hidl_out_service.readFromParcel(_hidl_reply);     // Catch: Throwable -> L6
            _hidl_cb.onValues(_hidl_out_status, _hidl_out_service);     // Catch: Throwable -> L6
            _hidl_reply.release();
            return;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // vendor.qti.hardware.servicetracker.V1_0.IServicetracker
        public void getServiceConnections(String serviceName, vendor.qti.hardware.servicetracker.V1_0.IServicetracker.getServiceConnectionsCallback _hidl_cb) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(vendor.qti.hardware.servicetracker.V1_0.IServicetracker.kInterfaceName);
            _hidl_request.writeString(serviceName);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(8, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            int _hidl_out_status = _hidl_reply.readInt32();     // Catch: Throwable -> L6
            ArrayList<ServiceConnection> _hidl_out_conn = ServiceConnection.readVectorFromParcel(_hidl_reply);     // Catch: Throwable -> L6
            _hidl_cb.onValues(_hidl_out_status, _hidl_out_conn);     // Catch: Throwable -> L6
            _hidl_reply.release();
            return;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // vendor.qti.hardware.servicetracker.V1_0.IServicetracker
        public void getClientConnections(String clientName, vendor.qti.hardware.servicetracker.V1_0.IServicetracker.getClientConnectionsCallback _hidl_cb) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(vendor.qti.hardware.servicetracker.V1_0.IServicetracker.kInterfaceName);
            _hidl_request.writeString(clientName);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(9, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            int _hidl_out_status = _hidl_reply.readInt32();     // Catch: Throwable -> L6
            ArrayList<ClientConnection> _hidl_out_conn = ClientConnection.readVectorFromParcel(_hidl_reply);     // Catch: Throwable -> L6
            _hidl_cb.onValues(_hidl_out_status, _hidl_out_conn);     // Catch: Throwable -> L6
            _hidl_reply.release();
            return;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // vendor.qti.hardware.servicetracker.V1_0.IServicetracker
        public void getPid(String processName, vendor.qti.hardware.servicetracker.V1_0.IServicetracker.getPidCallback _hidl_cb) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(vendor.qti.hardware.servicetracker.V1_0.IServicetracker.kInterfaceName);
            _hidl_request.writeString(processName);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(10, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            int _hidl_out_status = _hidl_reply.readInt32();     // Catch: Throwable -> L6
            int _hidl_out_pid = _hidl_reply.readInt32();     // Catch: Throwable -> L6
            _hidl_cb.onValues(_hidl_out_status, _hidl_out_pid);     // Catch: Throwable -> L6
            _hidl_reply.release();
            return;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // vendor.qti.hardware.servicetracker.V1_0.IServicetracker
        public void getPids(ArrayList<String> serviceList, vendor.qti.hardware.servicetracker.V1_0.IServicetracker.getPidsCallback _hidl_cb) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(vendor.qti.hardware.servicetracker.V1_0.IServicetracker.kInterfaceName);
            _hidl_request.writeStringVector(serviceList);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(11, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            int _hidl_out_status = _hidl_reply.readInt32();     // Catch: Throwable -> L6
            ArrayList<Integer> _hidl_out_pidList = _hidl_reply.readInt32Vector();     // Catch: Throwable -> L6
            _hidl_cb.onValues(_hidl_out_status, _hidl_out_pidList);     // Catch: Throwable -> L6
            _hidl_reply.release();
            return;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // vendor.qti.hardware.servicetracker.V1_0.IServicetracker
        public void isServiceB(String serviceName, vendor.qti.hardware.servicetracker.V1_0.IServicetracker.isServiceBCallback _hidl_cb) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(vendor.qti.hardware.servicetracker.V1_0.IServicetracker.kInterfaceName);
            _hidl_request.writeString(serviceName);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(12, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            int _hidl_out_status = _hidl_reply.readInt32();     // Catch: Throwable -> L6
            boolean _hidl_out_serviceB = _hidl_reply.readBool();     // Catch: Throwable -> L6
            _hidl_cb.onValues(_hidl_out_status, _hidl_out_serviceB);     // Catch: Throwable -> L6
            _hidl_reply.release();
            return;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // vendor.qti.hardware.servicetracker.V1_0.IServicetracker
        public void getServiceBCount(vendor.qti.hardware.servicetracker.V1_0.IServicetracker.getServiceBCountCallback _hidl_cb) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(vendor.qti.hardware.servicetracker.V1_0.IServicetracker.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(13, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            int _hidl_out_status = _hidl_reply.readInt32();     // Catch: Throwable -> L6
            ArrayList<ServiceRecord> _hidl_out_bServiceList = ServiceRecord.readVectorFromParcel(_hidl_reply);     // Catch: Throwable -> L6
            int _hidl_out_count = _hidl_reply.readInt32();     // Catch: Throwable -> L6
            _hidl_cb.onValues(_hidl_out_status, _hidl_out_bServiceList, _hidl_out_count);     // Catch: Throwable -> L6
            _hidl_reply.release();
            return;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // vendor.qti.hardware.servicetracker.V1_1.IServicetracker
        public void getRunningServicePid(vendor.qti.hardware.servicetracker.V1_1.IServicetracker.getRunningServicePidCallback _hidl_cb) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(vendor.qti.hardware.servicetracker.V1_1.IServicetracker.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(14, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            int _hidl_out_status = _hidl_reply.readInt32();     // Catch: Throwable -> L6
            ArrayList<Integer> _hidl_out_pidlist = _hidl_reply.readInt32Vector();     // Catch: Throwable -> L6
            _hidl_cb.onValues(_hidl_out_status, _hidl_out_pidlist);     // Catch: Throwable -> L6
            _hidl_reply.release();
            return;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // vendor.qti.hardware.servicetracker.V1_2.IServicetracker
        public int registerCallback(IActivityEventInfoCallback callback, int aNotify, int userdata) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IServicetracker.kInterfaceName);
            if (callback != null) goto L5;
            IHwBinder r1 = null;
        L6:
            _hidl_request.writeStrongBinder(r1);
            _hidl_request.writeInt32(aNotify);
            _hidl_request.writeInt32(userdata);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(15, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L10
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

        @Override // vendor.qti.hardware.servicetracker.V1_2.IServicetracker
        public int unregisterCallback(IActivityEventInfoCallback callback) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IServicetracker.kInterfaceName);
            if (callback != null) goto L5;
            IHwBinder r1 = null;
        L6:
            _hidl_request.writeStrongBinder(r1);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(16, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L10
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

        @Override // vendor.qti.hardware.servicetracker.V1_2.IServicetracker
        public void OnActivityStateChange(int aState, ActivityDetails aDetails, ActivityStats aStats, boolean early_notify) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IServicetracker.kInterfaceName);
            _hidl_request.writeInt32(aState);
            aDetails.writeToParcel(_hidl_request);
            aStats.writeToParcel(_hidl_request);
            _hidl_request.writeBool(early_notify);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(17, _hidl_request, _hidl_reply, 1);     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            _hidl_reply.release();
            return;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // vendor.qti.hardware.servicetracker.V1_2.IServicetracker, vendor.qti.hardware.servicetracker.V1_1.IServicetracker, vendor.qti.hardware.servicetracker.V1_0.IServicetracker, android.hidl.base.V1_0.IBase
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

        @Override // vendor.qti.hardware.servicetracker.V1_2.IServicetracker, vendor.qti.hardware.servicetracker.V1_1.IServicetracker, vendor.qti.hardware.servicetracker.V1_0.IServicetracker, android.hidl.base.V1_0.IBase
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

        @Override // vendor.qti.hardware.servicetracker.V1_2.IServicetracker, vendor.qti.hardware.servicetracker.V1_1.IServicetracker, vendor.qti.hardware.servicetracker.V1_0.IServicetracker, android.hidl.base.V1_0.IBase
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

        @Override // vendor.qti.hardware.servicetracker.V1_2.IServicetracker, vendor.qti.hardware.servicetracker.V1_1.IServicetracker, vendor.qti.hardware.servicetracker.V1_0.IServicetracker, android.hidl.base.V1_0.IBase
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

        @Override // vendor.qti.hardware.servicetracker.V1_2.IServicetracker, vendor.qti.hardware.servicetracker.V1_1.IServicetracker, vendor.qti.hardware.servicetracker.V1_0.IServicetracker, android.hidl.base.V1_0.IBase
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

        @Override // vendor.qti.hardware.servicetracker.V1_2.IServicetracker, vendor.qti.hardware.servicetracker.V1_1.IServicetracker, vendor.qti.hardware.servicetracker.V1_0.IServicetracker, android.hidl.base.V1_0.IBase
        public boolean linkToDeath(IHwBinder.DeathRecipient recipient, long cookie) throws RemoteException {
            return this.mRemote.linkToDeath(recipient, cookie);
        }

        @Override // vendor.qti.hardware.servicetracker.V1_2.IServicetracker, vendor.qti.hardware.servicetracker.V1_1.IServicetracker, vendor.qti.hardware.servicetracker.V1_0.IServicetracker, android.hidl.base.V1_0.IBase
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

        @Override // vendor.qti.hardware.servicetracker.V1_2.IServicetracker, vendor.qti.hardware.servicetracker.V1_1.IServicetracker, vendor.qti.hardware.servicetracker.V1_0.IServicetracker, android.hidl.base.V1_0.IBase
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

        @Override // vendor.qti.hardware.servicetracker.V1_2.IServicetracker, vendor.qti.hardware.servicetracker.V1_1.IServicetracker, vendor.qti.hardware.servicetracker.V1_0.IServicetracker, android.hidl.base.V1_0.IBase
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

        @Override // vendor.qti.hardware.servicetracker.V1_2.IServicetracker, vendor.qti.hardware.servicetracker.V1_1.IServicetracker, vendor.qti.hardware.servicetracker.V1_0.IServicetracker, android.hidl.base.V1_0.IBase
        public boolean unlinkToDeath(IHwBinder.DeathRecipient recipient) throws RemoteException {
            return this.mRemote.unlinkToDeath(recipient);
        }
    }

    public static abstract class Stub extends HwBinder implements IServicetracker {
        public Stub() {
        }

        @Override // vendor.qti.hardware.servicetracker.V1_2.IServicetracker, vendor.qti.hardware.servicetracker.V1_1.IServicetracker, vendor.qti.hardware.servicetracker.V1_0.IServicetracker, android.hidl.base.V1_0.IBase
        public IHwBinder asBinder() {
            return this;
        }

        @Override // vendor.qti.hardware.servicetracker.V1_2.IServicetracker, vendor.qti.hardware.servicetracker.V1_1.IServicetracker, vendor.qti.hardware.servicetracker.V1_0.IServicetracker, android.hidl.base.V1_0.IBase
        public final ArrayList<String> interfaceChain() {
            return new ArrayList(Arrays.asList(new String[]{IServicetracker.kInterfaceName, vendor.qti.hardware.servicetracker.V1_1.IServicetracker.kInterfaceName, vendor.qti.hardware.servicetracker.V1_0.IServicetracker.kInterfaceName, IBase.kInterfaceName}));
        }

        @Override // vendor.qti.hardware.servicetracker.V1_2.IServicetracker, vendor.qti.hardware.servicetracker.V1_1.IServicetracker, vendor.qti.hardware.servicetracker.V1_0.IServicetracker, android.hidl.base.V1_0.IBase
        public void debug(NativeHandle fd, ArrayList<String> options) {
        }

        @Override // vendor.qti.hardware.servicetracker.V1_2.IServicetracker, vendor.qti.hardware.servicetracker.V1_1.IServicetracker, vendor.qti.hardware.servicetracker.V1_0.IServicetracker, android.hidl.base.V1_0.IBase
        public final String interfaceDescriptor() {
            return IServicetracker.kInterfaceName;
        }

        @Override // vendor.qti.hardware.servicetracker.V1_2.IServicetracker, vendor.qti.hardware.servicetracker.V1_1.IServicetracker, vendor.qti.hardware.servicetracker.V1_0.IServicetracker, android.hidl.base.V1_0.IBase
        public final ArrayList<byte[]> getHashChain() {
            return new ArrayList(Arrays.asList(new byte[][]{new byte[]{-36, UsbASFormat.EXT_FORMAT_TYPE_III, -119, ParameterName.COLOR_TUNER_SWITCH, ParameterName.GAMUT_MAPPING, -28, -121, -107, -47, ParameterName.COLOR_TEMPERATURE, ParameterName.COLOR_TEMPERATURE, -10, -105, ParameterName.COLOR_TUNER_HUE_YELLOW, -114, -110, -95, -10, 96, -3, 109, ParameterName.DOLBY_DIALOGUE_ENHANCER, -58, 14, ParameterName.DIGITAL_OUTPUT, -24, -82, ParameterName.AUTO_PICTUREQUALITY_ENABLED, -63, -47, 97, 3}, new byte[]{-31, ParameterName.DE_CONTOUR, ParameterName.LOW_BLUE_LIGHT, -103, -19, -124, ParameterName.BALANCE, ParameterName.LOW_BLUE_LIGHT, ParameterName.COLOR_TUNER_HUE_CYAN, -99, 101, ParameterName.COLOR_TUNER_HUE_RED, -52, UsbASFormat.EXT_FORMAT_TYPE_I, UsbASFormat.EXT_FORMAT_TYPE_III, -111, -36, 4, 112, -72, 16, 112, ParameterName.BALANCE, ParameterName.DTS_DRC, -110, -117, 2, ParameterName.AUTO_SUPER_RESOLUTION_ENABLED, ParameterName.DE_CONTOUR, -20, -90, 117}, new byte[]{-69, -89, 53, -7, ParameterName.DTS_DRC, -43, -57, -93, 97, -106, -34, 101, ParameterName.COLOR_TUNER_LUMINANCE_RED, -91, -9, ParameterName.COLOR_TUNER_HUE_FLESH, -112, ParameterName.TREBLE, ParameterName.ELEVEN_POINT_RED, -60, -23, -39, 42, -62, -110, 121, -78, -35, TarConstants.LF_PAX_EXTENDED_HEADER_LC, 110, -69, -118}, new byte[]{-20, 127, -41, -98, -48, ParameterName.ELEVEN_POINT_BLUE, -6, -123, -68, ParameterName.COLOR_TUNER_LUMINANCE_GREEN, -108, ParameterName.COLOR_TEMPERATURE_GREEN_GAIN, -83, -82, ParameterName.COLOR_TUNER_HUE_MAGENTA, -66, 35, -17, 5, 36, -13, -51, 105, ParameterName.AUTO_VOLUME_CONTROL, ParameterName.FILM_MODE, -109, 36, -72, ParameterName.COLOR_TUNER_HUE_GREEN, ParameterName.GLOBE_DIMMING, -54, 76}}));
        }

        @Override // vendor.qti.hardware.servicetracker.V1_2.IServicetracker, vendor.qti.hardware.servicetracker.V1_1.IServicetracker, vendor.qti.hardware.servicetracker.V1_0.IServicetracker, android.hidl.base.V1_0.IBase
        public final void setHALInstrumentation() {
        }

        @Override // vendor.qti.hardware.servicetracker.V1_2.IServicetracker, vendor.qti.hardware.servicetracker.V1_1.IServicetracker, vendor.qti.hardware.servicetracker.V1_0.IServicetracker, android.hidl.base.V1_0.IBase
        public final boolean linkToDeath(IHwBinder.DeathRecipient recipient, long cookie) {
            return true;
        }

        @Override // vendor.qti.hardware.servicetracker.V1_2.IServicetracker, vendor.qti.hardware.servicetracker.V1_1.IServicetracker, vendor.qti.hardware.servicetracker.V1_0.IServicetracker, android.hidl.base.V1_0.IBase
        public final void ping() {
        }

        @Override // vendor.qti.hardware.servicetracker.V1_2.IServicetracker, vendor.qti.hardware.servicetracker.V1_1.IServicetracker, vendor.qti.hardware.servicetracker.V1_0.IServicetracker, android.hidl.base.V1_0.IBase
        public final DebugInfo getDebugInfo() {
            DebugInfo info = new DebugInfo();
            info.pid = HidlSupport.getPidIfSharable();
            info.ptr = 0;
            info.arch = 0;
            return info;
        }

        @Override // vendor.qti.hardware.servicetracker.V1_2.IServicetracker, vendor.qti.hardware.servicetracker.V1_1.IServicetracker, vendor.qti.hardware.servicetracker.V1_0.IServicetracker, android.hidl.base.V1_0.IBase
        public final void notifySyspropsChanged() {
            HwBinder.enableInstrumentation();
        }

        @Override // vendor.qti.hardware.servicetracker.V1_2.IServicetracker, vendor.qti.hardware.servicetracker.V1_1.IServicetracker, vendor.qti.hardware.servicetracker.V1_0.IServicetracker, android.hidl.base.V1_0.IBase
        public final boolean unlinkToDeath(IHwBinder.DeathRecipient recipient) {
            return true;
        }

        public IHwInterface queryLocalInterface(String descriptor) {
            if (IServicetracker.kInterfaceName.equals(descriptor) == false) goto L5;
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
                case 1: goto L39;
                case 2: goto L38;
                case 3: goto L37;
                case 4: goto L36;
                case 5: goto L35;
                case 6: goto L34;
                case 7: goto L33;
                case 8: goto L32;
                case 9: goto L31;
                case 10: goto L30;
                case 11: goto L29;
                case 12: goto L28;
                case 13: goto L27;
                case 14: goto L26;
                case 15: goto L25;
                case 16: goto L24;
                case 17: goto L23;
                case 256067662: goto L22;
                case 256131655: goto L21;
                case 256136003: goto L20;
                case 256398152: goto L10;
                case 256462420: goto L9;
                case 256660548: goto L68;
                case 256921159: goto L7;
                case 257049926: goto L6;
                case 257120595: goto L5;
                default: goto L68;
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
            _hidl_request.enforceInterface(IServicetracker.kInterfaceName);
            int aState = _hidl_request.readInt32();
            ActivityDetails aDetails = new ActivityDetails();
            aDetails.readFromParcel(_hidl_request);
            ActivityStats aStats = new ActivityStats();
            aStats.readFromParcel(_hidl_request);
            boolean early_notify = _hidl_request.readBool();
            OnActivityStateChange(aState, aDetails, aStats, early_notify);
            return;
        L24:
            _hidl_request.enforceInterface(IServicetracker.kInterfaceName);
            IActivityEventInfoCallback callback = IActivityEventInfoCallback.asInterface(_hidl_request.readStrongBinder());
            int _hidl_out_result = unregisterCallback(callback);
            _hidl_reply.writeStatus(0);
            _hidl_reply.writeInt32(_hidl_out_result);
            _hidl_reply.send();
            return;
        L25:
            _hidl_request.enforceInterface(IServicetracker.kInterfaceName);
            IActivityEventInfoCallback callback2 = IActivityEventInfoCallback.asInterface(_hidl_request.readStrongBinder());
            int aNotify = _hidl_request.readInt32();
            int userdata = _hidl_request.readInt32();
            int _hidl_out_result2 = registerCallback(callback2, aNotify, userdata);
            _hidl_reply.writeStatus(0);
            _hidl_reply.writeInt32(_hidl_out_result2);
            _hidl_reply.send();
            return;
        L26:
            _hidl_request.enforceInterface(vendor.qti.hardware.servicetracker.V1_1.IServicetracker.kInterfaceName);
            getRunningServicePid(new AnonymousClass9(this, _hidl_reply));
            return;
        L27:
            _hidl_request.enforceInterface(vendor.qti.hardware.servicetracker.V1_0.IServicetracker.kInterfaceName);
            getServiceBCount(new AnonymousClass8(this, _hidl_reply));
            return;
        L28:
            _hidl_request.enforceInterface(vendor.qti.hardware.servicetracker.V1_0.IServicetracker.kInterfaceName);
            String serviceName = _hidl_request.readString();
            isServiceB(serviceName, new AnonymousClass7(this, _hidl_reply));
            return;
        L29:
            _hidl_request.enforceInterface(vendor.qti.hardware.servicetracker.V1_0.IServicetracker.kInterfaceName);
            ArrayList<String> serviceList = _hidl_request.readStringVector();
            getPids(serviceList, new AnonymousClass6(this, _hidl_reply));
            return;
        L30:
            _hidl_request.enforceInterface(vendor.qti.hardware.servicetracker.V1_0.IServicetracker.kInterfaceName);
            String processName = _hidl_request.readString();
            getPid(processName, new AnonymousClass5(this, _hidl_reply));
            return;
        L31:
            _hidl_request.enforceInterface(vendor.qti.hardware.servicetracker.V1_0.IServicetracker.kInterfaceName);
            String clientName = _hidl_request.readString();
            getClientConnections(clientName, new AnonymousClass4(this, _hidl_reply));
            return;
        L32:
            _hidl_request.enforceInterface(vendor.qti.hardware.servicetracker.V1_0.IServicetracker.kInterfaceName);
            String serviceName2 = _hidl_request.readString();
            getServiceConnections(serviceName2, new AnonymousClass3(this, _hidl_reply));
            return;
        L33:
            _hidl_request.enforceInterface(vendor.qti.hardware.servicetracker.V1_0.IServicetracker.kInterfaceName);
            String serviceName3 = _hidl_request.readString();
            getserviceInfo(serviceName3, new AnonymousClass2(this, _hidl_reply));
            return;
        L34:
            _hidl_request.enforceInterface(vendor.qti.hardware.servicetracker.V1_0.IServicetracker.kInterfaceName);
            String clientName2 = _hidl_request.readString();
            getclientInfo(clientName2, new AnonymousClass1(this, _hidl_reply));
            return;
        L35:
            _hidl_request.enforceInterface(vendor.qti.hardware.servicetracker.V1_0.IServicetracker.kInterfaceName);
            int pid = _hidl_request.readInt32();
            killProcess(pid);
            return;
        L36:
            _hidl_request.enforceInterface(vendor.qti.hardware.servicetracker.V1_0.IServicetracker.kInterfaceName);
            ServiceData serviceData = new ServiceData();
            serviceData.readFromParcel(_hidl_request);
            destroyService(serviceData);
            return;
        L37:
            _hidl_request.enforceInterface(vendor.qti.hardware.servicetracker.V1_0.IServicetracker.kInterfaceName);
            ServiceData serviceData2 = new ServiceData();
            serviceData2.readFromParcel(_hidl_request);
            ClientData clientData = new ClientData();
            clientData.readFromParcel(_hidl_request);
            unbindService(serviceData2, clientData);
            return;
        L38:
            _hidl_request.enforceInterface(vendor.qti.hardware.servicetracker.V1_0.IServicetracker.kInterfaceName);
            ServiceData serviceData3 = new ServiceData();
            serviceData3.readFromParcel(_hidl_request);
            ClientData clientData2 = new ClientData();
            clientData2.readFromParcel(_hidl_request);
            bindService(serviceData3, clientData2);
            return;
        L39:
            _hidl_request.enforceInterface(vendor.qti.hardware.servicetracker.V1_0.IServicetracker.kInterfaceName);
            ServiceData serviceData4 = new ServiceData();
            serviceData4.readFromParcel(_hidl_request);
            startService(serviceData4);
            return;
        }
    }

    void OnActivityStateChange(int r1, ActivityDetails r2, ActivityStats r3, boolean r4) throws RemoteException;

    @Override // vendor.qti.hardware.servicetracker.V1_1.IServicetracker, vendor.qti.hardware.servicetracker.V1_0.IServicetracker, android.hidl.base.V1_0.IBase
    IHwBinder asBinder();

    @Override // vendor.qti.hardware.servicetracker.V1_1.IServicetracker, vendor.qti.hardware.servicetracker.V1_0.IServicetracker, android.hidl.base.V1_0.IBase
    void debug(NativeHandle r1, ArrayList<String> r2) throws RemoteException;

    @Override // vendor.qti.hardware.servicetracker.V1_1.IServicetracker, vendor.qti.hardware.servicetracker.V1_0.IServicetracker, android.hidl.base.V1_0.IBase
    DebugInfo getDebugInfo() throws RemoteException;

    @Override // vendor.qti.hardware.servicetracker.V1_1.IServicetracker, vendor.qti.hardware.servicetracker.V1_0.IServicetracker, android.hidl.base.V1_0.IBase
    ArrayList<byte[]> getHashChain() throws RemoteException;

    @Override // vendor.qti.hardware.servicetracker.V1_1.IServicetracker, vendor.qti.hardware.servicetracker.V1_0.IServicetracker, android.hidl.base.V1_0.IBase
    ArrayList<String> interfaceChain() throws RemoteException;

    @Override // vendor.qti.hardware.servicetracker.V1_1.IServicetracker, vendor.qti.hardware.servicetracker.V1_0.IServicetracker, android.hidl.base.V1_0.IBase
    String interfaceDescriptor() throws RemoteException;

    @Override // vendor.qti.hardware.servicetracker.V1_1.IServicetracker, vendor.qti.hardware.servicetracker.V1_0.IServicetracker, android.hidl.base.V1_0.IBase
    boolean linkToDeath(IHwBinder.DeathRecipient r1, long r2) throws RemoteException;

    @Override // vendor.qti.hardware.servicetracker.V1_1.IServicetracker, vendor.qti.hardware.servicetracker.V1_0.IServicetracker, android.hidl.base.V1_0.IBase
    void notifySyspropsChanged() throws RemoteException;

    @Override // vendor.qti.hardware.servicetracker.V1_1.IServicetracker, vendor.qti.hardware.servicetracker.V1_0.IServicetracker, android.hidl.base.V1_0.IBase
    void ping() throws RemoteException;

    int registerCallback(IActivityEventInfoCallback r1, int r2, int r3) throws RemoteException;

    @Override // vendor.qti.hardware.servicetracker.V1_1.IServicetracker, vendor.qti.hardware.servicetracker.V1_0.IServicetracker, android.hidl.base.V1_0.IBase
    void setHALInstrumentation() throws RemoteException;

    @Override // vendor.qti.hardware.servicetracker.V1_1.IServicetracker, vendor.qti.hardware.servicetracker.V1_0.IServicetracker, android.hidl.base.V1_0.IBase
    boolean unlinkToDeath(IHwBinder.DeathRecipient r1) throws RemoteException;

    int unregisterCallback(IActivityEventInfoCallback r1) throws RemoteException;

    static IServicetracker asInterface(IHwBinder binder) {
        if (binder != null) goto L5;
        return null;
    L5:
        IHwInterface iface = binder.queryLocalInterface(kInterfaceName);
        if (iface != null) goto L8;
    L11:
        IServicetracker proxy = new Proxy(binder);
        Iterator<String> r4 = proxy.interfaceChain().iterator();     // Catch: RemoteException -> L19
    L14:
        if (r4.hasNext() == false) goto L22;
        String descriptor = r4.next();     // Catch: RemoteException -> L19
        if (descriptor.equals(kInterfaceName) == false) goto L14;
        return proxy;
    L22:
        return null;
    L8:
        if ((iface instanceof IServicetracker) == false) goto L11;
        return (IServicetracker) iface;
    }

    static IServicetracker castFrom(IHwInterface iface) {
        if (iface != null) goto L5;
        return null;
    L5:
        return asInterface(iface.asBinder());
    }

    static IServicetracker getService(String serviceName, boolean retry) throws RemoteException {
        return asInterface(HwBinder.getService(kInterfaceName, serviceName, retry));
    }

    static IServicetracker getService(boolean retry) throws RemoteException {
        return getService("default", retry);
    }

    @Deprecated
    static IServicetracker getService(String serviceName) throws RemoteException {
        return asInterface(HwBinder.getService(kInterfaceName, serviceName));
    }

    @Deprecated
    static IServicetracker getService() throws RemoteException {
        return getService("default");
    }
}
