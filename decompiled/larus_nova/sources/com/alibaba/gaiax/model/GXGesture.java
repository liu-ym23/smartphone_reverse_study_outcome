package com.alibaba.gaiax.model;

import android.view.View;
import com.alibaba.gaiax.template.GXTemplateItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010%\u001a\u00020\nH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000eR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lcom/alibaba/gaiax/model/GXGesture;", "", "()V", "eventParams", "Lorg/json/JSONObject;", "getEventParams", "()Lorg/json/JSONObject;", "setEventParams", "(Lorg/json/JSONObject;)V", "gestureType", "", "getGestureType", "()Ljava/lang/String;", "setGestureType", "(Ljava/lang/String;)V", "index", "", "getIndex", "()Ljava/lang/Integer;", "setIndex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "nodeId", "getNodeId", "setNodeId", "templateItem", "Lcom/alibaba/gaiax/template/GXTemplateItem;", "getTemplateItem", "()Lcom/alibaba/gaiax/template/GXTemplateItem;", "setTemplateItem", "(Lcom/alibaba/gaiax/template/GXTemplateItem;)V", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "toString", "GaiaXAndroidApi_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class GXGesture {
    private JSONObject eventParams;
    private String gestureType;
    private Integer index;
    private String nodeId;
    private GXTemplateItem templateItem;
    private View view;

    public String toString() {
        return "GXGesture(gestureType='" + this.gestureType + "', view=" + this.view + ", nodeId=" + this.nodeId + ", index=" + this.index + ", eventParams=" + this.eventParams + ')';
    }

    public GXGesture() {
        this.gestureType = "tap";
    }

    public final JSONObject getEventParams() {
        return this.eventParams;
    }

    public final String getGestureType() {
        return this.gestureType;
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

    public final void setEventParams(JSONObject r100) {
        this.eventParams = r100;
    }

    public final void setGestureType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.gestureType = r100;
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
