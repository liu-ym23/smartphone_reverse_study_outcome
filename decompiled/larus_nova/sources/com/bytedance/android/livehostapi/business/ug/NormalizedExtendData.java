package com.bytedance.android.livehostapi.business.ug;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001:\u0001&BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\rHÆ\u0003JQ\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010\"\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\tHÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0013R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006'"}, d2 = {"Lcom/bytedance/android/livehostapi/business/ug/NormalizedExtendData;", "", "pendantExtendData", "Lcom/bytedance/android/livehostapi/business/ug/PendantExtendData;", "bizType", "", "showMills", "", "priority", "", "extendType", "extraLog", "isFromFeed", "", "(Lcom/bytedance/android/livehostapi/business/ug/PendantExtendData;Ljava/lang/String;JILjava/lang/String;Ljava/lang/String;Z)V", "getBizType", "()Ljava/lang/String;", "getExtendType", "getExtraLog", "()Z", "getPendantExtendData", "()Lcom/bytedance/android/livehostapi/business/ug/PendantExtendData;", "getPriority", "()I", "getShowMills", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "ExtendType", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NormalizedExtendData {
    private final String bizType;
    private final String extendType;
    private final String extraLog;
    private final boolean isFromFeed;
    private final PendantExtendData pendantExtendData;
    private final int priority;
    private final long showMills;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livehostapi/business/ug/NormalizedExtendData$ExtendType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", EffectConstants.NORMAL, "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ExtendType extends Enum<ExtendType> {
        private static final /* synthetic */ ExtendType[] $VALUES = null;
        public static final ExtendType NORMAL = null;
        private final String type;

        static {
            ExtendType r100 = new ExtendType(EffectConstants.NORMAL, 0, "normal");
            NORMAL = r100;
            $VALUES = new ExtendType[]{r100};
        }

        public static ExtendType valueOf(String r100) {
            return (ExtendType) a.a(ExtendType.class, r100);
        }

        public static ExtendType[] values() {
            return (ExtendType[]) $VALUES.clone();
        }

        public final String getType() {
            return this.type;
        }

        private ExtendType(String r100, int r101, String r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    public NormalizedExtendData() {
        this(null, null, 0, 0, null, null, false, 127, null);
    }

    public static /* synthetic */ NormalizedExtendData copy$default(NormalizedExtendData r100, PendantExtendData r110, String r111, long r112, int r113, String r114, String r115, boolean r116, int r117, Object r118) {
        if ((r117 & 1) == 0) goto L5;
        PendantExtendData r101 = r100.pendantExtendData;
    L7:
        if ((r117 & 2) == 0) goto L9;
        String r102 = r100.bizType;
    L11:
        if ((r117 & 4) == 0) goto L13;
        long r103 = r100.showMills;
    L15:
        if ((r117 & 8) == 0) goto L17;
        int r104 = r100.priority;
    L19:
        if ((r117 & 16) == 0) goto L21;
        String r105 = r100.extendType;
    L23:
        if ((r117 & 32) == 0) goto L25;
        String r106 = r100.extraLog;
    L27:
        if ((r117 & 64) == 0) goto L29;
        boolean r107 = r100.isFromFeed;
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

    public final PendantExtendData component1() {
        return this.pendantExtendData;
    }

    public final String component2() {
        return this.bizType;
    }

    public final long component3() {
        return this.showMills;
    }

    public final int component4() {
        return this.priority;
    }

    public final String component5() {
        return this.extendType;
    }

    public final String component6() {
        return this.extraLog;
    }

    public final boolean component7() {
        return this.isFromFeed;
    }

    public final NormalizedExtendData copy(PendantExtendData r110, String r111, long r112, int r113, String r114, String r115, boolean r116) {
        Intrinsics.checkNotNullParameter(r111, "bizType");
        Intrinsics.checkNotNullParameter(r114, "extendType");
        Intrinsics.checkNotNullParameter(r115, "extraLog");
        return new NormalizedExtendData(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof NormalizedExtendData) == false) goto L20;
        NormalizedExtendData r101 = (NormalizedExtendData) r100;
        if (Intrinsics.areEqual(this.pendantExtendData, r101.pendantExtendData) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.bizType, r101.bizType) == true) goto L10;
        return false;
    L10:
        if (this.showMills == r101.showMills) goto L12;
        return false;
    L12:
        if (this.priority == r101.priority) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.extendType, r101.extendType) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.extraLog, r101.extraLog) == true) goto L18;
        return false;
    L18:
        if (this.isFromFeed == r101.isFromFeed) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        PendantExtendData r100 = this.pendantExtendData;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.bizType;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.showMills;
        int r108 = (((r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31) + this.priority) * 31;
        String r109 = this.extendType;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (r108 + r110) * 31;
        String r112 = this.extraLog;
        if (r112 == null) goto L17;
        r101 = r112.hashCode();
    L17:
        int r113 = (r111 + r101) * 31;
        boolean r114 = this.isFromFeed;
        ?? r115 = r114;
        if (r114 == false) goto L21;
        r115 = 1;
    L21:
        return r113 + r115;
    L13:
        r110 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "NormalizedExtendData(pendantExtendData=" + this.pendantExtendData + ", bizType=" + this.bizType + ", showMills=" + this.showMills + ", priority=" + this.priority + ", extendType=" + this.extendType + ", extraLog=" + this.extraLog + ", isFromFeed=" + this.isFromFeed + ")";
    }

    public final String getBizType() {
        return this.bizType;
    }

    public final String getExtendType() {
        return this.extendType;
    }

    public final String getExtraLog() {
        return this.extraLog;
    }

    public final PendantExtendData getPendantExtendData() {
        return this.pendantExtendData;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final long getShowMills() {
        return this.showMills;
    }

    public final boolean isFromFeed() {
        return this.isFromFeed;
    }

    public NormalizedExtendData(PendantExtendData r100, String r101, long r102, int r103, String r104, String r105, boolean r106) {
        Intrinsics.checkNotNullParameter(r101, "bizType");
        Intrinsics.checkNotNullParameter(r104, "extendType");
        Intrinsics.checkNotNullParameter(r105, "extraLog");
        this.pendantExtendData = r100;
        this.bizType = r101;
        this.showMills = r102;
        this.priority = r103;
        this.extendType = r104;
        this.extraLog = r105;
        this.isFromFeed = r106;
    }

    public /* synthetic */ NormalizedExtendData(PendantExtendData r110, String r111, long r112, int r113, String r114, String r115, boolean r116, int r117, DefaultConstructorMarker r118) {
        if ((r117 & 1) == 0) goto L5;
        PendantExtendData r100 = null;
    L7:
        if ((r117 & 2) == 0) goto L9;
        String r101 = "default";
    L11:
        if ((r117 & 4) == 0) goto L13;
        long r102 = 3000;
    L14:
        boolean r103 = false;
        if ((r117 & 8) == 0) goto L17;
        int r104 = 0;
    L19:
        if ((r117 & 16) == 0) goto L21;
        String r105 = ExtendType.NORMAL.getType();
    L23:
        if ((r117 & 32) == 0) goto L25;
        String r106 = "";
    L27:
        if ((r117 & 64) != 0) goto L30;
        r103 = r116;
    L30:
        this(r100, r101, r102, r104, r105, r106, r103);
        return;
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
        r102 = r112;
        goto L14
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
