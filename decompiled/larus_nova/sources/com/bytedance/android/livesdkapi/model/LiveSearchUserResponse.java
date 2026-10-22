package com.bytedance.android.livesdkapi.model;

import com.bytedance.android.live.base.model.user.User;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u0001BW\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J\t\u0010!\u001a\u00020\rHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003JY\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010$\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LiveSearchUserResponse;", "", "statueCode", "", "statueMsg", "", "type", "userList", "", "Lcom/bytedance/android/live/base/model/user/User;", EffectConfiguration.KEY_CURSOR, "", "hasMore", "", "inputKeyword", "(ILjava/lang/String;ILjava/util/List;JZLjava/lang/String;)V", "getCursor", "()J", "getHasMore", "()Z", "getInputKeyword", "()Ljava/lang/String;", "getStatueCode", "()I", "getStatueMsg", "getType", "getUserList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSearchUserResponse {

    @SerializedName(EffectConfiguration.KEY_CURSOR)
    private final long cursor;

    @SerializedName("has_more")
    private final boolean hasMore;

    @SerializedName("input_keyword")
    private final String inputKeyword;

    @SerializedName("status_code")
    private final int statueCode;

    @SerializedName("status_msg")
    private final String statueMsg;

    @SerializedName("type")
    private final int type;

    @SerializedName("user_list")
    private final List<User> userList;

    public LiveSearchUserResponse() {
        this(0, null, 0, null, 0, false, null, 127, null);
    }

    public LiveSearchUserResponse(int r110) {
        this(r110, null, 0, null, 0, false, null, 126, null);
    }

    public LiveSearchUserResponse(int r110, String r111) {
        this(r110, r111, 0, null, 0, false, null, 124, null);
    }

    public LiveSearchUserResponse(int r110, String r111, int r112) {
        this(r110, r111, r112, null, 0, false, null, 120, null);
    }

    public LiveSearchUserResponse(int r110, String r111, int r112, List<? extends User> r113) {
        this(r110, r111, r112, r113, 0, false, null, 112, null);
    }

    public LiveSearchUserResponse(int r110, String r111, int r112, List<? extends User> r113, long r114) {
        this(r110, r111, r112, r113, r114, false, null, 96, null);
    }

    public LiveSearchUserResponse(int r110, String r111, int r112, List<? extends User> r113, long r114, boolean r115) {
        this(r110, r111, r112, r113, r114, r115, null, 64, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LiveSearchUserResponse copy$default(LiveSearchUserResponse r100, int r110, String r111, int r112, List r113, long r114, boolean r115, String r116, int r117, Object r118) {
        if ((r117 & 1) == 0) goto L5;
        int r101 = r100.statueCode;
    L7:
        if ((r117 & 2) == 0) goto L9;
        String r102 = r100.statueMsg;
    L11:
        if ((r117 & 4) == 0) goto L13;
        int r103 = r100.type;
    L15:
        if ((r117 & 8) == 0) goto L17;
        List r104 = r100.userList;
    L19:
        if ((r117 & 16) == 0) goto L21;
        long r105 = r100.cursor;
    L23:
        if ((r117 & 32) == 0) goto L25;
        boolean r106 = r100.hasMore;
    L27:
        if ((r117 & 64) == 0) goto L29;
        String r107 = r100.inputKeyword;
    L31:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107);
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final int component1() {
        return this.statueCode;
    }

    public final String component2() {
        return this.statueMsg;
    }

    public final int component3() {
        return this.type;
    }

    public final List<User> component4() {
        return this.userList;
    }

    public final long component5() {
        return this.cursor;
    }

    public final boolean component6() {
        return this.hasMore;
    }

    public final String component7() {
        return this.inputKeyword;
    }

    public final LiveSearchUserResponse copy(int r110, String r111, int r112, List<? extends User> r113, long r114, boolean r115, String r116) {
        Intrinsics.checkNotNullParameter(r111, "statueMsg");
        return new LiveSearchUserResponse(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LiveSearchUserResponse) == false) goto L20;
        LiveSearchUserResponse r101 = (LiveSearchUserResponse) r100;
        if (this.statueCode == r101.statueCode) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.statueMsg, r101.statueMsg) == true) goto L10;
        return false;
    L10:
        if (this.type == r101.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.userList, r101.userList) == true) goto L14;
        return false;
    L14:
        if (this.cursor == r101.cursor) goto L16;
        return false;
    L16:
        if (this.hasMore == r101.hasMore) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.inputKeyword, r101.inputKeyword) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v15 */
    public int hashCode() {
        int r100 = this.statueCode * 31;
        String r101 = this.statueMsg;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (((r100 + r103) * 31) + this.type) * 31;
        List<User> r105 = this.userList;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        long r107 = this.cursor;
        int r108 = (((r104 + r106) * 31) + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        boolean r109 = this.hasMore;
        ?? r110 = r109;
        if (r109 == false) goto L13;
        r110 = 1;
    L13:
        int r111 = (r108 + r110) * 31;
        String r112 = this.inputKeyword;
        if (r112 == null) goto L17;
        r102 = r112.hashCode();
    L17:
        return r111 + r102;
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public String toString() {
        return "LiveSearchUserResponse(statueCode=" + this.statueCode + ", statueMsg=" + this.statueMsg + ", type=" + this.type + ", userList=" + this.userList + ", cursor=" + this.cursor + ", hasMore=" + this.hasMore + ", inputKeyword=" + this.inputKeyword + ")";
    }

    public final long getCursor() {
        return this.cursor;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final String getInputKeyword() {
        return this.inputKeyword;
    }

    public final int getStatueCode() {
        return this.statueCode;
    }

    public final String getStatueMsg() {
        return this.statueMsg;
    }

    public final int getType() {
        return this.type;
    }

    public final List<User> getUserList() {
        return this.userList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LiveSearchUserResponse(int r100, String r101, int r102, List<? extends User> r103, long r104, boolean r105, String r106) {
        Intrinsics.checkNotNullParameter(r101, "statueMsg");
        this.statueCode = r100;
        this.statueMsg = r101;
        this.type = r102;
        this.userList = r103;
        this.cursor = r104;
        this.hasMore = r105;
        this.inputKeyword = r106;
    }

    public /* synthetic */ LiveSearchUserResponse(int r110, String r111, int r112, List r113, long r114, boolean r115, String r116, int r117, DefaultConstructorMarker r118) {
        boolean r100 = false;
        if ((r117 & 1) == 0) goto L5;
        int r101 = 0;
    L6:
        String r102 = "";
        if ((r117 & 2) == 0) goto L9;
        String r103 = "";
    L11:
        if ((r117 & 4) == 0) goto L13;
        int r104 = 1;
    L15:
        if ((r117 & 8) == 0) goto L17;
        List r105 = null;
    L19:
        if ((r117 & 16) == 0) goto L21;
        long r106 = 0;
    L23:
        if ((r117 & 32) != 0) goto L27;
        r100 = r115;
    L27:
        if ((r117 & 64) != 0) goto L30;
        r102 = r116;
    L30:
        this(r101, r103, r104, r105, r106, r100, r102);
        return;
    L21:
        r106 = r114;
        goto L23
    L17:
        r105 = r113;
        goto L19
    L13:
        r104 = r112;
        goto L15
    L9:
        r103 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L6
    }
}
