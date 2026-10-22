package com.bytedance.android.shopping.slice.action.entity;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u001c\b\u0086\b\u0018\u0000 12\u00020\u0001:\u00012BW\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n\u0012\u0018\b\u0002\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f¢\u0006\u0004\b/\u00100J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0019\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fHÆ\u0003JY\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n2\u0018\b\u0002\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fHÆ\u0001J\t\u0010\u0016\u001a\u00020\bHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0017HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\rHÖ\u0003R\u001a\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0010\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001b\u001a\u0004\b\u001e\u0010\u001dR\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\"\u001a\u0004\b#\u0010$R$\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R2\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u00063"}, d2 = {"Lcom/bytedance/android/shopping/slice/action/entity/PDPBuyWithoutCheckParam;", "Ljava/io/Serializable;", "", "secKillActivityOnGoing", "", "component1", "component2", "component3", "", "component4", "Lcom/bytedance/android/ec/core/btm/a;", "component5", "", "", "component6", "secActivityBeginTime", "secActivityEndTime", "hasSecActivity", "orderUrl", "btmFields", "updateParams", "copy", "toString", "", "hashCode", "other", "equals", "J", "getSecActivityBeginTime", "()J", "getSecActivityEndTime", "Z", "getHasSecActivity", "()Z", "Ljava/lang/String;", "getOrderUrl", "()Ljava/lang/String;", "Lcom/bytedance/android/ec/core/btm/a;", "getBtmFields", "()Lcom/bytedance/android/ec/core/btm/a;", "setBtmFields", "(Lcom/bytedance/android/ec/core/btm/a;)V", "Ljava/util/Map;", "getUpdateParams", "()Ljava/util/Map;", "setUpdateParams", "(Ljava/util/Map;)V", "<init>", "(JJZLjava/lang/String;Lcom/bytedance/android/ec/core/btm/a;Ljava/util/Map;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PDPBuyWithoutCheckParam implements Serializable {
    public static final a Companion = null;

    @SerializedName("btm_fields")
    private com.bytedance.android.ec.core.btm.a btmFields;

    @SerializedName("has_sec_activity")
    private final boolean hasSecActivity;

    @SerializedName("order_url")
    private final String orderUrl;

    @SerializedName("sec_activity_begin_time")
    private final long secActivityBeginTime;

    @SerializedName("sec_activity_end_time")
    private final long secActivityEndTime;

    @SerializedName("update_params")
    private Map<String, ? extends Object> updateParams;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public PDPBuyWithoutCheckParam() {
        this(0, 0, false, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PDPBuyWithoutCheckParam copy$default(PDPBuyWithoutCheckParam r100, long r110, long r111, boolean r112, String r113, com.bytedance.android.ec.core.btm.a r114, Map r115, int r116, Object r117) {
        if ((r116 & 1) == 0) goto L5;
        long r101 = r100.secActivityBeginTime;
    L7:
        if ((r116 & 2) == 0) goto L9;
        long r102 = r100.secActivityEndTime;
    L11:
        if ((r116 & 4) == 0) goto L13;
        boolean r103 = r100.hasSecActivity;
    L15:
        if ((r116 & 8) == 0) goto L17;
        String r104 = r100.orderUrl;
    L19:
        if ((r116 & 16) == 0) goto L21;
        com.bytedance.android.ec.core.btm.a r105 = r100.btmFields;
    L23:
        if ((r116 & 32) == 0) goto L25;
        Map r106 = r100.updateParams;
    L27:
        return r100.copy(r101, r102, r103, r104, r105, r106);
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

    public final long component1() {
        return this.secActivityBeginTime;
    }

    public final long component2() {
        return this.secActivityEndTime;
    }

    public final boolean component3() {
        return this.hasSecActivity;
    }

    public final String component4() {
        return this.orderUrl;
    }

    public final com.bytedance.android.ec.core.btm.a component5() {
        return this.btmFields;
    }

    public final Map<String, Object> component6() {
        return this.updateParams;
    }

    public final PDPBuyWithoutCheckParam copy(long r110, long r111, boolean r112, String r113, com.bytedance.android.ec.core.btm.a r114, Map<String, ? extends Object> r115) {
        return new PDPBuyWithoutCheckParam(r110, r111, r112, r113, r114, r115);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PDPBuyWithoutCheckParam) == false) goto L18;
        PDPBuyWithoutCheckParam r101 = (PDPBuyWithoutCheckParam) r100;
        if (this.secActivityBeginTime == r101.secActivityBeginTime) goto L8;
        return false;
    L8:
        if (this.secActivityEndTime == r101.secActivityEndTime) goto L10;
        return false;
    L10:
        if (this.hasSecActivity == r101.hasSecActivity) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.orderUrl, r101.orderUrl) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.btmFields, r101.btmFields) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.updateParams, r101.updateParams) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    public int hashCode() {
        long r100 = this.secActivityBeginTime;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.secActivityEndTime;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        boolean r104 = this.hasSecActivity;
        ?? r105 = r104;
        if (r104 == false) goto L5;
        r105 = 1;
    L5:
        int r106 = (r103 + r105) * 31;
        String r107 = this.orderUrl;
        int r108 = 0;
        if (r107 == null) goto L8;
        int r109 = r107.hashCode();
    L9:
        int r110 = (r106 + r109) * 31;
        com.bytedance.android.ec.core.btm.a r111 = this.btmFields;
        if (r111 == null) goto L12;
        int r112 = r111.hashCode();
    L13:
        int r113 = (r110 + r112) * 31;
        Map<String, ? extends Object> r114 = this.updateParams;
        if (r114 == null) goto L17;
        r108 = r114.hashCode();
    L17:
        return r113 + r108;
    L12:
        r112 = 0;
        goto L13
    L8:
        r109 = 0;
        goto L9
    }

    public String toString() {
        return "PDPBuyWithoutCheckParam(secActivityBeginTime=" + this.secActivityBeginTime + ", secActivityEndTime=" + this.secActivityEndTime + ", hasSecActivity=" + this.hasSecActivity + ", orderUrl=" + this.orderUrl + ", btmFields=" + this.btmFields + ", updateParams=" + this.updateParams + ")";
    }

    public final boolean secKillActivityOnGoing() {
        long r100 = System.currentTimeMillis() / ((long) 1000);
        long r101 = this.secActivityBeginTime;
        long r102 = this.secActivityEndTime;
        if (r101 <= r100) goto L6;
    L10:
        return false;
    L6:
        if (r102 < r100) goto L10;
        if (this.hasSecActivity == false) goto L10;
        return true;
    }

    public final com.bytedance.android.ec.core.btm.a getBtmFields() {
        return this.btmFields;
    }

    public final boolean getHasSecActivity() {
        return this.hasSecActivity;
    }

    public final String getOrderUrl() {
        return this.orderUrl;
    }

    public final long getSecActivityBeginTime() {
        return this.secActivityBeginTime;
    }

    public final long getSecActivityEndTime() {
        return this.secActivityEndTime;
    }

    public final Map<String, Object> getUpdateParams() {
        return this.updateParams;
    }

    public final void setBtmFields(com.bytedance.android.ec.core.btm.a r100) {
        this.btmFields = r100;
    }

    public final void setUpdateParams(Map<String, ? extends Object> r100) {
        this.updateParams = r100;
    }

    public PDPBuyWithoutCheckParam(long r100, long r101, boolean r102, String r103, com.bytedance.android.ec.core.btm.a r104, Map<String, ? extends Object> r105) {
        this.secActivityBeginTime = r100;
        this.secActivityEndTime = r101;
        this.hasSecActivity = r102;
        this.orderUrl = r103;
        this.btmFields = r104;
        this.updateParams = r105;
    }

    public /* synthetic */ PDPBuyWithoutCheckParam(long r110, long r111, boolean r112, String r113, com.bytedance.android.ec.core.btm.a r114, Map r115, int r116, DefaultConstructorMarker r117) {
        long r100 = 0;
        if ((r116 & 1) == 0) goto L5;
        long r101 = 0;
    L7:
        if ((r116 & 2) != 0) goto L11;
        r100 = r111;
    L11:
        if ((r116 & 4) == 0) goto L13;
        boolean r102 = false;
    L14:
        Map r103 = null;
        if ((r116 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r116 & 16) == 0) goto L21;
        com.bytedance.android.ec.core.btm.a r105 = null;
    L23:
        if ((r116 & 32) != 0) goto L26;
        r103 = r115;
    L26:
        this(r101, r100, r102, r104, r105, r103);
        return;
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L14
    L5:
        r101 = r110;
        goto L7
    }
}
