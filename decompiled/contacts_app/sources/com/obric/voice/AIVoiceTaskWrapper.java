package com.obric.voice;

import android.content.Context;
import com.GlobalProxyLancet;
import com.obric.aivoice.sdk.AIVoiceConfig;
import com.obric.aivoice.sdk.AIVoiceManager;
import com.obric.aivoice.sdk.AIVoiceTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AIVoiceTaskWrapper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000/\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0004J\u0016\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/obric/voice/AIVoiceTaskWrapper;", "", "()V", "TAG", "", "aiVoiceServerConnectListener", "com/obric/voice/AIVoiceTaskWrapper$aiVoiceServerConnectListener$1", "Lcom/obric/voice/AIVoiceTaskWrapper$aiVoiceServerConnectListener$1;", "createTtsTask", "", "ttsConfig", "initVoiceServer", "", "context", "Landroid/content/Context;", "removeTtsTask", "taskId", "writeTtsEnd", "writeTtsText", "text", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AIVoiceTaskWrapper {
    public static final AIVoiceTaskWrapper INSTANCE = null;
    private static final String TAG = "AIVoiceTaskWrapper";
    private static final AIVoiceTaskWrapper$aiVoiceServerConnectListener$1 aiVoiceServerConnectListener = null;

    private AIVoiceTaskWrapper() {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.obric.voice.AIVoiceTaskWrapper$aiVoiceServerConnectListener$1] */
    static {
        INSTANCE = new AIVoiceTaskWrapper();
        aiVoiceServerConnectListener = new AIVoiceTaskWrapper$aiVoiceServerConnectListener$1();
    }

    public final void initVoiceServer(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "initVoiceServer");
        AIVoiceConfig.Builder r3 = new AIVoiceConfig.Builder(r4).appId(0);
        String r5 = r4.getPackageName();
        Intrinsics.checkNotNullExpressionValue(r5, "context.packageName");
        AIVoiceConfig r6 = r3.packageName(r5).projectId(0).build();
        AIVoiceManager.INSTANCE.init(r6, aiVoiceServerConnectListener, null);
    }

    public final int createTtsTask(String r1) {
        Intrinsics.checkNotNullParameter(r1, "ttsConfig");
        return AIVoiceTask.INSTANCE.createTtsTask(r1);
    }

    public final int writeTtsText(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "taskId");
        Intrinsics.checkNotNullParameter(r2, "text");
        return AIVoiceTask.INSTANCE.writeTtsText(r1, r2);
    }

    public final int writeTtsEnd(String r1) {
        Intrinsics.checkNotNullParameter(r1, "taskId");
        return AIVoiceTask.INSTANCE.writeTtsEnd(r1);
    }

    public final int removeTtsTask(String r1) {
        Intrinsics.checkNotNullParameter(r1, "taskId");
        return AIVoiceTask.INSTANCE.removeTtsTask(r1);
    }
}
