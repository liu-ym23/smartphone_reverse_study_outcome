package com.android.common;

import android.content.SharedPreferences;
import android.text.format.Time;
import com.android.contacts.util.HanziToPinyin;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public class OperationScheduler {
    private static final String PREFIX = "OperationScheduler_";
    private final SharedPreferences mStorage;

    public static class Options {
        public int backoffExponentialMillis;
        public long backoffFixedMillis;
        public long backoffIncrementalMillis;
        public long maxMoratoriumMillis;
        public long minTriggerMillis;
        public long periodicIntervalMillis;

        public Options() {
            this.backoffFixedMillis = 0;
            this.backoffIncrementalMillis = 5000;
            this.backoffExponentialMillis = 0;
            this.maxMoratoriumMillis = 86400000;
            this.minTriggerMillis = 0;
            this.periodicIntervalMillis = 0;
        }

        public String toString() {
            if (this.backoffExponentialMillis <= 0) goto L7;
            return String.format("OperationScheduler.Options[backoff=%.1f+%.1f+%.1f max=%.1f min=%.1f period=%.1f]", new Object[]{Double.valueOf(this.backoffFixedMillis / 1000.0d), Double.valueOf(this.backoffIncrementalMillis / 1000.0d), Double.valueOf(((double) this.backoffExponentialMillis) / 1000.0d), Double.valueOf(this.maxMoratoriumMillis / 1000.0d), Double.valueOf(this.minTriggerMillis / 1000.0d), Double.valueOf(this.periodicIntervalMillis / 1000.0d)});
        L7:
            return String.format("OperationScheduler.Options[backoff=%.1f+%.1f max=%.1f min=%.1f period=%.1f]", new Object[]{Double.valueOf(this.backoffFixedMillis / 1000.0d), Double.valueOf(this.backoffIncrementalMillis / 1000.0d), Double.valueOf(this.maxMoratoriumMillis / 1000.0d), Double.valueOf(this.minTriggerMillis / 1000.0d), Double.valueOf(this.periodicIntervalMillis / 1000.0d)});
        }
    }

    public OperationScheduler(SharedPreferences r1) {
        this.mStorage = r1;
    }

    public static Options parseOptions(String r7, Options r8) throws IllegalArgumentException {
        String[] r0 = r7.split(" +");
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L39;
        String r4 = r0[r3];
        if (r4.length() == 0) goto L38;
        if (r4.startsWith("backoff=") == false) goto L29;
        String[] r5 = r4.substring(8).split("\\+");
        if (r5.length > 3) goto L27;
        if (r5.length <= 0) goto L17;
        if (r5[0].length() <= 0) goto L17;
        r8.backoffFixedMillis = parseSeconds(r5[0]);
    L17:
        if (r5.length <= 1) goto L22;
        if (r5[1].length() <= 0) goto L22;
        r8.backoffIncrementalMillis = parseSeconds(r5[1]);
    L22:
        if (r5.length <= 2) goto L38;
        if (r5[2].length() <= 0) goto L38;
        r8.backoffExponentialMillis = (int) parseSeconds(r5[2]);
        goto L38
    L27:
        throw new IllegalArgumentException("bad value for backoff: [" + r7 + "]");
    L29:
        if (r4.startsWith("max=") == false) goto L32;
        r8.maxMoratoriumMillis = parseSeconds(r4.substring(4));
        goto L38
    L32:
        if (r4.startsWith("min=") == false) goto L35;
        r8.minTriggerMillis = parseSeconds(r4.substring(4));
        goto L38
    L35:
        if (r4.startsWith("period=") == false) goto L37;
        r8.periodicIntervalMillis = parseSeconds(r4.substring(7));
        goto L38
    L37:
        r8.periodicIntervalMillis = parseSeconds(r4);
    L38:
        r3 = r3 + 1;
        goto L3
    L39:
        return r8;
    }

    private static long parseSeconds(String r2) throws NumberFormatException {
        return (long) (Float.parseFloat(r2) * 1000.0f);
    }

    public long getNextTimeMillis(Options r14) {
        if (this.mStorage.getBoolean("OperationScheduler_enabledState", true) == true) goto L6;
        return Long.MAX_VALUE;
    L6:
        if (this.mStorage.getBoolean("OperationScheduler_permanentError", false) == false) goto L8;
        return Long.MAX_VALUE;
    L8:
        int r0 = this.mStorage.getInt("OperationScheduler_errorCount", 0);
        long r3 = currentTimeMillis();
        long r5 = getTimeBefore("OperationScheduler_lastSuccessTimeMillis", r3);
        long r7 = getTimeBefore("OperationScheduler_lastErrorTimeMillis", r3);
        long r1 = this.mStorage.getLong("OperationScheduler_triggerTimeMillis", Long.MAX_VALUE);
        long r4 = getTimeBefore("OperationScheduler_moratoriumTimeMillis", getTimeBefore("OperationScheduler_moratoriumSetTimeMillis", r3) + r14.maxMoratoriumMillis);
        if (r14.periodicIntervalMillis <= 0) goto L11;
        r1 = Math.min(r1, r14.periodicIntervalMillis + r5);
    L11:
        long r2 = Math.max(Math.max(r1, r4), r5 + r14.minTriggerMillis);
        if (r0 <= 0) goto L18;
        int r13 = r0 - 1;
        if (r13 <= 30) goto L17;
        r13 = 30;
    L17:
        return Math.max(r2, r7 + Math.min((r14.backoffFixedMillis + (r14.backoffIncrementalMillis * ((long) r0))) + (((long) r14.backoffExponentialMillis) << r13), r14.maxMoratoriumMillis));
    L18:
        return r2;
    }

    public long getLastSuccessTimeMillis() {
        return this.mStorage.getLong("OperationScheduler_lastSuccessTimeMillis", 0);
    }

    public long getLastAttemptTimeMillis() {
        return Math.max(this.mStorage.getLong("OperationScheduler_lastSuccessTimeMillis", 0), this.mStorage.getLong("OperationScheduler_lastErrorTimeMillis", 0));
    }

    private long getTimeBefore(String r4, long r5) {
        long r0 = this.mStorage.getLong(r4, 0);
        if (r0 <= r5) goto L6;
        SharedPreferencesCompat.apply(this.mStorage.edit().putLong(r4, r5));
        return r5;
    L6:
        return r0;
    }

    public void setTriggerTimeMillis(long r2) {
        SharedPreferencesCompat.apply(this.mStorage.edit().putLong("OperationScheduler_triggerTimeMillis", r2));
    }

    public void setMoratoriumTimeMillis(long r3) {
        SharedPreferencesCompat.apply(this.mStorage.edit().putLong("OperationScheduler_moratoriumTimeMillis", r3).putLong("OperationScheduler_moratoriumSetTimeMillis", currentTimeMillis()));
    }

    public boolean setMoratoriumTimeHttp(String r6) {
        setMoratoriumTimeMillis((Long.parseLong(r6) * 1000) + currentTimeMillis());     // Catch: NumberFormatException -> L5
        return true;
    L5:
        setMoratoriumTimeMillis(LegacyHttpDateTime.parse(r6));     // Catch: IllegalArgumentException -> L7
        return true;
    L7:
        return false;
    }

    public void setEnabledState(boolean r2) {
        SharedPreferencesCompat.apply(this.mStorage.edit().putBoolean("OperationScheduler_enabledState", r2));
    }

    public void onSuccess() {
        resetTransientError();
        resetPermanentError();
        SharedPreferencesCompat.apply(this.mStorage.edit().remove("OperationScheduler_errorCount").remove("OperationScheduler_lastErrorTimeMillis").remove("OperationScheduler_permanentError").remove("OperationScheduler_triggerTimeMillis").putLong("OperationScheduler_lastSuccessTimeMillis", currentTimeMillis()));
    }

    public void onTransientError() {
        SharedPreferences.Editor r0 = this.mStorage.edit();
        r0.putLong("OperationScheduler_lastErrorTimeMillis", currentTimeMillis());
        r0.putInt("OperationScheduler_errorCount", this.mStorage.getInt("OperationScheduler_errorCount", 0) + 1);
        SharedPreferencesCompat.apply(r0);
    }

    public void resetTransientError() {
        SharedPreferencesCompat.apply(this.mStorage.edit().remove("OperationScheduler_errorCount"));
    }

    public void onPermanentError() {
        SharedPreferencesCompat.apply(this.mStorage.edit().putBoolean("OperationScheduler_permanentError", true));
    }

    public void resetPermanentError() {
        SharedPreferencesCompat.apply(this.mStorage.edit().remove("OperationScheduler_permanentError"));
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("[OperationScheduler:");
        Iterator r9 = new TreeMap(this.mStorage.getAll()).entrySet().iterator();
    L4:
        if (r9.hasNext() == false) goto L15;
        Map.Entry r1 = (Map.Entry) r9.next();
        String r2 = (String) r1.getKey();
        if (r2.startsWith(PREFIX) == false) goto L4;
        if (r2.endsWith("TimeMillis") == true) goto L9;
        r0.append(HanziToPinyin.Token.SEPARATOR).append(r2.substring(19));
        Object r3 = r1.getValue();
        if (r3 == null) goto L12;
        r0.append("=").append(r3.toString());
        goto L4
    L12:
        r0.append("=(null)");
        goto L4
    L9:
        Time r4 = new Time();
        r4.set(((Long) r1.getValue()).longValue());
        r0.append(HanziToPinyin.Token.SEPARATOR).append(r2.substring(19, r2.length() - 10));
        r0.append("=").append(r4.format("%Y-%m-%d/%H:%M:%S"));
        goto L4
    L15:
        return r0.append("]").toString();
    }

    protected long currentTimeMillis() {
        return System.currentTimeMillis();
    }
}
