package com.android.contacts.common.util;

import com.GlobalProxyLancet;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.util.HanziToPinyin;
import com.google.common.collect.Lists;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class StopWatch {
    private final String mLabel;
    private final ArrayList<String> mLapLabels;
    private final ArrayList<Long> mTimes;

    /* JADX INFO: renamed from: com.android.contacts.common.util.StopWatch$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class NullStopWatch extends StopWatch {
        public static final NullStopWatch INSTANCE = null;

        @Override // com.android.contacts.common.util.StopWatch
        public void lap(String r1) {
        }

        @Override // com.android.contacts.common.util.StopWatch
        public void stopAndLog(String r1, int r2) {
        }

        static {
            INSTANCE = new NullStopWatch();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public NullStopWatch() {
            super(null, 0 == true ? 1 : 0);
        }
    }

    /* synthetic */ StopWatch(String r1, AnonymousClass1 r2) {
        this(r1);
    }

    private StopWatch(String r2) {
        this.mTimes = Lists.newArrayList();
        this.mLapLabels = Lists.newArrayList();
        this.mLabel = r2;
        lap("");
    }

    public static StopWatch start(String r1) {
        return new StopWatch(r1);
    }

    public void lap(String r4) {
        this.mTimes.add(Long.valueOf(System.currentTimeMillis()));
        this.mLapLabels.add(r4);
    }

    public void stopAndLog(String r8, int r9) {
        lap("");
        long r0 = this.mTimes.get(0).longValue();
        ArrayList<Long> r2 = this.mTimes;
        int r4 = 1;
        long r3 = r2.get(r2.size() - 1).longValue() - r0;
        if (r3 >= r9) goto L5;
        return;
    L5:
        StringBuilder r10 = new StringBuilder();
        r10.append(this.mLabel);
        r10.append(SimContactsConstants.EMAIL_SEP);
        r10.append(r3);
        r10.append(": ");
    L7:
        if (r4 >= this.mTimes.size()) goto L9;
        long r5 = this.mTimes.get(r4).longValue();
        r10.append(this.mLapLabels.get(r4));
        r10.append(SimContactsConstants.EMAIL_SEP);
        r10.append(r5 - r0);
        r10.append(HanziToPinyin.Token.SEPARATOR);
        r4 = r4 + 1;
        r0 = r5;
        goto L7
    L9:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_v(r8, r10.toString());
    }

    public static StopWatch getNullStopWatch() {
        return NullStopWatch.INSTANCE;
    }
}
