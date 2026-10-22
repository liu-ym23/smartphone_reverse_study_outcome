package com.alibaba.gaiax.model;

import android.view.View;
import com.alibaba.gaiax.template.GXTemplateItem;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/alibaba/gaiax/model/GXData;", "", "()V", "index", "", "getIndex", "()Ljava/lang/Integer;", "setIndex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "nodeId", "", "getNodeId", "()Ljava/lang/String;", "setNodeId", "(Ljava/lang/String;)V", "templateItem", "Lcom/alibaba/gaiax/template/GXTemplateItem;", "getTemplateItem", "()Lcom/alibaba/gaiax/template/GXTemplateItem;", "setTemplateItem", "(Lcom/alibaba/gaiax/template/GXTemplateItem;)V", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "GaiaXAndroidApi_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class GXData {
    private Integer index;
    private String nodeId;
    private GXTemplateItem templateItem;
    private View view;

    public GXData() {
    }

    public final Integer getIndex() {
        return this.index;
    }

    public final String getNodeId() {
        return this.nodeId;
    }

    public final GXTemplateItem getTemplateItem() {
        return this.templateItem;
    }

    public final View getView() {
        return this.view;
    }

    public final void setIndex(Integer r100) {
        this.index = r100;
    }

    public final void setNodeId(String r100) {
        this.nodeId = r100;
    }

    public final void setTemplateItem(GXTemplateItem r100) {
        this.templateItem = r100;
    }

    public final void setView(View r100) {
        this.view = r100;
    }
}
