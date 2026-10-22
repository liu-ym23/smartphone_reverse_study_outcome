package com.alibaba.gaiax.model;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\nH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/alibaba/gaiax/model/GXAnimation;", "", "()V", "animationParams", "Lorg/json/JSONObject;", "getAnimationParams", "()Lorg/json/JSONObject;", "setAnimationParams", "(Lorg/json/JSONObject;)V", "nodeId", "", "getNodeId", "()Ljava/lang/String;", "setNodeId", "(Ljava/lang/String;)V", "state", "getState", "setState", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "toString", "Companion", "GaiaXAndroidApi_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXAnimation {
    public static final Companion Companion = null;
    public static final String STATE_END = "END";
    public static final String STATE_START = "START";
    private JSONObject animationParams;
    private String nodeId;
    private String state;
    private View view;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/alibaba/gaiax/model/GXAnimation$Companion;", "", "()V", "STATE_END", "", "STATE_START", "GaiaXAndroidApi_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public String toString() {
        return "GXAnimation(type=" + this.state + ", nodeId=" + this.nodeId + ", targetView=" + this.view + ')';
    }

    public GXAnimation() {
    }

    public final JSONObject getAnimationParams() {
        return this.animationParams;
    }

    public final String getNodeId() {
        return this.nodeId;
    }

    public final String getState() {
        return this.state;
    }

    public final View getView() {
        return this.view;
    }

    public final void setAnimationParams(JSONObject r100) {
        this.animationParams = r100;
    }

    public final void setNodeId(String r100) {
        this.nodeId = r100;
    }

    public final void setState(String r100) {
        this.state = r100;
    }

    public final void setView(View r100) {
        this.view = r100;
    }
}
