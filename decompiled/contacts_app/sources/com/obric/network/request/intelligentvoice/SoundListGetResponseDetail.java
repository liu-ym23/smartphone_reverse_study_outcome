package com.obric.network.request.intelligentvoice;

import com.android.contacts.obricsync.SyncContractKt;
import com.google.gson.annotations.SerializedName;
import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import com.obric.matrix.platform.sdk.ones.account.AccountInfoBundleKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IntelligentVoiceResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/obric/network/request/intelligentvoice/SoundListGetResponseDetail;", "", "speakerId", "", "name", AccountInfoBundleKey.AVATAR_URL, SyncContractKt.COLUMN_GENDER, "age", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAge", "()Ljava/lang/String;", "getAvatarUrl", "getGender", "getName", "getSpeakerId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SoundListGetResponseDetail {

    @SerializedName("age")
    private final String age;

    @SerializedName(AccountConst.KEY_AVATAR_URL)
    private final String avatarUrl;

    @SerializedName(SyncContractKt.COLUMN_GENDER)
    private final String gender;

    @SerializedName("name")
    private final String name;

    @SerializedName("speaker_id")
    private final String speakerId;

    public static /* synthetic */ SoundListGetResponseDetail copy$default(SoundListGetResponseDetail r3, String r4, String r5, String r6, String r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.speakerId;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.name;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.avatarUrl;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.gender;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.age;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.speakerId;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.avatarUrl;
    }

    public final String component4() {
        return this.gender;
    }

    public final String component5() {
        return this.age;
    }

    public final SoundListGetResponseDetail copy(String r7, String r8, String r9, String r10, String r11) {
        return new SoundListGetResponseDetail(r7, r8, r9, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SoundListGetResponseDetail) == true) goto L8;
        return false;
    L8:
        SoundListGetResponseDetail r6 = (SoundListGetResponseDetail) r5;
        if (Intrinsics.areEqual(this.speakerId, r6.speakerId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.avatarUrl, r6.avatarUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.gender, r6.gender) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.age, r6.age) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r0 = this.speakerId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.name;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.avatarUrl;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.gender;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.age;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "SoundListGetResponseDetail(speakerId=" + this.speakerId + ", name=" + this.name + ", avatarUrl=" + this.avatarUrl + ", gender=" + this.gender + ", age=" + this.age + ')';
    }

    public SoundListGetResponseDetail(String r1, String r2, String r3, String r4, String r5) {
        this.speakerId = r1;
        this.name = r2;
        this.avatarUrl = r3;
        this.gender = r4;
        this.age = r5;
    }

    public final String getSpeakerId() {
        return this.speakerId;
    }

    public final String getName() {
        return this.name;
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final String getGender() {
        return this.gender;
    }

    public final String getAge() {
        return this.age;
    }
}
