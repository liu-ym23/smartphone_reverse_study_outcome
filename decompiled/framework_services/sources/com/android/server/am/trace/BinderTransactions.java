package com.android.server.am.trace;

import android.util.Slog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class BinderTransactions {
    private static final String BINDER_TRANSATION_FILE = "/dev/binderfs/binder_logs/state";
    private static final int DUMP_MAX_COUNT = 10;
    private static final String REGEX_PATTERN = "\\s+(outgoing|incoming|pending)\\s+transaction.*from\\s+(\\d+):\\d+\\s+to\\s+(\\d+):\\d+\\s+.*";
    private static final String TAG = "BinderTransactions";
    private int mCheckPid;
    private Map<Integer, HashSet<Integer>> mLocalToRemotesMap;
    private boolean mRecursiveMode;
    private Set<Integer> mRemotePids;

    public static /* synthetic */ void $r8$lambda$l4krLZtVTdHjo86a0U97OdGC0fg(Set r0, Integer r1) {
        lambda$getTargetPidsStuckInBinder$0(r0, r1);
    }

    public BinderTransactions(boolean recursive) {
        this.mLocalToRemotesMap = new HashMap();
        this.mRemotePids = new HashSet();
        this.mRecursiveMode = recursive;
    }

    public Set<Integer> getTargetPidsStuckInBinder(int pid) {
        this.mCheckPid = pid;
        parseFromFile();
        if (this.mRecursiveMode == false) goto L5;
        Set<Integer> keyPids = this.mLocalToRemotesMap.keySet();
        Iterator<Integer> r1 = keyPids.iterator();
    L13:
        if (r1.hasNext() == false) goto L18;
        Integer p = r1.next();
        if (p.intValue() != this.mCheckPid) goto L13;
        this.mRemotePids.add(p);
        findRemotePid(p.intValue());
    L18:
        final Set<Integer> ret = new HashSet();
        this.mRemotePids.forEach(new BinderTransactions$$ExternalSyntheticLambda0(ret));
        return ret;
    L5:
        if (this.mLocalToRemotesMap.containsKey(Integer.valueOf(pid)) == false) goto L18;
        Iterator<Integer> r0 = this.mLocalToRemotesMap.get(Integer.valueOf(pid)).iterator();
    L8:
        if (r0.hasNext() == false) goto L18;
        int remotePid = r0.next().intValue();
        this.mRemotePids.add(Integer.valueOf(remotePid));
        goto L8
    }

    private static /* synthetic */ void lambda$getTargetPidsStuckInBinder$0(Set ret, Integer p) {
        if (p.intValue() != 0) goto L5;
        return;
    L5:
        if (ret.size() > 10) goto L9;
        ret.add(p);
        return;
    }

    public void binderStateRead(File outputFile) {
        boolean binderfsNodePresent = false;
        BufferedReader in = null;
        Slog.i(TAG, "Collecting Binder Transaction Status Information");     // Catch: IOException -> L13
        in = new BufferedReader(new FileReader(BINDER_TRANSATION_FILE));     // Catch: IOException -> L6
        Slog.i(TAG, "Collecting Binder state file from binderfs");     // Catch: IOException -> L6
        binderfsNodePresent = true;
    L8:
        if (binderfsNodePresent == false) goto L26;
    L16:
        if (in != null) goto L18;
        return;
    L18:
        new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.US).format(new Date());     // Catch: IOException -> L13
        FileWriter out = new FileWriter(outputFile, true);     // Catch: IOException -> L13
    L19:
        String line = in.readLine();     // Catch: IOException -> L13
        if (line == null) goto L22;
        out.write(line);     // Catch: IOException -> L13
        out.write(10);     // Catch: IOException -> L13
        goto L19
    L22:
        in.close();     // Catch: IOException -> L13
        out.close();     // Catch: IOException -> L13
        return;
    L26:
        in = new BufferedReader(new FileReader("/sys/kernel/debug/binder/state"));     // Catch: IOException -> L11
        Slog.i(TAG, "Collecting Binder state file from debugfs");     // Catch: IOException -> L11
    L11:
        e = move-exception;
        Slog.i(TAG, "Debugfs node not found", e);     // Catch: IOException -> L13
        goto L16
    L6:
        e = move-exception;
        Slog.i(TAG, "Binderfs node not found, Trying to collect it from debugfs", e);     // Catch: IOException -> L13
    L13:
        e = move-exception;
        Slog.w(TAG, "Failed to collect state file", e);
    }

    private void findRemotePid(int s) {
        if (this.mLocalToRemotesMap.containsKey(Integer.valueOf(s)) == false) goto L11;
        Iterator<Integer> r0 = this.mLocalToRemotesMap.get(Integer.valueOf(s)).iterator();
    L6:
        if (r0.hasNext() == false) goto L17;
        Integer p = r0.next();
        if (this.mRemotePids.contains(p) == true) goto L6;
        this.mRemotePids.add(p);
        findRemotePid(p.intValue());
        goto L6
    L17:
        return;
    }

    private void parseFromFile() {
        this.mLocalToRemotesMap.clear();     // Catch: NumberFormatException -> L9 IOException -> L11 FileNotFoundException -> L13
        this.mRemotePids.clear();     // Catch: NumberFormatException -> L9 IOException -> L11 FileNotFoundException -> L13
        BufferedReader in = new BufferedReader(new FileReader(BINDER_TRANSATION_FILE));     // Catch: NumberFormatException -> L9 IOException -> L11 FileNotFoundException -> L13
        Pattern outP = Pattern.compile(REGEX_PATTERN);     // Catch: NumberFormatException -> L9 IOException -> L11 FileNotFoundException -> L13
    L4:
        String line = in.readLine();     // Catch: NumberFormatException -> L9 IOException -> L11 FileNotFoundException -> L13
        if (line == null) goto L15;
        Matcher m = outP.matcher(line);     // Catch: NumberFormatException -> L9 IOException -> L11 FileNotFoundException -> L13
        if (m.find() == false) goto L4;
        addItem(Integer.parseInt(m.group(2)), Integer.parseInt(m.group(3)), m.group(1).equals("outgoing"));     // Catch: NumberFormatException -> L9 IOException -> L11 FileNotFoundException -> L13
        goto L4
    L15:
        in.close();     // Catch: NumberFormatException -> L9 IOException -> L11 FileNotFoundException -> L13
    L28:
        return;
    L13:
        e = move-exception;
        Slog.w(TAG, "Unexpected FileNotFoundException", e);
        return;
    L11:
        e = move-exception;
        Slog.w(TAG, "Unexpected IOException", e);
        return;
    L9:
        e = move-exception;
        Slog.w(TAG, "Unexpected NumberFormatException ", e);
    }

    private void addItem(int spid, int tpid, boolean outgoing) {
        if (outgoing == false) goto L8;
        if (this.mLocalToRemotesMap.containsKey(Integer.valueOf(spid)) == false) goto L6;
        this.mLocalToRemotesMap.get(Integer.valueOf(spid)).add(Integer.valueOf(tpid));
        return;
    L6:
        HashSet<Integer> set = new HashSet();
        set.add(Integer.valueOf(tpid));
        this.mLocalToRemotesMap.put(Integer.valueOf(spid), set);
        return;
    L8:
        if (tpid != this.mCheckPid) goto L13;
        this.mRemotePids.add(Integer.valueOf(spid));
        return;
    }
}
