package com.android.server.storage;

import android.content.Context;
import android.os.storage.DiskInfo;
import android.os.storage.StorageVolume;
import android.os.storage.VolumeInfo;
import com.android.internal.util.IndentingPrintWriter;
import com.android.server.utils.WatchableImpl;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class WatchedVolumeInfo extends WatchableImpl {
    private final VolumeInfo mVolumeInfo;

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8442clone() throws CloneNotSupportedException {
        return clone();
    }

    private WatchedVolumeInfo(VolumeInfo volumeInfo) {
        this.mVolumeInfo = volumeInfo;
    }

    public WatchedVolumeInfo(WatchedVolumeInfo watchedVolumeInfo) {
        this.mVolumeInfo = new VolumeInfo(watchedVolumeInfo.mVolumeInfo);
    }

    public static WatchedVolumeInfo fromVolumeInfo(VolumeInfo info) {
        return new WatchedVolumeInfo(info);
    }

    public WatchedVolumeInfo clone() {
        return fromVolumeInfo(this.mVolumeInfo.clone());
    }

    public ImmutableVolumeInfo getImmutableVolumeInfo() {
        return ImmutableVolumeInfo.fromVolumeInfo(this.mVolumeInfo);
    }

    public ImmutableVolumeInfo getClonedImmutableVolumeInfo() {
        return ImmutableVolumeInfo.fromVolumeInfo(this.mVolumeInfo.clone());
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

    public void setFsLabel(String fsLabel) {
        this.mVolumeInfo.fsLabel = fsLabel;
        dispatchChange(this);
    }

    public String getFsPath() {
        return this.mVolumeInfo.path;
    }

    public void setFsPath(String path) {
        this.mVolumeInfo.path = path;
        dispatchChange(this);
    }

    public String getFsType() {
        return this.mVolumeInfo.fsType;
    }

    public void setFsType(String fsType) {
        this.mVolumeInfo.fsType = fsType;
        dispatchChange(this);
    }

    public String getFsUuid() {
        return this.mVolumeInfo.fsUuid;
    }

    public void setFsUuid(String fsUuid) {
        this.mVolumeInfo.fsUuid = fsUuid;
        dispatchChange(this);
    }

    public String getId() {
        return this.mVolumeInfo.id;
    }

    public File getInternalPath() {
        return this.mVolumeInfo.getInternalPath();
    }

    public void setInternalPath(String internalPath) {
        this.mVolumeInfo.internalPath = internalPath;
        dispatchChange(this);
    }

    public int getMountFlags() {
        return this.mVolumeInfo.mountFlags;
    }

    public void setMountFlags(int mountFlags) {
        this.mVolumeInfo.mountFlags = mountFlags;
        dispatchChange(this);
    }

    public int getMountUserId() {
        return this.mVolumeInfo.mountUserId;
    }

    public void setMountUserId(int mountUserId) {
        this.mVolumeInfo.mountUserId = mountUserId;
        dispatchChange(this);
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

    public int getState(int state) {
        return this.mVolumeInfo.state;
    }

    public void setState(int state) {
        this.mVolumeInfo.state = state;
        dispatchChange(this);
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
