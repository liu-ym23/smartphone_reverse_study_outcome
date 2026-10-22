package com.android.server.hdmi;

import android.hardware.hdmi.IHdmiControlCallback;
import android.os.RemoteException;
import android.util.Slog;

/* JADX INFO: loaded from: classes2.dex */
public class SelectRequestBuffer {
    public static final SelectRequestBuffer EMPTY_BUFFER = null;
    private static final String TAG = "SelectRequestBuffer";
    private SelectRequest mRequest;

    public static class DeviceSelectRequest extends SelectRequest {
        /* synthetic */ DeviceSelectRequest(HdmiControlService r1, int r2, IHdmiControlCallback r3, SelectRequestBufferIA r4) {
            this(r1, r2, r3);
        }

        private DeviceSelectRequest(HdmiControlService srv, int id, IHdmiControlCallback callback) {
            super(srv, id, callback);
        }

        @Override // com.android.server.hdmi.SelectRequestBuffer.SelectRequest
        public void process() {
            if (isLocalDeviceReady() == false) goto L6;
            Slog.v(SelectRequestBuffer.TAG, "calling delayed deviceSelect id:" + this.mId);
            tv().deviceSelect(this.mId, this.mCallback);
            return;
        }
    }

    public static class PortSelectRequest extends SelectRequest {
        /* synthetic */ PortSelectRequest(HdmiControlService r1, int r2, IHdmiControlCallback r3, SelectRequestBufferIA r4) {
            this(r1, r2, r3);
        }

        private PortSelectRequest(HdmiControlService srv, int id, IHdmiControlCallback callback) {
            super(srv, id, callback);
        }

        @Override // com.android.server.hdmi.SelectRequestBuffer.SelectRequest
        public void process() {
            if (isLocalDeviceReady() == false) goto L12;
            Slog.v(SelectRequestBuffer.TAG, "calling delayed portSelect id:" + this.mId);
            HdmiCecLocalDeviceTv tv = tv();
            if (tv == null) goto L8;
            tv.doManualPortSwitching(this.mId, this.mCallback);
            return;
        L8:
            HdmiCecLocalDeviceAudioSystem audioSystem = audioSystem();
            if (audioSystem == null) goto L13;
            audioSystem.doManualPortSwitching(this.mId, this.mCallback);
            return;
        L13:
            return;
        }
    }

    public static abstract class SelectRequest {
        protected final IHdmiControlCallback mCallback;
        protected final int mId;
        protected final HdmiControlService mService;

        public abstract void process();

        public SelectRequest(HdmiControlService service, int id, IHdmiControlCallback callback) {
            this.mService = service;
            this.mId = id;
            this.mCallback = callback;
        }

        protected HdmiCecLocalDeviceTv tv() {
            return this.mService.tv();
        }

        protected HdmiCecLocalDeviceAudioSystem audioSystem() {
            return this.mService.audioSystem();
        }

        protected boolean isLocalDeviceReady() {
            if (tv() != null) goto L6;
            Slog.e(SelectRequestBuffer.TAG, "Local tv device not available");
            invokeCallback(2);
            return false;
        L6:
            return true;
        }

        private void invokeCallback(int reason) {
        L6:
            e = move-exception;
            Slog.e(SelectRequestBuffer.TAG, "Invoking callback failed:" + e);
            return;
        L3:
            if (this.mCallback == null) goto L13;
            this.mCallback.onComplete(reason);     // Catch: RemoteException -> L6
            return;
        }
    }

    public SelectRequestBuffer() {
    }

    static {
        EMPTY_BUFFER = new AnonymousClass1();
    }

    public static DeviceSelectRequest newDeviceSelect(HdmiControlService srv, int id, IHdmiControlCallback callback) {
        return new DeviceSelectRequest(srv, id, callback, null);
    }

    public static PortSelectRequest newPortSelect(HdmiControlService srv, int id, IHdmiControlCallback callback) {
        return new PortSelectRequest(srv, id, callback, null);
    }

    public void set(SelectRequest request) {
        this.mRequest = request;
    }

    public void process() {
        if (this.mRequest == null) goto L6;
        this.mRequest.process();
        clear();
        return;
    }

    public void clear() {
        this.mRequest = null;
    }
}
