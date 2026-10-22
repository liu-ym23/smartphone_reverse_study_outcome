package com.android.server.security;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.net.NetworkRequest;
import android.os.Binder;
import android.os.Environment;
import android.util.AtomicFile;
import android.util.Slog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.cert.CertPathValidatorException;
import java.security.cert.X509Certificate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
class CertificateRevocationStatusManager {
    private static final int JOB_ID = 1737671340;
    static final int MAX_OFFLINE_REVOCATION_LIST_AGE_DAYS = 30;
    static final int NUM_HOURS_BEFORE_NEXT_FETCH = 24;
    private static final String REVOCATION_LIST_FILE_NAME = "certificate_revocation_list.json";
    private static final String TAG = "AVF_CRL";
    private static final String TOP_LEVEL_JSON_PROPERTY_KEY = "entries";
    private static final Object sFileLock = null;
    private final Context mContext;
    private final boolean mShouldScheduleJob;
    private final String mTestRemoteRevocationListUrl;
    private final File mTestStoredRevocationListFile;

    public static /* synthetic */ void $r8$lambda$F6XQfwTEjF9E2YkHLOw_QbbK6AY(CertificateRevocationStatusManager r0) {
        r0.scheduleJobToFetchRemoteRevocationJob();
    }

    static {
        sFileLock = new Object();
    }

    CertificateRevocationStatusManager(Context context) {
        this(context, null, null, true);
    }

    CertificateRevocationStatusManager(Context context, String testRemoteRevocationListUrl, File testStoredRevocationListFile, boolean shouldScheduleJob) {
        this.mContext = context;
        this.mTestRemoteRevocationListUrl = testRemoteRevocationListUrl;
        this.mTestStoredRevocationListFile = testStoredRevocationListFile;
        this.mShouldScheduleJob = shouldScheduleJob;
    }

    void checkRevocationStatus(List<X509Certificate> certificates) throws CertPathValidatorException {
        List<String> serialNumbers = new ArrayList();
        Iterator<X509Certificate> r2 = certificates.iterator();
    L4:
        if (r2.hasNext() == false) goto L10;
        X509Certificate certificate = r2.next();
        String serialNumber = certificate.getSerialNumber().toString(16);
        if (serialNumber == null) goto L9;
        serialNumbers.add(serialNumber);
        goto L4
    L9:
        throw new CertPathValidatorException("Certificate serial number cannot be null.");
    L10:
        LocalDateTime now = LocalDateTime.now();
        if (getLastModifiedDateTime(getRevocationListFile()).isAfter(now.minusHours(24)) == false) goto L33;
        Slog.d(TAG, "CRL is fetched recently, do not fetch again.");     // Catch: Throwable -> L15
        JSONObject revocationList = getStoredRevocationList();     // Catch: Throwable -> L15
        checkRevocationStatus(revocationList, serialNumbers);     // Catch: Throwable -> L15
        return;
    L33:
        byte[] revocationListBytes = fetchRemoteRevocationListBytes();     // Catch: Throwable -> L20
        silentlyStoreRevocationList(revocationListBytes);     // Catch: Throwable -> L20
        JSONObject revocationList2 = parseRevocationList(revocationListBytes);     // Catch: Throwable -> L20
        checkRevocationStatus(revocationList2, serialNumbers);     // Catch: Throwable -> L20
        return;
    L20:
        ex = move-exception;
        Slog.d(TAG, "Fallback to check stored revocation status", ex);
        if ((ex instanceof IOException) == true) goto L24;
    L31:
        JSONObject revocationList3 = getStoredRevocationList();     // Catch: Throwable -> L28
        checkRevocationStatus(revocationList3, serialNumbers);     // Catch: Throwable -> L28
        return;
    L28:
        ex2 = move-exception;
        throw new CertPathValidatorException("Unable to load or parse stored revocation status", ex2);
    L24:
        if (this.mShouldScheduleJob == false) goto L31;
        Binder.withCleanCallingIdentity(new CertificateRevocationStatusManager$$ExternalSyntheticLambda0(this));
        goto L31
    }

    private static void checkRevocationStatus(JSONObject revocationList, List<String> serialNumbers) throws CertPathValidatorException {
        Iterator<String> r0 = serialNumbers.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        String serialNumber = r0.next();
        if (revocationList.has(serialNumber) == false) goto L4;
        throw new CertPathValidatorException("Certificate has been revoked: " + serialNumber);
    }

