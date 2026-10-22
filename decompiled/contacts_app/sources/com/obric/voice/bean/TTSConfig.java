package com.obric.voice.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TTSConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 '2\u00020\u0001:\u0001'BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J[\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u000bHÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006("}, d2 = {"Lcom/obric/voice/bean/TTSConfig;", "", "taskId", "", "format", "sampleRate", "bits", "channel", "packageName", "speakerId", "ttsType", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getBits", "()Ljava/lang/String;", "getChannel", "getFormat", "getPackageName", "getSampleRate", "getSpeakerId", "setSpeakerId", "(Ljava/lang/String;)V", "getTaskId", "getTtsType", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TTSConfig {
    public static final Companion Companion = null;
    public static final int TTS_TYPE_AUTO = 0;
    public static final int TTS_TYPE_OFFLINE = 2;
    public static final int TTS_TYPE_ONLINE = 100;

    @SerializedName("bits")
    private final String bits;

    @SerializedName("channel")
    private final String channel;

    @SerializedName("format")
    private final String format;

    @SerializedName("packageName")
    private final String packageName;

    @SerializedName("samplRate")
    private final String sampleRate;

    @SerializedName("speakerId")
    private String speakerId;

    @SerializedName("taskId")
    private final String taskId;

    @SerializedName("ttsType")
    private final int ttsType;

    /* JADX INFO: compiled from: TTSConfig.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/voice/bean/TTSConfig$Companion;", "", "()V", "TTS_TYPE_AUTO", "", "TTS_TYPE_OFFLINE", "TTS_TYPE_ONLINE", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public TTSConfig() {
        this(null, null, null, null, null, null, null, 0, 255, null);
    }

    public static /* synthetic */ TTSConfig copy$default(TTSConfig r9, String r10, String r11, String r12, String r13, String r14, String r15, String r16, int r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r2 = r9.taskId;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r3 = r9.format;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r4 = r9.sampleRate;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r5 = r9.bits;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = r9.channel;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r7 = r9.packageName;
    L27:
        if ((r18 & 64) == 0) goto L29;
        String r8 = r9.speakerId;
    L31:
        if ((r18 & 128) == 0) goto L33;
        int r1 = r9.ttsType;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final String component1() {
        return this.taskId;
    }

    public final String component2() {
        return this.format;
    }

    public final String component3() {
        return this.sampleRate;
    }

    public final String component4() {
        return this.bits;
    }

    public final String component5() {
        return this.channel;
    }

    public final String component6() {
        return this.packageName;
    }

    public final String component7() {
        return this.speakerId;
    }

    public final int component8() {
        return this.ttsType;
    }

    public final TTSConfig copy(String r11, String r12, String r13, String r14, String r15, String r16, String r17, int r18) {
        Intrinsics.checkNotNullParameter(r11, "taskId");
        Intrinsics.checkNotNullParameter(r12, "format");
        Intrinsics.checkNotNullParameter(r13, "sampleRate");
        Intrinsics.checkNotNullParameter(r14, "bits");
        Intrinsics.checkNotNullParameter(r15, "channel");
        Intrinsics.checkNotNullParameter(r16, "packageName");
        return new TTSConfig(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TTSConfig) == true) goto L8;
        return false;
    L8:
        TTSConfig r6 = (TTSConfig) r5;
        if (Intrinsics.areEqual(this.taskId, r6.taskId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.format, r6.format) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.sampleRate, r6.sampleRate) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bits, r6.bits) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.channel, r6.channel) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.packageName, r6.packageName) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.speakerId, r6.speakerId) == true) goto L30;
        return false;
    L30:
        if (this.ttsType == r6.ttsType) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((((this.taskId.hashCode() * 31) + this.format.hashCode()) * 31) + this.sampleRate.hashCode()) * 31) + this.bits.hashCode()) * 31) + this.channel.hashCode()) * 31) + this.packageName.hashCode()) * 31;
        String r1 = this.speakerId;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + Integer.hashCode(this.ttsType);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "TTSConfig(taskId=" + this.taskId + ", format=" + this.format + ", sampleRate=" + this.sampleRate + ", bits=" + this.bits + ", channel=" + this.channel + ", packageName=" + this.packageName + ", speakerId=" + this.speakerId + ", ttsType=" + this.ttsType + ')';
    }

    public TTSConfig(String r2, String r3, String r4, String r5, String r6, String r7, String r8, int r9) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "format");
        Intrinsics.checkNotNullParameter(r4, "sampleRate");
        Intrinsics.checkNotNullParameter(r5, "bits");
        Intrinsics.checkNotNullParameter(r6, "channel");
        Intrinsics.checkNotNullParameter(r7, "packageName");
        this.taskId = r2;
        this.format = r3;
        this.sampleRate = r4;
        this.bits = r5;
        this.channel = r6;
        this.packageName = r7;
        this.speakerId = r8;
        this.ttsType = r9;
    }

    public /* synthetic */ TTSConfig(String r2, String r3, String r4, String r5, String r6, String r7, String r8, int r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r10 & 2) == 0) goto L9;
        r3 = "pcm";
    L9:
        if ((r10 & 4) == 0) goto L12;
        r4 = "24000";
    L12:
        if ((r10 & 8) == 0) goto L15;
        r5 = "16";
    L15:
        if ((r10 & 16) == 0) goto L18;
        r6 = "1";
    L18:
        if ((r10 & 32) == 0) goto L21;
        r7 = "";
    L21:
        if ((r10 & 64) == 0) goto L24;
        r8 = null;
    L24:
        if ((r10 & 128) == 0) goto L26;
        r9 = 100;
    L26:
        this(r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getFormat() {
        return this.format;
    }

    public final String getSampleRate() {
        return this.sampleRate;
    }

    public final String getBits() {
        return this.bits;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getSpeakerId() {
        return this.speakerId;
    }

    public final void setSpeakerId(String r1) {
        this.speakerId = r1;
    }

    public final int getTtsType() {
        return this.ttsType;
    }
}
