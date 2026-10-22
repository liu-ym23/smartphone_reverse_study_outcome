package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\rJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003JW\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u000bHÖ\u0001J\t\u0010&\u001a\u00020\u0006HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017¨\u0006'"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/MFPromotionEvent;", "Ljava/io/Serializable;", "backgroundIcon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "eventIcon", "title", "", "transactionThreshold", "", "userTotalTransaction", "eventStatus", "", "descriptionSchema", "(Lcom/bytedance/android/ec/model/ECUrlModel;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;JJILjava/lang/String;)V", "getBackgroundIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "getDescriptionSchema", "()Ljava/lang/String;", "getEventIcon", "getEventStatus", "()I", "getTitle", "getTransactionThreshold", "()J", "getUserTotalTransaction", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class MFPromotionEvent implements Serializable {

    @SerializedName("bg_icon")
    private final ECUrlModel backgroundIcon;

    @SerializedName("desc_schema")
    private final String descriptionSchema;

    @SerializedName("event_icon")
    private final ECUrlModel eventIcon;

    @SerializedName("event_status")
    private final int eventStatus;

    @SerializedName("title")
    private final String title;

    @SerializedName("transaction_threshold")
    private final long transactionThreshold;

    @SerializedName("user_total_transaction")
    private final long userTotalTransaction;

    public MFPromotionEvent() {
        this(null, null, null, 0, 0, 0, null, 127, null);
    }

    public static /* synthetic */ MFPromotionEvent copy$default(MFPromotionEvent r110, ECUrlModel r111, ECUrlModel r112, String r113, long r114, long r115, int r116, String r117, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        ECUrlModel r100 = r110.backgroundIcon;
    L7:
        if ((r210 & 2) == 0) goto L9;
        ECUrlModel r101 = r110.eventIcon;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r102 = r110.title;
    L15:
        if ((r210 & 8) == 0) goto L17;
        long r103 = r110.transactionThreshold;
    L19:
        if ((r210 & 16) == 0) goto L21;
        long r104 = r110.userTotalTransaction;
    L23:
        if ((r210 & 32) == 0) goto L25;
        int r105 = r110.eventStatus;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r106 = r110.descriptionSchema;
    L31:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106);
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

    public final ECUrlModel component1() {
        return this.backgroundIcon;
    }

    public final ECUrlModel component2() {
        return this.eventIcon;
    }

    public final String component3() {
        return this.title;
    }

    public final long component4() {
        return this.transactionThreshold;
    }

    public final long component5() {
        return this.userTotalTransaction;
    }

    public final int component6() {
        return this.eventStatus;
    }

    public final String component7() {
        return this.descriptionSchema;
    }

    public final MFPromotionEvent copy(ECUrlModel r110, ECUrlModel r111, String r112, long r113, long r114, int r115, String r210) {
        return new MFPromotionEvent(r110, r111, r112, r113, r114, r115, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof MFPromotionEvent) == false) goto L20;
        MFPromotionEvent r101 = (MFPromotionEvent) r100;
        if (Intrinsics.areEqual(this.backgroundIcon, r101.backgroundIcon) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.eventIcon, r101.eventIcon) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L12;
        return false;
    L12:
        if (this.transactionThreshold == r101.transactionThreshold) goto L14;
        return false;
    L14:
        if (this.userTotalTransaction == r101.userTotalTransaction) goto L16;
        return false;
    L16:
        if (this.eventStatus == r101.eventStatus) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.descriptionSchema, r101.descriptionSchema) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        ECUrlModel r100 = this.backgroundIcon;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ECUrlModel r104 = this.eventIcon;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.title;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        long r110 = this.transactionThreshold;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        long r112 = this.userTotalTransaction;
        int r113 = (((r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31) + this.eventStatus) * 31;
        String r114 = this.descriptionSchema;
        if (r114 == null) goto L18;
        r101 = r114.hashCode();
    L18:
        return r113 + r101;
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
        return "MFPromotionEvent(backgroundIcon=" + this.backgroundIcon + ", eventIcon=" + this.eventIcon + ", title=" + this.title + ", transactionThreshold=" + this.transactionThreshold + ", userTotalTransaction=" + this.userTotalTransaction + ", eventStatus=" + this.eventStatus + ", descriptionSchema=" + this.descriptionSchema + ")";
    }

    public final ECUrlModel getBackgroundIcon() {
        return this.backgroundIcon;
    }

    public final String getDescriptionSchema() {
        return this.descriptionSchema;
    }

    public final ECUrlModel getEventIcon() {
        return this.eventIcon;
    }

    public final int getEventStatus() {
        return this.eventStatus;
    }

    public final String getTitle() {
        return this.title;
    }

    public final long getTransactionThreshold() {
        return this.transactionThreshold;
    }

    public final long getUserTotalTransaction() {
        return this.userTotalTransaction;
    }

    public MFPromotionEvent(ECUrlModel r100, ECUrlModel r101, String r102, long r103, long r104, int r105, String r106) {
        this.backgroundIcon = r100;
        this.eventIcon = r101;
        this.title = r102;
        this.transactionThreshold = r103;
        this.userTotalTransaction = r104;
        this.eventStatus = r105;
        this.descriptionSchema = r106;
    }

    public /* synthetic */ MFPromotionEvent(ECUrlModel r110, ECUrlModel r111, String r112, long r113, long r114, int r115, String r116, int r210, DefaultConstructorMarker r211) {
        String r100 = null;
        if ((r210 & 1) == 0) goto L5;
        ECUrlModel r101 = null;
    L7:
        if ((r210 & 2) == 0) goto L9;
        ECUrlModel r102 = null;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r103 = null;
    L14:
        long r104 = 0;
        if ((r210 & 8) == 0) goto L17;
        long r105 = 0;
    L19:
        if ((r210 & 16) != 0) goto L23;
        r104 = r114;
    L23:
        if ((r210 & 32) == 0) goto L25;
        int r106 = 0;
    L27:
        if ((r210 & 64) != 0) goto L30;
        r100 = r116;
    L30:
        this(r101, r102, r103, r105, r104, r106, r100);
        return;
    L25:
        r106 = r115;
        goto L27
    L17:
        r105 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L14
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
