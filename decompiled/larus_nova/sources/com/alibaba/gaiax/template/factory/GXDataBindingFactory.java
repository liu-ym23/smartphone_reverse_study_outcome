package com.alibaba.gaiax.template.factory;

import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.api.GXRegisterCenterApi;
import com.alibaba.gaiax.template.GXDataBinding;
import com.alibaba.gaiax.template.GXIExpression;
import com.alibaba.gaiax.template.GXTemplateKey;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0001J\u001c\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0001H\u0002¨\u0006\t"}, d2 = {"Lcom/alibaba/gaiax/template/factory/GXDataBindingFactory;", "", "()V", "create", "Lcom/alibaba/gaiax/template/GXDataBinding;", "expVersion", "", "data", "createDefaultDataBinding", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXDataBindingFactory {
    public static final GXDataBindingFactory INSTANCE = null;

    static {
        INSTANCE = new GXDataBindingFactory();
    }

    private GXDataBindingFactory() {
    }

    private final GXDataBinding createDefaultDataBinding(String r110, Object r111) {
        if ((r111 instanceof JSONObject) == true) goto L5;
        return null;
    L5:
        JSONObject r112 = (JSONObject) r111;
        String r100 = r112.optString("value", null);
        String r101 = r112.optString(GXTemplateKey.GAIAX_PLACEHOLDER, null);
        String r102 = r112.optString(GXTemplateKey.GAIAX_ACCESSIBILITY_DESC, null);
        String r103 = r112.optString(GXTemplateKey.GAIAX_ACCESSIBILITY_ENABLE, null);
        JSONObject r113 = r112.optJSONObject(GXTemplateKey.GAIAX_EXTEND);
        GXExpressionFactory r104 = GXExpressionFactory.INSTANCE;
        GXIExpression r105 = r104.create(r110, r100);
        GXIExpression r114 = r104.create(r110, r101);
        GXIExpression r106 = r104.create(r110, r102);
        GXIExpression r107 = r104.create(r110, r103);
        if (r113 != null) goto L8;
    L20:
        LinkedHashMap r115 = null;
    L21:
        if (r105 != null) goto L27;
        if (r114 != null) goto L27;
        if (r106 != null) goto L27;
        if (r107 != null) goto L27;
        if (r115 != null) goto L27;
        return null;
    L27:
        return new GXDataBinding(r105, r106, r107, r114, r115);
    L8:
        if (r113.length() <= 0) goto L20;
        LinkedHashMap r108 = new LinkedHashMap();
        Iterator<String> r109 = r113.keys();
    L11:
        if (r109.hasNext() == false) goto L19;
        String r116 = r109.next();
        if (r116 == null) goto L11;
        if (r113.opt(r116) == null) goto L11;
        GXIExpression r117 = GXExpressionFactory.INSTANCE.create(r110, r113.opt(r116));
        if (r117 == null) goto L11;
        r108.put(r116, r117);
        goto L11
    L19:
        r115 = r108;
        goto L21
    }

    public final GXDataBinding create(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r101, "data");
        GXRegisterCenterApi.GXIExtensionDataBinding r102 = GXRegisterCenter.Companion.getInstance().getExtensionDataBinding$GaiaX();
        if (r102 == null) goto L8;
        GXDataBinding r103 = r102.create(r100, r101);
        if (r103 == null) goto L8;
        return r103;
    L8:
        return createDefaultDataBinding(r100, r101);
    }
}
