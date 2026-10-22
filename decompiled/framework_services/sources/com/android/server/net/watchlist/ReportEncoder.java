package com.android.server.net.watchlist;

import android.util.Log;
import android.util.proto.ProtoOutputStream;
import com.android.internal.util.HexDump;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class ReportEncoder {
    private static final int REPORT_VERSION = 1;
    private static final String TAG = "ReportEncoder";
    private static final int WATCHLIST_HASH_SIZE = 32;

    ReportEncoder() {
    }

    static byte[] encodeWatchlistReport(WatchlistConfig config, byte[] userSecret, List<String> appDigestList, WatchlistReportDbHelper.AggregatedResult aggregatedResult) {
        Map<String, Boolean> resultMap = PrivacyUtils.createDpEncodedReportMap(config.isConfigSecure(), userSecret, appDigestList, aggregatedResult);
        return serializeReport(config, resultMap);
    }

    static byte[] serializeReport(WatchlistConfig config, Map<String, Boolean> encodedReportMap) {
        byte[] watchlistHash = config.getWatchlistConfigHash();
        if (watchlistHash != null) goto L7;
        Log.e(TAG, "No watchlist hash");
        return null;
    L7:
        if (watchlistHash.length == 32) goto L10;
        Log.e(TAG, "Unexpected hash length");
        return null;
    L10:
        ByteArrayOutputStream reportOutputStream = new ByteArrayOutputStream();
        ProtoOutputStream proto = new ProtoOutputStream(reportOutputStream);
        proto.write(1120986464257L, 1);
        proto.write(1138166333442L, HexDump.toHexString(watchlistHash));
        Iterator<Map.Entry<String, Boolean>> r3 = encodedReportMap.entrySet().iterator();
    L12:
        if (r3.hasNext() == false) goto L14;
        Map.Entry<String, Boolean> entry = r3.next();
        String key = entry.getKey();
        HexDump.hexStringToByteArray(key);
        boolean encodedResult = entry.getValue().booleanValue();
        long token = proto.start(2246267895811L);
        proto.write(1138166333441L, key);
        proto.write(1133871366146L, encodedResult);
        proto.end(token);
        goto L12
    L14:
        proto.flush();
        return reportOutputStream.toByteArray();
    }
}
