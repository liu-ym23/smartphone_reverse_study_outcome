package com.android.server.contentprotection;

import android.os.Handler;
import android.os.UserHandle;
import android.service.contentcapture.IContentProtectionAllowlistCallback;
import android.util.Slog;
import com.android.internal.content.PackageMonitor;
import com.android.server.contentcapture.ContentCaptureManagerService;
import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes.dex */
public class ContentProtectionAllowlistManager {
    private static final String TAG = "ContentProtectionAllowlistManager";
    private Set<String> mAllowedPackages;
    final IContentProtectionAllowlistCallback mAllowlistCallback;
    private final ContentCaptureManagerService mContentCaptureManagerService;
    private final Handler mHandler;
    private final Object mHandlerToken;
    private final Object mLock;
    final PackageMonitor mPackageMonitor;
    private boolean mStarted;
    private final long mTimeoutMs;
    private Instant mUpdatePendingUntil;

    private final class ContentProtectionAllowlistCallback extends IContentProtectionAllowlistCallback.Stub {
        final /* synthetic */ ContentProtectionAllowlistManager this$0;

        /* JADX INFO: renamed from: $r8$lambda$ajOm1tW_3f7Iz-_ZsWNp4-bD5T0, reason: not valid java name */
        public static /* synthetic */ void m3234$r8$lambda$ajOm1tW_3f7Iz_ZsWNp4bD5T0(ContentProtectionAllowlistCallback r0, List r1) {
            r0.lambda$setAllowlist$0(r1);
        }

        /* synthetic */ ContentProtectionAllowlistCallback(ContentProtectionAllowlistManager r1, ContentProtectionAllowlistManagerIA r2) {
            this(r1);
        }

        private ContentProtectionAllowlistCallback(ContentProtectionAllowlistManager r1) {
            this.this$0 = r1;
        }

        private /* synthetic */ void lambda$setAllowlist$0(List packages) {
            ContentProtectionAllowlistManager.m3233$$Nest$mhandleUpdateAllowlistResponse(this.this$0, packages);
        }

        public void setAllowlist(final List<String> packages) {
            ContentProtectionAllowlistManager.m3231$$Nest$fgetmHandler(this.this$0).post(new ContentProtectionAllowlistManager$ContentProtectionAllowlistCallback$$ExternalSyntheticLambda0(this, packages));
        }
    }

    private final class ContentProtectionPackageMonitor extends PackageMonitor {
        final /* synthetic */ ContentProtectionAllowlistManager this$0;

        /* synthetic */ ContentProtectionPackageMonitor(ContentProtectionAllowlistManager r1, ContentProtectionAllowlistManagerIA r2) {
            this(r1);
        }

        private ContentProtectionPackageMonitor(ContentProtectionAllowlistManager r1) {
            this.this$0 = r1;
        }

        public void onSomePackagesChanged() {
            ContentProtectionAllowlistManager.m3232$$Nest$mhandlePackagesChanged(this.this$0);
        }
    }

    public static /* synthetic */ void $r8$lambda$zfpJCoD6qamGn7eFKJ1PeYZcgu0(ContentProtectionAllowlistManager r0) {
        r0.handleInitialUpdate();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m3231$$Nest$fgetmHandler(ContentProtectionAllowlistManager r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$mhandlePackagesChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3232$$Nest$mhandlePackagesChanged(ContentProtectionAllowlistManager r0) {
        r0.handlePackagesChanged();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleUpdateAllowlistResponse, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3233$$Nest$mhandleUpdateAllowlistResponse(ContentProtectionAllowlistManager r0, List r1) {
        r0.handleUpdateAllowlistResponse(r1);
    }

    public ContentProtectionAllowlistManager(ContentCaptureManagerService contentCaptureManagerService, Handler handler, long timeoutMs) {
        this.mHandlerToken = new Object();
        this.mLock = new Object();
        this.mAllowedPackages = Set.of();
        this.mContentCaptureManagerService = contentCaptureManagerService;
        this.mHandler = handler;
        this.mTimeoutMs = timeoutMs;
        this.mPackageMonitor = createPackageMonitor();
        this.mAllowlistCallback = createAllowlistCallback();
    }

    public void start(long delayMs) {
        if (this.mStarted == false) goto L5;
        return;
    L5:
        this.mStarted = true;
        this.mHandler.postDelayed(new ContentProtectionAllowlistManager$$ExternalSyntheticLambda0(this), this.mHandlerToken, delayMs);
    }

    public void stop() {
        this.mPackageMonitor.unregister();     // Catch: IllegalStateException -> L4
    L5:
        this.mHandler.removeCallbacksAndMessages(this.mHandlerToken);
        this.mUpdatePendingUntil = null;
        this.mStarted = false;
    }

    public boolean isAllowed(String packageName) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Set<String> allowedPackages = this.mAllowedPackages;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return allowedPackages.contains(packageName);
    L8:
        th = move-exception;
        throw th;
    }

    private void handleUpdateAllowlistResponse(List<String> packages) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mAllowedPackages = (Set) packages.stream().collect(Collectors.toUnmodifiableSet());     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mUpdatePendingUntil = null;
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void handleInitialUpdate() {
        handlePackagesChanged();
        this.mPackageMonitor.register(this.mContentCaptureManagerService.getContext(), UserHandle.ALL, this.mHandler);
    }

    private void handlePackagesChanged() {
        if (this.mUpdatePendingUntil != null) goto L5;
    L7:
        RemoteContentProtectionService remoteContentProtectionService = this.mContentCaptureManagerService.createRemoteContentProtectionService();
        if (remoteContentProtectionService != null) goto L10;
        return;
    L10:
        this.mHandler.removeCallbacksAndMessages(this.mHandlerToken);
        this.mUpdatePendingUntil = Instant.now().plusMillis(this.mTimeoutMs);
        remoteContentProtectionService.onUpdateAllowlistRequest(this.mAllowlistCallback);     // Catch: Exception -> L13
        return;
    L13:
        ex = move-exception;
        Slog.e(TAG, "Failed to call remote service", ex);
        return;
    L5:
        if (Instant.now().isBefore(this.mUpdatePendingUntil) == false) goto L7;
    }

    protected PackageMonitor createPackageMonitor() {
        return new ContentProtectionPackageMonitor(this, null);
    }

    protected IContentProtectionAllowlistCallback createAllowlistCallback() {
        return new ContentProtectionAllowlistCallback(this, null);
    }
}
