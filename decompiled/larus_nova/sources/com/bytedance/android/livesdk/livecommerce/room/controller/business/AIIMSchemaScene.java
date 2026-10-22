package com.bytedance.android.livesdk.livecommerce.room.controller.business;

import com.bytedance.android.ec.model.response.ECPromotion;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/controller/business/AIIMSchemaScene;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "AI_IM", "PRODUCT_DETAIL", "ORDER_PAGE", "SKU", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AIIMSchemaScene extends Enum<AIIMSchemaScene> {
    public static final AIIMSchemaScene AI_IM = null;
    public static final a Companion = null;
    public static final AIIMSchemaScene ORDER_PAGE = null;
    public static final AIIMSchemaScene PRODUCT_DETAIL = null;
    public static final AIIMSchemaScene SKU = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AIIMSchemaScene[] f151456a = null;
    private final String value;

    public static final class a {
        public a() {
        }
    }

    static {
        AIIMSchemaScene r100 = new AIIMSchemaScene("AI_IM", 0, "ai_im");
        AI_IM = r100;
        AIIMSchemaScene r101 = new AIIMSchemaScene("PRODUCT_DETAIL", 1, com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL);
        PRODUCT_DETAIL = r101;
        AIIMSchemaScene r102 = new AIIMSchemaScene("ORDER_PAGE", 2, "order_page");
        ORDER_PAGE = r102;
        AIIMSchemaScene r103 = new AIIMSchemaScene("SKU", 3, ECPromotion.SKU);
        SKU = r103;
        f151456a = new AIIMSchemaScene[]{r100, r101, r102, r103};
        Companion = new a();
    }

    public static AIIMSchemaScene valueOf(String r100) {
        return (AIIMSchemaScene) r27.a.a(AIIMSchemaScene.class, r100);
    }

    public static AIIMSchemaScene[] values() {
        return (AIIMSchemaScene[]) f151456a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public AIIMSchemaScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
