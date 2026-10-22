package com.obric.network.request.intelligentvoice;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IntelligentVoiceResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/obric/network/request/intelligentvoice/SoundCopyRequestBody;", "", "fileUrl", "", "soundName", "speakerId", "promptText", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFileUrl", "()Ljava/lang/String;", "getPromptText", "getSoundName", "getSpeakerId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SoundCopyRequestBody {

    @SerializedName("file_url")
    private final String fileUrl;

    @SerializedName("prompt_text")
    private final String promptText;

    @SerializedName("sound_name")
    private final String soundName;

    @SerializedName("speaker_id")
    private final String speakerId;

    public static /* synthetic */ SoundCopyRequestBody copy$default(SoundCopyRequestBody r0, String r1, String r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.fileUrl;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.soundName;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.speakerId;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.promptText;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.fileUrl;
    }

    public final String component2() {
        return this.soundName;
    }

    public final String component3() {
        return this.speakerId;
    }

    public final String component4() {
        return this.promptText;
    }

    public final SoundCopyRequestBody copy(String r1, String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "soundName");
        return new SoundCopyRequestBody(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SoundCopyRequestBody) == true) goto L8;
        return false;
    L8:
        SoundCopyRequestBody r6 = (SoundCopyRequestBody) r5;
        if (Intrinsics.areEqual(this.fileUrl, r6.fileUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.soundName, r6.soundName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.speakerId, r6.speakerId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.promptText, r6.promptText) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.fileUrl;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.soundName.hashCode()) * 31;
        String r4 = this.speakerId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.promptText;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "SoundCopyRequestBody(fileUrl=" + this.fileUrl + ", soundName=" + this.soundName + ", speakerId=" + this.speakerId + ", promptText=" + this.promptText + ')';
    }

    public SoundCopyRequestBody(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "soundName");
        this.fileUrl = r2;
        this.soundName = r3;
        this.speakerId = r4;
        this.promptText = r5;
    }

    public /* synthetic */ SoundCopyRequestBody(String r1, String r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = null;
    L5:
        this(r1, r2, r3, r4);
    }

    public final String getFileUrl() {
        return this.fileUrl;
    }

    public final String getSoundName() {
        return this.soundName;
    }

    public final String getSpeakerId() {
        return this.speakerId;
    }

    public final String getPromptText() {
        return this.promptText;
    }
}
