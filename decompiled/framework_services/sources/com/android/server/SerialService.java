package com.android.server;

import android.R;
import android.content.Context;
import android.hardware.ISerialManager;
import android.hardware.SerialManagerInternal;
import android.os.ParcelFileDescriptor;
import android.os.PermissionEnforcer;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Slog;
import java.io.File;
import java.io.FileDescriptor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public class SerialService extends ISerialManager.Stub {
    private static final String PREFIX_VIRTUAL = "virtual:";
    private static final String TAG = "SerialService";
    private final Context mContext;
    private final SerialManagerInternal mInternal;
    private final LinkedHashMap<String, Supplier<ParcelFileDescriptor>> mSerialPorts;

    public static class Lifecycle extends SystemService {
        private SerialService mService;

        public Lifecycle(Context context) {
            super(context);
        }

        @Override // com.android.server.SystemService
        public void onStart() {
            this.mService = new SerialService(getContext());
            publishBinderService("serial", this.mService);
            publishLocalService(SerialManagerInternal.class, SerialService.m305$$Nest$fgetmInternal(this.mService));
        }
    }

    public static /* synthetic */ ParcelFileDescriptor $r8$lambda$LK872c4oRhwS3trdsecKSyuUPUM(String r0) {
        return lambda$new$0(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ SerialManagerInternal m305$$Nest$fgetmInternal(SerialService r0) {
        return r0.mInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSerialPorts, reason: not valid java name */
    static /* bridge */ /* synthetic */ LinkedHashMap m306$$Nest$fgetmSerialPorts(SerialService r0) {
        return r0.mSerialPorts;
    }

    public SerialService(Context context) {
        super(PermissionEnforcer.fromContext(context));
        this.mSerialPorts = new LinkedHashMap();
        this.mInternal = new AnonymousClass1(this);
        this.mContext = context;
        LinkedHashMap<String, Supplier<ParcelFileDescriptor>> r0 = this.mSerialPorts;
        monitor-enter(r0);
        String[] serialPorts = getSerialPorts(context);     // Catch: Throwable -> L8
        int r2 = serialPorts.length;     // Catch: Throwable -> L8
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L10;
        final String serialPort = serialPorts[r3];     // Catch: Throwable -> L8
        this.mSerialPorts.put(serialPort, new SerialService$$ExternalSyntheticLambda0(serialPort));     // Catch: Throwable -> L8
        r3 = r3 + 1;     // Catch: Throwable -> L8
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ ParcelFileDescriptor lambda$new$0(String serialPort) {
        return tryOpen(serialPort);
    }

    private static String[] getSerialPorts(Context context) {
        return context.getResources().getStringArray(R.array.config_trustedAccessibilityServices);
    }

    public String[] getSerialPorts() {
        super.getSerialPorts_enforcePermission();
        LinkedHashMap<String, Supplier<ParcelFileDescriptor>> r0 = this.mSerialPorts;
        monitor-enter(r0);
        ArrayList<String> ports = new ArrayList();     // Catch: Throwable -> L12
        Iterator<String> r2 = this.mSerialPorts.keySet().iterator();     // Catch: Throwable -> L12
    L6:
        if (r2.hasNext() == false) goto L16;
        String path = r2.next();     // Catch: Throwable -> L12
        if (path.startsWith(PREFIX_VIRTUAL) == true) goto L14;
        if (new File(path).exists() == false) goto L6;
    L14:
        ports.add(path);     // Catch: Throwable -> L12
        goto L6
    L16:
        String[] r3 = (String[]) ports.toArray(new String[ports.size()]);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r3;
    L12:
        th = move-exception;
        throw th;
    }

    public ParcelFileDescriptor openSerialPort(String path) {
        super.openSerialPort_enforcePermission();
        LinkedHashMap<String, Supplier<ParcelFileDescriptor>> r0 = this.mSerialPorts;
        monitor-enter(r0);
        Supplier<ParcelFileDescriptor> supplier = this.mSerialPorts.get(path);     // Catch: Throwable -> L9
        if (supplier == null) goto L12;
        ParcelFileDescriptor r2 = supplier.get();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L12:
        throw new IllegalArgumentException("Invalid serial port " + path);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private static ParcelFileDescriptor tryOpen(String path) {
        FileDescriptor fd = Os.open(path, OsConstants.O_RDWR | OsConstants.O_NOCTTY, 0);     // Catch: ErrnoException -> L4
        return new ParcelFileDescriptor(fd);
    L4:
        e = move-exception;
        Slog.e(TAG, "Could not open: " + path, e);
        return null;
    }
}
