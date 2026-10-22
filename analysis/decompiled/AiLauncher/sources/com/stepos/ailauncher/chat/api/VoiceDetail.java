package com.stepos.ailauncher.chat.api;

import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/chat/api/VoiceDetail;", "", "imgUrl", "", "voiceDemoUrl", "voiceName", "voiceDescription", "recommendedScene", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getImgUrl", "()Ljava/lang/String;", "getVoiceDemoUrl", "getVoiceName", "getVoiceDescription", "getRecommendedScene", "component1", "component2", "component3", "component4", "component5", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class VoiceDetail {
    private final String imgUrl;

    @SerializedName("recommended_scene")
    private final String recommendedScene;

    @SerializedName("voiceDemoUrl")
    private final String voiceDemoUrl;

    @SerializedName("voice-description")
    private final String voiceDescription;

    @SerializedName("voice-name")
    private final String voiceName;

    public VoiceDetail() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ VoiceDetail copy$default(VoiceDetail voiceDetail, String str, String str2, String str3, String str4, String str5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = voiceDetail.imgUrl;
        }
        if ((i10 & 2) != 0) {
            str2 = voiceDetail.voiceDemoUrl;
        }
        if ((i10 & 4) != 0) {
            str3 = voiceDetail.voiceName;
        }
        if ((i10 & 8) != 0) {
            str4 = voiceDetail.voiceDescription;
        }
        if ((i10 & 16) != 0) {
            str5 = voiceDetail.recommendedScene;
        }
        String str6 = str5;
        String str7 = str3;
        return voiceDetail.copy(str, str2, str7, str4, str6);
    }

    /* renamed from: component1, reason: from getter */
    public final String getImgUrl() {
        return this.imgUrl;
    }

    /* renamed from: component2, reason: from getter */
    public final String getVoiceDemoUrl() {
        return this.voiceDemoUrl;
    }

    /* renamed from: component3, reason: from getter */
    public final String getVoiceName() {
        return this.voiceName;
    }

    /* renamed from: component4, reason: from getter */
    public final String getVoiceDescription() {
        return this.voiceDescription;
    }

    /* renamed from: component5, reason: from getter */
    public final String getRecommendedScene() {
        return this.recommendedScene;
    }

    public final VoiceDetail copy(String imgUrl, String voiceDemoUrl, String voiceName, String voiceDescription, String recommendedScene) {
        return new VoiceDetail(imgUrl, voiceDemoUrl, voiceName, voiceDescription, recommendedScene);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VoiceDetail)) {
            return false;
        }
        VoiceDetail voiceDetail = (VoiceDetail) other;
        return p.d(this.imgUrl, voiceDetail.imgUrl) && p.d(this.voiceDemoUrl, voiceDetail.voiceDemoUrl) && p.d(this.voiceName, voiceDetail.voiceName) && p.d(this.voiceDescription, voiceDetail.voiceDescription) && p.d(this.recommendedScene, voiceDetail.recommendedScene);
    }

    public final String getImgUrl() {
        return this.imgUrl;
    }

    public final String getRecommendedScene() {
        return this.recommendedScene;
    }

    public final String getVoiceDemoUrl() {
        return this.voiceDemoUrl;
    }

    public final String getVoiceDescription() {
        return this.voiceDescription;
    }

    public final String getVoiceName() {
        return this.voiceName;
    }

    public int hashCode() {
        String str = this.imgUrl;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.voiceDemoUrl;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.voiceName;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.voiceDescription;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.recommendedScene;
        return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "VoiceDetail(imgUrl=" + this.imgUrl + ", voiceDemoUrl=" + this.voiceDemoUrl + ", voiceName=" + this.voiceName + ", voiceDescription=" + this.voiceDescription + ", recommendedScene=" + this.recommendedScene + ")";
    }

    public VoiceDetail(String str, String str2, String str3, String str4, String str5) {
        this.imgUrl = str;
        this.voiceDemoUrl = str2;
        this.voiceName = str3;
        this.voiceDescription = str4;
        this.recommendedScene = str5;
    }

    public /* synthetic */ VoiceDetail(String str, String str2, String str3, String str4, String str5, int i10, i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? null : str5);
    }
}
