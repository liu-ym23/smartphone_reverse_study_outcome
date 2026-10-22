package com.android.server.devicepolicy;

import android.app.admin.DevicePolicySafetyChecker;
import android.content.Context;
import android.os.RecoverySystem;
import android.os.UserManager;
import android.os.storage.StorageManager;
import android.service.persistentdata.PersistentDataBlockManager;
import com.android.internal.os.IResultReceiver;
import com.android.internal.util.Preconditions;
import com.android.server.utils.Slogf;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public final class FactoryResetter {
    private static final String TAG = null;
    private final Context mContext;
    private final boolean mForce;
    private final String mReason;
    private final DevicePolicySafetyChecker mSafetyChecker;
    private final boolean mShutdown;
    private final boolean mWipeAdoptableStorage;
    private final boolean mWipeEuicc;
    private final boolean mWipeFactoryResetProtection;

    public static final class Builder {
        private final Context mContext;
        private boolean mForce;
        private String mReason;
        private DevicePolicySafetyChecker mSafetyChecker;
        private boolean mShutdown;
        private boolean mWipeAdoptableStorage;
        private boolean mWipeEuicc;
        private boolean mWipeFactoryResetProtection;

        /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
        static /* bridge */ /* synthetic */ Context m3493$$Nest$fgetmContext(Builder r0) {
            return r0.mContext;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmForce, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m3494$$Nest$fgetmForce(Builder r0) {
            return r0.mForce;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmReason, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m3495$$Nest$fgetmReason(Builder r0) {
            return r0.mReason;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmSafetyChecker, reason: not valid java name */
        static /* bridge */ /* synthetic */ DevicePolicySafetyChecker m3496$$Nest$fgetmSafetyChecker(Builder r0) {
            return r0.mSafetyChecker;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmShutdown, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m3497$$Nest$fgetmShutdown(Builder r0) {
            return r0.mShutdown;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmWipeAdoptableStorage, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m3498$$Nest$fgetmWipeAdoptableStorage(Builder r0) {
            return r0.mWipeAdoptableStorage;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmWipeEuicc, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m3499$$Nest$fgetmWipeEuicc(Builder r0) {
            return r0.mWipeEuicc;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmWipeFactoryResetProtection, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m3500$$Nest$fgetmWipeFactoryResetProtection(Builder r0) {
            return r0.mWipeFactoryResetProtection;
        }

        /* synthetic */ Builder(Context r1, FactoryResetterIA r2) {
            this(r1);
        }

        private Builder(Context context) {
            context.getClass();
            this.mContext = context;
        }

        public Builder setSafetyChecker(DevicePolicySafetyChecker safetyChecker) {
            this.mSafetyChecker = safetyChecker;
            return this;
        }

        public Builder setReason(String reason) {
            reason.getClass();
            this.mReason = reason;
            return this;
        }

        public Builder setShutdown(boolean value) {
            this.mShutdown = value;
            return this;
        }

        public Builder setForce(boolean value) {
            this.mForce = value;
            return this;
        }

        public Builder setWipeEuicc(boolean value) {
            this.mWipeEuicc = value;
            return this;
        }

        public Builder setWipeAdoptableStorage(boolean value) {
            this.mWipeAdoptableStorage = value;
            return this;
        }

        public Builder setWipeFactoryResetProtection(boolean value) {
            this.mWipeFactoryResetProtection = value;
            return this;
        }

        public FactoryResetter build() {
            return new FactoryResetter(this, null);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSafetyChecker, reason: not valid java name */
    static /* bridge */ /* synthetic */ DevicePolicySafetyChecker m3490$$Nest$fgetmSafetyChecker(FactoryResetter r0) {
        return r0.mSafetyChecker;
    }

    /* JADX INFO: renamed from: -$$Nest$mfactoryResetInternalUnchecked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3491$$Nest$mfactoryResetInternalUnchecked(FactoryResetter r0) {
        r0.factoryResetInternalUnchecked();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m3492$$Nest$sfgetTAG() {
        return TAG;
    }

    /* synthetic */ FactoryResetter(Builder r1, FactoryResetterIA r2) {
        this(r1);
    }

    static {
        TAG = FactoryResetter.class.getSimpleName();
    }

    public boolean factoryReset() throws IOException {
        if (this.mContext.checkCallingOrSelfPermission("android.permission.MASTER_CLEAR") != 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkCallAuthorization(r0);
        com.android.server.FactoryResetter.setFactoryResetting(this.mContext);
        if (this.mSafetyChecker != null) goto L10;
        factoryResetInternalUnchecked();
        return true;
    L10:
        IResultReceiver.Stub r1 = new AnonymousClass1(this);
        Slogf.i(TAG, "Delaying factory reset until %s confirms", new Object[]{this.mSafetyChecker});
        this.mSafetyChecker.onFactoryReset(r1);
        return false;
    L5:
        r0 = false;
        goto L6
    }

    public String toString() {
        StringBuilder builder = new StringBuilder("FactoryResetter[");
        if (this.mReason != null) goto L5;
        builder.append("no_reason");
    L7:
        if (this.mSafetyChecker == null) goto L10;
        builder.append(",hasSafetyChecker");
    L10:
        if (this.mShutdown == false) goto L13;
        builder.append(",shutdown");
    L13:
        if (this.mForce == false) goto L16;
        builder.append(",force");
    L16:
        if (this.mWipeEuicc == false) goto L19;
        builder.append(",wipeEuicc");
    L19:
        if (this.mWipeAdoptableStorage == false) goto L22;
        builder.append(",wipeAdoptableStorage");
    L22:
        if (this.mWipeFactoryResetProtection == false) goto L24;
        builder.append(",ipeFactoryResetProtection");
    L24:
        builder.append(']');
        return builder.toString();
    L5:
        builder.append("reason='");
        builder.append(this.mReason);
        builder.append("'");
        goto L7
    }

    private void factoryResetInternalUnchecked() throws IOException {
        Slogf.i(TAG, "factoryReset(): reason=%s, shutdown=%b, force=%b, wipeEuicc=%b, wipeAdoptableStorage=%b, wipeFRP=%b", new Object[]{this.mReason, Boolean.valueOf(this.mShutdown), Boolean.valueOf(this.mForce), Boolean.valueOf(this.mWipeEuicc), Boolean.valueOf(this.mWipeAdoptableStorage), Boolean.valueOf(this.mWipeFactoryResetProtection)});
        UserManager um = (UserManager) this.mContext.getSystemService(UserManager.class);
        if (this.mForce == true) goto L10;
        if (um.hasUserRestriction("no_factory_reset") == false) goto L10;
        throw new SecurityException("Factory reset is not allowed for this user.");
    L10:
        if (this.mWipeFactoryResetProtection == false) goto L16;
        PersistentDataBlockManager manager = (PersistentDataBlockManager) this.mContext.getSystemService(PersistentDataBlockManager.class);
        if (manager == null) goto L14;
        Slogf.w(TAG, "Wiping factory reset protection");
        manager.wipe();
        goto L16
    L14:
        Slogf.w(TAG, "No need to wipe factory reset protection");
    L16:
        if (this.mWipeAdoptableStorage == false) goto L18;
        Slogf.w(TAG, "Wiping adoptable storage");
        StorageManager sm = (StorageManager) this.mContext.getSystemService(StorageManager.class);
        sm.wipeAdoptableDisks();
    L18:
        RecoverySystem.rebootWipeUserData(this.mContext, this.mShutdown, this.mReason, this.mForce, this.mWipeEuicc);
    }

    private FactoryResetter(Builder builder) {
        this.mContext = Builder.m3493$$Nest$fgetmContext(builder);
        this.mSafetyChecker = Builder.m3496$$Nest$fgetmSafetyChecker(builder);
        this.mReason = Builder.m3495$$Nest$fgetmReason(builder);
        this.mShutdown = Builder.m3497$$Nest$fgetmShutdown(builder);
        this.mForce = Builder.m3494$$Nest$fgetmForce(builder);
        this.mWipeEuicc = Builder.m3499$$Nest$fgetmWipeEuicc(builder);
        this.mWipeAdoptableStorage = Builder.m3498$$Nest$fgetmWipeAdoptableStorage(builder);
        this.mWipeFactoryResetProtection = Builder.m3500$$Nest$fgetmWipeFactoryResetProtection(builder);
    }

    public static Builder newBuilder(Context context) {
        return new Builder(context, null);
    }
}
