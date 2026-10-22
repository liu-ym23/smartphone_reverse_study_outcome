package com.stepos.pps.logpull;

import android.util.Log;
import com.stepos.pps.data.util.Constants;
import com.stepos.pps.logpull.LogPullStatusReporter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import okhttp3.internal.ws.RealWebSocket;

/* loaded from: classes.dex */
public class LogPullUploader {
    private static final int BUFFER_SIZE = 65536;
    private static final int MAX_RETRY = 3;
    private static final String TAG = "LogPull.Uploader";
    private final LogPullTaskStore taskStore;

    public interface ProgressCallback {
        void onPaused(String str);

        void onProgress(long j, long j2);

        boolean shouldContinue();
    }

    public LogPullUploader(LogPullTaskStore logPullTaskStore) {
        this.taskStore = logPullTaskStore;
    }

    public static class UploadState {
        public long configId;
        public long expireAt;
        public String filePath;
        public long lastActiveTime;
        public String oaid;
        public String objectKey;
        public long partSize;
        public long totalSize;
        public String uploadId;
        public String uploadUrl;
        public long uploadedBytes;
        public String uploadType = LogPullStatusReporter.UPLOAD_TYPE_NORMAL;
        public final Map<Integer, String> completedParts = new TreeMap();

        public boolean isMultipart() {
            return LogPullStatusReporter.UPLOAD_TYPE_MULTIPART.equals(this.uploadType);
        }

        public int totalParts() {
            long j = this.partSize;
            if (j <= 0) {
                return 0;
            }
            return (int) (((this.totalSize + j) - 1) / j);
        }

