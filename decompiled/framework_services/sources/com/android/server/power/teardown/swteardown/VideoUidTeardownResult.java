package com.android.server.power.teardown.swteardown;

import com.android.server.power.teardown.ComponentResult;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class VideoUidTeardownResult extends ComponentResult {
    public long mBgCurrent;
    public int mCount;
    public long mDuration;
    public HashMap<VideoInfoKey, VideoUidInfo> mVideoEntrys;

    public static class VideoInfoKey {
        public String mCodecName;
        public int mPid;
        public String mPkgName;
        public int mUid;

        public VideoInfoKey(int uid, int pid, String pkgName, String codecName) {
            this.mUid = uid;
            this.mPid = pid;
            this.mPkgName = pkgName;
            this.mCodecName = codecName;
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
            VideoInfoKey that = (VideoInfoKey) o;
            if (this.mUid != that.mUid) goto L20;
            if (this.mPid != that.mPid) goto L20;
            if (Objects.equals(this.mPkgName, that.mPkgName) == false) goto L20;
            if (Objects.equals(this.mCodecName, that.mCodecName) == false) goto L20;
            return true;
        L20:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.mUid), Integer.valueOf(this.mPid), this.mPkgName, this.mCodecName});
        }
    }

    public static class VideoUidInfo {
        public int mBgCurrent;
        public long mBgDuration;
        public String mCodecName;
        public int mCount;
        public int mCurrent;
        public long mDuration;
        public int mFrameRate;
        public int mHeight;
        public int mLowLatencyMode;
        public int mPid;
        public String mPkgName;
        public String mProcessName;
        public int mUid;
        public int mWidth;

        public VideoUidInfo(VideoInfoKey videoInfoKey, String processName) {
            this.mUid = videoInfoKey.mUid;
            this.mPkgName = videoInfoKey.mPkgName;
            this.mPid = videoInfoKey.mPid;
            this.mProcessName = processName;
            this.mCodecName = videoInfoKey.mCodecName;
        }

        public String toString() {
            return "pkg=" + this.mPkgName + ", uid=" + this.mUid + ", pid=" + this.mPid + ", procName=" + this.mProcessName + ", codecName=" + this.mCodecName + ", frameRate=" + this.mFrameRate + ", width=" + this.mWidth + ", height=" + this.mHeight + ", lowLatencyMode=" + this.mLowLatencyMode + ", current=" + this.mCurrent + "mA, bgCurrent=" + this.mBgCurrent + "mA, duration=" + (this.mDuration / 1000) + "s, bgDuration=" + (this.mBgDuration / 1000) + "s, count=" + this.mCount;
        }
    }

    public VideoUidTeardownResult() {
        this.mVideoEntrys = new HashMap();
    }

    public VideoUidInfo getVideoInfo(VideoInfoKey videoInfoKey, String processName) {
        if (this.mVideoEntrys.containsKey(videoInfoKey) == true) goto L5;
        VideoUidInfo uidInfo = new VideoUidInfo(videoInfoKey, processName);
        this.mVideoEntrys.put(videoInfoKey, uidInfo);
        return uidInfo;
    L5:
        return this.mVideoEntrys.get(videoInfoKey);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Video All] ");
        sb.append("video current=");
        sb.append(this.mCurrent);
        sb.append("mA, activeTime=");
        sb.append(this.mDuration / 1000);
        sb.append("s, bgCurrent=");
        sb.append(this.mBgCurrent);
        sb.append("mA, count=");
        sb.append(this.mCount);
        sb.append("\n");
        Iterator<Map.Entry<VideoInfoKey, VideoUidInfo>> r2 = this.mVideoEntrys.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L10;
        Map.Entry<VideoInfoKey, VideoUidInfo> entry = r2.next();
        VideoUidInfo videoInfo = entry.getValue();
        if (videoInfo.mCurrent == 0) goto L8;
        sb.append("[Video Uid]");
        sb.append(videoInfo.toString());
    L8:
        sb.append("\n");
        goto L4
    L10:
        return sb.toString();
    }
}