    private JSONObject getStoredRevocationList() throws IOException, JSONException {
        File offlineRevocationListFile = getRevocationListFile();
        if (offlineRevocationListFile.exists() == false) goto L24;
        if (isRevocationListExpired(offlineRevocationListFile) == true) goto L24;
        Object r1 = sFileLock;
        monitor-enter(r1);
        FileInputStream inputStream = new FileInputStream(offlineRevocationListFile);     // Catch: Throwable -> L13
        JSONObject r3 = parseRevocationList(inputStream.readAllBytes());     // Catch: Throwable -> L15
        inputStream.close();     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        return r3;
    L15:
        th = move-exception;
        inputStream.close();     // Catch: Throwable -> L18
    L20:
        throw th;     // Catch: Throwable -> L13
    L18:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    L24:
        throw new FileNotFoundException("Offline copy does not exist or has expired.");
    }

    private boolean isRevocationListExpired(File offlineRevocationListFile) {
        LocalDateTime acceptableLastModifiedDate = LocalDateTime.now().minusDays(30);
        LocalDateTime lastModifiedDate = getLastModifiedDateTime(offlineRevocationListFile);
        return lastModifiedDate.isBefore(acceptableLastModifiedDate);
    }

    private static LocalDateTime getLastModifiedDateTime(File file) {
        return LocalDateTime.ofEpochSecond(file.lastModified() / 1000, 0, OffsetDateTime.now().getOffset());
    }

    void silentlyStoreRevocationList(byte[] revocationListBytes) {
        Object r0 = sFileLock;
        monitor-enter(r0);
        AtomicFile atomicRevocationListFile = new AtomicFile(getRevocationListFile());     // Catch: Throwable -> L8
        FileOutputStream fileOutputStream = null;
        fileOutputStream = atomicRevocationListFile.startWrite();     // Catch: Throwable -> L8 IOException -> L10
        fileOutputStream.write(revocationListBytes);     // Catch: Throwable -> L8 IOException -> L10
        atomicRevocationListFile.finishWrite(fileOutputStream);     // Catch: Throwable -> L8 IOException -> L10
        Slog.d(TAG, "Successfully stored revocation list.");     // Catch: Throwable -> L8 IOException -> L10
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        ex = move-exception;
        Slog.e(TAG, "Failed to store the certificate revocation list.", ex);     // Catch: Throwable -> L8
        if (fileOutputStream == null) goto L14;
        atomicRevocationListFile.failWrite(fileOutputStream);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    private File getRevocationListFile() {
        if (this.mTestStoredRevocationListFile == null) goto L7;
        return this.mTestStoredRevocationListFile;
    L7:
        return new File(Environment.getDataSystemDirectory(), REVOCATION_LIST_FILE_NAME);
    }

    private void scheduleJobToFetchRemoteRevocationJob() {
        JobScheduler jobScheduler = (JobScheduler) this.mContext.getSystemService(JobScheduler.class);
        if (jobScheduler != null) goto L6;
        Slog.e(TAG, "Unable to get job scheduler.");
        return;
    L6:
        Slog.d(TAG, "Scheduling job to fetch remote CRL.");
        jobScheduler.forNamespace(TAG).schedule(new JobInfo.Builder(JOB_ID, new ComponentName(this.mContext, UpdateCertificateRevocationStatusJobService.class)).setRequiredNetwork(new NetworkRequest.Builder().addCapability(12).build()).build());
    }

    byte[] fetchRemoteRevocationListBytes() throws CertPathValidatorException, IOException {
        String urlString = getRemoteRevocationListUrl();
        if (urlString == null) goto L22;
        if (urlString.isEmpty() == true) goto L22;
        URL url = new URL(urlString);     // Catch: MalformedURLException -> L18
        InputStream inputStream = url.openStream();
        byte[] r3 = inputStream.readAllBytes();     // Catch: Throwable -> L11
        inputStream.close();
        return r3;
    L11:
        th = move-exception;
        if (inputStream != null) goto L25;
    L17:
        throw th;
    L25:
        inputStream.close();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.addSuppressed(th);
    L18:
        ex = move-exception;
        throw new CertPathValidatorException("Unable to parse the URL " + urlString, ex);
    L22:
        throw new CertPathValidatorException("R.string.vendor_required_attestation_revocation_list_url is empty.");
    }

    private JSONObject parseRevocationList(byte[] revocationListBytes) throws IOException, JSONException {
        JSONObject revocationListJson = new JSONObject(new String(revocationListBytes, StandardCharsets.UTF_8));
        return revocationListJson.getJSONObject(TOP_LEVEL_JSON_PROPERTY_KEY);
    }

    private String getRemoteRevocationListUrl() {
        if (this.mTestRemoteRevocationListUrl == null) goto L7;
        return this.mTestRemoteRevocationListUrl;
    L7:
        return this.mContext.getResources().getString(17042331);
    }
}
