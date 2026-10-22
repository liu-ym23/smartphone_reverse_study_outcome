package com.bytedance.watson.assist.file;

import android.util.Log;
import com.android.contacts.util.HanziToPinyin;
import com.bytedance.watson.assist.core.cpu.ThreadStatInfo;
import com.bytedance.watson.assist.utils.DebugLog;
import com.bytedance.watson.assist.utils.FileUtils;
import java.io.BufferedReader;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class ProcTidStatFile extends ProcPidStatFile {
    public ProcTidStatFile(long r3) {
        super("proc/self/task/" + r3 + "/stat");
    }

    @Override // com.bytedance.watson.assist.file.ProcPidStatFile, com.bytedance.watson.assist.file.BaseStatFile
    protected FileStatInfo doRead(File r2) {
        return parseFile(r2, null);
    }

    protected FileStatInfo parseFile(File r6, ThreadStatInfo r7) {
        BufferedReader r5 = FileUtils.openFile(r6);
        if (r5 != null) goto L31;
        return null;
    L31:
        String r8 = r5.readLine();     // Catch: Exception -> L25 Throwable -> L29
        if (r8 != null) goto L9;
    L23:
        FileUtils.closeFile(r5);
        return r7;
    L9:
        if (r8.isEmpty() == true) goto L23;
        String r9 = r8.trim();     // Catch: Exception -> L25 Throwable -> L29
        String r0 = r9.substring(0, r9.indexOf(SPLIT_PROC_NAME_RIGHT.charValue())).trim();     // Catch: Exception -> L25 Throwable -> L29
        String r10 = r9.substring(r9.indexOf(SPLIT_PROC_NAME_RIGHT.charValue()) + 1, r9.length()).trim();     // Catch: Exception -> L25 Throwable -> L29
        String[] r1 = r0.split("\\(");     // Catch: Exception -> L25 Throwable -> L29
        String[] r11 = r10.split(HanziToPinyin.Token.SEPARATOR);     // Catch: Exception -> L25 Throwable -> L29
        if (r1.length > 1) goto L14;
    L21:
        FileUtils.closeFile(r5);
        return r7;
    L14:
        if (r11.length <= 14) goto L21;
        if (r7 != null) goto L18;
        r7 = new ThreadStatInfo();     // Catch: Exception -> L25 Throwable -> L29
    L18:
        r7.setPid(Integer.parseInt(r1[0].trim()));     // Catch: Exception -> L25 Throwable -> L29
        r7.setProcessName(r1[1].trim());     // Catch: Exception -> L25 Throwable -> L29
        r7.setCpuTime((Integer.parseInt(r11[11]) + Integer.parseInt(r11[12])) * 10);     // Catch: Exception -> L25 Throwable -> L29
        FileUtils.closeFile(r5);
        return r7;
    L25:
        e = move-exception;
        DebugLog.e(Log.getStackTraceString(e));     // Catch: Throwable -> L29
        FileUtils.closeFile(r5);
        return r7;
    L29:
        FileUtils.closeFile(r5);
        return r7;
    }
}
