package com.android.internal.pm.parsing.pkg;

import android.content.pm.ApplicationInfo;
import android.content.res.TypedArray;
import android.os.Parcel;
import com.android.server.pm.pkg.AndroidPackage;

/* loaded from: classes.dex */
public class StepOSPackageImplExtImpl implements IStepOSPackageImplExt {
    private int mBaseAppInfoOemPrivateFlags;
    private int mOemBooleans;
    private PackageImpl mRefPackageImpl;

    public StepOSPackageImplExtImpl() {
    }

    public static class OemBooleans {
        public static final int SELF_DEVELOPED_REMOVABLE_PREINSTALLED = 1;
        public static final int THIRD_PARTY_REMOVABLE_PREINSTALLED = 2;

        public @interface OemFlags {
        }

        private OemBooleans() {
        }
    }

    public StepOSPackageImplExtImpl(PackageImpl base) {
        this.mRefPackageImpl = base;
    }

    public void init(PackageImpl refPackageImpl, Parcel in) {
        this.mRefPackageImpl = refPackageImpl;
        this.mOemBooleans = in.readInt();
    }

    public void init(PackageImpl refPackageImpl, String packageName, String baseApkPath, String path, TypedArray manifestArray, boolean isCoreApp) {
        this.mRefPackageImpl = refPackageImpl;
    }

    public void writeToParcel(Parcel dest) {
        dest.writeInt(this.mOemBooleans);
    }

    public void toAppInfoWithoutState(ApplicationInfo aInfo) {
        aInfo.getStepOSExt().setOemPrivateFlags(this.mBaseAppInfoOemPrivateFlags);
    }

    public void setBaseAppInfoOemPrivateFlags(AndroidPackage pkg) {
        AndroidPackageHidden hidden = (AndroidPackageHidden) pkg;
        this.mBaseAppInfoOemPrivateFlags = (hidden.isSelfDevelopedRemovablePreinstalled() ? 1 : 0) | (hidden.isThirdPartyRemovablePreinstalled() ? 2 : 0);
    }

    private void setOemBoolean(int flag, boolean value) {
        if (value) {
            this.mOemBooleans |= flag;
        } else {
            this.mOemBooleans &= ~flag;
        }
    }

    private boolean getOemBoolean(int flag) {
        return (this.mOemBooleans & flag) != 0;
    }

    public boolean isSelfDevelopedRemovablePreinstalled() {
        return getOemBoolean(1);
    }

    public boolean isThirdPartyRemovablePreinstalled() {
        return getOemBoolean(2);
    }

    public void setSelfDevelopedRemovablePreinstalled(boolean value) {
        setOemBoolean(1, value);
    }

    public void setThirdPartyRemovablePreinstalled(boolean value) {
        setOemBoolean(2, value);
    }
}
