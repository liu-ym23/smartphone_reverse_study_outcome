package com.android.server.hdmi;

import android.util.SparseArray;

/* JADX INFO: loaded from: classes2.dex */
public final class HdmiCecStandbyModeHandler {
    private final CecMessageHandler mAborterIncorrectMode;
    private final CecMessageHandler mAborterRefused;
    private final CecMessageHandler mAborterUnrecognizedOpcode;
    private final CecMessageHandler mAutoOnHandler;
    private final CecMessageHandler mBypasser;
    private final CecMessageHandler mBystander;
    private final SparseArray<CecMessageHandler> mCecMessageHandlers;
    private final CecMessageHandler mDefaultHandler;
    private final HdmiCecLocalDevice mDevice;
    private final HdmiControlService mService;
    private final UserControlProcessedHandler mUserControlProcessedHandler;

    private final class Aborter implements CecMessageHandler {
        private final int mReason;
        final /* synthetic */ HdmiCecStandbyModeHandler this$0;

        public Aborter(HdmiCecStandbyModeHandler r1, int reason) {
            this.this$0 = r1;
            this.mReason = reason;
        }

        @Override // com.android.server.hdmi.HdmiCecStandbyModeHandler.CecMessageHandler
        public boolean handle(HdmiCecMessage message) {
            HdmiCecStandbyModeHandler.m4331$$Nest$fgetmService(this.this$0).maySendFeatureAbortCommand(message, this.mReason);
            return true;
        }
    }

    private final class AutoOnHandler implements CecMessageHandler {
        final /* synthetic */ HdmiCecStandbyModeHandler this$0;

        /* synthetic */ AutoOnHandler(HdmiCecStandbyModeHandler r1, HdmiCecStandbyModeHandlerIA r2) {
            this(r1);
        }

        private AutoOnHandler(HdmiCecStandbyModeHandler r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.hdmi.HdmiCecStandbyModeHandler.CecMessageHandler
        public boolean handle(HdmiCecMessage message) {
            HdmiCecLocalDeviceTv tv = (HdmiCecLocalDeviceTv) HdmiCecStandbyModeHandler.m4330$$Nest$fgetmDevice(this.this$0);
            if (tv.getAutoWakeup() == true) goto L6;
            HdmiCecStandbyModeHandler.m4329$$Nest$fgetmAborterRefused(this.this$0).handle(message);
            return true;
        L6:
            return false;
        }
    }

    private static final class Bypasser implements CecMessageHandler {
        /* synthetic */ Bypasser(HdmiCecStandbyModeHandlerIA r1) {
            this();
        }

        private Bypasser() {
        }

        @Override // com.android.server.hdmi.HdmiCecStandbyModeHandler.CecMessageHandler
        public boolean handle(HdmiCecMessage message) {
            return false;
        }
    }

    private static final class Bystander implements CecMessageHandler {
        /* synthetic */ Bystander(HdmiCecStandbyModeHandlerIA r1) {
            this();
        }

        private Bystander() {
        }

        @Override // com.android.server.hdmi.HdmiCecStandbyModeHandler.CecMessageHandler
        public boolean handle(HdmiCecMessage message) {
            return true;
        }
    }

    private interface CecMessageHandler {
        boolean handle(HdmiCecMessage r1);
    }

    private final class UserControlProcessedHandler implements CecMessageHandler {
        final /* synthetic */ HdmiCecStandbyModeHandler this$0;

        /* synthetic */ UserControlProcessedHandler(HdmiCecStandbyModeHandler r1, HdmiCecStandbyModeHandlerIA r2) {
            this(r1);
        }

