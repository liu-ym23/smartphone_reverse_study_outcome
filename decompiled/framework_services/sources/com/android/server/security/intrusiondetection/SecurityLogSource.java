package com.android.server.security.intrusiondetection;

import android.app.admin.DevicePolicyManager;
import android.app.admin.DevicePolicyManagerInternal;
import android.app.admin.SecurityLog;
import android.content.Context;
import android.security.intrusiondetection.IntrusionDetectionEvent;
import android.util.Slog;
import com.android.server.LocalServices;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes3.dex */
public class SecurityLogSource implements DataSource {
    private static final String TAG = "IntrusionDetection SecurityLogSource";
    private DataAggregator mDataAggregator;
    private DevicePolicyManager mDpm;
    private DevicePolicyManagerInternal mDpmInternal;
    private SecurityEventCallback mEventCallback;

    private class SecurityEventCallback implements Consumer<List<SecurityLog.SecurityEvent>> {
        final /* synthetic */ SecurityLogSource this$0;

        public static /* synthetic */ IntrusionDetectionEvent $r8$lambda$Ot37V1FkWPG4P8eATwgdx5z2QoU(SecurityLog.SecurityEvent r0) {
            return lambda$accept$1(r0);
        }

        public static /* synthetic */ boolean $r8$lambda$fDIaKa09JC15dEtjUjrhxeqNYN8(SecurityLog.SecurityEvent r0) {
            return lambda$accept$0(r0);
        }

        /* synthetic */ SecurityEventCallback(SecurityLogSource r1, SecurityLogSourceIA r2) {
            this(r1);
        }

        private SecurityEventCallback(SecurityLogSource r1) {
            this.this$0 = r1;
        }

        @Override // java.util.function.Consumer
        public /* bridge */ /* synthetic */ void accept(List<SecurityLog.SecurityEvent> r1) {
            accept2(r1);
        }

        /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(List<SecurityLog.SecurityEvent> events) {
            if (events != null) goto L4;
        L8:
            Slog.w(SecurityLogSource.TAG, "No events received; caller may not be authorized");
            return;
        L4:
            if (events.size() == 0) goto L8;
            List<IntrusionDetectionEvent> intrusionDetectionEvents = (List) events.stream().filter(new SecurityLogSource$SecurityEventCallback$$ExternalSyntheticLambda0()).map(new SecurityLogSource$SecurityEventCallback$$ExternalSyntheticLambda1()).collect(Collectors.toList());
            SecurityLogSource.m8059$$Nest$fgetmDataAggregator(this.this$0).addBatchData(intrusionDetectionEvents);
        }

        private static /* synthetic */ boolean lambda$accept$0(SecurityLog.SecurityEvent event) {
            if (event == null) goto L4;
            return true;
        L4:
            return false;
        }

        private static /* synthetic */ IntrusionDetectionEvent lambda$accept$1(SecurityLog.SecurityEvent event) {
            return IntrusionDetectionEvent.createForSecurityEvent(event);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDataAggregator, reason: not valid java name */
    static /* bridge */ /* synthetic */ DataAggregator m8059$$Nest$fgetmDataAggregator(SecurityLogSource r0) {
        return r0.mDataAggregator;
    }

    public SecurityLogSource(Context context, DataAggregator dataAggregator) {
        this.mDataAggregator = dataAggregator;
        this.mDpm = (DevicePolicyManager) context.getSystemService(DevicePolicyManager.class);
        this.mDpmInternal = (DevicePolicyManagerInternal) LocalServices.getService(DevicePolicyManagerInternal.class);
        this.mEventCallback = new SecurityEventCallback(this, null);
    }

    @Override // com.android.server.security.intrusiondetection.DataSource
    public void enable() {
        enableAuditLog();
        this.mDpmInternal.setInternalEventsCallback(this.mEventCallback);
    }

    @Override // com.android.server.security.intrusiondetection.DataSource
    public void disable() {
        this.mDpmInternal.setInternalEventsCallback(null);
        disableAuditLog();
    }

    private void enableAuditLog() {
        if (isAuditLogEnabled() == true) goto L6;
        this.mDpm.setAuditLogEnabled(true);
        return;
    }

    private void disableAuditLog() {
        if (isAuditLogEnabled() == false) goto L6;
        this.mDpm.setAuditLogEnabled(false);
        return;
    }

    private boolean isAuditLogEnabled() {
        return this.mDpm.isAuditLogEnabled();
    }
}
