package android.hardware.boot.V1_1;

import android.hardware.boot.V1_0.CommandResult;
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
public interface IBootControl extends android.hardware.boot.V1_0.IBootControl {
    public static final String kInterfaceName = "android.hardware.boot@1.1::IBootControl";

    public static final class Proxy implements IBootControl {
        private IHwBinder mRemote;

        public Proxy(IHwBinder remote) {
            remote.getClass();
            this.mRemote = remote;
        }

        @Override // android.hardware.boot.V1_1.IBootControl, android.hardware.boot.V1_0.IBootControl, android.hidl.base.V1_0.IBase
        public IHwBinder asBinder() {
            return this.mRemote;
        }

        public String toString() {
            return interfaceDescriptor() + "@Proxy";
        L5:
            return "[class or subclass of android.hardware.boot@1.1::IBootControl]@Proxy";
        }

        public final boolean equals(Object other) {
            return HidlSupport.interfacesEqual(this, other);
        }

        public final int hashCode() {
            return asBinder().hashCode();
        }

        @Override // android.hardware.boot.V1_0.IBootControl
        public int getNumberSlots() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(android.hardware.boot.V1_0.IBootControl.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(1, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            int _hidl_out_numSlots = _hidl_reply.readInt32();     // Catch: Throwable -> L6
            _hidl_reply.release();
            return _hidl_out_numSlots;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hardware.boot.V1_0.IBootControl
        public int getCurrentSlot() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(android.hardware.boot.V1_0.IBootControl.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(2, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            int _hidl_out_slot = _hidl_reply.readInt32();     // Catch: Throwable -> L6
            _hidl_reply.release();
            return _hidl_out_slot;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hardware.boot.V1_0.IBootControl
        public CommandResult markBootSuccessful() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(android.hardware.boot.V1_0.IBootControl.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(3, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            CommandResult _hidl_out_error = new CommandResult();     // Catch: Throwable -> L6
            _hidl_out_error.readFromParcel(_hidl_reply);     // Catch: Throwable -> L6
            _hidl_reply.release();
            return _hidl_out_error;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hardware.boot.V1_0.IBootControl
        public CommandResult setActiveBootSlot(int slot) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(android.hardware.boot.V1_0.IBootControl.kInterfaceName);
            _hidl_request.writeInt32(slot);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(4, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            CommandResult _hidl_out_error = new CommandResult();     // Catch: Throwable -> L6
            _hidl_out_error.readFromParcel(_hidl_reply);     // Catch: Throwable -> L6
            _hidl_reply.release();
            return _hidl_out_error;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hardware.boot.V1_0.IBootControl
        public CommandResult setSlotAsUnbootable(int slot) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(android.hardware.boot.V1_0.IBootControl.kInterfaceName);
            _hidl_request.writeInt32(slot);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(5, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            CommandResult _hidl_out_error = new CommandResult();     // Catch: Throwable -> L6
            _hidl_out_error.readFromParcel(_hidl_reply);     // Catch: Throwable -> L6
            _hidl_reply.release();
            return _hidl_out_error;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hardware.boot.V1_0.IBootControl
        public int isSlotBootable(int slot) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(android.hardware.boot.V1_0.IBootControl.kInterfaceName);
            _hidl_request.writeInt32(slot);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(6, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            int _hidl_out_bootable = _hidl_reply.readInt32();     // Catch: Throwable -> L6
            _hidl_reply.release();
            return _hidl_out_bootable;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hardware.boot.V1_0.IBootControl
        public int isSlotMarkedSuccessful(int slot) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(android.hardware.boot.V1_0.IBootControl.kInterfaceName);
            _hidl_request.writeInt32(slot);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(7, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            int _hidl_out_successful = _hidl_reply.readInt32();     // Catch: Throwable -> L6
            _hidl_reply.release();
            return _hidl_out_successful;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hardware.boot.V1_0.IBootControl
        public String getSuffix(int slot) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(android.hardware.boot.V1_0.IBootControl.kInterfaceName);
            _hidl_request.writeInt32(slot);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(8, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            String _hidl_out_slotSuffix = _hidl_reply.readString();     // Catch: Throwable -> L6
            _hidl_reply.release();
            return _hidl_out_slotSuffix;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hardware.boot.V1_1.IBootControl
        public boolean setSnapshotMergeStatus(int status) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IBootControl.kInterfaceName);
            _hidl_request.writeInt32(status);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(9, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            boolean _hidl_out_success = _hidl_reply.readBool();     // Catch: Throwable -> L6
            _hidl_reply.release();
            return _hidl_out_success;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hardware.boot.V1_1.IBootControl
        public int getSnapshotMergeStatus() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IBootControl.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            this.mRemote.transact(10, _hidl_request, _hidl_reply, 0);     // Catch: Throwable -> L6
            _hidl_reply.verifySuccess();     // Catch: Throwable -> L6
            _hidl_request.releaseTemporaryStorage();     // Catch: Throwable -> L6
            int _hidl_out_status = _hidl_reply.readInt32();     // Catch: Throwable -> L6
            _hidl_reply.release();
            return _hidl_out_status;
        L6:
            th = move-exception;
            _hidl_reply.release();
            throw th;
        }

        @Override // android.hardware.boot.V1_1.IBootControl, android.hardware.boot.V1_0.IBootControl, android.hidl.base.V1_0.IBase
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

        @Override // android.hardware.boot.V1_1.IBootControl, android.hardware.boot.V1_0.IBootControl, android.hidl.base.V1_0.IBase
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

        @Override // android.hardware.boot.V1_1.IBootControl, android.hardware.boot.V1_0.IBootControl, android.hidl.base.V1_0.IBase
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

        @Override // android.hardware.boot.V1_1.IBootControl, android.hardware.boot.V1_0.IBootControl, android.hidl.base.V1_0.IBase
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

        @Override // android.hardware.boot.V1_1.IBootControl, android.hardware.boot.V1_0.IBootControl, android.hidl.base.V1_0.IBase
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

        @Override // android.hardware.boot.V1_1.IBootControl, android.hardware.boot.V1_0.IBootControl, android.hidl.base.V1_0.IBase
        public boolean linkToDeath(IHwBinder.DeathRecipient recipient, long cookie) throws RemoteException {
            return this.mRemote.linkToDeath(recipient, cookie);
        }

        @Override // android.hardware.boot.V1_1.IBootControl, android.hardware.boot.V1_0.IBootControl, android.hidl.base.V1_0.IBase
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

        @Override // android.hardware.boot.V1_1.IBootControl, android.hardware.boot.V1_0.IBootControl, android.hidl.base.V1_0.IBase
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

        @Override // android.hardware.boot.V1_1.IBootControl, android.hardware.boot.V1_0.IBootControl, android.hidl.base.V1_0.IBase
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

        @Override // android.hardware.boot.V1_1.IBootControl, android.hardware.boot.V1_0.IBootControl, android.hidl.base.V1_0.IBase
        public boolean unlinkToDeath(IHwBinder.DeathRecipient recipient) throws RemoteException {
            return this.mRemote.unlinkToDeath(recipient);
        }
    }

    public static abstract class Stub extends HwBinder implements IBootControl {
        public Stub() {
        }

        @Override // android.hardware.boot.V1_1.IBootControl, android.hardware.boot.V1_0.IBootControl, android.hidl.base.V1_0.IBase
        public IHwBinder asBinder() {
            return this;
        }

        @Override // android.hardware.boot.V1_1.IBootControl, android.hardware.boot.V1_0.IBootControl, android.hidl.base.V1_0.IBase
        public final ArrayList<String> interfaceChain() {
            return new ArrayList(Arrays.asList(new String[]{IBootControl.kInterfaceName, android.hardware.boot.V1_0.IBootControl.kInterfaceName, IBase.kInterfaceName}));
        }

        @Override // android.hardware.boot.V1_1.IBootControl, android.hardware.boot.V1_0.IBootControl, android.hidl.base.V1_0.IBase
        public void debug(NativeHandle fd, ArrayList<String> options) {
        }

        @Override // android.hardware.boot.V1_1.IBootControl, android.hardware.boot.V1_0.IBootControl, android.hidl.base.V1_0.IBase
        public final String interfaceDescriptor() {
            return IBootControl.kInterfaceName;
        }

        @Override // android.hardware.boot.V1_1.IBootControl, android.hardware.boot.V1_0.IBootControl, android.hidl.base.V1_0.IBase
        public final ArrayList<byte[]> getHashChain() {
            return new ArrayList(Arrays.asList(new byte[][]{new byte[]{7, -48, -94, ParameterName.SURROUND_SOUND_ENABLED, -78, -40, -6, 53, -120, 121, 8, -87, -106, -70, ParameterName.COLOR_TUNER_SWITCH, ParameterName.DTS_VIRTUAL_X, -13, -110, -106, UsbASFormat.EXT_FORMAT_TYPE_III, -107, -4, 48, -81, -85, 121, ParameterName.VRR, ParameterName.COLOR_TUNER_SATURATION_YELLOW, -32, -62, 42, ParameterName.SURROUND_SOUND_ENABLED}, new byte[]{113, -110, -41, ParameterName.ENHANCED_AUDIO_RETURN_CHANNEL_ENABLED, -82, -70, 0, -85, -93, ParameterName.LD_MODE, ParameterName.COLOR_TUNER_SATURATION_MAGENTA, 4, -104, ParameterName.PC_MODE, -8, ParameterName.COLOR_TEMPERATURE, ParameterName.LD_MODE, -4, -88, ParameterName.COLOR_TUNER_HUE_MAGENTA, 33, 12, ParameterName.COLOR_TUNER_LUMINANCE_RED, ParameterName.OSD_CONTRAST, -38, -65, 41, ParameterName.DIGITAL_OUTPUT_DELAY_MS, 83, -23, 53, -112}, new byte[]{-20, 127, -41, -98, -48, ParameterName.ELEVEN_POINT_BLUE, -6, -123, -68, ParameterName.COLOR_TUNER_LUMINANCE_GREEN, -108, ParameterName.COLOR_TEMPERATURE_GREEN_GAIN, -83, -82, ParameterName.COLOR_TUNER_HUE_MAGENTA, -66, 35, -17, 5, 36, -13, -51, 105, ParameterName.AUTO_VOLUME_CONTROL, ParameterName.FILM_MODE, -109, 36, -72, ParameterName.COLOR_TUNER_HUE_GREEN, ParameterName.GLOBE_DIMMING, -54, 76}}));
        }

        @Override // android.hardware.boot.V1_1.IBootControl, android.hardware.boot.V1_0.IBootControl, android.hidl.base.V1_0.IBase
        public final void setHALInstrumentation() {
        }

        @Override // android.hardware.boot.V1_1.IBootControl, android.hardware.boot.V1_0.IBootControl, android.hidl.base.V1_0.IBase
        public final boolean linkToDeath(IHwBinder.DeathRecipient recipient, long cookie) {
            return true;
        }

        @Override // android.hardware.boot.V1_1.IBootControl, android.hardware.boot.V1_0.IBootControl, android.hidl.base.V1_0.IBase
        public final void ping() {
        }

        @Override // android.hardware.boot.V1_1.IBootControl, android.hardware.boot.V1_0.IBootControl, android.hidl.base.V1_0.IBase
        public final DebugInfo getDebugInfo() {
            DebugInfo info = new DebugInfo();
            info.pid = HidlSupport.getPidIfSharable();
            info.ptr = 0;
            info.arch = 0;
            return info;
        }

        @Override // android.hardware.boot.V1_1.IBootControl, android.hardware.boot.V1_0.IBootControl, android.hidl.base.V1_0.IBase
        public final void notifySyspropsChanged() {
            HwBinder.enableInstrumentation();
        }

        @Override // android.hardware.boot.V1_1.IBootControl, android.hardware.boot.V1_0.IBootControl, android.hidl.base.V1_0.IBase
        public final boolean unlinkToDeath(IHwBinder.DeathRecipient recipient) {
            return true;
        }

        public IHwInterface queryLocalInterface(String descriptor) {
            if (IBootControl.kInterfaceName.equals(descriptor) == false) goto L5;
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
                case 1: goto L32;
                case 2: goto L31;
                case 3: goto L30;
                case 4: goto L29;
                case 5: goto L28;
                case 6: goto L27;
                case 7: goto L26;
                case 8: goto L25;
                case 9: goto L24;
                case 10: goto L23;
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
            _hidl_request.enforceInterface(IBootControl.kInterfaceName);
            int _hidl_out_status = getSnapshotMergeStatus();
            _hidl_reply.writeStatus(0);
            _hidl_reply.writeInt32(_hidl_out_status);
            _hidl_reply.send();
            return;
        L24:
            _hidl_request.enforceInterface(IBootControl.kInterfaceName);
            int status = _hidl_request.readInt32();
            boolean _hidl_out_success = setSnapshotMergeStatus(status);
            _hidl_reply.writeStatus(0);
            _hidl_reply.writeBool(_hidl_out_success);
            _hidl_reply.send();
            return;
        L25:
            _hidl_request.enforceInterface(android.hardware.boot.V1_0.IBootControl.kInterfaceName);
            int slot = _hidl_request.readInt32();
            String _hidl_out_slotSuffix = getSuffix(slot);
            _hidl_reply.writeStatus(0);
            _hidl_reply.writeString(_hidl_out_slotSuffix);
            _hidl_reply.send();
            return;
        L26:
            _hidl_request.enforceInterface(android.hardware.boot.V1_0.IBootControl.kInterfaceName);
            int slot2 = _hidl_request.readInt32();
            int _hidl_out_successful = isSlotMarkedSuccessful(slot2);
            _hidl_reply.writeStatus(0);
            _hidl_reply.writeInt32(_hidl_out_successful);
            _hidl_reply.send();
            return;
        L27:
            _hidl_request.enforceInterface(android.hardware.boot.V1_0.IBootControl.kInterfaceName);
            int slot3 = _hidl_request.readInt32();
            int _hidl_out_bootable = isSlotBootable(slot3);
            _hidl_reply.writeStatus(0);
            _hidl_reply.writeInt32(_hidl_out_bootable);
            _hidl_reply.send();
            return;
        L28:
            _hidl_request.enforceInterface(android.hardware.boot.V1_0.IBootControl.kInterfaceName);
            int slot4 = _hidl_request.readInt32();
            CommandResult _hidl_out_error = setSlotAsUnbootable(slot4);
            _hidl_reply.writeStatus(0);
            _hidl_out_error.writeToParcel(_hidl_reply);
            _hidl_reply.send();
            return;
        L29:
            _hidl_request.enforceInterface(android.hardware.boot.V1_0.IBootControl.kInterfaceName);
            int slot5 = _hidl_request.readInt32();
            CommandResult _hidl_out_error2 = setActiveBootSlot(slot5);
            _hidl_reply.writeStatus(0);
            _hidl_out_error2.writeToParcel(_hidl_reply);
            _hidl_reply.send();
            return;
        L30:
            _hidl_request.enforceInterface(android.hardware.boot.V1_0.IBootControl.kInterfaceName);
            CommandResult _hidl_out_error3 = markBootSuccessful();
            _hidl_reply.writeStatus(0);
            _hidl_out_error3.writeToParcel(_hidl_reply);
            _hidl_reply.send();
            return;
        L31:
            _hidl_request.enforceInterface(android.hardware.boot.V1_0.IBootControl.kInterfaceName);
            int _hidl_out_slot = getCurrentSlot();
            _hidl_reply.writeStatus(0);
            _hidl_reply.writeInt32(_hidl_out_slot);
            _hidl_reply.send();
            return;
        L32:
            _hidl_request.enforceInterface(android.hardware.boot.V1_0.IBootControl.kInterfaceName);
            int _hidl_out_numSlots = getNumberSlots();
            _hidl_reply.writeStatus(0);
            _hidl_reply.writeInt32(_hidl_out_numSlots);
            _hidl_reply.send();
            return;
        }
    }

    @Override // android.hardware.boot.V1_0.IBootControl, android.hidl.base.V1_0.IBase
    IHwBinder asBinder();

    @Override // android.hardware.boot.V1_0.IBootControl, android.hidl.base.V1_0.IBase
    void debug(NativeHandle r1, ArrayList<String> r2) throws RemoteException;

    @Override // android.hardware.boot.V1_0.IBootControl, android.hidl.base.V1_0.IBase
    DebugInfo getDebugInfo() throws RemoteException;

    @Override // android.hardware.boot.V1_0.IBootControl, android.hidl.base.V1_0.IBase
    ArrayList<byte[]> getHashChain() throws RemoteException;

    int getSnapshotMergeStatus() throws RemoteException;

    @Override // android.hardware.boot.V1_0.IBootControl, android.hidl.base.V1_0.IBase
    ArrayList<String> interfaceChain() throws RemoteException;

    @Override // android.hardware.boot.V1_0.IBootControl, android.hidl.base.V1_0.IBase
    String interfaceDescriptor() throws RemoteException;

    @Override // android.hardware.boot.V1_0.IBootControl, android.hidl.base.V1_0.IBase
    boolean linkToDeath(IHwBinder.DeathRecipient r1, long r2) throws RemoteException;

    @Override // android.hardware.boot.V1_0.IBootControl, android.hidl.base.V1_0.IBase
    void notifySyspropsChanged() throws RemoteException;

    @Override // android.hardware.boot.V1_0.IBootControl, android.hidl.base.V1_0.IBase
    void ping() throws RemoteException;

    @Override // android.hardware.boot.V1_0.IBootControl, android.hidl.base.V1_0.IBase
    void setHALInstrumentation() throws RemoteException;

    boolean setSnapshotMergeStatus(int r1) throws RemoteException;

    @Override // android.hardware.boot.V1_0.IBootControl, android.hidl.base.V1_0.IBase
    boolean unlinkToDeath(IHwBinder.DeathRecipient r1) throws RemoteException;

    static IBootControl asInterface(IHwBinder binder) {
        if (binder != null) goto L5;
        return null;
    L5:
        IHwInterface iface = binder.queryLocalInterface(kInterfaceName);
        if (iface != null) goto L8;
    L11:
        IBootControl proxy = new Proxy(binder);
        Iterator<String> r4 = proxy.interfaceChain().iterator();     // Catch: RemoteException -> L19
    L14:
        if (r4.hasNext() == false) goto L22;
        String descriptor = r4.next();     // Catch: RemoteException -> L19
        if (descriptor.equals(kInterfaceName) == false) goto L14;
        return proxy;
    L22:
        return null;
    L8:
        if ((iface instanceof IBootControl) == false) goto L11;
        return (IBootControl) iface;
    }

    static IBootControl castFrom(IHwInterface iface) {
        if (iface != null) goto L5;
        return null;
    L5:
        return asInterface(iface.asBinder());
    }

    static IBootControl getService(String serviceName, boolean retry) throws RemoteException {
        return asInterface(HwBinder.getService(kInterfaceName, serviceName, retry));
    }

    static IBootControl getService(boolean retry) throws RemoteException {
        return getService("default", retry);
    }

    @Deprecated
    static IBootControl getService(String serviceName) throws RemoteException {
        return asInterface(HwBinder.getService(kInterfaceName, serviceName));
    }

    @Deprecated
    static IBootControl getService() throws RemoteException {
        return getService("default");
    }
}
