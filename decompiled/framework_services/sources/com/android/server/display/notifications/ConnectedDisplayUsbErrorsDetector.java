package com.android.server.display.notifications;

import android.content.Context;
import android.hardware.usb.DisplayPortAltModeInfo;
import android.hardware.usb.UsbManager;
import android.util.Slog;
import com.android.server.display.feature.DisplayManagerFlags;

/* JADX INFO: loaded from: classes2.dex */
public class ConnectedDisplayUsbErrorsDetector implements UsbManager.DisplayPortAltModeInfoListener {
    private static final String TAG = "ConnectedDisplayUsbErrorsDetector";
    private final Context mContext;
    private final Injector mInjector;
    private final boolean mIsConnectedDisplayErrorHandlingEnabled;
    private Listener mListener;

    public interface Injector {
        UsbManager getUsbManager();
    }

    public interface Listener {
        void onCableNotCapableDisplayPort();

        void onDisplayPortLinkTrainingFailure();
    }

    public static /* synthetic */ UsbManager $r8$lambda$PN4BrLCfdXQAp9PYfft5KYnxARY(Context r0) {
        return lambda$new$0(r0);
    }

    ConnectedDisplayUsbErrorsDetector(DisplayManagerFlags flags, final Context context) {
        this(flags, context, new ConnectedDisplayUsbErrorsDetector$$ExternalSyntheticLambda0(context));
    }

    private static /* synthetic */ UsbManager lambda$new$0(Context context) {
        return (UsbManager) context.getSystemService(UsbManager.class);
    }

    ConnectedDisplayUsbErrorsDetector(DisplayManagerFlags flags, Context context, Injector injector) {
        this.mContext = context;
        this.mInjector = injector;
        this.mIsConnectedDisplayErrorHandlingEnabled = flags.isConnectedDisplayErrorHandlingEnabled();
    }

    void registerListener(Listener listener) {
        if (this.mIsConnectedDisplayErrorHandlingEnabled == true) goto L5;
        return;
    L5:
        UsbManager usbManager = this.mInjector.getUsbManager();
        if (usbManager != null) goto L9;
        Slog.e(TAG, "UsbManager is null");
        return;
    L9:
        this.mListener = listener;
        usbManager.registerDisplayPortAltModeInfoListener(this.mContext.getMainExecutor(), this);     // Catch: IllegalStateException -> L12
        return;
    L12:
        e = move-exception;
        Slog.e(TAG, "Failed to register listener", e);
    }

    public void onDisplayPortAltModeInfoChanged(String portId, DisplayPortAltModeInfo info) {
        if (this.mListener != null) goto L6;
        return;
    L6:
        if (2 != info.getPartnerSinkStatus()) goto L12;
        if (1 != info.getCableStatus()) goto L12;
        this.mListener.onCableNotCapableDisplayPort();
        return;
    L12:
        if (2 != info.getLinkTrainingStatus()) goto L15;
        this.mListener.onDisplayPortLinkTrainingFailure();
        return;
    }
}
