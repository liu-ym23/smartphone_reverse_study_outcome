package com.android.server.location.gnss;

import android.net.TrafficStats;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
class GnssPsdsDownloader {
    private static final int CONNECTION_TIMEOUT_MS = 0;
    private static final boolean DEBUG = false;
    static final int LONG_TERM_PSDS_SERVER_INDEX = 1;
    private static final long MAXIMUM_CONTENT_LENGTH_BYTES = 1000000;
    private static final int MAX_PSDS_TYPE_INDEX = 3;
    private static final int NORMAL_PSDS_SERVER_INDEX = 2;
    static final long PSDS_INTERVAL = 86400000;
    private static final int READ_TIMEOUT_MS = 0;
    private static final int REALTIME_PSDS_SERVER_INDEX = 3;
    private static final String TAG = "GnssPsdsDownloader";
    private final String[] mLongTermPsdsServers;
    private int mNextServerIndex;
    private final String[] mPsdsServers;

    static {
        DEBUG = Log.isLoggable(TAG, 3);
        CONNECTION_TIMEOUT_MS = (int) TimeUnit.SECONDS.toMillis(30);
        READ_TIMEOUT_MS = (int) TimeUnit.SECONDS.toMillis(60);
    }

    GnssPsdsDownloader(Properties properties) {
        int count = 0;
        String longTermPsdsServer1 = properties.getProperty("LONGTERM_PSDS_SERVER_1");
        String longTermPsdsServer2 = properties.getProperty("LONGTERM_PSDS_SERVER_2");
        String longTermPsdsServer3 = properties.getProperty("LONGTERM_PSDS_SERVER_3");
        if (longTermPsdsServer1 == null) goto L5;
        count = 0 + 1;
    L5:
        if (longTermPsdsServer2 == null) goto L7;
        count = count + 1;
    L7:
        if (longTermPsdsServer3 == null) goto L9;
        count = count + 1;
    L9:
        if (count != 0) goto L11;
        Log.e(TAG, "No Long-Term PSDS servers were specified in the GnssConfiguration");
        this.mLongTermPsdsServers = null;
    L19:
        String normalPsdsServer = properties.getProperty("NORMAL_PSDS_SERVER");
        String realtimePsdsServer = properties.getProperty("REALTIME_PSDS_SERVER");
        this.mPsdsServers = new String[4];
        this.mPsdsServers[2] = normalPsdsServer;
        this.mPsdsServers[3] = realtimePsdsServer;
        return;
    L11:
        this.mLongTermPsdsServers = new String[count];
        int count2 = 0;
        if (longTermPsdsServer1 == null) goto L14;
        int count3 = 0 + 1;
        this.mLongTermPsdsServers[0] = longTermPsdsServer1;
        count2 = count3;
    L14:
        if (longTermPsdsServer2 == null) goto L16;
        this.mLongTermPsdsServers[count2] = longTermPsdsServer2;
        count2 = count2 + 1;
    L16:
        if (longTermPsdsServer3 == null) goto L18;
        this.mLongTermPsdsServers[count2] = longTermPsdsServer3;
        count2 = count2 + 1;
    L18:
        Random random = new Random();
        this.mNextServerIndex = random.nextInt(count2);
        goto L19
    }

    byte[] downloadPsdsData(int psdsType) {
        byte[] result = null;
        int startIndex = this.mNextServerIndex;
        if (psdsType != 1) goto L8;
        if (this.mLongTermPsdsServers != null) goto L8;
        return null;
    L8:
        if (psdsType <= 1) goto L13;
        if (psdsType > 3) goto L13;
        if (this.mPsdsServers[psdsType] != null) goto L13;
        return null;
    L13:
        if (psdsType != 1) goto L21;
    L14:
        if (result != null) goto L31;
        result = doDownloadWithTrafficAccounted(this.mLongTermPsdsServers[this.mNextServerIndex]);
        this.mNextServerIndex++;
        if (this.mNextServerIndex != this.mLongTermPsdsServers.length) goto L19;
        this.mNextServerIndex = 0;
    L19:
        if (this.mNextServerIndex != startIndex) goto L14;
        return result;
    L31:
        return result;
    L21:
        if (psdsType <= 1) goto L28;
        if (psdsType > 3) goto L29;
        byte[] result2 = doDownloadWithTrafficAccounted(this.mPsdsServers[psdsType]);
        return result2;
    L29:
        return null;
    L28:
        return null;
    }

