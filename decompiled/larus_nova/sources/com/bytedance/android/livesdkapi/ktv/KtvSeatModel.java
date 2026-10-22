package com.bytedance.android.livesdkapi.ktv;

import com.bytedance.android.live.liveinteract.multianchor.model.MicDress;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b3\u00104J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\t\u0010\t\u001a\u00020\u0002HÆ\u0003J\t\u0010\n\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010Jp\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00042\b\b\u0002\u0010\u0017\u001a\u00020\u00042\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u001c\u001a\u00020\u0002HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0004HÖ\u0001J\u0013\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0011\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\u0012\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b%\u0010&R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0013\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010\u0014\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b*\u0010#R\u0017\u0010\u0015\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010!\u001a\u0004\b+\u0010#R\u0017\u0010\u0016\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010$\u001a\u0004\b,\u0010&R\u0017\u0010\u0017\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0017\u0010$\u001a\u0004\b-\u0010&R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\u0018\u0010.\u001a\u0004\b/\u00100R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u0019\u00101\u001a\u0004\b2\u0010\u0010¨\u00065"}, d2 = {"Lcom/bytedance/android/livesdkapi/ktv/KtvSeatModel;", "", "", "component1", "", "component2", "Lpy/k;", "component3", "component4", "component5", "component6", "component7", "Lcom/bytedance/android/live/liveinteract/multianchor/model/MicDress;", "component8", "", "component9", "()Ljava/lang/Long;", "userId", "userPosition", "avatarMedium", "nickName", "interactIdStr", "gender", "silenceStatus", "micDress", "followStatus", "copy", "(Ljava/lang/String;ILpy/k;Ljava/lang/String;Ljava/lang/String;IILcom/bytedance/android/live/liveinteract/multianchor/model/MicDress;Ljava/lang/Long;)Lcom/bytedance/android/livesdkapi/ktv/KtvSeatModel;", "toString", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getUserId", "()Ljava/lang/String;", "I", "getUserPosition", "()I", "Lpy/k;", "getAvatarMedium", "()Lpy/k;", "getNickName", "getInteractIdStr", "getGender", "getSilenceStatus", "Lcom/bytedance/android/live/liveinteract/multianchor/model/MicDress;", "getMicDress", "()Lcom/bytedance/android/live/liveinteract/multianchor/model/MicDress;", "Ljava/lang/Long;", "getFollowStatus", "<init>", "(Ljava/lang/String;ILpy/k;Ljava/lang/String;Ljava/lang/String;IILcom/bytedance/android/live/liveinteract/multianchor/model/MicDress;Ljava/lang/Long;)V", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class KtvSeatModel {
    private final k avatarMedium;
    private final Long followStatus;
    private final int gender;
    private final String interactIdStr;
    private final MicDress micDress;
    private final String nickName;
    private final int silenceStatus;
    private final String userId;
    private final int userPosition;

    public static /* synthetic */ KtvSeatModel copy$default(KtvSeatModel r110, String r111, int r112, k r113, String r114, String r115, int r116, int r117, MicDress r118, Long r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        String r100 = r110.userId;
    L7:
        if ((r210 & 2) == 0) goto L9;
        int r101 = r110.userPosition;
    L11:
        if ((r210 & 4) == 0) goto L13;
        k r102 = r110.avatarMedium;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r103 = r110.nickName;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r104 = r110.interactIdStr;
    L23:
        if ((r210 & 32) == 0) goto L25;
        int r105 = r110.gender;
    L27:
        if ((r210 & 64) == 0) goto L29;
        int r106 = r110.silenceStatus;
    L31:
        if ((r210 & 128) == 0) goto L33;
        MicDress r107 = r110.micDress;
    L35:
        if ((r210 & 256) == 0) goto L37;
        Long r108 = r110.followStatus;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.userId;
    }

    public final int component2() {
        return this.userPosition;
    }

    public final k component3() {
        return this.avatarMedium;
    }

    public final String component4() {
        return this.nickName;
    }

    public final String component5() {
        return this.interactIdStr;
    }

    public final int component6() {
        return this.gender;
    }

    public final int component7() {
        return this.silenceStatus;
    }

    public final MicDress component8() {
        return this.micDress;
    }

    public final Long component9() {
        return this.followStatus;
    }

    public final KtvSeatModel copy(String r110, int r111, k r112, String r113, String r114, int r115, int r116, MicDress r117, Long r210) {
        Intrinsics.checkNotNullParameter(r110, "userId");
        Intrinsics.checkNotNullParameter(r113, "nickName");
        Intrinsics.checkNotNullParameter(r114, "interactIdStr");
        return new KtvSeatModel(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof KtvSeatModel) == false) goto L24;
        KtvSeatModel r101 = (KtvSeatModel) r100;
        if (Intrinsics.areEqual(this.userId, r101.userId) == true) goto L8;
        return false;
    L8:
        if (this.userPosition == r101.userPosition) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.avatarMedium, r101.avatarMedium) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.nickName, r101.nickName) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.interactIdStr, r101.interactIdStr) == true) goto L16;
        return false;
    L16:
        if (this.gender == r101.gender) goto L18;
        return false;
    L18:
        if (this.silenceStatus == r101.silenceStatus) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.micDress, r101.micDress) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.followStatus, r101.followStatus) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public int hashCode() {
        String r100 = this.userId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.userPosition) * 31;
        k r104 = this.avatarMedium;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.nickName;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.interactIdStr;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (((((r109 + r111) * 31) + this.gender) * 31) + this.silenceStatus) * 31;
        MicDress r113 = this.micDress;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Long r116 = this.followStatus;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "KtvSeatModel(userId=" + this.userId + ", userPosition=" + this.userPosition + ", avatarMedium=" + this.avatarMedium + ", nickName=" + this.nickName + ", interactIdStr=" + this.interactIdStr + ", gender=" + this.gender + ", silenceStatus=" + this.silenceStatus + ", micDress=" + this.micDress + ", followStatus=" + this.followStatus + ")";
    }

    public final k getAvatarMedium() {
        return this.avatarMedium;
    }

    public final Long getFollowStatus() {
        return this.followStatus;
    }

    public final int getGender() {
        return this.gender;
    }

    public final String getInteractIdStr() {
        return this.interactIdStr;
    }

    public final MicDress getMicDress() {
        return this.micDress;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final int getSilenceStatus() {
        return this.silenceStatus;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final int getUserPosition() {
        return this.userPosition;
    }

    public KtvSeatModel(String r100, int r101, k r102, String r103, String r104, int r105, int r106, MicDress r107, Long r110) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r103, "nickName");
        Intrinsics.checkNotNullParameter(r104, "interactIdStr");
        this.userId = r100;
        this.userPosition = r101;
        this.avatarMedium = r102;
        this.nickName = r103;
        this.interactIdStr = r104;
        this.gender = r105;
        this.silenceStatus = r106;
        this.micDress = r107;
        this.followStatus = r110;
    }

    public /* synthetic */ KtvSeatModel(String r110, int r111, k r112, String r113, String r114, int r115, int r116, MicDress r210, Long r211, int r212, DefaultConstructorMarker r213) {
        if ((r212 & 64) == 0) goto L5;
        int r100 = 0;
    L7:
        if ((r212 & 128) == 0) goto L9;
        MicDress r117 = null;
    L11:
        if ((r212 & 256) == 0) goto L13;
        Long r118 = null;
    L14:
        this(r110, r111, r112, r113, r114, r115, r100, r117, r118);
        return;
    L13:
        r118 = r211;
        goto L14
    L9:
        r117 = r210;
        goto L11
    L5:
        r100 = r116;
        goto L7
    }
}
