package com.alibaba.gaiax.render.node;

import com.alibaba.gaiax.context.GXTemplateContext;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/alibaba/gaiax/render/node/GXINodeEvent;", "", "addDataBindingEvent", "", "gxTemplateContext", "Lcom/alibaba/gaiax/context/GXTemplateContext;", "gxNode", "Lcom/alibaba/gaiax/render/node/GXNode;", "templateData", "Lorg/json/JSONObject;", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface GXINodeEvent {
    void addDataBindingEvent(GXTemplateContext r100, GXNode r101, JSONObject r102);
}
