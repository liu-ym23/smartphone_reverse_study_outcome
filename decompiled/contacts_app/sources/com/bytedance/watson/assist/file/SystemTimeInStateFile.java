package com.bytedance.watson.assist.file;

import android.util.Log;
import com.android.contacts.util.HanziToPinyin;
import com.bytedance.watson.assist.core.cpu.CpuTimeStatInfo;
import com.bytedance.watson.assist.utils.CpuUtils;
import com.bytedance.watson.assist.utils.DebugLog;
import com.bytedance.watson.assist.utils.FileUtils;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SystemTimeInStateFile extends BaseStatFile {
    private static final int INDEX_FREQ = 0;
    private static final int INDEX_TIME = 1;
    private static final String PATH_PREFIX = "/sys/devices/system/cpu/cpu";
    private static final String PATH_SUFFIX = "/cpufreq/stats/time_in_state";
    private int cpuNum;
    private List<File> fileList;

    public SystemTimeInStateFile(String r1) {
        super(r1);
        this.cpuNum = CpuUtils.getCpuCoreNum();
        this.fileList = new ArrayList();
    }

    public SystemTimeInStateFile() {
        super("");
        this.cpuNum = CpuUtils.getCpuCoreNum();
        this.fileList = new ArrayList();
    }

    @Override // com.bytedance.watson.assist.file.BaseStatFile
    public FileStatInfo refresh() {
        if (this.fileList.isEmpty() == false) goto L8;
        int r0 = 0;
    L6:
        if (r0 == this.cpuNum) goto L8;
        this.fileList.add(new File(PATH_PREFIX + r0 + PATH_SUFFIX));
        r0 = r0 + 1;
    L8:
        this.mLastInfo = doRead(this.fileList);
        return this.mLastInfo;
    }

    private FileStatInfo doRead(List<File> r3) {
        if (r3 != null) goto L4;
        return null;
    L4:
        if (r3.isEmpty() == true) goto L20;
        CpuTimeStatInfo r0 = new CpuTimeStatInfo();
        Iterator<File> r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L12;
        LinkedHashMap<Long, Long> r1 = parseFile(r4.next());
        if (r1 == null) goto L8;
        r0.putFreqTimeMap(r1);
        goto L8
    L12:
        return r0;
    L20:
        return null;
    }

    private LinkedHashMap<Long, Long> parseFile(File r7) {
        BufferedReader r6 = FileUtils.openFile(r7);
        LinkedHashMap<Long, Long> r8 = null;
        if (r6 != null) goto L25;
        return null;
    L25:
        String r0 = r6.readLine();     // Catch: Exception -> L19 Throwable -> L23
        if (r0 == null) goto L17;
        if (r0.isEmpty() == true) goto L17;
        String[] r1 = r0.trim().split(HanziToPinyin.Token.SEPARATOR);     // Catch: Exception -> L19 Throwable -> L23
        if (r1.length <= 1) goto L17;
        if (r8 != null) goto L15;
        r8 = new LinkedHashMap();     // Catch: Exception -> L19 Throwable -> L23
    L15:
        r8.put(Long.valueOf(Long.parseLong(r1[0])), Long.valueOf(Long.parseLong(r1[1]) * 10));     // Catch: Exception -> L19 Throwable -> L23
    L17:
        FileUtils.closeFile(r6);
        return r8;
    L19:
        e = move-exception;
        DebugLog.e(Log.getStackTraceString(e));     // Catch: Throwable -> L23
        FileUtils.closeFile(r6);
        return r8;
    L23:
        FileUtils.closeFile(r6);
        return r8;
    }
}
