package android.hidl.manager.V1_0;

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
public interface IServiceManager extends IBase {
    public static final String kInterfaceName = "android.hidl.manager@1.0::IServiceManager";

    public static final class InstanceDebugInfo {
        public int arch;
        public ArrayList<Integer> clientPids;
        public String instanceName;
        public String interfaceName;
        public int pid;

        public InstanceDebugInfo() {
            this.interfaceName = new String();
            this.instanceName = new String();
            this.pid = 0;
            this.clientPids = new ArrayList();
            this.arch = 0;
        }

        public final boolean equals(Object otherObject) {
            if (this != otherObject) goto L6;
            return true;
        L6:
            if (otherObject != null) goto L9;
            return false;
        L9:
            if (otherObject.getClass() == InstanceDebugInfo.class) goto L11;
            return false;
        L11:
            InstanceDebugInfo other = (InstanceDebugInfo) otherObject;
            if (HidlSupport.deepEquals(this.interfaceName, other.interfaceName) == true) goto L15;
            return false;
        L15:
            if (HidlSupport.deepEquals(this.instanceName, other.instanceName) == true) goto L18;
            return false;
        L18:
            if (this.pid == other.pid) goto L21;
            return false;
        L21:
            if (HidlSupport.deepEquals(this.clientPids, other.clientPids) == true) goto L24;
            return false;
        L24:
            if (this.arch == other.arch) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(HidlSupport.deepHashCode(this.interfaceName)), Integer.valueOf(HidlSupport.deepHashCode(this.instanceName)), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.pid))), Integer.valueOf(HidlSupport.deepHashCode(this.clientPids)), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.arch)))});
        }

        public final String toString() {
            return "{.interfaceName = " + this.interfaceName + ", .instanceName = " + this.instanceName + ", .pid = " + this.pid + ", .clientPids = " + this.clientPids + ", .arch = " + DebugInfo.Architecture.toString(this.arch) + "}";
        }

        public final void readFromParcel(HwParcel parcel) {
            HwBlob blob = parcel.readBuffer(64);
            readEmbeddedFromParcel(parcel, blob, 0);
        }

        public static final ArrayList<InstanceDebugInfo> readVectorFromParcel(HwParcel parcel) {
            ArrayList<InstanceDebugInfo> _hidl_vec = new ArrayList();
            HwBlob _hidl_blob = parcel.readBuffer(16);
            int _hidl_vec_size = _hidl_blob.getInt32(8);
            HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 64, _hidl_blob.handle(), 0, true);
            _hidl_vec.clear();
            int _hidl_index_0 = 0;
        L3:
            if (_hidl_index_0 >= _hidl_vec_size) goto L6;
            InstanceDebugInfo _hidl_vec_element = new InstanceDebugInfo();
            _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 64);
            _hidl_vec.add(_hidl_vec_element);
            _hidl_index_0 = _hidl_index_0 + 1;
            goto L3
        L6:
            return _hidl_vec;
        }

        public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
            this.interfaceName = _hidl_blob.getString(_hidl_offset + 0);
            parcel.readEmbeddedBuffer(this.interfaceName.getBytes().length + 1, _hidl_blob.handle(), (_hidl_offset + 0) + 0, false);
            this.instanceName = _hidl_blob.getString(_hidl_offset + 16);
            parcel.readEmbeddedBuffer(this.instanceName.getBytes().length + 1, _hidl_blob.handle(), (_hidl_offset + 16) + 0, false);
            this.pid = _hidl_blob.getInt32(_hidl_offset + 32);
            int _hidl_vec_size = _hidl_blob.getInt32((_hidl_offset + 40) + 8);
            HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 4, _hidl_blob.handle(), (_hidl_offset + 40) + 0, true);
            this.clientPids.clear();
            int _hidl_index_0 = 0;
        L3:
            if (_hidl_index_0 >= _hidl_vec_size) goto L5;
            int _hidl_vec_element = childBlob.getInt32(_hidl_index_0 * 4);
            this.clientPids.add(Integer.valueOf(_hidl_vec_element));
            _hidl_index_0 = _hidl_index_0 + 1;
            goto L3
        L5:
            this.arch = _hidl_blob.getInt32(_hidl_offset + 56);
        }

        public final void writeToParcel(HwParcel parcel) {
            HwBlob _hidl_blob = new HwBlob(64);
            writeEmbeddedToBlob(_hidl_blob, 0);
            parcel.writeBuffer(_hidl_blob);
        }

        public static final void writeVectorToParcel(HwParcel parcel, ArrayList<InstanceDebugInfo> _hidl_vec) {
            HwBlob _hidl_blob = new HwBlob(16);
            int _hidl_vec_size = _hidl_vec.size();
            _hidl_blob.putInt32(8, _hidl_vec_size);
            _hidl_blob.putBool(12, false);
            HwBlob childBlob = new HwBlob(_hidl_vec_size * 64);
            int _hidl_index_0 = 0;
        L3:
            if (_hidl_index_0 >= _hidl_vec_size) goto L5;
            _hidl_vec.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 64);
            _hidl_index_0 = _hidl_index_0 + 1;
            goto L3
        L5:
            _hidl_blob.putBlob(0, childBlob);
            parcel.writeBuffer(_hidl_blob);
        }

        public final void writeEmbeddedToBlob(HwBlob _hidl_blob, long _hidl_offset) {
            _hidl_blob.putString(_hidl_offset + 0, this.interfaceName);
            _hidl_blob.putString(16 + _hidl_offset, this.instanceName);
            _hidl_blob.putInt32(32 + _hidl_offset, this.pid);
            int _hidl_vec_size = this.clientPids.size();
            _hidl_blob.putInt32((_hidl_offset + 40) + 8, _hidl_vec_size);
            _hidl_blob.putBool((_hidl_offset + 40) + 12, false);
            HwBlob childBlob = new HwBlob(_hidl_vec_size * 4);
            int _hidl_index_0 = 0;
        L3:
            if (_hidl_index_0 >= _hidl_vec_size) goto L5;
            childBlob.putInt32(_hidl_index_0 * 4, this.clientPids.get(_hidl_index_0).intValue());
            _hidl_index_0 = _hidl_index_0 + 1;
            goto L3
        L5:
            _hidl_blob.putBlob((40 + _hidl_offset) + 0, childBlob);
            _hidl_blob.putInt32(56 + _hidl_offset, this.arch);
        }
    }

    public static final class PidConstant {
        public static final int NO_PID = -1;

        public PidConstant() {
        }

        public static final String toString(int o) {
            if (o != (-1)) goto L7;
            return "NO_PID";
        L7:
            return "0x" + Integer.toHexString(o);
        }

        public static final String dumpBitfield(int o) {
            ArrayList<String> list = new ArrayList();
            int flipped = 0;
            if ((o & (-1)) != (-1)) goto L5;
            list.add("NO_PID");
            flipped = 0 | (-1);
        L5:
            if (o == flipped) goto L8;
            list.add("0x" + Integer.toHexString((~flipped) & o));
        L8:
            return String.join(" | ", list);
        }
    }

    public static final class Proxy implements IServiceManager {
        private IHwBinder mRemote;

        public Proxy(IHwBinder remote) {
            remote.getClass();
            this.mRemote = remote;
        }

        @Override // android.hidl.manager.V1_0.IServiceManager, android.hidl.base.V1_0.IBase
        public IHwBinder asBinder() {
            return this.mRemote;
        }

        public String toString() {
            return interfaceDescriptor() + "@Proxy";
        L5:
            return "[class or subclass of android.hidl.manager@1.0::IServiceManager]@Proxy";
        }

        public final boolean equals(Object other) {
            return HidlSupport.interfacesEqual(this, other);
        }

        public final int hashCode() {
            return asBinder().hashCode();
        }

        @Override // android.hidl.manager.V1_0.IServiceManager
        public IBase get(String fqName, String name) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IServiceManager.kInterfaceName);
            _hidl_request.writeString(fqName);
            _hidl_request.writeString(name);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(1, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            IBase _hidl_out_service = IBase.asInterface(_hidl_reply.readStrongBinder());     // Catch: Throwable -> L6
            _hidl_reply.release();
            return _hidl_out_service;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hidl.manager.V1_0.IServiceManager
        public boolean add(String name, IBase service) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IServiceManager.kInterfaceName);
            _hidl_request.writeString(name);
            if (service != null) goto L5;
            IHwBinder r1 = null;
        L6:
            _hidl_request.writeStrongBinder(r1);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(2, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L10
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L10
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L10
            boolean _hidl_out_success = _hidl_reply.readBool();     // Catch: Throwable -> L10
            _hidl_reply.release();
            return _hidl_out_success;
        L10:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        L5:
            r1 = service.asBinder();
            goto L6
        }

        @Override // android.hidl.manager.V1_0.IServiceManager
        public byte getTransport(String fqName, String name) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IServiceManager.kInterfaceName);
            _hidl_request.writeString(fqName);
            _hidl_request.writeString(name);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(3, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            byte _hidl_out_transport = _hidl_reply.readInt8();     // Catch: Throwable -> L6
            _hidl_reply.release();
            return _hidl_out_transport;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hidl.manager.V1_0.IServiceManager
        public ArrayList<String> list() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IServiceManager.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(4, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            ArrayList<String> _hidl_out_fqInstanceNames = _hidl_reply.readStringVector();     // Catch: Throwable -> L6
            _hidl_reply.release();
            return _hidl_out_fqInstanceNames;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hidl.manager.V1_0.IServiceManager
        public ArrayList<String> listByInterface(String fqName) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IServiceManager.kInterfaceName);
            _hidl_request.writeString(fqName);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(5, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            ArrayList<String> _hidl_out_instanceNames = _hidl_reply.readStringVector();     // Catch: Throwable -> L6
            _hidl_reply.release();
            return _hidl_out_instanceNames;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hidl.manager.V1_0.IServiceManager
        public boolean registerForNotifications(String fqName, String name, IServiceNotification callback) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IServiceManager.kInterfaceName);
            _hidl_request.writeString(fqName);
            _hidl_request.writeString(name);
            if (callback != null) goto L5;
            IHwBinder r1 = null;
        L6:
            _hidl_request.writeStrongBinder(r1);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(6, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L10
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L10
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L10
            boolean _hidl_out_success = _hidl_reply.readBool();     // Catch: Throwable -> L10
            _hidl_reply.release();
            return _hidl_out_success;
        L10:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        L5:
            r1 = callback.asBinder();
            goto L6
        }

        @Override // android.hidl.manager.V1_0.IServiceManager
        public ArrayList<InstanceDebugInfo> debugDump() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IServiceManager.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(7, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            ArrayList<InstanceDebugInfo> _hidl_out_info = InstanceDebugInfo.readVectorFromParcel(_hidl_reply);     // Catch: Throwable -> L6
            _hidl_reply.release();
            return _hidl_out_info;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hidl.manager.V1_0.IServiceManager
        public void registerPassthroughClient(String fqName, String name) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IServiceManager.kInterfaceName);
            _hidl_request.writeString(fqName);
            _hidl_request.writeString(name);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(8, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            _hidl_reply.release();
            return;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hidl.manager.V1_0.IServiceManager, android.hidl.base.V1_0.IBase
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

        @Override // android.hidl.manager.V1_0.IServiceManager, android.hidl.base.V1_0.IBase
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

        @Override // android.hidl.manager.V1_0.IServiceManager, android.hidl.base.V1_0.IBase
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

        @Override // android.hidl.manager.V1_0.IServiceManager, android.hidl.base.V1_0.IBase
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

        @Override // android.hidl.manager.V1_0.IServiceManager, android.hidl.base.V1_0.IBase
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

        @Override // android.hidl.manager.V1_0.IServiceManager, android.hidl.base.V1_0.IBase
        public boolean linkToDeath(IHwBinder.DeathRecipient recipient, long cookie) throws RemoteException {
            return this.mRemote.linkToDeath(recipient, cookie);
        }

        @Override // android.hidl.manager.V1_0.IServiceManager, android.hidl.base.V1_0.IBase
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

        @Override // android.hidl.manager.V1_0.IServiceManager, android.hidl.base.V1_0.IBase
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

        @Override // android.hidl.manager.V1_0.IServiceManager, android.hidl.base.V1_0.IBase
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

        @Override // android.hidl.manager.V1_0.IServiceManager, android.hidl.base.V1_0.IBase
        public boolean unlinkToDeath(IHwBinder.DeathRecipient recipient) throws RemoteException {
            return this.mRemote.unlinkToDeath(recipient);
        }
    }

    public static abstract class Stub extends HwBinder implements IServiceManager {
        public Stub() {
        }

        @Override // android.hidl.manager.V1_0.IServiceManager, android.hidl.base.V1_0.IBase
        public IHwBinder asBinder() {
            return this;
        }

        @Override // android.hidl.manager.V1_0.IServiceManager, android.hidl.base.V1_0.IBase
        public final ArrayList<String> interfaceChain() {
            return new ArrayList(Arrays.asList(new String[]{IServiceManager.kInterfaceName, IBase.kInterfaceName}));
        }

        @Override // android.hidl.manager.V1_0.IServiceManager, android.hidl.base.V1_0.IBase
        public void debug(NativeHandle fd, ArrayList<String> options) {
        }

        @Override // android.hidl.manager.V1_0.IServiceManager, android.hidl.base.V1_0.IBase
        public final String interfaceDescriptor() {
            return IServiceManager.kInterfaceName;
        }

        @Override // android.hidl.manager.V1_0.IServiceManager, android.hidl.base.V1_0.IBase
        public final ArrayList<byte[]> getHashChain() {
            return new ArrayList(Arrays.asList(new byte[][]{new byte[]{-123, ParameterName.COLOR_TUNER_SWITCH, ParameterName.BALANCE, -118, 13, ParameterName.BLUE_STRETCH, -25, -5, ParameterName.LOW_BLUE_LIGHT, -28, ParameterName.DTS_VIRTUAL_X, ParameterName.SURROUND_SOUND_ENABLED, -47, -5, -117, -113, -45, -63, ParameterName.COLOR_TUNER_HUE_BLUE, 51, ParameterName.COLOR_TUNER_HUE_MAGENTA, 99, -57, -116, ParameterName.COLOR_TUNER_LUMINANCE_BLUE, -95, -1, -122, -124, 12, -10, -36}, new byte[]{-20, 127, -41, -98, -48, ParameterName.ELEVEN_POINT_BLUE, -6, -123, -68, ParameterName.COLOR_TUNER_LUMINANCE_GREEN, -108, ParameterName.COLOR_TEMPERATURE_GREEN_GAIN, -83, -82, ParameterName.COLOR_TUNER_HUE_MAGENTA, -66, 35, -17, 5, 36, -13, -51, 105, ParameterName.AUTO_VOLUME_CONTROL, ParameterName.FILM_MODE, -109, 36, -72, ParameterName.COLOR_TUNER_HUE_GREEN, ParameterName.GLOBE_DIMMING, -54, 76}}));
        }

        @Override // android.hidl.manager.V1_0.IServiceManager, android.hidl.base.V1_0.IBase
        public final void setHALInstrumentation() {
        }

        @Override // android.hidl.manager.V1_0.IServiceManager, android.hidl.base.V1_0.IBase
        public final boolean linkToDeath(IHwBinder.DeathRecipient recipient, long cookie) {
            return true;
        }

        @Override // android.hidl.manager.V1_0.IServiceManager, android.hidl.base.V1_0.IBase
        public final void ping() {
        }

        @Override // android.hidl.manager.V1_0.IServiceManager, android.hidl.base.V1_0.IBase
        public final DebugInfo getDebugInfo() {
            DebugInfo info = new DebugInfo();
            info.pid = HidlSupport.getPidIfSharable();
            info.ptr = 0;
            info.arch = 0;
            return info;
        }

        @Override // android.hidl.manager.V1_0.IServiceManager, android.hidl.base.V1_0.IBase
        public final void notifySyspropsChanged() {
            HwBinder.enableInstrumentation();
        }

        @Override // android.hidl.manager.V1_0.IServiceManager, android.hidl.base.V1_0.IBase
        public final boolean unlinkToDeath(IHwBinder.DeathRecipient recipient) {
            return true;
        }

        public IHwInterface queryLocalInterface(String descriptor) {
            if (IServiceManager.kInterfaceName.equals(descriptor) == false) goto L5;
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
                case 1: goto L30;
                case 2: goto L29;
                case 3: goto L28;
                case 4: goto L27;
                case 5: goto L26;
                case 6: goto L25;
                case 7: goto L24;
                case 8: goto L23;
                case 256067662: goto L22;
                case 256131655: goto L21;
                case 256136003: goto L20;
                case 256398152: goto L10;
                case 256462420: goto L9;
                case 256660548: goto L54;
                case 256921159: goto L7;
                case 257049926: goto L6;
                case 257120595: goto L5;
                default: goto L54;
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
            _hidl_request.enforceInterface(IServiceManager.kInterfaceName);
            String fqName = _hidl_request.readString();
            String name = _hidl_request.readString();
            registerPassthroughClient(fqName, name);
            _hidl_reply.writeStatus(0);
            _hidl_reply.send();
            return;
        L24:
            _hidl_request.enforceInterface(IServiceManager.kInterfaceName);
            ArrayList<InstanceDebugInfo> _hidl_out_info2 = debugDump();
            _hidl_reply.writeStatus(0);
            InstanceDebugInfo.writeVectorToParcel(_hidl_reply, _hidl_out_info2);
            _hidl_reply.send();
            return;
        L25:
            _hidl_request.enforceInterface(IServiceManager.kInterfaceName);
            String fqName2 = _hidl_request.readString();
            String name2 = _hidl_request.readString();
            IServiceNotification callback = IServiceNotification.asInterface(_hidl_request.readStrongBinder());
            boolean _hidl_out_success = registerForNotifications(fqName2, name2, callback);
            _hidl_reply.writeStatus(0);
            _hidl_reply.writeBool(_hidl_out_success);
            _hidl_reply.send();
            return;
        L26:
            _hidl_request.enforceInterface(IServiceManager.kInterfaceName);
            String fqName3 = _hidl_request.readString();
            ArrayList<String> _hidl_out_instanceNames = listByInterface(fqName3);
            _hidl_reply.writeStatus(0);
            _hidl_reply.writeStringVector(_hidl_out_instanceNames);
            _hidl_reply.send();
            return;
        L27:
            _hidl_request.enforceInterface(IServiceManager.kInterfaceName);
            ArrayList<String> _hidl_out_fqInstanceNames = list();
            _hidl_reply.writeStatus(0);
            _hidl_reply.writeStringVector(_hidl_out_fqInstanceNames);
            _hidl_reply.send();
            return;
        L28:
            _hidl_request.enforceInterface(IServiceManager.kInterfaceName);
            String fqName4 = _hidl_request.readString();
            String name3 = _hidl_request.readString();
            byte _hidl_out_transport = getTransport(fqName4, name3);
            _hidl_reply.writeStatus(0);
            _hidl_reply.writeInt8(_hidl_out_transport);
            _hidl_reply.send();
            return;
        L29:
            _hidl_request.enforceInterface(IServiceManager.kInterfaceName);
            String name4 = _hidl_request.readString();
            IBase service = IBase.asInterface(_hidl_request.readStrongBinder());
            boolean _hidl_out_success2 = add(name4, service);
            _hidl_reply.writeStatus(0);
            _hidl_reply.writeBool(_hidl_out_success2);
            _hidl_reply.send();
            return;
        L30:
            _hidl_request.enforceInterface(IServiceManager.kInterfaceName);
            String fqName5 = _hidl_request.readString();
            String name5 = _hidl_request.readString();
            IBase _hidl_out_service = get(fqName5, name5);
            _hidl_reply.writeStatus(0);
            if (_hidl_out_service != null) goto L33;
            IHwBinder r2 = null;
        L34:
            _hidl_reply.writeStrongBinder(r2);
            _hidl_reply.send();
            return;
        L33:
            r2 = _hidl_out_service.asBinder();
            goto L34
        }
    }

    public static final class Transport {
        public static final byte EMPTY = 0;
        public static final byte HWBINDER = 1;
        public static final byte PASSTHROUGH = 2;

        public Transport() {
        }

        public static final String toString(byte o) {
            if (o != 0) goto L6;
            return "EMPTY";
        L6:
            if (o != 1) goto L10;
            return "HWBINDER";
        L10:
            if (o != 2) goto L14;
            return "PASSTHROUGH";
        L14:
            return "0x" + Integer.toHexString(Byte.toUnsignedInt(o));
        }

        public static final String dumpBitfield(byte o) {
            ArrayList<String> list = new ArrayList();
            byte flipped = 0;
            list.add("EMPTY");
            if ((o & 1) != 1) goto L6;
            list.add("HWBINDER");
            flipped = (byte) (0 | 1);
        L6:
            if ((o & 2) != 2) goto L8;
            list.add("PASSTHROUGH");
            flipped = (byte) (flipped | 2);
        L8:
            if (o == flipped) goto L11;
            list.add("0x" + Integer.toHexString(Byte.toUnsignedInt((byte) ((~flipped) & o))));
        L11:
            return String.join(" | ", list);
        }
    }

    boolean add(String r1, IBase r2) throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    IHwBinder asBinder();

    @Override // android.hidl.base.V1_0.IBase
    void debug(NativeHandle r1, ArrayList<String> r2) throws RemoteException;

    ArrayList<InstanceDebugInfo> debugDump() throws RemoteException;

    IBase get(String r1, String r2) throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    DebugInfo getDebugInfo() throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    ArrayList<byte[]> getHashChain() throws RemoteException;

    byte getTransport(String r1, String r2) throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    ArrayList<String> interfaceChain() throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    String interfaceDescriptor() throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    boolean linkToDeath(IHwBinder.DeathRecipient r1, long r2) throws RemoteException;

    ArrayList<String> list() throws RemoteException;

    ArrayList<String> listByInterface(String r1) throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    void notifySyspropsChanged() throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    void ping() throws RemoteException;

    boolean registerForNotifications(String r1, String r2, IServiceNotification r3) throws RemoteException;

    void registerPassthroughClient(String r1, String r2) throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    void setHALInstrumentation() throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    boolean unlinkToDeath(IHwBinder.DeathRecipient r1) throws RemoteException;

    static IServiceManager asInterface(IHwBinder binder) {
        if (binder != null) goto L5;
        return null;
    L5:
        IHwInterface iface = binder.queryLocalInterface(kInterfaceName);
        if (iface != null) goto L8;
    L11:
        IServiceManager proxy = new Proxy(binder);
        Iterator<String> r4 = proxy.interfaceChain().iterator();     // Catch: RemoteException -> L19
    L14:
        if (r4.hasNext() == false) goto L22;
        String descriptor = r4.next();     // Catch: RemoteException -> L19
        if (descriptor.equals(kInterfaceName) == false) goto L14;
        return proxy;
    L22:
        return null;
    L8:
        if ((iface instanceof IServiceManager) == false) goto L11;
        return (IServiceManager) iface;
    }

    static IServiceManager castFrom(IHwInterface iface) {
        if (iface != null) goto L5;
        return null;
    L5:
        return asInterface(iface.asBinder());
    }

    static IServiceManager getService(String serviceName, boolean retry) throws RemoteException {
        return asInterface(HwBinder.getService(kInterfaceName, serviceName, retry));
    }

    static IServiceManager getService(boolean retry) throws RemoteException {
        return getService("default", retry);
    }

    @Deprecated
    static IServiceManager getService(String serviceName) throws RemoteException {
        return asInterface(HwBinder.getService(kInterfaceName, serviceName));
    }

    @Deprecated
    static IServiceManager getService() throws RemoteException {
        return getService("default");
    }
}
