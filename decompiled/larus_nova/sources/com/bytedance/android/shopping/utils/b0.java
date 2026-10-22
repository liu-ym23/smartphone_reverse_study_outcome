package com.bytedance.android.shopping.utils;

import com.bytedance.android.ec.model.abscontainer.ISkuBuySchemaModel;
import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.shopping.anchorv4.params.AnchorV4Param;
import com.bytedance.android.shopping.anchorv4.params.V4NativeParams;
import com.bytedance.android.shopping.model.sku.SkuSchemaCategory;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f187052a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f187053b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f187054c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f187055d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f187056e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f187057f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f187058g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f187059h = null;

    static {
        StringBuilder r100 = new StringBuilder();
        SkuSchemaCategory r101 = SkuSchemaCategory.KEY_BIZ_CONTEXT;
        r100.append(r101.getValue());
        r100.append(".scene_type");
        f187052a = r100.toString();
        f187053b = r101.getValue() + ".sku_id";
        StringBuilder r102 = new StringBuilder();
        SkuSchemaCategory r103 = SkuSchemaCategory.KEY_CLIENT_PARAMS;
        r102.append(r103.getValue());
        r102.append(".height_percent");
        f187054c = r102.toString();
        f187055d = r103.getValue() + ".sku_session_id";
        f187056e = r103.getValue() + ".mask_alpha";
        f187057f = r103.getValue() + ".disable_server_specs_default_select";
        f187058g = r103.getValue() + ".default_spec_id";
        f187059h = r103.getValue() + ".default_count";
    }

    public static void a(ISkuBuySchemaModel r100, j73.d r101) {
        Intrinsics.checkNotNullParameter(r101, "anchorV4VM");
        if (r100 == null) goto L44;
        r100.replaceOrAppendParam("sku_session_id", UUID.randomUUID().toString());
        if ((!Intrinsics.areEqual(r100.getQueryParam("scene_type"), "105")) == true) goto L10;
        SkuRestoreState r102 = r101.P();
        if (r102 == null) goto L21;
        if (r102.allSelected() == true) goto L10;
    L21:
        if (r101.P() == null) goto L23;
        boolean r103 = true;
    L24:
        r100.replaceOrAppendParam("disable_server_specs_default_select", String.valueOf(r103));
        if (r101.isExpanded() == true) goto L34;
        AnchorV4Param r104 = r101.c();
        if (r104 == null) goto L33;
        V4NativeParams r105 = r104.getNativeParams();
        if (r105 == null) goto L33;
        if (r105.getFullMode() == true) goto L34;
    L33:
        float r106 = 0.0f;
    L35:
        r100.replaceOrAppendParam("mask_alpha", String.valueOf(r106));
        if (com.bytedance.android.shopping.anchorv4.helper.e.c(r101) == false) goto L39;
        r100.replaceOrAppendParam(ECFindSimilarConfig.HEIGHT_PERCENT, String.valueOf(r101.r()));
    L39:
        if (r101.isExpanded() == false) goto L41;
        String r107 = "full_screen";
    L42:
        r100.putValueInSkuLogData("page_type", r107);
        return;
    L41:
        r107 = "half_screen";
    L34:
        r106 = 0.5f;
        goto L35
    L23:
        r103 = false;
    L10:
        SkuRestoreState r108 = r101.P();
        if (r108 == null) goto L13;
        r100.replaceOrAppendParam("combo_num", String.valueOf(r108.getProductCount()));
    L13:
        SkuRestoreState r109 = r101.P();
        if (r109 == null) goto L21;
        String[] r110 = r109.getSelectSkuKeys();
        if (r110 == null) goto L21;
        String r111 = com.bytedance.android.shopping.extensions.k.x(r110);
        if (r111 == null) goto L21;
        r100.replaceOrAppendParam("default_spec_id", r111);
        goto L21
    }
}
