package com.android.server.people.prediction;

import android.app.usage.UsageEvents;
import android.util.ArrayMap;
import android.util.Pair;
import android.util.Range;
import com.android.server.people.data.AppUsageStatsData;
import com.android.server.people.data.DataManager;
import com.android.server.people.data.Event;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
class SharesheetModelScorer {
    private static final boolean DEBUG = false;
    private static final long FOREGROUND_APP_PROMO_TIME_WINDOW = 0;
    static final float FOREGROUND_APP_WEIGHT = 0.0f;
    private static final float FREQUENTLY_USED_APP_SCORE_INITIAL_DECAY = 0.3f;
    private static final long ONE_MONTH_WINDOW = 0;
    private static final float RECENCY_INITIAL_BASE_SCORE = 0.4f;
    private static final Integer RECENCY_SCORE_COUNT = null;
    private static final float RECENCY_SCORE_INITIAL_DECAY = 0.05f;
    private static final float RECENCY_SCORE_SUBSEQUENT_DECAY = 0.02f;
    private static final String TAG = "SharesheetModelScorer";
    private static final float USAGE_STATS_CHOOSER_SCORE_INITIAL_DECAY = 0.9f;

    private static class ShareTargetRankingScore {
        private float mFrequencyScore;
        private float mMimeFrequencyScore;
        private float mRecencyScore;
        private float mTotalScore;

        /* synthetic */ ShareTargetRankingScore(SharesheetModelScorerIA r1) {
            this();
        }

        private ShareTargetRankingScore() {
            this.mRecencyScore = SharesheetModelScorer.FOREGROUND_APP_WEIGHT;
            this.mFrequencyScore = SharesheetModelScorer.FOREGROUND_APP_WEIGHT;
            this.mMimeFrequencyScore = SharesheetModelScorer.FOREGROUND_APP_WEIGHT;
            this.mTotalScore = SharesheetModelScorer.FOREGROUND_APP_WEIGHT;
        }

        float getTotalScore() {
            return this.mTotalScore;
        }

        void setTotalScore(float totalScore) {
            this.mTotalScore = totalScore;
        }

        float getRecencyScore() {
            return this.mRecencyScore;
        }

        void setRecencyScore(float recencyScore) {
            this.mRecencyScore = recencyScore;
        }

        float getFrequencyScore() {
            return this.mFrequencyScore;
        }

        void setFrequencyScore(float frequencyScore) {
            this.mFrequencyScore = frequencyScore;
        }

        void incrementFrequencyScore(float incremental) {
            this.mFrequencyScore += incremental;
        }

        float getMimeFrequencyScore() {
            return this.mMimeFrequencyScore;
        }

        void setMimeFrequencyScore(float mimeFrequencyScore) {
            this.mMimeFrequencyScore = mimeFrequencyScore;
        }

        void incrementMimeFrequencyScore(float incremental) {
            this.mMimeFrequencyScore += incremental;
        }
    }

    public static /* synthetic */ long $r8$lambda$7FkxCQ5ZV6cMoLM7UQFPi_l0X4g(Pair r2) {
        return lambda$computeScore$0(r2);
    }

    public static /* synthetic */ List $r8$lambda$r6TVbXv33F_zO4tPP5uxiOCTb2c(String r0) {
        return lambda$postProcess$1(r0);
    }

    static {
        RECENCY_SCORE_COUNT = 6;
        ONE_MONTH_WINDOW = TimeUnit.DAYS.toMillis(30);
        FOREGROUND_APP_PROMO_TIME_WINDOW = TimeUnit.MINUTES.toMillis(10);
    }

    private SharesheetModelScorer() {
    }

