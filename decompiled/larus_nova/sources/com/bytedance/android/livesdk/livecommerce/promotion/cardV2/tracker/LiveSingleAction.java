package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J[\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR&\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/tracker/LiveSingleAction;", "Ljava/io/Serializable;", "actionName", "", "info", "", "", "success", "", "error", "requestId", "schema", "(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActionName", "()Ljava/lang/String;", "getError", "getInfo", "()Ljava/util/Map;", "getRequestId", "getSchema", "getSuccess", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSingleAction implements Serializable {

    @SerializedName("action_name")
    private final String actionName;

    @SerializedName("error")
    private final String error;

    @SerializedName("info")
    private final Map<String, Object> info;

    @SerializedName("request_id")
    private final String requestId;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("success")
    private final boolean success;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LiveSingleAction copy$default(LiveSingleAction r100, String r101, Map r102, boolean r103, String r104, String r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.actionName;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.info;
    L8:
        Map r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.success;
    L11:
        boolean r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.error;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.requestId;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.schema;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.actionName;
    }

    public final Map<String, Object> component2() {
        return this.info;
    }

    public final boolean component3() {
        return this.success;
    }

    public final String component4() {
        return this.error;
    }

    public final String component5() {
        return this.requestId;
    }

    public final String component6() {
        return this.schema;
    }

    public final LiveSingleAction copy(String r100, Map<String, ? extends Object> r110, boolean r111, String r112, String r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        return new LiveSingleAction(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LiveSingleAction) == false) goto L18;
        LiveSingleAction r101 = (LiveSingleAction) r100;
        if (Intrinsics.areEqual(this.actionName, r101.actionName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.info, r101.info) == true) goto L10;
        return false;
    L10:
        if (this.success == r101.success) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.error, r101.error) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.requestId, r101.requestId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    public int hashCode() {
        String r100 = this.actionName;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, Object> r104 = this.info;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.success;
        ?? r108 = r107;
        if (r107 == false) goto L13;
        r108 = 1;
    L13:
        int r109 = (r106 + r108) * 31;
        String r110 = this.error;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (r109 + r111) * 31;
        String r113 = this.requestId;
        if (r113 == null) goto L20;
        int r114 = r113.hashCode();
    L21:
        int r115 = (r112 + r114) * 31;
        String r116 = this.schema;
        if (r116 == null) goto L25;
        r101 = r116.hashCode();
    L25:
        return r115 + r101;
    L20:
        r114 = 0;
        goto L21
    L16:
        r111 = 0;
        goto L17
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "LiveSingleAction(actionName=" + this.actionName + ", info=" + this.info + ", success=" + this.success + ", error=" + this.error + ", requestId=" + this.requestId + ", schema=" + this.schema + ")";
    }

    public final String getActionName() {
        return this.actionName;
    }

    public final String getError() {
        return this.error;
    }

    public final Map<String, Object> getInfo() {
        return this.info;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public LiveSingleAction(String r100, Map<String, ? extends Object> r101, boolean r102, String r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        this.actionName = r100;
        this.info = r101;
        this.success = r102;
        this.error = r103;
        this.requestId = r104;
        this.schema = r105;
    }

    public /* synthetic */ LiveSingleAction(String r110, Map r111, boolean r112, String r113, String r114, String r115, int r116, DefaultConstructorMarker r117) {
        if ((r116 & 8) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r116 & 16) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r116 & 32) == 0) goto L13;
        String r102 = null;
    L14:
        this(r110, r111, r112, r100, r101, r102);
        return;
    L13:
        r102 = r115;
        goto L14
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }
}
