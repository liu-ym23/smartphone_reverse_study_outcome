package com.android.server.storage;

import android.content.Context;
import android.os.storage.DiskInfo;
import android.os.storage.StorageVolume;
import android.os.storage.VolumeInfo;
import com.android.internal.util.IndentingPrintWriter;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class ImmutableVolumeInfo {
    private final VolumeInfo mVolumeInfo;

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8432clone() throws CloneNotSupportedException {
        return clone();
    }

    private ImmutableVolumeInfo(VolumeInfo volumeInfo) {
        this.mVolumeInfo = new VolumeInfo(volumeInfo);
    }

    public static ImmutableVolumeInfo fromVolumeInfo(VolumeInfo info) {
        return new ImmutableVolumeInfo(info);
    }

    public ImmutableVolumeInfo clone() {
        return fromVolumeInfo(this.mVolumeInfo.clone());
    }

    public StorageVolume buildStorageVolume(Context context, int userId, boolean reportUnmounted) {
        return this.mVolumeInfo.buildStorageVolume(context, userId, reportUnmounted);
    }

    public void dump(IndentingPrintWriter pw) {
        this.mVolumeInfo.dump(pw);
    }

    public DiskInfo getDisk() {
        return this.mVolumeInfo.getDisk();
    }

    public String getDiskId() {
        return this.mVolumeInfo.getDiskId();
    }

    public String getFsLabel() {
        return this.mVolumeInfo.fsLabel;
    }

    public String getFsPath() {
        return this.mVolumeInfo.path;
    }

    public String getFsType() {
        return this.mVolumeInfo.fsType;
    }

    public String getFsUuid() {
        return this.mVolumeInfo.fsUuid;
    }

    public String getId() {
        return this.mVolumeInfo.id;
    }

    public File getInternalPath() {
        return this.mVolumeInfo.getInternalPath();
    }

    public int getMountFlags() {
        return this.mVolumeInfo.mountFlags;
    }

    public int getMountUserId() {
        return this.mVolumeInfo.mountUserId;
    }

    public String getPartGuid() {
        return this.mVolumeInfo.partGuid;
    }

    public File getPath() {
        return this.mVolumeInfo.getPath();
    }

    public int getState() {
        return this.mVolumeInfo.state;
    }

    public int getType() {
        return this.mVolumeInfo.type;
    }

    public VolumeInfo getVolumeInfo() {
        return new VolumeInfo(this.mVolumeInfo);
    }

    public boolean isMountedReadable() {
        return this.mVolumeInfo.isMountedReadable();
    }

    public boolean isMountedWritable() {
        return this.mVolumeInfo.isMountedWritable();
    }

    public boolean isPrimary() {
        return this.mVolumeInfo.isPrimary();
    }

    public boolean isVisible() {
        return this.mVolumeInfo.isVisible();
    }

    public boolean isVisibleForUser(int userId) {
        return this.mVolumeInfo.isVisibleForUser(userId);
    }

    public boolean isVisibleForWrite(int userId) {
        return this.mVolumeInfo.isVisibleForWrite(userId);
    }

    public String toString() {
        return this.mVolumeInfo.toString();
    }
}
