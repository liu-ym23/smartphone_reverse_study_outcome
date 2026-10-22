package com.obric.voice;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsApplication;
import com.google.gson.Gson;
import com.obric.settings.SettingsProviderHelper;
import com.obric.utils.GlobalUtils;
import com.obric.voice.bean.TTSConfig;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TTSManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f*\u0001\b\u0018\u0000 \"2\u00020\u0001:\u0003\"#$B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fJ\u001c\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00112\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0011H\u0002J\u000e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0011J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0011H\u0002J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u0011J\u0006\u0010\u001e\u001a\u00020\u0016J\u000e\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fJ\"\u0010 \u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00112\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR2\u0010\n\u001a&\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f \r*\u0012\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f\u0018\u00010\u000e0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/obric/voice/TTSManager;", "", "()V", "handler", "Landroid/os/Handler;", "handlerThread", "Landroid/os/HandlerThread;", "ttsListener", "com/obric/voice/TTSManager$ttsListener$1", "Lcom/obric/voice/TTSManager$ttsListener$1;", "ttsTaskListener", "", "Lcom/obric/voice/TTSManager$TTSTaskListener;", "kotlin.jvm.PlatformType", "", "ttsTaskMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "voiceCallAudioTracker", "Lcom/obric/voice/VoiceCallAudioTracker;", "addStatusChangeListener", "", "listener", "createTTSConfig", "taskId", "speakerId", "endSendTextTask", "getSpeakerId", "soundId", "onDestroy", "removeStatusChangeListener", "startSendTextTask", "text", "Companion", "TTSTask", "TTSTaskListener", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TTSManager {
    public static final Companion Companion = null;
    private static final int MSG_END_SEND_TEXT_TASK = 2;
    private static final int MSG_START_SEND_TEXT_TASK = 1;
    private static final String TAG = "TTSManager";
    private static final int WRITE_TTS_TEXT_RETRY_TIME = 3;
    private final Handler handler;
    private final HandlerThread handlerThread;
    private final TTSManager$ttsListener$1 ttsListener;
    private final Set<TTSTaskListener> ttsTaskListener;
    private final ConcurrentHashMap<String, Boolean> ttsTaskMap;
    private final VoiceCallAudioTracker voiceCallAudioTracker;

    /* JADX INFO: compiled from: TTSManager.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/voice/TTSManager$Companion;", "", "()V", "MSG_END_SEND_TEXT_TASK", "", "MSG_START_SEND_TEXT_TASK", "TAG", "", "WRITE_TTS_TEXT_RETRY_TIME", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: TTSManager.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J3\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/obric/voice/TTSManager$TTSTask;", "", "id", "", "text", "speakerId", "isStream", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "()Z", "setStream", "(Z)V", "getSpeakerId", "setSpeakerId", "getText", "setText", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class TTSTask {
        private String id;
        private boolean isStream;
        private String speakerId;
        private String text;

        public static /* synthetic */ TTSTask copy$default(TTSTask r0, String r1, String r2, String r3, boolean r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.id;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.text;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.speakerId;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.isStream;
        L15:
            return r0.copy(r1, r2, r3, r4);
        }

        public final String component1() {
            return this.id;
        }

        public final String component2() {
            return this.text;
        }

        public final String component3() {
            return this.speakerId;
        }

        public final boolean component4() {
            return this.isStream;
        }

        public final TTSTask copy(String r1, String r2, String r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r1, "id");
            Intrinsics.checkNotNullParameter(r2, "text");
            return new TTSTask(r1, r2, r3, r4);
        }

        public String toString() {
            return "TTSTask(id=" + this.id + ", text=" + this.text + ", speakerId=" + this.speakerId + ", isStream=" + this.isStream + ')';
        }

        public TTSTask(String r2, String r3, String r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r2, "id");
            Intrinsics.checkNotNullParameter(r3, "text");
            this.id = r2;
            this.text = r3;
            this.speakerId = r4;
            this.isStream = r5;
        }

        public /* synthetic */ TTSTask(String r1, String r2, String r3, boolean r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 2) == 0) goto L6;
            r2 = "";
        L6:
            if ((r5 & 4) == 0) goto L9;
            r3 = null;
        L9:
            if ((r5 & 8) == 0) goto L11;
            r4 = false;
        L11:
            this(r1, r2, r3, r4);
        }

        public final String getId() {
            return this.id;
        }

        public final String getSpeakerId() {
            return this.speakerId;
        }

        public final String getText() {
            return this.text;
        }

        public final boolean isStream() {
            return this.isStream;
        }

        public final void setId(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.id = r2;
        }

        public final void setSpeakerId(String r1) {
            this.speakerId = r1;
        }

        public final void setStream(boolean r1) {
            this.isStream = r1;
        }

        public final void setText(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.text = r2;
        }

        public boolean equals(Object r2) {
            if ((r2 instanceof TTSTask) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(this.id, ((TTSTask) r2).id);
        }

        public int hashCode() {
            int r0 = ((this.id.hashCode() * 31) + this.text.hashCode()) * 31;
            String r1 = this.speakerId;
            if (r1 == null) goto L5;
            int r2 = r1.hashCode();
        L7:
            return ((r0 + r2) * 31) + Boolean.hashCode(this.isStream);
        L5:
            r2 = 0;
            goto L7
        }
    }

    /* JADX INFO: compiled from: TTSManager.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/obric/voice/TTSManager$TTSTaskListener;", "", "onCreateTaskError", "", "taskId", "", "onWriteDataError", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface TTSTaskListener {
        void onCreateTaskError(String r1);

        void onWriteDataError(String r1);
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.obric.voice.TTSManager$ttsListener$1] */
    public TTSManager() {
        this.ttsTaskListener = Collections.newSetFromMap(new ConcurrentHashMap(4, 0.9f, 1));
        VoiceCallAudioTracker r0 = new VoiceCallAudioTracker();
        this.voiceCallAudioTracker = r0;
        HandlerThread r4 = new HandlerThread(TAG);
        this.handlerThread = r4;
        this.ttsTaskMap = new ConcurrentHashMap(4, 0.9f, 1);
        ?? r1 = new TTSManager$ttsListener$1(this);
        this.ttsListener = r1;
        r4.start();
        final Looper r2 = r4.getLooper();
        this.handler = new AnonymousClass1(this, r2);
        VoiceListenerManager.INSTANCE.addTTSListener((VoiceListenerManager.TTSListener) r1);
        r0.prepare();
    }

    public static final /* synthetic */ String access$createTTSConfig(TTSManager r0, String r1, String r2) {
        return r0.createTTSConfig(r1, r2);
    }

    public static final /* synthetic */ Set access$getTtsTaskListener$p(TTSManager r0) {
        return r0.ttsTaskListener;
    }

    public static final /* synthetic */ ConcurrentHashMap access$getTtsTaskMap$p(TTSManager r0) {
        return r0.ttsTaskMap;
    }

    public static final /* synthetic */ VoiceCallAudioTracker access$getVoiceCallAudioTracker$p(TTSManager r0) {
        return r0.voiceCallAudioTracker;
    }

    public final void addStatusChangeListener(TTSTaskListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.ttsTaskListener.add(r2);
    }

    public final void removeStatusChangeListener(TTSTaskListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.ttsTaskListener.remove(r2);
    }

    public final void onDestroy() {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "cleanUp");
        this.handlerThread.quitSafely();
        this.voiceCallAudioTracker.tearDown();
        VoiceListenerManager.INSTANCE.removeTTSListener(this.ttsListener);
        this.ttsTaskListener.clear();
        this.handler.removeCallbacksAndMessages(null);
    }

    private final String getSpeakerId() {
        SettingsProviderHelper r2 = SettingsProviderHelper.INSTANCE;
        ContactsApplication r0 = ContactsApplication.getInstance();
        Intrinsics.checkNotNullExpressionValue(r0, "getInstance()");
        String r3 = r2.getIntelligentVoiceCheckId(r0);
        if (Intrinsics.areEqual(r3, "defaultSound") == false) goto L6;
        return null;
    L6:
        return r3;
    }

    public final String getSpeakerId(String r1) {
        if (Intrinsics.areEqual(r1, "defaultSound") == false) goto L6;
        return null;
    L6:
        return r1;
    }

    static /* synthetic */ String createTTSConfig$default(TTSManager r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = r0.getSpeakerId();
    L6:
        return r0.createTTSConfig(r1, r2);
    }

    private final String createTTSConfig(String r13, String r14) {
        Gson r12 = GlobalUtils.INSTANCE.getGson();
        String r7 = ContactsApplication.getInstance().getPackageName();
        Intrinsics.checkNotNullExpressionValue(r7, "packageName");
        String r15 = r12.toJson(new TTSConfig(r13, null, null, null, null, r7, r14, 100, 30, null));
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "createTTSConfig: " + r15);
        Intrinsics.checkNotNullExpressionValue(r15, "GlobalUtils.gson.toJson(…TSConfig: $it\")\n        }");
        return r15;
    }

    public static /* synthetic */ void startSendTextTask$default(TTSManager r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = r0.getSpeakerId();
    L5:
        r0.startSendTextTask(r1, r2, r3);
    }

    public final void startSendTextTask(String r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r9, "taskId");
        Intrinsics.checkNotNullParameter(r10, "text");
        Handler r8 = this.handler;
        r8.sendMessage(r8.obtainMessage(1, new TTSTask(r9, r10, r11, false, 8, null)));
    }

    public final void endSendTextTask(String r10) {
        Intrinsics.checkNotNullParameter(r10, "taskId");
        String r3 = null;
        this.handler.removeMessages(1, new TTSTask(r10, r3, null, false, 14, null));
        Handler r9 = this.handler;
        r9.sendMessageAtFrontOfQueue(r9.obtainMessage(2, new TTSTask(r10, null, r3, false, 14, null)));
    }
}
