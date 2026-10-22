package com.alibaba.gaiax.template.factory;

import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.api.GXRegisterCenterApi;
import com.alibaba.gaiax.template.GXIExpression;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001J\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001J\u0017\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u000bJ!\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001¨\u0006\u000e"}, d2 = {"Lcom/alibaba/gaiax/template/factory/GXExpressionFactory;", "", "()V", "create", "Lcom/alibaba/gaiax/template/GXIExpression;", "expression", "expVersion", "", "isTrue", "", "value", "(Ljava/lang/Object;)Ljava/lang/Boolean;", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Boolean;", "valuePath", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXExpressionFactory {
    public static final GXExpressionFactory INSTANCE = null;

    static {
        INSTANCE = new GXExpressionFactory();
    }

    private GXExpressionFactory() {
    }

    public final GXIExpression create(Object r100) {
        return create(null, r100);
    }

    public final Boolean isTrue(Object r100) {
        return isTrue(null, r100);
    }

    public final String valuePath(Object r100) {
        if ((r100 instanceof String) == false) goto L8;
        String r101 = (String) r100;
        if (StringsKt.startsWith$default(r101, "$", false, 2, null) == false) goto L8;
        return r101.substring(1, r101.length());
    L8:
        return null;
    }

    public final GXIExpression create(String r100, Object r101) {
        if (r101 == null) goto L10;
        GXRegisterCenterApi.GXIExtensionExpression r102 = GXRegisterCenter.Companion.getInstance().getExtensionExpression$GaiaX();
        if (r102 != null) goto L8;
        return null;
    L8:
        return r102.create(r100, r101);
    L10:
        return null;
    }

    public final Boolean isTrue(String r100, Object r101) {
        GXRegisterCenterApi.GXIExtensionExpression r102 = GXRegisterCenter.Companion.getInstance().getExtensionExpression$GaiaX();
        if (r102 != null) goto L7;
        return null;
    L7:
        return Boolean.valueOf(r102.isTrue(r100, r101));
    }
}