        public List<LogPullStatusReporter.CompletedPart> toCompletedPartList() {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<Integer, String> entry : this.completedParts.entrySet()) {
                arrayList.add(new LogPullStatusReporter.CompletedPart(entry.getKey().intValue(), entry.getValue()));
            }
            return arrayList;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v4 */
    public boolean uploadParts(UploadState uploadState, List<LogPullStatusReporter.PartUrl> list, ProgressCallback progressCallback) throws InterruptedException, IOException {
        boolean z;
        LogPullStatusReporter.PartUrl partUrl;
        int i;
        String strPutPart;
        File file = new File(uploadState.filePath);
        boolean z2 = false;
        if (!file.exists()) {
            Log.e(TAG, "待上传文件不存在: " + uploadState.filePath);
            return false;
        }
        uploadState.totalSize = file.length();
        long jCountUploadedBytes = countUploadedBytes(uploadState);
        Iterator<LogPullStatusReporter.PartUrl> it = list.iterator();
        while (it.hasNext()) {
            LogPullStatusReporter.PartUrl next = it.next();
            if (!uploadState.completedParts.containsKey(Integer.valueOf(next.partNumber))) {
                if (progressCallback != null && !progressCallback.shouldContinue()) {
                    progressCallback.onPaused("上传暂停");
                    persistState(uploadState);
                    return z2;
                }
                long j = (next.partNumber - 1) * uploadState.partSize;
                if (j >= uploadState.totalSize) {
                    continue;
                } else {
                    long jMin = Math.min(uploadState.partSize, uploadState.totalSize - j);
                    long j2 = jCountUploadedBytes;
                    boolean z3 = z2;
                    boolean z4 = z3;
                    ?? r1 = z3;
                    while (r1 < 3 && !z4) {
                        try {
                            z = z2;
                            i = r1;
                            try {
                                strPutPart = putPart(uploadState, next.url, j, jMin, progressCallback);
                            } catch (IOException e) {
                                e = e;
                                partUrl = next;
                            }
                        } catch (IOException e2) {
                            e = e2;
                            z = z2;
                            partUrl = next;
                            i = r1;
                        }
                        if (strPutPart == null || strPutPart.isEmpty()) {
                            partUrl = next;
                            try {
                                throw new IOException("分片 " + partUrl.partNumber + " 未返回 ETag");
                            } catch (IOException e3) {
                                e = e3;
                            }
                        } else {
                            uploadState.completedParts.put(Integer.valueOf(next.partNumber), strPutPart);
                            j2 += jMin;
                            uploadState.uploadedBytes = j2;
                            uploadState.lastActiveTime = System.currentTimeMillis();
                            persistState(uploadState);
                            if (progressCallback != null) {
                                try {
                                    partUrl = next;
                                    try {
                                        progressCallback.onProgress(uploadState.uploadedBytes, uploadState.totalSize);
                                    } catch (IOException e4) {
                                        e = e4;
                                        z4 = true;
                                        Log.w(TAG, "分片上传失败 part=" + partUrl.partNumber + " retry=" + i, e);
                                        if (progressCallback == null) {
                                        }
                                        try {
                                            Thread.sleep(((long) Math.pow(3.0d, i)) * Constants.IPC_TIMEOUT);
                                            int i2 = i + 1;
                                            next = partUrl;
                                            z2 = z;
                                            r1 = i2;
                                        } catch (InterruptedException unused) {
                                            Thread.currentThread().interrupt();
                                            return z;
                                        }
                                    }
                                } catch (IOException e5) {
                                    e = e5;
                                    partUrl = next;
                                }
                            } else {
                                partUrl = next;
                            }
                            z4 = true;
                            int i22 = i + 1;
                            next = partUrl;
                            z2 = z;
                            r1 = i22;
                        }
                        Log.w(TAG, "分片上传失败 part=" + partUrl.partNumber + " retry=" + i, e);
                        if (progressCallback == null && !progressCallback.shouldContinue()) {
                            persistState(uploadState);
                            return z;
                        }
                        Thread.sleep(((long) Math.pow(3.0d, i)) * Constants.IPC_TIMEOUT);
                        int i222 = i + 1;
                        next = partUrl;
                        z2 = z;
                        r1 = i222;
                    }
                    boolean z5 = z2;
                    if (!z4) {
                        persistState(uploadState);
                        if (progressCallback != null) {
                            progressCallback.onPaused("分片上传失败，等待续传");
                        }
                        return z5;
                    }
                    jCountUploadedBytes = j2;
                    z2 = z5;
                }
            }
        }
        boolean z6 = z2;
        if (uploadState.completedParts.size() >= uploadState.totalParts()) {
            return true;
        }
        return z6;
    }

