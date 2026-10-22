package com.obric.voice;

import android.os.Looper;
import com.obric.aivoice.sdk.AIVoiceTask;
import com.obric.utils.GlobalUtils;
import com.obric.voice.bean.ASRResp;
import com.obric.voice.bean.TTSResp;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VoiceListenerManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u000e\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0018\u0019B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\nJ\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0011J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\nJ\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R2\u0010\b\u001a&\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n \u000b*\u0012\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n\u0018\u00010\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR2\u0010\u0010\u001a&\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00110\u0011 \u000b*\u0012\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00110\u0011\u0018\u00010\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/voice/VoiceListenerManager;", "", "()V", "MSG_ON_ASR_RESP", "", "MSG_ON_TTS_RESP", "TAG", "", "asrListener", "", "Lcom/obric/voice/VoiceListenerManager$ASRListener;", "kotlin.jvm.PlatformType", "", "handler", "com/obric/voice/VoiceListenerManager$handler$1", "Lcom/obric/voice/VoiceListenerManager$handler$1;", "ttsListener", "Lcom/obric/voice/VoiceListenerManager$TTSListener;", "addASRListener", "", "listener", "addTTSListener", "removeASRListener", "removeTTSListener", "ASRListener", "TTSListener", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VoiceListenerManager {
    public static final VoiceListenerManager INSTANCE = null;
    private static final int MSG_ON_ASR_RESP = 1;
    private static final int MSG_ON_TTS_RESP = 2;
    private static final String TAG = "VoiceListenerManager";
    private static final Set<ASRListener> asrListener = null;
    private static final VoiceListenerManager$handler$1 handler = null;
    private static final Set<TTSListener> ttsListener = null;

    /* JADX INFO: compiled from: VoiceListenerManager.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/obric/voice/VoiceListenerManager$ASRListener;", "", "onASRResponse", "", "taskId", "", "resp", "Lcom/obric/voice/bean/ASRResp;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ASRListener {
        void onASRResponse(String r1, ASRResp r2);
    }

    /* JADX INFO: compiled from: VoiceListenerManager.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/obric/voice/VoiceListenerManager$TTSListener;", "", "onTtsResponse", "", "taskId", "", "data", "", "resp", "Lcom/obric/voice/bean/TTSResp;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface TTSListener {
        void onTtsResponse(String r1, byte[] r2, TTSResp r3);
    }

    private VoiceListenerManager() {
    }

    public static final /* synthetic */ Set access$getAsrListener$p() {
        return asrListener;
    }

    public static final /* synthetic */ VoiceListenerManager$handler$1 access$getHandler$p() {
        return handler;
    }

    public static final /* synthetic */ Set access$getTtsListener$p() {
        return ttsListener;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.obric.voice.VoiceListenerManager$handler$1] */
    static {
        INSTANCE = new VoiceListenerManager();
        asrListener = Collections.newSetFromMap(new ConcurrentHashMap(4, 0.9f, 1));
        ttsListener = Collections.newSetFromMap(new ConcurrentHashMap(4, 0.9f, 1));
        final Looper r0 = GlobalUtils.INSTANCE.getEventDispatcherHandlerThread().getLooper();
        handler = new VoiceListenerManager$handler$1(r0);
        AIVoiceTask.INSTANCE.addAsrListener(new AnonymousClass1());
        AIVoiceTask.INSTANCE.addTtsListener(new AnonymousClass2());
    }

    public final void addASRListener(ASRListener r1) {
        Intrinsics.checkNotNullParameter(r1, "listener");
        asrListener.add(r1);
    }

    public final void removeASRListener(ASRListener r1) {
        Intrinsics.checkNotNullParameter(r1, "listener");
        asrListener.remove(r1);
    }

    public final void addTTSListener(TTSListener r1) {
        Intrinsics.checkNotNullParameter(r1, "listener");
        ttsListener.add(r1);
    }

    public final void removeTTSListener(TTSListener r1) {
        Intrinsics.checkNotNullParameter(r1, "listener");
        ttsListener.remove(r1);
    }
}
