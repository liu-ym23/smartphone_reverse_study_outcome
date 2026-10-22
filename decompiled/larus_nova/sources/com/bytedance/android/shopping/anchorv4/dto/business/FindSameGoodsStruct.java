package com.bytedance.android.shopping.anchorv4.dto.business;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001d\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0001%Ba\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\t\u0012\b\b\u0002\u0010\u001e\u001a\u00020\t\u0012\b\b\u0002\u0010 \u001a\u00020\t¢\u0006\u0004\b\"\u0010#J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016J\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\u000bJ\b\u0010\r\u001a\u00020\tH\u0016R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011R\u001a\u0010\u001a\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001f\u0010\u001dR\u001a\u0010 \u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001d¨\u0006&"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/business/FindSameGoodsStruct;", "Ljava/io/Serializable;", "Lcom/bytedance/android/shopping/anchorv4/dto/business/c;", "", "getFindSameSchemaStr", "getBlockNameStr", "getSceneIdStr", "getSceneProductIdStr", "getRecommendProductIdStr", "", "getPageCursorInt", "()Ljava/lang/Integer;", "getPageCounterInt", "getTypeInt", "findSameSchema", "Ljava/lang/String;", "getFindSameSchema", "()Ljava/lang/String;", "blockName", "getBlockName", "sceneId", "getSceneId", "sceneProductId", "getSceneProductId", "recommendProductId", "getRecommendProductId", "pageCursor", "I", "getPageCursor", "()I", "pageCounter", "getPageCounter", "type", "getType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;III)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FindSameGoodsStruct implements Serializable, c {
    public static final a Companion = null;
    public static final int FIND_SAME = 0;
    public static final int PIC_SEARCH = 1;

    @SerializedName("block_name")
    private final String blockName;

    @SerializedName("find_same_schema")
    private final String findSameSchema;

    @SerializedName("page_counter")
    private final int pageCounter;

    @SerializedName("page_cursor")
    private final int pageCursor;

    @SerializedName("recommend_product_id")
    private final String recommendProductId;

    @SerializedName("scene_id")
    private final String sceneId;

    @SerializedName("scene_product_id")
    private final String sceneProductId;

    @SerializedName("type")
    private final int type;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public FindSameGoodsStruct() {
        this(null, null, null, null, null, 0, 0, 0, 255, null);
    }

    @Override // com.bytedance.android.shopping.anchorv4.dto.business.c
    public String getEnterFromStr() {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.dto.business.c
    public String getImageUriStr() {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.dto.business.c
    public String getProductIdStr() {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.dto.business.c
    public String getProductNameStr() {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.dto.business.c
    public String getSearchChannelStr() {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.dto.business.c
    public String getSearchSourceStr() {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.dto.business.c
    public Integer getShownCountInt() {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.dto.business.c
    public Integer getPageCounterInt() {
        return Integer.valueOf(this.pageCounter);
    }

    @Override // com.bytedance.android.shopping.anchorv4.dto.business.c
    public Integer getPageCursorInt() {
        return Integer.valueOf(this.pageCursor);
    }

    public final String getBlockName() {
        return this.blockName;
    }

    @Override // com.bytedance.android.shopping.anchorv4.dto.business.c
    public String getBlockNameStr() {
        return this.blockName;
    }

    public final String getFindSameSchema() {
        return this.findSameSchema;
    }

    public String getFindSameSchemaStr() {
        return this.findSameSchema;
    }

    public final int getPageCounter() {
        return this.pageCounter;
    }

    public final int getPageCursor() {
        return this.pageCursor;
    }

    public final String getRecommendProductId() {
        return this.recommendProductId;
    }

    @Override // com.bytedance.android.shopping.anchorv4.dto.business.c
    public String getRecommendProductIdStr() {
        return this.recommendProductId;
    }

    public final String getSceneId() {
        return this.sceneId;
    }

    @Override // com.bytedance.android.shopping.anchorv4.dto.business.c
    public String getSceneIdStr() {
        return this.sceneId;
    }

    public final String getSceneProductId() {
        return this.sceneProductId;
    }

    @Override // com.bytedance.android.shopping.anchorv4.dto.business.c
    public String getSceneProductIdStr() {
        return this.sceneProductId;
    }

    public final int getType() {
        return this.type;
    }

    @Override // com.bytedance.android.shopping.anchorv4.dto.business.c
    public int getTypeInt() {
        return this.type;
    }

    public FindSameGoodsStruct(String r100, String r101, String r102, String r103, String r104, int r105, int r106, int r107) {
        this.findSameSchema = r100;
        this.blockName = r101;
        this.sceneId = r102;
        this.sceneProductId = r103;
        this.recommendProductId = r104;
        this.pageCursor = r105;
        this.pageCounter = r106;
        this.type = r107;
    }

    public /* synthetic */ FindSameGoodsStruct(String r110, String r111, String r112, String r113, String r114, int r115, int r116, int r117, int r118, DefaultConstructorMarker r119) {
        String r100 = null;
        if ((r118 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r118 & 16) != 0) goto L22;
        r100 = r114;
    L22:
        int r105 = 0;
        if ((r118 & 32) == 0) goto L25;
        int r106 = 0;
    L27:
        if ((r118 & 64) == 0) goto L29;
        int r107 = 0;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r105 = r117;
    L34:
        this(r101, r102, r103, r104, r100, r106, r107, r105);
        return;
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
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
}
