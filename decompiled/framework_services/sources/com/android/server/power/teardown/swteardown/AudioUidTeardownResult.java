package com.android.server.power.teardown.swteardown;

import com.android.server.power.teardown.ComponentResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class AudioUidTeardownResult extends ComponentResult {
    public HashMap<String, AudioPackageInfo> mAudioPackageEntrys;
    public int mBgCurrent;
    public long[] mVolumeDuration;

    public static class AudioPackageInfo {
        public int mBgCurrent;
        public int mCurrent;
        public String mPackageName;
        public List<AudioProcInfo> mProcInfoList;
        public List<AudioProcInfo> mProcInfoListBg;
        public int mUid;
        public long[] mVolumeDuration;

        public AudioPackageInfo(String packageName, int uid, int volumeNum) {
            this.mUid = uid;
            this.mPackageName = packageName;
            this.mProcInfoList = new ArrayList();
            this.mProcInfoListBg = new ArrayList();
            this.mVolumeDuration = new long[volumeNum];
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("pkg=");
            sb.append(this.mPackageName);
            sb.append(", uid=");
            sb.append(this.mUid);
            sb.append(", current=");
            sb.append(this.mCurrent);
            sb.append("mA, bgCurrent=");
            sb.append(this.mBgCurrent);
            sb.append("mA, volumeDurations=[");
            int i = 0;
        L4:
            if (i >= this.mVolumeDuration.length) goto L10;
            sb.append(this.mVolumeDuration[i] / 1000);
            sb.append("s");
            if (i == (this.mVolumeDuration.length - 1)) goto L8;
            sb.append(", ");
        L8:
            i = i + 1;
            goto L4
        L10:
            return sb.toString();
        }
    }

    public static class AudioProcInfo {
        public int mBgCurrent;
        public int mCurrent;
        public int mPid;
        public String mProcessName;
        public long[] mVolumeDuration;

        public AudioProcInfo(int pid, String processName, int volumeNum) {
            this.mPid = pid;
            this.mProcessName = processName;
            this.mVolumeDuration = new long[volumeNum];
        }

        public AudioProcInfo(int volumeNum) {
            this(0, "Unknown", volumeNum);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("pid=");
            sb.append(this.mPid);
            sb.append(", processName=");
            sb.append(this.mProcessName);
            sb.append(", current=");
            sb.append(this.mCurrent);
            sb.append("mA, bgCurrent=");
            sb.append(this.mBgCurrent);
            sb.append("mA, volumeDurations=[");
            int i = 0;
        L4:
            if (i >= this.mVolumeDuration.length) goto L9;
            sb.append(this.mVolumeDuration[i] / 1000);
            sb.append("s");
            if (i == (this.mVolumeDuration.length - 1)) goto L8;
            sb.append(", ");
        L8:
            i = i + 1;
            goto L4
        L9:
            sb.append("]");
            return sb.toString();
        }
    }

    public AudioUidTeardownResult(int volumeNum) {
        this.mVolumeDuration = new long[volumeNum];
        this.mAudioPackageEntrys = new HashMap();
    }

    public AudioProcInfo getPrcoInfo(String packageName, int uid, int pid) {
        if (this.mAudioPackageEntrys.containsKey(packageName) == false) goto L14;
        AudioPackageInfo packageInfo = this.mAudioPackageEntrys.get(packageName);
        int i = 0;
    L6:
        if (i >= packageInfo.mProcInfoList.size()) goto L12;
        if (packageInfo.mProcInfoList.get(i).mPid == pid) goto L10;
        i = i + 1;
        goto L6
    L10:
        return packageInfo.mProcInfoList.get(i);
    L12:
        AudioProcInfo procInfo = new AudioProcInfo(this.mVolumeDuration.length);
        packageInfo.mProcInfoList.add(procInfo);
        return procInfo;
    L14:
        AudioProcInfo procInfo2 = new AudioProcInfo(this.mVolumeDuration.length);
        AudioPackageInfo packageInfo2 = new AudioPackageInfo(packageName, uid, this.mVolumeDuration.length);
        packageInfo2.mProcInfoList.add(procInfo2);
        this.mAudioPackageEntrys.put(packageName, packageInfo2);
        return procInfo2;
    }

    public AudioProcInfo getBgPrcoInfo(String packageName, int uid, int pid) {
        if (this.mAudioPackageEntrys.containsKey(packageName) == false) goto L14;
        AudioPackageInfo packageInfo = this.mAudioPackageEntrys.get(packageName);
        int i = 0;
    L6:
        if (i >= packageInfo.mProcInfoListBg.size()) goto L12;
        if (packageInfo.mProcInfoListBg.get(i).mPid == pid) goto L10;
        i = i + 1;
        goto L6
    L10:
        return packageInfo.mProcInfoListBg.get(i);
    L12:
        AudioProcInfo procInfo = new AudioProcInfo(this.mVolumeDuration.length);
        packageInfo.mProcInfoListBg.add(procInfo);
        return procInfo;
    L14:
        AudioProcInfo procInfo2 = new AudioProcInfo(this.mVolumeDuration.length);
        AudioPackageInfo packageInfo2 = new AudioPackageInfo(packageName, uid, this.mVolumeDuration.length);
        packageInfo2.mProcInfoListBg.add(procInfo2);
        this.mAudioPackageEntrys.put(packageName, packageInfo2);
        return procInfo2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Audio_All] ");
        sb.append("Audio current=");
        sb.append(this.mCurrent);
        sb.append("mA, bgCurrent=");
        sb.append(this.mBgCurrent);
        sb.append("mA, volumeDurations=");
        int i = 0;
    L4:
        if (i >= this.mVolumeDuration.length) goto L9;
        sb.append(this.mVolumeDuration[i] / 1000);
        sb.append("s");
        if (i == (this.mVolumeDuration.length - 1)) goto L8;
        sb.append(", ");
    L8:
        i = i + 1;
        goto L4
    L9:
        sb.append("]\n");
        Iterator<Map.Entry<String, AudioPackageInfo>> r1 = this.mAudioPackageEntrys.entrySet().iterator();
    L11:
        if (r1.hasNext() == false) goto L21;
        Map.Entry<String, AudioPackageInfo> entry = r1.next();
        AudioPackageInfo packageInfo = entry.getValue();
        int i2 = 0;
    L14:
        if (i2 >= packageInfo.mProcInfoList.size()) goto L11;
        if (packageInfo.mProcInfoList.get(i2).mCurrent <= 0) goto L19;
        sb.append("[Audio]");
        sb.append("pkg=");
        sb.append(entry.getKey());
        sb.append(", uid=");
        sb.append(packageInfo.mUid);
        sb.append(", ");
        sb.append(packageInfo.mProcInfoList.get(i2).toString());
        sb.append("\n");
    L19:
        i2 = i2 + 1;
        goto L14
    L21:
        Iterator<Map.Entry<String, AudioPackageInfo>> r2 = this.mAudioPackageEntrys.entrySet().iterator();
    L23:
        if (r2.hasNext() == false) goto L34;
        Map.Entry<String, AudioPackageInfo> entry2 = r2.next();
        AudioPackageInfo packageInfo2 = entry2.getValue();
        int i3 = 0;
    L26:
        if (i3 >= packageInfo2.mProcInfoListBg.size()) goto L23;
        if (packageInfo2.mProcInfoListBg.get(i3).mCurrent <= 0) goto L31;
        sb.append("[Audio_BG]");
        sb.append("pkg=");
        sb.append(entry2.getKey());
        sb.append(", uid=");
        sb.append(packageInfo2.mUid);
        sb.append(", ");
        sb.append(packageInfo2.mProcInfoListBg.get(i3).toString());
        sb.append("\n");
    L31:
        i3 = i3 + 1;
        goto L26
    L34:
        return sb.toString();
    }
}
