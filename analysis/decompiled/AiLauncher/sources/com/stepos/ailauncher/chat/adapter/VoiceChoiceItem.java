package com.stepos.ailauncher.chat.adapter;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0015\u0010\u000bR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0016\u0010\u000bR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0017\u0010\u000bR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0018\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/r0;", "", "", "voiceId", "name", "description", "avatarUrl", "demoUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "e", Const.INTENT_KEY_UMID, "c", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.adapter.r0, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class VoiceChoiceItem {
    private final String avatarUrl;
    private final String demoUrl;
    private final String description;
    private final String name;
    private final String voiceId;

    public VoiceChoiceItem(String voiceId, String name, String str, String str2, String str3) {
        kotlin.jvm.internal.p.i(voiceId, "voiceId");
        kotlin.jvm.internal.p.i(name, "name");
        this.voiceId = voiceId;
        this.name = name;
        this.description = str;
        this.avatarUrl = str2;
        this.demoUrl = str3;
    }

    /* renamed from: a, reason: from getter */
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    /* renamed from: b, reason: from getter */
    public final String getDemoUrl() {
        return this.demoUrl;
    }

    /* renamed from: c, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: d, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: e, reason: from getter */
    public final String getVoiceId() {
        return this.voiceId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VoiceChoiceItem)) {
            return false;
        }
        VoiceChoiceItem voiceChoiceItem = (VoiceChoiceItem) other;
        return kotlin.jvm.internal.p.d(this.voiceId, voiceChoiceItem.voiceId) && kotlin.jvm.internal.p.d(this.name, voiceChoiceItem.name) && kotlin.jvm.internal.p.d(this.description, voiceChoiceItem.description) && kotlin.jvm.internal.p.d(this.avatarUrl, voiceChoiceItem.avatarUrl) && kotlin.jvm.internal.p.d(this.demoUrl, voiceChoiceItem.demoUrl);
    }

    public int hashCode() {
        int iHashCode = ((this.voiceId.hashCode() * 31) + this.name.hashCode()) * 31;
        String str = this.description;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.avatarUrl;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.demoUrl;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "VoiceChoiceItem(voiceId=" + this.voiceId + ", name=" + this.name + ", description=" + this.description + ", avatarUrl=" + this.avatarUrl + ", demoUrl=" + this.demoUrl + ")";
    }
}
