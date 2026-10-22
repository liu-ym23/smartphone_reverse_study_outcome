package com.bytedance.android.shopping.card_list.params;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001f\b\u0086\b\u0018\u0000 92\u00020\u0001:\u0001:By\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012(\b\u0002\u0010\u0012\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b7\u00108J\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J{\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032(\b\u0002\u0010\u0012\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0018HÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003R$\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010(\u001a\u0004\b)\u0010*RB\u0010\u0012\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010(\u001a\u0004\b0\u0010*\"\u0004\b1\u00102R$\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010(\u001a\u0004\b3\u0010*\"\u0004\b4\u00102R$\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010(\u001a\u0004\b5\u0010*\"\u0004\b6\u00102¨\u0006;"}, d2 = {"Lcom/bytedance/android/shopping/card_list/params/CardPassThroughData;", "Ljava/io/Serializable;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getSchemaParamsOrCreate", "Lcom/bytedance/android/shopping/card_list/params/CartPassThroughData;", "component1", "Lcom/bytedance/android/shopping/card_list/params/CollectPassThroughData;", "component2", "component3", "component4", "component5", "component6", "component7", "cartSchemaData", "collectSchemaData", "sessionId", "schemaParams", "monitorId", "ecomSceneId", "splitActivityScene", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/bytedance/android/shopping/card_list/params/CartPassThroughData;", "getCartSchemaData", "()Lcom/bytedance/android/shopping/card_list/params/CartPassThroughData;", "setCartSchemaData", "(Lcom/bytedance/android/shopping/card_list/params/CartPassThroughData;)V", "Lcom/bytedance/android/shopping/card_list/params/CollectPassThroughData;", "getCollectSchemaData", "()Lcom/bytedance/android/shopping/card_list/params/CollectPassThroughData;", "setCollectSchemaData", "(Lcom/bytedance/android/shopping/card_list/params/CollectPassThroughData;)V", "Ljava/lang/String;", "getSessionId", "()Ljava/lang/String;", "Ljava/util/HashMap;", "getSchemaParams", "()Ljava/util/HashMap;", "setSchemaParams", "(Ljava/util/HashMap;)V", "getMonitorId", "setMonitorId", "(Ljava/lang/String;)V", "getEcomSceneId", "setEcomSceneId", "getSplitActivityScene", "setSplitActivityScene", "<init>", "(Lcom/bytedance/android/shopping/card_list/params/CartPassThroughData;Lcom/bytedance/android/shopping/card_list/params/CollectPassThroughData;Ljava/lang/String;Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CardPassThroughData implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("cart_schema_data")
    private CartPassThroughData cartSchemaData;

    @SerializedName("collect_schema_data")
    private CollectPassThroughData collectSchemaData;

    @SerializedName("ecom_scene_id")
    private String ecomSceneId;

    @SerializedName("ec_monitor_key")
    private String monitorId;

    @SerializedName("schema_params")
    private HashMap<String, String> schemaParams;

    @SerializedName("session_id")
    private final String sessionId;

    @SerializedName("split_activity_scene")
    private String splitActivityScene;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public CardPassThroughData() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CardPassThroughData copy$default(CardPassThroughData r100, CartPassThroughData r101, CollectPassThroughData r102, String r103, HashMap r104, String r110, String r111, String r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.cartSchemaData;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.collectSchemaData;
    L8:
        CollectPassThroughData r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.sessionId;
    L11:
        String r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.schemaParams;
    L14:
        HashMap r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.monitorId;
    L17:
        String r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.ecomSceneId;
    L20:
        String r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.splitActivityScene;
    L23:
        CartPassThroughData r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final CartPassThroughData component1() {
        return this.cartSchemaData;
    }

    public final CollectPassThroughData component2() {
        return this.collectSchemaData;
    }

    public final String component3() {
        return this.sessionId;
    }

    public final HashMap<String, String> component4() {
        return this.schemaParams;
    }

    public final String component5() {
        return this.monitorId;
    }

    public final String component6() {
        return this.ecomSceneId;
    }

    public final String component7() {
        return this.splitActivityScene;
    }

    public final CardPassThroughData copy(CartPassThroughData r110, CollectPassThroughData r111, String r112, HashMap<String, String> r113, String r114, String r115, String r116) {
        return new CardPassThroughData(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CardPassThroughData) == false) goto L20;
        CardPassThroughData r101 = (CardPassThroughData) r100;
        if (Intrinsics.areEqual(this.cartSchemaData, r101.cartSchemaData) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.collectSchemaData, r101.collectSchemaData) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.sessionId, r101.sessionId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.schemaParams, r101.schemaParams) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.monitorId, r101.monitorId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.ecomSceneId, r101.ecomSceneId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.splitActivityScene, r101.splitActivityScene) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        CartPassThroughData r100 = this.cartSchemaData;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        CollectPassThroughData r104 = this.collectSchemaData;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.sessionId;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        HashMap<String, String> r110 = this.schemaParams;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.monitorId;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.ecomSceneId;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.splitActivityScene;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
    L25:
        r117 = 0;
        goto L26
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
        return "CardPassThroughData(cartSchemaData=" + this.cartSchemaData + ", collectSchemaData=" + this.collectSchemaData + ", sessionId=" + this.sessionId + ", schemaParams=" + this.schemaParams + ", monitorId=" + this.monitorId + ", ecomSceneId=" + this.ecomSceneId + ", splitActivityScene=" + this.splitActivityScene + ")";
    }

    public final HashMap<String, String> getSchemaParamsOrCreate() {
        HashMap<String, String> r100 = this.schemaParams;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new HashMap();
    }

    public final CartPassThroughData getCartSchemaData() {
        return this.cartSchemaData;
    }

    public final CollectPassThroughData getCollectSchemaData() {
        return this.collectSchemaData;
    }

    public final String getEcomSceneId() {
        return this.ecomSceneId;
    }

    public final String getMonitorId() {
        return this.monitorId;
    }

    public final HashMap<String, String> getSchemaParams() {
        return this.schemaParams;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getSplitActivityScene() {
        return this.splitActivityScene;
    }

    public final void setCartSchemaData(CartPassThroughData r100) {
        this.cartSchemaData = r100;
    }

    public final void setCollectSchemaData(CollectPassThroughData r100) {
        this.collectSchemaData = r100;
    }

    public final void setEcomSceneId(String r100) {
        this.ecomSceneId = r100;
    }

    public final void setMonitorId(String r100) {
        this.monitorId = r100;
    }

    public final void setSchemaParams(HashMap<String, String> r100) {
        this.schemaParams = r100;
    }

    public final void setSplitActivityScene(String r100) {
        this.splitActivityScene = r100;
    }

    public CardPassThroughData(CartPassThroughData r100, CollectPassThroughData r101, String r102, HashMap<String, String> r103, String r104, String r105, String r106) {
        this.cartSchemaData = r100;
        this.collectSchemaData = r101;
        this.sessionId = r102;
        this.schemaParams = r103;
        this.monitorId = r104;
        this.ecomSceneId = r105;
        this.splitActivityScene = r106;
    }

    public /* synthetic */ CardPassThroughData(CartPassThroughData r100, CollectPassThroughData r101, String r102, HashMap r110, String r111, String r112, String r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        CartPassThroughData r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        CollectPassThroughData r103 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        String r104 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        r110 = new HashMap();
    L17:
        HashMap r105 = r110;
        if ((r114 & 16) == 0) goto L20;
        String r106 = null;
    L22:
        if ((r114 & 32) == 0) goto L24;
        String r107 = null;
    L26:
        if ((r114 & 64) == 0) goto L28;
        String r117 = null;
    L29:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L28:
        r117 = r113;
        goto L29
    L24:
        r107 = r112;
        goto L26
    L20:
        r106 = r111;
        goto L22
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
