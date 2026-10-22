package android.app;

import android.os.Parcel;

/* loaded from: classes.dex */
public class StepOSTaskInfoExtImpl implements IStepOSTaskInfoExt {
    private int mFlags;
    private TaskInfo mTaskInfo;

    public void onAttach(TaskInfo host) {
        this.mTaskInfo = host;
    }

    public void onDetach() {
        this.mTaskInfo = null;
    }

    public void init(TaskInfo info) {
        this.mTaskInfo = info;
        this.mFlags = 0;
    }

    public void init(TaskInfo info, Parcel source) {
        this.mTaskInfo = info;
        this.mFlags = source.readInt();
    }

    public void writeToParcel(Parcel dest) {
        dest.writeInt(this.mFlags);
    }

    public int getStepOSFlags() {
        return this.mFlags;
    }

    public void addStepOSFlags(int flags) {
        this.mFlags |= flags;
    }

    public boolean equalsForTaskOrganizer(IStepOSTaskInfoExt that) {
        return that != null && this.mFlags == that.getStepOSFlags();
    }

    public boolean isSplitScreenUnsupported() {
        return (this.mFlags & 1) != 0;
    }
}
