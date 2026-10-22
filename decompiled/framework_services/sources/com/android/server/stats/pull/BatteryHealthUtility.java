package com.android.server.stats.pull;

import android.hardware.health.BatteryHealthData;
import android.util.StatsEvent;
import com.android.internal.util.FrameworkStatsLog;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BatteryHealthUtility {
    public BatteryHealthUtility() {
    }

    public static StatsEvent buildStatsEvent(int atomTag, BatteryHealthData data, int chargeStatus, int chargePolicy) throws NoSuchAlgorithmException {
        int manufacturingDate = secondsToWeekYYYYMMDD(data.batteryManufacturingDateSeconds);
        int firstUsageDate = secondsToWeekYYYYMMDD(data.batteryFirstUsageSeconds);
        long stateOfHealth = data.batteryStateOfHealth;
        int partStatus = data.batteryPartStatus;
        int serialHashTruncated = stringToIntHash(data.batterySerialNumber) & 255;
        return FrameworkStatsLog.buildStatsEvent(atomTag, manufacturingDate, firstUsageDate, (int) stateOfHealth, serialHashTruncated, partStatus, chargeStatus, chargePolicy);
    }

    private static int secondsToWeekYYYYMMDD(long seconds) {
        Calendar calendar = Calendar.getInstance();
        long millis = 1000 * seconds;
        calendar.setTimeInMillis(millis);
        calendar.set(7, 2);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd", Locale.US);
        String formattedDate = sdf.format(calendar.getTime());
        return Integer.parseInt(formattedDate);
    }

    private static int stringToIntHash(String data) throws NoSuchAlgorithmException {
        if (data != null) goto L4;
        return 0;
    L4:
        if (data.isEmpty() == true) goto L10;
        MessageDigest digest = MessageDigest.getInstance("MD5");
        byte[] hashBytes = digest.digest(data.getBytes());
        BigInteger bigInt = new BigInteger(1, hashBytes);
        return bigInt.intValue();
    L10:
        return 0;
    }
}
