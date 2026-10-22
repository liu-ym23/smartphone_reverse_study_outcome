package com.android.server.net.watchlist;

import android.privacy.DifferentialPrivacyEncoder;
import android.privacy.internal.longitudinalreporting.LongitudinalReportingConfig;
import android.privacy.internal.longitudinalreporting.LongitudinalReportingEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class PrivacyUtils {
    private static final boolean DEBUG = false;
    private static final String ENCODER_ID_PREFIX = "watchlist_encoder:";
    private static final double PROB_F = 0.469d;
    private static final double PROB_P = 0.28d;
    private static final double PROB_Q = 1.0d;
    private static final String TAG = "PrivacyUtils";

    private PrivacyUtils() {
    }

    static DifferentialPrivacyEncoder createInsecureDPEncoderForTest(String appDigest) {
        LongitudinalReportingConfig config = createLongitudinalReportingConfig(appDigest);
        return LongitudinalReportingEncoder.createInsecureEncoderForTest(config);
    }

    static DifferentialPrivacyEncoder createSecureDPEncoder(byte[] userSecret, String appDigest) {
        LongitudinalReportingConfig config = createLongitudinalReportingConfig(appDigest);
        return LongitudinalReportingEncoder.createEncoder(config, userSecret);
    }

    private static LongitudinalReportingConfig createLongitudinalReportingConfig(String appDigest) {
        return new LongitudinalReportingConfig(ENCODER_ID_PREFIX + appDigest, PROB_F, PROB_P, PROB_Q);
    }

    static Map<String, Boolean> createDpEncodedReportMap(boolean isSecure, byte[] userSecret, List<String> appDigestList, WatchlistReportDbHelper.AggregatedResult aggregatedResult) {
        int appDigestListSize = appDigestList.size();
        HashMap<String, Boolean> resultMap = new HashMap(appDigestListSize);
        int i = 0;
    L3:
        if (i >= appDigestListSize) goto L13;
        String appDigest = appDigestList.get(i);
        if (isSecure == false) goto L7;
        DifferentialPrivacyEncoder encoder = createSecureDPEncoder(userSecret, appDigest);
    L8:
        boolean visitedWatchlist = aggregatedResult.appDigestList.contains(appDigest);
        boolean encodedVisitedWatchlist = false;
        if ((encoder.encodeBoolean(visitedWatchlist)[0] & 1) != 1) goto L11;
        encodedVisitedWatchlist = true;
    L11:
        resultMap.put(appDigest, Boolean.valueOf(encodedVisitedWatchlist));
        i = i + 1;
        goto L3
    L7:
        encoder = createInsecureDPEncoderForTest(appDigest);
        goto L8
    L13:
        return resultMap;
    }
}
