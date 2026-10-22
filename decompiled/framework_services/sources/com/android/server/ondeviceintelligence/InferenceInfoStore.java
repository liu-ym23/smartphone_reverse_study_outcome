package com.android.server.ondeviceintelligence;

import android.app.ondeviceintelligence.InferenceInfo;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Base64;
import android.util.Slog;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
public class InferenceInfoStore {
    private static final String TAG = "InferenceInfoStore";
    private final TreeSet<InferenceInfo> inferenceInfos;
    private final long maxAgeMs;

    public static /* synthetic */ boolean $r8$lambda$tffXQQ2ks2SHiG2V02f09zrsI4w(long r0, InferenceInfo r2) {
        return lambda$getLatestInferenceInfo$0(r0, r2);
    }

    public InferenceInfoStore(long maxAgeMs) {
        this.maxAgeMs = maxAgeMs;
        this.inferenceInfos = new TreeSet(Comparator.comparingLong(new InferenceInfoStore$$ExternalSyntheticLambda1()));
    }

    public List<InferenceInfo> getLatestInferenceInfo(final long startTimeEpochMillis) {
        return this.inferenceInfos.stream().filter(new InferenceInfoStore$$ExternalSyntheticLambda0(startTimeEpochMillis)).toList();
    }

    private static /* synthetic */ boolean lambda$getLatestInferenceInfo$0(long startTimeEpochMillis, InferenceInfo info) {
        if (info.getStartTimeMillis() <= startTimeEpochMillis) goto L5;
        return true;
    L5:
        return false;
    }

    public void addInferenceInfoFromBundle(PersistableBundle pb) {
        if (pb.containsKey("inference_info") == true) goto L14;
        return;
    L14:
        String infoBytesBase64String = pb.getString("inference_info");     // Catch: IOException -> L9
        if (infoBytesBase64String == null) goto L16;
        byte[] infoBytes = Base64.decode(infoBytesBase64String, 0);     // Catch: IOException -> L9
        com.android.server.ondeviceintelligence.nano.InferenceInfo inferenceInfo = com.android.server.ondeviceintelligence.nano.InferenceInfo.parseFrom(infoBytes);     // Catch: IOException -> L9
        add(inferenceInfo);     // Catch: IOException -> L9
        return;
    L16:
        return;
    L12:
        Slog.e(TAG, "Unable to parse InferenceInfo from the received bytes.");
    }

    public void addInferenceInfoFromBundle(Bundle b) {
        if (b.containsKey("inference_info") == true) goto L14;
        return;
    L14:
        byte[] infoBytes = b.getByteArray("inference_info");     // Catch: IOException -> L9
        if (infoBytes == null) goto L16;
        com.android.server.ondeviceintelligence.nano.InferenceInfo inferenceInfo = com.android.server.ondeviceintelligence.nano.InferenceInfo.parseFrom(infoBytes);     // Catch: IOException -> L9
        add(inferenceInfo);     // Catch: IOException -> L9
        return;
    L16:
        return;
    L12:
        Slog.e(TAG, "Unable to parse InferenceInfo from the received bytes.");
    }

    private synchronized void add(com.android.server.ondeviceintelligence.nano.InferenceInfo info) {
        monitor-enter(this);
    L15:
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.inferenceInfos.isEmpty() == true) goto L10;
        if ((System.currentTimeMillis() - this.inferenceInfos.first().getStartTimeMillis()) <= this.maxAgeMs) goto L10;
        this.inferenceInfos.pollFirst();     // Catch: Throwable -> L8
    L10:
        this.inferenceInfos.add(toInferenceInfo(info));     // Catch: Throwable -> L8
        monitor-exit(this);
    }

    private static InferenceInfo toInferenceInfo(com.android.server.ondeviceintelligence.nano.InferenceInfo info) {
        return new InferenceInfo.Builder(info.uid).setStartTimeMillis(info.startTimeMs).setEndTimeMillis(info.endTimeMs).setSuspendedTimeMillis(info.suspendedTimeMs).build();
    }
}
