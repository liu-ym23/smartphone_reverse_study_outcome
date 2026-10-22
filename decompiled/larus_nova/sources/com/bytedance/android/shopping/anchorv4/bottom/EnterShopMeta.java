package com.bytedance.android.shopping.anchorv4.bottom;

import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LinkedTreeMap;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001Be\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010 \u001a\u00020\u00002\b\u0010!\u001a\u0004\u0018\u00010\"R&\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013¨\u0006#"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/bottom/EnterShopMeta;", "Ljava/io/Serializable;", "shopSchema", "", "enterShopLog", "Lcom/google/gson/internal/LinkedTreeMap;", "", "fromVideo", "", "entranceInfo", "productId", "liveRoomId", "itemId", "(Ljava/lang/String;Lcom/google/gson/internal/LinkedTreeMap;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEnterShopLog", "()Lcom/google/gson/internal/LinkedTreeMap;", "getEntranceInfo", "()Ljava/lang/String;", "setEntranceInfo", "(Ljava/lang/String;)V", "getFromVideo", "()Z", "setFromVideo", "(Z)V", "getItemId", "setItemId", "getLiveRoomId", "setLiveRoomId", "getProductId", "setProductId", "getShopSchema", "setShopSchema", "fillCommonMeta", "commonMeta", "Lcom/bytedance/android/shopping/anchorv4/dto/meta/CommonMeta;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EnterShopMeta implements Serializable {

    @SerializedName("enter_shop_log")
    private final LinkedTreeMap<String, Object> enterShopLog;
    private String entranceInfo;
    private boolean fromVideo;
    private String itemId;
    private String liveRoomId;
    private String productId;

    @SerializedName("shop_schema")
    private String shopSchema;

    public EnterShopMeta() {
        this(null, null, false, null, null, null, null, 127, null);
    }

    public final LinkedTreeMap<String, Object> getEnterShopLog() {
        return this.enterShopLog;
    }

    public final String getEntranceInfo() {
        return this.entranceInfo;
    }

    public final boolean getFromVideo() {
        return this.fromVideo;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final String getLiveRoomId() {
        return this.liveRoomId;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getShopSchema() {
        return this.shopSchema;
    }

    public final EnterShopMeta fillCommonMeta(CommonMeta r100) {
        String r101 = null;
        if (r100 == null) goto L5;
        Boolean r102 = Boolean.valueOf(r100.getFromVideo());
    L6:
        this.fromVideo = com.bytedance.android.shopping.extensions.k.i(r102);
        if (r100 == null) goto L9;
        String r103 = r100.getEntranceInfo();
    L10:
        if (r103 != null) goto L12;
        r103 = "";
    L12:
        this.entranceInfo = r103;
        if (r100 == null) goto L15;
        String r104 = r100.getProductId();
    L16:
        this.productId = r104;
        if (r100 == null) goto L19;
        String r105 = r100.getLiveRoomId();
    L20:
        this.liveRoomId = r105;
        if (r100 == null) goto L23;
        r101 = r100.getItemId();
    L23:
        this.itemId = r101;
        return this;
    L19:
        r105 = null;
        goto L20
    L15:
        r104 = null;
        goto L16
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public final void setEntranceInfo(String r100) {
        this.entranceInfo = r100;
    }

    public final void setFromVideo(boolean r100) {
        this.fromVideo = r100;
    }

    public final void setItemId(String r100) {
        this.itemId = r100;
    }

    public final void setLiveRoomId(String r100) {
        this.liveRoomId = r100;
    }

    public final void setProductId(String r100) {
        this.productId = r100;
    }

    public final void setShopSchema(String r100) {
        this.shopSchema = r100;
    }

    public EnterShopMeta(String r100, LinkedTreeMap<String, Object> r101, boolean r102, String r103, String r104, String r105, String r106) {
        this.shopSchema = r100;
        this.enterShopLog = r101;
        this.fromVideo = r102;
        this.entranceInfo = r103;
        this.productId = r104;
        this.liveRoomId = r105;
        this.itemId = r106;
    }

    public /* synthetic */ EnterShopMeta(String r100, LinkedTreeMap r101, boolean r102, String r110, String r111, String r112, String r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        String r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        LinkedTreeMap r103 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        boolean r104 = false;
    L15:
        if ((r114 & 8) == 0) goto L17;
        String r105 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        String r106 = null;
    L23:
        if ((r114 & 32) == 0) goto L25;
        String r107 = null;
    L27:
        if ((r114 & 64) == 0) goto L29;
        String r117 = null;
    L30:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L21:
        r106 = r111;
        goto L23
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}
