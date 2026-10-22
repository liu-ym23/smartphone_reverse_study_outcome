package com.alibaba.gaiax.render.view.basic;

import com.alibaba.gaiax.context.GXTemplateContext;
import com.alibaba.gaiax.render.view.GXIRoundCorner;
import com.alibaba.gaiax.render.view.GXIViewBindData;
import com.alibaba.gaiax.template.GXCss;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¨\u0006\u0014"}, d2 = {"Lcom/alibaba/gaiax/render/view/basic/GXIImageView;", "Lcom/alibaba/gaiax/render/view/GXIViewBindData;", "Lcom/alibaba/gaiax/render/view/GXIRoundCorner;", "onBindData", "", "data", "Lorg/json/JSONObject;", "setImageStyle", "gxTemplateContext", "Lcom/alibaba/gaiax/context/GXTemplateContext;", "gxCss", "Lcom/alibaba/gaiax/template/GXCss;", "setRoundCornerBorder", "borderColor", "", "borderWidth", "", "radius", "", "setRoundCornerRadius", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface GXIImageView extends GXIViewBindData, GXIRoundCorner {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static void setImageStyle(GXIImageView r100, GXTemplateContext r101, GXCss r102) {
            Intrinsics.checkNotNullParameter(r101, "gxTemplateContext");
            Intrinsics.checkNotNullParameter(r102, "gxCss");
        }

        public static void setRoundCornerBorder(GXIImageView r100, int r101, float r102, float[] r103) {
            Intrinsics.checkNotNullParameter(r103, "radius");
        }

        public static void setRoundCornerRadius(GXIImageView r100, float[] r101) {
            Intrinsics.checkNotNullParameter(r101, "radius");
        }
    }

    @Override // com.alibaba.gaiax.render.view.GXIViewBindData
    void onBindData(JSONObject r100);

    void setImageStyle(GXTemplateContext r100, GXCss r101);

    @Override // com.alibaba.gaiax.render.view.GXIRoundCorner
    void setRoundCornerBorder(int r100, float r101, float[] r102);

    @Override // com.alibaba.gaiax.render.view.GXIRoundCorner
    void setRoundCornerRadius(float[] r100);
}
