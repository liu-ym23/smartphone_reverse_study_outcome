package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.recommendAnonymous;

import com.bytedance.android.livesdkapi.depend.model.live.LabelInfo;
import com.bytedance.android.livesdkapi.depend.model.live.LiveRecommendSubmitExtra;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\b\u0086\b\u0018\u0000 /2\u00020\u0001:\u0001/Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\u0018\b\u0002\u0010\u0011\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0002\u0010\u0013J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\u0015\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bHÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\n0\fHÆ\u0003J\t\u0010'\u001a\u00020\u000eHÆ\u0003J\t\u0010(\u001a\u00020\u0010HÆ\u0003J\u0019\u0010)\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\n\u0018\u00010\bHÆ\u0003J{\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0018\b\u0002\u0010\u0011\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\n\u0018\u00010\bHÆ\u0001J\u0013\u0010+\u001a\u00020\u00102\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u000eHÖ\u0001J\t\u0010.\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR!\u0010\u0011\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00060"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/recommendAnonymous/LiveRecommendRequestParams;", "", "roomId", "", "anchorId", "", "requestTag", "onSuccess", "Lkotlin/Function1;", "Lcom/bytedance/android/livesdkapi/depend/model/live/LabelInfo;", "", "onFail", "Lkotlin/Function0;", "recommendUserLocation", "", "banRecommendMsg", "", "onSuccessInsertRoom", "Lcom/bytedance/android/livesdkapi/depend/model/live/LiveRecommendSubmitExtra;", "(JLjava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;IZLkotlin/jvm/functions/Function1;)V", "getAnchorId", "()Ljava/lang/String;", "getBanRecommendMsg", "()Z", "getOnFail", "()Lkotlin/jvm/functions/Function0;", "getOnSuccess", "()Lkotlin/jvm/functions/Function1;", "getOnSuccessInsertRoom", "getRecommendUserLocation", "()I", "getRequestTag", "getRoomId", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "Companion", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveRecommendRequestParams {
    public static final Companion Companion = null;
    public static final int LOCATION_IN_ROOM_HOMEPAGE_HOT = 2;
    public static final int LOCATION_OTHER = 0;
    public static final int LOCATION_PREVIEW = 1;
    private final String anchorId;
    private final boolean banRecommendMsg;
    private final Function0<Unit> onFail;
    private final Function1<LabelInfo, Unit> onSuccess;
    private final Function1<LiveRecommendSubmitExtra, Unit> onSuccessInsertRoom;
    private final int recommendUserLocation;
    private final String requestTag;
    private final long roomId;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/recommendAnonymous/LiveRecommendRequestParams$Companion;", "", "()V", "LOCATION_IN_ROOM_HOMEPAGE_HOT", "", "LOCATION_OTHER", "LOCATION_PREVIEW", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LiveRecommendRequestParams copy$default(LiveRecommendRequestParams r110, long r111, String r112, String r113, Function1 r114, Function0 r115, int r116, boolean r117, Function1 r118, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        long r100 = r110.roomId;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = r110.anchorId;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r102 = r110.requestTag;
    L15:
        if ((r210 & 8) == 0) goto L17;
        Function1 r103 = r110.onSuccess;
    L19:
        if ((r210 & 16) == 0) goto L21;
        Function0 r104 = r110.onFail;
    L23:
        if ((r210 & 32) == 0) goto L25;
        int r105 = r110.recommendUserLocation;
    L27:
        if ((r210 & 64) == 0) goto L29;
        boolean r106 = r110.banRecommendMsg;
    L31:
        if ((r210 & 128) == 0) goto L33;
        Function1 r107 = r110.onSuccessInsertRoom;
    L35:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107);
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

    public final long component1() {
        return this.roomId;
    }

    public final String component2() {
        return this.anchorId;
    }

    public final String component3() {
        return this.requestTag;
    }

    public final Function1<LabelInfo, Unit> component4() {
        return this.onSuccess;
    }

    public final Function0<Unit> component5() {
        return this.onFail;
    }

    public final int component6() {
        return this.recommendUserLocation;
    }

    public final boolean component7() {
        return this.banRecommendMsg;
    }

    public final Function1<LiveRecommendSubmitExtra, Unit> component8() {
        return this.onSuccessInsertRoom;
    }

    public final LiveRecommendRequestParams copy(long r110, String r111, String r112, Function1<? super LabelInfo, Unit> r113, Function0<Unit> r114, int r115, boolean r116, Function1<? super LiveRecommendSubmitExtra, Unit> r210) {
        Intrinsics.checkNotNullParameter(r111, "anchorId");
        Intrinsics.checkNotNullParameter(r112, "requestTag");
        Intrinsics.checkNotNullParameter(r113, "onSuccess");
        Intrinsics.checkNotNullParameter(r114, "onFail");
        return new LiveRecommendRequestParams(r110, r111, r112, r113, r114, r115, r116, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LiveRecommendRequestParams) == false) goto L22;
        LiveRecommendRequestParams r101 = (LiveRecommendRequestParams) r100;
        if (this.roomId == r101.roomId) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.anchorId, r101.anchorId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.requestTag, r101.requestTag) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.onSuccess, r101.onSuccess) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.onFail, r101.onFail) == true) goto L16;
        return false;
    L16:
        if (this.recommendUserLocation == r101.recommendUserLocation) goto L18;
        return false;
    L18:
        if (this.banRecommendMsg == r101.banRecommendMsg) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.onSuccessInsertRoom, r101.onSuccessInsertRoom) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    public int hashCode() {
        long r100 = this.roomId;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.anchorId;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.requestTag;
        if (r106 == null) goto L9;
        int r107 = r106.hashCode();
    L10:
        int r108 = (r105 + r107) * 31;
        Function1<LabelInfo, Unit> r109 = this.onSuccess;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (r108 + r110) * 31;
        Function0<Unit> r112 = this.onFail;
        if (r112 == null) goto L17;
        int r113 = r112.hashCode();
    L18:
        int r114 = (((r111 + r113) * 31) + this.recommendUserLocation) * 31;
        boolean r115 = this.banRecommendMsg;
        ?? r116 = r115;
        if (r115 == false) goto L21;
        r116 = 1;
    L21:
        int r117 = (r114 + r116) * 31;
        Function1<LiveRecommendSubmitExtra, Unit> r118 = this.onSuccessInsertRoom;
        if (r118 == null) goto L25;
        r103 = r118.hashCode();
    L25:
        return r117 + r103;
    L17:
        r113 = 0;
        goto L18
    L13:
        r110 = 0;
        goto L14
    L9:
        r107 = 0;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    public String toString() {
        return "LiveRecommendRequestParams(roomId=" + this.roomId + ", anchorId=" + this.anchorId + ", requestTag=" + this.requestTag + ", onSuccess=" + this.onSuccess + ", onFail=" + this.onFail + ", recommendUserLocation=" + this.recommendUserLocation + ", banRecommendMsg=" + this.banRecommendMsg + ", onSuccessInsertRoom=" + this.onSuccessInsertRoom + ")";
    }

    public final String getAnchorId() {
        return this.anchorId;
    }

    public final boolean getBanRecommendMsg() {
        return this.banRecommendMsg;
    }

    public final Function0<Unit> getOnFail() {
        return this.onFail;
    }

    public final Function1<LabelInfo, Unit> getOnSuccess() {
        return this.onSuccess;
    }

    public final Function1<LiveRecommendSubmitExtra, Unit> getOnSuccessInsertRoom() {
        return this.onSuccessInsertRoom;
    }

    public final int getRecommendUserLocation() {
        return this.recommendUserLocation;
    }

    public final String getRequestTag() {
        return this.requestTag;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LiveRecommendRequestParams(long r100, String r101, String r102, Function1<? super LabelInfo, Unit> r103, Function0<Unit> r104, int r105, boolean r106, Function1<? super LiveRecommendSubmitExtra, Unit> r110) {
        Intrinsics.checkNotNullParameter(r101, "anchorId");
        Intrinsics.checkNotNullParameter(r102, "requestTag");
        Intrinsics.checkNotNullParameter(r103, "onSuccess");
        Intrinsics.checkNotNullParameter(r104, "onFail");
        this.roomId = r100;
        this.anchorId = r101;
        this.requestTag = r102;
        this.onSuccess = r103;
        this.onFail = r104;
        this.recommendUserLocation = r105;
        this.banRecommendMsg = r106;
        this.onSuccessInsertRoom = r110;
    }

    public /* synthetic */ LiveRecommendRequestParams(long r110, String r111, String r112, Function1 r113, Function0 r114, int r115, boolean r210, Function1 r211, int r212, DefaultConstructorMarker r213) {
        if ((r212 & 64) == 0) goto L5;
        boolean r116 = false;
    L7:
        if ((r212 & 128) == 0) goto L9;
        Function1 r117 = null;
    L10:
        this(r110, r111, r112, r113, r114, r115, r116, r117);
        return;
    L9:
        r117 = r211;
        goto L10
    L5:
        r116 = r210;
        goto L7
    }
}
