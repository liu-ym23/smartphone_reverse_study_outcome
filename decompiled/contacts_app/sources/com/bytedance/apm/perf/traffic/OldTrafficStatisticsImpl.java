package com.bytedance.apm.perf.traffic;

import android.os.Process;
import android.text.TextUtils;
import com.android.contacts.util.HanziToPinyin;
import com.bytedance.apm.util.ListUtils;
import com.bytedance.monitor.util.IoUtil;
import com.bytedance.platform.godzilla.common.Constant;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class OldTrafficStatisticsImpl implements ITrafficStatistics {
    private List<String> mFileDataList;
    private long mLastReadTs;
    private volatile long mMobileBackBytes;
    private volatile long mMobileBackPackets;
    private volatile long mMobileFrontBytes;
    private volatile long mMobileFrontPackets;
    private File mProcFile;
    private volatile long mWifiBackBytes;
    private volatile long mWifiBackPackets;
    private volatile long mWifiFrontBytes;
    private volatile long mWifiFrontPackets;

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public void onStatusChange(boolean r1) {
    }

    public OldTrafficStatisticsImpl() {
        this.mFileDataList = new CopyOnWriteArrayList();
        this.mLastReadTs = -1;
        this.mWifiBackBytes = 0;
        this.mMobileBackBytes = 0;
        this.mWifiFrontBytes = 0;
        this.mMobileFrontBytes = 0;
        this.mWifiBackPackets = 0;
        this.mMobileBackPackets = 0;
        this.mWifiFrontPackets = 0;
        this.mMobileFrontPackets = 0;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public void init() {
        this.mProcFile = new File("/proc/net/xt_qtaguid/stats");
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getMobileBytes() {
        return getMobileBackBytes() + getMobileFrontBytes();
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getWifiBytes() {
        return getWifiBackBytes() + getWifiFrontBytes();
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getBackBytes() {
        return getMobileBackBytes() + getWifiBackBytes();
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getBackPackets() {
        updateNetData();
        return this.mMobileBackPackets + this.mWifiBackPackets;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getFrontBytes() {
        return getMobileFrontBytes() + getWifiFrontBytes();
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getFrontPackets() {
        updateNetData();
        return this.mMobileFrontPackets + this.mWifiFrontPackets;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getMobileFrontBytes() {
        updateNetData();
        return this.mMobileFrontBytes;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getMobileBackBytes() {
        updateNetData();
        return this.mMobileBackBytes;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getWifiFrontBytes() {
        updateNetData();
        return this.mWifiFrontBytes;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getWifiBackBytes() {
        updateNetData();
        return this.mWifiBackBytes;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getTotalBytes() {
        return getMobileBytes() + getWifiBytes();
    }

    private void updateNetData() {
        OldTrafficStatisticsImpl this = this;
        if ((System.currentTimeMillis() - this.mLastReadTs) >= 1000) goto L5;
        return;
    L5:
        this.mLastReadTs = System.currentTimeMillis();
        int r1 = Process.myUid();
        readFile2List();
        if (ListUtils.isEmpty(this.mFileDataList) == false) goto L8;
        return;
    L8:
        Iterator<String> r2 = this.mFileDataList.iterator();
        long r3 = 0;
        long r5 = 0;
        long r7 = 0;
        long r9 = 0;
        long r11 = 0;
        long r13 = 0;
        long r15 = 0;
        long r19 = 0;
    L10:
        if (r2.hasNext() == false) goto L45;
        r2 = r2;
        long r23 = r15;
        String[] r4 = r2.next().split(HanziToPinyin.Token.SEPARATOR);
    L41:
        int r32 = r1;
        long r34 = r5;
    L40:
        long r6 = r23;
    L42:
        r15 = r6;
    L43:
        r5 = r34;
    L44:
        r1 = r32;
        goto L10
    L13:
        if (TextUtils.equals(r4[3], "uid_tag_int") == true) goto L14;
        if (r1 != Integer.parseInt(r4[3])) goto L39;
        long r16 = Long.parseLong(r4[5]);     // Catch: Exception -> L41
        long r25 = Long.parseLong(r4[6]);     // Catch: Exception -> L41
        long r27 = Long.parseLong(r4[7]);     // Catch: Exception -> L41
        long r29 = Long.parseLong(r4[8]);     // Catch: Exception -> L41
        r32 = r1;
        if (Long.valueOf(r4[4]).longValue() != 1) goto L27;
        r34 = r5;
        if (r4[1].startsWith("rmnet_data") == false) goto L25;
        r11 = r11 + (r27 + r16);     // Catch: Exception -> L49
        r13 = r13 + (r29 + r25);     // Catch: Exception -> L49
    L30:
        if (Long.valueOf(r4[4]).longValue() == 0) goto L56;
    L38:
        r6 = r23;
        goto L42
    L56:
        if (r4[1].startsWith("rmnet_data") == false) goto L34;
        r7 = r7 + (r27 + r16);
        r15 = r23 + (r29 + r25);
        goto L43
    L34:
        r6 = r23;
        if (r4[1].startsWith("wlan") == false) goto L42;
        long r0 = r34 + (r27 + r16);
        r19 = r19 + (r29 + r25);
        r15 = r6;
        r5 = r0;
        goto L44
    L25:
        if (r4[1].startsWith("wlan") == false) goto L30;
        r9 = r9 + (r27 + r16);     // Catch: Exception -> L49
        r3 = r3 + (r29 + r25);     // Catch: Exception -> L49
        goto L30
    L27:
        r34 = r5;
        goto L30
    L39:
        r32 = r1;
        r34 = r5;
        goto L40
    L14:
        r15 = r23;
        goto L10
    L45:
        long r8 = r5;
        this.mWifiBackBytes = r8;
        this.mMobileBackBytes = r7;
        this.mWifiFrontBytes = r9;
        this.mMobileFrontBytes = r11;
        this.mWifiBackPackets = r19;
        this.mMobileBackPackets = r15;
        this.mWifiFrontPackets = r3;
        this.mMobileFrontPackets = r13;
    }

    private void readFile2List() {
        if (this.mProcFile != null) goto L5;
        return;
    L5:
        BufferedReader r0 = null;
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L17
        BufferedReader r2 = new BufferedReader(new InputStreamReader(new FileInputStream(this.mProcFile), Constant.CHARSET_UTF_8));     // Catch: Throwable -> L17
        int r3 = 1;
    L26:
        String r4 = r2.readLine();     // Catch: Throwable -> L15
        if (r4 == null) goto L13;
        if (r3 < 0) goto L12;
        r1.add(r4);     // Catch: Throwable -> L15
    L12:
        r3 = r3 + 1;     // Catch: Throwable -> L15
        goto L26
    L13:
        this.mFileDataList.clear();     // Catch: Throwable -> L15
        this.mFileDataList.addAll(r1);     // Catch: Throwable -> L15
        IoUtil.safeClose(r2);
        return;
    L15:
        th = th;
        r0 = r2;
    L24:
        th.printStackTrace();     // Catch: Throwable -> L21
        IoUtil.safeClose(r0);
        return;
    L21:
        th = move-exception;
        IoUtil.safeClose(r0);
        throw th;
    L17:
        th = th;
        goto L24
    }
}
