package com.alibaba.gaiax.template;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0001H&J\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001H&¨\u0006\u0005"}, d2 = {"Lcom/alibaba/gaiax/template/GXIExpression;", "", "expression", "value", "templateData", "GaiaXAndroidApi_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface GXIExpression {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object value$default(GXIExpression r100, Object r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L7;
            r101 = null;
        L7:
            return r100.value(r101);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: value");
        }
    }

    Object expression();

    Object value(Object r100);
}
