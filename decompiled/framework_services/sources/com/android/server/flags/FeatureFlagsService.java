package com.android.server.flags;

import android.content.Context;
import android.flags.FeatureFlags;
import android.flags.IFeatureFlags;
import android.util.Slog;
import com.android.server.SystemService;

/* JADX INFO: loaded from: classes2.dex */
public class FeatureFlagsService extends SystemService {
    static final String TAG = "FeatureFlagsService";
    private final FlagOverrideStore mFlagStore;
    private final FlagsShellCommand mShellCommand;

    public static class PermissionsChecker {
        private final Context mContext;

        public PermissionsChecker(Context context) {
            this.mContext = context;
        }

        public void assertSyncPermission() {
            if (this.mContext.checkCallingOrSelfPermission("android.permission.SYNC_FLAGS") != 0) goto L6;
            return;
        L6:
            throw new SecurityException("Non-core flag queried. Requires SYNC_FLAGS permission!");
        }

        public void assertWritePermission() {
            if (this.mContext.checkCallingPermission("android.permission.WRITE_FLAGS") != 0) goto L6;
            return;
        L6:
            throw new SecurityException("Requires WRITE_FLAGS permission!");
        }
    }

    public FeatureFlagsService(Context context) {
        super(context);
        this.mFlagStore = new FlagOverrideStore(new GlobalSettingsProxy(context.getContentResolver()));
        this.mShellCommand = new FlagsShellCommand(this.mFlagStore);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        Slog.d(TAG, "Started Feature Flag Service");
        IFeatureFlags.Stub r0 = new FeatureFlagsBinder(this.mFlagStore, this.mShellCommand, new PermissionsChecker(getContext()));
        publishBinderService("feature_flags", r0);
        publishLocalService(FeatureFlags.class, new FeatureFlags(r0));
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        super.onBootPhase(phase);
        if (phase != 500) goto L6;
        FeatureFlags.getInstance().sync();
        return;
    }
}
