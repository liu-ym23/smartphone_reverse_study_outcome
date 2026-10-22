package com.android.server.pm.pkg;

import android.annotation.CurrentTimeMillisLong;
import android.annotation.NonNull;
import android.content.ComponentName;
import com.android.internal.util.AnnotationValidations;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class ArchiveState {
    private final List<ArchiveActivityInfo> mActivityInfos;
    private final long mArchiveTimeMillis;
    private final String mInstallerTitle;

    public static class ArchiveActivityInfo {
        private final Path mIconBitmap;
        private final Path mMonochromeIconBitmap;
        private final ComponentName mOriginalComponentName;
        private final String mTitle;

        public ArchiveActivityInfo(String title, ComponentName originalComponentName, Path iconBitmap, Path monochromeIconBitmap) {
            this.mTitle = title;
            AnnotationValidations.validate(NonNull.class, null, this.mTitle);
            this.mOriginalComponentName = originalComponentName;
            AnnotationValidations.validate(NonNull.class, null, this.mOriginalComponentName);
            this.mIconBitmap = iconBitmap;
            this.mMonochromeIconBitmap = monochromeIconBitmap;
        }

        public String getTitle() {
            return this.mTitle;
        }

        public ComponentName getOriginalComponentName() {
            return this.mOriginalComponentName;
        }

        public Path getIconBitmap() {
            return this.mIconBitmap;
        }

        public Path getMonochromeIconBitmap() {
            return this.mMonochromeIconBitmap;
        }

        public String toString() {
            return "ArchiveActivityInfo { title = " + this.mTitle + ", originalComponentName = " + this.mOriginalComponentName + ", iconBitmap = " + this.mIconBitmap + ", monochromeIconBitmap = " + this.mMonochromeIconBitmap + " }";
        }

        public boolean equals(Object o) {
            if (this != o) goto L6;
            return true;
        L6:
            if (o != null) goto L8;
        L21:
            return false;
        L8:
            if (getClass() != o.getClass()) goto L21;
            ArchiveActivityInfo that = (ArchiveActivityInfo) o;
            if (Objects.equals(this.mTitle, that.mTitle) == false) goto L20;
            if (Objects.equals(this.mOriginalComponentName, that.mOriginalComponentName) == false) goto L20;
            if (Objects.equals(this.mIconBitmap, that.mIconBitmap) == false) goto L20;
            if (Objects.equals(this.mMonochromeIconBitmap, that.mMonochromeIconBitmap) == false) goto L20;
            return true;
        L20:
            return false;
        }

        public int hashCode() {
            int _hash = (1 * 31) + Objects.hashCode(this.mTitle);
            return (((((_hash * 31) + Objects.hashCode(this.mOriginalComponentName)) * 31) + Objects.hashCode(this.mIconBitmap)) * 31) + Objects.hashCode(this.mMonochromeIconBitmap);
        }

        @Deprecated
        private void __metadata() {
        }
    }

    public ArchiveState(List<ArchiveActivityInfo> activityInfos, String installerTitle) {
        this(activityInfos, installerTitle, System.currentTimeMillis());
    }

    public ArchiveState(List<ArchiveActivityInfo> activityInfos, String installerTitle, long archiveTimeMillis) {
        this.mActivityInfos = activityInfos;
        AnnotationValidations.validate(NonNull.class, null, this.mActivityInfos);
        this.mInstallerTitle = installerTitle;
        AnnotationValidations.validate(NonNull.class, null, this.mInstallerTitle);
        this.mArchiveTimeMillis = archiveTimeMillis;
        AnnotationValidations.validate(CurrentTimeMillisLong.class, null, this.mArchiveTimeMillis);
    }

    public List<ArchiveActivityInfo> getActivityInfos() {
        return this.mActivityInfos;
    }

    public String getInstallerTitle() {
        return this.mInstallerTitle;
    }

    public long getArchiveTimeMillis() {
        return this.mArchiveTimeMillis;
    }

    public String toString() {
        return "ArchiveState { activityInfos = " + this.mActivityInfos + ", installerTitle = " + this.mInstallerTitle + ", archiveTimeMillis = " + this.mArchiveTimeMillis + " }";
    }

    public boolean equals(Object o) {
        if (this != o) goto L6;
        return true;
    L6:
        if (o != null) goto L8;
    L19:
        return false;
    L8:
        if (getClass() != o.getClass()) goto L19;
        ArchiveState that = (ArchiveState) o;
        if (Objects.equals(this.mActivityInfos, that.mActivityInfos) == false) goto L18;
        if (Objects.equals(this.mInstallerTitle, that.mInstallerTitle) == false) goto L18;
        if (this.mArchiveTimeMillis != that.mArchiveTimeMillis) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        int _hash = (1 * 31) + Objects.hashCode(this.mActivityInfos);
        return (((_hash * 31) + Objects.hashCode(this.mInstallerTitle)) * 31) + Long.hashCode(this.mArchiveTimeMillis);
    }

    @Deprecated
    private void __metadata() {
    }
}