    private byte[] doDownloadWithTrafficAccounted(String url) {
        int oldTag = TrafficStats.getAndSetThreadStatsTag(-188);
        byte[] result = doDownload(url);     // Catch: Throwable -> L6
        TrafficStats.setThreadStatsTag(oldTag);
        return result;
    L6:
        th = move-exception;
        TrafficStats.setThreadStatsTag(oldTag);
        throw th;
    }

    private byte[] doDownload(String url) {
        if (DEBUG == false) goto L5;
        Log.d(TAG, "Downloading PSDS data from " + url);
    L5:
        HttpURLConnection connection = null;
        HttpURLConnection connection2 = (HttpURLConnection) new URL(url).openConnection();     // Catch: Throwable -> L12 IOException -> L14
        connection2.setRequestProperty("Accept", "*/*, application/vnd.wap.mms-message, application/vnd.wap.sic");     // Catch: Throwable -> L12 IOException -> L14
        connection2.setRequestProperty("x-wap-profile", "http://www.openmobilealliance.org/tech/profiles/UAPROF/ccppschema-20021212#");     // Catch: Throwable -> L12 IOException -> L14
        connection2.setConnectTimeout(CONNECTION_TIMEOUT_MS);     // Catch: Throwable -> L12 IOException -> L14
        connection2.setReadTimeout(READ_TIMEOUT_MS);     // Catch: Throwable -> L12 IOException -> L14
        connection2.connect();     // Catch: Throwable -> L12 IOException -> L14
        int statusCode = connection2.getResponseCode();     // Catch: Throwable -> L12 IOException -> L14
        if (statusCode != 200) goto L9;
        InputStream in = connection2.getInputStream();     // Catch: Throwable -> L12 IOException -> L14
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();     // Catch: Throwable -> L28
        byte[] buffer = new byte[1024];     // Catch: Throwable -> L28
    L20:
        int count = in.read(buffer);     // Catch: Throwable -> L28
        if (count == (-1)) goto L34;
        bytes.write(buffer, 0, count);     // Catch: Throwable -> L28
        if (bytes.size() <= MAXIMUM_CONTENT_LENGTH_BYTES) goto L20;
        if (DEBUG == false) goto L31;
        Log.d(TAG, "PSDS file too large");     // Catch: Throwable -> L28
    L31:
        in.close();     // Catch: Throwable -> L12 IOException -> L14
        connection2.disconnect();
        return null;
    L34:
        byte[] r7 = bytes.toByteArray();     // Catch: Throwable -> L28
        in.close();     // Catch: Throwable -> L12 IOException -> L14
        connection2.disconnect();
        return r7;
    L28:
        th = move-exception;
        if (in != null) goto L57;
    L44:
        throw th;     // Catch: Throwable -> L12 IOException -> L14
    L57:
        in.close();     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L12 IOException -> L14
        goto L44
    L9:
        if (DEBUG == false) goto L16;
        Log.d(TAG, "HTTP error downloading gnss PSDS: " + statusCode);     // Catch: Throwable -> L12 IOException -> L14
    L16:
        connection2.disconnect();
        return null;
    L14:
        ioe = move-exception;
        if (DEBUG == false) goto L49;
        Log.d(TAG, "Error downloading gnss PSDS: ", ioe);     // Catch: Throwable -> L12
    L49:
        if (0 == 0) goto L51;
        connection.disconnect();
    L51:
        return null;
    L12:
        th = move-exception;
        if (0 == 0) goto L54;
        connection.disconnect();
    L54:
        throw th;
    }
}