    private String putPart(UploadState uploadState, String str, long j, long j2, ProgressCallback progressCallback) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        try {
            httpURLConnection.setRequestMethod("PUT");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestProperty("Content-Type", "application/octet-stream");
            httpURLConnection.setFixedLengthStreamingMode(j2);
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setReadTimeout((int) Math.min(2147483647L, Math.min(7200000L, Math.max(Constants.SYSTEM_SERVER_INTERVAL, j2 / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE))));
            RandomAccessFile randomAccessFile = new RandomAccessFile(uploadState.filePath, "r");
            try {
                OutputStream outputStream = httpURLConnection.getOutputStream();
                try {
                    randomAccessFile.seek(j);
                    byte[] bArr = new byte[BUFFER_SIZE];
                    while (j2 > 0) {
                        if (progressCallback != null && !progressCallback.shouldContinue()) {
                            throw new IOException("upload cancelled");
                        }
                        int i = randomAccessFile.read(bArr, 0, (int) Math.min(BUFFER_SIZE, j2));
                        if (i < 0) {
                            throw new IOException("文件提前结束");
                        }
                        outputStream.write(bArr, 0, i);
                        j2 -= i;
                    }
                    outputStream.flush();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    randomAccessFile.close();
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode < 200 || responseCode >= 300) {
                        throw new IOException("TOS 分片返回错误: " + responseCode);
                    }
                    String headerField = httpURLConnection.getHeaderField("ETag");
                    if (headerField == null) {
                        headerField = httpURLConnection.getHeaderField("Etag");
                    }
                    return headerField;
                } finally {
                }
            } finally {
            }
        } finally {
            httpURLConnection.disconnect();
        }
    }

    private static long countUploadedBytes(UploadState uploadState) {
        Iterator<Integer> it = uploadState.completedParts.keySet().iterator();
        long jMin = 0;
        while (it.hasNext()) {
            jMin += Math.min(uploadState.partSize, Math.max(0L, uploadState.totalSize - ((it.next().intValue() - 1) * uploadState.partSize)));
        }
        return jMin;
    }

    public boolean upload(UploadState uploadState, ProgressCallback progressCallback) throws InterruptedException {
        File file = new File(uploadState.filePath);
        if (!file.exists()) {
            Log.e(TAG, "待上传文件不存在: " + uploadState.filePath);
            return false;
        }
        uploadState.totalSize = file.length();
        for (int i = 0; i < 3; i++) {
            if (progressCallback != null && !progressCallback.shouldContinue()) {
                progressCallback.onPaused("上传暂停");
                persistState(uploadState);
                return false;
            }
            try {
                putFile(uploadState, progressCallback);
                Log.i(TAG, "TOS 上传完成: objectKey=" + uploadState.objectKey + " size=" + uploadState.totalSize);
                return true;
            } catch (IOException e) {
                Log.w(TAG, "TOS 上传失败, retry=" + i, e);
                try {
                    Thread.sleep(((long) Math.pow(3.0d, i)) * Constants.IPC_TIMEOUT);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return false;
                }
            }
        }
        if (progressCallback != null) {
            progressCallback.onPaused("上传失败，等待重试");
        }
        persistState(uploadState);
        return false;
    }

    private void putFile(UploadState uploadState, ProgressCallback progressCallback) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(uploadState.uploadUrl).openConnection();
        try {
            httpURLConnection.setRequestMethod("PUT");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestProperty("Content-Type", "application/octet-stream");
            httpURLConnection.setFixedLengthStreamingMode(uploadState.totalSize);
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setReadTimeout((int) Math.min(2147483647L, Math.min(7200000L, Math.max(Constants.SYSTEM_SERVER_INTERVAL, uploadState.totalSize / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE))));
            FileInputStream fileInputStream = new FileInputStream(uploadState.filePath);
            try {
                OutputStream outputStream = httpURLConnection.getOutputStream();
                try {
                    byte[] bArr = new byte[BUFFER_SIZE];
                    long j = 0;
                    long j2 = 1048576;
                    while (true) {
                        int i = fileInputStream.read(bArr);
                        if (i != -1) {
                            if (progressCallback != null && !progressCallback.shouldContinue()) {
                                throw new IOException("upload cancelled");
                            }
                            outputStream.write(bArr, 0, i);
                            j += i;
                            uploadState.uploadedBytes = j;
                            uploadState.lastActiveTime = System.currentTimeMillis();
                            if (progressCallback != null && j >= j2) {
                                progressCallback.onProgress(j, uploadState.totalSize);
                                j2 = j + 1048576;
                            }
                        } else {
                            outputStream.flush();
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            fileInputStream.close();
                            int responseCode = httpURLConnection.getResponseCode();
                            if (responseCode < 200 || responseCode >= 300) {
                                throw new IOException("TOS 返回错误: " + responseCode);
                            }
                            uploadState.uploadedBytes = uploadState.totalSize;
                            if (progressCallback != null) {
                                progressCallback.onProgress(uploadState.totalSize, uploadState.totalSize);
                            }
                            return;
                        }
                    }
                } finally {
                }
            } finally {
            }
        } finally {
            httpURLConnection.disconnect();
        }
    }

    public void persistState(UploadState uploadState) {
        this.taskStore.saveUpload(uploadState);
    }

    public UploadState loadState() {
        return this.taskStore.loadUpload();
    }

    public void clearState() {
        this.taskStore.clearUpload();
    }
}