    static void computeScore(List<ShareTargetPredictor.ShareTarget> shareTargets, int shareEventType, long now) {
        if (shareTargets.isEmpty() == false) goto L5;
        return;
    L5:
        float totalFreqScore = FOREGROUND_APP_WEIGHT;
        int freqScoreCount = 0;
        float totalMimeFreqScore = FOREGROUND_APP_WEIGHT;
        int mimeFreqScoreCount = 0;
        PriorityQueue<Pair<ShareTargetRankingScore, Range<Long>>> recencyMinHeap = new PriorityQueue(RECENCY_SCORE_COUNT.intValue(), Comparator.comparingLong(new SharesheetModelScorer$$ExternalSyntheticLambda3()));
        List<ShareTargetRankingScore> scoreList = new ArrayList(shareTargets.size());
        Iterator<ShareTargetPredictor.ShareTarget> r6 = shareTargets.iterator();
    L7:
        if (r6.hasNext() == false) goto L39;
        ShareTargetPredictor.ShareTarget target = r6.next();
        ShareTargetRankingScore shareTargetScore = new ShareTargetRankingScore(null);
        scoreList.add(shareTargetScore);
        if (target.getEventHistory() == null) goto L7;
        List<Range<Long>> timeSlots = target.getEventHistory().getEventIndex(Event.SHARE_EVENT_TYPES).getActiveTimeSlots();
        if (timeSlots.isEmpty() == true) goto L18;
        Iterator<Range<Long>> r10 = timeSlots.iterator();
    L15:
        if (r10.hasNext() == false) goto L17;
        Range<Long> timeSlot = r10.next();
        shareTargetScore.incrementFrequencyScore(getFreqDecayedOnElapsedTime(now - ((Long) timeSlot.getLower()).longValue()));
        goto L15
    L17:
        totalFreqScore = totalFreqScore + shareTargetScore.getFrequencyScore();
        freqScoreCount = freqScoreCount + 1;
    L18:
        List<Range<Long>> timeSlotsOfSameType = target.getEventHistory().getEventIndex(shareEventType).getActiveTimeSlots();
        if (timeSlotsOfSameType.isEmpty() == true) goto L25;
        Iterator<Range<Long>> r12 = timeSlotsOfSameType.iterator();
    L22:
        if (r12.hasNext() == false) goto L24;
        Range<Long> timeSlot2 = r12.next();
        shareTargetScore.incrementMimeFrequencyScore(getFreqDecayedOnElapsedTime(now - ((Long) timeSlot2.getLower()).longValue()));
        goto L22
    L24:
        totalMimeFreqScore = totalMimeFreqScore + shareTargetScore.getMimeFrequencyScore();
        mimeFreqScoreCount = mimeFreqScoreCount + 1;
    L25:
        Range<Long> mostRecentTimeSlot = target.getEventHistory().getEventIndex(Event.SHARE_EVENT_TYPES).getMostRecentActiveTimeSlot();
        if (mostRecentTimeSlot == null) goto L7;
        if (recencyMinHeap.size() < RECENCY_SCORE_COUNT.intValue()) goto L33;
        if (((Long) mostRecentTimeSlot.getUpper()).longValue() <= ((Long) ((Range) recencyMinHeap.peek().second).getUpper()).longValue()) goto L7;
    L33:
        if (recencyMinHeap.size() != RECENCY_SCORE_COUNT.intValue()) goto L35;
        recencyMinHeap.poll();
    L35:
        recencyMinHeap.offer(new Pair(shareTargetScore, mostRecentTimeSlot));
    L39:
        if (recencyMinHeap.isEmpty() == true) goto L44;
        float recencyScore = RECENCY_INITIAL_BASE_SCORE;
        if (recencyMinHeap.size() <= 1) goto L43;
        recencyScore = 0.35f - ((recencyMinHeap.size() - 2) * RECENCY_SCORE_SUBSEQUENT_DECAY);
    L43:
        ((ShareTargetRankingScore) recencyMinHeap.poll().first).setRecencyScore(recencyScore);
        goto L39
    L44:
        float r7 = FOREGROUND_APP_WEIGHT;
        if (freqScoreCount == 0) goto L47;
        float r8 = totalFreqScore / freqScoreCount;
    L48:
        Float avgFreq = Float.valueOf(r8);
        if (mimeFreqScoreCount == 0) goto L51;
        float r9 = totalMimeFreqScore / mimeFreqScoreCount;
    L52:
        Float avgMimeFreq = Float.valueOf(r9);
        int i = 0;
    L54:
        if (i >= scoreList.size()) goto L65;
        ShareTargetPredictor.ShareTarget target2 = shareTargets.get(i);
        ShareTargetRankingScore targetScore = scoreList.get(i);
        double r15 = 0.0d;
        if (avgFreq.equals(Float.valueOf(r7)) == false) goto L58;
        double r11 = 0.0d;
    L59:
        targetScore.setFrequencyScore(normalizeFreqScore(r11));
        if (avgMimeFreq.equals(Float.valueOf(r7)) == true) goto L63;
        r15 = targetScore.getMimeFrequencyScore() / avgMimeFreq.floatValue();
    L63:
        targetScore.setMimeFrequencyScore(normalizeMimeFreqScore(r15));
        targetScore.setTotalScore(probOR(probOR(targetScore.getRecencyScore(), targetScore.getFrequencyScore()), targetScore.getMimeFrequencyScore()));
        target2.setScore(targetScore.getTotalScore());
        i = i + 1;
        r7 = r7;
        avgFreq = avgFreq;
        goto L54
    L58:
        r11 = targetScore.getFrequencyScore() / avgFreq.floatValue();
        goto L59
    L65:
        return;
    L51:
        r9 = 0.0f;
        goto L52
    L47:
        r8 = 0.0f;
        goto L48
    }

