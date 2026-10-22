package android.content.pm;

import android.os.Parcel;

/* loaded from: classes.dex */
public class StepOSApplicationInfoExtImpl implements IStepOSApplicationInfoExt {
    private int mCustomizedCutoutMode = -1;
    private int mOemPrivateFlags;
    private ApplicationInfo mRefApplicationInfo;

    public void init(ApplicationInfo refApplicationInfo) {
        this.mRefApplicationInfo = refApplicationInfo;
    }

    public void init(ApplicationInfo refApplicationInfo, ApplicationInfo orig) {
        IStepOSApplicationInfoExt origExt;
        this.mRefApplicationInfo = refApplicationInfo;
        if (orig != null && (origExt = orig.getStepOSExt()) != null) {
            this.mOemPrivateFlags = origExt.getOemPrivateFlags();
            this.mCustomizedCutoutMode = origExt.getCustomizedCutoutMode();
        }
    }

    public void init(ApplicationInfo refApplicationInfo, Parcel source) {
        this.mRefApplicationInfo = refApplicationInfo;
        this.mOemPrivateFlags = source.readInt();
        this.mCustomizedCutoutMode = source.readInt();
    }

    public void writeToParcel(Parcel dest) {
        dest.writeInt(this.mOemPrivateFlags);
        dest.writeInt(this.mCustomizedCutoutMode);
    }

    public int getOemPrivateFlags() {
        return this.mOemPrivateFlags;
    }

    public void setOemPrivateFlags(int flags) {
        this.mOemPrivateFlags = flags;
    }

    public void addOemPrivateFlags(int flags) {
        this.mOemPrivateFlags |= flags;
    }

    public boolean isSelfDevelopedRemovablePreinstalled() {
        return (this.mOemPrivateFlags & 1) != 0;
    }

    public boolean isThirdPartyRemovablePreinstalled() {
        return (this.mOemPrivateFlags & 2) != 0;
    }

    public boolean isRemovablePreinstalled() {
        return isSelfDevelopedRemovablePreinstalled() || isThirdPartyRemovablePreinstalled();
    }

    public int getCustomizedCutoutMode() {
        return this.mCustomizedCutoutMode;
    }

    public void setCustomizedCutoutMode(int mode) {
        this.mCustomizedCutoutMode = mode;
    }
}
