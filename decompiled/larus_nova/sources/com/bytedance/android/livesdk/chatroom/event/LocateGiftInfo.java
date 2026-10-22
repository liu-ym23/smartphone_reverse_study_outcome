package com.bytedance.android.livesdk.chatroom.event;

import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b<\b\u0087\b\u0018\u0000 D2\u00020\u0001:\u0001EB\u0089\u0001\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\n\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\n\u0012\b\b\u0002\u0010\u001b\u001a\u00020\n\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0007\u0012\b\b\u0002\u0010 \u001a\u00020\u0005¢\u0006\u0004\b?\u0010@Bc\b\u0016\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\n\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0007¢\u0006\u0004\b?\u0010ABE\b\u0016\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\n\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003¢\u0006\u0004\b?\u0010BB9\b\u0016\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\n\u0012\u0006\u0010 \u001a\u00020\u0005¢\u0006\u0004\b?\u0010CJ\u0006\u0010\u0002\u001a\u00020\u0000J\t\u0010\u0004\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0005HÆ\u0003J\t\u0010\b\u001a\u00020\u0007HÆ\u0003J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\nHÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\nHÆ\u0003J\t\u0010\u000e\u001a\u00020\nHÆ\u0003J\t\u0010\u000f\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u008b\u0001\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\n2\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\n2\b\b\u0002\u0010\u001b\u001a\u00020\n2\b\b\u0002\u0010\u001c\u001a\u00020\u00072\b\b\u0002\u0010\u001d\u001a\u00020\u00072\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u0005HÆ\u0001J\t\u0010\"\u001a\u00020\u0007HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\u0013\u0010%\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0014\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0014\u0010&\u001a\u0004\b'\u0010(R\"\u0010\u0015\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0017\u0010\u0016\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0016\u0010.\u001a\u0004\b/\u00100R\u0017\u0010\u0017\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0017\u0010&\u001a\u0004\b1\u0010(R\u0017\u0010\u0018\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0018\u00102\u001a\u0004\b3\u00104R\u0017\u0010\u0019\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0019\u0010&\u001a\u0004\b5\u0010(R\u0017\u0010\u001a\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u001a\u00102\u001a\u0004\b6\u00104R\u0017\u0010\u001b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u001b\u00102\u001a\u0004\b\u001b\u00104R\"\u0010\u001c\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010.\u001a\u0004\b7\u00100\"\u0004\b8\u00109R\u0017\u0010\u001d\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u001d\u0010.\u001a\u0004\b:\u00100R\u0017\u0010\u001e\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u001e\u0010&\u001a\u0004\b;\u0010(R\u0017\u0010\u001f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u001f\u0010.\u001a\u0004\b<\u00100R\"\u0010 \u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010)\u001a\u0004\b=\u0010+\"\u0004\b>\u0010-¨\u0006F"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/event/LocateGiftInfo;", "", "setLocateSecond", "", "component1", "", "component2", "", "component3", "component4", "", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "targetPageType", "targetGiftId", "tipsWhenNotExist", "actionWhenNotExist", "needAnimWhenLocated", "buffLevel", "stayWithCurrentPosition", "isSecondLocate", "cardName", "jumpSchema", "targetCounterPosition", "refId", "targetPropDefId", "copy", "toString", "hashCode", "other", "equals", "I", "getTargetPageType", "()I", "J", "getTargetGiftId", "()J", "setTargetGiftId", "(J)V", "Ljava/lang/String;", "getTipsWhenNotExist", "()Ljava/lang/String;", "getActionWhenNotExist", "Z", "getNeedAnimWhenLocated", "()Z", "getBuffLevel", "getStayWithCurrentPosition", "getCardName", "setCardName", "(Ljava/lang/String;)V", "getJumpSchema", "getTargetCounterPosition", "getRefId", "getTargetPropDefId", "setTargetPropDefId", "<init>", "(IJLjava/lang/String;IZIZZLjava/lang/String;Ljava/lang/String;ILjava/lang/String;J)V", "(IJLjava/lang/String;IZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(IJLjava/lang/String;IZI)V", "(ILjava/lang/String;IZJ)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LocateGiftInfo {
    public static final int ACTION_CHANGE_TAB_TO_GIFT = 3;
    public static final int ACTION_NOTHING = 0;
    public static final int ACTION_SELECT_DEFAULT_0 = 2;
    public static final int ACTION_TIPS = 1;
    public static final a Companion = null;
    private final int actionWhenNotExist;
    private final int buffLevel;
    private String cardName;
    private final boolean isSecondLocate;
    private final String jumpSchema;
    private final boolean needAnimWhenLocated;
    private final String refId;
    private final boolean stayWithCurrentPosition;
    private final int targetCounterPosition;
    private long targetGiftId;
    private final int targetPageType;
    private long targetPropDefId;
    private final String tipsWhenNotExist;

    public static final class a {
        @JvmStatic
        public static LocateGiftInfo a() {
            return new LocateGiftInfo(0, -1, "寻找礼物失败啦～重新打开礼物栏试试", 2, true, 0, 32, null);
        }

        public a() {
        }

        @JvmStatic
        public static LocateGiftInfo b(int r110) {
            return new LocateGiftInfo(r110, -1, "寻找礼物失败啦～重新打开礼物栏试试", 2, true, 0, 32, null);
        }
    }

    static {
        Companion = new a();
    }

    public LocateGiftInfo() {
        this(0, 0, null, 0, false, 0, false, false, null, null, 0, null, 0, 8191, null);
    }

    public static /* synthetic */ LocateGiftInfo copy$default(LocateGiftInfo r110, int r111, long r112, String r210, int r211, boolean r212, int r213, boolean r214, boolean r215, String r216, String r217, int r218, String r219, long r310, int r311, Object r312) {
        if ((r311 & 1) == 0) goto L5;
        int r100 = r110.targetPageType;
    L7:
        if ((r311 & 2) == 0) goto L9;
        long r101 = r110.targetGiftId;
    L11:
        if ((r311 & 4) == 0) goto L13;
        String r102 = r110.tipsWhenNotExist;
    L15:
        if ((r311 & 8) == 0) goto L17;
        int r103 = r110.actionWhenNotExist;
    L19:
        if ((r311 & 16) == 0) goto L21;
        boolean r104 = r110.needAnimWhenLocated;
    L23:
        if ((r311 & 32) == 0) goto L25;
        int r105 = r110.buffLevel;
    L27:
        if ((r311 & 64) == 0) goto L29;
        boolean r106 = r110.stayWithCurrentPosition;
    L31:
        if ((r311 & 128) == 0) goto L33;
        boolean r113 = r110.isSecondLocate;
    L35:
        if ((r311 & 256) == 0) goto L37;
        String r114 = r110.cardName;
    L39:
        if ((r311 & 512) == 0) goto L41;
        String r115 = r110.jumpSchema;
    L43:
        if ((r311 & 1024) == 0) goto L45;
        int r116 = r110.targetCounterPosition;
    L47:
        if ((r311 & 2048) == 0) goto L49;
        String r117 = r110.refId;
    L50:
        String r220 = r117;
        if ((r311 & 4096) == 0) goto L53;
        long r118 = r110.targetPropDefId;
    L55:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r113, r114, r115, r116, r220, r118);
    L53:
        r118 = r310;
        goto L55
    L49:
        r117 = r219;
        goto L50
    L45:
        r116 = r218;
        goto L47
    L41:
        r115 = r217;
        goto L43
    L37:
        r114 = r216;
        goto L39
    L33:
        r113 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    @JvmStatic
    public static final LocateGiftInfo getDefault() {
        Companion.getClass();
        return a.a();
    }

    @JvmStatic
    public static final LocateGiftInfo getDefault(int r100) {
        Companion.getClass();
        return a.b(r100);
    }

    public final int component1() {
        return this.targetPageType;
    }

    public final String component10() {
        return this.jumpSchema;
    }

    public final int component11() {
        return this.targetCounterPosition;
    }

    public final String component12() {
        return this.refId;
    }

    public final long component13() {
        return this.targetPropDefId;
    }

    public final long component2() {
        return this.targetGiftId;
    }

    public final String component3() {
        return this.tipsWhenNotExist;
    }

    public final int component4() {
        return this.actionWhenNotExist;
    }

    public final boolean component5() {
        return this.needAnimWhenLocated;
    }

    public final int component6() {
        return this.buffLevel;
    }

    public final boolean component7() {
        return this.stayWithCurrentPosition;
    }

    public final boolean component8() {
        return this.isSecondLocate;
    }

    public final String component9() {
        return this.cardName;
    }

    public final LocateGiftInfo copy(int r110, long r111, String r210, int r211, boolean r212, int r213, boolean r214, boolean r215, String r216, String r217, int r218, String r310, long r311) {
        Intrinsics.checkNotNullParameter(r210, "tipsWhenNotExist");
        Intrinsics.checkNotNullParameter(r216, "cardName");
        Intrinsics.checkNotNullParameter(r217, "jumpSchema");
        Intrinsics.checkNotNullParameter(r310, "refId");
        return new LocateGiftInfo(r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, r311);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LocateGiftInfo) == false) goto L32;
        LocateGiftInfo r101 = (LocateGiftInfo) r100;
        if (this.targetPageType == r101.targetPageType) goto L8;
        return false;
    L8:
        if (this.targetGiftId == r101.targetGiftId) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.tipsWhenNotExist, r101.tipsWhenNotExist) == true) goto L12;
        return false;
    L12:
        if (this.actionWhenNotExist == r101.actionWhenNotExist) goto L14;
        return false;
    L14:
        if (this.needAnimWhenLocated == r101.needAnimWhenLocated) goto L16;
        return false;
    L16:
        if (this.buffLevel == r101.buffLevel) goto L18;
        return false;
    L18:
        if (this.stayWithCurrentPosition == r101.stayWithCurrentPosition) goto L20;
        return false;
    L20:
        if (this.isSecondLocate == r101.isSecondLocate) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.cardName, r101.cardName) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.jumpSchema, r101.jumpSchema) == true) goto L26;
        return false;
    L26:
        if (this.targetCounterPosition == r101.targetCounterPosition) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.refId, r101.refId) == true) goto L30;
        return false;
    L30:
        if (this.targetPropDefId == r101.targetPropDefId) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [int] */
    /* JADX WARN: Type inference failed for: r4v3 */
    public int hashCode() {
        int r100 = this.targetPageType * 31;
        long r101 = this.targetGiftId;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        String r103 = this.tipsWhenNotExist;
        int r104 = 0;
        if (r103 == null) goto L5;
        int r105 = r103.hashCode();
    L6:
        int r106 = (((r102 + r105) * 31) + this.actionWhenNotExist) * 31;
        boolean r107 = this.needAnimWhenLocated;
        ?? r108 = 1;
        ?? r109 = r107;
        if (r107 == false) goto L9;
        r109 = 1;
    L9:
        int r110 = (((r106 + r109) * 31) + this.buffLevel) * 31;
        boolean r111 = this.stayWithCurrentPosition;
        ?? r112 = r111;
        if (r111 == false) goto L12;
        r112 = 1;
    L12:
        int r113 = (r110 + r112) * 31;
        boolean r114 = this.isSecondLocate;
        if (r114 == true) goto L16;
        r108 = r114;
    L16:
        int r115 = (r113 + r108) * 31;
        String r116 = this.cardName;
        if (r116 == null) goto L19;
        int r117 = r116.hashCode();
    L20:
        int r118 = (r115 + r117) * 31;
        String r119 = this.jumpSchema;
        if (r119 == null) goto L23;
        int r120 = r119.hashCode();
    L24:
        int r121 = (((r118 + r120) * 31) + this.targetCounterPosition) * 31;
        String r122 = this.refId;
        if (r122 == null) goto L27;
        r104 = r122.hashCode();
    L27:
        long r123 = this.targetPropDefId;
        return ((r121 + r104) * 31) + ((int) (r123 ^ (r123 >>> 32)));
    L23:
        r120 = 0;
        goto L24
    L19:
        r117 = 0;
        goto L20
    L5:
        r105 = 0;
        goto L6
    }

    public String toString() {
        return "LocateGiftInfo(targetPageType=" + this.targetPageType + ", targetGiftId=" + this.targetGiftId + ", tipsWhenNotExist=" + this.tipsWhenNotExist + ", actionWhenNotExist=" + this.actionWhenNotExist + ", needAnimWhenLocated=" + this.needAnimWhenLocated + ", buffLevel=" + this.buffLevel + ", stayWithCurrentPosition=" + this.stayWithCurrentPosition + ", isSecondLocate=" + this.isSecondLocate + ", cardName=" + this.cardName + ", jumpSchema=" + this.jumpSchema + ", targetCounterPosition=" + this.targetCounterPosition + ", refId=" + this.refId + ", targetPropDefId=" + this.targetPropDefId + ")";
    }

    public final LocateGiftInfo setLocateSecond() {
        return copy$default(this, 0, 0, null, 0, false, 0, false, true, null, null, 0, null, 0, 8063, null);
    }

    public final int getActionWhenNotExist() {
        return this.actionWhenNotExist;
    }

    public final int getBuffLevel() {
        return this.buffLevel;
    }

    public final String getCardName() {
        return this.cardName;
    }

    public final String getJumpSchema() {
        return this.jumpSchema;
    }

    public final boolean getNeedAnimWhenLocated() {
        return this.needAnimWhenLocated;
    }

    public final String getRefId() {
        return this.refId;
    }

    public final boolean getStayWithCurrentPosition() {
        return this.stayWithCurrentPosition;
    }

    public final int getTargetCounterPosition() {
        return this.targetCounterPosition;
    }

    public final long getTargetGiftId() {
        return this.targetGiftId;
    }

    public final int getTargetPageType() {
        return this.targetPageType;
    }

    public final long getTargetPropDefId() {
        return this.targetPropDefId;
    }

    public final String getTipsWhenNotExist() {
        return this.tipsWhenNotExist;
    }

    public final boolean isSecondLocate() {
        return this.isSecondLocate;
    }

    public final void setCardName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.cardName = r100;
    }

    public final void setTargetGiftId(long r100) {
        this.targetGiftId = r100;
    }

    public final void setTargetPropDefId(long r100) {
        this.targetPropDefId = r100;
    }

    public LocateGiftInfo(int r110, String r111, int r210, boolean r211, long r212) {
        Intrinsics.checkNotNullParameter(r111, "tipsWhenNotExist");
        this(r110, -1, r111, r210, r211, 0, false, false, "", "", -1, "", r212);
    }

    public LocateGiftInfo(int r110, long r210, String r211, int r212, boolean r213, int r214) {
        Intrinsics.checkNotNullParameter(r211, "tipsWhenNotExist");
        this(r110, r210, r211, r212, r213, r214, false, false, "", "", 0, null, 0, 7168, null);
    }

    public /* synthetic */ LocateGiftInfo(int r110, String r111, int r112, boolean r113, long r114, int r115, DefaultConstructorMarker r116) {
        if ((r115 & 1) == 0) goto L5;
        int r100 = 0;
    L7:
        if ((r115 & 2) == 0) goto L9;
        String r101 = "寻找礼物失败啦～重新打开礼物栏试试";
    L11:
        if ((r115 & 4) == 0) goto L13;
        int r102 = 0;
    L15:
        if ((r115 & 8) == 0) goto L17;
        boolean r103 = true;
    L18:
        this(r100, r101, r102, r103, r114);
        return;
    L17:
        r103 = r113;
        goto L18
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public /* synthetic */ LocateGiftInfo(int r100, long r101, String r110, int r111, boolean r112, int r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        int r116 = 0;
    L7:
        if ((r114 & 2) == 0) goto L9;
        r101 = -1;
    L9:
        long r102 = r101;
        if ((r114 & 4) == 0) goto L12;
        r110 = "寻找礼物失败啦～重新打开礼物栏试试";
    L12:
        String r103 = r110;
        if ((r114 & 8) == 0) goto L15;
        int r104 = 0;
    L17:
        if ((r114 & 16) == 0) goto L19;
        boolean r105 = true;
    L21:
        if ((r114 & 32) == 0) goto L23;
        int r117 = 0;
    L24:
        this(r116, r102, r103, r104, r105, r117);
        return;
    L23:
        r117 = r113;
        goto L24
    L19:
        r105 = r112;
        goto L21
    L15:
        r104 = r111;
        goto L17
    L5:
        r116 = r100;
        goto L7
    }

    public LocateGiftInfo(int r110, long r210, String r211, int r212, boolean r213, int r214, String r215, String r216, String r217) {
        Intrinsics.checkNotNullParameter(r211, "tipsWhenNotExist");
        Intrinsics.checkNotNullParameter(r215, "cardName");
        Intrinsics.checkNotNullParameter(r216, "jumpSchema");
        Intrinsics.checkNotNullParameter(r217, "refId");
        this(r110, r210, r211, r212, r213, r214, false, false, r215, r216, 0, r217, 0, BmLocated.HALF_LEFT_TOP, null);
    }

    public /* synthetic */ LocateGiftInfo(int r110, long r111, String r112, int r113, boolean r114, int r115, String r116, String r210, String r211, int r212, DefaultConstructorMarker r213) {
        int r100 = 0;
        if ((r212 & 1) == 0) goto L5;
        int r101 = 0;
    L7:
        if ((r212 & 2) == 0) goto L9;
        long r102 = -1;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r103 = "寻找礼物失败啦～重新打开礼物栏试试";
    L15:
        if ((r212 & 8) == 0) goto L17;
        int r104 = 0;
    L19:
        if ((r212 & 16) == 0) goto L21;
        boolean r105 = true;
    L23:
        if ((r212 & 32) != 0) goto L26;
        r100 = r115;
    L26:
        String r106 = "";
        if ((r212 & 64) == 0) goto L29;
        String r107 = "";
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r117 = "";
    L35:
        if ((r212 & 256) != 0) goto L38;
        r106 = r211;
    L38:
        this(r101, r102, r103, r104, r105, r100, r107, r117, r106);
        return;
    L33:
        r117 = r210;
        goto L35
    L29:
        r107 = r116;
        goto L31
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

    public LocateGiftInfo(int r100, long r101, String r110, int r111, boolean r112, int r113, boolean r114, boolean r115, String r116, String r117, int r118, String r210, long r211) {
        Intrinsics.checkNotNullParameter(r110, "tipsWhenNotExist");
        Intrinsics.checkNotNullParameter(r116, "cardName");
        Intrinsics.checkNotNullParameter(r117, "jumpSchema");
        Intrinsics.checkNotNullParameter(r210, "refId");
        this.targetPageType = r100;
        this.targetGiftId = r101;
        this.tipsWhenNotExist = r110;
        this.actionWhenNotExist = r111;
        this.needAnimWhenLocated = r112;
        this.buffLevel = r113;
        this.stayWithCurrentPosition = r114;
        this.isSecondLocate = r115;
        this.cardName = r116;
        this.jumpSchema = r117;
        this.targetCounterPosition = r118;
        this.refId = r210;
        this.targetPropDefId = r211;
    }

    public /* synthetic */ LocateGiftInfo(int r110, long r111, String r210, int r211, boolean r212, int r213, boolean r214, boolean r215, String r216, String r217, int r218, String r310, long r311, int r312, DefaultConstructorMarker r313) {
        boolean r100 = false;
        if ((r312 & 1) == 0) goto L5;
        int r101 = 0;
    L7:
        if ((r312 & 2) == 0) goto L9;
        long r102 = -1;
    L11:
        if ((r312 & 4) == 0) goto L13;
        String r103 = "寻找礼物失败啦～重新打开礼物栏试试";
    L15:
        if ((r312 & 8) == 0) goto L17;
        int r104 = 0;
    L19:
        if ((r312 & 16) == 0) goto L21;
        boolean r105 = true;
    L23:
        if ((r312 & 32) == 0) goto L25;
        int r106 = 0;
    L27:
        if ((r312 & 64) == 0) goto L29;
        boolean r112 = false;
    L31:
        if ((r312 & 128) != 0) goto L34;
        r100 = r215;
    L34:
        String r113 = "";
        if ((r312 & 256) == 0) goto L37;
        String r114 = "";
    L39:
        if ((r312 & 512) == 0) goto L41;
        String r115 = "";
    L43:
        if ((r312 & 1024) == 0) goto L45;
        int r116 = -1;
    L47:
        if ((r312 & 2048) != 0) goto L51;
        r113 = r310;
    L51:
        if ((r312 & 4096) == 0) goto L53;
        long r117 = -1;
    L54:
        this(r101, r102, r103, r104, r105, r106, r112, r100, r114, r115, r116, r113, r117);
        return;
    L53:
        r117 = r311;
        goto L54
    L45:
        r116 = r218;
        goto L47
    L41:
        r115 = r217;
        goto L43
    L37:
        r114 = r216;
        goto L39
    L29:
        r112 = r214;
        goto L31
    L25:
        r106 = r213;
        goto L27
    L21:
        r105 = r212;
        goto L23
    L17:
        r104 = r211;
        goto L19
    L13:
        r103 = r210;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