    private static /* synthetic */ long lambda$computeScore$0(Pair p) {
        return ((Long) ((Range) p.second).getUpper()).longValue();
    }

    static void computeScoreForAppShare(List<ShareTargetPredictor.ShareTarget> shareTargets, int shareEventType, int targetsLimit, long now, DataManager dataManager, int callingUserId, String chooserActivity) {
        computeScore(shareTargets, shareEventType, now);
        postProcess(shareTargets, targetsLimit, dataManager, callingUserId, chooserActivity);
    }

    private static void postProcess(List<ShareTargetPredictor.ShareTarget> shareTargets, int targetsLimit, DataManager dataManager, int callingUserId, String chooserActivity) {
        Map<String, List<ShareTargetPredictor.ShareTarget>> shareTargetMap = new ArrayMap();
        Iterator<ShareTargetPredictor.ShareTarget> r1 = shareTargets.iterator();
    L4:
        if (r1.hasNext() == false) goto L13;
        ShareTargetPredictor.ShareTarget shareTarget = r1.next();
        String packageName = shareTarget.getAppTarget().getPackageName();
        shareTargetMap.computeIfAbsent(packageName, new SharesheetModelScorer$$ExternalSyntheticLambda2());
        List<ShareTargetPredictor.ShareTarget> targetsList = shareTargetMap.get(packageName);
        int index = 0;
    L7:
        if (index >= targetsList.size()) goto L12;
        if (shareTarget.getScore() > targetsList.get(index).getScore()) goto L12;
        index = index + 1;
    L12:
        targetsList.add(index, shareTarget);
        goto L4
    L13:
        promoteForegroundApp(shareTargetMap, dataManager, callingUserId, chooserActivity);
        promoteMostChosenAndFrequentlyUsedApps(shareTargetMap, targetsLimit, dataManager, callingUserId);
    }

    private static /* synthetic */ List lambda$postProcess$1(String key) {
        return new ArrayList();
    }

    private static void promoteMostChosenAndFrequentlyUsedApps(Map<String, List<ShareTargetPredictor.ShareTarget>> shareTargetMap, int targetsLimit, DataManager dataManager, int callingUserId) {
        int validPredictionNum = 0;
        float minValidScore = 1.0f;
        Iterator<List<ShareTargetPredictor.ShareTarget>> r2 = shareTargetMap.values().iterator();
    L4:
        if (r2.hasNext() == false) goto L13;
        List<ShareTargetPredictor.ShareTarget> targets = r2.next();
        Iterator<ShareTargetPredictor.ShareTarget> r4 = targets.iterator();
    L7:
        if (r4.hasNext() == false) goto L4;
        ShareTargetPredictor.ShareTarget target = r4.next();
        if (target.getScore() <= FOREGROUND_APP_WEIGHT) goto L7;
        validPredictionNum = validPredictionNum + 1;
        minValidScore = Math.min(target.getScore(), minValidScore);
        goto L7
    L13:
        if (validPredictionNum < targetsLimit) goto L15;
        return;
    L15:
        long now = System.currentTimeMillis();
        Map<String, AppUsageStatsData> appStatsMap = dataManager.queryAppUsageStats(callingUserId, now - ONE_MONTH_WINDOW, now, shareTargetMap.keySet());
        float minValidScore2 = promoteApp(shareTargetMap, appStatsMap, new SharesheetModelScorer$$ExternalSyntheticLambda0(), USAGE_STATS_CHOOSER_SCORE_INITIAL_DECAY * minValidScore, minValidScore);
        promoteApp(shareTargetMap, appStatsMap, new SharesheetModelScorer$$ExternalSyntheticLambda1(), FREQUENTLY_USED_APP_SCORE_INITIAL_DECAY * minValidScore2, minValidScore2);
    }

