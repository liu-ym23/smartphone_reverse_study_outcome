package com.bytedance.perf.monitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes2.dex */
public class AnrEntryManager {
    public static long FOUND_DURATION = 600000;
    public static int MAX_ANR_SIZE = 3;
    public static int MAX_QUEUE_SIZE = 10;
    public static LinkedBlockingQueue<AnrEntry> mAnrEntries;

    public AnrEntryManager() {
    }

    static {
        mAnrEntries = new LinkedBlockingQueue(MAX_QUEUE_SIZE);
    }

    public static void putAnr(AnrEntry r2) {
        if (mAnrEntries != null) goto L13;
        mAnrEntries = new LinkedBlockingQueue(MAX_QUEUE_SIZE);
    L13:
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    L6:
        if (mAnrEntries.size() != MAX_QUEUE_SIZE) goto L8;
        mAnrEntries.take();     // Catch: InterruptedException -> L10
    L8:
        mAnrEntries.put(r2);     // Catch: InterruptedException -> L10
    }

    public static String getCostTop2Stack(AnrEntry r5) {
        if (checkIsSafe(r5) == false) goto L7;
        return r5.stack;
    L7:
        if (r5 != null) goto L9;
        String r6 = "";
    L10:
        StringBuilder r0 = new StringBuilder(r6);
        ArrayList r7 = new ArrayList();
        Iterator<AnrEntry> r1 = mAnrEntries.iterator();
    L12:
        if (r1.hasNext() == false) goto L16;
        AnrEntry r2 = r1.next();
        if (r2 == null) goto L12;
        r7.add(r2);
        goto L12
    L16:
        Collections.sort(r7);
        int r3 = Math.min(MAX_ANR_SIZE, r7.size());
        int r4 = 0;
    L18:
        if (r4 >= (r3 - 1)) goto L24;
        if (r7.get(r4) == null) goto L22;
        r0.append("\n").append(((AnrEntry) r7.get(r4)).stack);
    L22:
        r4 = r4 + 1;
        goto L18
    L24:
        return r0.toString();
    L9:
        r6 = r5.stack;
        goto L10
    }

    private static boolean checkIsSafe(AnrEntry r1) {
        LinkedBlockingQueue<AnrEntry> r0 = mAnrEntries;
        if (r0 != null) goto L5;
    L6:
        if (r1 == null) goto L8;
        return true;
    L8:
        return false;
    L5:
        if (r0.isEmpty() == false) goto L8;
        goto L6
    }

    public static void clear() {
        mAnrEntries.clear();
    }
}
