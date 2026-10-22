package com.alibaba.gaiax.render.node.text;

import com.alibaba.gaiax.context.GXTemplateContext;
import com.alibaba.gaiax.render.node.GXNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/alibaba/gaiax/render/node/text/GXDirtyText;", "", "gxTemplateContext", "Lcom/alibaba/gaiax/context/GXTemplateContext;", "gxNode", "Lcom/alibaba/gaiax/render/node/GXNode;", "templateData", "Lorg/json/JSONObject;", "(Lcom/alibaba/gaiax/context/GXTemplateContext;Lcom/alibaba/gaiax/render/node/GXNode;Lorg/json/JSONObject;)V", "getGxNode", "()Lcom/alibaba/gaiax/render/node/GXNode;", "getGxTemplateContext", "()Lcom/alibaba/gaiax/context/GXTemplateContext;", "getTemplateData", "()Lorg/json/JSONObject;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXDirtyText {
    private final GXNode gxNode;
    private final GXTemplateContext gxTemplateContext;
    private final JSONObject templateData;

    public static /* synthetic */ GXDirtyText copy$default(GXDirtyText r100, GXTemplateContext r101, GXNode r102, JSONObject r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.gxTemplateContext;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.gxNode;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.templateData;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final GXTemplateContext component1() {
        return this.gxTemplateContext;
    }

    public final GXNode component2() {
        return this.gxNode;
    }

    public final JSONObject component3() {
        return this.templateData;
    }

    public final GXDirtyText copy(GXTemplateContext r100, GXNode r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, "gxTemplateContext");
        Intrinsics.checkNotNullParameter(r101, "gxNode");
        Intrinsics.checkNotNullParameter(r102, "templateData");
        return new GXDirtyText(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GXDirtyText) == true) goto L8;
        return false;
    L8:
        GXDirtyText r101 = (GXDirtyText) r100;
        if (Intrinsics.areEqual(this.gxTemplateContext, r101.gxTemplateContext) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.gxNode, r101.gxNode) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.templateData, r101.templateData) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.gxTemplateContext.hashCode() * 31) + this.gxNode.hashCode()) * 31) + this.templateData.hashCode();
    }

    public String toString() {
        return "GXDirtyText(gxTemplateContext=" + this.gxTemplateContext + ", gxNode=" + this.gxNode + ", templateData=" + this.templateData + ')';
    }

    public final GXNode getGxNode() {
        return this.gxNode;
    }

    public final GXTemplateContext getGxTemplateContext() {
        return this.gxTemplateContext;
    }

    public final JSONObject getTemplateData() {
        return this.templateData;
    }

    public GXDirtyText(GXTemplateContext r100, GXNode r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, "gxTemplateContext");
        Intrinsics.checkNotNullParameter(r101, "gxNode");
        Intrinsics.checkNotNullParameter(r102, "templateData");
        this.gxTemplateContext = r100;
        this.gxNode = r101;
        this.templateData = r102;
    }
}