    private static float promoteApp(Map<String, List<ShareTargetPredictor.ShareTarget>> shareTargetMap, Map<String, AppUsageStatsData> appStatsMap, Function<AppUsageStatsData, Integer> countFunc, float baseScore, float minValidScore) {
        int maxCount = 0;
        Iterator<AppUsageStatsData> r1 = appStatsMap.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        AppUsageStatsData data = r1.next();
        maxCount = Math.max(maxCount, countFunc.apply(data).intValue());
        goto L4
    L6:
        if (maxCount <= 0) goto L20;
        Iterator<Map.Entry<String, AppUsageStatsData>> r2 = appStatsMap.entrySet().iterator();
    L9:
        if (r2.hasNext() == false) goto L20;
        Map.Entry<String, AppUsageStatsData> entry = r2.next();
        if (shareTargetMap.containsKey(entry.getKey()) == false) goto L9;
        ShareTargetPredictor.ShareTarget target = shareTargetMap.get(entry.getKey()).get(0);
        if (target.getScore() > FOREGROUND_APP_WEIGHT) goto L9;
        float curScore = (countFunc.apply(entry.getValue()).intValue() * baseScore) / maxCount;
        target.setScore(curScore);
        if (curScore <= FOREGROUND_APP_WEIGHT) goto L9;
        minValidScore = Math.min(minValidScore, curScore);
    L20:
        return minValidScore;
    }

    private static void promoteForegroundApp(Map<String, List<ShareTargetPredictor.ShareTarget>> shareTargetMap, DataManager dataManager, int callingUserId, String chooserActivity) {
        String sharingForegroundApp = findSharingForegroundApp(shareTargetMap, dataManager, callingUserId, chooserActivity);
        if (sharingForegroundApp == null) goto L6;
        ShareTargetPredictor.ShareTarget target = shareTargetMap.get(sharingForegroundApp).get(0);
        target.setScore(probOR(target.getScore(), FOREGROUND_APP_WEIGHT));
        return;
    }

    private static String findSharingForegroundApp(Map<String, List<ShareTargetPredictor.ShareTarget>> shareTargetMap, DataManager dataManager, int callingUserId, String chooserActivity) {
        long now = System.currentTimeMillis();
        List<UsageEvents.Event> events = dataManager.queryAppMovingToForegroundEvents(callingUserId, now - FOREGROUND_APP_PROMO_TIME_WINDOW, now);
        String sourceApp = null;
        int i = events.size() - 1;
    L3:
        if (i < 0) goto L27;
        String className = events.get(i).getClassName();
        String packageName = events.get(i).getPackageName();
        if (packageName == null) goto L18;
        if (className == null) goto L11;
        if (chooserActivity == null) goto L11;
        if (className.contains(chooserActivity) == true) goto L18;
    L11:
        if (sourceApp != null) goto L14;
        sourceApp = packageName;
        goto L18
    L14:
        if (packageName.equals(sourceApp) == true) goto L18;
        if (shareTargetMap.containsKey(packageName) == false) goto L18;
        return packageName;
    L18:
        i = i - 1;
        goto L3
    L27:
        return null;
    }

    private static float probOR(float a, float b) {
        return 1.0f - ((1.0f - a) * (1.0f - b));
    }

    private static float getFreqDecayedOnElapsedTime(long elapsedTimeMillis) {
        Duration duration = Duration.ofMillis(elapsedTimeMillis);
        if (duration.compareTo(Duration.ofDays(1)) > 0) goto L7;
        return 1.0f;
    L7:
        if (duration.compareTo(Duration.ofDays(3)) > 0) goto L11;
        return USAGE_STATS_CHOOSER_SCORE_INITIAL_DECAY;
    L11:
        if (duration.compareTo(Duration.ofDays(7)) > 0) goto L15;
        return 0.8f;
    L15:
        if (duration.compareTo(Duration.ofDays(14)) > 0) goto L18;
        return 0.7f;
    L18:
        return 0.6f;
    }

    private static float normalizeFreqScore(double freqRatio) {
        if (freqRatio < 2.5d) goto L7;
        return 0.2f;
    L7:
        if (freqRatio < 1.5d) goto L11;
        return 0.15f;
    L11:
        if (freqRatio < 1.0d) goto L15;
        return 0.1f;
    L15:
        if (freqRatio < 0.75d) goto L18;
        return RECENCY_SCORE_INITIAL_DECAY;
    L18:
        return FOREGROUND_APP_WEIGHT;
    }

    private static float normalizeMimeFreqScore(double freqRatio) {
        if (freqRatio < 2.0d) goto L7;
        return 0.2f;
    L7:
        if (freqRatio < 1.2d) goto L11;
        return 0.15f;
    L11:
        if (freqRatio <= 0.0d) goto L14;
        return 0.1f;
    L14:
        return FOREGROUND_APP_WEIGHT;
    }
}
