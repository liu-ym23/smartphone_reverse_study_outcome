package com.android.server.location.gnss;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class GnssSatelliteBlocklistHelper {
    private static final String BLOCKLIST_DELIMITER = ",";
    private static final String TAG = "GnssBlocklistHelper";
    private final GnssSatelliteBlocklistCallback mCallback;
    private final Context mContext;

    interface GnssSatelliteBlocklistCallback {
        void onUpdateSatelliteBlocklist(int[] r1, int[] r2);
    }

    GnssSatelliteBlocklistHelper(Context context, Looper looper, GnssSatelliteBlocklistCallback callback) {
        this.mContext = context;
        this.mCallback = callback;
        final Handler r1 = new Handler(looper);
        ContentObserver contentObserver = new AnonymousClass1(this, r1);
        this.mContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor("gnss_satellite_blocklist"), true, contentObserver, -1);
    }

    void updateSatelliteBlocklist() {
        ContentResolver resolver = this.mContext.getContentResolver();
        String blocklist = Settings.Global.getString(resolver, "gnss_satellite_blocklist");
        if (blocklist != null) goto L5;
        blocklist = "";
    L5:
        Log.i(TAG, String.format("Update GNSS satellite blocklist: %s", new Object[]{blocklist}));
        List<Integer> blocklistValues = parseSatelliteBlocklist(blocklist);     // Catch: NumberFormatException -> L16
        if ((blocklistValues.size() % 2) == 0) goto L11;
        Log.e(TAG, "blocklist string has odd number of values.Aborting updateSatelliteBlocklist");
        return;
    L11:
        int length = blocklistValues.size() / 2;
        int[] constellations = new int[length];
        int[] svids = new int[length];
        int i = 0;
    L12:
        if (i >= length) goto L14;
        constellations[i] = blocklistValues.get(i * 2).intValue();
        svids[i] = blocklistValues.get((i * 2) + 1).intValue();
        i = i + 1;
        goto L12
    L14:
        this.mCallback.onUpdateSatelliteBlocklist(constellations, svids);
        return;
    L16:
        e = move-exception;
        Log.e(TAG, "Exception thrown when parsing blocklist string.", e);
    }

    static List<Integer> parseSatelliteBlocklist(String blocklist) throws NumberFormatException {
        String[] strings = blocklist.split(BLOCKLIST_DELIMITER);
        List<Integer> parsed = new ArrayList(strings.length);
        int r2 = strings.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L12;
        String string = strings[r3].trim();
        if ("".equals(string) == true) goto L11;
        int value = Integer.parseInt(string);
        if (value < 0) goto L10;
        parsed.add(Integer.valueOf(value));
        goto L11
    L10:
        throw new NumberFormatException("Negative value is invalid.");
    L11:
        r3 = r3 + 1;
        goto L3
    L12:
        return parsed;
    }
}
