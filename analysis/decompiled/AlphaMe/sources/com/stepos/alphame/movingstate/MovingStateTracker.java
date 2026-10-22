package com.stepos.alphame.movingstate;

import android.os.SystemClock;
import android.util.Log;
import ch.qos.logback.core.CoreConstants;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class MovingStateTracker {
    private static final int EVENT_POOL_SIZE_MAX = 250;
    private static final int EVENT_POOL_SIZE_MIN = 150;
    private static final Matcher[] MATCHERS = {new Matcher(5000, 10000, 10), new Matcher(5000, 20000, 5), new Matcher(5000, 1200000, 2)};
    private static final long SPEED_RUN_MIN = 125;
    private static final long SPEED_WALK_MIN = 60;
    private static final String TAG = "MovingState";
    private final List<StepInfo> mSteps = new ArrayList(250);

    public static class Matcher {
        public final int maxDuration;
        public final int minDuration;
        public final int reachEventCount;

        public Matcher(int i4, int i5, int i6) {
            this.minDuration = i4;
            this.maxDuration = i5;
            this.reachEventCount = i6;
        }
    }

    public static class StepInfo {
        public final int count;
        public final long timeStamp;

        public StepInfo(int i4, long j4) {
            this.count = i4;
            this.timeStamp = j4;
        }
    }

    private int calculateSpeed(int i4) {
        long j4 = i4;
        if (j4 >= 125) {
            return 4;
        }
        if (j4 >= SPEED_WALK_MIN) {
            return 3;
        }
        return i4 > 0 ? 2 : 1;
    }

    private Matcher findMatcher(long j4, int[] iArr) {
        int size = this.mSteps.size();
        if (size <= 1) {
            return null;
        }
        for (Matcher matcher : MATCHERS) {
            int i4 = size - 1;
            int i5 = -1;
            int i6 = i4;
            while (i4 >= 0) {
                StepInfo stepInfo = this.mSteps.get(i4);
                if (stepInfo != null) {
                    int i7 = (int) (j4 - stepInfo.timeStamp);
                    if (i7 > matcher.maxDuration) {
                        break;
                    }
                    i6 = i4;
                    i5 = i7;
                }
                i4--;
            }
            if (size - i6 >= matcher.reachEventCount && i5 >= matcher.minDuration) {
                iArr[0] = i6;
                return matcher;
            }
        }
        return null;
    }

    public synchronized void addEvent(int i4) {
        this.mSteps.add(new StepInfo(i4, SystemClock.elapsedRealtime()));
    }

    public synchronized void addStaticEvent() {
        if (this.mSteps.size() > 0) {
            StepInfo stepInfo = this.mSteps.get(r0.size() - 1);
            if (stepInfo != null) {
                this.mSteps.add(new StepInfo(stepInfo.count, SystemClock.elapsedRealtime()));
            }
        }
    }

    public synchronized MovingState compute(boolean z4) {
        if (!z4) {
            try {
                Log.w(TAG, "compute while screen off");
            } catch (Throwable th) {
                throw th;
            }
        }
        int size = this.mSteps.size();
        if (size > 250) {
            this.mSteps.subList(0, size - 150).clear();
        }
        int size2 = this.mSteps.size();
        int[] iArr = {0};
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Matcher matcherFindMatcher = findMatcher(jElapsedRealtime, iArr);
        int i4 = iArr[0];
        if (matcherFindMatcher != null && i4 >= 0 && i4 < this.mSteps.size()) {
            StepInfo stepInfo = this.mSteps.get(i4);
            StepInfo stepInfo2 = this.mSteps.get(size2 - 1);
            if (stepInfo != null && stepInfo2 != null) {
                int i5 = stepInfo2.count - stepInfo.count;
                int iMax = Math.max((int) (jElapsedRealtime - stepInfo.timeStamp), 1);
                int i6 = (i5 * CoreConstants.MILLIS_IN_ONE_MINUTE) / iMax;
                return new MovingState(calculateSpeed(i6), i5, iMax, i6, ((size2 - i4) * CoreConstants.MILLIS_IN_ONE_MINUTE) / iMax);
            }
            return MovingState.unknownState();
        }
        return MovingState.unknownState();
    }
}