        private UserControlProcessedHandler(HdmiCecStandbyModeHandler r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.hdmi.HdmiCecStandbyModeHandler.CecMessageHandler
        public boolean handle(HdmiCecMessage message) {
            if (HdmiCecLocalDevice.isPowerOnOrToggleCommand(message) == false) goto L7;
            return false;
        L7:
            if (HdmiCecLocalDevice.isPowerOffOrToggleCommand(message) == false) goto L11;
            return true;
        L11:
            return HdmiCecStandbyModeHandler.m4328$$Nest$fgetmAborterIncorrectMode(this.this$0).handle(message);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAborterIncorrectMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ CecMessageHandler m4328$$Nest$fgetmAborterIncorrectMode(HdmiCecStandbyModeHandler r0) {
        return r0.mAborterIncorrectMode;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAborterRefused, reason: not valid java name */
    static /* bridge */ /* synthetic */ CecMessageHandler m4329$$Nest$fgetmAborterRefused(HdmiCecStandbyModeHandler r0) {
        return r0.mAborterRefused;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDevice, reason: not valid java name */
    static /* bridge */ /* synthetic */ HdmiCecLocalDevice m4330$$Nest$fgetmDevice(HdmiCecStandbyModeHandler r0) {
        return r0.mDevice;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmService, reason: not valid java name */
    static /* bridge */ /* synthetic */ HdmiControlService m4331$$Nest$fgetmService(HdmiCecStandbyModeHandler r0) {
        return r0.mService;
    }

    private void addCommonHandlers() {
        addHandler(68, this.mUserControlProcessedHandler);
    }

    private void addTvHandlers() {
        addHandler(130, this.mBystander);
        addHandler(133, this.mBystander);
        addHandler(128, this.mBystander);
        addHandler(129, this.mBystander);
        addHandler(134, this.mBystander);
        addHandler(54, this.mBystander);
        addHandler(50, this.mBystander);
        addHandler(69, this.mBystander);
        addHandler(0, this.mBystander);
        addHandler(157, this.mBystander);
        addHandler(126, this.mBystander);
        addHandler(122, this.mBystander);
        addHandler(131, this.mBypasser);
        addHandler(145, this.mBypasser);
        addHandler(132, this.mBypasser);
        addHandler(140, this.mBypasser);
        addHandler(70, this.mBypasser);
        addHandler(71, this.mBypasser);
        addHandler(135, this.mBypasser);
        addHandler(144, this.mBypasser);
        addHandler(165, this.mBypasser);
        addHandler(143, this.mBypasser);
        addHandler(255, this.mBypasser);
        addHandler(159, this.mBypasser);
        addHandler(160, this.mAborterIncorrectMode);
        addHandler(114, this.mAborterIncorrectMode);
        addHandler(4, this.mAutoOnHandler);
        addHandler(13, this.mAutoOnHandler);
        addHandler(10, this.mBystander);
        addHandler(15, this.mAborterIncorrectMode);
        addHandler(192, this.mAborterIncorrectMode);
        addHandler(197, this.mAborterIncorrectMode);
    }

    public HdmiCecStandbyModeHandler(HdmiControlService service, HdmiCecLocalDevice device) {
        this.mCecMessageHandlers = new SparseArray();
        this.mAborterUnrecognizedOpcode = new Aborter(this, 0);
        this.mAborterIncorrectMode = new Aborter(this, 1);
        this.mAborterRefused = new Aborter(this, 4);
        HdmiCecStandbyModeHandlerIA r1 = null;
        this.mAutoOnHandler = new AutoOnHandler(this, r1);
        this.mBypasser = new Bypasser(r1);
        this.mBystander = new Bystander(r1);
        this.mUserControlProcessedHandler = new UserControlProcessedHandler(this, r1);
        this.mService = service;
        this.mDevice = device;
        addCommonHandlers();
        if (this.mDevice.getType() != 0) goto L5;
        addTvHandlers();
        this.mDefaultHandler = this.mAborterUnrecognizedOpcode;
        return;
    L5:
        this.mDefaultHandler = this.mBypasser;
    }

    private void addHandler(int opcode, CecMessageHandler handler) {
        this.mCecMessageHandlers.put(opcode, handler);
    }

    boolean handleCommand(HdmiCecMessage message) {
        CecMessageHandler handler = this.mCecMessageHandlers.get(message.getOpcode());
        if (handler == null) goto L7;
        return handler.handle(message);
    L7:
        return this.mDefaultHandler.handle(message);
    }
}
