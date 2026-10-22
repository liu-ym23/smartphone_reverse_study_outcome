package com.obric.aivoice.sdk;

import com.obric.aivoice.core.AIVoiceManagerInner;
import com.obric.aivoice.core.log.AIVoiceLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AIVoiceTask.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0004J\u0016\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004J\u001e\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0004J\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004J\u000e\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0004J\u000e\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0004J\u0016\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u0004J\u000e\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0004J\u0016\u0010 \u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/obric/aivoice/sdk/AIVoiceTask;", "", "()V", "TAG", "", "mAsrListener", "Lcom/obric/aivoice/sdk/IAsrListener;", "mTtsListener", "Lcom/obric/aivoice/sdk/ITtsListener;", "addAsrListener", "", "listener", "addTtsListener", "createAsrTask", "", "asrConfig", "createFileAsrTask", "Lcom/obric/aivoice/sdk/FileAsrTaskListener;", "createTtsTask", "ttsConfig", "onAsrResult", "taskId", "resp", "onTtsResult", "data", "", "queryFileAsrTask", "removeAsrTask", "removeTtsTask", "writeAsrData", "asrData", "writeTtsEnd", "writeTtsText", "text", "voicesdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AIVoiceTask {
    public static final AIVoiceTask INSTANCE = null;
    public static final String TAG = "AIVoiceTask";
    private static IAsrListener mAsrListener;
    private static ITtsListener mTtsListener;

    static {
        INSTANCE = new AIVoiceTask();
    }

    private AIVoiceTask() {
    }

    public final int createAsrTask(String r1) {
        Intrinsics.checkNotNullParameter(r1, "asrConfig");
        return AIVoiceManagerInner.INSTANCE.createAsrTask(r1);
    }

    public final int writeAsrData(byte[] r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "data");
        Intrinsics.checkNotNullParameter(r2, "asrData");
        return AIVoiceManagerInner.INSTANCE.writeAsrData(r1, r2);
    }

    public final int removeAsrTask(String r1) {
        Intrinsics.checkNotNullParameter(r1, "taskId");
        return AIVoiceManagerInner.INSTANCE.removeAsrTask(r1);
    }

    public final String queryFileAsrTask(String r1) {
        Intrinsics.checkNotNullParameter(r1, "taskId");
        return AIVoiceManagerInner.INSTANCE.queryFileAsrTask(r1);
    }

    public final String createFileAsrTask(String r1, FileAsrTaskListener r2) {
        Intrinsics.checkNotNullParameter(r1, "asrConfig");
        return AIVoiceManagerInner.INSTANCE.createFileAsrTask(r1, r2);
    }

    public final void addAsrListener(IAsrListener r1) {
        Intrinsics.checkNotNullParameter(r1, "listener");
        mAsrListener = r1;
    }

    public final void onAsrResult(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "taskId");
        Intrinsics.checkNotNullParameter(r2, "resp");
        IAsrListener r0 = mAsrListener;
        if (r0 == null) goto L6;
        r0.onAsrResponse(r1, r2);
        return;
    }

    public final int createTtsTask(String r1) {
        Intrinsics.checkNotNullParameter(r1, "ttsConfig");
        return AIVoiceManagerInner.INSTANCE.createTtsTask(r1);
    }

    public final int writeTtsText(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "taskId");
        Intrinsics.checkNotNullParameter(r2, "text");
        return AIVoiceManagerInner.INSTANCE.writeTtsText(r1, r2);
    }

    public final int writeTtsEnd(String r1) {
        Intrinsics.checkNotNullParameter(r1, "taskId");
        return AIVoiceManagerInner.INSTANCE.writeTtsEnd(r1);
    }

    public final int removeTtsTask(String r1) {
        Intrinsics.checkNotNullParameter(r1, "taskId");
        return AIVoiceManagerInner.INSTANCE.removeTtsTask(r1);
    }

    public final void addTtsListener(ITtsListener r1) {
        Intrinsics.checkNotNullParameter(r1, "listener");
        mTtsListener = r1;
    }

    public final void onTtsResult(String r3, byte[] r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(r4, "data");
        Intrinsics.checkNotNullParameter(r5, "resp");
        AIVoiceLog.INSTANCE.d(TAG, "onAsrResult mTtsListener:" + mTtsListener);
        ITtsListener r2 = mTtsListener;
        if (r2 == null) goto L6;
        r2.onTtsResponse(r3, r4, r5);
        return;
    }
}
